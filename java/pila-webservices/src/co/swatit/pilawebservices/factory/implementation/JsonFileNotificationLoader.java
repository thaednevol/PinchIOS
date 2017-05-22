package co.swatit.pilawebservices.factory.implementation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import co.swatit.pilautil.constants.NumberConstants;
import co.swatit.pilautil.dto.out.NotificationDetailDTO;
import co.swatit.pilautil.enums.NotificationFilterOperationEnum;
import co.swatit.pilautil.exception.BusinessException;
import co.swatit.pilautil.exception.ErrorMessagesLoader;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;
import co.swatit.pilautil.generics.Constants;
import co.swatit.pilautil.generics.PropertyLoader;
import co.swatit.pilautil.generics.Utilities;
import co.swatit.pilautil.generics.Validation;
import co.swatit.pilautil.request.rest.ParserUtils;
import co.swatit.pilawebservices.interfaces.INotificationLoader;

/**
 * Implementación usada para obtener las notificaciones a través de un archivo que contiene un JSON
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/03/2017
 * @version 1.0
 */
public class JsonFileNotificationLoader implements INotificationLoader {

	/**
	 * Logger de la clase
	 */
	private static final Logger LOGGER = Logger.getLogger(JsonFileNotificationLoader.class);

	/**
	 * Momento en el que se instancia el cargador de notificaciones
	 */
	private Date rightNow;

	@Override
	public List<NotificationDetailDTO> getNotifications(String applicationVersion) throws BusinessException {
		List<NotificationDetailDTO> notificationsToReturn = new ArrayList<NotificationDetailDTO>();
		if (Validation.isVersionNumber(applicationVersion)) {
			String fileContent = PropertyLoader.INSTANCE.loadFileNoCache(Constants.NOTIFICATIONS_FILE);
			List<NotificationDetailDTO> notifications = ParserUtils.INSTANCE.parseJSONArrayToList(fileContent,
					NotificationDetailDTO.class);
			int notificationsSize = notifications.size();

			rightNow = new Date();
			for (int i = 0; i < notificationsSize; i++) {
				NotificationDetailDTO notification = notifications.get(i);
				if (filterNotification(notification.getVersion(), applicationVersion, notification.getOperVersion(),
						notification.getMaxDate())) {
					notificationsToReturn.add(notification);
				}
			}
		} else {
			throw new BusinessException(CodeErrorEnum.ERRORCLIENTVERSIONNUMBER, applicationVersion,
					Constants.APPLICATION_VERSION_EXAMPLE);
		}
		return notificationsToReturn;
	}

	/**
	 * 
	 * Método que obtiene la versión de la aplicación y la convierte en un número
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 13/03/2017
	 *
	 * @param version
	 *            , versión de la aplicación a convertir
	 * @return Double con la conversion de la version ingresada
	 */
	private Double getVersion(final String version, final NotificationFilterOperationEnum operation) {
		if (Validation.isNotNull(version) && Validation.isVersionNumber(version)) {
			String[] versionSplit = version.split("\\.");
			Integer versionSplitLength = versionSplit.length;
			if (versionSplitLength > NumberConstants.ZERO) {
				StringBuilder sbVersion = new StringBuilder(versionSplit[NumberConstants.ZERO]);
				sbVersion.append(Constants.POINT);
				for (int i = 1; i < versionSplitLength; i++) {
					sbVersion.append(versionSplit[i]);
				}
				return Double.valueOf(sbVersion.toString());
			}
		}
		LOGGER.error(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.ERRORVERSIONNUMBER.getDescription(),
				version, operation.name(), Constants.APPLICATION_VERSION_EXAMPLE));
		return null;
	}

	/**
	 * Método que realiza el filtrado de una notificación según la versión de la aplicación
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 13/03/2017
	 *
	 * @param filteredVersion
	 *            , versión de la aplicación sobre la que se va a filtrar
	 * @param applicationVersion
	 *            , versión de la aplicación del cliente
	 * @param operation
	 *            , operación sobre la versión
	 * @param date
	 *            , fecha máxima en la que debe aparecer la notificación
	 * @return true si la versión de la aplicación pasa el filtro de la notificación, false en los siguientes casos:
	 *         <ul>
	 *         <li>no pasa el filtro de la notificación</li>
	 *         <li>existe un error con el formato del parámetro filteredVersion</li>
	 *         <li>la operación a realizar sobre las versiones a filtrar no es encontrada</li>
	 *         </ul>
	 */
	private boolean filterNotification(String filteredVersion, String applicationVersion, String operation, String date) {
		boolean retorno;
		try {
			NotificationFilterOperationEnum operationValue = NotificationFilterOperationEnum.valueOf(operation);
			Double appVersion = getVersion(applicationVersion, operationValue);
			if (Validation.isNull(appVersion)) {
				return false;
			}
			retorno = filterNotificationsByDate(date);
			if (retorno) {
				switch (operationValue) {
				case EQUALS:
					retorno = appVersion.equals(getVersion(filteredVersion, operationValue));
					break;
				case LESSTHANOREQUAL:
					retorno = appVersion <= getVersion(filteredVersion, operationValue);
					break;
				case GREATERTHANOREQUAL:
					retorno = appVersion >= getVersion(filteredVersion, operationValue);
					break;
				case RANGE:
					retorno = filterVersionUsingRange(filteredVersion, applicationVersion);
					break;
				default:
					LOGGER.error(ErrorMessagesLoader.INSTANCE.getErrorMensage(
							CodeErrorEnum.ERROROPERATIONNOTFOUND.getDescription(), operation));
					retorno = false;
					break;
				}
			}
		} catch (ParseException e) {
			LOGGER.error(ErrorMessagesLoader.INSTANCE.getErrorMensage(
					CodeErrorEnum.ERRORINCORRECTDATE.getDescription(), date, Constants.NOTIFICATION_DATE_FORMAT), e);
			retorno = false;
		} catch (NullPointerException e) {
			LOGGER.error(ErrorMessagesLoader.INSTANCE.getErrorMensage(
					CodeErrorEnum.ERROROPERATIONNOTFOUND.getDescription(), operation), e);
			retorno = false;
		}
		return retorno;
	}

	/**
	 * Método que realiza el filtrado de las versiones de una notificación según un rango establecido
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 13/03/2017
	 *
	 * @param filteredVersion
	 *            , rango de versiones sobre las que se debe filtrar (separadas por "-")
	 * @param applicationVersion
	 *            , version de la aplicación del cliente
	 * @return true, si la versión de la aplicación del cliente cumple con el criterio de filtrado, false si
	 */
	private boolean filterVersionUsingRange(String filteredVersion, String applicationVersion) {
		boolean retorno;
		String[] versions = filteredVersion.split("-");
		if (versions.length == NumberConstants.TWO) {
			Double appVersion = getVersion(applicationVersion, NotificationFilterOperationEnum.RANGE);
			retorno = appVersion >= getVersion(versions[NumberConstants.ZERO], NotificationFilterOperationEnum.RANGE)
					&& appVersion <= getVersion(versions[NumberConstants.ONE], NotificationFilterOperationEnum.RANGE);
		} else {
			LOGGER.error(ErrorMessagesLoader.INSTANCE.getErrorMensage(
					CodeErrorEnum.ERRORVERSIONNUMBER.getDescription(), filteredVersion,
					NotificationFilterOperationEnum.RANGE.name(), Constants.APPLICATION_RANGE_FILTER_EXAMPLE));
			retorno = false;
		}
		return retorno;
	}

	/**
	 * Método que realiza el filtrado de una notificación según la fecha de esta
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/03/2017
	 *
	 * @param date
	 *            , fecha sobre la que se realiza el filtro
	 * @return true si la fecha actual es anterior a la fecha ingresada o si es nula o vacía, false si no puede ser
	 *         parseada correctamente o la fecha actual no es anterior a la ingresada
	 * @throws ParseException
	 *             , si la fecha ingresada es incorrecta, no tiene el formato adecuado o no es posible convertirla
	 */
	private boolean filterNotificationsByDate(String date) throws ParseException {
		if (Validation.isNullOrEmpty(date)) {
			return true;
		}
		Date dateToCheck = Utilities.parseStringToDate(date, Constants.NOTIFICATION_DATE_FORMAT);
		return rightNow.before(dateToCheck);
	}
}

package co.swatit.pilautil.generics;

import java.io.Closeable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.IncorrectUpdateSemanticsDataAccessException;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.dao.TypeMismatchDataAccessException;
import org.springframework.jdbc.UncategorizedSQLException;

import co.swatit.pilautil.constants.NumberConstants;
import co.swatit.pilautil.dto.ResponseDTO;
import co.swatit.pilautil.exception.BusinessException;
import co.swatit.pilautil.exception.ErrorMessagesLoader;
import co.swatit.pilautil.exception.GenericException;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;

/**
 * Clase de utilidades generales.
 * 
 * @author Swat-It <br>
 *         Jessica Antía Hortúa <br>
 *         Email: jantia@swat-it.co<br>
 * @date 25/10/2016
 * @version 1.0
 * 
 */
public final class Utilities {

	/**
	 * Referencia el Log del sistema
	 */
	private static final Logger LOGGER = Logger.getLogger(Utilities.class.getName());

	/**
	 * Nombre del contexto de la aplicación.
	 */
	public static String contextName = "";

	/**
	 * Constructor.
	 */
	private Utilities() {
	}

	/**
	 * Valida y cierra un flujo de lectura de archivo.
	 * 
	 * @param closeable
	 *            , con el objeto del cual se desea cerrar el flujo de lectura.
	 */
	public static void closeStream(final Closeable closeable) {
		try {
			if (Validation.isNotNull(closeable)) {
				closeable.close();
			}
		} catch (Exception ex) {
			LOGGER.error(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.EXCEPTION.getDescription()), ex);
		}
	}

	/**
	 * Metodo que retorna la fecha actual en el formato yyy-MM-dd HH:mm:ss
	 * 
	 * @return String con la fecha actual.
	 */
	public static String getCurrentDate() {
		Date fechaActual = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT_SERVICES);
		return sdf.format(fechaActual);
	}

	/**
	 * 
	 * Método que convierte un objeto calendar a String usando el formato yyyyMMdd
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param calendar
	 *            , Calendar a ser convertido
	 * @return {@link String}, con la fecha convertida
	 * @throws BusinessException
	 *             , cuando la fecha no tiene el formato correcto
	 */
	public static String convertCalendarToString(Calendar calendar) throws BusinessException {
		if (calendar != null) {
			return parseDateToStringBusiness(calendar.getTime(), Constants.DATE_PATTERN_YYYYMMDD);
		}
		return null;
	}

	/**
	 * Método que retorna la cantidad de días de diferencia entre dos fechas.
	 * 
	 * @param startDate
	 *            , fecha inicial.
	 * @param endDate
	 *            , fecha final.
	 * @return Long con el número de dias de diferencia entre las fechas recibidas por parámetro.
	 * @throws BusinessException
	 *             , en caso de que alguna de las fechas no tenga el formato correcto.
	 */
	public static long getDaysDifferenceBetweenDates(String startDate, String endDate) throws BusinessException {
		Date sdate = null;
		Date edate = null;

		SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT_SERVICES);

		try {
			sdate = sdf.parse(startDate);
			edate = sdf.parse(endDate);
		} catch (ParseException e) {
			throw new BusinessException(CodeErrorEnum.ERRORINCORRECTDATE.getCode(),
					CodeErrorEnum.ERRORINCORRECTDATE.getDescription(), new StringBuilder().append(startDate)
							.append(Constants.SPACE).append(endDate).toString(), Constants.DATE_FORMAT_SERVICES);
		}

		Calendar cinicio = Calendar.getInstance();
		Calendar cfinal = Calendar.getInstance();
		cinicio.setTime(sdate);
		cfinal.setTime(edate);

		long diferenciaMilisegundos = cfinal.getTimeInMillis() - cinicio.getTimeInMillis();

		return Math
				.abs(diferenciaMilisegundos
						/ (NumberConstants.TWENTY_FOUR * NumberConstants.SIXTY * NumberConstants.SIXTY * NumberConstants.ONE_THOUSAND));
	}

	/**
	 * 
	 * Método que obtiene la configuración para log4j a partir de la ruta de un archivo de propiedades
	 * 
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 6/03/2017
	 *
	 * @param log4jPropertiesFilePath
	 *            , ruta donde se encuentra el archivo de propiedades
	 */
	public static void getLog4jConfig(String log4jPropertiesFilePath) {
		try {
			PropertyConfigurator.configure(log4jPropertiesFilePath);
		} catch (Exception ex) {
			BasicConfigurator.configure();
		}
	}

	/**
	 * Método que retorna la fecha actual en el formato recibido
	 *
	 * @author SWAT-IT<br>
	 *         Andrés Julián Franco Pulgarín<br>
	 *         Email: afranco@swat-it.co<br>
	 * 
	 * @date 12/09/2016
	 * @version 1.0
	 * @sprint 1
	 * 
	 * @param format
	 *            , formato de fecha.
	 *
	 * @return String fecha actual.
	 */
	public static String getCurrentDateFormat(String format) {
		Date fechaActual = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format, new Locale(Constants.LOCALE_LANGUAGE));
		return sdf.format(fechaActual);
	}

	/**
	 * Metodo retorna un cadena de texto que representa a una fecha en un formato dado
	 *
	 * @author SWAT-IT<br>
	 *         Andrés Julián Franco Pulgarín<br>
	 *         Email: afranco@swat-it.co<br>
	 * 
	 * @date 21/09/2016
	 * @version 1.0
	 * @sprint 1
	 *
	 * @param date
	 *            fecha sobre la cual se obtiene la cadena de texto que la representa
	 * @param format
	 *            formato al que se desea parsear la fecha
	 *
	 * @return String, fecha convertida
	 *
	 * @throws BusinessException
	 *             , exepción generada
	 */
	public static String parseDateToStringBusiness(Date date, String format) throws BusinessException {
		if (Validation.isNull(date)) {
			return Constants.EMPTY;
		}

		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} catch (IllegalArgumentException e) {
			throw new BusinessException(e, CodeErrorEnum.ERRORINCORRECTDATE, date.toString(),
					Constants.DATE_FORMAT_SERVICES);
		}
	}

	/**
	 * Método que retorna la fecha cadena en un objeto Date de acuerdo al formato dado.
	 *
	 * @author SWAT-IT<br>
	 *         Diego Mauricio Badillo Bedoya<br>
	 *         Email: dbadillo@swat-it.co<br>
	 * 
	 * @date 30/11/2016
	 * @version 1.0
	 * @sprint 2
	 * 
	 * @param date
	 *            fecha en formato de cadena.
	 * @param format
	 *            formato de fecha.
	 *
	 * @return Date objeto con la fecha dada.
	 * @throws ParseException
	 *             error en conversión de la fecha al formato dado.
	 */
	public static Date parseStringToDate(String date, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format, new Locale(Constants.LOCALE_LANGUAGE));
		sdf.setLenient(Boolean.FALSE);
		return sdf.parse(date);
	}

	/**
	 * Método encargado de convertir una cadena a un bigdecimal teniendo en cuenta los ultimos caracteres de la cadena
	 * como decimales.
	 * 
	 * @author Swat-It <br>
	 *         Diego Mauricio Badillo Bedoya <br>
	 *         Email: dbadillo@swat-it.co<br
	 * @date 2/12/2016
	 * @version 1.0
	 * @sprint 2
	 * @issue HU-Carga y validación de registros en el archivo
	 *
	 * @param value
	 *            valor a convertir.
	 * @param fixedDecimals
	 *            cantidad de decimales a tomar.
	 * @return {@link BigDecimal} valor convertido.
	 * @throws NumberFormatException
	 *             error al convertir el número a BigDecimal.
	 */
	public static BigDecimal convertStringToBigDecimal(String value, int fixedDecimals) {
		StringBuilder realValue = new StringBuilder();
		realValue.append(value.substring(0, value.length() - fixedDecimals));
		realValue.append(Constants.POINT);
		realValue.append(value.substring(value.length() - fixedDecimals, value.length()));

		return new BigDecimal(realValue.toString());
	}

	/**
	 * Método encargado de obtener el CodeError de una excepción generica.
	 * 
	 * @param e
	 *            , con la excepción generada.
	 * @param codeDefault
	 *            , con el codigo por defecto si no se identifica la excepción.
	 * @return {@link CodeErrorEnum}, con el enum correspondiente al tipo de excepción.
	 */
	public static CodeErrorEnum getCodeErrorException(Exception e, CodeErrorEnum codeDefault) {
		CodeErrorEnum codeErrorEnum;
		if (e instanceof DataIntegrityViolationException) {
			codeErrorEnum = CodeErrorEnum.ERRORDATAINTEGRITYVIOLATION;
		} else if (e instanceof UncategorizedSQLException) {
			codeErrorEnum = CodeErrorEnum.ERRORUNCATEGORIZEDEX;
		} else if (e instanceof TypeMismatchDataAccessException) {
			codeErrorEnum = CodeErrorEnum.ERRORTYPEMISMATCHEX;
		} else if (e instanceof IncorrectUpdateSemanticsDataAccessException) {
			codeErrorEnum = CodeErrorEnum.ERRORINCORRECTUPDATESEMANTICS;
		} else if (e instanceof PermissionDeniedDataAccessException) {
			codeErrorEnum = CodeErrorEnum.ERRORPERMISSIONDENIED;
		} else if (e instanceof DataAccessResourceFailureException) {
			codeErrorEnum = CodeErrorEnum.BDCONNEXCEPTION;
		} else {
			codeErrorEnum = codeDefault;
		}
		return codeErrorEnum;
	}

	/**
	 * Método encargado de entregar una representación del objeto en forma de String. Retorna cadena vacía en caso de
	 * que el objeto sea null.
	 * 
	 * @author Swat-It <br>
	 *         Diego Mauricio Badillo Bedoya <br>
	 *         Email: dbadillo@swat-it.co<br
	 * @date 20/12/2016
	 * @version 1.0
	 * @sprint 2
	 * @issue HU-Procesamiento de consignaciones
	 *
	 * @param obj
	 *            objeto a convertir a cadena.
	 * @return representación del objeto en forma de cadena.
	 */
	public static String nvlObjectToString(Object obj) {
		if (Validation.isNullOrEmpty(obj)) {
			return Constants.EMPTY;
		} else {
			return obj.toString();
		}
	}

	/**
	 * Genera una respuesta.
	 *
	 * @param responseDto
	 *            , Objeto de respuesta, si el null, se crea uno.
	 * @param msgConstant
	 *            , enum que define el tipo de mensaje.
	 * @param exception
	 *            , excepción por medio de la cual se quiere construir la respuesta.
	 * @return {@link <T extends ResponseDTO>}, responseDTO.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends ResponseDTO> T buildResponse(ResponseDTO responseDto, final CodeErrorEnum msgConstant,
			final Exception exception) {
		ResponseDTO responseBuild;
		if (responseDto == null) {
			responseBuild = new ResponseDTO();
		} else {
			responseBuild = responseDto;
		}

		if (exception instanceof GenericException) {
			responseBuild.setCode(((GenericException) exception).getErrorDTO().getCode());
			responseBuild.setMessage(((GenericException) exception).getErrorDTO().getDescription());
		} else {
			responseBuild.setCode(msgConstant.getCode());
			responseBuild.setMessage(ErrorMessagesLoader.INSTANCE.getErrorMensage(msgConstant.getDescription()));
		}
		return (T) responseBuild;
	}

	/**
	 * 
	 * Método que obtiene el name() de un enum
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 21/02/2017
	 *
	 * @param enumValue
	 *            , valor del enum a extraer
	 * @return String, con el nombre del enum, null si el parámetro es vacío
	 */
	public static <E extends Enum<E>> String getEnumName(final E enumValue) {
		if (Validation.isNotNull(enumValue)) {
			return enumValue.name();
		}
		return null;
	}
}

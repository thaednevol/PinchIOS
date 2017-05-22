package co.swatit.pilawebservices.factory;

import co.swatit.pilautil.enums.NotificationLoaderImpEnum;
import co.swatit.pilautil.exception.BusinessException;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;
import co.swatit.pilawebservices.factory.implementation.JsonFileNotificationLoader;
import co.swatit.pilawebservices.interfaces.INotificationLoader;

/**
 * Fábrica usada para realizar la obtención de notificaciones
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/03/2017
 * @version 1.0
 */
public final class NotificationFactory {

	/**
	 * Constructor vacío
	 */
	private NotificationFactory() {

	}

	/**
	 * Método que crea una instancia de la implementación de obtención de notificaciones para un cliente
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 13/03/2017
	 *
	 * @param notificationSource
	 *            , nombre de la implementación a usar
	 * @return {@link INotificationLoader} con la implementación obtenida
	 * @throws BusinessException
	 *             , en caso que no sea posible obtener la implementación requerida
	 */
	public static INotificationLoader createImplementation(String notificationSource) throws BusinessException {
		NotificationLoaderImpEnum implementation = NotificationLoaderImpEnum.getImplementation(notificationSource);
		return getImplementation(implementation);
	}

	/**
	 * 
	 * Método que obtiene la implementación para obtener las notificaciones según sea necesario
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 13/03/2017
	 *
	 * @param loader
	 *            , enum que contiene el nombre de la clase que realiza la implementación
	 * @return {@link INotificationLoader} implementación obtenida
	 * @throws BusinessException
	 *             , en caso que no sea posible obtener la implementación
	 */
	private static INotificationLoader getImplementation(NotificationLoaderImpEnum implementationClass)
			throws BusinessException {
		INotificationLoader iNotificationLoader;
		switch (implementationClass) {
		case FILE:
			iNotificationLoader = new JsonFileNotificationLoader();
			break;
		default:
			throw new BusinessException(CodeErrorEnum.ERRORFACTORY);
		}
		return iNotificationLoader;
	}
}

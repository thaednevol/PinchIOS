/**
 * 
 */
package co.swatit.pilautil.enums;

/**
 * Enum que contiene las implementaciones de la carga de notificaciones
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/03/2017
 * @version 1.0
 */
public enum NotificationLoaderImpEnum {
	/** Implementación a través de la cual se obtienen las notificaciones desde un archivo */
	FILE("co.swatit.pilawebservices.factory.implementation.JsonFileNotificationLoader");

	/**
	 * Nombre de la clase que realiza la implementación
	 */
	public final String className;

	/**
	 * Constructor del Enum
	 * 
	 * @param className
	 *            , nombre de la clase de la implementación a asignar
	 */
	NotificationLoaderImpEnum(String className) {
		this.className = className;
	}

	/**
	 * Método que obtiene un enum según el nombre ingresado
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 13/03/2017
	 *
	 * @param implementationName
	 *            , nombre a encontrar dentro de los valores del enum
	 * @return enum encontrado según el nombre ingresado, null si no nada fué encontrado
	 */
	public static NotificationLoaderImpEnum getImplementation(final String implementationName) {
		for (NotificationLoaderImpEnum value : values()) {
			if (implementationName.equals(value.name())) {
				return value;
			}
		}
		return null;
	}

	/**
	 * Método getter del atributo className de la clase NotificationLoaderImpEnum
	 *
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

}

package co.swatit.pilabusiness.utils.enums;

/**
 * Enum que contiene los nombres de los servicios
 * 
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 20/02/2017
 * @version 1.0
 */
public enum ServiceNameEnum {

	/** Servicio de logueo */
	LOGIN("login"),
	/** Servicio que obtiene la configuración de un archivo de validación */
	GETVALIDATIONFILECONFIG("getValidationFileConfig"),
	/** Servicio que realiza la validación de un token */
	VALIDATETOKEN("validateToken"),
	/** Servicio que obtiene las últimas planillas pagadas */
	GETFILTEREDPAYROLLS("getFilteredPayrolls"),
	/** Servicio que obtiene las notificaciones según la versión de la aplicación del usuario */
	GETNOTIFICATIONS("getNotifications"),
	/** Servicio que obtiene los datos de la cabecera de una planilla */
	GETPAYROLLHEADER("getPayrollHeader"),
	/** Servicio que obtiene los aportantes de una planilla */
	GETPAYROLLCONTRIBUTORS("getPayrollContributors"),
	/** Servicio que obtiene la información de un listado de ids de aportantes */
	GETCONTRIBUTORSINFORMATION("getContributorsInformation"),
	CREATEPAYROLL("createPayroll");

	/**
	 * Nombre del servicio
	 */
	private final String nombreServicio;

	/**
	 * Método que define el nombre del servicio
	 * 
	 * @param nombreServicio
	 *            , nombre del servicio
	 */
	ServiceNameEnum(final String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	/**
	 * Método que busca un enum según el nombre de servicio ingresado
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/02/2017
	 *
	 * @param nombreServicio
	 * @return {@link ServiceNameEnum}, null si no encontró ningún servicio con el nombre ingresado, en caso contrario
	 *         el enum hallado
	 */
	public static ServiceNameEnum getService(final String nombreServicio) {
		for (ServiceNameEnum enumeration : values()) {
			if (nombreServicio.equalsIgnoreCase(enumeration.getNombreServicio())) {
				return enumeration;
			}
		}
		return null;
	}

	/**
	 * Método getter del atributo nombreServicio de la clase ServiceNameEnum
	 *
	 * @return the nombreServicio
	 */
	public String getNombreServicio() {
		return nombreServicio;
	}

}

package co.swatit.pilautil.constants;

/**
 * Clase que contiene los nombres de los servicios expuestos en el proyecto.
 * 
 * @author Swat-It <br>
 *         Jessica Antía Hortúa <br>
 *         Email: jantia@swat-it.co<br>
 * @date 25/10/2016
 * @version 1.0
 * 
 */
public final class ServicesConstants {

	/**
	 * Nombre del servicio de logueo
	 */
	public static final String WS_LOGIN = "login";

	/**
	 * Nombre del servicio que obtiene la configuración de la aplicación
	 */
	public static final String WS_GET_VALIDATION_FILE_CONFIG = "getValidationFileConfig";

	/**
	 * Nombre del servicio que realiza la validación de un token
	 */
	public static final String WS_VALIDATE_TOKEN = "validateToken";

	/**
	 * Nombre del servicio que obtiene las últimas planillas de un usuario
	 */
	public static final String WS_GET_FILTERED_PAYROLLS = "getFilteredPayrolls";

	/**
	 * Nombre del servicio que obtiene las notificaciones según la versión de la app del usuario
	 */
	public static final String WS_GET_NOTIFICATIONS = "getNotifications";

	/**
	 * Nombre del servicio que obtiene la información de la planilla según su numero
	 */
	public static final String WS_GET_PAYROLL_HEADER = "getPayrollHeader";

	/**
	 * Nombre del servicio que obtiene los aportantes de una planilla
	 */
	public static final String WS_GET_PAYROLL_CONTRIBUTORS = "getPayrollContributors";
	
	
	/**
	 * Nombre del servicio que obtiene la información de un listado de aportantes
	 */
	public static final String WS_GET_CONTIBUTORS_INFORMATION = "getContributorsInformation";
	
	/**
	 * Nombre del servicio que valida la planilla que se va a cargar por archivo.
	 */
	public static final String WS_VALIDATE_FILE = "validateFile";
	
	/**
	 * Nombre del servicio que consulta el archivo que se va a cargar por archivo.
	 */
	public static final String WS_CONSULT_FILE = "consultFile/{idFile}";
	
	
	/**
	 * Nombre del servicio que consulta la planilla que se va a cargar por archivo.
	 */
	public static final String WS_CONSULT_PAYROLL = "consultPayroll/{idPayroll}";
	
	/**
	 * Nombre del servicio que guarda una planilla.
	 */
	public static final String WS_PUT_PAYROLL = "putPayroll";
	
	/**
	 * Nombre del servicio que guarda una planilla.
	 */
	public static final String WS_CREATE_PAYROLL = "createPayroll";

	/**
	 * Método constructor privado por defecto.
	 */
	private ServicesConstants() {

	}
}

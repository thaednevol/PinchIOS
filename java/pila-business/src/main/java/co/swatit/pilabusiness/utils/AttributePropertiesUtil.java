package co.swatit.pilabusiness.utils;

import co.swatit.pilautil.generics.PropertyLoader;

/**
 * Clase que contiene todos los atributos paramétricos para el proyecto pila-business
 * 
 * @author SWAT-IT <br>
 *         Cristian Camilo Londoño <br>
 *         Email: clondono@swat-it.co <br>
 * @date 20/01/2017
 * @sprint 1.0
 */
public final class AttributePropertiesUtil {

	/** Constante que contiene la URL de los servicios web del servidor weblogic */
	public static final String PILA_WS_URL = PropertyLoader.INSTANCE.getPropertyInternal(
			Constants.PILA_BUSINESS_PROPERTIES, "PILA_WS_URL");

	/** Constante que contiene el path del servicio de login */
	public static final String LOGIN_PATH = PropertyLoader.INSTANCE.getPropertyInternal(
			Constants.PILA_BUSINESS_PROPERTIES, "LOGIN_PATH");

	/** Constante que contiene el nombre del servicio que obtiene la configuración de un archivo */
	public static final String GET_VALIDATION_FILE_CONFIG_PATH = PropertyLoader.INSTANCE.getPropertyInternal(
			Constants.PILA_BUSINESS_PROPERTIES, "GET_VALIDATION_FILE_CONFIG");

	/** Constante que contiene el path del servicio de validación de tokens */
	public static final String VALIDATE_TOKEN = PropertyLoader.INSTANCE.getPropertyInternal(
			Constants.PILA_BUSINESS_PROPERTIES, "VALIDATE_TOKEN");

	/** Constante que contiene el path del servicio que obtiene las últimas planillas de un usuario */
	public static final String GET_FILTERED_PAYROLLS = PropertyLoader.INSTANCE.getPropertyInternal(
			Constants.PILA_BUSINESS_PROPERTIES, "GET_FILTERED_PAYROLLS");

	/** Constante que contiene el path del servicio que obtiene las notificaciones de la aplicación del usuario */
	public static final String GET_NOTIFICATIONS = PropertyLoader.INSTANCE.getPropertyInternal(
			Constants.PILA_BUSINESS_PROPERTIES, "GET_NOTIFICATIONS");

	/** Constante que contiene el path del servicio que obtiene los datos de la cabecera de una planilla */
	public static final String GET_PAYROLL_HEADER = PropertyLoader.INSTANCE.getPropertyInternal(
			Constants.PILA_BUSINESS_PROPERTIES, "GET_PAYROLL_HEADER");

	/** Constante que contiene el path del servicio que obtiene los aportantes de una planilla */
	public static final String GET_PAYROLL_CONTRIBUTORS = PropertyLoader.INSTANCE.getPropertyInternal(
			Constants.PILA_BUSINESS_PROPERTIES, "GET_PAYROLL_CONTRIBUTORS");
	
	public static final String GET_CONTRIBUTORS_INFORMATION = PropertyLoader.INSTANCE.getPropertyInternal(
			Constants.PILA_BUSINESS_PROPERTIES, "GET_CONTRIBUTORS_INFORMATION");

	public static final String VALIDATE_FILE = PropertyLoader.INSTANCE.getPropertyInternal(
			Constants.PILA_BUSINESS_PROPERTIES, "VALIDATE_FILE");
	
	public static final String CONSULT_FILE = PropertyLoader.INSTANCE.getPropertyInternal(
			Constants.PILA_BUSINESS_PROPERTIES, "CONSULT_FILE");
	
	public static final String CONSULT_PAYROLL = PropertyLoader.INSTANCE.getPropertyInternal(
			Constants.PILA_BUSINESS_PROPERTIES, "CONSULT_PAYROLL");
	
	public static final String PUT_PAYROLL = PropertyLoader.INSTANCE.getPropertyInternal(
			Constants.PILA_BUSINESS_PROPERTIES, "PUT_PAYROLL");
	
	public static final String CREATE_PAYROLL = PropertyLoader.INSTANCE.getPropertyInternal(
			Constants.PILA_BUSINESS_PROPERTIES, "CREATE_PAYROLL");

	/** Constante que contiene el tamaño máximo de los archivos de log */
	public static final String MAX_FILE_SIZE = PropertyLoader.INSTANCE.getPropertyInternal(
			Constants.PILA_BUSINESS_PROPERTIES, "MAX_FILE_SIZE");

	/** Constante que contiene el número máximo de archivos de log backup */
	public static final Integer MAX_BACKUP_INDEX = Integer.valueOf(PropertyLoader.INSTANCE.getPropertyInternal(
			Constants.PILA_BUSINESS_PROPERTIES, "MAX_BACKUP_INDEX"));

	/**
	 * Método constructor privado por defecto.
	 */
	private AttributePropertiesUtil() {

	}
}
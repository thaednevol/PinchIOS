package co.swatit.pilautil.generics;

/**
 * Clase que contiene las constantes utilizadas en el proyecto SOI.
 * 
 * @author Swat-It <br>
 *         Jessica Antía Hortúa <br>
 *         Email: jantia@swat-it.co<br>
 * @date 25/10/2016
 * @version 1.0
 * 
 */
public final class Constants {

	/** Constante para la ruta del archivo properties permissions.properties */
	public static final String PERMISSIONS_PROPERTIES = Utilities.contextName + "/resources/permissions.properties";

	/** Constante que contiene el nombre del archivo log4j.properties */
	public static final String LOG4J_PROPERTIES = "/resources/log4j.properties";

	/** Constante para la ruta del archivo properties system.properties */
	public static final String GLOBAL_PROP = Utilities.contextName + "/resources/system.properties";

	/** Constante que contiene la ruta del archivo de configuración para la validación de la planilla */
	public static final String ARCHIVO_2388_XML = Utilities.contextName + "/resources/archivo2388-config.xml";
	
	/** Constante que contiene el nombre del archivo de notificaciones */
	public static final String NOTIFICATIONS_FILE = Utilities.contextName +"/resources/notifications.json";

	/** Cadena vacia */
	public static final String EMPTY = "";

	/** Caracter espacio */
	public static final String SPACE = " ";

	/** Caracter dos puntos */
	public static final String COLON = ":";

	/** Caracter para una nueva linea */
	public static final String NEWLINE = " \n";

	/** Caracter coma */
	public static final String COMMA = ",";

	/** Caracter slash */
	public static final String SLASH = "/";

	/** Caracter guion */
	public static final String DASH = "-";

	/** Signo de interrogacion */
	public static final String QUESTION_MARK = "?";

	/** Identificador Motor DB Mysql */
	public static final String MYSQL_ENGINE = "MySQL";

	/** Constante para la ruta del archivo mysql.queries.xml */
	public static final String MYSQLQ_XML = "/resources/mysql.queries.xml";

	/** Constante que contiene la declaración del protocolo HTTP para construir una URL */
	public static final String HTTP_PROTOCOL_URL_DECLARATION = "http://";

	/** Propiedad estándar para configuración de conexiones jndi en el archivo de propiedades */
	public static final String JNDI_PROPERTIES_LIST = "JNDI_PROPERTIES_LIST";

	/** Constante utilizada para efectos del log */
	public static final String LOG_WS_INVOKED = ":::SERVICIO INVOCADO:::";

	/** Constante utilizada para efectos del log */
	public static final String LOG_PARAMETERS = " - CON LOS PARAMETROS: ";

	/** Constante utilizada para efectos del log */
	public static final String LOG_WS_INVOCATION = ":::INVOCANDO SERVICIO:::";

	/** Constante utilizada para efectos del log */
	public static final String LOG_EXCEPTION = ":::EXCEPCION:::";

	/** Constante utilizada para efectos del log */
	public static final String LOG_CLASS_METHOD_NAME = ":::CLASE y MÉTODO INVOCADO:::";

	/** Constante utilizada para imprimir la salida de un método. */
	public static final String LOG_CLASS_METHOD_EXIT = ":::FIN CLASE y MÉTODO:::";

	/** Constante utilizada para efectos del log */
	public static final String LOG_CLASS_ERROR_MESSAGE = ":::SE GENERÓ ERROR CON LA SIGUIENTE DESCRIPCIÓN:::";

	/** Constante utilizada para imprimir la salida WARN de un parámetro vacío */
	public static final String LOG_NULL_PARAMETER = "El siguiente parámetro es nulo :";

	/** Constante que almacena el prefijo de los metodos get */
	public static final String GET_PREFIX = "get";

	/** Constante que almacena el formato de fecha: yyyyMMdd */
	public static final String DATE_PATTERN_YYYYMMDD = "yyyyMMdd";

	/** Constante con el pattern para reemplazar ceros en una cadena */
	public static final String REPLACE_ZEROS_PATTERN = "^0*";

	/** Constante para identificar el tipo de origen WS de una consignación */
	public static final String CONSIGNMENT_ORIGIN_WS = "WS";

	/** Constante para identificar el tipo de consignación automática */
	public static final String CONSIGNMENT_TYPE_AUTOMATIC = "Automática";

	/** Constante para identificar el tipo de moneda COP */
	public static final String CURRENCY_TYPE_COP = "COP";

	/** Constante para el código de éxito en los procesos de consignaciones */
	public static final String CONSIGNMENT_CODE_SUCCESSFUL = "00000";

	/** Constante para el código de error en los procesos de consignaciones */
	public static final String CONSIGNMENT_CODE_FAILED = "00099";

	/** Constante que almacena los caracteres no imprimibles. */
	public static final String NON_PRINTABLE_CHARACTERS = "[\r\t\n]";

	/** Constante con el formato de fecha yyyy-MM-dd HH:mm:ss */
	public static final String DATE_FORMAT_SERVICES = "yyyy-MM-dd HH:mm:ss";

	/** Constante referente al idioma del locale configurado en la aplicación */
	public static final String LOCALE_LANGUAGE = "es";

	/** Constante para almacenar el valor de 0 */
	public static final String ZERO = "0";

	/** Constante para almacenar el formato de fecha yyyyMMddHHmmss */
	public static final String DATE_FORMAT = "yyyyMMddHHmmss";

	/** Constante que hace referencia a un punto */
	public static final char POINT = '.';

	/** Constante con el nombre y ubicación del archivo mail.properties */
	public static final String MAIL_PROPERTIES = "/mail.properties";

	/** Constante que contiene el nombre de la variable Mail.receivers del archivo mail.properties */
	public static final String MAIL_RECEIVERS = "MAIL_RECEIVERS";

	/** Constante que contiene el nombre de la variable Mail.subject del archivo mail.properties */
	public static final String MAIL_SUBJECT = "MAIL_SUBJECT";

	/** Constante que contiene el nombre de la variable Mail.message del archivo mail.properties */
	public static final String MAIL_MESSAGE = "MAIL_MESSAGE";

	/** Constante que contiene el nombre de la variable Mail.host del archivo mail.properties */
	public static final String MAIL_HOST = "MAIL_HOST";

	/** Constante que contiene el nombre de la variable Mail.hostport del archivo mail.properties */
	public static final String MAIL_HOST_PORT = "MAIL_HOSTPORT";

	/** Constante que contiene el nombre de la variable Mail.sender del archivo mail.properties */
	public static final String MAIL_SENDER = "MAIL_SENDER";

	/** Constante que contiene el nombre de la variable Mail.senderpassword del archivo mail.properties */
	public static final String MAIL_SENDER_PASSWORD = "MAIL_SENDERPASSWORD";

	/** Constante que contiene el nombre de la variable URL_WS_CONSIGNMENT_CORE del archivo system.properties */
	public static final String URL_WS_CONSIGNMENT_CORE = "URL_WS_CONSIGNMENT_CORE";

	// Mensajes e informacion general para LOGS
	public static final String STARTING_SERVICE = "Invocando servicio: ";
	public static final String STARTING_SERVICE_PARAMS = "Con los parametros: ";
	public static final String ENDING_SERVICE = "Saliendo del servicio: ";
	public static final String ENDING_SERVICE_RESPONSE = "Respuesta: ";

	/** Formato para reporte de erroes de un registro a insertar. */
	public static final String CONSIGMENT_LOT_ERROR_FORMAT = "Registro: %s Errores: [%s]";
	/** Texto para reporte de error de requerido. */
	public static final String REQUIRED = " requerido";
	/** Texto para reporte de error de longitud. */
	public static final String LENGTH_FORBIDDEN = " Supera la longitud permitida %s";
	/** Texto para reporte de error de formato. */
	public static final String FORMAT_ERROR = "Error en formato de ";
	/** Texto para reporte de error de base de datos. */
	public static final String DATABASE_ERROR = "Error en registro en la base de datos";
	/** Texto para origen de carga archivo plano. */
	public static final String FLAT_FILE_TYPE = "Archivo Plano";
	/** Texto para reporte de errores. */
	public static final String WS_ERRORS = "WS_ERRORS";
	/** Texto para detalle de excepción. */
	public static final String STACKTRACE = "STACKTRACE";
	/** Texto para detalle de error de lectura. */
	public static final String READER_ERROR = "READER_ERROR";
	/** Texto para detalle de mensaje general del proceso. */
	public static final String PROCESS_OUTPUT = "PROCESS_OUTPUT";
	/** Texto para error de registro ignorado por no existir un lote. */
	public static final String CONSIGNMENT_SKIPPED = "Registro ignorado al no encontrar la cabecera del lote";
	/** Texto para error de registro ignorado por no existir un lote. */
	public static final String CONSIGNMENT_RECORD_UNREADABLE = "El registro no corresponde a ninguno definido en la estructura del archivo.";
	/** Literal null para comparaciones de servicios. */
	public static final String NULL_LITERAL = "null";

	/** Constante para almacenar el formato de fecha yyyyMMddHHmmssSSS */
	public static final String DATE_FORMAT_WITH_MILLISECONDS = "yyyyMMddHHmmssSSS";

	/** Constante para almacenar el nombre del encode utf-8. */
	public static final String UTF8_ENCODE = "UTF8";
	
	/** Constante que contiene el mensaje de excepción de SOI */
	public static final String LUCASIAN_APP_EXCEPTION_CODE="CÓDIGO DE LA EXCEPCIÓN DE SOI: ";
	
	/** Constante que contiene el formato de fechas dd-MM-yyyy */
	public static final String NOTIFICATION_DATE_FORMAT="dd-MM-yyyy";
	
	/** Constante que contiene un ejemplo de versión de aplicación */
	public static final String APPLICATION_VERSION_EXAMPLE = "1.3.5";
	
	/** Constante que contiene un ejemplo de versión a poner en el */
	public static final String APPLICATION_RANGE_FILTER_EXAMPLE = "1.3.2-2.4.5";
	
	/** Constante con el formato de fecha dd/MM/yyyy HH:mm */
	public static final String DATE_FORMAT_PAYROLL_PAYMENT = "dd/MM/yyyy HH:mm";
	
	/** Constante con el formato de fecha dd/MM/yyyy */
	public static final String DATE_FORMAT_PAYROLL = "dd/MM/yyyy";

	/**
	 * Constructor.
	 */
	private Constants() {
	}
}

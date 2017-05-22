package co.swatit.pilautil.constants;

/**
 * Clase de constantes que mapea los nombres de los parámetros de los servicios REST.
 * 
 * @author Swat-It <br>
 *         Jessica Antía Hortúa <br>
 *         Email: jantia@swat-it.co<br>
 * @date 25/10/2016
 * @version 1.0
 * 
 */
public final class ServicesParamsConstants {

	// Parámetros servicios generales, INICIO

	public static final String TOKEN = "token";
	// Parámetros servicios generales, FIN

	// Parámetros servicio checkAuthorizationFromSOI, INICIO

	/** Identificación del aportante (empresa) */
	public static final String CONTRIBUTOR_ID = "numeroIdentificacionAportante";

	/** Identificación del usuario de la aplicación */
	public static final String ACCOUNT_ID = "numeroIdentificacionCuenta";

	/** Tipo de identificación del aportante (empresa) */
	public static final String CONTRIBUTOR_TYPE = "tipoIdentificacionAportante";

	/** Tipo de identificación del usuario de la aplicación */
	public static final String ACCOUNT_TYPE = "tipoIdentificacionCuenta";

	/** Contrasena del usuario de la aplicación */
	public static final String ACCOUNT_PASSWORD = "contrasenaCuenta";

	// Parámetros servicio checkAuthorizationFromSOI, FIN

	// Parámetros servicio getApplicationConfiguration, INICIO

	/** Primera linea del archivo subido para validar */
	public static final String REG_TP_01 = "registroLinea1";

	public static final String ID_SOI_APORTANTE = "IdSoiAportante";

	public static final String ID_SEG_USUARIO = "IdSegUsuario";

	// Parámetros servicio getApplicationConfiguration, FIN

	// Parámetros servicio getFilteredPayrolls, INICIO

	/**
	 * Número de página a consultar
	 */
	public static final String NUM_PAGINA = "numPagina";

	/**
	 * Cantidad de registros a obtener de una página
	 */
	public static final String NUM_REGISTROS = "numRegistros";

	// Parámetros servicio getFilteredPayrolls, FIN

	// Parámetros servicio getNotifications, INICIO
	/**
	 * Versión de la aplicación del cliente
	 */
	public static final String APPLICATION_VERSION = "version";
	// Parámetros servicio getNotifications, FIN

	// Parámetros servicio getPayrollHeader, INICIO
	/**
	 * Número de planilla a ser consultada
	 */
	public static final String NUM_PLANILLA = "numeroPlanilla";

	// Parámetros servicio getPayrollHeader, FIN

	// Parámetros servicio getContributorsInformation, INICIO

	/** Listado de contribuyentes a los que se les debe completar su informacion */
	public static final String CONTRIBUTOR_IDENTIFICATION_LIST = "listaIdsAportantes";
	
	/** Nombre del archivo ZIP en el que viene la planilla */
	public static final String FILE_NAME_ZIP = "nombreArchivoZip";
	
	/** Ruta del archivo ZIP en el que viene la planilla */
	public static final String FILE_ZIP = "archivoZip";

	// Parámetros servicio getContributorsInformation, FIN
	/**
	 * Constructor por defecto de la clase.
	 */
	private ServicesParamsConstants() {
		// Se deja vacio intencionalmente.
	}
}

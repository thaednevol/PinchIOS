package co.swatit.pilautil.exception.codeenum;

/**
 * Enum que contiene los codigos y descripciones de los errores posibles presentados en los servicios web.
 * 
 * @author Swat-It <br>
 *         Jessica Antía Hortúa <br>
 *         Email: jantia@swat-it.co<br>
 * @date 25/10/2016
 * @version 1.0
 * 
 */
public enum CodeErrorEnum {
	/** CODIGOS DE VALIDACIONES DE NEGOCIO GENERICAS */
	SUCCESSFULL("00", "codeerror.successfull"),
	/** Código para error inesperado en invocación del servicio web. */
	PARSERESPONSEERROR("01", "codeerror.parseresponseerror"),
	/** Código para error inesperado en invocación del servicio web. */
	WSCLIENTERROR("02", "codeerror.wsclienterror"),
	/** Codigo de error para el caso que se genere un error consumiendo un servicio web */
	GETRESPONSECLIENTERROR("03", "codeerror.getresponseclienterror"),
	/** Código para respuesta vacía del servicio web. */
	WSEMPTYRESPONSE("04", "codeerror.wsemptyresponse"),
	/** CODIGOS Y MENSAJES DE EXCEPCIONES CONTROLADAS */
	/** Mensaje de excepción genérica inesperada. */
	EXCEPTION("05", "codeerror.exception"),
	/** Mensaje de e/s exception. */
	IOEXCEPTION("06", "codeerror.ioexception"),
	/** Mensaje de excepción posición ilegal en arreglo. */
	ARRAYINDEXOUTOFBOUNDSEXC("07", "codeerror.arrayindexoutboundexception"),
	/** Mensaje de excepción de formato numérico. */
	NUMBERFORMATEXCEPTION("08", "codeerror.numberformatexception"),
	/** Mensaje de excepción por conexión a la base de datos. */
	BDCONNEXCEPTION("09", "codeerror.bdconnectionexception"),
	/** Error por defecto cuando se produce una excepcion BusinessException */
	BOERROR("10", "codeerror.boerror"),
	/** Codigo cuando se present aun error en el servicio */
	ERROR("11", "codeerror.error"),
	/** Error que se presenta cuando una cadena de texto no corresponde a un formato de fecha especifico */
	ERRORINCORRECTDATE("12", "codeerror.errorincorrectdate"),
	/** Error asociado a validacion de longitud de parametros WS */
	ERRORLENGTHINCORRECT("13", "codeerror.errorlenghtincorrect"),
	/** Codigo de error por parametro requerido. */
	ERRORREQUIREDFIELD("14", "codeerror.errorrequiredfield"),
	/** Mensaje de excepción si la busqueda de la persona no genera resultados. */
	ERRORSEARCHWITHOUTRESULTS("15", "codeerror.errorsearchwithoutresults"),
	/** Codigo de error por parametro no numerico. */
	ERRORINTEGERFIELD("16", "codeerror.errorintegerfield"),
	/** Código de error para un campo con valores inválidos. */
	ERRORSTRINGFIELDVALUE("17", "codeerror.errorstringfieldvalue"),
	/** Error para indicar error de integridad */
	ERRORDATAINTEGRITYVIOLATION("18", "codeerror.errordataintegrityviolation"),
	/** Error para indicar que se presentó un error de SQL que no se puede identificar */
	ERRORUNCATEGORIZEDEX("19", "codeerror.erroruncategorizedex"),
	/** Error para indicar que se presentó un error de desigualdad de tipos de datos */
	ERRORTYPEMISMATCHEX("20", "codeerror.errortypemismatchex"),
	/** Error para indicar que se presentó un error donde no se hizo lo que se debía hacer pero no se ha hecho rollback */
	ERRORINCORRECTUPDATESEMANTICS("21", "codeerror.errorincorrectupdatesemantics"),
	/** Error para indicar que no se tienen permisos para acceder a un recurso determinado */
	ERRORPERMISSIONDENIED("22", "codeerror.errorsqlpermissiondenied"),
	/** Error cuando no se ingresan campos obligatorios en un servicio */
	ERRORREQUIREDALLFIELDS("23", "codeerror.errorrequiredAllFields"),
	/** Error fuera de rango específico */
	ERROROUTOFRANGE("24", "codeerror.erroroutofrange"),
	/** Error asociado a validación de longitud máxima de un parámetro */
	ERRORMAXLENGTHNOTALLOWED("25", "codeerror.errormaxlengthnotallowed"),
	/** Error asociado a validación de cadenas con solo letras */
	ERRORALPHABET("26", "codeerror.erroralphabet"),
	/** Error asociado a validación de longitud máxima de un parámetro */
	ERRORMINLENGTHNOTALLOWED("27", "codeerror.errorminlengthnotallowed"),

	/**
	 * ********************************************************************** /** *************Mostrar opciones según
	 * permisos retornados*************** /** **********************************************************************
	 * /** Rol no encontrado en Enum
	 */
	ERRORROLENOTFOUND("28", "codeerror.errorrolenotfound"),
	/** Archivo de propiedades no encontrado */
	ERRORPERMISSIONSPROPERTIESNOTFOUND("29", "codeerror.errorpermissionspropertiesnotfound"),
	/** Archivo de propiedades no encontrado */
	ERRORIDROLENULLOREMPTY("30", "codeerror.erroridrolenullorempty"),

	/**
	 * ************************************************************* /** Mensajes de respuesta del servicio de logueo
	 * /** ************************************************************* /** La conexión al servidor de SOI está mal
	 * configurada/ no es posible
	 */
	ERRORCONNECTIONREFUSED("31", "codeerror.errorconnectionrefused"),
	/** Los datos enviados al servicio de logueo no son válidos */
	ERRORINVALIDLOGINDATA("32", "codeerror.errorinvalidlogindata"),
	/** No se han podido obtener los datos del token */
	ERRORTOKENSERVICERESPONSE("33", "codeerror.errortokenserviceresponse"),
	/** No se ha podido obtener la conexión con el servidor que genera los tokens */
	ERRORTOKENSERVICECONNECTION("34", "codeerror.errortokenserviceconnection"),
	/** Respuesta del servicio de generación de token cuando la validación de este falle */
	ERRORTOKENNOTAUTHORIZED("35", "codeerror.errortokennotauthorized"),

	/**
	 * ******************************************************************* /** Mensajes de respuesta del servicio de
	 * logueo del proyecto business /** ******************************************************************* /**
	 * Respuesta del servicio cuando falta algunos de los parámetros de entrada
	 */
	ERRORPARAMSNULL("36", "codeerror.errorparamsnull"),
	/** Respuesta del servicio cuando se envía como parámetro una acción a realizar inválida */
	ERRORACTIONINVALID("37", "codeerror.erroractioninvalid"),
	/** Respuesta del servicio Json enviado no se puede convertir en un objeto */
	ERRORPARSEJSON("38", "codeerror.errorparsejson"),
	/** Respuesta del servicio cuando ocurre un error enviado al cliente */
	ERRORUNEXPECTED("39", "codeerror.errorunexpected"),
	/** Respuesta del jar pila-business cuando se usa sin los parámetros suficientes */
	ERRORPARAMSQUANTITY("40", "codeerror.errorparamsquantity"),
	/** Respuesta del jar pila-business cuando no se encuentra el servicio que se desea invocar */
	ERRORSERVICENOTFOUND("41", "codeerror.errorservicenotfound"),
	/** Respuesta del servicio cuando no se puede encontrar la implementación en una fábrica */
	ERRORFACTORY("42", "codeerror.errorfactory"),
	/** Respuesta del servicio cuando no se puede determinar el número de versión de la app o es inválido */
	ERRORVERSIONNUMBER("43", "codeerror.errorversionnumber"),
	/** Respuesta del servicio cuando la operación para filtrar notificaciones no es encontrada */
	ERROROPERATIONNOTFOUND("44", "codeerror.erroroperationnotfound"),
	/** Respuesta del servicio cuando la versión de la aplicación del cliente no es válida */
	ERRORCLIENTVERSIONNUMBER("45", "codeerror.errorclientversionnumber"),
	/** Respuesta del servicio cuando la identificación de un aportante no es válida */
	ERRORINVALIDIDENTIFICATIONNUMBER("46","codeerror.errorinvalididentificationnumber");

	/**
	 * Corresponde al codigo del enum
	 */
	private final String code;
	/**
	 * corresponde a la descripcion del enum
	 */
	private final String description;

	/**
	 * Metodo que define el nombre de la operacion.
	 * 
	 * @param code
	 *            El code del enum
	 * @param description
	 *            La descripcion del enum
	 */
	CodeErrorEnum(final String code, final String description) {
		this.code = code;
		this.description = description;

	}

	/**
	 * Metodo que obtiene el codigo del enum
	 * 
	 * @return code El codigo a retornar
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Metodo que retorna la descripcion del enum
	 * 
	 * @return descripcion La descripcion del enum
	 */
	public String getDescription() {
		return description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return "CodeErrorEnum[code=" + getCode() + ", descripcion=" + getDescription() + "]";
	}

	/**
	 * Metodo que permite obtener una enumeracion a partir de su llave
	 * 
	 * @author Swat-It <br>
	 *         Joshua Rios <br>
	 *         Email: jrios@swat-it.co<br>
	 * @date 24/04/2014
	 * @version 1.0
	 * 
	 * @param key
	 *            codigo para obtener el enumerado
	 * @return Enumerado con el error asociado a la KEY
	 */
	public static CodeErrorEnum getEnum(final String key) {
		CodeErrorEnum response = ERROR;
		for (CodeErrorEnum enumeration : values()) {
			if (enumeration.getCode().equals(key)) {
				response = enumeration;
				break;
			}
		}
		return response;
	}
}

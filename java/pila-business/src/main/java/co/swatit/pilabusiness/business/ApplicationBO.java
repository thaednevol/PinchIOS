package co.swatit.pilabusiness.business;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

import co.swatit.pilabusiness.utils.AttributePropertiesUtil;
import co.swatit.pilabusiness.utils.ResponseUtil;
import co.swatit.pilabusiness.utils.enums.ServiceNameEnum;
import co.swatit.pilautil.constants.ServicesParamsConstants;
import co.swatit.pilautil.dto.in.GetConsultFileInDTO;
import co.swatit.pilautil.dto.in.GetContributorsInformationInDTO;
import co.swatit.pilautil.dto.in.GetFilteredPayrollsInDTO;
import co.swatit.pilautil.dto.in.GetNotificationsInDTO;
import co.swatit.pilautil.dto.in.GetPayrollContributorsInDTO;
import co.swatit.pilautil.dto.in.GetPayrollHeaderInDTO;
import co.swatit.pilautil.dto.in.GetPutPayrollInDTO;
import co.swatit.pilautil.dto.in.GetValidateFileInDTO;
import co.swatit.pilautil.dto.in.GetValidationFileConfigInDTO;
import co.swatit.pilautil.dto.in.LoginInDTO;
import co.swatit.pilautil.dto.in.ValidateTokenInDTO;
import co.swatit.pilautil.dto.out.GetConsultFileOutDTO;
import co.swatit.pilautil.dto.out.GetConsultPayrollOutDTO;
import co.swatit.pilautil.dto.out.GetValidateFileOutDTO;
import co.swatit.pilautil.exception.BusinessException;
import co.swatit.pilautil.exception.ErrorMessagesLoader;
import co.swatit.pilautil.exception.InvokeException;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;
import co.swatit.pilautil.generics.Constants;
import co.swatit.pilautil.generics.FileUtilities;
import co.swatit.pilautil.generics.Validation;
import co.swatit.pilautil.request.rest.ParserUtils;
import co.swatit.pilautil.request.rest.ServiceRequestProvider;

import com.ach.pla.biz.type.NotificacionDeArchivoEnProcesoType;

/**
 * Clase encargada de implementar la lógica del negocio del proyecto
 * 
 * @author SWAT-IT <br>
 *         Cristian Camilo Londoño <br>
 *         Email: clondono@swat-it.co <br>
 * @date 19/01/2017
 * @sprint 1.0
 */
public final class ApplicationBO {

	/**
	 * Método constructor privado
	 */
	private ApplicationBO() {

	}

	/**
	 * 
	 * Método que determina el servicio a consumir
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/02/2017
	 *
	 * @param serviceNameEnum
	 *            enum que contiene el nombre del servicio
	 * @param parameters
	 *            contiene los parámetros que usa el servicio
	 * @return String con la respuesta del servicio
	 */
	public static String serviceConsumer(ServiceNameEnum serviceNameEnum, String parameters) {
		String retorno;
		switch (serviceNameEnum) {
		case LOGIN:
			retorno = login(parameters);
			break;
		case GETVALIDATIONFILECONFIG:
			retorno = getValidationFileConfig(parameters);
			break;
		case VALIDATETOKEN:
			retorno = validateToken(parameters);
			break;
		case GETFILTEREDPAYROLLS:
			retorno = getFilteredPayrolls(parameters);
			break;
		case GETNOTIFICATIONS:
			retorno = getNotifications(parameters);
			break;
		case GETPAYROLLHEADER:
			retorno = getPayrollHeader(parameters);
			break;
		case GETPAYROLLCONTRIBUTORS:
			retorno = getPayrollContributors(parameters);
			break;
		case GETCONTRIBUTORSINFORMATION:
			retorno = getContributorsInformation(parameters);
			break;
		case CREATEPAYROLL:
			retorno = createPayroll(parameters);
			break;
		case VALIDATEFILE:
			retorno = validateFile(parameters);
			break;
		case CONSULTFILE:
			retorno = consultFile(parameters);
			break;
		case PUTPAYROLL:
			retorno = putPayroll(parameters);
			break;
		default:
			retorno = ResponseUtil.manageException(CodeErrorEnum.ERRORSERVICENOTFOUND.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.ERRORSERVICENOTFOUND.getDescription()),
					new BusinessException(CodeErrorEnum.ERRORSERVICENOTFOUND));
		}

		return retorno;
	}

	/**
	 * Método encargado de convertir la cadena JSON de entrada en un objeto LoginInDTO, de realizar las validaciones de
	 * campos del DTO y de realizar el llamado al WS de login
	 * 
	 * @autor SWAT-IT <br>
	 *        Cristian Camilo Londoño <br>
	 *        Email: clondono@swat-it.co <br>
	 * @date 19/01/2017
	 * @version 1.0
	 *
	 * @param loginData
	 *            {@link String} JSON que contiene los datos de acceso para realizar el logueo en la aplicación.
	 * @return {@link String} String que contiene el JSON que response el servidor.
	 */
	private static String login(String loginData) {
		String resp = Constants.EMPTY;
		try {
			/* Se convierte el String JSON de entrada en un LoginInDTO */
			LoginInDTO inDTO = ParserUtils.INSTANCE.parseJSONToObject(loginData, LoginInDTO.class);

			/* Se realiza la validación de los campos del DTO de entrada al servicio */
			Validation.validateParam(ServicesParamsConstants.CONTRIBUTOR_ID, inDTO.getContributorIdNumber());
			Validation.validateParam(ServicesParamsConstants.ACCOUNT_ID, inDTO.getAccountIdNumber());
			Validation.valideParamInteger(ServicesParamsConstants.CONTRIBUTOR_TYPE, inDTO.getContributorIdType());
			Validation.valideParamInteger(ServicesParamsConstants.ACCOUNT_TYPE, inDTO.getAccountIdType());
			Validation.validateParam(ServicesParamsConstants.ACCOUNT_PASSWORD, inDTO.getAccountPassword());
			/* Se realiza el llamado al WS que realiza el logueo */
			resp = ServiceRequestProvider.callPostWS(AttributePropertiesUtil.PILA_WS_URL,
					AttributePropertiesUtil.LOGIN_PATH, loginData, MediaType.APPLICATION_JSON);

		} catch (BusinessException e) {
			/* Se llama el método que registra la excepción en el log */
			resp = ResponseUtil
					.manageBusinessException(e.getErrorDTO().getCode(), e.getErrorDTO().getDescription(), e);
		} catch (IOException e) {
			/* Se llama el método que registra la excepción en el log */
			resp = ResponseUtil.manageException(CodeErrorEnum.ERRORPARSEJSON.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.ERRORPARSEJSON.getDescription()), e);
		} catch (InvokeException e) {
			/* Se llama el método que registra la excepción en el log */
			resp = ResponseUtil.manageException(CodeErrorEnum.WSCLIENTERROR.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.WSCLIENTERROR.getDescription()), e);
		}
		/* Se retorna la respuesta dada por el WS */
		return resp;
	}

	/**
	 * 
	 * Método que hace un consumo al servicio getValidationFileConfig el cuál obtiene la configuración de un archivo y
	 * la aplicación
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/02/2017
	 *
	 * @param paramData
	 *            , parámetros del servicio
	 * @return respuesta del servicio
	 */
	private static String getValidationFileConfig(String paramData) {
		String resp = Constants.EMPTY;
		try {
			// Parseo del objeto de entrada en un objeto GetValidatrionFileConfigInDTO
			GetValidationFileConfigInDTO inDTO = ParserUtils.INSTANCE.parseJSONToObject(paramData,
					GetValidationFileConfigInDTO.class);
			// Bloque de validaciones
			Validation.valideParamInteger(ServicesParamsConstants.ID_SEG_USUARIO, inDTO.getIdSegUsuario());
			Validation.validateParam(ServicesParamsConstants.TOKEN, inDTO.getToken());
			Validation.validateParam(ServicesParamsConstants.REG_TP_01, inDTO.getRegTp01());
			Validation.valideParamInteger(ServicesParamsConstants.ID_SOI_APORTANTE, inDTO.getIdSoiAportante());

			// consumo del servicio
			resp = ServiceRequestProvider.callPostWS(AttributePropertiesUtil.PILA_WS_URL,
					AttributePropertiesUtil.GET_VALIDATION_FILE_CONFIG_PATH, paramData, MediaType.APPLICATION_JSON);
		} catch (BusinessException e) {
			resp = ResponseUtil
					.manageBusinessException(e.getErrorDTO().getCode(), e.getErrorDTO().getDescription(), e);
		} catch (IOException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.ERRORPARSEJSON.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.ERRORPARSEJSON.getDescription()), e);
		} catch (InvokeException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.WSCLIENTERROR.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.WSCLIENTERROR.getDescription()), e);
		}
		// respuesta del servicio
		return resp;
	}

	/**
	 * 
	 * Método que hace un consumo del servicio de validación de tokens
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 27/02/2017
	 *
	 * @param paramData
	 *            , parámetros del servicio
	 * @return respuesta del servicio
	 */
	private static String validateToken(String paramData) {
		String resp = Constants.EMPTY;
		try {
			ValidateTokenInDTO inDTO = ParserUtils.INSTANCE.parseJSONToObject(paramData, ValidateTokenInDTO.class);
			Validation.validateParam(ServicesParamsConstants.TOKEN, inDTO.getToken());
			resp = ServiceRequestProvider.callPostWS(AttributePropertiesUtil.PILA_WS_URL,
					AttributePropertiesUtil.VALIDATE_TOKEN, paramData, MediaType.APPLICATION_JSON);
		} catch (BusinessException e) {
			resp = ResponseUtil
					.manageBusinessException(e.getErrorDTO().getCode(), e.getErrorDTO().getDescription(), e);
		} catch (IOException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.ERRORPARSEJSON.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.ERRORPARSEJSON.getDescription()), e);
		} catch (InvokeException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.WSCLIENTERROR.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.WSCLIENTERROR.getDescription()), e);
		}
		return resp;
	}

	/**
	 * Método que hace un consumo al servicio getFilteredPayrolls para obtener las últimas planillas pagadas de un
	 * usuario
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 9/03/2017
	 *
	 * @param paramData
	 *            , parámetros del servicio
	 * @return respuesta del servicio
	 */
	private static String getFilteredPayrolls(String paramData) {
		String resp = Constants.EMPTY;
		try {
			GetFilteredPayrollsInDTO inDTO = ParserUtils.INSTANCE.parseJSONToObject(paramData,
					GetFilteredPayrollsInDTO.class);
			Validation.validateParam(ServicesParamsConstants.TOKEN, inDTO.getToken());
			Validation.valideParamInteger(ServicesParamsConstants.ID_SEG_USUARIO, inDTO.getIdSegUsuario());
			Validation.valideParamInteger(ServicesParamsConstants.ID_SOI_APORTANTE, inDTO.getIdSoiAportante());
			String numPagina = inDTO.getNumPagina();
			if (Validation.isNotNull(numPagina)) {
				Validation.valideParamInteger(ServicesParamsConstants.NUM_PAGINA, numPagina);
			}
			String numRegistros = inDTO.getNumRegistros();
			if (Validation.isNotNull(numRegistros)) {
				Validation.valideParamInteger(ServicesParamsConstants.NUM_REGISTROS, numRegistros);
			}
			resp = ServiceRequestProvider.callPostWS(AttributePropertiesUtil.PILA_WS_URL,
					AttributePropertiesUtil.GET_FILTERED_PAYROLLS, paramData, MediaType.APPLICATION_JSON);
		} catch (IOException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.ERRORPARSEJSON.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.ERRORPARSEJSON.getDescription()), e);
		} catch (BusinessException e) {
			resp = ResponseUtil
					.manageBusinessException(e.getErrorDTO().getCode(), e.getErrorDTO().getDescription(), e);
		} catch (InvokeException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.WSCLIENTERROR.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.WSCLIENTERROR.getDescription()), e);
		}
		return resp;
	}

	/**
	 * Método que consume el servicio getNotifications para obtener las notificaciones del usuario según la versión de
	 * la aplicación
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 15/03/2017
	 *
	 * @param paramData
	 *            , parámetros del servicio
	 * @return respuesta del servicio
	 */
	private static String getNotifications(String paramData) {
		String resp = Constants.EMPTY;
		try {
			GetNotificationsInDTO inDTO = ParserUtils.INSTANCE.parseJSONToObject(paramData,
					GetNotificationsInDTO.class);
			Validation.validateParam(ServicesParamsConstants.TOKEN, inDTO.getToken());
			String version = inDTO.getVersion();
			Validation.validateParam(ServicesParamsConstants.APPLICATION_VERSION, version);
			if (Validation.isVersionNumber(version)) {
				resp = ServiceRequestProvider.callPostWS(AttributePropertiesUtil.PILA_WS_URL,
						AttributePropertiesUtil.GET_NOTIFICATIONS, paramData, MediaType.APPLICATION_JSON);
			} else {
				resp = ResponseUtil.printResponse(CodeErrorEnum.ERRORCLIENTVERSIONNUMBER.getCode(),
						ErrorMessagesLoader.INSTANCE.getErrorMensage(
								CodeErrorEnum.ERRORCLIENTVERSIONNUMBER.getDescription(), version,
								Constants.APPLICATION_VERSION_EXAMPLE));
			}

		} catch (IOException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.ERRORPARSEJSON.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.ERRORPARSEJSON.getDescription()), e);
		} catch (BusinessException e) {
			resp = ResponseUtil
					.manageBusinessException(e.getErrorDTO().getCode(), e.getErrorDTO().getDescription(), e);
		} catch (InvokeException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.WSCLIENTERROR.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.WSCLIENTERROR.getDescription()), e);
		}
		return resp;
	}

	/**
	 * Método que consume el servicio getPayrollHeader el cual obtiene los datos de la cabecera de una planilla
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 15/03/2017
	 *
	 * @param paramData
	 *            , parámetros del servicio
	 * @return respuesta del servicio
	 */
	private static String getPayrollHeader(String paramData) {
		String resp = Constants.EMPTY;
		try {
			GetPayrollHeaderInDTO inDTO = ParserUtils.INSTANCE.parseJSONToObject(paramData,
					GetPayrollHeaderInDTO.class);
			Validation.validateParam(ServicesParamsConstants.TOKEN, inDTO.getToken());
			Validation.valideParamInteger(ServicesParamsConstants.NUM_PLANILLA, inDTO.getNumeroPlanilla());
			resp = ServiceRequestProvider.callPostWS(AttributePropertiesUtil.PILA_WS_URL,
					AttributePropertiesUtil.GET_PAYROLL_HEADER, paramData, MediaType.APPLICATION_JSON);
		} catch (IOException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.ERRORPARSEJSON.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.ERRORPARSEJSON.getDescription()), e);
		} catch (BusinessException e) {
			resp = ResponseUtil
					.manageBusinessException(e.getErrorDTO().getCode(), e.getErrorDTO().getDescription(), e);
		} catch (InvokeException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.WSCLIENTERROR.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.WSCLIENTERROR.getDescription()), e);
		}
		return resp;
	}

	/**
	 * Método que consume el servicio web getPayrollContributors el cual obtiene los aportantes de una planilla según
	 * su número de identificación
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 5/04/2017
	 *
	 * @param paramData
	 *            , parámetros del servicio
	 * @return respuesta del servicio
	 */
	private static String getPayrollContributors(String paramData) {
		String resp = Constants.EMPTY;
		try {
			GetPayrollContributorsInDTO inDTO = ParserUtils.INSTANCE.parseJSONToObject(paramData,
					GetPayrollContributorsInDTO.class);
			Validation.validateParam(ServicesParamsConstants.TOKEN, inDTO.getToken());
			Validation.valideParamInteger(ServicesParamsConstants.NUM_PLANILLA, inDTO.getNumeroPlanilla());
			resp = ServiceRequestProvider.callPostWS(AttributePropertiesUtil.PILA_WS_URL,
					AttributePropertiesUtil.GET_PAYROLL_CONTRIBUTORS, paramData, MediaType.APPLICATION_JSON);
		} catch (IOException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.ERRORPARSEJSON.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.ERRORPARSEJSON.getDescription()), e);
		} catch (BusinessException e) {
			resp = ResponseUtil
					.manageBusinessException(e.getErrorDTO().getCode(), e.getErrorDTO().getDescription(), e);
		} catch (InvokeException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.WSCLIENTERROR.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.WSCLIENTERROR.getDescription()), e);
		}
		return resp;
	}

	/**
	 * 
	 * Método que invoca el servicio web getContributorsInformation el cual obtiene información de aportantes de SOI
	 * según su identificación
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 10/04/2017
	 *
	 * @param paramData
	 *            , parámetros del servicio
	 * @return respuesta del servicio
	 */
	private static String getContributorsInformation(String paramData) {
		String resp = Constants.EMPTY;
		try {
			GetContributorsInformationInDTO inDTO = ParserUtils.INSTANCE.parseJSONToObject(paramData,
					GetContributorsInformationInDTO.class);
			Validation.validateParam(ServicesParamsConstants.TOKEN, inDTO.getToken());
			Validation.validateParam(ServicesParamsConstants.CONTRIBUTOR_IDENTIFICATION_LIST,
					inDTO.getContributorsIds());
			resp = ServiceRequestProvider.callPostWS(AttributePropertiesUtil.PILA_WS_URL,
					AttributePropertiesUtil.GET_CONTRIBUTORS_INFORMATION, paramData, MediaType.APPLICATION_JSON);
		} catch (IOException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.ERRORPARSEJSON.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.ERRORPARSEJSON.getDescription()), e);
		} catch (BusinessException e) {
			resp = ResponseUtil
					.manageBusinessException(e.getErrorDTO().getCode(), e.getErrorDTO().getDescription(), e);
		} catch (InvokeException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.WSCLIENTERROR.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.WSCLIENTERROR.getDescription()), e);
		}
		return resp;
	}
	
	
	private static String createPayroll(String paramData) {
		String resp = Constants.EMPTY;
		try {
			GetValidateFileInDTO inDTO = ParserUtils.INSTANCE.parseJSONToObject(paramData,
					GetValidateFileInDTO.class);
			
			FileUtilities.zipFile(inDTO.getRutaLocalArchivo(), inDTO.getFileName(), inDTO.getFileNameZip());
			
			resp = ServiceRequestProvider.callPostWS(AttributePropertiesUtil.PILA_WS_URL,
					AttributePropertiesUtil.VALIDATE_FILE, paramData, MediaType.APPLICATION_JSON);
			GetValidateFileOutDTO getValidateFileOutDTO = ParserUtils.INSTANCE.parseJSONToObject(resp,
					GetValidateFileOutDTO.class);
			
			
			GetConsultFileInDTO getConsultFileInDTO = new GetConsultFileInDTO();
			getConsultFileInDTO.setIdFile(getValidateFileOutDTO.getIdArchivoEnProceso());
			resp = ParserUtils.INSTANCE.convertObjectToJSON(getConsultFileInDTO);
			
			resp = ServiceRequestProvider.callPostWS(AttributePropertiesUtil.PILA_WS_URL,
					AttributePropertiesUtil.CONSULT_FILE, resp, MediaType.APPLICATION_JSON);
			GetConsultFileOutDTO getConsultFileOutDTO = ParserUtils.INSTANCE.parseJSONToObject(resp,
					GetConsultFileOutDTO.class);
			
			while (getConsultFileOutDTO.getIdPlanilla() == 0) {
				FileUtilities.sleep();
				resp = ParserUtils.INSTANCE.convertObjectToJSON(getConsultFileInDTO);
				resp = ServiceRequestProvider.callPostWS(AttributePropertiesUtil.PILA_WS_URL,
						AttributePropertiesUtil.CONSULT_FILE, resp, MediaType.APPLICATION_JSON);
				getConsultFileOutDTO = ParserUtils.INSTANCE.parseJSONToObject(resp,
						GetConsultFileOutDTO.class);
			}
			
			GetConsultPayrollOutDTO getConsultPayrollOutDTO = new GetConsultPayrollOutDTO();
			GetPutPayrollInDTO getPutPayrollInDTO = new GetPutPayrollInDTO();
			getConsultPayrollOutDTO.setPeriodoNoSalud(inDTO.getPeriodoNoSalud());
			getConsultPayrollOutDTO.setPeriodoSalud(inDTO.getPeriodoSalud());
			getPutPayrollInDTO.setGetConsultPayrollOutDTO(getConsultPayrollOutDTO);
			getPutPayrollInDTO.setIdPlanilla(getConsultFileOutDTO.getIdPlanilla());
			
			getValidateFileOutDTO.setIdSegUsuario(inDTO.getIdSegUsuario());
			getValidateFileOutDTO.setIdSoiPlanilla(getConsultFileOutDTO.getIdPlanilla());
			getValidateFileOutDTO.setNotificacionDeArchivoEnProcesoType(NotificacionDeArchivoEnProcesoType.SOBREESCRIBIR_NOTIFICACION);
			getValidateFileOutDTO.setNumeroTotalDeEmpleadosPorPantalla(inDTO.getNumeroTotalDeEmpleadosPorPantalla());
			getValidateFileOutDTO.setNombreArchivo(inDTO.getFileName());
			getValidateFileOutDTO.setIdAportante(inDTO.getIdAportante());
			
			getPutPayrollInDTO.setGetValidateFileOutDTO(getValidateFileOutDTO);
			
			resp = ParserUtils.INSTANCE.convertObjectToJSON(getPutPayrollInDTO);
			
			resp = ServiceRequestProvider.callPostWS(AttributePropertiesUtil.PILA_WS_URL,
					AttributePropertiesUtil.PUT_PAYROLL, resp, MediaType.APPLICATION_JSON);
			
		} catch (IOException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.ERRORPARSEJSON.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.ERRORPARSEJSON.getDescription()), e);
		} catch (InvokeException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.WSCLIENTERROR.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.WSCLIENTERROR.getDescription()), e);
		}
		return resp;
	}
	
	private static String validateFile(String paramData) {
		String resp = Constants.EMPTY;
		try {
			GetValidateFileInDTO inDTO = ParserUtils.INSTANCE.parseJSONToObject(paramData,GetValidateFileInDTO.class);
			
			FileUtilities.zipFile(inDTO.getRutaLocalArchivo(), inDTO.getFileName(), inDTO.getFileNameZip());
			
			if ( inDTO.getFileZip()==null || inDTO.getFileZip().length==0 ){
				inDTO.setArchivoZip(FileUtilities.readZipFile(inDTO.getRutaLocalArchivo()+File.separator+inDTO.getFileNameZip()));
				paramData = ParserUtils.INSTANCE.convertObjectToJSON(inDTO);
			}						
			
			resp = ServiceRequestProvider.callPostWS(AttributePropertiesUtil.PILA_WS_URL,
					AttributePropertiesUtil.VALIDATE_FILE, paramData, MediaType.APPLICATION_JSON);
			
			
			
		} catch (IOException e) {			
			resp = ResponseUtil.manageException(CodeErrorEnum.ERRORPARSEJSON.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.ERRORPARSEJSON.getDescription()), e);
		} catch (InvokeException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.WSCLIENTERROR.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.WSCLIENTERROR.getDescription()), e);
		}
		return resp;
	}
	
	
	private static String consultFile(String paramData) {
		String resp = Constants.EMPTY;
		try {
			
			GetConsultFileInDTO inDTO = ParserUtils.INSTANCE.parseJSONToObject(paramData,
					GetConsultFileInDTO.class);
			
			resp = ServiceRequestProvider.callPostWS(AttributePropertiesUtil.PILA_WS_URL,
					AttributePropertiesUtil.CONSULT_FILE, paramData, MediaType.APPLICATION_JSON);
			/*GetConsultFileOutDTO getConsultFileOutDTO = ParserUtils.INSTANCE.parseJSONToObject(resp,
					GetConsultFileOutDTO.class);
			
			while (getConsultFileOutDTO.getIdPlanilla() == 0) {
				FileUtilities.sleep();
				resp = ParserUtils.INSTANCE.convertObjectToJSON(inDTO);
				resp = ServiceRequestProvider.callPostWS(AttributePropertiesUtil.PILA_WS_URL,
						AttributePropertiesUtil.CONSULT_FILE, resp, MediaType.APPLICATION_JSON);
				getConsultFileOutDTO = ParserUtils.INSTANCE.parseJSONToObject(resp,
						GetConsultFileOutDTO.class);
			}*/
			
		} catch (IOException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.ERRORPARSEJSON.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.ERRORPARSEJSON.getDescription()), e);
		} catch (InvokeException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.WSCLIENTERROR.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.WSCLIENTERROR.getDescription()), e);
		}
		return resp;
	}
	
	
	private static String putPayroll(String paramData) {
		String resp = Constants.EMPTY;
		try {
			
			GetPutPayrollInDTO inDTO = ParserUtils.INSTANCE.parseJSONToObject(paramData,
					GetPutPayrollInDTO.class);
			
			resp = ServiceRequestProvider.callPostWS(AttributePropertiesUtil.PILA_WS_URL,
					AttributePropertiesUtil.PUT_PAYROLL, paramData, MediaType.APPLICATION_JSON);
			
		} catch (IOException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.ERRORPARSEJSON.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.ERRORPARSEJSON.getDescription()), e);
		} catch (InvokeException e) {
			resp = ResponseUtil.manageException(CodeErrorEnum.WSCLIENTERROR.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.WSCLIENTERROR.getDescription()), e);
		}
		return resp;
	}
}
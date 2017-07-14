package co.swatit.pilawebservices.business;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJBException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import co.swatit.pilautil.constants.NumberConstants;
import co.swatit.pilautil.constants.ServicesParamsConstants;
import co.swatit.pilautil.converter.Converter;
import co.swatit.pilautil.dto.ResponseDTO;
import co.swatit.pilautil.dto.in.GenerateTokenInDTO;
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
import co.swatit.pilautil.dto.out.GenerateTokenOutDTO;
import co.swatit.pilautil.dto.out.GetConsultFileOutDTO;
import co.swatit.pilautil.dto.out.GetConsultPayrollOutDTO;
import co.swatit.pilautil.dto.out.GetContributorsInformationOutDTO;
import co.swatit.pilautil.dto.out.GetFilteredPayrollsOutDTO;
import co.swatit.pilautil.dto.out.GetNotificationsOutDTO;
import co.swatit.pilautil.dto.out.GetPayrollContributorsOutDTO;
import co.swatit.pilautil.dto.out.GetPayrollHeaderOutDTO;
import co.swatit.pilautil.dto.out.GetPutPayrollOutDTO;
import co.swatit.pilautil.dto.out.GetValidateFileOutDTO;
import co.swatit.pilautil.dto.out.GetValidationFileConfigOutDTO;
import co.swatit.pilautil.dto.out.LoginOutDTO;
import co.swatit.pilautil.dto.out.PayrollDetailDTO;
import co.swatit.pilautil.dto.out.PlanillaAportanteDTO;
import co.swatit.pilautil.enums.RoleEnum;
import co.swatit.pilautil.exception.BusinessException;
import co.swatit.pilautil.exception.ErrorMessagesLoader;
import co.swatit.pilautil.exception.InvokeException;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;
import co.swatit.pilautil.generics.Constants;
import co.swatit.pilautil.generics.FileUtilities;
import co.swatit.pilautil.generics.PropertyLoader;
import co.swatit.pilautil.generics.VOBuilder;
import co.swatit.pilautil.generics.Validation;
import co.swatit.pilautil.request.rest.ParserUtils;
import co.swatit.pilautil.request.rest.ServiceRequestProvider;
import co.swatit.pilawebservices.factory.NotificationFactory;
import co.swatit.pilawebservices.interfaces.INotificationLoader;
import co.swatit.pilawebservices.soi.ApplicationConfiguration;

import com.ach.arc.biz.AdminProcesarCargaArchivosSvc;
import com.ach.arc.biz.PlanillaRegistroConsultaTempArchivosSvc;
import com.ach.arc.biz.r1747.model.bean.PlanillaRegT01;
import com.ach.arc.biz.transfer.ArchivoEnProcesoConsultaDTO;
import com.ach.arc.biz.transfer.ArchivoNotificacionDTO;
import com.ach.arc.biz.transfer.ArchivoNotificacionResultadoDTO;
import com.ach.cfg.biz.type.EstadoPlanillaType;
import com.ach.pla.biz.PlanillaConsultaSvc;
import com.ach.pla.biz.transfer.ConsultarPlanillaFilterDTO;
import com.ach.pla.biz.transfer.InformacionBasicaCotizanteDTO;
import com.ach.pla.biz.transfer.PlanillaConsultadaDTO;
import com.ach.pla.biz.transfer.PlanillaConsultadaListadoDTO;
import com.ach.pla.biz.transfer.PlanillaTotalesDTO;
import com.ach.pla.biz.type.NotificacionDeArchivoEnProcesoType;
import com.ach.seg.biz.NSOISeguridadSvc;
import com.ach.seg.biz.model.RecursoVO;
import com.ach.seg.biz.model.UsuarioVO;
import com.ach.seg.biz.transfer.LoginDTO;
import com.ach.seg.biz.transfer.UsuarioAutenticadoDTO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lucasian.common.jee.model.PagedTableDTO;
import com.lucasian.exception.ApplicationException;

/**
 * 
 * Clase encargada de implementar la lógica del negocio del proyecto
 * 
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 12/01/2017
 * @version 1.0
 */
public final class PilaBO {

	/**
	 * LOGGER de la aplicación.
	 */
	private static final Logger LOGGER = Logger.getLogger(PilaBO.class.getName());

	/**
	 * Constructor vacío de la clase
	 */
	private PilaBO() {

	}

	/**
	 * 
	 * Método que configura la conexión con el servidor de SOI
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 13/01/2017
	 *
	 * @return {@link Context}, contexto de la conexión al servidor
	 * @throws NamingException
	 *             , se lanzará la excepción en los siguientes casos:
	 *             <ul>
	 *             <li>La propiedad INITIAL_CONTEXT_FACTORY del archivo de propiedades /system.properties no esté
	 *             configurada adecuadamente</li>
	 *             <li>La propiedad PROVIDER_URL del archivo de propiedades /system.properties no esté configurada
	 *             adecuadamente</li>
	 *             <li>La propiedad SECURITY_PRINCIPAL del archivo de propiedades /system.properties no esté
	 *             configurada adecuadamente</li>
	 *             <li>La propiedad SECURITY_CREDENTIALS del archivo de propiedades /system.properties no esté
	 *             configurada adecuadamente</li>
	 *             </ul>
	 */
	private static Context connect() throws NamingException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilawebservices.business.PilaBO.connect");
		Properties connectionProperties = new Properties();
		connectionProperties.put(Context.INITIAL_CONTEXT_FACTORY,
				PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP, "INITIAL_CONTEXT_FACTORY"));
		connectionProperties.put(Context.PROVIDER_URL,
				PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP, "PROVIDER_URL"));
		connectionProperties.put(Context.SECURITY_PRINCIPAL,
				PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP, "SECURITY_PRINCIPAL"));
		connectionProperties.put(Context.SECURITY_CREDENTIALS,
				PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP, "SECURITY_CREDENTIALS"));
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilawebservices.business.PilaBO.connect");
		return new InitialContext(connectionProperties);
	}

	/**
	 * 
	 * Método que provee la conexión con el servidor de SOI que provee la configuración de archivos
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 15/02/2017
	 *
	 * @return
	 * @throws NamingException
	 *             , se lanzará la excepción en los siguientes casos:
	 *             <ul>
	 *             <li>La propiedad INITIAL_CONTEXT_FACTORY del archivo de propiedades /system.properties no esté
	 *             configurada adecuadamente</li>
	 *             <li>La propiedad CONFIGURATION_PROVIDER_URL del archivo de propiedades /system.properties no esté
	 *             configurada adecuadamente</li>
	 *             <li>La propiedad CONFIGURATION_SECURITY_PRINCIPAL del archivo de propiedades /system.properties no
	 *             esté configurada adecuadamente</li>
	 *             <li>La propiedad CONFIGURATION_SECURITY_CREDENTIALS del archivo de propiedades /system.properties no
	 *             esté configurada adecuadamente</li>
	 *             </ul>
	 */
	private static Context connectFileValidatorServer() throws NamingException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilawebservices.business.PilaBO.connectFileValidatorServer");
		Properties connectionProperties = new Properties();
		connectionProperties.put(Context.INITIAL_CONTEXT_FACTORY,
				PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP, "INITIAL_CONTEXT_FACTORY"));
		connectionProperties.put(Context.PROVIDER_URL,
				PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP, "PROVIDER_URL"));
		connectionProperties.put(Context.SECURITY_PRINCIPAL,
				PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP, "SECURITY_PRINCIPAL"));
		connectionProperties.put(Context.SECURITY_CREDENTIALS,
				PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP, "SECURITY_CREDENTIALS"));
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ "co.swatit.pilawebservices.business.PilaBO.connectFileValidatorServer");
		return new InitialContext(connectionProperties);
	}

	/**
	 * 
	 * Método que cierra una conexión con el servidor SOI
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/01/2017
	 *
	 * @param connection
	 *            , conexión a cerrar
	 */
	private static void closeConnection(Context connection) {
		if (Validation.isNotNull(connection)) {
			try {
				connection.close();
			} catch (NamingException e) {
				LOGGER.error(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.ERROR.getCode()), e);
			}
		}
	}

	/**
	 * 
	 * Método que realiza el logueo de un usuario, obtención de su rol y generación del token que provee la seguridad
	 * de los demás servicios web, como también de los permisos del usuario
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 13/01/2017
	 *
	 * @param loginInDTO
	 *            , objeto que contiene todos los parámetros de entrada del servicio
	 * @param requestClient
	 *            , IP del cliente que realiza la petición al servicio
	 * @return {@link LoginOutDTO}, objeto que contiene el token y los permisos del usuario
	 * @throws {@link BusinessException}, en las siguientes situaciones:
	 *         <ul>
	 *         <li>La conexión con SOI no sea posible, esté mal configurada</li>
	 *         <li>Los datos ingresados no correspondan a un usuario, sean incorrectos
	 *         <li>Fallo al obtener respuesta del servicio de generación de tokens</li>
	 *         <li>No se puede obtener conexión con el servidor de generación de tokens</li>
	 *         <li>Alguno de los parámetros recibidos es nulo o vacío</li>
	 *         <li>Existe algún problema al momento de obtener los permisos del usuario</li>
	 *         </ul>
	 */
	public static LoginOutDTO checkAuthorizationFromSOI(LoginInDTO loginInDTO, String requestClient)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilawebservices.business.PilaBO.checkAuthorizationFromSOI");
		Validation.validateParam(ServicesParamsConstants.CONTRIBUTOR_ID, loginInDTO.getContributorIdNumber());
		Validation.validateParam(ServicesParamsConstants.ACCOUNT_ID, loginInDTO.getAccountIdNumber());
		Validation.valideParamInteger(ServicesParamsConstants.CONTRIBUTOR_TYPE, loginInDTO.getContributorIdType());
		Validation.valideParamInteger(ServicesParamsConstants.ACCOUNT_TYPE, loginInDTO.getAccountIdType());
		Validation.validateParam(ServicesParamsConstants.ACCOUNT_PASSWORD, loginInDTO.getAccountPassword());
		Context connection = null;
		try {
			// Se instancia el objeto de transporte de la aplicación SOI
			LoginDTO loginBeforeSoiDTO = new LoginDTO();
			loginBeforeSoiDTO.setIdSoiAplicacion(Integer.valueOf(PropertyLoader.INSTANCE.getProperty(
					Constants.GLOBAL_PROP, "ID_SOI_APPLICATION")));
			loginBeforeSoiDTO.setIpUsuarioOrigen(requestClient);
			loginBeforeSoiDTO.setContrasena(loginInDTO.getAccountPassword());
			loginBeforeSoiDTO.setCuenta(Integer.valueOf(loginInDTO.getAccountIdType()),
					loginInDTO.getAccountIdNumber());
			loginBeforeSoiDTO.setIdTipoIdentificacionAportante(Integer.valueOf(loginInDTO.getContributorIdType()));
			loginBeforeSoiDTO.setNumeroIdentificacionAportante(loginInDTO.getContributorIdNumber());
			// Se realiza la conexión con el servidor SOI
			connection = connect();
			NSOISeguridadSvc security = (NSOISeguridadSvc) connection.lookup(PropertyLoader.INSTANCE.getProperty(
					Constants.GLOBAL_PROP, "CONNECTION_CLASS"));
			// Se autentica ante SOI
			UsuarioAutenticadoDTO usuarioAuthDTO = security.autenticarUsuario(loginBeforeSoiDTO);
			List<RecursoVO> resources = (List<RecursoVO>) usuarioAuthDTO.getRecursosAutorizacion();
			if (!Validation.isNullOrEmpty(resources)) {
				// Preparación del objeto de transporte de respuesta
				LoginOutDTO outDTO = new LoginOutDTO();
				outDTO.setAuthenticatedUserDTO(Converter.convertAuthenticatedUser(usuarioAuthDTO));
				outDTO.setCompanyName(usuarioAuthDTO.getInfoAportanteDTO().getNombre());
				UsuarioVO userVO = usuarioAuthDTO.getUsuarioVO();
				StringBuilder sbUsername = new StringBuilder(userVO.getNombre1() + Constants.SPACE);
				if (!Validation.isNullOrEmpty(userVO.getNombre2())) {
					sbUsername.append(userVO.getNombre2() + Constants.SPACE);
				}
				sbUsername.append(userVO.getApellido1());
				if (!Validation.isNullOrEmpty(userVO.getApellido2())) {
					sbUsername.append(Constants.SPACE + userVO.getApellido2());
				}
				outDTO.setUserName(sbUsername.toString());
				// se obtienen los permisos del usuario
				outDTO.getUserPermissions().addAll(
						getPermissionsByRole(resources.get(NumberConstants.ZERO).getIdSegAplicacion()));
				GenerateTokenOutDTO tokenDTO = generateToken(loginInDTO.getContributorIdNumber());
				if (CodeErrorEnum.SUCCESSFULL.getCode().equals(tokenDTO.getCode())) {
					outDTO.setSoiAccountIdNumber(Long.toString(usuarioAuthDTO.getUsuarioVO().getIdSegUsuario()));
					outDTO.setSoiContributorIdNumber(Long.toString(usuarioAuthDTO.getInfoAportanteDTO()
							.getIdSoiAportante()));
					outDTO.setToken(tokenDTO.getData().getToken());
					outDTO.setCode(CodeErrorEnum.SUCCESSFULL.getCode());
					outDTO.setMessage(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.SUCCESSFULL
							.getDescription()));
					LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
							+ "co.swatit.pilawebservices.business.PilaBO.checkAuthorizationFromSOI");
					return outDTO;
				} else {
					throw new BusinessException(CodeErrorEnum.ERRORTOKENSERVICERESPONSE);
				}
			} else {
				throw new BusinessException(CodeErrorEnum.ERRORSEARCHWITHOUTRESULTS);
			}

		} catch (NamingException ex) {
			throw new BusinessException(CodeErrorEnum.ERRORCONNECTIONREFUSED, ex);
		} catch (ApplicationException e) {
			throw new BusinessException(CodeErrorEnum.ERRORINVALIDLOGINDATA, e);
		} finally {
			closeConnection(connection);
		}
	}

	/**
	 * 
	 * Método que realiza una invocación al servicio generador de tokens
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/01/2017
	 *
	 * @param user
	 *            , usuario que ha sido logueado ante la aplicación SOI
	 * @return {@link GenerateTokenOutDTO}, objeto de transporte con la respuesta del servicio
	 * @throws BusinessException
	 *             , en caso que suceda un error al momento del envío, respuesta o parseo de la información
	 */
	private static GenerateTokenOutDTO generateToken(String user) throws BusinessException {
		GenerateTokenOutDTO tokenDTO = null;
		try {
			GenerateTokenInDTO tokenWSParam = new GenerateTokenInDTO();
			tokenWSParam.setUser(user);
			tokenWSParam.setExpirationTime(PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP,
					"TOKEN_WS_EXPIRATION_TIME"));
			StringBuilder sbTokenWSURL = new StringBuilder(Constants.HTTP_PROTOCOL_URL_DECLARATION);
			sbTokenWSURL.append(PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP, "TOKEN_WS_HOST"));
			sbTokenWSURL.append(Constants.COLON
					+ PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP, "TOKEN_WS_PORT"));
			sbTokenWSURL.append(PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP, "TOKEN_WS_CREATE_PATH"));
			String tokenServiceResponse = ServiceRequestProvider.callPostWS(sbTokenWSURL.toString(), null,
					ParserUtils.INSTANCE.convertObjectToJSON(tokenWSParam), MediaType.APPLICATION_JSON);
			if (Validation.isNullOrEmpty(tokenServiceResponse)) {
				throw new BusinessException(CodeErrorEnum.ERRORTOKENSERVICERESPONSE);
			} else {
				tokenDTO = ParserUtils.INSTANCE.parseJSONToObject(tokenServiceResponse, GenerateTokenOutDTO.class);
			}
		} catch (JsonParseException e) {
			throw new BusinessException(CodeErrorEnum.ERRORTOKENSERVICERESPONSE, e);
		} catch (JsonMappingException e) {
			throw new BusinessException(CodeErrorEnum.ERRORTOKENSERVICERESPONSE, e);
		} catch (InvokeException e) {
			throw new BusinessException(CodeErrorEnum.ERRORTOKENSERVICECONNECTION, e);
		} catch (JsonProcessingException e) {
			throw new BusinessException(CodeErrorEnum.ERRORTOKENSERVICERESPONSE, e);
		} catch (IOException e) {
			throw new BusinessException(CodeErrorEnum.ERRORTOKENSERVICERESPONSE, e);
		}
		return tokenDTO;
	}

	/**
	 * Método utilizado para obtener los permisos que tiene asignado un rol
	 * 
	 * @autor SWAT-IT <br>
	 *        Cristian Camilo Londoño <br>
	 *        Email: clondono@swat-it.co <br>
	 * @date 13/01/2017
	 * @version 1.0
	 *
	 * @param idRole
	 *            {@link Integer} id del rol al que se le buscarán los permisos
	 * @return Lista de los permisos que tiene el rol
	 * @throws BusinessException
	 *             Excepción cuando no encuentra rol en el enum, cuando el idRole recibido es nulo o cuando no puede
	 *             cargar el archivo de propiedades.
	 */
	private static List<String> getPermissionsByRole(Integer idRole) throws BusinessException {
		/* Se valida que el parámetro idRole */
		if (idRole == null) {
			throw new BusinessException(CodeErrorEnum.ERRORIDROLENULLOREMPTY);
		}
		String role = Constants.EMPTY;
		/* Se recorre el enum de roles comparando el id */
		for (RoleEnum roleEnum : RoleEnum.values()) {
			if (roleEnum.getIdRole() == idRole.intValue()) {
				role = roleEnum.name();
				break;
			}
		}
		/* Se valida si se encontró un rol en el Enum */
		if (Validation.isNullOrEmpty(role)) {
			/* Se arroja la excepción al no encontrar rol en el Enum */
			throw new BusinessException(CodeErrorEnum.ERRORROLENOTFOUND);
		} else {
			/* Se obtienen los permisos del rol */
			String permissions = PropertyLoader.INSTANCE.getPropertyInternal(Constants.PERMISSIONS_PROPERTIES, role);
			/* Se valida la obtención de permisos */
			if (Validation.isNullOrEmpty(permissions)) {
				/* Se arroja excepción cuando no se puede cargar el archivo de propiedades */
				throw new BusinessException(CodeErrorEnum.ERRORPERMISSIONSPROPERTIESNOTFOUND);
			} else {
				/* Se crea la lista de role que se retornará */
				List<String> list = new ArrayList<String>();
				String[] permissionsList = permissions.split(Constants.COMMA);
				for (String string : permissionsList) {
					/* Se agrega el permiso a la lista de permisos */
					list.add(string);
				}
				/* Se retorna la lista de los permisos encontrados */
				return list;
			}
		}
	}

	/**
	 * 
	 * Método que consulta la configuración de la aplicación con SOI usando un archivo provisto por el usuario de la
	 * aplicación
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 16/02/2017
	 *
	 * @param inDTO
	 *            , objeto de transporte que conteiene los parámetros de entrada del servicio
	 * @return {@link GetValidationFileConfigOutDTO} objeto de transporte que contiene la configuración del archivo
	 *         obtenida desde SOI
	 * @throws {@link BusinessException} , en las siguientes situaciones:
	 *         <ul>
	 *         <li>La conexión con SOI no sea posible, esté mal configurada</li>
	 *         <li>Los datos ingresados son incorrectos
	 *         <li>Fallo al obtener respuesta del servicio de generación de tokens</li>
	 *         <li>No se puede obtener conexión con el servidor de generación de tokens</li>
	 *         <li>Alguno de los parámetros recibidos es nulo o vacío</li>
	 *         <li>Existe algún problema al momento de obtener los permisos del usuario</li>
	 *         </ul>
	 */
	public static GetValidationFileConfigOutDTO getValidationFileConfig(GetValidationFileConfigInDTO inDTO)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilawebservices.business.getValidationFileConfig");
		GetValidationFileConfigOutDTO configOutDTO = new GetValidationFileConfigOutDTO();
		Context connection = null;
		try {
			Validation.valideParamInteger(ServicesParamsConstants.ID_SEG_USUARIO, inDTO.getIdSegUsuario());
			Validation.valideParamInteger(ServicesParamsConstants.ID_SOI_APORTANTE, inDTO.getIdSoiAportante());
			Validation.validateParam(ServicesParamsConstants.TOKEN, inDTO.getToken());
			Validation.validateParam(ServicesParamsConstants.REG_TP_01, inDTO.getRegTp01());
			ValidateTokenInDTO token = new ValidateTokenInDTO();
			token.setToken(inDTO.getToken());
			if (CodeErrorEnum.SUCCESSFULL.getCode().equals(validateToken(token).getCode())) {
				connection = connectFileValidatorServer();
				AdminProcesarCargaArchivosSvc bean = (AdminProcesarCargaArchivosSvc) connection
						.lookup(PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP,
								"CONFIGURATION_CONNECTION_CLASS"));
				// Se obtiene la planilla por parte de SOI y se convierte
				PlanillaRegT01 planillaRegT01 = ApplicationConfiguration.buildPlanillaRegT01(inDTO.getRegTp01());
				com.ach.pla.biz.transfer.PlanillaAportanteDTO planillaSOI = bean
						.getPlanillaAportanteDTOFromRegT01(planillaRegT01, Long.valueOf(inDTO.getIdSoiAportante()),
								Long.valueOf(inDTO.getIdSegUsuario()));
				PlanillaAportanteDTO planillaAportanteDTO = Converter.convertPlanillaAportante(planillaSOI);
				planillaAportanteDTO.setAportanteLey1607(inDTO.isReforma());
				planillaSOI.setAportanteLey1607(inDTO.isReforma());
				// Se obtiene el objeto ArchivoEnProcesoDTO convertido y se pone en el objeto de respuesta
				configOutDTO.setArchivoEnProcesoDTO(ApplicationConfiguration.buildArchivoEnProceso(
						planillaAportanteDTO, planillaRegT01));
				AdminProcesarCargaArchivosSvc adminProcesarCargaArchivosSvc = (AdminProcesarCargaArchivosSvc) connection
						.lookup(PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP,
								"FILE_LOAD_CONNECTION_CLASS"));
				configOutDTO.setValidacionArchivoDataSourceDTO(Converter.convertValidacionArchivoDataSource(
						adminProcesarCargaArchivosSvc.obtenerConfiguracionParaValidacionArchivoPlano(planillaSOI),
						planillaSOI));
				configOutDTO.setCode(CodeErrorEnum.SUCCESSFULL.getCode());
				configOutDTO.setMessage(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.SUCCESSFULL
						.getDescription()));
			} else {
				throw new BusinessException(CodeErrorEnum.ERRORTOKENNOTAUTHORIZED);
			}
		} catch (NamingException ex) {
			throw new BusinessException(CodeErrorEnum.ERRORCONNECTIONREFUSED, ex);
		} catch (NumberFormatException e) {
			throw new BusinessException(CodeErrorEnum.ERRORINTEGERFIELD, e);
		} catch (ApplicationException e) {
			throw new BusinessException(CodeErrorEnum.ERRORUNEXPECTED, e);
		} catch (EJBException ex) {
			throw new BusinessException(CodeErrorEnum.ERRORUNEXPECTED, ex);
		} finally {
			closeConnection(connection);
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilawebservices.business.getValidationFileConfig");
		return configOutDTO;
	}

	/**
	 * Método que valida un token ingresado
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 15/02/2017
	 * @version 1.0
	 * 
	 * @param token
	 *            , token a ser validado
	 * @return {@link ResponseDTO} que contiene el código que el servicio retorna: 00, exitoso; 35, errorValidación
	 * @throws BusinessException
	 *             , en caso que suceda un error al momento del envío, respuesta o parseo de la información
	 */
	/**
	 * 
	 * Método que invoca al servicio validador publicado por el administrador de tokens y retorna su resultado como
	 * respuesta del servicio
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 27/02/2017
	 * @version 2.0
	 * 
	 * @param inDTO
	 *            , objeto de transporte que contiene un token a ser validado
	 * @return {@link ResponseDTO} con los datos de la respuesta del servicio
	 * @throws BusinessException
	 *             , en caso que suceda un error al momento del envío, respuesta o parseo de la información
	 */
	public static ResponseDTO validateToken(ValidateTokenInDTO inDTO) throws BusinessException {
		ResponseDTO validationResult = null;
		try {
			Validation.validateParam(ServicesParamsConstants.TOKEN, inDTO.getToken());
			StringBuilder sbTokenWSURL = new StringBuilder(Constants.HTTP_PROTOCOL_URL_DECLARATION);
			sbTokenWSURL.append(PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP, "TOKEN_WS_HOST"));
			sbTokenWSURL.append(Constants.COLON
					+ PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP, "TOKEN_WS_PORT"));
			sbTokenWSURL.append(PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP, "TOKEN_WS_VALIDATE_PATH"));
			String tokenServiceResponse = ServiceRequestProvider.callPostWS(sbTokenWSURL.toString(), null,
					ParserUtils.INSTANCE.convertObjectToJSON(inDTO), MediaType.APPLICATION_JSON);
			if (Validation.isNullOrEmpty(tokenServiceResponse)) {
				throw new BusinessException(CodeErrorEnum.ERRORTOKENSERVICERESPONSE);
			} else {
				validationResult = ParserUtils.INSTANCE.parseJSONToObject(tokenServiceResponse, ResponseDTO.class);
				validationResult.setMessage(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.getEnum(
						validationResult.getCode()).getDescription()));
			}
		} catch (JsonParseException e) {
			throw new BusinessException(CodeErrorEnum.ERRORTOKENSERVICERESPONSE, e);
		} catch (JsonMappingException e) {
			throw new BusinessException(CodeErrorEnum.ERRORTOKENSERVICERESPONSE, e);
		} catch (InvokeException e) {
			throw new BusinessException(CodeErrorEnum.ERRORTOKENSERVICECONNECTION, e);
		} catch (JsonProcessingException e) {
			throw new BusinessException(CodeErrorEnum.ERRORTOKENSERVICERESPONSE, e);
		} catch (IOException e) {
			throw new BusinessException(CodeErrorEnum.ERRORTOKENSERVICERESPONSE, e);
		}
		return validationResult;
	}

	/**
	 * 
	 * Método que obtiene las últimas planillas por parte de SOI, las convierte en objetos de transporte de tipo
	 * {@link PayrollDetailDTO} y las lista en un objeto de tipo {@link GetFilteredPayrollsOutDTO} para producir una
	 * respuesta
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 9/03/2017
	 *
	 * @param inDTO
	 *            , {@link GetFilteredPayrollsInDTO} con los parámetros del servicio
	 * @return
	 * @throws {@link BusinessException} , en las siguientes situaciones:
	 *         <ul>
	 *         <li>La conexión con SOI no sea posible, esté mal configurada</li>
	 *         <li>Los datos ingresados son incorrectos
	 *         <li>Fallo al obtener respuesta del ejb provisto por SOI</li>
	 *         <li>Alguno de los parámetros recibidos es nulo o vacío</li>
	 *         <li>La validación del token no es exitosa</li>
	 *         </ul>
	 */
	public static GetFilteredPayrollsOutDTO getFilteredPayrolls(GetFilteredPayrollsInDTO inDTO)
			throws BusinessException {
		GetFilteredPayrollsOutDTO response = new GetFilteredPayrollsOutDTO();
		Context connection = null;
		try {
			Validation.validateParam(ServicesParamsConstants.TOKEN, inDTO.getToken());
			Validation.valideParamInteger(ServicesParamsConstants.ID_SEG_USUARIO, inDTO.getIdSegUsuario());
			Validation.valideParamInteger(ServicesParamsConstants.ID_SOI_APORTANTE, inDTO.getIdSoiAportante());
			String numPagina = inDTO.getNumPagina();
			String numRegistros = inDTO.getNumRegistros();
			if (Validation.isNullOrEmpty(numPagina)) {
				numPagina = PropertyLoader.INSTANCE
						.getProperty(Constants.GLOBAL_PROP, "FILTERED_PAYROLLS_PAGE_NUMBER");
			} else {
				Validation.valideParamInteger(ServicesParamsConstants.NUM_PAGINA, numPagina);
			}
			if (Validation.isNullOrEmpty(numRegistros)) {
				numRegistros = PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP,
						"FILTERED_PAYROLLS_RECORDS_QUANTITY");
			} else {
				Validation.valideParamInteger(ServicesParamsConstants.NUM_REGISTROS, numRegistros);
			}
			ValidateTokenInDTO token = new ValidateTokenInDTO();
			token.setToken(inDTO.getToken());
			if (CodeErrorEnum.SUCCESSFULL.getCode().equals(validateToken(token).getCode())) {
				connection = connect();
				PlanillaConsultaSvc planillaBean = (PlanillaConsultaSvc) connection.lookup(PropertyLoader.INSTANCE
						.getProperty(Constants.GLOBAL_PROP, "GET_FILTERED_PAYROLLS_CONNECTION_CLASS"));
				ConsultarPlanillaFilterDTO consultarPlanillaFilterDTO = new ConsultarPlanillaFilterDTO();
				consultarPlanillaFilterDTO.setEstadoPlanilla(EstadoPlanillaType.PAGADA);
				consultarPlanillaFilterDTO.setIdSoiAportante(Long.valueOf(inDTO.getIdSoiAportante()));
				consultarPlanillaFilterDTO.setIdSegUsuario(Long.valueOf(inDTO.getIdSegUsuario()));
				PagedTableDTO<PlanillaConsultadaListadoDTO> ejbResponse = planillaBean.consultarListadoPlanilla(
						consultarPlanillaFilterDTO, Integer.valueOf(numPagina), Integer.valueOf(numRegistros));
				for (PlanillaConsultadaListadoDTO data : ejbResponse) {
					response.getListFilteredPayrollsDetails().add(Converter.convertPayrollDetail(data));
				}
				response.setCode(CodeErrorEnum.SUCCESSFULL.getCode());
				response.setMessage(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.SUCCESSFULL
						.getDescription()));
			} else {
				throw new BusinessException(CodeErrorEnum.ERRORTOKENNOTAUTHORIZED);
			}
		} catch (NamingException e) {
			throw new BusinessException(CodeErrorEnum.ERRORCONNECTIONREFUSED, e);
		} catch (ApplicationException e) {
			throw new BusinessException(CodeErrorEnum.ERRORUNEXPECTED, e);
		} finally {
			closeConnection(connection);
		}
		return response;
	}

	/**
	 * 
	 * Método que obtiene las notificaciones para un cliente en específico según la versión de la aplicación con la que
	 * cuenta
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 13/03/2017
	 *
	 * @param inDTO
	 *            , objeto de transporte que contiene los parámetros del servicio
	 * @return {@link GetNotificationsOutDTO} con las notificaciones que se le mostrarán al usuario
	 * @throws BusinessException
	 *             en caso que exista un error con la validación del token, o la versión ingresada no sea correcta
	 */
	public static GetNotificationsOutDTO getNotifications(GetNotificationsInDTO inDTO) throws BusinessException {
		GetNotificationsOutDTO response = new GetNotificationsOutDTO();
		Validation.validateParam(ServicesParamsConstants.APPLICATION_VERSION, inDTO.getVersion());
		if (Validation.isVersionNumber(inDTO.getVersion())) {
			ValidateTokenInDTO token = new ValidateTokenInDTO();
			token.setToken(inDTO.getToken());
			if (CodeErrorEnum.SUCCESSFULL.getCode().equals(validateToken(token).getCode())) {
				// se obtiene la implementación
				INotificationLoader notificationLoader = NotificationFactory
						.createImplementation(PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP,
								"NOTIFICATION_LOADER_IMPLEMENTATION"));
				response.getNotificationDetails().addAll(notificationLoader.getNotifications(inDTO.getVersion()));
				response.setCode(CodeErrorEnum.SUCCESSFULL.getCode());
				response.setMessage(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.SUCCESSFULL
						.getDescription()));
			} else {
				throw new BusinessException(CodeErrorEnum.ERRORTOKENNOTAUTHORIZED);
			}
		} else {
			throw new BusinessException(CodeErrorEnum.ERRORCLIENTVERSIONNUMBER, inDTO.getVersion(),
					Constants.APPLICATION_VERSION_EXAMPLE);
		}
		return response;
	}

	/**
	 * 
	 *
	 * Método que obtiene información de la planilla de un aportante a partir del número de la planilla
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 3/04/2017
	 *
	 * @param inDTO
	 *            , objeto de transporte que contiene los parámetros del servicio
	 * @return {@link GetPayrollHeaderOutDTO} con la información obtenida por parte de SOI
	 * 
	 * @throws {@link BusinessException} , en las siguientes situaciones:
	 *         <ul>
	 *         <li>La conexión con SOI no sea posible, esté mal configurada</li>
	 *         <li>Los datos ingresados son incorrectos</li>
	 *         <li>Fallo al obtener respuesta del ejb provisto por SOI</li>
	 *         <li>Alguno de los parámetros recibidos es nulo o vacío</li>
	 *         <li>La validación del token no es exitosa</li>
	 *         </ul>
	 */
	public static GetPayrollHeaderOutDTO getPayrollHeader(GetPayrollHeaderInDTO inDTO) throws BusinessException {
		GetPayrollHeaderOutDTO response = new GetPayrollHeaderOutDTO();
		Context connection = null;
		Validation.valideParamInteger(ServicesParamsConstants.NUM_PLANILLA, inDTO.getNumeroPlanilla());
		ValidateTokenInDTO token = new ValidateTokenInDTO();
		token.setToken(inDTO.getToken());
		try {
			if (CodeErrorEnum.SUCCESSFULL.getCode().equals(validateToken(token).getCode())) {
				// Se realiza la conexión
				connection = connect();
				PlanillaConsultaSvc planillaConsulta = (PlanillaConsultaSvc) connection.lookup(PropertyLoader.INSTANCE
						.getProperty(Constants.GLOBAL_PROP, "GET_PAYROLL_INFORMATION_CONNECTION_CLASS"));
				ConsultarPlanillaFilterDTO consultarPlanillaFilterDTO = new ConsultarPlanillaFilterDTO();
				consultarPlanillaFilterDTO.setEstadoPlanilla(EstadoPlanillaType.PAGADA);
				consultarPlanillaFilterDTO.setOrigenSoportesPago(Boolean.TRUE);
				consultarPlanillaFilterDTO.setNumeroPlanilla(inDTO.getNumeroPlanilla());
				//se agrega el idAportante
				consultarPlanillaFilterDTO.setIdSoiAportante(inDTO.getIdAportante());
				consultarPlanillaFilterDTO.setIdSegUsuario(inDTO.getIdSegUsuario());
				PagedTableDTO<PlanillaConsultadaListadoDTO> ejbResponse = planillaConsulta.consultarListadoPlanilla(
						consultarPlanillaFilterDTO, NumberConstants.ONE, NumberConstants.ONE);
				if (ejbResponse.size() < NumberConstants.ONE) {
					throw new BusinessException(CodeErrorEnum.ERRORSEARCHWITHOUTRESULTS);
				}
				PlanillaAportanteDTO planillaAportante = Converter.convertPlanillaAportante(planillaConsulta
						.consultarPlanillaAportanteDTOPorIdPlanilla(ejbResponse.get(NumberConstants.ZERO)
								.getIdSoiPlanilla()));
				// Se inicializan los atributos del objeto de respuesta
				response.setPlanillaAportanteDTO(planillaAportante);
				String fechaPago = planillaAportante.getFechaDePagoEfectiva();
				if (Validation.isNotNull(fechaPago) && Validation.isNotEmpty(fechaPago)) {
					StringBuilder builder = new StringBuilder();
					builder.append(fechaPago.substring(NumberConstants.SIX));
					builder.append(Constants.SLASH);
					builder.append(fechaPago.substring(NumberConstants.FOUR, NumberConstants.SIX));
					builder.append(Constants.SLASH);
					builder.append(fechaPago.substring(NumberConstants.ZERO, NumberConstants.FOUR));
					response.setFechaPago(builder.toString());
				}
				response.setTipoPlanilla(planillaAportante.getNombreSoiTpPlanilla());
				Long totalEmpleados = planillaAportante.getNumeroTotalEmpleados();
				if (Validation.isNotNull(totalEmpleados)) {
					response.setCantidadEmpleados(totalEmpleados.toString());
				}
				response.setSucursal(planillaAportante.getNombreSucursal());
				response.setPeriodoLiquidacionPensiones(planillaAportante.getPeriodoLiquidacionNoSalud());
				response.setPeriodoLiquidacionSalud(planillaAportante.getPeriodoLiquidacionSalud());
				response.setCode(CodeErrorEnum.SUCCESSFULL.getCode());
				response.setMessage(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.SUCCESSFULL
						.getDescription()));
			} else {
				throw new BusinessException(CodeErrorEnum.ERRORTOKENNOTAUTHORIZED);
			}
		} catch (NamingException e) {
			throw new BusinessException(CodeErrorEnum.ERRORCONNECTIONREFUSED, e);
		} catch (ApplicationException e) {
			throw new BusinessException(CodeErrorEnum.ERRORUNEXPECTED, e);
		} finally {
			closeConnection(connection);
		}
		return response;
	}

	/**
	 * Método que obtiene los aportantes de una planilla según su número de identificación
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 4/04/2017
	 *
	 * @param inDTO
	 *            , objeto de transporte que contiene los parámetros del servicio
	 * @return {@link GetPayrollContributorsOutDTO} con la información obtenida por parte de SOI
	 * 
	 * @throws {@link BusinessException} , en las siguientes situaciones:
	 *         <ul>
	 *         <li>La conexión con SOI no sea posible, esté mal configurada</li>
	 *         <li>Los datos ingresados son incorrectos</li>
	 *         <li>Fallo al obtener respuesta del ejb provisto por SOI</li>
	 *         <li>Alguno de los parámetros recibidos es nulo o vacío</li>
	 *         <li>La validación del token no es exitosa</li>
	 *         </ul>
	 */
	public static GetPayrollContributorsOutDTO getPayrollContributors(GetPayrollContributorsInDTO inDTO)
			throws BusinessException {
		GetPayrollContributorsOutDTO response = new GetPayrollContributorsOutDTO();
		Context connection = null;
		Validation.valideParamInteger(ServicesParamsConstants.NUM_PLANILLA, inDTO.getNumeroPlanilla());
		ValidateTokenInDTO token = new ValidateTokenInDTO();
		token.setToken(inDTO.getToken());
		try {
			if (CodeErrorEnum.SUCCESSFULL.getCode().equals(validateToken(token).getCode())) {
				connection = connect();
				PlanillaConsultaSvc planillaConsulta = (PlanillaConsultaSvc) connection.lookup(PropertyLoader.INSTANCE
						.getProperty(Constants.GLOBAL_PROP, "GET_PAYROLL_INFORMATION_CONNECTION_CLASS"));
				ConsultarPlanillaFilterDTO consultarPlanillaFilterDTO = new ConsultarPlanillaFilterDTO();
				consultarPlanillaFilterDTO.setEstadoPlanilla(EstadoPlanillaType.PAGADA);
				consultarPlanillaFilterDTO.setOrigenSoportesPago(Boolean.TRUE);
				consultarPlanillaFilterDTO.setNumeroPlanilla(inDTO.getNumeroPlanilla());
				consultarPlanillaFilterDTO.setIdSegUsuario(inDTO.getIdSegUsuario());
				consultarPlanillaFilterDTO.setIdSoiAportante(inDTO.getIdSoiAportante());
				PagedTableDTO<PlanillaConsultadaListadoDTO> ejbResponse = planillaConsulta.consultarListadoPlanilla(
						consultarPlanillaFilterDTO, NumberConstants.ONE, NumberConstants.ONE);
				if (ejbResponse.size() < NumberConstants.ONE) {
					throw new BusinessException(CodeErrorEnum.ERRORSEARCHWITHOUTRESULTS);
				}
				Long idPlanilla = Long.valueOf(ejbResponse.get(NumberConstants.ZERO).getIdSoiPlanilla());
				// Se obtiene la cantidad de aportantes de la planilla
				Long cantidadCotizantes = planillaConsulta.consultarCantidadDeCotizantes(idPlanilla);
				if (NumberConstants.ZERO == cantidadCotizantes) {
					throw new BusinessException(CodeErrorEnum.ERRORSEARCHWITHOUTRESULTS);
				}
				// Se obtienen los aportantes de la planilla
				Collection<InformacionBasicaCotizanteDTO> aportantes = planillaConsulta
						.consultarInformacionBasicaCotizantesPorPlanilla(idPlanilla, NumberConstants.ONE,
								cantidadCotizantes.intValue());
				for (InformacionBasicaCotizanteDTO infoBasica : aportantes) {
					response.getPayrollContributors().add(Converter.convertPayrollContributor(infoBasica));
				}
				response.setCode(CodeErrorEnum.SUCCESSFULL.getCode());
				response.setMessage(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.SUCCESSFULL
						.getDescription()));
			} else {
				throw new BusinessException(CodeErrorEnum.ERRORTOKENNOTAUTHORIZED);
			}
		} catch (NamingException e) {
			throw new BusinessException(CodeErrorEnum.ERRORCONNECTIONREFUSED, e);
		} catch (ApplicationException e) {
			throw new BusinessException(CodeErrorEnum.ERRORUNEXPECTED, e);
		} finally {
			closeConnection(connection);
		}
		return response;
	}

	/**
	 * 
	 * Método que obtiene la información de un listado de cotizantes según su id, este servicio hace parte de la
	 * funcionalidad de soporte de pago, provee la información para enviar los emails a los aportantes.
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 10/04/2017
	 *
	 * @param inDTO
	 *            , objeto de transporte que contiene los parámetros del servicio
	 * @return {@link GetContributorsInformationOutDTO} con la información obtenida por parte de SOI
	 * @throws BusinessException
	 *             {@link BusinessException} , en las siguientes situaciones:
	 *             <ul>
	 *             <li>La conexión con SOI no sea posible, esté mal configurada</li>
	 *             <li>Los datos ingresados son incorrectos</li>
	 *             <li>Fallo al obtener respuesta del ejb provisto por SOI</li>
	 *             <li>Alguno de los parámetros recibidos es nulo o vacío</li>
	 *             <li>La validación del token no es exitosa</li>
	 *             <li>La conversión de un objeto SOI no fué realizada correctamente</li>
	 *             </ul>
	 */
	public static GetContributorsInformationOutDTO getContributorsInformation(GetContributorsInformationInDTO inDTO)
			throws BusinessException {
		Validation.validateParam(ServicesParamsConstants.CONTRIBUTOR_IDENTIFICATION_LIST, inDTO.getContributorsIds());
		GetContributorsInformationOutDTO response = new GetContributorsInformationOutDTO();
		Context connection = null;
		ValidateTokenInDTO token = new ValidateTokenInDTO();
		token.setToken(inDTO.getToken());
		try {
			if (CodeErrorEnum.SUCCESSFULL.getCode().equals(validateToken(token).getCode())) {
				connection = connect();
				PlanillaConsultaSvc planillaConsulta = (PlanillaConsultaSvc) connection.lookup(PropertyLoader.INSTANCE
						.getProperty(Constants.GLOBAL_PROP, "GET_PAYROLL_INFORMATION_CONNECTION_CLASS"));
				ArrayList<Long> idsAportantes = getContributorsIds(inDTO.getContributorsIds());
				Collection<com.ach.pla.biz.transfer.PlanillaCotizanteDTO> infoCotizantes = planillaConsulta
						.consultarListaPlanillaCotizante(idsAportantes);
				for (com.ach.pla.biz.transfer.PlanillaCotizanteDTO ejbOutput : infoCotizantes) {
					response.getContributorPayrolls().add(Converter.convertPlanillaCotizante(ejbOutput));
					idsAportantes.remove(ejbOutput.getIdSoiCotizante());
				}
				response.getContributorsNotFound().addAll(idsAportantes);
				response.setCode(CodeErrorEnum.SUCCESSFULL.getCode());
				response.setMessage(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.SUCCESSFULL
						.getDescription()));
			} else {
				throw new BusinessException(CodeErrorEnum.ERRORTOKENNOTAUTHORIZED);
			}
		} catch (NamingException e) {
			throw new BusinessException(CodeErrorEnum.ERRORCONNECTIONREFUSED, e);
		} catch (ApplicationException e) {
			throw new BusinessException(CodeErrorEnum.ERRORUNEXPECTED, e);
		} finally {
			closeConnection(connection);
		}
		return response;
	}

	/**
	 * Método que valida los ids de los aportantes y los convierte en objetos de tipo Long
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 10/04/2017
	 *
	 * @param contributorsIds
	 *            , Lista con los ids de los cotizantes a ser validada
	 * @return {@link ArrayList} con los ids de cotizantes obtenidos
	 * @throws BusinessException
	 *             {@link BusinessException} , en las siguientes situaciones:
	 *             <ul>
	 *             <li>Algún id ingresado es incorrecto</li>
	 *             </ul>
	 */
	private static ArrayList<Long> getContributorsIds(List<String> contributorsIds) throws BusinessException {
		ArrayList<Long> cotizantes = new ArrayList<Long>();
		for (String idCotizante : contributorsIds) {
			if (Validation.isInteger(idCotizante)) {
				cotizantes.add(Long.valueOf(idCotizante));
			} else {
				throw new BusinessException(CodeErrorEnum.ERRORINVALIDIDENTIFICATIONNUMBER, idCotizante);
			}
		}
		return cotizantes;
	}
	
	
	/**
	 * Metodo que descomprime una planilla y lo encola para su procesamiento.
	 * 
	 * @param inDTO Información de la planilla a procesar.
	 * @return La información de la planilla que se esta procesando.
	 * @throws BusinessException
	 */
	public static GetValidateFileOutDTO validateFile(GetValidateFileInDTO inDTO)
			throws BusinessException {
		GetValidateFileOutDTO response = new GetValidateFileOutDTO();
		Context connection = null;
		String nombreArchivo = null;
		ArchivoNotificacionDTO archivoNotificacionDTO = new ArchivoNotificacionDTO();
		try {

			Validation.validateParam(ServicesParamsConstants.FILE_NAME_ZIP, inDTO.getFileNameZip());
			Validation.validateParam(ServicesParamsConstants.FILE_ZIP, inDTO.getFileZip());
			
			// Se realiza la conexión con el servidor SOI
			connection = connect();
			AdminProcesarCargaArchivosSvc bean = (AdminProcesarCargaArchivosSvc) connection
					.lookup(PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP,
							"CONFIGURATION_CONNECTION_CLASS"));
			
			String tmpPath = PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP, "PATH_FILE_TMP");
			String rutaArchivoZip = tmpPath + File.separator + inDTO.getFileNameZip();
			
			LOGGER.info("Contenido Zip: "+inDTO.getFileZip());
			FileUtilities.write(rutaArchivoZip, inDTO.getFileZip());
			LOGGER.info("Escribio archivo ZIP en: "+rutaArchivoZip);
			FileUtilities.unzipFile(rutaArchivoZip, tmpPath);
			LOGGER.info("descomprimio archivo ZIP en: "+tmpPath);			
			nombreArchivo = FileUtilities.copyGetFile(inDTO.getFileName(), FileUtilities.readZipFile(tmpPath+File.separator+inDTO.getFileName()));
			LOGGER.info("copio archivo: "+nombreArchivo);
			
			archivoNotificacionDTO.setAportanteLey1429(inDTO.isAportanteLey1429());
			archivoNotificacionDTO.setNombreArchivo(nombreArchivo);
			archivoNotificacionDTO.setIdSegUsuario(inDTO.getIdSegUsuario());
			archivoNotificacionDTO.setNumeroTotalDeEmpleadosPorPantalla(inDTO.getNumeroTotalDeEmpleadosPorPantalla());
			archivoNotificacionDTO.setIdAportante(inDTO.getIdAportante());
			archivoNotificacionDTO.setAportanteLey1607(inDTO.isAportanteLey1607());
			archivoNotificacionDTO.setIdSoiTpPlanilla(inDTO.getIdSoiTpPlanilla());
			
			ArchivoNotificacionResultadoDTO archivoNotificacionResultadoDTO = bean.notificarNuevoProcesoValidaryGuardarArchivo(archivoNotificacionDTO);
			
			if (archivoNotificacionResultadoDTO.getAppExList() == null) {
				archivoNotificacionDTO.setNotificacionDeArchivoEnProcesoType(NotificacionDeArchivoEnProcesoType.SOBREESCRIBIR_NOTIFICACION);
				archivoNotificacionDTO.setUsuarioAceptaSobreescribirPlanilla(true);
				archivoNotificacionResultadoDTO = bean.notificarNuevoProcesoValidaryGuardarArchivo(archivoNotificacionDTO);
			}
			
			
			Collection<String> errores = new ArrayList<String>();
			
			if (archivoNotificacionResultadoDTO.getAppExList() != null) {
				ApplicationException app = archivoNotificacionResultadoDTO.getAppExList();
				for (ApplicationException excepcion : app.getAppExceptionSet()) {
					errores.add(String.valueOf(excepcion.getCodigo()));
				}
				response.setErrores(errores);
			}
			
			if (archivoNotificacionResultadoDTO.getAppExArchivoAdvertenciaCertificaCalculoInteresesMora() != null) {
				ApplicationException app = archivoNotificacionResultadoDTO.getAppExArchivoAdvertenciaCertificaCalculoInteresesMora();
				errores.add(String.valueOf(app.getCodigo()));
				response.setErrores(errores);
			}
			
			if (archivoNotificacionResultadoDTO.getAppExArchivoAdvertenciaParaPublicasPlanillaRetroactivos() != null) {
				ApplicationException app = archivoNotificacionResultadoDTO.getAppExArchivoAdvertenciaParaPublicasPlanillaRetroactivos();
				errores.add(String.valueOf(app.getCodigo()));
				response.setErrores(errores);
			}
			
			if (archivoNotificacionResultadoDTO.getAppExArchivoAdvertenciaPlanillaReferidaNoEncontrada() != null) {
				ApplicationException app = archivoNotificacionResultadoDTO.getAppExArchivoAdvertenciaPlanillaReferidaNoEncontrada();
				errores.add(String.valueOf(app.getCodigo()));
				response.setErrores(errores);
			}
			
			if (archivoNotificacionResultadoDTO.getAppExArchivoAdvertenciaPlanillaRepetida() != null) {
				ApplicationException app = archivoNotificacionResultadoDTO.getAppExArchivoAdvertenciaPlanillaRepetida();
				errores.add(String.valueOf(app.getCodigo()));
				response.setErrores(errores);
			}
			
			response.setCodTipoPlanilla(archivoNotificacionResultadoDTO.getArchivoNotificacionDTO().getCodTipoPlanilla());
			response.setIdArchivoEnProceso(archivoNotificacionResultadoDTO.getArchivoNotificacionDTO().getIdArchivoEnProceso());
			response.setIdSoiTpPlanilla(archivoNotificacionResultadoDTO.getArchivoNotificacionDTO().getIdSoiTpPlanilla());
			
		} catch (NamingException e) {
			throw new BusinessException(CodeErrorEnum.ERRORCONNECTIONREFUSED, e);
		} catch (ApplicationException e) {
			throw new BusinessException(CodeErrorEnum.ERRORUNEXPECTED, e);
		} finally {
			closeConnection(connection);
		}
		return response;
	}
	
	
	public static GetConsultFileOutDTO consultFile(Long idFile) throws BusinessException {
		GetConsultFileOutDTO response = new GetConsultFileOutDTO();
		ArchivoEnProcesoConsultaDTO archivoEnProcesoConsultaDTO = new ArchivoEnProcesoConsultaDTO();
		Context connection = null;
		
		try {
			LOGGER.info("Inicia consulta de estado de archivo: "+idFile);
			// Se realiza la conexión con el servidor SOI
			connection = connect();
			archivoEnProcesoConsultaDTO.setIdArchivoEnProceso(idFile);
			AdminProcesarCargaArchivosSvc bean = (AdminProcesarCargaArchivosSvc) connection
					.lookup(PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP,
							"CONFIGURATION_CONNECTION_CLASS"));
			
			archivoEnProcesoConsultaDTO = bean.consultarProcesoValidarYGuardarArchivo(archivoEnProcesoConsultaDTO);
			response = VOBuilder.armarArchivoResponse(archivoEnProcesoConsultaDTO);
			
			LOGGER.info("Finaliza consulta de estado de archivo, BDUA: "+response.getRutaArchivoErrores());
			String filePath = FileUtilities.createDir(PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP, "PATH_FILE"));
			if ( response.getNombreArchivoError()!=null && !response.getNombreArchivoError().trim().equals("") ){
				byte[] archivoError = FileUtilities.readZipFile(filePath+File.separator+response.getNombreArchivoError());
				response.setArchivoError(archivoError);
			}
			LOGGER.info("Finaliza consulta de estado de archivo, RUAF: "+response.getRutaArchivoErroresAf());
			//TODO
//			FileUtilities.write("/tmp/archivoError.xls", archivoError);
//			System.out.println(filePath + "/" + response.getNombreArchivoError() + ", archivo[" + archivoError +"]" );
			
			if ( response.getNombreArchivoErrorAsofondo()!=null && !response.getNombreArchivoErrorAsofondo().trim().equals("") ){
				byte[] archivoErrorAsofondo = FileUtilities.readZipFile(filePath+File.separator+response.getNombreArchivoErrorAsofondo());
				response.setArchivoErrorAsofondo(archivoErrorAsofondo);
			}
			//TODO
//			FileUtilities.write("/tmp/archivoErrorAsofondo.xls", archivoErrorAsofondo);
//			System.out.println(filePath +  "/" + response.getNombreArchivoErrorAsofondo() + ", archivo[" + archivoErrorAsofondo +"]");
			LOGGER.info("Finaliza consulta de estado de archivo, estado: "+response.getEstado());
			
		} catch (NamingException e) {
			throw new BusinessException(CodeErrorEnum.ERRORCONNECTIONREFUSED, e);
		} catch (ApplicationException e) {
			throw new BusinessException(CodeErrorEnum.ERRORUNEXPECTED, e);
		} finally {
			closeConnection(connection);
		}
		
		return response;
	}
	
	
	public static GetConsultPayrollOutDTO consultPayroll(Long idSheet) throws BusinessException {
		GetConsultPayrollOutDTO response = new GetConsultPayrollOutDTO();
		Context connection = null;
		
		try {
			// Se realiza la conexión con el servidor SOI
			connection = connect();
			
			PlanillaRegistroConsultaTempArchivosSvc bean = (PlanillaRegistroConsultaTempArchivosSvc) connection
					.lookup(PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP,
							"CONSULT_PAYROLL_INFORMATION_CONNECTION_CLASS"));
			
			PlanillaConsultadaDTO planillaConsultadaDTO = bean.consultarPlanilla(idSheet);
			response = VOBuilder.arrmarPlanillaResponse(planillaConsultadaDTO);
		} catch (NamingException e) {
			throw new BusinessException(CodeErrorEnum.ERRORCONNECTIONREFUSED, e);
		} catch (ApplicationException e) {
			throw new BusinessException(CodeErrorEnum.ERRORUNEXPECTED, e);
		} finally {
			closeConnection(connection);
		}
		
		return response;
	}
	
	
	public static GetPutPayrollOutDTO putPayroll(GetPutPayrollInDTO getPutPayrollInDTO) throws BusinessException {
		GetPutPayrollOutDTO response = new GetPutPayrollOutDTO();
		Context connection = null;
		
		try {
			
			PlanillaConsultadaDTO planillaConsultadaDTO = VOBuilder.planillaResponseToPlanillaConsultada(getPutPayrollInDTO.getGetConsultPayrollOutDTO());
			ArchivoNotificacionDTO archivoNotificacionDTO = VOBuilder.armarArchivoNotificacion(getPutPayrollInDTO.getGetValidateFileOutDTO(), planillaConsultadaDTO);
			UsuarioAutenticadoDTO usuarioAutenticadoDTO = VOBuilder.armarUsuarioAutenticado(getPutPayrollInDTO.getGetUsuarioAutenticadoInDTO());
			
			archivoNotificacionDTO.setIdSoiPlanilla(getPutPayrollInDTO.getIdPlanilla());
			// Se realiza la conexión con el servidor SOI
			connection = connect();
			PlanillaRegistroConsultaTempArchivosSvc bean = (PlanillaRegistroConsultaTempArchivosSvc) connection
					.lookup(PropertyLoader.INSTANCE.getProperty(Constants.GLOBAL_PROP,
							"CONSULT_PAYROLL_INFORMATION_CONNECTION_CLASS"));
			
			PlanillaTotalesDTO planillaTotalesDTO = bean.consultarTotalesPlanilla(getPutPayrollInDTO.getIdPlanilla());
			
			archivoNotificacionDTO = bean.guardarPlanillaDefinitivaAportante(
					archivoNotificacionDTO,
					usuarioAutenticadoDTO,
					planillaTotalesDTO,
					planillaConsultadaDTO.getPeriodoNoSalud().getPeriodoPlanillaString(),
					planillaConsultadaDTO.getPeriodoSalud().getPeriodoPlanillaString(),
					getPutPayrollInDTO.getGetConsultPayrollOutDTO().getNombreFilial());
			
			response.setIdNumeroDePlanilla(archivoNotificacionDTO.getIdNumeroDePlanilla());
			response.setIdSoiPlanilla(archivoNotificacionDTO.getIdSoiPlanilla());
			
		} catch (NamingException e) {
			throw new BusinessException(CodeErrorEnum.ERRORCONNECTIONREFUSED, e);
		} catch (ApplicationException e) {
			throw new BusinessException(CodeErrorEnum.ERRORUNEXPECTED, e);
		} finally {
			closeConnection(connection);
		}
		
		return response;
	}
	
	
	
	public static GetPutPayrollOutDTO createPayroll(GetValidateFileInDTO getValidateFileInDTO) throws BusinessException {
		GetPutPayrollOutDTO response = null;
		GetPutPayrollInDTO getPutPayrollInDTO = new GetPutPayrollInDTO();
		GetValidateFileOutDTO getValidateFileOutDTO = validateFile(getValidateFileInDTO);
		GetConsultFileOutDTO getConsultFileOutDTO = consultFile(getValidateFileOutDTO.getIdArchivoEnProceso());
		while (getConsultFileOutDTO.getIdPlanilla() == 0) {
			FileUtilities.sleep();
			getConsultFileOutDTO = consultFile(getValidateFileOutDTO.getIdArchivoEnProceso());
		}
		System.out.println("Termino... idPlanilla[" +getConsultFileOutDTO.getIdPlanilla() + "]");
		GetConsultPayrollOutDTO getConsultPayrollOutDTO = consultPayroll(getValidateFileOutDTO.getIdArchivoEnProceso());
		getConsultPayrollOutDTO.setPeriodoNoSalud(getValidateFileInDTO.getPeriodoNoSalud());
		getConsultPayrollOutDTO.setPeriodoSalud(getValidateFileInDTO.getPeriodoSalud());
		getPutPayrollInDTO.setGetConsultPayrollOutDTO(getConsultPayrollOutDTO);
		getPutPayrollInDTO.setIdPlanilla(getConsultFileOutDTO.getIdPlanilla());
		response = putPayroll(getPutPayrollInDTO);
		
		return response;
	}
}

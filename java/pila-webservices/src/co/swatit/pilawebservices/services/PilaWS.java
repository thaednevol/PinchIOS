package co.swatit.pilawebservices.services;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import co.swatit.pilautil.constants.ServicesConstants;
import co.swatit.pilautil.dto.ResponseDTO;
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
import co.swatit.pilautil.dto.out.GetContributorsInformationOutDTO;
import co.swatit.pilautil.dto.out.GetFilteredPayrollsOutDTO;
import co.swatit.pilautil.dto.out.GetNotificationsOutDTO;
import co.swatit.pilautil.dto.out.GetPayrollContributorsOutDTO;
import co.swatit.pilautil.dto.out.GetPayrollHeaderOutDTO;
import co.swatit.pilautil.dto.out.GetPutPayrollOutDTO;
import co.swatit.pilautil.dto.out.GetValidateFileOutDTO;
import co.swatit.pilautil.dto.out.GetValidationFileConfigOutDTO;
import co.swatit.pilautil.dto.out.LoginOutDTO;
import co.swatit.pilautil.exception.BusinessException;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;
import co.swatit.pilautil.generics.Constants;
import co.swatit.pilautil.generics.Utilities;
import co.swatit.pilawebservices.business.PilaBO;

/**
 * 
 * Clase encargada de exponer como servicios web sus métodos
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 12/01/2017
 * @version 1.0
 */
@Path("/PilaWS")
public class PilaWS {
	/**
	 * LOGGER de la aplicación.
	 */
	private static final Logger LOGGER = Logger.getLogger(PilaWS.class.getName());

	/**
	 * 
	 * Servicio web que realiza el logueo de un usuario ante SOI
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 19/01/2017
	 *
	 * @param context
	 *            , información sobre la petición realizada al servicio
	 * @param loginInDTO
	 *            , objeto de transporte que contiene los parámetros del servicio
	 * @return {@link LoginOutDTO}, objeto de transporte que contiene la respuesta del servicio, las cuales son:
	 *         <ul>
	 *         <li>Código y mensaje de error, ayudan a determinar el éxito o fracaso del logueo</li>
	 *         <li>token, en caso que el logueo sea exitoso se generará un token para el usuario</li>
	 *         <li>permisos del usuario, según el rol del usuario logueado</li>
	 *         </ul>
	 */
	@POST
	@Path(ServicesConstants.WS_LOGIN)
	@Produces({ MediaType.APPLICATION_JSON })
	public LoginOutDTO checkAuthorizationFromSOI(@Context HttpServletRequest context, LoginInDTO loginInDTO) {
		LOGGER.info(Constants.STARTING_SERVICE + ServicesConstants.WS_LOGIN + Constants.STARTING_SERVICE_PARAMS
				+ loginInDTO.toString());
		LoginOutDTO response = new LoginOutDTO();
		try {
			response = PilaBO.checkAuthorizationFromSOI(loginInDTO, context.getRemoteAddr());
		} catch (BusinessException ex) {
			Utilities.buildResponse(response, CodeErrorEnum.ERROR, ex);
			LOGGER.error("Error en el servicio: checkAuthorizationFromSOI",ex);
		}
		LOGGER.info(Constants.LOG_WS_INVOKED);
		return response;
	}

	/**
	 * 
	 * Servicio web que obtiene la configuración de una planilla PILA
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 16/02/2017
	 *
	 * @param inDTO
	 *            , objeto de transporte que contiene los parámetros del servicio
	 * @return
	 */
	@POST
	@Path(ServicesConstants.WS_GET_VALIDATION_FILE_CONFIG)
	@Produces({ MediaType.APPLICATION_JSON })
	public GetValidationFileConfigOutDTO getValidationFileConfig(GetValidationFileConfigInDTO inDTO) {
		LOGGER.info(Constants.STARTING_SERVICE + ServicesConstants.WS_LOGIN + Constants.STARTING_SERVICE_PARAMS
				+ inDTO.toString());
		GetValidationFileConfigOutDTO response = new GetValidationFileConfigOutDTO();
		try {
			response = PilaBO.getValidationFileConfig(inDTO);
		} catch (BusinessException ex) {
			Utilities.buildResponse(response, CodeErrorEnum.ERROR, ex);
		}
		LOGGER.info(Constants.LOG_WS_INVOKED);
		return response;
	}

	/**
	 * 
	 * Método que publica un servicio web que valida un token
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 27/02/2017
	 *
	 * @param inDTO
	 *            , objeto de transporte que contiene un token a ser validado
	 * @return {@link ResponseDTO} con los datos de la respuesta del servicio
	 */
	@POST
	@Path(ServicesConstants.WS_VALIDATE_TOKEN)
	@Produces({ MediaType.APPLICATION_JSON })
	public ResponseDTO validateToken(ValidateTokenInDTO inDTO) {
		LOGGER.info(Constants.STARTING_SERVICE + ServicesConstants.WS_VALIDATE_TOKEN
				+ Constants.STARTING_SERVICE_PARAMS + inDTO.toString());
		ResponseDTO response = new ResponseDTO();
		try {
			response = PilaBO.validateToken(inDTO);
		} catch (BusinessException ex) {
			Utilities.buildResponse(response, CodeErrorEnum.ERROR, ex);
		}
		LOGGER.info(Constants.LOG_WS_INVOKED);
		return response;

	}

	/**
	 * 
	 * Método que publica un servicio web que obtiene una determinada cantidad de planillas ya pagadas a SOI por parte
	 * de una empresa
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 9/03/2017
	 *
	 * @param inDTO
	 *            , objeto de transporte con los parámetros del servicio
	 * @return {@link GetFilteredPayrollsOutDTO} con la respuesta del servicio
	 */
	@POST
	@Path(ServicesConstants.WS_GET_FILTERED_PAYROLLS)
	@Produces({ MediaType.APPLICATION_JSON })
	public GetFilteredPayrollsOutDTO getFilteredPayrolls(GetFilteredPayrollsInDTO inDTO) {
		LOGGER.info(Constants.STARTING_SERVICE + ServicesConstants.WS_GET_FILTERED_PAYROLLS
				+ Constants.STARTING_SERVICE_PARAMS + inDTO.toString());
		GetFilteredPayrollsOutDTO response = new GetFilteredPayrollsOutDTO();
		try {
			response = PilaBO.getFilteredPayrolls(inDTO);
		} catch (BusinessException ex) {
			Utilities.buildResponse(response, CodeErrorEnum.ERROR, ex);
		}
		LOGGER.info(Constants.LOG_WS_INVOKED);
		return response;
	}

	/**
	 * 
	 * Método que publica un servicio web que obtiene las notificaciones que le corresponden a un usuario según la
	 * versión de la aplicación con la que cuenta
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/03/2017
	 *
	 * @param inDTO
	 *            , objeto de transporte que contiene los parámetros del servicio
	 * @return {@link GetNotificationsOutDTO} con la respuesta del servicio
	 */
	@POST
	@Path(ServicesConstants.WS_GET_NOTIFICATIONS)
	@Produces({ MediaType.APPLICATION_JSON })
	public GetNotificationsOutDTO getNotifications(GetNotificationsInDTO inDTO) {
		LOGGER.info(Constants.STARTING_SERVICE + ServicesConstants.WS_GET_NOTIFICATIONS
				+ Constants.STARTING_SERVICE_PARAMS + inDTO.toString());
		GetNotificationsOutDTO response = new GetNotificationsOutDTO();
		try {
			response = PilaBO.getNotifications(inDTO);
		} catch (BusinessException ex) {
			Utilities.buildResponse(response, CodeErrorEnum.ERROR, ex);
		}
		LOGGER.info(Constants.LOG_WS_INVOKED);
		return response;
	}

	/**
	 * 
	 * Método que publica un servicio que obtiene los datos de la planilla según su número
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 3/04/2017
	 *
	 * @param inDTO
	 *            , objeto de transporte que contiene los parámetros del servicio
	 * @return {@link GetPayrollHeaderOutDTO} con la respuesta del servicio
	 */
	@POST
	@Path(ServicesConstants.WS_GET_PAYROLL_HEADER)
	@Produces({ MediaType.APPLICATION_JSON })
	public GetPayrollHeaderOutDTO getPayrollHeader(GetPayrollHeaderInDTO inDTO) {
		LOGGER.info(Constants.STARTING_SERVICE + ServicesConstants.WS_GET_PAYROLL_HEADER
				+ Constants.STARTING_SERVICE_PARAMS + inDTO.toString());
		GetPayrollHeaderOutDTO response = new GetPayrollHeaderOutDTO();
		try {
			response = PilaBO.getPayrollHeader(inDTO);
		} catch (BusinessException ex) {
			response = Utilities.buildResponse(response, CodeErrorEnum.ERROR, ex);
		}
		LOGGER.info(Constants.LOG_WS_INVOKED);
		return response;
	}

	/**
	 * 
	 * Método que publica un servicio web que obtiene los aportantes de una planilla según su identificación
	 * 
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 4/04/2017
	 *
	 * @param inDTO
	 *            , objeto de transporte que contiene los parámetros del servicio
	 * @return {@link GetPayrollContributorsOutDTO} con la respuesta del servicio
	 */
	@POST
	@Path(ServicesConstants.WS_GET_PAYROLL_CONTRIBUTORS)
	@Produces({ MediaType.APPLICATION_JSON })
	public GetPayrollContributorsOutDTO getPayrollContributors(GetPayrollContributorsInDTO inDTO) {
		LOGGER.info(Constants.STARTING_SERVICE + ServicesConstants.WS_GET_PAYROLL_CONTRIBUTORS
				+ Constants.STARTING_SERVICE_PARAMS + inDTO.toString());
		GetPayrollContributorsOutDTO response = new GetPayrollContributorsOutDTO();
		try {
			response = PilaBO.getPayrollContributors(inDTO);
		} catch (BusinessException ex) {
			response = Utilities.buildResponse(response, CodeErrorEnum.ERROR, ex);
		}
		LOGGER.info(Constants.LOG_WS_INVOKED);
		return response;
	}

	/**
	 * 
	 * Método que publica un servicio web que obtiene la información de un listado de cotizantes según su id, este
	 * servicio hace parte de la funcionalidad de soporte de pago, provee la información para enviar los emails a los
	 * aportantes.
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 10/04/2017
	 *
	 * @param inDTO
	 *            , objeto de transporte que contiene los parámetros del servicio
	 * @return {@link GetContributorsInformationOutDTO} con la respuesta del servicio
	 */
	@POST
	@Path(ServicesConstants.WS_GET_CONTIBUTORS_INFORMATION)
	@Produces({ MediaType.APPLICATION_JSON })
	public GetContributorsInformationOutDTO getContributorsInformation(GetContributorsInformationInDTO inDTO) {
		LOGGER.info(Constants.STARTING_SERVICE + ServicesConstants.WS_GET_CONTIBUTORS_INFORMATION);
		GetContributorsInformationOutDTO response = new GetContributorsInformationOutDTO();
		try {
			response = PilaBO.getContributorsInformation(inDTO);
		} catch (BusinessException ex) {
			response = Utilities.buildResponse(response, CodeErrorEnum.ERROR, ex);
		}
		LOGGER.info(Constants.LOG_WS_INVOKED);
		return response;
	}
	
	@POST
	@Path(ServicesConstants.WS_VALIDATE_FILE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetValidateFileOutDTO validateFile(GetValidateFileInDTO getValidateFileInDTO) {
		LOGGER.info(Constants.STARTING_SERVICE + ServicesConstants.WS_VALIDATE_FILE);
		GetValidateFileOutDTO response = new GetValidateFileOutDTO();
		try {
			response = PilaBO.validateFile(getValidateFileInDTO);
		} catch (BusinessException ex) {
			response = Utilities.buildResponse(response, CodeErrorEnum.ERROR, ex);
		}
		LOGGER.info(Constants.LOG_WS_INVOKED);
		return response;
	}
	
	
	@POST
	@Path(ServicesConstants.WS_CONSULT_FILE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetConsultFileOutDTO consultFile(GetConsultFileInDTO getConsultFileInDTO) {
		LOGGER.info(Constants.STARTING_SERVICE + ServicesConstants.WS_CONSULT_FILE);
		GetConsultFileOutDTO response = new GetConsultFileOutDTO();
		
		try {
			response = PilaBO.consultFile(getConsultFileInDTO.getIdFile());
		} catch (BusinessException ex) {
			response = Utilities.buildResponse(response, CodeErrorEnum.ERROR, ex);
		}
		LOGGER.info(Constants.LOG_WS_INVOKED);
		return response;
	}
	
	
	@GET
	@Path(ServicesConstants.WS_CONSULT_PAYROLL)
	@Produces(MediaType.APPLICATION_JSON)
	public GetConsultPayrollOutDTO consultPayroll(@PathParam("idPayroll") Long idPayroll) {
		LOGGER.info(Constants.STARTING_SERVICE + ServicesConstants.WS_CONSULT_PAYROLL);
		GetConsultPayrollOutDTO response = new GetConsultPayrollOutDTO();
		
		try {
			response = PilaBO.consultPayroll(idPayroll);
		} catch (BusinessException ex) {
			response = Utilities.buildResponse(response, CodeErrorEnum.ERROR, ex);
		}
		LOGGER.info(Constants.LOG_WS_INVOKED);
		return response;
	}
	
	
	@POST
	@Path(ServicesConstants.WS_PUT_PAYROLL)
	@Produces(MediaType.APPLICATION_JSON)
	//{"getValidateFileOutDTO":	{"idArchivoEnProceso":30805,"errores":[],"idSegUsuario":5728,"idSoiPlanilla":41820,"notificacionDeArchivoEnProcesoType":"SOBREESCRIBIR_NOTIFICACION","numeroTotalDeEmpleadosPorPantalla":201,"nombreArchivo":"/data/nsoi.out.directories/nsoi/entrada/ArchivosDeEntrada/05-2017/1494369020622-ARCHIVO PLANO ACTIVOS NEC248-005 CP4923.TXT","idAportante":4891,"idSoiPlanillaGuardada":118224,"codTipoPlanilla":"E","idSoiTpPlanilla":1}	,"getUsuarioAutenticadoInDTO":{"idSoiAportanteUsuario":5352,"permitirActualizarDatosApteMigrado":false,"apteUgpp":false,"idRecursoLiquidacionPlanillaU":5465,"usuarioCreacion":"CC180818","ipUsuarioOrigen":"localhost"},"idPlanilla":30739,"getConsultPayrollOutDTO":{"periodoSalud":"2017-03","periodoNoSalud":"2017-02","confirmacionRetroactivo":false,"calcularMora":true}}
	public GetPutPayrollOutDTO putPayroll(GetPutPayrollInDTO getPutPayrollInDTO) {
		LOGGER.info(Constants.STARTING_SERVICE + ServicesConstants.WS_PUT_PAYROLL);
		GetPutPayrollOutDTO response = new GetPutPayrollOutDTO();
		
		try {
			response = PilaBO.putPayroll(getPutPayrollInDTO);
		} catch (BusinessException ex) {
			response = Utilities.buildResponse(response, CodeErrorEnum.ERROR, ex);
		}
		LOGGER.info(Constants.LOG_WS_INVOKED);
		return response;
	}
	
	
	@POST
	@Path(ServicesConstants.WS_CREATE_PAYROLL)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	//{"getValidateFileOutDTO":	{"idArchivoEnProceso":30805,"errores":[],"idSegUsuario":5728,"idSoiPlanilla":41820,"notificacionDeArchivoEnProcesoType":"SOBREESCRIBIR_NOTIFICACION","numeroTotalDeEmpleadosPorPantalla":201,"nombreArchivo":"/data/nsoi.out.directories/nsoi/entrada/ArchivosDeEntrada/05-2017/1494369020622-ARCHIVO PLANO ACTIVOS NEC248-005 CP4923.TXT","idAportante":4891,"idSoiPlanillaGuardada":118224,"codTipoPlanilla":"E","idSoiTpPlanilla":1}	,"getUsuarioAutenticadoInDTO":{"idSoiAportanteUsuario":5352,"permitirActualizarDatosApteMigrado":false,"apteUgpp":false,"idRecursoLiquidacionPlanillaU":5465,"usuarioCreacion":"CC180818","ipUsuarioOrigen":"localhost"},"idPlanilla":30739,"getConsultPayrollOutDTO":{"periodoSalud":"2017-03","periodoNoSalud":"2017-02","confirmacionRetroactivo":false,"calcularMora":true}}
	public GetPutPayrollOutDTO createPayroll(GetValidateFileInDTO getValidateFileInDTO) {
		LOGGER.info(Constants.STARTING_SERVICE + ServicesConstants.WS_CREATE_PAYROLL);
		GetPutPayrollOutDTO response = new GetPutPayrollOutDTO();
		try {
			response = PilaBO.createPayroll(getValidateFileInDTO);
		} catch (BusinessException ex) {
			response = Utilities.buildResponse(response, CodeErrorEnum.ERROR, ex);
		}
		LOGGER.info(Constants.LOG_WS_INVOKED);
		return response;
	}

}

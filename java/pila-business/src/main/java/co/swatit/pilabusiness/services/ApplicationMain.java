package co.swatit.pilabusiness.services;

import co.swatit.pilabusiness.business.ApplicationBO;
import co.swatit.pilabusiness.utils.LogFileGenerator;
import co.swatit.pilabusiness.utils.ResponseUtil;
import co.swatit.pilabusiness.utils.enums.ServiceNameEnum;
import co.swatit.pilautil.constants.NumberConstants;
import co.swatit.pilautil.dto.out.GetValidateFileOutDTO;
import co.swatit.pilautil.exception.BusinessException;
import co.swatit.pilautil.exception.ErrorMessagesLoader;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;
import co.swatit.pilautil.generics.Validation;

/**
 * Clase encargada de recibir las peticiones realizadas relacionadas a la autenticación de usuarios.
 * 
 * @author SWAT-IT <br>
 *         Cristian Camilo Londoño <br>
 *         Email: clondono@swat-it.co <br>
 * @date 19/01/2017
 * @sprint 1.0
 */
public final class ApplicationMain {

	/**
	 * Método constructor privado.
	 */
	private ApplicationMain() {

	}


	/**
	 * Método encargado de recibir la acción y el JSON para orquestar la función a ejecutar.
	 * 
	 * @autor SWAT-IT <br>
	 *        Cristian Camilo Londoño <br>
	 *        Email: clondono@swat-it.co <br>
	 * @date 19/01/2017
	 * @version 1.0
	 *
	 * @param args
	 *            Arreglo que contiene la acción a realizar en la posición 0 y el JSON necesario para la acción en la
	 *            posición 1.
	 */
	/**
	 * 
	 * Método encargado de recibir la acción y parámetros del servicio a ejecutar e imprime su respuesta
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 22/02/2017
	 * @version 2.0
	 *
	 * @param args
	 *            Arreglo que contiene la orden y parámetros para invocar un servicio
	 */
	public static void main(String[] args) {

		
		/* Se llama el método que genera el archivo de log */
		LogFileGenerator.buildFileLog();
		String response;
		/* Se valida la acción y el JSON de entrada */
		if (args.length > NumberConstants.ONE) {
			String serviceName = args[NumberConstants.ZERO];
			String serviceParams = args[NumberConstants.ONE];
			if (Validation.isNotNull(serviceName)) {
				response = serviceConsumer(serviceName, serviceParams);
			} else {
				/* En caso que los parámetros de entrada sean nulos */
				/* En caso que no encuentre una acción a realizar se imprime el error */
				response = ResponseUtil.manageException(CodeErrorEnum.ERRORPARAMSNULL.getCode(),
						ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.ERRORPARAMSNULL.getDescription()),
						new BusinessException(CodeErrorEnum.ERRORPARAMSNULL));
			}
		} else {
			response = ResponseUtil.manageException(CodeErrorEnum.ERRORPARAMSQUANTITY.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.ERRORPARAMSQUANTITY.getDescription()),
					new BusinessException(CodeErrorEnum.ERRORPARAMSQUANTITY));
		}
		System.out.println(response);
	}
	

	/**
	 * 
	 * Método que determina el servicio que debe ser invocado
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/02/2017
	 *
	 * @param serviceName
	 *            , nombre del servicio que se requiere usar
	 * @param parameters
	 *            , parámetros del servicio a usar
	 * @return la respuesta del servicio
	 */
	private static String serviceConsumer(String serviceName, String parameters) {
		ServiceNameEnum serviceNameEn = ServiceNameEnum.getService(serviceName);
		if (Validation.isNull(serviceNameEn)) {
			return ResponseUtil.manageException(CodeErrorEnum.ERRORSERVICENOTFOUND.getCode(),
					ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.ERRORSERVICENOTFOUND.getDescription()),
					new BusinessException(CodeErrorEnum.ERRORSERVICENOTFOUND));
		} else {
			return ApplicationBO.serviceConsumer(serviceNameEn, parameters);
		}
	}

}

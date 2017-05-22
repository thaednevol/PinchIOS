package co.swatit.pilabusiness.utils;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

import co.swatit.pilautil.dto.ResponseDTO;
import co.swatit.pilautil.exception.BusinessException;
import co.swatit.pilautil.exception.ErrorMessagesLoader;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;
import co.swatit.pilautil.generics.Constants;
import co.swatit.pilautil.request.rest.ParserUtils;

/**
 * Clase encargada de imprimir por consola los mensajes que serán leídos por la aplicación electron
 * 
 * @author SWAT-IT <br>
 *         Cristian Camilo Londoño <br>
 *         Email: clondono@swat-it.co <br>
 * @date 24/01/2017
 * @sprint 1.0
 */
public final class ResponseUtil {

	/**
	 * LOGGER de la aplicación.
	 */
	private static final Logger LOGGER = Logger.getLogger(ResponseUtil.class.getName());

	/**
	 * Método constructor vacío
	 */
	private ResponseUtil() {
	}

	/**
	 * Método utilizado para imprimir en consola un ResponseDTO convertido en JSON
	 * 
	 * @autor SWAT-IT <br>
	 *        Cristian Camilo Londoño <br>
	 *        Email: clondono@swat-it.co <br>
	 * @date 23/01/2017
	 * @version 1.0
	 *
	 * @param code
	 *            Código de la respuesta enviada
	 * @param message
	 *            Mensaje de la respuesta enviada
	 * @return respuesta que contiene el error convertido desde el objeto
	 */
	public static String printResponse(String code, String message) {
		try {
			/* Se crea el objeto de tipo ResponseDTO y se setean los campos */
			ResponseDTO response = new ResponseDTO();
			response.setCode(code);
			response.setMessage(message);
			/* Se imprime en consola el objeto convertido en JSON */
			return ParserUtils.INSTANCE.convertObjectToJSON(response);
		} catch (JsonProcessingException e) {
			LOGGER.error(e);
		}
		return null;
	}

	/**
	 * Método encargado de realizar el llamado del método que imprime en consola el error generado y de dejar registro
	 * en el log de la excepción
	 * 
	 * @autor SWAT-IT <br>
	 *        Cristian Camilo Londoño <br>
	 *        Email: clondono@swat-it.co <br>
	 * @date 24/01/2017
	 * @version 1.0
	 *
	 * @param code
	 *            Código de la excepción generada
	 * @param message
	 *            Mesaje de la excepción generada
	 * @param e
	 *            Excepción generada
	 * @return String con la respuesta del error
	 */
	public static String manageException(String code, String message, Exception e) {

		/* Se contruye el mensaje que se registrará en el log */
		StringBuilder logMessage = new StringBuilder();
		logMessage.append(code);
		logMessage.append(Constants.SPACE);
		logMessage.append(Constants.DASH);
		logMessage.append(Constants.SPACE);
		logMessage.append(message);

		/* Se deja registro en el log */
		LOGGER.error(logMessage.toString(), e);
		/* Se imprime en consola el mensaje que se leerá en electron */
		return ResponseUtil.printResponse(code,
				ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.ERRORUNEXPECTED.getDescription()));
	}

	/**
	 * Método encargado de realizar el llamado del método que imprime en consola el error generado y de dejar registro
	 * en el log de la excepción cuando es una excepción de negocio
	 * 
	 * @autor SWAT-IT <br>
	 *        Cristian Camilo Londoño <br>
	 *        Email: clondono@swat-it.co <br>
	 * @date 24/01/2017
	 * @version 1.0
	 *
	 * @param code
	 *            Código de la excepción generada
	 * @param message
	 *            Mesaje de la excepción generada
	 * @param e
	 *            Excepción generada
	 * @return Respuesta con la excepción que se obtuvo
	 */
	public static String manageBusinessException(String code, String message, BusinessException e) {

		/* Se contruye el mensaje que se registrará en el log */
		StringBuilder logMessage = new StringBuilder();
		logMessage.append(code);
		logMessage.append(Constants.SPACE);
		logMessage.append(Constants.DASH);
		logMessage.append(Constants.SPACE);
		logMessage.append(message);

		/* Se deja registro en el log */
		LOGGER.error(logMessage.toString(), e);

		/* Se imprime en consola el mensaje que se leerá en electron */
		return ResponseUtil.printResponse(code, message);
	}
}

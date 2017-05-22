package co.swatit.pilautil.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

import com.lucasian.exception.ApplicationException;

import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;
import co.swatit.pilautil.exception.dto.ErrorDTO;
import co.swatit.pilautil.generics.Constants;
import co.swatit.pilautil.generics.Validation;

/**
 * Clase que hereda de Exception y se encarga de encapsular el objeto ErrorDTO para el manejo de excepciones.
 * 
 * @author Swat-It <br>
 *         Jessica Antía Hortúa <br>
 *         Email: jantia@swat-it.co<br>
 * @date 25/10/2016
 * @version 1.0
 */
public class GenericException extends Exception {

	/**
	 * Serial por defecto de la clase.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Dto con el error de la excepción.
	 */
	private ErrorDTO errorDTO;

	/**
	 * Logger de la aplicación.
	 */
	private static final Logger LOGGER = Logger.getLogger(GenericException.class.getName());

	/**
	 * Metodo constructor, inicializa con la asignacion de un objeto ErrorDTO.
	 * 
	 * @param errorDTO
	 */
	public GenericException(final ErrorDTO errorDTO) {
		super();
		this.errorDTO = errorDTO;
		printLog();
	}

	/**
	 * Metodo constructor, inicializa con la asignacion de los parametros basicos de un objeto ErrorDTO.
	 * 
	 * @param code
	 * @param description
	 * @param cause
	 */
	public GenericException(final String code, final String description, final Throwable cause) {

		super();
		this.errorDTO = new ErrorDTO(code, description);
		printLog();
		printTrace(cause);
	}

	/**
	 * Metodo constructor, inicializa con la asignacion de los parametros basicos de un objeto ErrorDTO.
	 * 
	 * @param code
	 *            , codigo que identifica la excepción.
	 * @param description
	 *            , descripción de la excepción generada.
	 * @param args
	 *            , argumentos.
	 */
	public GenericException(final String code, final String description, String... args) {
		super();
		String message = description;
		if (Validation.isNotNull(args)) {
			message = ErrorMessagesLoader.INSTANCE.getErrorMensage(description, args);
		}
		this.errorDTO = new ErrorDTO(code, message);
		printLog();
	}

	/**
	 * Metodo constructor, inicializa con la asignacion de los parametros basicos de un objeto ErrorDTO pasandole la
	 * traza del error en el parametro StackTraceElement.
	 * 
	 * @param code
	 * @param cause
	 */
	public GenericException(final String code, final Throwable cause) {

		super();
		this.errorDTO = new ErrorDTO(code, cause.getMessage());
		printLog();
		printTrace(cause);
	}

	/**
	 * 
	 * @param mensaje
	 * @param cause
	 */
	public GenericException(final CodeErrorEnum mensaje, final Throwable cause) {
		super();
		String errorCode = mensaje.getCode();
		String message;
		if (cause instanceof ApplicationException) {
			ApplicationException ex = (ApplicationException) cause;
			errorCode = Integer.toString(ex.getCodigo());
			message = ErrorMessagesLoader.INSTANCE.getSOIErrorMessage(errorCode, ex.getParametrosReemplazo());
		} else {
			message = ErrorMessagesLoader.INSTANCE.getErrorMensage(mensaje.getDescription());
		}

		this.errorDTO = new ErrorDTO(errorCode, message);
		printLog();
		printTrace(cause);
	}

	/**
	 * @param mensaje
	 */
	public GenericException(final CodeErrorEnum mensaje) {
		super();
		String message = ErrorMessagesLoader.INSTANCE.getErrorMensage(mensaje.getDescription());
		this.errorDTO = new ErrorDTO(mensaje.getCode(), message);
		printLog();
	}

	/**
	 * Metodo constructor, inicializa con la asignacion de los parametros basicos de un objeto ErrorDTO.
	 * 
	 * @param exception
	 * @param code
	 * @param args
	 */
	public GenericException(final Throwable exception, final CodeErrorEnum code, final String[] args) {
		super();
		String message = code.getDescription();

		if (Validation.isNotNull(args)) {
			message = ErrorMessagesLoader.INSTANCE.getErrorMensage(code.getDescription(), args);
		}
		this.errorDTO = new ErrorDTO(code.getCode(), message);
		printLog();
		printTrace(exception);
	}

	/**
	 * Metodo encargado de sobrecargar el constructor de la clase para recibir una enumeracion con el codigo de error y
	 * los parametros del mensaje.
	 * 
	 * @param code
	 *            enumeracion que contiene el codigo y mensaje de error.
	 * @param args
	 *            parametros que se deben incluir en el mensaje.
	 */
	public GenericException(final CodeErrorEnum code, final String[] args) {
		super();
		String message = code.getDescription();
		if (Validation.isNotNull(args)) {
			message = ErrorMessagesLoader.INSTANCE.getErrorMensage(code.getDescription(), args);
		} else {
			message = ErrorMessagesLoader.INSTANCE.getErrorMensage(code.getDescription());
		}
		this.errorDTO = new ErrorDTO(code.getCode(), message);
		printLog();
	}

	/**
	 * Metodo que retorna el objeto ErrorDTO definido como excepcion.
	 * 
	 * @return
	 */
	public ErrorDTO getErrorDTO() {
		return errorDTO;
	}

	/**
	 * Metodo que establece un objeto ErrorDTO y se retorna asi mismo.
	 * 
	 * @param errorDTO
	 * @return
	 */
	public GenericException setErrorDTO(final ErrorDTO errorDTO) {
		this.errorDTO = errorDTO;
		return this;
	}

	/**
	 * Metodo que establece un objeto ErrorDTO mediante sus parametros basicos y se retorna asi mismo.
	 * 
	 * @param code
	 * @param description
	 * @return
	 */
	public GenericException setErrorDTO(final String code, final String description) {
		this.errorDTO = new ErrorDTO(code, description);
		return this;
	}

	/**
	 * Este metodo registra la informacion en logger.
	 * 
	 * @author Jorge Mario Romero Arroyo <jromero.swat.it@gmail.com>
	 * 
	 * @param code
	 * @param description
	 */
	private void printLog() {
		StringBuilder string = new StringBuilder();
		string.append("Cod. Error: ").append(errorDTO.getCode()).append(" - Mensaje: ")
				.append(errorDTO.getDescription());
		LOGGER.error(string.toString());
	}

	/**
	 * Metodo para imprimir una traza de error.
	 * 
	 * @author Swat-It - Bryan Camilo Perez Trujillo <bperez@swat-it.co>
	 * @date 05/11/2013
	 * @version 1.0
	 * 
	 * @param cause
	 *            excepcion caputrada
	 */
	private static void printTrace(final Throwable cause) {
		try {
			StringWriter result = new StringWriter();
			PrintWriter printWriter = new PrintWriter(result);
			if (cause instanceof ApplicationException) {
				LOGGER.error(Constants.LUCASIAN_APP_EXCEPTION_CODE + ((ApplicationException) cause).getCodigo());
			}
			cause.printStackTrace(printWriter);
			LOGGER.error(result);
			result.close();
			printWriter.close();
		} catch (Exception ex) {
			LOGGER.error(new StringBuilder("ocurrio un error al intentar").append("imprimir la traza de error ")
					.append(":").append(ex.getMessage()));
		}
	}
}

package co.swatit.pilautil.exception;

import java.text.MessageFormat;

import co.swatit.pilautil.generics.PropertyLoader;
import co.swatit.pilautil.generics.Utilities;
import co.swatit.pilautil.generics.Validation;

/**
 * Clase encargada de cargar los mensajes de error asociados a la excepciones.
 * 
 * @author Swat-It <br>
 *         Jessica Antía Hortúa <br>
 *         Email: jantia@swat-it.co<br>
 * @date 25/10/2016
 * @version 1.0
 * 
 */
public final class ErrorMessagesLoader {

	/** Path del archivo de excepciones */
	public static final String EXCEPTIONFILE = "/resources/messages.properties";

	/** Constante que contiene la ruta del archivo que contiene las excepciones de SOI */
	public static final String SOI_EXCEPTIONS = Utilities.contextName + "/resources/soi-exceptions.properties";

	/** Instancia para acceder a las funcionalidades */
	public static final ErrorMessagesLoader INSTANCE = new ErrorMessagesLoader();

	/**
	 * Constructor encargado de cargar el archivo de mensajes de errores
	 */
	private ErrorMessagesLoader() {
		PropertyLoader.INSTANCE.loadPropertiesFile(EXCEPTIONFILE);
	}

	/**
	 * Metodo encargado de obtener los mensajes de error asociados a una llave.
	 * 
	 * @param key
	 *            , llave del mensaje de error.
	 * @param args
	 *            , argumentos del mensaje.
	 * @return {@link String} el mensaje asociado a la llave.
	 */
	public String getErrorMensage(final String key, final String... args) {
		String message = PropertyLoader.INSTANCE.getProperty(EXCEPTIONFILE, key);
		if (Validation.isNotEmpty(message) && Validation.isNotNull(args)) {
			MessageFormat formater = new MessageFormat(message);
			message = formater.format(args);
			return message;
		}
		return Validation.isNotEmpty(message) ? message : key;
	}

	/**
	 * 
	 * Método que obtiene el mensaje de una excepción de SOI
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 23/02/2017
	 *
	 * @param key
	 *            , llave de la excepción
	 * @param parameters
	 *            , arreglo que contiene los campos a modificar en el formateo final del mensaje
	 * @return el mensaje formateado usando los parámetros enviados, si aplica
	 */
	public String getSOIErrorMessage(final String key, final Object[] parameters) {
		String message = PropertyLoader.INSTANCE.getProperty(SOI_EXCEPTIONS, key);
		if (Validation.isNotEmpty(message) && Validation.isNotNull(parameters)) {
			MessageFormat format = new MessageFormat(message);
			message = format.format(parameters);
		}
		return Validation.isNotEmpty(message) ? message : key;
	}
}

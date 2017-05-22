package co.swatit.pilautil.exception;

import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;

/**
 * Clase de excepciones generadas en el proceso de invocacion de servicios Rest y de parseo de respuesta generados en
 * estas invocaciones.
 * 
 * @author Swat-It <br>
 *         Jessica Antía Hortúa <br>
 *         Email: jantia@swat-it.co<br>
 * @date 25/10/2016
 * @version 1.0
 * 
 */
public class InvokeException extends GenericException {

	/**
	 * variable de serializacion
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor simple con codigo y descripcion para propagar a traves de las capas
	 * 
	 * @param code
	 * @param description
	 * @param args
	 */
	public InvokeException(final String code, final String description, final String... args) {
		super(code, description, args);
	}

	/**
	 * Constructor para generar error asociando la causa por la que se genera
	 * 
	 * @param code
	 * @param description
	 * @param cause
	 */
	public InvokeException(final String code, final String description, final Throwable cause) {
		super(code, description, cause);
	}

	/**
	 * Constructor para generar error a partir de una enumeracion permite imprimir la traza de error
	 * 
	 * @param error
	 * @param cause
	 */
	public InvokeException(final CodeErrorEnum error, final Throwable cause) {
		super(error, cause);
	}

	/**
	 * Constructor para generar error a partir de una enumeracion
	 * 
	 * @param error
	 */
	public InvokeException(final CodeErrorEnum error) {
		super(error);
	}
}

package co.swatit.pilautil.exception;

import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;

/**
 * Clase que hereda de GenericException y se encarga de encapsular el objeto ErrorDTO para el manejo de excepciones
 * sobre la capa de negocio.
 * 
 *         Jessica Antía Hortúa <br>
 *         Email: jantia@swat-it.co<br>
 * @date 25/10/2016
 * @version 1.0
 * 
 */
public class BusinessException extends GenericException {

    /**
     * Serial por defecto de la clase.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Metodo constructor, inicializa con la asignacion de un objeto ErrorDTO.
     * 
     * @param gex,
     *            con la excepción generica.
     */
    public BusinessException(final GenericException gex) {
        super(gex.getErrorDTO());
    }

    /**
     * Metodo constructor, inicializa con la asignacion de los parametros basicos de un objeto ErrorDTO.
     * 
     * @param code
     * @param description
     * @param args
     */
    public BusinessException(final String code, final String description, final String... args) {
        super(code, description, args);
    }

    /**
     * Metodo constructor, inicializa con la asignacion de los parametros basicos de un objeto ErrorDTO.
     * 
     * @param code
     * @param cause
     */
    public BusinessException(final CodeErrorEnum code, Throwable cause) {
        super(code, cause);
    }

    /**
     * Metodo constructor para lanzar una excepcion a partir de un codeErrorEnum
     * 
     * @param code
     */
    public BusinessException(final CodeErrorEnum code) {
        super(code);
    }

    /**
     * Metodo constructor, inicializa con la asignacion de los parametros basicos de un objeto ErrorDTO, por defecto el
     * codigo es "BOERROR".
     * 
     * @param description
     */
    public BusinessException(final String description) {
        super(CodeErrorEnum.BOERROR.getCode(), description);
    }

    /**
     * Metodo constructor, inicializa con la asignacion de los parametros basicos de un objeto ErrorDTO pasandole la
     * traza del error en el parametro StackTraceElement, por defecto el codigo es "BOERROR".
     * 
     * @param cause
     */
    public BusinessException(final Throwable cause) {
        super(CodeErrorEnum.BOERROR.getCode(), cause);
    }

    /**
     * Constructor de la clase que recibe una enumeracion con el codigo de error y los argumentos para formatear el
     * mensaje.
     * 
     * @param code
     *            enumeracion del error
     * @param arguments
     *            argumentos para parametrizar el mensaje de error
     */
    public BusinessException(final CodeErrorEnum code, final String... arguments) {
        super(code, arguments);
    }

    /**
     * Metodo constructor, inicializa con la asignacion de los parametros basicos de un objeto ErrorDTO.
     * 
     * @param code
     *            codigo del error
     * @param description
     *            descripcion del error
     * @param cause
     *            excepcion generada
     */
    public BusinessException(final String code, final String description, final Throwable cause) {
        super(code, description, cause);
    }

    /**
     * Metodo constructor, inicializa con la asignacion de los parametros basicos de un objeto ErrorDTO.
     * 
     * @param exception
     * @param code
     * @param args
     */
    public BusinessException(Throwable exception, final CodeErrorEnum code, final String... args) {
		super(exception, code, args);
	}
}

package co.swatit.pilautil.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Objeto que transporta el mensaje y el código de error que retorna la ejecución de un servicio
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 12/01/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseDTO", propOrder = { "code", "message" })
@XmlRootElement
public class ResponseDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Código de error de la ejecución del servicio.
	 */
	private String code;

	/**
	 * Mensaje de error de la ejecución del servicio.
	 */
	private String message;

	/**
	 * Método getter del atributo code de la clase ResponseDTO
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Método setter del atributo code de la clase ResponseDTO
	 *
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Método getter del atributo message de la clase ResponseDTO
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Método setter del atributo message de la clase ResponseDTO
	 *
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ResponseDTO [code=").append(code).append(", message=").append(message).append("]");
		return sb.toString();
	}

}

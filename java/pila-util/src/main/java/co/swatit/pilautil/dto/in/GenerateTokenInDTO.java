package co.swatit.pilautil.dto.in;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Objeto de transporte que contiene los parámetros de entrada del servicio generador de tokens
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 18/01/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "generateTokenInDTO", propOrder = { "user", "expirationTime" })
@XmlRootElement
public class GenerateTokenInDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Nombre del usuario autenticado
	 */
	private String user;

	/**
	 * Tiempo de expiración del token
	 */
	private String expirationTime;

	/**
	 * Método getter del atributo user de la clase GenerateTokenInDTO
	 *
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Método setter del atributo user de la clase GenerateTokenInDTO
	 *
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Método getter del atributo expirationTime de la clase GenerateTokenInDTO
	 *
	 * @return the expirationTime
	 */
	public String getExpirationTime() {
		return expirationTime;
	}

	/**
	 * Método setter del atributo expirationTime de la clase GenerateTokenInDTO
	 *
	 * @param expirationTime
	 *            the expirationTime to set
	 */
	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}

}

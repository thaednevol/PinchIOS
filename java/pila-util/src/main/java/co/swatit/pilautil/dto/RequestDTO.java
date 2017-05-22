/**
 * 
 */
package co.swatit.pilautil.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Objeto de transporte genérico para el manejo de peticiones de servicios que requieran autenticación
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 9/03/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestDTO", propOrder = { "token" })
@XmlRootElement
public class RequestDTO implements Serializable {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Token a ser autenticado para la ejecución del servicio invocado
	 */
	private String token;

	/**
	 * Método getter del atributo token de la clase RequestDTO
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Método setter del atributo token de la clase RequestDTO
	 *
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

}

package co.swatit.pilautil.dto.in;

import java.io.Serializable;

/**
 * 
 * Objeto de transporte que contiene los parámetros de entrada del servicio web que valida los tokens
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 15/02/2017
 * @version 1.0
 */
public class ValidateTokenInDTO implements Serializable {

	/**
	 * Constante de serialiación
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Token a validar
	 */
	private String token;

	/**
	 * Método getter del atributo token de la clase ValidateTokenInDTO
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Método setter del atributo token de la clase ValidateTokenInDTO
	 *
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

}

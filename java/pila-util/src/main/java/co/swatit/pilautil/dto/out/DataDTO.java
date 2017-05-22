package co.swatit.pilautil.dto.out;

/**
 * 
 * Objeto de transporte que contiene la información devuelta por el servicio generador de tokens
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 18/01/2017
 * @version 1.0
 */
public class DataDTO {

	private String token;

	/**
	 * Método getter del atributo token de la clase DataDTO
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Método setter del atributo token de la clase DataDTO
	 *
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

}

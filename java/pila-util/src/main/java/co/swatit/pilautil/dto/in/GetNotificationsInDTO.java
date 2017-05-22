/**
 * 
 */
package co.swatit.pilautil.dto.in;

import co.swatit.pilautil.dto.RequestDTO;

/**
 * Objeto de transporte que contiene los parámetros del servicio web getNotifications
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/03/2017
 * @version 1.0
 */
public class GetNotificationsInDTO extends RequestDTO {
	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Versión del cliente de SOI que realiza la petición
	 */
	private String version;

	/**
	 * Método getter del atributo version de la clase GetNotificationsInDTO
	 *
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Método setter del atributo version de la clase GetNotificationsInDTO
	 *
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetNotificationsInDTO [version=");
		builder.append(version);
		builder.append("]");
		return builder.toString();
	}

}

/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import co.swatit.pilautil.dto.ResponseDTO;

/**
 * Objeto de transporte que contiene todas las notificaciones a retornar a un cliente
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/03/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getNotificationsOutDTO", propOrder = { "notificationDetails" })
public class GetNotificationsOutDTO extends ResponseDTO {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Lista de notificaciones a retornar a un cliente
	 */
	private List<NotificationDetailDTO> notificationDetails;

	/**
	 * Método getter del atributo notificationDetails de la clase GetNotificationsOutDTO
	 *
	 * @return the notificationDetails
	 */
	public List<NotificationDetailDTO> getNotificationDetails() {
		if (notificationDetails == null) {
			notificationDetails = new ArrayList<NotificationDetailDTO>();
		}
		return notificationDetails;
	}

}

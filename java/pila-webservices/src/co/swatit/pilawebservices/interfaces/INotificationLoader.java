/**
 * 
 */
package co.swatit.pilawebservices.interfaces;

import java.util.List;

import co.swatit.pilautil.dto.out.NotificationDetailDTO;
import co.swatit.pilautil.exception.BusinessException;

/**
 * Interfaz con la que se obtiene la implementación de cada mecanismo para el manejo de notificaciones
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/03/2017
 * @version 1.0
 */
public interface INotificationLoader {

	/**
	 * 
	 * Método encargado de obtener las notificaciones que deben ser mostradas a un usuario de SOI, habiendo pasado por
	 * un proceso de filtro según la versión y fecha.
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 13/03/2017
	 *
	 * @param applicationVersion
	 *            , versión del cliente que ha realizado la petición
	 * @return List con las notificaciones que deben aparecer al cliente
	 */
	List<NotificationDetailDTO> getNotifications(String applicationVersion) throws BusinessException;

}

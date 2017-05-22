package co.swatit.pilautil.dto.out;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * Objeto de transporte que contiene la información de una notificación a retornar por el servicio getNotifications
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/03/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notificationDetailDTO", propOrder = { "notificationMessage", "severity", "version", "operVersion",
		"maxDate", "actions", "url", "type" })
public class NotificationDetailDTO implements Serializable {
	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Mensaje de la notificación
	 */
	private String notificationMessage;
	/**
	 * Severidad de la notificación
	 */
	private String severity;
	/**
	 * Versión de la aplicación a la que va destinada la notificación
	 */
	private String version;
	/**
	 * Operación según la versión retornada
	 */
	private String operVersion;
	/**
	 * Fecha máxima en la que se debe mostrar la notificación
	 */
	private String maxDate;
	/**
	 * Acciones a realizar cuando se ejecuta la notificación
	 */
	private String actions;
	/**
	 * URL a la que puede redireccionar la notificación
	 */
	private String url;
	/**
	 * Tipo de notificación
	 */
	private String type;

	/**
	 * Método getter del atributo notificationMessage de la clase NotificationDetailDTO
	 *
	 * @return the notificationMessage
	 */
	public String getNotificationMessage() {
		return notificationMessage;
	}

	/**
	 * Método setter del atributo notificationMessage de la clase NotificationDetailDTO
	 *
	 * @param notificationMessage
	 *            the notificationMessage to set
	 */
	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}

	/**
	 * Método getter del atributo severity de la clase NotificationDetailDTO
	 *
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * Método setter del atributo severity de la clase NotificationDetailDTO
	 *
	 * @param severity
	 *            the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * Método getter del atributo version de la clase NotificationDetailDTO
	 *
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Método setter del atributo version de la clase NotificationDetailDTO
	 *
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * Método getter del atributo operVersion de la clase NotificationDetailDTO
	 *
	 * @return the operVersion
	 */
	public String getOperVersion() {
		return operVersion;
	}

	/**
	 * Método setter del atributo operVersion de la clase NotificationDetailDTO
	 *
	 * @param operVersion
	 *            the operVersion to set
	 */
	public void setOperVersion(String operVersion) {
		this.operVersion = operVersion;
	}

	/**
	 * Método getter del atributo maxDate de la clase NotificationDetailDTO
	 *
	 * @return the maxDate
	 */
	public String getMaxDate() {
		return maxDate;
	}

	/**
	 * Método setter del atributo maxDate de la clase NotificationDetailDTO
	 *
	 * @param maxDate
	 *            the maxDate to set
	 */
	public void setMaxDate(String maxDate) {
		this.maxDate = maxDate;
	}

	/**
	 * Método getter del atributo actions de la clase NotificationDetailDTO
	 *
	 * @return the actions
	 */
	public String getActions() {
		return actions;
	}

	/**
	 * Método setter del atributo actions de la clase NotificationDetailDTO
	 *
	 * @param actions
	 *            the actions to set
	 */
	public void setActions(String actions) {
		this.actions = actions;
	}

	/**
	 * Método getter del atributo url de la clase NotificationDetailDTO
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Método setter del atributo url de la clase NotificationDetailDTO
	 *
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Método getter del atributo type de la clase NotificationDetailDTO
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Método setter del atributo type de la clase NotificationDetailDTO
	 *
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}

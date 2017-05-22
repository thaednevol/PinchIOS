package co.swatit.pilautil.exception.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Esta clase se encarga de manejar los codigos de error y su descripcion.
 * 
 * @author Swat-It <br>
 *         Jessica Antía Hortúa <br>
 *         Email: jantia@swat-it.co<br>
 * @date 25/10/2016
 * @version 1.0
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class ErrorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Codigo del error
	 */
	@XmlElement
	private String code;

	/**
	 * Descripcion del error
	 */
	@XmlElement
	private String description;

	/**
	 * Método constructor de la clase que permite almancenar el error.
	 */
	public ErrorDTO() {
		// Se deja vacio intencionalmente.
	}

	/**
	 * Método constructor de la clase que permite almancenar el error.
	 * 
	 * @param code
	 *            , codigo del error.
	 * @param description
	 *            , descripción del error.
	 */
	public ErrorDTO(final String code, final String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * @return Retorna el código del error
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            Establece el código del error
	 */
	public void setCode(final String code) {
		this.code = code;
	}

	/**
	 * @return la descripción del error
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            Establece la descripción del error
	 */
	public void setDescription(final String description) {
		this.description = description;
	}
}

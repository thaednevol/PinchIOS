/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.ach.seg.biz.transfer.RecursoDTO;

/**
 * Objeto de transporte que contiene la información obtenida de un objeto de tipo {@link RecursoDTO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 8/03/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceDTO")
public class ResourceDTO implements Serializable {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * DTO de transporte que contiene los detalles del recurso obtenido
	 */
	private ResourceDetailDTO resourceDetailDTO;
	private Boolean tieneHijos;
	private Integer nivel;
	private Long idSegRol;
	private ResourceDTO recursoPadre;

	/**
	 * Método getter del atributo resourceDetailDTO de la clase ResourceDTO
	 *
	 * @return the resourceDetailDTO
	 */
	public ResourceDetailDTO getResourceDetailDTO() {
		return resourceDetailDTO;
	}

	/**
	 * Método setter del atributo resourceDetailDTO de la clase ResourceDTO
	 *
	 * @param resourceDetailDTO
	 *            the resourceDetailDTO to set
	 */
	public void setResourceDetailDTO(ResourceDetailDTO resourceDetailDTO) {
		this.resourceDetailDTO = resourceDetailDTO;
	}

	/**
	 * Método getter del atributo tieneHijos de la clase ResourceDTO
	 *
	 * @return the tieneHijos
	 */
	public Boolean isTieneHijos() {
		return tieneHijos;
	}

	/**
	 * Método setter del atributo tieneHijos de la clase ResourceDTO
	 *
	 * @param tieneHijos
	 *            the tieneHijos to set
	 */
	public void setTieneHijos(Boolean tieneHijos) {
		this.tieneHijos = tieneHijos;
	}

	/**
	 * Método getter del atributo nivel de la clase ResourceDTO
	 *
	 * @return the nivel
	 */
	public Integer getNivel() {
		return nivel;
	}

	/**
	 * Método setter del atributo nivel de la clase ResourceDTO
	 *
	 * @param nivel
	 *            the nivel to set
	 */
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	/**
	 * Método getter del atributo idSegRol de la clase ResourceDTO
	 *
	 * @return the idSegRol
	 */
	public Long getIdSegRol() {
		return idSegRol;
	}

	/**
	 * Método setter del atributo idSegRol de la clase ResourceDTO
	 *
	 * @param idSegRol
	 *            the idSegRol to set
	 */
	public void setIdSegRol(Long idSegRol) {
		this.idSegRol = idSegRol;
	}

	/**
	 * Método getter del atributo recursoPadre de la clase ResourceDTO
	 *
	 * @return the recursoPadre
	 */
	public ResourceDTO getRecursoPadre() {
		return recursoPadre;
	}

	/**
	 * Método setter del atributo recursoPadre de la clase ResourceDTO
	 *
	 * @param recursoPadre
	 *            the recursoPadre to set
	 */
	public void setRecursoPadre(ResourceDTO recursoPadre) {
		this.recursoPadre = recursoPadre;
	}

}

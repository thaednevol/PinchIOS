/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.ach.seg.biz.model.RecursoVO;

/**
 * Objeto de transporte que contiene la información obtenida de un objeto de tipo {@link RecursoVO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 8/03/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceDetailDTO")
public class ResourceDetailDTO implements Serializable {
	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	private Long idSegRecursoPadre;
	private Integer tpRecurso;
	private Integer idSegAplicacion;
	private String observacion;
	private String accion;
	private String descripcion;
	private Long idSegRecurso;

	/**
	 * Método getter del atributo idSegRecursoPadre de la clase ResourceDetailDTO
	 *
	 * @return the idSegRecursoPadre
	 */
	public Long getIdSegRecursoPadre() {
		return idSegRecursoPadre;
	}

	/**
	 * Método setter del atributo idSegRecursoPadre de la clase ResourceDetailDTO
	 *
	 * @param idSegRecursoPadre
	 *            the idSegRecursoPadre to set
	 */
	public void setIdSegRecursoPadre(Long idSegRecursoPadre) {
		this.idSegRecursoPadre = idSegRecursoPadre;
	}

	/**
	 * Método getter del atributo tpRecurso de la clase ResourceDetailDTO
	 *
	 * @return the tpRecurso
	 */
	public Integer getTpRecurso() {
		return tpRecurso;
	}

	/**
	 * Método setter del atributo tpRecurso de la clase ResourceDetailDTO
	 *
	 * @param tpRecurso
	 *            the tpRecurso to set
	 */
	public void setTpRecurso(Integer tpRecurso) {
		this.tpRecurso = tpRecurso;
	}

	/**
	 * Método getter del atributo idSegAplicacion de la clase ResourceDetailDTO
	 *
	 * @return the idSegAplicacion
	 */
	public Integer getIdSegAplicacion() {
		return idSegAplicacion;
	}

	/**
	 * Método setter del atributo idSegAplicacion de la clase ResourceDetailDTO
	 *
	 * @param idSegAplicacion
	 *            the idSegAplicacion to set
	 */
	public void setIdSegAplicacion(Integer idSegAplicacion) {
		this.idSegAplicacion = idSegAplicacion;
	}

	/**
	 * Método getter del atributo observacion de la clase ResourceDetailDTO
	 *
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * Método setter del atributo observacion de la clase ResourceDetailDTO
	 *
	 * @param observacion
	 *            the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * Método getter del atributo accion de la clase ResourceDetailDTO
	 *
	 * @return the accion
	 */
	public String getAccion() {
		return accion;
	}

	/**
	 * Método setter del atributo accion de la clase ResourceDetailDTO
	 *
	 * @param accion
	 *            the accion to set
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}

	/**
	 * Método getter del atributo descripcion de la clase ResourceDetailDTO
	 *
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Método setter del atributo descripcion de la clase ResourceDetailDTO
	 *
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Método getter del atributo idSegRecurso de la clase ResourceDetailDTO
	 *
	 * @return the idSegRecurso
	 */
	public Long getIdSegRecurso() {
		return idSegRecurso;
	}

	/**
	 * Método setter del atributo idSegRecurso de la clase ResourceDetailDTO
	 *
	 * @param idSegRecurso
	 *            the idSegRecurso to set
	 */
	public void setIdSegRecurso(Long idSegRecurso) {
		this.idSegRecurso = idSegRecurso;
	}

}

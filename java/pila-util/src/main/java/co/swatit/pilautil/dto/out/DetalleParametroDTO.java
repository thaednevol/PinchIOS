/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;

import com.ach.cfg.biz.model.ParametroVO;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link ParametroVO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class DetalleParametroDTO implements Serializable {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	private Integer claseParametro;
	private String descripcion;
	private Integer aplicaMultiple;
	private String causaFinVigencia;
	private String fechaFinVigencia;
	private Integer vigente;
	private String fechaInicioVigencia;
	private String tpDato;
	private String nombre;
	private Integer idSoiParametro;

	/**
	 * Método getter del atributo claseParametro de la clase DetalleParametroDTO
	 *
	 * @return the claseParametro
	 */
	public Integer getClaseParametro() {
		return claseParametro;
	}

	/**
	 * Método setter del atributo claseParametro de la clase DetalleParametroDTO
	 *
	 * @param claseParametro
	 *            the claseParametro to set
	 */
	public void setClaseParametro(Integer claseParametro) {
		this.claseParametro = claseParametro;
	}

	/**
	 * Método getter del atributo descripcion de la clase DetalleParametroDTO
	 *
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Método setter del atributo descripcion de la clase DetalleParametroDTO
	 *
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Método getter del atributo aplicaMultiple de la clase DetalleParametroDTO
	 *
	 * @return the aplicaMultiple
	 */
	public Integer getAplicaMultiple() {
		return aplicaMultiple;
	}

	/**
	 * Método setter del atributo aplicaMultiple de la clase DetalleParametroDTO
	 *
	 * @param aplicaMultiple
	 *            the aplicaMultiple to set
	 */
	public void setAplicaMultiple(Integer aplicaMultiple) {
		this.aplicaMultiple = aplicaMultiple;
	}

	/**
	 * Método getter del atributo causaFinVigencia de la clase DetalleParametroDTO
	 *
	 * @return the causaFinVigencia
	 */
	public String getCausaFinVigencia() {
		return causaFinVigencia;
	}

	/**
	 * Método setter del atributo causaFinVigencia de la clase DetalleParametroDTO
	 *
	 * @param causaFinVigencia
	 *            the causaFinVigencia to set
	 */
	public void setCausaFinVigencia(String causaFinVigencia) {
		this.causaFinVigencia = causaFinVigencia;
	}

	/**
	 * Método getter del atributo fechaFinVigencia de la clase DetalleParametroDTO
	 *
	 * @return the fechaFinVigencia
	 */
	public String getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	/**
	 * Método setter del atributo fechaFinVigencia de la clase DetalleParametroDTO
	 *
	 * @param fechaFinVigencia
	 *            the fechaFinVigencia to set
	 */
	public void setFechaFinVigencia(String fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	/**
	 * Método getter del atributo vigente de la clase DetalleParametroDTO
	 *
	 * @return the vigente
	 */
	public Integer getVigente() {
		return vigente;
	}

	/**
	 * Método setter del atributo vigente de la clase DetalleParametroDTO
	 *
	 * @param vigente
	 *            the vigente to set
	 */
	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}

	/**
	 * Método getter del atributo fechaInicioVigencia de la clase DetalleParametroDTO
	 *
	 * @return the fechaInicioVigencia
	 */
	public String getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	/**
	 * Método setter del atributo fechaInicioVigencia de la clase DetalleParametroDTO
	 *
	 * @param fechaInicioVigencia
	 *            the fechaInicioVigencia to set
	 */
	public void setFechaInicioVigencia(String fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	/**
	 * Método getter del atributo tpDato de la clase DetalleParametroDTO
	 *
	 * @return the tpDato
	 */
	public String getTpDato() {
		return tpDato;
	}

	/**
	 * Método setter del atributo tpDato de la clase DetalleParametroDTO
	 *
	 * @param tpDato
	 *            the tpDato to set
	 */
	public void setTpDato(String tpDato) {
		this.tpDato = tpDato;
	}

	/**
	 * Método getter del atributo nombre de la clase DetalleParametroDTO
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre de la clase DetalleParametroDTO
	 *
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter del atributo idSoiParametro de la clase DetalleParametroDTO
	 *
	 * @return the idSoiParametro
	 */
	public Integer getIdSoiParametro() {
		return idSoiParametro;
	}

	/**
	 * Método setter del atributo idSoiParametro de la clase DetalleParametroDTO
	 *
	 * @param idSoiParametro
	 *            the idSoiParametro to set
	 */
	public void setIdSoiParametro(Integer idSoiParametro) {
		this.idSoiParametro = idSoiParametro;
	}

}

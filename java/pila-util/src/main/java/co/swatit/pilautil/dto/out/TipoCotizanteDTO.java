/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;
import java.math.BigDecimal;

import com.ach.pla.biz.model.TipoCotizanteVO;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link TipoCotizanteVO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class TipoCotizanteDTO implements Serializable {
	/**
	 * Constante de Serialización
	 */
	private static final long serialVersionUID = 1L;
	private Integer necesitaRegistroPrevio;
	private BigDecimal maxSbCantSmmlv;
	private BigDecimal minSbCantSmmlv;
	private String causaFinVigencia;
	private String fechaFinVigencia;
	private String fechaInicioVigencia;
	private Integer vigente;
	private String nombreMostrar;
	private String nombre;
	private String codigo;
	private Integer obligarSbMayorCero;
	private Integer idSoiTpCotizante;

	/**
	 * Método getter del atributo necesitaRegistroPrevio de la clase TipoCotizanteDTO
	 *
	 * @return the necesitaRegistroPrevio
	 */
	public Integer getNecesitaRegistroPrevio() {
		return necesitaRegistroPrevio;
	}

	/**
	 * Método setter del atributo necesitaRegistroPrevio de la clase TipoCotizanteDTO
	 *
	 * @param necesitaRegistroPrevio
	 *            the necesitaRegistroPrevio to set
	 */
	public void setNecesitaRegistroPrevio(Integer necesitaRegistroPrevio) {
		this.necesitaRegistroPrevio = necesitaRegistroPrevio;
	}

	/**
	 * Método getter del atributo maxSbCantSmmlv de la clase TipoCotizanteDTO
	 *
	 * @return the maxSbCantSmmlv
	 */
	public BigDecimal getMaxSbCantSmmlv() {
		return maxSbCantSmmlv;
	}

	/**
	 * Método setter del atributo maxSbCantSmmlv de la clase TipoCotizanteDTO
	 *
	 * @param maxSbCantSmmlv
	 *            the maxSbCantSmmlv to set
	 */
	public void setMaxSbCantSmmlv(BigDecimal maxSbCantSmmlv) {
		this.maxSbCantSmmlv = maxSbCantSmmlv;
	}

	/**
	 * Método getter del atributo minSbCantSmmlv de la clase TipoCotizanteDTO
	 *
	 * @return the minSbCantSmmlv
	 */
	public BigDecimal getMinSbCantSmmlv() {
		return minSbCantSmmlv;
	}

	/**
	 * Método setter del atributo minSbCantSmmlv de la clase TipoCotizanteDTO
	 *
	 * @param minSbCantSmmlv
	 *            the minSbCantSmmlv to set
	 */
	public void setMinSbCantSmmlv(BigDecimal minSbCantSmmlv) {
		this.minSbCantSmmlv = minSbCantSmmlv;
	}

	/**
	 * Método getter del atributo causaFinVigencia de la clase TipoCotizanteDTO
	 *
	 * @return the causaFinVigencia
	 */
	public String getCausaFinVigencia() {
		return causaFinVigencia;
	}

	/**
	 * Método setter del atributo causaFinVigencia de la clase TipoCotizanteDTO
	 *
	 * @param causaFinVigencia
	 *            the causaFinVigencia to set
	 */
	public void setCausaFinVigencia(String causaFinVigencia) {
		this.causaFinVigencia = causaFinVigencia;
	}

	/**
	 * Método getter del atributo fechaFinVigencia de la clase TipoCotizanteDTO
	 *
	 * @return the fechaFinVigencia
	 */
	public String getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	/**
	 * Método setter del atributo fechaFinVigencia de la clase TipoCotizanteDTO
	 *
	 * @param fechaFinVigencia
	 *            the fechaFinVigencia to set
	 */
	public void setFechaFinVigencia(String fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	/**
	 * Método getter del atributo fechaInicioVigencia de la clase TipoCotizanteDTO
	 *
	 * @return the fechaInicioVigencia
	 */
	public String getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	/**
	 * Método setter del atributo fechaInicioVigencia de la clase TipoCotizanteDTO
	 *
	 * @param fechaInicioVigencia
	 *            the fechaInicioVigencia to set
	 */
	public void setFechaInicioVigencia(String fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	/**
	 * Método getter del atributo vigente de la clase TipoCotizanteDTO
	 *
	 * @return the vigente
	 */
	public Integer getVigente() {
		return vigente;
	}

	/**
	 * Método setter del atributo vigente de la clase TipoCotizanteDTO
	 *
	 * @param vigente
	 *            the vigente to set
	 */
	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}

	/**
	 * Método getter del atributo nombreMostrar de la clase TipoCotizanteDTO
	 *
	 * @return the nombreMostrar
	 */
	public String getNombreMostrar() {
		return nombreMostrar;
	}

	/**
	 * Método setter del atributo nombreMostrar de la clase TipoCotizanteDTO
	 *
	 * @param nombreMostrar
	 *            the nombreMostrar to set
	 */
	public void setNombreMostrar(String nombreMostrar) {
		this.nombreMostrar = nombreMostrar;
	}

	/**
	 * Método getter del atributo nombre de la clase TipoCotizanteDTO
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre de la clase TipoCotizanteDTO
	 *
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter del atributo codigo de la clase TipoCotizanteDTO
	 *
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Método setter del atributo codigo de la clase TipoCotizanteDTO
	 *
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Método getter del atributo obligarSbMayorCero de la clase TipoCotizanteDTO
	 *
	 * @return the obligarSbMayorCero
	 */
	public Integer getObligarSbMayorCero() {
		return obligarSbMayorCero;
	}

	/**
	 * Método setter del atributo obligarSbMayorCero de la clase TipoCotizanteDTO
	 *
	 * @param obligarSbMayorCero
	 *            the obligarSbMayorCero to set
	 */
	public void setObligarSbMayorCero(Integer obligarSbMayorCero) {
		this.obligarSbMayorCero = obligarSbMayorCero;
	}

	/**
	 * Método getter del atributo idSoiTpCotizante de la clase TipoCotizanteDTO
	 *
	 * @return the idSoiTpCotizante
	 */
	public Integer getIdSoiTpCotizante() {
		return idSoiTpCotizante;
	}

	/**
	 * Método setter del atributo idSoiTpCotizante de la clase TipoCotizanteDTO
	 *
	 * @param idSoiTpCotizante
	 *            the idSoiTpCotizante to set
	 */
	public void setIdSoiTpCotizante(Integer idSoiTpCotizante) {
		this.idSoiTpCotizante = idSoiTpCotizante;
	}

}

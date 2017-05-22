/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;
import java.math.BigDecimal;

import com.ach.pla.biz.model.SubTipoCotizanteVO;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link SubTipoCotizanteVO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class SubTipoCotizanteDTO implements Serializable {
	/**
	 * Constante de Serialización
	 */
	private static final long serialVersionUID = 1L;
	private Integer necesitaRegistroPrevio;
	private BigDecimal maxSbCantSmmlv;
	private BigDecimal minSbCantSmmlv;
	private Integer extranjeria;
	private String causaFinVigencia;
	private String fechaFinVigencia;
	private String fechaInicioVigencia;
	private Integer vigente;
	private String nombreMostrar;
	private String nombre;
	private String codigo;
	private Integer idSoiSubtpCotizante;

	/**
	 * Método getter del atributo necesitaRegistroPrevio de la clase SubTipoCotizanteDTO
	 *
	 * @return the necesitaRegistroPrevio
	 */
	public Integer getNecesitaRegistroPrevio() {
		return necesitaRegistroPrevio;
	}

	/**
	 * Método setter del atributo necesitaRegistroPrevio de la clase SubTipoCotizanteDTO
	 *
	 * @param necesitaRegistroPrevio
	 *            the necesitaRegistroPrevio to set
	 */
	public void setNecesitaRegistroPrevio(Integer necesitaRegistroPrevio) {
		this.necesitaRegistroPrevio = necesitaRegistroPrevio;
	}

	/**
	 * Método getter del atributo maxSbCantSmmlv de la clase SubTipoCotizanteDTO
	 *
	 * @return the maxSbCantSmmlv
	 */
	public BigDecimal getMaxSbCantSmmlv() {
		return maxSbCantSmmlv;
	}

	/**
	 * Método setter del atributo maxSbCantSmmlv de la clase SubTipoCotizanteDTO
	 *
	 * @param maxSbCantSmmlv
	 *            the maxSbCantSmmlv to set
	 */
	public void setMaxSbCantSmmlv(BigDecimal maxSbCantSmmlv) {
		this.maxSbCantSmmlv = maxSbCantSmmlv;
	}

	/**
	 * Método getter del atributo minSbCantSmmlv de la clase SubTipoCotizanteDTO
	 *
	 * @return the minSbCantSmmlv
	 */
	public BigDecimal getMinSbCantSmmlv() {
		return minSbCantSmmlv;
	}

	/**
	 * Método setter del atributo minSbCantSmmlv de la clase SubTipoCotizanteDTO
	 *
	 * @param minSbCantSmmlv
	 *            the minSbCantSmmlv to set
	 */
	public void setMinSbCantSmmlv(BigDecimal minSbCantSmmlv) {
		this.minSbCantSmmlv = minSbCantSmmlv;
	}

	/**
	 * Método getter del atributo extranjeria de la clase SubTipoCotizanteDTO
	 *
	 * @return the extranjeria
	 */
	public Integer getExtranjeria() {
		return extranjeria;
	}

	/**
	 * Método setter del atributo extranjeria de la clase SubTipoCotizanteDTO
	 *
	 * @param extranjeria
	 *            the extranjeria to set
	 */
	public void setExtranjeria(Integer extranjeria) {
		this.extranjeria = extranjeria;
	}

	/**
	 * Método getter del atributo causaFinVigencia de la clase SubTipoCotizanteDTO
	 *
	 * @return the causaFinVigencia
	 */
	public String getCausaFinVigencia() {
		return causaFinVigencia;
	}

	/**
	 * Método setter del atributo causaFinVigencia de la clase SubTipoCotizanteDTO
	 *
	 * @param causaFinVigencia
	 *            the causaFinVigencia to set
	 */
	public void setCausaFinVigencia(String causaFinVigencia) {
		this.causaFinVigencia = causaFinVigencia;
	}

	/**
	 * Método getter del atributo fechaFinVigencia de la clase SubTipoCotizanteDTO
	 *
	 * @return the fechaFinVigencia
	 */
	public String getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	/**
	 * Método setter del atributo fechaFinVigencia de la clase SubTipoCotizanteDTO
	 *
	 * @param fechaFinVigencia
	 *            the fechaFinVigencia to set
	 */
	public void setFechaFinVigencia(String fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	/**
	 * Método getter del atributo fechaInicioVigencia de la clase SubTipoCotizanteDTO
	 *
	 * @return the fechaInicioVigencia
	 */
	public String getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	/**
	 * Método setter del atributo fechaInicioVigencia de la clase SubTipoCotizanteDTO
	 *
	 * @param fechaInicioVigencia
	 *            the fechaInicioVigencia to set
	 */
	public void setFechaInicioVigencia(String fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	/**
	 * Método getter del atributo vigente de la clase SubTipoCotizanteDTO
	 *
	 * @return the vigente
	 */
	public Integer getVigente() {
		return vigente;
	}

	/**
	 * Método setter del atributo vigente de la clase SubTipoCotizanteDTO
	 *
	 * @param vigente
	 *            the vigente to set
	 */
	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}

	/**
	 * Método getter del atributo nombreMostrar de la clase SubTipoCotizanteDTO
	 *
	 * @return the nombreMostrar
	 */
	public String getNombreMostrar() {
		return nombreMostrar;
	}

	/**
	 * Método setter del atributo nombreMostrar de la clase SubTipoCotizanteDTO
	 *
	 * @param nombreMostrar
	 *            the nombreMostrar to set
	 */
	public void setNombreMostrar(String nombreMostrar) {
		this.nombreMostrar = nombreMostrar;
	}

	/**
	 * Método getter del atributo nombre de la clase SubTipoCotizanteDTO
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre de la clase SubTipoCotizanteDTO
	 *
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter del atributo codigo de la clase SubTipoCotizanteDTO
	 *
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Método setter del atributo codigo de la clase SubTipoCotizanteDTO
	 *
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Método getter del atributo idSoiSubtpCotizante de la clase SubTipoCotizanteDTO
	 *
	 * @return the idSoiSubtpCotizante
	 */
	public Integer getIdSoiSubtpCotizante() {
		return idSoiSubtpCotizante;
	}

	/**
	 * Método setter del atributo idSoiSubtpCotizante de la clase SubTipoCotizanteDTO
	 *
	 * @param idSoiSubtpCotizante
	 *            the idSoiSubtpCotizante to set
	 */
	public void setIdSoiSubtpCotizante(Integer idSoiSubtpCotizante) {
		this.idSoiSubtpCotizante = idSoiSubtpCotizante;
	}

}

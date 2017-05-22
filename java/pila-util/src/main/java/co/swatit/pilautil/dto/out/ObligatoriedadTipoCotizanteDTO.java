/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;
import java.math.BigDecimal;

import com.ach.apt.biz.model.ObligatoriedadTipoCotizanteVO;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link ObligatoriedadTipoCotizanteVO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class ObligatoriedadTipoCotizanteDTO implements Serializable {
	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal maxIbcCotizadoCantSmmlv;
	private BigDecimal minIbcCotizadoCantSmmlv;
	private Integer maxCantDiaCotizado;
	private Integer minCantDiaCotizado;
	private String causaFinVigencia;
	private String fechaFinVigencia;
	private String fechaInicioVigencia;
	private Integer vigente;
	private String tpObligatoriedad;
	private Integer idSoiSubsistema;
	private Integer idSoiTpCotizante;
	private Long idSoiOblgTpCotizante;

	/**
	 * Método getter del atributo maxIbcCotizadoCantSmmlv de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @return the maxIbcCotizadoCantSmmlv
	 */
	public BigDecimal getMaxIbcCotizadoCantSmmlv() {
		return maxIbcCotizadoCantSmmlv;
	}

	/**
	 * Método setter del atributo maxIbcCotizadoCantSmmlv de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @param maxIbcCotizadoCantSmmlv
	 *            the maxIbcCotizadoCantSmmlv to set
	 */
	public void setMaxIbcCotizadoCantSmmlv(BigDecimal maxIbcCotizadoCantSmmlv) {
		this.maxIbcCotizadoCantSmmlv = maxIbcCotizadoCantSmmlv;
	}

	/**
	 * Método getter del atributo minIbcCotizadoCantSmmlv de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @return the minIbcCotizadoCantSmmlv
	 */
	public BigDecimal getMinIbcCotizadoCantSmmlv() {
		return minIbcCotizadoCantSmmlv;
	}

	/**
	 * Método setter del atributo minIbcCotizadoCantSmmlv de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @param minIbcCotizadoCantSmmlv
	 *            the minIbcCotizadoCantSmmlv to set
	 */
	public void setMinIbcCotizadoCantSmmlv(BigDecimal minIbcCotizadoCantSmmlv) {
		this.minIbcCotizadoCantSmmlv = minIbcCotizadoCantSmmlv;
	}

	/**
	 * Método getter del atributo maxCantDiaCotizado de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @return the maxCantDiaCotizado
	 */
	public Integer getMaxCantDiaCotizado() {
		return maxCantDiaCotizado;
	}

	/**
	 * Método setter del atributo maxCantDiaCotizado de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @param maxCantDiaCotizado
	 *            the maxCantDiaCotizado to set
	 */
	public void setMaxCantDiaCotizado(Integer maxCantDiaCotizado) {
		this.maxCantDiaCotizado = maxCantDiaCotizado;
	}

	/**
	 * Método getter del atributo minCantDiaCotizado de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @return the minCantDiaCotizado
	 */
	public Integer getMinCantDiaCotizado() {
		return minCantDiaCotizado;
	}

	/**
	 * Método setter del atributo minCantDiaCotizado de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @param minCantDiaCotizado
	 *            the minCantDiaCotizado to set
	 */
	public void setMinCantDiaCotizado(Integer minCantDiaCotizado) {
		this.minCantDiaCotizado = minCantDiaCotizado;
	}

	/**
	 * Método getter del atributo causaFinVigencia de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @return the causaFinVigencia
	 */
	public String getCausaFinVigencia() {
		return causaFinVigencia;
	}

	/**
	 * Método setter del atributo causaFinVigencia de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @param causaFinVigencia
	 *            the causaFinVigencia to set
	 */
	public void setCausaFinVigencia(String causaFinVigencia) {
		this.causaFinVigencia = causaFinVigencia;
	}

	/**
	 * Método getter del atributo fechaFinVigencia de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @return the fechaFinVigencia
	 */
	public String getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	/**
	 * Método setter del atributo fechaFinVigencia de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @param fechaFinVigencia
	 *            the fechaFinVigencia to set
	 */
	public void setFechaFinVigencia(String fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	/**
	 * Método getter del atributo fechaInicioVigencia de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @return the fechaInicioVigencia
	 */
	public String getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	/**
	 * Método setter del atributo fechaInicioVigencia de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @param fechaInicioVigencia
	 *            the fechaInicioVigencia to set
	 */
	public void setFechaInicioVigencia(String fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	/**
	 * Método getter del atributo vigente de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @return the vigente
	 */
	public Integer getVigente() {
		return vigente;
	}

	/**
	 * Método setter del atributo vigente de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @param vigente
	 *            the vigente to set
	 */
	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}

	/**
	 * Método getter del atributo tpObligatoriedad de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @return the tpObligatoriedad
	 */
	public String getTpObligatoriedad() {
		return tpObligatoriedad;
	}

	/**
	 * Método setter del atributo tpObligatoriedad de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @param tpObligatoriedad
	 *            the tpObligatoriedad to set
	 */
	public void setTpObligatoriedad(String tpObligatoriedad) {
		this.tpObligatoriedad = tpObligatoriedad;
	}

	/**
	 * Método getter del atributo idSoiSubsistema de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @return the idSoiSubsistema
	 */
	public Integer getIdSoiSubsistema() {
		return idSoiSubsistema;
	}

	/**
	 * Método setter del atributo idSoiSubsistema de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @param idSoiSubsistema
	 *            the idSoiSubsistema to set
	 */
	public void setIdSoiSubsistema(Integer idSoiSubsistema) {
		this.idSoiSubsistema = idSoiSubsistema;
	}

	/**
	 * Método getter del atributo idSoiTpCotizante de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @return the idSoiTpCotizante
	 */
	public Integer getIdSoiTpCotizante() {
		return idSoiTpCotizante;
	}

	/**
	 * Método setter del atributo idSoiTpCotizante de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @param idSoiTpCotizante
	 *            the idSoiTpCotizante to set
	 */
	public void setIdSoiTpCotizante(Integer idSoiTpCotizante) {
		this.idSoiTpCotizante = idSoiTpCotizante;
	}

	/**
	 * Método getter del atributo idSoiOblgTpCotizante de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @return the idSoiOblgTpCotizante
	 */
	public Long getIdSoiOblgTpCotizante() {
		return idSoiOblgTpCotizante;
	}

	/**
	 * Método setter del atributo idSoiOblgTpCotizante de la clase ObligatoriedadTipoCotizanteDTO
	 *
	 * @param idSoiOblgTpCotizante
	 *            the idSoiOblgTpCotizante to set
	 */
	public void setIdSoiOblgTpCotizante(Long idSoiOblgTpCotizante) {
		this.idSoiOblgTpCotizante = idSoiOblgTpCotizante;
	}

}

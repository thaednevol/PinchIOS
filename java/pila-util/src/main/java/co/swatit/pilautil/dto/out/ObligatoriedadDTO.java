/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo
 * {@link com.ach.pla.biz.transfer.ObligatoriedadDTO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 7/04/2017
 * @version 1.0
 */
public class ObligatoriedadDTO implements Serializable {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;

	private Integer idSoiTpCotizante;
	private Integer idSoiSubtpCotizante;
	private Long idSoiAportante;
	private Integer idSoiSubsistema;
	private Integer idSoiExtranjeria;
	private String tpObligatoriedad;
	private Integer minCantidadDiasCotizados;
	private Integer maxCantidadDiasCotizados;
	private BigDecimal minIbcCotizadoCantSmmlv;
	private BigDecimal maxIbcCotizadoCantSmmlv;
	private String fechaVigencia;

	/**
	 * Método getter del atributo idSoiTpCotizante de la clase ObligatoriedadDTO
	 *
	 * @return the idSoiTpCotizante
	 */
	public Integer getIdSoiTpCotizante() {
		return idSoiTpCotizante;
	}

	/**
	 * Método setter del atributo idSoiTpCotizante de la clase ObligatoriedadDTO
	 *
	 * @param idSoiTpCotizante
	 *            the idSoiTpCotizante to set
	 */
	public void setIdSoiTpCotizante(Integer idSoiTpCotizante) {
		this.idSoiTpCotizante = idSoiTpCotizante;
	}

	/**
	 * Método getter del atributo idSoiSubtpCotizante de la clase ObligatoriedadDTO
	 *
	 * @return the idSoiSubtpCotizante
	 */
	public Integer getIdSoiSubtpCotizante() {
		return idSoiSubtpCotizante;
	}

	/**
	 * Método setter del atributo idSoiSubtpCotizante de la clase ObligatoriedadDTO
	 *
	 * @param idSoiSubtpCotizante
	 *            the idSoiSubtpCotizante to set
	 */
	public void setIdSoiSubtpCotizante(Integer idSoiSubtpCotizante) {
		this.idSoiSubtpCotizante = idSoiSubtpCotizante;
	}

	/**
	 * Método getter del atributo idSoiAportante de la clase ObligatoriedadDTO
	 *
	 * @return the idSoiAportante
	 */
	public Long getIdSoiAportante() {
		return idSoiAportante;
	}

	/**
	 * Método setter del atributo idSoiAportante de la clase ObligatoriedadDTO
	 *
	 * @param idSoiAportante
	 *            the idSoiAportante to set
	 */
	public void setIdSoiAportante(Long idSoiAportante) {
		this.idSoiAportante = idSoiAportante;
	}

	/**
	 * Método getter del atributo idSoiSubsistema de la clase ObligatoriedadDTO
	 *
	 * @return the idSoiSubsistema
	 */
	public Integer getIdSoiSubsistema() {
		return idSoiSubsistema;
	}

	/**
	 * Método setter del atributo idSoiSubsistema de la clase ObligatoriedadDTO
	 *
	 * @param idSoiSubsistema
	 *            the idSoiSubsistema to set
	 */
	public void setIdSoiSubsistema(Integer idSoiSubsistema) {
		this.idSoiSubsistema = idSoiSubsistema;
	}

	/**
	 * Método getter del atributo idSoiExtranjeria de la clase ObligatoriedadDTO
	 *
	 * @return the idSoiExtranjeria
	 */
	public Integer getIdSoiExtranjeria() {
		return idSoiExtranjeria;
	}

	/**
	 * Método setter del atributo idSoiExtranjeria de la clase ObligatoriedadDTO
	 *
	 * @param idSoiExtranjeria
	 *            the idSoiExtranjeria to set
	 */
	public void setIdSoiExtranjeria(Integer idSoiExtranjeria) {
		this.idSoiExtranjeria = idSoiExtranjeria;
	}

	/**
	 * Método getter del atributo tpObligatoriedad de la clase ObligatoriedadDTO
	 *
	 * @return the tpObligatoriedad
	 */
	public String getTpObligatoriedad() {
		return tpObligatoriedad;
	}

	/**
	 * Método setter del atributo tpObligatoriedad de la clase ObligatoriedadDTO
	 *
	 * @param tpObligatoriedad
	 *            the tpObligatoriedad to set
	 */
	public void setTpObligatoriedad(String tpObligatoriedad) {
		this.tpObligatoriedad = tpObligatoriedad;
	}

	/**
	 * Método getter del atributo minCantidadDiasCotizados de la clase ObligatoriedadDTO
	 *
	 * @return the minCantidadDiasCotizados
	 */
	public Integer getMinCantidadDiasCotizados() {
		return minCantidadDiasCotizados;
	}

	/**
	 * Método setter del atributo minCantidadDiasCotizados de la clase ObligatoriedadDTO
	 *
	 * @param minCantidadDiasCotizados
	 *            the minCantidadDiasCotizados to set
	 */
	public void setMinCantidadDiasCotizados(Integer minCantidadDiasCotizados) {
		this.minCantidadDiasCotizados = minCantidadDiasCotizados;
	}

	/**
	 * Método getter del atributo maxCantidadDiasCotizados de la clase ObligatoriedadDTO
	 *
	 * @return the maxCantidadDiasCotizados
	 */
	public Integer getMaxCantidadDiasCotizados() {
		return maxCantidadDiasCotizados;
	}

	/**
	 * Método setter del atributo maxCantidadDiasCotizados de la clase ObligatoriedadDTO
	 *
	 * @param maxCantidadDiasCotizados
	 *            the maxCantidadDiasCotizados to set
	 */
	public void setMaxCantidadDiasCotizados(Integer maxCantidadDiasCotizados) {
		this.maxCantidadDiasCotizados = maxCantidadDiasCotizados;
	}

	/**
	 * Método getter del atributo minIbcCotizadoCantSmmlv de la clase ObligatoriedadDTO
	 *
	 * @return the minIbcCotizadoCantSmmlv
	 */
	public BigDecimal getMinIbcCotizadoCantSmmlv() {
		return minIbcCotizadoCantSmmlv;
	}

	/**
	 * Método setter del atributo minIbcCotizadoCantSmmlv de la clase ObligatoriedadDTO
	 *
	 * @param minIbcCotizadoCantSmmlv
	 *            the minIbcCotizadoCantSmmlv to set
	 */
	public void setMinIbcCotizadoCantSmmlv(BigDecimal minIbcCotizadoCantSmmlv) {
		this.minIbcCotizadoCantSmmlv = minIbcCotizadoCantSmmlv;
	}

	/**
	 * Método getter del atributo maxIbcCotizadoCantSmmlv de la clase ObligatoriedadDTO
	 *
	 * @return the maxIbcCotizadoCantSmmlv
	 */
	public BigDecimal getMaxIbcCotizadoCantSmmlv() {
		return maxIbcCotizadoCantSmmlv;
	}

	/**
	 * Método setter del atributo maxIbcCotizadoCantSmmlv de la clase ObligatoriedadDTO
	 *
	 * @param maxIbcCotizadoCantSmmlv
	 *            the maxIbcCotizadoCantSmmlv to set
	 */
	public void setMaxIbcCotizadoCantSmmlv(BigDecimal maxIbcCotizadoCantSmmlv) {
		this.maxIbcCotizadoCantSmmlv = maxIbcCotizadoCantSmmlv;
	}

	/**
	 * Método getter del atributo fechaVigencia de la clase ObligatoriedadDTO
	 *
	 * @return the fechaVigencia
	 */
	public String getFechaVigencia() {
		return fechaVigencia;
	}

	/**
	 * Método setter del atributo fechaVigencia de la clase ObligatoriedadDTO
	 *
	 * @param fechaVigencia
	 *            the fechaVigencia to set
	 */
	public void setFechaVigencia(String fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

}

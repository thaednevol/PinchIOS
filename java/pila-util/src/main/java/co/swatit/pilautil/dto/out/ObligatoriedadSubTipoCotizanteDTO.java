/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;

import com.ach.apt.biz.model.ObligatoriedadSubTipoCotizanteVO;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link ObligatoriedadSubTipoCotizanteVO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class ObligatoriedadSubTipoCotizanteDTO implements Serializable {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	private String causaFinVigencia;
	private String fechaFinVigencia;
	private String fechaInicioVigencia;
	private Integer vigente;
	private String tpObligatoriedad;
	private Integer idSoiSubsistema;
	private Integer idSoiSubtpCotizante;
	private Long idSoiOblgSubtpCotizante;

	/**
	 * Método getter del atributo causaFinVigencia de la clase ObligatoriedadSubTipoCotizanteDTO
	 *
	 * @return the causaFinVigencia
	 */
	public String getCausaFinVigencia() {
		return causaFinVigencia;
	}

	/**
	 * Método setter del atributo causaFinVigencia de la clase ObligatoriedadSubTipoCotizanteDTO
	 *
	 * @param causaFinVigencia
	 *            the causaFinVigencia to set
	 */
	public void setCausaFinVigencia(String causaFinVigencia) {
		this.causaFinVigencia = causaFinVigencia;
	}

	/**
	 * Método getter del atributo fechaFinVigencia de la clase ObligatoriedadSubTipoCotizanteDTO
	 *
	 * @return the fechaFinVigencia
	 */
	public String getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	/**
	 * Método setter del atributo fechaFinVigencia de la clase ObligatoriedadSubTipoCotizanteDTO
	 *
	 * @param fechaFinVigencia
	 *            the fechaFinVigencia to set
	 */
	public void setFechaFinVigencia(String fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	/**
	 * Método getter del atributo fechaInicioVigencia de la clase ObligatoriedadSubTipoCotizanteDTO
	 *
	 * @return the fechaInicioVigencia
	 */
	public String getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	/**
	 * Método setter del atributo fechaInicioVigencia de la clase ObligatoriedadSubTipoCotizanteDTO
	 *
	 * @param fechaInicioVigencia
	 *            the fechaInicioVigencia to set
	 */
	public void setFechaInicioVigencia(String fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	/**
	 * Método getter del atributo vigente de la clase ObligatoriedadSubTipoCotizanteDTO
	 *
	 * @return the vigente
	 */
	public Integer getVigente() {
		return vigente;
	}

	/**
	 * Método setter del atributo vigente de la clase ObligatoriedadSubTipoCotizanteDTO
	 *
	 * @param vigente
	 *            the vigente to set
	 */
	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}

	/**
	 * Método getter del atributo tpObligatoriedad de la clase ObligatoriedadSubTipoCotizanteDTO
	 *
	 * @return the tpObligatoriedad
	 */
	public String getTpObligatoriedad() {
		return tpObligatoriedad;
	}

	/**
	 * Método setter del atributo tpObligatoriedad de la clase ObligatoriedadSubTipoCotizanteDTO
	 *
	 * @param tpObligatoriedad
	 *            the tpObligatoriedad to set
	 */
	public void setTpObligatoriedad(String tpObligatoriedad) {
		this.tpObligatoriedad = tpObligatoriedad;
	}

	/**
	 * Método getter del atributo idSoiSubsistema de la clase ObligatoriedadSubTipoCotizanteDTO
	 *
	 * @return the idSoiSubsistema
	 */
	public Integer getIdSoiSubsistema() {
		return idSoiSubsistema;
	}

	/**
	 * Método setter del atributo idSoiSubsistema de la clase ObligatoriedadSubTipoCotizanteDTO
	 *
	 * @param idSoiSubsistema
	 *            the idSoiSubsistema to set
	 */
	public void setIdSoiSubsistema(Integer idSoiSubsistema) {
		this.idSoiSubsistema = idSoiSubsistema;
	}

	/**
	 * Método getter del atributo idSoiSubtpCotizante de la clase ObligatoriedadSubTipoCotizanteDTO
	 *
	 * @return the idSoiSubtpCotizante
	 */
	public Integer getIdSoiSubtpCotizante() {
		return idSoiSubtpCotizante;
	}

	/**
	 * Método setter del atributo idSoiSubtpCotizante de la clase ObligatoriedadSubTipoCotizanteDTO
	 *
	 * @param idSoiSubtpCotizante
	 *            the idSoiSubtpCotizante to set
	 */
	public void setIdSoiSubtpCotizante(Integer idSoiSubtpCotizante) {
		this.idSoiSubtpCotizante = idSoiSubtpCotizante;
	}

	/**
	 * Método getter del atributo idSoiOblgSubtpCotizante de la clase ObligatoriedadSubTipoCotizanteDTO
	 *
	 * @return the idSoiOblgSubtpCotizante
	 */
	public Long getIdSoiOblgSubtpCotizante() {
		return idSoiOblgSubtpCotizante;
	}

	/**
	 * Método setter del atributo idSoiOblgSubtpCotizante de la clase ObligatoriedadSubTipoCotizanteDTO
	 *
	 * @param idSoiOblgSubtpCotizante
	 *            the idSoiOblgSubtpCotizante to set
	 */
	public void setIdSoiOblgSubtpCotizante(Long idSoiOblgSubtpCotizante) {
		this.idSoiOblgSubtpCotizante = idSoiOblgSubtpCotizante;
	}

}

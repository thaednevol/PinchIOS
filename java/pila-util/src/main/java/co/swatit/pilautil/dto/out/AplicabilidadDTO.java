package co.swatit.pilautil.dto.out;

import java.io.Serializable;

/**
 * 
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link com.ach.pla.biz.transfer.AplicabilidadDTO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class AplicabilidadDTO implements Serializable {
	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	private Integer idSoiClaseAportante;
	private Integer idSoiTipoAportante;
	private Integer idSoiTipoPlanilla;
	private String codigoTipoPlanilla;
	private String nombreTipoPlanilla;
	private Integer idOrdenTipoPlanilla;
	private Integer idSoiTipoCotizante;
	private String codigoTipoCotizante;
	private String nombreTipoCotizante;
	private Integer cotizanteIndependiente;
	private Integer idSoiSubTipoCotizante;
	private String codigoSubtipoCotizante;
	private String nombreSubtipoCotizante;
	private Integer idSoiExtranjeria;
	private String codigoExtranjeria;
	private String nombreExtranjeria;
	private Integer idParametroSMMLV;
	private String numeroIdentificacionApte;
	private Integer idIdentificacionApte;
	private Integer extranjeria;
	private String fechaInicioVigenciaTpCzte;
	private String fechaFinVigenciaTpCzte;
	private Long idSoiAplicabilidad;
	private Integer aporteCajaCompensacion;
	private Long idSoiMunicipio;
	private Boolean validarMunicipioTpCotizante;
	private Boolean validarTipoIdentificacionCzte;
	private Boolean origenPlanillaN;
	private Boolean origenPlanillaM;
	private Boolean noAplicaCotizanteConcejal;
	private Boolean filtroPlanillaVigente;
	private Integer planillaVigente;
	private Integer aplicaNyM;
	private Integer tipoEmpresaAplicabilidad;

	/**
	 * Método getter del atributo idSoiClaseAportante de la clase AplicabilidadDTO
	 *
	 * @return the idSoiClaseAportante
	 */
	public Integer getIdSoiClaseAportante() {
		return idSoiClaseAportante;
	}

	/**
	 * Método setter del atributo idSoiClaseAportante de la clase AplicabilidadDTO
	 *
	 * @param idSoiClaseAportante
	 *            the idSoiClaseAportante to set
	 */
	public void setIdSoiClaseAportante(Integer idSoiClaseAportante) {
		this.idSoiClaseAportante = idSoiClaseAportante;
	}

	/**
	 * Método getter del atributo idSoiTipoAportante de la clase AplicabilidadDTO
	 *
	 * @return the idSoiTipoAportante
	 */
	public Integer getIdSoiTipoAportante() {
		return idSoiTipoAportante;
	}

	/**
	 * Método setter del atributo idSoiTipoAportante de la clase AplicabilidadDTO
	 *
	 * @param idSoiTipoAportante
	 *            the idSoiTipoAportante to set
	 */
	public void setIdSoiTipoAportante(Integer idSoiTipoAportante) {
		this.idSoiTipoAportante = idSoiTipoAportante;
	}

	/**
	 * Método getter del atributo idSoiTipoPlanilla de la clase AplicabilidadDTO
	 *
	 * @return the idSoiTipoPlanilla
	 */
	public Integer getIdSoiTipoPlanilla() {
		return idSoiTipoPlanilla;
	}

	/**
	 * Método setter del atributo idSoiTipoPlanilla de la clase AplicabilidadDTO
	 *
	 * @param idSoiTipoPlanilla
	 *            the idSoiTipoPlanilla to set
	 */
	public void setIdSoiTipoPlanilla(Integer idSoiTipoPlanilla) {
		this.idSoiTipoPlanilla = idSoiTipoPlanilla;
	}

	/**
	 * Método getter del atributo codigoTipoPlanilla de la clase AplicabilidadDTO
	 *
	 * @return the codigoTipoPlanilla
	 */
	public String getCodigoTipoPlanilla() {
		return codigoTipoPlanilla;
	}

	/**
	 * Método setter del atributo codigoTipoPlanilla de la clase AplicabilidadDTO
	 *
	 * @param codigoTipoPlanilla
	 *            the codigoTipoPlanilla to set
	 */
	public void setCodigoTipoPlanilla(String codigoTipoPlanilla) {
		this.codigoTipoPlanilla = codigoTipoPlanilla;
	}

	/**
	 * Método getter del atributo nombreTipoPlanilla de la clase AplicabilidadDTO
	 *
	 * @return the nombreTipoPlanilla
	 */
	public String getNombreTipoPlanilla() {
		return nombreTipoPlanilla;
	}

	/**
	 * Método setter del atributo nombreTipoPlanilla de la clase AplicabilidadDTO
	 *
	 * @param nombreTipoPlanilla
	 *            the nombreTipoPlanilla to set
	 */
	public void setNombreTipoPlanilla(String nombreTipoPlanilla) {
		this.nombreTipoPlanilla = nombreTipoPlanilla;
	}

	/**
	 * Método getter del atributo idOrdenTipoPlanilla de la clase AplicabilidadDTO
	 *
	 * @return the idOrdenTipoPlanilla
	 */
	public Integer getIdOrdenTipoPlanilla() {
		return idOrdenTipoPlanilla;
	}

	/**
	 * Método setter del atributo idOrdenTipoPlanilla de la clase AplicabilidadDTO
	 *
	 * @param idOrdenTipoPlanilla
	 *            the idOrdenTipoPlanilla to set
	 */
	public void setIdOrdenTipoPlanilla(Integer idOrdenTipoPlanilla) {
		this.idOrdenTipoPlanilla = idOrdenTipoPlanilla;
	}

	/**
	 * Método getter del atributo idSoiTipoCotizante de la clase AplicabilidadDTO
	 *
	 * @return the idSoiTipoCotizante
	 */
	public Integer getIdSoiTipoCotizante() {
		return idSoiTipoCotizante;
	}

	/**
	 * Método setter del atributo idSoiTipoCotizante de la clase AplicabilidadDTO
	 *
	 * @param idSoiTipoCotizante
	 *            the idSoiTipoCotizante to set
	 */
	public void setIdSoiTipoCotizante(Integer idSoiTipoCotizante) {
		this.idSoiTipoCotizante = idSoiTipoCotizante;
	}

	/**
	 * Método getter del atributo codigoTipoCotizante de la clase AplicabilidadDTO
	 *
	 * @return the codigoTipoCotizante
	 */
	public String getCodigoTipoCotizante() {
		return codigoTipoCotizante;
	}

	/**
	 * Método setter del atributo codigoTipoCotizante de la clase AplicabilidadDTO
	 *
	 * @param codigoTipoCotizante
	 *            the codigoTipoCotizante to set
	 */
	public void setCodigoTipoCotizante(String codigoTipoCotizante) {
		this.codigoTipoCotizante = codigoTipoCotizante;
	}

	/**
	 * Método getter del atributo nombreTipoCotizante de la clase AplicabilidadDTO
	 *
	 * @return the nombreTipoCotizante
	 */
	public String getNombreTipoCotizante() {
		return nombreTipoCotizante;
	}

	/**
	 * Método setter del atributo nombreTipoCotizante de la clase AplicabilidadDTO
	 *
	 * @param nombreTipoCotizante
	 *            the nombreTipoCotizante to set
	 */
	public void setNombreTipoCotizante(String nombreTipoCotizante) {
		this.nombreTipoCotizante = nombreTipoCotizante;
	}

	/**
	 * Método getter del atributo cotizanteIndependiente de la clase AplicabilidadDTO
	 *
	 * @return the cotizanteIndependiente
	 */
	public Integer getCotizanteIndependiente() {
		return cotizanteIndependiente;
	}

	/**
	 * Método setter del atributo cotizanteIndependiente de la clase AplicabilidadDTO
	 *
	 * @param cotizanteIndependiente
	 *            the cotizanteIndependiente to set
	 */
	public void setCotizanteIndependiente(Integer cotizanteIndependiente) {
		this.cotizanteIndependiente = cotizanteIndependiente;
	}

	/**
	 * Método getter del atributo idSoiSubTipoCotizante de la clase AplicabilidadDTO
	 *
	 * @return the idSoiSubTipoCotizante
	 */
	public Integer getIdSoiSubTipoCotizante() {
		return idSoiSubTipoCotizante;
	}

	/**
	 * Método setter del atributo idSoiSubTipoCotizante de la clase AplicabilidadDTO
	 *
	 * @param idSoiSubTipoCotizante
	 *            the idSoiSubTipoCotizante to set
	 */
	public void setIdSoiSubTipoCotizante(Integer idSoiSubTipoCotizante) {
		this.idSoiSubTipoCotizante = idSoiSubTipoCotizante;
	}

	/**
	 * Método getter del atributo codigoSubtipoCotizante de la clase AplicabilidadDTO
	 *
	 * @return the codigoSubtipoCotizante
	 */
	public String getCodigoSubtipoCotizante() {
		return codigoSubtipoCotizante;
	}

	/**
	 * Método setter del atributo codigoSubtipoCotizante de la clase AplicabilidadDTO
	 *
	 * @param codigoSubtipoCotizante
	 *            the codigoSubtipoCotizante to set
	 */
	public void setCodigoSubtipoCotizante(String codigoSubtipoCotizante) {
		this.codigoSubtipoCotizante = codigoSubtipoCotizante;
	}

	/**
	 * Método getter del atributo nombreSubtipoCotizante de la clase AplicabilidadDTO
	 *
	 * @return the nombreSubtipoCotizante
	 */
	public String getNombreSubtipoCotizante() {
		return nombreSubtipoCotizante;
	}

	/**
	 * Método setter del atributo nombreSubtipoCotizante de la clase AplicabilidadDTO
	 *
	 * @param nombreSubtipoCotizante
	 *            the nombreSubtipoCotizante to set
	 */
	public void setNombreSubtipoCotizante(String nombreSubtipoCotizante) {
		this.nombreSubtipoCotizante = nombreSubtipoCotizante;
	}

	/**
	 * Método getter del atributo idSoiExtranjeria de la clase AplicabilidadDTO
	 *
	 * @return the idSoiExtranjeria
	 */
	public Integer getIdSoiExtranjeria() {
		return idSoiExtranjeria;
	}

	/**
	 * Método setter del atributo idSoiExtranjeria de la clase AplicabilidadDTO
	 *
	 * @param idSoiExtranjeria
	 *            the idSoiExtranjeria to set
	 */
	public void setIdSoiExtranjeria(Integer idSoiExtranjeria) {
		this.idSoiExtranjeria = idSoiExtranjeria;
	}

	/**
	 * Método getter del atributo codigoExtranjeria de la clase AplicabilidadDTO
	 *
	 * @return the codigoExtranjeria
	 */
	public String getCodigoExtranjeria() {
		return codigoExtranjeria;
	}

	/**
	 * Método setter del atributo codigoExtranjeria de la clase AplicabilidadDTO
	 *
	 * @param codigoExtranjeria
	 *            the codigoExtranjeria to set
	 */
	public void setCodigoExtranjeria(String codigoExtranjeria) {
		this.codigoExtranjeria = codigoExtranjeria;
	}

	/**
	 * Método getter del atributo nombreExtranjeria de la clase AplicabilidadDTO
	 *
	 * @return the nombreExtranjeria
	 */
	public String getNombreExtranjeria() {
		return nombreExtranjeria;
	}

	/**
	 * Método setter del atributo nombreExtranjeria de la clase AplicabilidadDTO
	 *
	 * @param nombreExtranjeria
	 *            the nombreExtranjeria to set
	 */
	public void setNombreExtranjeria(String nombreExtranjeria) {
		this.nombreExtranjeria = nombreExtranjeria;
	}

	/**
	 * Método getter del atributo idParametroSMMLV de la clase AplicabilidadDTO
	 *
	 * @return the idParametroSMMLV
	 */
	public Integer getIdParametroSMMLV() {
		return idParametroSMMLV;
	}

	/**
	 * Método setter del atributo idParametroSMMLV de la clase AplicabilidadDTO
	 *
	 * @param idParametroSMMLV
	 *            the idParametroSMMLV to set
	 */
	public void setIdParametroSMMLV(Integer idParametroSMMLV) {
		this.idParametroSMMLV = idParametroSMMLV;
	}

	/**
	 * Método getter del atributo numeroIdentificacionApte de la clase AplicabilidadDTO
	 *
	 * @return the numeroIdentificacionApte
	 */
	public String getNumeroIdentificacionApte() {
		return numeroIdentificacionApte;
	}

	/**
	 * Método setter del atributo numeroIdentificacionApte de la clase AplicabilidadDTO
	 *
	 * @param numeroIdentificacionApte
	 *            the numeroIdentificacionApte to set
	 */
	public void setNumeroIdentificacionApte(String numeroIdentificacionApte) {
		this.numeroIdentificacionApte = numeroIdentificacionApte;
	}

	/**
	 * Método getter del atributo idIdentificacionApte de la clase AplicabilidadDTO
	 *
	 * @return the idIdentificacionApte
	 */
	public Integer getIdIdentificacionApte() {
		return idIdentificacionApte;
	}

	/**
	 * Método setter del atributo idIdentificacionApte de la clase AplicabilidadDTO
	 *
	 * @param idIdentificacionApte
	 *            the idIdentificacionApte to set
	 */
	public void setIdIdentificacionApte(Integer idIdentificacionApte) {
		this.idIdentificacionApte = idIdentificacionApte;
	}

	/**
	 * Método getter del atributo extranjeria de la clase AplicabilidadDTO
	 *
	 * @return the extranjeria
	 */
	public Integer getExtranjeria() {
		return extranjeria;
	}

	/**
	 * Método setter del atributo extranjeria de la clase AplicabilidadDTO
	 *
	 * @param extranjeria
	 *            the extranjeria to set
	 */
	public void setExtranjeria(Integer extranjeria) {
		this.extranjeria = extranjeria;
	}

	/**
	 * Método getter del atributo fechaInicioVigenciaTpCzte de la clase AplicabilidadDTO
	 *
	 * @return the fechaInicioVigenciaTpCzte
	 */
	public String getFechaInicioVigenciaTpCzte() {
		return fechaInicioVigenciaTpCzte;
	}

	/**
	 * Método setter del atributo fechaInicioVigenciaTpCzte de la clase AplicabilidadDTO
	 *
	 * @param fechaInicioVigenciaTpCzte
	 *            the fechaInicioVigenciaTpCzte to set
	 */
	public void setFechaInicioVigenciaTpCzte(String fechaInicioVigenciaTpCzte) {
		this.fechaInicioVigenciaTpCzte = fechaInicioVigenciaTpCzte;
	}

	/**
	 * Método getter del atributo fechaFinVigenciaTpCzte de la clase AplicabilidadDTO
	 *
	 * @return the fechaFinVigenciaTpCzte
	 */
	public String getFechaFinVigenciaTpCzte() {
		return fechaFinVigenciaTpCzte;
	}

	/**
	 * Método setter del atributo fechaFinVigenciaTpCzte de la clase AplicabilidadDTO
	 *
	 * @param fechaFinVigenciaTpCzte
	 *            the fechaFinVigenciaTpCzte to set
	 */
	public void setFechaFinVigenciaTpCzte(String fechaFinVigenciaTpCzte) {
		this.fechaFinVigenciaTpCzte = fechaFinVigenciaTpCzte;
	}

	/**
	 * Método getter del atributo idSoiAplicabilidad de la clase AplicabilidadDTO
	 *
	 * @return the idSoiAplicabilidad
	 */
	public Long getIdSoiAplicabilidad() {
		return idSoiAplicabilidad;
	}

	/**
	 * Método setter del atributo idSoiAplicabilidad de la clase AplicabilidadDTO
	 *
	 * @param idSoiAplicabilidad
	 *            the idSoiAplicabilidad to set
	 */
	public void setIdSoiAplicabilidad(Long idSoiAplicabilidad) {
		this.idSoiAplicabilidad = idSoiAplicabilidad;
	}

	/**
	 * Método getter del atributo aporteCajaCompensacion de la clase AplicabilidadDTO
	 *
	 * @return the aporteCajaCompensacion
	 */
	public Integer getAporteCajaCompensacion() {
		return aporteCajaCompensacion;
	}

	/**
	 * Método setter del atributo aporteCajaCompensacion de la clase AplicabilidadDTO
	 *
	 * @param aporteCajaCompensacion
	 *            the aporteCajaCompensacion to set
	 */
	public void setAporteCajaCompensacion(Integer aporteCajaCompensacion) {
		this.aporteCajaCompensacion = aporteCajaCompensacion;
	}

	/**
	 * Método getter del atributo idSoiMunicipio de la clase AplicabilidadDTO
	 *
	 * @return the idSoiMunicipio
	 */
	public Long getIdSoiMunicipio() {
		return idSoiMunicipio;
	}

	/**
	 * Método setter del atributo idSoiMunicipio de la clase AplicabilidadDTO
	 *
	 * @param idSoiMunicipio
	 *            the idSoiMunicipio to set
	 */
	public void setIdSoiMunicipio(Long idSoiMunicipio) {
		this.idSoiMunicipio = idSoiMunicipio;
	}

	/**
	 * Método getter del atributo validarMunicipioTpCotizante de la clase AplicabilidadDTO
	 *
	 * @return the validarMunicipioTpCotizante
	 */
	public Boolean getValidarMunicipioTpCotizante() {
		return validarMunicipioTpCotizante;
	}

	/**
	 * Método setter del atributo validarMunicipioTpCotizante de la clase AplicabilidadDTO
	 *
	 * @param validarMunicipioTpCotizante
	 *            the validarMunicipioTpCotizante to set
	 */
	public void setValidarMunicipioTpCotizante(Boolean validarMunicipioTpCotizante) {
		this.validarMunicipioTpCotizante = validarMunicipioTpCotizante;
	}

	/**
	 * Método getter del atributo validarTipoIdentificacionCzte de la clase AplicabilidadDTO
	 *
	 * @return the validarTipoIdentificacionCzte
	 */
	public Boolean getValidarTipoIdentificacionCzte() {
		return validarTipoIdentificacionCzte;
	}

	/**
	 * Método setter del atributo validarTipoIdentificacionCzte de la clase AplicabilidadDTO
	 *
	 * @param validarTipoIdentificacionCzte
	 *            the validarTipoIdentificacionCzte to set
	 */
	public void setValidarTipoIdentificacionCzte(Boolean validarTipoIdentificacionCzte) {
		this.validarTipoIdentificacionCzte = validarTipoIdentificacionCzte;
	}

	/**
	 * Método getter del atributo origenPlanillaN de la clase AplicabilidadDTO
	 *
	 * @return the origenPlanillaN
	 */
	public Boolean getOrigenPlanillaN() {
		return origenPlanillaN;
	}

	/**
	 * Método setter del atributo origenPlanillaN de la clase AplicabilidadDTO
	 *
	 * @param origenPlanillaN
	 *            the origenPlanillaN to set
	 */
	public void setOrigenPlanillaN(Boolean origenPlanillaN) {
		this.origenPlanillaN = origenPlanillaN;
	}

	/**
	 * Método getter del atributo origenPlanillaM de la clase AplicabilidadDTO
	 *
	 * @return the origenPlanillaM
	 */
	public Boolean getOrigenPlanillaM() {
		return origenPlanillaM;
	}

	/**
	 * Método setter del atributo origenPlanillaM de la clase AplicabilidadDTO
	 *
	 * @param origenPlanillaM
	 *            the origenPlanillaM to set
	 */
	public void setOrigenPlanillaM(Boolean origenPlanillaM) {
		this.origenPlanillaM = origenPlanillaM;
	}

	/**
	 * Método getter del atributo noAplicaCotizanteConcejal de la clase AplicabilidadDTO
	 *
	 * @return the noAplicaCotizanteConcejal
	 */
	public Boolean getNoAplicaCotizanteConcejal() {
		return noAplicaCotizanteConcejal;
	}

	/**
	 * Método setter del atributo noAplicaCotizanteConcejal de la clase AplicabilidadDTO
	 *
	 * @param noAplicaCotizanteConcejal
	 *            the noAplicaCotizanteConcejal to set
	 */
	public void setNoAplicaCotizanteConcejal(Boolean noAplicaCotizanteConcejal) {
		this.noAplicaCotizanteConcejal = noAplicaCotizanteConcejal;
	}

	/**
	 * Método getter del atributo filtroPlanillaVigente de la clase AplicabilidadDTO
	 *
	 * @return the filtroPlanillaVigente
	 */
	public Boolean getFiltroPlanillaVigente() {
		return filtroPlanillaVigente;
	}

	/**
	 * Método setter del atributo filtroPlanillaVigente de la clase AplicabilidadDTO
	 *
	 * @param filtroPlanillaVigente
	 *            the filtroPlanillaVigente to set
	 */
	public void setFiltroPlanillaVigente(Boolean filtroPlanillaVigente) {
		this.filtroPlanillaVigente = filtroPlanillaVigente;
	}

	/**
	 * Método getter del atributo planillaVigente de la clase AplicabilidadDTO
	 *
	 * @return the planillaVigente
	 */
	public Integer getPlanillaVigente() {
		return planillaVigente;
	}

	/**
	 * Método setter del atributo planillaVigente de la clase AplicabilidadDTO
	 *
	 * @param planillaVigente
	 *            the planillaVigente to set
	 */
	public void setPlanillaVigente(Integer planillaVigente) {
		this.planillaVigente = planillaVigente;
	}

	/**
	 * Método getter del atributo aplicaNyM de la clase AplicabilidadDTO
	 *
	 * @return the aplicaNyM
	 */
	public Integer getAplicaNyM() {
		return aplicaNyM;
	}

	/**
	 * Método setter del atributo aplicaNyM de la clase AplicabilidadDTO
	 *
	 * @param aplicaNyM
	 *            the aplicaNyM to set
	 */
	public void setAplicaNyM(Integer aplicaNyM) {
		this.aplicaNyM = aplicaNyM;
	}

	/**
	 * Método getter del atributo tipoEmpresaAplicabilidad de la clase AplicabilidadDTO
	 *
	 * @return the tipoEmpresaAplicabilidad
	 */
	public Integer getTipoEmpresaAplicabilidad() {
		return tipoEmpresaAplicabilidad;
	}

	/**
	 * Método setter del atributo tipoEmpresaAplicabilidad de la clase AplicabilidadDTO
	 *
	 * @param tipoEmpresaAplicabilidad
	 *            the tipoEmpresaAplicabilidad to set
	 */
	public void setTipoEmpresaAplicabilidad(Integer tipoEmpresaAplicabilidad) {
		this.tipoEmpresaAplicabilidad = tipoEmpresaAplicabilidad;
	}

}

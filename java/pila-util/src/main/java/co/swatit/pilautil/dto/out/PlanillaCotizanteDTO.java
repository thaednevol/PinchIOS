/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo
 * {@link com.ach.pla.biz.transfer.PlanillaCotizanteDTO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 7/04/2017
 * @version 1.0
 */
public class PlanillaCotizanteDTO implements Serializable {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;

	private Boolean modificado;
	private Boolean seleccionado;
	private Integer indiceCotizante;
	private String exoneradoParafiscales;
	private Long tiempoEjb0;
	private Long tiempoEjb1;
	private Boolean mostrarDiasLaborados;
	private String numeroDiasLaborados;
	private Long idSoiCotizante;
	private Integer idWebCotizante;
	private Integer idWebSlnComCotizante;
	private DatosBasicosCotizanteDTO datosBasicosCotizanteDTO;
	private List<NovedadDTO> novedades;
	private List<AporteSubsistemaDTO> aportesSubsistemas;
	private List<NovedadDTO> novedadSLNCOMdeDiasLaborados;
	private List<ObligatoriedadDTO> opcionesObligatoriedad;
	private PlanillaCotizanteDTO cotizanteA;
	private PlanillaCotizanteDTO cotizanteC;
	private Boolean aplicaFSP;
	private Boolean cargadoPlanillaAnteriorPagada;
	private Boolean esCotizanteSln;
	private Boolean esCotizanteCom;
	private Boolean cotizanteLey1607;
	private Boolean validarArpEntPub;
	private String novedadSLNCOM;
	private Integer idGrupoCotizantesPlanillaN;
	private Boolean existeConfiguracionTpCzte4;
	private String codAdminSaludBdua;
	private Integer coincidenciaBdua;
	private String codAdminPensionBdua;
	private String valorUpcBdua;
	private String codAfpReportada;
	private ResultadoValidacionBduaDTO resultadoValidacionBduaDTO;
	private Boolean concuerdaTarifaSalud;
	private Boolean concuerdaTarifaArp;
	private Boolean origenPlanillaPagada;
	private Boolean esCotizante23;
	private Integer secuencia;
	private Boolean adminEditable;
	private Boolean upcEditable;
	private Boolean valorUpcModificado;
	private String primerNombreArchivo;
	private String segundoNombreArchivo;
	private String primerApellidoArchivo;
	private String segundoApellidoArchivo;
	private String codAdministradoraEpsArchivo;
	private Boolean esPlanillaNReferidaT;
	private BigDecimal valorBecaMadreSustituta;
	private Boolean administradoraEpsRegC;
	private Long ibcOtrosParafiscales;
	private Long numeroHorasLaboradas;
	private Boolean calculosDiasIBC;
	private Boolean liquidacionSoloFsp;
	private Boolean repCztesMultiples;
	private Boolean planillaJReferida;
	private Boolean validacionOffline;
	private Boolean czteDependienteNr415;
	private Boolean sinAportePension;
	private String jsonAportesSubsistemasString;

	/**
	 * Método getter del atributo modificado de la clase PlanillaCotizanteDTO
	 *
	 * @return the modificado
	 */
	public Boolean getModificado() {
		return modificado;
	}

	/**
	 * Método setter del atributo modificado de la clase PlanillaCotizanteDTO
	 *
	 * @param modificado
	 *            the modificado to set
	 */
	public void setModificado(Boolean modificado) {
		this.modificado = modificado;
	}

	/**
	 * Método getter del atributo seleccionado de la clase PlanillaCotizanteDTO
	 *
	 * @return the seleccionado
	 */
	public Boolean getSeleccionado() {
		return seleccionado;
	}

	/**
	 * Método setter del atributo seleccionado de la clase PlanillaCotizanteDTO
	 *
	 * @param seleccionado
	 *            the seleccionado to set
	 */
	public void setSeleccionado(Boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	/**
	 * Método getter del atributo indiceCotizante de la clase PlanillaCotizanteDTO
	 *
	 * @return the indiceCotizante
	 */
	public Integer getIndiceCotizante() {
		return indiceCotizante;
	}

	/**
	 * Método setter del atributo indiceCotizante de la clase PlanillaCotizanteDTO
	 *
	 * @param indiceCotizante
	 *            the indiceCotizante to set
	 */
	public void setIndiceCotizante(Integer indiceCotizante) {
		this.indiceCotizante = indiceCotizante;
	}

	/**
	 * Método getter del atributo exoneradoParafiscales de la clase PlanillaCotizanteDTO
	 *
	 * @return the exoneradoParafiscales
	 */
	public String getExoneradoParafiscales() {
		return exoneradoParafiscales;
	}

	/**
	 * Método setter del atributo exoneradoParafiscales de la clase PlanillaCotizanteDTO
	 *
	 * @param exoneradoParafiscales
	 *            the exoneradoParafiscales to set
	 */
	public void setExoneradoParafiscales(String exoneradoParafiscales) {
		this.exoneradoParafiscales = exoneradoParafiscales;
	}

	/**
	 * Método getter del atributo tiempoEjb0 de la clase PlanillaCotizanteDTO
	 *
	 * @return the tiempoEjb0
	 */
	public Long getTiempoEjb0() {
		return tiempoEjb0;
	}

	/**
	 * Método setter del atributo tiempoEjb0 de la clase PlanillaCotizanteDTO
	 *
	 * @param tiempoEjb0
	 *            the tiempoEjb0 to set
	 */
	public void setTiempoEjb0(Long tiempoEjb0) {
		this.tiempoEjb0 = tiempoEjb0;
	}

	/**
	 * Método getter del atributo tiempoEjb1 de la clase PlanillaCotizanteDTO
	 *
	 * @return the tiempoEjb1
	 */
	public Long getTiempoEjb1() {
		return tiempoEjb1;
	}

	/**
	 * Método setter del atributo tiempoEjb1 de la clase PlanillaCotizanteDTO
	 *
	 * @param tiempoEjb1
	 *            the tiempoEjb1 to set
	 */
	public void setTiempoEjb1(Long tiempoEjb1) {
		this.tiempoEjb1 = tiempoEjb1;
	}

	/**
	 * Método getter del atributo mostrarDiasLaborados de la clase PlanillaCotizanteDTO
	 *
	 * @return the mostrarDiasLaborados
	 */
	public Boolean getMostrarDiasLaborados() {
		return mostrarDiasLaborados;
	}

	/**
	 * Método setter del atributo mostrarDiasLaborados de la clase PlanillaCotizanteDTO
	 *
	 * @param mostrarDiasLaborados
	 *            the mostrarDiasLaborados to set
	 */
	public void setMostrarDiasLaborados(Boolean mostrarDiasLaborados) {
		this.mostrarDiasLaborados = mostrarDiasLaborados;
	}

	/**
	 * Método getter del atributo numeroDiasLaborados de la clase PlanillaCotizanteDTO
	 *
	 * @return the numeroDiasLaborados
	 */
	public String getNumeroDiasLaborados() {
		return numeroDiasLaborados;
	}

	/**
	 * Método setter del atributo numeroDiasLaborados de la clase PlanillaCotizanteDTO
	 *
	 * @param numeroDiasLaborados
	 *            the numeroDiasLaborados to set
	 */
	public void setNumeroDiasLaborados(String numeroDiasLaborados) {
		this.numeroDiasLaborados = numeroDiasLaborados;
	}

	/**
	 * Método getter del atributo idSoiCotizante de la clase PlanillaCotizanteDTO
	 *
	 * @return the idSoiCotizante
	 */
	public Long getIdSoiCotizante() {
		return idSoiCotizante;
	}

	/**
	 * Método setter del atributo idSoiCotizante de la clase PlanillaCotizanteDTO
	 *
	 * @param idSoiCotizante
	 *            the idSoiCotizante to set
	 */
	public void setIdSoiCotizante(Long idSoiCotizante) {
		this.idSoiCotizante = idSoiCotizante;
	}

	/**
	 * Método getter del atributo idWebCotizante de la clase PlanillaCotizanteDTO
	 *
	 * @return the idWebCotizante
	 */
	public Integer getIdWebCotizante() {
		return idWebCotizante;
	}

	/**
	 * Método setter del atributo idWebCotizante de la clase PlanillaCotizanteDTO
	 *
	 * @param idWebCotizante
	 *            the idWebCotizante to set
	 */
	public void setIdWebCotizante(Integer idWebCotizante) {
		this.idWebCotizante = idWebCotizante;
	}

	/**
	 * Método getter del atributo idWebSlnComCotizante de la clase PlanillaCotizanteDTO
	 *
	 * @return the idWebSlnComCotizante
	 */
	public Integer getIdWebSlnComCotizante() {
		return idWebSlnComCotizante;
	}

	/**
	 * Método setter del atributo idWebSlnComCotizante de la clase PlanillaCotizanteDTO
	 *
	 * @param idWebSlnComCotizante
	 *            the idWebSlnComCotizante to set
	 */
	public void setIdWebSlnComCotizante(Integer idWebSlnComCotizante) {
		this.idWebSlnComCotizante = idWebSlnComCotizante;
	}

	/**
	 * Método getter del atributo datosBasicosCotizanteDTO de la clase PlanillaCotizanteDTO
	 *
	 * @return the datosBasicosCotizanteDTO
	 */
	public DatosBasicosCotizanteDTO getDatosBasicosCotizanteDTO() {
		return datosBasicosCotizanteDTO;
	}

	/**
	 * Método setter del atributo datosBasicosCotizanteDTO de la clase PlanillaCotizanteDTO
	 *
	 * @param datosBasicosCotizanteDTO
	 *            the datosBasicosCotizanteDTO to set
	 */
	public void setDatosBasicosCotizanteDTO(DatosBasicosCotizanteDTO datosBasicosCotizanteDTO) {
		this.datosBasicosCotizanteDTO = datosBasicosCotizanteDTO;
	}

	/**
	 * Método getter del atributo novedades de la clase PlanillaCotizanteDTO
	 *
	 * @return the novedades
	 */
	public List<NovedadDTO> getNovedades() {
		if (novedades == null) {
			novedades = new ArrayList<NovedadDTO>();
		}
		return novedades;
	}

	/**
	 * Método getter del atributo aportesSubsistemas de la clase PlanillaCotizanteDTO
	 *
	 * @return the aportesSubsistemas
	 */
	public List<AporteSubsistemaDTO> getAportesSubsistemas() {
		if (aportesSubsistemas == null) {
			aportesSubsistemas = new ArrayList<AporteSubsistemaDTO>();
		}
		return aportesSubsistemas;
	}

	/**
	 * Método getter del atributo novedadSLNCOMdeDiasLaborados de la clase PlanillaCotizanteDTO
	 *
	 * @return the novedadSLNCOMdeDiasLaborados
	 */
	public List<NovedadDTO> getNovedadSLNCOMdeDiasLaborados() {
		if (novedadSLNCOMdeDiasLaborados == null) {
			novedadSLNCOMdeDiasLaborados = new ArrayList<NovedadDTO>();
		}
		return novedadSLNCOMdeDiasLaborados;
	}

	/**
	 * Método getter del atributo opcionesObligatoriedad de la clase PlanillaCotizanteDTO
	 *
	 * @return the opcionesObligatoriedad
	 */
	public List<ObligatoriedadDTO> getOpcionesObligatoriedad() {
		if (opcionesObligatoriedad == null) {
			opcionesObligatoriedad = new ArrayList<ObligatoriedadDTO>();
		}
		return opcionesObligatoriedad;
	}

	/**
	 * Método getter del atributo cotizanteA de la clase PlanillaCotizanteDTO
	 *
	 * @return the cotizanteA
	 */
	public PlanillaCotizanteDTO getCotizanteA() {
		return cotizanteA;
	}

	/**
	 * Método setter del atributo cotizanteA de la clase PlanillaCotizanteDTO
	 *
	 * @param cotizanteA
	 *            the cotizanteA to set
	 */
	public void setCotizanteA(PlanillaCotizanteDTO cotizanteA) {
		this.cotizanteA = cotizanteA;
	}

	/**
	 * Método getter del atributo cotizanteC de la clase PlanillaCotizanteDTO
	 *
	 * @return the cotizanteC
	 */
	public PlanillaCotizanteDTO getCotizanteC() {
		return cotizanteC;
	}

	/**
	 * Método setter del atributo cotizanteC de la clase PlanillaCotizanteDTO
	 *
	 * @param cotizanteC
	 *            the cotizanteC to set
	 */
	public void setCotizanteC(PlanillaCotizanteDTO cotizanteC) {
		this.cotizanteC = cotizanteC;
	}

	/**
	 * Método getter del atributo aplicaFSP de la clase PlanillaCotizanteDTO
	 *
	 * @return the aplicaFSP
	 */
	public Boolean getAplicaFSP() {
		return aplicaFSP;
	}

	/**
	 * Método setter del atributo aplicaFSP de la clase PlanillaCotizanteDTO
	 *
	 * @param aplicaFSP
	 *            the aplicaFSP to set
	 */
	public void setAplicaFSP(Boolean aplicaFSP) {
		this.aplicaFSP = aplicaFSP;
	}

	/**
	 * Método getter del atributo cargadoPlanillaAnteriorPagada de la clase PlanillaCotizanteDTO
	 *
	 * @return the cargadoPlanillaAnteriorPagada
	 */
	public Boolean getCargadoPlanillaAnteriorPagada() {
		return cargadoPlanillaAnteriorPagada;
	}

	/**
	 * Método setter del atributo cargadoPlanillaAnteriorPagada de la clase PlanillaCotizanteDTO
	 *
	 * @param cargadoPlanillaAnteriorPagada
	 *            the cargadoPlanillaAnteriorPagada to set
	 */
	public void setCargadoPlanillaAnteriorPagada(Boolean cargadoPlanillaAnteriorPagada) {
		this.cargadoPlanillaAnteriorPagada = cargadoPlanillaAnteriorPagada;
	}

	/**
	 * Método getter del atributo esCotizanteSln de la clase PlanillaCotizanteDTO
	 *
	 * @return the esCotizanteSln
	 */
	public Boolean getEsCotizanteSln() {
		return esCotizanteSln;
	}

	/**
	 * Método setter del atributo esCotizanteSln de la clase PlanillaCotizanteDTO
	 *
	 * @param esCotizanteSln
	 *            the esCotizanteSln to set
	 */
	public void setEsCotizanteSln(Boolean esCotizanteSln) {
		this.esCotizanteSln = esCotizanteSln;
	}

	/**
	 * Método getter del atributo esCotizanteCom de la clase PlanillaCotizanteDTO
	 *
	 * @return the esCotizanteCom
	 */
	public Boolean getEsCotizanteCom() {
		return esCotizanteCom;
	}

	/**
	 * Método setter del atributo esCotizanteCom de la clase PlanillaCotizanteDTO
	 *
	 * @param esCotizanteCom
	 *            the esCotizanteCom to set
	 */
	public void setEsCotizanteCom(Boolean esCotizanteCom) {
		this.esCotizanteCom = esCotizanteCom;
	}

	/**
	 * Método getter del atributo cotizanteLey1607 de la clase PlanillaCotizanteDTO
	 *
	 * @return the cotizanteLey1607
	 */
	public Boolean getCotizanteLey1607() {
		return cotizanteLey1607;
	}

	/**
	 * Método setter del atributo cotizanteLey1607 de la clase PlanillaCotizanteDTO
	 *
	 * @param cotizanteLey1607
	 *            the cotizanteLey1607 to set
	 */
	public void setCotizanteLey1607(Boolean cotizanteLey1607) {
		this.cotizanteLey1607 = cotizanteLey1607;
	}

	/**
	 * Método getter del atributo validarArpEntPub de la clase PlanillaCotizanteDTO
	 *
	 * @return the validarArpEntPub
	 */
	public Boolean getValidarArpEntPub() {
		return validarArpEntPub;
	}

	/**
	 * Método setter del atributo validarArpEntPub de la clase PlanillaCotizanteDTO
	 *
	 * @param validarArpEntPub
	 *            the validarArpEntPub to set
	 */
	public void setValidarArpEntPub(Boolean validarArpEntPub) {
		this.validarArpEntPub = validarArpEntPub;
	}

	/**
	 * Método getter del atributo novedadSLNCOM de la clase PlanillaCotizanteDTO
	 *
	 * @return the novedadSLNCOM
	 */
	public String getNovedadSLNCOM() {
		return novedadSLNCOM;
	}

	/**
	 * Método setter del atributo novedadSLNCOM de la clase PlanillaCotizanteDTO
	 *
	 * @param novedadSLNCOM
	 *            the novedadSLNCOM to set
	 */
	public void setNovedadSLNCOM(String novedadSLNCOM) {
		this.novedadSLNCOM = novedadSLNCOM;
	}

	/**
	 * Método getter del atributo idGrupoCotizantesPlanillaN de la clase PlanillaCotizanteDTO
	 *
	 * @return the idGrupoCotizantesPlanillaN
	 */
	public Integer getIdGrupoCotizantesPlanillaN() {
		return idGrupoCotizantesPlanillaN;
	}

	/**
	 * Método setter del atributo idGrupoCotizantesPlanillaN de la clase PlanillaCotizanteDTO
	 *
	 * @param idGrupoCotizantesPlanillaN
	 *            the idGrupoCotizantesPlanillaN to set
	 */
	public void setIdGrupoCotizantesPlanillaN(Integer idGrupoCotizantesPlanillaN) {
		this.idGrupoCotizantesPlanillaN = idGrupoCotizantesPlanillaN;
	}

	/**
	 * Método getter del atributo existeConfiguracionTpCzte4 de la clase PlanillaCotizanteDTO
	 *
	 * @return the existeConfiguracionTpCzte4
	 */
	public Boolean getExisteConfiguracionTpCzte4() {
		return existeConfiguracionTpCzte4;
	}

	/**
	 * Método setter del atributo existeConfiguracionTpCzte4 de la clase PlanillaCotizanteDTO
	 *
	 * @param existeConfiguracionTpCzte4
	 *            the existeConfiguracionTpCzte4 to set
	 */
	public void setExisteConfiguracionTpCzte4(Boolean existeConfiguracionTpCzte4) {
		this.existeConfiguracionTpCzte4 = existeConfiguracionTpCzte4;
	}

	/**
	 * Método getter del atributo codAdminSaludBdua de la clase PlanillaCotizanteDTO
	 *
	 * @return the codAdminSaludBdua
	 */
	public String getCodAdminSaludBdua() {
		return codAdminSaludBdua;
	}

	/**
	 * Método setter del atributo codAdminSaludBdua de la clase PlanillaCotizanteDTO
	 *
	 * @param codAdminSaludBdua
	 *            the codAdminSaludBdua to set
	 */
	public void setCodAdminSaludBdua(String codAdminSaludBdua) {
		this.codAdminSaludBdua = codAdminSaludBdua;
	}

	/**
	 * Método getter del atributo coincidenciaBdua de la clase PlanillaCotizanteDTO
	 *
	 * @return the coincidenciaBdua
	 */
	public Integer getCoincidenciaBdua() {
		return coincidenciaBdua;
	}

	/**
	 * Método setter del atributo coincidenciaBdua de la clase PlanillaCotizanteDTO
	 *
	 * @param coincidenciaBdua
	 *            the coincidenciaBdua to set
	 */
	public void setCoincidenciaBdua(Integer coincidenciaBdua) {
		this.coincidenciaBdua = coincidenciaBdua;
	}

	/**
	 * Método getter del atributo codAdminPensionBdua de la clase PlanillaCotizanteDTO
	 *
	 * @return the codAdminPensionBdua
	 */
	public String getCodAdminPensionBdua() {
		return codAdminPensionBdua;
	}

	/**
	 * Método setter del atributo codAdminPensionBdua de la clase PlanillaCotizanteDTO
	 *
	 * @param codAdminPensionBdua
	 *            the codAdminPensionBdua to set
	 */
	public void setCodAdminPensionBdua(String codAdminPensionBdua) {
		this.codAdminPensionBdua = codAdminPensionBdua;
	}

	/**
	 * Método getter del atributo valorUpcBdua de la clase PlanillaCotizanteDTO
	 *
	 * @return the valorUpcBdua
	 */
	public String getValorUpcBdua() {
		return valorUpcBdua;
	}

	/**
	 * Método setter del atributo valorUpcBdua de la clase PlanillaCotizanteDTO
	 *
	 * @param valorUpcBdua
	 *            the valorUpcBdua to set
	 */
	public void setValorUpcBdua(String valorUpcBdua) {
		this.valorUpcBdua = valorUpcBdua;
	}

	/**
	 * Método getter del atributo codAfpReportada de la clase PlanillaCotizanteDTO
	 *
	 * @return the codAfpReportada
	 */
	public String getCodAfpReportada() {
		return codAfpReportada;
	}

	/**
	 * Método setter del atributo codAfpReportada de la clase PlanillaCotizanteDTO
	 *
	 * @param codAfpReportada
	 *            the codAfpReportada to set
	 */
	public void setCodAfpReportada(String codAfpReportada) {
		this.codAfpReportada = codAfpReportada;
	}

	/**
	 * Método getter del atributo resultadoValidacionBduaDTO de la clase PlanillaCotizanteDTO
	 *
	 * @return the resultadoValidacionBduaDTO
	 */
	public ResultadoValidacionBduaDTO getResultadoValidacionBduaDTO() {
		return resultadoValidacionBduaDTO;
	}

	/**
	 * Método setter del atributo resultadoValidacionBduaDTO de la clase PlanillaCotizanteDTO
	 *
	 * @param resultadoValidacionBduaDTO
	 *            the resultadoValidacionBduaDTO to set
	 */
	public void setResultadoValidacionBduaDTO(ResultadoValidacionBduaDTO resultadoValidacionBduaDTO) {
		this.resultadoValidacionBduaDTO = resultadoValidacionBduaDTO;
	}

	/**
	 * Método getter del atributo concuerdaTarifaSalud de la clase PlanillaCotizanteDTO
	 *
	 * @return the concuerdaTarifaSalud
	 */
	public Boolean getConcuerdaTarifaSalud() {
		return concuerdaTarifaSalud;
	}

	/**
	 * Método setter del atributo concuerdaTarifaSalud de la clase PlanillaCotizanteDTO
	 *
	 * @param concuerdaTarifaSalud
	 *            the concuerdaTarifaSalud to set
	 */
	public void setConcuerdaTarifaSalud(Boolean concuerdaTarifaSalud) {
		this.concuerdaTarifaSalud = concuerdaTarifaSalud;
	}

	/**
	 * Método getter del atributo concuerdaTarifaArp de la clase PlanillaCotizanteDTO
	 *
	 * @return the concuerdaTarifaArp
	 */
	public Boolean getConcuerdaTarifaArp() {
		return concuerdaTarifaArp;
	}

	/**
	 * Método setter del atributo concuerdaTarifaArp de la clase PlanillaCotizanteDTO
	 *
	 * @param concuerdaTarifaArp
	 *            the concuerdaTarifaArp to set
	 */
	public void setConcuerdaTarifaArp(Boolean concuerdaTarifaArp) {
		this.concuerdaTarifaArp = concuerdaTarifaArp;
	}

	/**
	 * Método getter del atributo origenPlanillaPagada de la clase PlanillaCotizanteDTO
	 *
	 * @return the origenPlanillaPagada
	 */
	public Boolean getOrigenPlanillaPagada() {
		return origenPlanillaPagada;
	}

	/**
	 * Método setter del atributo origenPlanillaPagada de la clase PlanillaCotizanteDTO
	 *
	 * @param origenPlanillaPagada
	 *            the origenPlanillaPagada to set
	 */
	public void setOrigenPlanillaPagada(Boolean origenPlanillaPagada) {
		this.origenPlanillaPagada = origenPlanillaPagada;
	}

	/**
	 * Método getter del atributo esCotizante23 de la clase PlanillaCotizanteDTO
	 *
	 * @return the esCotizante23
	 */
	public Boolean getEsCotizante23() {
		return esCotizante23;
	}

	/**
	 * Método setter del atributo esCotizante23 de la clase PlanillaCotizanteDTO
	 *
	 * @param esCotizante23
	 *            the esCotizante23 to set
	 */
	public void setEsCotizante23(Boolean esCotizante23) {
		this.esCotizante23 = esCotizante23;
	}

	/**
	 * Método getter del atributo secuencia de la clase PlanillaCotizanteDTO
	 *
	 * @return the secuencia
	 */
	public Integer getSecuencia() {
		return secuencia;
	}

	/**
	 * Método setter del atributo secuencia de la clase PlanillaCotizanteDTO
	 *
	 * @param secuencia
	 *            the secuencia to set
	 */
	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

	/**
	 * Método getter del atributo adminEditable de la clase PlanillaCotizanteDTO
	 *
	 * @return the adminEditable
	 */
	public Boolean getAdminEditable() {
		return adminEditable;
	}

	/**
	 * Método setter del atributo adminEditable de la clase PlanillaCotizanteDTO
	 *
	 * @param adminEditable
	 *            the adminEditable to set
	 */
	public void setAdminEditable(Boolean adminEditable) {
		this.adminEditable = adminEditable;
	}

	/**
	 * Método getter del atributo valorUpcModificado de la clase PlanillaCotizanteDTO
	 *
	 * @return the valorUpcModificado
	 */
	public Boolean getValorUpcModificado() {
		return valorUpcModificado;
	}

	/**
	 * Método setter del atributo valorUpcModificado de la clase PlanillaCotizanteDTO
	 *
	 * @param valorUpcModificado
	 *            the valorUpcModificado to set
	 */
	public void setValorUpcModificado(Boolean valorUpcModificado) {
		this.valorUpcModificado = valorUpcModificado;
	}

	/**
	 * Método getter del atributo primerNombreArchivo de la clase PlanillaCotizanteDTO
	 *
	 * @return the primerNombreArchivo
	 */
	public String getPrimerNombreArchivo() {
		return primerNombreArchivo;
	}

	/**
	 * Método setter del atributo primerNombreArchivo de la clase PlanillaCotizanteDTO
	 *
	 * @param primerNombreArchivo
	 *            the primerNombreArchivo to set
	 */
	public void setPrimerNombreArchivo(String primerNombreArchivo) {
		this.primerNombreArchivo = primerNombreArchivo;
	}

	/**
	 * Método getter del atributo segundoNombreArchivo de la clase PlanillaCotizanteDTO
	 *
	 * @return the segundoNombreArchivo
	 */
	public String getSegundoNombreArchivo() {
		return segundoNombreArchivo;
	}

	/**
	 * Método setter del atributo segundoNombreArchivo de la clase PlanillaCotizanteDTO
	 *
	 * @param segundoNombreArchivo
	 *            the segundoNombreArchivo to set
	 */
	public void setSegundoNombreArchivo(String segundoNombreArchivo) {
		this.segundoNombreArchivo = segundoNombreArchivo;
	}

	/**
	 * Método getter del atributo primerApellidoArchivo de la clase PlanillaCotizanteDTO
	 *
	 * @return the primerApellidoArchivo
	 */
	public String getPrimerApellidoArchivo() {
		return primerApellidoArchivo;
	}

	/**
	 * Método setter del atributo primerApellidoArchivo de la clase PlanillaCotizanteDTO
	 *
	 * @param primerApellidoArchivo
	 *            the primerApellidoArchivo to set
	 */
	public void setPrimerApellidoArchivo(String primerApellidoArchivo) {
		this.primerApellidoArchivo = primerApellidoArchivo;
	}

	/**
	 * Método getter del atributo segundoApellidoArchivo de la clase PlanillaCotizanteDTO
	 *
	 * @return the segundoApellidoArchivo
	 */
	public String getSegundoApellidoArchivo() {
		return segundoApellidoArchivo;
	}

	/**
	 * Método setter del atributo segundoApellidoArchivo de la clase PlanillaCotizanteDTO
	 *
	 * @param segundoApellidoArchivo
	 *            the segundoApellidoArchivo to set
	 */
	public void setSegundoApellidoArchivo(String segundoApellidoArchivo) {
		this.segundoApellidoArchivo = segundoApellidoArchivo;
	}

	/**
	 * Método getter del atributo codAdministradoraEpsArchivo de la clase PlanillaCotizanteDTO
	 *
	 * @return the codAdministradoraEpsArchivo
	 */
	public String getCodAdministradoraEpsArchivo() {
		return codAdministradoraEpsArchivo;
	}

	/**
	 * Método setter del atributo codAdministradoraEpsArchivo de la clase PlanillaCotizanteDTO
	 *
	 * @param codAdministradoraEpsArchivo
	 *            the codAdministradoraEpsArchivo to set
	 */
	public void setCodAdministradoraEpsArchivo(String codAdministradoraEpsArchivo) {
		this.codAdministradoraEpsArchivo = codAdministradoraEpsArchivo;
	}

	/**
	 * Método getter del atributo esPlanillaNReferidaT de la clase PlanillaCotizanteDTO
	 *
	 * @return the esPlanillaNReferidaT
	 */
	public Boolean getEsPlanillaNReferidaT() {
		return esPlanillaNReferidaT;
	}

	/**
	 * Método setter del atributo esPlanillaNReferidaT de la clase PlanillaCotizanteDTO
	 *
	 * @param esPlanillaNReferidaT
	 *            the esPlanillaNReferidaT to set
	 */
	public void setEsPlanillaNReferidaT(Boolean esPlanillaNReferidaT) {
		this.esPlanillaNReferidaT = esPlanillaNReferidaT;
	}

	/**
	 * Método getter del atributo valorBecaMadreSustituta de la clase PlanillaCotizanteDTO
	 *
	 * @return the valorBecaMadreSustituta
	 */
	public BigDecimal getValorBecaMadreSustituta() {
		return valorBecaMadreSustituta;
	}

	/**
	 * Método setter del atributo valorBecaMadreSustituta de la clase PlanillaCotizanteDTO
	 *
	 * @param valorBecaMadreSustituta
	 *            the valorBecaMadreSustituta to set
	 */
	public void setValorBecaMadreSustituta(BigDecimal valorBecaMadreSustituta) {
		this.valorBecaMadreSustituta = valorBecaMadreSustituta;
	}

	/**
	 * Método getter del atributo administradoraEpsRegC de la clase PlanillaCotizanteDTO
	 *
	 * @return the administradoraEpsRegC
	 */
	public Boolean getAdministradoraEpsRegC() {
		return administradoraEpsRegC;
	}

	/**
	 * Método setter del atributo administradoraEpsRegC de la clase PlanillaCotizanteDTO
	 *
	 * @param administradoraEpsRegC
	 *            the administradoraEpsRegC to set
	 */
	public void setAdministradoraEpsRegC(Boolean administradoraEpsRegC) {
		this.administradoraEpsRegC = administradoraEpsRegC;
	}

	/**
	 * Método getter del atributo ibcOtrosParafiscales de la clase PlanillaCotizanteDTO
	 *
	 * @return the ibcOtrosParafiscales
	 */
	public Long getIbcOtrosParafiscales() {
		return ibcOtrosParafiscales;
	}

	/**
	 * Método setter del atributo ibcOtrosParafiscales de la clase PlanillaCotizanteDTO
	 *
	 * @param ibcOtrosParafiscales
	 *            the ibcOtrosParafiscales to set
	 */
	public void setIbcOtrosParafiscales(Long ibcOtrosParafiscales) {
		this.ibcOtrosParafiscales = ibcOtrosParafiscales;
	}

	/**
	 * Método getter del atributo numeroHorasLaboradas de la clase PlanillaCotizanteDTO
	 *
	 * @return the numeroHorasLaboradas
	 */
	public Long getNumeroHorasLaboradas() {
		return numeroHorasLaboradas;
	}

	/**
	 * Método setter del atributo numeroHorasLaboradas de la clase PlanillaCotizanteDTO
	 *
	 * @param numeroHorasLaboradas
	 *            the numeroHorasLaboradas to set
	 */
	public void setNumeroHorasLaboradas(Long numeroHorasLaboradas) {
		this.numeroHorasLaboradas = numeroHorasLaboradas;
	}

	/**
	 * Método getter del atributo calculosDiasIBC de la clase PlanillaCotizanteDTO
	 *
	 * @return the calculosDiasIBC
	 */
	public Boolean getCalculosDiasIBC() {
		return calculosDiasIBC;
	}

	/**
	 * Método setter del atributo calculosDiasIBC de la clase PlanillaCotizanteDTO
	 *
	 * @param calculosDiasIBC
	 *            the calculosDiasIBC to set
	 */
	public void setCalculosDiasIBC(Boolean calculosDiasIBC) {
		this.calculosDiasIBC = calculosDiasIBC;
	}

	/**
	 * Método getter del atributo liquidacionSoloFsp de la clase PlanillaCotizanteDTO
	 *
	 * @return the liquidacionSoloFsp
	 */
	public Boolean getLiquidacionSoloFsp() {
		return liquidacionSoloFsp;
	}

	/**
	 * Método setter del atributo liquidacionSoloFsp de la clase PlanillaCotizanteDTO
	 *
	 * @param liquidacionSoloFsp
	 *            the liquidacionSoloFsp to set
	 */
	public void setLiquidacionSoloFsp(Boolean liquidacionSoloFsp) {
		this.liquidacionSoloFsp = liquidacionSoloFsp;
	}

	/**
	 * Método getter del atributo repCztesMultiples de la clase PlanillaCotizanteDTO
	 *
	 * @return the repCztesMultiples
	 */
	public Boolean getRepCztesMultiples() {
		return repCztesMultiples;
	}

	/**
	 * Método setter del atributo repCztesMultiples de la clase PlanillaCotizanteDTO
	 *
	 * @param repCztesMultiples
	 *            the repCztesMultiples to set
	 */
	public void setRepCztesMultiples(Boolean repCztesMultiples) {
		this.repCztesMultiples = repCztesMultiples;
	}

	/**
	 * Método getter del atributo planillaJReferida de la clase PlanillaCotizanteDTO
	 *
	 * @return the planillaJReferida
	 */
	public Boolean getPlanillaJReferida() {
		return planillaJReferida;
	}

	/**
	 * Método setter del atributo planillaJReferida de la clase PlanillaCotizanteDTO
	 *
	 * @param planillaJReferida
	 *            the planillaJReferida to set
	 */
	public void setPlanillaJReferida(Boolean planillaJReferida) {
		this.planillaJReferida = planillaJReferida;
	}

	/**
	 * Método getter del atributo validacionOffline de la clase PlanillaCotizanteDTO
	 *
	 * @return the validacionOffline
	 */
	public Boolean getValidacionOffline() {
		return validacionOffline;
	}

	/**
	 * Método setter del atributo validacionOffline de la clase PlanillaCotizanteDTO
	 *
	 * @param validacionOffline
	 *            the validacionOffline to set
	 */
	public void setValidacionOffline(Boolean validacionOffline) {
		this.validacionOffline = validacionOffline;
	}

	/**
	 * Método getter del atributo czteDependienteNr415 de la clase PlanillaCotizanteDTO
	 *
	 * @return the czteDependienteNr415
	 */
	public Boolean getCzteDependienteNr415() {
		return czteDependienteNr415;
	}

	/**
	 * Método setter del atributo czteDependienteNr415 de la clase PlanillaCotizanteDTO
	 *
	 * @param czteDependienteNr415
	 *            the czteDependienteNr415 to set
	 */
	public void setCzteDependienteNr415(Boolean czteDependienteNr415) {
		this.czteDependienteNr415 = czteDependienteNr415;
	}

	/**
	 * Método getter del atributo sinAportePension de la clase PlanillaCotizanteDTO
	 *
	 * @return the sinAportePension
	 */
	public Boolean getSinAportePension() {
		return sinAportePension;
	}

	/**
	 * Método setter del atributo sinAportePension de la clase PlanillaCotizanteDTO
	 *
	 * @param sinAportePension
	 *            the sinAportePension to set
	 */
	public void setSinAportePension(Boolean sinAportePension) {
		this.sinAportePension = sinAportePension;
	}

	/**
	 * Método getter del atributo upcEditable de la clase PlanillaCotizanteDTO
	 *
	 * @return the upcEditable
	 */
	public Boolean getUpcEditable() {
		return upcEditable;
	}

	/**
	 * Método setter del atributo upcEditable de la clase PlanillaCotizanteDTO
	 *
	 * @param upcEditable
	 *            the upcEditable to set
	 */
	public void setUpcEditable(Boolean upcEditable) {
		this.upcEditable = upcEditable;
	}

	/**
	 * Método getter del atributo jsonAportesSubsistemasString de la clase PlanillaCotizanteDTO
	 *
	 * @return the jsonAportesSubsistemasString
	 */
	public String getJsonAportesSubsistemasString() {
		return jsonAportesSubsistemasString;
	}

	/**
	 * Método setter del atributo jsonAportesSubsistemasString de la clase PlanillaCotizanteDTO
	 *
	 * @param jsonAportesSubsistemasString
	 *            the jsonAportesSubsistemasString to set
	 */
	public void setJsonAportesSubsistemasString(String jsonAportesSubsistemasString) {
		this.jsonAportesSubsistemasString = jsonAportesSubsistemasString;
	}
}

/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;
import java.math.BigDecimal;

import com.ach.pla.biz.model.AporteSubsistemaVO;

/**
 * Objeto de transporte resultado de la conversión de objetos {@link AporteSubsistemaVO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 7/04/2017
 * @version 1.0
 */
public class AporteSubsistemaDTO implements Serializable {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idAdministradora;
	private String codigoAdministradora;
	private String nombreAdministradora;
	private Integer nroDiasSubsistema;
	private BigDecimal ibcSubsistema;
	private BigDecimal tarifaSubsistema;
	private BigDecimal valorAporteSubsistema;
	private String tipoSubSistemasType;
	private Integer idClaseRiesgo;
	private String codClaseRiesgo;
	private String centroTrabajo;
	private BigDecimal ibcSinRedondeo;
	private Boolean ibcEditado;
	private Boolean diasEditado;
	private String nroAutorizacionIGE;
	private BigDecimal valorAutorizacionIGE;
	private String nroAutorizacionLMA;
	private BigDecimal valorAutorizacionLMA;
	private BigDecimal valorUPC;
	private Boolean incluirArcSalida;
	private Boolean cotizanteAyCincluidosEnArcSalida;
	private Boolean eliminarAporte;
	private Boolean validacionDiasMaximo;
	private Integer nroDiasSubsistemaMaximo;
	private String indicadorTarifaEspecialPen;
	private BigDecimal ibcOtrosParafiscales;
	private Integer horasLaboradas;

	/**
	 * Método getter del atributo idAdministradora de la clase AporteSubsistemaDTO
	 *
	 * @return the idAdministradora
	 */
	public Integer getIdAdministradora() {
		return idAdministradora;
	}

	/**
	 * Método setter del atributo idAdministradora de la clase AporteSubsistemaDTO
	 *
	 * @param idAdministradora
	 *            the idAdministradora to set
	 */
	public void setIdAdministradora(Integer idAdministradora) {
		this.idAdministradora = idAdministradora;
	}

	/**
	 * Método getter del atributo codigoAdministradora de la clase AporteSubsistemaDTO
	 *
	 * @return the codigoAdministradora
	 */
	public String getCodigoAdministradora() {
		return codigoAdministradora;
	}

	/**
	 * Método setter del atributo codigoAdministradora de la clase AporteSubsistemaDTO
	 *
	 * @param codigoAdministradora
	 *            the codigoAdministradora to set
	 */
	public void setCodigoAdministradora(String codigoAdministradora) {
		this.codigoAdministradora = codigoAdministradora;
	}

	/**
	 * Método getter del atributo nombreAdministradora de la clase AporteSubsistemaDTO
	 *
	 * @return the nombreAdministradora
	 */
	public String getNombreAdministradora() {
		return nombreAdministradora;
	}

	/**
	 * Método setter del atributo nombreAdministradora de la clase AporteSubsistemaDTO
	 *
	 * @param nombreAdministradora
	 *            the nombreAdministradora to set
	 */
	public void setNombreAdministradora(String nombreAdministradora) {
		this.nombreAdministradora = nombreAdministradora;
	}

	/**
	 * Método getter del atributo nroDiasSubsistema de la clase AporteSubsistemaDTO
	 *
	 * @return the nroDiasSubsistema
	 */
	public Integer getNroDiasSubsistema() {
		return nroDiasSubsistema;
	}

	/**
	 * Método setter del atributo nroDiasSubsistema de la clase AporteSubsistemaDTO
	 *
	 * @param nroDiasSubsistema
	 *            the nroDiasSubsistema to set
	 */
	public void setNroDiasSubsistema(Integer nroDiasSubsistema) {
		this.nroDiasSubsistema = nroDiasSubsistema;
	}

	/**
	 * Método getter del atributo ibcSubsistema de la clase AporteSubsistemaDTO
	 *
	 * @return the ibcSubsistema
	 */
	public BigDecimal getIbcSubsistema() {
		return ibcSubsistema;
	}

	/**
	 * Método setter del atributo ibcSubsistema de la clase AporteSubsistemaDTO
	 *
	 * @param ibcSubsistema
	 *            the ibcSubsistema to set
	 */
	public void setIbcSubsistema(BigDecimal ibcSubsistema) {
		this.ibcSubsistema = ibcSubsistema;
	}

	/**
	 * Método getter del atributo tarifaSubsistema de la clase AporteSubsistemaDTO
	 *
	 * @return the tarifaSubsistema
	 */
	public BigDecimal getTarifaSubsistema() {
		return tarifaSubsistema;
	}

	/**
	 * Método setter del atributo tarifaSubsistema de la clase AporteSubsistemaDTO
	 *
	 * @param tarifaSubsistema
	 *            the tarifaSubsistema to set
	 */
	public void setTarifaSubsistema(BigDecimal tarifaSubsistema) {
		this.tarifaSubsistema = tarifaSubsistema;
	}

	/**
	 * Método getter del atributo valorAporteSubsistema de la clase AporteSubsistemaDTO
	 *
	 * @return the valorAporteSubsistema
	 */
	public BigDecimal getValorAporteSubsistema() {
		return valorAporteSubsistema;
	}

	/**
	 * Método setter del atributo valorAporteSubsistema de la clase AporteSubsistemaDTO
	 *
	 * @param valorAporteSubsistema
	 *            the valorAporteSubsistema to set
	 */
	public void setValorAporteSubsistema(BigDecimal valorAporteSubsistema) {
		this.valorAporteSubsistema = valorAporteSubsistema;
	}

	/**
	 * Método getter del atributo tipoSubSistemasType de la clase AporteSubsistemaDTO
	 *
	 * @return the tipoSubSistemasType
	 */
	public String getTipoSubSistemasType() {
		return tipoSubSistemasType;
	}

	/**
	 * Método setter del atributo tipoSubSistemasType de la clase AporteSubsistemaDTO
	 *
	 * @param tipoSubSistemasType
	 *            the tipoSubSistemasType to set
	 */
	public void setTipoSubSistemasType(String tipoSubSistemasType) {
		this.tipoSubSistemasType = tipoSubSistemasType;
	}

	/**
	 * Método getter del atributo idClaseRiesgo de la clase AporteSubsistemaDTO
	 *
	 * @return the idClaseRiesgo
	 */
	public Integer getIdClaseRiesgo() {
		return idClaseRiesgo;
	}

	/**
	 * Método setter del atributo idClaseRiesgo de la clase AporteSubsistemaDTO
	 *
	 * @param idClaseRiesgo
	 *            the idClaseRiesgo to set
	 */
	public void setIdClaseRiesgo(Integer idClaseRiesgo) {
		this.idClaseRiesgo = idClaseRiesgo;
	}

	/**
	 * Método getter del atributo codClaseRiesgo de la clase AporteSubsistemaDTO
	 *
	 * @return the codClaseRiesgo
	 */
	public String getCodClaseRiesgo() {
		return codClaseRiesgo;
	}

	/**
	 * Método setter del atributo codClaseRiesgo de la clase AporteSubsistemaDTO
	 *
	 * @param codClaseRiesgo
	 *            the codClaseRiesgo to set
	 */
	public void setCodClaseRiesgo(String codClaseRiesgo) {
		this.codClaseRiesgo = codClaseRiesgo;
	}

	/**
	 * Método getter del atributo centroTrabajo de la clase AporteSubsistemaDTO
	 *
	 * @return the centroTrabajo
	 */
	public String getCentroTrabajo() {
		return centroTrabajo;
	}

	/**
	 * Método setter del atributo centroTrabajo de la clase AporteSubsistemaDTO
	 *
	 * @param centroTrabajo
	 *            the centroTrabajo to set
	 */
	public void setCentroTrabajo(String centroTrabajo) {
		this.centroTrabajo = centroTrabajo;
	}

	/**
	 * Método getter del atributo ibcSinRedondeo de la clase AporteSubsistemaDTO
	 *
	 * @return the ibcSinRedondeo
	 */
	public BigDecimal getIbcSinRedondeo() {
		return ibcSinRedondeo;
	}

	/**
	 * Método setter del atributo ibcSinRedondeo de la clase AporteSubsistemaDTO
	 *
	 * @param ibcSinRedondeo
	 *            the ibcSinRedondeo to set
	 */
	public void setIbcSinRedondeo(BigDecimal ibcSinRedondeo) {
		this.ibcSinRedondeo = ibcSinRedondeo;
	}

	/**
	 * Método getter del atributo ibcEditado de la clase AporteSubsistemaDTO
	 *
	 * @return the ibcEditado
	 */
	public Boolean getIbcEditado() {
		return ibcEditado;
	}

	/**
	 * Método setter del atributo ibcEditado de la clase AporteSubsistemaDTO
	 *
	 * @param ibcEditado
	 *            the ibcEditado to set
	 */
	public void setIbcEditado(Boolean ibcEditado) {
		this.ibcEditado = ibcEditado;
	}

	/**
	 * Método getter del atributo diasEditado de la clase AporteSubsistemaDTO
	 *
	 * @return the diasEditado
	 */
	public Boolean getDiasEditado() {
		return diasEditado;
	}

	/**
	 * Método setter del atributo diasEditado de la clase AporteSubsistemaDTO
	 *
	 * @param diasEditado
	 *            the diasEditado to set
	 */
	public void setDiasEditado(Boolean diasEditado) {
		this.diasEditado = diasEditado;
	}

	/**
	 * Método getter del atributo nroAutorizacionIGE de la clase AporteSubsistemaDTO
	 *
	 * @return the nroAutorizacionIGE
	 */
	public String getNroAutorizacionIGE() {
		return nroAutorizacionIGE;
	}

	/**
	 * Método setter del atributo nroAutorizacionIGE de la clase AporteSubsistemaDTO
	 *
	 * @param nroAutorizacionIGE
	 *            the nroAutorizacionIGE to set
	 */
	public void setNroAutorizacionIGE(String nroAutorizacionIGE) {
		this.nroAutorizacionIGE = nroAutorizacionIGE;
	}

	/**
	 * Método getter del atributo valorAutorizacionIGE de la clase AporteSubsistemaDTO
	 *
	 * @return the valorAutorizacionIGE
	 */
	public BigDecimal getValorAutorizacionIGE() {
		return valorAutorizacionIGE;
	}

	/**
	 * Método setter del atributo valorAutorizacionIGE de la clase AporteSubsistemaDTO
	 *
	 * @param valorAutorizacionIGE
	 *            the valorAutorizacionIGE to set
	 */
	public void setValorAutorizacionIGE(BigDecimal valorAutorizacionIGE) {
		this.valorAutorizacionIGE = valorAutorizacionIGE;
	}

	/**
	 * Método getter del atributo nroAutorizacionLMA de la clase AporteSubsistemaDTO
	 *
	 * @return the nroAutorizacionLMA
	 */
	public String getNroAutorizacionLMA() {
		return nroAutorizacionLMA;
	}

	/**
	 * Método setter del atributo nroAutorizacionLMA de la clase AporteSubsistemaDTO
	 *
	 * @param nroAutorizacionLMA
	 *            the nroAutorizacionLMA to set
	 */
	public void setNroAutorizacionLMA(String nroAutorizacionLMA) {
		this.nroAutorizacionLMA = nroAutorizacionLMA;
	}

	/**
	 * Método getter del atributo valorAutorizacionLMA de la clase AporteSubsistemaDTO
	 *
	 * @return the valorAutorizacionLMA
	 */
	public BigDecimal getValorAutorizacionLMA() {
		return valorAutorizacionLMA;
	}

	/**
	 * Método setter del atributo valorAutorizacionLMA de la clase AporteSubsistemaDTO
	 *
	 * @param valorAutorizacionLMA
	 *            the valorAutorizacionLMA to set
	 */
	public void setValorAutorizacionLMA(BigDecimal valorAutorizacionLMA) {
		this.valorAutorizacionLMA = valorAutorizacionLMA;
	}

	/**
	 * Método getter del atributo valorUPC de la clase AporteSubsistemaDTO
	 *
	 * @return the valorUPC
	 */
	public BigDecimal getValorUPC() {
		return valorUPC;
	}

	/**
	 * Método setter del atributo valorUPC de la clase AporteSubsistemaDTO
	 *
	 * @param valorUPC
	 *            the valorUPC to set
	 */
	public void setValorUPC(BigDecimal valorUPC) {
		this.valorUPC = valorUPC;
	}

	/**
	 * Método getter del atributo incluirArcSalida de la clase AporteSubsistemaDTO
	 *
	 * @return the incluirArcSalida
	 */
	public Boolean getIncluirArcSalida() {
		return incluirArcSalida;
	}

	/**
	 * Método setter del atributo incluirArcSalida de la clase AporteSubsistemaDTO
	 *
	 * @param incluirArcSalida
	 *            the incluirArcSalida to set
	 */
	public void setIncluirArcSalida(Boolean incluirArcSalida) {
		this.incluirArcSalida = incluirArcSalida;
	}

	/**
	 * Método getter del atributo cotizanteAyCincluidosEnArcSalida de la clase AporteSubsistemaDTO
	 *
	 * @return the cotizanteAyCincluidosEnArcSalida
	 */
	public Boolean getCotizanteAyCincluidosEnArcSalida() {
		return cotizanteAyCincluidosEnArcSalida;
	}

	/**
	 * Método setter del atributo cotizanteAyCincluidosEnArcSalida de la clase AporteSubsistemaDTO
	 *
	 * @param cotizanteAyCincluidosEnArcSalida
	 *            the cotizanteAyCincluidosEnArcSalida to set
	 */
	public void setCotizanteAyCincluidosEnArcSalida(Boolean cotizanteAyCincluidosEnArcSalida) {
		this.cotizanteAyCincluidosEnArcSalida = cotizanteAyCincluidosEnArcSalida;
	}

	/**
	 * Método getter del atributo eliminarAporte de la clase AporteSubsistemaDTO
	 *
	 * @return the eliminarAporte
	 */
	public Boolean getEliminarAporte() {
		return eliminarAporte;
	}

	/**
	 * Método setter del atributo eliminarAporte de la clase AporteSubsistemaDTO
	 *
	 * @param eliminarAporte
	 *            the eliminarAporte to set
	 */
	public void setEliminarAporte(Boolean eliminarAporte) {
		this.eliminarAporte = eliminarAporte;
	}

	/**
	 * Método getter del atributo validacionDiasMaximo de la clase AporteSubsistemaDTO
	 *
	 * @return the validacionDiasMaximo
	 */
	public Boolean getValidacionDiasMaximo() {
		return validacionDiasMaximo;
	}

	/**
	 * Método setter del atributo validacionDiasMaximo de la clase AporteSubsistemaDTO
	 *
	 * @param validacionDiasMaximo
	 *            the validacionDiasMaximo to set
	 */
	public void setValidacionDiasMaximo(Boolean validacionDiasMaximo) {
		this.validacionDiasMaximo = validacionDiasMaximo;
	}

	/**
	 * Método getter del atributo nroDiasSubsistemaMaximo de la clase AporteSubsistemaDTO
	 *
	 * @return the nroDiasSubsistemaMaximo
	 */
	public Integer getNroDiasSubsistemaMaximo() {
		return nroDiasSubsistemaMaximo;
	}

	/**
	 * Método setter del atributo nroDiasSubsistemaMaximo de la clase AporteSubsistemaDTO
	 *
	 * @param nroDiasSubsistemaMaximo
	 *            the nroDiasSubsistemaMaximo to set
	 */
	public void setNroDiasSubsistemaMaximo(Integer nroDiasSubsistemaMaximo) {
		this.nroDiasSubsistemaMaximo = nroDiasSubsistemaMaximo;
	}

	/**
	 * Método getter del atributo indicadorTarifaEspecialPen de la clase AporteSubsistemaDTO
	 *
	 * @return the indicadorTarifaEspecialPen
	 */
	public String getIndicadorTarifaEspecialPen() {
		return indicadorTarifaEspecialPen;
	}

	/**
	 * Método setter del atributo indicadorTarifaEspecialPen de la clase AporteSubsistemaDTO
	 *
	 * @param indicadorTarifaEspecialPen
	 *            the indicadorTarifaEspecialPen to set
	 */
	public void setIndicadorTarifaEspecialPen(String indicadorTarifaEspecialPen) {
		this.indicadorTarifaEspecialPen = indicadorTarifaEspecialPen;
	}

	/**
	 * Método getter del atributo ibcOtrosParafiscales de la clase AporteSubsistemaDTO
	 *
	 * @return the ibcOtrosParafiscales
	 */
	public BigDecimal getIbcOtrosParafiscales() {
		return ibcOtrosParafiscales;
	}

	/**
	 * Método setter del atributo ibcOtrosParafiscales de la clase AporteSubsistemaDTO
	 *
	 * @param ibcOtrosParafiscales
	 *            the ibcOtrosParafiscales to set
	 */
	public void setIbcOtrosParafiscales(BigDecimal ibcOtrosParafiscales) {
		this.ibcOtrosParafiscales = ibcOtrosParafiscales;
	}

	/**
	 * Método getter del atributo horasLaboradas de la clase AporteSubsistemaDTO
	 *
	 * @return the horasLaboradas
	 */
	public Integer getHorasLaboradas() {
		return horasLaboradas;
	}

	/**
	 * Método setter del atributo horasLaboradas de la clase AporteSubsistemaDTO
	 *
	 * @param horasLaboradas
	 *            the horasLaboradas to set
	 */
	public void setHorasLaboradas(Integer horasLaboradas) {
		this.horasLaboradas = horasLaboradas;
	}

}

package com.ach.soi.empresarial.converters.model.beans2388.write;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388Tp05 extends CommonBean{

	private String codigoEps;
	private String nitEps;
	private Integer digitoVerificacionEps;
	private Long valorCotizacionesOblEps;
	private Long valorUpcsEps;
	private Long valorNetoAportesEps;
	private Integer diasMora;
	private Long valorMoraCotizacionesOblg;
	private Long valorMoraUpcs;
	private Long subtotalAportesCotizacion;
	private Long subtotalAportesUpc;
	private Long totalPagarCotizacionesOblg;
	private Long totalPagarUpcs;
	private Long totalPagarAdministradora;
	private Integer totalAfiliadosAdministradora;
	public String getCodigoEps() {
		return codigoEps;
	}
	public void setCodigoEps(String codigoEps) {
		this.codigoEps = codigoEps;
	}
	public String getNitEps() {
		return nitEps;
	}
	public void setNitEps(String nitEps) {
		this.nitEps = nitEps;
	}
	public Integer getDigitoVerificacionEps() {
		return digitoVerificacionEps;
	}
	public void setDigitoVerificacionEps(Integer digitoVerificacionEps) {
		this.digitoVerificacionEps = digitoVerificacionEps;
	}
	public Long getValorCotizacionesOblEps() {
		return valorCotizacionesOblEps;
	}
	public void setValorCotizacionesOblEps(Long valorCotizacionesOblEps) {
		this.valorCotizacionesOblEps = valorCotizacionesOblEps;
	}
	public Long getValorUpcsEps() {
		return valorUpcsEps;
	}
	public void setValorUpcsEps(Long valorUpcsEps) {
		this.valorUpcsEps = valorUpcsEps;
	}
	public Long getValorNetoAportesEps() {
		return valorNetoAportesEps;
	}
	public void setValorNetoAportesEps(Long valorNetoAportesEps) {
		this.valorNetoAportesEps = valorNetoAportesEps;
	}
	public Integer getDiasMora() {
		return diasMora;
	}
	public void setDiasMora(Integer diasMora) {
		this.diasMora = diasMora;
	}
	public Long getValorMoraCotizacionesOblg() {
		return valorMoraCotizacionesOblg;
	}
	public void setValorMoraCotizacionesOblg(Long valorMoraCotizacionesOblg) {
		this.valorMoraCotizacionesOblg = valorMoraCotizacionesOblg;
	}
	public Long getValorMoraUpcs() {
		return valorMoraUpcs;
	}
	public void setValorMoraUpcs(Long valorMoraUpcs) {
		this.valorMoraUpcs = valorMoraUpcs;
	}
	public Long getSubtotalAportesCotizacion() {
		return subtotalAportesCotizacion;
	}
	public void setSubtotalAportesCotizacion(Long subtotalAportesCotizacion) {
		this.subtotalAportesCotizacion = subtotalAportesCotizacion;
	}
	public Long getSubtotalAportesUpc() {
		return subtotalAportesUpc;
	}
	public void setSubtotalAportesUpc(Long subtotalAportesUpc) {
		this.subtotalAportesUpc = subtotalAportesUpc;
	}
	public Long getTotalPagarCotizacionesOblg() {
		return totalPagarCotizacionesOblg;
	}
	public void setTotalPagarCotizacionesOblg(Long totalPagarCotizacionesOblg) {
		this.totalPagarCotizacionesOblg = totalPagarCotizacionesOblg;
	}
	public Long getTotalPagarUpcs() {
		return totalPagarUpcs;
	}
	public void setTotalPagarUpcs(Long totalPagarUpcs) {
		this.totalPagarUpcs = totalPagarUpcs;
	}
	public Long getTotalPagarAdministradora() {
		return totalPagarAdministradora;
	}
	public void setTotalPagarAdministradora(Long totalPagarAdministradora) {
		this.totalPagarAdministradora = totalPagarAdministradora;
	}
	public Integer getTotalAfiliadosAdministradora() {
		return totalAfiliadosAdministradora;
	}
	public void setTotalAfiliadosAdministradora(Integer totalAfiliadosAdministradora) {
		this.totalAfiliadosAdministradora = totalAfiliadosAdministradora;
	}
	@Override
	public String toString() {
		return "Reg2388Tp5 [codigoEps=" + codigoEps + ", nitEps=" + nitEps
				+ ", digitoVerificacionEps=" + digitoVerificacionEps
				+ ", valorCotizacionesOblEps=" + valorCotizacionesOblEps
				+ ", valorUpcsEps=" + valorUpcsEps + ", valorNetoAportesEps="
				+ valorNetoAportesEps + ", diasMora=" + diasMora
				+ ", valorMoraCotizacionesOblg=" + valorMoraCotizacionesOblg
				+ ", valorMoraUpcs=" + valorMoraUpcs
				+ ", subtotalAportesCotizacion=" + subtotalAportesCotizacion
				+ ", subtotalAportesUpc=" + subtotalAportesUpc
				+ ", totalPagarCotizacionesOblg=" + totalPagarCotizacionesOblg
				+ ", totalPagarUpcs=" + totalPagarUpcs
				+ ", totalPagarAdministradora=" + totalPagarAdministradora
				+ ", totalAfiliadosAdministradora="
				+ totalAfiliadosAdministradora + ", tipoRegistro="
				+ tipoRegistro + ", secuencia=" + secuencia + "]";
	}
	public void buildDefault() {
		super.secuencia = 0;
		super.tipoRegistro = 5;
		this.codigoEps = "EPS001";
		this.nitEps = "388288388";
		this.digitoVerificacionEps = 3;
		this.valorCotizacionesOblEps = 800000l;
		this.valorUpcsEps = 0l;
		this.valorNetoAportesEps = 800000l;
		this.diasMora = 0;
		this.valorMoraCotizacionesOblg = 0l;
		this.valorMoraUpcs = 0l;
		this.subtotalAportesCotizacion = 80000l;
		this.subtotalAportesUpc = 0l;
		this.totalPagarCotizacionesOblg = 80000l;
		this.totalPagarUpcs = 0l;
		this.totalPagarAdministradora = 80000l;
		this.totalAfiliadosAdministradora = 40;
	}
	
	
	
}

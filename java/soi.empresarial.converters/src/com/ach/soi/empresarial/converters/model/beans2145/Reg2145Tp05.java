package com.ach.soi.empresarial.converters.model.beans2145;

import java.io.Serializable;

import com.ach.soi.empresarial.converters.model.CommonBean;

@SuppressWarnings("serial")
public class Reg2145Tp05 extends CommonBean implements Serializable {

	private String codigoAdministradoraSalud;
	private String nitEPSoEOC;
	private Integer digitoVerificacionEPSoEOC;
	private Long valorTotalCotOblAdmin;
	private Long valorTotalUPCAdmin;
	private Integer nroDiasMoraLiquidados;
	private Long valorIntMoraCotObligatorias;
	private Long valorIntMoraUPCAdicionales;
	private Long subTotalAportesCot;
	private Long subTotalAportesUPC;
	private Long totalPagarAdministradora;
	private Long valorFosyga;
	private Integer totalAfiliadosAdministradora;
	public String getCodigoAdministradoraSalud() {
		return codigoAdministradoraSalud;
	}
	public void setCodigoAdministradoraSalud(String codigoAdministradoraSalud) {
		this.codigoAdministradoraSalud = codigoAdministradoraSalud;
	}
	public String getNitEPSoEOC() {
		return nitEPSoEOC;
	}
	public void setNitEPSoEOC(String nitEPSoEOC) {
		this.nitEPSoEOC = nitEPSoEOC;
	}
	public Integer getDigitoVerificacionEPSoEOC() {
		return digitoVerificacionEPSoEOC;
	}
	public void setDigitoVerificacionEPSoEOC(Integer digitoVerificacionEPSoEOC) {
		this.digitoVerificacionEPSoEOC = digitoVerificacionEPSoEOC;
	}
	public Long getValorTotalCotOblAdmin() {
		return valorTotalCotOblAdmin;
	}
	public void setValorTotalCotOblAdmin(Long valorTotalCotOblAdmin) {
		this.valorTotalCotOblAdmin = valorTotalCotOblAdmin;
	}
	public Long getValorTotalUPCAdmin() {
		return valorTotalUPCAdmin;
	}
	public void setValorTotalUPCAdmin(Long valorTotalUPCAdmin) {
		this.valorTotalUPCAdmin = valorTotalUPCAdmin;
	}
	public Integer getNroDiasMoraLiquidados() {
		return nroDiasMoraLiquidados;
	}
	public void setNroDiasMoraLiquidados(Integer nroDiasMoraLiquidados) {
		this.nroDiasMoraLiquidados = nroDiasMoraLiquidados;
	}
	public Long getValorIntMoraCotObligatorias() {
		return valorIntMoraCotObligatorias;
	}
	public void setValorIntMoraCotObligatorias(Long valorIntMoraCotObligatorias) {
		this.valorIntMoraCotObligatorias = valorIntMoraCotObligatorias;
	}
	public Long getValorIntMoraUPCAdicionales() {
		return valorIntMoraUPCAdicionales;
	}
	public void setValorIntMoraUPCAdicionales(Long valorIntMoraUPCAdicionales) {
		this.valorIntMoraUPCAdicionales = valorIntMoraUPCAdicionales;
	}
	public Long getSubTotalAportesCot() {
		return subTotalAportesCot;
	}
	public void setSubTotalAportesCot(Long subTotalAportesCot) {
		this.subTotalAportesCot = subTotalAportesCot;
	}
	public Long getSubTotalAportesUPC() {
		return subTotalAportesUPC;
	}
	public void setSubTotalAportesUPC(Long subTotalAportesUPC) {
		this.subTotalAportesUPC = subTotalAportesUPC;
	}
	public Long getTotalPagarAdministradora() {
		return totalPagarAdministradora;
	}
	public void setTotalPagarAdministradora(Long totalPagarAdministradora) {
		this.totalPagarAdministradora = totalPagarAdministradora;
	}
	public Long getValorFosyga() {
		return valorFosyga;
	}
	public void setValorFosyga(Long valorFosyga) {
		this.valorFosyga = valorFosyga;
	}
	public Integer getTotalAfiliadosAdministradora() {
		return totalAfiliadosAdministradora;
	}
	public void setTotalAfiliadosAdministradora(Integer totalAfiliadosAdministradora) {
		this.totalAfiliadosAdministradora = totalAfiliadosAdministradora;
	}
}

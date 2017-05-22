package com.ach.soi.empresarial.converters.model.beans2388.write;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388Tp06 extends CommonBean{

	private String codigoArl;
	private String nitArl;
	private Integer digitoVerificacionArl;
	private Long valorCotizaciones;
	private String numeroAutIncapacidades;
	private Long valorTotalIncapacidades;
	private Long valorAportesOtrosSistemas;
	private Long valorNetoAportes;
	private Integer diasMora;
	private Long valorMoraCotizacion;
	private Long subtotalCotizacion;
	private String numeroPlanillaSaldoAFavor;
	private Long valorSaldoAFavor;
	private Long totalPagarAdministradora;
	private Integer fondoRiesgosLaborales;
	private Integer totalAfiliadosAdministradora;
	public String getCodigoArl() {
		return codigoArl;
	}
	public void setCodigoArl(String codigoArl) {
		this.codigoArl = codigoArl;
	}
	public String getNitArl() {
		return nitArl;
	}
	public void setNitArl(String nitArl) {
		this.nitArl = nitArl;
	}
	public Integer getDigitoVerificacionArl() {
		return digitoVerificacionArl;
	}
	public void setDigitoVerificacionArl(Integer digitoVerificacionArl) {
		this.digitoVerificacionArl = digitoVerificacionArl;
	}
	public Long getValorCotizaciones() {
		return valorCotizaciones;
	}
	public void setValorCotizaciones(Long valorCotizaciones) {
		this.valorCotizaciones = valorCotizaciones;
	}
	public String getNumeroAutIncapacidades() {
		return numeroAutIncapacidades;
	}
	public void setNumeroAutIncapacidades(String numeroAutIncapacidades) {
		this.numeroAutIncapacidades = numeroAutIncapacidades;
	}
	public Long getValorTotalIncapacidades() {
		return valorTotalIncapacidades;
	}
	public void setValorTotalIncapacidades(Long valorTotalIncapacidades) {
		this.valorTotalIncapacidades = valorTotalIncapacidades;
	}
	public Long getValorAportesOtrosSistemas() {
		return valorAportesOtrosSistemas;
	}
	public void setValorAportesOtrosSistemas(Long valorAportesOtrosSistemas) {
		this.valorAportesOtrosSistemas = valorAportesOtrosSistemas;
	}
	public Long getValorNetoAportes() {
		return valorNetoAportes;
	}
	public void setValorNetoAportes(Long valorNetoAportes) {
		this.valorNetoAportes = valorNetoAportes;
	}
	public Integer getDiasMora() {
		return diasMora;
	}
	public void setDiasMora(Integer diasMora) {
		this.diasMora = diasMora;
	}
	public Long getValorMoraCotizacion() {
		return valorMoraCotizacion;
	}
	public void setValorMoraCotizacion(Long valorMoraCotizacion) {
		this.valorMoraCotizacion = valorMoraCotizacion;
	}
	public Long getSubtotalCotizacion() {
		return subtotalCotizacion;
	}
	public void setSubtotalCotizacion(Long subtotalCotizacion) {
		this.subtotalCotizacion = subtotalCotizacion;
	}
	public String getNumeroPlanillaSaldoAFavor() {
		return numeroPlanillaSaldoAFavor;
	}
	public void setNumeroPlanillaSaldoAFavor(String numeroPlanillaSaldoAFavor) {
		this.numeroPlanillaSaldoAFavor = numeroPlanillaSaldoAFavor;
	}
	public Long getValorSaldoAFavor() {
		return valorSaldoAFavor;
	}
	public void setValorSaldoAFavor(Long valorSaldoAFavor) {
		this.valorSaldoAFavor = valorSaldoAFavor;
	}
	public Long getTotalPagarAdministradora() {
		return totalPagarAdministradora;
	}
	public void setTotalPagarAdministradora(Long totalPagarAdministradora) {
		this.totalPagarAdministradora = totalPagarAdministradora;
	}
	public Integer getFondoRiesgosLaborales() {
		return fondoRiesgosLaborales;
	}
	public void setFondoRiesgosLaborales(Integer fondoRiesgosLaborales) {
		this.fondoRiesgosLaborales = fondoRiesgosLaborales;
	}
	public Integer getTotalAfiliadosAdministradora() {
		return totalAfiliadosAdministradora;
	}
	public void setTotalAfiliadosAdministradora(Integer totalAfiliadosAdministradora) {
		this.totalAfiliadosAdministradora = totalAfiliadosAdministradora;
	}
	@Override
	public String toString() {
		return "Reg2388Tp6 [codigoArl=" + codigoArl + ", nitArl=" + nitArl
				+ ", digitoVerificacionArl=" + digitoVerificacionArl
				+ ", valorCotizaciones=" + valorCotizaciones
				+ ", numeroAutIncapacidades=" + numeroAutIncapacidades
				+ ", valorTotalIncapacidades=" + valorTotalIncapacidades
				+ ", valorAportesOtrosSistemas=" + valorAportesOtrosSistemas
				+ ", valorNetoAportes=" + valorNetoAportes + ", diasMora="
				+ diasMora + ", valorMoraCotizacion=" + valorMoraCotizacion
				+ ", subtotalCotizacion=" + subtotalCotizacion
				+ ", numeroPlanillaSaldoAFavor=" + numeroPlanillaSaldoAFavor
				+ ", valorSaldoAFavor=" + valorSaldoAFavor
				+ ", totalPagarAdministradora=" + totalPagarAdministradora
				+ ", fondoRiesgosLaborales=" + fondoRiesgosLaborales
				+ ", totalAfiliadosAdministradora="
				+ totalAfiliadosAdministradora + ", tipoRegistro="
				+ tipoRegistro + ", secuencia=" + secuencia + "]";
	}
	
	
	public void buildDefault() {
		super.secuencia = 0;
		super.tipoRegistro = 6;
		this.codigoArl = "ARP19";
		this.nitArl = "312321332";
		this.digitoVerificacionArl = 3;
		this.valorCotizaciones = 1899999l;
		this.numeroAutIncapacidades = "AUT11111";
		this.valorTotalIncapacidades = 0l;
		this.valorAportesOtrosSistemas = 0l;
		this.valorNetoAportes = 1000001l;
		this.diasMora = 30;
		this.valorMoraCotizacion = 0l;
		this.subtotalCotizacion = 1000001l;
		this.numeroPlanillaSaldoAFavor = " ";
		this.valorSaldoAFavor = 0l;
		this.totalPagarAdministradora = 1000001l;
		this.fondoRiesgosLaborales = 111;
		this.totalAfiliadosAdministradora = 40;
	}
	
	
	
}

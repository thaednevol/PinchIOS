package com.ach.soi.empresarial.converters.model.beans2388.write;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388Tp09 extends CommonBean{
	private String nitIcbf;
	private Integer digitoVerificacionIcbf;
	private Long valorAporteParafiscal;
	private Integer diasMora;
	private Long valorInteresesMora;
	private Long totalPagarIcbf;
	private Integer totalAfiliadosAdministradora;
	public String getNitIcbf() {
		return nitIcbf;
	}
	public void setNitIcbf(String nitIcbf) {
		this.nitIcbf = nitIcbf;
	}
	public Integer getDigitoVerificacionIcbf() {
		return digitoVerificacionIcbf;
	}
	public void setDigitoVerificacionIcbf(Integer digitoVerificacionIcbf) {
		this.digitoVerificacionIcbf = digitoVerificacionIcbf;
	}
	public Long getValorAporteParafiscal() {
		return valorAporteParafiscal;
	}
	public void setValorAporteParafiscal(Long valorAporteParafiscal) {
		this.valorAporteParafiscal = valorAporteParafiscal;
	}
	public Integer getDiasMora() {
		return diasMora;
	}
	public void setDiasMora(Integer diasMora) {
		this.diasMora = diasMora;
	}
	public Long getValorInteresesMora() {
		return valorInteresesMora;
	}
	public void setValorInteresesMora(Long valorInteresesMora) {
		this.valorInteresesMora = valorInteresesMora;
	}
	public Long getTotalPagarIcbf() {
		return totalPagarIcbf;
	}
	public void setTotalPagarIcbf(Long totalPagarIcbf) {
		this.totalPagarIcbf = totalPagarIcbf;
	}
	public Integer getTotalAfiliadosAdministradora() {
		return totalAfiliadosAdministradora;
	}
	public void setTotalAfiliadosAdministradora(Integer totalAfiliadosAdministradora) {
		this.totalAfiliadosAdministradora = totalAfiliadosAdministradora;
	}
	public void buildDefault() {
		super.secuencia = 0;
		super.tipoRegistro = 9;
		this.nitIcbf = "231231233";
		this.digitoVerificacionIcbf = 8;
		this.valorAporteParafiscal = 30000l;
		this.diasMora = 0;
		this.valorInteresesMora = 0l;
		this.totalPagarIcbf = 30000l;
		this.totalAfiliadosAdministradora = 30;
	}
	@Override
	public String toString() {
		return "Reg2388Tp09 [nitIcbf=" + nitIcbf + ", digitoVerificacionIcbf="
				+ digitoVerificacionIcbf + ", valorAporteParafiscal="
				+ valorAporteParafiscal + ", diasMora=" + diasMora
				+ ", valorInteresesMora=" + valorInteresesMora
				+ ", totalPagarIcbf=" + totalPagarIcbf
				+ ", totalAfiliadosAdministradora="
				+ totalAfiliadosAdministradora + ", tipoRegistro="
				+ tipoRegistro + ", secuencia=" + secuencia + "]";
	}
	
	
	
}

package com.ach.soi.empresarial.converters.model.beans2388.write;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388Tp10 extends CommonBean{
	private String nitEsap;
	private Integer digitoVerificacionEsap;
	private Long valorAporteParafiscal;
	private Integer diasMora;
	private Long valorInteresesMora;
	private Long totalPagarEsap;
	public String getNitEsap() {
		return nitEsap;
	}
	public void setNitEsap(String nitEsap) {
		this.nitEsap = nitEsap;
	}
	public Integer getDigitoVerificacionEsap() {
		return digitoVerificacionEsap;
	}
	public void setDigitoVerificacionEsap(Integer digitoVerificacionEsap) {
		this.digitoVerificacionEsap = digitoVerificacionEsap;
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
	public Long getTotalPagarEsap() {
		return totalPagarEsap;
	}
	public void setTotalPagarEsap(Long totalPagarEsap) {
		this.totalPagarEsap = totalPagarEsap;
	}
	@Override
	public String toString() {
		return "Reg2388Tp10 [nitEsap=" + nitEsap + ", digitoVerificacionEsap="
				+ digitoVerificacionEsap + ", valorAporteParafiscal="
				+ valorAporteParafiscal + ", diasMora=" + diasMora
				+ ", valorInteresesMora=" + valorInteresesMora
				+ ", totalPagarEsap=" + totalPagarEsap + ", tipoRegistro="
				+ tipoRegistro + ", secuencia=" + secuencia + "]";
	}
	public void buildDefault() {
		super.secuencia = 0;
		super.tipoRegistro = 10;
		this.nitEsap = "2313333";
		this.digitoVerificacionEsap = 1;
		this.valorAporteParafiscal = 190000l;
		this.diasMora = 0;
		this.valorInteresesMora = 0l;
		this.totalPagarEsap = 190000l;
	}
	
	
}

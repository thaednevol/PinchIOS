package com.ach.soi.empresarial.converters.model.beans2388.write;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388Tp11 extends CommonBean{
	private String nitMen;
	private Integer digitoVerificacionMen;
	private Long valorAporteParafiscal;
	private Integer diasMora;
	private Long valorInteresesMora;
	private Long totalPagarMen;
	public String getNitMen() {
		return nitMen;
	}
	public void setNitMen(String nitMen) {
		this.nitMen = nitMen;
	}
	public Integer getDigitoVerificacionMen() {
		return digitoVerificacionMen;
	}
	public void setDigitoVerificacionMen(Integer digitoVerificacionMen) {
		this.digitoVerificacionMen = digitoVerificacionMen;
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
	public Long getTotalPagarMen() {
		return totalPagarMen;
	}
	public void setTotalPagarMen(Long totalPagarMen) {
		this.totalPagarMen = totalPagarMen;
	}
	@Override
	public String toString() {
		return "Reg2388Tp11 [nitMen=" + nitMen + ", digitoVerificacionMen="
				+ digitoVerificacionMen + ", valorAporteParafiscal="
				+ valorAporteParafiscal + ", diasMora=" + diasMora
				+ ", valorInteresesMora=" + valorInteresesMora
				+ ", totalPagarMen=" + totalPagarMen + ", tipoRegistro="
				+ tipoRegistro + ", secuencia=" + secuencia + "]";
	}
	public void buildDefault() {
		super.secuencia = 0;
		super.tipoRegistro = 11;
		this.nitMen = "2315565445";
		this.digitoVerificacionMen = 3;
		this.valorAporteParafiscal = 50000l;
		this.diasMora = 0;
		this.valorInteresesMora = 0l;
		this.totalPagarMen = 50000l;
	}
	
	
}

package com.ach.soi.empresarial.converters.model.beans2388.write;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388Tp04 extends CommonBean{

	private String codigoFsp;
	private String nitFsp;
	private Integer digitoVerificacionFsp;
	private Long valorTotalAportesFsp;
	private Integer diasMora;
	private Long valorInteresMoraFsp;
	private Long valorTotalPagarFsp;
	private Integer totalAfiliadosFsp;
	public String getCodigoFsp() {
		return codigoFsp;
	}
	public void setCodigoFsp(String codigoFsp) {
		this.codigoFsp = codigoFsp;
	}
	public String getNitFsp() {
		return nitFsp;
	}
	public void setNitFsp(String nitFsp) {
		this.nitFsp = nitFsp;
	}
	public Integer getDigitoVerificacionFsp() {
		return digitoVerificacionFsp;
	}
	public void setDigitoVerificacionFsp(Integer digitoVerificacionFsp) {
		this.digitoVerificacionFsp = digitoVerificacionFsp;
	}
	public Long getValorTotalAportesFsp() {
		return valorTotalAportesFsp;
	}
	public void setValorTotalAportesFsp(Long valorTotalAportesFsp) {
		this.valorTotalAportesFsp = valorTotalAportesFsp;
	}
	public Integer getDiasMora() {
		return diasMora;
	}
	public void setDiasMora(Integer diasMora) {
		this.diasMora = diasMora;
	}
	public Long getValorInteresMoraFsp() {
		return valorInteresMoraFsp;
	}
	public void setValorInteresMoraFsp(Long valorInteresMoraFsp) {
		this.valorInteresMoraFsp = valorInteresMoraFsp;
	}
	public Long getValorTotalPagarFsp() {
		return valorTotalPagarFsp;
	}
	public void setValorTotalPagarFsp(Long valorTotalPagarFsp) {
		this.valorTotalPagarFsp = valorTotalPagarFsp;
	}
	public Integer getTotalAfiliadosFsp() {
		return totalAfiliadosFsp;
	}
	public void setTotalAfiliadosFsp(Integer totalAfiliadosFsp) {
		this.totalAfiliadosFsp = totalAfiliadosFsp;
	}
	@Override
	public String toString() {
		return "Reg2388Tp4 [codigoFsp=" + codigoFsp + ", nitFsp=" + nitFsp
				+ ", digitoVerificacionFsp=" + digitoVerificacionFsp
				+ ", valorTotalAportesFsp=" + valorTotalAportesFsp
				+ ", diasMora=" + diasMora + ", valorInteresMoraFsp="
				+ valorInteresMoraFsp + ", valorTotalPagarFsp="
				+ valorTotalPagarFsp + ", totalAfiliadosFsp="
				+ totalAfiliadosFsp + ", tipoRegistro=" + tipoRegistro
				+ ", secuencia=" + secuencia + "]";
	}
	public void buildDefault() {
		super.secuencia = 0;
		super.setTipoRegistro(4);
		this.codigoFsp = "FSP001";
		this.nitFsp = "333333333";
		this.digitoVerificacionFsp = 8;
		this.valorTotalAportesFsp = 10000l;
		this.diasMora = 0;
		this.valorInteresMoraFsp = 0l;
		this.valorTotalPagarFsp = 10000l;
		this.totalAfiliadosFsp = 30;
	}
	
	
	
}

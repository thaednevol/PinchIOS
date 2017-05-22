package com.ach.soi.empresarial.converters.model.beans2388.write;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388Tp07 extends CommonBean{
	private String codigoCcf;
	private String nitCcf;
	private Integer digitoVerificacionCcf;
	private Long valorAporteCcf;
	private Integer diasMora;
	private Long valorInteresesMora;
	private Long totalPagarCcf;
	private Integer totalAfiliadosAdministradora;
	public String getCodigoCcf() {
		return codigoCcf;
	}
	public void setCodigoCcf(String codigoCcf) {
		this.codigoCcf = codigoCcf;
	}
	public String getNitCcf() {
		return nitCcf;
	}
	public void setNitCcf(String nitCcf) {
		this.nitCcf = nitCcf;
	}
	public Integer getDigitoVerificacionCcf() {
		return digitoVerificacionCcf;
	}
	public void setDigitoVerificacionCcf(Integer digitoVerificacionCcf) {
		this.digitoVerificacionCcf = digitoVerificacionCcf;
	}
	public Long getValorAporteCcf() {
		return valorAporteCcf;
	}
	public void setValorAporteCcf(Long valorAporteCcf) {
		this.valorAporteCcf = valorAporteCcf;
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
	public Long getTotalPagarCcf() {
		return totalPagarCcf;
	}
	public void setTotalPagarCcf(Long totalPagarCcf) {
		this.totalPagarCcf = totalPagarCcf;
	}
	public Integer getTotalAfiliadosAdministradora() {
		return totalAfiliadosAdministradora;
	}
	public void setTotalAfiliadosAdministradora(Integer totalAfiliadosAdministradora) {
		this.totalAfiliadosAdministradora = totalAfiliadosAdministradora;
	}
	@Override
	public String toString() {
		return "Reg2388Tp7 [codigoCcf=" + codigoCcf + ", nitCcf=" + nitCcf
				+ ", digitoVerificacionCcf=" + digitoVerificacionCcf
				+ ", valorAporteCcf=" + valorAporteCcf + ", diasMora="
				+ diasMora + ", valorInteresesMora=" + valorInteresesMora
				+ ", totalPagarCcf=" + totalPagarCcf
				+ ", totalAfiliadosAdministradora="
				+ totalAfiliadosAdministradora + ", tipoRegistro="
				+ tipoRegistro + ", secuencia=" + secuencia + "]";
	}
	public void buildDefault() {
		super.secuencia = 0;
		super.tipoRegistro = 7;
		this.codigoCcf = "CCF24";
		this.nitCcf = "23213123131";
		this.digitoVerificacionCcf = 3;
		this.valorAporteCcf = 1000000l;
		this.diasMora = 30;
		this.valorInteresesMora = 0l;
		this.totalPagarCcf = 1000000l;
		this.totalAfiliadosAdministradora = 30;
	}
	
	
}

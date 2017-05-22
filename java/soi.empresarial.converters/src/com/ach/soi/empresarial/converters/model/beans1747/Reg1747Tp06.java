package com.ach.soi.empresarial.converters.model.beans1747;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg1747Tp06  extends CommonBean{
	
	
	private String codigoCCF;
	private String nitCCF;
	private Integer digVerNitCCF;
	private Long vlrAportesACCF;
	private Integer numeroDiasMoraLiquidados;
	private Long vlrInteresMora;
	private Long vlrTotalPagarCCF;
	private Integer totalAfiliadosCCF;
	public String getCodigoCCF() {
		return codigoCCF;
	}
	public void setCodigoCCF(String codigoCCF) {
		this.codigoCCF = codigoCCF;
	}
	public String getNitCCF() {
		return nitCCF;
	}
	public void setNitCCF(String nitCCF) {
		this.nitCCF = nitCCF;
	}
	public Integer getDigVerNitCCF() {
		return digVerNitCCF;
	}
	public void setDigVerNitCCF(Integer digVerNitCCF) {
		this.digVerNitCCF = digVerNitCCF;
	}
	public Long getVlrAportesACCF() {
		return vlrAportesACCF;
	}
	public void setVlrAportesACCF(Long vlrAportesACCF) {
		this.vlrAportesACCF = vlrAportesACCF;
	}
	public Integer getNumeroDiasMoraLiquidados() {
		return numeroDiasMoraLiquidados;
	}
	public void setNumeroDiasMoraLiquidados(Integer numeroDiasMoraLiquidados) {
		this.numeroDiasMoraLiquidados = numeroDiasMoraLiquidados;
	}
	public Long getVlrInteresMora() {
		return vlrInteresMora;
	}
	public void setVlrInteresMora(Long vlrInteresMora) {
		this.vlrInteresMora = vlrInteresMora;
	}
	public Long getVlrTotalPagarCCF() {
		return vlrTotalPagarCCF;
	}
	public void setVlrTotalPagarCCF(Long vlrTotalPagarCCF) {
		this.vlrTotalPagarCCF = vlrTotalPagarCCF;
	}
	public Integer getTotalAfiliadosCCF() {
		return totalAfiliadosCCF;
	}
	public void setTotalAfiliadosCCF(Integer totalAfiliadosCCF) {
		this.totalAfiliadosCCF = totalAfiliadosCCF;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reg1747Tp6 [codigoCCF=");
		builder.append(codigoCCF);
		builder.append(", nitCCF=");
		builder.append(nitCCF);
		builder.append(", digVerNitCCF=");
		builder.append(digVerNitCCF);
		builder.append(", vlrAportesACCF=");
		builder.append(vlrAportesACCF);
		builder.append(", numeroDiasMoraLiquidados=");
		builder.append(numeroDiasMoraLiquidados);
		builder.append(", vlrInteresMora=");
		builder.append(vlrInteresMora);
		builder.append(", vlrTotalPagarCCF=");
		builder.append(vlrTotalPagarCCF);
		builder.append(", totalAfiliadosCCF=");
		builder.append(totalAfiliadosCCF);
		builder.append(", tipoRegistro=");
		builder.append(tipoRegistro);
		builder.append(", secuencia=");
		builder.append(secuencia);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}

package com.ach.soi.empresarial.converters.model.beans1747;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg1747Tp09  extends CommonBean{
	
	private String nitESAP;
	private Integer digVerNitESAP;
	private Long vlrPagar;
	private Integer numeroDiasMoraLiquidados;
	private Long vlrInteresMora;
	private Long vlrTotalPagar;
	public String getNitESAP() {
		return nitESAP;
	}
	public void setNitESAP(String nitESAP) {
		this.nitESAP = nitESAP;
	}
	public Integer getDigVerNitESAP() {
		return digVerNitESAP;
	}
	public void setDigVerNitESAP(Integer digVerNitESAP) {
		this.digVerNitESAP = digVerNitESAP;
	}
	public Long getVlrPagar() {
		return vlrPagar;
	}
	public void setVlrPagar(Long vlrPagar) {
		this.vlrPagar = vlrPagar;
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
	public Long getVlrTotalPagar() {
		return vlrTotalPagar;
	}
	public void setVlrTotalPagar(Long vlrTotalPagar) {
		this.vlrTotalPagar = vlrTotalPagar;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reg1747Tp9 [nitESAP=");
		builder.append(nitESAP);
		builder.append(", digVerNitESAP=");
		builder.append(digVerNitESAP);
		builder.append(", vlrPagar=");
		builder.append(vlrPagar);
		builder.append(", numeroDiasMoraLiquidados=");
		builder.append(numeroDiasMoraLiquidados);
		builder.append(", vlrInteresMora=");
		builder.append(vlrInteresMora);
		builder.append(", vlrTotalPagar=");
		builder.append(vlrTotalPagar);
		builder.append(", tipoRegistro=");
		builder.append(tipoRegistro);
		builder.append(", secuencia=");
		builder.append(secuencia);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

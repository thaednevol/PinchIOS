package com.ach.soi.empresarial.converters.model.beans1747;

import java.io.Serializable;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg1747Tp10 extends CommonBean  implements Serializable{
	
	private String nitMEN;
	private Integer digVerNitMEN;
	private Long vlrPagar;
	private Integer numeroDiasMoraLiquidados;
	private Long vlrInteresMora;
	private Long vlrTotalPagar;
	public String getNitMEN() {
		return nitMEN;
	}
	public void setNitMEN(String nitMEN) {
		this.nitMEN = nitMEN;
	}
	public Integer getDigVerNitMEN() {
		return digVerNitMEN;
	}
	public void setDigVerNitMEN(Integer digVerNitMEN) {
		this.digVerNitMEN = digVerNitMEN;
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
		builder.append("Reg1747Tp10 [nitMEN=");
		builder.append(nitMEN);
		builder.append(", digVerNitMEN=");
		builder.append(digVerNitMEN);
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

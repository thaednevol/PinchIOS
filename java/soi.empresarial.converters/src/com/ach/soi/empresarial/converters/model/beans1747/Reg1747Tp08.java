package com.ach.soi.empresarial.converters.model.beans1747;

import com.ach.soi.empresarial.converters.model.CommonBean;


public class Reg1747Tp08  extends CommonBean {
	
	private String nitICBF;
	private Integer digVerNitICBF;
	private Long vlrAportes;
	private Integer numeroDiasMoraLiquidados;
	private Long vlrInteresMora;
	private Long vlrTotalPagar;
	private Integer numeroPersonas;
	
	public String getNitICBF() {
		return nitICBF;
	}
	public void setNitICBF(String nitICBF) {
		this.nitICBF = nitICBF;
	}
	public Integer getDigVerNitICBF() {
		return digVerNitICBF;
	}
	public void setDigVerNitICBF(Integer digVerNitICBF) {
		this.digVerNitICBF = digVerNitICBF;
	}
	public Long getVlrAportes() {
		return vlrAportes;
	}
	public void setVlrAportes(Long vlrAportes) {
		this.vlrAportes = vlrAportes;
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
	public Integer getNumeroPersonas() {
		return numeroPersonas;
	}
	public void setNumeroPersonas(Integer numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reg1747Tp8 [nitICBF=");
		builder.append(nitICBF);
		builder.append(", digVerNitICBF=");
		builder.append(digVerNitICBF);
		builder.append(", vlrAportes=");
		builder.append(vlrAportes);
		builder.append(", numeroDiasMoraLiquidados=");
		builder.append(numeroDiasMoraLiquidados);
		builder.append(", vlrInteresMora=");
		builder.append(vlrInteresMora);
		builder.append(", vlrTotalPagar=");
		builder.append(vlrTotalPagar);
		builder.append(", numeroPersonas=");
		builder.append(numeroPersonas);
		builder.append(", tipoRegistro=");
		builder.append(tipoRegistro);
		builder.append(", secuencia=");
		builder.append(secuencia);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

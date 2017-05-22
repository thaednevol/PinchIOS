package com.ach.soi.empresarial.converters.model.beans1747;

import com.ach.soi.empresarial.converters.model.CommonBean;


public class Reg1747Tp07  extends CommonBean{
	
	private String nitSENA;
	private Integer digVerNitSENA;
	private Long vlrAportesParafiscales;
	private Integer numeroDiasMoraLiquidados;
	private Long vlrInteresMoraSobreAporte;
	private Long vlrTotalPagarSENA;
	private Integer numeroPersonas;
	public String getNitSENA() {
		return nitSENA;
	}
	public void setNitSENA(String nitSENA) {
		this.nitSENA = nitSENA;
	}
	public Integer getDigVerNitSENA() {
		return digVerNitSENA;
	}
	public void setDigVerNitSENA(Integer digVerNitSENA) {
		this.digVerNitSENA = digVerNitSENA;
	}
	public Long getVlrAportesParafiscales() {
		return vlrAportesParafiscales;
	}
	public void setVlrAportesParafiscales(Long vlrAportesParafiscales) {
		this.vlrAportesParafiscales = vlrAportesParafiscales;
	}
	public Integer getNumeroDiasMoraLiquidados() {
		return numeroDiasMoraLiquidados;
	}
	public void setNumeroDiasMoraLiquidados(Integer numeroDiasMoraLiquidados) {
		this.numeroDiasMoraLiquidados = numeroDiasMoraLiquidados;
	}
	public Long getVlrInteresMoraSobreAporte() {
		return vlrInteresMoraSobreAporte;
	}
	public void setVlrInteresMoraSobreAporte(Long vlrInteresMoraSobreAporte) {
		this.vlrInteresMoraSobreAporte = vlrInteresMoraSobreAporte;
	}
	public Long getVlrTotalPagarSENA() {
		return vlrTotalPagarSENA;
	}
	public void setVlrTotalPagarSENA(Long vlrTotalPagarSENA) {
		this.vlrTotalPagarSENA = vlrTotalPagarSENA;
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
		builder.append("Reg1747Tp7 [nitSENA=");
		builder.append(nitSENA);
		builder.append(", digVerNitSENA=");
		builder.append(digVerNitSENA);
		builder.append(", vlrAportesParafiscales=");
		builder.append(vlrAportesParafiscales);
		builder.append(", numeroDiasMoraLiquidados=");
		builder.append(numeroDiasMoraLiquidados);
		builder.append(", vlrInteresMoraSobreAporte=");
		builder.append(vlrInteresMoraSobreAporte);
		builder.append(", vlrTotalPagarSENA=");
		builder.append(vlrTotalPagarSENA);
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

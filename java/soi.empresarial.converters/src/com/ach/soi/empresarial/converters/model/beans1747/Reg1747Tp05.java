package com.ach.soi.empresarial.converters.model.beans1747;

import java.math.BigDecimal;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg1747Tp05 extends CommonBean {
	
	
	private String codigoARP;
	private String nitARP;
	private Integer digVerNitARP;
	private Long vlrTotalCotizacionReportada;
	private String numeroAutorizacionPagoIncapacidades;
	private Long vlrTotalIncapacidadesPagadas;
	private Long vlrAportesPagadosOtrosSistemas;
	private Long vlrNetoAportesCotizacion;
	private Integer numeroDiasMoraLiquidados;
	private Long valorInteresMoraLiquidacionObligatoria;
	private Long subtotalAportesCotizacion;
	private String numeroFormularioUnico;
	private Long vlrSaldoPeriodoAnterior;
	private Long vlrTotalPagarAdministradora;
	private BigDecimal fondoRiesgosProfesionales;
	private Integer totalAfiliadosAdministradora;
	public String getCodigoARP() {
		return codigoARP;
	}
	public void setCodigoARP(String codigoARP) {
		this.codigoARP = codigoARP;
	}
	public String getNitARP() {
		return nitARP;
	}
	public void setNitARP(String nitARP) {
		this.nitARP = nitARP;
	}
	public Integer getDigVerNitARP() {
		return digVerNitARP;
	}
	public void setDigVerNitARP(Integer digVerNitARP) {
		this.digVerNitARP = digVerNitARP;
	}
	public Long getVlrTotalCotizacionReportada() {
		return vlrTotalCotizacionReportada;
	}
	public void setVlrTotalCotizacionReportada(Long vlrTotalCotizacionReportada) {
		this.vlrTotalCotizacionReportada = vlrTotalCotizacionReportada;
	}
	public String getNumeroAutorizacionPagoIncapacidades() {
		return numeroAutorizacionPagoIncapacidades;
	}
	public void setNumeroAutorizacionPagoIncapacidades(String numeroAutorizacionPagoIncapacidades) {
		this.numeroAutorizacionPagoIncapacidades = numeroAutorizacionPagoIncapacidades;
	}
	public Long getVlrTotalIncapacidadesPagadas() {
		return vlrTotalIncapacidadesPagadas;
	}
	public void setVlrTotalIncapacidadesPagadas(Long vlrTotalIncapacidadesPagadas) {
		this.vlrTotalIncapacidadesPagadas = vlrTotalIncapacidadesPagadas;
	}
	public Long getVlrAportesPagadosOtrosSistemas() {
		return vlrAportesPagadosOtrosSistemas;
	}
	public void setVlrAportesPagadosOtrosSistemas(Long vlrAportesPagadosOtrosSistemas) {
		this.vlrAportesPagadosOtrosSistemas = vlrAportesPagadosOtrosSistemas;
	}
	public Long getVlrNetoAportesCotizacion() {
		return vlrNetoAportesCotizacion;
	}
	public void setVlrNetoAportesCotizacion(Long vlrNetoAportesCotizacion) {
		this.vlrNetoAportesCotizacion = vlrNetoAportesCotizacion;
	}
	public Integer getNumeroDiasMoraLiquidados() {
		return numeroDiasMoraLiquidados;
	}
	public void setNumeroDiasMoraLiquidados(Integer numeroDiasMoraLiquidados) {
		this.numeroDiasMoraLiquidados = numeroDiasMoraLiquidados;
	}
	public Long getValorInteresMoraLiquidacionObligatoria() {
		return valorInteresMoraLiquidacionObligatoria;
	}
	public void setValorInteresMoraLiquidacionObligatoria(Long valorInteresMoraLiquidacionObligatoria) {
		this.valorInteresMoraLiquidacionObligatoria = valorInteresMoraLiquidacionObligatoria;
	}
	public Long getSubtotalAportesCotizacion() {
		return subtotalAportesCotizacion;
	}
	public void setSubtotalAportesCotizacion(Long subtotalAportesCotizacion) {
		this.subtotalAportesCotizacion = subtotalAportesCotizacion;
	}
	public String getNumeroFormularioUnico() {
		return numeroFormularioUnico;
	}
	public void setNumeroFormularioUnico(String numeroFormularioUnico) {
		this.numeroFormularioUnico = numeroFormularioUnico;
	}
	public Long getVlrSaldoPeriodoAnterior() {
		return vlrSaldoPeriodoAnterior;
	}
	public void setVlrSaldoPeriodoAnterior(Long vlrSaldoPeriodoAnterior) {
		this.vlrSaldoPeriodoAnterior = vlrSaldoPeriodoAnterior;
	}
	public Long getVlrTotalPagarAdministradora() {
		return vlrTotalPagarAdministradora;
	}
	public void setVlrTotalPagarAdministradora(Long vlrTotalPagarAdministradora) {
		this.vlrTotalPagarAdministradora = vlrTotalPagarAdministradora;
	}
	public BigDecimal getFondoRiesgosProfesionales() {
		return fondoRiesgosProfesionales;
	}
	public void setFondoRiesgosProfesionales(BigDecimal fondoRiesgosProfesionales) {
		this.fondoRiesgosProfesionales = fondoRiesgosProfesionales;
	}
	public Integer getTotalAfiliadosAdministradora() {
		return totalAfiliadosAdministradora;
	}
	public void setTotalAfiliadosAdministradora(Integer totalAfiliadosAdministradora) {
		this.totalAfiliadosAdministradora = totalAfiliadosAdministradora;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reg1747Tp5 [codigoARP=");
		builder.append(codigoARP);
		builder.append(", nitARP=");
		builder.append(nitARP);
		builder.append(", digVerNitARP=");
		builder.append(digVerNitARP);
		builder.append(", vlrTotalCotizacionReportada=");
		builder.append(vlrTotalCotizacionReportada);
		builder.append(", numeroAutorizacionPagoIncapacidades=");
		builder.append(numeroAutorizacionPagoIncapacidades);
		builder.append(", vlrTotalIncapacidadesPagadas=");
		builder.append(vlrTotalIncapacidadesPagadas);
		builder.append(", vlrAportesPagadosOtrosSistemas=");
		builder.append(vlrAportesPagadosOtrosSistemas);
		builder.append(", vlrNetoAportesCotizacion=");
		builder.append(vlrNetoAportesCotizacion);
		builder.append(", numeroDiasMoraLiquidados=");
		builder.append(numeroDiasMoraLiquidados);
		builder.append(", valorInteresMoraLiquidacionObligatoria=");
		builder.append(valorInteresMoraLiquidacionObligatoria);
		builder.append(", subtotalAportesCotizacion=");
		builder.append(subtotalAportesCotizacion);
		builder.append(", numeroFormularioUnico=");
		builder.append(numeroFormularioUnico);
		builder.append(", vlrSaldoPeriodoAnterior=");
		builder.append(vlrSaldoPeriodoAnterior);
		builder.append(", vlrTotalPagarAdministradora=");
		builder.append(vlrTotalPagarAdministradora);
		builder.append(", fondoRiesgosProfesionales=");
		builder.append(fondoRiesgosProfesionales);
		builder.append(", totalAfiliadosAdministradora=");
		builder.append(totalAfiliadosAdministradora);
		builder.append(", tipoRegistro=");
		builder.append(tipoRegistro);
		builder.append(", secuencia=");
		builder.append(secuencia);
		builder.append("]");
		return builder.toString();
	}
	
	


}

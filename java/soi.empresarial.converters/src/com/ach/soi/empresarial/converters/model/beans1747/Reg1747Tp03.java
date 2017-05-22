package com.ach.soi.empresarial.converters.model.beans1747;

import java.io.Serializable;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg1747Tp03 extends CommonBean implements Serializable{

	
	private String codigoAdministradoraPensiones;
	private String nitAdministradoraPensiones;
	private Integer digVerNitAdministradoraPensiones;
	private Long vlrTotalCotizacionObligacionesReportadas;
	private Long vlrTotalCotizacionVoluntariaReportadas;
	private Long vlrTotalCotizacionVoluntariaAportante;
	private Long vlrAporteFondoSolidaridadSubCtaSolidaridad;
	private Long vlrAporteFondoSolidaridadSubCtaSubsistencia;
	private Integer numeroDiasMoraLiquidados;
	private Long valorInteresMoraSobreCotizaciones;
	private Long valorInteresMoraSobreAporteFondoSolidaridad;
	private Long valorInteresMoraSobreAporteFondoSolidaridadSubsistencia;
	private Long totalPagarAdministradora;
	private Integer totalAfiliadosAdministradora;
	
	public String getCodigoAdministradoraPensiones() {
		return codigoAdministradoraPensiones;
	}
	public void setCodigoAdministradoraPensiones(String codigoAdministradoraPensiones) {
		this.codigoAdministradoraPensiones = codigoAdministradoraPensiones;
	}
	public String getNitAdministradoraPensiones() {
		return nitAdministradoraPensiones;
	}
	public void setNitAdministradoraPensiones(String nitAdministradoraPensiones) {
		this.nitAdministradoraPensiones = nitAdministradoraPensiones;
	}
	public Integer getDigVerNitAdministradoraPensiones() {
		return digVerNitAdministradoraPensiones;
	}
	public void setDigVerNitAdministradoraPensiones(Integer digVerNitAdministradoraPensiones) {
		this.digVerNitAdministradoraPensiones = digVerNitAdministradoraPensiones;
	}
	public Long getVlrTotalCotizacionObligacionesReportadas() {
		return vlrTotalCotizacionObligacionesReportadas;
	}
	public void setVlrTotalCotizacionObligacionesReportadas(Long vlrTotalCotizacionObligacionesReportadas) {
		this.vlrTotalCotizacionObligacionesReportadas = vlrTotalCotizacionObligacionesReportadas;
	}
	public Long getVlrTotalCotizacionVoluntariaReportadas() {
		return vlrTotalCotizacionVoluntariaReportadas;
	}
	public void setVlrTotalCotizacionVoluntariaReportadas(Long vlrTotalCotizacionVoluntariaReportadas) {
		this.vlrTotalCotizacionVoluntariaReportadas = vlrTotalCotizacionVoluntariaReportadas;
	}
	public Long getVlrTotalCotizacionVoluntariaAportante() {
		return vlrTotalCotizacionVoluntariaAportante;
	}
	public void setVlrTotalCotizacionVoluntariaAportante(Long vlrTotalCotizacionVoluntariaAportante) {
		this.vlrTotalCotizacionVoluntariaAportante = vlrTotalCotizacionVoluntariaAportante;
	}
	public Long getVlrAporteFondoSolidaridadSubCtaSolidaridad() {
		return vlrAporteFondoSolidaridadSubCtaSolidaridad;
	}
	public void setVlrAporteFondoSolidaridadSubCtaSolidaridad(Long vlrAporteFondoSolidaridadSubCtaSolidaridad) {
		this.vlrAporteFondoSolidaridadSubCtaSolidaridad = vlrAporteFondoSolidaridadSubCtaSolidaridad;
	}
	public Long getVlrAporteFondoSolidaridadSubCtaSubsistencia() {
		return vlrAporteFondoSolidaridadSubCtaSubsistencia;
	}
	public void setVlrAporteFondoSolidaridadSubCtaSubsistencia(Long vlrAporteFondoSolidaridadSubCtaSubsistencia) {
		this.vlrAporteFondoSolidaridadSubCtaSubsistencia = vlrAporteFondoSolidaridadSubCtaSubsistencia;
	}
	public Integer getNumeroDiasMoraLiquidados() {
		return numeroDiasMoraLiquidados;
	}
	public void setNumeroDiasMoraLiquidados(Integer numeroDiasMoraLiquidados) {
		this.numeroDiasMoraLiquidados = numeroDiasMoraLiquidados;
	}
	public Long getValorInteresMoraSobreCotizaciones() {
		return valorInteresMoraSobreCotizaciones;
	}
	public void setValorInteresMoraSobreCotizaciones(Long valorInteresMoraSobreCotizaciones) {
		this.valorInteresMoraSobreCotizaciones = valorInteresMoraSobreCotizaciones;
	}
	public Long getValorInteresMoraSobreAporteFondoSolidaridad() {
		return valorInteresMoraSobreAporteFondoSolidaridad;
	}
	public void setValorInteresMoraSobreAporteFondoSolidaridad(Long valorInteresMoraSobreAporteFondoSolidaridad) {
		this.valorInteresMoraSobreAporteFondoSolidaridad = valorInteresMoraSobreAporteFondoSolidaridad;
	}
	public Long getValorInteresMoraSobreAporteFondoSolidaridadSubsistencia() {
		return valorInteresMoraSobreAporteFondoSolidaridadSubsistencia;
	}
	public void setValorInteresMoraSobreAporteFondoSolidaridadSubsistencia(
			Long valorInteresMoraSobreAporteFondoSolidaridadSubsistencia) {
		this.valorInteresMoraSobreAporteFondoSolidaridadSubsistencia = valorInteresMoraSobreAporteFondoSolidaridadSubsistencia;
	}
	public Long getTotalPagarAdministradora() {
		return totalPagarAdministradora;
	}
	public void setTotalPagarAdministradora(Long totalPagarAdministradora) {
		this.totalPagarAdministradora = totalPagarAdministradora;
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
		builder.append("Reg1747Tp3 [codigoAdministradoraPensiones=");
		builder.append(codigoAdministradoraPensiones);
		builder.append(", nitAdministradoraPensiones=");
		builder.append(nitAdministradoraPensiones);
		builder.append(", digVerNitAdministradoraPensiones=");
		builder.append(digVerNitAdministradoraPensiones);
		builder.append(", vlrTotalCotizacionObligacionesReportadas=");
		builder.append(vlrTotalCotizacionObligacionesReportadas);
		builder.append(", vlrTotalCotizacionVoluntariaReportadas=");
		builder.append(vlrTotalCotizacionVoluntariaReportadas);
		builder.append(", vlrTotalCotizacionVoluntariaAportante=");
		builder.append(vlrTotalCotizacionVoluntariaAportante);
		builder.append(", vlrAporteFondoSolidaridadSubCtaSolidaridad=");
		builder.append(vlrAporteFondoSolidaridadSubCtaSolidaridad);
		builder.append(", vlrAporteFondoSolidaridadSubCtaSubsistencia=");
		builder.append(vlrAporteFondoSolidaridadSubCtaSubsistencia);
		builder.append(", numeroDiasMoraLiquidados=");
		builder.append(numeroDiasMoraLiquidados);
		builder.append(", valorInteresMoraSobreCotizaciones=");
		builder.append(valorInteresMoraSobreCotizaciones);
		builder.append(", valorInteresMoraSobreAporteFondoSolidaridad=");
		builder.append(valorInteresMoraSobreAporteFondoSolidaridad);
		builder.append(", valorInteresMoraSobreAporteFondoSolidaridadSubsistencia=");
		builder.append(valorInteresMoraSobreAporteFondoSolidaridadSubsistencia);
		builder.append(", totalPagarAdministradora=");
		builder.append(totalPagarAdministradora);
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

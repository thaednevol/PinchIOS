package com.ach.soi.empresarial.converters.model.beans1747;

import java.io.Serializable;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg1747Tp11 extends CommonBean implements Serializable{
	
	private Long vlrPagarPensiones;
	private Long vlrPagarSalud;
	private Long vlrPagarRiesgosProfesionales;
	private Long vlrCajasCompensacion;
	private Long vlrPagarSena;
	private Long vlrPagarICBF;
	private Long vlrPagarESAP;
	private Long vlrPagarMinisterioEducacion;
	private Long vlrGranTotal;
	private Integer numeroAdministradorasPension;
	private Integer numeroEPSReportadas;
	private Integer numeroARPReportadas;
	private Integer numeroCCFReportadas;
	public Long getVlrPagarPensiones() {
		return vlrPagarPensiones;
	}
	public void setVlrPagarPensiones(Long vlrPagarPensiones) {
		this.vlrPagarPensiones = vlrPagarPensiones;
	}
	public Long getVlrPagarSalud() {
		return vlrPagarSalud;
	}
	public void setVlrPagarSalud(Long vlrPagarSalud) {
		this.vlrPagarSalud = vlrPagarSalud;
	}
	public Long getVlrPagarRiesgosProfesionales() {
		return vlrPagarRiesgosProfesionales;
	}
	public void setVlrPagarRiesgosProfesionales(Long vlrPagarRiesgosProfesionales) {
		this.vlrPagarRiesgosProfesionales = vlrPagarRiesgosProfesionales;
	}
	public Long getVlrCajasCompensacion() {
		return vlrCajasCompensacion;
	}
	public void setVlrCajasCompensacion(Long vlrCajasCompensacion) {
		this.vlrCajasCompensacion = vlrCajasCompensacion;
	}
	public Long getVlrPagarSena() {
		return vlrPagarSena;
	}
	public void setVlrPagarSena(Long vlrPagarSena) {
		this.vlrPagarSena = vlrPagarSena;
	}
	public Long getVlrPagarICBF() {
		return vlrPagarICBF;
	}
	public void setVlrPagarICBF(Long vlrPagarICBF) {
		this.vlrPagarICBF = vlrPagarICBF;
	}
	public Long getVlrPagarESAP() {
		return vlrPagarESAP;
	}
	public void setVlrPagarESAP(Long vlrPagarESAP) {
		this.vlrPagarESAP = vlrPagarESAP;
	}
	public Long getVlrPagarMinisterioEducacion() {
		return vlrPagarMinisterioEducacion;
	}
	public void setVlrPagarMinisterioEducacion(Long vlrPagarMinisterioEducacion) {
		this.vlrPagarMinisterioEducacion = vlrPagarMinisterioEducacion;
	}
	public Long getVlrGranTotal() {
		return vlrGranTotal;
	}
	public void setVlrGranTotal(Long vlrGranTotal) {
		this.vlrGranTotal = vlrGranTotal;
	}
	public Integer getNumeroAdministradorasPension() {
		return numeroAdministradorasPension;
	}
	public void setNumeroAdministradorasPension(Integer numeroAdministradorasPension) {
		this.numeroAdministradorasPension = numeroAdministradorasPension;
	}
	public Integer getNumeroEPSReportadas() {
		return numeroEPSReportadas;
	}
	public void setNumeroEPSReportadas(Integer numeroEPSReportadas) {
		this.numeroEPSReportadas = numeroEPSReportadas;
	}
	public Integer getNumeroARPReportadas() {
		return numeroARPReportadas;
	}
	public void setNumeroARPReportadas(Integer numeroARPReportadas) {
		this.numeroARPReportadas = numeroARPReportadas;
	}
	public Integer getNumeroCCFReportadas() {
		return numeroCCFReportadas;
	}
	public void setNumeroCCFReportadas(Integer numeroCCFReportadas) {
		this.numeroCCFReportadas = numeroCCFReportadas;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reg1747Tp11 [vlrPagarPensiones=");
		builder.append(vlrPagarPensiones);
		builder.append(", vlrPagarSalud=");
		builder.append(vlrPagarSalud);
		builder.append(", vlrPagarRiesgosProfesionales=");
		builder.append(vlrPagarRiesgosProfesionales);
		builder.append(", vlrCajasCompensacion=");
		builder.append(vlrCajasCompensacion);
		builder.append(", vlrPagarSena=");
		builder.append(vlrPagarSena);
		builder.append(", vlrPagarICBF=");
		builder.append(vlrPagarICBF);
		builder.append(", vlrPagarESAP=");
		builder.append(vlrPagarESAP);
		builder.append(", vlrPagarMinisterioEducacion=");
		builder.append(vlrPagarMinisterioEducacion);
		builder.append(", vlrGranTotal=");
		builder.append(vlrGranTotal);
		builder.append(", numeroAdministradorasPension=");
		builder.append(numeroAdministradorasPension);
		builder.append(", numeroEPSReportadas=");
		builder.append(numeroEPSReportadas);
		builder.append(", numeroARPReportadas=");
		builder.append(numeroARPReportadas);
		builder.append(", numeroCCFReportadas=");
		builder.append(numeroCCFReportadas);
		builder.append(", tipoRegistro=");
		builder.append(tipoRegistro);
		builder.append(", secuencia=");
		builder.append(secuencia);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}

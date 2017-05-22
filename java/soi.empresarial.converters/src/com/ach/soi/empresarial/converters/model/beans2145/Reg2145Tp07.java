package com.ach.soi.empresarial.converters.model.beans2145;

import java.io.Serializable;

import com.ach.soi.empresarial.converters.model.CommonBean;

@SuppressWarnings("serial")
public class Reg2145Tp07 extends CommonBean implements Serializable {
	
	private Long totalAPagar;
	private Long totalAPagarFondoSolPensional;
	private Long totalAPagarSalud;
	private Long totalAPagarCCF;
	private Long granTotalAPagar;
	private Integer nroAdminPensionesReportadas;
	private Integer nroEPSoEOCReportadas;
	private Integer nroCCFReportadas;
	public Long getTotalAPagar() {
		return totalAPagar;
	}
	public void setTotalAPagar(Long totalAPagar) {
		this.totalAPagar = totalAPagar;
	}
	public Long getTotalAPagarFondoSolPensional() {
		return totalAPagarFondoSolPensional;
	}
	public void setTotalAPagarFondoSolPensional(Long totalAPagarFondoSolPensional) {
		this.totalAPagarFondoSolPensional = totalAPagarFondoSolPensional;
	}
	public Long getTotalAPagarSalud() {
		return totalAPagarSalud;
	}
	public void setTotalAPagarSalud(Long totalAPagarSalud) {
		this.totalAPagarSalud = totalAPagarSalud;
	}
	public Long getTotalAPagarCCF() {
		return totalAPagarCCF;
	}
	public void setTotalAPagarCCF(Long totalAPagarCCF) {
		this.totalAPagarCCF = totalAPagarCCF;
	}
	public Long getGranTotalAPagar() {
		return granTotalAPagar;
	}
	public void setGranTotalAPagar(Long granTotalAPagar) {
		this.granTotalAPagar = granTotalAPagar;
	}
	public Integer getNroAdminPensionesReportadas() {
		return nroAdminPensionesReportadas;
	}
	public void setNroAdminPensionesReportadas(Integer nroAdminPensionesReportadas) {
		this.nroAdminPensionesReportadas = nroAdminPensionesReportadas;
	}
	public Integer getNroEPSoEOCReportadas() {
		return nroEPSoEOCReportadas;
	}
	public void setNroEPSoEOCReportadas(Integer nroEPSoEOCReportadas) {
		this.nroEPSoEOCReportadas = nroEPSoEOCReportadas;
	}
	public Integer getNroCCFReportadas() {
		return nroCCFReportadas;
	}
	public void setNroCCFReportadas(Integer nroCCFReportadas) {
		this.nroCCFReportadas = nroCCFReportadas;
	}
}

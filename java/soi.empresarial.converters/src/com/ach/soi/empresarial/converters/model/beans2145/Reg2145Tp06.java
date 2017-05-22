package com.ach.soi.empresarial.converters.model.beans2145;

import java.io.Serializable;

import com.ach.soi.empresarial.converters.model.CommonBean;

@SuppressWarnings("serial")
public class Reg2145Tp06 extends CommonBean implements Serializable {

	private String codigoCCF;
	private String nitCCF;
	private Integer digitoVerificacionCCF;
	private Long valorAportes;
	private Integer nroDiasMoraLiquidados;
	private Long valorIntMoraAporte;
	private Long totalAPagarCCF;
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
	public Integer getDigitoVerificacionCCF() {
		return digitoVerificacionCCF;
	}
	public void setDigitoVerificacionCCF(Integer digitoVerificacionCCF) {
		this.digitoVerificacionCCF = digitoVerificacionCCF;
	}
	public Long getValorAportes() {
		return valorAportes;
	}
	public void setValorAportes(Long valorAportes) {
		this.valorAportes = valorAportes;
	}
	public Integer getNroDiasMoraLiquidados() {
		return nroDiasMoraLiquidados;
	}
	public void setNroDiasMoraLiquidados(Integer nroDiasMoraLiquidados) {
		this.nroDiasMoraLiquidados = nroDiasMoraLiquidados;
	}
	public Long getValorIntMoraAporte() {
		return valorIntMoraAporte;
	}
	public void setValorIntMoraAporte(Long valorIntMoraAporte) {
		this.valorIntMoraAporte = valorIntMoraAporte;
	}
	public Long getTotalAPagarCCF() {
		return totalAPagarCCF;
	}
	public void setTotalAPagarCCF(Long totalAPagarCCF) {
		this.totalAPagarCCF = totalAPagarCCF;
	}
	public Integer getTotalAfiliadosCCF() {
		return totalAfiliadosCCF;
	}
	public void setTotalAfiliadosCCF(Integer totalAfiliadosCCF) {
		this.totalAfiliadosCCF = totalAfiliadosCCF;
	}
}

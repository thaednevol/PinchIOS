package com.ach.soi.empresarial.converters.model.beans2388.write;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388Tp12 extends CommonBean{

	private Long totalPagarPensiones;
	private Long totalPagarFsp;
	private Long totalPagarSalud;
	private Long totalPagarArl;
	private Long totalPagarCcf;
	private Long totalPagarSena;
	private Long totalPagarIcbf;
	private Long totalPagarEsap;
	private Long totalPagarMen;
	private Long granTotal;
	private Integer numeroAdmPensiones;
	private Integer numeroAdmSalud;
	private Integer numeroAdmRiesgo;
	private Integer numeroAdmCcf;
	public Long getTotalPagarPensiones() {
		return totalPagarPensiones;
	}
	public void setTotalPagarPensiones(Long totalPagarPensiones) {
		this.totalPagarPensiones = totalPagarPensiones;
	}
	public Long getTotalPagarFsp() {
		return totalPagarFsp;
	}
	public void setTotalPagarFsp(Long totalPagarFsp) {
		this.totalPagarFsp = totalPagarFsp;
	}
	public Long getTotalPagarSalud() {
		return totalPagarSalud;
	}
	public void setTotalPagarSalud(Long totalPagarSalud) {
		this.totalPagarSalud = totalPagarSalud;
	}
	public Long getTotalPagarArl() {
		return totalPagarArl;
	}
	public void setTotalPagarArl(Long totalPagarArl) {
		this.totalPagarArl = totalPagarArl;
	}
	public Long getTotalPagarCcf() {
		return totalPagarCcf;
	}
	public void setTotalPagarCcf(Long totalPagarCcf) {
		this.totalPagarCcf = totalPagarCcf;
	}
	public Long getTotalPagarSena() {
		return totalPagarSena;
	}
	public void setTotalPagarSena(Long totalPagarSena) {
		this.totalPagarSena = totalPagarSena;
	}
	public Long getTotalPagarIcbf() {
		return totalPagarIcbf;
	}
	public void setTotalPagarIcbf(Long totalPagarIcbf) {
		this.totalPagarIcbf = totalPagarIcbf;
	}
	public Long getTotalPagarEsap() {
		return totalPagarEsap;
	}
	public void setTotalPagarEsap(Long totalPagarEsap) {
		this.totalPagarEsap = totalPagarEsap;
	}
	public Long getTotalPagarMen() {
		return totalPagarMen;
	}
	public void setTotalPagarMen(Long totalPagarMen) {
		this.totalPagarMen = totalPagarMen;
	}
	public Long getGranTotal() {
		return granTotal;
	}
	public void setGranTotal(Long granTotal) {
		this.granTotal = granTotal;
	}
	public Integer getNumeroAdmPensiones() {
		return numeroAdmPensiones;
	}
	public void setNumeroAdmPensiones(Integer numeroAdmPensiones) {
		this.numeroAdmPensiones = numeroAdmPensiones;
	}
	public Integer getNumeroAdmSalud() {
		return numeroAdmSalud;
	}
	public void setNumeroAdmSalud(Integer numeroAdmSalud) {
		this.numeroAdmSalud = numeroAdmSalud;
	}
	public Integer getNumeroAdmRiesgo() {
		return numeroAdmRiesgo;
	}
	public void setNumeroAdmRiesgo(Integer numeroAdmRiesgo) {
		this.numeroAdmRiesgo = numeroAdmRiesgo;
	}
	public Integer getNumeroAdmCcf() {
		return numeroAdmCcf;
	}
	public void setNumeroAdmCcf(Integer numeroAdmCcf) {
		this.numeroAdmCcf = numeroAdmCcf;
	}
	@Override
	public String toString() {
		return "Reg2388Tp12 [totalPagarPensiones=" + totalPagarPensiones
				+ ", totalPagarFsp=" + totalPagarFsp + ", totalPagarSalud="
				+ totalPagarSalud + ", totalPagarArl=" + totalPagarArl
				+ ", totalPagarCcf=" + totalPagarCcf + ", totalPagarSena="
				+ totalPagarSena + ", totalPagarIcbf=" + totalPagarIcbf
				+ ", totalPagarEsap=" + totalPagarEsap + ", totalPagarMen="
				+ totalPagarMen + ", granTotal=" + granTotal
				+ ", numeroAdmPensiones=" + numeroAdmPensiones
				+ ", numeroAdmSalud=" + numeroAdmSalud + ", numeroAdmRiesgo="
				+ numeroAdmRiesgo + ", numeroAdmCcf=" + numeroAdmCcf
				+ ", tipoRegistro=" + tipoRegistro + ", secuencia=" + secuencia
				+ "]";
	}
	public void buildDefault() {
		super.secuencia = 0;
		super.tipoRegistro = 12;
		this.totalPagarPensiones = 1000l;
		this.totalPagarFsp = 1000l;
		this.totalPagarSalud = 1000l;
		this.totalPagarArl = 1000l;
		this.totalPagarCcf = 1000l;
		this.totalPagarSena = 1000l;
		this.totalPagarIcbf = 1000l;
		this.totalPagarEsap = 1000l;
		this.totalPagarMen = 1000l;
		this.granTotal = 1000l;
		this.numeroAdmPensiones = 20;
		this.numeroAdmSalud = 20;
		this.numeroAdmRiesgo = 20;
		this.numeroAdmCcf = 20;
	}
	
	
}

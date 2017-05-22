package com.ach.soi.empresarial.converters.model.beans2388.write;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388Tp08 extends CommonBean{

	private String nitSena;
	private Integer digitoVerificacionSena;
	private Long valorAporteParafiscal;
	private Integer diasMora;
	private Long valorInteresesMora;
	private Long totalPagarSena;
	private Integer totalAfiliadosAdministradora;
	public String getNitSena() {
		return nitSena;
	}
	public void setNitSena(String nitSena) {
		this.nitSena = nitSena;
	}
	public Integer getDigitoVerificacionSena() {
		return digitoVerificacionSena;
	}
	public void setDigitoVerificacionSena(Integer digitoVerificacionSena) {
		this.digitoVerificacionSena = digitoVerificacionSena;
	}
	public Long getValorAporteParafiscal() {
		return valorAporteParafiscal;
	}
	public void setValorAporteParafiscal(Long valorAporteParafiscal) {
		this.valorAporteParafiscal = valorAporteParafiscal;
	}
	public Integer getDiasMora() {
		return diasMora;
	}
	public void setDiasMora(Integer diasMora) {
		this.diasMora = diasMora;
	}
	public Long getValorInteresesMora() {
		return valorInteresesMora;
	}
	public void setValorInteresesMora(Long valorInteresesMora) {
		this.valorInteresesMora = valorInteresesMora;
	}
	public Long getTotalPagarSena() {
		return totalPagarSena;
	}
	public void setTotalPagarSena(Long totalPagarSena) {
		this.totalPagarSena = totalPagarSena;
	}
	public Integer getTotalAfiliadosAdministradora() {
		return totalAfiliadosAdministradora;
	}
	public void setTotalAfiliadosAdministradora(Integer totalAfiliadosAdministradora) {
		this.totalAfiliadosAdministradora = totalAfiliadosAdministradora;
	}
	@Override
	public String toString() {
		return "Reg2388Tp8 [nitSena=" + nitSena + ", digitoVerificacionSena="
				+ digitoVerificacionSena + ", valorAporteParafiscal="
				+ valorAporteParafiscal + ", diasMora=" + diasMora
				+ ", valorInteresesMora=" + valorInteresesMora
				+ ", totalPagarSena=" + totalPagarSena
				+ ", totalAfiliadosAdministradora="
				+ totalAfiliadosAdministradora + ", tipoRegistro="
				+ tipoRegistro + ", secuencia=" + secuencia + "]";
	}
	public void buildDefault() {
		super.secuencia = 0;
		super.tipoRegistro = 8;
		this.nitSena = "321313231231";
		this.digitoVerificacionSena = 3;
		this.valorAporteParafiscal = 200000l;
		this.diasMora = 0;
		this.valorInteresesMora = 0l;
		this.totalPagarSena = 200000l;
		this.totalAfiliadosAdministradora = 10;
	}
	
	
}

package com.ach.soi.empresarial.converters.model.beans2388.write;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388Tp03 extends CommonBean{
	
	private String codigoAdmPensiones;
	private String nitAdministradoraPensiones;
	private Integer digitoVerificacionAdmPensiones;
	private Long totalCotizacionesObligatorias;
	private Long totalCotizacionesVolAfiliados;
	private Long totalCotizacionesVolAportantes;
	private Long totalAportesFSPSolidaridad;
	private Long totalAportesFSPSubsistencia;
	private Integer diasMora;
	private Long moraCotizacionesOblg;
	private Long moraCotizacionFSPSolidaridad;
	private Long moraCotizacionFSPSubsistencia;
	private Long totalPagarAdministradora;
	private Integer totalAfiliadosAdministradora;
	public String getCodigoAdmPensiones() {
		return codigoAdmPensiones;
	}
	public void setCodigoAdmPensiones(String codigoAdmPensiones) {
		this.codigoAdmPensiones = codigoAdmPensiones;
	}
	public String getNitAdministradoraPensiones() {
		return nitAdministradoraPensiones;
	}
	public void setNitAdministradoraPensiones(String nitAdministradoraPensiones) {
		this.nitAdministradoraPensiones = nitAdministradoraPensiones;
	}
	public Integer getDigitoVerificacionAdmPensiones() {
		return digitoVerificacionAdmPensiones;
	}
	public void setDigitoVerificacionAdmPensiones(
			Integer digitoVerificacionAdmPensiones) {
		this.digitoVerificacionAdmPensiones = digitoVerificacionAdmPensiones;
	}
	public Long getTotalCotizacionesObligatorias() {
		return totalCotizacionesObligatorias;
	}
	public void setTotalCotizacionesObligatorias(Long totalCotizacionesObligatorias) {
		this.totalCotizacionesObligatorias = totalCotizacionesObligatorias;
	}
	public Long getTotalCotizacionesVolAfiliados() {
		return totalCotizacionesVolAfiliados;
	}
	public void setTotalCotizacionesVolAfiliados(Long totalCotizacionesVolAfiliados) {
		this.totalCotizacionesVolAfiliados = totalCotizacionesVolAfiliados;
	}
	public Long getTotalCotizacionesVolAportantes() {
		return totalCotizacionesVolAportantes;
	}
	public void setTotalCotizacionesVolAportantes(
			Long totalCotizacionesVolAportantes) {
		this.totalCotizacionesVolAportantes = totalCotizacionesVolAportantes;
	}
	public Long getTotalAportesFSPSolidaridad() {
		return totalAportesFSPSolidaridad;
	}
	public void setTotalAportesFSPSolidaridad(Long totalAportesFSPSolidaridad) {
		this.totalAportesFSPSolidaridad = totalAportesFSPSolidaridad;
	}
	public Long getTotalAportesFSPSubsistencia() {
		return totalAportesFSPSubsistencia;
	}
	public void setTotalAportesFSPSubsistencia(Long totalAportesFSPSubsistencia) {
		this.totalAportesFSPSubsistencia = totalAportesFSPSubsistencia;
	}
	public Integer getDiasMora() {
		return diasMora;
	}
	public void setDiasMora(Integer diasMora) {
		this.diasMora = diasMora;
	}
	public Long getMoraCotizacionesOblg() {
		return moraCotizacionesOblg;
	}
	public void setMoraCotizacionesOblg(Long moraCotizacionesOblg) {
		this.moraCotizacionesOblg = moraCotizacionesOblg;
	}
	public Long getMoraCotizacionFSPSolidaridad() {
		return moraCotizacionFSPSolidaridad;
	}
	public void setMoraCotizacionFSPSolidaridad(Long moraCotizacionFSPSolidaridad) {
		this.moraCotizacionFSPSolidaridad = moraCotizacionFSPSolidaridad;
	}
	public Long getMoraCotizacionFSPSubsistencia() {
		return moraCotizacionFSPSubsistencia;
	}
	public void setMoraCotizacionFSPSubsistencia(Long moraCotizacionFSPSubsistencia) {
		this.moraCotizacionFSPSubsistencia = moraCotizacionFSPSubsistencia;
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
		return "Reg2388Tp3 [codigoAdmPensiones=" + codigoAdmPensiones
				+ ", nitAdministradoraPensiones=" + nitAdministradoraPensiones
				+ ", digitoVerificacionAdmPensiones="
				+ digitoVerificacionAdmPensiones
				+ ", totalCotizacionesObligatorias="
				+ totalCotizacionesObligatorias
				+ ", totalCotizacionesVolAfiliados="
				+ totalCotizacionesVolAfiliados
				+ ", totalCotizacionesVolAportantes="
				+ totalCotizacionesVolAportantes
				+ ", totalAportesFSPSolidaridad=" + totalAportesFSPSolidaridad
				+ ", totalAportesFSPSubsistencia="
				+ totalAportesFSPSubsistencia + ", diasMora=" + diasMora
				+ ", moraCotizacionesOblg=" + moraCotizacionesOblg
				+ ", moraCotizacionFSPSolidaridad="
				+ moraCotizacionFSPSolidaridad
				+ ", moraCotizacionFSPSubsistencia="
				+ moraCotizacionFSPSubsistencia + ", totalPagarAdministradora="
				+ totalPagarAdministradora + ", totalAfiliadosAdministradora="
				+ totalAfiliadosAdministradora + ", tipoRegistro="
				+ tipoRegistro + ", secuencia=" + secuencia + "]";
	}
	public void buildDefault() {
		super.tipoRegistro = 3;
		super.secuencia = 0;
		this.codigoAdmPensiones = "FSP001";
		this.nitAdministradoraPensiones = "1223231313";
		this.digitoVerificacionAdmPensiones = 9;
		this.totalCotizacionesObligatorias = 999999l;
		this.totalCotizacionesVolAfiliados = 999999l;
		this.totalCotizacionesVolAportantes = 999999l;
		this.totalAportesFSPSolidaridad = 999999l;
		this.totalAportesFSPSubsistencia = 999999l;
		this.diasMora = 0;
		this.moraCotizacionesOblg = 0l;
		this.moraCotizacionFSPSolidaridad = 0l;
		this.moraCotizacionFSPSubsistencia = 0l;
		this.totalPagarAdministradora = 999999l;
		this.totalAfiliadosAdministradora = 3;
	}
	
	
}

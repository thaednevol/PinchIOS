package com.ach.soi.empresarial.converters.model.beans2388.read;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388ReadTp03 extends CommonBean{
	
	private String codigoAdmPensiones;
	private String nitAdministradoraPensiones;
	private String digitoVerificacionAdmPensiones;
	private String totalCotizacionesObligatorias;
	private String totalCotizacionesVolAfiliados;
	private String totalCotizacionesVolAportantes;
	private String totalAportesFSPSolidaridad;
	private String totalAportesFSPSubsistencia;
	private String diasMora;
	private String moraCotizacionesOblg;
	private String moraCotizacionFSPSolidaridad;
	private String moraCotizacionFSPSubsistencia;
	private String totalPagarAdministradora;
	private String totalAfiliadosAdministradora;
	
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
	public String getDigitoVerificacionAdmPensiones() {
		return digitoVerificacionAdmPensiones;
	}
	public void setDigitoVerificacionAdmPensiones(
			String digitoVerificacionAdmPensiones) {
		this.digitoVerificacionAdmPensiones = digitoVerificacionAdmPensiones;
	}
	public String getTotalCotizacionesObligatorias() {
		return totalCotizacionesObligatorias;
	}
	public void setTotalCotizacionesObligatorias(
			String totalCotizacionesObligatorias) {
		this.totalCotizacionesObligatorias = totalCotizacionesObligatorias;
	}
	public String getTotalCotizacionesVolAfiliados() {
		return totalCotizacionesVolAfiliados;
	}
	public void setTotalCotizacionesVolAfiliados(
			String totalCotizacionesVolAfiliados) {
		this.totalCotizacionesVolAfiliados = totalCotizacionesVolAfiliados;
	}
	public String getTotalCotizacionesVolAportantes() {
		return totalCotizacionesVolAportantes;
	}
	public void setTotalCotizacionesVolAportantes(
			String totalCotizacionesVolAportantes) {
		this.totalCotizacionesVolAportantes = totalCotizacionesVolAportantes;
	}
	public String getTotalAportesFSPSolidaridad() {
		return totalAportesFSPSolidaridad;
	}
	public void setTotalAportesFSPSolidaridad(String totalAportesFSPSolidaridad) {
		this.totalAportesFSPSolidaridad = totalAportesFSPSolidaridad;
	}
	public String getTotalAportesFSPSubsistencia() {
		return totalAportesFSPSubsistencia;
	}
	public void setTotalAportesFSPSubsistencia(String totalAportesFSPSubsistencia) {
		this.totalAportesFSPSubsistencia = totalAportesFSPSubsistencia;
	}
	public String getDiasMora() {
		return diasMora;
	}
	public void setDiasMora(String diasMora) {
		this.diasMora = diasMora;
	}
	public String getMoraCotizacionesOblg() {
		return moraCotizacionesOblg;
	}
	public void setMoraCotizacionesOblg(String moraCotizacionesOblg) {
		this.moraCotizacionesOblg = moraCotizacionesOblg;
	}
	public String getMoraCotizacionFSPSolidaridad() {
		return moraCotizacionFSPSolidaridad;
	}
	public void setMoraCotizacionFSPSolidaridad(String moraCotizacionFSPSolidaridad) {
		this.moraCotizacionFSPSolidaridad = moraCotizacionFSPSolidaridad;
	}
	public String getMoraCotizacionFSPSubsistencia() {
		return moraCotizacionFSPSubsistencia;
	}
	public void setMoraCotizacionFSPSubsistencia(
			String moraCotizacionFSPSubsistencia) {
		this.moraCotizacionFSPSubsistencia = moraCotizacionFSPSubsistencia;
	}
	public String getTotalPagarAdministradora() {
		return totalPagarAdministradora;
	}
	public void setTotalPagarAdministradora(String totalPagarAdministradora) {
		this.totalPagarAdministradora = totalPagarAdministradora;
	}
	public String getTotalAfiliadosAdministradora() {
		return totalAfiliadosAdministradora;
	}
	public void setTotalAfiliadosAdministradora(String totalAfiliadosAdministradora) {
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
		this.digitoVerificacionAdmPensiones = "9";
		this.totalCotizacionesObligatorias = "999999l";
		this.totalCotizacionesVolAfiliados = "999999l";
		this.totalCotizacionesVolAportantes = "999999l";
		this.totalAportesFSPSolidaridad = "999999l";
		this.totalAportesFSPSubsistencia = "999999l";
		this.diasMora = "0";
		this.moraCotizacionesOblg = "0l";
		this.moraCotizacionFSPSolidaridad = "0l";
		this.moraCotizacionFSPSubsistencia = "0l";
		this.totalPagarAdministradora = "999999l";
		this.totalAfiliadosAdministradora = "3";
	}
	
	public String[] toStringArray(){
		String array[] = new String[16];
		array[0]=tipoRegistro.toString();
		array[1]=secuencia.toString();
		array[2]=codigoAdmPensiones ;
		array[3]=nitAdministradoraPensiones ;
		array[4]=digitoVerificacionAdmPensiones ;
		array[5]=totalCotizacionesObligatorias ;
		array[6]=totalCotizacionesVolAfiliados ;
		array[7]=totalCotizacionesVolAportantes ;
		array[8]=totalAportesFSPSolidaridad ;
		array[9]=totalAportesFSPSubsistencia ;
		array[10]=diasMora ;
		array[11]=moraCotizacionesOblg ;
		array[12]=moraCotizacionFSPSolidaridad ;
		array[13]=moraCotizacionFSPSubsistencia ;
		array[14]=totalPagarAdministradora ;
		array[15]=totalAfiliadosAdministradora ;
		return array;
	}
	
	public static String[] getLabels ( ){
		String[] labels = new String[16];
		labels[0]="Tipo registro";
		labels[1]="Secuencia";
		labels[2]="C\u00F3—digo AFP";
		labels[3]="NIT AFP";
		labels[4]="Dig. Ver. AFP";
		labels[5]="Total Cot Oblg";
		labels[6]="Total Cot Vol Afiliado";
		labels[7]="Total Cot Vol Aportante";
		labels[8]="Total Aportes FSP-Sol";
		labels[9]="Total Aportes FSP-Sub";
		labels[10]="D\u00FA’as mora";
		labels[11]="Mora Cotizaci—\u00F3n FSP";
		labels[12]="Mora FSP-Sol";
		labels[13]="Mora FSP-Sub";
		labels[14]="Total Pagar FSP";
		labels[15]="Nro Afiliados FSP";
		return labels;
	}
	

	public static Reg2388ReadTp03 buildRecordFromStringArray( String array[] ){
		
		String[] arrayAux = Reg2388ReadTp03.fillArray(array, 16);
		Reg2388ReadTp03 instance = new Reg2388ReadTp03();
		instance.tipoRegistro=Integer.valueOf(arrayAux[0]);
		instance.secuencia=Integer.valueOf(arrayAux[1]);
		instance.codigoAdmPensiones=arrayAux[2];
		instance.nitAdministradoraPensiones=arrayAux[3];
		instance.digitoVerificacionAdmPensiones=arrayAux[4];
		instance.totalCotizacionesObligatorias=arrayAux[5];
		instance.totalCotizacionesVolAfiliados=arrayAux[6];
		instance.totalCotizacionesVolAportantes=arrayAux[7];
		instance.totalAportesFSPSolidaridad=arrayAux[8];
		instance.totalAportesFSPSubsistencia=arrayAux[9];
		instance.diasMora=arrayAux[10];
		instance.moraCotizacionesOblg=arrayAux[11];
		instance.moraCotizacionFSPSolidaridad=arrayAux[12];
		instance.moraCotizacionFSPSubsistencia=arrayAux[13];
		instance.totalPagarAdministradora=arrayAux[14];
		instance.totalAfiliadosAdministradora=arrayAux[15];
		return instance;
	}
	
}

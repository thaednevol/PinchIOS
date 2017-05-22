package com.ach.soi.empresarial.converters.model.beans2388.read;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388ReadPensTp03 extends CommonBean{
	
	private String codigoAdmPensiones;
	private String nitAdministradoraPensiones;
	private String digitoVerificacionAdmPensiones;
	private String totalCotizacionesObligatorias;
	private String totalCotizacionesVolAfiliados;
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
		String array[] = new String[15];
		array[0]=tipoRegistro.toString();
		array[1]=secuencia.toString();
		array[2]=codigoAdmPensiones;
		array[3]=nitAdministradoraPensiones;
		array[4]=digitoVerificacionAdmPensiones;
		array[5]=totalCotizacionesObligatorias;
		array[6]=totalCotizacionesVolAfiliados;
		array[7]=totalAportesFSPSolidaridad;
		array[8]=totalAportesFSPSubsistencia;
		array[9]=diasMora;
		array[10]=moraCotizacionesOblg;
		array[11]=moraCotizacionFSPSolidaridad;
		array[12]=moraCotizacionFSPSubsistencia;
		array[13]=totalPagarAdministradora;
		array[14]=totalAfiliadosAdministradora;
		return array;
	}
	
	public static String[] getLabels ( ){
		String[] labels = new String[15];
		labels[0]="Tipo de registro";
		labels[1]="Secuencia";
		labels[2]="C—digo Administradora Pensiones";
		labels[3]="NIT Fondo de Pensiones";
		labels[4]="D’gito de verificaci—n Administradora Pensiones";
		labels[5]="Valor total cotizaciones";
		labels[6]="Valor total cotizaciones voluntarias";
		labels[7]="Valor total aportes FSP Solidaridad";
		labels[8]="Valor total aportes FSP Subsistencia";
		labels[9]="Nœmero de d’as de mora";
		labels[10]="Intereses de mora Cotizaciones";
		labels[11]="Intereses de mora FSP Solidaridad";
		labels[12]="Intereses de mora FSP Subsistencia";
		labels[13]="Total a pagar";
		labels[14]="Total afiliados";
		return labels;
	}
	

	public static Reg2388ReadPensTp03 buildRecordFromStringArray( String array[] ){
		
		String[] arrayAux = Reg2388ReadPensTp03.fillArray(array, 15);
		Reg2388ReadPensTp03 instance = new Reg2388ReadPensTp03();
		instance.tipoRegistro=Integer.valueOf(arrayAux[0]);
		instance.secuencia=Integer.valueOf(arrayAux[1]);
		instance.codigoAdmPensiones=arrayAux[2];
		instance.nitAdministradoraPensiones=arrayAux[3];
		instance.digitoVerificacionAdmPensiones=arrayAux[4];
		instance.totalCotizacionesObligatorias=arrayAux[5];
		instance.totalCotizacionesVolAfiliados=arrayAux[6];
		instance.totalAportesFSPSolidaridad=arrayAux[7];
		instance.totalAportesFSPSubsistencia=arrayAux[8];
		instance.diasMora=arrayAux[9];
		instance.moraCotizacionesOblg=arrayAux[10];
		instance.moraCotizacionFSPSolidaridad=arrayAux[11];
		instance.moraCotizacionFSPSubsistencia=arrayAux[12];
		instance.totalPagarAdministradora=arrayAux[13];
		instance.totalAfiliadosAdministradora=arrayAux[14];
		return instance;
	}
	
}

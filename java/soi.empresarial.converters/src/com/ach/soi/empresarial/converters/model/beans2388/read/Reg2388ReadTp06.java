package com.ach.soi.empresarial.converters.model.beans2388.read;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388ReadTp06 extends CommonBean{

	private String codigoArl;
	private String nitArl;
	private String digitoVerificacionArl;
	private String valorCotizaciones;
	private String numeroAutIncapacidades;
	private String valorTotalIncapacidades;
	private String valorAportesOtrosSistemas;
	private String valorNetoAportes;
	private String diasMora;
	private String valorMoraCotizacion;
	private String subtotalCotizacion;
	private String numeroPlanillaSaldoAFavor;
	private String valorSaldoAFavor;
	private String totalPagarAdministradora;
	private String fondoRiesgosLaborales;
	private String totalAfiliadosAdministradora;
	public String getCodigoArl() {
		return codigoArl;
	}
	public void setCodigoArl(String codigoArl) {
		this.codigoArl = codigoArl;
	}
	public String getNitArl() {
		return nitArl;
	}
	public void setNitArl(String nitArl) {
		this.nitArl = nitArl;
	}
	public String getDigitoVerificacionArl() {
		return digitoVerificacionArl;
	}
	public void setDigitoVerificacionArl(String digitoVerificacionArl) {
		this.digitoVerificacionArl = digitoVerificacionArl;
	}
	public String getValorCotizaciones() {
		return valorCotizaciones;
	}
	public void setValorCotizaciones(String valorCotizaciones) {
		this.valorCotizaciones = valorCotizaciones;
	}
	public String getNumeroAutIncapacidades() {
		return numeroAutIncapacidades;
	}
	public void setNumeroAutIncapacidades(String numeroAutIncapacidades) {
		this.numeroAutIncapacidades = numeroAutIncapacidades;
	}
	public String getValorTotalIncapacidades() {
		return valorTotalIncapacidades;
	}
	public void setValorTotalIncapacidades(String valorTotalIncapacidades) {
		this.valorTotalIncapacidades = valorTotalIncapacidades;
	}
	public String getValorAportesOtrosSistemas() {
		return valorAportesOtrosSistemas;
	}
	public void setValorAportesOtrosSistemas(String valorAportesOtrosSistemas) {
		this.valorAportesOtrosSistemas = valorAportesOtrosSistemas;
	}
	public String getValorNetoAportes() {
		return valorNetoAportes;
	}
	public void setValorNetoAportes(String valorNetoAportes) {
		this.valorNetoAportes = valorNetoAportes;
	}
	public String getDiasMora() {
		return diasMora;
	}
	public void setDiasMora(String diasMora) {
		this.diasMora = diasMora;
	}
	public String getValorMoraCotizacion() {
		return valorMoraCotizacion;
	}
	public void setValorMoraCotizacion(String valorMoraCotizacion) {
		this.valorMoraCotizacion = valorMoraCotizacion;
	}
	public String getSubtotalCotizacion() {
		return subtotalCotizacion;
	}
	public void setSubtotalCotizacion(String subtotalCotizacion) {
		this.subtotalCotizacion = subtotalCotizacion;
	}
	public String getNumeroPlanillaSaldoAFavor() {
		return numeroPlanillaSaldoAFavor;
	}
	public void setNumeroPlanillaSaldoAFavor(String numeroPlanillaSaldoAFavor) {
		this.numeroPlanillaSaldoAFavor = numeroPlanillaSaldoAFavor;
	}
	public String getValorSaldoAFavor() {
		return valorSaldoAFavor;
	}
	public void setValorSaldoAFavor(String valorSaldoAFavor) {
		this.valorSaldoAFavor = valorSaldoAFavor;
	}
	public String getTotalPagarAdministradora() {
		return totalPagarAdministradora;
	}
	public void setTotalPagarAdministradora(String totalPagarAdministradora) {
		this.totalPagarAdministradora = totalPagarAdministradora;
	}
	public String getFondoRiesgosLaborales() {
		return fondoRiesgosLaborales;
	}
	public void setFondoRiesgosLaborales(String fondoRiesgosLaborales) {
		this.fondoRiesgosLaborales = fondoRiesgosLaborales;
	}
	public String getTotalAfiliadosAdministradora() {
		return totalAfiliadosAdministradora;
	}
	public void setTotalAfiliadosAdministradora(String totalAfiliadosAdministradora) {
		this.totalAfiliadosAdministradora = totalAfiliadosAdministradora;
	}
	@Override
	public String toString() {
		return "Reg2388Tp6 [codigoArl=" + codigoArl + ", nitArl=" + nitArl
				+ ", digitoVerificacionArl=" + digitoVerificacionArl
				+ ", valorCotizaciones=" + valorCotizaciones
				+ ", numeroAutIncapacidades=" + numeroAutIncapacidades
				+ ", valorTotalIncapacidades=" + valorTotalIncapacidades
				+ ", valorAportesOtrosSistemas=" + valorAportesOtrosSistemas
				+ ", valorNetoAportes=" + valorNetoAportes + ", diasMora="
				+ diasMora + ", valorMoraCotizacion=" + valorMoraCotizacion
				+ ", subtotalCotizacion=" + subtotalCotizacion
				+ ", numeroPlanillaSaldoAFavor=" + numeroPlanillaSaldoAFavor
				+ ", valorSaldoAFavor=" + valorSaldoAFavor
				+ ", totalPagarAdministradora=" + totalPagarAdministradora
				+ ", fondoRiesgosLaborales=" + fondoRiesgosLaborales
				+ ", totalAfiliadosAdministradora="
				+ totalAfiliadosAdministradora + ", tipoRegistro="
				+ tipoRegistro + ", secuencia=" + secuencia + "]";
	}
	
	
	public void buildDefault() {
		super.secuencia = 0;
		super.tipoRegistro = 6;		
	}
	
	public String[] toStringArray(){
		String array[] = new String[18];
		array[0]=tipoRegistro.toString();
		array[1]=secuencia.toString();		
		array[2]=codigoArl;
		array[3]=nitArl;
		array[4]=digitoVerificacionArl;
		array[5]=valorCotizaciones;
		array[6]=numeroAutIncapacidades;
		array[7]=valorTotalIncapacidades;
		array[8]=valorAportesOtrosSistemas;
		array[9]=valorNetoAportes;
		array[10]=diasMora;
		array[11]=valorMoraCotizacion;
		array[12]=subtotalCotizacion;
		array[13]=numeroPlanillaSaldoAFavor;
		array[14]=valorSaldoAFavor;
		array[15]=totalPagarAdministradora;
		array[16]=fondoRiesgosLaborales;
		array[17]=totalAfiliadosAdministradora;
		return array;
	}
	
	public static String[] getLabels ( ){
		String[] labels = new String[18];
		labels[0]="Tipo registro";
		labels[1]="Secuencia";
		labels[2]="Có—digo ARL";
		labels[3]="NIT ARL";
		labels[4]="Dig. Ver. ARL";
		labels[5]="Total Cotizaciones";
		labels[6]="Autorizaci—ón incapacidades";
		labels[7]="Total incapacidades";
		labels[8]="Aportes a otros sistemas";
		labels[9]="Aportes cotizació—n";
		labels[10]="D’ías Mora";
		labels[11]="Valor Mora";
		labels[12]="Aportes cotizaci—n";
		labels[13]="Planilla Saldo a Favor";
		labels[14]="Valor Saldo a Favor";
		labels[15]="Total Pagar";
		labels[16]="Fondo Riesgos";
		labels[17]="Nro. Afiliados";
		return labels;
	}
	
	

	public static Reg2388ReadTp06 buildRecordFromStringArray( String array[] ){
		
		String[] arrayAux = Reg2388ReadTp06.fillArray(array, 18);
		Reg2388ReadTp06 instance = new Reg2388ReadTp06();
		instance.tipoRegistro=Integer.valueOf(arrayAux[0]);
		instance.secuencia=Integer.valueOf(arrayAux[1]);
		instance.codigoArl=arrayAux[2];
		instance.nitArl=arrayAux[3];
		instance.digitoVerificacionArl=arrayAux[4];
		instance.valorCotizaciones=arrayAux[5];
		instance.numeroAutIncapacidades=arrayAux[6];
		instance.valorTotalIncapacidades=arrayAux[7];
		instance.valorAportesOtrosSistemas=arrayAux[8];
		instance.valorNetoAportes=arrayAux[9];
		instance.diasMora=arrayAux[10];
		instance.valorMoraCotizacion=arrayAux[11];
		instance.subtotalCotizacion=arrayAux[12];
		instance.numeroPlanillaSaldoAFavor=arrayAux[13];
		instance.valorSaldoAFavor=arrayAux[14];
		instance.totalPagarAdministradora=arrayAux[15];
		instance.fondoRiesgosLaborales=arrayAux[16];
		instance.totalAfiliadosAdministradora=arrayAux[17];
		return instance;
	}
	
}

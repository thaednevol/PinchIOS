package com.ach.soi.empresarial.converters.model.beans2388.read;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388ReadPensTp05 extends CommonBean{


	private String codigoAdministradoraSalud;
	private String nitEPSoEOC;
	private String digitoVerificacionEPSoEOC;
	private String valorTotalCotOblAdmin;
	private String valorTotalUPCAdmin;
	private String nroDiasMoraLiquidados;
	private String valorIntMoraCotObligatorias;
	private String valorIntMoraUPCAdicionales;
	private String subTotalAportesCot;
	private String subTotalAportesUPC;
	private String totalPagarAdministradora;
	private String valorFosyga;
	private String totalAfiliadosAdministradora;
	
	
	@Override
	public String toString() {
		return "Reg2388ReadPensTp05 [codigoAdministradoraSalud="
				+ codigoAdministradoraSalud + ", nitEPSoEOC=" + nitEPSoEOC
				+ ", digitoVerificacionEPSoEOC=" + digitoVerificacionEPSoEOC
				+ ", valorTotalCotOblAdmin=" + valorTotalCotOblAdmin
				+ ", valorTotalUPCAdmin=" + valorTotalUPCAdmin
				+ ", nroDiasMoraLiquidados=" + nroDiasMoraLiquidados
				+ ", valorIntMoraCotObligatorias="
				+ valorIntMoraCotObligatorias + ", valorIntMoraUPCAdicionales="
				+ valorIntMoraUPCAdicionales + ", subTotalAportesCot="
				+ subTotalAportesCot + ", subTotalAportesUPC="
				+ subTotalAportesUPC + ", totalPagarAdministradora="
				+ totalPagarAdministradora + ", valorFosyga=" + valorFosyga
				+ ", totalAfiliadosAdministradora="
				+ totalAfiliadosAdministradora + "]";
	}

	public String getCodigoAdministradoraSalud() {
		return codigoAdministradoraSalud;
	}

	public void setCodigoAdministradoraSalud(String codigoAdministradoraSalud) {
		this.codigoAdministradoraSalud = codigoAdministradoraSalud;
	}

	public String getNitEPSoEOC() {
		return nitEPSoEOC;
	}

	public void setNitEPSoEOC(String nitEPSoEOC) {
		this.nitEPSoEOC = nitEPSoEOC;
	}

	public String getDigitoVerificacionEPSoEOC() {
		return digitoVerificacionEPSoEOC;
	}

	public void setDigitoVerificacionEPSoEOC(String digitoVerificacionEPSoEOC) {
		this.digitoVerificacionEPSoEOC = digitoVerificacionEPSoEOC;
	}

	public String getValorTotalCotOblAdmin() {
		return valorTotalCotOblAdmin;
	}

	public void setValorTotalCotOblAdmin(String valorTotalCotOblAdmin) {
		this.valorTotalCotOblAdmin = valorTotalCotOblAdmin;
	}

	public String getValorTotalUPCAdmin() {
		return valorTotalUPCAdmin;
	}

	public void setValorTotalUPCAdmin(String valorTotalUPCAdmin) {
		this.valorTotalUPCAdmin = valorTotalUPCAdmin;
	}

	public String getNroDiasMoraLiquidados() {
		return nroDiasMoraLiquidados;
	}

	public void setNroDiasMoraLiquidados(String nroDiasMoraLiquidados) {
		this.nroDiasMoraLiquidados = nroDiasMoraLiquidados;
	}

	public String getValorIntMoraCotObligatorias() {
		return valorIntMoraCotObligatorias;
	}

	public void setValorIntMoraCotObligatorias(String valorIntMoraCotObligatorias) {
		this.valorIntMoraCotObligatorias = valorIntMoraCotObligatorias;
	}

	public String getValorIntMoraUPCAdicionales() {
		return valorIntMoraUPCAdicionales;
	}

	public void setValorIntMoraUPCAdicionales(String valorIntMoraUPCAdicionales) {
		this.valorIntMoraUPCAdicionales = valorIntMoraUPCAdicionales;
	}

	public String getSubTotalAportesCot() {
		return subTotalAportesCot;
	}

	public void setSubTotalAportesCot(String subTotalAportesCot) {
		this.subTotalAportesCot = subTotalAportesCot;
	}

	public String getSubTotalAportesUPC() {
		return subTotalAportesUPC;
	}

	public void setSubTotalAportesUPC(String subTotalAportesUPC) {
		this.subTotalAportesUPC = subTotalAportesUPC;
	}

	public String getTotalPagarAdministradora() {
		return totalPagarAdministradora;
	}

	public void setTotalPagarAdministradora(String totalPagarAdministradora) {
		this.totalPagarAdministradora = totalPagarAdministradora;
	}

	public String getValorFosyga() {
		return valorFosyga;
	}

	public void setValorFosyga(String valorFosyga) {
		this.valorFosyga = valorFosyga;
	}

	public String getTotalAfiliadosAdministradora() {
		return totalAfiliadosAdministradora;
	}

	public void setTotalAfiliadosAdministradora(String totalAfiliadosAdministradora) {
		this.totalAfiliadosAdministradora = totalAfiliadosAdministradora;
	}

	public void buildDefault() {
		super.secuencia = 0;
		super.tipoRegistro = 5;
		
	}
	
	public String[] toStringArray(){
		String array[] = new String[15];
		array[0]=tipoRegistro.toString();
		array[1]=secuencia.toString();				
		array[2]=codigoAdministradoraSalud;
		array[3]=nitEPSoEOC;
		array[4]=digitoVerificacionEPSoEOC;
		array[5]=valorTotalCotOblAdmin;
		array[6]=valorTotalUPCAdmin;
		array[7]=nroDiasMoraLiquidados;
		array[8]=valorIntMoraCotObligatorias;
		array[9]=valorIntMoraUPCAdicionales;
		array[10]=subTotalAportesCot;
		array[11]=subTotalAportesUPC;
		array[12]=totalPagarAdministradora;
		array[13]=valorFosyga;
		array[14]=totalAfiliadosAdministradora;
		return array;
	}
	
	public static String[] getLabels ( ){
		String[] labels = new String[15];
		labels[0]="Tipo de registro.";
		labels[1]="Secuencia.";
		labels[2]="C—digo administradora de Salud";
		labels[3]="NIT EPS o EOC";
		labels[4]="D’gito de verificaci—n EPS";
		labels[5]="Valor cotizaciones obligatorias";
		labels[6]="Valor obligatorias A127:N132";
		labels[7]="D’as de mora liquidados";
		labels[8]="Intereses de mora cotizaciones";
		labels[9]="Intereses de mora UPC";
		labels[10]="Subtotal cotizaci—n";
		labels[11]="Subtotal UPC";
		labels[12]="Total a pagar";
		labels[13]="Valor Fosyga";
		labels[14]="Nro Afiliados administradora";
		return labels;
	}
	

	public static Reg2388ReadPensTp05 buildRecordFromStringArray( String array[] ){
		
		String[] arrayAux = Reg2388ReadPensTp05.fillArray(array, 15);
		Reg2388ReadPensTp05 instance = new Reg2388ReadPensTp05();
		instance.tipoRegistro=Integer.valueOf(arrayAux[0]);
		instance.secuencia=Integer.valueOf(arrayAux[1]);
		instance.codigoAdministradoraSalud=arrayAux[2];
		instance.nitEPSoEOC=arrayAux[3];
		instance.digitoVerificacionEPSoEOC=arrayAux[4];
		instance.valorTotalCotOblAdmin=arrayAux[5];
		instance.valorTotalUPCAdmin=arrayAux[6];
		instance.nroDiasMoraLiquidados=arrayAux[7];
		instance.valorIntMoraCotObligatorias=arrayAux[8];
		instance.valorIntMoraUPCAdicionales=arrayAux[9];
		instance.subTotalAportesCot=arrayAux[10];
		instance.subTotalAportesUPC=arrayAux[11];
		instance.totalPagarAdministradora=arrayAux[12];
		instance.valorFosyga=arrayAux[13];
		instance.totalAfiliadosAdministradora=arrayAux[14];
		return instance;
	}
	
}

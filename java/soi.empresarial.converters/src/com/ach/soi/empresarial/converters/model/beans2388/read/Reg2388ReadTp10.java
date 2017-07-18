package com.ach.soi.empresarial.converters.model.beans2388.read;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388ReadTp10 extends CommonBean{
	private String nitEsap;
	private String digitoVerificacionEsap;
	private String valorAporteParafiscal;
	private String diasMora;
	private String valorInteresesMora;
	private String totalPagarEsap;
	public String getNitEsap() {
		return nitEsap;
	}
	public void setNitEsap(String nitEsap) {
		this.nitEsap = nitEsap;
	}
	public String getDigitoVerificacionEsap() {
		return digitoVerificacionEsap;
	}
	public void setDigitoVerificacionEsap(String digitoVerificacionEsap) {
		this.digitoVerificacionEsap = digitoVerificacionEsap;
	}
	public String getValorAporteParafiscal() {
		return valorAporteParafiscal;
	}
	public void setValorAporteParafiscal(String valorAporteParafiscal) {
		this.valorAporteParafiscal = valorAporteParafiscal;
	}
	public String getDiasMora() {
		return diasMora;
	}
	public void setDiasMora(String diasMora) {
		this.diasMora = diasMora;
	}
	public String getValorInteresesMora() {
		return valorInteresesMora;
	}
	public void setValorInteresesMora(String valorInteresesMora) {
		this.valorInteresesMora = valorInteresesMora;
	}
	public String getTotalPagarEsap() {
		return totalPagarEsap;
	}
	public void setTotalPagarEsap(String totalPagarEsap) {
		this.totalPagarEsap = totalPagarEsap;
	}
	@Override
	public String toString() {
		return "Reg2388Tp10 [nitEsap=" + nitEsap + ", digitoVerificacionEsap="
				+ digitoVerificacionEsap + ", valorAporteParafiscal="
				+ valorAporteParafiscal + ", diasMora=" + diasMora
				+ ", valorInteresesMora=" + valorInteresesMora
				+ ", totalPagarEsap=" + totalPagarEsap + ", tipoRegistro="
				+ tipoRegistro + ", secuencia=" + secuencia + "]";
	}
	public void buildDefault() {
		super.secuencia = 0;
		super.tipoRegistro = 10;
		
	}
	

	public String[] toStringArray(){
		String array[] = new String[8];
		array[0]=tipoRegistro.toString();
		array[1]=secuencia.toString();		
		array[2]=nitEsap;
		array[3]=digitoVerificacionEsap;
		array[4]=valorAporteParafiscal;
		array[5]=diasMora;
		array[6]=valorInteresesMora;
		array[7]=totalPagarEsap;
		return array;
	}

	
	
	public static String[] getLabels ( ){
		String[] labels = new String[8];
		labels[0]="Tipo de registro.";
		labels[1]="Secuencia";
		labels[2]="NIT ESAP.";
		labels[3]="Dig. Ver. ESAP.";
		labels[4]="Valor a pagar";
		labels[5]="D’ías Mora";
		labels[6]="Intereses mora";
		labels[7]="Total a pagar";
		return labels;
	}
	

	public static Reg2388ReadTp10 buildRecordFromStringArray( String array[] ){
		
		String[] arrayAux = Reg2388ReadTp11.fillArray(array, 8);
		Reg2388ReadTp10 instance = new Reg2388ReadTp10();
		instance.tipoRegistro=Integer.valueOf(arrayAux[0]);
		instance.secuencia=Integer.valueOf(arrayAux[1]);
		instance.nitEsap=arrayAux[2];
		instance.digitoVerificacionEsap=arrayAux[3];
		instance.valorAporteParafiscal=arrayAux[4];
		instance.diasMora=arrayAux[5];
		instance.valorInteresesMora=arrayAux[6];
		instance.totalPagarEsap=arrayAux[7];
		return instance;
	}
}

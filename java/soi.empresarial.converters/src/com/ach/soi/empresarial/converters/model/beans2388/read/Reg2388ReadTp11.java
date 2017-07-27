package com.ach.soi.empresarial.converters.model.beans2388.read;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388ReadTp11 extends CommonBean{
	private String nitMen;
	private String digitoVerificacionMen;
	private String valorAporteParafiscal;
	private String diasMora;
	private String valorInteresesMora;
	private String totalPagarMen;
	public String getNitMen() {
		return nitMen;
	}
	public void setNitMen(String nitMen) {
		this.nitMen = nitMen;
	}
	public String getDigitoVerificacionMen() {
		return digitoVerificacionMen;
	}
	public void setDigitoVerificacionMen(String digitoVerificacionMen) {
		this.digitoVerificacionMen = digitoVerificacionMen;
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
	public String getTotalPagarMen() {
		return totalPagarMen;
	}
	public void setTotalPagarMen(String totalPagarMen) {
		this.totalPagarMen = totalPagarMen;
	}
	@Override
	public String toString() {
		return "Reg2388Tp11 [nitMen=" + nitMen + ", digitoVerificacionMen="
				+ digitoVerificacionMen + ", valorAporteParafiscal="
				+ valorAporteParafiscal + ", diasMora=" + diasMora
				+ ", valorInteresesMora=" + valorInteresesMora
				+ ", totalPagarMen=" + totalPagarMen + ", tipoRegistro="
				+ tipoRegistro + ", secuencia=" + secuencia + "]";
	}
	public void buildDefault() {
		super.secuencia = 0;
		super.tipoRegistro = 11;
		
	}
	

	public String[] toStringArray(){
		String array[] = new String[8];
		array[0]=tipoRegistro.toString();
		array[1]=secuencia.toString();		
		array[2]=nitMen;
		array[3]=digitoVerificacionMen;
		array[4]=valorAporteParafiscal;
		array[5]=diasMora;
		array[6]=valorInteresesMora;
		array[7]=totalPagarMen;
		return array;
	}
	
	public static String[] getLabels ( ){
		String[] labels = new String[8];
		labels[0]="Tipo registro.";
		labels[1]="Secuencia.";
		labels[2]="NIT MEN";
		labels[3]="Dig. Ver. MEN";
		labels[4]="Valor a pagar";
		labels[5]="D’\u00FAas Mora";
		labels[6]="Intereses Mora";
		labels[7]="Total a pagar";
		return labels;
	}
	

	public static Reg2388ReadTp11 buildRecordFromStringArray( String array[] ){
		
		String[] arrayAux = Reg2388ReadTp11.fillArray(array, 8);
		Reg2388ReadTp11 instance = new Reg2388ReadTp11();
		instance.tipoRegistro=Integer.valueOf(arrayAux[0]);
		instance.secuencia=Integer.valueOf(arrayAux[1]);
		instance.nitMen=arrayAux[2];
		instance.digitoVerificacionMen=arrayAux[3];
		instance.valorAporteParafiscal=arrayAux[4];
		instance.diasMora=arrayAux[5];
		instance.valorInteresesMora=arrayAux[6];
		instance.totalPagarMen=arrayAux[7];
		return instance;
	}
}

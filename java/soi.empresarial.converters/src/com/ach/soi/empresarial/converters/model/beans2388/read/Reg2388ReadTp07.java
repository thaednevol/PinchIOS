package com.ach.soi.empresarial.converters.model.beans2388.read;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388ReadTp07 extends CommonBean{
	private String codigoCcf;
	private String nitCcf;
	private String digitoVerificacionCcf;
	private String valorAporteCcf;
	private String diasMora;
	private String valorInteresesMora;
	private String totalPagarCcf;
	private String totalAfiliadosAdministradora;
	public String getCodigoCcf() {
		return codigoCcf;
	}
	public void setCodigoCcf(String codigoCcf) {
		this.codigoCcf = codigoCcf;
	}
	public String getNitCcf() {
		return nitCcf;
	}
	public void setNitCcf(String nitCcf) {
		this.nitCcf = nitCcf;
	}
	public String getDigitoVerificacionCcf() {
		return digitoVerificacionCcf;
	}
	public void setDigitoVerificacionCcf(String digitoVerificacionCcf) {
		this.digitoVerificacionCcf = digitoVerificacionCcf;
	}
	public String getValorAporteCcf() {
		return valorAporteCcf;
	}
	public void setValorAporteCcf(String valorAporteCcf) {
		this.valorAporteCcf = valorAporteCcf;
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
	public String getTotalPagarCcf() {
		return totalPagarCcf;
	}
	public void setTotalPagarCcf(String totalPagarCcf) {
		this.totalPagarCcf = totalPagarCcf;
	}
	public String getTotalAfiliadosAdministradora() {
		return totalAfiliadosAdministradora;
	}
	public void setTotalAfiliadosAdministradora(String totalAfiliadosAdministradora) {
		this.totalAfiliadosAdministradora = totalAfiliadosAdministradora;
	}
	@Override
	public String toString() {
		return "Reg2388Tp7 [codigoCcf=" + codigoCcf + ", nitCcf=" + nitCcf
				+ ", digitoVerificacionCcf=" + digitoVerificacionCcf
				+ ", valorAporteCcf=" + valorAporteCcf + ", diasMora="
				+ diasMora + ", valorInteresesMora=" + valorInteresesMora
				+ ", totalPagarCcf=" + totalPagarCcf
				+ ", totalAfiliadosAdministradora="
				+ totalAfiliadosAdministradora + ", tipoRegistro="
				+ tipoRegistro + ", secuencia=" + secuencia + "]";
	}
	public void buildDefault() {
		super.secuencia = 0;
		super.tipoRegistro = 7;
		
	}
	
	public String[] toStringArray(){
		String array[] = new String[10];
		array[0]=tipoRegistro.toString();
		array[1]=secuencia.toString();		
		array[2]=codigoCcf;
		array[3]=nitCcf;
		array[4]=digitoVerificacionCcf;
		array[5]=valorAporteCcf;
		array[6]=diasMora;
		array[7]=valorInteresesMora;
		array[8]=totalPagarCcf;
		array[9]=totalAfiliadosAdministradora;
		return array;
	}
	
	
	public static String[] getLabels ( ){
		String[] labels = new String[10];
		labels[0]="Tipo registro";
		labels[1]="Secuencia";
		labels[2]="C—digo CCF";
		labels[3]="NIT CCF";
		labels[4]="Dig. Ver. CCF";
		labels[5]="Valor Aportes";
		labels[6]="D’\u00FAas Mora";
		labels[7]="Intereses Mora";
		labels[8]="Total a pagar";
		labels[9]="Nro Afiliados";
		return labels;
	}
	
	

	public static Reg2388ReadTp07 buildRecordFromStringArray( String array[] ){
		
		String[] arrayAux = Reg2388ReadTp07.fillArray(array, 10);
		Reg2388ReadTp07 instance = new Reg2388ReadTp07();
		instance.tipoRegistro=Integer.valueOf(arrayAux[0]);
		instance.secuencia=Integer.valueOf(arrayAux[1]);
		instance.codigoCcf=arrayAux[2];
		instance.nitCcf=arrayAux[3];
		instance.digitoVerificacionCcf=arrayAux[4];
		instance.valorAporteCcf=arrayAux[5];
		instance.diasMora=arrayAux[6];
		instance.valorInteresesMora=arrayAux[7];
		instance.totalPagarCcf=arrayAux[8];
		instance.totalAfiliadosAdministradora=arrayAux[9];
		return instance;
	}
}

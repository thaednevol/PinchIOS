package com.ach.soi.empresarial.converters.model.beans2388.read;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388ReadTp09 extends CommonBean{
	private String nitIcbf;
	private String digitoVerificacionIcbf;
	private String valorAporteParafiscal;
	private String diasMora;
	private String valorInteresesMora;
	private String totalPagarIcbf;
	private String totalAfiliadosAdministradora;
	public String getNitIcbf() {
		return nitIcbf;
	}
	public void setNitIcbf(String nitIcbf) {
		this.nitIcbf = nitIcbf;
	}
	public String getDigitoVerificacionIcbf() {
		return digitoVerificacionIcbf;
	}
	public void setDigitoVerificacionIcbf(String digitoVerificacionIcbf) {
		this.digitoVerificacionIcbf = digitoVerificacionIcbf;
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
	public String getTotalPagarIcbf() {
		return totalPagarIcbf;
	}
	public void setTotalPagarIcbf(String totalPagarIcbf) {
		this.totalPagarIcbf = totalPagarIcbf;
	}
	public String getTotalAfiliadosAdministradora() {
		return totalAfiliadosAdministradora;
	}
	public void setTotalAfiliadosAdministradora(String totalAfiliadosAdministradora) {
		this.totalAfiliadosAdministradora = totalAfiliadosAdministradora;
	}
	public void buildDefault() {
		super.secuencia = 0;
		super.tipoRegistro = 9;
		
	}
	@Override
	public String toString() {
		return "Reg2388Tp09 [nitIcbf=" + nitIcbf + ", digitoVerificacionIcbf="
				+ digitoVerificacionIcbf + ", valorAporteParafiscal="
				+ valorAporteParafiscal + ", diasMora=" + diasMora
				+ ", valorInteresesMora=" + valorInteresesMora
				+ ", totalPagarIcbf=" + totalPagarIcbf
				+ ", totalAfiliadosAdministradora="
				+ totalAfiliadosAdministradora + ", tipoRegistro="
				+ tipoRegistro + ", secuencia=" + secuencia + "]";
	}
	

	public String[] toStringArray(){
		String array[] = new String[9];
		array[0]=tipoRegistro.toString();
		array[1]=secuencia.toString();		
		array[2]=nitIcbf;
		array[3]=digitoVerificacionIcbf;
		array[4]=valorAporteParafiscal;
		array[5]=diasMora;
		array[6]=valorInteresesMora;
		array[7]=totalPagarIcbf;
		array[8]=totalAfiliadosAdministradora;
		return array;
	}
	
	public static String[] getLabels ( ){
		String[] labels = new String[9];
		labels[0]="Tipo registro.";
		labels[1]="Secuencia.";
		labels[2]="NIT ICBF.";
		labels[3]="Dig. Ver. ICBF.";
		labels[4]="Valor Aportes";
		labels[5]="D’as Mora";
		labels[6]="Intereses mora";
		labels[7]="Total a pagar";
		labels[8]="Nœ\u00FAmero de personas";
		return labels;
	}
	

	public static Reg2388ReadTp09 buildRecordFromStringArray( String array[] ){
		
		String[] arrayAux = Reg2388ReadTp09.fillArray(array, 9);
		Reg2388ReadTp09 instance = new Reg2388ReadTp09();
		instance.tipoRegistro=Integer.valueOf(arrayAux[0]);
		instance.secuencia=Integer.valueOf(arrayAux[1]);
		instance.nitIcbf=arrayAux[2];
		instance.digitoVerificacionIcbf=arrayAux[3];
		instance.valorAporteParafiscal=arrayAux[4];
		instance.diasMora=arrayAux[5];
		instance.valorInteresesMora=arrayAux[6];
		instance.totalPagarIcbf=arrayAux[7];
		instance.totalAfiliadosAdministradora=arrayAux[8];
		return instance;
	}
	
}

package com.ach.soi.empresarial.converters.model.beans2388.read;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388ReadTp08 extends CommonBean{

	private String nitSena;
	private String digitoVerificacionSena;
	private String valorAporteParafiscal;
	private String diasMora;
	private String valorInteresesMora;
	private String totalPagarSena;
	private String totalAfiliadosAdministradora;
	public String getNitSena() {
		return nitSena;
	}
	public void setNitSena(String nitSena) {
		this.nitSena = nitSena;
	}
	public String getDigitoVerificacionSena() {
		return digitoVerificacionSena;
	}
	public void setDigitoVerificacionSena(String digitoVerificacionSena) {
		this.digitoVerificacionSena = digitoVerificacionSena;
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
	public String getTotalPagarSena() {
		return totalPagarSena;
	}
	public void setTotalPagarSena(String totalPagarSena) {
		this.totalPagarSena = totalPagarSena;
	}
	public String getTotalAfiliadosAdministradora() {
		return totalAfiliadosAdministradora;
	}
	public void setTotalAfiliadosAdministradora(String totalAfiliadosAdministradora) {
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
	}
	
	
	public String[] toStringArray(){
		String array[] = new String[9];
		array[0]=tipoRegistro.toString();
		array[1]=secuencia.toString();		
		array[2]=nitSena;
		array[3]=digitoVerificacionSena;
		array[4]=valorAporteParafiscal;
		array[5]=diasMora;
		array[6]=valorInteresesMora;
		array[7]=totalPagarSena;
		array[8]=totalAfiliadosAdministradora;
		return array;
	}
	
	public static String[] getLabels ( ){
		String[] labels = new String[9];
		labels[0]="Tipo registro.";
		labels[1]="Secuencia.";
		labels[2]="NIT Sena.";
		labels[3]="Dig. Ver. Sena.";
		labels[4]="Valor Aportes";
		labels[5]="D’\u00FAas Mora";
		labels[6]="Intereses mora";
		labels[7]="Total a pagar";
		labels[8]="Nœ\u00FAmero de personas";
		return labels;
	}
	
	

	public static Reg2388ReadTp08 buildRecordFromStringArray( String array[] ){
		
		String[] arrayAux = Reg2388ReadTp08.fillArray(array, 9);
		Reg2388ReadTp08 instance = new Reg2388ReadTp08();
		instance.tipoRegistro=Integer.valueOf(arrayAux[0]);
		instance.secuencia=Integer.valueOf(arrayAux[1]);
		instance.nitSena=arrayAux[2];
		instance.digitoVerificacionSena=arrayAux[3];
		instance.valorAporteParafiscal=arrayAux[4];
		instance.diasMora=arrayAux[5];
		instance.valorInteresesMora=arrayAux[6];
		instance.totalPagarSena=arrayAux[7];
		instance.totalAfiliadosAdministradora=arrayAux[8];
		return instance;
	}
}

package com.ach.soi.empresarial.converters.model.beans2388.read;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388ReadTp04 extends CommonBean{

	private String codigoFsp;
	private String nitFsp;
	private String digitoVerificacionFsp;
	private String valorTotalAportesFsp;
	private String diasMora;
	private String valorInteresMoraFsp;
	private String valorTotalPagarFsp;
	private String totalAfiliadosFsp;
	public String getCodigoFsp() {
		return codigoFsp;
	}
	public void setCodigoFsp(String codigoFsp) {
		this.codigoFsp = codigoFsp;
	}
	public String getNitFsp() {
		return nitFsp;
	}
	public void setNitFsp(String nitFsp) {
		this.nitFsp = nitFsp;
	}
	public String getDigitoVerificacionFsp() {
		return digitoVerificacionFsp;
	}
	public void setDigitoVerificacionFsp(String digitoVerificacionFsp) {
		this.digitoVerificacionFsp = digitoVerificacionFsp;
	}
	public String getValorTotalAportesFsp() {
		return valorTotalAportesFsp;
	}
	public void setValorTotalAportesFsp(String valorTotalAportesFsp) {
		this.valorTotalAportesFsp = valorTotalAportesFsp;
	}
	public String getDiasMora() {
		return diasMora;
	}
	public void setDiasMora(String diasMora) {
		this.diasMora = diasMora;
	}
	public String getValorInteresMoraFsp() {
		return valorInteresMoraFsp;
	}
	public void setValorInteresMoraFsp(String valorInteresMoraFsp) {
		this.valorInteresMoraFsp = valorInteresMoraFsp;
	}
	public String getValorTotalPagarFsp() {
		return valorTotalPagarFsp;
	}
	public void setValorTotalPagarFsp(String valorTotalPagarFsp) {
		this.valorTotalPagarFsp = valorTotalPagarFsp;
	}
	public String getTotalAfiliadosFsp() {
		return totalAfiliadosFsp;
	}
	public void setTotalAfiliadosFsp(String totalAfiliadosFsp) {
		this.totalAfiliadosFsp = totalAfiliadosFsp;
	}
	@Override
	public String toString() {
		return "Reg2388Tp4 [codigoFsp=" + codigoFsp + ", nitFsp=" + nitFsp
				+ ", digitoVerificacionFsp=" + digitoVerificacionFsp
				+ ", valorTotalAportesFsp=" + valorTotalAportesFsp
				+ ", diasMora=" + diasMora + ", valorInteresMoraFsp="
				+ valorInteresMoraFsp + ", valorTotalPagarFsp="
				+ valorTotalPagarFsp + ", totalAfiliadosFsp="
				+ totalAfiliadosFsp + ", tipoRegistro=" + tipoRegistro
				+ ", secuencia=" + secuencia + "]";
	}
	public void buildDefault() {
		super.secuencia = 0;
		super.setTipoRegistro(4);
		this.codigoFsp = "FSP001";
		this.nitFsp = "333333333";
		this.digitoVerificacionFsp = "8";
		this.valorTotalAportesFsp = "10000l";
		this.diasMora = "0";
		this.valorInteresMoraFsp = "0l";
		this.valorTotalPagarFsp = "10000l";
		this.totalAfiliadosFsp = "30";
	}
	
	public String[] toStringArray(){
		String array[] = new String[10];
		array[0]=tipoRegistro.toString();
		array[1]=secuencia.toString();		
		array[2]=codigoFsp ;
		array[3]= nitFsp ;
		array[4]= digitoVerificacionFsp ;
		array[5]= valorTotalAportesFsp ;
		array[6]= diasMora ;
		array[7]= valorInteresMoraFsp ;
		array[8]= valorTotalPagarFsp ;
		array[9]= totalAfiliadosFsp ;
		return array;
	}
	
	public static String[] getLabels ( ){
		String[] labels = new String[10];
		labels[0]="Tipo registro";
		labels[1]="Secuencia";
		labels[2]="C\u00f3digo FSP";
		labels[3]="NIT FSP";
		labels[4]="Dig. Ver. FSP";
		labels[5]="Total aportes FSP";
		labels[6]="D’as de mora";
		labels[7]="Valor Mora";
		labels[8]="Total Pagar";
		labels[9]="Nro Afiliados";
		return labels;
	}
	

	public static Reg2388ReadTp04 buildRecordFromStringArray( String array[] ){
		
		String[] arrayAux = Reg2388ReadTp04.fillArray(array, 10);
		Reg2388ReadTp04 instance = new Reg2388ReadTp04();
		instance.tipoRegistro=Integer.valueOf(arrayAux[0]);
		instance.secuencia=Integer.valueOf(arrayAux[1]);
		instance.codigoFsp=arrayAux[2];
		instance.nitFsp=arrayAux[3];
		instance.digitoVerificacionFsp=arrayAux[4];
		instance.valorTotalAportesFsp=arrayAux[5];
		instance.diasMora=arrayAux[6];
		instance.valorInteresMoraFsp=arrayAux[7];
		instance.valorTotalPagarFsp=arrayAux[8];
		instance.totalAfiliadosFsp=arrayAux[9];
		return instance;
	}
	
	
}

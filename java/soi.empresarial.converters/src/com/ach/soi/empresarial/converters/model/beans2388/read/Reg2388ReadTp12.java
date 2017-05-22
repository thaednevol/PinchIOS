package com.ach.soi.empresarial.converters.model.beans2388.read;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388ReadTp12 extends CommonBean{

	private String totalPagarPensiones;
	private String totalPagarFsp;
	private String totalPagarSalud;
	private String totalPagarArl;
	private String totalPagarCcf;
	private String totalPagarSena;
	private String totalPagarIcbf;
	private String totalPagarEsap;
	private String totalPagarMen;
	private String granTotal;
	private String numeroAdmPensiones;
	private String numeroAdmSalud;
	private String numeroAdmRiesgo;
	private String numeroAdmCcf;
	public String getTotalPagarPensiones() {
		return totalPagarPensiones;
	}
	public void setTotalPagarPensiones(String totalPagarPensiones) {
		this.totalPagarPensiones = totalPagarPensiones;
	}
	public String getTotalPagarFsp() {
		return totalPagarFsp;
	}
	public void setTotalPagarFsp(String totalPagarFsp) {
		this.totalPagarFsp = totalPagarFsp;
	}
	public String getTotalPagarSalud() {
		return totalPagarSalud;
	}
	public void setTotalPagarSalud(String totalPagarSalud) {
		this.totalPagarSalud = totalPagarSalud;
	}
	public String getTotalPagarArl() {
		return totalPagarArl;
	}
	public void setTotalPagarArl(String totalPagarArl) {
		this.totalPagarArl = totalPagarArl;
	}
	public String getTotalPagarCcf() {
		return totalPagarCcf;
	}
	public void setTotalPagarCcf(String totalPagarCcf) {
		this.totalPagarCcf = totalPagarCcf;
	}
	public String getTotalPagarSena() {
		return totalPagarSena;
	}
	public void setTotalPagarSena(String totalPagarSena) {
		this.totalPagarSena = totalPagarSena;
	}
	public String getTotalPagarIcbf() {
		return totalPagarIcbf;
	}
	public void setTotalPagarIcbf(String totalPagarIcbf) {
		this.totalPagarIcbf = totalPagarIcbf;
	}
	public String getTotalPagarEsap() {
		return totalPagarEsap;
	}
	public void setTotalPagarEsap(String totalPagarEsap) {
		this.totalPagarEsap = totalPagarEsap;
	}
	public String getTotalPagarMen() {
		return totalPagarMen;
	}
	public void setTotalPagarMen(String totalPagarMen) {
		this.totalPagarMen = totalPagarMen;
	}
	public String getGranTotal() {
		return granTotal;
	}
	public void setGranTotal(String granTotal) {
		this.granTotal = granTotal;
	}
	public String getNumeroAdmPensiones() {
		return numeroAdmPensiones;
	}
	public void setNumeroAdmPensiones(String numeroAdmPensiones) {
		this.numeroAdmPensiones = numeroAdmPensiones;
	}
	public String getNumeroAdmSalud() {
		return numeroAdmSalud;
	}
	public void setNumeroAdmSalud(String numeroAdmSalud) {
		this.numeroAdmSalud = numeroAdmSalud;
	}
	public String getNumeroAdmRiesgo() {
		return numeroAdmRiesgo;
	}
	public void setNumeroAdmRiesgo(String numeroAdmRiesgo) {
		this.numeroAdmRiesgo = numeroAdmRiesgo;
	}
	public String getNumeroAdmCcf() {
		return numeroAdmCcf;
	}
	public void setNumeroAdmCcf(String numeroAdmCcf) {
		this.numeroAdmCcf = numeroAdmCcf;
	}
	@Override
	public String toString() {
		return "Reg2388Tp12 [totalPagarPensiones=" + totalPagarPensiones
				+ ", totalPagarFsp=" + totalPagarFsp + ", totalPagarSalud="
				+ totalPagarSalud + ", totalPagarArl=" + totalPagarArl
				+ ", totalPagarCcf=" + totalPagarCcf + ", totalPagarSena="
				+ totalPagarSena + ", totalPagarIcbf=" + totalPagarIcbf
				+ ", totalPagarEsap=" + totalPagarEsap + ", totalPagarMen="
				+ totalPagarMen + ", granTotal=" + granTotal
				+ ", numeroAdmPensiones=" + numeroAdmPensiones
				+ ", numeroAdmSalud=" + numeroAdmSalud + ", numeroAdmRiesgo="
				+ numeroAdmRiesgo + ", numeroAdmCcf=" + numeroAdmCcf
				+ ", tipoRegistro=" + tipoRegistro + ", secuencia=" + secuencia
				+ "]";
	}
	public void buildDefault() {
		super.secuencia = 0;
		super.tipoRegistro = 12;
		
	}
	

	public String[] toStringArray(){
		String array[] = new String[15];
		array[0]=tipoRegistro.toString();		
		array[1]=totalPagarPensiones;
		array[2]="0";
		array[3]=totalPagarSalud;
		array[4]=totalPagarArl;
		array[5]=totalPagarCcf;
		array[6]=totalPagarSena;
		array[7]=totalPagarIcbf;
		array[8]=totalPagarEsap;
		array[9]=totalPagarMen;
		array[10]=granTotal;
		array[11]=numeroAdmPensiones;
		array[12]=numeroAdmSalud;
		array[13]=numeroAdmRiesgo;
		array[14]=numeroAdmCcf;
		return array;
	}
	
	
	public static String[] getLabels ( ){
		String[] labels = new String[15];
		labels[0]="Tipo registro.";
		labels[1]="Total a pagar AFP";
		labels[2]="Total a pagar FSP";
		labels[3]="Total a pagar EPS";
		labels[4]="Total a pagar ARL";
		labels[5]="Total a pagar CCF";
		labels[6]="Total a pagar SENA";
		labels[7]="Total a pagar ICBF";
		labels[8]="Total a pagar ESAP";
		labels[9]="Total a pagar MEN";
		labels[10]="Gran total";
		labels[11]="Nro AFP Reportadas.";
		labels[12]="Nro EPS Reportadas";
		labels[13]="Nro ARL Reportadas";
		labels[14]="Nro CCF Reportadas";
		return labels;
	}
	

	public static Reg2388ReadTp12 buildRecordFromStringArray( String array[] ){
		
		String[] arrayAux = Reg2388ReadTp12.fillArray(array, 15);
		Reg2388ReadTp12 instance = new Reg2388ReadTp12();
		instance.tipoRegistro=Integer.valueOf(arrayAux[0]);
		instance.totalPagarPensiones=arrayAux[1];
		instance.totalPagarFsp=arrayAux[2];
		instance.totalPagarSalud=arrayAux[3];
		instance.totalPagarArl=arrayAux[4];
		instance.totalPagarCcf=arrayAux[5];
		instance.totalPagarSena=arrayAux[6];
		instance.totalPagarIcbf=arrayAux[7];
		instance.totalPagarEsap=arrayAux[8];
		instance.totalPagarMen=arrayAux[9];
		instance.granTotal=arrayAux[10];
		instance.numeroAdmPensiones=arrayAux[11];
		instance.numeroAdmSalud=arrayAux[12];
		instance.numeroAdmRiesgo=arrayAux[13];
		instance.numeroAdmCcf=arrayAux[14];
		return instance;
	}
}

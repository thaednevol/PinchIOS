package com.ach.soi.empresarial.liquidacion.model;

import java.io.Serializable;

public class TotalesTO implements Serializable, Cloneable{

	
	private String totalAPagar;
	private String periodoSalud;
	private String periodoNoSalud;
	
	private String[] totalesPensionLabels;
	private String[] totalesFspLabels;
	private String[] totalesSaludLabels;
	private String[] totalesRiesgoLabels;
	private String[] totalParafiscalesLabels;
	private String[] granTotalLabels;
	private String[][] totalesPension;
	private String[][] totalesFsp;
	private String[][] totalesSalud;
	private String[][] totalesRiesgo;
	private String[][] totalParafiscales;
	private String[] granTotal;
	public String[] getTotalesPensionLabels() {
		return totalesPensionLabels;
	}
	public void setTotalesPensionLabels(String[] totalesPensionLabels) {
		this.totalesPensionLabels = totalesPensionLabels;
	}
	public String[] getTotalesFspLabels() {
		return totalesFspLabels;
	}
	public void setTotalesFspLabels(String[] totalesFspLabels) {
		this.totalesFspLabels = totalesFspLabels;
	}
	public String[] getTotalesSaludLabels() {
		return totalesSaludLabels;
	}
	public void setTotalesSaludLabels(String[] totalesSaludLabels) {
		this.totalesSaludLabels = totalesSaludLabels;
	}
	public String[] getTotalesRiesgoLabels() {
		return totalesRiesgoLabels;
	}
	public void setTotalesRiesgoLabels(String[] totalesRiesgoLabels) {
		this.totalesRiesgoLabels = totalesRiesgoLabels;
	}
	public String[] getTotalParafiscalesLabels() {
		return totalParafiscalesLabels;
	}
	public void setTotalParafiscalesLabels(String[] totalParafiscalesLabels) {
		this.totalParafiscalesLabels = totalParafiscalesLabels;
	}
	public String[] getGranTotalLabels() {
		return granTotalLabels;
	}
	public void setGranTotalLabels(String[] granTotalLabels) {
		this.granTotalLabels = granTotalLabels;
	}
	public String[][] getTotalesPension() {
		return totalesPension;
	}
	public void setTotalesPension(String[][] totalesPension) {
		this.totalesPension = totalesPension;
	}
	public String[][] getTotalesFsp() {
		return totalesFsp;
	}
	public void setTotalesFsp(String[][] totalesFsp) {
		this.totalesFsp = totalesFsp;
	}
	public String[][] getTotalesSalud() {
		return totalesSalud;
	}
	public void setTotalesSalud(String[][] totalesSalud) {
		this.totalesSalud = totalesSalud;
	}
	public String[][] getTotalesRiesgo() {
		return totalesRiesgo;
	}
	public void setTotalesRiesgo(String[][] totalesRiesgo) {
		this.totalesRiesgo = totalesRiesgo;
	}
	public String[][] getTotalParafiscales() {
		return totalParafiscales;
	}
	public void setTotalParafiscales(String[][] totalParafiscales) {
		this.totalParafiscales = totalParafiscales;
	}
	public String[] getGranTotal() {
		return granTotal;
	}
	public void setGranTotal(String[] granTotal) {
		this.granTotal = granTotal;
	}
	
	
	
	public String getTotalAPagar() {
		return totalAPagar;
	}
	public void setTotalAPagar(String totalAPagar) {
		this.totalAPagar = totalAPagar;
	}
	public String getPeriodoSalud() {
		return periodoSalud;
	}
	public void setPeriodoSalud(String periodoSalud) {
		this.periodoSalud = periodoSalud;
	}
	public String getPeriodoNoSalud() {
		return periodoNoSalud;
	}
	public void setPeriodoNoSalud(String periodoNoSalud) {
		this.periodoNoSalud = periodoNoSalud;
	}
	public static String[] getLabelsGranTotal ( ){
		String[] labels = new String[14];
		labels[0]="Total a pagar AFP";
		labels[1]="Total a pagar FSP";
		labels[2]="Total a pagar EPS";
		labels[3]="Total a pagar ARL";
		labels[4]="Total a pagar CCF";
		labels[5]="Total a pagar SENA";
		labels[6]="Total a pagar ICBF";
		labels[7]="Total a pagar ESAP";
		labels[8]="Total a pagar MEN";
		labels[9]="Gran total";
		labels[10]="Nro AFP Reportadas.";
		labels[11]="Nro EPS Reportadas";
		labels[12]="Nro ARL Reportadas";
		labels[13]="Nro CCF Reportadas";
		return labels;
	}
	
	public static String[] getLabelsParafiscales ( ){
		String[] labels = new String[10];
		labels[0]="Subsistema";
		labels[1]="Cod. Administradora";
		labels[2]="Administradora";
		labels[3]="NIT";
		labels[4]="Dig. Verif";
		labels[5]="Aporte";
		labels[6]="Dias Mora";
		labels[7]="Intereses Mora";
		labels[8]="Total a pagar";		
		labels[9]="Nro Afiliados";
		return labels;
	}
	
	public static String[] getLabelsSegSocial ( ){
		String[] labels = new String[9];
		labels[0]="Cod. Administradora";
		labels[1]="Administradora";
		labels[2]="NIT";
		labels[3]="Dig Verificación";
		labels[4]="Cotizaciones";
		labels[5]="Dias Mora";		
		labels[6]="Intereses Mora";
		labels[7]="Total a pagar";
		labels[8]="Nro Afiliados";
		return labels;
	}
	

	
}

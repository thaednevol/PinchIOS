package com.ach.soi.empresarial.converters.model.beans2388.read;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388ReadTp05 extends CommonBean{

	private String codigoEps;
	private String nitEps;
	private String digitoVerificacionEps;
	private String valorCotizacionesOblEps;
	private String valorUpcsEps;
	private String valorNetoAportesEps;
	private String diasMora;
	private String valorMoraCotizacionesOblg;
	private String valorMoraUpcs;
	private String subtotalAportesCotizacion;
	private String subtotalAportesUpc;
	private String totalPagarCotizacionesOblg;
	private String totalPagarUpcs;
	private String totalPagarAdministradora;
	private String totalAfiliadosAdministradora;
	public String getCodigoEps() {
		return codigoEps;
	}
	public void setCodigoEps(String codigoEps) {
		this.codigoEps = codigoEps;
	}
	public String getNitEps() {
		return nitEps;
	}
	public void setNitEps(String nitEps) {
		this.nitEps = nitEps;
	}
	public String getDigitoVerificacionEps() {
		return digitoVerificacionEps;
	}
	public void setDigitoVerificacionEps(String digitoVerificacionEps) {
		this.digitoVerificacionEps = digitoVerificacionEps;
	}
	public String getValorCotizacionesOblEps() {
		return valorCotizacionesOblEps;
	}
	public void setValorCotizacionesOblEps(String valorCotizacionesOblEps) {
		this.valorCotizacionesOblEps = valorCotizacionesOblEps;
	}
	public String getValorUpcsEps() {
		return valorUpcsEps;
	}
	public void setValorUpcsEps(String valorUpcsEps) {
		this.valorUpcsEps = valorUpcsEps;
	}
	public String getValorNetoAportesEps() {
		return valorNetoAportesEps;
	}
	public void setValorNetoAportesEps(String valorNetoAportesEps) {
		this.valorNetoAportesEps = valorNetoAportesEps;
	}
	public String getDiasMora() {
		return diasMora;
	}
	public void setDiasMora(String diasMora) {
		this.diasMora = diasMora;
	}
	public String getValorMoraCotizacionesOblg() {
		return valorMoraCotizacionesOblg;
	}
	public void setValorMoraCotizacionesOblg(String valorMoraCotizacionesOblg) {
		this.valorMoraCotizacionesOblg = valorMoraCotizacionesOblg;
	}
	public String getValorMoraUpcs() {
		return valorMoraUpcs;
	}
	public void setValorMoraUpcs(String valorMoraUpcs) {
		this.valorMoraUpcs = valorMoraUpcs;
	}
	public String getSubtotalAportesCotizacion() {
		return subtotalAportesCotizacion;
	}
	public void setSubtotalAportesCotizacion(String subtotalAportesCotizacion) {
		this.subtotalAportesCotizacion = subtotalAportesCotizacion;
	}
	public String getSubtotalAportesUpc() {
		return subtotalAportesUpc;
	}
	public void setSubtotalAportesUpc(String subtotalAportesUpc) {
		this.subtotalAportesUpc = subtotalAportesUpc;
	}
	public String getTotalPagarCotizacionesOblg() {
		return totalPagarCotizacionesOblg;
	}
	public void setTotalPagarCotizacionesOblg(String totalPagarCotizacionesOblg) {
		this.totalPagarCotizacionesOblg = totalPagarCotizacionesOblg;
	}
	public String getTotalPagarUpcs() {
		return totalPagarUpcs;
	}
	public void setTotalPagarUpcs(String totalPagarUpcs) {
		this.totalPagarUpcs = totalPagarUpcs;
	}
	public String getTotalPagarAdministradora() {
		return totalPagarAdministradora;
	}
	public void setTotalPagarAdministradora(String totalPagarAdministradora) {
		this.totalPagarAdministradora = totalPagarAdministradora;
	}
	public String getTotalAfiliadosAdministradora() {
		return totalAfiliadosAdministradora;
	}
	public void setTotalAfiliadosAdministradora(String totalAfiliadosAdministradora) {
		this.totalAfiliadosAdministradora = totalAfiliadosAdministradora;
	}
	@Override
	public String toString() {
		return "Reg2388Tp5 [codigoEps=" + codigoEps + ", nitEps=" + nitEps
				+ ", digitoVerificacionEps=" + digitoVerificacionEps
				+ ", valorCotizacionesOblEps=" + valorCotizacionesOblEps
				+ ", valorUpcsEps=" + valorUpcsEps + ", valorNetoAportesEps="
				+ valorNetoAportesEps + ", diasMora=" + diasMora
				+ ", valorMoraCotizacionesOblg=" + valorMoraCotizacionesOblg
				+ ", valorMoraUpcs=" + valorMoraUpcs
				+ ", subtotalAportesCotizacion=" + subtotalAportesCotizacion
				+ ", subtotalAportesUpc=" + subtotalAportesUpc
				+ ", totalPagarCotizacionesOblg=" + totalPagarCotizacionesOblg
				+ ", totalPagarUpcs=" + totalPagarUpcs
				+ ", totalPagarAdministradora=" + totalPagarAdministradora
				+ ", totalAfiliadosAdministradora="
				+ totalAfiliadosAdministradora + ", tipoRegistro="
				+ tipoRegistro + ", secuencia=" + secuencia + "]";
	}
	public void buildDefault() {
		super.secuencia = 0;
		super.tipoRegistro = 5;
		this.codigoEps = "EPS001";
		this.nitEps = "388288388";
		this.digitoVerificacionEps = "3";
		this.valorCotizacionesOblEps = "800000l";
		this.valorUpcsEps = "0l";
		this.valorNetoAportesEps = "800000l";
		this.diasMora = "0";
		this.valorMoraCotizacionesOblg = "0l";
		this.valorMoraUpcs = "0l";
		this.subtotalAportesCotizacion = "80000l";
		this.subtotalAportesUpc = "0l";
		this.totalPagarCotizacionesOblg = "80000l";
		this.totalPagarUpcs = "0l";
		this.totalPagarAdministradora = "80000l";
		this.totalAfiliadosAdministradora = "40";
	}
	
	public String[] toStringArray(){
		String array[] = new String[17];
		array[0]=tipoRegistro.toString();
		array[1]=secuencia.toString();		
		array[2]=codigoEps;
		array[3]=nitEps;
		array[4]=digitoVerificacionEps;
		array[5]=valorCotizacionesOblEps;
		array[6]=valorUpcsEps;
		array[7]=valorNetoAportesEps;
		array[8]=diasMora;
		array[9]=valorMoraCotizacionesOblg;
		array[10]=valorMoraUpcs;
		array[11]=subtotalAportesCotizacion;
		array[12]=subtotalAportesUpc;
		array[13]=totalPagarCotizacionesOblg;
		array[14]=totalPagarUpcs;
		array[15]=totalPagarAdministradora;
		array[16]=totalAfiliadosAdministradora;
		return array;
	}
	
	public static String[] getLabels ( ){
		String[] labels = new String[17];
		labels[0]="Tipo registro";
		labels[1]="Secuencia";
		labels[2]="C—\u00F3digo EPS";
		labels[3]="NIT EPS";
		labels[4]="Dig. Ver. EPS";
		labels[5]="Total Cotiz. Oblg EPS";
		labels[6]="Total UPC EPS";
		labels[7]="Neto Aportes";
		labels[8]="D’\u00FAas Mora";
		labels[9]="Intereses de mora Cot. Oblg";
		labels[10]="Intereses de mora UPC";
		labels[11]="Subtotal Cotizaci—\u00F3n";
		labels[12]="Subtotal UPC ";
		labels[13]="Total cotizaci—\u00F3n oblig";
		labels[14]="Total UPC";
		labels[15]="Total administradora";
		labels[16]="Nro afiliados";
		return labels;
	}
	

	public static Reg2388ReadTp05 buildRecordFromStringArray( String array[] ){
		
		String[] arrayAux = Reg2388ReadTp05.fillArray(array, 17);
		Reg2388ReadTp05 instance = new Reg2388ReadTp05();
		instance.tipoRegistro=Integer.valueOf(arrayAux[0]);
		instance.secuencia=Integer.valueOf(arrayAux[1]);
		instance.codigoEps=arrayAux[2];
		instance.nitEps=arrayAux[3];
		instance.digitoVerificacionEps=arrayAux[4];
		instance.valorCotizacionesOblEps=arrayAux[5];
		instance.valorUpcsEps=arrayAux[6];
		instance.valorNetoAportesEps=arrayAux[7];
		instance.diasMora=arrayAux[8];
		instance.valorMoraCotizacionesOblg=arrayAux[9];
		instance.valorMoraUpcs=arrayAux[10];
		instance.subtotalAportesCotizacion=arrayAux[11];
		instance.subtotalAportesUpc=arrayAux[12];
		instance.totalPagarCotizacionesOblg=arrayAux[13];
		instance.totalPagarUpcs=arrayAux[14];
		instance.totalPagarAdministradora=arrayAux[15];
		instance.totalAfiliadosAdministradora=arrayAux[16];
		return instance;
	}
	
}

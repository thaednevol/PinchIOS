package com.ach.soi.empresarial.converters.model.beans2388.read;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388ReadPensTp01 extends CommonBean{

	
	private String razonSocialPagadorPens;
	private String tipoDocumentoPagadorPens;
	private String numeroIdentificacionPagadorPens;
	private String digitoVerificacionPagadorPens;
	private String formaPresentacion;	
	private String codigoSucursal;
	private String nombreSucursal;
	private String periodoPagoNoSalud;
	private String periodoPagoSalud;
	private String numeroPlanilla;
	private String fechaPago;
	private String numeroTotalPensionados;
	private String valorTotalNomina;
	private String tipoPagadorPensiones;
	private String codigoOperador;
	private String tipoPlanillaPensionados;
	public String getRazonSocialPagadorPens() {
		return razonSocialPagadorPens;
	}
	public void setRazonSocialPagadorPens(String razonSocialPagadorPens) {
		this.razonSocialPagadorPens = razonSocialPagadorPens;
	}
	public String getTipoDocumentoPagadorPens() {
		return tipoDocumentoPagadorPens;
	}
	public void setTipoDocumentoPagadorPens(String tipoDocumentoPagadorPens) {
		this.tipoDocumentoPagadorPens = tipoDocumentoPagadorPens;
	}
	public String getNumeroIdentificacionPagadorPens() {
		return numeroIdentificacionPagadorPens;
	}
	public void setNumeroIdentificacionPagadorPens(
			String numeroIdentificacionPagadorPens) {
		this.numeroIdentificacionPagadorPens = numeroIdentificacionPagadorPens;
	}
	public String getDigitoVerificacionPagadorPens() {
		return digitoVerificacionPagadorPens;
	}
	public void setDigitoVerificacionPagadorPens(
			String digitoVerificacionPagadorPens) {
		this.digitoVerificacionPagadorPens = digitoVerificacionPagadorPens;
	}
	public String getFormaPresentacion() {
		return formaPresentacion;
	}
	public void setFormaPresentacion(String formaPresentacion) {
		this.formaPresentacion = formaPresentacion;
	}
	public String getCodigoSucursal() {
		return codigoSucursal;
	}
	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}
	public String getNombreSucursal() {
		return nombreSucursal;
	}
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}
	public String getPeriodoPagoNoSalud() {
		return periodoPagoNoSalud;
	}
	public void setPeriodoPagoNoSalud(String periodoPagoNoSalud) {
		this.periodoPagoNoSalud = periodoPagoNoSalud;
	}
	public String getPeriodoPagoSalud() {
		return periodoPagoSalud;
	}
	public void setPeriodoPagoSalud(String periodoPagoSalud) {
		this.periodoPagoSalud = periodoPagoSalud;
	}
	public String getNumeroPlanilla() {
		return numeroPlanilla;
	}
	public void setNumeroPlanilla(String numeroPlanilla) {
		this.numeroPlanilla = numeroPlanilla;
	}
	public String getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getNumeroTotalPensionados() {
		return numeroTotalPensionados;
	}
	public void setNumeroTotalPensionados(String numeroTotalPensionados) {
		this.numeroTotalPensionados = numeroTotalPensionados;
	}
	public String getValorTotalNomina() {
		return valorTotalNomina;
	}
	public void setValorTotalNomina(String valorTotalNomina) {
		this.valorTotalNomina = valorTotalNomina;
	}
	public String getTipoPagadorPensiones() {
		return tipoPagadorPensiones;
	}
	public void setTipoPagadorPensiones(String tipoPagadorPensiones) {
		this.tipoPagadorPensiones = tipoPagadorPensiones;
	}
	public String getCodigoOperador() {
		return codigoOperador;
	}
	public void setCodigoOperador(String codigoOperador) {
		this.codigoOperador = codigoOperador;
	}
	public String getTipoPlanillaPensionados() {
		return tipoPlanillaPensionados;
	}
	public void setTipoPlanillaPensionados(String tipoPlanillaPensionados) {
		this.tipoPlanillaPensionados = tipoPlanillaPensionados;
	}
	@Override
	public String toString() {
		return "Reg2388ReadPensTp01 [razonSocialPagadorPens="
				+ razonSocialPagadorPens + ", tipoDocumentoPagadorPens="
				+ tipoDocumentoPagadorPens
				+ ", numeroIdentificacionPagadorPens="
				+ numeroIdentificacionPagadorPens
				+ ", digitoVerificacionPagadorPens="
				+ digitoVerificacionPagadorPens + ", formaPresentacion="
				+ formaPresentacion + ", codigoSucursal=" + codigoSucursal
				+ ", nombreSucursal=" + nombreSucursal
				+ ", periodoPagoNoSalud=" + periodoPagoNoSalud
				+ ", periodoPagoSalud=" + periodoPagoSalud
				+ ", numeroPlanilla=" + numeroPlanilla + ", fechaPago="
				+ fechaPago + ", numeroTotalPensionados="
				+ numeroTotalPensionados + ", valorTotalNomina="
				+ valorTotalNomina + ", tipoPagadorPensiones="
				+ tipoPagadorPensiones + ", codigoOperador=" + codigoOperador
				+ ", tipoPlanillaPensionados=" + tipoPlanillaPensionados + "]";
	}
	
	public String[] toStringArray(){
		String array[] = new String[18];
		array[0]=tipoRegistro.toString();
		array[1]=secuencia.toString();
		array[2]=razonSocialPagadorPens;
		array[3]=tipoDocumentoPagadorPens;
		array[4]=numeroIdentificacionPagadorPens;
		array[5]=digitoVerificacionPagadorPens;
		array[6]=formaPresentacion;
		array[7]=codigoSucursal;
		array[8]=nombreSucursal;
		array[9]=periodoPagoNoSalud;
		array[10]=periodoPagoSalud;
		array[11]=numeroPlanilla;
		array[12]=fechaPago;
		array[13]=numeroTotalPensionados;
		array[14]=valorTotalNomina;
		array[15]=tipoPagadorPensiones;
		array[16]=codigoOperador;
		array[17]=tipoPlanillaPensionados;
		return array;
	}
	
	public static String[] getLabels ( ){
		String[] labels = new String[18];
		labels[0]="Tipo de registro";
		labels[1]="Secuencia";
		labels[2]="Nombre o raz—n social";
		labels[3]="Tipo documento";
		labels[4]="Nœmero de identificaci—n";
		labels[5]="D’gito de verificaci—n";
		labels[6]="Forma de presentaci—n";
		labels[7]="C—digo de la sucursal";
		labels[8]="Nombre de la sucursal";
		labels[9]="Per’odo de pago no salud";
		labels[10]="Per’odo de pago salud";
		labels[11]="Nœmero de planilla";
		labels[12]="Fecha de pago";
		labels[13]="Nœmero total de pensionados";
		labels[14]="Valor total de la n—mina";
		labels[15]="Tipo de pagador de pensiones";
		labels[16]="C—digo del operador";
		labels[17]="Tipo de planilla";
		return labels;
	}
	
	
	public static Reg2388ReadPensTp01 buildRecordFromStringArray( String array[] ){
		
		String[] arrayAux = Reg2388ReadPensTp01.fillArray(array, 18);
		Reg2388ReadPensTp01 instance = new Reg2388ReadPensTp01();
		instance.setTipoRegistro(Integer.valueOf(arrayAux[0]));
		instance.setSecuencia(Integer.valueOf(arrayAux[1]));
		instance.razonSocialPagadorPens=arrayAux[2];
		instance.tipoDocumentoPagadorPens=arrayAux[3];
		instance.numeroIdentificacionPagadorPens=arrayAux[4];
		instance.digitoVerificacionPagadorPens=arrayAux[5];
		instance.formaPresentacion=arrayAux[6];
		instance.codigoSucursal=arrayAux[7];
		instance.nombreSucursal=arrayAux[8];
		instance.periodoPagoNoSalud=arrayAux[9];
		instance.periodoPagoSalud=arrayAux[10];
		instance.numeroPlanilla=arrayAux[11];
		instance.fechaPago=arrayAux[12];
		instance.numeroTotalPensionados=arrayAux[13];
		instance.valorTotalNomina=arrayAux[14];
		instance.tipoPagadorPensiones=arrayAux[15];
		instance.codigoOperador=arrayAux[16];
		instance.tipoPlanillaPensionados=arrayAux[17];
		return instance;
	}
	
	
	
}

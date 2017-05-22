package com.ach.soi.empresarial.converters.model.beans2388.read;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388ReadPensTp04 extends CommonBean{

	private String codigoFsp;
	private String nitFsp;
	private String digitoVerificacionFsp;
	private String valorTotalAportesFsp;
	private String nroDiasMoraLiquidados;
	private String valorIntSubctaSubsistencia;
	private String totalPagarSubctaSusbsistencia;
	private String numeroPensionadosFsp;
	
	
	
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

	public String getNroDiasMoraLiquidados() {
		return nroDiasMoraLiquidados;
	}

	public void setNroDiasMoraLiquidados(String nroDiasMoraLiquidados) {
		this.nroDiasMoraLiquidados = nroDiasMoraLiquidados;
	}

	public String getValorIntSubctaSubsistencia() {
		return valorIntSubctaSubsistencia;
	}

	public void setValorIntSubctaSubsistencia(String valorIntSubctaSubsistencia) {
		this.valorIntSubctaSubsistencia = valorIntSubctaSubsistencia;
	}

	public String getTotalPagarSubctaSusbsistencia() {
		return totalPagarSubctaSusbsistencia;
	}

	public void setTotalPagarSubctaSusbsistencia(
			String totalPagarSubctaSusbsistencia) {
		this.totalPagarSubctaSusbsistencia = totalPagarSubctaSusbsistencia;
	}

	public String getNumeroPensionadosFsp() {
		return numeroPensionadosFsp;
	}

	public void setNumeroPensionadosFsp(String numeroPensionadosFsp) {
		this.numeroPensionadosFsp = numeroPensionadosFsp;
	}

	@Override
	public String toString() {
		return "Reg2388ReadPensTp04 [codigoFsp=" + codigoFsp + ", nitFsp="
				+ nitFsp + ", digitoVerificacionFsp=" + digitoVerificacionFsp
				+ ", valorTotalAportesFsp=" + valorTotalAportesFsp
				+ ", nroDiasMoraLiquidados=" + nroDiasMoraLiquidados
				+ ", valorIntSubctaSubsistencia=" + valorIntSubctaSubsistencia
				+ ", totalPagarSubctaSusbsistencia="
				+ totalPagarSubctaSusbsistencia + ", numeroPensionadosFsp="
				+ numeroPensionadosFsp + "]";
	}

	public String[] toStringArray(){
		String array[] = new String[10];
		array[0]=tipoRegistro.toString();
		array[1]=secuencia.toString();		
		array[2]=codigoFsp;
		array[3]=nitFsp;
		array[4]=digitoVerificacionFsp;
		array[5]=valorTotalAportesFsp;
		array[6]=nroDiasMoraLiquidados;
		array[7]=valorIntSubctaSubsistencia;
		array[8]=totalPagarSubctaSusbsistencia;
		array[9]=numeroPensionadosFsp;
		return array;
	}
	
	public static String[] getLabels ( ){
		String[] labels = new String[10];
		labels[0]="Tipo registro";
		labels[1]="Secuencia";
		labels[2]="C—digo FSP";
		labels[3]="NIT FSP";
		labels[4]="D’gito verificaci—n FSP";
		labels[5]="Aportes FSP";
		labels[6]="D’as de mora";
		labels[7]="Intereses de mora";
		labels[8]="Total a pagar FSP";
		labels[9]="Nro de pensionados ";
		return labels;
	}
	

	public static Reg2388ReadPensTp04 buildRecordFromStringArray( String array[] ){
		
		String[] arrayAux = Reg2388ReadPensTp04.fillArray(array, 10);
		Reg2388ReadPensTp04 instance = new Reg2388ReadPensTp04();
		instance.tipoRegistro=Integer.valueOf(arrayAux[0]);
		instance.secuencia=Integer.valueOf(arrayAux[1]);
		instance.codigoFsp=arrayAux[2];
		instance.nitFsp=arrayAux[3];
		instance.digitoVerificacionFsp=arrayAux[4];
		instance.valorTotalAportesFsp=arrayAux[5];
		instance.nroDiasMoraLiquidados=arrayAux[6];
		instance.valorIntSubctaSubsistencia=arrayAux[7];
		instance.totalPagarSubctaSusbsistencia=arrayAux[8];
		instance.numeroPensionadosFsp=arrayAux[9];
		return instance;
	}
	
	
}

package com.ach.soi.empresarial.converters.model.beans2388.read;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg2388ReadPensTp07 extends CommonBean{
	private String totalAPagarPension;
	private String totalAPagarFondoSolPensional;
	private String totalAPagarSalud;
	private String totalAPagarCCF;
	private String granTotalAPagar;
	private String nroAdminPensionesReportadas;
	private String nroEPSoEOCReportadas;
	private String nroCCFReportadas;
	
	
	public static String[] toStringArrayDefault(){
		String array[] = new String[9];
		array[0]="7";
		array[1]="0";
		array[2]="0";
		array[3]="0";
		array[4]="0";
		array[5]="0";
		array[6]="0";
		array[7]="0";
		array[8]="0";
		return array;
	}
	
	
	public String[] toStringArray(){
		String array[] = new String[9];
		array[0]=tipoRegistro.toString();
		array[1]=totalAPagarPension;
		array[2]=totalAPagarFondoSolPensional;
		array[3]=totalAPagarSalud;
		array[4]=totalAPagarCCF;
		array[5]=granTotalAPagar;
		array[6]=nroAdminPensionesReportadas;
		array[7]=nroEPSoEOCReportadas;
		array[8]=nroCCFReportadas;
		return array;
	}
	
	
	public static String[] getLabels ( ){
		String[] labels = new String[9];
		labels[0]="Tipo registro";
		labels[1]="Total a pagar a pensiones";
		labels[2]="Total a pagar al Fondo de Solidaridad Pensional";
		labels[3]="Total a pagar a salud";
		labels[4]="Total a pagar a cajas de compensaci—n familiar";
		labels[5]="Gran total a pagar";
		labels[6]="Nœmero de administradoras de pensiones reportadas";
		labels[7]="Nœmero de EPS, EOC reportadas";
		labels[8]="Nœmero de CCF reportadas";
		return labels;
	}
	
	

	public static Reg2388ReadPensTp07 buildRecordFromStringArray( String array[] ){
		
		String[] arrayAux = Reg2388ReadPensTp07.fillArray(array, 9);
		Reg2388ReadPensTp07 instance = new Reg2388ReadPensTp07();
		instance.tipoRegistro=Integer.valueOf(arrayAux[0]);
		instance.totalAPagarPension=arrayAux[1];
		instance.totalAPagarFondoSolPensional=arrayAux[2];
		instance.totalAPagarSalud=arrayAux[3];
		instance.totalAPagarCCF=arrayAux[4];
		instance.granTotalAPagar=arrayAux[5];
		instance.nroAdminPensionesReportadas=arrayAux[6];
		instance.nroEPSoEOCReportadas=arrayAux[7];
		instance.nroCCFReportadas=arrayAux[8];
		return instance;
	}
}

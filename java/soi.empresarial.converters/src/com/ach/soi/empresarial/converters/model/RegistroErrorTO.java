package com.ach.soi.empresarial.converters.model;

import java.io.Serializable;

public class RegistroErrorTO implements Serializable, Cloneable{

	private int nroLinea = 1;
	private String tipoRegistro = "2";
	private ErrorLiquidacionTO[] errores = new ErrorLiquidacionTO[3];
	public int getNroLinea() {
		return nroLinea;
	}
	public void setNroLinea(int nroLinea) {
		this.nroLinea = nroLinea;
	}
	public String getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	public ErrorLiquidacionTO[] getErrores() {
		return errores;
	}
	public void setErrores(ErrorLiquidacionTO[] errores) {
		this.errores = errores;
	}
	
	
	
	
	
}

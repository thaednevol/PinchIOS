package com.ach.soi.empresarial.converters.model;

import java.io.Serializable;

public class ErrorValidacionTO implements Serializable, Cloneable{

	private int linea;
	private String campo;
	private String error;
	private String detalleError;
	public int getLinea() {
		return linea;
	}
	public void setLinea(int linea) {
		this.linea = linea;
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getDetalleError() {
		return detalleError;
	}
	public void setDetalleError(String detalleError) {
		this.detalleError = detalleError;
	}
	@Override
	public String toString() {
		return "ResultadoValidacion1747TO [linea=" + linea + ", campo=" + campo
				+ ", error=" + error + ", detalleError=" + detalleError + "]";
	}
	
	
	
}

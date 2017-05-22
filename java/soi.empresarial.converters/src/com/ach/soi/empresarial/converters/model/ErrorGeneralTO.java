package com.ach.soi.empresarial.converters.model;

import java.io.Serializable;

public class ErrorGeneralTO implements Serializable, Cloneable{

	private String estado;
	private String error;
	private String detalleError;
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
	
	
	
}

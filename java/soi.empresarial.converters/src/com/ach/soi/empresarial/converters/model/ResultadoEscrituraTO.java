package com.ach.soi.empresarial.converters.model;

import java.io.Serializable;

public class ResultadoEscrituraTO implements Serializable, Cloneable{

	private String estado;
	private String pathArchio;
	private String error;
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPathArchio() {
		return pathArchio;
	}
	public void setPathArchio(String pathArchio) {
		this.pathArchio = pathArchio;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
	
}

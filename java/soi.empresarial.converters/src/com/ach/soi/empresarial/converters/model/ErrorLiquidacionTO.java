package com.ach.soi.empresarial.converters.model;

import java.io.Serializable;

public class ErrorLiquidacionTO implements Serializable, Cloneable{

	
	private Integer campo = 1;
	private String error = "Error en campo test";
	private String detalleError = "Detalle Error en campo test";
	private boolean autocorregible = false;
	private String sugerencias[] = new String[]{"SUGERENCIA 1","SUGERENCIA 2"};
	
	public Integer getCampo() {
		return campo;
	}
	public void setCampo(Integer campo) {
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
	public boolean isAutocorregible() {
		return autocorregible;
	}
	public void setAutocorregible(boolean autocorregible) {
		this.autocorregible = autocorregible;
	}
	public String[] getSugerencias() {
		return sugerencias;
	}
	public void setSugerencias(String[] sugerencias) {
		this.sugerencias = sugerencias;
	}
	
	
	
}

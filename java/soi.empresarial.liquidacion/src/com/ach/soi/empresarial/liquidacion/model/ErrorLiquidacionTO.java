package com.ach.soi.empresarial.liquidacion.model;

import java.util.Arrays;

public class ErrorLiquidacionTO {

	private boolean errorRegistro;
	private int linea;
	private boolean autocorregible;
	private String nombreCampo;
	private String error;
	private String[] sugerencias;
	private Integer campo;
	public int getLinea() {
		return linea;
	}
	public void setLinea(int linea) {
		this.linea = linea;
	}
	public boolean isAutocorregible() {
		return autocorregible;
	}
	public void setAutocorregible(boolean autocorregible) {
		this.autocorregible = autocorregible;
	}
	public String getNombreCampo() {
		return nombreCampo;
	}
	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String[] getSugerencias() {
		return sugerencias;
	}
	public void setSugerencias(String[] sugerencias) {
		this.sugerencias = sugerencias;
	}
	public Integer getCampo() {
		return campo;
	}
	public void setCampo(Integer campo) {
		this.campo = campo;
	}
	
	
	public boolean isErrorRegistro() {
		return errorRegistro;
	}
	public void setErrorRegistro(boolean errorRegistro) {
		this.errorRegistro = errorRegistro;
	}
	@Override
	public String toString() {
		return "ErrorLiquidacionTO [linea=" + linea + ", autocorregible="
				+ autocorregible + ", nombreCampo=" + nombreCampo + ", error="
				+ error + ", sugerencias=" + Arrays.toString(sugerencias)
				+ ", campo=" + campo + "]";
	}
	
	
}

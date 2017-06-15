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
	private String tipoIdentificacion = "N/A";
	private String nroIdentificacion = "N/A";
	private boolean enfasis = false;
	private boolean aplicarSegundaValidacion = false;
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
	
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	public String getNroIdentificacion() {
		return nroIdentificacion;
	}
	public void setNroIdentificacion(String nroIdentificacion) {
		this.nroIdentificacion = nroIdentificacion;
	}
	public boolean isEnfasis() {
		return enfasis;
	}
	public void setEnfasis(boolean enfasis) {
		this.enfasis = enfasis;
	}
	
	public boolean isAplicarSegundaValidacion() {
		return aplicarSegundaValidacion;
	}
	public void setAplicarSegundaValidacion(boolean aplicarSegundaValidacion) {
		this.aplicarSegundaValidacion = aplicarSegundaValidacion;
	}
	@Override
	public String toString() {
		return "ErrorLiquidacionTO [errorRegistro=" + errorRegistro
				+ ", linea=" + linea + ", autocorregible=" + autocorregible
				+ ", nombreCampo=" + nombreCampo + ", error=" + error
				+ ", sugerencias=" + Arrays.toString(sugerencias) + ", campo="
				+ campo + ", tipoIdentificacion=" + tipoIdentificacion
				+ ", nroIdentificacion=" + nroIdentificacion + ", enfasis="
				+ enfasis + "]";
	}
	
	
	
	
}

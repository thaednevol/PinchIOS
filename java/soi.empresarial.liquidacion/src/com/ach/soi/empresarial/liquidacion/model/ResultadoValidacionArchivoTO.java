package com.ach.soi.empresarial.liquidacion.model;


/**
 * 
 * Objeto que almacena el resultado de la validacion completa del archivo
 * 
 * @author jgutierrez
 *
 */
public class ResultadoValidacionArchivoTO {

	private String estado;
	private String pathResultadoJson;
	private String error;
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPathResultadoJson() {
		return pathResultadoJson;
	}
	public void setPathResultadoJson(String pathResultadoJson) {
		this.pathResultadoJson = pathResultadoJson;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
	
}

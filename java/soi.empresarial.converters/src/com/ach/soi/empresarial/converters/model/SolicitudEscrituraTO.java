package com.ach.soi.empresarial.converters.model;

import java.io.Serializable;

public class SolicitudEscrituraTO implements Serializable, Cloneable{

	
	private String pathArchivo;
	private String tipoArchivo;
	private String pathArchivoData;
	private String pathArchivoComplementario;
	private String aplicarCorrecionesConversiones;
	
	public String getPathArchivo() {
		return pathArchivo;
	}
	public void setPathArchivo(String pathArchivo) {
		this.pathArchivo = pathArchivo;
	}
	public String getTipoArchivo() {
		return tipoArchivo;
	}
	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}
	public String getPathArchivoData() {
		return pathArchivoData;
	}
	public void setPathArchivoData(String pathArchivoData) {
		this.pathArchivoData = pathArchivoData;
	}
	public String getPathArchivoComplementario() {
		return pathArchivoComplementario;
	}
	public void setPathArchivoComplementario(String pathArchivoComplementario) {
		this.pathArchivoComplementario = pathArchivoComplementario;
	}
	public String getAplicarCorrecionesConversiones() {
		return aplicarCorrecionesConversiones;
	}
	public void setAplicarCorrecionesConversiones(
			String aplicarCorrecionesConversiones) {
		this.aplicarCorrecionesConversiones = aplicarCorrecionesConversiones;
	}	
	
	
	
}

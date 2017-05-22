package com.ach.soi.empresarial.converters.model;

import java.io.Serializable;

public class SolicitudConversionTO implements Serializable, Cloneable{

	
	private String pathArchivo;
	private String tipoArchivo;
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
	@Override
	public String toString() {
		return "SolicitudConversionTO [pathArchivo=" + pathArchivo
				+ ", tipoArchivo=" + tipoArchivo + "]";
	}
	
	
}

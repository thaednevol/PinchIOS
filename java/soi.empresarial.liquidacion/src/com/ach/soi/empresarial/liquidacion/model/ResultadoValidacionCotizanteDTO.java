package com.ach.soi.empresarial.liquidacion.model;

import java.io.Serializable;

public class ResultadoValidacionCotizanteDTO implements Serializable, Cloneable {

	private ErrorLiquidacionTO erroresRegistros[] = null;
	private String estadoSolicitud;
	private String errorSolicitud;
	public ErrorLiquidacionTO[] getErroresRegistros() {
		return erroresRegistros;
	}
	public void setErroresRegistros(ErrorLiquidacionTO[] erroresRegistros) {
		this.erroresRegistros = erroresRegistros;
	}
	public String getEstadoSolicitud() {
		return estadoSolicitud;
	}
	public void setEstadoSolicitud(String estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}
	public String getErrorSolicitud() {
		return errorSolicitud;
	}
	public void setErrorSolicitud(String errorSolicitud) {
		this.errorSolicitud = errorSolicitud;
	}
	
	
	
}

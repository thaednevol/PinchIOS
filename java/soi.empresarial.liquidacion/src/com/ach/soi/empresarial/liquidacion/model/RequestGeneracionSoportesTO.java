package com.ach.soi.empresarial.liquidacion.model;

import java.io.Serializable;

public class RequestGeneracionSoportesTO implements Serializable, Cloneable {

	
	private String datosEncabezadoJson;
	private String datosDetalleCotizanteJson;
	private String datosEnvioCorreoJson;
	private String rutaRecursos;
	private String rutaGeneracion;
	public String getDatosEncabezadoJson() {
		return datosEncabezadoJson;
	}
	public void setDatosEncabezadoJson(String datosEncabezadoJson) {
		this.datosEncabezadoJson = datosEncabezadoJson;
	}
	public String getDatosDetalleCotizanteJson() {
		return datosDetalleCotizanteJson;
	}
	public void setDatosDetalleCotizanteJson(String datosDetalleCotizanteJson) {
		this.datosDetalleCotizanteJson = datosDetalleCotizanteJson;
	}
	public String getDatosEnvioCorreoJson() {
		return datosEnvioCorreoJson;
	}
	public void setDatosEnvioCorreoJson(String datosEnvioCorreoJson) {
		this.datosEnvioCorreoJson = datosEnvioCorreoJson;
	}
	public String getRutaRecursos() {
		return rutaRecursos;
	}
	public void setRutaRecursos(String rutaRecursos) {
		this.rutaRecursos = rutaRecursos;
	}
	public String getRutaGeneracion() {
		return rutaGeneracion;
	}
	public void setRutaGeneracion(String rutaGeneracion) {
		this.rutaGeneracion = rutaGeneracion;
	}
	
	
}

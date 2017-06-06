package com.ach.sop.utility.biz.transfer;

/**
 * 
 * @author Gustavo Castro <gcastro@lucasian.com>
 *
 */
public class RespuestaGeneracionSoporteDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String resultadoGeneracion;
	private String detalleError;
	private String stackTraceError;
	private String rutaSoporteGenerado;
	public String getResultadoGeneracion() {
		return resultadoGeneracion;
	}
	public void setResultadoGeneracion(String resultadoGeneracion) {
		this.resultadoGeneracion = resultadoGeneracion;
	}
	public String getDetalleError() {
		return detalleError;
	}
	public void setDetalleError(String detalleError) {
		this.detalleError = detalleError;
	}
	public String getRutaSoporteGenerado() {
		return rutaSoporteGenerado;
	}
	public void setRutaSoporteGenerado(String rutaSoporteGenerado) {
		this.rutaSoporteGenerado = rutaSoporteGenerado;
	}
	public String getStackTraceError() {
		return stackTraceError;
	}
	public void setStackTraceError(String stackTraceError) {
		this.stackTraceError = stackTraceError;
	}
	
	

}

package com.ach.soi.empresarial.liquidacion.model;

import java.util.Arrays;

public class ErrorRegistroTO {
	private int id = 0;
	private String mensajeFuncional = null;
	private int tipoRegistro = 0;
	private int numeroLinea = 0;
	private int posicionInicial = 0;
	private int posicionFinal = 0;
	private String valorEncontrado = null;
	private String valorEsperado = null;
	private int codigoExcepcion;
	private String nombreCampo = null;
	private String codigoTipoDoc = null;
	private String numeroDoc = null;
	private Object[] parametrosError = null;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMensajeFuncional() {
		return mensajeFuncional;
	}
	public void setMensajeFuncional(String mensajeFuncional) {
		this.mensajeFuncional = mensajeFuncional;
	}
	public int getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(int tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	public int getNumeroLinea() {
		return numeroLinea;
	}
	public void setNumeroLinea(int numeroLinea) {
		this.numeroLinea = numeroLinea;
	}
	public int getPosicionInicial() {
		return posicionInicial;
	}
	public void setPosicionInicial(int posicionInicial) {
		this.posicionInicial = posicionInicial;
	}
	public int getPosicionFinal() {
		return posicionFinal;
	}
	public void setPosicionFinal(int posicionFinal) {
		this.posicionFinal = posicionFinal;
	}
	public String getValorEncontrado() {
		return valorEncontrado;
	}
	public void setValorEncontrado(String valorEncontrado) {
		this.valorEncontrado = valorEncontrado;
	}
	public String getValorEsperado() {
		return valorEsperado;
	}
	public void setValorEsperado(String valorEsperado) {
		this.valorEsperado = valorEsperado;
	}
	public int getCodigoExcepcion() {
		return codigoExcepcion;
	}
	public void setCodigoExcepcion(int codigoExcepcion) {
		this.codigoExcepcion = codigoExcepcion;
	}
	public String getNombreCampo() {
		return nombreCampo;
	}
	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}
	public String getCodigoTipoDoc() {
		return codigoTipoDoc;
	}
	public void setCodigoTipoDoc(String codigoTipoDoc) {
		this.codigoTipoDoc = codigoTipoDoc;
	}
	public String getNumeroDoc() {
		return numeroDoc;
	}
	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

	
	
	public Object[] getParametrosError() {
		return parametrosError;
	}
	public void setParametrosError(Object[] parametrosError) {
		this.parametrosError = parametrosError;
	}
	@Override
	public String toString() {
		return "ErrorRegistroTO [id=" + id + ", mensajeFuncional="
				+ mensajeFuncional + ", tipoRegistro=" + tipoRegistro
				+ ", numeroLinea=" + numeroLinea + ", posicionInicial="
				+ posicionInicial + ", posicionFinal=" + posicionFinal
				+ ", valorEncontrado=" + valorEncontrado + ", valorEsperado="
				+ valorEsperado + ", codigoExcepcion=" + codigoExcepcion
				+ ", nombreCampo=" + nombreCampo + ", codigoTipoDoc="
				+ codigoTipoDoc + ", numeroDoc=" + numeroDoc
				+ ", parametrosError=" + Arrays.toString(parametrosError) + "]";
	}
	
}

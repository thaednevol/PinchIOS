package com.ach.soi.empresarial.converters.model.beans2145;

import java.io.Serializable;
import java.util.Date;

import com.ach.soi.empresarial.converters.model.CommonBean;

@SuppressWarnings("serial")
public class Reg2145Tp01 extends CommonBean implements Serializable {

	private String razonSocialPagador;
	private String tipoDocumentoPagador;
	private String numeroIdentificacionPagador;
	private Long digitoVerificacionPagador;
	private String formaPresentacion;
	private String codigoSucursalODependencia;
	private String nombreSucursalODependencia;
	private Date fechaPagoSistemasNoSalud;
	private Date fechaPagoSistemaSalud;
	private Long numeroRadicacion;
	private Date fechaPago;
	private Integer numeroTotalPensionados;
	private Long valorTotalNomina;
	private Integer tipoPagadorPensiones;
	private Integer codigoOperadorInformacion;
	private String tipoPlanillaPensionado;
	
	public String getTipoPlanillaPensionado() {
		return tipoPlanillaPensionado;
	}
	public void setTipoPlanillaPensionado(String tipoPlanillaPensionado) {
		this.tipoPlanillaPensionado = tipoPlanillaPensionado;
	}
	public String getRazonSocialPagador() {
		return razonSocialPagador;
	}
	public void setRazonSocialPagador(String razonSocialPagador) {
		this.razonSocialPagador = razonSocialPagador;
	}
	public String getTipoDocumentoPagador() {
		return tipoDocumentoPagador;
	}
	public void setTipoDocumentoPagador(String tipoDocumentoPagador) {
		this.tipoDocumentoPagador = tipoDocumentoPagador;
	}
	public String getNumeroIdentificacionPagador() {
		return numeroIdentificacionPagador;
	}
	public void setNumeroIdentificacionPagador(String numeroIdentificacionPagador) {
		this.numeroIdentificacionPagador = numeroIdentificacionPagador;
	}
	public Long getDigitoVerificacionPagador() {
		return digitoVerificacionPagador;
	}
	public void setDigitoVerificacionPagador(Long digitoVerificacionPagador) {
		this.digitoVerificacionPagador = digitoVerificacionPagador;
	}
	public String getFormaPresentacion() {
		return formaPresentacion;
	}
	public void setFormaPresentacion(String formaPresentacion) {
		this.formaPresentacion = formaPresentacion;
	}
	public String getCodigoSucursalODependencia() {
		return codigoSucursalODependencia;
	}
	public void setCodigoSucursalODependencia(String codigoSucursalODependencia) {
		this.codigoSucursalODependencia = codigoSucursalODependencia;
	}
	public String getNombreSucursalODependencia() {
		return nombreSucursalODependencia;
	}
	public void setNombreSucursalODependencia(String nombreSucursalODependencia) {
		this.nombreSucursalODependencia = nombreSucursalODependencia;
	}
	public Date getFechaPagoSistemasNoSalud() {
		return fechaPagoSistemasNoSalud;
	}
	public void setFechaPagoSistemasNoSalud(Date fechaPagoSistemasNoSalud) {
		this.fechaPagoSistemasNoSalud = fechaPagoSistemasNoSalud;
	}
	public Date getFechaPagoSistemaSalud() {
		return fechaPagoSistemaSalud;
	}
	public void setFechaPagoSistemaSalud(Date fechaPagoSistemaSalud) {
		this.fechaPagoSistemaSalud = fechaPagoSistemaSalud;
	}
	public Long getNumeroRadicacion() {
		return numeroRadicacion;
	}
	public void setNumeroRadicacion(Long numeroRadicacion) {
		this.numeroRadicacion = numeroRadicacion;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public Integer getNumeroTotalPensionados() {
		return numeroTotalPensionados;
	}
	public void setNumeroTotalPensionados(Integer numeroTotalPensionados) {
		this.numeroTotalPensionados = numeroTotalPensionados;
	}
	public Long getValorTotalNomina() {
		return valorTotalNomina;
	}
	public void setValorTotalNomina(Long valorTotalNomina) {
		this.valorTotalNomina = valorTotalNomina;
	}
	public Integer getTipoPagadorPensiones() {
		return tipoPagadorPensiones;
	}
	public void setTipoPagadorPensiones(Integer tipoPagadorPensiones) {
		this.tipoPagadorPensiones = tipoPagadorPensiones;
	}
	public Integer getCodigoOperadorInformacion() {
		return codigoOperadorInformacion;
	}
	public void setCodigoOperadorInformacion(Integer codigoOperadorInformacion) {
		this.codigoOperadorInformacion = codigoOperadorInformacion;
	}
}

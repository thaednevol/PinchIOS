package com.ach.soi.empresarial.converters.model.beans1747;

import java.io.Serializable;
import java.util.Date;

import com.ach.soi.empresarial.converters.model.CommonBean;

public class Reg1747Tp01 extends CommonBean implements Serializable{
	
	private Integer modalidadPlanilla;
	private String razonSocialAportante;
	private String tipoDocumentoAportante;
	private String numeroDocumentoAportante;
	private Integer digitoVerificacionAportante;
	private String tipoPlanilla;
	private Long numeroPlanillaAsociada;
	private Date fechaPagoPlanillaAsociada;
	private String formaPresentacion;
	private String codigoSucursalAportante;
	private String nombreSucursal;
	private String codigoARPAportante;
	private Date periodoPagoSistemaNoSalud;
	private Date periodoPagoSistemaSalud;
	private Long numeroRadicacionPlanilla;
	private Date fechaPago;
	private Integer numeroTotalEmpleados;
	private Long valorTotalNomina;
	private Integer tipoAportante;
	private Integer codigoOperadorInformacion;
	
	
	
	public Integer getModalidadPlanilla() {
		return modalidadPlanilla;
	}
	public void setModalidadPlanilla(Integer modalidadPlanilla) {
		this.modalidadPlanilla = modalidadPlanilla;
	}
	
	public String getRazonSocialAportante() {
		return razonSocialAportante;
	}
	public void setRazonSocialAportante(String razonSocialAportante) {
		this.razonSocialAportante = razonSocialAportante;
	}
	public String getTipoDocumentoAportante() {
		return tipoDocumentoAportante;
	}
	public void setTipoDocumentoAportante(String tipoDocumentoAportante) {
		this.tipoDocumentoAportante = tipoDocumentoAportante;
	}
	public String getNumeroDocumentoAportante() {
		return numeroDocumentoAportante;
	}
	public void setNumeroDocumentoAportante(String numeroDocumentoAportante) {
		this.numeroDocumentoAportante = numeroDocumentoAportante;
	}
	public Integer getDigitoVerificacionAportante() {
		return digitoVerificacionAportante;
	}
	public void setDigitoVerificacionAportante(Integer digitoVerificacionAportante) {
		this.digitoVerificacionAportante = digitoVerificacionAportante;
	}
	public String getTipoPlanilla() {
		return tipoPlanilla;
	}
	public void setTipoPlanilla(String tipoPlanilla) {
		this.tipoPlanilla = tipoPlanilla;
	}
	public Long getNumeroPlanillaAsociada() {
		return numeroPlanillaAsociada;
	}
	public void setNumeroPlanillaAsociada(Long numeroPlanillaAsociada) {
		this.numeroPlanillaAsociada = numeroPlanillaAsociada;
	}
	public Date getFechaPagoPlanillaAsociada() {
		return fechaPagoPlanillaAsociada;
	}
	public void setFechaPagoPlanillaAsociada(Date fechaPagoPlanillaAsociada) {
		this.fechaPagoPlanillaAsociada = fechaPagoPlanillaAsociada;
	}
	public String getFormaPresentacion() {
		return formaPresentacion;
	}
	public void setFormaPresentacion(String formaPresentacion) {
		this.formaPresentacion = formaPresentacion;
	}
	public String getCodigoSucursalAportante() {
		return codigoSucursalAportante;
	}
	public void setCodigoSucursalAportante(String codigoSucursalAportante) {
		this.codigoSucursalAportante = codigoSucursalAportante;
	}
	public String getNombreSucursal() {
		return nombreSucursal;
	}
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}
	public String getCodigoARPAportante() {
		return codigoARPAportante;
	}
	public void setCodigoARPAportante(String codigoARPAportante) {
		this.codigoARPAportante = codigoARPAportante;
	}
	public Date getPeriodoPagoSistemaNoSalud() {
		return periodoPagoSistemaNoSalud;
	}
	public void setPeriodoPagoSistemaNoSalud(Date periodoPagoSistemaNoSalud) {
		this.periodoPagoSistemaNoSalud = periodoPagoSistemaNoSalud;
	}
	public Date getPeriodoPagoSistemaSalud() {
		return periodoPagoSistemaSalud;
	}
	public void setPeriodoPagoSistemaSalud(Date periodoPagoSistemaSalud) {
		this.periodoPagoSistemaSalud = periodoPagoSistemaSalud;
	}
	public Long getNumeroRadicacionPlanilla() {
		return numeroRadicacionPlanilla;
	}
	public void setNumeroRadicacionPlanilla(Long numeroRadicacionPlanilla) {
		this.numeroRadicacionPlanilla = numeroRadicacionPlanilla;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public Integer getNumeroTotalEmpleados() {
		return numeroTotalEmpleados;
	}
	public void setNumeroTotalEmpleados(Integer numeroTotalEmpleados) {
		this.numeroTotalEmpleados = numeroTotalEmpleados;
	}
	public Long getValorTotalNomina() {
		return valorTotalNomina;
	}
	public void setValorTotalNomina(Long valorTotalNomina) {
		this.valorTotalNomina = valorTotalNomina;
	}
	public Integer getTipoAportante() {
		return tipoAportante;
	}
	public void setTipoAportante(Integer tipoAportante) {
		this.tipoAportante = tipoAportante;
	}
	public Integer getCodigoOperadorInformacion() {
		return codigoOperadorInformacion;
	}
	public void setCodigoOperadorInformacion(Integer codigoOperadorInformacion) {
		this.codigoOperadorInformacion = codigoOperadorInformacion;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reg1747Tp1 [modalidadPlanilla=");
		builder.append(modalidadPlanilla);
		builder.append(", razonSocialAportante=");
		builder.append(razonSocialAportante);
		builder.append(", tipoDocumentoAportante=");
		builder.append(tipoDocumentoAportante);
		builder.append(", numeroDocumentoAportante=");
		builder.append(numeroDocumentoAportante);
		builder.append(", digitoVerificacionAportante=");
		builder.append(digitoVerificacionAportante);
		builder.append(", tipoPlanilla=");
		builder.append(tipoPlanilla);
		builder.append(", numeroPlanillaAsociada=");
		builder.append(numeroPlanillaAsociada);
		builder.append(", fechaPagoPlanillaAsociada=");
		builder.append(fechaPagoPlanillaAsociada);
		builder.append(", formaPresentacion=");
		builder.append(formaPresentacion);
		builder.append(", codigoSucursalAportante=");
		builder.append(codigoSucursalAportante);
		builder.append(", nombreSucursal=");
		builder.append(nombreSucursal);
		builder.append(", codigoARPAportante=");
		builder.append(codigoARPAportante);
		builder.append(", periodoPagoSistemaNoSalud=");
		builder.append(periodoPagoSistemaNoSalud);
		builder.append(", periodoPagoSistemaSalud=");
		builder.append(periodoPagoSistemaSalud);
		builder.append(", numeroRadicacionPlanilla=");
		builder.append(numeroRadicacionPlanilla);
		builder.append(", fechaPago=");
		builder.append(fechaPago);
		builder.append(", numeroTotalEmpleados=");
		builder.append(numeroTotalEmpleados);
		builder.append(", valorTotalNomina=");
		builder.append(valorTotalNomina);
		builder.append(", tipoAportante=");
		builder.append(tipoAportante);
		builder.append(", codigoOperadorInformacion=");
		builder.append(codigoOperadorInformacion);
		builder.append(", tipoRegistro=");
		builder.append(tipoRegistro);
		builder.append(", secuencia=");
		builder.append(secuencia);
		builder.append("]");
		return builder.toString();
	}

	
	
}

package com.ach.soi.empresarial.converters.model.beans2145;

import java.io.Serializable;

import com.ach.soi.empresarial.converters.model.CommonBean;

@SuppressWarnings("serial")
public class Reg2145Tp04 extends CommonBean implements Serializable {

	private String codigoFondoSolidaridad;
	private String nitFondoSolidaridadPensional;
	private String digitoVerFondoSolPensional;
	private Long valorTotalAportesSubctaSubsistencia;
	private Integer nroDiasMoraLiquidados;
	private Long valorIntSubctaSubsistencia;
	private Long totalPagarSubctaSusbsistencia;
	private Integer totalAportantesSubctaSubsistencia;
	public String getCodigoFondoSolidaridad() {
		return codigoFondoSolidaridad;
	}
	public void setCodigoFondoSolidaridad(String codigoFondoSolidaridad) {
		this.codigoFondoSolidaridad = codigoFondoSolidaridad;
	}
	public String getNitFondoSolidaridadPensional() {
		return nitFondoSolidaridadPensional;
	}
	public void setNitFondoSolidaridadPensional(String nitFondoSolidaridadPensional) {
		this.nitFondoSolidaridadPensional = nitFondoSolidaridadPensional;
	}
	public String getDigitoVerFondoSolPensional() {
		return digitoVerFondoSolPensional;
	}
	public void setDigitoVerFondoSolPensional(String digitoVerFondoSolPensional) {
		this.digitoVerFondoSolPensional = digitoVerFondoSolPensional;
	}
	public Long getValorTotalAportesSubctaSubsistencia() {
		return valorTotalAportesSubctaSubsistencia;
	}
	public void setValorTotalAportesSubctaSubsistencia(
			Long valorTotalAportesSubctaSubsistencia) {
		this.valorTotalAportesSubctaSubsistencia = valorTotalAportesSubctaSubsistencia;
	}
	public Integer getNroDiasMoraLiquidados() {
		return nroDiasMoraLiquidados;
	}
	public void setNroDiasMoraLiquidados(Integer nroDiasMoraLiquidados) {
		this.nroDiasMoraLiquidados = nroDiasMoraLiquidados;
	}
	public Long getValorIntSubctaSubsistencia() {
		return valorIntSubctaSubsistencia;
	}
	public void setValorIntSubctaSubsistencia(Long valorIntSubctaSubsistencia) {
		this.valorIntSubctaSubsistencia = valorIntSubctaSubsistencia;
	}
	public Long getTotalPagarSubctaSusbsistencia() {
		return totalPagarSubctaSusbsistencia;
	}
	public void setTotalPagarSubctaSusbsistencia(Long totalPagarSubctaSusbsistencia) {
		this.totalPagarSubctaSusbsistencia = totalPagarSubctaSusbsistencia;
	}
	public Integer getTotalAportantesSubctaSubsistencia() {
		return totalAportantesSubctaSubsistencia;
	}
	public void setTotalAportantesSubctaSubsistencia(
			Integer totalAportantesSubctaSubsistencia) {
		this.totalAportantesSubctaSubsistencia = totalAportantesSubctaSubsistencia;
	}
}

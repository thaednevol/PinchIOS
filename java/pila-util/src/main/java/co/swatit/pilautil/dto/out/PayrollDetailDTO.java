/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Objeto de transporte que contiene los detalles de las plantillas obtenidas por el servicio getFilteredPayrolls
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 9/03/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "payrollDetailDTO", propOrder = { "idSoiPlanilla", "numeroPlanillaElectronica", "tipoPlanilla",
		"valorPagado", "periodoSistemaSalud", "numeroEmpleados", "fechaUltimaModificacion" })
public class PayrollDetailDTO implements Serializable {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id de la planilla ante SOI
	 */
	private Long idSoiPlanilla;
	/**
	 * identificación de la planilla
	 */
	private String numeroPlanillaElectronica;
	/**
	 * Tipo de la planilla
	 */
	private String tipoPlanilla;
	/**
	 * Valor total pagado de la planilla
	 */
	private BigDecimal valorPagado;
	/**
	 * Periodo en el que fué pagada la planilla
	 */
	private String periodoSistemaSalud;
	/**
	 * Cantidad de empleados del aportante
	 */
	private Long numeroEmpleados;
	/**
	 * Fecha de modificación de la planilla
	 */
	private String fechaUltimaModificacion;

	/**
	 * Método getter del atributo idSoiPlanilla de la clase PayrollDetailDTO
	 *
	 * @return the idSoiPlanilla
	 */
	public Long getIdSoiPlanilla() {
		return idSoiPlanilla;
	}

	/**
	 * Método setter del atributo idSoiPlanilla de la clase PayrollDetailDTO
	 *
	 * @param idSoiPlanilla
	 *            the idSoiPlanilla to set
	 */
	public void setIdSoiPlanilla(Long idSoiPlanilla) {
		this.idSoiPlanilla = idSoiPlanilla;
	}

	/**
	 * Método getter del atributo numeroPlanillaElectronica de la clase PayrollDetailDTO
	 *
	 * @return the numeroPlanillaElectronica
	 */
	public String getNumeroPlanillaElectronica() {
		return numeroPlanillaElectronica;
	}

	/**
	 * Método setter del atributo numeroPlanillaElectronica de la clase PayrollDetailDTO
	 *
	 * @param numeroPlanillaElectronica
	 *            the numeroPlanillaElectronica to set
	 */
	public void setNumeroPlanillaElectronica(String numeroPlanillaElectronica) {
		this.numeroPlanillaElectronica = numeroPlanillaElectronica;
	}

	/**
	 * Método getter del atributo tipoPlanilla de la clase PayrollDetailDTO
	 *
	 * @return the tipoPlanilla
	 */
	public String getTipoPlanilla() {
		return tipoPlanilla;
	}

	/**
	 * Método setter del atributo tipoPlanilla de la clase PayrollDetailDTO
	 *
	 * @param tipoPlanilla
	 *            the tipoPlanilla to set
	 */
	public void setTipoPlanilla(String tipoPlanilla) {
		this.tipoPlanilla = tipoPlanilla;
	}

	/**
	 * Método getter del atributo valorPagado de la clase PayrollDetailDTO
	 *
	 * @return the valorPagado
	 */
	public BigDecimal getValorPagado() {
		return valorPagado;
	}

	/**
	 * Método setter del atributo valorPagado de la clase PayrollDetailDTO
	 *
	 * @param valorPagado
	 *            the valorPagado to set
	 */
	public void setValorPagado(BigDecimal valorPagado) {
		this.valorPagado = valorPagado;
	}

	/**
	 * Método getter del atributo periodoSistemaSalud de la clase PayrollDetailDTO
	 *
	 * @return the periodoSistemaSalud
	 */
	public String getPeriodoSistemaSalud() {
		return periodoSistemaSalud;
	}

	/**
	 * Método setter del atributo periodoSistemaSalud de la clase PayrollDetailDTO
	 *
	 * @param periodoSistemaSalud
	 *            the periodoSistemaSalud to set
	 */
	public void setPeriodoSistemaSalud(String periodoSistemaSalud) {
		this.periodoSistemaSalud = periodoSistemaSalud;
	}

	/**
	 * Método getter del atributo numeroEmpleados de la clase PayrollDetailDTO
	 *
	 * @return the numeroEmpleados
	 */
	public Long getNumeroEmpleados() {
		return numeroEmpleados;
	}

	/**
	 * Método setter del atributo numeroEmpleados de la clase PayrollDetailDTO
	 *
	 * @param numeroEmpleados
	 *            the numeroEmpleados to set
	 */
	public void setNumeroEmpleados(Long numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}

	/**
	 * Método getter del atributo fechaUltimaModificacion de la clase PayrollDetailDTO
	 *
	 * @return the fechaUltimaModificacion
	 */
	public String getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	/**
	 * Método setter del atributo fechaUltimaModificacion de la clase PayrollDetailDTO
	 *
	 * @param fechaUltimaModificacion
	 *            the fechaUltimaModificacion to set
	 */
	public void setFechaUltimaModificacion(String fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

}

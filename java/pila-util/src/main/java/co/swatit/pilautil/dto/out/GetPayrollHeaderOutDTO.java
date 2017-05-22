/**
 * 
 */
package co.swatit.pilautil.dto.out;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import co.swatit.pilautil.dto.ResponseDTO;

/**
 * Objeto de transporte que contiene la respuesta del servicio getPayrollHeader
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 3/04/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPayrollHeaderOutDTO", propOrder = { "fechaPago", "tipoPlanilla", "cantidadEmpleados", "sucursal",
		"periodoLiquidacionPensiones", "periodoLiquidacionSalud" })
public class GetPayrollHeaderOutDTO extends ResponseDTO {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * fecha de pago de la planilla
	 */
	private String fechaPago;
	/**
	 * tipo de planilla
	 */
	private String tipoPlanilla;
	/**
	 * Cantidad de empleados de la empresa
	 */
	private String cantidadEmpleados;
	/**
	 * Sucursal de la empresa
	 */
	private String sucursal;
	/**
	 * Periodo de liquidación correspondiente a las pensiones
	 */
	private String periodoLiquidacionPensiones;
	/**
	 * Periodo de liquidación correspondiente a la salud
	 */
	private String periodoLiquidacionSalud;

	/**
	 * Información de la planilla obtenida
	 */
	private PlanillaAportanteDTO planillaAportanteDTO;

	/**
	 * Método getter del atributo fechaPago de la clase GetPayrollHeaderInDTO
	 *
	 * @return the fechaPago
	 */
	public String getFechaPago() {
		return fechaPago;
	}

	/**
	 * Método setter del atributo fechaPago de la clase GetPayrollHeaderInDTO
	 *
	 * @param fechaPago
	 *            the fechaPago to set
	 */
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	/**
	 * Método getter del atributo tipoPlanilla de la clase GetPayrollHeaderInDTO
	 *
	 * @return the tipoPlanilla
	 */
	public String getTipoPlanilla() {
		return tipoPlanilla;
	}

	/**
	 * Método setter del atributo tipoPlanilla de la clase GetPayrollHeaderInDTO
	 *
	 * @param tipoPlanilla
	 *            the tipoPlanilla to set
	 */
	public void setTipoPlanilla(String tipoPlanilla) {
		this.tipoPlanilla = tipoPlanilla;
	}

	/**
	 * Método getter del atributo cantidadEmpleados de la clase GetPayrollHeaderInDTO
	 *
	 * @return the cantidadEmpleados
	 */
	public String getCantidadEmpleados() {
		return cantidadEmpleados;
	}

	/**
	 * Método setter del atributo cantidadEmpleados de la clase GetPayrollHeaderInDTO
	 *
	 * @param cantidadEmpleados
	 *            the cantidadEmpleados to set
	 */
	public void setCantidadEmpleados(String cantidadEmpleados) {
		this.cantidadEmpleados = cantidadEmpleados;
	}

	/**
	 * Método getter del atributo sucursal de la clase GetPayrollHeaderInDTO
	 *
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * Método setter del atributo sucursal de la clase GetPayrollHeaderInDTO
	 *
	 * @param sucursal
	 *            the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Método getter del atributo periodoLiquidacionPensiones de la clase GetPayrollHeaderInDTO
	 *
	 * @return the periodoLiquidacionPensiones
	 */
	public String getPeriodoLiquidacionPensiones() {
		return periodoLiquidacionPensiones;
	}

	/**
	 * Método setter del atributo periodoLiquidacionPensiones de la clase GetPayrollHeaderInDTO
	 *
	 * @param periodoLiquidacionPensiones
	 *            the periodoLiquidacionPensiones to set
	 */
	public void setPeriodoLiquidacionPensiones(String periodoLiquidacionPensiones) {
		this.periodoLiquidacionPensiones = periodoLiquidacionPensiones;
	}

	/**
	 * Método getter del atributo periodoLiquidacionSalud de la clase GetPayrollHeaderInDTO
	 *
	 * @return the periodoLiquidacionSalud
	 */
	public String getPeriodoLiquidacionSalud() {
		return periodoLiquidacionSalud;
	}

	/**
	 * Método setter del atributo periodoLiquidacionSalud de la clase GetPayrollHeaderInDTO
	 *
	 * @param periodoLiquidacionSalud
	 *            the periodoLiquidacionSalud to set
	 */
	public void setPeriodoLiquidacionSalud(String periodoLiquidacionSalud) {
		this.periodoLiquidacionSalud = periodoLiquidacionSalud;
	}

	/**
	 * Método getter del atributo planillaAportanteDTO de la clase GetPayrollHeaderOutDTO
	 *
	 * @return the planillaAportanteDTO
	 */
	public PlanillaAportanteDTO getPlanillaAportanteDTO() {
		return planillaAportanteDTO;
	}

	/**
	 * Método setter del atributo planillaAportanteDTO de la clase GetPayrollHeaderOutDTO
	 *
	 * @param planillaAportanteDTO
	 *            the planillaAportanteDTO to set
	 */
	public void setPlanillaAportanteDTO(PlanillaAportanteDTO planillaAportanteDTO) {
		this.planillaAportanteDTO = planillaAportanteDTO;
	}

}

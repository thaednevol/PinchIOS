/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;

import com.ach.pla.biz.transfer.InformacionPlanillaMNCorregida;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link InformacionPlanillaMNCorregida}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class InformacionPlanillaMNCorregidaDTO implements Serializable {
	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	private Integer idTipoPlanilla;
	private String tipoPlanilla;
	private Long idSucursal;
	private String sucursal;
	private String periodoLiquidacionSalud;
	private String periodoLiquidacionNoSalud;
	private Integer idFormaPresentacion;
	private String codigoSucursal;
	private String formaPresentacion;
	private String fechaPago;

	/**
	 * Método getter del atributo idTipoPlanilla de la clase InformacionPlanillaMNCorregidaDTO
	 *
	 * @return the idTipoPlanilla
	 */
	public Integer getIdTipoPlanilla() {
		return idTipoPlanilla;
	}

	/**
	 * Método setter del atributo idTipoPlanilla de la clase InformacionPlanillaMNCorregidaDTO
	 *
	 * @param idTipoPlanilla
	 *            the idTipoPlanilla to set
	 */
	public void setIdTipoPlanilla(Integer idTipoPlanilla) {
		this.idTipoPlanilla = idTipoPlanilla;
	}

	/**
	 * Método getter del atributo tipoPlanilla de la clase InformacionPlanillaMNCorregidaDTO
	 *
	 * @return the tipoPlanilla
	 */
	public String getTipoPlanilla() {
		return tipoPlanilla;
	}

	/**
	 * Método setter del atributo tipoPlanilla de la clase InformacionPlanillaMNCorregidaDTO
	 *
	 * @param tipoPlanilla
	 *            the tipoPlanilla to set
	 */
	public void setTipoPlanilla(String tipoPlanilla) {
		this.tipoPlanilla = tipoPlanilla;
	}

	/**
	 * Método getter del atributo idSucursal de la clase InformacionPlanillaMNCorregidaDTO
	 *
	 * @return the idSucursal
	 */
	public Long getIdSucursal() {
		return idSucursal;
	}

	/**
	 * Método setter del atributo idSucursal de la clase InformacionPlanillaMNCorregidaDTO
	 *
	 * @param idSucursal
	 *            the idSucursal to set
	 */
	public void setIdSucursal(Long idSucursal) {
		this.idSucursal = idSucursal;
	}

	/**
	 * Método getter del atributo sucursal de la clase InformacionPlanillaMNCorregidaDTO
	 *
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * Método setter del atributo sucursal de la clase InformacionPlanillaMNCorregidaDTO
	 *
	 * @param sucursal
	 *            the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Método getter del atributo periodoLiquidacionSalud de la clase InformacionPlanillaMNCorregidaDTO
	 *
	 * @return the periodoLiquidacionSalud
	 */
	public String getPeriodoLiquidacionSalud() {
		return periodoLiquidacionSalud;
	}

	/**
	 * Método setter del atributo periodoLiquidacionSalud de la clase InformacionPlanillaMNCorregidaDTO
	 *
	 * @param periodoLiquidacionSalud
	 *            the periodoLiquidacionSalud to set
	 */
	public void setPeriodoLiquidacionSalud(String periodoLiquidacionSalud) {
		this.periodoLiquidacionSalud = periodoLiquidacionSalud;
	}

	/**
	 * Método getter del atributo periodoLiquidacionNoSalud de la clase InformacionPlanillaMNCorregidaDTO
	 *
	 * @return the periodoLiquidacionNoSalud
	 */
	public String getPeriodoLiquidacionNoSalud() {
		return periodoLiquidacionNoSalud;
	}

	/**
	 * Método setter del atributo periodoLiquidacionNoSalud de la clase InformacionPlanillaMNCorregidaDTO
	 *
	 * @param periodoLiquidacionNoSalud
	 *            the periodoLiquidacionNoSalud to set
	 */
	public void setPeriodoLiquidacionNoSalud(String periodoLiquidacionNoSalud) {
		this.periodoLiquidacionNoSalud = periodoLiquidacionNoSalud;
	}

	/**
	 * Método getter del atributo idFormaPresentacion de la clase InformacionPlanillaMNCorregidaDTO
	 *
	 * @return the idFormaPresentacion
	 */
	public Integer getIdFormaPresentacion() {
		return idFormaPresentacion;
	}

	/**
	 * Método setter del atributo idFormaPresentacion de la clase InformacionPlanillaMNCorregidaDTO
	 *
	 * @param idFormaPresentacion
	 *            the idFormaPresentacion to set
	 */
	public void setIdFormaPresentacion(Integer idFormaPresentacion) {
		this.idFormaPresentacion = idFormaPresentacion;
	}

	/**
	 * Método getter del atributo codigoSucursal de la clase InformacionPlanillaMNCorregidaDTO
	 *
	 * @return the codigoSucursal
	 */
	public String getCodigoSucursal() {
		return codigoSucursal;
	}

	/**
	 * Método setter del atributo codigoSucursal de la clase InformacionPlanillaMNCorregidaDTO
	 *
	 * @param codigoSucursal
	 *            the codigoSucursal to set
	 */
	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}

	/**
	 * Método getter del atributo formaPresentacion de la clase InformacionPlanillaMNCorregidaDTO
	 *
	 * @return the formaPresentacion
	 */
	public String getFormaPresentacion() {
		return formaPresentacion;
	}

	/**
	 * Método setter del atributo formaPresentacion de la clase InformacionPlanillaMNCorregidaDTO
	 *
	 * @param formaPresentacion
	 *            the formaPresentacion to set
	 */
	public void setFormaPresentacion(String formaPresentacion) {
		this.formaPresentacion = formaPresentacion;
	}

	/**
	 * Método getter del atributo fechaPago de la clase InformacionPlanillaMNCorregidaDTO
	 *
	 * @return the fechaPago
	 */
	public String getFechaPago() {
		return fechaPago;
	}

	/**
	 * Método setter del atributo fechaPago de la clase InformacionPlanillaMNCorregidaDTO
	 *
	 * @param fechaPago
	 *            the fechaPago to set
	 */
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
}

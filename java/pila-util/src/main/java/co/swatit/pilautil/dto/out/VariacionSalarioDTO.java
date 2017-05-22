/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;

import com.ach.pla.biz.model.VariacionSalarioVO;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link VariacionSalarioVO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 7/04/2017
 * @version 1.0
 */
public class VariacionSalarioDTO implements Serializable {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;

	private Integer diaInicial;
	private Integer diaFinal;
	private Long nuevoSalario;
	private Boolean integral;
	private Long nuevoSalarioEfectivo;
	private String fechaFin;
	private String fechaInicio;
	private Boolean calculosDiasIBC;

	/**
	 * Método getter del atributo diaInicial de la clase VariacionSalarioDTO
	 *
	 * @return the diaInicial
	 */
	public Integer getDiaInicial() {
		return diaInicial;
	}

	/**
	 * Método setter del atributo diaInicial de la clase VariacionSalarioDTO
	 *
	 * @param diaInicial
	 *            the diaInicial to set
	 */
	public void setDiaInicial(Integer diaInicial) {
		this.diaInicial = diaInicial;
	}

	/**
	 * Método getter del atributo diaFinal de la clase VariacionSalarioDTO
	 *
	 * @return the diaFinal
	 */
	public Integer getDiaFinal() {
		return diaFinal;
	}

	/**
	 * Método setter del atributo diaFinal de la clase VariacionSalarioDTO
	 *
	 * @param diaFinal
	 *            the diaFinal to set
	 */
	public void setDiaFinal(Integer diaFinal) {
		this.diaFinal = diaFinal;
	}

	/**
	 * Método getter del atributo nuevoSalario de la clase VariacionSalarioDTO
	 *
	 * @return the nuevoSalario
	 */
	public Long getNuevoSalario() {
		return nuevoSalario;
	}

	/**
	 * Método setter del atributo nuevoSalario de la clase VariacionSalarioDTO
	 *
	 * @param nuevoSalario
	 *            the nuevoSalario to set
	 */
	public void setNuevoSalario(Long nuevoSalario) {
		this.nuevoSalario = nuevoSalario;
	}

	/**
	 * Método getter del atributo integral de la clase VariacionSalarioDTO
	 *
	 * @return the integral
	 */
	public Boolean getIntegral() {
		return integral;
	}

	/**
	 * Método setter del atributo integral de la clase VariacionSalarioDTO
	 *
	 * @param integral
	 *            the integral to set
	 */
	public void setIntegral(Boolean integral) {
		this.integral = integral;
	}

	/**
	 * Método getter del atributo nuevoSalarioEfectivo de la clase VariacionSalarioDTO
	 *
	 * @return the nuevoSalarioEfectivo
	 */
	public Long getNuevoSalarioEfectivo() {
		return nuevoSalarioEfectivo;
	}

	/**
	 * Método setter del atributo nuevoSalarioEfectivo de la clase VariacionSalarioDTO
	 *
	 * @param nuevoSalarioEfectivo
	 *            the nuevoSalarioEfectivo to set
	 */
	public void setNuevoSalarioEfectivo(Long nuevoSalarioEfectivo) {
		this.nuevoSalarioEfectivo = nuevoSalarioEfectivo;
	}

	/**
	 * Método getter del atributo fechaFin de la clase VariacionSalarioDTO
	 *
	 * @return the fechaFin
	 */
	public String getFechaFin() {
		return fechaFin;
	}

	/**
	 * Método setter del atributo fechaFin de la clase VariacionSalarioDTO
	 *
	 * @param fechaFin
	 *            the fechaFin to set
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Método getter del atributo fechaInicio de la clase VariacionSalarioDTO
	 *
	 * @return the fechaInicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Método setter del atributo fechaInicio de la clase VariacionSalarioDTO
	 *
	 * @param fechaInicio
	 *            the fechaInicio to set
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Método getter del atributo calculosDiasIBC de la clase VariacionSalarioDTO
	 *
	 * @return the calculosDiasIBC
	 */
	public Boolean getCalculosDiasIBC() {
		return calculosDiasIBC;
	}

	/**
	 * Método setter del atributo calculosDiasIBC de la clase VariacionSalarioDTO
	 *
	 * @param calculosDiasIBC
	 *            the calculosDiasIBC to set
	 */
	public void setCalculosDiasIBC(Boolean calculosDiasIBC) {
		this.calculosDiasIBC = calculosDiasIBC;
	}

}

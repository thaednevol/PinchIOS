/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;
import java.math.BigDecimal;

import com.ach.cfg.biz.model.RiesgoClaseVO;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link RiesgoClaseVO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class RiesgoClaseDTO implements Serializable {
	/**
	 * Constante de Serialización
	 */
	private static final long serialVersionUID = 1L;
	private String causaFinVigencia;
	private String fechaFinVigencia;
	private String fechaInicioVigencia;
	private Integer vigente;
	private BigDecimal tarifaLimSuperior;
	private BigDecimal tarifaLimInferior;
	private BigDecimal tarifa;
	private String nombreMostrar;
	private String nombre;
	private String codigo;
	private Integer idSoiRiesgoClase;

	/**
	 * Método getter del atributo causaFinVigencia de la clase RiesgoClaseDTO
	 *
	 * @return the causaFinVigencia
	 */
	public String getCausaFinVigencia() {
		return causaFinVigencia;
	}

	/**
	 * Método setter del atributo causaFinVigencia de la clase RiesgoClaseDTO
	 *
	 * @param causaFinVigencia
	 *            the causaFinVigencia to set
	 */
	public void setCausaFinVigencia(String causaFinVigencia) {
		this.causaFinVigencia = causaFinVigencia;
	}

	/**
	 * Método getter del atributo fechaFinVigencia de la clase RiesgoClaseDTO
	 *
	 * @return the fechaFinVigencia
	 */
	public String getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	/**
	 * Método setter del atributo fechaFinVigencia de la clase RiesgoClaseDTO
	 *
	 * @param fechaFinVigencia
	 *            the fechaFinVigencia to set
	 */
	public void setFechaFinVigencia(String fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	/**
	 * Método getter del atributo fechaInicioVigencia de la clase RiesgoClaseDTO
	 *
	 * @return the fechaInicioVigencia
	 */
	public String getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	/**
	 * Método setter del atributo fechaInicioVigencia de la clase RiesgoClaseDTO
	 *
	 * @param fechaInicioVigencia
	 *            the fechaInicioVigencia to set
	 */
	public void setFechaInicioVigencia(String fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	/**
	 * Método getter del atributo vigente de la clase RiesgoClaseDTO
	 *
	 * @return the vigente
	 */
	public Integer getVigente() {
		return vigente;
	}

	/**
	 * Método setter del atributo vigente de la clase RiesgoClaseDTO
	 *
	 * @param vigente
	 *            the vigente to set
	 */
	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}

	/**
	 * Método getter del atributo tarifaLimSuperior de la clase RiesgoClaseDTO
	 *
	 * @return the tarifaLimSuperior
	 */
	public BigDecimal getTarifaLimSuperior() {
		return tarifaLimSuperior;
	}

	/**
	 * Método setter del atributo tarifaLimSuperior de la clase RiesgoClaseDTO
	 *
	 * @param tarifaLimSuperior
	 *            the tarifaLimSuperior to set
	 */
	public void setTarifaLimSuperior(BigDecimal tarifaLimSuperior) {
		this.tarifaLimSuperior = tarifaLimSuperior;
	}

	/**
	 * Método getter del atributo tarifaLimInferior de la clase RiesgoClaseDTO
	 *
	 * @return the tarifaLimInferior
	 */
	public BigDecimal getTarifaLimInferior() {
		return tarifaLimInferior;
	}

	/**
	 * Método setter del atributo tarifaLimInferior de la clase RiesgoClaseDTO
	 *
	 * @param tarifaLimInferior
	 *            the tarifaLimInferior to set
	 */
	public void setTarifaLimInferior(BigDecimal tarifaLimInferior) {
		this.tarifaLimInferior = tarifaLimInferior;
	}

	/**
	 * Método getter del atributo tarifa de la clase RiesgoClaseDTO
	 *
	 * @return the tarifa
	 */
	public BigDecimal getTarifa() {
		return tarifa;
	}

	/**
	 * Método setter del atributo tarifa de la clase RiesgoClaseDTO
	 *
	 * @param tarifa
	 *            the tarifa to set
	 */
	public void setTarifa(BigDecimal tarifa) {
		this.tarifa = tarifa;
	}

	/**
	 * Método getter del atributo nombreMostrar de la clase RiesgoClaseDTO
	 *
	 * @return the nombreMostrar
	 */
	public String getNombreMostrar() {
		return nombreMostrar;
	}

	/**
	 * Método setter del atributo nombreMostrar de la clase RiesgoClaseDTO
	 *
	 * @param nombreMostrar
	 *            the nombreMostrar to set
	 */
	public void setNombreMostrar(String nombreMostrar) {
		this.nombreMostrar = nombreMostrar;
	}

	/**
	 * Método getter del atributo nombre de la clase RiesgoClaseDTO
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre de la clase RiesgoClaseDTO
	 *
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter del atributo codigo de la clase RiesgoClaseDTO
	 *
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Método setter del atributo codigo de la clase RiesgoClaseDTO
	 *
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Método getter del atributo idSoiRiesgoClase de la clase RiesgoClaseDTO
	 *
	 * @return the idSoiRiesgoClase
	 */
	public Integer getIdSoiRiesgoClase() {
		return idSoiRiesgoClase;
	}

	/**
	 * Método setter del atributo idSoiRiesgoClase de la clase RiesgoClaseDTO
	 *
	 * @param idSoiRiesgoClase
	 *            the idSoiRiesgoClase to set
	 */
	public void setIdSoiRiesgoClase(Integer idSoiRiesgoClase) {
		this.idSoiRiesgoClase = idSoiRiesgoClase;
	}

}

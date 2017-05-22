package co.swatit.pilautil.dto.out;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link com.ach.pla.biz.transfer.FspTarifaDTO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class FspTarifaDTO implements Serializable {
	/**
	 * Constante de Serialización
	 */
	private static final long serialVersionUID = 1L;
	private Integer idSoiFspTarifa;
	private Integer limInferiorCantSmmlv;
	private Integer limSuperiorCantSmmlv;
	private BigDecimal smmlvInferior;
	private BigDecimal smmlvSuperior;
	private BigDecimal tarifaSolidaridad;
	private BigDecimal tarifaSubsistencia;
	private Integer vigente;
	private String fechaInicioVigencia;
	private String fechaFinVigencia;
	private String comparacionLimiteInferior;
	private String comparacionLimiteSuperior;
	private BigDecimal ibcPension;

	/**
	 * Método getter del atributo idSoiFspTarifa de la clase FspTarifaDTO
	 *
	 * @return the idSoiFspTarifa
	 */
	public Integer getIdSoiFspTarifa() {
		return idSoiFspTarifa;
	}

	/**
	 * Método setter del atributo idSoiFspTarifa de la clase FspTarifaDTO
	 *
	 * @param idSoiFspTarifa
	 *            the idSoiFspTarifa to set
	 */
	public void setIdSoiFspTarifa(Integer idSoiFspTarifa) {
		this.idSoiFspTarifa = idSoiFspTarifa;
	}

	/**
	 * Método getter del atributo limInferiorCantSmmlv de la clase FspTarifaDTO
	 *
	 * @return the limInferiorCantSmmlv
	 */
	public Integer getLimInferiorCantSmmlv() {
		return limInferiorCantSmmlv;
	}

	/**
	 * Método setter del atributo limInferiorCantSmmlv de la clase FspTarifaDTO
	 *
	 * @param limInferiorCantSmmlv
	 *            the limInferiorCantSmmlv to set
	 */
	public void setLimInferiorCantSmmlv(Integer limInferiorCantSmmlv) {
		this.limInferiorCantSmmlv = limInferiorCantSmmlv;
	}

	/**
	 * Método getter del atributo limSuperiorCantSmmlv de la clase FspTarifaDTO
	 *
	 * @return the limSuperiorCantSmmlv
	 */
	public Integer getLimSuperiorCantSmmlv() {
		return limSuperiorCantSmmlv;
	}

	/**
	 * Método setter del atributo limSuperiorCantSmmlv de la clase FspTarifaDTO
	 *
	 * @param limSuperiorCantSmmlv
	 *            the limSuperiorCantSmmlv to set
	 */
	public void setLimSuperiorCantSmmlv(Integer limSuperiorCantSmmlv) {
		this.limSuperiorCantSmmlv = limSuperiorCantSmmlv;
	}

	/**
	 * Método getter del atributo smmlvInferior de la clase FspTarifaDTO
	 *
	 * @return the smmlvInferior
	 */
	public BigDecimal getSmmlvInferior() {
		return smmlvInferior;
	}

	/**
	 * Método setter del atributo smmlvInferior de la clase FspTarifaDTO
	 *
	 * @param smmlvInferior
	 *            the smmlvInferior to set
	 */
	public void setSmmlvInferior(BigDecimal smmlvInferior) {
		this.smmlvInferior = smmlvInferior;
	}

	/**
	 * Método getter del atributo smmlvSuperior de la clase FspTarifaDTO
	 *
	 * @return the smmlvSuperior
	 */
	public BigDecimal getSmmlvSuperior() {
		return smmlvSuperior;
	}

	/**
	 * Método setter del atributo smmlvSuperior de la clase FspTarifaDTO
	 *
	 * @param smmlvSuperior
	 *            the smmlvSuperior to set
	 */
	public void setSmmlvSuperior(BigDecimal smmlvSuperior) {
		this.smmlvSuperior = smmlvSuperior;
	}

	/**
	 * Método getter del atributo tarifaSolidaridad de la clase FspTarifaDTO
	 *
	 * @return the tarifaSolidaridad
	 */
	public BigDecimal getTarifaSolidaridad() {
		return tarifaSolidaridad;
	}

	/**
	 * Método setter del atributo tarifaSolidaridad de la clase FspTarifaDTO
	 *
	 * @param tarifaSolidaridad
	 *            the tarifaSolidaridad to set
	 */
	public void setTarifaSolidaridad(BigDecimal tarifaSolidaridad) {
		this.tarifaSolidaridad = tarifaSolidaridad;
	}

	/**
	 * Método getter del atributo tarifaSubsistencia de la clase FspTarifaDTO
	 *
	 * @return the tarifaSubsistencia
	 */
	public BigDecimal getTarifaSubsistencia() {
		return tarifaSubsistencia;
	}

	/**
	 * Método setter del atributo tarifaSubsistencia de la clase FspTarifaDTO
	 *
	 * @param tarifaSubsistencia
	 *            the tarifaSubsistencia to set
	 */
	public void setTarifaSubsistencia(BigDecimal tarifaSubsistencia) {
		this.tarifaSubsistencia = tarifaSubsistencia;
	}

	/**
	 * Método getter del atributo vigente de la clase FspTarifaDTO
	 *
	 * @return the vigente
	 */
	public Integer getVigente() {
		return vigente;
	}

	/**
	 * Método setter del atributo vigente de la clase FspTarifaDTO
	 *
	 * @param vigente
	 *            the vigente to set
	 */
	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}

	/**
	 * Método getter del atributo fechaInicioVigencia de la clase FspTarifaDTO
	 *
	 * @return the fechaInicioVigencia
	 */
	public String getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	/**
	 * Método setter del atributo fechaInicioVigencia de la clase FspTarifaDTO
	 *
	 * @param fechaInicioVigencia
	 *            the fechaInicioVigencia to set
	 */
	public void setFechaInicioVigencia(String fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	/**
	 * Método getter del atributo fechaFinVigencia de la clase FspTarifaDTO
	 *
	 * @return the fechaFinVigencia
	 */
	public String getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	/**
	 * Método setter del atributo fechaFinVigencia de la clase FspTarifaDTO
	 *
	 * @param fechaFinVigencia
	 *            the fechaFinVigencia to set
	 */
	public void setFechaFinVigencia(String fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	/**
	 * Método getter del atributo comparacionLimiteInferior de la clase FspTarifaDTO
	 *
	 * @return the comparacionLimiteInferior
	 */
	public String getComparacionLimiteInferior() {
		return comparacionLimiteInferior;
	}

	/**
	 * Método setter del atributo comparacionLimiteInferior de la clase FspTarifaDTO
	 *
	 * @param comparacionLimiteInferior
	 *            the comparacionLimiteInferior to set
	 */
	public void setComparacionLimiteInferior(String comparacionLimiteInferior) {
		this.comparacionLimiteInferior = comparacionLimiteInferior;
	}

	/**
	 * Método getter del atributo comparacionLimiteSuperior de la clase FspTarifaDTO
	 *
	 * @return the comparacionLimiteSuperior
	 */
	public String getComparacionLimiteSuperior() {
		return comparacionLimiteSuperior;
	}

	/**
	 * Método setter del atributo comparacionLimiteSuperior de la clase FspTarifaDTO
	 *
	 * @param comparacionLimiteSuperior
	 *            the comparacionLimiteSuperior to set
	 */
	public void setComparacionLimiteSuperior(String comparacionLimiteSuperior) {
		this.comparacionLimiteSuperior = comparacionLimiteSuperior;
	}

	/**
	 * Método getter del atributo ibcPension de la clase FspTarifaDTO
	 *
	 * @return the ibcPension
	 */
	public BigDecimal getIbcPension() {
		return ibcPension;
	}

	/**
	 * Método setter del atributo ibcPension de la clase FspTarifaDTO
	 *
	 * @param ibcPension
	 *            the ibcPension to set
	 */
	public void setIbcPension(BigDecimal ibcPension) {
		this.ibcPension = ibcPension;
	}
}

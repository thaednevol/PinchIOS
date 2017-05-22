package co.swatit.pilautil.dto.out;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo
 * {@link com.ach.cfg.biz.transfer.AdministradoraTarifaDTO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class AdministradoraTarifaDTO implements Serializable {
	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	private AdministradoraDTO administradora;
	private Long idSoiAdmTarifa;
	private Integer vigenteAdmTarifa;
	private String fechaInicioVigAdmTarifa;
	private String fechaFinVigAdmTarifa;
	private BigDecimal tarifa;
	private Integer aplicaPlanillaCorrecciones;

	/**
	 * Método getter del atributo administradora de la clase AdministradoraTarifaDTO
	 *
	 * @return the administradora
	 */
	public AdministradoraDTO getAdministradora() {
		return administradora;
	}

	/**
	 * Método setter del atributo administradora de la clase AdministradoraTarifaDTO
	 *
	 * @param administradora
	 *            the administradora to set
	 */
	public void setAdministradora(AdministradoraDTO administradora) {
		this.administradora = administradora;
	}

	/**
	 * Método getter del atributo idSoiAdmTarifa de la clase AdministradoraTarifaDTO
	 *
	 * @return the idSoiAdmTarifa
	 */
	public Long getIdSoiAdmTarifa() {
		return idSoiAdmTarifa;
	}

	/**
	 * Método setter del atributo idSoiAdmTarifa de la clase AdministradoraTarifaDTO
	 *
	 * @param idSoiAdmTarifa
	 *            the idSoiAdmTarifa to set
	 */
	public void setIdSoiAdmTarifa(Long idSoiAdmTarifa) {
		this.idSoiAdmTarifa = idSoiAdmTarifa;
	}

	/**
	 * Método getter del atributo vigenteAdmTarifa de la clase AdministradoraTarifaDTO
	 *
	 * @return the vigenteAdmTarifa
	 */
	public Integer getVigenteAdmTarifa() {
		return vigenteAdmTarifa;
	}

	/**
	 * Método setter del atributo vigenteAdmTarifa de la clase AdministradoraTarifaDTO
	 *
	 * @param vigenteAdmTarifa
	 *            the vigenteAdmTarifa to set
	 */
	public void setVigenteAdmTarifa(Integer vigenteAdmTarifa) {
		this.vigenteAdmTarifa = vigenteAdmTarifa;
	}

	/**
	 * Método getter del atributo fechaInicioVigAdmTarifa de la clase AdministradoraTarifaDTO
	 *
	 * @return the fechaInicioVigAdmTarifa
	 */
	public String getFechaInicioVigAdmTarifa() {
		return fechaInicioVigAdmTarifa;
	}

	/**
	 * Método setter del atributo fechaInicioVigAdmTarifa de la clase AdministradoraTarifaDTO
	 *
	 * @param fechaInicioVigAdmTarifa
	 *            the fechaInicioVigAdmTarifa to set
	 */
	public void setFechaInicioVigAdmTarifa(String fechaInicioVigAdmTarifa) {
		this.fechaInicioVigAdmTarifa = fechaInicioVigAdmTarifa;
	}

	/**
	 * Método getter del atributo fechaFinVigAdmTarifa de la clase AdministradoraTarifaDTO
	 *
	 * @return the fechaFinVigAdmTarifa
	 */
	public String getFechaFinVigAdmTarifa() {
		return fechaFinVigAdmTarifa;
	}

	/**
	 * Método setter del atributo fechaFinVigAdmTarifa de la clase AdministradoraTarifaDTO
	 *
	 * @param fechaFinVigAdmTarifa
	 *            the fechaFinVigAdmTarifa to set
	 */
	public void setFechaFinVigAdmTarifa(String fechaFinVigAdmTarifa) {
		this.fechaFinVigAdmTarifa = fechaFinVigAdmTarifa;
	}

	/**
	 * Método getter del atributo tarifa de la clase AdministradoraTarifaDTO
	 *
	 * @return the tarifa
	 */
	public BigDecimal getTarifa() {
		return tarifa;
	}

	/**
	 * Método setter del atributo tarifa de la clase AdministradoraTarifaDTO
	 *
	 * @param tarifa
	 *            the tarifa to set
	 */
	public void setTarifa(BigDecimal tarifa) {
		this.tarifa = tarifa;
	}

	/**
	 * Método getter del atributo aplicaPlanillaCorrecciones de la clase AdministradoraTarifaDTO
	 *
	 * @return the aplicaPlanillaCorrecciones
	 */
	public Integer getAplicaPlanillaCorrecciones() {
		return aplicaPlanillaCorrecciones;
	}

	/**
	 * Método setter del atributo aplicaPlanillaCorrecciones de la clase AdministradoraTarifaDTO
	 *
	 * @param aplicaPlanillaCorrecciones
	 *            the aplicaPlanillaCorrecciones to set
	 */
	public void setAplicaPlanillaCorrecciones(Integer aplicaPlanillaCorrecciones) {
		this.aplicaPlanillaCorrecciones = aplicaPlanillaCorrecciones;
	}

}

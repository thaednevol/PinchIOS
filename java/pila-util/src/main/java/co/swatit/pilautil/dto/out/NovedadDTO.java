/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de transporte resultado de la conversión de objetos {@link com.ach.pla.biz.transfer.NovedadDTO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 7/04/2017
 * @version 1.0
 */
public class NovedadDTO implements Serializable {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	private String tipoNovedad;
	private Integer diaING;
	private String tipoING;
	private Integer diaRET;
	private String tipoRET;
	private Integer idAdministradora;
	private String codAdministradora;
	private String nombreAdministradora;
	private List<VariacionSalarioDTO> variacionesVSP;
	private Boolean ultimaVSP;
	private List<VariacionSalarioDTO> variacionesVST;
	private Boolean ultimaVST;
	private List<VariacionSalarioDTO> variacionesSLN;
	private Boolean ultimaSLN;
	private List<VariacionSalarioDTO> variacionesCOM;
	private Boolean ultimaCOM;
	private Integer diaInicial;
	private Integer diaFinal;
	private BigDecimal ibcNovedad;
	private BigDecimal tarifaSalud;
	private Boolean aportaPensionSLN;
	private BigDecimal porcentajeIGE;
	private Long aporteAportante;
	private Long aporteCotizante;
	private Long valorNoRetenido;
	private String tipoCorreccion;
	private String tipoSLN;
	private String fechaDeInicio;
	private String fechaDeFin;
	private Boolean calculosDiasIBC;
	private String tipoVacaciones;
	private BigDecimal ibcCalculadoNovedad;
	private List<VariacionSalarioDTO> variacionesRegMultiple;

	/**
	 * Método getter del atributo tipoNovedad de la clase NovedadDTO
	 *
	 * @return the tipoNovedad
	 */
	public String getTipoNovedad() {
		return tipoNovedad;
	}

	/**
	 * Método setter del atributo tipoNovedad de la clase NovedadDTO
	 *
	 * @param tipoNovedad
	 *            the tipoNovedad to set
	 */
	public void setTipoNovedad(String tipoNovedad) {
		this.tipoNovedad = tipoNovedad;
	}

	/**
	 * Método getter del atributo diaING de la clase NovedadDTO
	 *
	 * @return the diaING
	 */
	public Integer getDiaING() {
		return diaING;
	}

	/**
	 * Método setter del atributo diaING de la clase NovedadDTO
	 *
	 * @param diaING
	 *            the diaING to set
	 */
	public void setDiaING(Integer diaING) {
		this.diaING = diaING;
	}

	/**
	 * Método getter del atributo tipoING de la clase NovedadDTO
	 *
	 * @return the tipoING
	 */
	public String getTipoING() {
		return tipoING;
	}

	/**
	 * Método setter del atributo tipoING de la clase NovedadDTO
	 *
	 * @param tipoING
	 *            the tipoING to set
	 */
	public void setTipoING(String tipoING) {
		this.tipoING = tipoING;
	}

	/**
	 * Método getter del atributo diaRET de la clase NovedadDTO
	 *
	 * @return the diaRET
	 */
	public Integer getDiaRET() {
		return diaRET;
	}

	/**
	 * Método setter del atributo diaRET de la clase NovedadDTO
	 *
	 * @param diaRET
	 *            the diaRET to set
	 */
	public void setDiaRET(Integer diaRET) {
		this.diaRET = diaRET;
	}

	/**
	 * Método getter del atributo tipoRET de la clase NovedadDTO
	 *
	 * @return the tipoRET
	 */
	public String getTipoRET() {
		return tipoRET;
	}

	/**
	 * Método setter del atributo tipoRET de la clase NovedadDTO
	 *
	 * @param tipoRET
	 *            the tipoRET to set
	 */
	public void setTipoRET(String tipoRET) {
		this.tipoRET = tipoRET;
	}

	/**
	 * Método getter del atributo idAdministradora de la clase NovedadDTO
	 *
	 * @return the idAdministradora
	 */
	public Integer getIdAdministradora() {
		return idAdministradora;
	}

	/**
	 * Método setter del atributo idAdministradora de la clase NovedadDTO
	 *
	 * @param idAdministradora
	 *            the idAdministradora to set
	 */
	public void setIdAdministradora(Integer idAdministradora) {
		this.idAdministradora = idAdministradora;
	}

	/**
	 * Método getter del atributo codAdministradora de la clase NovedadDTO
	 *
	 * @return the codAdministradora
	 */
	public String getCodAdministradora() {
		return codAdministradora;
	}

	/**
	 * Método setter del atributo codAdministradora de la clase NovedadDTO
	 *
	 * @param codAdministradora
	 *            the codAdministradora to set
	 */
	public void setCodAdministradora(String codAdministradora) {
		this.codAdministradora = codAdministradora;
	}

	/**
	 * Método getter del atributo nombreAdministradora de la clase NovedadDTO
	 *
	 * @return the nombreAdministradora
	 */
	public String getNombreAdministradora() {
		return nombreAdministradora;
	}

	/**
	 * Método setter del atributo nombreAdministradora de la clase NovedadDTO
	 *
	 * @param nombreAdministradora
	 *            the nombreAdministradora to set
	 */
	public void setNombreAdministradora(String nombreAdministradora) {
		this.nombreAdministradora = nombreAdministradora;
	}

	/**
	 * Método getter del atributo variacionesVSP de la clase NovedadDTO
	 *
	 * @return the variacionesVSP
	 */
	public List<VariacionSalarioDTO> getVariacionesVSP() {
		if (variacionesVSP == null) {
			variacionesVSP = new ArrayList<VariacionSalarioDTO>();
		}
		return variacionesVSP;
	}

	/**
	 * Método getter del atributo ultimaVSP de la clase NovedadDTO
	 *
	 * @return the ultimaVSP
	 */
	public Boolean getUltimaVSP() {
		return ultimaVSP;
	}

	/**
	 * Método setter del atributo ultimaVSP de la clase NovedadDTO
	 *
	 * @param ultimaVSP
	 *            the ultimaVSP to set
	 */
	public void setUltimaVSP(Boolean ultimaVSP) {
		this.ultimaVSP = ultimaVSP;
	}

	/**
	 * Método getter del atributo variacionesVST de la clase NovedadDTO
	 *
	 * @return the variacionesVST
	 */
	public List<VariacionSalarioDTO> getVariacionesVST() {
		if (variacionesVST == null) {
			variacionesVST = new ArrayList<VariacionSalarioDTO>();
		}
		return variacionesVST;
	}

	/**
	 * Método getter del atributo ultimaVST de la clase NovedadDTO
	 *
	 * @return the ultimaVST
	 */
	public Boolean getUltimaVST() {
		return ultimaVST;
	}

	/**
	 * Método setter del atributo ultimaVST de la clase NovedadDTO
	 *
	 * @param ultimaVST
	 *            the ultimaVST to set
	 */
	public void setUltimaVST(Boolean ultimaVST) {
		this.ultimaVST = ultimaVST;
	}

	/**
	 * Método getter del atributo variacionesSLN de la clase NovedadDTO
	 *
	 * @return the variacionesSLN
	 */
	public List<VariacionSalarioDTO> getVariacionesSLN() {
		if (variacionesSLN == null) {
			variacionesSLN = new ArrayList<VariacionSalarioDTO>();
		}
		return variacionesSLN;
	}

	/**
	 * Método getter del atributo ultimaSLN de la clase NovedadDTO
	 *
	 * @return the ultimaSLN
	 */
	public Boolean getUltimaSLN() {
		return ultimaSLN;
	}

	/**
	 * Método setter del atributo ultimaSLN de la clase NovedadDTO
	 *
	 * @param ultimaSLN
	 *            the ultimaSLN to set
	 */
	public void setUltimaSLN(Boolean ultimaSLN) {
		this.ultimaSLN = ultimaSLN;
	}

	/**
	 * Método getter del atributo variacionesCOM de la clase NovedadDTO
	 *
	 * @return the variacionesCOM
	 */
	public List<VariacionSalarioDTO> getVariacionesCOM() {
		if (variacionesCOM == null) {
			variacionesCOM = new ArrayList<VariacionSalarioDTO>();
		}
		return variacionesCOM;
	}

	/**
	 * Método getter del atributo ultimaCOM de la clase NovedadDTO
	 *
	 * @return the ultimaCOM
	 */
	public Boolean getUltimaCOM() {
		return ultimaCOM;
	}

	/**
	 * Método setter del atributo ultimaCOM de la clase NovedadDTO
	 *
	 * @param ultimaCOM
	 *            the ultimaCOM to set
	 */
	public void setUltimaCOM(Boolean ultimaCOM) {
		this.ultimaCOM = ultimaCOM;
	}

	/**
	 * Método getter del atributo diaInicial de la clase NovedadDTO
	 *
	 * @return the diaInicial
	 */
	public Integer getDiaInicial() {
		return diaInicial;
	}

	/**
	 * Método setter del atributo diaInicial de la clase NovedadDTO
	 *
	 * @param diaInicial
	 *            the diaInicial to set
	 */
	public void setDiaInicial(Integer diaInicial) {
		this.diaInicial = diaInicial;
	}

	/**
	 * Método getter del atributo diaFinal de la clase NovedadDTO
	 *
	 * @return the diaFinal
	 */
	public Integer getDiaFinal() {
		return diaFinal;
	}

	/**
	 * Método setter del atributo diaFinal de la clase NovedadDTO
	 *
	 * @param diaFinal
	 *            the diaFinal to set
	 */
	public void setDiaFinal(Integer diaFinal) {
		this.diaFinal = diaFinal;
	}

	/**
	 * Método getter del atributo ibcNovedad de la clase NovedadDTO
	 *
	 * @return the ibcNovedad
	 */
	public BigDecimal getIbcNovedad() {
		return ibcNovedad;
	}

	/**
	 * Método setter del atributo ibcNovedad de la clase NovedadDTO
	 *
	 * @param ibcNovedad
	 *            the ibcNovedad to set
	 */
	public void setIbcNovedad(BigDecimal ibcNovedad) {
		this.ibcNovedad = ibcNovedad;
	}

	/**
	 * Método getter del atributo tarifaSalud de la clase NovedadDTO
	 *
	 * @return the tarifaSalud
	 */
	public BigDecimal getTarifaSalud() {
		return tarifaSalud;
	}

	/**
	 * Método setter del atributo tarifaSalud de la clase NovedadDTO
	 *
	 * @param tarifaSalud
	 *            the tarifaSalud to set
	 */
	public void setTarifaSalud(BigDecimal tarifaSalud) {
		this.tarifaSalud = tarifaSalud;
	}

	/**
	 * Método getter del atributo aportaPensionSLN de la clase NovedadDTO
	 *
	 * @return the aportaPensionSLN
	 */
	public Boolean getAportaPensionSLN() {
		return aportaPensionSLN;
	}

	/**
	 * Método setter del atributo aportaPensionSLN de la clase NovedadDTO
	 *
	 * @param aportaPensionSLN
	 *            the aportaPensionSLN to set
	 */
	public void setAportaPensionSLN(Boolean aportaPensionSLN) {
		this.aportaPensionSLN = aportaPensionSLN;
	}

	/**
	 * Método getter del atributo porcentajeIGE de la clase NovedadDTO
	 *
	 * @return the porcentajeIGE
	 */
	public BigDecimal getPorcentajeIGE() {
		return porcentajeIGE;
	}

	/**
	 * Método setter del atributo porcentajeIGE de la clase NovedadDTO
	 *
	 * @param porcentajeIGE
	 *            the porcentajeIGE to set
	 */
	public void setPorcentajeIGE(BigDecimal porcentajeIGE) {
		this.porcentajeIGE = porcentajeIGE;
	}

	/**
	 * Método getter del atributo aporteAportante de la clase NovedadDTO
	 *
	 * @return the aporteAportante
	 */
	public Long getAporteAportante() {
		return aporteAportante;
	}

	/**
	 * Método setter del atributo aporteAportante de la clase NovedadDTO
	 *
	 * @param aporteAportante
	 *            the aporteAportante to set
	 */
	public void setAporteAportante(Long aporteAportante) {
		this.aporteAportante = aporteAportante;
	}

	/**
	 * Método getter del atributo aporteCotizante de la clase NovedadDTO
	 *
	 * @return the aporteCotizante
	 */
	public Long getAporteCotizante() {
		return aporteCotizante;
	}

	/**
	 * Método setter del atributo aporteCotizante de la clase NovedadDTO
	 *
	 * @param aporteCotizante
	 *            the aporteCotizante to set
	 */
	public void setAporteCotizante(Long aporteCotizante) {
		this.aporteCotizante = aporteCotizante;
	}

	/**
	 * Método getter del atributo valorNoRetenido de la clase NovedadDTO
	 *
	 * @return the valorNoRetenido
	 */
	public Long getValorNoRetenido() {
		return valorNoRetenido;
	}

	/**
	 * Método setter del atributo valorNoRetenido de la clase NovedadDTO
	 *
	 * @param valorNoRetenido
	 *            the valorNoRetenido to set
	 */
	public void setValorNoRetenido(Long valorNoRetenido) {
		this.valorNoRetenido = valorNoRetenido;
	}

	/**
	 * Método getter del atributo tipoCorreccion de la clase NovedadDTO
	 *
	 * @return the tipoCorreccion
	 */
	public String getTipoCorreccion() {
		return tipoCorreccion;
	}

	/**
	 * Método setter del atributo tipoCorreccion de la clase NovedadDTO
	 *
	 * @param tipoCorreccion
	 *            the tipoCorreccion to set
	 */
	public void setTipoCorreccion(String tipoCorreccion) {
		this.tipoCorreccion = tipoCorreccion;
	}

	/**
	 * Método getter del atributo tipoSLN de la clase NovedadDTO
	 *
	 * @return the tipoSLN
	 */
	public String getTipoSLN() {
		return tipoSLN;
	}

	/**
	 * Método setter del atributo tipoSLN de la clase NovedadDTO
	 *
	 * @param tipoSLN
	 *            the tipoSLN to set
	 */
	public void setTipoSLN(String tipoSLN) {
		this.tipoSLN = tipoSLN;
	}

	/**
	 * Método getter del atributo fechaDeInicio de la clase NovedadDTO
	 *
	 * @return the fechaDeInicio
	 */
	public String getFechaDeInicio() {
		return fechaDeInicio;
	}

	/**
	 * Método setter del atributo fechaDeInicio de la clase NovedadDTO
	 *
	 * @param fechaDeInicio
	 *            the fechaDeInicio to set
	 */
	public void setFechaDeInicio(String fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}

	/**
	 * Método getter del atributo fechaDeFin de la clase NovedadDTO
	 *
	 * @return the fechaDeFin
	 */
	public String getFechaDeFin() {
		return fechaDeFin;
	}

	/**
	 * Método setter del atributo fechaDeFin de la clase NovedadDTO
	 *
	 * @param fechaDeFin
	 *            the fechaDeFin to set
	 */
	public void setFechaDeFin(String fechaDeFin) {
		this.fechaDeFin = fechaDeFin;
	}

	/**
	 * Método getter del atributo calculosDiasIBC de la clase NovedadDTO
	 *
	 * @return the calculosDiasIBC
	 */
	public Boolean getCalculosDiasIBC() {
		return calculosDiasIBC;
	}

	/**
	 * Método setter del atributo calculosDiasIBC de la clase NovedadDTO
	 *
	 * @param calculosDiasIBC
	 *            the calculosDiasIBC to set
	 */
	public void setCalculosDiasIBC(Boolean calculosDiasIBC) {
		this.calculosDiasIBC = calculosDiasIBC;
	}

	/**
	 * Método getter del atributo tipoVacaciones de la clase NovedadDTO
	 *
	 * @return the tipoVacaciones
	 */
	public String getTipoVacaciones() {
		return tipoVacaciones;
	}

	/**
	 * Método setter del atributo tipoVacaciones de la clase NovedadDTO
	 *
	 * @param tipoVacaciones
	 *            the tipoVacaciones to set
	 */
	public void setTipoVacaciones(String tipoVacaciones) {
		this.tipoVacaciones = tipoVacaciones;
	}

	/**
	 * Método getter del atributo ibcCalculadoNovedad de la clase NovedadDTO
	 *
	 * @return the ibcCalculadoNovedad
	 */
	public BigDecimal getIbcCalculadoNovedad() {
		return ibcCalculadoNovedad;
	}

	/**
	 * Método setter del atributo ibcCalculadoNovedad de la clase NovedadDTO
	 *
	 * @param ibcCalculadoNovedad
	 *            the ibcCalculadoNovedad to set
	 */
	public void setIbcCalculadoNovedad(BigDecimal ibcCalculadoNovedad) {
		this.ibcCalculadoNovedad = ibcCalculadoNovedad;
	}

	/**
	 * Método getter del atributo variacionesRegMultiple de la clase NovedadDTO
	 *
	 * @return the variacionesRegMultiple
	 */
	public List<VariacionSalarioDTO> getVariacionesRegMultiple() {
		if (variacionesRegMultiple == null) {
			variacionesRegMultiple = new ArrayList<VariacionSalarioDTO>();
		}
		return variacionesRegMultiple;
	}

}

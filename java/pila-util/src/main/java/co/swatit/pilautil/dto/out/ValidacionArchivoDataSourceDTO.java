/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ach.arc.biz.r1747.util.ValidacionArchivoDataSource;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link ValidacionArchivoDataSource}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class ValidacionArchivoDataSourceDTO implements Serializable {
	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	private List<AplicabilidadDTO> registrosAplicabilidadApte;
	private List<AplicabilidadDTO> tiposCotizante;
	private List<AplicabilidadDTO> subtiposCotizante;
	private List<AplicabilidadDTO> extranjerias;
	private List<ObligatoriedadTipoCotizanteDTO> obligatoriedadesTipoCotizante;
	private List<ObligatoriedadSubTipoCotizanteDTO> obligatoriedadesSubTipoCotizante;
	private List<ObligatoriedadSubTipoCotizanteDTO> obligatoriedadesExtranjeria;
	private List<ObligatoriedadAportanteDTO> obligatoriedadesAportante;
	private Map<String, List<BigDecimal>> tarifasPfGenerales;
	private Map<String, List<BigDecimal>> tarifasPfIndependientes;
	private Map<String, String> administradorasCcfMunicipios;
	private List<AdministradoraTarifaDTO> administradorasPension;
	private List<AdministradoraTarifaDTO> administradorasSalud;
	private List<AdministradoraTarifaDTO> administradorasSaludLey1607;
	private List<AdministradoraTarifaDTO> administradorasTarifasSLN;
	private AportanteDTO aportanteDTO;
	private BigDecimal topeSalarioIntegral;
	private String tpCotizante;
	private PlanillaAportanteDTO planillaApteDto;
	private List<BigDecimal> tarifaCcfGeneral;
	private List<BigDecimal> tarifaCcfIndependiente;
	private AportanteFilialDTO aportanteFilialDto;
	private Map<String, AdministradoraDTO> administradorasParafiscales;
	private Map<String, DepartamentoDTO> departamentosMap;
	private Map<String, MunicipioDTO> municipiosMap;
	private Map<Integer, ParametroDTO> parametrosLiquidacion;
	private List<SeccionalFiscaliaDTO> seccionalesFiscalia;
	private List<TipoIdentificacionDTO> tiposDocumentosCotizantes;
	private Map<String, List<TipoIdentificacionDTO>> tiposDocumentoPorTipoCotizante;
	private Map<Integer, TipoCotizanteDTO> tiposCotizanteMap;
	private Map<Integer, SubTipoCotizanteDTO> subtiposCotizanteMap;
	private Map<Integer, SubTipoCotizanteDTO> extranjeriaCotizanteMap;
	private List<String> codTpsCotizanteDependientesNr415;
	private List<String> listadoAdminTarifasEspeciales;
	private List<BigDecimal> tarifasEspeciales;
	private List<BigDecimal> tarifasEspecialesSln;
	private List<FspTarifaDTO> tarifasFsp;
	private Map<String, String> propiedadesNec160Map;
	private List<RiesgoClaseDTO> clasesRiesgo;
	private TimelyPaydayDTO timelyPaydayDTO;
	private List<AdministradoraDTO> administradorasRiesgoYCcf;
	private String fechaPagoOportuno;
	private Map<String, String> properties;
	
	private Collection<AplicabilidadDTO> tiposPlanillaApte = null;

	/**
	 * Método getter del atributo registrosAplicabilidadApte de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the registrosAplicabilidadApte
	 */
	public List<AplicabilidadDTO> getRegistrosAplicabilidadApte() {
		if (registrosAplicabilidadApte == null) {
			registrosAplicabilidadApte = new ArrayList<AplicabilidadDTO>();
		}
		return registrosAplicabilidadApte;
	}

	/**
	 * Método getter del atributo tiposCotizante de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the tiposCotizante
	 */
	public List<AplicabilidadDTO> getTiposCotizante() {
		if (tiposCotizante == null) {
			tiposCotizante = new ArrayList<AplicabilidadDTO>();
		}
		return tiposCotizante;
	}

	/**
	 * Método getter del atributo subtiposCotizante de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the subtiposCotizante
	 */
	public List<AplicabilidadDTO> getSubtiposCotizante() {
		if (subtiposCotizante == null) {
			subtiposCotizante = new ArrayList<AplicabilidadDTO>();
		}
		return subtiposCotizante;
	}

	/**
	 * Método getter del atributo extranjerias de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the extranjerias
	 */
	public List<AplicabilidadDTO> getExtranjerias() {
		if (extranjerias == null) {
			extranjerias = new ArrayList<AplicabilidadDTO>();
		}
		return extranjerias;
	}

	/**
	 * Método getter del atributo obligatoriedadesTipoCotizante de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the obligatoriedadesTipoCotizante
	 */
	public List<ObligatoriedadTipoCotizanteDTO> getObligatoriedadesTipoCotizante() {
		if (obligatoriedadesTipoCotizante == null) {
			obligatoriedadesTipoCotizante = new ArrayList<ObligatoriedadTipoCotizanteDTO>();
		}
		return obligatoriedadesTipoCotizante;
	}

	/**
	 * Método getter del atributo obligatoriedadesSubTipoCotizante de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the obligatoriedadesSubTipoCotizante
	 */
	public List<ObligatoriedadSubTipoCotizanteDTO> getObligatoriedadesSubTipoCotizante() {
		if (obligatoriedadesSubTipoCotizante == null) {
			obligatoriedadesSubTipoCotizante = new ArrayList<ObligatoriedadSubTipoCotizanteDTO>();
		}
		return obligatoriedadesSubTipoCotizante;
	}

	/**
	 * Método getter del atributo obligatoriedadesExtranjeria de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the obligatoriedadesExtranjeria
	 */
	public List<ObligatoriedadSubTipoCotizanteDTO> getObligatoriedadesExtranjeria() {
		if (obligatoriedadesExtranjeria == null) {
			obligatoriedadesExtranjeria = new ArrayList<ObligatoriedadSubTipoCotizanteDTO>();
		}
		return obligatoriedadesExtranjeria;
	}

	/**
	 * Método getter del atributo obligatoriedadesAportante de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the obligatoriedadesAportante
	 */
	public List<ObligatoriedadAportanteDTO> getObligatoriedadesAportante() {
		if (obligatoriedadesAportante == null) {
			obligatoriedadesAportante = new ArrayList<ObligatoriedadAportanteDTO>();
		}
		return obligatoriedadesAportante;
	}

	/**
	 * Método getter del atributo tarifasPfGenerales de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the tarifasPfGenerales
	 */
	public Map<String, List<BigDecimal>> getTarifasPfGenerales() {
		if (tarifasPfGenerales == null) {
			tarifasPfGenerales = new HashMap<String, List<BigDecimal>>();
		}
		return tarifasPfGenerales;
	}

	/**
	 * Método getter del atributo tarifasPfIndependientes de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the tarifasPfIndependientes
	 */
	public Map<String, List<BigDecimal>> getTarifasPfIndependientes() {
		if (tarifasPfIndependientes == null) {
			tarifasPfIndependientes = new HashMap<String, List<BigDecimal>>();
		}
		return tarifasPfIndependientes;
	}

	/**
	 * Método getter del atributo administradorasCcfMunicipios de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the administradorasCcfMunicipios
	 */
	public Map<String, String> getAdministradorasCcfMunicipios() {
		if (administradorasCcfMunicipios == null) {
			administradorasCcfMunicipios = new HashMap<String, String>();
		}
		return administradorasCcfMunicipios;
	}

	/**
	 * Método getter del atributo administradorasPension de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the administradorasPension
	 */
	public List<AdministradoraTarifaDTO> getAdministradorasPension() {
		if (administradorasPension == null) {
			administradorasPension = new ArrayList<AdministradoraTarifaDTO>();
		}
		return administradorasPension;
	}

	/**
	 * Método getter del atributo administradorasSalud de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the administradorasSalud
	 */
	public List<AdministradoraTarifaDTO> getAdministradorasSalud() {
		if (administradorasSalud == null) {
			administradorasSalud = new ArrayList<AdministradoraTarifaDTO>();
		}
		return administradorasSalud;
	}

	/**
	 * Método getter del atributo administradorasSaludLey1607 de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the administradorasSaludLey1607
	 */
	public List<AdministradoraTarifaDTO> getAdministradorasSaludLey1607() {
		if (administradorasSaludLey1607 == null) {
			administradorasSaludLey1607 = new ArrayList<AdministradoraTarifaDTO>();
		}
		return administradorasSaludLey1607;
	}
	

	public List<AdministradoraTarifaDTO> getAdministradorasTarifasSLN() {
		if (administradorasTarifasSLN == null) {
			administradorasTarifasSLN = new ArrayList<AdministradoraTarifaDTO>();
		}
		return administradorasTarifasSLN;
	}

	/**
	 * Método getter del atributo aportanteDTO de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the aportanteDTO
	 */
	public AportanteDTO getAportanteDTO() {
		return aportanteDTO;
	}

	/**
	 * Método setter del atributo aportanteDTO de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @param aportanteDTO
	 *            the aportanteDTO to set
	 */
	public void setAportanteDTO(AportanteDTO aportanteDTO) {
		this.aportanteDTO = aportanteDTO;
	}

	/**
	 * Método getter del atributo topeSalarioIntegral de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the topeSalarioIntegral
	 */
	public BigDecimal getTopeSalarioIntegral() {
		return topeSalarioIntegral;
	}

	/**
	 * Método setter del atributo topeSalarioIntegral de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @param topeSalarioIntegral
	 *            the topeSalarioIntegral to set
	 */
	public void setTopeSalarioIntegral(BigDecimal topeSalarioIntegral) {
		this.topeSalarioIntegral = topeSalarioIntegral;
	}

	/**
	 * Método getter del atributo tpCotizante de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the tpCotizante
	 */
	public String getTpCotizante() {
		return tpCotizante;
	}

	/**
	 * Método setter del atributo tpCotizante de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @param tpCotizante
	 *            the tpCotizante to set
	 */
	public void setTpCotizante(String tpCotizante) {
		this.tpCotizante = tpCotizante;
	}

	/**
	 * Método getter del atributo planillaApteDto de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the planillaApteDto
	 */
	public PlanillaAportanteDTO getPlanillaApteDto() {
		return planillaApteDto;
	}

	/**
	 * Método setter del atributo planillaApteDto de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @param planillaApteDto
	 *            the planillaApteDto to set
	 */
	public void setPlanillaApteDto(PlanillaAportanteDTO planillaApteDto) {
		this.planillaApteDto = planillaApteDto;
	}

	/**
	 * Método getter del atributo tarifaCcfGeneral de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the tarifaCcfGeneral
	 */
	public List<BigDecimal> getTarifaCcfGeneral() {
		if (tarifaCcfGeneral == null) {
			tarifaCcfGeneral = new ArrayList<BigDecimal>();
		}
		return tarifaCcfGeneral;
	}

	/**
	 * Método getter del atributo tarifaCcfIndependiente de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the tarifaCcfIndependiente
	 */
	public List<BigDecimal> getTarifaCcfIndependiente() {
		if (tarifaCcfIndependiente == null) {
			tarifaCcfIndependiente = new ArrayList<BigDecimal>();
		}
		return tarifaCcfIndependiente;
	}

	/**
	 * Método getter del atributo aportanteFilialDto de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the aportanteFilialDto
	 */
	public AportanteFilialDTO getAportanteFilialDto() {
		return aportanteFilialDto;
	}

	/**
	 * Método setter del atributo aportanteFilialDto de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @param aportanteFilialDto
	 *            the aportanteFilialDto to set
	 */
	public void setAportanteFilialDto(AportanteFilialDTO aportanteFilialDto) {
		this.aportanteFilialDto = aportanteFilialDto;
	}

	/**
	 * Método getter del atributo administradorasParafiscales de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the administradorasParafiscales
	 */
	public Map<String, AdministradoraDTO> getAdministradorasParafiscales() {
		if (administradorasParafiscales == null) {
			administradorasParafiscales = new HashMap<String, AdministradoraDTO>();
		}
		return administradorasParafiscales;
	}

	/**
	 * Método getter del atributo departamentosMap de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the departamentosMap
	 */
	public Map<String, DepartamentoDTO> getDepartamentosMap() {
		if (departamentosMap == null) {
			departamentosMap = new HashMap<String, DepartamentoDTO>();
		}
		return departamentosMap;
	}

	/**
	 * Método getter del atributo municipiosMap de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the municipiosMap
	 */
	public Map<String, MunicipioDTO> getMunicipiosMap() {
		if (municipiosMap == null) {
			municipiosMap = new HashMap<String, MunicipioDTO>();
		}
		return municipiosMap;
	}

	/**
	 * Método getter del atributo parametrosLiquidacion de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the parametrosLiquidacion
	 */
	public Map<Integer, ParametroDTO> getParametrosLiquidacion() {
		if (parametrosLiquidacion == null) {
			parametrosLiquidacion = new HashMap<Integer, ParametroDTO>();
		}
		return parametrosLiquidacion;
	}

	/**
	 * Método getter del atributo seccionalesFiscalia de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the seccionalesFiscalia
	 */
	public List<SeccionalFiscaliaDTO> getSeccionalesFiscalia() {
		if (seccionalesFiscalia == null) {
			seccionalesFiscalia = new ArrayList<SeccionalFiscaliaDTO>();
		}
		return seccionalesFiscalia;
	}

	/**
	 * Método getter del atributo tiposDocumentosCotizantes de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the tiposDocumentosCotizantes
	 */
	public List<TipoIdentificacionDTO> getTiposDocumentosCotizantes() {
		if (tiposDocumentosCotizantes == null) {
			tiposDocumentosCotizantes = new ArrayList<TipoIdentificacionDTO>();
		}
		return tiposDocumentosCotizantes;
	}

	/**
	 * Método getter del atributo tiposDocumentoPorTipoCotizante de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the tiposDocumentoPorTipoCotizante
	 */
	public Map<String, List<TipoIdentificacionDTO>> getTiposDocumentoPorTipoCotizante() {
		if (tiposDocumentoPorTipoCotizante == null) {
			tiposDocumentoPorTipoCotizante = new HashMap<String, List<TipoIdentificacionDTO>>();
		}
		return tiposDocumentoPorTipoCotizante;
	}

	/**
	 * Método getter del atributo tiposCotizanteMap de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the tiposCotizanteMap
	 */
	public Map<Integer, TipoCotizanteDTO> getTiposCotizanteMap() {
		if (tiposCotizanteMap == null) {
			tiposCotizanteMap = new HashMap<Integer, TipoCotizanteDTO>();
		}
		return tiposCotizanteMap;
	}

	/**
	 * Método getter del atributo subtiposCotizanteMap de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the subtiposCotizanteMap
	 */
	public Map<Integer, SubTipoCotizanteDTO> getSubtiposCotizanteMap() {
		if (subtiposCotizanteMap == null) {
			subtiposCotizanteMap = new HashMap<Integer, SubTipoCotizanteDTO>();
		}
		return subtiposCotizanteMap;
	}

	/**
	 * Método getter del atributo extranjeriaCotizanteMap de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the extranjeriaCotizanteMap
	 */
	public Map<Integer, SubTipoCotizanteDTO> getExtranjeriaCotizanteMap() {
		if (extranjeriaCotizanteMap == null) {
			extranjeriaCotizanteMap = new HashMap<Integer, SubTipoCotizanteDTO>();
		}
		return extranjeriaCotizanteMap;
	}

	/**
	 * Método getter del atributo codTpsCotizanteDependientesNr415 de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the codTpsCotizanteDependientesNr415
	 */
	public List<String> getCodTpsCotizanteDependientesNr415() {
		if (codTpsCotizanteDependientesNr415 == null) {
			codTpsCotizanteDependientesNr415 = new ArrayList<String>();
		}
		return codTpsCotizanteDependientesNr415;
	}

	/**
	 * Método getter del atributo listadoAdminTarifasEspeciales de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the listadoAdminTarifasEspeciales
	 */
	public List<String> getListadoAdminTarifasEspeciales() {
		if (listadoAdminTarifasEspeciales == null) {
			listadoAdminTarifasEspeciales = new ArrayList<String>();
		}
		return listadoAdminTarifasEspeciales;
	}

	/**
	 * Método getter del atributo tarifasEspeciales de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the tarifasEspeciales
	 */
	public List<BigDecimal> getTarifasEspeciales() {
		if (tarifasEspeciales == null) {
			tarifasEspeciales = new ArrayList<BigDecimal>();
		}
		return tarifasEspeciales;
	}

	/**
	 * Método getter del atributo tarifasEspecialesSln de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the tarifasEspecialesSln
	 */
	public List<BigDecimal> getTarifasEspecialesSln() {
		if (tarifasEspecialesSln == null) {
			tarifasEspecialesSln = new ArrayList<BigDecimal>();
		}
		return tarifasEspecialesSln;
	}

	/**
	 * Método getter del atributo tarifasFsp de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the tarifasFsp
	 */
	public List<FspTarifaDTO> getTarifasFsp() {
		if (tarifasFsp == null) {
			tarifasFsp = new ArrayList<FspTarifaDTO>();
		}
		return tarifasFsp;
	}

	/**
	 * Método getter del atributo propiedadesNec160Map de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the propiedadesNec160Map
	 */
	public Map<String, String> getPropiedadesNec160Map() {
		if (propiedadesNec160Map == null) {
			propiedadesNec160Map = new HashMap<String, String>();
		}
		return propiedadesNec160Map;
	}

	/**
	 * Método getter del atributo clasesRiesgo de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the clasesRiesgo
	 */
	public List<RiesgoClaseDTO> getClasesRiesgo() {
		if (clasesRiesgo == null) {
			clasesRiesgo = new ArrayList<RiesgoClaseDTO>();
		}
		return clasesRiesgo;
	}

	/**
	 * Método getter del atributo timelyPaydayDTO de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the timelyPaydayDTO
	 */
	public TimelyPaydayDTO getTimelyPaydayDTO() {
		return timelyPaydayDTO;
	}

	/**
	 * Método setter del atributo timelyPaydayDTO de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @param timelyPaydayDTO
	 *            the timelyPaydayDTO to set
	 */
	public void setTimelyPaydayDTO(TimelyPaydayDTO timelyPaydayDTO) {
		this.timelyPaydayDTO = timelyPaydayDTO;
	}

	/**
	 * Método getter del atributo fechaPagoOportuno de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the fechaPagoOportuno
	 */
	public String getFechaPagoOportuno() {
		return fechaPagoOportuno;
	}

	/**
	 * Método setter del atributo fechaPagoOportuno de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @param fechaPagoOportuno
	 *            the fechaPagoOportuno to set
	 */
	public void setFechaPagoOportuno(String fechaPagoOportuno) {
		this.fechaPagoOportuno = fechaPagoOportuno;
	}

	/**
	 * Método getter del atributo administradorasRiesgoYCcf de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the administradorasRiesgoYCcf
	 */
	public List<AdministradoraDTO> getAdministradorasRiesgoYCcf() {
		if (administradorasRiesgoYCcf == null) {
			administradorasRiesgoYCcf = new ArrayList<AdministradoraDTO>();
		}
		return administradorasRiesgoYCcf;
	}

	/**
	 * Método getter del atributo properties de la clase ValidacionArchivoDataSourceDTO
	 *
	 * @return the properties
	 */
	public Map<String, String> getProperties() {
		if (properties == null) {
			properties = new HashMap<String, String>();
		}
		return properties;
	}

	public Collection<AplicabilidadDTO> getTiposPlanillaApte() {
		if (tiposPlanillaApte == null) {
			tiposPlanillaApte = new ArrayList<AplicabilidadDTO>();
		}
		return tiposPlanillaApte;
	}

	public void setTiposPlanillaApte(Collection<AplicabilidadDTO> tiposPlanillaApte) {
		this.tiposPlanillaApte = tiposPlanillaApte;
	}
	
	

}

package com.ach.soi.empresarial.liquidacion.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import co.swatit.pilautil.dto.out.AdministradoraDTO;
import co.swatit.pilautil.dto.out.AdministradoraTarifaDTO;
import co.swatit.pilautil.dto.out.AplicabilidadDTO;
import co.swatit.pilautil.dto.out.AportanteDTO;
import co.swatit.pilautil.dto.out.AportanteFilialDTO;
import co.swatit.pilautil.dto.out.ArchivoEnProcesoDTO;
import co.swatit.pilautil.dto.out.DepartamentoDTO;
import co.swatit.pilautil.dto.out.DetalleParametroDTO;
import co.swatit.pilautil.dto.out.FspTarifaDTO;
import co.swatit.pilautil.dto.out.InformacionAportantePlanillaDTO;
import co.swatit.pilautil.dto.out.InformacionPlanillaMNCorregidaDTO;
import co.swatit.pilautil.dto.out.MunicipioDTO;
import co.swatit.pilautil.dto.out.ObligatoriedadAportanteDTO;
import co.swatit.pilautil.dto.out.ObligatoriedadSubTipoCotizanteDTO;
import co.swatit.pilautil.dto.out.ObligatoriedadTipoCotizanteDTO;
import co.swatit.pilautil.dto.out.ParametroDTO;
import co.swatit.pilautil.dto.out.PlanillaAportanteDTO;
import co.swatit.pilautil.dto.out.RiesgoClaseDTO;
import co.swatit.pilautil.dto.out.SeccionalFiscaliaDTO;
import co.swatit.pilautil.dto.out.SubTipoCotizanteDTO;
import co.swatit.pilautil.dto.out.TipoCotizanteDTO;
import co.swatit.pilautil.dto.out.TipoIdentificacionDTO;
import co.swatit.pilautil.dto.out.ValidacionArchivoDataSourceDTO;
import co.swatit.pilautil.dto.out.ValorParametroDTO;
import co.swatit.pilautil.exception.BusinessException;
import co.swatit.pilautil.generics.Constants;
import co.swatit.pilautil.generics.Utilities;
import co.swatit.pilautil.generics.Validation;

import com.ach.apt.biz.model.AportanteVO;
import com.ach.apt.biz.model.ObligatoriedadAportanteVO;
import com.ach.apt.biz.model.ObligatoriedadSubTipoCotizanteVO;
import com.ach.apt.biz.model.ObligatoriedadTipoCotizanteVO;
import com.ach.apt.biz.type.EventoFilialApteType;
import com.ach.arc.biz.r1747.util.ValidacionArchivoDataSource;
import com.ach.cfg.biz.model.AdministradoraVO;
import com.ach.cfg.biz.model.DepartamentoVO;
import com.ach.cfg.biz.model.MunicipioVO;
import com.ach.cfg.biz.model.ParametroVO;
import com.ach.cfg.biz.model.RiesgoClaseVO;
import com.ach.cfg.biz.model.TipoIdentificacionVO;
import com.ach.cfg.biz.model.ValorParametroVO;
import com.ach.cfg.biz.type.EstadoPlanillaType;
import com.ach.cfg.biz.type.NormatividadType;
import com.ach.cfg.biz.type.ParametrosType;
import com.ach.cfg.biz.type.TipoFormasPresentacionType;
import com.ach.cfg.biz.type.TipoPersonaEntidadFinancieraType;
import com.ach.cfg.biz.type.TipoSubSistemasType;
import com.ach.pla.biz.model.SeccionalFiscaliaVO;
import com.ach.pla.biz.model.SubTipoCotizanteVO;
import com.ach.pla.biz.model.TipoCotizanteVO;
import com.ach.pla.biz.transfer.DiaPagoOportunoDTO;
import com.ach.pla.biz.transfer.InformacionPlanillaMNCorregida;
import com.ach.pla.biz.type.EstadoProcesosArchivoPlanoType;
import com.ach.pla.biz.type.NotificacionDeArchivoEnProcesoType;
import com.ach.pla.biz.type.PeriodoType;
import com.lucasian.common.jee.model.CommonVO;
import com.lucasian.exception.ApplicationException;


public final class Converter {

	private static final Logger LOGGER = Logger.getLogger(Converter.class.getName());

	private Converter() {
		// constructor vacío intencionalmente
	}
	
	
	private static Calendar convertStringToCalendar ( String str ) {
		if ( str==null||str.trim().equals("") ){
			return null;
		}
		String DATE_PATTERN_YYYYMMDD = "yyyyMMdd";
		SimpleDateFormat fmt = new SimpleDateFormat(DATE_PATTERN_YYYYMMDD);
		try{
			Date fecha = fmt.parse(str);
			Calendar cal = Calendar.getInstance();
			cal.setTime(fecha);
			return cal;
		}catch ( Exception e ){
			e.printStackTrace();
			return null;
		}
		
	}

	/**
	 * 
	 * Método que convierte un objeto {@link AdministradoraVO} en {@link AdministradoraDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            , objeto a ser convertido
	 * @return {@link AdministradoraDTO} con la información obtenida desde SOI
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static AdministradoraVO convertAdministradora(AdministradoraDTO ejbObjectOutput) throws BusinessException {
		AdministradoraVO retorno = new AdministradoraVO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setAdminPcss(ejbObjectOutput.getAdminPcss());
			retorno.setAplicaPnllaCorrecciones(ejbObjectOutput.getAplicaPnllaCorrecciones());
			retorno.setIdSoiPenSubsistema(ejbObjectOutput.getIdSoiPenSubsistema());
			retorno.setNombreSoporte(ejbObjectOutput.getNombreSoporte());
			retorno.setPeriodoFin(ejbObjectOutput.getPeriodoFin());
			retorno.setPeriodoInicio(ejbObjectOutput.getPeriodoInicio());
			retorno.setIpModificacion(ejbObjectOutput.getIpModificacion());
			retorno.setUsuarioModificacion(ejbObjectOutput.getUsuarioModificacion());
			retorno.setIpCreacion(ejbObjectOutput.getIpCreacion());
			retorno.setUsuarioCreacion(ejbObjectOutput.getUsuarioCreacion());
			retorno.setCorreoContacto(ejbObjectOutput.getCorreoContacto());
			retorno.setIdNuevaAdministradora(ejbObjectOutput.getIdNuevaAdministradora());
			retorno.setFechaFusion(convertStringToCalendar(ejbObjectOutput.getFechaFusion()));
			retorno.setFusionada(ejbObjectOutput.getFusionada());
			retorno.setFsp(ejbObjectOutput.getFsp());
			retorno.setMultipleArp(ejbObjectOutput.getMultipleArp());
			retorno.setNaturaleza(ejbObjectOutput.getNaturaleza());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setIdSoiSubsistema(ejbObjectOutput.getIdSoiSubsistema());
			retorno.setNumeroIdentificacion(ejbObjectOutput.getNumeroIdentificacion());
			retorno.setIdTpIdentificacion(ejbObjectOutput.getIdTpIdentificacion());
			retorno.setNombreMostrar(ejbObjectOutput.getNombreMostrar());
			retorno.setNombre(ejbObjectOutput.getNombre());
			retorno.setCodAdministradora(ejbObjectOutput.getCodAdministradora());
			retorno.setIdSoiAdministradora(ejbObjectOutput.getIdSoiAdministradora());
			retorno.setVigenteSubsistema(ejbObjectOutput.getVigenteSubsistema());
			retorno.setIdSoiTpCotizante(ejbObjectOutput.getIdSoiTpCotizante());
			retorno.setIdSoiSubtpCotizante(ejbObjectOutput.getIdSoiSubtpCotizante());
			retorno.setIdSoiAdmCobertura(ejbObjectOutput.getIdSoiAdmCobertura());
			retorno.setIdSoiMunicipioCobertura(ejbObjectOutput.getIdSoiMunicipioCobertura());
			retorno.setVigenteAdmCobertura(ejbObjectOutput.getVigenteAdmCobertura());
			retorno.setFechaInicioVigenciaCobertura(convertStringToCalendar(ejbObjectOutput
					.getFechaInicioVigenciaCobertura()));
			retorno.setFechaFinVigenciaCobertura(convertStringToCalendar(ejbObjectOutput
					.getFechaFinVigenciaCobertura()));
			AdministradoraDTO adminVO = ejbObjectOutput.getAdministradoraFusion();
			if (Validation.isNotNull(adminVO)) {
				retorno.setAdministradoraFusion(convertAdministradora(ejbObjectOutput.getAdministradoraFusion()));
			}
		} else {
		}
		return retorno;
	}

	/**
	 * 
	 *
	 * Método que convierte un un objeto {@link com.ach.pla.biz.transfer.AplicabilidadDTO} provisto por SOI en
	 * {@link AplicabilidadDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            , objeto {@link com.ach.pla.biz.transfer.AplicabilidadDTO} provisto por SOI
	 * @return {@link AplicabilidadDTO} objeto convertido usando la información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static com.ach.pla.biz.transfer.AplicabilidadDTO convertAplicabilidad(AplicabilidadDTO ejbObjectOutput)
			throws BusinessException {
		com.ach.pla.biz.transfer.AplicabilidadDTO retorno = new com.ach.pla.biz.transfer.AplicabilidadDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIdSoiClaseAportante(ejbObjectOutput.getIdSoiClaseAportante());
			retorno.setIdSoiTipoAportante(ejbObjectOutput.getIdSoiTipoAportante());
			retorno.setIdSoiTipoPlanilla(ejbObjectOutput.getIdSoiTipoPlanilla());
			retorno.setCodigoTipoPlanilla(ejbObjectOutput.getCodigoTipoPlanilla());
			retorno.setNombreTipoPlanilla(ejbObjectOutput.getNombreTipoPlanilla());
			retorno.setIdOrdenTipoPlanilla(ejbObjectOutput.getIdOrdenTipoPlanilla());
			retorno.setIdSoiTipoCotizante(ejbObjectOutput.getIdSoiTipoCotizante());
			retorno.setCodigoTipoCotizante(ejbObjectOutput.getCodigoTipoCotizante());
			retorno.setNombreTipoCotizante(ejbObjectOutput.getNombreTipoCotizante());
			retorno.setCotizanteIndependiente(ejbObjectOutput.getCotizanteIndependiente());
			retorno.setIdSoiSubTipoCotizante(ejbObjectOutput.getIdSoiSubTipoCotizante());
			retorno.setCodigoSubtipoCotizante(ejbObjectOutput.getCodigoSubtipoCotizante());
			retorno.setNombreSubtipoCotizante(ejbObjectOutput.getNombreSubtipoCotizante());
			retorno.setIdSoiExtranjeria(ejbObjectOutput.getIdSoiExtranjeria());
			retorno.setCodigoExtranjeria(ejbObjectOutput.getCodigoExtranjeria());
			retorno.setNombreExtranjeria(ejbObjectOutput.getNombreExtranjeria());
			retorno.setIdParametroSMMLV(ejbObjectOutput.getIdParametroSMMLV());
			retorno.setNumeroIdentificacionApte(ejbObjectOutput.getNumeroIdentificacionApte());
			retorno.setIdIdentificacionApte(ejbObjectOutput.getIdIdentificacionApte());
			retorno.setExtranjeria(ejbObjectOutput.getExtranjeria());
			retorno.setFechaInicioVigenciaTpCzte(convertStringToCalendar(ejbObjectOutput
					.getFechaInicioVigenciaTpCzte()));
			retorno.setFechaFinVigenciaTpCzte(convertStringToCalendar(ejbObjectOutput
					.getFechaFinVigenciaTpCzte()));
			retorno.setIdSoiAplicabilidad(ejbObjectOutput.getIdSoiAplicabilidad());
			retorno.setAporteCajaCompensacion(ejbObjectOutput.getAporteCajaCompensacion());
			retorno.setIdSoiMunicipio(ejbObjectOutput.getIdSoiMunicipio());
			retorno.setValidarMunicipioTpCotizante(ejbObjectOutput.getValidarMunicipioTpCotizante());
			retorno.setValidarTipoIdentificacionCzte(ejbObjectOutput.getValidarTipoIdentificacionCzte());
			retorno.setOrigenPlanillaN(ejbObjectOutput.getOrigenPlanillaN());
			retorno.setOrigenPlanillaM(ejbObjectOutput.getOrigenPlanillaM());
			retorno.setNoAplicaCotizanteConcejal(ejbObjectOutput.getNoAplicaCotizanteConcejal());
			retorno.setFiltroPlanillaVigente(ejbObjectOutput.getFiltroPlanillaVigente());
			retorno.setPlanillaVigente(ejbObjectOutput.getPlanillaVigente());
			retorno.setAplicaNyM(ejbObjectOutput.getAplicaNyM());
			retorno.setTipoEmpresaAplicabilidad(ejbObjectOutput.getTipoEmpresaAplicabilidad());
		} else {
		
		}
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto {@link MunicipioVO} en {@link MunicipioDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            , objeto {@link MunicipioVO} provisto por SOI
	 * @return {@link MunicipioDTO} objeto de transporte creado con la información obtenida
	 */
	public static MunicipioVO convertMunicipio(MunicipioDTO ejbObjectOutput) {
		MunicipioVO retorno = new MunicipioVO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setNombreMostrar(ejbObjectOutput.getNombreMostrar());
			retorno.setNombre(ejbObjectOutput.getNombre());
			retorno.setCodigo(ejbObjectOutput.getCodigo());
			retorno.setIdSoiDepartamento(ejbObjectOutput.getIdSoiDepartamento());
			retorno.setIdSoiMunicipio(ejbObjectOutput.getIdSoiMunicipio());
			retorno.setVigenteDepartamento(ejbObjectOutput.getVigenteDepartamento());
			retorno.setNombreMostrarDepto(ejbObjectOutput.getNombreMostrarDepto());
		} else {
		}
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto {@link com.ach.apt.biz.transfer.AportanteFilialDTO} provisto por SOI en
	 * {@link AportanteFilialDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            objeto {@link com.ach.apt.biz.transfer.AportanteFilialDTO} provisto por SOI
	 * @return {@link AportanteFilialDTO} objeto con la información obtenida
	 */
	public static com.ach.apt.biz.transfer.AportanteFilialDTO convertAportanteFilial(AportanteFilialDTO ejbObjectOutput) {
		com.ach.apt.biz.transfer.AportanteFilialDTO retorno = new com.ach.apt.biz.transfer.AportanteFilialDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIdSoiFilial(ejbObjectOutput.getIdSoiFilial());
			retorno.setIdSoiFilialUsuario(ejbObjectOutput.getIdSoiFilialUsuario());
			retorno.setIdSoiAportante(ejbObjectOutput.getIdSoiAportante());
			retorno.setIdSoiMunicipio(ejbObjectOutput.getIdSoiMunicipio());
			retorno.setTipo(ejbObjectOutput.getTipo());
			retorno.setVigenteFilial(ejbObjectOutput.getVigenteFilial());
			retorno.setVigenteFilialUsuario(ejbObjectOutput.getVigenteFilialUsuario());
			retorno.setVigenteDepartamento(ejbObjectOutput.getVigenteDepartamento());
			retorno.setVigenteMunicipio(ejbObjectOutput.getVigenteMunicipio());
			retorno.setCodigo(ejbObjectOutput.getCodigo());
			retorno.setNombre(ejbObjectOutput.getNombre());
			retorno.setCodigoMunicipio(ejbObjectOutput.getCodigoMunicipio());
			retorno.setNombreMunicipio(ejbObjectOutput.getNombreMunicipio());
			retorno.setIdSoiDepartamento(ejbObjectOutput.getIdSoiDepartamento());
			retorno.setCodigoDepartamento(ejbObjectOutput.getCodigoDepartamento());
			retorno.setNombreDepartamento(ejbObjectOutput.getNombreDepartamento());
			retorno.setIdSoiSegUsuario(ejbObjectOutput.getIdSoiSegUsuario());
			retorno.setEsAdministrador(ejbObjectOutput.getEsAdministrador());
			retorno.setCantPlanillaFilial(ejbObjectOutput.getCantPlanillaFilial());
			retorno.setEventoSucursal(EventoFilialApteType.valueOf(ejbObjectOutput.getEventoSucursal()));			
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		return retorno;
	}

	/**
	 * 
	 *
	 * Método que convierte un objeto {@link ObligatoriedadAportanteVO} en {@link ObligatoriedadAportanteDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            , objeto {@link ObligatoriedadAportanteVO} provisto por SOI
	 * @return {@link ObligatoriedadAportanteDTO} con la información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static ObligatoriedadAportanteVO convertObligatoriedadAportante(ObligatoriedadAportanteDTO ejbObjectOutput)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.convertObligatoriedadAportante");
		ObligatoriedadAportanteVO retorno = new ObligatoriedadAportanteVO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIpModificacion(ejbObjectOutput.getIpModificacion());
			retorno.setFechaModificacion(convertStringToCalendar(ejbObjectOutput.getFechaModificacion()));
			retorno.setUsuarioModificacion(ejbObjectOutput.getUsuarioModificacion());
			retorno.setIpCreacion(ejbObjectOutput.getIpCreacion());
			retorno.setFechaCreacion(convertStringToCalendar(ejbObjectOutput.getFechaCreacion()));
			retorno.setUsuarioCreacion(ejbObjectOutput.getUsuarioCreacion());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(convertStringToCalendar(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setFechaInicioVigencia(convertStringToCalendar(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setTpObligatoriedad(ejbObjectOutput.getTpObligatoriedad());
			retorno.setIdSoiSubsistema(ejbObjectOutput.getIdSoiSubsistema());
			retorno.setIdSoiAportante(ejbObjectOutput.getIdSoiAportante());
			retorno.setIdSoiOblgAportante(ejbObjectOutput.getIdSoiOblgAportante());
			retorno.setIpModificacion1(ejbObjectOutput.getIpModificacion1());
			retorno.setFechaModificacion1(convertStringToCalendar(ejbObjectOutput.getFechaModificacion1()));
			retorno.setUsuarioModificacion1(ejbObjectOutput.getUsuarioModificacion1());
			retorno.setIpCreacion1(ejbObjectOutput.getIpCreacion1());
			retorno.setFechaCreacion1(convertStringToCalendar(ejbObjectOutput.getFechaCreacion1()));
			retorno.setUsuarioCreacion1(ejbObjectOutput.getUsuarioCreacion1());
			retorno.setCausaFinVigencia1(ejbObjectOutput.getCausaFinVigencia1());
			retorno.setFechaFinVigencia1(convertStringToCalendar(ejbObjectOutput.getFechaFinVigencia1()));
			retorno.setFechaInicioVigencia1(convertStringToCalendar(ejbObjectOutput.getFechaInicioVigencia1()));
			retorno.setVigente1(ejbObjectOutput.getVigente1());
			retorno.setNombreMostrar(ejbObjectOutput.getNombreMostrar());
			retorno.setNombre(ejbObjectOutput.getNombre());
			retorno.setCodigo(ejbObjectOutput.getCodigo());
			retorno.setIdSoiSubsistema1(ejbObjectOutput.getIdSoiSubsistema1());
			retorno.setCtaEntidadFinanciera(ejbObjectOutput.getCtaEntidadFinanciera());
			retorno.setCelular(ejbObjectOutput.getCelular());
			retorno.setCorreo(ejbObjectOutput.getCorreo());
			retorno.setInfoViaCelular(ejbObjectOutput.getInfoViaCelular());
			retorno.setInfoViaCorreo(ejbObjectOutput.getInfoViaCorreo());
			retorno.setIpModificacion2(ejbObjectOutput.getIpModificacion2());
			retorno.setFechaModificacion2(convertStringToCalendar(ejbObjectOutput.getFechaModificacion2()));
			retorno.setUsuarioModificacion2(ejbObjectOutput.getUsuarioModificacion2());
			retorno.setIpCreacion2(ejbObjectOutput.getIpCreacion2());
			retorno.setFechaCreacion2(convertStringToCalendar(ejbObjectOutput.getFechaCreacion2()));
			retorno.setUsuarioCreacion2(ejbObjectOutput.getUsuarioCreacion2());
			retorno.setApellido(ejbObjectOutput.getApellido());
			retorno.setCausaFinVigencia2(ejbObjectOutput.getCausaFinVigencia2());
			retorno.setFechaFinVigencia2(convertStringToCalendar(ejbObjectOutput.getFechaFinVigencia2()));
			retorno.setVigente2(ejbObjectOutput.getVigente2());
			retorno.setFechaInicioVigencia2(convertStringToCalendar(ejbObjectOutput.getFechaInicioVigencia2()));
			retorno.setIdArp(ejbObjectOutput.getIdArp());
			retorno.setIdCcf(ejbObjectOutput.getIdCcf());
			retorno.setAporteEsapMinedu(ejbObjectOutput.getAporteEsapMinedu());
			retorno.setCodTpPersonaFinanciera(ejbObjectOutput.getCodTpPersonaFinanciera());
			retorno.setIdSoiTpPagadorPension(ejbObjectOutput.getIdSoiTpPagadorPension());
			retorno.setFechaFinAccion(convertStringToCalendar(ejbObjectOutput.getFechaFinAccion()));
			retorno.setFechaInicioAccion(convertStringToCalendar(ejbObjectOutput.getFechaInicioAccion()));
			retorno.setIdSoiTpAccion(ejbObjectOutput.getIdSoiTpAccion());
			retorno.setRlSegundoApellido(ejbObjectOutput.getRlSegundoApellido());
			retorno.setRlPrimerApellido(ejbObjectOutput.getRlPrimerApellido());
			retorno.setRlSegundoNombre(ejbObjectOutput.getRlSegundoNombre());
			retorno.setRlPrimerNombre(ejbObjectOutput.getRlPrimerNombre());
			retorno.setRlNumeroIdentificacion(ejbObjectOutput.getRlNumeroIdentificacion());
			retorno.setRlIdTpIdentificacion(ejbObjectOutput.getRlIdTpIdentificacion());
			retorno.setFax(ejbObjectOutput.getFax());
			retorno.setExtension(ejbObjectOutput.getExtension());
			retorno.setTelefono(ejbObjectOutput.getTelefono());
			retorno.setIdSoiActividadEcon(ejbObjectOutput.getIdSoiActividadEcon());
			retorno.setIdSoiMunicipio(ejbObjectOutput.getIdSoiMunicipio());
			retorno.setDireccion(ejbObjectOutput.getDireccion());
			retorno.setIdSoiFormaPresentacion(ejbObjectOutput.getIdSoiFormaPresentacion());
			retorno.setCodTpPersona(ejbObjectOutput.getCodTpPersona());
			retorno.setIdSoiTpEmpresa(ejbObjectOutput.getIdSoiTpEmpresa());
			retorno.setIdSoiTpAportante(ejbObjectOutput.getIdSoiTpAportante());
			retorno.setIdSoiClaseAportante(ejbObjectOutput.getIdSoiClaseAportante());
			retorno.setDigitoVerificacion(ejbObjectOutput.getDigitoVerificacion());
			retorno.setNumeroIdentificacion(ejbObjectOutput.getNumeroIdentificacion());
			retorno.setIdSoiTpIdentificacion(ejbObjectOutput.getIdSoiTpIdentificacion());
			retorno.setNombre1(ejbObjectOutput.getNombre1());
			retorno.setIdSoiAportante1(ejbObjectOutput.getIdSoiAportante1());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ "co.swatit.pilautil.converter.Converter.convertObligatoriedadAportante");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto {@link AportanteVO} en {@link AportanteDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            , objeto {@link AportanteVO} provisto por SOI
	 * @return {@link AportanteDTO} objeto de transporte con la información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static AportanteVO convertAportante(AportanteDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertAportante");
		AportanteVO retorno = new AportanteVO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setPagoElectronicoOc(ejbObjectOutput.getPagoElectronicoOc());
			retorno.setPermiteGeneracionCsv(ejbObjectOutput.getPermiteGeneracionCsv());
			retorno.setCantidadMaximaErrores(ejbObjectOutput.getCantidadMaximaErrores());
			retorno.setFechaActInformacion(convertStringToCalendar(ejbObjectOutput.getFechaActInformacion()));
			retorno.setActualizoInformacion(ejbObjectOutput.getActualizoInformacion());
			retorno.setAporteCajaCompensacion(ejbObjectOutput.getAporteCajaCompensacion());
			retorno.setFechaCreacionEmpresa(convertStringToCalendar(ejbObjectOutput.getFechaCreacionEmpresa()));
			retorno.setApteMigradoActDatos(ejbObjectOutput.getApteMigradoActDatos());
			retorno.setAportanteMigrado(ejbObjectOutput.getAportanteMigrado());
			retorno.setCtaEntidadFinanciera(ejbObjectOutput.getCtaEntidadFinanciera());
			retorno.setCelular(ejbObjectOutput.getCelular());
			retorno.setCorreo(ejbObjectOutput.getCorreo());
			retorno.setInfoViaCelular(ejbObjectOutput.getInfoViaCelular());
			retorno.setInfoViaCorreo(ejbObjectOutput.getInfoViaCorreo());
			retorno.setIpModificacion(ejbObjectOutput.getIpModificacion());
			retorno.setFechaModificacion(convertStringToCalendar(ejbObjectOutput.getFechaModificacion()));
			retorno.setUsuarioModificacion(ejbObjectOutput.getUsuarioModificacion());
			retorno.setIpCreacion(ejbObjectOutput.getIpCreacion());
			retorno.setFechaCreacion(convertStringToCalendar(ejbObjectOutput.getFechaCreacion()));
			retorno.setUsuarioCreacion(ejbObjectOutput.getUsuarioCreacion());
			retorno.setApellido(ejbObjectOutput.getApellido());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(convertStringToCalendar(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setFechaInicioVigencia(convertStringToCalendar(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setIdArp(ejbObjectOutput.getIdArp());
			retorno.setIdCcf(ejbObjectOutput.getIdCcf());
			retorno.setAporteEsapMinedu(ejbObjectOutput.getAporteEsapMinedu());
			retorno.setCodTpPersonaFinanciera(ejbObjectOutput.getCodTpPersonaFinanciera());
			retorno.setIdSoiTpPagadorPension(ejbObjectOutput.getIdSoiTpPagadorPension());
			retorno.setFechaFinAccion(convertStringToCalendar(ejbObjectOutput.getFechaFinAccion()));
			retorno.setFechaInicioAccion(convertStringToCalendar(ejbObjectOutput.getFechaInicioAccion()));
			retorno.setIdSoiTpAccion(ejbObjectOutput.getIdSoiTpAccion());
			retorno.setRlSegundoApellido(ejbObjectOutput.getRlSegundoApellido());
			retorno.setRlPrimerApellido(ejbObjectOutput.getRlPrimerApellido());
			retorno.setRlSegundoNombre(ejbObjectOutput.getRlSegundoNombre());
			retorno.setRlPrimerNombre(ejbObjectOutput.getRlPrimerNombre());
			retorno.setRlNumeroIdentificacion(ejbObjectOutput.getRlNumeroIdentificacion());
			retorno.setRlIdTpIdentificacion(ejbObjectOutput.getRlIdTpIdentificacion());
			retorno.setFax(ejbObjectOutput.getFax());
			retorno.setExtension(ejbObjectOutput.getExtension());
			retorno.setTelefono(ejbObjectOutput.getTelefono());
			retorno.setIdSoiActividadEcon(ejbObjectOutput.getIdSoiActividadEcon());
			retorno.setIdSoiMunicipio(ejbObjectOutput.getIdSoiMunicipio());
			retorno.setDireccion(ejbObjectOutput.getDireccion());
			retorno.setIdSoiFormaPresentacion(ejbObjectOutput.getIdSoiFormaPresentacion());
			retorno.setCodTpPersona(ejbObjectOutput.getCodTpPersona());
			retorno.setIdSoiTpEmpresa(ejbObjectOutput.getIdSoiTpEmpresa());
			retorno.setIdSoiTpAportante(ejbObjectOutput.getIdSoiTpAportante());
			retorno.setIdSoiClaseAportante(ejbObjectOutput.getIdSoiClaseAportante());
			retorno.setDigitoVerificacion(ejbObjectOutput.getDigitoVerificacion());
			retorno.setNumeroIdentificacion(ejbObjectOutput.getNumeroIdentificacion());
			retorno.setIdSoiTpIdentificacion(ejbObjectOutput.getIdSoiTpIdentificacion());
			retorno.setNombre(ejbObjectOutput.getNombre());
			retorno.setIdSoiAportante(ejbObjectOutput.getIdSoiAportante());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertAportante");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto {@link com.ach.pla.biz.transfer.PlanillaAportanteDTO} en
	 * {@link PlanillaAportanteDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            , objeto {@link com.ach.pla.biz.transfer.PlanillaAportanteDTO} provisto por SOI
	 * @return {@link PlanillaAportanteDTO} objeto de transporte con la Información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static com.ach.pla.biz.transfer.PlanillaAportanteDTO convertPlanillaAportante(
			PlanillaAportanteDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertPlanillaAportante");
		com.ach.pla.biz.transfer.PlanillaAportanteDTO retorno = new com.ach.pla.biz.transfer.PlanillaAportanteDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setNumeroPlanillaActual(ejbObjectOutput.getNumeroPlanillaActual());
			retorno.setNumeroPlanillaAsistida(ejbObjectOutput.getNumeroPlanillaAsistida());
			retorno.setNumeroPlanillaElectronica(ejbObjectOutput.getNumeroPlanillaElectronica());
			retorno.setIdSoiTpPlanilla(ejbObjectOutput.getIdSoiTpPlanilla());
			retorno.setCodigoSoiTpPlanilla(ejbObjectOutput.getCodigoSoiTpPlanilla());
			retorno.setNombreSoiTpPlanilla(ejbObjectOutput.getNombreSoiTpPlanilla());
			retorno.setNumeroTotalEmpleados(ejbObjectOutput.getNumeroTotalEmpleados());
			retorno.setNumeroTotalCotizantes(ejbObjectOutput.getNumeroTotalCotizantes());
			retorno.setIdSucursal(ejbObjectOutput.getIdSucursal());
			retorno.setCodigoSucursal(ejbObjectOutput.getCodigoSucursal());
			retorno.setNombreSucursal(ejbObjectOutput.getNombreSucursal());
			retorno.setConvertidor(ejbObjectOutput.getConvertidor());
			try{
				retorno.setPeriodoLiquidacionSalud(new PeriodoType(ejbObjectOutput.getPeriodoLiquidacionSalud()));
				retorno.setPeriodoLiquidacionNoSalud(new PeriodoType((ejbObjectOutput.getPeriodoLiquidacionNoSalud())));
			}catch ( ApplicationException a ){
				a.printStackTrace();
				return null;
			}
			retorno.setNumeroPlanillaAsocida(ejbObjectOutput.getNumeroPlanillaAsocida());
			retorno.setFechaPagoPlanillaAsociada(convertStringToCalendar(ejbObjectOutput
					.getFechaPagoPlanillaAsociada()));
			retorno.setFechaPagoPlanillaAsociadaCadena(ejbObjectOutput.getFechaPagoPlanillaAsociadaCadena());
			retorno.setIdSoiTpPlanillaAsociada(ejbObjectOutput.getIdSoiTpPlanillaAsociada());
			retorno.setCodigoSoiTpPlanillaAsociada(ejbObjectOutput.getCodigoSoiTpPlanillaAsociada());
			retorno.setNombreSoiTpPlanillaAsociada(ejbObjectOutput.getNombreSoiTpPlanillaAsociada());
			retorno.setIdSoiAdministradoraARPPlanillaAsociada(ejbObjectOutput
					.getIdSoiAdministradoraARPPlanillaAsociada());
			retorno.setNombreARPPlanillaAsociada(ejbObjectOutput.getNombreARPPlanillaAsociada());
			retorno.setCodAdministradoraARPPlanillaAsociada(ejbObjectOutput.getCodAdministradoraARPPlanillaAsociada());
			retorno.setEstadoPlanilla(EstadoPlanillaType.valueOf(ejbObjectOutput.getEstadoPlanilla()));
			retorno.setIdSoiAdministradoraARP(ejbObjectOutput.getIdSoiAdministradoraARP());
			retorno.setCodAdministradoraARPPlanilla(ejbObjectOutput.getCodAdministradoraARPPlanilla());
			retorno.setIdSoiFormaPresentacion(ejbObjectOutput.getIdSoiFormaPresentacion());
			retorno.setCodSoiFormaPresentacion(ejbObjectOutput.getCodSoiFormaPresentacion());
			retorno.setNombreSoiFormaPresentacion(ejbObjectOutput.getNombreSoiFormaPresentacion());
			retorno.setIdOperadorPila(ejbObjectOutput.getIdOperadorPila());
			retorno.setFormaElaboracionPlanilla(ejbObjectOutput.getFormaElaboracionPlanilla());
			retorno.setModalidadPlanilla(ejbObjectOutput.getModalidadPlanilla());
			retorno.setIdSoiPlanilla(ejbObjectOutput.getIdSoiPlanilla());
			retorno.setNombreArchivoPlano(ejbObjectOutput.getNombreArchivoPlano());
			retorno.setTipoPlanillaBloquedada(ejbObjectOutput.getTipoPlanillaBloquedada());
			retorno.setClaseAportanteBoI(ejbObjectOutput.getClaseAportanteBoI());
			retorno.setValorPagado(ejbObjectOutput.getValorPagado());
			retorno.setFechaDePagoEfectiva(convertStringToCalendar(ejbObjectOutput.getFechaDePagoEfectiva()));
			retorno.setUsuarioModificaInformacionAportante(ejbObjectOutput.getUsuarioModificaInformacionAportante());
			retorno.setPlanilaAsociadaMNExiste(ejbObjectOutput.getPlanilaAsociadaMNExiste());
			retorno.setPlanilaAsociadaTExiste(ejbObjectOutput.getPlanilaAsociadaTExiste());
			retorno.setUsuarioAceptaPlanillaMNPagadaPorEsteOperador(ejbObjectOutput
					.getUsuarioAceptaPlanillaMNPagadaPorEsteOperador());
			retorno.setPlanillaPublicaPreguntarSiEsRetroactivo(ejbObjectOutput
					.getPlanillaPublicaPreguntarSiEsRetroactivo());
			retorno.setUsuarioAceptaRetroactivoPlanillaPublica(ejbObjectOutput
					.getUsuarioAceptaRetroactivoPlanillaPublica());
			retorno.setCertificaCalculoInteresesMora(ejbObjectOutput.getCertificaCalculoInteresesMora());
			retorno.setNumeroDiasExistenciaEmpresa(ejbObjectOutput.getNumeroDiasExistenciaEmpresa());
			retorno.setNumeroAnosExistenciaEmpresa(ejbObjectOutput.getNumeroAnosExistenciaEmpresa());
			retorno.setUsuarioAceptaDescuentoPymes(ejbObjectOutput.getUsuarioAceptaDescuentoPymes());
			retorno.setRecalcularMora(ejbObjectOutput.getRecalcularMora());
			retorno.setAportanteLey1607(ejbObjectOutput.getAportanteLey1607());
			retorno.setAportanteLey1429(ejbObjectOutput.getAportanteLey1429());
			retorno.setTipoPlanillaAplicaLey1607(ejbObjectOutput.getTipoPlanillaAplicaLey1607());
			retorno.setAplicaPeriodoMayorIgualAbr1994(ejbObjectOutput.getAplicaPeriodoMayorIgualAbr1994());
			retorno.setAplicaPeriodoMenorIgualDic2002(ejbObjectOutput.getAplicaPeriodoMenorIgualDic2002());
			retorno.setIdSoiAportante(ejbObjectOutput.getIdSoiAportante());
			retorno.setCodigoTpPlanillaExistente(ejbObjectOutput.getCodigoTpPlanillaExistente());
			retorno.setExistenPlanillasBase(ejbObjectOutput.getExistenPlanillasBase());
			retorno.setCantidadMaximaErrores(ejbObjectOutput.getCantidadMaximaErrores());
			retorno.setPermiteGeneracionCsv(ejbObjectOutput.getPermiteGeneracionCsv());
			retorno.setIdSoiSoporteUsuario(ejbObjectOutput.getIdSoiSoporteUsuario());
			retorno.setExisteApteNsoiPlanillaU(ejbObjectOutput.getExisteApteNsoiPlanillaU());
			retorno.setExisteApteUgpp(ejbObjectOutput.getExisteApteUgpp());
			retorno.setNumeroDiasMoraPnllaJ(ejbObjectOutput.getNumeroDiasMoraPnllaJ());
			retorno.setEdicionPlanillaArchivo(ejbObjectOutput.getEdicionPlanillaArchivo());
			retorno.setEsPreliquidacion(ejbObjectOutput.getEsPreliquidacion());
			retorno.setAplicaValidacionPlanillaPrevia(ejbObjectOutput.getAplicaValidacionPlanillaPrevia());
			retorno.setIdSoiTpEmpresa(ejbObjectOutput.getIdSoiTpEmpresa());
			retorno.setPlanillaJReferida(ejbObjectOutput.getPlanillaJReferida());
			retorno.setCreacionPlanilla(ejbObjectOutput.getCreacionPlanilla());
			retorno.setIpCreacion(ejbObjectOutput.getIpCreacion());
			retorno.setCodMunicipioAportante(ejbObjectOutput.getCodMunicipioAportante());
			retorno.setIvaComision(ejbObjectOutput.getIvaComision());
			retorno.setComision(ejbObjectOutput.getComision());
			retorno.setCodDepartamentoAportante(ejbObjectOutput.getCodDepartamentoAportante());
			retorno.setDireccionAportante(ejbObjectOutput.getDireccionAportante());
			retorno.setTelefonoAportante(ejbObjectOutput.getTelefonoAportante());
			retorno.setFax(ejbObjectOutput.getFax());
			retorno.setIdPlanillaE(ejbObjectOutput.getIdPlanillaE());
			retorno.setNumeroCotizantesPermitidos(ejbObjectOutput.getNumeroCotizantesPermitidos());
			retorno.setIdSoiEntidadFinanciera(ejbObjectOutput.getIdSoiEntidadFinanciera());
			retorno.setApteSeccionalFiscalia(ejbObjectOutput.getApteSeccionalFiscalia());
			retorno.setExitePlanillaPreviaResolucion1233(ejbObjectOutput.getExitePlanillaPreviaResolucion1233());
			retorno.setUsuarioSolicitaCambioNormatividad(ejbObjectOutput.getUsuarioSolicitaCambioNormatividad());
			retorno.setInformacionAportantePlanillaDTO(convertInformacionAportantePlanilla(ejbObjectOutput.getInformacionAportantePlanillaDTO()));
			retorno.setAdministradorasAportante(new HashMap<TipoSubSistemasType,Collection<AdministradoraVO>>());
			for (Map.Entry<String, List<AdministradoraDTO>> entry : ejbObjectOutput.getAdministradorasAportante().entrySet()) {
				ArrayList<AdministradoraVO> adminRetorno = new ArrayList<AdministradoraVO>();
				for (AdministradoraDTO convertir : entry.getValue()) {
					adminRetorno.add(convertAdministradora(convertir));
				}
				retorno.getAdministradorasAportante().put(TipoSubSistemasType.valueOf(entry.getKey()), adminRetorno);
			}
			retorno.setTarifasAportante(new HashMap<Integer, Collection<BigDecimal>>());
			if ( ejbObjectOutput.getTarifasAportante()!=null ){
				Map<Integer, List<BigDecimal>> mapaTarifas = ejbObjectOutput.getTarifasAportante();				
				for (Map.Entry<Integer, List<BigDecimal>> entry : mapaTarifas.entrySet()) {
					ArrayList<BigDecimal> tarifaRetorno = new ArrayList<BigDecimal>();
					for (BigDecimal convertir : entry.getValue()) {
						tarifaRetorno.add(convertir);
					}
					retorno.getTarifasAportante().put(entry.getKey(), tarifaRetorno);
				}
			}
			
			retorno.setNormatividad(new HashMap<NormatividadType, Boolean>());
			if ( ejbObjectOutput.getNormatividad()!=null ){
				for ( Map.Entry<String, Boolean> entry: ejbObjectOutput.getNormatividad().entrySet() ){
					retorno.getNormatividad().put(NormatividadType.valueOf(entry.getKey()), entry.getValue());
				}
			}
			
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertPlanillaAportante");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto {@link ObligatoriedadSubTipoCotizanteVO} en
	 * {@link ObligatoriedadSubTipoCotizanteDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            , {@link ObligatoriedadSubTipoCotizanteVO} provisto por SOI
	 * @return {@link ObligatoriedadSubTipoCotizanteDTO} con la información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static ObligatoriedadSubTipoCotizanteVO convertObligatoriedadSubTipoCotizante(
			ObligatoriedadSubTipoCotizanteDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.convertObligatoriedadSubTipoCotizante");
		ObligatoriedadSubTipoCotizanteVO retorno = new ObligatoriedadSubTipoCotizanteVO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(convertStringToCalendar(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setFechaInicioVigencia(convertStringToCalendar(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setTpObligatoriedad(ejbObjectOutput.getTpObligatoriedad());
			retorno.setIdSoiSubsistema(ejbObjectOutput.getIdSoiSubsistema());
			retorno.setIdSoiSubtpCotizante(ejbObjectOutput.getIdSoiSubtpCotizante());
			retorno.setIdSoiOblgSubtpCotizan(ejbObjectOutput.getIdSoiOblgSubtpCotizante());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ "co.swatit.pilautil.converter.Converter.convertObligatoriedadSubTipoCotizante");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto {@link SubTipoCotizanteVO} en {@link SubTipoCotizanteDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            , {@link SubTipoCotizanteVO} provisto por SOI
	 * @return {@link SubTipoCotizanteDTO} objeto de transporte con la información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static SubTipoCotizanteVO convertSubTipoCotizante(SubTipoCotizanteDTO ejbObjectOutput)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertSubTipoCotizante");
		SubTipoCotizanteVO retorno = new SubTipoCotizanteVO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setNecesitaRegistroPrevio(ejbObjectOutput.getNecesitaRegistroPrevio());
			retorno.setMaxSbCantSmmlv(ejbObjectOutput.getMaxSbCantSmmlv());
			retorno.setMinSbCantSmmlv(ejbObjectOutput.getMinSbCantSmmlv());
			retorno.setExtranjeria(ejbObjectOutput.getExtranjeria());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(convertStringToCalendar(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setFechaInicioVigencia(convertStringToCalendar(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setNombreMostrar(ejbObjectOutput.getNombreMostrar());
			retorno.setNombre(ejbObjectOutput.getNombre());
			retorno.setCodigo(ejbObjectOutput.getCodigo());
			retorno.setIdSoiSubtpCotizante(ejbObjectOutput.getIdSoiSubtpCotizante());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertSubTipoCotizante");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto {@link ObligatoriedadTipoCotizanteVO} en {@link ObligatoriedadTipoCotizanteDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            objeto {@link ObligatoriedadTipoCotizanteVO} provisto por SOI
	 * @return {@link ObligatoriedadTipoCotizanteDTO} con la información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static ObligatoriedadTipoCotizanteVO convertObligatoriedadTipoCotizante(
			ObligatoriedadTipoCotizanteDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.convertObligatoriedadTipoCotizante");
		ObligatoriedadTipoCotizanteVO retorno = new ObligatoriedadTipoCotizanteVO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setMaxIbcCotizadoCantSmmlv(ejbObjectOutput.getMaxIbcCotizadoCantSmmlv());
			retorno.setMinIbcCotizadoCantSmmlv(ejbObjectOutput.getMinIbcCotizadoCantSmmlv());
			retorno.setMaxCantDiaCotizado(ejbObjectOutput.getMaxCantDiaCotizado());
			retorno.setMinCantDiaCotizado(ejbObjectOutput.getMinCantDiaCotizado());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(convertStringToCalendar(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setFechaInicioVigencia(convertStringToCalendar(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setTpObligatoriedad(ejbObjectOutput.getTpObligatoriedad());
			retorno.setIdSoiSubsistema(ejbObjectOutput.getIdSoiSubsistema());
			retorno.setIdSoiTpCotizante(ejbObjectOutput.getIdSoiTpCotizante());
			retorno.setIdSoiOblgTpCotizante(ejbObjectOutput.getIdSoiOblgTpCotizante());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ "co.swatit.pilautil.converter.Converter.convertObligatoriedadTipoCotizante");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto {@link TipoCotizanteVO} en {@link TipoCotizanteDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            , objeto {@link TipoCotizanteVO} provisto por SOI
	 * @return {@link TipoCotizanteDTO} con la información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static TipoCotizanteVO convertTipoCotizante(TipoCotizanteDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertTipoCotizante");
		TipoCotizanteVO retorno = new TipoCotizanteVO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setNecesitaRegistroPrevio(ejbObjectOutput.getNecesitaRegistroPrevio());
			retorno.setMaxSbCantSmmlv(ejbObjectOutput.getMaxSbCantSmmlv());
			retorno.setMinSbCantSmmlv(ejbObjectOutput.getMinSbCantSmmlv());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(convertStringToCalendar(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setFechaInicioVigencia(convertStringToCalendar(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setNombreMostrar(ejbObjectOutput.getNombreMostrar());
			retorno.setNombre(ejbObjectOutput.getNombre());
			retorno.setCodigo(ejbObjectOutput.getCodigo());
			retorno.setObligarSbMayorCero(ejbObjectOutput.getObligarSbMayorCero());
			retorno.setIdSoiTpCotizante(ejbObjectOutput.getIdSoiTpCotizante());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertTipoCotizante");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto {@link com.ach.cfg.biz.transfer.AdministradoraTarifaDTO} en
	 * {@link AdministradoraTarifaDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            , objeto {@link com.ach.cfg.biz.transfer.AdministradoraTarifaDTO} provisto por SOI
	 * @return {@link AdministradoraDTO} con la información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static com.ach.cfg.biz.transfer.AdministradoraTarifaDTO convertAdministradoraTarifa(
			AdministradoraTarifaDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.convertAdministradoraTarifa");
		com.ach.cfg.biz.transfer.AdministradoraTarifaDTO retorno = new com.ach.cfg.biz.transfer.AdministradoraTarifaDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setAdministradora(convertAdministradora(ejbObjectOutput.getAdministradora()));
			retorno.setIdSoiAdmTarifa(ejbObjectOutput.getIdSoiAdmTarifa());
			retorno.setVigenteAdmTarifa(ejbObjectOutput.getVigenteAdmTarifa());
			retorno.setFechaInicioVigAdmTarifa(convertStringToCalendar(ejbObjectOutput
					.getFechaInicioVigAdmTarifa()));
			retorno.setFechaFinVigAdmTarifa(convertStringToCalendar(ejbObjectOutput.getFechaFinVigAdmTarifa()));
			retorno.setTarifa(ejbObjectOutput.getTarifa());
			retorno.setAplicaPnllaCorrecciones(ejbObjectOutput.getAplicaPlanillaCorrecciones());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ "co.swatit.pilautil.converter.Converter.convertAdministradoraTarifa");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto {@link com.ach.pla.biz.transfer.FspTarifaDTO} en {@link FspTarifaDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            objeto {@link com.ach.pla.biz.transfer.FspTarifaDTO} provisto por SOI
	 * @return {@link FspTarifaDTO} con la información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static com.ach.pla.biz.transfer.FspTarifaDTO convertFspTarifa(FspTarifaDTO ejbObjectOutput)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertFspTarifa");
		com.ach.pla.biz.transfer.FspTarifaDTO retorno = new com.ach.pla.biz.transfer.FspTarifaDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIdSoiFspTarifa(ejbObjectOutput.getIdSoiFspTarifa());
			retorno.setLimInferiorCantSmmlv(ejbObjectOutput.getLimInferiorCantSmmlv());
			retorno.setLimSuperiorCantSmmlv(ejbObjectOutput.getLimSuperiorCantSmmlv());
			retorno.setSmmlvInferior(ejbObjectOutput.getSmmlvInferior());
			retorno.setSmmlvSuperior(ejbObjectOutput.getSmmlvSuperior());
			retorno.setTarifaSolidaridad(ejbObjectOutput.getTarifaSolidaridad());
			retorno.setTarifaSubsistencia(ejbObjectOutput.getTarifaSubsistencia());
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setFechaInicioVigencia(convertStringToCalendar(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setFechaFinVigencia(convertStringToCalendar(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setComparacionLimiteInferior(ejbObjectOutput.getComparacionLimiteInferior());
			retorno.setComparacionLimiteSuperior(ejbObjectOutput.getComparacionLimiteSuperior());
			retorno.setIbcPension(ejbObjectOutput.getIbcPension());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertFspTarifa");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto {@link SeccionalFiscaliaVO} en {@link SeccionalFiscaliaDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            objeto {@link SeccionalFiscaliaVO} provisto por SOI
	 * @return {@link SeccionalFiscaliaDTO} con la información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static SeccionalFiscaliaVO convertSeccionalFiscalia(SeccionalFiscaliaDTO ejbObjectOutput)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertSeccionalFiscalia");
		SeccionalFiscaliaVO retorno = new SeccionalFiscaliaVO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIpModificacion(ejbObjectOutput.getIpModificacion());
			retorno.setFechaModificacion(convertStringToCalendar(ejbObjectOutput.getFechaModificacion()));
			retorno.setUsuarioModificacion(ejbObjectOutput.getUsuarioModificacion());
			retorno.setIpCreacion(ejbObjectOutput.getIpCreacion());
			retorno.setFechaCreacion(convertStringToCalendar(ejbObjectOutput.getFechaCreacion()));
			retorno.setUsuarioCreacion(ejbObjectOutput.getUsuarioCreacion());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(convertStringToCalendar(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setFechaInicioVigencia(convertStringToCalendar(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setDigitoVerificacion(ejbObjectOutput.getDigitoVerificacion());
			retorno.setNumeroIdentificacion(ejbObjectOutput.getNumeroIdentificacion());
			retorno.setIdSoiTpIdentificacion(ejbObjectOutput.getIdSoiTpIdentificacion());
			retorno.setNombre(ejbObjectOutput.getNombre());
			retorno.setIdSoiSeccionalFiscalia(ejbObjectOutput.getIdSoiSeccionalFiscalia());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertSeccionalFiscalia");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto {@link RiesgoClaseVO} en {@link RiesgoClaseDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            , objeto {@link RiesgoClaseVO} provisto por SOI
	 * @return {@link RiesgoClaseDTO} con la información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static RiesgoClaseVO convertRiesgoClase(RiesgoClaseDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertRiesgoClase");
		RiesgoClaseVO retorno = new RiesgoClaseVO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(convertStringToCalendar(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setFechaInicioVigencia(convertStringToCalendar(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setTarifaLimSuperior(ejbObjectOutput.getTarifaLimSuperior());
			retorno.setTarifaLimInferior(ejbObjectOutput.getTarifaLimInferior());
			retorno.setTarifa(ejbObjectOutput.getTarifa());
			retorno.setNombreMostrar(ejbObjectOutput.getNombreMostrar());
			retorno.setNombre(ejbObjectOutput.getNombre());
			retorno.setCodigo(ejbObjectOutput.getCodigo());
			retorno.setIdSoiRiesgoClase(ejbObjectOutput.getIdSoiRiesgoClase());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertRiesgoClase");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto {@link TipoIdentificacionVO} en {@link TipoIdentificacionDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            {@link TipoIdentificacionVO} provisto por SOI
	 * @return {@link TipoIdentificacionDTO} con la información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static TipoIdentificacionVO convertTipoIdentificacion(TipoIdentificacionDTO ejbObjectOutput)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.convertTipoIdentificacion");
		TipoIdentificacionVO retorno = new TipoIdentificacionVO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setCodTpIdenAllus(ejbObjectOutput.getCodTpIdenAllus());
			retorno.setAplicaCzteResExterior(ejbObjectOutput.getAplicaCzteResExterior());
			retorno.setAplicaCotizante(ejbObjectOutput.getAplicaCotizante());
			retorno.setAplicaRl(ejbObjectOutput.getAplicaRl());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(convertStringToCalendar(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setFechaInicioVigencia(convertStringToCalendar(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setAplicaUsuarioBco(ejbObjectOutput.getAplicaUsuarioBco());
			retorno.setAplicaUsuarioApte(ejbObjectOutput.getAplicaUsuarioApte());
			retorno.setAplicaIndependiente(ejbObjectOutput.getAplicaIndependiente());
			retorno.setAplicaEmpresa(ejbObjectOutput.getAplicaEmpresa());
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setNombreMostrar(ejbObjectOutput.getNombreMostrar());
			retorno.setNombre(ejbObjectOutput.getNombre());
			retorno.setCodigo(ejbObjectOutput.getCodigo());
			retorno.setIdSoiTpIdentificacion(ejbObjectOutput.getIdSoiTpIdentificacion());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ "co.swatit.pilautil.converter.Converter.convertTipoIdentificacion");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto {@link InformacionPlanillaMNCorregida} en
	 * {@link InformacionPlanillaMNCorregidaDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            {@link InformacionPlanillaMNCorregida} provisto por SOI
	 * @return {@link InformacionPlanillaMNCorregidaDTO} con la información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static InformacionPlanillaMNCorregida convertInformacionPlanillaMNCorregida(
			InformacionPlanillaMNCorregidaDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.convertInformacionPlanillaMNCorregida");
		InformacionPlanillaMNCorregida retorno = new InformacionPlanillaMNCorregida();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIdTipoPlanilla(ejbObjectOutput.getIdTipoPlanilla());
			retorno.setTipoPlanilla(ejbObjectOutput.getTipoPlanilla());
			retorno.setIdSucursal(ejbObjectOutput.getIdSucursal());
			retorno.setSucursal(ejbObjectOutput.getSucursal());
			try{
				retorno.setPeriodoLiquidacionSalud(new PeriodoType(ejbObjectOutput.getPeriodoLiquidacionSalud()));
				retorno.setPeriodoLiquidacionNoSalud(new PeriodoType(ejbObjectOutput.getPeriodoLiquidacionNoSalud()));
			}catch ( ApplicationException a ){
				a.printStackTrace();
				return null;
			}			
			retorno.setIdFormaPresentacion(ejbObjectOutput.getIdFormaPresentacion());
			retorno.setCodigoSucursal(ejbObjectOutput.getCodigoSucursal());
			retorno.setFormaPresentacion(ejbObjectOutput.getFormaPresentacion());
			retorno.setFechaPago(convertStringToCalendar(ejbObjectOutput.getFechaPago()));
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ "co.swatit.pilautil.converter.Converter.convertInformacionPlanillaMNCorregida");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto {@link ParametroVO} en {@link DetalleParametroDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            objeto {@link ParametroVO} provisto por SOI
	 * @return {@link DetalleParametroDTO} con la información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static ParametroVO convertDetalleParametro(DetalleParametroDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertDetalleParametro");
		ParametroVO retorno = new ParametroVO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setClaseParametro(ejbObjectOutput.getClaseParametro());
			retorno.setDescripcion(ejbObjectOutput.getDescripcion());
			retorno.setAplicaMultiple(ejbObjectOutput.getAplicaMultiple());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(convertStringToCalendar(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setFechaInicioVigencia(convertStringToCalendar(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setTpDato(ejbObjectOutput.getTpDato());
			retorno.setNombre(ejbObjectOutput.getNombre());
			retorno.setIdSoiParametro(ejbObjectOutput.getIdSoiParametro());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertDetalleParametro");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto {@link ValorParametroVO} en {@link ValorParametroDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            , objeto {@link ValorParametroVO} provisto por SOI
	 * @return {@link ValorParametroDTO} con la información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static ValorParametroVO convertValorParametro(ValorParametroDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertValorParametro");
		ValorParametroVO retorno = new ValorParametroVO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIpModificacion(ejbObjectOutput.getIpModificacion());
			retorno.setFechaModificacion(convertStringToCalendar(ejbObjectOutput.getFechaModificacion()));
			retorno.setUsuarioModificacion(ejbObjectOutput.getUsuarioModificacion());
			retorno.setIpCreacion(ejbObjectOutput.getIpCreacion());
			retorno.setFechaCreacion(convertStringToCalendar(ejbObjectOutput.getFechaCreacion()));
			retorno.setUsuarioCreacion(ejbObjectOutput.getUsuarioCreacion());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(convertStringToCalendar(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setFechaInicioVigencia(convertStringToCalendar(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setValorCadena(ejbObjectOutput.getValorCadena());
			retorno.setValorFecha(convertStringToCalendar(ejbObjectOutput.getValorFecha()));
			retorno.setValorNumerico(ejbObjectOutput.getValorNumerico());
			retorno.setIdSoiParametro(ejbObjectOutput.getIdSoiParametro());
			retorno.setIdSoiValorParametro(ejbObjectOutput.getIdSoiValorParametro());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertValorParametro");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto {@link com.ach.cfg.biz.transfer.ParametroDTO} en {@link ParametroDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            objeto {@link com.ach.cfg.biz.transfer.ParametroDTO} provisto por SOI
	 * @return {@link ParametroDTO} con la información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static com.ach.cfg.biz.transfer.ParametroDTO convertParametro(ParametroDTO ejbObjectOutput)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertParametro");
		com.ach.cfg.biz.transfer.ParametroDTO retorno = new com.ach.cfg.biz.transfer.ParametroDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIdSoiParametro(ejbObjectOutput.getIdSoiParametro());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setNombre(ejbObjectOutput.getNombre());
			retorno.setValorCadena(ejbObjectOutput.getValorCadena());
			retorno.setValorNumerico(ejbObjectOutput.getValorNumerico());
			retorno.setValorFecha(convertStringToCalendar(ejbObjectOutput.getValorFecha()));
			retorno.setValorMostrar(ejbObjectOutput.getValorMostrar());
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setVigenteValorParametro(ejbObjectOutput.getVigenteValorParametro());
			retorno.setAplicaMultiple(ejbObjectOutput.getAplicaMultiple());
			retorno.setClaseParametro(ejbObjectOutput.getClaseParametro());
			retorno.setClaseParametroMostrar(ejbObjectOutput.getClaseParametroMostrar());
			retorno.setFechaInicioVigencia1(convertStringToCalendar(ejbObjectOutput.getFechaInicioVigencia1()));
			retorno.setFechaInicioVigencia2(convertStringToCalendar(ejbObjectOutput.getFechaInicioVigencia2()));
			retorno.setFechaInicioVigencia(convertStringToCalendar(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setFechaFinVigencia(convertStringToCalendar(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setFechaInicioVigenciaValor(convertStringToCalendar(ejbObjectOutput
					.getFechaInicioVigenciaValor()));
			retorno.setFechaFinVigenciaValor(convertStringToCalendar(ejbObjectOutput
					.getFechaFinVigenciaValor()));
			retorno.setDescripcion(ejbObjectOutput.getDescripcion());
			retorno.setIdSoiValorParametro(ejbObjectOutput.getIdSoiValorParametro());
			retorno.setTipoDato(ejbObjectOutput.getTipoDato());
			retorno.setTipoDatoMostrar(ejbObjectOutput.getTipoDatoMostrar());
			retorno.setVigenteValorMostrar(ejbObjectOutput.getVigenteValorMostrar());
			retorno.setParametroVO(convertDetalleParametro(ejbObjectOutput.getDetalleParametroDTO()));
			retorno.setValorParametroVO(convertValorParametro(ejbObjectOutput.getValorParametroDTO()));
			retorno.setIdSegUsuario(ejbObjectOutput.getIdSegUsuario());
			retorno.setEsEditable(ejbObjectOutput.getEsEditable());
			retorno.setBusquedaParCrear(ejbObjectOutput.isBusquedaParCrear());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertParametro");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto {@link com.ach.seg.biz.transfer.InformacionAportantePlanillaDTO} en
	 * {@link InformacionAportantePlanillaDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            objeto {@link com.ach.seg.biz.transfer.InformacionAportantePlanillaDTO} provisto por SOI
	 * @return {@link InformacionAportantePlanillaDTO} con la información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static com.ach.seg.biz.transfer.InformacionAportantePlanillaDTO convertInformacionAportantePlanilla(
							InformacionAportantePlanillaDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertInformacionAportantePlanilla");
		com.ach.seg.biz.transfer.InformacionAportantePlanillaDTO retorno = new com.ach.seg.biz.transfer.InformacionAportantePlanillaDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIdSoiAportante(ejbObjectOutput.getIdSoiAportante());
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setIdSoiTpIdentificacion(ejbObjectOutput.getIdSoiTpIdentificacion());
			retorno.setNumeroIdentificacion(ejbObjectOutput.getNumeroIdentificacion());
			retorno.setDigitoVerificacion(ejbObjectOutput.getDigitoVerificacion());
			retorno.setNombre(ejbObjectOutput.getNombre());
			retorno.setCodSoiTpIdentificacion(ejbObjectOutput.getCodSoiTpIdentificacion());
			retorno.setNombreTpIdentificacion(ejbObjectOutput.getNombreTpIdentificacion());
			retorno.setIdSoiTpAportante(ejbObjectOutput.getIdSoiTpAportante());
			retorno.setCodigoTpAportante(ejbObjectOutput.getCodigoTpAportante());
			retorno.setNombreTpAportante(ejbObjectOutput.getNombreTpAportante());
			retorno.setIdSoiTpEmpresa(ejbObjectOutput.getIdSoiTpEmpresa());
			retorno.setCodigoTpEmpresa(ejbObjectOutput.getCodigoTpEmpresa());
			retorno.setNombreTpEmpresa(ejbObjectOutput.getNombreTpEmpresa());
			retorno.setIdSoiClaseAportante(ejbObjectOutput.getIdSoiClaseAportante());
			retorno.setCodigoClaseAportante(ejbObjectOutput.getCodigoClaseAportante());
			retorno.setNombreClaseAportante(ejbObjectOutput.getNombreClaseAportante());
			retorno.setIdSoiFormaPresentacion(ejbObjectOutput.getIdSoiFormaPresentacion());
			retorno.setCodigoFormaPresentacion(ejbObjectOutput.getCodigoFormaPresentacion());
			retorno.setNombreFormaPresentacion(ejbObjectOutput.getNombreFormaPresentacion());
			retorno.setIdSoiAdministradoraARP(ejbObjectOutput.getIdSoiAdministradoraARP());
			retorno.setNombreARP(ejbObjectOutput.getNombreARP());
			retorno.setCodAdministradoraARP(ejbObjectOutput.getCodAdministradoraARP());
			retorno.setIdSoiAdministradoraCCF(ejbObjectOutput.getIdSoiAdministradoraCCF());
			retorno.setNombreCCF(ejbObjectOutput.getNombreCCF());
			retorno.setCodAdministradoraCCF(ejbObjectOutput.getCodAdministradoraCCF());
			retorno.setMinimoCotizanteClaseAportante(ejbObjectOutput.getMinimoCotizanteClaseAportante());
			retorno.setMaximoCotizanteClaseAportante(ejbObjectOutput.getMaximoCotizanteClaseAportante());
			retorno.setCorreoAportante(ejbObjectOutput.getCorreoAportante());
			retorno.setCodigoOperador(ejbObjectOutput.getCodigoOperador());
			retorno.setIdSoiOperador(ejbObjectOutput.getIdSoiOperador());
			retorno.setTipoPersonaEntidadFinanciera(TipoPersonaEntidadFinancieraType.valueOf(ejbObjectOutput.getTipoPersonaEntidadFinanciera()));
			retorno.setIdSoiTpPagadorPension(ejbObjectOutput.getIdSoiTpPagadorPension());
			retorno.setNombreTipoPagadoPension(ejbObjectOutput.getNombreTipoPagadoPension());
			retorno.setNombreUsuarioAdministrador(ejbObjectOutput.getNombreUsuarioAdministrador());
			retorno.setApellidoUsuarioAdministrador(ejbObjectOutput.getApellidoUsuarioAdministrador());
			retorno.setNombreCompletoUsuarioAdmin(ejbObjectOutput.getNombreCompletoUsuarioAdmin());
			retorno.setCodDepartamentoAportante(ejbObjectOutput.getCodDepartamentoAportante());
			retorno.setCodMunicipioAportante(ejbObjectOutput.getCodMunicipioAportante());
			retorno.setDireccionAportante(ejbObjectOutput.getDireccionAportante());
			retorno.setTelefonoAportante(ejbObjectOutput.getTelefonoAportante());
			retorno.setFax(ejbObjectOutput.getFaxAportante());
			retorno.setAportanteMigrado(ejbObjectOutput.getAportanteMigrado());
			retorno.setApteMigradoActDatos(ejbObjectOutput.getApteMigradoActDatos());
			retorno.setFechaRegistroMercantil(convertStringToCalendar(ejbObjectOutput
					.getFechaRegistroMercantil()));
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertInformacionAportantePlanilla");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto {@link com.ach.arc.biz.transfer.ArchivoEnProcesoDTO} en
	 * {@link ArchivoEnProcesoDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            , objeto {@link com.ach.arc.biz.transfer.ArchivoEnProcesoDTO} provisto por SOI
	 * @return {@link ArchivoEnProcesoDTO} con la información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static com.ach.arc.biz.transfer.ArchivoEnProcesoDTO convertArchivoEnProceso(
							ArchivoEnProcesoDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertArchivoEnProceso");
		com.ach.arc.biz.transfer.ArchivoEnProcesoDTO retorno = new com.ach.arc.biz.transfer.ArchivoEnProcesoDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIdArchivoEnProceso(ejbObjectOutput.getIdArchivoEnProceso());
			retorno.setPathArchivo(ejbObjectOutput.getPathArchivo());
			retorno.setIdAportante(ejbObjectOutput.getIdAportante());
			retorno.setEstadoProcesosArchivoPlanoType(EstadoProcesosArchivoPlanoType.valueOf(ejbObjectOutput.getEstadoProcesosArchivoPlanoType()));
			retorno.setIdSegUsuario(ejbObjectOutput.getIdSegUsuario());
			retorno.setNombreArchivo(ejbObjectOutput.getNombreArchivo());
			retorno.setIdSoiPlanilla(ejbObjectOutput.getIdSoiPlanilla());
			retorno.setIdNumeroDePlanilla(ejbObjectOutput.getIdNumeroDePlanilla());
			if ( ejbObjectOutput.getNotificacionDeArchivoEnProcesoType()!=null ){
				retorno.setNotificacionDeArchivoEnProcesoType(NotificacionDeArchivoEnProcesoType.valueOf(ejbObjectOutput.getNotificacionDeArchivoEnProcesoType()));
			}
			else{
				retorno.setNotificacionDeArchivoEnProcesoType(NotificacionDeArchivoEnProcesoType.NUEVA_NOTIFICACION);
			}
			retorno.setNumeroTotalDeEmpleadosEnPlanilla(ejbObjectOutput.getNumeroTotalDeEmpleadosEnPlanilla());
			retorno.setNombreAportante(ejbObjectOutput.getNombreAportante());
			retorno.setCodTpDocAportante(ejbObjectOutput.getCodTpDocAportante());
			retorno.setNroDocAportante(ejbObjectOutput.getNroDocAportante());
			
			try{
				retorno.setPeriodoSalud(new PeriodoType(ejbObjectOutput.getPeriodoSalud()));
				retorno.setPeriodoNoSalud(new PeriodoType(ejbObjectOutput.getPeriodoNoSalud()));
			}catch ( ApplicationException a ){
				a.printStackTrace();
				return null;
			}	
			
			retorno.setCodTipoPlanilla(ejbObjectOutput.getCodTipoPlanilla());
			retorno.setIdSoiTpPlanillaAsociada(ejbObjectOutput.getIdSoiTpPlanillaAsociada());
			retorno.setUsuarioAceptaPlanillaMNPagadaPorEsteOperador(ejbObjectOutput
					.getUsuarioAceptaPlanillaMNPagadaPorEsteOperador());
			retorno.setUsuarioAceptaRetroactivoPlanillaPublica(ejbObjectOutput
					.getUsuarioAceptaRetroactivoPlanillaPublica());
			retorno.setUsuarioCertificaCalculoInteresesMora(ejbObjectOutput.getUsuarioCertificaCalculoInteresesMora());
			retorno.setEnProcesoDeReValidacion(false);
			if ( ejbObjectOutput.getEnProcesoDeReValidacion()!=null )
				retorno.setEnProcesoDeReValidacion(ejbObjectOutput.getEnProcesoDeReValidacion());
			retorno.setInformacionPlanillaMNCorregida(convertInformacionPlanillaMNCorregida(ejbObjectOutput.getInformacionPlanillaMNCorregidaDTO()));
			retorno.setNumeroPlanillaAsociada(ejbObjectOutput.getNumeroPlanillaAsociada());
			retorno.setFechaPlanillaAsociada(convertStringToCalendar(ejbObjectOutput.getFechaPlanillaAsociada()));
			retorno.setTipoFormaPresentacionType(TipoFormasPresentacionType.valueOf(ejbObjectOutput.getTipoFormaPresentacionType()));
			retorno.setCodigoSucursal(ejbObjectOutput.getCodigoSucursal());
			retorno.setModificarPlanillaReferida(ejbObjectOutput.getModificarPlanillaReferida());
			retorno.setAceptaRenunciaLey1233(ejbObjectOutput.getAceptaRenunciaLey1233());
			if (ejbObjectOutput.getUsuarioAceptaDescuentoPymes()!=null)
				retorno.setUsuarioAceptaDescuentoPymes(ejbObjectOutput.getUsuarioAceptaDescuentoPymes());
			if (ejbObjectOutput.getPlanillaCorrector()!=null)
				retorno.setPlanillaCorrector(ejbObjectOutput.getPlanillaCorrector());
			retorno.setIdTmpCorrector(ejbObjectOutput.getIdTmpCorrector());
			retorno.setIdEstadoProcesoCorrector(ejbObjectOutput.getIdEstadoProcesoCorrector());
			retorno.setUrlArchivosCorrecciones(ejbObjectOutput.getUrlArchivosCorrecciones());
			if (ejbObjectOutput.getAceptoAutocorreccion()!=null)
				retorno.setAceptoAutocorreccion(ejbObjectOutput.getAceptoAutocorreccion());
			if (ejbObjectOutput.getGenerarErroresNoCorregibles()!=null)
				retorno.setGenerarErroresNoCorregibles(ejbObjectOutput.getGenerarErroresNoCorregibles());
			if (ejbObjectOutput.getConvertidor()!=null)
				retorno.setConvertidor(ejbObjectOutput.getConvertidor());
			if (ejbObjectOutput.getAportanteLey1607()!=null)
				retorno.setAportanteLey1607(ejbObjectOutput.getAportanteLey1607());
			if (ejbObjectOutput.getAportanteLey1429()!=null)
				retorno.setAportanteLey1429(ejbObjectOutput.getAportanteLey1429());
			if (ejbObjectOutput.getValidarSoloRegistrosT02()!=null)
				retorno.setValidarSoloRegistrosT02(ejbObjectOutput.getValidarSoloRegistrosT02());
			if (ejbObjectOutput.getPnllaArchivoEdicion()!=null)
				retorno.setPnllaArchivoEdicion(ejbObjectOutput.getPnllaArchivoEdicion());
			if (ejbObjectOutput.getContieneArchivoTipo1Consolidado()!=null)
				retorno.setContieneArchivoTipo1Consolidado(ejbObjectOutput.getContieneArchivoTipo1Consolidado());
			if (ejbObjectOutput.getEsPlanillaTipoU()!=null)
				retorno.setEsPlanillaTipoU(ejbObjectOutput.getEsPlanillaTipoU());
			if (ejbObjectOutput.getExisteApteNsoiPlanillaU()!=null)
				retorno.setExisteApteNsoiPlanillaU(ejbObjectOutput.getExisteApteNsoiPlanillaU());
			retorno.setIdClaseAptePlanillaU(ejbObjectOutput.getIdClaseAptePlanillaU());
			if (ejbObjectOutput.getIncluirNombres()!=null)
				retorno.setIncluirNombres(ejbObjectOutput.getIncluirNombres());
			if (ejbObjectOutput.getIncluirAdministradoras()!=null)
				retorno.setIncluirAdministradoras(ejbObjectOutput.getIncluirAdministradoras());
			if (ejbObjectOutput.getAdministradoraArchivo()!=null)
				retorno.setAdministradoraArchivo(ejbObjectOutput.getAdministradoraArchivo());
			if (ejbObjectOutput.getAplicaValidacionPlanillaPrevia()!=null)
				retorno.setAplicaValidacionPlanillaPrevia(ejbObjectOutput.getAplicaValidacionPlanillaPrevia());
			if (ejbObjectOutput.getEdicionRegTp2Corrector()!=null)
				retorno.setEdicionRegTp2Corrector(ejbObjectOutput.getEdicionRegTp2Corrector());
			retorno.setIdSoiTpEmpresa(ejbObjectOutput.getIdSoiTpEmpresa());
			retorno.getEpsModificadaBDUA().addAll(ejbObjectOutput.getEpsModificadaBDUA());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertArchivoEnProceso");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto {@link DepartamentoVO} en {@link DepartamentoDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            objeto {@link DepartamentoVO} provisto por SOI
	 * @return {@link DepartamentoDTO} con la información obtenida
	 */
	public static DepartamentoVO convertDepartamento(DepartamentoDTO ejbObjectOutput) {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertDepartamento");
		DepartamentoVO retorno = new DepartamentoVO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setNombreMostrar(ejbObjectOutput.getNombreMostrar());
			retorno.setNombre(ejbObjectOutput.getNombre());
			retorno.setCodigo(ejbObjectOutput.getCodigo());
			retorno.setIdSoiDepartamento(ejbObjectOutput.getIdSoiDepartamento());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertDepartamento");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto tipo {@link ValidacionArchivoDataSource} en {@link ValidacionArchivoDataSourceDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param ejbObjectOutput
	 *            Objeto {@link ValidacionArchivoDataSource} provisto por SOI
	 * @param planillaAportanteDTO
	 *            Objeto {@link com.ach.pla.biz.transfer.PlanillaAportanteDTO} provisto por SOI
	 * @return {@link ValidacionArchivoDataSourceDTO} con la información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static ValidacionArchivoDataSource convertValidacionArchivoDataSource(
			ValidacionArchivoDataSourceDTO ejbObjectOutput,
			PlanillaAportanteDTO planillaAportanteDTO) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.convertValidacionArchivoDataSource");
		com.ach.pla.biz.transfer.PlanillaAportanteDTO apteDto = convertPlanillaAportante(planillaAportanteDTO);
		ValidacionArchivoDataSource retorno = null;
		try{
			retorno = new ValidacionArchivoDataSource(apteDto);	
		}catch ( Exception e ){
			e.printStackTrace();
			return retorno;
		}
		
		if (Validation.isNotNull(ejbObjectOutput) && Validation.isNotNull(planillaAportanteDTO)) {
			obtenerListasAplicabilidad(retorno, ejbObjectOutput);
			obtenerListasObligatoriedad(retorno, ejbObjectOutput);
			obtenerEstructurasTarifas(retorno, ejbObjectOutput);
			obtenerAdministradoras(retorno, ejbObjectOutput);
			obtenerEstructurasTipoCotizante(retorno, ejbObjectOutput);
			obtenerEstructurasTipoId(retorno, ejbObjectOutput);
			obtenerMapasDeptoMunic(retorno, ejbObjectOutput);

			for (Map.Entry<Integer, ParametroDTO> parametro : ejbObjectOutput.getParametrosLiquidacion().entrySet()) {
				retorno.getParametrosLiquidacion().put(parametro.getKey(), convertParametro(parametro.getValue()));
			}
			

			Map<Integer,com.ach.cfg.biz.transfer.ParametroDTO> parametrosLiq = new HashMap<Integer, com.ach.cfg.biz.transfer.ParametroDTO>();
			for (Map.Entry<Integer, ParametroDTO> entry : ejbObjectOutput.getParametrosLiquidacion().entrySet()) {
				parametrosLiq.put(entry.getKey(), convertParametro(entry.getValue()));
			}
			retorno.setParametrosLiquidacion(parametrosLiq);
			
			//TODO: Parametros hardcode para pruebas
			if ( !retorno.getParametrosLiquidacion().containsKey(ParametrosType.PORC_APORTE_FOSYGA.getIdSoiParametro()) ){
				com.ach.cfg.biz.transfer.ParametroDTO param = new com.ach.cfg.biz.transfer.ParametroDTO();
				param.setAplicaMultiple(CommonVO.REGISTRO_ACTIVO);
				param.setIdSoiParametro(ParametrosType.PORC_APORTE_FOSYGA.getIdSoiParametro());
				param.setValorNumerico(BigDecimal.valueOf(1.5));
				retorno.getParametrosLiquidacion().put(param.getIdSoiParametro(), param);
			}
			if ( !retorno.getParametrosLiquidacion().containsKey(ParametrosType.TASA_FONDO_ARP.getIdSoiParametro()) ){
				com.ach.cfg.biz.transfer.ParametroDTO param1 = new com.ach.cfg.biz.transfer.ParametroDTO();
				param1.setAplicaMultiple(CommonVO.REGISTRO_ACTIVO);
				param1.setIdSoiParametro(ParametrosType.TASA_FONDO_ARP.getIdSoiParametro());
				param1.setValorNumerico(BigDecimal.valueOf(8));
				retorno.getParametrosLiquidacion().put(param1.getIdSoiParametro(), param1);
			}
			
			if ( ejbObjectOutput.getFechaPagoOportuno()!=null ){
				retorno.setFechaPagoOportuno(convertStringToCalendar(ejbObjectOutput.getFechaPagoOportuno()));
			}
			else{
				Calendar fechaPagoOportunoHc = Calendar.getInstance();
				fechaPagoOportunoHc.set(Calendar.DAY_OF_MONTH, fechaPagoOportunoHc.get(Calendar.DAY_OF_MONTH)+4);
				retorno.setFechaPagoOportuno(fechaPagoOportunoHc);
			}
			
			if ( ejbObjectOutput.getTimelyPaydayDTO()!=null ){
				retorno.setDiaPagoOportuno(new DiaPagoOportunoDTO());
				retorno.getDiaPagoOportuno().setDiaPagoOportuno(ejbObjectOutput.getTimelyPaydayDTO().getDiaPagoOportuno());
				retorno.getDiaPagoOportuno().setDigitosDeVerifiacion(ejbObjectOutput.getTimelyPaydayDTO().getDigitosVerificacion());
				retorno.getDiaPagoOportuno().setDiaPagoOportuno(ejbObjectOutput.getTimelyPaydayDTO().getDiaPagoOportuno());
				retorno.getDiaPagoOportuno().setIdSoiDiaPagoOportuno(ejbObjectOutput.getTimelyPaydayDTO().getIdSoiDiaPagoOportuno());
				retorno.getDiaPagoOportuno().setIdSoiFormaPresentacion(ejbObjectOutput.getTimelyPaydayDTO().getIdSoiFormaPresentacion());
			}
			
			retorno.setSeccionalesFiscalia(new ArrayList<SeccionalFiscaliaVO>());
			for (SeccionalFiscaliaDTO seccionalFis : ejbObjectOutput.getSeccionalesFiscalia()) {
				retorno.getSeccionalesFiscalia().add(convertSeccionalFiscalia(seccionalFis));
			}
			retorno.setClasesRiesgo(new ArrayList<RiesgoClaseVO>());
			for (RiesgoClaseDTO riesgoClase : ejbObjectOutput.getClasesRiesgo()) {
				retorno.getClasesRiesgo().add(convertRiesgoClase(riesgoClase));
			}
			retorno.setAportanteVo(convertAportante(ejbObjectOutput.getAportanteDTO()));
			retorno.setTopeSalarioIntegral(ejbObjectOutput.getTopeSalarioIntegral());
			retorno.setTpCotizante(ejbObjectOutput.getTpCotizante());
			retorno.setPlanillaApteDto(apteDto);
			retorno.getPropiedadesNec160Map().putAll(ejbObjectOutput.getPropiedadesNec160Map());
			retorno.setAportanteVo(convertAportante(ejbObjectOutput.getAportanteDTO()));
			
			retorno.addProperty("cods.tp.cztes.independientes", "3,16,33,34,35,36,42,43,52,53,56");
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ "co.swatit.pilautil.converter.Converter.convertValidacionArchivoDataSource");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte las estructuras de datos que contienen objetos de tipo
	 * {@link com.ach.pla.biz.transfer.AplicabilidadDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param wsOutputDTO
	 *            {@link ValidacionArchivoDataSourceDTO} objeto resultado de la conversión
	 * @param ejbObjectOutput
	 *            {@link ValidacionArchivoDataSource} objeto a convertir
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static void obtenerListasAplicabilidad(ValidacionArchivoDataSource wsOutputDTO,
			ValidacionArchivoDataSourceDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.obtenerListasAplicabilidad");
		wsOutputDTO.setRegistrosAplicabilidadApte(new ArrayList<com.ach.pla.biz.transfer.AplicabilidadDTO>());
		for (AplicabilidadDTO aplicabilidadApte : ejbObjectOutput.getRegistrosAplicabilidadApte()) {
			wsOutputDTO.getRegistrosAplicabilidadApte().add(convertAplicabilidad(aplicabilidadApte));
		}
		wsOutputDTO.setTiposCotizante(new ArrayList<com.ach.pla.biz.transfer.AplicabilidadDTO>());
		for (AplicabilidadDTO tipoCotizante : ejbObjectOutput.getTiposCotizante()) {
			wsOutputDTO.getTiposCotizante().add(convertAplicabilidad(tipoCotizante));
		}
		wsOutputDTO.setSubtiposCotizante(new ArrayList<com.ach.pla.biz.transfer.AplicabilidadDTO>());
		for (AplicabilidadDTO subtipoCotizante : ejbObjectOutput.getSubtiposCotizante()) {
			wsOutputDTO.getSubtiposCotizante().add(convertAplicabilidad(subtipoCotizante));
		}
		wsOutputDTO.setExtranjerias(new ArrayList<com.ach.pla.biz.transfer.AplicabilidadDTO>());
		for (AplicabilidadDTO extranjeria : ejbObjectOutput.getExtranjerias()) {
			wsOutputDTO.getExtranjerias().add(convertAplicabilidad(extranjeria));
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ "co.swatit.pilautil.converter.Converter.obtenerListasAplicabilidad");
	}

	/**
	 * 
	 * Método que convierte las estructuras de datos que contienen objetos de tipo
	 * {@link ObligatoriedadSubTipoCotizanteVO}, {@link ObligatoriedadAportanteVO} y
	 * {@link ObligatoriedadTipoCotizanteVO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param wsOutputDTO
	 *            {@link ValidacionArchivoDataSourceDTO} objeto resultado de la conversión
	 * @param ejbObjectOutput
	 *            {@link ValidacionArchivoDataSource} objeto a convertir
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static void obtenerListasObligatoriedad(ValidacionArchivoDataSource wsOutputDTO,
			ValidacionArchivoDataSourceDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.obtenerListasObligatoriedad");
		wsOutputDTO.setObligatoriedadesTipoCotizante(new ArrayList<ObligatoriedadTipoCotizanteVO>());
		for (ObligatoriedadTipoCotizanteDTO obligatoriedadTipoCoti : ejbObjectOutput.getObligatoriedadesTipoCotizante()) {
			wsOutputDTO.getObligatoriedadesTipoCotizante().add(
					convertObligatoriedadTipoCotizante(obligatoriedadTipoCoti));
		}
		wsOutputDTO.setObligatoriedadesSubTipoCotizante(new ArrayList<ObligatoriedadSubTipoCotizanteVO>());
		for (ObligatoriedadSubTipoCotizanteDTO obligatoriedadSubTipoCoti : ejbObjectOutput.getObligatoriedadesSubTipoCotizante()) {
			wsOutputDTO.getObligatoriedadesSubTipoCotizante().add(convertObligatoriedadSubTipoCotizante(obligatoriedadSubTipoCoti));
		}
		wsOutputDTO.setObligatoriedadesExtranjeria(new ArrayList<ObligatoriedadSubTipoCotizanteVO>());
		for (ObligatoriedadSubTipoCotizanteDTO obligatoriedadExtranjeria : ejbObjectOutput.getObligatoriedadesExtranjeria()) {
			wsOutputDTO.getObligatoriedadesExtranjeria().add(convertObligatoriedadSubTipoCotizante(obligatoriedadExtranjeria));
		}
		wsOutputDTO.setObligatoriedadesAportante(new ArrayList<ObligatoriedadAportanteVO>());
		for (ObligatoriedadAportanteDTO obligatoriedadAportante : ejbObjectOutput.getObligatoriedadesAportante()) {
			wsOutputDTO.getObligatoriedadesAportante().add(convertObligatoriedadAportante(obligatoriedadAportante));
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ "co.swatit.pilautil.converter.Converter.obtenerListasObligatoriedad");
	}

	/**
	 * 
	 * Método que convierte las estructuras de datos cuyos nombres indican que contienen datos de tarifas
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param wsOutputDTO
	 *            {@link ValidacionArchivoDataSourceDTO} objeto resultado de la conversión
	 * @param ejbObjectOutput
	 *            {@link ValidacionArchivoDataSource} objeto a convertir
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static void obtenerEstructurasTarifas(ValidacionArchivoDataSource wsOutputDTO,
			ValidacionArchivoDataSourceDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.obtenerMapasTarifas");
		wsOutputDTO.setTarifasPfGenerales(new HashMap<TipoSubSistemasType, Collection<BigDecimal>>());
		for (Map.Entry<String, List<BigDecimal>> entry : ejbObjectOutput.getTarifasPfGenerales().entrySet()) {
			ArrayList<BigDecimal> tarifas = new ArrayList<BigDecimal>(entry.getValue());
			wsOutputDTO.getTarifasPfGenerales().put(TipoSubSistemasType.valueOf(entry.getKey()), tarifas);
		}
		wsOutputDTO.setTarifasPfIndependientes(new HashMap<TipoSubSistemasType, Collection<BigDecimal>>());
		for (Map.Entry<String, List<BigDecimal>> entry : ejbObjectOutput.getTarifasPfIndependientes().entrySet()) {
			ArrayList<BigDecimal> tarifas = new ArrayList<BigDecimal>(entry.getValue());
			wsOutputDTO.getTarifasPfIndependientes().put(TipoSubSistemasType.valueOf(entry.getKey()), tarifas);
		}
		wsOutputDTO.setTarifasFsp(new ArrayList<com.ach.pla.biz.transfer.FspTarifaDTO>());
		for (FspTarifaDTO fspTarifa : ejbObjectOutput.getTarifasFsp()) {
			wsOutputDTO.getTarifasFsp().add(convertFspTarifa(fspTarifa));
		}
		wsOutputDTO.setListadoAdminTarifasEspeciales(new ArrayList<String>());
		wsOutputDTO.getListadoAdminTarifasEspeciales().addAll(ejbObjectOutput.getListadoAdminTarifasEspeciales());
		wsOutputDTO.setTarifasEspeciales(new ArrayList<BigDecimal>());
		wsOutputDTO.getTarifasEspeciales().addAll(ejbObjectOutput.getTarifasEspeciales());
		wsOutputDTO.setTarifasEspecialesSln(new ArrayList<BigDecimal>());
		wsOutputDTO.getTarifasEspecialesSln().addAll(ejbObjectOutput.getTarifasEspecialesSln());
		wsOutputDTO.setTarifaCcfGeneral(new ArrayList<BigDecimal>());
		wsOutputDTO.getTarifaCcfGeneral().addAll(ejbObjectOutput.getTarifaCcfGeneral());
		wsOutputDTO.setTarifaCcfIndependiente(new ArrayList<BigDecimal>());
		wsOutputDTO.getTarifaCcfIndependiente().addAll(ejbObjectOutput.getTarifaCcfIndependiente());
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.obtenerMapasTarifas");
	}

	/**
	 * 
	 * Método que convierte las estructuras de datos que contienen objetos de tipo
	 * {@link com.ach.cfg.biz.transfer.AdministradoraTarifaDTO} y {@link AdministradoraVO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/02/2017
	 *
	 * @param wsOutputDTO
	 *            {@link ValidacionArchivoDataSourceDTO} objeto resultado de la conversión
	 * @param ejbObjectOutput
	 *            {@link ValidacionArchivoDataSource} objeto a convertir
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static void obtenerAdministradoras(ValidacionArchivoDataSource wsOutputDTO,
			ValidacionArchivoDataSourceDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.obtenerAdministradoras");
		wsOutputDTO.setAdministradorasCcfMunicipios(new HashMap<String, String>());
		for (Map.Entry<String, String> entry : ejbObjectOutput.getAdministradorasCcfMunicipios().entrySet()) {
			wsOutputDTO.getAdministradorasCcfMunicipios().put(entry.getKey(), entry.getValue());
		}
		wsOutputDTO.setAdministradorasPension(new ArrayList<com.ach.cfg.biz.transfer.AdministradoraTarifaDTO>());
		for (AdministradoraTarifaDTO adminTarifa : ejbObjectOutput.getAdministradorasPension()) {
			wsOutputDTO.getAdministradorasPension().add(convertAdministradoraTarifa(adminTarifa));
		}
		wsOutputDTO.setAdministradorasSalud(new ArrayList<com.ach.cfg.biz.transfer.AdministradoraTarifaDTO>());
		for (AdministradoraTarifaDTO adminTarifa : ejbObjectOutput.getAdministradorasSalud()) {
			wsOutputDTO.getAdministradorasSalud().add(convertAdministradoraTarifa(adminTarifa));
		}
		wsOutputDTO.setAdministradorasParafiscales(new Hashtable<TipoSubSistemasType, AdministradoraVO>());
		for (Map.Entry<String, AdministradoraDTO> adminiParafiscales : ejbObjectOutput.getAdministradorasParafiscales().entrySet()) {
			wsOutputDTO.getAdministradorasParafiscales().put(TipoSubSistemasType.valueOf(adminiParafiscales.getKey()),
					convertAdministradora(adminiParafiscales.getValue()));
		}
		wsOutputDTO.setAdministradorasSaludLey1607(new ArrayList<com.ach.cfg.biz.transfer.AdministradoraTarifaDTO>());
		for (AdministradoraTarifaDTO adminSalud : ejbObjectOutput.getAdministradorasSaludLey1607()) {
			wsOutputDTO.getAdministradorasSaludLey1607().add(convertAdministradoraTarifa(adminSalud));
		}
		
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "Administradoras ARL/CCF en modo hardcode");
		
		//TODO: Administradoras Riesgo HARDCODE para test
		wsOutputDTO.setAdministradorasRiesgoYCcf(new ArrayList<AdministradoraVO>());
		for (AdministradoraDTO adm : ejbObjectOutput.getAdministradorasRiesgoYCcf()) {
			AdministradoraVO admVo = new AdministradoraVO();
			admVo.setCodAdministradora(adm.getCodAdministradora());
			admVo.setIdSoiAdministradora(adm.getIdSoiAdministradora());
			admVo.setNombre(adm.getNombre());
			admVo.setNombreMostrar(adm.getNombreMostrar());
			admVo.setIdTpIdentificacion(adm.getIdTpIdentificacion());
			admVo.setNumeroIdentificacion(adm.getNumeroIdentificacion());
			admVo.setIdSoiSubsistema(adm.getIdSoiSubsistema());
			admVo.setVigente(adm.getVigente());
			admVo.setNaturaleza(adm.getNaturaleza());
			wsOutputDTO.getAdministradorasRiesgoYCcf().add(admVo);
		}
		
		
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.obtenerAdministradoras");
	}

	/**
	 * 
	 * Método que convierte las estructuras de datos que contienen objetos de tipo {@link DepartamentoVO} y
	 * {@link MunicipioVO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 15/02/2017
	 *
	 * @param wsOutputDTO
	 *            {@link ValidacionArchivoDataSourceDTO} objeto resultado de la conversión
	 * @param ejbObjectOutput
	 *            {@link ValidacionArchivoDataSource} objeto a convertir
	 */
	public static void obtenerMapasDeptoMunic(ValidacionArchivoDataSource wsOutputDTO,
			ValidacionArchivoDataSourceDTO ejbObjectOutput) {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.obtenerMapasDeptoMunic");
		wsOutputDTO.setDepartamentosMap(new HashMap<String, DepartamentoVO>());
		for (Map.Entry<String, DepartamentoDTO> depto : ejbObjectOutput.getDepartamentosMap().entrySet()) {
			wsOutputDTO.getDepartamentosMap().put(depto.getKey(), convertDepartamento(depto.getValue()));
		}
		wsOutputDTO.setMunicipiosMap(new HashMap<String, MunicipioVO>());
		for (Map.Entry<String, MunicipioDTO> municipio : ejbObjectOutput.getMunicipiosMap().entrySet()) {
			wsOutputDTO.getMunicipiosMap().put(municipio.getKey(), convertMunicipio(municipio.getValue()));
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.obtenerMapasDeptoMunic");
	}

	/**
	 * 
	 * Método que convierte las estructuras de datos que contienen objetos de tipo {@link TipoCotizanteVO} y
	 * {@link SubTipoCotizanteVO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 15/02/2017
	 *
	 * @param wsOutputDTO
	 *            {@link ValidacionArchivoDataSourceDTO} objeto resultado de la conversión
	 * @param ejbObjectOutput
	 *            {@link ValidacionArchivoDataSource} objeto a convertir
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static void obtenerEstructurasTipoCotizante(ValidacionArchivoDataSource wsOutputDTO,
			ValidacionArchivoDataSourceDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.obtenerEstructurasTipoCotizante");
		wsOutputDTO.setTiposCotizanteMap(new HashMap<Integer, TipoCotizanteVO>());
		for (Map.Entry<Integer, TipoCotizanteDTO> tipoCotizante : ejbObjectOutput.getTiposCotizanteMap().entrySet()) {
			wsOutputDTO.getTiposCotizanteMap().put(tipoCotizante.getKey(),convertTipoCotizante(tipoCotizante.getValue()));
		}
		wsOutputDTO.setSubtiposCotizanteMap(new HashMap<Integer, SubTipoCotizanteVO>());
		for (Map.Entry<Integer, SubTipoCotizanteDTO> subtipoCotizante : ejbObjectOutput.getSubtiposCotizanteMap().entrySet()) {
			wsOutputDTO.getSubtiposCotizanteMap().put(subtipoCotizante.getKey(),convertSubTipoCotizante(subtipoCotizante.getValue()));

		}
		wsOutputDTO.setExtranjeriaCotizanteMap(new HashMap<Integer, SubTipoCotizanteVO>());
		for (Map.Entry<Integer, SubTipoCotizanteDTO> subtipoCotizanteExt : ejbObjectOutput.getExtranjeriaCotizanteMap().entrySet()) {
			wsOutputDTO.getExtranjeriaCotizanteMap().put(subtipoCotizanteExt.getKey(),convertSubTipoCotizante(subtipoCotizanteExt.getValue()));
		}
		wsOutputDTO.setCodTpsCotizanteDependientesNr415(new String[ejbObjectOutput.getCodTpsCotizanteDependientesNr415().size()]);
		int index = 0;
		for (String codTpsCotizante : ejbObjectOutput.getCodTpsCotizanteDependientesNr415()) {
			wsOutputDTO.getCodTpsCotizanteDependientesNr415()[index] = codTpsCotizante;
			index++;
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ "co.swatit.pilautil.converter.Converter.obtenerEstructurasTipoCotizante");
	}

	/**
	 * 
	 * Método que convierte las estructuras de datos que contienen objetos de tipo {@link TipoIdentificacionVO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 15/02/2017
	 *
	 * @param wsOutputDTO
	 *            {@link ValidacionArchivoDataSourceDTO} objeto resultado de la conversión
	 * @param ejbObjectOutput
	 *            {@link ValidacionArchivoDataSource} objeto a convertir
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static void obtenerEstructurasTipoId(ValidacionArchivoDataSource wsOutputDTO,
			ValidacionArchivoDataSourceDTO ejbObjectOutput) throws BusinessException {
		for (TipoIdentificacionDTO tipoId : ejbObjectOutput.getTiposDocumentosCotizantes()) {
			wsOutputDTO.getTiposDocumentosCotizantes().add(convertTipoIdentificacion(tipoId));
		}
		for (Map.Entry<String, List<TipoIdentificacionDTO>> tipoDocTipoCot : ejbObjectOutput.getTiposDocumentoPorTipoCotizante().entrySet()) {
			ArrayList<TipoIdentificacionVO> tipoIdentificacion = new ArrayList<TipoIdentificacionVO>();
			for (TipoIdentificacionDTO tpId : tipoDocTipoCot.getValue()) {
				tipoIdentificacion.add(convertTipoIdentificacion(tpId));
			}
			wsOutputDTO.getTiposDocumentoPorTipoCotizante().put(tipoDocTipoCot.getKey(), tipoIdentificacion);
		}
	}
	
	
}

package co.swatit.pilautil.converter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ach.apt.biz.model.AportanteVO;
import com.ach.apt.biz.model.ObligatoriedadAportanteVO;
import com.ach.apt.biz.model.ObligatoriedadSubTipoCotizanteVO;
import com.ach.apt.biz.model.ObligatoriedadTipoCotizanteVO;
import com.ach.arc.biz.r1747.util.ValidacionArchivoDataSource;
import com.ach.cfg.biz.model.AdministradoraVO;
import com.ach.cfg.biz.model.DepartamentoVO;
import com.ach.cfg.biz.model.MunicipioVO;
import com.ach.cfg.biz.model.ParametroVO;
import com.ach.cfg.biz.model.RiesgoClaseVO;
import com.ach.cfg.biz.model.TipoIdentificacionVO;
import com.ach.cfg.biz.model.ValorParametroVO;
import com.ach.cfg.biz.type.NormatividadType;
import com.ach.cfg.biz.type.TipoSubSistemasType;
import com.ach.pla.biz.model.AporteSubsistemaVO;
import com.ach.pla.biz.model.DatosBasicosCotizanteVO;
import com.ach.pla.biz.model.SeccionalFiscaliaVO;
import com.ach.pla.biz.model.SubTipoCotizanteVO;
import com.ach.pla.biz.model.TipoCotizanteVO;
import com.ach.pla.biz.model.VariacionSalarioVO;
import com.ach.pla.biz.transfer.DiaPagoOportunoDTO;
import com.ach.pla.biz.transfer.InformacionBasicaCotizanteDTO;
import com.ach.pla.biz.transfer.InformacionPlanillaMNCorregida;
import com.ach.pla.biz.transfer.PlanillaConsultadaListadoDTO;
import com.ach.seg.biz.model.RecursoVO;
import com.ach.seg.biz.model.UsuarioVO;
import com.ach.seg.biz.transfer.RecursoDTO;
import com.ach.seg.biz.transfer.UsuarioAutenticadoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import co.swatit.pilautil.dto.out.AdministradoraDTO;
import co.swatit.pilautil.dto.out.AdministradoraTarifaDTO;
import co.swatit.pilautil.dto.out.AplicabilidadDTO;
import co.swatit.pilautil.dto.out.AportanteDTO;
import co.swatit.pilautil.dto.out.AportanteFilialDTO;
import co.swatit.pilautil.dto.out.AporteSubsistemaDTO;
import co.swatit.pilautil.dto.out.ArchivoEnProcesoDTO;
import co.swatit.pilautil.dto.out.AuthenticatedUserDTO;
import co.swatit.pilautil.dto.out.DatosBasicosCotizanteDTO;
import co.swatit.pilautil.dto.out.DepartamentoDTO;
import co.swatit.pilautil.dto.out.DetalleParametroDTO;
import co.swatit.pilautil.dto.out.FspTarifaDTO;
import co.swatit.pilautil.dto.out.InformacionAportantePlanillaDTO;
import co.swatit.pilautil.dto.out.InformacionPlanillaMNCorregidaDTO;
import co.swatit.pilautil.dto.out.MunicipioDTO;
import co.swatit.pilautil.dto.out.NovedadDTO;
import co.swatit.pilautil.dto.out.ObligatoriedadAportanteDTO;
import co.swatit.pilautil.dto.out.ObligatoriedadDTO;
import co.swatit.pilautil.dto.out.ObligatoriedadSubTipoCotizanteDTO;
import co.swatit.pilautil.dto.out.ObligatoriedadTipoCotizanteDTO;
import co.swatit.pilautil.dto.out.ParametroDTO;
import co.swatit.pilautil.dto.out.PayrollContributorDTO;
import co.swatit.pilautil.dto.out.PayrollDetailDTO;
import co.swatit.pilautil.dto.out.PlanillaAportanteDTO;
import co.swatit.pilautil.dto.out.PlanillaCotizanteDTO;
import co.swatit.pilautil.dto.out.ResourceDTO;
import co.swatit.pilautil.dto.out.ResourceDetailDTO;
import co.swatit.pilautil.dto.out.ResultadoValidacionBduaDTO;
import co.swatit.pilautil.dto.out.RiesgoClaseDTO;
import co.swatit.pilautil.dto.out.SeccionalFiscaliaDTO;
import co.swatit.pilautil.dto.out.SubTipoCotizanteDTO;
import co.swatit.pilautil.dto.out.TimelyPaydayDTO;
import co.swatit.pilautil.dto.out.TipoCotizanteDTO;
import co.swatit.pilautil.dto.out.TipoIdentificacionDTO;
import co.swatit.pilautil.dto.out.UserDTO;
import co.swatit.pilautil.dto.out.ValidacionArchivoDataSourceDTO;
import co.swatit.pilautil.dto.out.ValorParametroDTO;
import co.swatit.pilautil.dto.out.VariacionSalarioDTO;
import co.swatit.pilautil.exception.BusinessException;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;
import co.swatit.pilautil.generics.Constants;
import co.swatit.pilautil.generics.Utilities;
import co.swatit.pilautil.generics.Validation;
import co.swatit.pilautil.request.rest.ParserUtils;

/**
 * Clase que provee todos los métodos que convierten objetos SOI en objetos de transporte
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public final class Converter {

	private static final Logger LOGGER = Logger.getLogger(Converter.class.getName());

	private Converter() {
		// constructor vacío intencionalmente
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
	public static AdministradoraDTO convertAdministradora(AdministradoraVO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertAdministradora");
		AdministradoraDTO retorno = new AdministradoraDTO();
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
			retorno.setFechaFusion(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFusion()));
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
			retorno.setFechaInicioVigenciaCobertura(Utilities.convertCalendarToString(ejbObjectOutput
					.getFechaInicioVigenciaCobertura()));
			retorno.setFechaFinVigenciaCobertura(Utilities.convertCalendarToString(ejbObjectOutput
					.getFechaFinVigenciaCobertura()));
			AdministradoraVO adminVO = ejbObjectOutput.getAdministradoraFusion();
			if (Validation.isNotNull(adminVO)) {
				retorno.setAdministradoraFusion(convertAdministradora(ejbObjectOutput.getAdministradoraFusion()));
			}
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertAdministradora");
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
	public static AplicabilidadDTO convertAplicabilidad(com.ach.pla.biz.transfer.AplicabilidadDTO ejbObjectOutput)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertAplicabilidad");
		AplicabilidadDTO retorno = new AplicabilidadDTO();
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
			retorno.setFechaInicioVigenciaTpCzte(Utilities.convertCalendarToString(ejbObjectOutput
					.getFechaInicioVigenciaTpCzte()));
			retorno.setFechaFinVigenciaTpCzte(Utilities.convertCalendarToString(ejbObjectOutput
					.getFechaFinVigenciaTpCzte()));
			retorno.setIdSoiAplicabilidad(ejbObjectOutput.getIdSoiAplicabilidad());
			retorno.setAporteCajaCompensacion(ejbObjectOutput.getAporteCajaCompensacion());
			retorno.setIdSoiMunicipio(ejbObjectOutput.getIdSoiMunicipio());
			retorno.setValidarMunicipioTpCotizante(ejbObjectOutput.isValidarMunicipioTpCotizante());
			retorno.setValidarTipoIdentificacionCzte(ejbObjectOutput.isValidarTipoIdentificacionCzte());
			retorno.setOrigenPlanillaN(ejbObjectOutput.isOrigenPlanillaN());
			retorno.setOrigenPlanillaM(ejbObjectOutput.isOrigenPlanillaM());
			retorno.setNoAplicaCotizanteConcejal(ejbObjectOutput.isNoAplicaCotizanteConcejal());
			retorno.setFiltroPlanillaVigente(ejbObjectOutput.isFiltroPlanillaVigente());
			retorno.setPlanillaVigente(ejbObjectOutput.getPlanillaVigente());
			retorno.setAplicaNyM(ejbObjectOutput.getAplicaNyM());
			retorno.setTipoEmpresaAplicabilidad(ejbObjectOutput.getTipoEmpresaAplicabilidad());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertAplicabilidad");
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
	public static MunicipioDTO convertMunicipio(MunicipioVO ejbObjectOutput) {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertMunicipio");
		MunicipioDTO retorno = new MunicipioDTO();
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
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertMunicipio");
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
	public static AportanteFilialDTO convertAportanteFilial(com.ach.apt.biz.transfer.AportanteFilialDTO ejbObjectOutput) {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertAportanteFilial");
		AportanteFilialDTO retorno = new AportanteFilialDTO();
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
			retorno.setEsAdministrador(ejbObjectOutput.isEsAdministrador());
			retorno.setCantPlanillaFilial(ejbObjectOutput.getCantPlanillaFilial());
			retorno.setEventoSucursal(Utilities.getEnumName(ejbObjectOutput.getEventoSucursal()));
			LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
					+ "co.swatit.pilautil.converter.Converter.convertAportanteFilial");
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
	public static ObligatoriedadAportanteDTO convertObligatoriedadAportante(ObligatoriedadAportanteVO ejbObjectOutput)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.convertObligatoriedadAportante");
		ObligatoriedadAportanteDTO retorno = new ObligatoriedadAportanteDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIpModificacion(ejbObjectOutput.getIpModificacion());
			retorno.setFechaModificacion(Utilities.convertCalendarToString(ejbObjectOutput.getFechaModificacion()));
			retorno.setUsuarioModificacion(ejbObjectOutput.getUsuarioModificacion());
			retorno.setIpCreacion(ejbObjectOutput.getIpCreacion());
			retorno.setFechaCreacion(Utilities.convertCalendarToString(ejbObjectOutput.getFechaCreacion()));
			retorno.setUsuarioCreacion(ejbObjectOutput.getUsuarioCreacion());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setFechaInicioVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setTpObligatoriedad(ejbObjectOutput.getTpObligatoriedad());
			retorno.setIdSoiSubsistema(ejbObjectOutput.getIdSoiSubsistema());
			retorno.setIdSoiAportante(ejbObjectOutput.getIdSoiAportante());
			retorno.setIdSoiOblgAportante(ejbObjectOutput.getIdSoiOblgAportante());
			retorno.setIpModificacion1(ejbObjectOutput.getIpModificacion1());
			retorno.setFechaModificacion1(Utilities.convertCalendarToString(ejbObjectOutput.getFechaModificacion1()));
			retorno.setUsuarioModificacion1(ejbObjectOutput.getUsuarioModificacion1());
			retorno.setIpCreacion1(ejbObjectOutput.getIpCreacion1());
			retorno.setFechaCreacion1(Utilities.convertCalendarToString(ejbObjectOutput.getFechaCreacion1()));
			retorno.setUsuarioCreacion1(ejbObjectOutput.getUsuarioCreacion1());
			retorno.setCausaFinVigencia1(ejbObjectOutput.getCausaFinVigencia1());
			retorno.setFechaFinVigencia1(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFinVigencia1()));
			retorno.setFechaInicioVigencia1(Utilities.convertCalendarToString(ejbObjectOutput
					.getFechaInicioVigencia1()));
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
			retorno.setFechaModificacion2(Utilities.convertCalendarToString(ejbObjectOutput.getFechaModificacion2()));
			retorno.setUsuarioModificacion2(ejbObjectOutput.getUsuarioModificacion2());
			retorno.setIpCreacion2(ejbObjectOutput.getIpCreacion2());
			retorno.setFechaCreacion2(Utilities.convertCalendarToString(ejbObjectOutput.getFechaCreacion2()));
			retorno.setUsuarioCreacion2(ejbObjectOutput.getUsuarioCreacion2());
			retorno.setApellido(ejbObjectOutput.getApellido());
			retorno.setCausaFinVigencia2(ejbObjectOutput.getCausaFinVigencia2());
			retorno.setFechaFinVigencia2(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFinVigencia2()));
			retorno.setVigente2(ejbObjectOutput.getVigente2());
			retorno.setFechaInicioVigencia2(Utilities.convertCalendarToString(ejbObjectOutput
					.getFechaInicioVigencia2()));
			retorno.setIdArp(ejbObjectOutput.getIdArp());
			retorno.setIdCcf(ejbObjectOutput.getIdCcf());
			retorno.setAporteEsapMinedu(ejbObjectOutput.getAporteEsapMinedu());
			retorno.setCodTpPersonaFinanciera(ejbObjectOutput.getCodTpPersonaFinanciera());
			retorno.setIdSoiTpPagadorPension(ejbObjectOutput.getIdSoiTpPagadorPension());
			retorno.setFechaFinAccion(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFinAccion()));
			retorno.setFechaInicioAccion(Utilities.convertCalendarToString(ejbObjectOutput.getFechaInicioAccion()));
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
	public static AportanteDTO convertAportante(AportanteVO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertAportante");
		AportanteDTO retorno = new AportanteDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setPagoElectronicoOc(ejbObjectOutput.getPagoElectronicoOc());
			retorno.setPermiteGeneracionCsv(ejbObjectOutput.getPermiteGeneracionCsv());
			retorno.setCantidadMaximaErrores(ejbObjectOutput.getCantidadMaximaErrores());
			retorno.setFechaActInformacion(Utilities.convertCalendarToString(ejbObjectOutput.getFechaActInformacion()));
			retorno.setActualizoInformacion(ejbObjectOutput.getActualizoInformacion());
			retorno.setAporteCajaCompensacion(ejbObjectOutput.getAporteCajaCompensacion());
			retorno.setFechaCreacionEmpresa(Utilities.convertCalendarToString(ejbObjectOutput
					.getFechaCreacionEmpresa()));
			retorno.setApteMigradoActDatos(ejbObjectOutput.getApteMigradoActDatos());
			retorno.setAportanteMigrado(ejbObjectOutput.getAportanteMigrado());
			retorno.setCtaEntidadFinanciera(ejbObjectOutput.getCtaEntidadFinanciera());
			retorno.setCelular(ejbObjectOutput.getCelular());
			retorno.setCorreo(ejbObjectOutput.getCorreo());
			retorno.setInfoViaCelular(ejbObjectOutput.getInfoViaCelular());
			retorno.setInfoViaCorreo(ejbObjectOutput.getInfoViaCorreo());
			retorno.setIpModificacion(ejbObjectOutput.getIpModificacion());
			retorno.setFechaModificacion(Utilities.convertCalendarToString(ejbObjectOutput.getFechaModificacion()));
			retorno.setUsuarioModificacion(ejbObjectOutput.getUsuarioModificacion());
			retorno.setIpCreacion(ejbObjectOutput.getIpCreacion());
			retorno.setFechaCreacion(Utilities.convertCalendarToString(ejbObjectOutput.getFechaCreacion()));
			retorno.setUsuarioCreacion(ejbObjectOutput.getUsuarioCreacion());
			retorno.setApellido(ejbObjectOutput.getApellido());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setFechaInicioVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setIdArp(ejbObjectOutput.getIdArp());
			retorno.setIdCcf(ejbObjectOutput.getIdCcf());
			retorno.setAporteEsapMinedu(ejbObjectOutput.getAporteEsapMinedu());
			retorno.setCodTpPersonaFinanciera(ejbObjectOutput.getCodTpPersonaFinanciera());
			retorno.setIdSoiTpPagadorPension(ejbObjectOutput.getIdSoiTpPagadorPension());
			retorno.setFechaFinAccion(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFinAccion()));
			retorno.setFechaInicioAccion(Utilities.convertCalendarToString(ejbObjectOutput.getFechaInicioAccion()));
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
	public static PlanillaAportanteDTO convertPlanillaAportante(
			com.ach.pla.biz.transfer.PlanillaAportanteDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.convertPlanillaAportante");
		PlanillaAportanteDTO retorno = new PlanillaAportanteDTO();
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
			retorno.setConvertidor(ejbObjectOutput.isConvertidor());
			retorno.setPeriodoLiquidacionSalud(ejbObjectOutput.getPeriodoLiquidacionSalud().getPeriodoString());
			retorno.setPeriodoLiquidacionNoSalud(ejbObjectOutput.getPeriodoLiquidacionNoSalud().getPeriodoString());
			retorno.setNumeroPlanillaAsocida(ejbObjectOutput.getNumeroPlanillaAsocida());
			retorno.setFechaPagoPlanillaAsociada(Utilities.convertCalendarToString(ejbObjectOutput
					.getFechaPagoPlanillaAsociada()));
			retorno.setFechaPagoPlanillaAsociadaCadena(ejbObjectOutput.getFechaPagoPlanillaAsociadaCadena());
			retorno.setIdSoiTpPlanillaAsociada(ejbObjectOutput.getIdSoiTpPlanillaAsociada());
			retorno.setCodigoSoiTpPlanillaAsociada(ejbObjectOutput.getCodigoSoiTpPlanillaAsociada());
			retorno.setNombreSoiTpPlanillaAsociada(ejbObjectOutput.getNombreSoiTpPlanillaAsociada());
			retorno.setIdSoiAdministradoraARPPlanillaAsociada(ejbObjectOutput
					.getIdSoiAdministradoraARPPlanillaAsociada());
			retorno.setNombreARPPlanillaAsociada(ejbObjectOutput.getNombreARPPlanillaAsociada());
			retorno.setCodAdministradoraARPPlanillaAsociada(ejbObjectOutput.getCodAdministradoraARPPlanillaAsociada());
			retorno.setEstadoPlanilla(Utilities.getEnumName(ejbObjectOutput.getEstadoPlanilla()));
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
			retorno.setTipoPlanillaBloquedada(ejbObjectOutput.isTipoPlanillaBloquedada());
			retorno.setClaseAportanteBoI(ejbObjectOutput.isClaseAportanteBoI());
			retorno.setValorPagado(ejbObjectOutput.getValorPagado());
			retorno.setFechaDePagoEfectiva(Utilities.convertCalendarToString(ejbObjectOutput.getFechaDePagoEfectiva()));
			retorno.setUsuarioModificaInformacionAportante(ejbObjectOutput.isUsuarioModificaInformacionAportante());
			retorno.setPlanilaAsociadaMNExiste(ejbObjectOutput.isPlanilaAsociadaMNExiste());
			retorno.setPlanilaAsociadaTExiste(ejbObjectOutput.isPlanilaAsociadaTExiste());
			retorno.setUsuarioAceptaPlanillaMNPagadaPorEsteOperador(ejbObjectOutput
					.isUsuarioAceptaPlanillaMNPagadaPorEsteOperador());
			retorno.setPlanillaPublicaPreguntarSiEsRetroactivo(ejbObjectOutput
					.isPlanillaPublicaPreguntarSiEsRetroactivo());
			retorno.setUsuarioAceptaRetroactivoPlanillaPublica(ejbObjectOutput
					.isUsuarioAceptaRetroactivoPlanillaPublica());
			retorno.setCertificaCalculoInteresesMora(ejbObjectOutput.isCertificaCalculoInteresesMora());
			retorno.setNumeroDiasExistenciaEmpresa(ejbObjectOutput.getNumeroDiasExistenciaEmpresa());
			retorno.setNumeroAnosExistenciaEmpresa(ejbObjectOutput.getNumeroAnosExistenciaEmpresa());
			retorno.setUsuarioAceptaDescuentoPymes(ejbObjectOutput.isUsuarioAceptaDescuentoPymes());
			retorno.setRecalcularMora(ejbObjectOutput.isRecalcularMora());
			retorno.setAportanteLey1607(ejbObjectOutput.isAportanteLey1607());
			retorno.setAportanteLey1429(ejbObjectOutput.isAportanteLey1429());
			retorno.setTipoPlanillaAplicaLey1607(ejbObjectOutput.isTipoPlanillaAplicaLey1607());
			retorno.setAplicaPeriodoMayorIgualAbr1994(ejbObjectOutput.isAplicaPeriodoMayorIgualAbr1994());
			retorno.setAplicaPeriodoMenorIgualDic2002(ejbObjectOutput.isAplicaPeriodoMenorIgualDic2002());
			retorno.setIdSoiAportante(ejbObjectOutput.getIdSoiAportante());
			retorno.setCodigoTpPlanillaExistente(ejbObjectOutput.getCodigoTpPlanillaExistente());
			retorno.setExistenPlanillasBase(ejbObjectOutput.isExistenPlanillasBase());
			retorno.setCantidadMaximaErrores(ejbObjectOutput.getCantidadMaximaErrores());
			retorno.setPermiteGeneracionCsv(ejbObjectOutput.isPermiteGeneracionCsv());
			retorno.setIdSoiSoporteUsuario(ejbObjectOutput.getIdSoiSoporteUsuario());
			retorno.setExisteApteNsoiPlanillaU(ejbObjectOutput.isExisteApteNsoiPlanillaU());
			retorno.setExisteApteUgpp(ejbObjectOutput.isExisteApteUgpp());
			retorno.setNumeroDiasMoraPnllaJ(ejbObjectOutput.getNumeroDiasMoraPnllaJ());
			retorno.setEdicionPlanillaArchivo(ejbObjectOutput.isEdicionPlanillaArchivo());
			retorno.setEsPreliquidacion(ejbObjectOutput.isEsPreliquidacion());
			retorno.setAplicaValidacionPlanillaPrevia(ejbObjectOutput.isAplicaValidacionPlanillaPrevia());
			retorno.setPlanillaJReferida(ejbObjectOutput.isPlanillaJReferida());
			retorno.setCreacionPlanilla(ejbObjectOutput.isCreacionPlanilla());
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
			retorno.setApteSeccionalFiscalia(ejbObjectOutput.isApteSeccionalFiscalia());
			retorno.setExitePlanillaPreviaResolucion1233(ejbObjectOutput.isExitePlanillaPreviaResolucion1233());
			retorno.setUsuarioSolicitaCambioNormatividad(ejbObjectOutput.isUsuarioSolicitaCambioNormatividad());
			retorno.setInformacionAportantePlanillaDTO(convertInformacionAportantePlanilla(ejbObjectOutput
					.getInformacionAportantePlanillaDTO()));
			Map<TipoSubSistemasType, Collection<AdministradoraVO>> adminAportante = ejbObjectOutput
					.getAdministradorasAportante();
			if (Validation.isNotNull(adminAportante)) {
				for (Map.Entry<TipoSubSistemasType, Collection<AdministradoraVO>> entry : adminAportante.entrySet()) {
					ArrayList<AdministradoraDTO> adminRetorno = new ArrayList<AdministradoraDTO>();
					for (AdministradoraVO convertir : entry.getValue()) {
						adminRetorno.add(convertAdministradora(convertir));
					}
					retorno.getAdministradorasAportante().put(Utilities.getEnumName(entry.getKey()), adminRetorno);
				}
			}
			Map<Integer, Collection<BigDecimal>> mapaTarifas = ejbObjectOutput.getTarifasAportante();
			if (Validation.isNotNull(mapaTarifas)) {
				for (Map.Entry<Integer, Collection<BigDecimal>> entry : mapaTarifas.entrySet()) {
					ArrayList<BigDecimal> tarifaRetorno = new ArrayList<BigDecimal>();
					for (BigDecimal convertir : entry.getValue()) {
						tarifaRetorno.add(convertir);
					}
					retorno.getTarifasAportante().put(entry.getKey(), tarifaRetorno);
				}
			}
			Map<NormatividadType, Boolean> mapaNormatividad = ejbObjectOutput.getNormatividad();
			retorno.setNormatividad(new HashMap<String, Boolean>());
			if (Validation.isNotNull(mapaNormatividad)) {
				for (Map.Entry<NormatividadType, Boolean> entry : mapaNormatividad.entrySet()) {
					retorno.getNormatividad().put(Utilities.getEnumName(entry.getKey()), entry.getValue());
				}
			}
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ "co.swatit.pilautil.converter.Converter.convertPlanillaAportante");
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
	public static ObligatoriedadSubTipoCotizanteDTO convertObligatoriedadSubTipoCotizante(
			ObligatoriedadSubTipoCotizanteVO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.convertObligatoriedadSubTipoCotizante");
		ObligatoriedadSubTipoCotizanteDTO retorno = new ObligatoriedadSubTipoCotizanteDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setFechaInicioVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setTpObligatoriedad(ejbObjectOutput.getTpObligatoriedad());
			retorno.setIdSoiSubsistema(ejbObjectOutput.getIdSoiSubsistema());
			retorno.setIdSoiSubtpCotizante(ejbObjectOutput.getIdSoiSubtpCotizante());
			retorno.setIdSoiOblgSubtpCotizante(ejbObjectOutput.getIdSoiOblgSubtpCotizan());
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
	public static SubTipoCotizanteDTO convertSubTipoCotizante(SubTipoCotizanteVO ejbObjectOutput)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertSubTipoCotizante");
		SubTipoCotizanteDTO retorno = new SubTipoCotizanteDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setNecesitaRegistroPrevio(ejbObjectOutput.getNecesitaRegistroPrevio());
			retorno.setMaxSbCantSmmlv(ejbObjectOutput.getMaxSbCantSmmlv());
			retorno.setMinSbCantSmmlv(ejbObjectOutput.getMinSbCantSmmlv());
			retorno.setExtranjeria(ejbObjectOutput.getExtranjeria());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setFechaInicioVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaInicioVigencia()));
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
	public static ObligatoriedadTipoCotizanteDTO convertObligatoriedadTipoCotizante(
			ObligatoriedadTipoCotizanteVO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.convertObligatoriedadTipoCotizante");
		ObligatoriedadTipoCotizanteDTO retorno = new ObligatoriedadTipoCotizanteDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setMaxIbcCotizadoCantSmmlv(ejbObjectOutput.getMaxIbcCotizadoCantSmmlv());
			retorno.setMinIbcCotizadoCantSmmlv(ejbObjectOutput.getMinIbcCotizadoCantSmmlv());
			retorno.setMaxCantDiaCotizado(ejbObjectOutput.getMaxCantDiaCotizado());
			retorno.setMinCantDiaCotizado(ejbObjectOutput.getMinCantDiaCotizado());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setFechaInicioVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaInicioVigencia()));
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
	public static TipoCotizanteDTO convertTipoCotizante(TipoCotizanteVO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertTipoCotizante");
		TipoCotizanteDTO retorno = new TipoCotizanteDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setNecesitaRegistroPrevio(ejbObjectOutput.getNecesitaRegistroPrevio());
			retorno.setMaxSbCantSmmlv(ejbObjectOutput.getMaxSbCantSmmlv());
			retorno.setMinSbCantSmmlv(ejbObjectOutput.getMinSbCantSmmlv());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setFechaInicioVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaInicioVigencia()));
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
	public static AdministradoraTarifaDTO convertAdministradoraTarifa(
			com.ach.cfg.biz.transfer.AdministradoraTarifaDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.convertAdministradoraTarifa");
		AdministradoraTarifaDTO retorno = new AdministradoraTarifaDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setAdministradora(convertAdministradora(ejbObjectOutput.getAdministradora()));
			retorno.setIdSoiAdmTarifa(ejbObjectOutput.getIdSoiAdmTarifa());
			retorno.setVigenteAdmTarifa(ejbObjectOutput.getVigenteAdmTarifa());
			retorno.setFechaInicioVigAdmTarifa(Utilities.convertCalendarToString(ejbObjectOutput
					.getFechaInicioVigAdmTarifa()));
			retorno.setFechaFinVigAdmTarifa(Utilities.convertCalendarToString(ejbObjectOutput
					.getFechaFinVigAdmTarifa()));
			retorno.setTarifa(ejbObjectOutput.getTarifa());
			retorno.setAplicaPlanillaCorrecciones(ejbObjectOutput.getAplicaPnllaCorrecciones());
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
	public static FspTarifaDTO convertFspTarifa(com.ach.pla.biz.transfer.FspTarifaDTO ejbObjectOutput)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertFspTarifa");
		FspTarifaDTO retorno = new FspTarifaDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIdSoiFspTarifa(ejbObjectOutput.getIdSoiFspTarifa());
			retorno.setLimInferiorCantSmmlv(ejbObjectOutput.getLimInferiorCantSmmlv());
			retorno.setLimSuperiorCantSmmlv(ejbObjectOutput.getLimSuperiorCantSmmlv());
			retorno.setSmmlvInferior(ejbObjectOutput.getSmmlvInferior());
			retorno.setSmmlvSuperior(ejbObjectOutput.getSmmlvSuperior());
			retorno.setTarifaSolidaridad(ejbObjectOutput.getTarifaSolidaridad());
			retorno.setTarifaSubsistencia(ejbObjectOutput.getTarifaSubsistencia());
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setFechaInicioVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setFechaFinVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFinVigencia()));
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
	public static SeccionalFiscaliaDTO convertSeccionalFiscalia(SeccionalFiscaliaVO ejbObjectOutput)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.convertSeccionalFiscalia");
		SeccionalFiscaliaDTO retorno = new SeccionalFiscaliaDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIpModificacion(ejbObjectOutput.getIpModificacion());
			retorno.setFechaModificacion(Utilities.convertCalendarToString(ejbObjectOutput.getFechaModificacion()));
			retorno.setUsuarioModificacion(ejbObjectOutput.getUsuarioModificacion());
			retorno.setIpCreacion(ejbObjectOutput.getIpCreacion());
			retorno.setFechaCreacion(Utilities.convertCalendarToString(ejbObjectOutput.getFechaCreacion()));
			retorno.setUsuarioCreacion(ejbObjectOutput.getUsuarioCreacion());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setFechaInicioVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setDigitoVerificacion(ejbObjectOutput.getDigitoVerificacion());
			retorno.setNumeroIdentificacion(ejbObjectOutput.getNumeroIdentificacion());
			retorno.setIdSoiTpIdentificacion(ejbObjectOutput.getIdSoiTpIdentificacion());
			retorno.setNombre(ejbObjectOutput.getNombre());
			retorno.setIdSoiSeccionalFiscalia(ejbObjectOutput.getIdSoiSeccionalFiscalia());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ "co.swatit.pilautil.converter.Converter.convertSeccionalFiscalia");
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
	public static RiesgoClaseDTO convertRiesgoClase(RiesgoClaseVO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertRiesgoClase");
		RiesgoClaseDTO retorno = new RiesgoClaseDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setFechaInicioVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaInicioVigencia()));
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
	public static TipoIdentificacionDTO convertTipoIdentificacion(TipoIdentificacionVO ejbObjectOutput)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.convertTipoIdentificacion");
		TipoIdentificacionDTO retorno = new TipoIdentificacionDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setCodTpIdenAllus(ejbObjectOutput.getCodTpIdenAllus());
			retorno.setAplicaCzteResExterior(ejbObjectOutput.getAplicaCzteResExterior());
			retorno.setAplicaCotizante(ejbObjectOutput.getAplicaCotizante());
			retorno.setAplicaRl(ejbObjectOutput.getAplicaRl());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setFechaInicioVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaInicioVigencia()));
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
	public static InformacionPlanillaMNCorregidaDTO convertInformacionPlanillaMNCorregida(
			InformacionPlanillaMNCorregida ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.convertInformacionPlanillaMNCorregida");
		InformacionPlanillaMNCorregidaDTO retorno = new InformacionPlanillaMNCorregidaDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIdTipoPlanilla(ejbObjectOutput.getIdTipoPlanilla());
			retorno.setTipoPlanilla(ejbObjectOutput.getTipoPlanilla());
			retorno.setIdSucursal(ejbObjectOutput.getIdSucursal());
			retorno.setSucursal(ejbObjectOutput.getSucursal());
			retorno.setPeriodoLiquidacionSalud(ejbObjectOutput.getPeriodoLiquidacionSalud().getPeriodoString());
			retorno.setPeriodoLiquidacionNoSalud(ejbObjectOutput.getPeriodoLiquidacionNoSalud().getPeriodoString());
			retorno.setIdFormaPresentacion(ejbObjectOutput.getIdFormaPresentacion());
			retorno.setCodigoSucursal(ejbObjectOutput.getCodigoSucursal());
			retorno.setFormaPresentacion(ejbObjectOutput.getFormaPresentacion());
			retorno.setFechaPago(Utilities.convertCalendarToString(ejbObjectOutput.getFechaPago()));
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
	public static DetalleParametroDTO convertDetalleParametro(ParametroVO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertDetalleParametro");
		DetalleParametroDTO retorno = new DetalleParametroDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setClaseParametro(ejbObjectOutput.getClaseParametro());
			retorno.setDescripcion(ejbObjectOutput.getDescripcion());
			retorno.setAplicaMultiple(ejbObjectOutput.getAplicaMultiple());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setFechaInicioVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaInicioVigencia()));
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
	public static ValorParametroDTO convertValorParametro(ValorParametroVO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertValorParametro");
		ValorParametroDTO retorno = new ValorParametroDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIpModificacion(ejbObjectOutput.getIpModificacion());
			retorno.setFechaModificacion(Utilities.convertCalendarToString(ejbObjectOutput.getFechaModificacion()));
			retorno.setUsuarioModificacion(ejbObjectOutput.getUsuarioModificacion());
			retorno.setIpCreacion(ejbObjectOutput.getIpCreacion());
			retorno.setFechaCreacion(Utilities.convertCalendarToString(ejbObjectOutput.getFechaCreacion()));
			retorno.setUsuarioCreacion(ejbObjectOutput.getUsuarioCreacion());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setFechaInicioVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setValorCadena(ejbObjectOutput.getValorCadena());
			retorno.setValorFecha(Utilities.convertCalendarToString(ejbObjectOutput.getValorFecha()));
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
	public static ParametroDTO convertParametro(com.ach.cfg.biz.transfer.ParametroDTO ejbObjectOutput)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertParametro");
		ParametroDTO retorno = new ParametroDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIdSoiParametro(ejbObjectOutput.getIdSoiParametro());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setNombre(ejbObjectOutput.getNombre());
			retorno.setValorCadena(ejbObjectOutput.getValorCadena());
			retorno.setValorNumerico(ejbObjectOutput.getValorNumerico());
			retorno.setValorFecha(Utilities.convertCalendarToString(ejbObjectOutput.getValorFecha()));
			retorno.setValorMostrar(ejbObjectOutput.getValorMostrar());
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setVigenteValorParametro(ejbObjectOutput.getVigenteValorParametro());
			retorno.setAplicaMultiple(ejbObjectOutput.getAplicaMultiple());
			retorno.setClaseParametro(ejbObjectOutput.getClaseParametro());
			retorno.setClaseParametroMostrar(ejbObjectOutput.getClaseParametroMostrar());
			retorno.setFechaInicioVigencia1(Utilities.convertCalendarToString(ejbObjectOutput
					.getFechaInicioVigencia1()));
			retorno.setFechaInicioVigencia2(Utilities.convertCalendarToString(ejbObjectOutput
					.getFechaInicioVigencia2()));
			retorno.setFechaInicioVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setFechaFinVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setFechaInicioVigenciaValor(Utilities.convertCalendarToString(ejbObjectOutput
					.getFechaInicioVigenciaValor()));
			retorno.setFechaFinVigenciaValor(Utilities.convertCalendarToString(ejbObjectOutput
					.getFechaFinVigenciaValor()));
			retorno.setDescripcion(ejbObjectOutput.getDescripcion());
			retorno.setIdSoiValorParametro(ejbObjectOutput.getIdSoiValorParametro());
			retorno.setTipoDato(ejbObjectOutput.getTipoDato());
			retorno.setTipoDatoMostrar(ejbObjectOutput.getTipoDatoMostrar());
			retorno.setVigenteValorMostrar(ejbObjectOutput.getVigenteValorMostrar());
			retorno.setDetalleParametroDTO(convertDetalleParametro(ejbObjectOutput.getParametroVO()));
			retorno.setValorParametroDTO(convertValorParametro(ejbObjectOutput.getValorParametroVO()));
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
	public static InformacionAportantePlanillaDTO convertInformacionAportantePlanilla(
			com.ach.seg.biz.transfer.InformacionAportantePlanillaDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.convertInformacionAportantePlanilla");
		InformacionAportantePlanillaDTO retorno = new InformacionAportantePlanillaDTO();
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
			retorno.setTipoPersonaEntidadFinanciera(Utilities.getEnumName(ejbObjectOutput
					.getTipoPersonaEntidadFinanciera()));
			retorno.setIdSoiTpPagadorPension(ejbObjectOutput.getIdSoiTpPagadorPension());
			retorno.setNombreTipoPagadoPension(ejbObjectOutput.getNombreTipoPagadoPension());
			retorno.setNombreUsuarioAdministrador(ejbObjectOutput.getNombreUsuarioAdministrador());
			retorno.setApellidoUsuarioAdministrador(ejbObjectOutput.getApellidoUsuarioAdministrador());
			retorno.setNombreCompletoUsuarioAdmin(ejbObjectOutput.getNombreCompletoUsuarioAdmin());
			retorno.setCodDepartamentoAportante(ejbObjectOutput.getCodDepartamentoAportante());
			retorno.setCodMunicipioAportante(ejbObjectOutput.getCodMunicipioAportante());
			retorno.setDireccionAportante(ejbObjectOutput.getDireccionAportante());
			retorno.setTelefonoAportante(ejbObjectOutput.getTelefonoAportante());
			retorno.setFaxAportante(ejbObjectOutput.getFax());
			retorno.setAportanteMigrado(ejbObjectOutput.getAportanteMigrado());
			retorno.setApteMigradoActDatos(ejbObjectOutput.getApteMigradoActDatos());
			retorno.setFechaRegistroMercantil(Utilities.convertCalendarToString(ejbObjectOutput
					.getFechaRegistroMercantil()));
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ "co.swatit.pilautil.converter.Converter.convertInformacionAportantePlanilla");
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
	public static ArchivoEnProcesoDTO convertArchivoEnProceso(
			com.ach.arc.biz.transfer.ArchivoEnProcesoDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertArchivoEnProceso");
		ArchivoEnProcesoDTO retorno = new ArchivoEnProcesoDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIdArchivoEnProceso(ejbObjectOutput.getIdArchivoEnProceso());
			retorno.setPathArchivo(ejbObjectOutput.getPathArchivo());
			retorno.setIdAportante(ejbObjectOutput.getIdAportante());
			retorno.setEstadoProcesosArchivoPlanoType(Utilities.getEnumName(ejbObjectOutput
					.getEstadoProcesosArchivoPlanoType()));
			retorno.setIdSegUsuario(ejbObjectOutput.getIdSegUsuario());
			retorno.setNombreArchivo(ejbObjectOutput.getNombreArchivo());
			retorno.setIdSoiPlanilla(ejbObjectOutput.getIdSoiPlanilla());
			retorno.setIdNumeroDePlanilla(ejbObjectOutput.getIdNumeroDePlanilla());
			retorno.setNotificacionDeArchivoEnProcesoType(Utilities.getEnumName(ejbObjectOutput
					.getNotificacionDeArchivoEnProcesoType()));
			retorno.setNumeroTotalDeEmpleadosEnPlanilla(ejbObjectOutput.getNumeroTotalDeEmpleadosEnPlanilla());
			retorno.setNombreAportante(ejbObjectOutput.getNombreAportante());
			retorno.setCodTpDocAportante(ejbObjectOutput.getCodTpDocAportante());
			retorno.setNroDocAportante(ejbObjectOutput.getNroDocAportante());
			retorno.setPeriodoSalud(ejbObjectOutput.getPeriodoSalud().getPeriodoString());
			retorno.setPeriodoNoSalud(ejbObjectOutput.getPeriodoNoSalud().getPeriodoString());
			retorno.setCodTipoPlanilla(ejbObjectOutput.getCodTipoPlanilla());
			retorno.setIdSoiTpPlanillaAsociada(ejbObjectOutput.getIdSoiTpPlanillaAsociada());
			retorno.setUsuarioAceptaPlanillaMNPagadaPorEsteOperador(ejbObjectOutput
					.getUsuarioAceptaPlanillaMNPagadaPorEsteOperador());
			retorno.setUsuarioAceptaRetroactivoPlanillaPublica(ejbObjectOutput
					.getUsuarioAceptaRetroactivoPlanillaPublica());
			retorno.setUsuarioCertificaCalculoInteresesMora(ejbObjectOutput.getUsuarioCertificaCalculoInteresesMora());
			retorno.setEnProcesoDeReValidacion(ejbObjectOutput.isEnProcesoDeReValidacion());
			retorno.setInformacionPlanillaMNCorregidaDTO(convertInformacionPlanillaMNCorregida(ejbObjectOutput
					.getInformacionPlanillaMNCorregida()));
			retorno.setNumeroPlanillaAsociada(ejbObjectOutput.getNumeroPlanillaAsociada());
			retorno.setFechaPlanillaAsociada(Utilities.convertCalendarToString(ejbObjectOutput
					.getFechaPlanillaAsociada()));
			retorno.setTipoFormaPresentacionType(Utilities.getEnumName(ejbObjectOutput.getTipoFormaPresentacionType()));
			retorno.setCodigoSucursal(ejbObjectOutput.getCodigoSucursal());
			retorno.setModificarPlanillaReferida(ejbObjectOutput.getModificarPlanillaReferida());
			retorno.setAceptaRenunciaLey1233(ejbObjectOutput.getAceptaRenunciaLey1233());
			retorno.setUsuarioAceptaDescuentoPymes(ejbObjectOutput.isUsuarioAceptaDescuentoPymes());
			retorno.setPlanillaCorrector(ejbObjectOutput.isPlanillaCorrector());
			retorno.setIdTmpCorrector(ejbObjectOutput.getIdTmpCorrector());
			retorno.setIdEstadoProcesoCorrector(ejbObjectOutput.getIdEstadoProcesoCorrector());
			retorno.setUrlArchivosCorrecciones(ejbObjectOutput.getUrlArchivosCorrecciones());
			retorno.setAceptoAutocorreccion(ejbObjectOutput.isAceptoAutocorreccion());
			retorno.setGenerarErroresNoCorregibles(ejbObjectOutput.isGenerarErroresNoCorregibles());
			retorno.setConvertidor(ejbObjectOutput.isConvertidor());
			retorno.setAportanteLey1607(ejbObjectOutput.isAportanteLey1607());
			retorno.setAportanteLey1429(ejbObjectOutput.isAportanteLey1429());
			retorno.setValidarSoloRegistrosT02(ejbObjectOutput.isValidarSoloRegistrosT02());
			retorno.setPnllaArchivoEdicion(ejbObjectOutput.isPnllaArchivoEdicion());
			retorno.setContieneArchivoTipo1Consolidado(ejbObjectOutput.isContieneArchivoTipo1Consolidado());
			retorno.setEsPlanillaTipoU(ejbObjectOutput.isEsPlanillaTipoU());
			retorno.setExisteApteNsoiPlanillaU(ejbObjectOutput.isExisteApteNsoiPlanillaU());
			retorno.setIdClaseAptePlanillaU(ejbObjectOutput.getIdClaseAptePlanillaU());
			retorno.setIncluirNombres(ejbObjectOutput.isIncluirNombres());
			retorno.setIncluirAdministradoras(ejbObjectOutput.isIncluirAdministradoras());
			retorno.setAdministradoraArchivo(ejbObjectOutput.isAdministradoraArchivo());
			retorno.setAplicaValidacionPlanillaPrevia(ejbObjectOutput.isAplicaValidacionPlanillaPrevia());
			retorno.setEdicionRegTp2Corrector(ejbObjectOutput.isEdicionRegTp2Corrector());
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
	public static DepartamentoDTO convertDepartamento(DepartamentoVO ejbObjectOutput) {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertDepartamento");
		DepartamentoDTO retorno = new DepartamentoDTO();
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
	 * Método que convierte un objeto tipo {@link ValidacionArchivoDataSource} en
	 * {@link ValidacionArchivoDataSourceDTO}
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
	public static ValidacionArchivoDataSourceDTO convertValidacionArchivoDataSource(
			ValidacionArchivoDataSource ejbObjectOutput,
			com.ach.pla.biz.transfer.PlanillaAportanteDTO planillaAportanteDTO) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.convertValidacionArchivoDataSource");
		ValidacionArchivoDataSourceDTO retorno = new ValidacionArchivoDataSourceDTO();
		if (Validation.isNotNull(ejbObjectOutput) && Validation.isNotNull(planillaAportanteDTO)) {
			getAplicabilityLists(retorno, ejbObjectOutput);
			getCompulsoriesLists(retorno, ejbObjectOutput);
			getFaresStructures(retorno, ejbObjectOutput);
			getAdministratorStructures(retorno, ejbObjectOutput);
			getContributorTypesStructures(retorno, ejbObjectOutput);
			getIdTypeStructures(retorno, ejbObjectOutput);
			getStatesCitiesStructures(retorno, ejbObjectOutput);

			for (Map.Entry<Integer, com.ach.cfg.biz.transfer.ParametroDTO> parametro : ejbObjectOutput
					.getParametrosLiquidacion().entrySet()) {
				retorno.getParametrosLiquidacion().put(parametro.getKey(), convertParametro(parametro.getValue()));
			}
			for (SeccionalFiscaliaVO seccionalFis : ejbObjectOutput.getSeccionalesFiscalia()) {
				retorno.getSeccionalesFiscalia().add(convertSeccionalFiscalia(seccionalFis));
			}
			for (RiesgoClaseVO riesgoClase : ejbObjectOutput.getClasesRiesgo()) {
				retorno.getClasesRiesgo().add(convertRiesgoClase(riesgoClase));
			}
			retorno.setAportanteDTO(convertAportante(ejbObjectOutput.getAportanteVo()));
			retorno.setTopeSalarioIntegral(ejbObjectOutput.getTopeSalarioIntegral());
			retorno.setTpCotizante(ejbObjectOutput.getTpCotizante());
			retorno.setPlanillaApteDto(convertPlanillaAportante(planillaAportanteDTO));
			retorno.getPropiedadesNec160Map().putAll(ejbObjectOutput.getPropiedadesNec160Map());
			retorno.setAportanteDTO(convertAportante(ejbObjectOutput.getAportanteVo()));
			retorno.setTimelyPaydayDTO(convertTimelyPayday(ejbObjectOutput.getDiaPagoOportuno()));
			retorno.setFechaPagoOportuno(Utilities.convertCalendarToString(ejbObjectOutput.getFechaPagoOportuno()));
			if (Validation.isNotNull(ejbObjectOutput.getProperties())) {
				retorno.getProperties().putAll(ejbObjectOutput.getProperties());
			}
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
	public static void getAplicabilityLists(ValidacionArchivoDataSourceDTO wsOutputDTO,
			ValidacionArchivoDataSource ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.getAplicabilityLists");
		for (com.ach.pla.biz.transfer.AplicabilidadDTO aplicabilidadApte : ejbObjectOutput
				.getRegistrosAplicabilidadApte()) {
			wsOutputDTO.getRegistrosAplicabilidadApte().add(convertAplicabilidad(aplicabilidadApte));
		}
		for (com.ach.pla.biz.transfer.AplicabilidadDTO tipoCotizante : ejbObjectOutput.getTiposCotizante()) {
			wsOutputDTO.getTiposCotizante().add(convertAplicabilidad(tipoCotizante));
		}
		for (com.ach.pla.biz.transfer.AplicabilidadDTO subtipoCotizante : ejbObjectOutput.getSubtiposCotizante()) {
			wsOutputDTO.getSubtiposCotizante().add(convertAplicabilidad(subtipoCotizante));
		}
		for (com.ach.pla.biz.transfer.AplicabilidadDTO extranjeria : ejbObjectOutput.getExtranjerias()) {
			wsOutputDTO.getExtranjerias().add(convertAplicabilidad(extranjeria));
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.getAplicabilityLists");
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
	public static void getCompulsoriesLists(ValidacionArchivoDataSourceDTO wsOutputDTO,
			ValidacionArchivoDataSource ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.getCompulsoriesLists");
		for (ObligatoriedadTipoCotizanteVO obligatoriedadTipoCoti : ejbObjectOutput.getObligatoriedadesTipoCotizante()) {
			wsOutputDTO.getObligatoriedadesTipoCotizante().add(
					convertObligatoriedadTipoCotizante(obligatoriedadTipoCoti));
		}
		for (ObligatoriedadSubTipoCotizanteVO obligatoriedadSubTipoCoti : ejbObjectOutput
				.getObligatoriedadesSubTipoCotizante()) {
			wsOutputDTO.getObligatoriedadesSubTipoCotizante().add(
					convertObligatoriedadSubTipoCotizante(obligatoriedadSubTipoCoti));
		}
		for (ObligatoriedadSubTipoCotizanteVO obligatoriedadExtranjeria : ejbObjectOutput
				.getObligatoriedadesExtranjeria()) {
			wsOutputDTO.getObligatoriedadesExtranjeria().add(
					convertObligatoriedadSubTipoCotizante(obligatoriedadExtranjeria));
		}
		for (ObligatoriedadAportanteVO obligatoriedadAportante : ejbObjectOutput.getObligatoriedadesAportante()) {
			wsOutputDTO.getObligatoriedadesAportante().add(convertObligatoriedadAportante(obligatoriedadAportante));
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.getCompulsoriesLists");
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
	public static void getFaresStructures(ValidacionArchivoDataSourceDTO wsOutputDTO,
			ValidacionArchivoDataSource ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.getFaresStructures");
		for (Map.Entry<TipoSubSistemasType, Collection<BigDecimal>> entry : ejbObjectOutput.getTarifasPfGenerales()
				.entrySet()) {
			ArrayList<BigDecimal> tarifas = new ArrayList<BigDecimal>(entry.getValue());
			wsOutputDTO.getTarifasPfGenerales().put(Utilities.getEnumName(entry.getKey()), tarifas);
		}
		for (Map.Entry<TipoSubSistemasType, Collection<BigDecimal>> entry : ejbObjectOutput
				.getTarifasPfIndependientes().entrySet()) {
			ArrayList<BigDecimal> tarifas = new ArrayList<BigDecimal>(entry.getValue());
			wsOutputDTO.getTarifasPfIndependientes().put(Utilities.getEnumName(entry.getKey()), tarifas);
		}
		for (com.ach.pla.biz.transfer.FspTarifaDTO fspTarifa : ejbObjectOutput.getTarifasFsp()) {
			wsOutputDTO.getTarifasFsp().add(convertFspTarifa(fspTarifa));
		}
		wsOutputDTO.getListadoAdminTarifasEspeciales().addAll(ejbObjectOutput.getListadoAdminTarifasEspeciales());
		wsOutputDTO.getTarifasEspeciales().addAll(ejbObjectOutput.getTarifasEspeciales());
		wsOutputDTO.getTarifasEspecialesSln().addAll(ejbObjectOutput.getTarifasEspecialesSln());
		wsOutputDTO.getTarifaCcfGeneral().addAll(ejbObjectOutput.getTarifaCcfGeneral());
		wsOutputDTO.getTarifaCcfIndependiente().addAll(ejbObjectOutput.getTarifaCcfIndependiente());
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.getFaresStructures");
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
	public static void getAdministratorStructures(ValidacionArchivoDataSourceDTO wsOutputDTO,
			ValidacionArchivoDataSource ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.getAdministratorStructures");
		for (Map.Entry<String, String> entry : ejbObjectOutput.getAdministradorasCcfMunicipios().entrySet()) {
			wsOutputDTO.getAdministradorasCcfMunicipios().put(entry.getKey(), entry.getValue());
		}
		for (com.ach.cfg.biz.transfer.AdministradoraTarifaDTO adminTarifa : ejbObjectOutput
				.getAdministradorasPension()) {
			wsOutputDTO.getAdministradorasPension().add(convertAdministradoraTarifa(adminTarifa));
		}
		for (com.ach.cfg.biz.transfer.AdministradoraTarifaDTO adminTarifa : ejbObjectOutput.getAdministradorasSalud()) {
			wsOutputDTO.getAdministradorasSalud().add(convertAdministradoraTarifa(adminTarifa));
		}
		for (com.ach.cfg.biz.transfer.AdministradoraTarifaDTO adminTarifa : ejbObjectOutput.getAdministradorasTarifasSLN()) {
			wsOutputDTO.getAdministradorasTarifasSLN().add(convertAdministradoraTarifa(adminTarifa));
		}
		for (Map.Entry<TipoSubSistemasType, AdministradoraVO> adminiParafiscales : ejbObjectOutput
				.getAdministradorasParafiscales().entrySet()) {
			wsOutputDTO.getAdministradorasParafiscales().put(Utilities.getEnumName(adminiParafiscales.getKey()),
					convertAdministradora(adminiParafiscales.getValue()));
		}
		for (com.ach.cfg.biz.transfer.AdministradoraTarifaDTO adminSalud : ejbObjectOutput
				.getAdministradorasSaludLey1607()) {
			wsOutputDTO.getAdministradorasSaludLey1607().add(convertAdministradoraTarifa(adminSalud));
		}
		for (AdministradoraVO adminRiesgo : ejbObjectOutput.getAdministradorasRiesgoYCcf()) {
			wsOutputDTO.getAdministradorasRiesgoYCcf().add(convertAdministradora(adminRiesgo));
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT+ "co.swatit.pilautil.converter.Converter.getAdministratorStructures");
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
	public static void getStatesCitiesStructures(ValidacionArchivoDataSourceDTO wsOutputDTO,
			ValidacionArchivoDataSource ejbObjectOutput) {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.getStatesCitiesStructures");
		for (Map.Entry<String, DepartamentoVO> depto : ejbObjectOutput.getDepartamentosMap().entrySet()) {
			wsOutputDTO.getDepartamentosMap().put(depto.getKey(), convertDepartamento(depto.getValue()));
		}
		for (Map.Entry<String, MunicipioVO> municipio : ejbObjectOutput.getMunicipiosMap().entrySet()) {
			wsOutputDTO.getMunicipiosMap().put(municipio.getKey(), convertMunicipio(municipio.getValue()));
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ "co.swatit.pilautil.converter.Converter.getStatesCitiesStructures");
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
	public static void getContributorTypesStructures(ValidacionArchivoDataSourceDTO wsOutputDTO,
			ValidacionArchivoDataSource ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.getContributorTypesStructures");
		for (Map.Entry<Integer, TipoCotizanteVO> tipoCotizante : ejbObjectOutput.getTiposCotizanteMap().entrySet()) {
			wsOutputDTO.getTiposCotizanteMap().put(tipoCotizante.getKey(),
					convertTipoCotizante(tipoCotizante.getValue()));
		}
		for (Map.Entry<Integer, SubTipoCotizanteVO> subtipoCotizante : ejbObjectOutput.getSubtiposCotizanteMap()
				.entrySet()) {
			wsOutputDTO.getSubtiposCotizanteMap().put(subtipoCotizante.getKey(),
					convertSubTipoCotizante(subtipoCotizante.getValue()));

		}
		for (Map.Entry<Integer, SubTipoCotizanteVO> subtipoCotizanteExt : ejbObjectOutput.getExtranjeriaCotizanteMap()
				.entrySet()) {
			wsOutputDTO.getExtranjeriaCotizanteMap().put(subtipoCotizanteExt.getKey(),
					convertSubTipoCotizante(subtipoCotizanteExt.getValue()));
		}
		for (String codTpsCotizante : ejbObjectOutput.getCodTpsCotizanteDependientesNr415()) {
			wsOutputDTO.getCodTpsCotizanteDependientesNr415().add(codTpsCotizante);
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ "co.swatit.pilautil.converter.Converter.getContributorTypesStructures");
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
	public static void getIdTypeStructures(ValidacionArchivoDataSourceDTO wsOutputDTO,
			ValidacionArchivoDataSource ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.getIdTypeStructures");
		for (TipoIdentificacionVO tipoId : ejbObjectOutput.getTiposDocumentosCotizantes()) {
			wsOutputDTO.getTiposDocumentosCotizantes().add(convertTipoIdentificacion(tipoId));
		}
		for (Map.Entry<String, Collection<TipoIdentificacionVO>> tipoDocTipoCot : ejbObjectOutput
				.getTiposDocumentoPorTipoCotizante().entrySet()) {
			ArrayList<TipoIdentificacionDTO> tipoIdentificacion = new ArrayList<TipoIdentificacionDTO>();
			for (TipoIdentificacionVO tpId : tipoDocTipoCot.getValue()) {
				tipoIdentificacion.add(convertTipoIdentificacion(tpId));
			}
			wsOutputDTO.getTiposDocumentoPorTipoCotizante().put(tipoDocTipoCot.getKey(), tipoIdentificacion);
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.getIdTypeStructures");
	}

	/**
	 * Método que convierte un objeto de tipo {@link UsuarioVO} en {@link UserDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 8/03/2017
	 *
	 * @param ejbObjectOutput
	 *            , {@link UsuarioVO} a convertir
	 * @return {@link UserDTO} con el resultado de la conversión
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static UserDTO convertUser(UsuarioVO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertUser");
		UserDTO retorno = new UserDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setCambioContrasena(ejbObjectOutput.getCambioContrasena());
			retorno.setCausaFinVigencia(ejbObjectOutput.getCausaFinVigencia());
			retorno.setFechaFinVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFinVigencia()));
			retorno.setVigente(ejbObjectOutput.getVigente());
			retorno.setFechaInicioVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaInicioVigencia()));
			retorno.setIdSegTpUsuario(ejbObjectOutput.getIdSegTpUsuario());
			retorno.setFcaActContrasena(Utilities.convertCalendarToString(ejbObjectOutput.getFcaActContrasena()));
			retorno.setSal(ejbObjectOutput.getSal());
			retorno.setContrasenaAnt(ejbObjectOutput.getContrasenaAnt());
			retorno.setContrasena(ejbObjectOutput.getContrasena());
			retorno.setCuenta(ejbObjectOutput.getCuenta());
			retorno.setEstado(ejbObjectOutput.getEstado());
			retorno.setNmrIdentificacion(ejbObjectOutput.getNmrIdentificacion());
			retorno.setIdTpIdentificacion(ejbObjectOutput.getIdTpIdentificacion());
			retorno.setEmail(ejbObjectOutput.getEmail());
			retorno.setApellido2(ejbObjectOutput.getApellido2());
			retorno.setApellido1(ejbObjectOutput.getApellido1());
			retorno.setNombre2(ejbObjectOutput.getNombre2());
			retorno.setNombre1(ejbObjectOutput.getNombre1());
			retorno.setIdSegUsuario(ejbObjectOutput.getIdSegUsuario());
			retorno.setAplicaCotizante(ejbObjectOutput.getAplicaCotizante());
			retorno.setAplicaRl(ejbObjectOutput.getAplicaRl());
			retorno.setCausaFinVigencia1(ejbObjectOutput.getCausaFinVigencia1());
			retorno.setFechaFinVigencia1(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFinVigencia1()));
			retorno.setFechaInicioVigencia1(Utilities.convertCalendarToString(ejbObjectOutput
					.getFechaInicioVigencia1()));
			retorno.setAplicaUsuarioBco(ejbObjectOutput.getAplicaUsuarioBco());
			retorno.setAplicaUsuarioApte(ejbObjectOutput.getAplicaUsuarioApte());
			retorno.setAplicaIndependiente(ejbObjectOutput.getAplicaIndependiente());
			retorno.setAplicaEmpresa(ejbObjectOutput.getAplicaEmpresa());
			retorno.setVigente1(ejbObjectOutput.getVigente1());
			retorno.setNombreMostrar(ejbObjectOutput.getNombreMostrar());
			retorno.setNombre(ejbObjectOutput.getNombre());
			retorno.setCodigo(ejbObjectOutput.getCodigo());
			retorno.setIdSoiTpIdentificacion(ejbObjectOutput.getIdSoiTpIdentificacion());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertUser");
		return retorno;
	}

	/**
	 * Método que convierte un objeto de tipo {@link RecursoVO} en {@link ResourceDetailDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 8/03/2017
	 *
	 * @param ejbObjectOutput
	 *            , {@link RecursoVO} a convertir
	 * @return {@link ResourceDetailDTO} con el resultado de la conversión
	 */
	public static ResourceDetailDTO convertResourceDetail(RecursoVO ejbObjectOutput) {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertResourceDetail");
		ResourceDetailDTO retorno = new ResourceDetailDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIdSegRecursoPadre(ejbObjectOutput.getIdSegRecursoPadre());
			retorno.setTpRecurso(ejbObjectOutput.getTpRecurso());
			retorno.setIdSegAplicacion(ejbObjectOutput.getIdSegAplicacion());
			retorno.setObservacion(ejbObjectOutput.getObservacion());
			retorno.setAccion(ejbObjectOutput.getAccion());
			retorno.setDescripcion(ejbObjectOutput.getDescripcion());
			retorno.setIdSegRecurso(ejbObjectOutput.getIdSegRecurso());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertResourceDetail");
		return retorno;
	}

	/**
	 * Método que convierte un objeto de tipo {@link RecursoDTO} en {@link ResourceDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 8/03/2017
	 *
	 * @param ejbObjectOutput
	 *            , {@link RecursoDTO} a convertir
	 * @return {@link ResourceDTO} con el resultado de la conversión
	 */
	public static ResourceDTO convertResource(RecursoDTO ejbObjectOutput) {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertResource");
		ResourceDTO retorno = new ResourceDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setResourceDetailDTO(convertResourceDetail(ejbObjectOutput.getRecursoVO()));
			retorno.setTieneHijos(ejbObjectOutput.isTieneHijos());
			retorno.setNivel(ejbObjectOutput.getNivel());
			retorno.setIdSegRol(ejbObjectOutput.getIdSegRol());
			RecursoDTO recursoPadre = ejbObjectOutput.getRecursoDTOPadre();
			if (Validation.isNotNull(recursoPadre)) {
				convertResource(recursoPadre);
			}
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertResource");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto de tipo {@link UsuarioAutenticadoDTO} en {@link AuthenticatedUserDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 8/03/2017
	 *
	 * @param ejbObjectOutput
	 *            {@link UsuarioAutenticadoDTO} a convertir
	 * @return {@link AuthenticatedUserDTO} con la información obtenida
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static AuthenticatedUserDTO convertAuthenticatedUser(UsuarioAutenticadoDTO ejbObjectOutput)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.convertAuthenticatedUser");
		AuthenticatedUserDTO retorno = new AuthenticatedUserDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIdSoiAportanteUsuario(ejbObjectOutput.getIdSoiAportanteUsuario());
			retorno.setCorreoAportanteUsuario(ejbObjectOutput.getCorreoAportanteUsuario());
			retorno.setPermitirActualizarDatosApteMigrado(ejbObjectOutput.isPermitirActualizarDatosApteMigrado());
			retorno.setUserDTO(convertUser(ejbObjectOutput.getUsuarioVO()));
			retorno.setResourceDTO(convertResource(ejbObjectOutput.getRecursoDTO()));
			retorno.setObligarCambioContrasena(ejbObjectOutput.isObligarCambioContrasena());
			retorno.setInformacionAportantePlanillaDTO(convertInformacionAportantePlanilla(ejbObjectOutput
					.getInfoAportanteDTO()));
			retorno.setFechaUltimoIngreso(Utilities.convertCalendarToString(ejbObjectOutput.getFechaUltimoIngreso()));
			Collection<RecursoVO> ejbOutputResources = ejbObjectOutput.getRecursosAutorizacion();
			if (Validation.isNotNull(ejbOutputResources)) {
				ArrayList<RecursoVO> recursosVO = new ArrayList<RecursoVO>(ejbOutputResources);
				for (RecursoVO recursoVO : recursosVO) {
					retorno.getRecursosAutorizacion().add(convertResourceDetail(recursoVO));
				}
			}

		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ "co.swatit.pilautil.converter.Converter.convertAuthenticatedUser");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto de tipo {@link PlanillaConsultadaListadoDTO} en {@link PayrollDetailDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 9/03/2017
	 *
	 * @param ejbObjectOutput
	 *            , {@link PlanillaConsultadaListadoDTO} con la información obtenida por parte de SOI
	 * @return {@link PayrollDetailDTO} resultado de la conversión
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static PayrollDetailDTO convertPayrollDetail(PlanillaConsultadaListadoDTO ejbObjectOutput)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertPayrollDetail");
		PayrollDetailDTO retorno = new PayrollDetailDTO();
		retorno.setIdSoiPlanilla(ejbObjectOutput.getIdSoiPlanilla());
		retorno.setNumeroPlanillaElectronica(ejbObjectOutput.getNumeroPlanillaElectronica());
		retorno.setTipoPlanilla(ejbObjectOutput.getTipoPlanilla());
		retorno.setValorPagado(ejbObjectOutput.getValorPagado());
		retorno.setPeriodoSistemaSalud(ejbObjectOutput.getPeriodoSistemaSalud().getPeriodoPlanillaString());
		retorno.setNumeroEmpleados(ejbObjectOutput.getNumeroEmpleados());
		Calendar fechaPago = ejbObjectOutput.getFechaUltimaModificacion();
		if (Validation.isNotNull(fechaPago)) {
			retorno.setFechaUltimaModificacion(Utilities.parseDateToStringBusiness(fechaPago.getTime(),
					Constants.DATE_FORMAT_PAYROLL_PAYMENT));
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertPayrollDetail");
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto de tipo {@link DiaPagoOportunoDTO} en {@link TimelyPaydayDTO}
	 * 
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 3/04/2017
	 *
	 * @param ejbObjectOutput
	 *            , {@link DiaPagoOportunoDTO} con la información obtenida de SOI
	 * @return {@link TimelyPaydayDTO} resultado del proceso
	 */
	public static TimelyPaydayDTO convertTimelyPayday(DiaPagoOportunoDTO ejbObjectOutput) {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertTimelyPayday");
		TimelyPaydayDTO retorno = new TimelyPaydayDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIdClaseAportante(ejbObjectOutput.getIdClaseAportante());
			retorno.setDigitosVerificacion(ejbObjectOutput.getDigitosDeVerifiacion());
			retorno.setDiaPagoOportuno(ejbObjectOutput.getDiaPagoOportuno());
			retorno.setIdSoiDiaPagoOportuno(ejbObjectOutput.getIdSoiDiaPagoOportuno());
			retorno.setIdSoiFormaPresentacion(ejbObjectOutput.getIdSoiFormaPresentacion());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertTimelyPayday");
		return retorno;
	}

	/**
	 * Método que convierte un objeto de tipo {@link InformacionBasicaCotizanteDTO} en {@link PayrollContributorDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 4/04/2017
	 *
	 * @param ejbObjectOutput
	 *            objeto de tipo {@link InformacionBasicaCotizanteDTO} con la información obtenida por parte de SOI
	 * @return {@link PayrollContributorDTO} resultado de la conversión
	 */
	public static PayrollContributorDTO convertPayrollContributor(InformacionBasicaCotizanteDTO ejbObjectOutput) {
		PayrollContributorDTO retorno = new PayrollContributorDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			Long idCotizante = ejbObjectOutput.getIdCotizante();
			if (Validation.isNotNull(idCotizante)) {
				retorno.setIdCotizante(idCotizante.toString());
			}
			retorno.setNombreCompleto(ejbObjectOutput.getNombreCompleto());
			retorno.setIdTipoIdentificacion(ejbObjectOutput.getCodTipoIdentificacion());
			retorno.setTipoIdentificacion(ejbObjectOutput.getNombreTipoIdentificacion());
			retorno.setNumeroIdentificacion(ejbObjectOutput.getNumeroIdentificacion());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		return retorno;
	}

	/**
	 * 
	 * Método que convierte un objeto de tipo {@link AporteSubsistemaVO} en {@link AporteSubsistemaDTO}
	 * 
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 3/04/2017
	 *
	 * @param ejbObjectOutput
	 *            , {@link AporteSubsistemaVO} con la información obtenida de SOI
	 * @return {@link AporteSubsistemaDTO} resultado del proceso
	 */
	public static AporteSubsistemaDTO convertAporteSubsistema(AporteSubsistemaVO ejbObjectOutput) {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertAporteSubsistema");
		AporteSubsistemaDTO retorno = new AporteSubsistemaDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIdAdministradora(ejbObjectOutput.getIdAdministradora());
			retorno.setCodigoAdministradora(ejbObjectOutput.getCodigoAdministradora());
			retorno.setNombreAdministradora(ejbObjectOutput.getNombreAdministradora());
			retorno.setNroDiasSubsistema(ejbObjectOutput.getNroDiasSubsistema());
			retorno.setIbcSubsistema(ejbObjectOutput.getIbcSubsistema());
			retorno.setTarifaSubsistema(ejbObjectOutput.getTarifaSubsistema());
			retorno.setValorAporteSubsistema(ejbObjectOutput.getValorAporteSubsistema());
			retorno.setTipoSubSistemasType(Utilities.getEnumName(ejbObjectOutput.getTipoSubSistemasType()));
			retorno.setIdClaseRiesgo(ejbObjectOutput.getIdClaseRiesgo());
			retorno.setCodClaseRiesgo(ejbObjectOutput.getCodClaseRiesgo());
			retorno.setCentroTrabajo(ejbObjectOutput.getCentroTrabajo());
			retorno.setIbcSinRedondeo(ejbObjectOutput.getIbcSinRedondeo());
			retorno.setIbcEditado(ejbObjectOutput.isIbcEditado());
			retorno.setDiasEditado(ejbObjectOutput.isDiasEditado());
			retorno.setNroAutorizacionIGE(ejbObjectOutput.getNroAutorizacionIGE());
			retorno.setValorAutorizacionIGE(ejbObjectOutput.getValorAutorizacionIGE());
			retorno.setNroAutorizacionLMA(ejbObjectOutput.getNroAutorizacionLMA());
			retorno.setValorAutorizacionLMA(ejbObjectOutput.getValorAutorizacionLMA());
			retorno.setValorUPC(ejbObjectOutput.getValorUPC());
			retorno.setIncluirArcSalida(ejbObjectOutput.isIncluirArcSalida());
			retorno.setCotizanteAyCincluidosEnArcSalida(ejbObjectOutput.isCotizanteAyCincluidosEnArcSalida());
			retorno.setEliminarAporte(ejbObjectOutput.isEliminarAporte());
			retorno.setValidacionDiasMaximo(ejbObjectOutput.isValidacionDiasMaximo());
			retorno.setNroDiasSubsistemaMaximo(ejbObjectOutput.getNroDiasSubsistemaMaximo());
			retorno.setIndicadorTarifaEspecialPen(ejbObjectOutput.getIndicadorTarifaEspecialPen());
			retorno.setIbcOtrosParafiscales(ejbObjectOutput.getIbcOtrosParafiscales());
			retorno.setHorasLaboradas(ejbObjectOutput.getHorasLaboradas());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertAporteSubsistema");
		return retorno;
	}

	/**
	 * Método que convierte un objeto de tipo {@link DatosBasicosCotizanteVO} en {@link DatosBasicosCotizanteDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 7/04/2017
	 *
	 * @param ejbObjectOutput
	 *            , {@link DatosBasicosCotizanteVO} con la información obtenida de SOI
	 * @return {@link DatosBasicosCotizanteDTO} resultado del proceso
	 */
	public static DatosBasicosCotizanteDTO convertDatosBasicosCotizante(DatosBasicosCotizanteVO ejbObjectOutput) {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.convertDatosBasicosCotizante");
		DatosBasicosCotizanteDTO retorno = new DatosBasicosCotizanteDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIdTipoIdentificacion(ejbObjectOutput.getIdTipoIdentificacion());
			retorno.setCodTipoIdentificacion(ejbObjectOutput.getCodTipoIdentificacion());
			retorno.setNombreTipoIdentificacion(ejbObjectOutput.getNombreTipoIdentificacion());
			retorno.setNroIdentificacion(ejbObjectOutput.getNroIdentificacion());
			retorno.setPrimerNombre(ejbObjectOutput.getPrimerNombre());
			retorno.setSegundoNombre(ejbObjectOutput.getSegundoNombre());
			retorno.setPrimerApellido(ejbObjectOutput.getPrimerApellido());
			retorno.setSegundoApellido(ejbObjectOutput.getSegundoApellido());
			retorno.setIdTipoCotizante(ejbObjectOutput.getIdTipoCotizante());
			retorno.setCodTipoCotizante(ejbObjectOutput.getCodTipoCotizante());
			retorno.setDscTipoCotizante(ejbObjectOutput.getDscTipoCotizante());
			retorno.setIdSubtipoCotizante(ejbObjectOutput.getIdSubtipoCotizante());
			retorno.setCodSubtipoCotizante(ejbObjectOutput.getCodSubtipoCotizante());
			retorno.setDscSubTipoCotizante(ejbObjectOutput.getDscSubTipoCotizante());
			retorno.setIdSCExtranjeria(ejbObjectOutput.getIdSCExtranjeria());
			retorno.setCodSCExtranjeria(ejbObjectOutput.getCodSCExtranjeria());
			retorno.setFechaColResidenteExterior(ejbObjectOutput.getFechaColResidenteExterior());
			retorno.setEmailCotizanteParaEnvioSoportes(ejbObjectOutput.getEmailCotizanteParaEnvioSoportes());
			retorno.setIdDepartamento(ejbObjectOutput.getIdDepartamento());
			retorno.setCodDepartamento(ejbObjectOutput.getCodDepartamento());
			retorno.setNombreDepartamento(ejbObjectOutput.getNombreDepartamento());
			retorno.setIdMunicipio(ejbObjectOutput.getIdMunicipio());
			retorno.setCodMunicipio(ejbObjectOutput.getCodMunicipio());
			retorno.setNombreMunicipio(ejbObjectOutput.getNombreMunicipio());
			retorno.setSalario(ejbObjectOutput.getSalario());
			retorno.setSalarioIntegral(ejbObjectOutput.isSalarioIntegral());
			retorno.setSalarioEfectivo(ejbObjectOutput.getSalarioEfectivo());
			retorno.setSmmlv(ejbObjectOutput.getSMMLV());
			retorno.setIdParametroSMMLV(ejbObjectOutput.getIdParametroSMMLV());
			retorno.setIdTipoIdentificacionPrinc(ejbObjectOutput.getIdTipoIdentificacionPrinc());
			retorno.setCodTipoIdentificacionPrinc(ejbObjectOutput.getCodTipoIdentificacionPrinc());
			retorno.setNombreTipoIdentificacionPrinc(ejbObjectOutput.getNombreTipoIdentificacionPrinc());
			retorno.setNroIdentificacionPrinc(ejbObjectOutput.getNroIdentificacionPrinc());
			retorno.setCargadoPlanillaPreviaPagada(ejbObjectOutput.isCargadoPlanillaPagada());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ "co.swatit.pilautil.converter.Converter.convertDatosBasicosCotizante");
		return retorno;
	}

	/**
	 * Método que convierte un objeto de tipo {@link com.ach.pla.biz.transfer.ObligatoriedadDTO} en
	 * {@link ObligatoriedadDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 7/04/2017
	 *
	 * @param ejbObjectOutput
	 *            , {@link com.ach.pla.biz.transfer.ObligatoriedadDTO} con la información obtenida de SOI
	 * @return {@link ObligatoriedadDTO} resultado del proceso
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static ObligatoriedadDTO convertObligatoriedad(com.ach.pla.biz.transfer.ObligatoriedadDTO ejbObjectOutput)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + "co.swatit.pilautil.converter.Converter.convertObligatoriedad");
		ObligatoriedadDTO retorno = new ObligatoriedadDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setIdSoiTpCotizante(ejbObjectOutput.getIdSoiTpCotizante());
			retorno.setIdSoiSubtpCotizante(ejbObjectOutput.getIdSoiSubtpCotizante());
			retorno.setIdSoiAportante(ejbObjectOutput.getIdSoiAportante());
			retorno.setIdSoiSubsistema(ejbObjectOutput.getIdSoiSubsistema());
			retorno.setIdSoiExtranjeria(ejbObjectOutput.getIdSoiExtranjeria());
			retorno.setTpObligatoriedad(Utilities.getEnumName(ejbObjectOutput.getTpObligatoriedad()));
			retorno.setMinCantidadDiasCotizados(ejbObjectOutput.getMinCantidadDiasCotizados());
			retorno.setMaxCantidadDiasCotizados(ejbObjectOutput.getMaxCantidadDiasCotizados());
			retorno.setMinIbcCotizadoCantSmmlv(ejbObjectOutput.getMinIbcCotizadoCantSmmlv());
			retorno.setMaxIbcCotizadoCantSmmlv(ejbObjectOutput.getMaxIbcCotizadoCantSmmlv());
			retorno.setFechaVigencia(Utilities.convertCalendarToString(ejbObjectOutput.getFechaVigencia()));
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + "co.swatit.pilautil.converter.Converter.convertObligatoriedad");
		return retorno;
	}

	/**
	 * Método que convierte un objeto de tipo {@link com.ach.pla.biz.transfer.ResultadoValidacionBduaDTO} en
	 * {@link ResultadoValidacionBduaDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 7/04/2017
	 *
	 * @param ejbObjectOutput
	 *            , {@link com.ach.pla.biz.transfer.ResultadoValidacionBduaDTO} con la información obtenida de SOI
	 * @return {@link ResultadoValidacionBduaDTO} resultado del proceso
	 */
	public static ResultadoValidacionBduaDTO convertResultadoValidacionBdua(
			com.ach.pla.biz.transfer.ResultadoValidacionBduaDTO ejbObjectOutput) {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "co.swatit.pilautil.converter.Converter.convertResultadoValidacionBdua");
		ResultadoValidacionBduaDTO retorno = new ResultadoValidacionBduaDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setValorUpc(ejbObjectOutput.getValorUpc());
			retorno.setTipoAfiliado(ejbObjectOutput.getTipoAfiliado());
			retorno.setFechaAfiliacionEps(ejbObjectOutput.getFechaAfiliacionEps());
			retorno.setSegundoNombre(ejbObjectOutput.getSegundoNombre());
			retorno.setPrimerNombre(ejbObjectOutput.getPrimerNombre());
			retorno.setSegundoApellido(ejbObjectOutput.getSegundoApellido());
			retorno.setPrimerApellido(ejbObjectOutput.getPrimerApellido());
			retorno.setCodigoEps(ejbObjectOutput.getCodigoEps());
			retorno.setSerial(ejbObjectOutput.getSerial());
			retorno.setNumeroIdentificacion(ejbObjectOutput.getNumeroIdentificacion());
			retorno.setCodTpIdentificacion(ejbObjectOutput.getCodTpIdentificacion());
			retorno.setCodigoAfp(ejbObjectOutput.getCodigoAfp());
			retorno.setFechaAfiliacionAfp(ejbObjectOutput.getFechaAfiliacionAfp());
			retorno.setIdSoiBduaNsoi(ejbObjectOutput.getIdSoiBduaNsoi());
			retorno.setPresentaDiferenciaNombres(ejbObjectOutput.isPresentaDiferenciaNombres());
			retorno.setPresentaDiferenciaCodEps(ejbObjectOutput.isPresentaDiferenciaCodEps());
			retorno.setPresentaDiferenciaCodAfp(ejbObjectOutput.isPresentaDiferenciaCodAfp());
			retorno.setPresentaDiferenciaPrimerNombre(ejbObjectOutput.isPresentaDiferenciaPrimerNombre());
			retorno.setPresentaDiferenciaSegundoNombre(ejbObjectOutput.isPresentaDiferenciaSegundoNombre());
			retorno.setPresentaDiferenciaPrimerApellido(ejbObjectOutput.isPresentaDiferenciaPrimerApellido());
			retorno.setPresentaDiferenciaSegundoApellido(ejbObjectOutput.isPresentaDiferenciaSegundoApellido());
			retorno.setPresentaDiferenciaValorUpc(ejbObjectOutput.isPresentaDiferenciaValorUpc());
			retorno.setPresentaValorUpcInvalido(ejbObjectOutput.isPresentaValorUpcInvalido());
			retorno.setPresentaFechaAfiliacionMayor(ejbObjectOutput.isPresentaFechaAfiliacionMayor());
			retorno.setNoExisteConfigRuaf(ejbObjectOutput.isNoExisteConfigRuaf());
			retorno.setPresentaDiferenciaCodAfpVigente(ejbObjectOutput.isPresentaDiferenciaCodAfpVigente());
			retorno.setNombreEpsBdua(ejbObjectOutput.getNombreEpsBdua());
			retorno.setNombreAfpBdua(ejbObjectOutput.getNombreAfpBdua());
			retorno.setCodigoAfpReportada(ejbObjectOutput.getCodigoAfpReportada());
			retorno.setCoincidencia(ejbObjectOutput.getCoincidencia());
			retorno.setPresentaPeriodoSaludActual(ejbObjectOutput.isPresentaPeriodoSaludActual());
			retorno.setPresentaPeriodoMayorAFP(ejbObjectOutput.isPresentaPeriodoMayorAFP());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ "co.swatit.pilautil.converter.Converter.convertResultadoValidacionBdua");
		return retorno;
	}

	/**
	 * Método que convierte un objeto de tipo {@link VariacionSalarioVO} en {@link VariacionSalarioDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 7/04/2017
	 *
	 * @param ejbObjectOutput
	 *            , {@link VariacionSalarioVO} con la información obtenida de SOI
	 * @return {@link VariacionSalarioDTO} resultado del proceso
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static VariacionSalarioDTO convertVariacionSalario(VariacionSalarioVO ejbObjectOutput)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ " co.swatit.pilautil.converter.Converter.convertVariacionSalario");
		VariacionSalarioDTO retorno = new VariacionSalarioDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setDiaInicial(ejbObjectOutput.getDiaInicial());
			retorno.setDiaFinal(ejbObjectOutput.getDiaFinal());
			retorno.setNuevoSalario(ejbObjectOutput.getNuevoSalario());
			retorno.setIntegral(ejbObjectOutput.isIntegral());
			retorno.setNuevoSalarioEfectivo(ejbObjectOutput.getNuevoSalarioEfectivo());
			retorno.setFechaFin(Utilities.convertCalendarToString(ejbObjectOutput.getFechaFin()));
			retorno.setFechaInicio(Utilities.convertCalendarToString(ejbObjectOutput.getFechaInicio()));
			retorno.setCalculosDiasIBC(ejbObjectOutput.isCalculosDiasIBC());
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ " co.swatit.pilautil.converter.Converter.convertVariacionSalario");
		return retorno;
	}

	/**
	 * Método que convierte un objeto de tipo {@link com.ach.pla.biz.transfer.NovedadDTO} en {@link NovedadDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 7/04/2017
	 *
	 * @param ejbObjectOutput
	 *            , {@link com.ach.pla.biz.transfer.NovedadDTO} con la información obtenida de SOI
	 * @return {@link NovedadDTO} resultado del proceso
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static NovedadDTO convertNovedad(com.ach.pla.biz.transfer.NovedadDTO ejbObjectOutput)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME + " co.swatit.pilautil.converter.Converter.convertNovedad");
		NovedadDTO retorno = new NovedadDTO();
		if (Validation.isNotNull(ejbObjectOutput)) {
			retorno.setTipoNovedad(Utilities.getEnumName(ejbObjectOutput.getTipoNovedad()));
			retorno.setDiaING(ejbObjectOutput.getDiaING());
			retorno.setTipoING(Utilities.getEnumName(ejbObjectOutput.getTipoING()));
			retorno.setDiaRET(ejbObjectOutput.getDiaRET());
			retorno.setTipoRET(Utilities.getEnumName(ejbObjectOutput.getTipoRET()));
			retorno.setIdAdministradora(ejbObjectOutput.getIdAdministradora());
			retorno.setCodAdministradora(ejbObjectOutput.getCodAdministradora());
			retorno.setNombreAdministradora(ejbObjectOutput.getNombreAdministradora());
			retorno.setUltimaVSP(ejbObjectOutput.isUltimaVSP());
			retorno.setUltimaVST(ejbObjectOutput.isUltimaVST());
			retorno.setUltimaSLN(ejbObjectOutput.isUltimaSLN());
			retorno.setUltimaCOM(ejbObjectOutput.isUltimaCOM());
			retorno.setDiaInicial(ejbObjectOutput.getDiaInicial());
			retorno.setDiaFinal(ejbObjectOutput.getDiaFinal());
			retorno.setIbcNovedad(ejbObjectOutput.getIbcNovedad());
			retorno.setTarifaSalud(ejbObjectOutput.getTarifaSalud());
			retorno.setAportaPensionSLN(ejbObjectOutput.isAportaPensionSLN());
			retorno.setPorcentajeIGE(ejbObjectOutput.getPorcentajeIGE());
			retorno.setAporteAportante(ejbObjectOutput.getAporteAportante());
			retorno.setAporteCotizante(ejbObjectOutput.getAporteCotizante());
			retorno.setValorNoRetenido(ejbObjectOutput.getValorNoRetenido());
			retorno.setTipoCorreccion(Utilities.getEnumName(ejbObjectOutput.getTipoCorreccion()));
			retorno.setTipoSLN(Utilities.getEnumName(ejbObjectOutput.getTipoSLN()));
			retorno.setFechaDeInicio(Utilities.convertCalendarToString(ejbObjectOutput.getFechaDeInicio()));
			retorno.setFechaDeFin(Utilities.convertCalendarToString(ejbObjectOutput.getFechaDeFin()));
			retorno.setCalculosDiasIBC(ejbObjectOutput.isCalculosDiasIBC());
			retorno.setTipoVacaciones(Utilities.getEnumName(ejbObjectOutput.getTipoVacaciones()));
			retorno.setIbcCalculadoNovedad(ejbObjectOutput.getIbcCalculadoNovedad());
			retorno.getVariacionesRegMultiple().addAll(
					getVariationsStructure(ejbObjectOutput.getVariacionesRegMultiple()));
			retorno.getVariacionesCOM().addAll(getVariationsStructure(ejbObjectOutput.getVariacionesCOM()));
			retorno.getVariacionesSLN().addAll(getVariationsStructure(ejbObjectOutput.getVariacionesSLN()));
			retorno.getVariacionesVSP().addAll(getVariationsStructure(ejbObjectOutput.getVariacionesVSP()));
			retorno.getVariacionesVST().addAll(getVariationsStructure(ejbObjectOutput.getVariacionesVST()));
		} else {
			LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT + " co.swatit.pilautil.converter.Converter.convertNovedad");
		return retorno;
	}

	/**
	 * Método que convierte un objeto de tipo {@link Collection} de objetos {@link VariacionSalarioVO} en una
	 * {@link List} de objetos {@link VariacionSalarioDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 7/04/2017
	 *
	 * @param ejbOutputCollection
	 *            {@link Collection} a convertir
	 * @return {@link List} de objetos {@link VariacionSalarioDTO} resultado de la conversión
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	private static List<VariacionSalarioDTO> getVariationsStructure(Collection<VariacionSalarioVO> ejbOutputCollection)
			throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ "  co.swatit.pilautil.converter.Converter.getVariationsStructure");
		List<VariacionSalarioDTO> retorno = new ArrayList<VariacionSalarioDTO>();
		if (Validation.isNotNull(ejbOutputCollection)) {
			for (VariacionSalarioVO variacion : ejbOutputCollection) {
				retorno.add(convertVariacionSalario(variacion));
			}
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ "  co.swatit.pilautil.converter.Converter.getVariationsStructure");
		return retorno;
	}

	/**
	 * Método que convierte un objeto de tipo {@link PlanillaCotizanteDTO} en
	 * {@link com.ach.pla.biz.transfer.PlanillaCotizanteDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 7/04/2017
	 *
	 * @param ejbObjectOutput
	 *            , {@link com.ach.pla.biz.transfer.PlanillaCotizanteDTO} con la información obtenida de SOI
	 * @return {@link PlanillaCotizanteDTO} resultado del proceso
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static PlanillaCotizanteDTO convertPlanillaCotizante(
			com.ach.pla.biz.transfer.PlanillaCotizanteDTO ejbObjectOutput) throws BusinessException {
		LOGGER.info(Constants.LOG_CLASS_METHOD_NAME
				+ " co.swatit.pilautil.converter.Converter.convertPlanillaCotizante");
		PlanillaCotizanteDTO retorno = new PlanillaCotizanteDTO();
		try {
			if (Validation.isNotNull(ejbObjectOutput)) {
				retorno.setModificado(ejbObjectOutput.isModificado());
				retorno.setSeleccionado(ejbObjectOutput.isSeleccionado());
				retorno.setIndiceCotizante(ejbObjectOutput.getIndiceCotizante());
				retorno.setExoneradoParafiscales(ejbObjectOutput.getExoneradoParafiscales());
				retorno.setTiempoEjb0(ejbObjectOutput.getTiempoEjb0());
				retorno.setTiempoEjb1(ejbObjectOutput.getTiempoEjb1());
				retorno.setMostrarDiasLaborados(ejbObjectOutput.isMostrarDiasLaborados());
				retorno.setNumeroDiasLaborados(ejbObjectOutput.getNumeroDiasLaborados());
				retorno.setIdSoiCotizante(ejbObjectOutput.getIdSoiCotizante());
				retorno.setIdWebCotizante(ejbObjectOutput.getIdWebCotizante());
				retorno.setIdWebSlnComCotizante(ejbObjectOutput.getIdWebSlnComCotizante());
				retorno.setDatosBasicosCotizanteDTO(convertDatosBasicosCotizante(ejbObjectOutput
						.getDatosBasicosCotizanteVO()));
				retorno.setCotizanteA(convertPlanillaCotizante(ejbObjectOutput.getCotizanteA()));
				retorno.setCotizanteC(convertPlanillaCotizante(ejbObjectOutput.getCotizanteC()));
				retorno.setAplicaFSP(ejbObjectOutput.isAplicaFSP());
				retorno.setCargadoPlanillaAnteriorPagada(ejbObjectOutput.isCargadoPlanillaAnteriorPagada());
				retorno.setEsCotizanteSln(ejbObjectOutput.isEsCotizanteSln());
				retorno.setEsCotizanteCom(ejbObjectOutput.isEsCotizanteCom());
				retorno.setCotizanteLey1607(ejbObjectOutput.isCotizanteLey1607StandAlone());
				retorno.setValidarArpEntPub(ejbObjectOutput.isValidarArpEntPub());
				retorno.setNovedadSLNCOM(ejbObjectOutput.getNovedadSLNCOM());
				retorno.setIdGrupoCotizantesPlanillaN(ejbObjectOutput.getIdGrupoCotizantesPlanillaN());
				retorno.setExisteConfiguracionTpCzte4(ejbObjectOutput.isExisteConfiguracionTpCzte4());
				retorno.setCodAdminSaludBdua(ejbObjectOutput.getCodAdminSaludBdua());
				retorno.setCoincidenciaBdua(ejbObjectOutput.getCoincidenciaBdua());
				retorno.setCodAdminPensionBdua(ejbObjectOutput.getCodAdminPensionBdua());
				retorno.setValorUpcBdua(ejbObjectOutput.getValorUpcBdua());
				retorno.setCodAfpReportada(ejbObjectOutput.getCodAfpReportada());
				retorno.setResultadoValidacionBduaDTO(convertResultadoValidacionBdua(ejbObjectOutput
						.getResultadoValidacionBduaDTO()));
				retorno.setConcuerdaTarifaSalud(ejbObjectOutput.isConcuerdaTarifaSalud());
				retorno.setConcuerdaTarifaArp(ejbObjectOutput.isConcuerdaTarifaArp());
				retorno.setOrigenPlanillaPagada(ejbObjectOutput.isOrigenPlanillaPagada());
				retorno.setEsCotizante23(ejbObjectOutput.isEsCotizante23());
				retorno.setSecuencia(ejbObjectOutput.getSecuencia());
				retorno.setAdminEditable(ejbObjectOutput.isAdminEditable());
				retorno.setUpcEditable(ejbObjectOutput.isUPCEditable());
				retorno.setValorUpcModificado(ejbObjectOutput.isValorUpcModificado());
				retorno.setPrimerNombreArchivo(ejbObjectOutput.getPrimerNombreArchivo());
				retorno.setSegundoNombreArchivo(ejbObjectOutput.getSegundoNombreArchivo());
				retorno.setPrimerApellidoArchivo(ejbObjectOutput.getPrimerApellidoArchivo());
				retorno.setSegundoApellidoArchivo(ejbObjectOutput.getSegundoApellidoArchivo());
				retorno.setCodAdministradoraEpsArchivo(ejbObjectOutput.getCodAdministradoraEpsArchivo());
				retorno.setEsPlanillaNReferidaT(ejbObjectOutput.isEsPlanillaNReferidaT());
				retorno.setValorBecaMadreSustituta(ejbObjectOutput.getValorBecaMadreSustituta());
				retorno.setAdministradoraEpsRegC(ejbObjectOutput.isAdministradoraEpsRegC());
				retorno.setIbcOtrosParafiscales(ejbObjectOutput.getIbcOtrosParafiscales());
				retorno.setNumeroHorasLaboradas(ejbObjectOutput.getNumeroHorasLaboradas());
				retorno.setCalculosDiasIBC(ejbObjectOutput.isCalculosDiasIBC());
				retorno.setLiquidacionSoloFsp(ejbObjectOutput.isLiquidacionSoloFsp());
				retorno.setRepCztesMultiples(ejbObjectOutput.isRepCztesMultiples());
				retorno.setPlanillaJReferida(ejbObjectOutput.isPlanillaJReferida());
				retorno.setValidacionOffline(ejbObjectOutput.isValidacionOffline());
				retorno.setCzteDependienteNr415(ejbObjectOutput.isCzteDependienteNr415());
				retorno.setSinAportePension(ejbObjectOutput.isSinAportePension());
				getContributorPayrollStructures(retorno, ejbObjectOutput);
				TipoSubSistemasType.SUBSISTEMA_ARP.getIdSubsistema();
				Map<Integer, AporteSubsistemaVO> aportesSubsistemas = new HashMap<Integer, AporteSubsistemaVO>();
				for (Map.Entry<TipoSubSistemasType, AporteSubsistemaVO> aporte : ejbObjectOutput
						.getAportesSubsistemas().entrySet()) {
					aportesSubsistemas.put(aporte.getKey().getIdSubsistema(), aporte.getValue());
				}
				String jsonAportesSubsistemas = ParserUtils.INSTANCE.convertObjectToJSON(aportesSubsistemas);
				retorno.setJsonAportesSubsistemasString(jsonAportesSubsistemas);
			} else {
				LOGGER.warn(Constants.LOG_NULL_PARAMETER + "ejbObjectOutput");
			}
		} catch (JsonProcessingException e) {
			throw new BusinessException(CodeErrorEnum.ERRORUNEXPECTED, e);
		}
		LOGGER.info(Constants.LOG_CLASS_METHOD_EXIT
				+ " co.swatit.pilautil.converter.Converter.convertPlanillaCotizante");
		return retorno;
	}

	/**
	 * Método que realiza la conversión de las estructuras del objeto
	 * {@link com.ach.pla.biz.transfer.PlanillaCotizanteDTO} a {@link PlanillaCotizanteDTO}
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 7/04/2017
	 *
	 * @param wsObjectOutput
	 *            , {@link PlanillaCotizanteDTO} con la información obtenida del objeto
	 * @param ejbObjectOutput
	 *            , {@link com.ach.pla.biz.transfer.PlanillaCotizanteDTO} con la información obtenida por parte de SOI
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	private static void getContributorPayrollStructures(PlanillaCotizanteDTO wsObjectOutput,
			com.ach.pla.biz.transfer.PlanillaCotizanteDTO ejbObjectOutput) throws BusinessException {
		Collection<com.ach.pla.biz.transfer.NovedadDTO> novedades = ejbObjectOutput.getNovedades();
		if (Validation.isNotNull(novedades)) {
			for (com.ach.pla.biz.transfer.NovedadDTO novedad : novedades) {
				wsObjectOutput.getNovedades().add(convertNovedad(novedad));
			}
		}
		Collection<AporteSubsistemaVO> aportesSubsistema = ejbObjectOutput.getAportes();
		if (Validation.isNotNull(aportesSubsistema)) {
			for (AporteSubsistemaVO aporte : aportesSubsistema) {
				wsObjectOutput.getAportesSubsistemas().add(convertAporteSubsistema(aporte));
			}
		}
		Collection<com.ach.pla.biz.transfer.NovedadDTO> novedadesSLNCOM = ejbObjectOutput
				.getNovedadSLNCOMdeDiasLaborados();
		if (Validation.isNotNull(novedadesSLNCOM)) {
			for (com.ach.pla.biz.transfer.NovedadDTO novedad : novedadesSLNCOM) {
				wsObjectOutput.getNovedadSLNCOMdeDiasLaborados().add(convertNovedad(novedad));
			}
		}

		Collection<com.ach.pla.biz.transfer.ObligatoriedadDTO> opcionesObligatoriedad = ejbObjectOutput
				.getOpcionesObligatoriedad();
		if (Validation.isNotNull(opcionesObligatoriedad)) {
			for (com.ach.pla.biz.transfer.ObligatoriedadDTO obligatoriedad : opcionesObligatoriedad) {
				wsObjectOutput.getOpcionesObligatoriedad().add(convertObligatoriedad(obligatoriedad));
			}
		}
	}

}
package co.swatit.pilautil.generics;

import co.swatit.pilautil.dto.in.GetUsuarioAutenticadoInDTO;
import co.swatit.pilautil.dto.out.GetConsultFileOutDTO;
import co.swatit.pilautil.dto.out.GetConsultPayrollOutDTO;
import co.swatit.pilautil.dto.out.GetValidateFileOutDTO;

import com.ach.arc.biz.transfer.ArchivoEnProcesoConsultaDTO;
import com.ach.arc.biz.transfer.ArchivoNotificacionDTO;
import com.ach.pla.biz.transfer.PlanillaConsultadaDTO;
import com.ach.pla.biz.type.PeriodoType;
import com.ach.seg.biz.model.UsuarioVO;
import com.ach.seg.biz.transfer.UsuarioAutenticadoDTO;
import com.lucasian.exception.ApplicationException;

public final class VOBuilder {

	/**
	 * Constructor.
	 */
	private VOBuilder() {
	}
	
	public static GetConsultFileOutDTO armarArchivoResponse(ArchivoEnProcesoConsultaDTO archivoEnProcesoConsultaDTO) {
		GetConsultFileOutDTO result = new GetConsultFileOutDTO();
		
		if (archivoEnProcesoConsultaDTO != null) {
			result.setCodigoErrorGuardar(archivoEnProcesoConsultaDTO.getCodigoErrorGuardar());
			result.setCodigoErrorValidacion(archivoEnProcesoConsultaDTO.getCodigoErrorValidacion());
			if (archivoEnProcesoConsultaDTO.getValidacionArchivoVO() != null) {
				result.setCotizantesIngresados(archivoEnProcesoConsultaDTO.getValidacionArchivoVO().getCotizantesIngresados());
				result.setEstado(archivoEnProcesoConsultaDTO.getValidacionArchivoVO().getEstado());
				result.setIdPlanilla(archivoEnProcesoConsultaDTO.getValidacionArchivoVO().getIdPlanilla());
				result.setIdTmpValidacionArchivo(archivoEnProcesoConsultaDTO.getValidacionArchivoVO().getIdTmpValidacionArchivo());
				result.setPorcentajeAvanceGuardado(archivoEnProcesoConsultaDTO.getValidacionArchivoVO().getPorcentajeAvanceGuardado());
				result.setPorcentajeAvanceValidacion(archivoEnProcesoConsultaDTO.getValidacionArchivoVO().getPorcentajeAvanceValidacion());
				result.setRutaArchivoErrores(archivoEnProcesoConsultaDTO.getValidacionArchivoVO().getRutaArchivoErrores());
				result.setRutaArchivoErroresAf(archivoEnProcesoConsultaDTO.getValidacionArchivoVO().getRutaArchivoErroresAf());
				result.setRutaArchivoPlanilla(archivoEnProcesoConsultaDTO.getValidacionArchivoVO().getRutaArchivoPlanilla());
				result.setRutaArchivoValidacion(archivoEnProcesoConsultaDTO.getValidacionArchivoVO().getRutaArchivoValidacion());
				result.setSupera5smmlv(archivoEnProcesoConsultaDTO.getValidacionArchivoVO().getSupera5smmlv());
			}

			result.setFechaCreacion(archivoEnProcesoConsultaDTO.getFechaCreacion());
			result.setFechaModificacion(archivoEnProcesoConsultaDTO.getFechaModificacion());
			result.setIpCreacion(archivoEnProcesoConsultaDTO.getIpCreacion());
			result.setIpModificacion(archivoEnProcesoConsultaDTO.getIpModificacion());
			result.setTrazaErrorGuardar(archivoEnProcesoConsultaDTO.getTrazaErrorGuardar());
			result.setTrazaErrorValidacion(archivoEnProcesoConsultaDTO.getTrazaErrorValidacion());
			result.setUsuarioCreacion(archivoEnProcesoConsultaDTO.getUsuarioCreacion());
			result.setUsuarioModificacion(archivoEnProcesoConsultaDTO.getUsuarioModificacion());
			result.setNombreArchivoError(archivoEnProcesoConsultaDTO.getNombreArchivoError());
			result.setNombreArchivoErrorAsofondo(archivoEnProcesoConsultaDTO.getNombreArchivoErrorAsofondo());
		}
		
		return result;
	}
	
	public static GetConsultPayrollOutDTO arrmarPlanillaResponse(PlanillaConsultadaDTO planillaConsultadaDTO) {
		GetConsultPayrollOutDTO result = new GetConsultPayrollOutDTO();
		
		if (planillaConsultadaDTO != null) {
			result.setIdSoiTpIdentApte(planillaConsultadaDTO.getIdSoiTpIdentApte());
			result.setNombreTpIndentApte(planillaConsultadaDTO.getNombreTpIndentApte());
			result.setNumeroIdentApte(planillaConsultadaDTO.getNumeroIdentApte());
			result.setIdSoiTpIdentApte(planillaConsultadaDTO.getIdSoiTpIdentApte());
			result.setNombreAportante(planillaConsultadaDTO.getNombreAportante());
			result.setIdSoiTpAportante(planillaConsultadaDTO.getIdSoiTpAportante());
			result.setNombreTpAportante(planillaConsultadaDTO.getNombreTpAportante());
			result.setIdSoiClaseAportante(planillaConsultadaDTO.getIdSoiClaseAportante());
			result.setNombreClaseAportante(planillaConsultadaDTO.getNombreClaseAportante());
			result.setIdSoiTpEmpresa(planillaConsultadaDTO.getIdSoiTpEmpresa());
			result.setNombreTpEmpresa(planillaConsultadaDTO.getNombreTpEmpresa());
			result.setNumeroEmpleados(planillaConsultadaDTO.getNumeroEmpleados());
			result.setCantidadCotizante(planillaConsultadaDTO.getCantidadCotizante());
			result.setIdSoiFormaPresentacion(planillaConsultadaDTO.getIdSoiFormaPresentacion());
			result.setNombreFormaPresentacion(planillaConsultadaDTO.getNombreFormaPresentacion());
			result.setIdSoiAdmraArp(planillaConsultadaDTO.getIdSoiAdmraArp());
			result.setNombreAdmraArp(planillaConsultadaDTO.getNombreAdmraArp());
			result.setIdSoiAdmraCcf(planillaConsultadaDTO.getIdSoiAdmraCcf());
			result.setNombreAdmraCcf(planillaConsultadaDTO.getNombreAdmraCcf());
			result.setIdSoiTpPlanilla(planillaConsultadaDTO.getIdSoiTpPlanilla());
			result.setNombreTpPlanilla(planillaConsultadaDTO.getNombreTpPlanilla());
			result.setNumeroAsistida(planillaConsultadaDTO.getNumeroAsistida());
			result.setNumeroElectronica(planillaConsultadaDTO.getNumeroElectronica());
			result.setModalidadPlanilla(planillaConsultadaDTO.getModalidadPlanilla());
			result.setIdSoiFilial(planillaConsultadaDTO.getIdSoiFilial());
			result.setNombreFilial(planillaConsultadaDTO.getNombreFilial());
			result.setDiasMora(planillaConsultadaDTO.getDiasMora());
			result.setTasaMora(planillaConsultadaDTO.getTasaMora());
			result.setValorMora(planillaConsultadaDTO.getValorMora());
			if (planillaConsultadaDTO.getPeriodoSalud() != null) {
				result.setPeriodoSalud(planillaConsultadaDTO.getPeriodoSalud().getPeriodoNombreMesString());	
			}
			
			if (planillaConsultadaDTO.getPeriodoNoSalud() != null) {
				result.setPeriodoNoSalud(planillaConsultadaDTO.getPeriodoNoSalud().getPeriodoNombreMesString());	
			}
			
			result.setIdFormaElaboracion(planillaConsultadaDTO.getIdFormaElaboracion());
			result.setFechaPagoCalendario(planillaConsultadaDTO.getFechaPagoCalendario());
			result.setFechaPagoefectiva(planillaConsultadaDTO.getFechaPagoefectiva());
			result.setNumeroPlanillaReferida(planillaConsultadaDTO.getNumeroPlanillaReferida());
			result.setFechaPagoPlanillaReferida(planillaConsultadaDTO.getFechaPagoPlanillaReferida());
			result.setIdSoiTpPlanillaReferida(planillaConsultadaDTO.getIdSoiTpPlanillaReferida());
			result.setCodigoTpPlanillaReferida(planillaConsultadaDTO.getCodigoTpPlanillaReferida());
			result.setNombreTpPlanillaReferida(planillaConsultadaDTO.getNombreTpPlanillaReferida());
			result.setEstadoPlanilla(planillaConsultadaDTO.getEstadoPlanilla());
			result.setConfirmacionRetroactivo(planillaConsultadaDTO.isConfirmacionRetroactivo());
			result.setIdSoiAportante(planillaConsultadaDTO.getIdSoiAportante());
			result.setFechaRegistroMercantil(planillaConsultadaDTO.getFechaRegistroMercantil());
			result.setCodDepartamentoAportante(planillaConsultadaDTO.getCodigoTpPlanillaReferida());
			result.setCodMunicipioAportante(planillaConsultadaDTO.getCodMunicipioAportante());
			result.setGuardadaCompletamente(planillaConsultadaDTO.getGuardadaCompletamente());
			result.setCalcularMora(planillaConsultadaDTO.isCalcularMora());
			result.setValorTotalPago(planillaConsultadaDTO.getValorTotalPago());
			result.setExoneradoParafiscales(planillaConsultadaDTO.getExoneradoParafiscales());
			result.setIdResponsableLiqAportante(planillaConsultadaDTO.getIdResponsableLiqAportante());
		}
		
		return result;
	}
	
	
	public static PlanillaConsultadaDTO planillaResponseToPlanillaConsultada(GetConsultPayrollOutDTO getConsultPayrollOutDTO) throws ApplicationException {
		PlanillaConsultadaDTO planillaConsultadaDTO = new PlanillaConsultadaDTO();
		
		planillaConsultadaDTO.setPeriodoNoSalud(new PeriodoType(getConsultPayrollOutDTO.getPeriodoNoSalud()));
		planillaConsultadaDTO.setPeriodoSalud(new PeriodoType(getConsultPayrollOutDTO.getPeriodoSalud()));
		
		return planillaConsultadaDTO;
	}
	
	
	public static ArchivoNotificacionDTO armarArchivoNotificacion(GetValidateFileOutDTO getValidateFileOutDTO, PlanillaConsultadaDTO planillaConsultadaDTO) {
		ArchivoNotificacionDTO archivoNotificacionDTO = new ArchivoNotificacionDTO();
		
		if (getValidateFileOutDTO != null) {
			archivoNotificacionDTO.setIdArchivoEnProceso(getValidateFileOutDTO.getIdArchivoEnProceso());	
			
			archivoNotificacionDTO.setIdSegUsuario(getValidateFileOutDTO.getIdSegUsuario());
			archivoNotificacionDTO.setIdSoiPlanilla(getValidateFileOutDTO.getIdSoiPlanilla());
			archivoNotificacionDTO.setNotificacionDeArchivoEnProcesoType(getValidateFileOutDTO.getNotificacionDeArchivoEnProcesoType());
			archivoNotificacionDTO.setNumeroTotalDeEmpleadosPorPantalla(getValidateFileOutDTO.getNumeroTotalDeEmpleadosPorPantalla());
			archivoNotificacionDTO.setIdArchivoEnProceso(getValidateFileOutDTO.getIdArchivoEnProceso());
			archivoNotificacionDTO.setNombreArchivo(getValidateFileOutDTO.getNombreArchivo());
			archivoNotificacionDTO.setIdAportante(getValidateFileOutDTO.getIdAportante());
			archivoNotificacionDTO.setIdSoiPlanillaGuardada(getValidateFileOutDTO.getIdSoiPlanillaGuardada());
			archivoNotificacionDTO.setCodTipoPlanilla(getValidateFileOutDTO.getCodTipoPlanilla());
			archivoNotificacionDTO.setIdSoiTpPlanilla(getValidateFileOutDTO.getIdSoiTpPlanilla());
			archivoNotificacionDTO.setPeriodoNoSalud(planillaConsultadaDTO.getPeriodoNoSalud());
			archivoNotificacionDTO.setPeriodoSalud(planillaConsultadaDTO.getPeriodoSalud());
		}
		
		return archivoNotificacionDTO;
	}
	
	
	public static UsuarioAutenticadoDTO armarUsuarioAutenticado(GetUsuarioAutenticadoInDTO getUsuarioAutenticadoInDTO) {
		UsuarioAutenticadoDTO usuarioAutenticadoDTO = new UsuarioAutenticadoDTO();
		
		if (getUsuarioAutenticadoInDTO != null) {
			//usuarioAutenticadoDTO.setApteUgpp(getUsuarioAutenticadoInDTO.isApteUgpp());
			usuarioAutenticadoDTO.setCorreoAportanteUsuario(getUsuarioAutenticadoInDTO.getCorreoAportanteUsuario());
			//usuarioAutenticadoDTO.setIdRecursoLiquidacionPlanillaU(getUsuarioAutenticadoInDTO.getIdRecursoLiquidacionPlanillaU());
			usuarioAutenticadoDTO.setIdSoiAportanteUsuario(getUsuarioAutenticadoInDTO.getIdSoiAportanteUsuario());
			usuarioAutenticadoDTO.setPermitirActualizarDatosApteMigrado(getUsuarioAutenticadoInDTO.isPermitirActualizarDatosApteMigrado());
			usuarioAutenticadoDTO.setUsuarioCreacion(getUsuarioAutenticadoInDTO.getUsuarioCreacion());
			UsuarioVO usuarioVO = new UsuarioVO();
			usuarioVO.setCuenta(getUsuarioAutenticadoInDTO.getUsuarioCreacion());
			usuarioAutenticadoDTO.setUsuarioVO(usuarioVO);
			usuarioAutenticadoDTO.setIpUsuarioOrigen(getUsuarioAutenticadoInDTO.getIpUsuarioOrigen());
		}
		
		return usuarioAutenticadoDTO;
	}
}

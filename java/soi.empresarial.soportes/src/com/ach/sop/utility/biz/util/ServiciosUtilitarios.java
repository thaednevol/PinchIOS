package com.ach.sop.utility.biz.util;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.ach.cfg.biz.type.TipoSubSistemasType;
import com.ach.pla.biz.model.AporteSubsistemaVO;
import com.ach.pla.biz.type.PeriodoType;
import com.ach.sop.biz.transfer.PlanillaSoporteCotizanteDTO;
import com.ach.sop.biz.transfer.PlanillaSoporteEncabezadoPlanillaDTO;
import com.ach.sop.utility.biz.transfer.DatosEnvioCorreoDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lucasian.exception.ApplicationException;
import com.lucasian.exception.SystemException;


public class ServiciosUtilitarios {
	
	
	public static String transformarEncabezadoJson(PlanillaSoporteEncabezadoPlanillaDTO dto){
		String respuestaJson=null;
		Gson gson=new Gson();
		respuestaJson =gson.toJson(dto);
		return respuestaJson;
	}
	
	public static String transformarCotizanteJson(Collection<PlanillaSoporteCotizanteDTO> cotizantes){
		String respuestaJson=null;
		Gson gson=new Gson();
		respuestaJson =gson.toJson(cotizantes);
		return respuestaJson;
	}
	public static DatosEnvioCorreoDTO  convertirDatosEnvioCorreo(String datosEnvio){
		DatosEnvioCorreoDTO dto =null;
		Gson gson=new Gson();
		dto =gson.fromJson(datosEnvio, DatosEnvioCorreoDTO.class);
		return dto;
	}
	
	public static PlanillaSoporteEncabezadoPlanillaDTO  convertirDatosEncabezadoDTO(String datosEntrada){
		PlanillaSoporteEncabezadoPlanillaDTO dto =null;
		Gson gson=new Gson();
		dto =gson.fromJson(datosEntrada, PlanillaSoporteEncabezadoPlanillaDTO.class);
		if(dto.getActividadEconAportante()!=null&&dto.getActividadEconAportante().isEmpty()){
			dto.setActividadEconAportante(null);
		}
		if(dto.getClaseAportante()!=null&&dto.getClaseAportante().isEmpty()){
			dto.setClaseAportante(null);
		}
		if(dto.getCodAdm()!=null&&dto.getClaseAportante().isEmpty()){
			dto.setClaseAportante(null);
		}
		if(dto.getCodigoFilialAportante()!=null&&dto.getCodigoFilialAportante().isEmpty()){
			dto.setCodigoFilialAportante(null);
		}
		if(dto.getCodigoOperador()!=null&&dto.getCodigoOperador().isEmpty()){
			dto.setCodigoOperador(null);
		}
		if(dto.getDiasMoraPlanilla()!=null&&dto.getDiasMoraPlanilla().isEmpty()){
			dto.setDiasMoraPlanilla(null);
		}
		if(dto.getDireccionAportante()!=null&&dto.getDireccionAportante().isEmpty()){
			dto.setDireccionAportante(null);
		}
		if(dto.getEstadoPlanilla()!=null&&dto.getEstadoPlanilla().isEmpty()){
			dto.setEstadoPlanilla(null);
		}
		if(dto.getExoneradoParafiscales()!=null&&dto.getExoneradoParafiscales().isEmpty()){
			dto.setExoneradoParafiscales(null);
		}
		if(dto.getIdAdm()!=null&&dto.getIdAdm().isEmpty()){
			dto.setIdAdm(null);
		}
		if(dto.getIdSoiCodigoOperador()!=null&&dto.getIdSoiCodigoOperador().isEmpty()){
			dto.setIdSoiCodigoOperador(null);
		}
		if(dto.getNombreAportante()!=null&&dto.getNombreAportante().isEmpty()){
			dto.setNombreAportante(null);
		}
		if(dto.getNombreDepartamentoAportante()!=null&&dto.getNombreDepartamentoAportante().isEmpty()){
			dto.setNombreDepartamentoAportante(null);
		}
		if(dto.getNombreFilialAportante()!=null&&dto.getNombreFilialAportante().isEmpty()){
			dto.setNombreFilialAportante(null);
		}
		if(dto.getNombreFrmPresentacionAportante()!=null&&dto.getNombreFrmPresentacionAportante().isEmpty()){
			dto.setNombreFrmPresentacionAportante(null);
		}
		if(dto.getNombreLogo()!=null&&dto.getNombreLogo().isEmpty()){
			dto.setNombreLogo(null);
		}
		if(dto.getNombreMunicipioAportante()!=null&&dto.getNombreMunicipioAportante().isEmpty()){
			dto.setNombreMunicipioAportante(null);
		}
		if(dto.getNombreTipoAportante()!=null&&dto.getNombreTipoAportante().isEmpty()){
			dto.setNombreTipoAportante(null);
		}
		if(dto.getNombreTipoEmpresaAportante()!=null&&dto.getNombreTipoEmpresaAportante().isEmpty()){
			dto.setNombreTipoEmpresaAportante(null);
		}
		if(dto.getNombreTipoIdentificacion()!=null&&dto.getNombreTipoIdentificacion().isEmpty()){
			dto.setNombreTipoIdentificacion(null);
		}
		if(dto.getNombreTipoPlanilla()!=null&&dto.getNombreTipoPlanilla().isEmpty()){
			dto.setNombreTipoPlanilla(null);
		}
		if(dto.getNombreUsuarioQueGeneraElReporte()!=null&&dto.getNombreUsuarioQueGeneraElReporte().isEmpty()){
			dto.setNombreUsuarioQueGeneraElReporte(null);
		}
		if(dto.getNotaAdicionalDelRpt()!=null&&dto.getNotaAdicionalDelRpt().isEmpty()){
			dto.setNotaAdicionalDelRpt(null);
		}
		if(dto.getNumeroAsistidaPlanilla()!=null&&dto.getNumeroAsistidaPlanilla().isEmpty()){
			dto.setNumeroAsistidaPlanilla(null);
		}
		if(dto.getNumeroAutorizacionPagoPlanilla()!=null&&dto.getNumeroAutorizacionPagoPlanilla().isEmpty()){
			dto.setNumeroAutorizacionPagoPlanilla(null);
		}
		if(dto.getNumeroElectronicaPlanilla()!=null&&dto.getNumeroElectronicaPlanilla().isEmpty()){
			dto.setNumeroElectronicaPlanilla(null);
		}
		if(dto.getNumeroEmpleadosPlanilla()!=null&&dto.getNumeroEmpleadosPlanilla().isEmpty()){
			dto.setNumeroEmpleadosPlanilla(null);
		}
		if(dto.getNumeroIdentificacionAportante()!=null&&dto.getNumeroIdentificacionAportante().isEmpty()){
			dto.setNumeroIdentificacionAportante(null);
		}
		if(dto.getNumeroPlanillaReferidaPlanilla()!=null&&dto.getNumeroPlanillaReferidaPlanilla().isEmpty()){
			dto.setNumeroPlanillaReferidaPlanilla(null);
		}
		if(dto.getPeriodoCotOtrosPlanillaString()!=null&&dto.getPeriodoCotOtrosPlanillaString().isEmpty()){
			dto.setPeriodoCotOtrosPlanillaString(null);
		}
		if(dto.getPeriodoCotSaludPlanillaString()!=null&&dto.getPeriodoCotSaludPlanillaString().isEmpty()){
			dto.setPeriodoCotSaludPlanillaString(null);
		}
		if(dto.getTasaMoraPlanilla()!=null&&dto.getTasaMoraPlanilla().isEmpty()){
			dto.setTasaMoraPlanilla(null);
		}
		if(dto.getTelefonoAportante()!=null&&dto.getTelefonoAportante().isEmpty()){
			dto.setTelefonoAportante(null);
		}
		if(dto.getTituloDelRpt()!=null&&dto.getTituloDelRpt().isEmpty()){
			dto.setTituloDelRpt(null);
		}
		if(dto.getValorMoraPlanilla()!=null&&dto.getValorMoraPlanilla().isEmpty()){
			dto.setValorMoraPlanilla(null);
		}
		if(dto.getPeriodoCotOtrosPlanillaString()!=null&&!dto.getPeriodoCotOtrosPlanillaString().isEmpty()){
			try {
				dto.setPeriodoCotOtrosPlanilla(new PeriodoType(dto.getPeriodoCotOtrosPlanillaString()));
			} catch (ApplicationException e) {
				throw new SystemException("Formato invalido para campo periodo cotizacion otros (YYYYMM) "+dto.getPeriodoCotOtrosPlanillaString(),e);
			}
		}
		if(dto.getPeriodoCotSaludPlanillaString()!=null&&!dto.getPeriodoCotSaludPlanillaString().isEmpty()){
			try {
				dto.setPeriodoCotSaludPlanilla(new PeriodoType(dto.getPeriodoCotSaludPlanillaString()));
			} catch (ApplicationException e) {
				throw new SystemException("Formato invalido para campo periodo cotizacion salud (YYYYMM) "+dto.getPeriodoCotSaludPlanillaString(),e);
			}
		}
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		Calendar fecha = Calendar.getInstance();
		if(dto.getFechaPagoCalendarioPlanillaInMillis()!=0){		
			try{
				fecha.setTime(fmt.parse(dto.getFechaPagoCalendarioPlanillaInMillis()+""));
			}catch ( Exception e ){}
			
			dto.setFechaPagoCalendarioPlanilla(fecha);
		}
		if(dto.getFechaPagoEfectivaPlanillaInMillis()!=0){
			try{
				fecha.setTime(fmt.parse(dto.getFechaPagoEfectivaPlanillaInMillis()+""));
			}catch ( Exception e ){}			
			dto.setFechaPagoEfectivaPlanilla(fecha);
		}
		if(dto.getFechaPlanillaReferidaPlanillaInMillis()!=0){
			
			try{
				fecha.setTime(fmt.parse(dto.getFechaPlanillaReferidaPlanillaInMillis()+""));
			}catch ( Exception e ){}			
			dto.setFechaPlanillaReferidaPlanilla(fecha);						
		}
		
		return dto;
	}
	
	
	public static Collection<PlanillaSoporteCotizanteDTO> convertirDatosCotizantes(String datosCotizantes){
		final Type tipoListaCotizantes = new TypeToken<Collection<PlanillaSoporteCotizanteDTO>>(){}.getType();
		final Type typeMapaSubsistemas = new TypeToken<Map<String, AporteSubsistemaVO>>(){}.getType();
		Map<String, AporteSubsistemaVO> aportesSubsistemasString = null;
		Gson gson=new Gson();
		Collection<PlanillaSoporteCotizanteDTO>cotizantes=gson.fromJson(datosCotizantes, tipoListaCotizantes);
		
		
		for(PlanillaSoporteCotizanteDTO dto:cotizantes){
			if(dto.getPrimerNombre()!=null&&dto.getPrimerNombre().isEmpty()){
				dto.getDatosBasicosCotizanteVO().setPrimerNombre(null);
			}
			if(dto.getDatosBasicosCotizanteVO().getSegundoNombre()!=null&&dto.getDatosBasicosCotizanteVO().getSegundoNombre().isEmpty()){
				dto.getDatosBasicosCotizanteVO().setSegundoNombre(null);
			}
			if(dto.getDatosBasicosCotizanteVO().getPrimerApellido()!=null&&dto.getDatosBasicosCotizanteVO().getPrimerApellido().isEmpty()){
				dto.getDatosBasicosCotizanteVO().setPrimerApellido(null);
			}
			if(dto.getDatosBasicosCotizanteVO().getSegundoApellido()!=null&&dto.getDatosBasicosCotizanteVO().getSegundoApellido().isEmpty()){
				dto.getDatosBasicosCotizanteVO().setSegundoApellido(null);
			}
			if(dto.getDatosBasicosCotizanteVO().getCodTipoIdentificacion()!=null&&dto.getDatosBasicosCotizanteVO().getCodTipoIdentificacion().isEmpty()){
				dto.getDatosBasicosCotizanteVO().setCodTipoIdentificacion(null);
			}
			if(dto.getDatosBasicosCotizanteVO().getNroIdentificacion()!=null&&dto.getDatosBasicosCotizanteVO().getNroIdentificacion().isEmpty()){
				dto.getDatosBasicosCotizanteVO().setNroIdentificacion(null);
			}
			if(dto.getDatosBasicosCotizanteVO().getDscTipoCotizante()!=null&&dto.getDatosBasicosCotizanteVO().getDscTipoCotizante().isEmpty()){
				dto.getDatosBasicosCotizanteVO().setDscTipoCotizante(null);
			}
			if(dto.getDatosBasicosCotizanteVO().getDscSubTipoCotizante()!=null&&dto.getDatosBasicosCotizanteVO().getDscSubTipoCotizante().isEmpty()){
				dto.getDatosBasicosCotizanteVO().setDscSubTipoCotizante(null);
			}
			if(dto.getDatosBasicosCotizanteVO().getCodSCExtranjeria()!=null&&dto.getDatosBasicosCotizanteVO().getCodSCExtranjeria().isEmpty()){
				dto.getDatosBasicosCotizanteVO().setCodSCExtranjeria(null);
			}
			if(dto.getDatosBasicosCotizanteVO().getNombreDepartamento()!=null&&dto.getDatosBasicosCotizanteVO().getNombreDepartamento().isEmpty()){
				dto.getDatosBasicosCotizanteVO().setNombreDepartamento(null);
			}
			if(dto.getDatosBasicosCotizanteVO().getNombreMunicipio()!=null&&dto.getDatosBasicosCotizanteVO().getNombreMunicipio().isEmpty()){
				dto.getDatosBasicosCotizanteVO().setNombreMunicipio(null);
			}
			if(dto.getING()!=null&&dto.getING().isEmpty()){
				dto.setING(null);
			}
			if(dto.getRET()!=null&&dto.getRET().isEmpty()){
				dto.setRET(null);
			}
			if(dto.getTDE()!=null&&dto.getTDE().isEmpty()){
				dto.setTDE(null);
			}
			if(dto.getTAE()!=null&&dto.getTAE().isEmpty()){
				dto.setTAE(null);
			}
			if(dto.getTDP()!=null&&dto.getTDP().isEmpty()){
				dto.setTDP(null);
			}
			if(dto.getTAP()!=null&&dto.getTAP().isEmpty()){
				dto.setTAP(null);
			}
			if(dto.getCOR()!=null&&dto.getCOR().isEmpty()){
				dto.setCOR(null);
			}
			if(dto.getVSP()!=null&&dto.getVSP().isEmpty()){
				dto.setVSP(null);
			}
			if(dto.getVST()!=null&&dto.getVST().isEmpty()){
				dto.setVST(null);
			}
			if(dto.getSLN()!=null&&dto.getSLN().isEmpty()){
				dto.setSLN(null);
			}
			if(dto.getIGE()!=null&&dto.getIGE().isEmpty()){
				dto.setIGE(null);
			}
			if(dto.getLMA()!=null&&dto.getLMA().isEmpty()){
				dto.setLMA(null);
			}
			if(dto.getVAC()!=null&&dto.getVAC().isEmpty()){
				dto.setVAC(null);
			}
			if(dto.getAVP()!=null&&dto.getAVP().isEmpty()){
				dto.setAVP(null);
			}
			if(dto.getVCT()!=null&&dto.getVCT().isEmpty()){
				dto.setVCT(null);
			}
			if(dto.getIRP()!=null&&dto.getIRP().isEmpty()){
				dto.setIRP(null);
			}
			if(dto.getCOM()!=null&&dto.getCOM().isEmpty()){
				dto.setCOM(null);
			}
			if(dto.getExoneradoParafiscales()!=null&&dto.getExoneradoParafiscales().isEmpty()){
				dto.setExoneradoParafiscales(null);
			}
			
			if(dto.getJsonAportesSubsistemasString()!=null&&!dto.getJsonAportesSubsistemasString().isEmpty()){
				aportesSubsistemasString =gson.fromJson(dto.getJsonAportesSubsistemasString(), typeMapaSubsistemas);
				
				if(aportesSubsistemasString!=null){
					dto.setAportesSubsistemas(new HashMap<TipoSubSistemasType, AporteSubsistemaVO>());
					AporteSubsistemaVO aporteSubsistemaVO=null;
					TipoSubSistemasType tipoSubSistemasType=null;
					for(String llave:aportesSubsistemasString.keySet()){
						tipoSubSistemasType=TipoSubSistemasType.getTipoSubSistemasXId(Integer.valueOf(llave));
						aporteSubsistemaVO=dto.getAportesSubsistemas().get(tipoSubSistemasType);
						if(aporteSubsistemaVO!=null){
							dto.getAportesSubsistemas().remove(tipoSubSistemasType);
						}
						aporteSubsistemaVO=aportesSubsistemasString.get(llave);
						if(aporteSubsistemaVO.getNombreAdministradora()!=null&&aporteSubsistemaVO.getNombreAdministradora().isEmpty()){
							aporteSubsistemaVO.setNombreAdministradora(null);
						}
						if(aporteSubsistemaVO.getNroAutorizacionIGE()!=null&&aporteSubsistemaVO.getNroAutorizacionIGE().isEmpty()){
							aporteSubsistemaVO.setNroAutorizacionIGE(null);
						}
						if(aporteSubsistemaVO.getNroAutorizacionLMA()!=null&&aporteSubsistemaVO.getNroAutorizacionLMA().isEmpty()){
							aporteSubsistemaVO.setNroAutorizacionLMA(null);
						}
						if(aporteSubsistemaVO.getCodClaseRiesgo()!=null&&aporteSubsistemaVO.getCodClaseRiesgo().isEmpty()){
							aporteSubsistemaVO.setCodClaseRiesgo(null);
						}
						if(aporteSubsistemaVO.getCentroTrabajo()!=null&&aporteSubsistemaVO.getCentroTrabajo().isEmpty()){
							aporteSubsistemaVO.setCentroTrabajo(null);
						}
						if(aporteSubsistemaVO.getIndicadorTarifaEspecialPen()!=null&&aporteSubsistemaVO.getIndicadorTarifaEspecialPen().isEmpty()){
							aporteSubsistemaVO.setIndicadorTarifaEspecialPen(null);
						}
						
						dto.getAportesSubsistemas().put(tipoSubSistemasType, aporteSubsistemaVO);
					}
				}
				
				
			}
			
			
			
		}
		return cotizantes;
	}
	

}

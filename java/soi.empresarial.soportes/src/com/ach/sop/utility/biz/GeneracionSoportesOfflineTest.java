package com.ach.sop.utility.biz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.ach.cfg.biz.type.TipoSubSistemasType;
import com.ach.pla.biz.model.AporteSubsistemaVO;
import com.ach.pla.biz.model.DatosBasicosCotizanteVO;
import com.ach.pla.biz.type.ModalidadPlanillaType;
import com.ach.sop.biz.transfer.PlanillaSoporteCotizanteDTO;
import com.ach.sop.biz.transfer.PlanillaSoporteEncabezadoPlanillaDTO;
import com.ach.sop.utility.biz.transfer.DatosEnvioCorreoDTO;
import com.ach.sop.utility.biz.util.ServiciosUtilitarios;
import com.google.gson.Gson;

public class GeneracionSoportesOfflineTest {
	
	public static void main(String ars[]) {
		DatosEnvioCorreoDTO dto=new DatosEnvioCorreoDTO();
		dto.setContrasenaUsuarioAutenticacion("manager2009");
		dto.setCuentaCorreoElectronicoDestino("g.andres.castro@gmail.com");
		dto.setCuentaCorreoElectronicoOrigen("correoprueba@gmail.com");
		dto.setNombreUsuarioAutenticacion("correoprueba@gmail.com");
		dto.setPuertoServidorCorreo("465");
		dto.setServidorCorreo("smtp.gmail.com");
		dto.setServidorRequiereAutenticacion(true);
		dto.setServidorRequiereSsl(true);
		dto.setServidorRequiereTls(false);
		Gson gson=new Gson();
		Collection<PlanillaSoporteCotizanteDTO>cotizantes=generarCotizantesEjemplo();
		PlanillaSoporteEncabezadoPlanillaDTO encabezado=generarEncabezadoEjemplo(((ArrayList<PlanillaSoporteCotizanteDTO>)cotizantes).get(0));
		String jsonEncabezado=ServiciosUtilitarios.transformarEncabezadoJson(encabezado);
		String jsonCotizantes=ServiciosUtilitarios.transformarCotizanteJson(cotizantes);
		//new GeneracionSoportesOffline().generarSoporteCotizante(jsonEncabezado, jsonCotizantes,gson.toJson(dto));
	
	}
	
	
	private static PlanillaSoporteEncabezadoPlanillaDTO generarEncabezadoEjemplo(PlanillaSoporteCotizanteDTO cotizante){
		PlanillaSoporteEncabezadoPlanillaDTO dto=new PlanillaSoporteEncabezadoPlanillaDTO();
		dto.setModalidad(ModalidadPlanillaType.ASISTIDA.getIdModalidadPlanilla());
		dto.setNumeroAsistidaPlanilla("018003456678");
		dto.setNumeroElectronicaPlanilla("700004324234");
		dto.setCodigoOperador("01");
		dto.setNombreAportante("Empresa privada de desarrollo");
		dto.setNombreTipoIdentificacion("CEDULA CIUDADANIA");
		StringBuilder nombreParaTituloCotizantes =new StringBuilder (cotizante.getCodTipoIdentificacion()).append(" ").append(cotizante.getNroIdentificacion());
        dto.setTituloDelRpt(new StringBuilder()
        		.append(" SOPORTE DE PAGO PARA EL COTIZANTE ")
        		.append(nombreParaTituloCotizantes).toString());
        dto.setNumeroIdentificacionAportante("80853221");
        dto.setNombreDepartamentoAportante("Cundinamarca");
        dto.setNombreMunicipioAportante("Bogota");
        dto.setDireccionAportante("Calle 127 15-01");
        dto.setTelefonoAportante("6251245");
        dto.setNombreTipoAportante("2-INDEPENDIENTE");
        dto.setClaseAportante("I-INDEPENDIENTE");
        dto.setNombreTipoEmpresaAportante("Privada");
        dto.setActividadEconAportante("Servicios profesionales de software");
        dto.setNombreFrmPresentacionAportante("Sucursal");
        dto.setNombreFilialAportante("Sede principal");
        dto.setCodigoFilialAportante("01");
        dto.setNombreTipoPlanilla("E-EMPLEADOS");
        dto.setPeriodoCotOtrosPlanillaString("201612");
        dto.setPeriodoCotSaludPlanillaString("201701");
        dto.setDiasMoraPlanilla("0");
        dto.setFechaPagoCalendarioPlanillaInMillis(Calendar.getInstance().getTimeInMillis());
        dto.setFechaPagoEfectivaPlanillaInMillis(Calendar.getInstance().getTimeInMillis());
        dto.setValorTotalAPagar(new BigDecimal("320000"));
        dto.setNombreUsuarioQueGeneraElReporte("PruebaComponente");
        dto.setComision(BigDecimal.ZERO);
        dto.setIvaComision(BigDecimal.ZERO);
        dto.setNombreLogo("01.gif");
        dto.setExoneradoParafiscales("NO");
        dto.setNumeroAutorizacionPagoPlanilla("234965175");
        dto.setDiasMoraPlanilla("2");
        
        return dto;
	}
	
	private static Collection<PlanillaSoporteCotizanteDTO> generarCotizantesEjemplo(){
		Collection<PlanillaSoporteCotizanteDTO> cotizantes =new ArrayList<PlanillaSoporteCotizanteDTO>();
		PlanillaSoporteCotizanteDTO cotizante=new PlanillaSoporteCotizanteDTO();
		cotizante.setDatosBasicosCotizanteVO(new DatosBasicosCotizanteVO());
		Map<String, AporteSubsistemaVO> aportes=new HashMap<String, AporteSubsistemaVO>();
		cotizante.setING("X");
		cotizante.getDatosBasicosCotizanteVO().setPrimerNombre("Pepito");
		cotizante.getDatosBasicosCotizanteVO().setPrimerApellido("Perez");
		cotizante.getDatosBasicosCotizanteVO().setCodTipoIdentificacion("CC");
		cotizante.getDatosBasicosCotizanteVO().setNroIdentificacion("88881");
		cotizante.getDatosBasicosCotizanteVO().setDscTipoCotizante("INDEPENDIENTE");
		cotizante.getDatosBasicosCotizanteVO().setNombreDepartamento("BOGOTA DISTRITO CAPITAL");
		cotizante.getDatosBasicosCotizanteVO().setNombreMunicipio("BOGOTA DISTRITO CAPITAL");
		cotizante.getDatosBasicosCotizanteVO().setSalario(new BigDecimal("689454"));
		cotizante.getDatosBasicosCotizanteVO().setSalarioIntegral(false);
		cotizante.setExoneradoParafiscalesCotizante("NO");
		cotizante.setExoneradoParafiscales("NO");
		cotizante.setExoneradoParafiscalesAportante("NO");
		
		AporteSubsistemaVO aporteSubsistemaVO=new AporteSubsistemaVO();
		aporteSubsistemaVO.setNombreAdministradora("230301-PORVENIR");
		aporteSubsistemaVO.setNroDiasSubsistema(30);
		aporteSubsistemaVO.setIbcSubsistema(new BigDecimal("689455"));
		aporteSubsistemaVO.setTarifaSubsistema(new BigDecimal("0.16"));
		aporteSubsistemaVO.setValorAporteSubsistema(new BigDecimal("110313"));
		aporteSubsistemaVO.setIndicadorTarifaEspecialPen("Normal");
		aportes.put(TipoSubSistemasType.SUBSISTEMA_PENSION.getIdSubsistema().toString(), aporteSubsistemaVO);
		
		aporteSubsistemaVO=new AporteSubsistemaVO();
		aporteSubsistemaVO.setNombreAdministradora("EPS037-NUEVA EPS");
		aporteSubsistemaVO.setNroDiasSubsistema(30);
		aporteSubsistemaVO.setIbcSubsistema(new BigDecimal("689455"));
		aporteSubsistemaVO.setTarifaSubsistema(new BigDecimal("0.125"));
		aporteSubsistemaVO.setValorAporteSubsistema(new BigDecimal("86200"));
		aportes.put(TipoSubSistemasType.SUBSISTEMA_SALUD.getIdSubsistema().toString(), aporteSubsistemaVO);
		
		aporteSubsistemaVO=new AporteSubsistemaVO();
		aporteSubsistemaVO.setNombreAdministradora("14-29-LA EQUIDAD");
		aporteSubsistemaVO.setNroDiasSubsistema(30);
		aporteSubsistemaVO.setIbcSubsistema(new BigDecimal("689455"));
		aporteSubsistemaVO.setTarifaSubsistema(new BigDecimal("0.01044"));
		aporteSubsistemaVO.setIdClaseRiesgo(1);
		aporteSubsistemaVO.setCentroTrabajo("88881"); 
		aporteSubsistemaVO.setValorAporteSubsistema(new BigDecimal("7200"));
		aportes.put(TipoSubSistemasType.SUBSISTEMA_ARP.getIdSubsistema().toString(), aporteSubsistemaVO);
		
		Gson gson=new Gson();
		cotizante.setJsonAportesSubsistemasString(gson.toJson(aportes));
		cotizantes.add(cotizante);
		return cotizantes;
	}

		
}


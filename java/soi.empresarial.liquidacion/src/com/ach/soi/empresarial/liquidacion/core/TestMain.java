package com.ach.soi.empresarial.liquidacion.core;

import java.util.Calendar;

import javax.naming.Context;
import javax.naming.NamingException;

import com.ach.arc.biz.AdminProcesarCargaArchivosSvc;
import com.ach.arc.biz.r1747.model.bean.PlanillaRegT01;
import com.ach.arc.biz.r1747.type.TipoInputImplType;
import com.ach.arc.biz.r1747.util.ArchivoEntradaParser;
import com.ach.arc.biz.r1747.util.ValidacionArchivoDataSource;
import com.ach.arc.biz.transfer.ArchivoEnProcesoDTO;
import com.ach.cfg.biz.type.TipoFormasPresentacionType;
import com.ach.pla.biz.transfer.PlanillaAportanteDTO;
import com.ach.pla.biz.type.EstadoProcesosArchivoPlanoType;
import com.ach.soi.empresarial.liquidacion.model.ErrorRegistroTO;
import com.blackbear.flatworm.ConfigurationReader;
import com.blackbear.flatworm.FileFormat;
import com.lucasian.common.jee.jndi.JNDIContextFactory;
import com.lucasian.exception.ApplicationException;

public class TestMain {
/*
	public static void main ( String ars[] ) throws Exception{
		try{
			TestMain main = new TestMain();
			ConfiguracionTarifasSvc bean = (ConfiguracionTarifasSvc)main.getBeanLookup("ConfiguracionTarifasBean#com.ach.cfg.biz.ConfiguracionTarifasSvc");
			String regTp01 = "0110001APORTANTE JGUTIERREZ                                                                                                                                                                                    NI18401130        6E                    S1000      SUCURSAL 1000                           14-23 2016-112016-1276480860472016-11-28002500011380920001022";
			Long idSoiAportante = 3670l;
			Long idSegUsuario = 3444l;
			
			PlanillaRegT01 beanT01 = main.buildPlanillaRegT01(regTp01);
			PlanillaAportanteDTO encabezadoPlanilla = main.buildPlanillaAportanteDTO(beanT01, idSoiAportante, idSegUsuario);
			ValidacionArchivoDataSource ds = main.crearDatasourceValidacion(encabezadoPlanilla);
			
			TarifasCacheFilterDTO filter = new TarifasCacheFilterDTO();
						
			filter.setVigente(CommonVO.REGISTRO_ACTIVO);
			filter.setIdAdministradora(137);
			filter.setFechaVigencia(Calendar.getInstance());
			Collection<BigDecimal> res1 = null;
			Collection<BigDecimal> res2 = null;
			filter.setIdSoiTpCotizante(6);
			filter.setIdSoiSubtpCotizante(7);
			res1 = bean.consultarTarifasAdministradoraSS(filter);
			res2 = bean.consultarTarifasAdministradoraSS(ds.getAdministradorasTarifasSalud(),filter);
			System.out.println(res1);
			System.out.println(res2);
			for ( int i=1;i<40;i++ ){				
				filter.setIdSoiTpCotizante(i);
				filter.setIdSoiSubtpCotizante(null);
				res1 = bean.consultarTarifasAdministradoraSS(filter);
				res2 = bean.consultarTarifasAdministradoraSS(ds.getAdministradorasTarifasSalud(),filter);
				System.out.println((res1.toString().equals(res2.toString()))?"true":"diferencia---------->TipoCotizante: "+i);
				for ( int j=1;j<50;j++ ){
					filter.setIdSoiSubtpCotizante(j);
					res1 = bean.consultarTarifasAdministradoraSS(filter);
					res2 = bean.consultarTarifasAdministradoraSS(ds.getAdministradorasTarifasSalud(),filter);
					System.out.println((res1.toString().equals(res2.toString()))?"true":"diferencia---------->TipoCotizante: "+i+" - Subtipo: "+j);
				}
			}
			
			
			
		}catch ( Exception e ){
			e.printStackTrace();
		}
	}
	
	
	public static void main ( String ars[] ) throws Exception{
		ErrorRegistroTO[] errores = null;			
		String regTp01 = "0110001APORTANTE JGUTIERREZ                                                                                                                                                                                    NI18401130        6E                    S1000      SUCURSAL 1000                           14-23 2016-112016-1276480860472016-11-28002500011380920001022";
		//String regTp01 = "0110001APORTANTE JGUTIERREZ                                                                                                                                                                                    NI18401130        6E                    U                                                  14-23 2016-112016-1276480860472016-11-28002500011380920001022";
		String regTp02 = "0200001CC1024488638      0100  11001MAYORGA             AVELLANEDA                    PAOLA               ANDREA                            X X X X X  00230301      EPS017      CCF21 30303030002208442 0022080000022080000022080000000000000.160000003533000000000000000000000003533000000000000000000000000000000.12500000276000000000000               000000000               0000000000.00522000000000030000115000.040000000883000.005000000110000.030000000662000.005000000110000.01000000022100                  N14-23 1                     2016-11-01                    2016-11-012016-11-30                    2016-11-012016-11-30                                                 160";
		Long idSoiAportante = 4040l;
		Long idSegUsuario = 4567l;
		try{
		
			TestMain testMain = new TestMain();
			LiquidadorActivos liquidador = new LiquidadorActivos();
			PlanillaRegT01 beanT01 = testMain.buildPlanillaRegT01(regTp01);
			PlanillaAportanteDTO encabezadoPlanilla = testMain.buildPlanillaAportanteDTO(beanT01, idSoiAportante, idSegUsuario);
			ArchivoEnProcesoDTO archivoDto = testMain.createArchivoEnProcesoObject(encabezadoPlanilla,beanT01);
			ValidacionArchivoDataSource ds = testMain.crearDatasourceValidacion(new PlanillaAportanteDTO());
			//errores = liquidador.validarRegistroTp02(encabezadoPlanilla,regTp02, archivoDto, ds, 1);
			//for ( ErrorRegistroTO to:errores ){
			//	System.out.println(to);
			//}
		}catch ( Exception e ){
			e.printStackTrace();
		}
		
	}*/
	
	private PlanillaRegT01 buildPlanillaRegT01 ( String regT01 ) throws Exception{
		FileFormat ps = null;
		ArchivoEntradaParser mn = null;
		PlanillaRegT01 bean01 = null;
		try{
			ConfigurationReader cfg = new ConfigurationReader();
			ps = cfg.loadConfigurationFile(this.getClass().getResourceAsStream("/archivo2388-config.xml"));
			mn = new ArchivoEntradaParser(TipoInputImplType.IO_BUFFERED_READER, ps);
			mn.inicializarMio(regT01);
			bean01 = (PlanillaRegT01)mn.getNextRecord();
			return bean01;
			
		}catch ( ApplicationException e ){
			throw new Exception("Excepcion conviertiendo el RegT01",e);
		}
	}
	
	private ArchivoEnProcesoDTO createArchivoEnProcesoObject(PlanillaAportanteDTO planillaApteDto,PlanillaRegT01 t01){
		ArchivoEnProcesoDTO dto = new ArchivoEnProcesoDTO();
		dto.setAceptaRenunciaLey1233(false);
		dto.setAportanteLey1607(false);
		dto.setCodigoSucursal(planillaApteDto.getCodigoSucursal());
		dto.setCodTipoPlanilla(planillaApteDto.getCodigoSoiTpPlanilla());
		dto.setCodTpDocAportante(planillaApteDto.getInformacionAportantePlanillaDTO().getCodSoiTpIdentificacion());
		dto.setEstadoProcesosArchivoPlanoType(EstadoProcesosArchivoPlanoType.EN_PROCESO);
		dto.setFechaCreacion(Calendar.getInstance());
		dto.setFechaPlanillaAsociada(t01.getFcaPagoPlanillaAsociadaType());
		dto.setIdAportante(planillaApteDto.getIdSoiAportante());
		dto.setNombreAportante(planillaApteDto.getInformacionAportantePlanillaDTO().getNombre());
		dto.setNroDocAportante(planillaApteDto.getInformacionAportantePlanillaDTO().getNumeroIdentificacion());
		dto.setNumeroPlanillaAsociada(planillaApteDto.getNumeroPlanillaAsocida());
		dto.setNumeroTotalDeEmpleadosEnPlanilla(planillaApteDto.getNumeroTotalEmpleados().intValue());
		dto.setPeriodoNoSalud(planillaApteDto.getPeriodoLiquidacionNoSalud());
		dto.setPeriodoSalud(planillaApteDto.getPeriodoLiquidacionSalud());
		dto.setPlanillaCorrector(true);
		dto.setTipoFormaPresentacionType(TipoFormasPresentacionType.getTipoFormasPresentacionXId(planillaApteDto.getIdSoiFormaPresentacion()));
		dto.setUsuarioCreacion("test");
		return dto;
	}
	
	private ValidacionArchivoDataSource crearDatasourceValidacion ( PlanillaAportanteDTO encabezadoPlanilla ) throws Exception{
		AdminProcesarCargaArchivosSvc bean = (AdminProcesarCargaArchivosSvc)this.getBeanLookup("AdminProcesarCargaArchivosBean#com.ach.arc.biz.AdminProcesarCargaArchivosSvc");
		ValidacionArchivoDataSource ds = bean.obtenerConfiguracionParaValidacionArchivoPlano(encabezadoPlanilla);
		return ds;
	}
	
	
	private PlanillaAportanteDTO buildPlanillaAportanteDTO ( PlanillaRegT01 beanTp01,Long idSoiAportante, Long idSegUsuario ) throws Exception{
		AdminProcesarCargaArchivosSvc bean = (AdminProcesarCargaArchivosSvc)this.getBeanLookup("AdminProcesarCargaArchivosBean#com.ach.arc.biz.AdminProcesarCargaArchivosSvc");		
		PlanillaAportanteDTO encabezado = bean.getPlanillaAportanteDTOFromRegT01(beanTp01, idSoiAportante, idSegUsuario);
		
		return encabezado;
	}
	
	
	protected Object getBeanLookup(String beanLookupName) throws Exception{
		
		Context ctx						= null;				
		//beanLookupName = new StringBuilder(remoteName).append("#").append(refId);
		
		try{
			ctx = getContext();
			return ctx.lookup(beanLookupName);
		}catch (NamingException ne) {
			throw new Exception("Excepcion localizando el bean: "+beanLookupName,ne);
		}
	}
	
	private Context getContext() throws Exception{

		
		//190.145.77.219:8001
		//192.168.0.42
		
		return JNDIContextFactory.getRemoteContext(	"t3://190.145.77.219:8001", 
													"weblogic", 
													"manager2016", 
													"weblogic.jndi.WLInitialContextFactory");		
	}
 
}

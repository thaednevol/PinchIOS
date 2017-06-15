package com.ach.soi.empresarial.liquidacion.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ach.arc.biz.exception.ClavesMensajesArchivoConstants;
import com.ach.arc.biz.r1747.mngr.LiquidacionPlanillaXArchivoEvolMngr;
import com.ach.arc.biz.r1747.model.CampoLeido1747;
import com.ach.arc.biz.r1747.model.bean.PlanillaRegT01;
import com.ach.arc.biz.r1747.model.bean.PlanillaRegT02;
import com.ach.arc.biz.r1747.model.bean.PlanillaRegTAbstract;
import com.ach.arc.biz.r1747.type.TipoInputImplType;
import com.ach.arc.biz.r1747.util.ArchivoEntradaParser;
import com.ach.arc.biz.r1747.util.ValidacionArchivoDataSource;
import com.ach.arc.biz.transfer.ArchivoEnProcesoDTO;
import com.ach.arc.biz.validatorcfgs.PlanillaAportanteValidatorCfg;
import com.ach.cfg.biz.cache.AdministradorasSingleton;
import com.ach.cfg.biz.model.AdministradoraVO;
import com.ach.cfg.biz.transfer.AdministradoraTarifaDTO;
import com.ach.pla.biz.mngr.totalizador.TotalizadorPlanillaMngr;
import com.ach.pla.biz.transfer.PlanillaAportanteDTO;
import com.ach.pla.biz.transfer.PlanillaCotizanteDTO;
import com.ach.pla.biz.transfer.PlanillaTotalesDTO;
import com.ach.pla.biz.type.TipoPlanillaType;
import com.ach.soi.empresarial.liquidacion.exceptions.DesktopExceptionMngr;
import com.ach.soi.empresarial.liquidacion.model.ErrorLiquidacionTO;
import com.blackbear.flatworm.ConfigurationReader;
import com.blackbear.flatworm.FileFormat;
import com.lucasian.common.validator.ValidadorUtil;
import com.lucasian.exception.ApplicationException;
import com.lucasian.exception.ExceptionMessage;

public class LiquidadorActivos {

	
	private static FileFormat ps = null;
	private static ArchivoEntradaParser mn = null;
	
	private static Map<String, CampoLeido1747> camposBeanT02 = null;
	
	private static final Logger LOGGER = Logger.getLogger(LiquidadorActivos.class.getName());
	
	static{
		try{
			ConfigurationReader cfg = new ConfigurationReader();
			ps = cfg.loadConfigurationFile(LiquidadorActivos.class.getResourceAsStream("/archivo2388-config.xml"));
			mn = new ArchivoEntradaParser(TipoInputImplType.IO_BUFFERED_READER, ps);
		}catch ( Exception e ){
			LOGGER.fatal(e);
		}
	}
	
	public ErrorLiquidacionTO[] completarPlanillaAportanteDTO ( PlanillaAportanteDTO planillaApteDto, String regT01 ) throws ApplicationException,Exception{
		
		PlanillaRegT01 bean01 = null;
		
		Collection<ErrorLiquidacionTO> errores = new ArrayList<ErrorLiquidacionTO>();
		
		
		ErrorLiquidacionTO err;
		try{			
			mn.inicializarMio(regT01);
			bean01 = (PlanillaRegT01)mn.getNextRecord();
			this.completarPlanillaAportanteDTODePlanillaRegT01(bean01, planillaApteDto);
		}catch ( ApplicationException e ){
			err = crearRegistroErrorLexicoSintacticoRegistro(e,null, 1 ,1);				
			errores.add(err);			
		}
		return errores.toArray(new ErrorLiquidacionTO[0]);				
	}
	
	
	private void completarPlanillaAportanteDTODePlanillaRegT01(
								PlanillaRegT01 planillaRegT01,PlanillaAportanteDTO planillaAportanteDTO) throws ApplicationException {
		LOGGER.info("inicio: completarPlanillaAportanteDTODePlanillaRegT01()");
		String codTipoPlanilla = planillaRegT01.getTipoPlanillaType();
		planillaAportanteDTO.setCodigoSoiTpPlanilla(codTipoPlanilla);
		planillaAportanteDTO.setNumeroTotalEmpleados(planillaRegT01.getNroEmpleadosType());
		planillaAportanteDTO.setCodigoSucursal(planillaRegT01.getCodSucursalType());
		
		planillaAportanteDTO.setNombreSucursal(planillaRegT01.getNmSucursalType());
		com.ach.pla.biz.type.PeriodoType periodoNoSalud = new com.ach.pla.biz.type.PeriodoType(planillaRegT01.getPeriodoNoSaludType());
		com.ach.pla.biz.type.PeriodoType periodoSalud =null;
		
		periodoNoSalud = calcularPeriodoNoSalud(periodoNoSalud, periodoSalud, codTipoPlanilla);
		
		if(planillaRegT01.getTipoPlanillaType().equals(TipoPlanillaType.K_ESTUDIANTES.getCodTpPlanilla())){
			periodoSalud=periodoNoSalud;
		}else{
			periodoSalud = new com.ach.pla.biz.type.PeriodoType(planillaRegT01.getPeriodoSaludType());
		}

		planillaAportanteDTO.setPeriodoLiquidacionNoSalud(periodoNoSalud);
		planillaAportanteDTO.setPeriodoLiquidacionSalud(periodoSalud);

		planillaAportanteDTO.setCodSoiFormaPresentacion(planillaRegT01.getFmaPresentacionType());

		if(planillaRegT01.getModalidadType() != null){
			planillaAportanteDTO.setModalidadPlanilla(planillaRegT01.getModalidadType().intValue());
		}

		PlanillaAportanteValidatorCfg planillaAportanteValidatorCfg = new PlanillaAportanteValidatorCfg();

		LOGGER.info("fin: completarPlanillaAportanteDTODePlanillaRegT01()");
		try{
			ValidadorUtil.validarObjeto(planillaAportanteDTO, planillaAportanteValidatorCfg);
		}catch ( ApplicationException e ){
			LOGGER.error("error completarPlanillaAportanteDTODePlanillaRegT01()", e);
		}

	}
	
	private com.ach.pla.biz.type.PeriodoType calcularPeriodoNoSalud(
			com.ach.pla.biz.type.PeriodoType periodoNoSalud, com.ach.pla.biz.type.PeriodoType periodoSalud,
			String codTipoPlanilla) {

		if (periodoNoSalud != null) {
			return periodoNoSalud;
		}

		periodoNoSalud = new com.ach.pla.biz.type.PeriodoType(periodoSalud.getMes(), periodoSalud.getAno());

		com.ach.pla.biz.type.TipoPlanillaType tipoPlanillaType = com.ach.pla.biz.type.TipoPlanillaType.getTipoPlanillaXCodigo(codTipoPlanilla);
		if (tipoPlanillaType == null) {
			// por lo general este caso nunca debe pasar
			return periodoSalud;
		}

		switch (tipoPlanillaType) {
		case A_EMPLEADOS_ADICIONALES:
			periodoNoSalud = disminuirMes(periodoNoSalud);
			break;
		case E_EMPLEADOS_EMPRESAS:
		case H_MADRES_COMUNITARIAS:
			periodoNoSalud = disminuirMes(periodoNoSalud);
			break;
		default:
			// para las demas planillas es el mismo de salud exceptuando M y N
			// que se toman de planilla referida
			break;
		}

		return periodoNoSalud;
	}
	
	
	public com.ach.pla.biz.type.PeriodoType disminuirMes(com.ach.pla.biz.type.PeriodoType periodo) {
		int nuevoMes = periodo.getMes() - 1;
		int nuevoAno = periodo.getAno();
		if (nuevoMes <= 0) {
			nuevoAno--;
			nuevoMes = 12;
		}
		return new com.ach.pla.biz.type.PeriodoType((byte) nuevoMes, nuevoAno);
	}

	
	
	public ErrorLiquidacionTO[] validarRegsTp02Archivo2388 (ArchivoEnProcesoDTO archivoDto, 
															ValidacionArchivoDataSource datasourceValidacion,
															String pathArchivo2388) throws Exception{
		Collection<ErrorLiquidacionTO> erroresLiquidacion = new ArrayList<ErrorLiquidacionTO>();
		BufferedReader reader = null;
		ErrorLiquidacionTO[] errorRegs = null;
		LOGGER.info("inicio: validarRegsTp02Archivo2388()");
		try{
			reader = new BufferedReader(new FileReader(pathArchivo2388));
			String line = null;
			int nroLinea = 0;
			int oks = 0;
			int regsError = 0;
			while ( (line=reader.readLine())!=null ){
				nroLinea++;
				LOGGER.info("validarRegsTp02Archivo2388()->"+nroLinea);
				if ( line.startsWith("02") ){
					errorRegs = this.validarRegistroTp02(line, archivoDto, datasourceValidacion, nroLinea);					
					if ( errorRegs!=null && errorRegs.length>0 ){
						regsError++;
						erroresLiquidacion.addAll(Arrays.asList(errorRegs));												
					}
					else{
						oks ++;
					}
				}				
			}
			LOGGER.info("Registros OK: "+oks);
			LOGGER.info("Registros Error: "+regsError);
			LOGGER.info("fin: validarRegsTp02Archivo2388()");
		}finally{
			if ( reader!=null ){
				reader.close();
			}
		}
		
		return erroresLiquidacion.toArray(new ErrorLiquidacionTO[0]);
	}
	
	
	public ErrorLiquidacionTO[] validarRegistroTp02 ( 	String registroTp02, 
													ArchivoEnProcesoDTO archivoDto, 
													ValidacionArchivoDataSource datasourceValidacion,
													int nroLinea) throws Exception{
		
					
		LOGGER.info("inicio: validarRegsTp02Archivo2388() -> "+registroTp02);
		cargarSingletonAdministradoras(datasourceValidacion);
		Collection<ErrorLiquidacionTO> errores = new ArrayList<ErrorLiquidacionTO>();
		Collection<ErrorLiquidacionTO> erroresRevalidacion = new ArrayList<ErrorLiquidacionTO>();
		LiquidacionPlanillaXArchivoEvolMngr mngr = new LiquidacionPlanillaXArchivoEvolMngr();
				
		PlanillaRegT02 bean02 = null;
		PlanillaCotizanteDTO czte = null;
		try{		
			
			LOGGER.info("validarRegsTp02Archivo2388() -> Inicializa Cfg");
			try{
				
				mn.inicializarMio(registroTp02);
				bean02 = (PlanillaRegT02)mn.getNextRecord();
				if ( camposBeanT02==null ){
					camposBeanT02 = bean02.getCampos();
				}																											
				LOGGER.info("validarRegsTp02Archivo2388() -> Obtuvo el record");
			}catch ( ApplicationException e ){
				this.manejarBeanConErroresLexicoSintacticos(errores, bean02, e, nroLinea);
				LOGGER.error("validarRegsTp02Archivo2388() -> Errores sintacticos: "+nroLinea);
				return errores.toArray(new ErrorLiquidacionTO[0]);
			}	
			
			if ( bean02.getSecuencia2Type()==null||bean02.getSecuencia2Type().intValue()!=nroLinea-1 ){
				bean02.getSecuencia2().setValorEsperado(""+(nroLinea-1));
				this.manejarBeanConErroresLexicoSintacticos(errores, bean02, 
								new ApplicationException(ClavesMensajesArchivoConstants.ERROR_CONSECUTIVO_REGISTRO,new Object[] { bean02.getSecuencia2() }), 
																nroLinea);
			}
			
			bean02.setNumeroLineaArchivo((int)(bean02.getSecuencia2Type()+1));
			
			archivoDto.setPlanillaCorrector(false);
			try{
				LOGGER.info("validarRegsTp02Archivo2388() -> Inicializa Validacion semantica");
				bean02.setValidacionOffline(true);
				czte = mngr.procesarBeanRegistroT02Individual(datasourceValidacion.getPlanillaApteDto(),bean02, archivoDto, datasourceValidacion);							
			}catch ( ApplicationException e ){
				LOGGER.error("validarRegsTp02Archivo2388() -> Errores semanticos: "+nroLinea);
				this.manejarExcepcionesSemanticas(errores, bean02, e, nroLinea);
				boolean validarNuevamente = true;
				for ( ErrorLiquidacionTO err:errores ){
					if ( err.isAplicarSegundaValidacion() ){
						//Revalida el registro con ibcs modificados										
						validarNuevamente = true;						
						break;
					}
				}
				while ( validarNuevamente ){
					erroresRevalidacion.clear();
					try{
						czte = mngr.procesarBeanRegistroT02Individual(datasourceValidacion.getPlanillaApteDto(),bean02, archivoDto, datasourceValidacion);
					}catch ( ApplicationException e1 ){
						LOGGER.error("validarRegsTp02Archivo2388() -> Errores semanticos en revalidacion: "+nroLinea);						
						this.manejarExcepcionesSemanticas(erroresRevalidacion, bean02, e1, nroLinea);
						errores.addAll(erroresRevalidacion);
					}
					validarNuevamente = false;
					for ( ErrorLiquidacionTO err:erroresRevalidacion ){
						if ( err.isAplicarSegundaValidacion() ){										
							validarNuevamente = true;						
							break;
						}
					}									
				}
			}
			boolean totalizar = false;
			totalizar = true;
			for ( ErrorLiquidacionTO err:errores ){
				if ( !err.isAutocorregible() ){
					totalizar = false;
					break;
				}
			}
			//Si se corrigieron todos los errores debe volver a crearse el registro de cotizante ya sin ningun error
			if ( totalizar && czte!=null ){
				 				
				TotalizadorActivos totalizador = TotalizadorActivos.getInstance(datasourceValidacion);
				totalizador.agregarCotizanteAlTotal(czte, nroLinea);
				LOGGER.info("validarRegsTp02Archivo2388() -> Finaliza Validacion semantica");
			}				
		}catch (Exception e) {
			ErrorLiquidacionTO errorTo = new ErrorLiquidacionTO();
			LOGGER.fatal("validarRegsTp02Archivo2388() -> Errores inesperado",e);
			errorTo.setAutocorregible(false);
			errorTo.setCampo(0);
			errorTo.setErrorRegistro(true);
			errorTo.setLinea(nroLinea);
			errorTo.setError("Error no identificado");
			errorTo.setNombreCampo("-");
			errores.add(errorTo);
		}
		return errores.toArray(new ErrorLiquidacionTO[0]);
	}
	
	
	private void cargarSingletonAdministradoras ( ValidacionArchivoDataSource ds ) throws Exception{
		ArrayList<AdministradoraVO> admins = new ArrayList<AdministradoraVO>();
		
		for ( AdministradoraTarifaDTO a:ds.getAdministradorasPension() ){
			admins.add(a.getAdministradora());
		}
		
		for ( AdministradoraTarifaDTO a:ds.getAdministradorasSalud() ){
			admins.add(a.getAdministradora());
		}
		

		for ( AdministradoraVO a:ds.getAdministradorasRiesgoYCcf() ){
			admins.add(a);
		}
		
		AdministradorasSingleton.getInstance(admins);
	}
	
	public PlanillaTotalesDTO calcularTotalesPlanilla ( ValidacionArchivoDataSource ds, String pathArchivo2388, ArchivoEnProcesoDTO archivoDto ) throws Exception{
		LOGGER.info("inicio - calcularTotalesPlanilla()");
		TotalizadorPlanillaMngr totalizador = new TotalizadorPlanillaMngr(ds.getPlanillaApteDto());		
		BufferedReader reader = new BufferedReader(new FileReader(pathArchivo2388));
		PlanillaCotizanteDTO czte = null;
		Collection<ErrorLiquidacionTO> errores = new ArrayList<ErrorLiquidacionTO>();
		try{
			LOGGER.info("calcularTotalesPlanilla() - recorre registros del archivo");
			String line = null;
			int nroLinea = 0;
			while ( ( line = reader.readLine() )!=null ){
				nroLinea ++;
				if ( line.startsWith("02") ){
					//czte = this.validarRegistroTp02(line, archivoDto, ds, nroLinea, errores);
					if (  czte!=null ){
						
					}
				}
			}			
		}catch ( Exception e ){
			LOGGER.error("Error calculando los totales",e);
		}
		finally{
			if ( reader!=null ){
				reader.close();
			}
		}
		LOGGER.info("fin - calcularTotalesPlanilla()");
		return totalizador.getPlanillaTotalesDTO();
	}
	
	

	private void manejarExcepcionesSemanticas(	Collection<ErrorLiquidacionTO> errores,
														PlanillaRegTAbstract bean, 
														ApplicationException exc, int nroLinea) {

		int secuenciaError = 0;
		ErrorLiquidacionTO err = null;	
		
		/*if ( bean instanceof PlanillaRegT02 ){
			PlanillaRegT02 b02 = (PlanillaRegT02)bean;
			System.out.println("_________________________________________");
			System.out.println("Validacion Cotizante");
			System.out.println("Tipo Identif: "+b02.getTpDocumentoCotizante3Type());
			System.out.println("Nro Identif: "+b02.getNumeroIdentificacionCotizante4Type());
			System.out.println("IBC Pens: "+b02.getIBCPension42Type());
			System.out.println("Cot Pens: "+b02.getCotizacionObligatoria47Type());
			System.out.println("IBC Salud: "+b02.getIBCSalud43Type());
			System.out.println("Cot Salud: "+b02.getCotizacionOblSalud55Type());
			System.out.println("_________________________________________");
		}*/
		
		if (exc.isMultiple()) {
			for (ApplicationException e : exc.getAppExceptionSet()) {
				err = crearRegistroErrorLexicoSintacticoRegistro(e, bean,nroLinea,++secuenciaError);				
				errores.add(err);
			}
		} else {
			
			err = crearRegistroErrorLexicoSintacticoRegistro(exc,bean,nroLinea,++secuenciaError);
			errores.add(err);
		}
	}
	

	public void manejarBeanConErroresLexicoSintacticos(Collection<ErrorLiquidacionTO> errores,PlanillaRegTAbstract bean,ApplicationException exc, int nroLinea) {

		int secuenciaError = 0;
		
		if (exc.isMultiple()) {

			for (CampoLeido1747 campo : bean.getCampos().values()) {
				ErrorLiquidacionTO err = null;
				if (campo.isConError()) {
					err = crearRegistroErrorLexicoSintacticoEnCampo(++secuenciaError,campo.getExcepcion(),bean, campo,nroLinea);
					errores.add(err);
				}
				
			}
		} else {
			ErrorLiquidacionTO err = crearRegistroErrorLexicoSintacticoRegistro(exc,bean,nroLinea,++secuenciaError);
			errores.add(err);
		}
	}

	
	
	private ErrorLiquidacionTO crearRegistroErrorLexicoSintacticoEnCampo(int secuenciaError,ApplicationException excepcion, PlanillaRegTAbstract reg,CampoLeido1747 campo, int nroLinea) {

		//return err;
		ErrorLiquidacionTO err = new ErrorLiquidacionTO();
						
		ExceptionMessage msge = DesktopExceptionMngr.getInstance().manejarException(excepcion);
		err.setCampo(0);
		err.setNombreCampo(campo!=null?campo.getNombreCampo():"-");
		err.setLinea(nroLinea);
		err.setErrorRegistro(campo==null);
		err.setError(msge.getMensaje());
		if ( reg!=null && reg instanceof PlanillaRegT02 ){
			PlanillaRegT02 reg2 = (PlanillaRegT02)reg;
			err.setTipoIdentificacion(reg2.getTpDocumentoCotizante3Type());
			err.setNroIdentificacion(reg2.getNumeroIdentificacionCotizante4Type());
		}		
		if ( campo!=null && campo.getValorEsperado()!=null && !campo.getValorEsperado().trim().equals("") ){
			if ( campo.getValorEsperado().contains(";") ){
				err.setSugerencias(campo.getValorEsperado().split(";"));
			}
			else{
				err.setSugerencias(campo.getValorEsperado().split("\\s+"));
			}
			
			if ( err.getSugerencias().length==1 ){
				this.verificarErrorIBCoCotizacion(err, reg, campo);
				err.setAutocorregible(true);
			}
		}
		
		if (campo!=null){
			for ( Map.Entry<String,CampoLeido1747> e:camposBeanT02.entrySet() ){
				if ( e.getValue().getNombreCampo().equals(campo.getNombreCampo()) ){					
					err.setCampo(Integer.valueOf(e.getKey()));
					break;
				}
			}
		}
			
		return err;
	}
	
	
	private void verificarErrorIBCoCotizacion ( ErrorLiquidacionTO error, PlanillaRegTAbstract reg,CampoLeido1747 campo  ) {
		if ( !(reg instanceof PlanillaRegT02) || campo==null ){
			return;
		}
		PlanillaRegT02 reg02 = (PlanillaRegT02)reg;
		this.aplicarSugerenciasEnCampo(error, reg02.getIBCCCF45(),campo);			
		this.aplicarSugerenciasEnCampo(error, reg02.getIBCOtrosParafiscales95(),campo);
		this.aplicarSugerenciasEnCampo(error, reg02.getIBCPension42(),campo);
		this.aplicarSugerenciasEnCampo(error, reg02.getIBCRiesgosProfesionales44(),campo);
		this.aplicarSugerenciasEnCampo(error, reg02.getIBCSalud43(),campo);
		this.aplicarSugerenciasEnCampo(error, reg02.getIBCOtrosParafiscales95(),campo);
		this.aplicarSugerenciasEnCampo(error, reg02.getValorApCCF65(),campo);
		this.aplicarSugerenciasEnCampo(error, reg02.getValorApICBF69(),campo);
		this.aplicarSugerenciasEnCampo(error, reg02.getValorApMEN73(),campo);
		this.aplicarSugerenciasEnCampo(error, reg02.getValorApSENA67(),campo);
		this.aplicarSugerenciasEnCampo(error, reg02.getValorESAP71(),campo);
		this.aplicarSugerenciasEnCampo(error, reg02.getCotizacionOblSalud55(),campo);
		this.aplicarSugerenciasEnCampo(error, reg02.getCotOblARP63(),campo);		
		this.aplicarSugerenciasEnCampo(error, reg02.getCodAdminRiesgosLab77(),campo);
		this.aplicarSugerenciasEnCampo(error, reg02.getCotizacionObligatoria47(),campo);
	}
	
	private void aplicarSugerenciasEnCampo ( ErrorLiquidacionTO error,CampoLeido1747 campoLeido, CampoLeido1747 campoError ){
		if ( campoError.getNombreCampo().equals(campoLeido.getNombreCampo()) ){
			verificarSiEnfatizarError(error, campoLeido.getValorNumerico());
			campoLeido.setValorCrudo(error.getSugerencias()[0]);
			if ( campoLeido.getValorAlfanumerico()!=null && !campoLeido.getValorAlfanumerico().trim().equals("") ){
				campoLeido.setValorAlfanumerico(error.getSugerencias()[0]);
			}
			else{
				campoLeido.setValorNumerico(this.getValorLong(error.getSugerencias()[0]));
			}
			
			error.setAplicarSegundaValidacion(true);
		}
	}
	
	private void verificarSiEnfatizarError ( ErrorLiquidacionTO error, Long valorEncontrado ){
		Long valorEsperado = 0l;
		try{
			valorEsperado = Long.valueOf(error.getSugerencias()[0]);
		}catch ( Exception e ){
			return;
		}
		if ( valorEncontrado!=null && ((valorEsperado-valorEncontrado)>100 || (valorEsperado-valorEncontrado)<-100) ){
			error.setEnfasis(true);
		}
		
	}
	
	
	private Long getValorLong ( String val ){
		try{
			return Long.valueOf(val);
		}catch ( Exception e ){
			return 0l;
		}
	}
	

	private ErrorLiquidacionTO crearRegistroErrorLexicoSintacticoRegistro(ApplicationException excepcion, PlanillaRegTAbstract reg, int numeroLineaActual, int idErrorActual) {
		
		ErrorLiquidacionTO err = new ErrorLiquidacionTO();
		
		CampoLeido1747 campo = null;
		if ( excepcion.getParametrosReemplazo()!=null && 
				excepcion.getParametrosReemplazo().length>=1 && 
				excepcion.getParametrosReemplazo()[0] instanceof CampoLeido1747 ){
			campo = (CampoLeido1747)excepcion.getParametrosReemplazo()[0];			
		}
		
		ExceptionMessage msge = DesktopExceptionMngr.getInstance().manejarException(excepcion);
		err.setCampo(0);
		err.setNombreCampo(campo!=null?campo.getNombreCampo():"-");
		err.setLinea(numeroLineaActual);
		err.setErrorRegistro(campo==null);
		err.setError(msge.getMensaje());
		if ( reg!=null && reg instanceof PlanillaRegT02 ){
			PlanillaRegT02 reg2 = (PlanillaRegT02)reg;
			err.setTipoIdentificacion(reg2.getTpDocumentoCotizante3Type());
			err.setNroIdentificacion(reg2.getNumeroIdentificacionCotizante4Type());
		}		
		if ( campo!=null && campo.getValorEsperado()!=null && !campo.getValorEsperado().trim().equals("") ){
			if ( campo.getValorEsperado().contains(";") ){
				err.setSugerencias(campo.getValorEsperado().split(";"));
			}
			else{
				err.setSugerencias(campo.getValorEsperado().split("\\s+"));
			}
			if ( err.getSugerencias().length==1 ){
				err.setAutocorregible(true);
				this.verificarErrorIBCoCotizacion(err, reg, campo);
			}
		}
		
		if (campo!=null){
			for ( Map.Entry<String,CampoLeido1747> e:camposBeanT02.entrySet() ){
				if ( e.getValue().getNombreCampo().equals(campo.getNombreCampo()) ){					
					err.setCampo(Integer.valueOf(e.getKey()));
					break;
				}
			}
		}
			
		return err;
	}

	
}

package com.ach.soi.empresarial.liquidacion.core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ach.arc.biz.exception.ClavesMensajesArchivoConstants;
import com.ach.arc.biz.r1747.mngr.LiquidacionPlanillaXArchivoEvolMngr;
import com.ach.arc.biz.r1747.model.CampoLeido1747;
import com.ach.arc.biz.r1747.model.bean.PlanillaRegT01;
import com.ach.arc.biz.r1747.model.bean.PlanillaRegT02;
import com.ach.arc.biz.r1747.model.bean.PlanillaRegTAbstract;
import com.ach.arc.biz.r1747.type.TipoDatoType;
import com.ach.arc.biz.r1747.type.TipoInputImplType;
import com.ach.arc.biz.r1747.util.ArchivoEntradaParser;
import com.ach.arc.biz.r1747.util.ValidacionArchivoDataSource;
import com.ach.arc.biz.transfer.ArchivoEnProcesoDTO;
import com.ach.arc.biz.transfer.ArchivoNotificacionDTO;
import com.ach.arc.biz.transfer.GrupoCotizantesDTO;
import com.ach.arc.biz.validator.PlanillaArcPreValidador;
import com.ach.arc.biz.validatorcfgs.PlanillaAportanteValidatorCfg;
import com.ach.cfg.biz.cache.AdministradorasSingleton;
import com.ach.cfg.biz.model.AdministradoraVO;
import com.ach.cfg.biz.transfer.AdministradoraTarifaDTO;
import com.ach.pla.biz.mngr.totalizador.TotalizadorPlanillaMngr;
import com.ach.pla.biz.reglas.NSOIRNCotizante;
import com.ach.pla.biz.transfer.PlanillaAportanteDTO;
import com.ach.pla.biz.transfer.PlanillaCotizanteDTO;
import com.ach.pla.biz.transfer.PlanillaTotalesDTO;
import com.ach.pla.biz.type.TipoPlanillaType;
import com.ach.soi.empresarial.converters.utils.Constants;
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
	
	public ErrorLiquidacionTO[] completarPlanillaAportanteDTO ( PlanillaAportanteDTO planillaApteDto, String regT01 ,ArchivoEnProcesoDTO archivoEnProcesoDTO,
			ValidacionArchivoDataSource validacionArchivoDataSource) throws ApplicationException,Exception{
		
		PlanillaRegT01 bean01 = null;
		
		Collection<ErrorLiquidacionTO> errores = new ArrayList<ErrorLiquidacionTO>();
		
		
		ErrorLiquidacionTO err;
		try{			
			mn.inicializarMio(regT01);
			bean01 = (PlanillaRegT01)mn.getNextRecord();
			this.completarPlanillaAportanteDTODePlanillaRegT01(bean01, planillaApteDto);
			this.validarRegistroTp01(bean01, planillaApteDto, archivoEnProcesoDTO,validacionArchivoDataSource);
		}catch ( ApplicationException e ){
			for(ApplicationException exc : e.getAppExceptionSet()) {
				err = crearRegistroErrorLexicoSintacticoRegistro(exc,null, 1 ,1);				
				errores.add(err);							
			}
		}
		return errores.toArray(new ErrorLiquidacionTO[0]);				
	}
	
	
	private void validarRegistroTp01(PlanillaRegT01 bean01, PlanillaAportanteDTO planillaApteDto,ArchivoEnProcesoDTO archivoEnProcesoDTO,
			ValidacionArchivoDataSource validacionArchivoDataSource) throws ApplicationException {
		PlanillaArcPreValidador planillaArcPreValidador = new PlanillaArcPreValidador(validacionArchivoDataSource);
		ArchivoNotificacionDTO  archivoNotificacionDTO = new ArchivoNotificacionDTO();
		archivoNotificacionDTO.setActualizarNombre(false);
		archivoNotificacionDTO.setIdAportante(archivoEnProcesoDTO.getIdAportante());
		archivoNotificacionDTO.setIdSegUsuario(archivoEnProcesoDTO.getIdSegUsuario());
		archivoNotificacionDTO.setNombreArchivo(archivoEnProcesoDTO.getNombreArchivo());
		archivoNotificacionDTO.setEsPlanillaTipoU(archivoEnProcesoDTO.isEsPlanillaTipoU());
		archivoNotificacionDTO.setProcesoEdicion(false);
		archivoNotificacionDTO.setPlanillaSoiClick(true);
		planillaArcPreValidador.aplicarRNBasicasParaTodosLosArchivos(planillaApteDto.getInformacionAportantePlanillaDTO(), bean01, archivoNotificacionDTO);
		
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

	

	public ErrorLiquidacionTO[] validarRegistroTp02 ( 	Collection<String> registroTp02, 
														ArchivoEnProcesoDTO archivoDto, 
														ValidacionArchivoDataSource datasourceValidacion,
														int nroLinea) throws Exception{
		
					
		LOGGER.info("inicio: validarRegistroTp02() -> "+registroTp02.size());		
		Collection<ErrorLiquidacionTO> errores = new ArrayList<ErrorLiquidacionTO>();
		Collection<PlanillaRegT02> registrosT02Agrupados = new ArrayList<PlanillaRegT02>();
		PlanillaRegT02 bean02 = null;
		int nroLineaActual = nroLinea;
		for ( String line:registroTp02 ){			
			try{
				mn.inicializarMio(line);
				bean02 = (PlanillaRegT02)mn.getNextRecord();
				if ( bean02!=null && bean02.getExcepcion()!=null ){
					throw bean02.getExcepcion();
				}
				bean02.setNumeroLineaArchivo(nroLineaActual);
			}catch ( ApplicationException appExc ){
				this.manejarBeanConErroresLexicoSintacticos(errores, bean02, appExc, nroLinea);
				LOGGER.error("validarRegsTp02Archivo2388() -> Errores sintacticos: "+nroLinea);
				continue;
			}
			nroLineaActual++;
			registrosT02Agrupados.add(bean02);																																																																																				
		}
		GrupoCotizantesDTO grupoCotizantes = this.agruparCotizantesAplicarValidacionesPrevias(registrosT02Agrupados,errores);		
		
		if ( errores.isEmpty() ){
			this.procesarGrupoCotizantesTp2Desconectado(grupoCotizantes, archivoDto, datasourceValidacion,errores);
		}
		
		return errores.toArray(new ErrorLiquidacionTO[0]);
	}
	
	
	public ErrorLiquidacionTO[] validarRegsTp02Archivo2388 (ArchivoEnProcesoDTO archivoDto, 
															ValidacionArchivoDataSource datasourceValidacion,
															String pathArchivo2388) throws Exception{
		Collection<ErrorLiquidacionTO> erroresLiquidacion = new ArrayList<ErrorLiquidacionTO>();
		BufferedReader reader = null;
		Collection<ErrorLiquidacionTO> errorRegs = new ArrayList<ErrorLiquidacionTO>();
		Collection<PlanillaRegT02> registrosT02Agrupados = new ArrayList<PlanillaRegT02>();
		LOGGER.info("inicio: validarRegsTp02Archivo2388()");
		try{
			reader = new BufferedReader( new InputStreamReader(new FileInputStream(pathArchivo2388), Constants.GENERAL_ENCODING) );
			String line = null;
			int nroLinea = 0;
			int oks = 0;
			int regsError = 0;
			PlanillaRegT02 bean02 = null;
			do{
				line=reader.readLine();
				nroLinea++;
				LOGGER.info("validarRegsTp02Archivo2388()->"+nroLinea);
				if ( line==null || line!=null && line.startsWith("02") ){
					//errorRegs = this.validarRegistroTp02(line, archivoDto, datasourceValidacion, nroLinea);
					
					if ( line!=null ){
						try{
							mn.inicializarMio(line);
							bean02 = (PlanillaRegT02)mn.getNextRecord();
							if ( bean02.getExcepcion()!=null ){
								throw bean02.getExcepcion();
							}
							if ( camposBeanT02==null ){
								camposBeanT02 = bean02.getCampos();
							}
						}catch ( ApplicationException appExc ){
							this.manejarBeanConErroresLexicoSintacticos(errorRegs, bean02, appExc, nroLinea);
							LOGGER.error("validarRegsTp02Archivo2388() -> Errores sintacticos: "+nroLinea);
							continue;
						}
					}
					//Termina de agrupar e inicia la validacion
					if ( (line==null||this.isCambioRegistro((ArrayList<PlanillaRegT02>)registrosT02Agrupados, bean02)) && !registrosT02Agrupados.isEmpty() ){						
						GrupoCotizantesDTO grupoCotizantes = this.agruparCotizantesAplicarValidacionesPrevias(registrosT02Agrupados,errorRegs);
						
						if ( errorRegs.isEmpty() ){
							 this.procesarGrupoCotizantesTp2Desconectado(grupoCotizantes, archivoDto, datasourceValidacion,errorRegs);
						}																																				
						registrosT02Agrupados.clear();				
					}
					if ( line!=null ){
						registrosT02Agrupados.add(bean02);
						bean02.setNumeroLineaArchivo(nroLinea);
					}
										
					if ( !errorRegs.isEmpty() ){
						regsError++;
						erroresLiquidacion.addAll(errorRegs);
						errorRegs.clear();
					}
					else{
						oks ++;
					}
				}				
			}while ( line!=null );
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
	
	
	private GrupoCotizantesDTO agruparCotizantesAplicarValidacionesPrevias ( Collection<PlanillaRegT02> beans, Collection<ErrorLiquidacionTO> errores ) throws ApplicationException{
		GrupoCotizantesDTO grupoCotizantes = new GrupoCotizantesDTO();
		
		PlanillaRegT02 beanTmp = null;
		Collection<ApplicationException> exceptions = new ArrayList<ApplicationException>();
		for ( PlanillaRegT02 bean:beans ){			
			beanTmp = bean;
			try{
				grupoCotizantes.addRegistro(beanTmp);
				
			}catch(ApplicationException appExc){
				this.manejarExcepcionesSemanticas(errores,bean,appExc,bean.getNumeroLineaArchivo());
				exceptions.add(appExc);
			}
		}
		if ( grupoCotizantes.getRegistros().size()>1 && !grupoCotizantes.isPermiteMultiplesRegs() 
				&& !grupoCotizantes.isAusentismo() && !grupoCotizantes.isTieneSln() && !grupoCotizantes.isTieneCom() ){
			
			ApplicationException appExc = new ApplicationException(ClavesMensajesArchivoConstants.INGRESO_OBLIGATORIO_VSPVST,
											new Object[] { beanTmp.getINGIngreso15(),beanTmp.getINGIngreso15Type() });
			this.manejarExcepcionesSemanticas(errores,beanTmp,appExc,beanTmp.getNumeroLineaArchivo());				
		}
		
		
		return grupoCotizantes;		
	}
	
	

	private GrupoCotizantesDTO procesarGrupoCotizantesTp2Desconectado(	GrupoCotizantesDTO grupoCotizantes, 
																		ArchivoEnProcesoDTO archivoDto,
																		ValidacionArchivoDataSource validacionArchivoDs,
																		Collection<ErrorLiquidacionTO> errores) 
																		throws ApplicationException {
		
		LiquidacionPlanillaXArchivoEvolMngr liquidacionMngr = new LiquidacionPlanillaXArchivoEvolMngr(validacionArchivoDs);		
		PlanillaCotizanteDTO czte = null;		
		boolean ocurrioExcepcion = false;
		int indexRegistros = 0;		
		int registrosNovedadesNoMultiRegistros = 0;
		BigDecimal ibcAfp = BigDecimal.ZERO;
		BigDecimal AporteFssol = BigDecimal.ZERO;
		BigDecimal AporteFssub = BigDecimal.ZERO;
		int cantidadReg = 0;
		int conteoReg = 0;
		int nroLinea = 0;
		try{
			cargarSingletonAdministradoras(validacionArchivoDs);
			if ( grupoCotizantes.size()==1 ){
				nroLinea = grupoCotizantes.getRegistro(0).getNumeroLineaArchivo();
				grupoCotizantes.getRegistro(0).setValidacionOffline(true);
				czte = this.validarCotizanteIndividualConCorrecciones(errores, grupoCotizantes.getRegistro(0), 
																	archivoDto, validacionArchivoDs, liquidacionMngr);
				if (czte!=null){
					grupoCotizantes.addCzte(czte);
				}
				else{
					ocurrioExcepcion = true;
				}
			}
			else{
				boolean isColResidenteExt = false;
				cantidadReg = grupoCotizantes.getCantidadRegistros();
				for ( PlanillaRegT02 reg:grupoCotizantes.getRegistros() ) {
					conteoReg++;
					nroLinea = reg.getNumeroLineaArchivo();
					//NR268 Se agrega validacion para permitir multiples registros de un mismo cotizante con diferente valor en el campo 74 si
					//el tipo de cotizante para ese mismo cotizante es diferente
					//Ajuste NEC164
					for ( PlanillaRegT02 reg2:grupoCotizantes.getRegistros() ) {
						if(reg.getNumeroIdentificacionCotizante4Type().equals(reg2.getNumeroIdentificacionCotizante4Type())
								&& reg.getTpDocumentoCotizante3Type().equals(reg2.getTpDocumentoCotizante3Type())
									&& reg.getTpCotizante5Type().equals(reg2.getTpCotizante5Type())
										&& !reg.getCotizanteExoneradoLey160776Type().equals(reg2.getCotizanteExoneradoLey160776Type())
										&& !archivoDto.isAportanteLey1607()){
							ApplicationException exc = new ApplicationException(
									ClavesMensajesArchivoConstants.MULTIPLES_CZTES_EXONERADO_LEY1607_DIFERENTES_VALORES,
										new Object[] { reg.getCotizanteExoneradoLey160776() });
							this.manejarExcepcionesSemanticas(errores, reg2, exc, nroLinea);
							ocurrioExcepcion = true;
						}
																		
					}
					
					ibcAfp = ibcAfp.add(reg.getIBCPension42()!=null&&reg.getIBCPension42().getValorNumerico()!=null?BigDecimal.valueOf(reg.getIBCPension42().getValorNumerico()):BigDecimal.ZERO);
					AporteFssol = AporteFssol.add(reg.getApFondoSolidaridadPensionalSubSolidaridad51()!=null&&reg.getApFondoSolidaridadPensionalSubSolidaridad51().getValorNumerico()!=null?BigDecimal.valueOf(reg.getApFondoSolidaridadPensionalSubSolidaridad51().getValorNumerico()):BigDecimal.ZERO);
					AporteFssub = AporteFssub.add(reg.getApFondoSolidaridadPensionalSubSubsistencia52()!=null&&reg.getApFondoSolidaridadPensionalSubSubsistencia52().getValorNumerico()!=null?BigDecimal.valueOf(reg.getApFondoSolidaridadPensionalSubSubsistencia52().getValorNumerico()):BigDecimal.ZERO);
											
					isColResidenteExt = reg.getColResExt8Type()!=null&&reg.getColResExt8Type().equals("X");
					
					if(!reg.isTieneNovedadMultiRegistros()&&!isColResidenteExt){
						registrosNovedadesNoMultiRegistros++;
					}
					
					if(registrosNovedadesNoMultiRegistros > 1){
						ApplicationException exc = new ApplicationException(ClavesMensajesArchivoConstants.REGISTRO_SIN_AUSENTISMO_INVALIDO);
						this.manejarExcepcionesSemanticas(errores, reg, exc, grupoCotizantes.getRegistros().get(0).getNumeroLineaArchivo());
						ocurrioExcepcion = true;
					}
					
					if(conteoReg == cantidadReg && grupoCotizantes.isAusentismo()){
						reg.setIbcAfp(ibcAfp);
						reg.setAporteFssol(AporteFssol);
						reg.setAporteFssub(AporteFssub);
						reg.setValidarFspGrupoCztesAusentismo(true);
					}
					
					reg.setCotizanteMultiplesRegistros(true);
					if ( indexRegistros==grupoCotizantes.size()-1 ){
						reg.setCotizanteMultiplesRegistros(true);
					}
					czte = this.validarCotizanteIndividualConCorrecciones(errores, reg, 
																			archivoDto, validacionArchivoDs, liquidacionMngr);					
					if (czte!=null){
						grupoCotizantes.addCzte(czte);
					}
					else{
						ocurrioExcepcion = true;
					}
					indexRegistros++;
				}
				
				try{
					if(grupoCotizantes.size()>1 && !ocurrioExcepcion){
						liquidacionMngr.validarDiasAportesMulplesRegistros(grupoCotizantes, archivoDto, false,ibcAfp);
					}
				}catch(ApplicationException exc) {
					this.manejarExcepcionesSemanticas(errores,grupoCotizantes.getRegistros().get(0),exc, grupoCotizantes.getRegistros().get(0).getNumeroLineaArchivo());
					ocurrioExcepcion = true;
				}
				
				try{
					if(grupoCotizantes.isAusentismo() && !ocurrioExcepcion){
						
						NSOIRNCotizante rnCotizante = new NSOIRNCotizante();				
						int cantidadTotalCotizantes = grupoCotizantes.getCotizantes().size();
						
						rnCotizante.validarCotizantesMultiplesRegistrosNEC164(grupoCotizantes.getCotizantes().get(0),
																				grupoCotizantes.getCotizantes().subList(1, cantidadTotalCotizantes),
																				archivoDto.getPeriodoSalud().getPeriodoCalendar(), false);				
						
						
						liquidacionMngr.validarDiasAportesMulplesRegistros(grupoCotizantes, archivoDto, false,ibcAfp);
					}
				}catch(ApplicationException exc) {
					this.manejarExcepcionesSemanticas(errores,grupoCotizantes.getRegistros().get(0),exc,grupoCotizantes.getRegistros().get(0).getNumeroLineaArchivo());
					ocurrioExcepcion = true;
				}
					
				if ( !ocurrioExcepcion ){
					liquidacionMngr.validacionesCotizantesMultiplesContratos(grupoCotizantes, archivoDto);
				}
						
				grupoCotizantes.setOcurrioExcepcion(ocurrioExcepcion);
				
				try{
					Collection<ApplicationException> excepcionesValidacionIbc = new ArrayList<ApplicationException>();
					if(grupoCotizantes!=null && !grupoCotizantes.getCotizantes().isEmpty()){
						liquidacionMngr.validarTopeIBCMultiplesContratos(grupoCotizantes.getRegistros().get(0),grupoCotizantes.getCotizantes(), archivoDto, excepcionesValidacionIbc);
						for ( ApplicationException appExc:excepcionesValidacionIbc ){
							this.manejarExcepcionesSemanticas(errores,grupoCotizantes.getRegistros().get(0),appExc, grupoCotizantes.getRegistros().get(0).getNumeroLineaArchivo());
						}
					}
				}catch(ApplicationException exc) {
					this.manejarExcepcionesSemanticas(errores,grupoCotizantes.getRegistros().get(0),exc, grupoCotizantes.getRegistros().get(0).getNumeroLineaArchivo());
				}			
			}
			boolean totalizar = false;
			boolean tieneErroresNoCorregibles = false;
			for ( ErrorLiquidacionTO err:errores ){
				if ( !err.isAutocorregible() ){
					tieneErroresNoCorregibles = true;
					break;
				}
			}
			totalizar = errores.isEmpty()||(!tieneErroresNoCorregibles&&!grupoCotizantes.getCotizantes().isEmpty());
			LOGGER.info("totalizar cotizante: "+totalizar);
			//Si se corrigieron todos los errores debe volver a crearse el registro de cotizante ya sin ningun error
			TotalizadorActivos totalizador = TotalizadorActivos.getInstance(validacionArchivoDs);
			if ( totalizar ){					
				for ( PlanillaCotizanteDTO c:grupoCotizantes.getCotizantes() ){
					totalizador.totalizarCotizante(c, nroLinea);					
				}
			}			
			else if(!grupoCotizantes.getRegistros().isEmpty()){
				for ( PlanillaRegT02 bean02:grupoCotizantes.getRegistros() ){
					if(totalizador.existeCotizanteEnTotal(bean02.getTpDocumentoCotizante3Type(),bean02.getNumeroIdentificacionCotizante4Type(), nroLinea)){
						totalizador.eliminarCotizanteTotal(bean02.getTpDocumentoCotizante3Type(),bean02.getNumeroIdentificacionCotizante4Type(), nroLinea);
					}
				}					
			}
			LOGGER.info("procesarGrupoCotizantesTp2Desconectado() -> Finaliza Validacion semantica");
		}catch (Exception e) {
			ErrorLiquidacionTO errorTo = new ErrorLiquidacionTO();
			LOGGER.fatal("procesarGrupoCotizantesTp2Desconectado() -> Errores inesperado",e);
			errorTo.setAutocorregible(false);
			errorTo.setCampo(0);
			errorTo.setErrorRegistro(true);
			errorTo.setLinea(nroLinea);
			errorTo.setError("Error no identificado");
			errorTo.setNombreCampo("-");
			errores.add(errorTo);
		}
				
		return grupoCotizantes;
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
		if ( !(excepcion.getParametrosReemplazo()!=null && excepcion.getParametrosReemplazo().length>0
				&&excepcion.getParametrosReemplazo()[0] instanceof CampoLeido1747) ){
			ArrayList<Object> parametrosReemplazo = new ArrayList<Object>();
			parametrosReemplazo.add(campo);
			for ( Object obj:excepcion.getParametrosReemplazo() ){
				parametrosReemplazo.add(obj);
			}
			excepcion.setParametrosReemplazo(parametrosReemplazo.toArray(new Object[0]));
		}
		
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
				this.aplicarSugerenciaError(err, reg, campo);
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
	
	
	private void aplicarSugerenciaError ( ErrorLiquidacionTO error, PlanillaRegTAbstract reg,CampoLeido1747 campoError  ) {
		if ( !(reg instanceof PlanillaRegT02) || campoError==null ){
			return;
		}
		PlanillaRegT02 reg02 = (PlanillaRegT02)reg;
		/*this.aplicarSugerenciasEnCampo(error, reg02.getIBCCCF45(),campo);			
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
		this.aplicarSugerenciasEnCampo(error, reg02.getCotizacionObligatoria47(),campo);*/
		for ( CampoLeido1747 campoLeido:reg02.getCampos().values() ){
			if ( campoError.getNombreCampo().equals(campoLeido.getNombreCampo()) ){
				this.aplicarSugerenciasEnCampo(error, campoLeido,campoError);
			}
		}
	}
	
	private void aplicarSugerenciasEnCampo ( ErrorLiquidacionTO error,CampoLeido1747 campoLeido, CampoLeido1747 campoError ){
		//if ( campoError.getNombreCampo().equals(campoLeido.getNombreCampo()) ){
			verificarSiEnfatizarError(error, campoLeido.getValorNumerico());
			campoLeido.setValorCrudo(error.getSugerencias()[0]);
			error.setAplicarSegundaValidacion(true);
			if ( campoLeido.getValorAlfanumerico()!=null && !campoLeido.getValorAlfanumerico().trim().equals("") && campoLeido.getTipoDato()==TipoDatoType.A ){
				if ( campoLeido.getValorAlfanumerico().trim().equals(error.getSugerencias()[0].trim()) ){
					error.setAplicarSegundaValidacion(false);
				}
				else{
					campoLeido.setValorAlfanumerico(error.getSugerencias()[0]);
				}
			}			
			else if ( campoLeido.getTipoDato()==TipoDatoType.N ){				
				if ( campoLeido.getValorNumerico()!=null && campoLeido.getValorNumerico().equals(this.getValorLong(error.getSugerencias()[0].trim())) ){
					error.setAplicarSegundaValidacion(false);
				}
				else{
					campoLeido.setValorNumerico(this.getValorLong(error.getSugerencias()[0]));
				}
			}
			else if ( campoLeido.getTipoDato()==TipoDatoType.D ){
				if ( campoLeido.getValorDecimal()!=null && campoLeido.getValorDecimal().equals(this.getValorDecimal(error.getSugerencias()[0].trim())) ){
					error.setAplicarSegundaValidacion(false);
				}
				else{
					campoLeido.setValorDecimal(this.getValorDecimal(error.getSugerencias()[0]));
				}
			}
			else{
				error.setAplicarSegundaValidacion(false);
			}
			
		//}
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
	

	private BigDecimal getValorDecimal ( String val ){
		try{
			return BigDecimal.valueOf(Double.valueOf(val));
		}catch ( Exception e ){
			return BigDecimal.ZERO;
		}
	}
	
	private CampoLeido1747 getCampoError ( String nombreCampo ){
		if ( camposBeanT02==null||camposBeanT02.isEmpty() ){
			return null;
		}
		for ( Map.Entry<String,CampoLeido1747> e:camposBeanT02.entrySet() ){
			if ( e.getValue().getNombreCampo().equals(nombreCampo) ){									
				return e.getValue();
			}
		}
		return null;
	}

	private ErrorLiquidacionTO crearRegistroErrorLexicoSintacticoRegistro(ApplicationException excepcion, PlanillaRegTAbstract reg, int numeroLineaActual, int idErrorActual) {
		
		ErrorLiquidacionTO err = new ErrorLiquidacionTO();
		
		CampoLeido1747 campo = null;
		if ( excepcion.getParametrosReemplazo()!=null && 
				excepcion.getParametrosReemplazo().length>=1 && 
				excepcion.getParametrosReemplazo()[0] instanceof CampoLeido1747 ){
			campo = (CampoLeido1747)excepcion.getParametrosReemplazo()[0];			
		}
		//cuando el nombre del campo viene en el segundo parametro del error
		else if( excepcion.getParametrosReemplazo()!=null &&
				excepcion.getParametrosReemplazo().length>1 ){
			campo = this.getCampoError(excepcion.getParametrosReemplazo()[1].toString());
			if ( campo!=null ){
				ArrayList<Object> parametrosReemplazo = new ArrayList<Object>();				
				parametrosReemplazo.add(campo);				
				parametrosReemplazo.add(campo.getNombreCampo());
				excepcion.setParametrosReemplazo(parametrosReemplazo.toArray(new Object[0]));
			}
		}
				
		ExceptionMessage msge = DesktopExceptionMngr.getInstance().manejarException(excepcion);
		err.setCampo(0);
		err.setNombreCampo(campo!=null?campo.getNombreCampo():"-");
		if(excepcion.getNumeroLinea() >= 0) {
			err.setLinea(excepcion.getNumeroLinea());
		}else {
			err.setLinea(numeroLineaActual);			
		}
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
				this.aplicarSugerenciaError(err, reg, campo);
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
	


	private PlanillaCotizanteDTO validarCotizanteIndividualConCorrecciones ( 	
												Collection<ErrorLiquidacionTO> errores, 
												PlanillaRegT02 regT02,
												ArchivoEnProcesoDTO archivoDto,
												ValidacionArchivoDataSource validacionArchivoDs,
												LiquidacionPlanillaXArchivoEvolMngr liquidacionMngr
												) throws ApplicationException{
		
		PlanillaCotizanteDTO czte = null;
		int nroLinea = 0;
		Collection<ErrorLiquidacionTO> erroresRevalidacion = new ArrayList<ErrorLiquidacionTO>();
		try{
			nroLinea = regT02.getNumeroLineaArchivo();
			regT02.setValidacionOffline(true);
			czte = liquidacionMngr.procesarBeanRegistroT02Individual(	validacionArchivoDs.getPlanillaApteDto(),
																		regT02, 
																		archivoDto,validacionArchivoDs);					
			
		}catch ( ApplicationException e ){
			e.printStackTrace();
			LOGGER.error("validarRegsTp02Archivo2388() -> Errores semanticos validacion registro unico: "+nroLinea,e);
			this.manejarExcepcionesSemanticas(errores, regT02, e, nroLinea);
			boolean validarNuevamente = true;
			for ( ErrorLiquidacionTO err:errores ){
				if ( err.isAplicarSegundaValidacion() ){
					//Revalida el registro con ibcs modificados										
					validarNuevamente = true;						
					break;
				}
			}
			while ( validarNuevamente ){
				LOGGER.info("validarNuevamente: "+validarNuevamente);
				erroresRevalidacion.clear();
				try{
					regT02.setValidacionOffline(true);
					czte = liquidacionMngr.procesarBeanRegistroT02Individual(validacionArchivoDs.getPlanillaApteDto(),
																			regT02, archivoDto, 
																			validacionArchivoDs);
				}catch ( ApplicationException e1 ){
					LOGGER.error("validarRegsTp02Archivo2388() -> Errores semanticos validacion registro unico: "+nroLinea);						
					this.manejarExcepcionesSemanticas(erroresRevalidacion, regT02, e1, nroLinea);
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
		return czte;
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
	
	
	private boolean isCambioRegistro ( ArrayList<PlanillaRegT02> beansAgrupados, PlanillaRegT02 beanActual ){
		String keyRegActual = ((PlanillaRegT02) beanActual).getTpDocumentoCotizante3Type()+";"+((PlanillaRegT02) beanActual).getNumeroIdentificacionCotizante4Type();
		String keyRegGrupo = "";
				
		if ( beanActual.getNumeroLineaArchivo()==2 ){
			return false;
		}
		if ( beansAgrupados.size()>0 ){
			keyRegGrupo = ((PlanillaRegT02) beansAgrupados.get(0)).getTpDocumentoCotizante3Type()+";"
											+((PlanillaRegT02) beansAgrupados.get(0)).getNumeroIdentificacionCotizante4Type();
		}
				
		if ( !keyRegActual.equals(keyRegGrupo) ){
			return true;
		}
		
		return false;
	}
	
	

	
}

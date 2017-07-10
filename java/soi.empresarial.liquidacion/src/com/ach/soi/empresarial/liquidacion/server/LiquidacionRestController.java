package com.ach.soi.empresarial.liquidacion.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.swatit.pilautil.dto.out.ValidacionArchivoDataSourceDTO;
import co.swatit.pilautil.generics.Validation;

import com.ach.arc.biz.r1747.util.ValidacionArchivoDataSource;
import com.ach.arc.biz.transfer.ArchivoEnProcesoDTO;
import com.ach.soi.empresarial.converters.core.Converter1747to2388;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadTp02;
import com.ach.soi.empresarial.liquidacion.core.LiquidadorActivos;
import com.ach.soi.empresarial.liquidacion.core.TotalizadorActivos;
import com.ach.soi.empresarial.liquidacion.model.ErrorLiquidacionTO;
import com.ach.soi.empresarial.liquidacion.model.RequestGeneracionSoportesTO;
import com.ach.soi.empresarial.liquidacion.model.ResultadoValidacionArchivoTO;
import com.ach.soi.empresarial.liquidacion.model.ResultadoValidacionCotizanteDTO;
import com.ach.soi.empresarial.liquidacion.model.TotalesTO;
import com.ach.soi.empresarial.liquidacion.util.Converter;
import com.ach.sop.biz.transfer.PlanillaSoporteCotizanteDTO;
import com.ach.sop.utility.biz.GeneracionSoportesOffline;
import com.ach.sop.utility.biz.util.ServiciosUtilitarios;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

@Controller
@EnableAutoConfiguration
public class LiquidacionRestController {
	
	private static ValidacionArchivoDataSource validacionPlanillaDd;
	private static ArchivoEnProcesoDTO archivoEnProceso;
	
	private static final Logger LOGGER = getLogger();
	
	@RequestMapping("/incializarliquidacion")
	@ResponseBody
    public ResultadoValidacionArchivoTO incializarLiquidacion( String archivoProcesoJson, 
    															String archivoDatasourceJson, 
    															String pathArchivo2388, 
    															String pathRespuestaJson, 
    															boolean reformaTributaria ) {
		LOGGER.info("incializarLiquidacion!!!!");
		ResultadoValidacionArchivoTO resultado = new ResultadoValidacionArchivoTO();
		BufferedReader lineReader =null;
		ErrorLiquidacionTO[] erroresLiq = new ErrorLiquidacionTO[0];
		FileOutputStream os = null;
        BufferedWriter bw = null;

        Gson gsonWriter=new GsonBuilder().setPrettyPrinting().create();
        try {        	
            JsonReader readerArchivoEnProceso = new JsonReader(new FileReader(new File(archivoProcesoJson)));
            JsonReader readerArchivoDs = new JsonReader(new FileReader(new File(archivoDatasourceJson)));            
            
            StringBuilder pathResultado = new StringBuilder(pathRespuestaJson);
            pathResultado.append(File.separator).append("Resultado.").append(Calendar.getInstance().getTimeInMillis()).append(".json");          
            
            Gson gson = new Gson();
            co.swatit.pilautil.dto.out.ArchivoEnProcesoDTO archivoEnProcesoTO = gson.fromJson(readerArchivoEnProceso, co.swatit.pilautil.dto.out.ArchivoEnProcesoDTO.class);
            ValidacionArchivoDataSourceDTO archivoDs = gson.fromJson(readerArchivoDs, ValidacionArchivoDataSourceDTO.class);
            //Setea el valor del campo reforma tributaria seleccionado por el usuario
            archivoDs.getPlanillaApteDto().setAportanteLey1607(reformaTributaria);
            
            validacionPlanillaDd = Converter.convertValidacionArchivoDataSource(archivoDs, archivoDs.getPlanillaApteDto());
            
            TotalizadorActivos.getInstance(validacionPlanillaDd).resetInstance(validacionPlanillaDd);
            
            archivoEnProceso = Converter.convertArchivoEnProceso(archivoEnProcesoTO);
            
            LiquidadorActivos liquidacion = new LiquidadorActivos();
            		
			String regT01 = null;
			
			lineReader = new BufferedReader(new FileReader(pathArchivo2388));
			if ( (regT01=lineReader.readLine())!=null ){		
				lineReader.close();
			}
            			
			erroresLiq = liquidacion.completarPlanillaAportanteDTO(validacionPlanillaDd.getPlanillaApteDto(), regT01);
			if ( erroresLiq!=null && erroresLiq.length>0 ){
				LOGGER.error("Fin: Error en el registro tipo 1.");
				resultado.setError(erroresLiq[0].getError());
				resultado.setEstado("ERROR");
				resultado.setPathResultadoJson("");
				return resultado;
			}
			
			os = new FileOutputStream(new File(pathResultado.toString()),true);
	        bw = new BufferedWriter(new OutputStreamWriter(os));

	        gsonWriter=new GsonBuilder().setPrettyPrinting().create();
            erroresLiq = liquidacion.validarRegsTp02Archivo2388(archivoEnProceso, validacionPlanillaDd, pathArchivo2388);
            gsonWriter.toJson(erroresLiq, bw);
            
            resultado.setError("");
			resultado.setEstado("OK");
			resultado.setPathResultadoJson(pathResultado.toString());
            
            LOGGER.info("Resultado Ok: "+pathResultado.toString());        
            return resultado;
                    
        } catch (Exception ioe){
        	erroresLiq = new ErrorLiquidacionTO[0];
        	
        	LOGGER.error("Error", ioe);
        	ioe.printStackTrace();
        	resultado.setError(erroresLiq[0].getError());
			resultado.setEstado("ERROR");
			resultado.setPathResultadoJson("");
        	return resultado;
        }
        finally{
        	if ( bw!=null ){
        		try {
        			bw.flush();
					bw.close();					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					LOGGER.error(e);
				}        		
        	}
        	if ( os!=null ){
        		try {
					os.flush();
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					LOGGER.error(e);
				}        		
        	}        	
        }
                
    }
	
	@RequestMapping("/convertircotizante")
	@ResponseBody
    public String[] convertirCotizante( String registroTp02 ) {
		LOGGER.info("Convertir cotizante!!!!"+registroTp02);
		Converter1747to2388 converter = new Converter1747to2388();
		String[] regArray = null;
		try{
			regArray = converter.convertirRegTp02Individual(registroTp02);
		}catch ( Exception e ){
			e.printStackTrace();
		}	
        return regArray;
    }
	
	
	@RequestMapping("/validarcotizante")
	@ResponseBody
    public ResultadoValidacionCotizanteDTO validarCotizante( String regTp02[][], int nroLinea ) {
		LOGGER.info("Validar Cotizante!!!!");
		LOGGER.info("Registro: "+regTp02); 
		LiquidadorActivos liquidador = new LiquidadorActivos();
		ResultadoValidacionCotizanteDTO resultado = new ResultadoValidacionCotizanteDTO();
		Collection<String> regsValidacion = new ArrayList<String>();
		try{
			for ( String reg[]:regTp02 ){
				Reg2388ReadTp02 regT02Bean = Reg2388ReadTp02.buildRecordFromStringArray(reg);
				Converter1747to2388 converter = new Converter1747to2388();
				String regT02Str = converter.getRegT02FromBean(regT02Bean);
				regsValidacion.add(regT02Str);
			}						
			resultado.setErroresRegistros(liquidador.validarRegistroTp02(regsValidacion, archivoEnProceso, validacionPlanillaDd, nroLinea));
			resultado.setEstadoSolicitud("OK");
		}catch ( Exception e ){
			LOGGER.error("Error no controlado",e);
			resultado.setEstadoSolicitud("ERROR");
			resultado.setErrorSolicitud(e.getMessage());			
		}
		return resultado;
    }
	
	
	@RequestMapping("/gettotales")
	@ResponseBody
    public TotalesTO getTotales(  ) {
		LOGGER.info("Obtener Totales!!!!");			
		try{
			TotalizadorActivos totalizador = TotalizadorActivos.getInstance(validacionPlanillaDd);
			TotalesTO totales = totalizador.getTotales();
			LOGGER.info("Fin Obtener Totales!!!!");
			return totales;
		}catch ( Exception e ){
			LOGGER.error("Error no controlado",e);					
		}
		LOGGER.info("Fin Obtener Totales!!!!");
		return null;
    }
	
	@RequestMapping("/agregarcotizante")
	@ResponseBody
    public ResultadoValidacionCotizanteDTO agregarCotizante( String regTp02[], int nroLinea  ) {
		LOGGER.info("Inicio Validacion Cotizante nuevo!!!!");			
		try{
			String[][] regs = new String[1][regTp02.length];
			regs[0] = regTp02;
			return validarCotizante(regs, nroLinea);
		}catch ( Exception e ){
			LOGGER.error("Error no controlado",e);					
		}
		LOGGER.info("Fin Validacion Cotizante nuevo!!!!");
		return null;
    }
	
	@RequestMapping("/eliminarcotizante")
	@ResponseBody
    public void eliminarCotizante( String regTp02[], int nroLinea  ) {
		LOGGER.info("Inicio Validacion Cotizante eliminado!!!!");			
		try{
			//validarCotizante(regTp02, nroLinea);
		}catch ( Exception e ){
			LOGGER.error("Error no controlado",e);					
		}
		LOGGER.info("Fin Validacion Cotizante eliminado!!!!");
    }
	
	@RequestMapping(value="/generarsoportes",method={RequestMethod.POST})
	@ResponseBody	
    public String generarSoportes( @RequestBody RequestGeneracionSoportesTO requestSoportes ) {
		LOGGER.info("inicio generacion soportes!!!!");
		LOGGER.info("datosEncabezado: "+requestSoportes.getDatosEncabezadoJson());
		LOGGER.info("datosDetalleCotizante: "+requestSoportes.getDatosDetalleCotizanteJson());
		LOGGER.info("datosEnvioCorreo: "+requestSoportes.getDatosEnvioCorreoJson());
		String resultado = null;
        
		
		
		try{
			
			Collection<PlanillaSoporteCotizanteDTO> cotizantes = ServiciosUtilitarios.convertirDatosCotizantes(requestSoportes.getDatosDetalleCotizanteJson());
			Collection<PlanillaSoporteCotizanteDTO> cotizantesSop = new ArrayList<PlanillaSoporteCotizanteDTO>(); 
			GeneracionSoportesOffline soportesOffline = new GeneracionSoportesOffline();
			for ( PlanillaSoporteCotizanteDTO czte:cotizantes ){
				cotizantesSop.add(czte);
				resultado = soportesOffline.generarSoporteCotizante(requestSoportes.getDatosEncabezadoJson(), cotizantesSop, requestSoportes.getDatosEnvioCorreoJson(),requestSoportes.getRutaRecursos(), requestSoportes.getRutaGeneracion());
				cotizantesSop.clear();
			}
		}catch ( Exception e ){
			LOGGER.error("Resultado Error: ",e);
			resultado = "ERROR: "+e.getMessage();
		}
		
        LOGGER.info("Resultado: "+resultado);        
        return resultado;
    }
	
	

	private static Logger getLogger ( ){
		String path = System.getenv().get("LOG_PILA");
        if (!Validation.isNullOrEmpty(path)) {
            // creates pattern layout
            PatternLayout layout = new PatternLayout();
            layout.setConversionPattern("[%p] %d %c %M - %m%n");

            // creates daily rolling file appender
            RollingFileAppender rollingAppender = new RollingFileAppender();
            rollingAppender.setFile(path);
            rollingAppender.setLayout(layout);
            rollingAppender.setMaxFileSize("10MB");
            rollingAppender.setMaxBackupIndex(6);
            rollingAppender.activateOptions();

            // configures the root logger
            Logger rootLogger = Logger.getRootLogger();
            rootLogger.setLevel(Level.ERROR);
            rootLogger.addAppender(rollingAppender);
            
            return rootLogger;

        }
        else{
        	 PatternLayout layout = new PatternLayout("[%p] %d %c %M - %m%n");

        	 ConsoleAppender ca = new ConsoleAppender();
        	 ca.setWriter(new OutputStreamWriter(System.out));
        	 ca.setLayout(layout);
        	 ca.setName("soi.empresarial.console.appender");
        	 ca.activateOptions();

             // configures the root logger
             Logger rootLogger = Logger.getRootLogger();
             rootLogger.setLevel(Level.ERROR);             
             rootLogger.addAppender(ca);
             
             return rootLogger;
        }
	}
		
}

package com.ach.soi.empresarial.converters.core;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

import com.ach.soi.empresarial.converters.exception.ErrorTO;
import com.ach.soi.empresarial.converters.model.Archivo2388TO;
import com.ach.soi.empresarial.converters.model.ErrorGeneralTO;
import com.ach.soi.empresarial.converters.model.ErrorValidacionTO;
import com.ach.soi.empresarial.converters.model.ResultadoEscrituraTO;
import com.ach.soi.empresarial.converters.model.SolicitudConversionTO;
import com.ach.soi.empresarial.converters.model.SolicitudEscrituraTO;
import com.ach.soi.empresarial.converters.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import co.swatit.pilautil.generics.PropertyLoader;
import co.swatit.pilautil.generics.Validation;

public class ConverterPila {
	
	private static Logger logger = getLogger();

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
	        rollingAppender.setMaxFileSize("4MB");
	        rollingAppender.setMaxBackupIndex(2);
	        rollingAppender.activateOptions();
	
	        // configures the root logger
	        Logger rootLogger = Logger.getLogger("soi.empresarial.converter");
	        rootLogger.setLevel(Level.TRACE);
	        rootLogger.addAppender(rollingAppender);
	        return rootLogger;
        }
        return null;
    }
	
	public static void main ( String ars[] ){
		ConverterPila conv = new ConverterPila();
		//String request = "{'pathArchivo' : '/Users/jgutierrez/lucasian/tmp/ene-2017/soi.empresarial/data/Enero.txt','tipoArchivo' : '1747'}";
		String method = ars[0];
		String request = ars[1];	
		Locale.setDefault(new Locale("es","CO"));
		
		System.setProperty("org.beanio.configuration", "/settings.properties");
		System.setProperty("file.encoding", Constants.GENERAL_ENCODING);
		PrintStream out = null;
		try{
			out = new PrintStream(System.out, true,Charset.defaultCharset().name());
		}catch ( UnsupportedEncodingException e ){			
			out = new PrintStream(System.out, true);
		}
		
		try {	
			if ( method.equals("test") ){
				try{
					String texto = "Validaci�n";
					String textoUcd = "Validaci\u00f3n";
					out.println("Test:");
					out = new PrintStream(System.out, true,Charset.defaultCharset().name());
					out.println(Charset.defaultCharset().name());
					out.println(texto);
					out.println("Unicode: "+textoUcd);
					out = new PrintStream(System.out, true,"ISO-8859-1");
					out.println("ISO-8859-1");
					out.println(texto);
					out.println("Unicode: "+textoUcd);
					out = new PrintStream(System.out, true,"UTF-8");
					out.println("UTF-8");
					out.println(texto);
					out.println("Unicode: "+textoUcd);
					
					System.out.println("Conversi�n UTF-8");
					byte bytes[] = texto.getBytes(Charset.forName("UTF-8"));								
					byte bytes1[] = textoUcd.getBytes(Charset.forName("UTF-8"));
					System.out.println(new String(bytes,"UTF-8"));
					System.out.println("Unicode: "+new String(bytes1,"UTF-8"));
					
					System.out.println("Conversi�n ISO-8859-1");
					bytes = texto.getBytes(Charset.forName(Constants.GENERAL_ENCODING));								
					bytes1 = textoUcd.getBytes(Charset.forName(Constants.GENERAL_ENCODING));
					System.out.println(new String(bytes,Constants.GENERAL_ENCODING));
					System.out.println("Unicode: "+new String(bytes1,Constants.GENERAL_ENCODING));
					
					
					
				}catch ( UnsupportedEncodingException e ){
					e.printStackTrace();
				}
			}
			if ( method.equals("validarArchivoPila") ){
				logger.info("entra al metodo validarArchivoPila");
				out.println(conv.validarArchivoPila(request));
				logger.info("sale del metodo validarArchivoPila");
			}
			else if ( method.equalsIgnoreCase("convertirArchivoA2388") ){	
				logger.info("entra al metodo convertirArchivoA2388");
				out.println(conv.convertirArchivoA2388(request));
				logger.info("sale del metodo leerArchivo2388");
			}
			else if ( method.equalsIgnoreCase("escribirArchivo2388") ){	
				logger.info("entra al metodo escribirArchivo2388");
				out.println(conv.escribirArchivo2388(request));
				logger.info("sale del metodo escribirArchivo2388");
			}
			else if ( method.equalsIgnoreCase("leerArchivo2388") ){
				logger.info("entra al metodo leerArchivo2388");
				out.println(conv.leerArchivo2388(request));
				logger.info("sale del metodo leerArchivo2388");
			}
		}catch (Exception e) {
			ErrorTO errorTO = new ErrorTO();
			errorTO.setCode("Error Inesperado");
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			errorTO.setStackTrace(errors.toString());
			errorTO.setMessageError(e.getCause()!= null?e.getCause().toString():e.getMessage());
			errorTO.setFunctionFail("pila.converter module");
			Gson gson = new Gson();
			if(errorTO.getMessageError() == null) {
				errorTO.setMessageError(errorTO.getStackTrace());
			}
			String response = gson.toJson(errorTO);
			out.println(response);
			logger.error("Error Inesperado en el comvertidor",e);
		}
	}
	
	public String validarArchivoPila( String request ) throws Exception{
		String response = null;
		Gson gson = new Gson();
		SolicitudConversionTO solicitud = gson.fromJson(request, SolicitudConversionTO.class);
		ConverterController controller = new ConverterController();		
		ErrorValidacionTO[] errores = controller.validarArchivoPila(solicitud.getPathArchivo(), solicitud.getTipoArchivo());
		response = gson.toJson(errores, ErrorValidacionTO[].class);
		return response;
	}
	
	public String convertirArchivoA2388 ( String request ) throws Exception{
		String response = null;
		Gson gson = new Gson();
		SolicitudEscrituraTO solicitud = gson.fromJson(request, SolicitudEscrituraTO.class);
		ConverterController controller = new ConverterController();
		boolean aplicarCorreccionesConversiones = solicitud.getAplicarCorrecionesConversiones()==null
														||solicitud.getAplicarCorrecionesConversiones().trim().equals("")
														||solicitud.getAplicarCorrecionesConversiones().trim().equals("S");
		Archivo2388TO archivo = controller.convertirArchivoA2388(solicitud.getPathArchivo(), solicitud.getPathArchivoComplementario(),
																solicitud.getTipoArchivo(),aplicarCorreccionesConversiones);
		response = gson.toJson(archivo, Archivo2388TO.class);		
		return response;
	}
	
	public String escribirArchivo2388 ( String request ) throws Exception{
		String response = null;
		Gson gson = new Gson();
		SolicitudEscrituraTO solicitud = null;
		Writer2388File writer = new Writer2388File();
		ResultadoEscrituraTO resultado = new ResultadoEscrituraTO();			
		solicitud = gson.fromJson(request, SolicitudEscrituraTO.class);
		JsonReader readerJson = new JsonReader(new InputStreamReader(new FileInputStream(solicitud.getPathArchivoData()), "UTF-8") );
		readerJson.setLenient(true);
		Archivo2388TO data = gson.fromJson(readerJson, Archivo2388TO.class);
		
		boolean aplicarCorreccionesConversiones = solicitud.getAplicarCorrecionesConversiones()==null
				||solicitud.getAplicarCorrecionesConversiones().trim().equals("")
				||solicitud.getAplicarCorrecionesConversiones().trim().equals("S");
		
		writer.writeFile2388(solicitud.getPathArchivo(), data,solicitud.getTipoArchivo(),aplicarCorreccionesConversiones);
		resultado.setError(null);
		resultado.setEstado("OK");
		resultado.setPathArchio(solicitud.getPathArchivo());
		response = gson.toJson(resultado, ResultadoEscrituraTO.class);
		
		return response;
	}
	
	
	public String leerArchivo2388 ( String pathArchivo ) throws Exception{
		String response = null;
		Gson gson = new Gson();
		ConverterController controller = new ConverterController();
		Archivo2388TO resultado = null;					
		resultado = controller.leerArchivo2388(pathArchivo);
		//printArchivoResultado(resultado);
		response = gson.toJson(resultado, Archivo2388TO.class);
		
		return response;
	}
	
	
	private void printArchivoResultado ( Archivo2388TO resultado ){
		System.out.println("[RegTp01]");
		printStringArray(resultado.getLabelsTp01());
		printStringArray(resultado.getRegTp01());
		System.out.println("[RegTp02]");
		printStringArray(resultado.getLabelsTp02());
		for ( String[] res:resultado.getRegsTp02() ){
			printStringArray(res);
		}		
		if ( resultado.getRegsTp03()!=null && resultado.getRegsTp03().length>0 ){
			System.out.println("[RegTp03]");
			printStringArray(resultado.getLabelsTp03());
			for ( String[] res:resultado.getRegsTp03() ){
				printStringArray(res);
			}
		}
		if ( resultado.getRegsTp04()!=null && resultado.getRegsTp04().length>0 ){
			System.out.println("[RegTp04]");
			printStringArray(resultado.getLabelsTp04());
			for ( String[] res:resultado.getRegsTp04() ){
				printStringArray(res);
			}
		}
		if ( resultado.getRegsTp05()!=null && resultado.getRegsTp05().length>0 ){
			System.out.println("[RegTp05]");
			printStringArray(resultado.getLabelsTp05());
			for ( String[] res:resultado.getRegsTp05() ){
				printStringArray(res);
			}
		}
		if ( resultado.getRegsTp06()!=null && resultado.getRegsTp06().length>0 ){
			System.out.println("[RegTp06]");
			printStringArray(resultado.getLabelsTp06());
			for ( String[] res:resultado.getRegsTp06() ){
				printStringArray(res);
			}
		}
		if ( resultado.getRegsTp07()!=null && resultado.getRegsTp07().length>0 ){
			System.out.println("[RegTp07]");
			printStringArray(resultado.getLabelsTp07());
			for ( String[] res:resultado.getRegsTp07() ){
				printStringArray(res);
			}
		}
		if ( resultado.getRegTp08()!=null ){
			System.out.println("[RegTp08]");
			printStringArray(resultado.getLabelsTp08());
			printStringArray(resultado.getRegTp08());
		}
		if ( resultado.getRegTp09()!=null ){
			System.out.println("[RegTp09]");
			printStringArray(resultado.getLabelsTp09());
			printStringArray(resultado.getRegTp09());
		}
		if ( resultado.getRegTp10()!=null ){
			System.out.println("[RegTp10]");
			printStringArray(resultado.getLabelsTp10());
			printStringArray(resultado.getRegTp10());
		}
		if ( resultado.getRegTp11()!=null ){
			System.out.println("[RegTp11]");
			printStringArray(resultado.getLabelsTp11());
			printStringArray(resultado.getRegTp11());
		}
		if ( resultado.getRegTp12()!=null ){
			System.out.println("[RegTp12]");
			printStringArray(resultado.getLabelsTp12());
			printStringArray(resultado.getRegTp12());
		}
	}
	
	private void printStringArray ( String[] srt){
		for ( String s:srt ){
			System.out.print(s+";");
		}
		System.out.println();
	}
}

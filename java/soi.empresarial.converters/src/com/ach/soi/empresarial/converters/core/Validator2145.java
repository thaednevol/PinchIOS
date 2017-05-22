package com.ach.soi.empresarial.converters.core;

import java.io.File;

import org.beanio.BeanReader;
import org.beanio.StreamFactory;

import com.ach.soi.empresarial.converters.error.ErrorHandlerReader2145;
import com.ach.soi.empresarial.converters.model.CommonBean;
import com.ach.soi.empresarial.converters.model.ErrorValidacionTO;

public class Validator2145 {
	
	public static void main(String[] args) throws Exception{
		ErrorValidacionTO[] errores = new Validator2145().validarArchivo2145("/Users/jgutierrez/lucasian/soi.empresarial.git/archivos/test_pens.txt");
		
		System.out.println(errores.length + " errores");
		
		for (ErrorValidacionTO error : errores) {
			System.out.println("linea: " + error.getLinea() + ", " + 
							   "campo: " + error.getCampo() + ", " +
							   "error: " + error.getError() + ", " + 
							   "detalle: " + error.getDetalleError());
		}
	}

	public ErrorValidacionTO[] validarArchivo2145 ( String path ) throws Exception{
		StreamFactory factory = StreamFactory.newInstance();
        factory.loadResource("mapping-2145.xml");
        
        BeanReader in = null;
        ErrorHandlerReader2145 errorHandler = new ErrorHandlerReader2145();
        try {                	
	        in	= factory.createReader("PILA-2145", new File(path));
	        CommonBean bean = null;
	        in.setErrorHandler(errorHandler);
	        ErrorValidacionTO errorTo = null;

	        int line = 0;
	        int currentType = 1;
	        int previousType = 1;
	        
	        while ((bean = (CommonBean)in.read()) != null){
	        	line++;
	        	currentType = bean.getTipoRegistro();
	        	if ( currentType<previousType ){
	        		errorTo = new ErrorValidacionTO();
	        		errorTo.setCampo("-");
	        		errorTo.setDetalleError("Tipo de registro no esperado en la linea "+line);
	        		errorTo.setError("Tipo de registro no esperado en la linea "+line);
	        		errorTo.setLinea(line);
	        		errorHandler.getErrors().add(errorTo);
	        	}
	        	previousType = currentType;
	        }
	        
        } catch (Exception e) {
        	System.out.println("Exception: " + e.getMessage());
        } finally{
        	
        }
        return errorHandler.getErrors().toArray(new ErrorValidacionTO[0]);
	}
}

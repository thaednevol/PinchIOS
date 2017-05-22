package com.ach.soi.empresarial.converters.core;

import java.io.File;

import org.beanio.BeanReader;
import org.beanio.StreamFactory;

import com.ach.soi.empresarial.converters.error.ErrorHandlerReader1747;
import com.ach.soi.empresarial.converters.model.CommonBean;
import com.ach.soi.empresarial.converters.model.ErrorValidacionTO;

public class Validator1747 {

	public static void main(String[] args) throws Exception{
		new Validator1747().validarArchivo1747("/Users/jgutierrez/lucasian/tmp/ene-2017/soi.empresarial/data/test.txt");
	}
	
	
	
	public ErrorValidacionTO[] validarArchivo1747 ( String path ) throws Exception{
		StreamFactory factory = StreamFactory.newInstance();
        factory.loadResource("mapping-1747.xml");
        
        BeanReader in = null;
        ErrorHandlerReader1747 errorHandler = new ErrorHandlerReader1747();
        try {                	
	        in	= factory.createReader("PILA-1747", new File(path));
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
	        
        }finally{
        	
        }
        return errorHandler.getErrors().toArray(new ErrorValidacionTO[0]);
	}
 

}

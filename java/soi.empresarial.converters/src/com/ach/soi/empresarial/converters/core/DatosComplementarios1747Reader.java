package com.ach.soi.empresarial.converters.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.beanio.BeanReader;
import org.beanio.InvalidRecordException;
import org.beanio.StreamFactory;
import org.beanio.UnidentifiedRecordException;

import com.ach.soi.empresarial.converters.model.beans1747.DatosComplementarios1747;
import com.ach.soi.empresarial.converters.utils.Constants;

/**
 * 
 * Lector de datos complementarios del archivo 1747 enviados por
 * algunos aportantes. Esta clase lee el archivo y los agrupa 
 * para su posterior lectura y uso.
 * 
 * @author jgutierrez
 *
 */
public class DatosComplementarios1747Reader {

	private String pathArchivoDatosCompl;
	private Map<String, DatosComplementarios1747> datosComplementariosMap = new HashMap<String, DatosComplementarios1747>();
	
	
	public DatosComplementarios1747Reader ( String pathArchivoDatosCompl ){
		this.pathArchivoDatosCompl = pathArchivoDatosCompl;
	}
	
	public DatosComplementarios1747 getDatosComplementarios ( String key ){
		return datosComplementariosMap.get(key);
	}
	
	public void loadData ( ) throws Exception{
		
		StreamFactory factory = StreamFactory.newInstance();
        factory.loadResource("mapping-1747-complements.xml");
        BeanReader in = null;
        DatosComplementarios1747 datos = null;
		try {        
			
            in	= factory.createReader("PILA-1747-Complemento", new InputStreamReader(new FileInputStream(pathArchivoDatosCompl), Constants.GENERAL_ENCODING));
            
            while ( (datos=(DatosComplementarios1747)in.read())!=null ){
            	this.datosComplementariosMap.put(datos.getKey(), datos);
            }
	        
        }catch (UnidentifiedRecordException ex2) {
        	ex2.printStackTrace();
        	throw ex2;
		}catch (InvalidRecordException ex) {
			ex.printStackTrace();
        	throw ex;
        } finally {
        	if (in != null) {
        		in.close();
        	}
        }
	}
	
}

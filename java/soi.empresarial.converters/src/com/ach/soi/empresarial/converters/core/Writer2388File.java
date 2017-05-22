package com.ach.soi.empresarial.converters.core;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.beanio.BeanWriter;
import org.beanio.StreamFactory;

import com.ach.soi.empresarial.converters.enums.TipoArchivo;
import com.ach.soi.empresarial.converters.model.Archivo2388TO;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadPensTp01;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadPensTp02;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadTp01;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadTp02;
import com.ach.soi.empresarial.converters.utils.ParsersUtil;

public class Writer2388File {

	
	
	public void writeFile2388( String outFilePath, Archivo2388TO archivo2388, String tipoArchivo ) throws Exception{
		TipoArchivo tp = TipoArchivo.getTipoArchivoPorCod(tipoArchivo);
		
		switch (tp) {
		case ACTIVOS:
			this.writeFile2388from1747(outFilePath, archivo2388);
			break;
		case PENSIONADOS:
			this.writeFile2388from2145(outFilePath, archivo2388);
			break;
		default:
			throw new Exception("Tipo de archivo no implementado: "+tipoArchivo);
		}
	}
	
	private void writeFile2388from2145( String outFilePath, Archivo2388TO archivo2388 ) throws Exception{
		
		//this.validateFileContent2145(archivo2388);
			
		StreamFactory factory = StreamFactory.newInstance();
	    factory.loadResource("mapping-2145-to-2388-write.xml");
	        
	    //BeanWriter writer = factory.createWriter("PILA-2388",  new File(outFilePath));
	    BeanWriter writer = factory.createWriter("PILA-2388",  new OutputStreamWriter(new FileOutputStream(outFilePath),"UTF-8"));
	    try{    
	        writer.write(Reg2388ReadPensTp01.buildRecordFromStringArray(archivo2388.getRegTp01()));
	        
	        for ( String[] r:archivo2388.getRegsTp02() ){
	        	writer.write(Reg2388ReadPensTp02.buildRecordFromStringArray(r) );
	        }
	        
	        /*if ( archivo2388.getRegsTp03()!=null && archivo2388.getRegsTp03().length>0 ){
		        for ( String r[]:archivo2388.getRegsTp03() ){
		        	writer.write(Reg2388ReadPensTp03.buildRecordFromStringArray(r));
		        }	        
	        }
	        
	        if ( archivo2388.getRegsTp04()!=null && archivo2388.getRegsTp04().length>0 ){
		        for ( String[] r:archivo2388.getRegsTp04() ){
		        	writer.write(Reg2388ReadPensTp04.buildRecordFromStringArray(r));
		        }	        
	        }
	        
	        if ( archivo2388.getRegsTp05()!=null && archivo2388.getRegsTp05().length>0 ){
		        for ( String[] r:archivo2388.getRegsTp05() ){
		        	writer.write(Reg2388ReadPensTp05.buildRecordFromStringArray(r));
		        }	        
	        }
	        
	        if ( archivo2388.getRegsTp06()!=null && archivo2388.getRegsTp06().length>0 ){
		        for ( String[] r:archivo2388.getRegsTp06() ){
		        	writer.write(Reg2388ReadPensTp06.buildRecordFromStringArray(r));
		        }	        
	        }
	        
	        if ( archivo2388.getRegsTp07()!=null && archivo2388.getRegsTp07().length>0 ){
		        for ( String r[]:archivo2388.getRegsTp07() ){
		        	writer.write(Reg2388ReadPensTp07.buildRecordFromStringArray(r));
		        }	        
	        }*/
	        	       
		}finally{
			writer.flush();
			writer.close();
		}
	}
	
	
	private void validateFileContent2145 ( Archivo2388TO archivo2388 ) throws Exception{
		if ( archivo2388.getRegTp01()==null || archivo2388.getRegTp01().length==0 ){
			throw new Exception ("Registro tipo 1 requerido");
		}
		
		if ( archivo2388.getRegsTp07()==null || archivo2388.getRegsTp07().length==0 ){
			throw new Exception ("Registro tipo 7 requerido");
		}
		
		if ( archivo2388.getRegsTp02()==null || archivo2388.getRegsTp02().length==0 ){
			throw new Exception ("Se requiere al menos un registro tipo 2");
		}
		
		if ( archivo2388.getRegsTp03()==null || archivo2388.getRegsTp03().length==0 ){
			throw new Exception ("Se requiere al menos un registro tipo 3");
		}
	}
	
	
	private void writeFile2388from1747 ( String outFilePath, Archivo2388TO archivo2388 ) throws Exception{
		
		//this.validateFileContent1747(archivo2388);
			
		StreamFactory factory = StreamFactory.newInstance();
	    factory.loadResource("mapping-1747-to-5858-write.xml");
	    Reg2388ReadTp01 regTp01 = null;  
	    //BeanWriter writer = factory.createWriter("PILA-2388", new File(outFilePath));
	    BeanWriter writer = factory.createWriter("PILA-2388", new OutputStreamWriter(new FileOutputStream(outFilePath), "UTF-8"));
	    try{    
	    	regTp01 = Reg2388ReadTp01.buildRecordFromStringArray(archivo2388.getRegTp01());
	        writer.write(regTp01);
	        
	        for ( String[] r:archivo2388.getRegsTp02() ){	        	
	        	Reg2388ReadTp02 regTp02 = Reg2388ReadTp02.buildRecordFromStringArray(r); 	        	
        		ParsersUtil.completarConvertirTp02(regTp01, regTp02);
        		writer.write(regTp02);		        	
	        }
	        
	       /* if ( archivo2388.getRegsTp03()!=null && archivo2388.getRegsTp03().length>0 ){
		        for ( String r[]:archivo2388.getRegsTp03() ){
		        	writer.write(Reg2388ReadTp03.buildRecordFromStringArray(r));
		        }	        
	        }
	        
	        if ( archivo2388.getRegsTp04()!=null && archivo2388.getRegsTp04().length>0 ){
		        for ( String[] r:archivo2388.getRegsTp04() ){
		        	writer.write(Reg2388ReadTp04.buildRecordFromStringArray(r));
		        }	        
	        }
	        
	        if ( archivo2388.getRegsTp05()!=null && archivo2388.getRegsTp05().length>0 ){
		        for ( String[] r:archivo2388.getRegsTp05() ){
		        	writer.write(Reg2388ReadTp05.buildRecordFromStringArray(r));
		        }	        
	        }
	        
	        if ( archivo2388.getRegsTp06()!=null && archivo2388.getRegsTp06().length>0 ){
		        for ( String[] r:archivo2388.getRegsTp06() ){
		        	writer.write(Reg2388ReadTp06.buildRecordFromStringArray(r));
		        }	        
	        }
	        
	        if ( archivo2388.getRegsTp07()!=null && archivo2388.getRegsTp07().length>0 ){
		        for ( String r[]:archivo2388.getRegsTp07() ){
		        	writer.write(Reg2388ReadTp07.buildRecordFromStringArray(r));
		        }	        
	        }
	        
	        if ( archivo2388.getRegTp08()!=null && archivo2388.getRegTp08().length>1 ){
	        	writer.write(Reg2388ReadTp08.buildRecordFromStringArray(archivo2388.getRegTp08()));	        
	        }
	        
	        if ( archivo2388.getRegTp09()!=null && archivo2388.getRegTp09().length>1 ){
	        	writer.write(Reg2388ReadTp09.buildRecordFromStringArray(archivo2388.getRegTp09()));	        
	        }
	        
	        if ( archivo2388.getRegTp10()!=null && archivo2388.getRegTp10().length>1 ){
	        	writer.write(Reg2388ReadTp10.buildRecordFromStringArray(archivo2388.getRegTp10()));	        
	        }
	        
	        if ( archivo2388.getRegTp11()!=null && archivo2388.getRegTp11().length>1 ){
	        	writer.write(Reg2388ReadTp11.buildRecordFromStringArray(archivo2388.getRegTp11()));	        
	        }
	        if ( archivo2388.getRegTp12()!=null ){
	        	writer.write(Reg2388ReadTp12.buildRecordFromStringArray(archivo2388.getRegTp12()));
	        }*/
		}finally{
			writer.flush();
			writer.close();
		}
	}
	
	
	private boolean tieneNovedadesAusentismo ( Reg2388ReadTp02 regTp2 ){
		if ( regTp2.getIge()!=null && regTp2.getIge().equals("X") ){
			return true;
		}
		if ( regTp2.getVac()!=null && regTp2.getVac().equals("X") ){
			return true;
		}
		if ( regTp2.getLma()!=null && regTp2.getLma().equals("X") ){
			return true;
		}
		if ( regTp2.getSln()!=null && regTp2.getSln().equals("X") ){
			return true;
		}
		if ( regTp2.getIrl()!=null && regTp2.getVst().equals("X") ){
			return true;
		}
		return false;
	}
	
	
	
	private void validateFileContent1747 ( Archivo2388TO archivo2388 ) throws Exception{
		if ( archivo2388.getRegTp01()==null || archivo2388.getRegTp01().length==0 ){
			throw new Exception ("Registro tipo 1 requerido");
		}
		
		if ( archivo2388.getRegTp12()==null || archivo2388.getRegTp12().length==0 ){
			throw new Exception ("Registro tipo 12 requerido");
		}
		
		if ( archivo2388.getRegsTp02()==null || archivo2388.getRegsTp02().length==0 ){
			throw new Exception ("Se requiere al menos un registro tipo 2");
		}
		
		if ( archivo2388.getRegsTp03()==null || archivo2388.getRegsTp03().length==0 ){
			throw new Exception ("Se requiere al menos un registro tipo 3");
		}
	}
	
}

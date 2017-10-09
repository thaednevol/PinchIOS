package com.ach.soi.empresarial.converters.core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

import org.beanio.BeanReader;
import org.beanio.InvalidRecordException;
import org.beanio.StreamFactory;
import org.beanio.UnidentifiedRecordException;

import com.ach.soi.empresarial.converters.model.Archivo2388TO;
import com.ach.soi.empresarial.converters.model.CommonBean;
import com.ach.soi.empresarial.converters.model.ErrorValidacionTO;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadTp01;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadTp02;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadTp03;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadTp04;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadTp05;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadTp06;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadTp07;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadTp08;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadTp09;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadTp10;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadTp11;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadTp12;
import com.ach.soi.empresarial.converters.utils.Constants;

public class Validator2388 {

	
	public Archivo2388TO read2388File ( String filePath ) throws Exception{
		
		StreamFactory factory = StreamFactory.newInstance();
        factory.loadResource("mapping-2388-read.xml");
        
        BeanReader in = null;
        Archivo2388TO archivoResultado = new Archivo2388TO();
        Collection<Reg2388ReadTp02> regsTp2 = new ArrayList<Reg2388ReadTp02>();
        Collection<Reg2388ReadTp03> regsTp3 = new ArrayList<Reg2388ReadTp03>();
        Collection<Reg2388ReadTp04> regsTp4 = new ArrayList<Reg2388ReadTp04>();
        Collection<Reg2388ReadTp05> regsTp5 = new ArrayList<Reg2388ReadTp05>();
        Collection<Reg2388ReadTp06> regsTp6 = new ArrayList<Reg2388ReadTp06>();
        Collection<Reg2388ReadTp07> regsTp7 = new ArrayList<Reg2388ReadTp07>();
        Reg2388ReadTp02 regTp02 = null;
        Reg2388ReadTp01 regTp01 = null;
        
        
        try {        
        	        	
            in	= factory.createReader("PILA-2388", new InputStreamReader(new FileInputStream(filePath), Constants.GENERAL_ENCODING));
	        CommonBean bean = null;
	        int regsNoIdentificados = 0;
	        do{	
	        	try{
	        		bean = (CommonBean)in.read();	
		        	if ( bean instanceof Reg2388ReadTp01 ){	        		
		        		regTp01 = (Reg2388ReadTp01)bean;
		        		archivoResultado.setRegTp01(regTp01.toStringArray());
		        	}
		        	else if ( bean instanceof Reg2388ReadTp02 ){	        		
		        		regTp02 = (Reg2388ReadTp02)bean;
		        		regsTp2.add(regTp02);
		        	}
		        	else if ( bean instanceof Reg2388ReadTp03 ){
		        		regsTp3.add((Reg2388ReadTp03)bean);
		        	}
		        	else if ( bean instanceof Reg2388ReadTp04 ){
		        		regsTp4.add((Reg2388ReadTp04)bean);
		        	}
		        	else if ( bean instanceof Reg2388ReadTp05 ){
		        		regsTp5.add((Reg2388ReadTp05)bean);
		        	}
		        	else if ( bean instanceof Reg2388ReadTp06 ){
		        		regsTp6.add((Reg2388ReadTp06)bean);
		        	}
		        	else if ( bean instanceof Reg2388ReadTp07 ){
		        		regsTp7.add((Reg2388ReadTp07)bean);
		        	}
		        	else if ( bean instanceof Reg2388ReadTp08 ){
		        		((Reg2388ReadTp08)bean).setTipoRegistro(8);
		        		archivoResultado.setRegTp08(((Reg2388ReadTp08)bean).toStringArray());
		        	}
		        	else if ( bean instanceof Reg2388ReadTp09 ){
		        		((Reg2388ReadTp09)bean).setTipoRegistro(9);
		        		archivoResultado.setRegTp09(((Reg2388ReadTp09)bean).toStringArray());
		        	}
		        	else if ( bean instanceof Reg2388ReadTp10 ){
		        		((Reg2388ReadTp10)bean).setTipoRegistro(10);
		        		archivoResultado.setRegTp10(((Reg2388ReadTp10)bean).toStringArray());
		        	}
		        	else if ( bean instanceof Reg2388ReadTp11 ){
		        		((Reg2388ReadTp11)bean).setTipoRegistro(11);
		        		archivoResultado.setRegTp11(((Reg2388ReadTp11)bean).toStringArray());
		        	}
		        	else if ( bean instanceof Reg2388ReadTp12 ){
		        		((Reg2388ReadTp12)bean).setTipoRegistro(12);
		        		archivoResultado.setRegTp12(((Reg2388ReadTp12)bean).toStringArray());
		        	}
	        	}catch(Exception e){
	        		regsNoIdentificados++;
	        		if ( regsNoIdentificados>100 ){
	        			throw e;
	        		}
	        		continue;
	        	}
	        }while (bean != null);
	        
	        archivoResultado.setRegsTp02(new String[regsTp2.size()][97]);
	        archivoResultado.setRegsTp03(new String[regsTp3.size()][16]);
	        archivoResultado.setRegsTp04(new String[regsTp4.size()][10]);
	        archivoResultado.setRegsTp05(new String[regsTp5.size()][17]);
	        archivoResultado.setRegsTp06(new String[regsTp6.size()][18]);
	        archivoResultado.setRegsTp07(new String[regsTp7.size()][10]);
	        
	        int index = 0;
	        for ( Reg2388ReadTp02 tp2:regsTp2 ){
	        	archivoResultado.getRegsTp02()[index]=tp2.toStringArray();
	        	index++;
	        }
	        
	        index = 0;
	        for ( Reg2388ReadTp03 tp3:regsTp3 ){
	        	archivoResultado.getRegsTp03()[index]=tp3.toStringArray();
	        	index++;
	        }
	        
	        index = 0;
	        for ( Reg2388ReadTp04 tp4:regsTp4 ){
	        	archivoResultado.getRegsTp04()[index]=tp4.toStringArray();
	        	index++;
	        }
	        
	        index = 0;
	        for ( Reg2388ReadTp05 tp5:regsTp5 ){
	        	tp5.setTipoRegistro(5);
	        	archivoResultado.getRegsTp05()[index]=tp5.toStringArray();
	        	index++;
	        }
	        
	        index = 0;
	        for ( Reg2388ReadTp06 tp6:regsTp6 ){
	        	tp6.setTipoRegistro(6);
	        	archivoResultado.getRegsTp06()[index]=tp6.toStringArray();
	        	index++;
	        }
	        
	        index = 0;
	        for ( Reg2388ReadTp07 tp7:regsTp7 ){	
	        	tp7.setTipoRegistro(7);
	        	archivoResultado.getRegsTp07()[index]=tp7.toStringArray();
	        	index++;
	        }
	        
	        archivoResultado.setLabelsTp01(Reg2388ReadTp01.getLabels());
	        archivoResultado.setLabelsTp02(Reg2388ReadTp02.getLabels());
	        archivoResultado.setLabelsTp03(Reg2388ReadTp03.getLabels());
	        archivoResultado.setLabelsTp04(Reg2388ReadTp04.getLabels());
	        archivoResultado.setLabelsTp05(Reg2388ReadTp05.getLabels());
	        archivoResultado.setLabelsTp06(Reg2388ReadTp06.getLabels());
	        archivoResultado.setLabelsTp07(Reg2388ReadTp07.getLabels());
	        archivoResultado.setLabelsTp08(Reg2388ReadTp08.getLabels());
	        archivoResultado.setLabelsTp09(Reg2388ReadTp09.getLabels());
	        archivoResultado.setLabelsTp10(Reg2388ReadTp10.getLabels());
	        archivoResultado.setLabelsTp11(Reg2388ReadTp11.getLabels());
	        archivoResultado.setLabelsTp12(Reg2388ReadTp12.getLabels());
	        
	        BufferedReader reader = new BufferedReader( new InputStreamReader(new FileInputStream(filePath), Constants.GENERAL_ENCODING) );
	        							
	        String line1 = reader.readLine();
	        archivoResultado.setRegTp1Txt(line1);
	        reader.close();
	        
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
		
		return archivoResultado;
	}
	
	
	public ErrorValidacionTO[] validate2388File ( String filePath ) throws Exception{
		return null;
	}
	
}

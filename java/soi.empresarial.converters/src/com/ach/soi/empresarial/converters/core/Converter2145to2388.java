package com.ach.soi.empresarial.converters.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

import org.beanio.BeanReader;
import org.beanio.InvalidRecordException;
import org.beanio.StreamFactory;
import org.beanio.UnidentifiedRecordException;

import com.ach.soi.empresarial.converters.model.Archivo2388TO;
import com.ach.soi.empresarial.converters.model.CommonBean;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadPensTp01;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadPensTp02;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadPensTp03;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadPensTp04;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadPensTp05;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadPensTp06;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadPensTp07;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadTp04;
import com.ach.soi.empresarial.converters.utils.Constants;
import com.ach.soi.empresarial.converters.utils.ParsersUtil;

public class Converter2145to2388 extends CommonConverter{


	public Archivo2388TO convertir2145a2388 ( String filePath ) throws Exception{
		StreamFactory factory = StreamFactory.newInstance();
        factory.loadResource("mapping-2145-to-2388-read.xml");
        
        BeanReader in = null;
        Archivo2388TO archivoResultado = new Archivo2388TO();
        Collection<Reg2388ReadPensTp02> regsTp2 = new ArrayList<Reg2388ReadPensTp02>();
        Collection<Reg2388ReadPensTp03> regsTp3 = new ArrayList<Reg2388ReadPensTp03>();
        Collection<Reg2388ReadPensTp04> regsTp4 = new ArrayList<Reg2388ReadPensTp04>();
        Collection<Reg2388ReadPensTp05> regsTp5 = new ArrayList<Reg2388ReadPensTp05>();
        Collection<Reg2388ReadPensTp06> regsTp6 = new ArrayList<Reg2388ReadPensTp06>();
        Reg2388ReadPensTp07 regTp07 = null;
        Reg2388ReadPensTp02 regTp02 = null;
        Reg2388ReadPensTp01 regTp01 = null;
        
        String primerDiaMes = null;
        String ultimoDiaMes = null;
        
        try {        
        	
        	in	= factory.createReader("PILA-2145-to-2388", new InputStreamReader(new FileInputStream(filePath), Constants.GENERAL_ENCODING));            
	        CommonBean bean = null;
	        int regsNoIdentificados = 0;
	        do{	
	        	try{
	        		bean = (CommonBean)in.read();	
		        	if ( bean instanceof Reg2388ReadPensTp01 ){	        		
		        		regTp01 = (Reg2388ReadPensTp01)bean;
		        		regTp01.setTipoPlanillaPensionados("P");
		        		primerDiaMes = ParsersUtil.getPrimerDiaMes(regTp01);
		        		ultimoDiaMes = ParsersUtil.getUltimoDiaMes(regTp01);
		        		archivoResultado.setRegTp01(regTp01.toStringArray());
		        	}
		        	else if ( bean instanceof Reg2388ReadPensTp02 ){	        		
		        		regTp02 = (Reg2388ReadPensTp02)bean;
		        		this.completarConvertirTp02(regTp01, regTp02, primerDiaMes, ultimoDiaMes);
		        		regsTp2.add(regTp02);
		        	}
		        	else if ( bean instanceof Reg2388ReadPensTp03 ){
		        		regsTp3.add((Reg2388ReadPensTp03)bean);
		        	}
		        	else if ( bean instanceof Reg2388ReadTp04 ){
		        		regsTp4.add((Reg2388ReadPensTp04)bean);
		        	}
		        	else if ( bean instanceof Reg2388ReadPensTp05 ){
		        		regsTp5.add((Reg2388ReadPensTp05)bean);
		        	}
		        	else if ( bean instanceof Reg2388ReadPensTp06 ){
		        		regsTp6.add((Reg2388ReadPensTp06)bean);
		        	}
		        	else if ( bean instanceof Reg2388ReadPensTp07 ){
		        		regTp07 = (Reg2388ReadPensTp07)bean;
		        	}
		        	
	        	}catch(Exception e){
	        		regsNoIdentificados++;
	        		e.printStackTrace();
	        		if ( regsNoIdentificados>100 ){
	        			throw e;
	        		}
	        		bean = new Reg2388ReadPensTp01();
	        		continue;
	        	}
	        }while (bean != null);
	        
	        archivoResultado.setRegTp01(regTp01.toStringArray());
	        archivoResultado.setRegsTp02(new String[regsTp2.size()][61]);
	        archivoResultado.setRegsTp03(new String[regsTp3.size()][15]);
	        archivoResultado.setRegsTp04(new String[regsTp4.size()][10]);
	        archivoResultado.setRegsTp05(new String[regsTp5.size()][15]);
	        archivoResultado.setRegsTp06(new String[regsTp6.size()][18]);
	        archivoResultado.setRegsTp07(new String[1][9]);
	        
	        int index = 0;
	        for ( Reg2388ReadPensTp02 tp2:regsTp2 ){
	        	archivoResultado.getRegsTp02()[index]=tp2.toStringArray();
	        	index++;
	        }
	        
	        index = 0;
	        for ( Reg2388ReadPensTp03 tp3:regsTp3 ){
	        	archivoResultado.getRegsTp03()[index]=tp3.toStringArray();
	        	index++;
	        }
	        
	        index = 0;
	        for ( Reg2388ReadPensTp04 tp4:regsTp4 ){
	        	archivoResultado.getRegsTp04()[index]=tp4.toStringArray();
	        	index++;
	        }
	        
	        index = 0;
	        for ( Reg2388ReadPensTp05 tp5:regsTp5 ){
	        	tp5.setTipoRegistro(5);
	        	archivoResultado.getRegsTp05()[index]=tp5.toStringArray();
	        	index++;
	        }
	        
	        index = 0;
	        for ( Reg2388ReadPensTp06 tp6:regsTp6 ){
	        	tp6.setTipoRegistro(6);
	        	archivoResultado.getRegsTp06()[index]=tp6.toStringArray();
	        	index++;
	        }
	        
	        if ( regTp07!=null ){
	        	archivoResultado.getRegsTp07()[0]=regTp07.toStringArray();
	        }
	        else{
	        	archivoResultado.getRegsTp07()[0]=Reg2388ReadPensTp07.toStringArrayDefault();
	        }
	        
	        archivoResultado.setLabelsTp01(Reg2388ReadPensTp01.getLabels());
	        archivoResultado.setLabelsTp02(Reg2388ReadPensTp02.getLabels());
	        archivoResultado.setLabelsTp03(Reg2388ReadPensTp03.getLabels());
	        archivoResultado.setLabelsTp04(Reg2388ReadPensTp04.getLabels());
	        archivoResultado.setLabelsTp05(Reg2388ReadPensTp05.getLabels());
	        archivoResultado.setLabelsTp06(Reg2388ReadPensTp06.getLabels());
	        archivoResultado.setLabelsTp07(Reg2388ReadPensTp07.getLabels());
	        
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
	
	
	
	private void completarConvertirTp02 ( Reg2388ReadPensTp01 regTp01, Reg2388ReadPensTp02 regTp02, String primerDiaMes, String ultimoDiaMes ){
		//R01
		if ( regTp02.getTipoPensionado()!=null && regTp02.getTipoPensionado().equals("9") ){
			regTp02.setTipoDocumentoCotizantePpal(regTp02.getTipoDocumentoPensionado());
			regTp02.setNroIdentificacionCotizantePpal(regTp02.getNumeroIdentificacionPensionado());
		}
		
		
		if ( regTp02.getING()!=null&&regTp02.getING().equals("X") ){
			regTp02.setFechaIngreso(primerDiaMes);
		}
		else{
			regTp02.setFechaIngreso(" ");
		}
		
		if ( regTp02.getRET()!=null&&regTp02.getRET().equals("X") ){
			regTp02.setFechaRetiro(ultimoDiaMes);
		}else{
			regTp02.setFechaRetiro(" ");
		}
		
		if ( regTp02.getVSP()!=null&&regTp02.getVSP().equals("X") ){
			regTp02.setFechaInicioVsp(primerDiaMes);		
		}
		else{
			regTp02.setFechaInicioVsp(" ");
		}
		
		if ( regTp02.getSUS()!=null&&regTp02.getSUS().equals("S") ){
			regTp02.setFechaInicioSusp(primerDiaMes);
			regTp02.setFechaFinSusp(ultimoDiaMes);
		}
		else{
			regTp02.setFechaInicioSusp(" ");
			regTp02.setFechaFinSusp(" ");
		}
		
		regTp02.setValorMesada("0");
		regTp02.setFechaRadicacionExterior("2016-02-01");
		
	}
	
	
}

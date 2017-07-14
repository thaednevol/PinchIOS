package com.ach.soi.empresarial.converters.core;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import org.beanio.BeanReader;
import org.beanio.BeanWriter;
import org.beanio.InvalidRecordException;
import org.beanio.StreamFactory;
import org.beanio.UnidentifiedRecordException;

import com.ach.soi.empresarial.converters.model.Archivo2388TO;
import com.ach.soi.empresarial.converters.model.CommonBean;
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
import com.ach.soi.empresarial.converters.utils.ParsersUtil;

public class Converter1747to2388 extends CommonConverter{

	public static void main ( String ars[] ){
		try{
			
			String[] eps = new String[]{"EPS001","EPS002","EPS001","EPS010","EPS016","EPS016"};
			String[] afp = new String[]{"230201","230301","230901"};
			String[] ccf = new String[]{"CCF41;70;001","CCF48;73;408;","CCF63;86;568","CCF56;76;001","CCF03;05;001"};
			String codCcf;
			
			String reg2 = "0200001CC1024488638      0100  11001MAYORGA             AVELLANEDA                    PAOLA               ANDREA                                       00230301      EPS017      CCF21 30303030002208442 0022084420022084420022084420022084420.160000003534000000000000000000000003533000000000000000000000000000000.12500000276100000000000               000000000               0000000000.00522000000000030000116000.040000000884000.020000000442000.030000000663000.000000000110000.01000000000000                  N14-17 1 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002208442160";
			Converter1747to2388 converter = new Converter1747to2388();
			String[] convertido = converter.convertirRegTp02Individual(reg2);
			Reg2388ReadTp02 reg = Reg2388ReadTp02.buildRecordFromStringArray(convertido);
			String nroDoc = reg.getNumeroDocumentoCotizante();
			
			Random random = new Random(100000);
			
			for ( int i=1;i<=1000; i++ ){
				reg.setSecuencia(i);
				reg.setPrimerApellido("APELLIDO"+i);
				reg.setPrimerNombre("NOMBRE"+i);
				reg.setNumeroDocumentoCotizante(nroDoc+i);
				codCcf = ccf[random.nextInt(5)];
				String codCcfArr[] = codCcf.split(";");
				reg.setCodigoAdmCcf(codCcfArr[0]);
				reg.setCodigoDepartamentoUbicacion(codCcfArr[1]);
				reg.setCodigoMunicipioUbicacion(codCcfArr[2]);
				reg.setCodigoAdmPensionesActual(afp[random.nextInt(3)]);
				reg.setCodigoAdmSaludActual(eps[random.nextInt(6)]);
				reg.setCodigoArlAfiliado("14-17");
				String regStr = converter.getRegT02FromBean(reg);
				System.out.print(regStr);
			}
			
		}catch ( Exception e ){
			
		}
	}
	
	public String getRegT02FromBean ( Reg2388ReadTp02 regT02 ) throws Exception{
		StreamFactory factory = StreamFactory.newInstance();
	    factory.loadResource("mapping-1747-to-5858-write.xml");
	    StringWriter strWriter = new StringWriter();
	    BeanWriter writer = factory.createWriter("PILA-2388", strWriter);
	    writer.write(regT02);
	    return strWriter.toString();
	}
	
	public Archivo2388TO convertir1747a2388 ( String filePath, String filePathArchivoComplementario ) throws Exception{
		StreamFactory factory = StreamFactory.newInstance();
        factory.loadResource("mapping-1747-to-5858-read.xml");
        
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
        DatosComplementarios1747Reader datosComplementarios = new DatosComplementarios1747Reader(filePathArchivoComplementario);
        boolean tieneDatosComplementarios = false;

        if ( filePathArchivoComplementario!=null && !filePathArchivoComplementario.trim().equals("") ){
        	try{
        		datosComplementarios.loadData();
        		tieneDatosComplementarios = true;
            }catch ( Exception e ){
            	throw new Exception("No se pudo cargar el archivo de datos complementarios enviado: "+filePathArchivoComplementario,e);
            }
        }
        
        try {
        	
            //in	= factory.createReader("PILA-1747-to-2388", new File(filePath));
        	in	= factory.createReader("PILA-1747-to-2388", new InputStreamReader(new FileInputStream(filePath), Constants.GENERAL_ENCODING));
            
            
	        CommonBean bean = null;
	        int regsNoIdentificados = 0;
	        ParsersUtil parseUtil = null;
	        if ( tieneDatosComplementarios ){
	        	parseUtil = new ParsersUtil(datosComplementarios);
	        }
	        else{
	        	parseUtil = new ParsersUtil();
	        }
	        do{	
	        	try{
	        		bean = (CommonBean)in.read();	
		        	if ( bean instanceof Reg2388ReadTp01 ){	        		
		        		regTp01 = (Reg2388ReadTp01)bean;
		        		archivoResultado.setRegTp01(regTp01.toStringArray());
		        	}
		        	else if ( bean instanceof Reg2388ReadTp02 ){	        		
		        		regTp02 = (Reg2388ReadTp02)bean;
		        		ParsersUtil.completarConvertirTp02(regTp01, regTp02);
		        		//divide multiples registros
		        		if ( ParsersUtil.tieneNovedadesAusentismo(regTp02) ){
		        			regsTp2.addAll(parseUtil.generarMultiRegistrosNovedadAusentismo(regTp02,regTp01));
		        		}
		        		else{
		        			regsTp2.add(regTp02);	
		        		}		        		
		        	}
		        	else if ( bean instanceof Reg2388ReadTp03 ){
		        		regsTp3.add((Reg2388ReadTp03)bean);
		        	}
		        	/*else if ( bean instanceof Reg2388ReadTp04 ){
		        		regsTp4.add((Reg2388ReadTp04)bean);
		        	}*/
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
	        		e.printStackTrace();
	        		regsNoIdentificados++;
	        		if ( regsNoIdentificados>100 ){
	        			throw e;
	        		}
	        		bean = new Reg2388ReadTp01();
	        		continue;
	        	}
	        }while (bean != null);
	        regsTp4 = this.generarRegistrosTp4(regsTp2);
	        	       
	        
	        archivoResultado.setRegsTp02(new String[regsTp2.size()][97]);
	        archivoResultado.setRegsTp03(new String[regsTp3.size()][16]);
	        archivoResultado.setRegsTp04(new String[regsTp4.size()][10]);
	        archivoResultado.setRegsTp05(new String[regsTp5.size()][17]);
	        archivoResultado.setRegsTp06(new String[regsTp6.size()][18]);
	        archivoResultado.setRegsTp07(new String[regsTp7.size()][10]);
	        
	        int index = 0;
	        for ( Reg2388ReadTp02 tp2:regsTp2 ){
	        	tp2.setSecuencia(index+1);	        	
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
	
	
	
	private Collection<Reg2388ReadTp04> generarRegistrosTp4 ( Collection<Reg2388ReadTp02> regsTp02 ){
		Collection<Reg2388ReadTp04> regsTp04 = new ArrayList<Reg2388ReadTp04>();
		Reg2388ReadTp04 tp4 = null;
		Long aportesFsp = 0l;		
		String codAdm = "MIN001";
		String nitAdm = "900462447";
		String digVeriAdm = "5";
		int nroAfiliados = 0;
		for ( Reg2388ReadTp02 tp2:regsTp02 ){
			if ( tp2.getSubtipoCotizante()!=null && tp2.getSubtipoCotizante().equals("6") ){
				nroAfiliados ++;
				try{
					aportesFsp += Long.valueOf(tp2.getAporteFspSolidaridad());
				}catch ( Exception e ){
					//continua con valor 0
				}
				try{
					aportesFsp += Long.valueOf(tp2.getAporteFspSubsistencia());
				}catch ( Exception e ){
					//continua con valor 0
				}
				try{
					aportesFsp += Long.valueOf(tp2.getCotizacionOblgPension());
				}catch ( Exception e ){
					//continua con valor 0
				}
			}						
		}
		//Crea registro de FSP
		if ( aportesFsp>0l ){
			tp4 = new Reg2388ReadTp04();
			tp4.setSecuencia(1);
			tp4.setDiasMora("0");
			tp4.setCodigoFsp(codAdm);
			tp4.setDigitoVerificacionFsp(digVeriAdm);
			tp4.setNitFsp(nitAdm);
			tp4.setTipoRegistro(4);
			tp4.setTotalAfiliadosFsp(nroAfiliados+"");			
			tp4.setValorInteresMoraFsp("0");			
			tp4.setValorTotalAportesFsp(aportesFsp.toString());
			tp4.setValorTotalPagarFsp(aportesFsp+"");
			regsTp04.add(tp4);
			
		}
		return regsTp04;
	}
	
	public String[] convertirRegTp02Individual ( String regTp02Str ) throws Exception{
		StreamFactory factory = StreamFactory.newInstance();
        factory.loadResource("mapping-1747-to-5858-read.xml");
        
        BeanReader in = null;
        Reg2388ReadTp02 regTp2 = null;        
        
        try {        
        	
            in	= factory.createReader("PILA-1747-to-2388", new StringReader(regTp02Str));
	        
	        regTp2 = (Reg2388ReadTp02)in.read();	
	        ParsersUtil.completarConvertirTp02(null, regTp2);
		        		        
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
        return regTp2.toStringArray();
	}
	

}

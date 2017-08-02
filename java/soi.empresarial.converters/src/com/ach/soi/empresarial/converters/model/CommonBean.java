package com.ach.soi.empresarial.converters.model;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;

import com.ach.soi.empresarial.converters.utils.Constants;


public class CommonBean implements Serializable{

	protected Integer tipoRegistro;
	protected Integer secuencia;
	
	
	protected boolean isNull ( String str ){
		return isNull((Object)str)||str.trim().equals("");
	}
	
	protected boolean isNull ( Object obj ){
		return obj==null;
	}
	
	
	public Integer getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(Integer tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	public Integer getSecuencia() {
		return secuencia;
	}
	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}
	
	
	protected static String[] fillArray ( String[] array,int size ){
		
		if ( array!=null && array.length==size ){
			return array;
		}
		
		Collection<String> result=new ArrayList<String>(size);
		if ( array==null ){
			for ( int i=0;i<size;i++ ){
				result.add(" ");
			}
		}
		else{
			for ( int i=0;i<size;i++ ){
				result.add(array[i]);
			}
			for ( int i=array.length;i<size;i++ ){
				result.add(array[i]);
			}
		}		
		return result.toArray(new String[0]);
	}
	
	/*public static String getEncodingValue ( String unicodeVal ){
		Charset charset = Charset.forName(Constants.GENERAL_ENCODING);
		String res = null;
		try{
			res = new String(unicodeVal.getBytes(charset),Constants.GENERAL_ENCODING);
		}catch ( Exception e ){
			res = new String(unicodeVal.getBytes(charset));
		}
		return res;
	}*/
	
}

package com.ach.soi.empresarial.converters.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


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
	
	
	
}

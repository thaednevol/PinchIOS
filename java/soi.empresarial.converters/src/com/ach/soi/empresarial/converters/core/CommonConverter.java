package com.ach.soi.empresarial.converters.core;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonConverter {

	
	
	protected String getPrimerDiaMes (  ){
		Date periodoOtros = new Date();
		Calendar periodoOtrosCal = Calendar.getInstance();
		SimpleDateFormat fmtPeriodo = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat fmtFecha = new SimpleDateFormat("yyyy-MM-dd");
		String primerDiaMes = "";
		try{
			String periodo = null;
			
			periodoOtros = fmtPeriodo.parse(periodo);
			periodoOtrosCal.setTime(periodoOtros);
			periodoOtrosCal.set(Calendar.DAY_OF_MONTH, 1);
			primerDiaMes = fmtFecha.format(periodoOtrosCal.getTime()); 
		}catch ( Exception e ){
			periodoOtros = new Date();
		}
		return primerDiaMes;
	}
	

	protected String getUltimoDiaMes (  ){
		Date periodoOtros = new Date();
		Calendar periodoOtrosCal = Calendar.getInstance();
		SimpleDateFormat fmtPeriodo = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat fmtFecha = new SimpleDateFormat("yyyy-MM-dd");
		String ultimoDiaMes = "";
		try{
			String periodo = null;
			
		
			periodoOtros = fmtPeriodo.parse(periodo);
			periodoOtrosCal.setTime(periodoOtros);
			periodoOtrosCal.set(Calendar.DAY_OF_MONTH, 30);
			ultimoDiaMes = fmtFecha.format(periodoOtrosCal.getTime()); 
		}catch ( Exception e ){
			periodoOtros = new Date();
		}
		return ultimoDiaMes;
	}
	 
}

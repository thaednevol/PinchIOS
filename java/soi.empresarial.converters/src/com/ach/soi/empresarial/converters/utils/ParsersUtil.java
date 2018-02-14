package com.ach.soi.empresarial.converters.utils;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import com.ach.soi.empresarial.converters.core.DatosComplementarios1747Reader;
import com.ach.soi.empresarial.converters.model.CommonBean;
import com.ach.soi.empresarial.converters.model.beans1747.DatosComplementarios1747;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadPensTp01;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadTp01;
import com.ach.soi.empresarial.converters.model.beans2388.read.Reg2388ReadTp02;

public class ParsersUtil {

	
	private DatosComplementarios1747Reader datosComplementarios = null;
	
	public ParsersUtil ( DatosComplementarios1747Reader datosComplementarios ){
		this.datosComplementarios = datosComplementarios;
	}
	
	public ParsersUtil ( ){
		
	}
	
	public static boolean tieneNovedadesAusentismo ( Reg2388ReadTp02 regTp2 ){
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
		if ( regTp2.getIrl()!=null && regTp2.getIrl().equals("X") ){
			return true;
		}
		return false;
	}
	
	
	public static String getPrimerDiaMes ( CommonBean regTp01 ){
		//R06 - Si se reporta una novedad de ING (campo 15 con �X) se deber� completar el campo con el primer d�a del mes del periodo otros sistemas (campo 15 registro tipo 1).
		Date periodoOtros = new Date();
		Calendar periodoOtrosCal = Calendar.getInstance();
		SimpleDateFormat fmtPeriodo = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat fmtFecha = new SimpleDateFormat("yyyy-MM-dd");
		String primerDiaMes = "";
		try{
			String periodo = null;
			if ( regTp01 instanceof Reg2388ReadTp01 ){
				periodo = ((Reg2388ReadTp01)regTp01).getPeriodoPagoNoSalud();
			}
			else if( regTp01 instanceof Reg2388ReadPensTp01 ){
				periodo = ((Reg2388ReadPensTp01)regTp01).getPeriodoPagoNoSalud();
			}else{
				periodo = "2000-01";
			}
			
			periodoOtros = fmtPeriodo.parse(periodo);
			periodoOtrosCal.setTime(periodoOtros);
			periodoOtrosCal.set(Calendar.DAY_OF_MONTH, 1);
			primerDiaMes = fmtFecha.format(periodoOtrosCal.getTime()); 
		}catch ( Exception e ){
			periodoOtros = new Date();
		}
		return primerDiaMes;
	}
	

	public static String getUltimoDiaMes ( CommonBean regTp01 ){
		Date periodoOtros = new Date();
		Calendar periodoOtrosCal = Calendar.getInstance();
		SimpleDateFormat fmtPeriodo = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat fmtFecha = new SimpleDateFormat("yyyy-MM-dd");
		String ultimoDiaMes = "";
		try{
			String periodo = null;
			if ( regTp01 instanceof Reg2388ReadTp01 ){
				periodo = ((Reg2388ReadTp01)regTp01).getPeriodoPagoNoSalud();
			}
			else{
				periodo = ((Reg2388ReadPensTp01)regTp01).getPeriodoPagoNoSalud();
			}
			
			periodoOtros = fmtPeriodo.parse(periodo);
			periodoOtrosCal.setTime(periodoOtros);
			periodoOtrosCal.set(Calendar.DAY_OF_MONTH, periodoOtrosCal.getActualMaximum(Calendar.DAY_OF_MONTH));
			ultimoDiaMes = fmtFecha.format(periodoOtrosCal.getTime()); 
		}catch ( Exception e ){
			periodoOtros = new Date();
		}
		return ultimoDiaMes;
	}
	

	public Collection<Reg2388ReadTp02> generarMultiRegistrosNovedadAusentismo ( Reg2388ReadTp02 regTp02Original, CommonBean regTp01) throws Exception{		
		Collection<Reg2388ReadTp02> regsGenerados = new ArrayList<Reg2388ReadTp02>();
		Collection<Reg2388ReadTp02> resultado = new ArrayList<Reg2388ReadTp02>();
		
		String primerDiaMes = getPrimerDiaMes(regTp01);
		String ultimoDiaMes = getUltimoDiaMes(regTp01);
		
		if ( regTp02Original.getDiasSalud().equals("1")||
				regTp02Original.getDiasPension().equals("1")||
				regTp02Original.getDiasRiesgo().equals("1")||
				regTp02Original.getDiasCcf().equals("1")){
			//No hay dias suficientes para generar registro de dias laborados.
			regsGenerados.add(regTp02Original);
			return regsGenerados;
		}
		
		Reg2388ReadTp02 regDiasLaborados = regTp02Original.clone();
		regDiasLaborados.limpiarNovedadesAusentismo();		
		
		if ( regTp02Original.getIge()!=null && regTp02Original.getIge().equals("X") ){
			Reg2388ReadTp02 regIge = regTp02Original.clone();
			regIge.limpiarNovedades();
			regIge.setIge("X");
			regIge.setFechaInicioIge(primerDiaMes);
			regIge.setFechaFinIge(ultimoDiaMes);
			regsGenerados.add(regIge);
		}
		if ( regTp02Original.getVac()!=null && regTp02Original.getVac().equals("X") ){
			Reg2388ReadTp02 regVac = regTp02Original.clone();
			regVac.limpiarNovedades();
			regVac.setVac("X");
			regVac.setFechaInicioVac(primerDiaMes);
			regVac.setFechaFinVac(ultimoDiaMes);
			regsGenerados.add(regVac);
		}
		if ( regTp02Original.getLma()!=null && regTp02Original.getLma().equals("X") ){
			Reg2388ReadTp02 regLma = regTp02Original.clone();
			regLma.limpiarNovedades();
			regLma.setLma("X");
			regLma.setFechaInicioLma(primerDiaMes);
			regLma.setFechaFinLma(ultimoDiaMes);
			regsGenerados.add(regLma);
		}
		if ( regTp02Original.getSln()!=null && regTp02Original.getSln().equals("X") ){
			Reg2388ReadTp02 regSln = regTp02Original.clone();
			regSln.limpiarNovedades();
			regSln.setSln("X");
			regSln.setFechaInicioSln(primerDiaMes);
			regSln.setFechaFinSln(ultimoDiaMes);
			regsGenerados.add(regSln);
		}
		if ( regTp02Original.getIrl()!=null && !regTp02Original.getIrl().trim().equals("00") ){
			Reg2388ReadTp02 regIrl = regTp02Original.clone();
			regIrl.limpiarNovedades();
			regIrl.setIrl(regTp02Original.getIrl());
			regIrl.setFechaInicioIrl(primerDiaMes);
			regIrl.setFechaFinIrl(ultimoDiaMes);
			regsGenerados.add(regIrl);
		}
		int cantidadNovedades = regsGenerados.size()+1; //Toma en cuenta el registro de dias laborados para el calculo		
		for ( Reg2388ReadTp02 tp2:regsGenerados ){
			if ( datosComplementarios!=null ){
				this.incluirDatosComplementarios(datosComplementarios, tp2);
			}
			else{
				tp2.dividirAportesPorNovedades(cantidadNovedades);
			}
		}	
		if ( datosComplementarios!=null ){
			this.incluirDatosComplementarios(datosComplementarios, regDiasLaborados);
			ajustarRegistroDiasLabConDatosComplem(regsGenerados, regDiasLaborados,datosComplementarios);			
		}
		else{
			regDiasLaborados.dividirAportesPorNovedades(cantidadNovedades);
			ajustarRegistroDiasLab(regsGenerados, regDiasLaborados, regTp02Original);
		}		
		resultado.add(regDiasLaborados);
		//Con el fin de reordenarlos
		for ( Reg2388ReadTp02 reg:regsGenerados ){
			resultado.add(reg);
		}		
		return resultado;
	}
	
	
	private boolean isNovedadMarcada ( String nov ){
		return nov!=null&nov.equals("X");
	}

	private void incluirDatosComplementarios ( 	DatosComplementarios1747Reader datosComplementarios, 
												Reg2388ReadTp02 regTp2 ) throws Exception{
		StringBuilder key = new StringBuilder();
		key.append(regTp2.getTipoDocumentoCotizante()).append(":");
		key.append(regTp2.getNumeroDocumentoCotizante());
		String novedad = null;
		
		boolean regIge = false;
		boolean regVac = false;
		boolean regLma = false;
		boolean regSln = false;
		boolean regIrl = false;

		if ( isNovedadMarcada(regTp2.getIge()) ){
			novedad = "IGE";
			regIge = true;
		}
		if ( isNovedadMarcada(regTp2.getVac()) ){
			novedad = "VAC";
			regVac = true;
		}
		if ( isNovedadMarcada(regTp2.getLma()) ){
			novedad = "LMA";
			regLma = true;
		}
		if ( isNovedadMarcada(regTp2.getSln()) ){
			novedad = "SLN";
			regSln = true;
		}
		if ( isNovedadMarcada(regTp2.getIrl()) ){
			novedad = "IRL";
			regIrl = true;
		}
		
		if ( novedad!=null ){
			key.append(":").append(novedad);
		}
		
		DatosComplementarios1747 datos = datosComplementarios.getDatosComplementarios(key.toString());
		if ( datos==null ){
			return;
		}
		
		if ( datos.getIbcNovedad()!=null && datos.getIbcNovedad().length()>1 ){
			regTp2.setIbcCcf(datos.getIbcNovedad());
			regTp2.setIbcOtrosParafiscales(datos.getIbcNovedad());
			regTp2.setIbcPension(datos.getIbcNovedad());
			regTp2.setIbcRiesgo(datos.getIbcNovedad());
			regTp2.setIbcSalud(datos.getIbcNovedad());
		}
		if ( datos.getDiasNovedad()!=null && !datos.getDiasNovedad().trim().equals("") ){
			regTp2.setDiasCcf(datos.getDiasNovedad());
			regTp2.setDiasPension(datos.getDiasNovedad());
			regTp2.setDiasRiesgo(datos.getDiasNovedad());
			regTp2.setDiasSalud(datos.getDiasNovedad());						
		}
		if ( datos.getClaseRiesgo()!=null && !datos.getClaseRiesgo().trim().equals("") ){
			regTp2.setClaseRiesgoAfiliado(datos.getClaseRiesgo());
		}
		if ( datos.getCodigoArl()!=null && !datos.getCodigoArl().trim().equals("") ){
			regTp2.setCodigoArlAfiliado(datos.getCodigoArl());
		}
		if ( datos.getFechaDesde()!=null && !datos.getFechaDesde().trim().equals("") ){
			if ( regIge ){
				regTp2.setFechaInicioIge(datos.getFechaDesde());
			}
			else if( regIrl ){
				regTp2.setFechaInicioIrl(datos.getFechaDesde());
			}
			else if( regVac ){
				regTp2.setFechaInicioVac(datos.getFechaDesde());
			}
			else if( regSln ){
				regTp2.setFechaInicioSln(datos.getFechaDesde());
			}
			else if( regLma ){
				regTp2.setFechaInicioLma(datos.getFechaDesde());
			}
		}
		if ( datos.getFechaHasta()!=null && !datos.getFechaHasta().trim().equals("") ){
			if ( regIge ){
				regTp2.setFechaFinIge(datos.getFechaHasta());
			}
			else if( regIrl ){
				regTp2.setFechaFinIrl(datos.getFechaHasta());
			}
			else if( regVac ){
				regTp2.setFechaFinVac(datos.getFechaHasta());
			}
			else if( regSln ){
				regTp2.setFechaFinSln(datos.getFechaHasta());
			}
			else if( regLma ){
				regTp2.setFechaFinLma(datos.getFechaHasta());
			}
		}
		if ( datos.getHorasLaboradas()!=null && !datos.getHorasLaboradas().trim().equals("") ){
			regTp2.setNumeroHorasLaboradas(datos.getHorasLaboradas());
		}
		if ( datos.getIndTarifaEspecialPens()!=null&&!datos.getIndTarifaEspecialPens().trim().equals("") ){
			regTp2.setTarifaEspecialPensiones(datos.getIndTarifaEspecialPens());
		}
	}
	
	
	private static boolean isNull ( String val ){
		return val==null || val.trim().equals("");
	}
	
	private void ajustarRegistroDiasLabConDatosComplem ( Collection<Reg2388ReadTp02> registrosGenerados, Reg2388ReadTp02 registroDl,DatosComplementarios1747Reader datosComplementarios ){
		Collection<String> ibcsEps = new ArrayList<String>();
		Long sumaIbcsEps = 0l;
		Long sumaDiasEps = 0l;
		Long sumaIbcsAfp = 0l;
		Long sumaDiasAfp = 0l;
		Long sumaIbcsArl = 0l;
		Long sumaDiasArl = 0l;
		Long sumaIbcsCcf = 0l;
		Long sumaDiasCcf = 0l;
		Long sumaIbcsOtrosPf = 0l;
		
		Long ibcEpsDl = 0l;
		Long diasEpsDl = 0l;
		Long ibcAfpDl = 0l;
		Long diaAfpDl = 0l;
		Long ibcArlDl = 0l;
		Long diaArldl = 0l;
		Long ibcCcfDl = 0l;
		Long diaCcfDl = 0l;
		Long ibcOtrosPfDl = 0l;
		
		Collection<String> diasEps = new ArrayList<String>();		
		Collection<String> ibcsAfp = new ArrayList<String>();
		Collection<String> diasAfp = new ArrayList<String>();		
		Collection<String> ibcsArl = new ArrayList<String>();
		Collection<String> diasArl = new ArrayList<String>();		
		Collection<String> ibcsCcf = new ArrayList<String>();
		Collection<String> diasCcf = new ArrayList<String>();		
		Collection<String> ibcsOtrosPf = new ArrayList<String>();
		
		for ( Reg2388ReadTp02 tp02:registrosGenerados ){
			ibcsEps.add(tp02.getIbcSalud());						
			ibcsAfp.add(tp02.getIbcPension());
			ibcsArl.add(tp02.getIbcRiesgo());
			ibcsCcf.add(tp02.getIbcCcf());
			ibcsOtrosPf.add(tp02.getIbcOtrosParafiscales());
			
			diasEps.add(tp02.getDiasSalud());
			diasAfp.add(tp02.getDiasPension());
			diasArl.add(tp02.getDiasRiesgo());
			diasCcf.add(tp02.getDiasCcf());
		}
		
		sumaIbcsAfp = this.getSumaValoresString(ibcsAfp);
		ibcAfpDl = this.getValorLong(registroDl.getIbcPension());
		registroDl.setIbcPension((ibcAfpDl-sumaIbcsAfp)+"");
		
		sumaIbcsArl = this.getSumaValoresString(ibcsArl);		
		ibcArlDl = this.getValorLong(registroDl.getIbcRiesgo());
		registroDl.setIbcRiesgo((ibcArlDl-sumaIbcsArl)+"");
		
		sumaIbcsCcf = this.getSumaValoresString(ibcsCcf);
		ibcCcfDl = this.getValorLong(registroDl.getIbcCcf());
		registroDl.setIbcCcf((ibcCcfDl-sumaIbcsCcf)+"");
		
		sumaIbcsEps = this.getSumaValoresString(ibcsEps);
		ibcEpsDl = this.getValorLong(registroDl.getIbcSalud());
		registroDl.setIbcSalud((ibcEpsDl-sumaIbcsEps)+"");
		
		sumaIbcsOtrosPf = this.getSumaValoresString(ibcsOtrosPf);
		ibcOtrosPfDl = this.getValorLong(registroDl.getIbcOtrosParafiscales());
		registroDl.setIbcOtrosParafiscales((ibcOtrosPfDl-sumaIbcsOtrosPf)+"");
		
		sumaDiasAfp = this.getSumaValoresString(diasAfp);
		diaAfpDl = this.getValorLong(registroDl.getDiasPension());
		registroDl.setDiasPension((diaAfpDl-sumaDiasAfp)+"");
		
		sumaDiasArl = this.getSumaValoresString(diasArl);
		diaArldl = this.getValorLong(registroDl.getDiasRiesgo());
		registroDl.setDiasRiesgo((diaArldl-sumaDiasArl)+"");
		
		sumaDiasCcf = this.getSumaValoresString(diasCcf);
		diaCcfDl = this.getValorLong(registroDl.getDiasCcf());
		registroDl.setDiasCcf((diaCcfDl-sumaDiasCcf)+"");
		
		sumaDiasEps = this.getSumaValoresString(diasEps);
		diasEpsDl = this.getValorLong(registroDl.getDiasSalud());
		registroDl.setDiasSalud((diasEpsDl-sumaDiasEps)+"");		
	}
	
	private Long getValorLong ( String valStr ){
		Long val = null;
		try{
			val = Long.valueOf(valStr);
		}catch ( NumberFormatException e ){
			val = 0l;
		}
		return val;
	}
	
	private Long getSumaValoresString ( Collection<String> vals ){
		Long val = null;
		Long result = 0l;
		for ( String v:vals ){
			try{
				val = Long.valueOf(v);
			}catch ( NumberFormatException e ){
				val = 0l;
			}
			result += val;
		}
		return result;
	}
	
	private void ajustarRegistroDiasLab ( Collection<Reg2388ReadTp02> registrosGenerados, Reg2388ReadTp02 registroDl, Reg2388ReadTp02 registroOriginal ){
		int cantidadNovedades = registrosGenerados.size()+1;
		
		String valorEsperado = null;
		Long diferencia = null;
		
		if ( !isNull(registroDl.getIbcSalud()) ){
			valorEsperado = multiplicarValoresString(registroDl.getIbcSalud(), cantidadNovedades);
			diferencia = calcularDiferencia(valorEsperado,registroOriginal.getIbcSalud());
			if ( diferencia.longValue()!=0 ){
				registroDl.setIbcSalud(sumarDiferencia(registroDl.getIbcSalud(), diferencia));
			}
		}
		
		if ( !isNull(registroDl.getIbcRiesgo()) ){
			valorEsperado = multiplicarValoresString(registroDl.getIbcRiesgo(), cantidadNovedades);
			diferencia = calcularDiferencia(valorEsperado,registroOriginal.getIbcRiesgo());
			if ( diferencia.longValue()!=0 ){
				registroDl.setIbcRiesgo(sumarDiferencia(registroDl.getIbcRiesgo(), diferencia));
			}
		}
		if ( !isNull(registroDl.getIbcPension()) ){
			valorEsperado = multiplicarValoresString(registroDl.getIbcPension(), cantidadNovedades);
			diferencia = calcularDiferencia(valorEsperado,registroOriginal.getIbcPension());
			if ( diferencia.longValue()!=0 ){
				registroDl.setIbcPension(sumarDiferencia(registroDl.getIbcPension(), diferencia));
			}
		}
		if ( !isNull(registroDl.getIbcOtrosParafiscales()) ){
			valorEsperado = multiplicarValoresString(registroDl.getIbcOtrosParafiscales(), cantidadNovedades);
			diferencia = calcularDiferencia(valorEsperado,registroOriginal.getIbcOtrosParafiscales());
			if ( diferencia.longValue()!=0 ){
				registroDl.setIbcOtrosParafiscales(sumarDiferencia(registroDl.getIbcOtrosParafiscales(), diferencia));
			}
		}
		if ( !isNull(registroDl.getIbcCcf()) ){
			valorEsperado = multiplicarValoresString(registroDl.getIbcCcf(), cantidadNovedades);
			diferencia = calcularDiferencia(valorEsperado,registroOriginal.getIbcCcf());
			if ( diferencia.longValue()!=0 ){
				registroDl.setIbcCcf(sumarDiferencia(registroDl.getIbcCcf(), diferencia));
			}
		}
		if ( !isNull(registroDl.getDiasCcf()) ){
			valorEsperado = multiplicarValoresString(registroDl.getDiasCcf(), cantidadNovedades);
			diferencia = calcularDiferencia(valorEsperado,registroOriginal.getDiasCcf());
			if ( diferencia.longValue()!=0 ){
				registroDl.setDiasCcf(sumarDiferencia(registroDl.getDiasCcf(), diferencia));
			}
		}
		if ( !isNull(registroDl.getDiasPension()) ){
			valorEsperado = multiplicarValoresString(registroDl.getDiasPension(), cantidadNovedades);
			diferencia = calcularDiferencia(valorEsperado,registroOriginal.getDiasPension());
			if ( diferencia.longValue()!=0 ){
				registroDl.setDiasPension(sumarDiferencia(registroDl.getDiasPension(), diferencia));
			}
		}
		if ( !isNull(registroDl.getDiasRiesgo()) ){
			valorEsperado = multiplicarValoresString(registroDl.getDiasRiesgo(), cantidadNovedades);
			diferencia = calcularDiferencia(valorEsperado,registroOriginal.getDiasRiesgo());
			if ( diferencia.longValue()!=0 ){
				registroDl.setDiasRiesgo(sumarDiferencia(registroDl.getDiasRiesgo(), diferencia));
			}
		}
		if ( !isNull(registroDl.getDiasSalud()) ){
			valorEsperado = multiplicarValoresString(registroDl.getDiasSalud(), cantidadNovedades);
			diferencia = calcularDiferencia(valorEsperado,registroOriginal.getDiasSalud());
			if ( diferencia.longValue()!=0 ){
				registroDl.setDiasSalud(sumarDiferencia(registroDl.getDiasSalud(), diferencia));
			}
		}
		if ( !isNull(registroDl.getAporteFspSolidaridad()) ){
			valorEsperado = multiplicarValoresString(registroDl.getAporteFspSolidaridad(), cantidadNovedades);
			diferencia = calcularDiferencia(valorEsperado,registroOriginal.getAporteFspSolidaridad());
			if ( diferencia.longValue()!=0 ){
				registroDl.setAporteFspSolidaridad(sumarDiferencia(registroDl.getAporteFspSolidaridad(), diferencia));
			}
		}
		if ( !isNull(registroDl.getAporteFspSubsistencia()) ){
			valorEsperado = multiplicarValoresString(registroDl.getAporteFspSubsistencia(), cantidadNovedades);
			diferencia = calcularDiferencia(valorEsperado,registroOriginal.getAporteFspSubsistencia());
			if ( diferencia.longValue()!=0 ){
				registroDl.setAporteFspSubsistencia(sumarDiferencia(registroDl.getAporteFspSubsistencia(), diferencia));
			}
		}
		if ( !isNull(registroDl.getValorAporteCcf()) ){
			valorEsperado = multiplicarValoresString(registroDl.getValorAporteCcf(), cantidadNovedades);
			diferencia = calcularDiferencia(valorEsperado,registroOriginal.getValorAporteCcf());
			if ( diferencia.longValue()!=0 ){
				registroDl.setValorAporteCcf(sumarDiferencia(registroDl.getValorAporteCcf(), diferencia));
			}
		}
		if ( !isNull(registroDl.getValorAporteEsap()) ){
			valorEsperado = multiplicarValoresString(registroDl.getValorAporteEsap(), cantidadNovedades);
			diferencia = calcularDiferencia(valorEsperado,registroOriginal.getValorAporteEsap());
			if ( diferencia.longValue()!=0 ){
				registroDl.setValorAporteEsap(sumarDiferencia(registroDl.getValorAporteEsap(), diferencia));
			}
		}
		if ( !isNull(registroDl.getValorAporteIcbf()) ){
			valorEsperado = multiplicarValoresString(registroDl.getValorAporteIcbf(), cantidadNovedades);
			diferencia = calcularDiferencia(valorEsperado,registroOriginal.getValorAporteIcbf());
			if ( diferencia.longValue()!=0 ){
				registroDl.setValorAporteIcbf(sumarDiferencia(registroDl.getValorAporteIcbf(), diferencia));
			}		
		}
		if ( !isNull(registroDl.getValorAporteMen()) ){
			valorEsperado = multiplicarValoresString(registroDl.getValorAporteMen(), cantidadNovedades);
			diferencia = calcularDiferencia(valorEsperado,registroOriginal.getValorAporteMen());
			if ( diferencia.longValue()!=0 ){
				registroDl.setValorAporteMen(sumarDiferencia(registroDl.getValorAporteMen(), diferencia));
			}
		}
		if ( !isNull(registroDl.getValorAporteSena()) ){
			valorEsperado = multiplicarValoresString(registroDl.getValorAporteSena(), cantidadNovedades);
			diferencia = calcularDiferencia(valorEsperado,registroOriginal.getValorAporteSena());
			if ( diferencia.longValue()!=0 ){
				registroDl.setValorAporteSena(sumarDiferencia(registroDl.getValorAporteSena(), diferencia));
			}
		}
		if ( !isNull(registroDl.getCotizacionOblgPension()) ){
			valorEsperado = multiplicarValoresString(registroDl.getCotizacionOblgPension(), cantidadNovedades);
			diferencia = calcularDiferencia(valorEsperado,registroOriginal.getCotizacionOblgPension());
			if ( diferencia.longValue()!=0 ){
				registroDl.setCotizacionOblgPension(sumarDiferencia(registroDl.getCotizacionOblgPension(), diferencia));
			}
		}
		if ( !isNull(registroDl.getCotizacionObligatoriaArl()) ){
			valorEsperado = multiplicarValoresString(registroDl.getCotizacionObligatoriaArl(), cantidadNovedades);
			diferencia = calcularDiferencia(valorEsperado,registroOriginal.getCotizacionObligatoriaArl());
			if ( diferencia.longValue()!=0 ){
				registroDl.setCotizacionObligatoriaArl(sumarDiferencia(registroDl.getCotizacionObligatoriaArl(), diferencia));
			}
		}
		if ( !isNull(registroDl.getCotizacionObligatoriaSalud()) ){
			valorEsperado = multiplicarValoresString(registroDl.getCotizacionObligatoriaSalud(), cantidadNovedades);
			diferencia = calcularDiferencia(valorEsperado,registroOriginal.getCotizacionObligatoriaSalud());
			if ( diferencia.longValue()!=0 ){
				registroDl.setCotizacionObligatoriaSalud(sumarDiferencia(registroDl.getCotizacionObligatoriaSalud(), diferencia));
			}
		}
	}

	private static Long dividirValoresString ( String val,int divisor ){
		try{
			Long valor = Long.valueOf(val);
			Long res = valor/divisor;
			return res;
		}catch ( Exception e ){
			return Long.valueOf(val);
		}
	}
	
	private static  String multiplicarValoresString ( String val,int multiplicador ){
		try{
			Long valor = Long.valueOf(val);
			Long res = valor*multiplicador;
			return res.toString();
		}catch ( Exception e ){
			return val;
		}
	}
	

	private static  Long calcularDiferencia ( String val,String value2){
		try{
			Long valor = Long.valueOf(val.trim());
			Long valor1 = Long.valueOf(value2.trim());
			Long res = valor1-valor;
			return res;
		}catch ( Exception e ){
			return Long.valueOf(val);
		}
	}
	
	
	private static  String sumarDiferencia ( String val,Long value2){
		try{
			Long valor = Long.valueOf(val);
			Long res = valor+value2;
			return res.toString();
		}catch ( Exception e ){
			return val;
		}
	}
	
	
	public static String getPrimerDiaMes ( Calendar periodo ){
		SimpleDateFormat fmtFecha = new SimpleDateFormat("yyyy-MM-dd");
		String ultimoDiaMes = "";
		Calendar periodoCal = Calendar.getInstance();
		try{
			periodoCal.setTime(periodo.getTime());
			periodoCal.set(Calendar.DAY_OF_MONTH, 1);
			ultimoDiaMes = fmtFecha.format(periodoCal.getTime()); 
		}catch ( Exception e ){
			periodoCal = Calendar.getInstance();
			ultimoDiaMes = fmtFecha.format(periodoCal.getTime());
		}
		return ultimoDiaMes;
	}
	

	public static String getUltimoDiaMes ( Calendar periodo ){
		SimpleDateFormat fmtFecha = new SimpleDateFormat("yyyy-MM-dd");
		String ultimoDiaMes = "";
		Calendar periodoCal = Calendar.getInstance();
		try{
			periodoCal.setTime(periodo.getTime());
			periodoCal.set(Calendar.DAY_OF_MONTH, 30);
			ultimoDiaMes = fmtFecha.format(periodoCal.getTime()); 
		}catch ( Exception e ){
			periodoCal = Calendar.getInstance();
			ultimoDiaMes = fmtFecha.format(periodoCal.getTime());
		}
		return ultimoDiaMes;
	}
	
	
	public static void completarConvertirTp02 ( Reg2388ReadTp01 regTp01, Reg2388ReadTp02 regTp02 ){
		
		
		regTp02.setPrimerNombre(regTp02.getPrimerNombre().replace("�", "N"));
		regTp02.setPrimerApellido(regTp02.getPrimerApellido().replace("�", "N"));
		if ( regTp02.getSegundoApellido()!=null ){
			regTp02.setSegundoApellido(regTp02.getSegundoApellido().replace("�", "N"));
		}
		
		if ( regTp02.getSegundoNombre()!=null ){
			regTp02.setSegundoNombre(regTp02.getSegundoNombre().replace("�", "N"));
		}
		
		String primerDiaMes = getPrimerDiaMes(regTp01); 
		String ultimoDiaMes = getUltimoDiaMes(regTp01); 
		//R01
		if ( regTp02.getTipoCotizante()!=null && regTp02.getTipoCotizante().equals("40") ){
			if ( isNull(regTp02.getTipoDocumentoCotizante()) ){
				regTp02.setTipoDocCotizantePpal(regTp02.getTipoDocumentoCotizante());
			}
			if ( isNull(regTp02.getNumeroDocumentoCotizante()) ){
				regTp02.setNumeroDocCotizantePpal(regTp02.getNumeroDocumentoCotizante());
			}
		}
		else{
			regTp02.setTipoDocCotizantePpal("");
			regTp02.setNumeroDocCotizantePpal("");
		}
		
		//R02 - Cuando el valor del campo 43 � IBC Salud sea superior a 10 SMLMV este campo debe ser N
		Long smmlv10 = Long.valueOf("700000");
		Long valueIbcSalud = 0l;
		try{
			valueIbcSalud = Long.valueOf(regTp02.getIbcSalud());
		}catch ( Exception e ){
			valueIbcSalud = 0l;
		}
		if ( regTp02.getCotizanteLey1607()==null || regTp02.getCotizanteLey1607().trim().equals("") && isNull(regTp02.getCotizanteLey1607()) ){
			if ( valueIbcSalud > smmlv10){
				regTp02.setCotizanteLey1607("N");
			}
			else{
				regTp02.setCotizanteLey1607("S");
			}
		}
		
		//R03 - Lo suministra el aportante.
		//Para el caso de cotizantes diferente al cotizante 3 � independiente, se debe registrar el valor ingresado en el campo 14 del registro tipo 1 del archivo tipo 2.
		//Se deja en blanco cuando no sea obligatorio para el cotizante estar afiliado a una administradora de Riesgo Laborales
		if ( isNull(regTp02.getCodigoArlAfiliado()) && regTp02.getTipoCotizante()!=null && !regTp02.getTipoCotizante().equals("3") && regTp01!=null){
			regTp02.setCodigoArlAfiliado(regTp01.getCodigoArl());
		}
		
		
		/*R04
		 * Determinar con la tarifa de riesgo:
			1. Clase de riesgo I
			2. Clase de riesgo II
			3. Clase de riesgo III
			4. Clase de riesgo IV
			5. Clase de riesgo V
		 * 
		 */
		if ( regTp02.getClaseRiesgoAfiliado()==null||regTp02.getClaseRiesgoAfiliado().trim().equals("") ){
			if ( regTp02.getTarifaArl()!=null ){
				if ( regTp02.getTarifaArl().toString().equals(".0052200") ){
					regTp02.setClaseRiesgoAfiliado("1");
				}else if ( regTp02.getTarifaArl().toString().equals(".0104400") ){
					regTp02.setClaseRiesgoAfiliado("2");
				}else if ( regTp02.getTarifaArl().toString().equals(".0243600") ){
					regTp02.setClaseRiesgoAfiliado("3");
				}else if ( regTp02.getTarifaArl().toString().equals(".0435000") ){
					regTp02.setClaseRiesgoAfiliado("4");
				}else if ( regTp02.getTarifaArl().toString().equals(".0696000") ){
					regTp02.setClaseRiesgoAfiliado("5");
				}
			}
		}
		
		//R05 - Blanco Tarifa normal
		if ( regTp02.getTarifaEspecialPensiones()==null ){
			regTp02.setTarifaEspecialPensiones(" ");
		}
		
		if ( regTp02.getIng()!=null&&regTp02.getIng().equals("X") ){
			if ( isNull(regTp02.getFechaIngreso()) ){
				regTp02.setFechaIngreso(primerDiaMes);
			}
		}
		else{
			regTp02.setFechaIngreso("");
		}
		
		if ( regTp02.getRet()!=null&&regTp02.getRet().equals("X") ){
			if ( isNull(regTp02.getFechaRetiro()) ){
				regTp02.setFechaRetiro(ultimoDiaMes);
			}
		}
		else{
			regTp02.setFechaRetiro("");
		}
		
		if ( regTp02.getVsp()!=null&&regTp02.getVsp().equals("X") ){			
			regTp02.setFechaInicioVsp(primerDiaMes);		
		}
		else{
			regTp02.setFechaInicioVsp("");
		}
		
		if ( regTp02.getSln()!=null&&regTp02.getSln().equals("X") ){
			if ( isNull(regTp02.getFechaInicioSln()) ){
				regTp02.setFechaInicioSln(primerDiaMes);
			}
			if ( isNull(regTp02.getFechaFinSln()) ){
				regTp02.setFechaFinSln(ultimoDiaMes);
			}
		}
		else{
			regTp02.setFechaInicioSln("");		
			regTp02.setFechaFinSln("");
		}
		if ( regTp02.getIge()!=null&&regTp02.getIge().equals("X") ){
			if ( isNull(regTp02.getFechaInicioIge()) ){
				regTp02.setFechaInicioIge(primerDiaMes);
			}
			if ( isNull(regTp02.getFechaFinIge()) ){
				regTp02.setFechaFinIge(ultimoDiaMes);
			}
		}
		else{
			regTp02.setFechaInicioIge("");		
			regTp02.setFechaFinIge("");
		}
		
		if ( regTp02.getSln()!=null&&regTp02.getSln().equals("X") ){
			if ( isNull(regTp02.getFechaInicioSln()) ){
				regTp02.setFechaInicioSln(primerDiaMes);
			}
			if ( isNull(regTp02.getFechaFinSln()) ){
				regTp02.setFechaFinSln(ultimoDiaMes);
			}
		}
		else{
			regTp02.setFechaInicioSln("");		
			regTp02.setFechaFinSln("");
		}
		
		if ( regTp02.getLma()!=null&&regTp02.getLma().equals("X") ){
			if ( isNull(regTp02.getFechaInicioLma()) ){
				regTp02.setFechaInicioLma(primerDiaMes);
			}
			if ( isNull(regTp02.getFechaFinLma()) ){
				regTp02.setFechaFinLma(ultimoDiaMes);
			}
		}
		else{
			regTp02.setFechaInicioLma("");		
			regTp02.setFechaFinLma("");
		}
		
		if ( regTp02.getVac()!=null&&regTp02.getVac().equals("X") ){
			if ( isNull(regTp02.getFechaInicioVac()) ){
				regTp02.setFechaInicioVac(primerDiaMes);
			}
			if ( isNull(regTp02.getFechaFinVac()) ){
				regTp02.setFechaFinVac(ultimoDiaMes);
			}
		}
		else{
			regTp02.setFechaInicioVac("");		
			regTp02.setFechaFinVac("");
		}
		
		if ( regTp02.getVct()!=null&&regTp02.getVct().equals("X") ){
			if ( isNull(regTp02.getFechaInicioVct()) ){
				regTp02.setFechaInicioVct(primerDiaMes);
			}
			if ( isNull(regTp02.getFechaFinVct()) ){
				regTp02.setFechaFinVct(ultimoDiaMes);
			}
		}
		else{
			regTp02.setFechaInicioVct("");		
			regTp02.setFechaFinVct("");
		}
		
		if ( regTp02.getIrl()!=null&&regTp02.getIrl().equals("X") ){
			if ( isNull(regTp02.getFechaInicioIrl()) ){
				regTp02.setFechaInicioIrl(primerDiaMes);
			}
			if ( isNull(regTp02.getFechaFinIrl()) ){
				regTp02.setFechaFinIrl(ultimoDiaMes);
			}
		}
		else{
			regTp02.setFechaInicioIrl("");		
			regTp02.setFechaFinIrl("");
		}
		
		if ( isNull(regTp02.getIbcOtrosParafiscales()) ){
			regTp02.setIbcOtrosParafiscales("0");
			if ( regTp02.getCodigoAdmCcf()!=null&&regTp02.getCodigoAdmCcf().length()>2 ){
				regTp02.setIbcOtrosParafiscales(regTp02.getIbcCcf());
			}
		}
		
		if ( isNull(regTp02.getNumeroHorasLaboradas()) ){
			regTp02.setNumeroHorasLaboradas("160");
		}
		if ( regTp02.getColombianoExterior()!=null && regTp02.getColombianoExterior().equals("X") ){
			regTp02.setFechaRadicacionExterior("2016-02-01");
		}
		else{
			regTp02.setFechaRadicacionExterior("");
		}
		
		
		
	}
	
	public static String replaceCharsNotUTF8 ( String original ){
		if ( original!=null ){
			try {
				if ( original.contains("�") ){
					return original.replaceAll("�",new String("Ñ".getBytes(Constants.GENERAL_ENCODING)));
				}				
			} catch (UnsupportedEncodingException e) {
				return original;
			}
		}
		return original;
	}

	
	

	
}

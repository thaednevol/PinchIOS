package com.ach.soi.empresarial.liquidacion.core;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import com.ach.arc.biz.r1747.util.ValidacionArchivoDataSource;
import com.ach.cfg.biz.cache.AdministradorasSingleton;
import com.ach.cfg.biz.model.AdministradoraVO;
import com.ach.cfg.biz.type.ParametrosType;
import com.ach.cfg.biz.type.TipoSubSistemasType;
import com.ach.pla.biz.mngr.totalizador.TotalizadorPlanillaMngr;
import com.ach.pla.biz.model.CfgMoraVO;
import com.ach.pla.biz.transfer.AplicadorMoraDesconectadoDTO;
import com.ach.pla.biz.transfer.PlanillaCotizanteDTO;
import com.ach.pla.biz.transfer.PlanillaTotalCajaCompensacionDTO;
import com.ach.pla.biz.transfer.PlanillaTotalEsapDTO;
import com.ach.pla.biz.transfer.PlanillaTotalIcbfDTO;
import com.ach.pla.biz.transfer.PlanillaTotalMinEducacionDTO;
import com.ach.pla.biz.transfer.PlanillaTotalParafiscalesDTO;
import com.ach.pla.biz.transfer.PlanillaTotalPensionDTO;
import com.ach.pla.biz.transfer.PlanillaTotalRiesgosProfesionalesDTO;
import com.ach.pla.biz.transfer.PlanillaTotalSaludDTO;
import com.ach.pla.biz.transfer.PlanillaTotalSenaDTO;
import com.ach.pla.biz.transfer.PlanillaTotalesDTO;
import com.ach.soi.empresarial.liquidacion.model.TotalesTO;
import com.ach.soi.empresarial.liquidacion.util.FormatValues;

public class TotalizadorActivos {

	
	private static TotalizadorActivos INSTANCE 				= null;
	//private PlanillaAportanteDTO encabezadoPlanilla 		= null;
	private Map<String,PlanillaCotizanteDTO> cotizantes 	= null;
	private TotalizadorPlanillaMngr totalizador 			= null;
	private ValidacionArchivoDataSource ds					= null;
	
	
	private TotalizadorActivos ( ValidacionArchivoDataSource ds ) throws Exception{
		//this.encabezadoPlanilla = encabezadoPlanilla;
		cotizantes = new HashMap<String,PlanillaCotizanteDTO>();
		this.ds = ds;
		AplicadorMoraDesconectadoDTO desconectado = this.buildAplicadorMoraDesconectado();
		totalizador = new TotalizadorPlanillaMngr(ds.getPlanillaApteDto(),desconectado);
	}

	
	public void resetInstance ( ValidacionArchivoDataSource ds ) throws Exception{
		INSTANCE = new TotalizadorActivos(ds);
	}
	
	public static TotalizadorActivos getInstance ( ValidacionArchivoDataSource ds ) throws Exception{
		if ( INSTANCE == null ){
			INSTANCE = new TotalizadorActivos(ds);
		}
		return INSTANCE;
	}
	

	public void eliminarCotizanteTotal ( String tpIdentificacion, String nroIdentific, int nroLinea ) throws Exception{
		String keyCotizante = nroLinea+"-"+tpIdentificacion+"-"+nroIdentific;
		if ( cotizantes.containsKey(keyCotizante) ){
			removeCotizanteDelTotal(nroLinea, keyCotizante);
		}		
	}
	
	public void totalizarCotizante ( PlanillaCotizanteDTO cotizante, int nroLinea ) throws Exception{
		String keyCotizante = nroLinea+"-"+cotizante.getCodTipoIdentificacion()+"-"+cotizante.getNroIdentificacion();
		if ( cotizantes.containsKey(keyCotizante) ){
			actualizarCotizante(cotizante, nroLinea, keyCotizante);
		}
		else{
			agregarCotizanteAlTotal(cotizante, nroLinea, keyCotizante);
		}
	}

	private void agregarCotizanteAlTotal ( PlanillaCotizanteDTO cotizante, int nroLinea, String keyCotizante ) throws Exception{
		this.agregarAdministradorasCotizante(cotizante);		
		this.cotizantes.put(keyCotizante,cotizante);
		totalizador.agregarCotizanteAlTotal(cotizante, false);
	}
	
	private void removeCotizanteDelTotal ( int nroLinea, String keyCotizante ) throws Exception{		
		PlanillaCotizanteDTO cotizante = this.cotizantes.get(keyCotizante);
		totalizador.restarCotizanteAlTotal(cotizante, false); 
		this.cotizantes.remove(keyCotizante);
	}
	
	private void actualizarCotizante ( PlanillaCotizanteDTO cotizante, int nroLinea, String keyCotizante ) throws Exception{
		this.removeCotizanteDelTotal(nroLinea,keyCotizante);
		this.agregarCotizanteAlTotal(cotizante, nroLinea,keyCotizante);		 
	}
	
	public TotalesTO getTotales ( ) throws Exception{
		TotalesTO res = this.buildTotales(totalizador.getPlanillaTotalesDTODesconectado(Calendar.getInstance()));
		return res;
	}
	

	public boolean existeCotizanteEnTotal ( String tpIdentificacion, String nroIdentific, int nroLinea ){
		String keyCotizante = nroLinea+"-"+tpIdentificacion+"-"+nroIdentific;
		return this.cotizantes.containsKey(keyCotizante);
	}
	
	
	private void agregarAdministradorasCotizante ( PlanillaCotizanteDTO dto ){
		AdministradoraVO eps = null;
		if ( dto.getCodigoAdmSalud()!=null ){
			eps = this.ds.getAdministradoraAFPoEPSPorCodigo(dto.getCodigoAdmSalud());
		}
		AdministradoraVO afp = null;
		if ( dto.getCodigoAdmPension()!=null ){
			afp = this.ds.getAdministradoraAFPoEPSPorCodigo(dto.getCodigoAdmPension());
		}
		AdministradoraVO arl = null;
		AdministradoraVO ccf = null;
		for ( AdministradoraVO adm:this.ds.getAdministradorasRiesgoYCcf() ){
			if ( adm.getCodAdministradora().equals(dto.getCodigoAdmARP()) ){
				arl = adm;
				break;
			}
		}
		for ( AdministradoraVO adm:this.ds.getAdministradorasRiesgoYCcf() ){
			if ( adm.getCodAdministradora().equals(dto.getCodigoAdmCCF()) ){
				ccf = adm;
				break;
			}
		}		
		if ( eps!=null )
			AdministradorasSingleton.getInstance().getAdministradoras().put(eps.getCodAdministradora(), eps);
		if ( afp!=null )
			AdministradorasSingleton.getInstance().getAdministradoras().put(afp.getCodAdministradora(), afp);
		if ( arl!=null )
			AdministradorasSingleton.getInstance().getAdministradoras().put(arl.getCodAdministradora(), arl);
		if ( ccf!=null )
			AdministradorasSingleton.getInstance().getAdministradoras().put(ccf.getCodAdministradora(), ccf);
	}
	
	private AplicadorMoraDesconectadoDTO buildAplicadorMoraDesconectado ( ){
		AplicadorMoraDesconectadoDTO aplicadorMoraDesconectado=new AplicadorMoraDesconectadoDTO();		
		AdministradoraVO adm = new AdministradoraVO();
		adm.setCodAdministradora("SUBSOI");
		aplicadorMoraDesconectado.setAdministradoraSubtotal(adm);
		HashMap<TipoSubSistemasType, AdministradoraVO> parafiscalesMap = new HashMap<TipoSubSistemasType, AdministradoraVO>();
		for ( TipoSubSistemasType key:ds.getAdministradorasParafiscales().keySet() ){
			parafiscalesMap.put(key, this.ds.getAdministradorasParafiscales().get(key));
		}
		aplicadorMoraDesconectado.setAdministradorasPfMap(parafiscalesMap);
		aplicadorMoraDesconectado.setPorcentajeFosyga(ds.getParametroLiquidacion(ParametrosType.PORC_APORTE_FOSYGA.getIdSoiParametro()));
		aplicadorMoraDesconectado.setDiaPagoOportunoDTO(ds.getDiaPagoOportuno());
		aplicadorMoraDesconectado.setDiaPagoOportunoHabil(ds.getFechaPagoOportuno());
		aplicadorMoraDesconectado.setParametroDTOTasaFondoARP(ds.getParametroLiquidacion(ParametrosType.TASA_FONDO_ARP.getIdSoiParametro()));
		aplicadorMoraDesconectado.setFechaPagoReal(Calendar.getInstance());
		aplicadorMoraDesconectado.setIvaComisionParametro(ds.getParametroLiquidacion(ParametrosType.IVA_COM_PLANILLA_MN.getIdSoiParametro()));
		aplicadorMoraDesconectado.setValorComisionParametro(ds.getParametroLiquidacion(ParametrosType.COM_PLANILLA_MN.getIdSoiParametro()));
		aplicadorMoraDesconectado.setMorasCalculoNuevo(new ArrayList<CfgMoraVO>());
		aplicadorMoraDesconectado.setMorasCalculoViejo(new ArrayList<CfgMoraVO>());
		
		//TODO: Temporal mientras se incluye el servicio de consulta de moras
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		Calendar fechaInicio = Calendar.getInstance();
		Calendar fechaFin = Calendar.getInstance();
		Calendar currDate = Calendar.getInstance();
		try {
			fechaInicio.setTime(fmt.parse("01/01/2010"));
			do{			
				CfgMoraVO mora=new CfgMoraVO();
				mora.setTasaAnual(new BigDecimal("0.00"));
				mora.setTasaDiaria(new BigDecimal("0.000"));
				mora.setTasaMensual(new BigDecimal("0.000"));
				
				fechaFin.setTime(fechaInicio.getTime());
				fechaFin.set(Calendar.MONTH, fechaFin.get(Calendar.MONTH)+3);
				fechaFin.set(Calendar.DAY_OF_MONTH, fechaFin.getActualMaximum(Calendar.DAY_OF_MONTH));
									
				mora.setFechaInicio(fechaInicio);
				mora.setFechaFin(fechaFin);
				aplicadorMoraDesconectado.getMorasCalculoNuevo().add(mora);
				
				
				mora=new CfgMoraVO();
				mora.setTasaAnual(new BigDecimal("0.000"));
				mora.setTasaDiaria(new BigDecimal("0.0000"));
				mora.setTasaMensual(new BigDecimal("0.0000"));
				mora.setFechaInicio(fechaInicio);
				mora.setFechaFin(fechaFin);
				aplicadorMoraDesconectado.getMorasCalculoViejo().add(mora);
				
				fechaInicio.set(Calendar.MONTH, fechaInicio.get(Calendar.MONTH)+3);
			}while ( fechaInicio.before(currDate) );
						
		} catch (ParseException e) {
			e.printStackTrace();
		}
				
		return aplicadorMoraDesconectado;
	}
	
	
	private TotalesTO buildTotales ( PlanillaTotalesDTO totalesDto ){
				
		TotalesTO resultado = new TotalesTO();
		
		if (this.ds.getPlanillaApteDto().getPeriodoLiquidacionNoSalud()==null || this.ds.getPlanillaApteDto().getPeriodoLiquidacionSalud()==null){
			return resultado;
		}
		
		resultado.setPeriodoNoSalud(this.ds.getPlanillaApteDto().getPeriodoLiquidacionNoSalud().getAno()+"-"+
										this.ds.getPlanillaApteDto().getPeriodoLiquidacionNoSalud().getMes());
		resultado.setPeriodoSalud(this.ds.getPlanillaApteDto().getPeriodoLiquidacionSalud().getAno()+"-"+
										this.ds.getPlanillaApteDto().getPeriodoLiquidacionSalud().getMes());
		resultado.setTotalAPagar(FormatValues.formatLongvalueCurrency(totalesDto.getVlrGranTotal().longValue()));
		
		resultado.setTotalesPensionLabels(TotalesTO.getLabelsSegSocial());
		resultado.setTotalesSaludLabels(TotalesTO.getLabelsSegSocial());
		resultado.setTotalesRiesgoLabels(TotalesTO.getLabelsSegSocial());
		resultado.setTotalesFspLabels(TotalesTO.getLabelsSegSocial());
		resultado.setTotalParafiscalesLabels(TotalesTO.getLabelsParafiscales());
		resultado.setGranTotalLabels(TotalesTO.getLabelsGranTotal());
		
		//Totales pension
		Hashtable<String, Object> totalSubSistemaPens = totalesDto.getTotalesSubsistema().get(TipoSubSistemasType.SUBSISTEMA_PENSION);		
		int index = 0;
		String values[] = null;
		if ( totalSubSistemaPens!=null ){
			Collection<Object> valoresPension = totalSubSistemaPens.values();			
			resultado.setTotalesPension(new String[valoresPension.size()+1][resultado.getTotalesPensionLabels().length]);			
			for ( Object obj:valoresPension ){
				PlanillaTotalPensionDTO pens = (PlanillaTotalPensionDTO)obj;
				values = new String[resultado.getTotalesPensionLabels().length];
				values[0] = pens.getCodigoAdministradoraPensiones();
				values[1] = pens.getNombreAdministradora();
				values[2] = pens.getNitAdministradoraPensiones();
				values[3] = pens.getDigVerNitAdministradoraPensiones()+"";
				values[4] = FormatValues.formatLongvalueCurrency(pens.getTotalAportes().longValue());
				values[5] = pens.getNumeroDiasMoraLiquidados()+"";
				values[6] = FormatValues.formatLongvalueCurrency(pens.getValorInteresMoraSobreCotizaciones().longValue());
				values[7] = FormatValues.formatLongvalueCurrency(pens.getTotalPagarAdministradora().longValue());
				values[8] = pens.getTotalAfiliadosAdministradora()+"";
				resultado.getTotalesPension()[index]=values;
				index++;
			}
			PlanillaTotalPensionDTO pens = totalesDto.getSubtotalPension();
			values = new String[resultado.getTotalesPensionLabels().length];
			values[0] = "TOTALES";
			values[1] = "-";
			values[2] = "-";
			values[3] = "-";
			values[4] = FormatValues.formatLongvalueCurrency(pens.getTotalAportes().longValue());
			values[5] = pens.getNumeroDiasMoraLiquidados()+"";
			values[6] = FormatValues.formatLongvalueCurrency(pens.getValorInteresMoraSobreCotizaciones().longValue());
			values[7] = FormatValues.formatLongvalueCurrency(pens.getTotalPagarAdministradora().longValue());
			values[8] = pens.getTotalAfiliadosAdministradora()+"";
			resultado.getTotalesPension()[index]=values;
		}
		
		
		//Totales pension
		index = 0;
		Hashtable<String, Object> totalSubSistemaSal = totalesDto.getTotalesSubsistema().get(TipoSubSistemasType.SUBSISTEMA_SALUD);
		if ( totalSubSistemaSal!=null ){
			Collection<Object> valoresSalud = totalSubSistemaSal.values();
			resultado.setTotalesSalud(new String[valoresSalud.size()+1][resultado.getTotalesSaludLabels().length]);
			index = 0;
			for ( Object obj:valoresSalud ){
				PlanillaTotalSaludDTO sal = (PlanillaTotalSaludDTO)obj;
				values = new String[resultado.getTotalesSaludLabels().length];
				values[0] = sal.getCodigoAdministradoraSalud();
				values[1] = sal.getNombreAdministradora();
				values[2] = sal.getNitAdministradoraSalud();
				values[3] = sal.getDigVerNitAdministradoraSalud()+"";
				values[4] = FormatValues.formatLongvalueCurrency(sal.getVlrTotalAportes().longValue());
				values[5] = sal.getNumeroDiasMoraLiquidados()+"";
				values[6] = FormatValues.formatLongvalueCurrency(sal.getTotalMora().longValue());
				values[7] = FormatValues.formatLongvalueCurrency(sal.getVlrTotalPagarAdministradora().longValue());
				values[8] = sal.getTotalAfiliadosAdministradora()+"";
				resultado.getTotalesSalud()[index]=values;
				index++;
			}
			PlanillaTotalSaludDTO sal = totalesDto.getSubtotalSalud();
			values = new String[resultado.getTotalesSaludLabels().length];
			values[0] = "TOTALES";
			values[1] = "-";
			values[2] = "-";
			values[3] = "-";
			values[4] = FormatValues.formatLongvalueCurrency(sal.getVlrTotalAportes().longValue());
			values[5] = sal.getNumeroDiasMoraLiquidados()+"";
			values[6] = FormatValues.formatLongvalueCurrency(sal.getTotalMora().longValue());
			values[7] = FormatValues.formatLongvalueCurrency(sal.getVlrTotalPagarAdministradora().longValue());
			values[8] = sal.getTotalAfiliadosAdministradora()+"";
			resultado.getTotalesSalud()[index]=values;
		}
		
		
		//Totales riesgo
		index = 0;
		Hashtable<String, Object> totalSubSistemaRiesgo = totalesDto.getTotalesSubsistema().get(TipoSubSistemasType.SUBSISTEMA_ARP);
		if ( totalSubSistemaRiesgo!=null ){
			Collection<Object> valoresRiesgo = totalSubSistemaRiesgo.values();
			resultado.setTotalesRiesgo(new String[valoresRiesgo.size()+1][resultado.getTotalesRiesgoLabels().length]);
			index = 0;
			for ( Object obj:valoresRiesgo ){
				PlanillaTotalRiesgosProfesionalesDTO arl = (PlanillaTotalRiesgosProfesionalesDTO)obj;
				values = new String[resultado.getTotalesRiesgoLabels().length];
				values[0] = arl.getCodigoARP();
				values[1] = arl.getNombreAdministradora();
				values[2] = arl.getNitARP();
				values[3] = arl.getDigVerNitARP()+"";
				values[4] = FormatValues.formatLongvalueCurrency(arl.getVlrTotalCotizacionReportada().longValue());
				values[5] = arl.getNumeroDiasMoraLiquidados()+"";
				values[6] = FormatValues.formatLongvalueCurrency(arl.getTotalMora().longValue());
				values[7] = FormatValues.formatLongvalueCurrency(arl.getVlrTotalPagarAdministradora().longValue());
				values[8] = arl.getTotalAfiliadosAdministradora()+"";
				resultado.getTotalesRiesgo()[index]=values;
				index++;
			}
			PlanillaTotalRiesgosProfesionalesDTO arl = totalesDto.getSubtotalRiesgosProfesionales();
			values = new String[resultado.getTotalesRiesgoLabels().length];
			values[0] = "TOTALES";
			values[1] = "-";
			values[2] = "-";
			values[3] = "-";
			values[4] = FormatValues.formatLongvalueCurrency(arl.getVlrTotalCotizacionReportada().longValue());
			values[5] = arl.getNumeroDiasMoraLiquidados()+"";
			values[6] = FormatValues.formatLongvalueCurrency(arl.getTotalMora().longValue());
			values[7] = FormatValues.formatLongvalueCurrency(arl.getVlrTotalPagarAdministradora().longValue());
			values[8] = arl.getTotalAfiliadosAdministradora()+"";
			resultado.getTotalesRiesgo()[index]=values;
		}
		
				
		Collection<String[]> parafiscales = new ArrayList<String[]>();
		//Totales ccf
		index = 0;
		Hashtable<String, Object> totalSubSistemaCcf = totalesDto.getTotalesSubsistema().get(TipoSubSistemasType.SUBSISTEMA_CCF);
		if ( totalSubSistemaCcf!=null ){
			Collection<Object> valoresCcf = totalSubSistemaCcf.values();			
			index = 0;
			for ( Object obj:valoresCcf ){
				PlanillaTotalCajaCompensacionDTO ccf = (PlanillaTotalCajaCompensacionDTO)obj;
				values = new String[resultado.getTotalParafiscalesLabels().length];
				values[0] = TipoSubSistemasType.SUBSISTEMA_CCF.getNombre();
				values[1] = ccf.getCodigoCCF();
				values[2] = ccf.getNombreAdministradora();
				values[3] = ccf.getNitCCF();
				values[4] = ccf.getDigVerNitCCF()+"";
				values[5] = FormatValues.formatLongvalueCurrency(ccf.getVlrAportesACCF().longValue());
				values[6] = ccf.getNumeroDiasMoraLiquidados()+"";
				values[7] = FormatValues.formatLongvalueCurrency(ccf.getVlrInteresMora().longValue());
				values[8] = FormatValues.formatLongvalueCurrency(ccf.getVlrTotalPagarCCF().longValue());
				values[9] = ccf.getTotalAfiliadosCCF()+"";
				parafiscales.add(values);
				index++;
			}
		}
		
		
		//Totales ESAP
		index = 0;

		if ( totalesDto.getPlanillaTotalEsapDTO()!=null ){
					
			PlanillaTotalEsapDTO min = totalesDto.getPlanillaTotalEsapDTO();
			values = new String[resultado.getTotalParafiscalesLabels().length];
			values[0] = TipoSubSistemasType.SUBSISTEMA_ESAP.getNombre();
			values[1] = min.getCodigoAdministradora();
			values[2] = min.getNombreAdministradora();
			values[3] = min.getNitESAP();
			values[4] = min.getDigVerNitESAP()+"";
			values[5] = FormatValues.formatLongvalueCurrency(min.getVlrPagar().longValue());
			values[6] = min.getNumeroDiasMoraLiquidados()+"";
			values[7] = FormatValues.formatLongvalueCurrency(min.getVlrInteresMora().longValue());
			values[8] = FormatValues.formatLongvalueCurrency(min.getVlrTotalPagar().longValue());
			values[9] = min.getTotalAfiliadosNoRepetidosAdministradora()+"";
			parafiscales.add(values);
			index++;
		}
		

		//Totales MEN
		//index = 0;
		//Hashtable<String, Object> totalSubSistemaMen = totalesDto.getTotalesSubsistema().get(TipoSubSistemasType.SUBSISTEMA_MINEDU);
		if ( totalesDto.getPlanillaTotalMinEducacionDTO()!=null ){
			
			PlanillaTotalMinEducacionDTO min = totalesDto.getPlanillaTotalMinEducacionDTO();
			values = new String[resultado.getTotalParafiscalesLabels().length];
			values[0] = TipoSubSistemasType.SUBSISTEMA_MINEDU.getNombre();
			values[1] = min.getCodigoAdministradora();
			values[2] = min.getNombreAdministradora();
			values[3] = min.getNitMEN();
			values[4] = min.getDigVerNitMEN()+"";
			values[5] = FormatValues.formatLongvalueCurrency(min.getVlrPagar().longValue());
			values[6] = min.getNumeroDiasMoraLiquidados()+"";
			values[7] = FormatValues.formatLongvalueCurrency(min.getVlrInteresMora().longValue());
			values[8] = FormatValues.formatLongvalueCurrency(min.getVlrTotalPagar().longValue());
			values[9] = min.getTotalAfiliadosNoRepetidosAdministradora()+"";
			parafiscales.add(values);
			index++;
		}
		
		//Totales SENA
		if ( totalesDto.getPlanillaTotalSenaDTO()!=null ){
			
			PlanillaTotalSenaDTO min = totalesDto.getPlanillaTotalSenaDTO();
			values = new String[resultado.getTotalParafiscalesLabels().length];
			values[0] = TipoSubSistemasType.SUBSISTEMA_SENA.getNombre();
			values[1] = min.getCodigoAdministradora();
			values[2] = min.getNombreAdministradora();
			values[3] = min.getNitSENA();
			values[4] = min.getDigVerNitSENA()+"";
			values[5] = FormatValues.formatLongvalueCurrency(min.getVlrAportesParafiscales().longValue());
			values[6] = min.getNumeroDiasMoraLiquidados()+"";
			values[7] = FormatValues.formatLongvalueCurrency(min.getVlrInteresMoraSobreAporte().longValue());
			values[8] = FormatValues.formatLongvalueCurrency(min.getVlrTotalPagarSENA().longValue());
			values[9] = min.getTotalAfiliadosNoRepetidosAdministradora()+"";
			parafiscales.add(values);
			index++;
		}
		

		//Totales ICBF
		if ( totalesDto.getPlanillaTotalIcbfDTO()!=null ){
			
			PlanillaTotalIcbfDTO min = totalesDto.getPlanillaTotalIcbfDTO();
			values = new String[resultado.getTotalParafiscalesLabels().length];
			values[0] = TipoSubSistemasType.SUBSISTEMA_ICBF.getNombre();
			values[1] = min.getCodigoIcbf();
			values[2] = min.getNombreAdministradora();
			values[3] = min.getNitICBF();
			values[4] = min.getDigVerNitICBF()+"";
			values[5] = FormatValues.formatLongvalueCurrency(min.getVlrAportes().longValue());
			values[6] = min.getNumeroDiasMoraLiquidados()+"";
			values[7] = FormatValues.formatLongvalueCurrency(min.getVlrInteresMora().longValue());
			values[8] = FormatValues.formatLongvalueCurrency(min.getVlrTotalPagar().longValue());
			values[9] = min.getTotalAfiliadosNoRepetidosAdministradora()+"";
			parafiscales.add(values);
			index++;
		}
		
		PlanillaTotalParafiscalesDTO parafiscalesDto = totalesDto.getSubTotalParafiscales();
		values = new String[resultado.getTotalParafiscalesLabels().length];
		values[0] = "TOTAL";
		values[1] = "-";
		values[2] = "-";
		values[3] = "-";
		values[4] = "-";
		values[5] = FormatValues.formatLongvalueCurrency(parafiscalesDto.getVlrPagar().longValue());
		values[6] = "-";
		values[7] = FormatValues.formatLongvalueCurrency(parafiscalesDto.getVlrInteresMora().longValue());
		values[8] = FormatValues.formatLongvalueCurrency(parafiscalesDto.getVlrTotalPagar().longValue());
		values[9] = "-";
		parafiscales.add(values);
		
		resultado.setTotalParafiscales(parafiscales.toArray(new String[0][0]));
		
		
		//Gran total
		resultado.setGranTotal(new String[resultado.getGranTotalLabels().length]);
		
		resultado.getGranTotal()[0]=FormatValues.formatLongvalueCurrency(totalesDto.getVlrPagarPensiones().longValue());
		resultado.getGranTotal()[1]=FormatValues.formatLongvalueCurrency(0l);
		resultado.getGranTotal()[2]=FormatValues.formatLongvalueCurrency(totalesDto.getVlrPagarSalud().longValue());
		resultado.getGranTotal()[3]=FormatValues.formatLongvalueCurrency(totalesDto.getVlrPagarRiesgosProfesionales().longValue());
		resultado.getGranTotal()[4]=FormatValues.formatLongvalueCurrency(totalesDto.getVlrCajasCompensacion().longValue());
		resultado.getGranTotal()[5]=FormatValues.formatLongvalueCurrency(totalesDto.getVlrPagarSena().longValue());
		resultado.getGranTotal()[6]=FormatValues.formatLongvalueCurrency(totalesDto.getVlrPagarICBF().longValue());
		resultado.getGranTotal()[7]=FormatValues.formatLongvalueCurrency(totalesDto.getVlrPagarESAP().longValue());
		resultado.getGranTotal()[8]=FormatValues.formatLongvalueCurrency(totalesDto.getVlrPagarMinisterioEducacion().longValue());
		resultado.getGranTotal()[9]=FormatValues.formatLongvalueCurrency(totalesDto.getVlrGranTotal().longValue());
		resultado.getGranTotal()[10]=totalesDto.getNumeroAdministradorasPension()+"";
		resultado.getGranTotal()[11]=totalesDto.getNumeroEPSReportadas()+"";
		resultado.getGranTotal()[12]=totalesDto.getNumeroARPReportadas()+"";
		resultado.getGranTotal()[13]=totalesDto.getNumeroCCFReportadas()+"";
		
		
		return resultado;
	}
	
}

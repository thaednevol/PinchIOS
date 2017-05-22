package com.ach.sop.utility.biz;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;




import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.ach.common.biz.model.EmailVO;
import com.ach.pla.biz.type.ModalidadPlanillaType;
import com.ach.sop.biz.transfer.PlanillaSoporteCotizanteCollectionDTO;
import com.ach.sop.biz.transfer.PlanillaSoporteCotizanteCollectionPaginadoDTO;
import com.ach.sop.biz.transfer.PlanillaSoporteCotizanteDTO;
import com.ach.sop.biz.transfer.PlanillaSoporteEncabezadoPlanillaDTO;
import com.ach.sop.biz.transfer.filter.PlanillaSoportesFilterDTO;
import com.ach.sop.biz.transfer.info.PlanillaSoportePagoBaseInfoDTO;
import com.ach.sop.biz.type.TipoSoporteDePagoType;
import com.ach.sop.biz.util.GeneradorRutasSoportesUtil;
import com.ach.sop.utility.biz.transfer.DatosEnvioCorreoDTO;
import com.ach.sop.utility.biz.transfer.RespuestaGeneracionSoporteDTO;
import com.ach.sop.utility.biz.util.MailSender;
import com.ach.sop.utility.biz.util.ServiciosUtilitarios;
import com.google.gson.Gson;
import com.lucasian.common.util.UtilidadesFile;
import com.lucasian.exception.SystemException;

public class GeneracionSoportesOffline {
	public static final String EXTENSION_REPORTE_PDF = ".pdf";
	public static String RUTA_RECURSOS = "./resources";
	public static String RUTA_GENERACION_SOPORTES="./soportes_generados";
	public static String RUTA_IMG_LOGO_OPERADORES=RUTA_RECURSOS+"/img/";
	public static final String SOP_IMG_EXTENSION=".jpg";	
	public static final String TEMPLATE_CORREO_SOPORTE="reporteSoportesPlanillaPorCotizante.html";
	public static final String ASUNTO_CORREO_SOPORTE="Soporte de Pago SOI";
	
	public static void main(String ars[]) {
		String jsonEncabezado=ars[0].trim();
		String jsonCotizantes=ars[1].trim();
		String datosEnvioCorreo=ars[2].trim();
		//String resultado=new GeneracionSoportesOffline().generarSoporteCotizante(jsonEncabezado, jsonCotizantes,datosEnvioCorreo);
		
		//System.out.println(resultado);
	}
	
	public String generarSoporteCotizante(String datosEncabezado, Collection<PlanillaSoporteCotizanteDTO> datosDetalleCotizante, String datosEnvioCorreo, String rutaRecursos, String rutaGeneracion){
		RespuestaGeneracionSoporteDTO respuestaGeneracionSoporteDTO=new RespuestaGeneracionSoporteDTO();
		respuestaGeneracionSoporteDTO.setResultadoGeneracion("OK");
		
		if ( rutaRecursos!=null && !rutaRecursos.trim().equals("") ){
			RUTA_RECURSOS = rutaRecursos;
			RUTA_IMG_LOGO_OPERADORES = RUTA_RECURSOS+"/img/";
		}
		if ( rutaGeneracion!=null && !rutaGeneracion.trim().equals("") ){
			RUTA_GENERACION_SOPORTES = rutaGeneracion;
		}
		
		try{
			PlanillaSoporteEncabezadoPlanillaDTO planillaSoporteEncabezadoPlanillaDTO=null;
			try{
				planillaSoporteEncabezadoPlanillaDTO=ServiciosUtilitarios.convertirDatosEncabezadoDTO(datosEncabezado);
			}catch (Exception e) {
				throw new SystemException("Ocurrio un problema mapeando el encabezado a json "+e.getMessage()+" Traza: "+e.getStackTrace(),e);
			}
			
			List<PlanillaSoportePagoBaseInfoDTO> planillaSoportePagoBaseInfoDTOCollection = new ArrayList<PlanillaSoportePagoBaseInfoDTO>();
			/*try{
				cotizantes =ServiciosUtilitarios.convertirDatosCotizantes(datosDetalleCotizante);
			}catch (Exception e) {
				throw new SystemException("Ocurrio un problema mapeando los cotizantes a json "+e.getMessage()+" Traza: "+e.getStackTrace(),e);
			}*/
			PlanillaSoporteCotizanteCollectionDTO planillaSoporteCotizanteCollectionDTO=new PlanillaSoporteCotizanteCollectionPaginadoDTO(datosDetalleCotizante);
			
			PlanillaSoportePagoBaseInfoDTO punteroDeTrabajo = new PlanillaSoportePagoBaseInfoDTO();
			punteroDeTrabajo.setEncabezado(planillaSoporteEncabezadoPlanillaDTO);
			punteroDeTrabajo
					.setPlanillaSoporteCotizanteDTO(planillaSoporteCotizanteCollectionDTO);
			planillaSoportePagoBaseInfoDTOCollection.add(punteroDeTrabajo);
			PlanillaSoporteCotizanteDTO cotizante=((ArrayList<PlanillaSoporteCotizanteDTO>)datosDetalleCotizante).get(0);
			StringBuilder nombreCompletoCotizante=new StringBuilder(cotizante.getPrimerNombre());
			String numeroPlanilla=null;
			if(cotizante.getSegundoNombre()!=null&&!cotizante.getSegundoNombre().isEmpty()){
				nombreCompletoCotizante.append(" ");
				nombreCompletoCotizante.append(cotizante.getSegundoNombre());
			}
			nombreCompletoCotizante.append(" ").append(cotizante.getPrimerApellido());
			if(cotizante.getSegundoApellido()!=null&&!cotizante.getSegundoApellido().isEmpty()){
				nombreCompletoCotizante.append(" ");
				nombreCompletoCotizante.append(cotizante.getSegundoApellido());
			}
			
			if (planillaSoporteEncabezadoPlanillaDTO.getNumeroAsistidaPlanilla() != null
					&& !planillaSoporteEncabezadoPlanillaDTO.getNumeroAsistidaPlanilla().trim()
							.equals("")
					&& planillaSoporteEncabezadoPlanillaDTO.getModalidad().equals(
							ModalidadPlanillaType.ASISTIDA
									.getIdModalidadPlanilla())) {
				numeroPlanilla=planillaSoporteEncabezadoPlanillaDTO.getNumeroAsistidaPlanilla()
						.trim();
			} else if (planillaSoporteEncabezadoPlanillaDTO.getNumeroElectronicaPlanilla() != null
					&& !planillaSoporteEncabezadoPlanillaDTO.getNumeroElectronicaPlanilla().trim()
							.equals("")
					&& planillaSoporteEncabezadoPlanillaDTO.getModalidad().equals(
							ModalidadPlanillaType.ELECTRONICA
									.getIdModalidadPlanilla())) {
				numeroPlanilla=planillaSoporteEncabezadoPlanillaDTO.getNumeroElectronicaPlanilla()
						.trim();
			}
			
	        StringBuilder pathReporte = new StringBuilder();
			String directorioDeTrabajoLocal;
			PlanillaSoportesFilterDTO planillaSoportesFilterDTO=new PlanillaSoportesFilterDTO();
			planillaSoportesFilterDTO.setTipoDeComprobanteDePago(TipoSoporteDePagoType.SOPORTE_PAGO_COTIZANTE);
			planillaSoportesFilterDTO.setIdNumeroPlanilla(numeroPlanilla);
			directorioDeTrabajoLocal = ""+RUTA_GENERACION_SOPORTES;
			directorioDeTrabajoLocal += File.separator;
			try {
				directorioDeTrabajoLocal = GeneradorRutasSoportesUtil
						.generarPathPorFechaTpSoportePlanilla(directorioDeTrabajoLocal,
								Calendar.getInstance(), planillaSoportesFilterDTO);
			} catch (Exception e) {
				throw new SystemException("Ocurrio un problema obteniendo el directorio de generación local del soporte "+ directorioDeTrabajoLocal,e);
			}

			pathReporte.append(directorioDeTrabajoLocal);
			StringBuilder nombreReporte = new StringBuilder(TipoSoporteDePagoType.SOPORTE_PAGO_COTIZANTE.getNombreComprobante());
			nombreReporte.append(".");

			
			nombreReporte.append(numeroPlanilla);
			pathReporte.append(nombreReporte).append(EXTENSION_REPORTE_PDF);
	        
			JRBeanCollectionDataSource jrBeanDataSource = new JRBeanCollectionDataSource(
					planillaSoportePagoBaseInfoDTOCollection, false);

			
			File fileSoportes = new File(RUTA_RECURSOS);

			
			if (!fileSoportes.isDirectory()) {
				throw new SystemException("No existe directorio donde se encuentra el jasper SoporteDePago.Cotizantes.jasper : "+ fileSoportes);		
			}
			StringBuilder rutaRpt = new StringBuilder(
					fileSoportes.getAbsolutePath()).append(File.separator)
					.append("SoporteDePago.Cotizantes")
					.append(".jasper");

			

			Map<String, Object> parameters = new Hashtable<String, Object>();
			if (SOP_IMG_EXTENSION != null) {
				parameters.put("EXTENSION_IMG", SOP_IMG_EXTENSION);
				parameters.put("PATH_IMG", RUTA_IMG_LOGO_OPERADORES);
				parameters.put("RPT_LOCATION", fileSoportes.getAbsolutePath());
				parameters.put("SUBREPORT_DIR", fileSoportes.getAbsolutePath());
			}

			try {
				parameters.put(JRParameter.REPORT_LOCALE, new Locale("es", "CO"));
				JasperPrint jasperPrint = JasperFillManager.fillReport(
						rutaRpt.toString(), parameters, jrBeanDataSource);

				// reemplazar las ï¿½'s por N's para compatibilidad generacion zip
				String pathReporteAux = pathReporte.toString().replace('Ñ', 'N');
				pathReporte = new StringBuilder(pathReporteAux);
				//
				// proceso en donde se escribe fisicamente el pdf con la informacion
				// generada anteriormente
				//
				JasperExportManager.exportReportToPdfFile(jasperPrint,
						pathReporte.toString());
				
				respuestaGeneracionSoporteDTO.setRutaSoporteGenerado(pathReporte.toString());

			} catch (JRException jrEx) {
				throw new SystemException("Ocurrio un problema durante la generación del soporte ",jrEx);
			}
			
			try{
				enviarSoporteEmailPorCotizante(ServiciosUtilitarios.convertirDatosEnvioCorreo(datosEnvioCorreo), nombreCompletoCotizante.toString(), pathReporte.toString(), numeroPlanilla, cotizante.getCorreoSoporteCotizante());
			}catch (Exception e) {
				throw new SystemException("Ocurrio un problema durante el envio del soporte al correo ",e);
			}

		}catch (Exception e) {
			respuestaGeneracionSoporteDTO.setResultadoGeneracion("ERROR");
			respuestaGeneracionSoporteDTO.setDetalleError(e.getMessage());
			StringBuilder str = new StringBuilder();
			str.append(this.getExceptionString(e));			
			if ( e.getCause()!=null && e.getCause().getStackTrace()!=null ){
				str.append("Excepcion Level 1");
				str.append(this.getExceptionString(e.getCause()));
				if ( e.getCause().getCause()!=null && e.getCause().getCause().getStackTrace()!=null ){
					str.append("Excepcion Level 2");
					str.append(this.getExceptionString(e.getCause().getCause()));
				}
			}
			respuestaGeneracionSoporteDTO.setStackTraceError(str.toString());
		}
		Gson gson=new Gson();
		return gson.toJson(respuestaGeneracionSoporteDTO);

	}
	
	private String getExceptionString ( Throwable e ){
		StringBuilder str = new StringBuilder();
		str.append("getLocalizedMessage: "+e.getLocalizedMessage());
		str.append("getMessage: "+e.getMessage());
		str.append("getClass: "+e.getClass());
		for ( StackTraceElement elm:e.getStackTrace() ){
			str.append(elm.getClassName()).append(":").append(elm.getLineNumber()).append("\n");
		}
		return str.toString();
	}

	
	
	
	private static void enviarSoporteEmailPorCotizante(DatosEnvioCorreoDTO datosEnvioCorreo, String nombreMostrar,String adjunto,String numeroPlanilla, String correoCotizante){
		
		
		Collection<String> direccionesDestino;
		Collection<File> adjuntos = null;
		EmailVO emailVO = null;
		File templateFile = new File(RUTA_RECURSOS, TEMPLATE_CORREO_SOPORTE);
		if (!templateFile.exists() && !templateFile.canRead()) {
			throw new SystemException("Template de correo no existe en la ruta especificada "+templateFile.getAbsolutePath());
		}
		
		StringBuilder stringMessageBuilder = new StringBuilder();
		try {
			stringMessageBuilder = UtilidadesFile.readFile(templateFile);
		} catch (IOException io) {
			throw new SystemException("Error de lectura de template de correo  "+templateFile.getAbsolutePath());
		}
		direccionesDestino = new ArrayList<String>();
		String mensajeReemplazo = stringMessageBuilder.toString();
		direccionesDestino.add(correoCotizante);
		mensajeReemplazo = mensajeReemplazo.replaceAll("\\{nombre}", nombreMostrar);
		mensajeReemplazo = mensajeReemplazo.replaceAll("\\{numeroPlanilla}",numeroPlanilla);
		mensajeReemplazo = mensajeReemplazo.replaceAll("\\{correoSoporte}", datosEnvioCorreo.getCuentaCorreoElectronicoOrigen());

		emailVO = new EmailVO();
		emailVO.setFromAddress(datosEnvioCorreo.getCuentaCorreoElectronicoOrigen());
		emailVO.setSubject(ASUNTO_CORREO_SOPORTE);
		emailVO.setText(mensajeReemplazo);
		emailVO.setToAddresses(direccionesDestino);
		emailVO.setServerName(datosEnvioCorreo.getServidorCorreo());
		emailVO.setServerPort(datosEnvioCorreo.getPuertoServidorCorreo());
		emailVO.setServerRequiredAuthentication(datosEnvioCorreo.isServidorRequiereAutenticacion());
		emailVO.setUseTLS(datosEnvioCorreo.isServidorRequiereTls());
		emailVO.setUsernameAuthentication(datosEnvioCorreo.getNombreUsuarioAutenticacion());
		emailVO.setPasswordAuthentication(datosEnvioCorreo.getContrasenaUsuarioAutenticacion());

		emailVO.setUseSSL(datosEnvioCorreo.isServidorRequiereSsl());
		adjuntos = new ArrayList<File>();
		adjuntos.add(new File(adjunto));
		emailVO.setArchivosAdjuntos(adjuntos);
		MailSender.sendMail(emailVO);
	}
		
}


package com.ach.soi.empresarial.liquidacion.exceptions;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.ach.arc.biz.r1747.model.CampoLeido1747;
import com.lucasian.exception.ApplicationException;
import com.lucasian.exception.ExceptionContext;
import com.lucasian.exception.ExceptionMessage;
import com.lucasian.exception.LevelConstants;
import com.lucasian.exception.SysExceptionCodesConstants;
import com.lucasian.exception.SystemException;
import com.lucasian.exception.UnhandledExceptionWebContext;
import com.lucasian.exception.manager.ExceptionManager;

public class DesktopExceptionMngr implements ExceptionManager{

	
	private final static String MESSAGE_LOG_EXCEPTION_CONTEXT = " - Contexto Web: usuario= {0}, ip usuario= {1}, componente web= {2}, metodo web= {3}, traza: ";
	private final static String MESSAGE_LOG_EXCEPTION_NO_CONTEXT = " - traza: ";
	private final static String MESSAGE_LOG_WEB_EXCEPTION_UNHANDLED = "Mensaje Excepción: {0} - Contexto web: URI request= {1}, ServletName = {2}, código status = {3, number, integer} ";
	private final static String MESSAGE_NO_SETTING_FOR_EXCEPTION = "No se encontró configuración de excepción con código: {0,number,integer}";
	private final static String MESSAGE_NO_APP_NO_SYS_EXCEPTION = "Ha ocurrido un error inesperado en la aplicación";

	private static final DecimalFormat formatter = new DecimalFormat("00000");
	
	private static Properties exceptionsMessages = new Properties();
	private static DesktopExceptionMngr INSTANCE = null;
	
	public static DesktopExceptionMngr getInstance ( ){
		if ( INSTANCE==null ){
			InputStream is = DesktopExceptionMngr.class.getResourceAsStream("/com/ach/soi/empresarial/liquidacion/exceptions/exceptions.properties");
			try {
				exceptionsMessages.load(is);
				INSTANCE = new DesktopExceptionMngr();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new Error("No se ha configurado correctamente el manejador de excepciopnes",e);
			}
		}
		return INSTANCE;
	}
	
	
	private static final Logger logger = Logger.getLogger(DesktopExceptionMngr.class.getName());
	
	@Override
	public ExceptionMessage manejarException(Throwable exception) {
		return manejarException(exception, (ExceptionContext)null);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public ExceptionMessage manejarException(Throwable exception, ExceptionContext ctx) {

		ExceptionMessage exMsg = null;

		if (exception instanceof ApplicationException) {

			ApplicationException appEx = (ApplicationException) exception;

			if (!appEx.isMultiple()) {
				exMsg = manejarApplicationException(appEx, ctx);
			} else {
				exMsg = manejarMultipleApplicationException(appEx, ctx);
			}

		} else if (exception instanceof SystemException){

			SystemException sysEx = (SystemException) exception;

			if (!sysEx.isMultiple()) {
				exMsg = manejarSystemException(sysEx, ctx);
			} else {
				exMsg = manejarMultipleSystemException(sysEx, ctx);
			}

		} else {

			exMsg = manejarExceptionGeneral(exception);
		}

		return exMsg;

	}
	
	private ExceptionMessage manejarExceptionGeneral(Throwable th) {

		ExceptionMessage exMsg = null;

		// Hacer log de la aplicación
		logger.fatal(th.getMessage(), th);

		/**
		 *  Construir el objeto ExceptionMessage para presentacion,
		 *  utilizando un mensaje genérico para este escenario de manejo
		 *  de excepción, siempre usar el nivel error, y un código especial
		 *  que significa que no está en la configuración de base de datos
		 */
		exMsg = new ExceptionMessage();
		exMsg.setCodigo(SysExceptionCodesConstants.UNHANDLED_SYSTEM_EXCEPTION);
		exMsg.setMensaje(MESSAGE_NO_APP_NO_SYS_EXCEPTION);
		exMsg.setNivel(LevelConstants.FATAL);

		return exMsg;
	}

	/**
	 * {@inheritDoc}
	 */
	public ExceptionMessage manejarExceptionWebGeneral(Throwable exception, UnhandledExceptionWebContext ctx) {

		ExceptionMessage exMsg = null;
		
		return exMsg;
	}


	private ExceptionMessage manejarMultipleApplicationException(ApplicationException appEx, ExceptionContext ctx) {

		ExceptionMessage exMsg = null;

		ArrayList<ExceptionMessage> exMsgs = new ArrayList<ExceptionMessage>(appEx.getAppExceptionSet().size());
		logger.info("******* Inicio excepción múltiple *********");
		for (ApplicationException item : appEx.getAppExceptionSet()) {
			exMsg = manejarApplicationException(item, ctx);
			exMsgs.add(exMsg);
		}
		//exMsg = manejarApplicationException(appEx, ctx);
		exMsg.setExceptionMessageSet(exMsgs);

		logger.info("******* Fin excepción múltiple    *********");

		return exMsg;
	}

	private ExceptionMessage manejarApplicationException(ApplicationException appEx, ExceptionContext ctx) {

		// Obtener configuracion de la excepcion
		String msgUsuario = DesktopExceptionMngr.exceptionsMessages.getProperty(appEx.getCodigo()+"");

		
		if (appEx.getNivel() == null) {
			appEx.setNivel("ERROR");
		}

		StringBuilder sb = new StringBuilder();
		sb.append(formatter.format(appEx.getCodigo())).append(": ").append(msgUsuario);

		MessageFormat mf = new MessageFormat(sb.toString());
		
		
		Collection<Object> parametrosReemplazo = new ArrayList<Object>();
		if ( appEx.getParametrosReemplazo()!=null &&
				appEx.getParametrosReemplazo().length>=1 && appEx.getParametrosReemplazo()[0] instanceof CampoLeido1747 ){
			for ( int i=1;i<appEx.getParametrosReemplazo().length;i++ ){
				parametrosReemplazo.add(appEx.getParametrosReemplazo()[i]);
			}			
		}
		
		msgUsuario = mf.format(parametrosReemplazo.toArray(new Object[0]));

		msgUsuario = msgUsuario.trim();
		// Agregar info de contexto si hay
		String msgLog = null;
		if (ctx == null) {
			msgLog = MESSAGE_LOG_EXCEPTION_NO_CONTEXT;
		} else {
			msgLog = MessageFormat.format(MESSAGE_LOG_EXCEPTION_CONTEXT, ctx.getIdUsuario(), ctx.getIpUsuario(), ctx.getComponentePresentacion(), ctx.getMetodoComponentePresentacion());
		}

		msgLog = msgUsuario + msgLog;

		// Construir el objeto ExceptionMessage para presentacion
		ExceptionMessage exMsg = new ExceptionMessage();
		exMsg.setCodigo(appEx.getCodigo());
		exMsg.setMensaje(msgUsuario);
		exMsg.setNivel(appEx.getNivel());

		return exMsg;
	}

	private ExceptionMessage manejarMultipleSystemException(SystemException appEx, ExceptionContext ctx) {

		ExceptionMessage exMsg = null;

		ArrayList<ExceptionMessage> exMsgs = new ArrayList<ExceptionMessage>(appEx.getSysExceptionSet().size());

		logger.info("******* Inicio excepción múltiple *********");
		for (SystemException item : appEx.getSysExceptionSet()) {
			exMsg = manejarSystemException(item, ctx);
			exMsgs.add(exMsg);
		}

		exMsg = manejarSystemException(appEx, ctx);
		exMsg.setExceptionMessageSet(exMsgs);

		logger.info("******* Fin excepción múltiple    *********");

		return exMsg;
	}

	private ExceptionMessage manejarSystemException(SystemException sysEx, ExceptionContext ctx) {

		ExceptionMessage exMsg = null;

		
		
		
		String msgUsuario = exceptionsMessages.getProperty(sysEx.getCodigo()+"");
		StringBuilder sb = new StringBuilder();
		sb.append(formatter.format(sysEx.getCodigo()))
			.append(": ").append(msgUsuario);

		// Agregar parametros de reemplazo si los hay
		MessageFormat mf = new MessageFormat(sb.toString());
		msgUsuario = mf.format(sysEx.getParametrosReemplazo());

		// Agregar info de contexto si hay
		String msgLog = null;
		if (ctx == null) {
			msgLog = MESSAGE_LOG_EXCEPTION_NO_CONTEXT;
		} else {
			msgLog = MessageFormat.format(MESSAGE_LOG_EXCEPTION_CONTEXT, ctx.getIdUsuario(), ctx.getIpUsuario(), ctx.getComponentePresentacion(), ctx.getMetodoComponentePresentacion());
		}

		msgLog = msgUsuario + msgLog;

		// Hacer log de la excepcion
				// Construir el objeto ExceptionMessage para presentacion
		exMsg = new ExceptionMessage();
		exMsg.setCodigo(sysEx.getCodigo());
		exMsg.setMensaje(msgUsuario);
		exMsg.setNivel("FATAL");

		return exMsg;
	}
	

}

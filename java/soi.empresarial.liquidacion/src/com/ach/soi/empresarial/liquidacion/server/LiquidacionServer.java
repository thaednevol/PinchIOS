package com.ach.soi.empresarial.liquidacion.server;

import java.io.OutputStreamWriter;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.springframework.boot.SpringApplication;

import co.swatit.pilautil.generics.Validation;



public class LiquidacionServer {

	private static Logger logger = getLogger();
	
	public static void main(String[] args) {
		logger.info("Start - Init-LiqServer");
        SpringApplication.run(LiquidacionRestController.class, args);
        logger.info("End - Init-LiqServer");

    }
	

	private static Logger getLogger ( ){
		String path = System.getenv().get("LOG_PILA");
        if (!Validation.isNullOrEmpty(path)) {
            // creates pattern layout
            PatternLayout layout = new PatternLayout();
            layout.setConversionPattern("[%p] %d %c %M - %m%n");

            // creates daily rolling file appender
            RollingFileAppender rollingAppender = new RollingFileAppender();
            rollingAppender.setFile(path);
            rollingAppender.setLayout(layout);
            rollingAppender.setMaxFileSize("10MB");
            rollingAppender.setMaxBackupIndex(6);
            rollingAppender.activateOptions();

            // configures the root logger
            Logger springLogger = Logger.getLogger("org.springframework.web");
            springLogger.setLevel(Level.TRACE);
            springLogger.addAppender(rollingAppender);
            
            return springLogger;

        }
        else{
        	 PatternLayout layout = new PatternLayout("[%p] %d %c %M - %m%n");

        	 ConsoleAppender ca = new ConsoleAppender();
        	 ca.setWriter(new OutputStreamWriter(System.out));
        	 ca.setLayout(layout);
        	 ca.setName("soi.empresarial.console.appender");
        	 ca.activateOptions();

             // configures the root logger
             Logger springLogger = Logger.getLogger("org.springframework.web");
             springLogger.setLevel(Level.TRACE);             
             springLogger.addAppender(ca);
             
             return springLogger;
        }
	}
	
	
}

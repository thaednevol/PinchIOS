package com.ach.soi.empresarial.liquidacion.server;

import java.io.OutputStreamWriter;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.springframework.boot.SpringApplication;


public class LiquidacionServer {

	public static void main(String[] args) {
        SpringApplication.run(LiquidacionRestController.class, args);

    }
	
	static{
		String path = System.getenv().get("LOG_PILA");
        if (path!=null && !path.trim().equals("")) {
            // creates pattern layout
            PatternLayout layout = new PatternLayout("[%p] %d %c %M - %m%n");

            RollingFileAppender rollingAppender = new RollingFileAppender();
            rollingAppender.setFile(path);
            rollingAppender.setLayout(layout);
            rollingAppender.setMaxFileSize("1MB");
            rollingAppender.setMaxBackupIndex(3);
            rollingAppender.activateOptions();

            // configures the root logger
            Logger rootLogger = Logger.getRootLogger();
            rootLogger.setLevel(Level.TRACE);
            rootLogger.addAppender(rollingAppender);

        }
        else{
        	 PatternLayout layout = new PatternLayout("[%p] %d %c %M - %m%n");

        	 ConsoleAppender ca = new ConsoleAppender();
        	 ca.setWriter(new OutputStreamWriter(System.out));
        	 ca.setLayout(layout);
        	 ca.setName("soi.empresarial.console.appender");
        	 ca.activateOptions();

             // configures the root logger
             Logger rootLogger = Logger.getRootLogger();
             rootLogger.setLevel(Level.ALL);             
             rootLogger.addAppender(ca);
        }
	}
	
	
}

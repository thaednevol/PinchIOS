package co.swatit.pilabusiness.utils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

import co.swatit.pilautil.generics.Validation;

/**
 * Clase utilizada para la creación de un archivo de log.
 * 
 * @author SWAT-IT <br>
 *         Cristian Camilo Londoño <br>
 *         Email: clondono@swat-it.co <br>
 * @date 23/01/2017
 * @sprint 1.0
 */
public final class LogFileGenerator {

    /** Constante que contiene el patrón para imprimir fecha en el log */
    public static final String CONVERSION_PATTERN = "[%p] %d %c %M - %m%n";

    /**
     * Método constructor por defecto
     */
    private LogFileGenerator() {
    }

    /**
     * Método utilizado para la generación de un archivo log.
     * 
     * @autor SWAT-IT <br>
     *        Cristian Camilo Londoño <br>
     *        Email: clondono@swat-it.co <br>
     * @date 23/01/2017
     * @version 1.0
     */
    public static void buildFileLog() {
        String path = System.getenv().get(Constants.LOG_PILA);
        if (!Validation.isNullOrEmpty(path)) {
            // creates pattern layout
            PatternLayout layout = new PatternLayout();
            layout.setConversionPattern(CONVERSION_PATTERN);

            // creates daily rolling file appender
            RollingFileAppender rollingAppender = new RollingFileAppender();
            rollingAppender.setFile(path);
            rollingAppender.setLayout(layout);
            rollingAppender.setMaxFileSize(AttributePropertiesUtil.MAX_FILE_SIZE);
            rollingAppender.setMaxBackupIndex(AttributePropertiesUtil.MAX_BACKUP_INDEX);
            rollingAppender.activateOptions();

            // configures the root logger
            Logger rootLogger = Logger.getRootLogger();
            rootLogger.setLevel(Level.TRACE);
            rootLogger.addAppender(rollingAppender);

        }
    }
}

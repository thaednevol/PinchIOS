package co.swatit.pilawebservices.startup;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import co.swatit.pilautil.generics.Constants;
import co.swatit.pilautil.generics.PropertyLoader;
import co.swatit.pilautil.generics.Utilities;

/**
 * 
 * Clase que provee la inicialización de la aplicación, se hace carga de los archivos de propiedades del proyecto
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 20/01/2017
 * @version 1.0
 */
public class Initializer extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Inicializador de la aplicación.
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/01/2017
	 *
	 * @param event
	 *            , objeto de transporte usado para pasar información durante la inicialización
	 * @throws {@link ServletException} cuando existe un problema propio del servidor con la inicialización
	 */
	public void init(ServletConfig event) throws ServletException {
		Utilities.contextName = System.getProperty("weblogic.home") + "/PILA";
		// Carga archivo log4j properties
		Utilities.getLog4jConfig(Utilities.contextName + Constants.LOG4J_PROPERTIES);
		PropertyLoader.INSTANCE.loadExternalProperties(Constants.GLOBAL_PROP);
		PropertyLoader.INSTANCE.loadExternalProperties(Constants.PERMISSIONS_PROPERTIES);
	}
}

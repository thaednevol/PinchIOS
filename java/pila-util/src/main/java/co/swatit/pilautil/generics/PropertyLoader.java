package co.swatit.pilautil.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;


import org.apache.log4j.Logger;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import co.swatit.pilautil.exception.BusinessException;
import co.swatit.pilautil.exception.ErrorMessagesLoader;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;

/**
 * Clase que implementa la logica para la carga de propiedades desde un archivo externo.
 * 
 * @author Swat-It <br>
 *         Jessica Antía Hortúa <br>
 *         Email: jantia@swat-it.co<br>
 * @date 25/10/2016
 * @version 1.0
 * 
 */
public final class PropertyLoader {

	/**
	 * Logger de la aplicación.
	 */
	private static final Logger LOGGER = Logger.getLogger(PropertyLoader.class.getName());

	/**
	 * Se crea una variable del mismo tipo de la clase para usar el patron singleton, dicha variable se instancia por
	 * única vez y se devuelve al cliente.
	 */
	public static final PropertyLoader INSTANCE = new PropertyLoader();

	/**
	 * Mapa que almacena las propiedades cargadas del archivo externo al proyecto.
	 */
	private final Map<String, Map<String, String>> propertyMap = new HashMap<String, Map<String, String>>();

	/**
	 * Constructor.
	 */
	private PropertyLoader() {
		// Se deja vacio por conveniencia.
	}

	/**
	 * Carga las propiedades en el mapa de acuerdo al nombre del archivo.
	 * 
	 * @param filePath
	 *            nombre del archivo de propiedades.
	 */
	public void loadPropertiesFile(final String filePath) {
		InputStream fin = null;
		try {
			Map<String, String> propertiesMap = new HashMap<String, String>();
			// Se carga el flujo del recurso
			fin = this.getClass().getResourceAsStream(filePath);
			// Se cargan las propiedades y se ingresan en el map de la utilidad
			final Properties properties = new Properties();
			properties.load(fin);

			for (Entry<Object, Object> entry : properties.entrySet()) {
				propertiesMap.put(entry.getKey().toString(), entry.getValue().toString());
			}
			// Se ingresan todos los properties en el map singleton.
			propertyMap.put(filePath, propertiesMap);
		} catch (FileNotFoundException ex) {
			LOGGER.error("FileNotFoundException PropertyLoader - ", ex);
		} catch (Exception ex) {
			LOGGER.error(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.EXCEPTION.getDescription()), ex);
		} finally {
			Utilities.closeStream(fin);
		}
	}
	
    /**
     * Método encargado de cargar una propiedad de un archivo cargado como resource, si el archivo ya se ha cargado
     * anteriormente no lo cargará más.
     * 
     * @autor SWAT-IT <br>
     *        Cristian Camilo Londoño <br>
     *        Email: clondono@swat-it.co <br>
     * @date 13/01/2017
     * @version 1.0
     *
     * @param fileName
     *            {@link String} con el nombre del archivo desde el cual cargar la propieda
     * @param nameProperty
     *            {@link String} con el nombre de la propiedad que se desea cargar
     * @return el valor de la propiedad
     */
    public String getPropertyInternal(String fileName, String nameProperty) {
        /* Se valida si se ha cargado el archivo anteriormente */
        if (propertyMap.get(fileName) == null) {
            loadPropertiesFile(fileName);
        }
        /* Se valida que exista el archivo */
        if (propertyMap.get(fileName) != null) {
            /* Se retorna la propiedad */
            return propertyMap.get(fileName).get(nameProperty);
        }
        return null;
    }

	/**
	 * Metodo que obtiene el valor de una propiedad desde un archivo externo al proyecto
	 * 
	 * @param filePath
	 *            , con la ubicación del archivo desde el cual se debe cargar la propiedad.
	 * @param propertyName
	 *            , con el nombre de la propiedad a cargar.
	 * @return {@link String}, el valor de la propiedad.
	 */
	private String getPropertyValue(final String filePath, final String propertyName) {
		String value = null;
		if (filePath.equalsIgnoreCase(ErrorMessagesLoader.EXCEPTIONFILE)) {
			value = loadPropertyFile(filePath, propertyName);
		} else {
			InputStream fin = null;
			try {
				fin = new FileInputStream(filePath);
				if (Validation.isNotNull(fin)) {
					Properties properties = new Properties();
					properties.load(fin);
					value = properties.getProperty(propertyName);
				}
			} catch (IOException ex) {
				LOGGER.error(ErrorMessagesLoader.INSTANCE.getErrorMensage(CodeErrorEnum.IOEXCEPTION.getDescription()),
						ex);
			} finally {
				Utilities.closeStream(fin);
			}
		}

		return value;
	}

	/**
	 * Método que permite la carga de una propiedad de un archivo.
	 * 
	 * @param fileName
	 *            , con el nombre del archivo desde el cual cargar la propiedad.
	 * @param propertyName
	 *            , nombre de la propiedad a cargar.
	 * @return {@link String}, el valor de la propiedad.
	 */
	private String loadPropertyValue(final String fileName, final String propertyName) {
		String propertyValue = getPropertyValue(fileName, propertyName);

		if (Validation.isNullOrEmpty(propertyValue)) {
			LOGGER.info("No existe la propiedad " + propertyName + " en el recurso " + fileName + ".");
		} else {
			Map<String, String> propertiesMap;
			if (propertyMap.containsKey(fileName)) {
				propertiesMap = propertyMap.get(fileName);
			} else {
				propertiesMap = new HashMap<String, String>();
				propertyMap.put(fileName, propertiesMap);
			}
			propertiesMap.put(propertyName, propertyValue);
		}
		return propertyValue;
	}

	/**
	 * Método que permite la carga de una propiedad de un archivo externo.
	 * 
	 * @param fileName
	 *            , con el nombre del archivo desde el cual cargar la propieda
	 * @param propName
	 *            , nombre de la propiedad a cargar.
	 * @return {@link String}, el valor de la propiedad.
	 */
	public String getProperty(final String fileName, final String propName) {
		String response;
		if (propertyMap.containsKey(fileName)) {
			final Map<String, String> propertiesMap = propertyMap.get(fileName);
			if (Validation.isNull(propertiesMap) || propertiesMap.isEmpty()) {
				response = loadPropertyValue(fileName, propName);
			} else {
				if (propertiesMap.containsKey(propName)) {
					response = propertiesMap.get(propName);
				} else {
					response = loadPropertyValue(fileName, propName);
				}
			}
		} else {
			response = loadPropertyValue(fileName, propName);
		}
		return response;
	}

	/**
	 * Método encargado de cargar una propiedad de un archivo cargado como resource.
	 * 
	 * @param filePath
	 *            , con el path del archivo.
	 * @param property
	 *            , con el nombre de la propiedad.
	 * @return {@link String}, el valor de la propiedad.
	 */
	public String loadPropertyFile(final String filePath, final String property) {
		String result = null;
		InputStream fin = null;
		try {
			// Se carga el flujo del recurso
			fin = this.getClass().getResourceAsStream(filePath);
			// Se cargan las propiedades y se ingresan en el map de la utilidad
			final Properties properties = new Properties();
			properties.load(fin);

			result = properties.getProperty(property);
		} catch (IOException e) {
			LOGGER.error("IOException PropertyLoader - ", e);
		} finally {
			Utilities.closeStream(fin);
		}
		return result;
	}

	/**
	 * Metodo encargado de cargar en un mapa las propiedades definidas en un archivo .properties fuera del proyecto.
	 * 
	 * @param pathFile
	 *            {@link String} define la ruta del archivo de propiedades contenida en el proyecto.
	 */
	public void loadExternalProperties(final String pathFile) {
		Map<String, String> propertiesMap;
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(pathFile);
			// Se cargan las propiedades
			Properties properties = new Properties();
			properties.load(inputStream);
			// Se ingresan las propiedades en el mapa
			propertiesMap = new HashMap<String, String>();
			for (Entry<Object, Object> entry : properties.entrySet()) {
				propertiesMap.put(entry.getKey().toString(), entry.getValue().toString());
			}
		} catch (IOException e) {
			propertiesMap = new HashMap<String, String>();
		} finally {
			Utilities.closeStream(inputStream);
		}
		propertyMap.put(pathFile, propertiesMap);
	}

	/**
	 * Método encargado de eliminar las propiedades cargadas para obligar a la aplicación a cargarlas nuevamente.
	 */
	public void resetProperties() {
		propertyMap.clear();
	}
	
	
	/**
	 * 
	 * Método que lee el contenido de un archivo y lo retorna como un String
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 13/03/2017
	 *
	 * @param pathFile
	 *            , path del archivo a leer
	 * @return String con el contenido del archivo
	 * @throws BusinessException
	 *             , cuando ocurra un error de Lectura del archivo
	 */
	public String loadFileNoCache(String pathFile) throws BusinessException {
		try {
			return Files.toString(new File(pathFile), Charsets.UTF_8);
		} catch (IOException e) {
			throw new BusinessException(CodeErrorEnum.IOEXCEPTION, e);
		}
	}
}

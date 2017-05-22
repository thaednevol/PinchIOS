package co.swatit.pilautil.request.rest;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import co.swatit.pilautil.exception.BusinessException;
import co.swatit.pilautil.exception.InvokeException;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;

/**
 * Clase que contiene métodos de conversión de objetos.
 * 
 * @author Swat-It <br>
 *         Jessica Antía Hortúa <br>
 *         Email: jantia@swat-it.co<br>
 * @date 25/10/2016
 * @version 1.0
 * 
 */
public class ParserUtils {

	/** Instancia de la clase para poder acceder a las utilidades de parseo */
	public static final ParserUtils INSTANCE = new ParserUtils();
	/** Logger de la clase */
	private static final Logger LOGGER = Logger.getLogger(ParserUtils.class);

	/** Mapa de contextos para el manejo de JAXB */
	private static Map<String, JAXBContext> contexts = new HashMap<String, JAXBContext>();

	/**
	 * 
	 * Utilidad para parsear un StringXml a un objeto.
	 * 
	 * @param source
	 *            recurso Xml a parsear.
	 * @param object
	 *            objeto al cual se parseara.
	 * @return el objeto parseado.
	 */
	@SuppressWarnings("unchecked")
	public <T> T parserXmlToObject(String source, Class<T> object) throws InvokeException {
		T response = null;
		try {
			if (source != null && object != null) {
				JAXBContext jaxbContext = contexts.get(object.getCanonicalName());
				if (jaxbContext == null) {
					jaxbContext = JAXBContext.newInstance(object);
					contexts.put(object.getCanonicalName(), jaxbContext);
				}
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				StringReader reader = new StringReader(source);
				Object objTemp = unmarshaller.unmarshal(reader);
				response = (T) objTemp;
			} else {
				LOGGER.error("El XML a parsear es null");
			}
		} catch (JAXBException ex) {
			throw new InvokeException(CodeErrorEnum.PARSERESPONSEERROR, ex);
		}
		return response;
	}

	/**
	 * 
	 * Utilidad para hacer parseo de una cadena de tipo JSON a un objeto
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 19/01/2017
	 *
	 * @param source
	 *            , cadena JSON a convertir
	 * @param object
	 *            , clase del objeto a ser convertido
	 * @return, el objeto resultado de la conversión
	 * @throws JsonParseException
	 *             , la estructura del JSON es inválida o no está bien definida
	 * @throws JsonMappingException
	 *             , la estructura del objeto no puede ser identificada con el JSON
	 * @throws IOException.
	 */
	public <T> T parseJSONToObject(String source, Class<T> object) throws JsonParseException, JsonMappingException,
			IOException {
		T response = null;
		if (source != null && object != null) {
			response = (T) new ObjectMapper().readValue(source, object);
		} else {
			LOGGER.error("El JSON a parsear es null");
		}
		return response;
	}

	/**
	 * Método que realiza el parseo de una cadena con formato JSON a una lista de objetos
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 13/03/2017
	 *
	 * @param source
	 *            , cadena JSON a convertir
	 * @param objectClass
	 *            , clase de los objetos a convertir
	 * @return la lista de objetos resultado de la conversion
	 * @throws BusinessException
	 *             , cuando ocurre un error en una operación IO
	 */
	public <T> List<T> parseJSONArrayToList(String source, Class<T> objectClass) throws BusinessException {
		List<T> response = new ArrayList<T>();
		if (source != null && objectClass != null) {
			try {
				response = new ObjectMapper().readValue(source,
						TypeFactory.defaultInstance().constructCollectionType(List.class, objectClass));
			} catch (JsonParseException e) {
				throw new BusinessException(CodeErrorEnum.ERRORPARSEJSON, e);
			} catch (JsonMappingException e) {
				throw new BusinessException(CodeErrorEnum.ERRORPARSEJSON, e);
			} catch (IOException e) {
				throw new BusinessException(CodeErrorEnum.IOEXCEPTION, e);
			}
		} else {
			LOGGER.error("El JSON a parsear es null");
		}
		return response;
	}

	/**
	 * 
	 * Método que convierte un objeto en una cadena JSON
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 19/01/2017
	 *
	 * @param object
	 *            , objeto a ser convertido
	 * @return {@link String}, contiene el JSON generado a partir del objeto
	 * @throws JsonProcessingException
	 *             , cuando el objeto no puede ser convertido
	 */
	public String convertObjectToJSON(Object object) throws JsonProcessingException {
		String response = null;
		if (object != null) {
			response = new ObjectMapper().writeValueAsString(object);
		} else {
			LOGGER.error("El Objeto a convertir es null");
		}
		return response;
	}
}

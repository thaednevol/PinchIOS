package co.swatit.pilautil.request.rest;

import java.net.Authenticator; 
import java.net.PasswordAuthentication; 
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

import co.swatit.pilautil.constants.NumberConstants;
import co.swatit.pilautil.exception.InvokeException;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;

/**
 * Clase encarga de construir y enviar las peticiones a los servicios web REST.
 * 
 * @author Swat-It <br>
 *         Jessica Antía Hortúa <br>
 *         Email: jantia@swat-it.co<br>
 * @date 25/10/2016
 * @version 1.0
 * 
 */
public final class ServiceRequestProvider {

	/** Objeto instancia de log4j. */
	private static final Logger LOGGER = Logger.getLogger(ServiceRequestProvider.class.getName());

	/**
	 * Constructor.
	 */
	private ServiceRequestProvider() {
		// Se deja vacio intencionalmente.
	}

	/**
	 * 
	 * Cliente para hacer una peticion post especificando la url del ws y la operacion especifica a consumir ademas la
	 * peticion
	 * 
	 * @param url
	 *            , url en la cual se encuentra expuesto el servicio web.
	 * @param operation
	 *            , path del servicio especifico en caso de no estar anexo en la URL.
	 * @param request
	 *            , objeto de entrada como parámetro al servicio.
	 * @return {@link String}, con la respuesta recibida desde el servicio web consumido.
	 * @throws InvokeException
	 *             , en caso de que se presenten problemas en la invocación como timeout o no conexión, y en caso de que
	 *             no se obtenga una respuesta.
	 */
	public static String callPostWS(final String url, final String operation, final Object request)
			throws InvokeException {
		return callPostWS(url, operation, request, MediaType.APPLICATION_XML);
	}

	/**
	 * Cliente para hacer una peticion POST administrando la ruta y la petición.
	 * 
	 * @param url
	 *            , url en la cual se encuentra expuesto el servicio web.
	 * @param request
	 *            , objeto de entrada como parámetro al servicio.
	 * @return {@link String}, con la respuesta recibida desde el servicio web consumido.
	 * @throws InvokeException
	 *             , en caso de que se presenten problemas en la invocación como timeout o no conexión, y en caso de que
	 *             no se obtenga una respuesta.
	 */
	public static String callPostWS(final String url, final Object request) throws InvokeException {
		return callPostWS(url, null, request, MediaType.APPLICATION_XML);
	}

	/**
	 * Realiza la invocacion de un ws post.
	 * 
	 * @param url
	 *            , url en la cual se encuentra expuesto el servicio web.
	 * @param operation
	 *            , path del servicio especifico en caso de no estar anexo en la URL.
	 * @param request
	 *            , objeto de entrada como parámetro al servicio.
	 * @param mediaType
	 *            , tipo mediaType aceptado por el servicio.
	 * 
	 * @return {@link String}, con la respuesta recibida desde el servicio web consumido.
	 * @throws InvokeException
	 *             , en caso de que se presenten problemas en la invocación como timeout o no conexión, y en caso de que
	 *             no se obtenga una respuesta.
	 */
	public static String callPostWS(final String url, String operation, final Object request, final String mediaType)
			throws InvokeException {
		try {
			// Se invoca el recurso web y se valida el response.
			return getResponseFromService(invokeWebResource(request, mediaType, getWebResource(url, operation)));
		} catch (ClientHandlerException ex) {
			LOGGER.error("Error invocacion: ",ex);
			throw new InvokeException(CodeErrorEnum.GETRESPONSECLIENTERROR, ex);
		} catch (UniformInterfaceException ex) {
			throw new InvokeException(CodeErrorEnum.WSCLIENTERROR, ex);
		}
	}

	/**
	 * Método encargado de obtener el WebResource por medio de la url y la operation.
	 * 
	 * @param url
	 *            , con la url del servicio a consumir.
	 * @param operation
	 *            , con la operación a ejecutar del servicio.
	 * @return {@link WebResource}, con el recurso web construido.
	 * @throws InvokeException
	 *             , en caso de que la url sea null.
	 */
	private static WebResource getWebResource(String url, String operation) throws InvokeException {
		WebResource webResource;
		if (url != null) {
			LOGGER.info(new StringBuilder("Invocando el servicio web:: ").append(url).append("::Operation:").append(operation).toString());
			initializeProxyAuthenticator(); 
			Client client = Client.create();
			webResource = client.resource(url);
			if (operation != null) {
				webResource = webResource.path(operation);
			}
		} else {
			LOGGER.info("El parámetro url es null.");
			throw new InvokeException(CodeErrorEnum.WSCLIENTERROR);
		}
		return webResource;
	}

	private static void initializeProxyAuthenticator() {
		final String proxyUser = System.getProperty("http.proxyUser"); 
		final String proxyPassword = System.getProperty("http.proxyPassword");
		
		if ( System.getProperty("http.proxyHost")!=null ){			
			System.setProperty("https.proxyHost", System.getProperty("http.proxyHost"));		
		}		
		
		if ( System.getProperty("http.proxyPort")!=null ){			
			System.setProperty("https.proxyPort", System.getProperty("http.proxyPort"));		
		}		
		
		if ( System.getProperty("http.proxyPassword")!=null ){			
			System.setProperty("https.proxyPassword", System.getProperty("http.proxyPassword"));		
		}		
		
		if ( System.getProperty("http.proxyUser")!=null ){			
			System.setProperty("https.proxyUser", System.getProperty("http.proxyUser"));		
		}
		
		if (proxyUser != null && proxyPassword != null) {
			Authenticator.setDefault(new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(proxyUser, proxyPassword.toCharArray());
				} 
            });
		}
	}

	/**
	 * Método encargado de obtener la respuesta del servicio.
	 * 
	 * @param response
	 *            , con la respuesta recibida en la invocación de un servicio.
	 * @return {@link String}, con la respuesta obtenida.
	 * @throws InvokeException
	 *             , en caso de que la respuesta del servicio
	 */
	private static String getResponseFromService(ClientResponse response) throws InvokeException {
		String output;
		if ( response!=null ){
			LOGGER.info("Status respuesta:::" + response.getStatus());
		}
		if (response != null && response.getStatus() == NumberConstants.TWO_HUNDRED) {
			output = response.getEntity(String.class);
			if (output == null) {
				throw new InvokeException(CodeErrorEnum.WSEMPTYRESPONSE);
			}
		} else {
			LOGGER.error("ServiceRequestProvider:::getResponseFromService:::Variable response vacia.");
			throw new InvokeException(CodeErrorEnum.WSCLIENTERROR);
		}
		return output;
	}

	/**
	 * Método encargado de realizar la invocación del recurso web.
	 * 
	 * @param request
	 *            , con los datos a enviar a la petición como parámetros.
	 * @param mediaType
	 *            , con el mediaType del servicio post a consumir.
	 * @param webResource
	 *            , con el recurso web a consumir.
	 * @return {@link ClientResponse}, con la respuesta generada por el recurso web.
	 */
	private static ClientResponse invokeWebResource(final Object request, final String mediaType,
			WebResource webResource) {
		LOGGER.info("Request: "+request);
		LOGGER.info("Request Class: "+request.getClass());	
		LOGGER.info("mediaType: "+mediaType);
		ClientResponse response;
		if (request != null) {
			// Se establecen los parametros del servicio
			if (request instanceof Map) {
				@SuppressWarnings("unchecked")
				Map<String, String> params = (Map<String, String>) request;
				Form form = new Form();
				for (Map.Entry<String, String> entry : params.entrySet()) {
					LOGGER.info(new StringBuilder(entry.getKey()).append(" = ").append(entry.getValue()).toString());
					form.add(entry.getKey(), entry.getValue());
				}
				response = webResource.accept(mediaType).post(ClientResponse.class, form);
			} else {
				response = webResource.type(mediaType).accept(mediaType).post(ClientResponse.class, request);
			}
		} else {
			response = webResource.accept(mediaType).post(ClientResponse.class);
		}
		LOGGER.info("Response: "+response);
		return response;
	}

}

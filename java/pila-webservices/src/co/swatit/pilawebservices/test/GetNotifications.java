package co.swatit.pilawebservices.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import co.swatit.pilautil.dto.in.GetNotificationsInDTO;
import co.swatit.pilautil.dto.out.GetNotificationsOutDTO;
import co.swatit.pilautil.exception.InvokeException;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;
import co.swatit.pilautil.generics.Constants;
import co.swatit.pilautil.request.rest.ParserUtils;
import co.swatit.pilautil.request.rest.ServiceRequestProvider;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * Clase que provee los test para la historia de usuario Exponer servicio de obtener notificaciones
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 14/03/2017
 * @version 1.0
 */
public class GetNotifications {
	public static final String URL = "http://172.16.10.207:7001/pila-webservices/PilaWS/getNotifications";

	/**
	 * 
	 * Método que realiza una invocación al servicio web getNotifications
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/03/2017
	 *
	 * @param inDTO
	 *            , objeto de transporte con los parámetros de entrada del servicio
	 * @return {@link GetNotificationsOutDTO} con la respuesta del servicio
	 */
	public GetNotificationsOutDTO invokeGetNotifications(GetNotificationsInDTO inDTO) {
		GetNotificationsOutDTO outDTO = new GetNotificationsOutDTO();
		try {
			outDTO = ParserUtils.INSTANCE.parseJSONToObject(ServiceRequestProvider.callPostWS(URL, null,
					ParserUtils.INSTANCE.convertObjectToJSON(inDTO), MediaType.APPLICATION_JSON),
					GetNotificationsOutDTO.class);
		} catch (InvokeException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outDTO;
	}

	/**
	 * 
	 *
	 * Método que inicializa un DTO de entrada al servicio con datos de entrada válidos
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/03/2017
	 *
	 * @return el DTO con los parámetros inicializados
	 */
	public GetNotificationsInDTO testSetup() {
		GetNotificationsInDTO inDTO = new GetNotificationsInDTO();
		inDTO.setVersion("1.3.2");
		inDTO.setToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjoiMTg0MDExMzAiLCJpYXQiOjE0ODk0OTk5OTQsImV4cCI6MTQ4OTU4NjM5NH0.I5L46VviB1TZ8X-As7TGtYuMNyWlsEkdxlLkw1YJBbM");
		return inDTO;
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene las notificaciones cuando el parámetro token es
	 * nulo
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/03/2017
	 *
	 */
	@Test
	public void testTokenNull() {
		GetNotificationsInDTO inDTO = testSetup();
		inDTO.setToken(null);
		GetNotificationsOutDTO outDTO = invokeGetNotifications(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene las notificaciones cuando el parámetro token está
	 * vacío
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/03/2017
	 *
	 */
	@Test
	public void testTokenEmpty() {
		GetNotificationsInDTO inDTO = testSetup();
		inDTO.setToken(Constants.EMPTY);
		GetNotificationsOutDTO outDTO = invokeGetNotifications(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene las notificaciones cuando el parámetro token no es
	 * válido
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/03/2017
	 *
	 */
	@Test
	public void testInvalidToken() {
		GetNotificationsInDTO inDTO = testSetup();
		inDTO.setToken("NOT AN AUTHORIZED TOKEN");
		GetNotificationsOutDTO outDTO = invokeGetNotifications(inDTO);
		assertEquals(CodeErrorEnum.ERRORTOKENNOTAUTHORIZED.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene las notificaciones cuando el parámetro version
	 * está vacío
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/03/2017
	 *
	 */
	@Test
	public void testVersionEmpty() {
		GetNotificationsInDTO inDTO = testSetup();
		inDTO.setVersion(Constants.EMPTY);
		GetNotificationsOutDTO outDTO = invokeGetNotifications(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene las notificaciones cuando el parámetro version es
	 * nulo
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/03/2017
	 *
	 */
	@Test
	public void testVersionNull() {
		GetNotificationsInDTO inDTO = testSetup();
		inDTO.setVersion(null);
		GetNotificationsOutDTO outDTO = invokeGetNotifications(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}
	
	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene las notificaciones cuando el parámetro version es
	 * inválido
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/03/2017
	 *
	 */
	@Test
	public void testVersionInvalid() {
		GetNotificationsInDTO inDTO = testSetup();
		inDTO.setVersion("NOT A VALID VERSION");
		GetNotificationsOutDTO outDTO = invokeGetNotifications(inDTO);
		assertEquals(CodeErrorEnum.ERRORCLIENTVERSIONNUMBER.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene las notificaciones según el flujo normal
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 14/03/2017
	 *
	 */
	@Test
	public void testNormalFlow() {
		GetNotificationsInDTO inDTO = testSetup();
		GetNotificationsOutDTO outDTO = invokeGetNotifications(inDTO);
		assertEquals(CodeErrorEnum.SUCCESSFULL.getCode(), outDTO.getCode());
	}
}

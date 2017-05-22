/**
 * 
 */
package co.swatit.pilawebservices.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import co.swatit.pilautil.constants.NumberConstants;
import co.swatit.pilautil.dto.in.GetContributorsInformationInDTO;
import co.swatit.pilautil.dto.out.GetContributorsInformationOutDTO;
import co.swatit.pilautil.exception.InvokeException;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;
import co.swatit.pilautil.generics.Constants;
import co.swatit.pilautil.request.rest.ParserUtils;
import co.swatit.pilautil.request.rest.ServiceRequestProvider;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * Clase que provee los test sobre el servicio web getContributorsInformation
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 10/04/2017
 * @version 1.0
 */
public class GetContributorsInformation {
	public static final String URL = "http://172.16.10.207:7001/pila-webservices/PilaWS/getContributorsInformation";

	/**
	 * 
	 * Método que realiza una invocación al servicio web getContributorsInformation
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 10/04/2017
	 *
	 * @param inDTO
	 *            , objeto de transporte con los parámetros de entrada del servicio
	 * @return {@link GetContributorsInformationOutDTO} con la respuesta del servicio
	 */
	public GetContributorsInformationOutDTO invokeGetContributorsInformation(GetContributorsInformationInDTO inDTO) {
		GetContributorsInformationOutDTO outDTO = new GetContributorsInformationOutDTO();
		try {
			outDTO = ParserUtils.INSTANCE.parseJSONToObject(ServiceRequestProvider.callPostWS(URL, null,
					ParserUtils.INSTANCE.convertObjectToJSON(inDTO), MediaType.APPLICATION_JSON),
					GetContributorsInformationOutDTO.class);
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
	 * @date 10/04/2017
	 *
	 * @return el DTO con los parámetros inicializados
	 */
	public GetContributorsInformationInDTO testSetup() {
		GetContributorsInformationInDTO inDTO = new GetContributorsInformationInDTO();
		inDTO.setToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjoiMTg0MDExMzAiLCJpYXQiOjE0ODk0OTk5OTQsImV4cCI6MTQ4OTU4NjM5NH0.I5L46VviB1TZ8X-As7TGtYuMNyWlsEkdxlLkw1YJBbM");
		inDTO.getContributorsIds().add("10127244");
		inDTO.getContributorsIds().add("10127245");
		inDTO.getContributorsIds().add("10127246");
		inDTO.getContributorsIds().add("10127247");
		return inDTO;
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene la información de los aportantes cuando el
	 * parámetro token es nulo
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 10/04/2017
	 *
	 */
	@Test
	public void testTokenNull() {
		GetContributorsInformationInDTO inDTO = testSetup();
		inDTO.setToken(null);
		GetContributorsInformationOutDTO outDTO = invokeGetContributorsInformation(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene la información de los aportantes cuando el
	 * parámetro token está vacío
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 10/04/2017
	 *
	 */
	@Test
	public void testTokenEmpty() {
		GetContributorsInformationInDTO inDTO = testSetup();
		inDTO.setToken(Constants.EMPTY);
		GetContributorsInformationOutDTO outDTO = invokeGetContributorsInformation(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene la información de los aportantes cuando el
	 * parámetro token no es válido
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 10/04/2017
	 *
	 */
	@Test
	public void testInvalidToken() {
		GetContributorsInformationInDTO inDTO = testSetup();
		inDTO.setToken("NOT AN AUTHORIZED TOKEN");
		GetContributorsInformationOutDTO outDTO = invokeGetContributorsInformation(inDTO);
		assertEquals(CodeErrorEnum.ERRORTOKENNOTAUTHORIZED.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene la información de los aportantes cuando el
	 * parámetro contributorsIds está vacío
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 10/04/2017
	 *
	 */
	@Test
	public void testEmptyContributorsIds() {
		GetContributorsInformationInDTO inDTO = testSetup();
		inDTO.getContributorsIds().clear();
		GetContributorsInformationOutDTO outDTO = invokeGetContributorsInformation(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene la información de los aportantes cuando el
	 * parámetro contributorsIds contiene un elemento que no es un número entero
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 10/04/2017
	 *
	 */
	@Test
	public void testInvalidContributorId() {
		GetContributorsInformationInDTO inDTO = testSetup();
		inDTO.getContributorsIds().add("NOT A NUMBER");
		GetContributorsInformationOutDTO outDTO = invokeGetContributorsInformation(inDTO);
		assertEquals(CodeErrorEnum.ERRORINVALIDIDENTIFICATIONNUMBER.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene la información de los aportantes cuando el
	 * parámetro contributorsIds contiene un elemento que no existe en SOI
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 10/04/2017
	 *
	 */
	@Test
	public void testNotFoundContributorId() {
		GetContributorsInformationInDTO inDTO = testSetup();
		// Este id de aportante no está registrado en SOI
		inDTO.getContributorsIds().add("1");
		GetContributorsInformationOutDTO outDTO = invokeGetContributorsInformation(inDTO);
		assertEquals(CodeErrorEnum.SUCCESSFULL.getCode(), outDTO.getCode());
		assertEquals(NumberConstants.ONE, outDTO.getContributorsNotFound().size());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene la información de los aportantes cuando todos los
	 * parámetros son correctos y no hay ningún error de validación, además se obtienen todos los datos correctamente
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 10/04/2017
	 *
	 */
	@Test
	public void testNormalFlow() {
		GetContributorsInformationInDTO inDTO = testSetup();
		GetContributorsInformationOutDTO outDTO = invokeGetContributorsInformation(inDTO);
		assertEquals(CodeErrorEnum.SUCCESSFULL.getCode(), outDTO.getCode());
		assertEquals(NumberConstants.ZERO, outDTO.getContributorsNotFound().size());
	}

}

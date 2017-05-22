package co.swatit.pilawebservices.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import co.swatit.pilautil.dto.in.GetValidationFileConfigInDTO;
import co.swatit.pilautil.dto.out.GetValidationFileConfigOutDTO;
import co.swatit.pilautil.exception.InvokeException;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;
import co.swatit.pilautil.generics.Constants;
import co.swatit.pilautil.request.rest.ParserUtils;
import co.swatit.pilautil.request.rest.ServiceRequestProvider;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * 
 * Clase que provee los test de la historia de usuario obtener la configuración de la aplicación
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 6/03/2017
 * @version 1.0
 */
public class GetValidationFileConfig {
	public static final String URL = "http://172.16.10.207:7001/pila-webservices/PilaWS/getValidationFileConfig";

	/**
	 * 
	 * Método que realiza una invocación al servicio web getValidationFileConfig
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 6/03/2017
	 *
	 * @param inDTO
	 *            , objeto de transporte con los parámetros de entrada del servicio
	 * @return {@link GetValidationFileConfigOutDTO} con la respuesta del servicio
	 */
	public GetValidationFileConfigOutDTO invokeAppConfigWS(GetValidationFileConfigInDTO inDTO) {
		GetValidationFileConfigOutDTO outDTO = new GetValidationFileConfigOutDTO();
		try {
			outDTO = ParserUtils.INSTANCE.parseJSONToObject(ServiceRequestProvider.callPostWS(URL, null,
					ParserUtils.INSTANCE.convertObjectToJSON(inDTO), MediaType.APPLICATION_JSON),
					GetValidationFileConfigOutDTO.class);
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
	 * Método que inicializa un DTO de entrada al servicio con datos de entrada válidos
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/02/2017
	 *
	 * @return 
	 */
	public GetValidationFileConfigInDTO testSetup() {
		GetValidationFileConfigInDTO setup = new GetValidationFileConfigInDTO();
		setup.setIdSoiAportante("4041");
		setup.setIdSegUsuario("4567");
		setup.setRegTp01("0110001APORTANTE JGUTIERREZ                                                                                                                                                                                    NI18401130        6E                    S1000      SUCURSAL 1000                           14-23 2016-112016-1276480860472016-11-28002500011380920001022");
		setup.setToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjoiMTg0MDExMzAiLCJpYXQiOjE0OTEyMzM1MzcsImV4cCI6MTQ5MTMxOTkzN30.tDMZX9SV7rI0hw5Y_SCLJfFMlizwv0UcEJfztNruPt0");
		return setup;
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de configuración cuando el parámetro idSoiAportante es nulo
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/02/2017
	 *
	 */
	@Test
	public void testIdSoiAportanteNull() {
		GetValidationFileConfigInDTO inDTO = testSetup();
		inDTO.setIdSoiAportante(null);
		GetValidationFileConfigOutDTO outDTO = invokeAppConfigWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de configuración cuando el parámetro idSoiAportante está vacío
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/02/2017
	 *
	 */
	@Test
	public void testIdSoiAportanteEmpty() {
		GetValidationFileConfigInDTO inDTO = testSetup();
		inDTO.setIdSoiAportante(Constants.EMPTY);
		GetValidationFileConfigOutDTO outDTO = invokeAppConfigWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de configuración cuando el parámetros idSoiAportante no es un
	 * número
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/02/2017
	 *
	 */
	@Test
	public void testIdSoiAportanteNotInteger() {
		GetValidationFileConfigInDTO inDTO = testSetup();
		inDTO.setIdSoiAportante("NOT A NUMBER");
		GetValidationFileConfigOutDTO outDTO = invokeAppConfigWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORINTEGERFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de configuración cuando el parámetro idSegUsuario es nulo
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/02/2017
	 *
	 */
	@Test
	public void testIdSegUsuarioNull() {
		GetValidationFileConfigInDTO inDTO = testSetup();
		inDTO.setIdSegUsuario(null);
		GetValidationFileConfigOutDTO outDTO = invokeAppConfigWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de configuración cuando el parámetro idSegUsuario está vacío
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/02/2017
	 *
	 */
	@Test
	public void testIdSegUsuarioEmpty() {
		GetValidationFileConfigInDTO inDTO = testSetup();
		inDTO.setIdSegUsuario(Constants.EMPTY);
		GetValidationFileConfigOutDTO outDTO = invokeAppConfigWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de configuración cuando el parámetros idSegUsuario no es un
	 * número
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/02/2017
	 *
	 */
	@Test
	public void testIdSegUsuarioNotInteger() {
		GetValidationFileConfigInDTO inDTO = testSetup();
		inDTO.setIdSegUsuario("NOT A NUMBER");
		GetValidationFileConfigOutDTO outDTO = invokeAppConfigWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORINTEGERFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de configuración cuando el parámetro token es nulo
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/02/2017
	 *
	 */
	@Test
	public void testTokenNull() {
		GetValidationFileConfigInDTO inDTO = testSetup();
		inDTO.setToken(null);
		GetValidationFileConfigOutDTO outDTO = invokeAppConfigWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de configuración cuando el parámetro token está vacío
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/02/2017
	 *
	 */
	@Test
	public void testTokenEmpty() {
		GetValidationFileConfigInDTO inDTO = testSetup();
		inDTO.setToken(Constants.EMPTY);
		GetValidationFileConfigOutDTO outDTO = invokeAppConfigWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * 
	 * Test que comprueba el funcionamiento del servicio de configuración cuando el parámetro token no es válido
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/02/2017
	 *
	 */
	@Test
	public void testInvalidToken() {
		GetValidationFileConfigInDTO inDTO = testSetup();
		inDTO.setToken("NOT AN AUTHORIZED TOKEN");
		GetValidationFileConfigOutDTO outDTO = invokeAppConfigWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORTOKENNOTAUTHORIZED.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de configuración cuando el parámetro regTp01 es nulo
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/02/2017
	 *
	 */
	@Test
	public void testregTp01Null() {
		GetValidationFileConfigInDTO inDTO = testSetup();
		inDTO.setRegTp01(null);
		GetValidationFileConfigOutDTO outDTO = invokeAppConfigWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de configuración cuando el parámetro regTp01 está vacío
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/02/2017
	 *
	 */
	@Test
	public void testregTp01Empty() {
		GetValidationFileConfigInDTO inDTO = testSetup();
		inDTO.setRegTp01(Constants.EMPTY);
		GetValidationFileConfigOutDTO outDTO = invokeAppConfigWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * 
	 * Test que comprueba el funcionamiento del servicio de configuración cuando el parámetro regTp01 no es válido
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/02/2017
	 *
	 */
	@Test
	public void testregTp01Invalid() {
		GetValidationFileConfigInDTO inDTO = testSetup();
		inDTO.setRegTp01("NOT A VALID VALUE");
		GetValidationFileConfigOutDTO outDTO = invokeAppConfigWS(inDTO);
		/** Código de error provisto por SOI para este caso de prueba */
		assertEquals("20003", outDTO.getCode());
	}

	/**
	 * Se hace una petición al servicio usando un idSoiAportante que no existe en SOI
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 21/02/2017
	 *
	 */
	public void testNoDataFound() {
		GetValidationFileConfigInDTO inDTO = testSetup();
		inDTO.setIdSoiAportante("999999999");
		GetValidationFileConfigOutDTO outDTO = invokeAppConfigWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORUNEXPECTED.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento normal del servicio
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 20/02/2017
	 *
	 */
	@Test
	public void testNormalFlow() {
		GetValidationFileConfigOutDTO outDTO = invokeAppConfigWS(testSetup());
		assertEquals(CodeErrorEnum.SUCCESSFULL.getCode(), outDTO.getCode());
	}

}

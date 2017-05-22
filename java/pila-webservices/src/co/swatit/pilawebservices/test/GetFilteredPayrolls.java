package co.swatit.pilawebservices.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import co.swatit.pilautil.dto.in.GetFilteredPayrollsInDTO;
import co.swatit.pilautil.dto.out.GetFilteredPayrollsOutDTO;
import co.swatit.pilautil.exception.InvokeException;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;
import co.swatit.pilautil.generics.Constants;
import co.swatit.pilautil.request.rest.ParserUtils;
import co.swatit.pilautil.request.rest.ServiceRequestProvider;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * Clase que provee los test de la historia de usuario Obtener listado de planillas
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 9/03/2017
 * @version 1.0
 */
public class GetFilteredPayrolls {
	public static final String URL = "http://172.16.10.207:7001/pila-webservices/PilaWS/getFilteredPayrolls";

	/**
	 * 
	 * Método que realiza una invocación al servicio web getFilteredPayrolls
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 9/03/2017
	 *
	 * @param inDTO
	 *            , objeto de transporte con los parámetros de entrada del servicio
	 * @return {@link GetFilteredPayrollsOutDTO} con la respuesta del servicio
	 */
	public GetFilteredPayrollsOutDTO invokeGetFilteredPayrolls(GetFilteredPayrollsInDTO inDTO) {
		GetFilteredPayrollsOutDTO outDTO = new GetFilteredPayrollsOutDTO();
		try {
			outDTO = ParserUtils.INSTANCE.parseJSONToObject(ServiceRequestProvider.callPostWS(URL, null,
					ParserUtils.INSTANCE.convertObjectToJSON(inDTO), MediaType.APPLICATION_JSON),
					GetFilteredPayrollsOutDTO.class);
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
	 * @date 9/03/2017
	 *
	 * @return el DTO con los parámetros inicializados
	 */
	public GetFilteredPayrollsInDTO testSetup() {
		GetFilteredPayrollsInDTO inDTO = new GetFilteredPayrollsInDTO();
		inDTO.setIdSegUsuario("4567");
		inDTO.setIdSoiAportante("4040");
		inDTO.setNumPagina("1");
		inDTO.setNumRegistros("10");
		inDTO.setToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjoiMTg0MDExMzAiLCJpYXQiOjE0ODkwOTA3NDAsImV4cCI6MTQ4OTE3NzE0MH0.l28-9Lv0H-vAb1wVgwEFhnAFGFjqRw4gO7OjNJrMI88");
		return inDTO;
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene las planillas cuando el parámetro idSoiAportante es
	 * nulo
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 9/03/2017
	 *
	 */
	@Test
	public void testIdSoiAportanteNull() {
		GetFilteredPayrollsInDTO inDTO = testSetup();
		inDTO.setIdSoiAportante(null);
		GetFilteredPayrollsOutDTO outDTO = invokeGetFilteredPayrolls(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene las planillas cuando el parámetro idSoiAportante
	 * está vacío
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 9/03/2017
	 *
	 */
	@Test
	public void testIdSoiAportanteEmpty() {
		GetFilteredPayrollsInDTO inDTO = testSetup();
		inDTO.setIdSoiAportante(Constants.EMPTY);
		GetFilteredPayrollsOutDTO outDTO = invokeGetFilteredPayrolls(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene las planillas cuando el parámetros idSoiAportante
	 * no es un número
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 9/03/2017
	 *
	 */
	@Test
	public void testIdSoiAportanteNotInteger() {
		GetFilteredPayrollsInDTO inDTO = testSetup();
		inDTO.setIdSoiAportante("NOT A NUMBER");
		GetFilteredPayrollsOutDTO outDTO = invokeGetFilteredPayrolls(inDTO);
		assertEquals(CodeErrorEnum.ERRORINTEGERFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene las planillas cuando el parámetro idSegUsuario es
	 * nulo
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 9/03/2017
	 *
	 */
	@Test
	public void testIdSegUsuarioNull() {
		GetFilteredPayrollsInDTO inDTO = testSetup();
		inDTO.setIdSegUsuario(null);
		GetFilteredPayrollsOutDTO outDTO = invokeGetFilteredPayrolls(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene las planillas cuando el parámetro idSegUsuario está
	 * vacío
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 9/03/2017
	 *
	 */
	@Test
	public void testIdSegUsuarioEmpty() {
		GetFilteredPayrollsInDTO inDTO = testSetup();
		inDTO.setIdSegUsuario(Constants.EMPTY);
		GetFilteredPayrollsOutDTO outDTO = invokeGetFilteredPayrolls(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene las planillas cuando el parámetros idSegUsuario no
	 * es un número
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 9/03/2017
	 *
	 */
	@Test
	public void testIdSegUsuarioNotInteger() {
		GetFilteredPayrollsInDTO inDTO = testSetup();
		inDTO.setIdSegUsuario("NOT A NUMBER");
		GetFilteredPayrollsOutDTO outDTO = invokeGetFilteredPayrolls(inDTO);
		assertEquals(CodeErrorEnum.ERRORINTEGERFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene las planillas cuando el parámetro token es nulo
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 9/03/2017
	 *
	 */
	@Test
	public void testTokenNull() {
		GetFilteredPayrollsInDTO inDTO = testSetup();
		inDTO.setToken(null);
		GetFilteredPayrollsOutDTO outDTO = invokeGetFilteredPayrolls(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene las planillas cuando el parámetro token está vacío
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 9/03/2017
	 *
	 */
	@Test
	public void testTokenEmpty() {
		GetFilteredPayrollsInDTO inDTO = testSetup();
		inDTO.setToken(Constants.EMPTY);
		GetFilteredPayrollsOutDTO outDTO = invokeGetFilteredPayrolls(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene las planillas cuando el parámetro token no es
	 * válido
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 9/03/2017
	 *
	 */
	@Test
	public void testInvalidToken() {
		GetFilteredPayrollsInDTO inDTO = testSetup();
		inDTO.setToken("NOT AN AUTHORIZED TOKEN");
		GetFilteredPayrollsOutDTO outDTO = invokeGetFilteredPayrolls(inDTO);
		assertEquals(CodeErrorEnum.ERRORTOKENNOTAUTHORIZED.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio cuando el parámetro numPagina es nulo, debería realizarse el
	 * flujo normal debido a que el servicio inicializa el parámetro cuando este es nulo o vacío
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 9/03/2017
	 *
	 */
	@Test
	public void testNumPaginaNull() {
		GetFilteredPayrollsInDTO inDTO = testSetup();
		inDTO.setNumPagina(null);
		GetFilteredPayrollsOutDTO outDTO = invokeGetFilteredPayrolls(inDTO);
		assertEquals(CodeErrorEnum.SUCCESSFULL.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio cuando el parámetro numPagina es vacío, debería realizarse el
	 * flujo normal debido a que el servicio inicializa el parámetro cuando este es nulo o vacío
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 9/03/2017
	 *
	 */
	@Test
	public void testNumPaginaEmpty() {
		GetFilteredPayrollsInDTO inDTO = testSetup();
		inDTO.setNumPagina(null);
		GetFilteredPayrollsOutDTO outDTO = invokeGetFilteredPayrolls(inDTO);
		assertEquals(CodeErrorEnum.SUCCESSFULL.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba la respuesta del servicio cuando el parámetro numPagina no es un número entero
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 10/03/2017
	 *
	 */
	@Test
	public void testNumPaginaNotInteger() {
		GetFilteredPayrollsInDTO inDTO = testSetup();
		inDTO.setNumPagina("NOT A NUMBER");
		GetFilteredPayrollsOutDTO outDTO = invokeGetFilteredPayrolls(inDTO);
		assertEquals(CodeErrorEnum.ERRORINTEGERFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio cuando el parámetro numRegistros es nulo, debería realizarse el
	 * flujo normal debido a que el servicio inicializa el parámetro cuando este es nulo o vacío
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 9/03/2017
	 *
	 */
	@Test
	public void testNumRegistrosNull() {
		GetFilteredPayrollsInDTO inDTO = testSetup();
		inDTO.setNumPagina(null);
		GetFilteredPayrollsOutDTO outDTO = invokeGetFilteredPayrolls(inDTO);
		assertEquals(CodeErrorEnum.SUCCESSFULL.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio cuando el parámetro numRegistros es vacío, debería realizarse
	 * el flujo normal debido a que el servicio inicializa el parámetro cuando este es nulo o vacío
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 9/03/2017
	 *
	 */
	@Test
	public void testNumRegistrosEmpty() {
		GetFilteredPayrollsInDTO inDTO = testSetup();
		inDTO.setNumPagina(null);
		GetFilteredPayrollsOutDTO outDTO = invokeGetFilteredPayrolls(inDTO);
		assertEquals(CodeErrorEnum.SUCCESSFULL.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba la respuesta del servicio cuando el parámetro numRegistros no es un número entero
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 10/03/2017
	 *
	 */
	@Test
	public void testNumRegistrosNotInteger() {
		GetFilteredPayrollsInDTO inDTO = testSetup();
		inDTO.setNumRegistros("NOT A NUMBER");
		GetFilteredPayrollsOutDTO outDTO = invokeGetFilteredPayrolls(inDTO);
		assertEquals(CodeErrorEnum.ERRORINTEGERFIELD.getCode(), outDTO.getCode());
	}
	
	/**
	 * 
	 * Test que comprueba el flujo normal de la ejecución del servicio
	 *
	 * @author SWAT-IT <br>
	 *			Daniel Moncada Tabares <br>
	 * 			Email: dmoncada@swat-it.co
	 * 
	 * @date 10/03/2017
	 *
	 */
	@Test
	public void testNormalFlow(){
		GetFilteredPayrollsInDTO inDTO = testSetup();
		GetFilteredPayrollsOutDTO outDTO = invokeGetFilteredPayrolls(inDTO);
		assertEquals(CodeErrorEnum.SUCCESSFULL.getCode(), outDTO.getCode());
	}

}

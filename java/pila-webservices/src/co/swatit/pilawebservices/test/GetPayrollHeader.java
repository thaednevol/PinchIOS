/**
 * 
 */
package co.swatit.pilawebservices.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import co.swatit.pilautil.dto.in.GetPayrollHeaderInDTO;
import co.swatit.pilautil.dto.out.GetPayrollHeaderOutDTO;
import co.swatit.pilautil.exception.InvokeException;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;
import co.swatit.pilautil.generics.Constants;
import co.swatit.pilautil.request.rest.ParserUtils;
import co.swatit.pilautil.request.rest.ServiceRequestProvider;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * 
 * Clase que contiene los test sobre el servicio web getPayrollHeader
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 3/04/2017
 * @version 1.0
 */
public class GetPayrollHeader {
	public static final String URL = "http://172.16.10.207:7001/pila-webservices/PilaWS/getPayrollHeader";

	/**
	 * 
	 * Método que realiza una invocación al servicio web getPayrollHeader
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 03/04/2017
	 *
	 * @param inDTO
	 *            , objeto de transporte con los parámetros de entrada del servicio
	 * @return {@link GetPayrollHeaderOutDTO} con la respuesta del servicio
	 */
	public GetPayrollHeaderOutDTO invokeGetPayrollHeader(GetPayrollHeaderInDTO inDTO) {
		GetPayrollHeaderOutDTO outDTO = new GetPayrollHeaderOutDTO();
		try {
			outDTO = ParserUtils.INSTANCE.parseJSONToObject(ServiceRequestProvider.callPostWS(URL, null,
					ParserUtils.INSTANCE.convertObjectToJSON(inDTO), MediaType.APPLICATION_JSON),
					GetPayrollHeaderOutDTO.class);
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
	 * @date 03/04/2017
	 *
	 * @return el DTO con los parámetros inicializados
	 */
	public GetPayrollHeaderInDTO testSetup() {
		GetPayrollHeaderInDTO inDTO = new GetPayrollHeaderInDTO();
		inDTO.setNumeroPlanilla("141981");
		inDTO.setToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjoiMTg0MDExMzAiLCJpYXQiOjE0OTEyMzM1MzcsImV4cCI6MTQ5MTMxOTkzN30.tDMZX9SV7rI0hw5Y_SCLJfFMlizwv0UcEJfztNruPt0");
		return inDTO;
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene la información de la planilla cuando el parámetro token es
	 * nulo
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 03/04/2017
	 *
	 */
	@Test
	public void testTokenNull() {
		GetPayrollHeaderInDTO inDTO = testSetup();
		inDTO.setToken(null);
		GetPayrollHeaderOutDTO outDTO = invokeGetPayrollHeader(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene la información de la planilla cuando el parámetro token está
	 * vacío
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 03/04/2017
	 *
	 */
	@Test
	public void testTokenEmpty() {
		GetPayrollHeaderInDTO inDTO = testSetup();
		inDTO.setToken(Constants.EMPTY);
		GetPayrollHeaderOutDTO outDTO = invokeGetPayrollHeader(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene la información de la planilla cuando el parámetro token no es
	 * válido
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 03/04/2017
	 *
	 */
	@Test
	public void testInvalidToken() {
		GetPayrollHeaderInDTO inDTO = testSetup();
		inDTO.setToken("NOT AN AUTHORIZED TOKEN");
		GetPayrollHeaderOutDTO outDTO = invokeGetPayrollHeader(inDTO);
		assertEquals(CodeErrorEnum.ERRORTOKENNOTAUTHORIZED.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene la información de la planilla cuando el parámetro
	 * numeroPlanilla es nulo
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 03/04/2017
	 *
	 */
	@Test
	public void testNumeroPlanillaNull() {
		GetPayrollHeaderInDTO inDTO = testSetup();
		inDTO.setNumeroPlanilla(null);
		GetPayrollHeaderOutDTO outDTO = invokeGetPayrollHeader(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio que obtiene la información de la planilla cuando el parámetro
	 * numeroPlanilla está vacío
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 03/04/2017
	 *
	 */
	@Test
	public void testNumeroPlanillaEmpty() {
		GetPayrollHeaderInDTO inDTO = testSetup();
		inDTO.setNumeroPlanilla(Constants.EMPTY);
		GetPayrollHeaderOutDTO outDTO = invokeGetPayrollHeader(inDTO);
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
	 * @date 03/04/2017
	 *
	 */
	@Test
	public void testNumeroPlanillaNotInteger() {
		GetPayrollHeaderInDTO inDTO = testSetup();
		inDTO.setNumeroPlanilla("NOT A NUMBER");
		GetPayrollHeaderOutDTO outDTO = invokeGetPayrollHeader(inDTO);
		assertEquals(CodeErrorEnum.ERRORINTEGERFIELD.getCode(), outDTO.getCode());
	}

	/**
	 * 
	 * Test que comprueba el flujo normal del servicio
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 04/04/2017
	 *
	 */
	@Test
	public void testNormalFlow() {
		GetPayrollHeaderInDTO inDTO = testSetup();
		GetPayrollHeaderOutDTO outDTO = invokeGetPayrollHeader(inDTO);
		assertEquals(CodeErrorEnum.SUCCESSFULL.getCode(), outDTO.getCode());
	}

	/**
	 * Test que comprueba el comportamiento del servicio cuando no se encuentra ningún dato
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 4/04/2017
	 *
	 */
	@Test
	public void testNotFound() {
		GetPayrollHeaderInDTO inDTO = testSetup();
		inDTO.setNumeroPlanilla("1234512345");
		GetPayrollHeaderOutDTO outDTO = invokeGetPayrollHeader(inDTO);
		// Código de error enviado desde SOI
		assertEquals("8030", outDTO.getCode());
	}
}

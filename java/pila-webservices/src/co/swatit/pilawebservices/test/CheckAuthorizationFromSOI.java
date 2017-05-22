package co.swatit.pilawebservices.test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import co.swatit.pilautil.dto.in.LoginInDTO;
import co.swatit.pilautil.dto.out.LoginOutDTO;
import co.swatit.pilautil.exception.InvokeException;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;
import co.swatit.pilautil.request.rest.ParserUtils;
import co.swatit.pilautil.request.rest.ServiceRequestProvider;

/**
 * 
 * Clase que contiene las pruebas unitarias del servicio web login del proyecto pila-webservices
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 19/01/2017
 * @version 1.0
 */
public class CheckAuthorizationFromSOI {
	public static final String URL = "http://172.16.10.207:7001/pila-webservices/PilaWS/login";

	public static final String METHOD = "getConsignmentRequestsByStatus";

	public LoginOutDTO invokeLoginWS(LoginInDTO inDTO) {
		LoginOutDTO outDTO = new LoginOutDTO();
		try {
			outDTO = ParserUtils.INSTANCE.parseJSONToObject(ServiceRequestProvider.callPostWS(URL, null,
					ParserUtils.INSTANCE.convertObjectToJSON(inDTO), MediaType.APPLICATION_JSON), LoginOutDTO.class);
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
	 * Test que comprueba el funcionamiento normal del servicio web de logueo
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 19/01/2017
	 *
	 */
	@Test
	public void testLoginSuccessfull() {
		LoginInDTO inDTO = new LoginInDTO();
		inDTO.setContributorIdType("2");
		inDTO.setAccountPassword("manager2009");
		inDTO.setContributorIdNumber("18401130");
		inDTO.setAccountIdType("1");
		inDTO.setAccountIdNumber("18401130");
		LoginOutDTO resp = invokeLoginWS(inDTO);
		assertEquals(CodeErrorEnum.SUCCESSFULL.getCode(), resp.getCode());
	}

	/**
	 * 
	 *
	 * Test que comprueba el funcionamiento del servicio web de logueo cuando los datos ingresados no corresponden a
	 * ningún usuario existente
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 19/01/2017
	 *
	 */
	@Test
	public void testLoginInvalidSOIUser() {
		LoginInDTO inDTO = new LoginInDTO();
		inDTO.setContributorIdType("5");
		inDTO.setAccountPassword("asdfqwerty");
		inDTO.setContributorIdNumber("123456789");
		inDTO.setAccountIdType("3");
		inDTO.setAccountIdNumber("987654321");
		LoginOutDTO resp = invokeLoginWS(inDTO);
		assertEquals("7008", resp.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio web de logueo cuando la conexión con el servidor generador de
	 * tokens falla
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 19/01/2017
	 *
	 */
	@Test
	public void testTokenServerOff() {
		LoginInDTO inDTO = new LoginInDTO();
		inDTO.setContributorIdType("2");
		inDTO.setAccountPassword("manager2009");
		inDTO.setContributorIdNumber("18401130");
		inDTO.setAccountIdType("1");
		inDTO.setAccountIdNumber("18401130");
		LoginOutDTO resp = invokeLoginWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORTOKENSERVICECONNECTION.getCode(), resp.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de logueo cuando el parámetro tipoIdentificacionAportante no es
	 * un entero
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 19/01/2017
	 *
	 */
	@Test
	public void testContributorIdentificationTypeNotInteger() {
		LoginInDTO inDTO = new LoginInDTO();
		inDTO.setContributorIdType("NOT A NUMBER");
		inDTO.setAccountPassword("manager2009");
		inDTO.setContributorIdNumber("18401130");
		inDTO.setAccountIdType("1");
		inDTO.setAccountIdNumber("18401130");
		LoginOutDTO resp = invokeLoginWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORINTEGERFIELD.getCode(), resp.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de logueo cuando el parámetro tipoIdentificacionCuenta no es un
	 * entero
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 19/01/2017
	 *
	 */
	@Test
	public void testAccountIdentificationTypeNotInteger() {
		LoginInDTO inDTO = new LoginInDTO();
		inDTO.setContributorIdType("2");
		inDTO.setAccountPassword("manager2009");
		inDTO.setContributorIdNumber("18401130");
		inDTO.setAccountIdType("NOT A NUMBER");
		inDTO.setAccountIdNumber("18401130");
		LoginOutDTO resp = invokeLoginWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORINTEGERFIELD.getCode(), resp.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de logueo cuando el parámetro tipoIdentificacionAportante es
	 * nulo
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 19/01/2017
	 *
	 */
	@Test
	public void testContributorIdentificationTypeNull() {
		LoginInDTO inDTO = new LoginInDTO();
		inDTO.setAccountPassword("manager2009");
		inDTO.setContributorIdNumber("18401130");
		inDTO.setAccountIdType("1");
		inDTO.setAccountIdNumber("18401130");
		LoginOutDTO resp = invokeLoginWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), resp.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de logueo cuando el parámetro tipoIdentificacionCuenta es nulo
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 19/01/2017
	 *
	 */
	@Test
	public void testAccountIdentificationTypeNull() {
		LoginInDTO inDTO = new LoginInDTO();
		inDTO.setContributorIdType("2");
		inDTO.setAccountPassword("manager2009");
		inDTO.setContributorIdNumber("18401130");
		inDTO.setAccountIdNumber("18401130");
		LoginOutDTO resp = invokeLoginWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), resp.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de logueo cuando el parámetro numeroIdentificacionAportante es
	 * nulo
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 19/01/2017
	 *
	 */
	@Test
	public void testIdContributorNumberNull() {
		LoginInDTO inDTO = new LoginInDTO();
		inDTO.setContributorIdType("2");
		inDTO.setAccountPassword("manager2009");
		inDTO.setAccountIdType("1");
		inDTO.setAccountIdNumber("18401130");
		LoginOutDTO resp = invokeLoginWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), resp.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de logueo cuando el parámetro numeroIdentificacionCuenta es
	 * nulo
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 19/01/2017
	 *
	 */
	@Test
	public void testIdAccountNumberNull() {
		LoginInDTO inDTO = new LoginInDTO();
		inDTO.setContributorIdType("2");
		inDTO.setAccountPassword("manager2009");
		inDTO.setAccountIdType("1");
		inDTO.setContributorIdType("18401130");
		LoginOutDTO resp = invokeLoginWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), resp.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de logueo cuando el parámetro contrasenaCuenta es nulo
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 19/01/2017
	 *
	 */
	@Test
	public void testPasswordAccountNull() {
		LoginInDTO inDTO = new LoginInDTO();
		inDTO.setContributorIdType("2");
		inDTO.setAccountIdType("1");
		inDTO.setAccountIdNumber("18401130");
		inDTO.setContributorIdNumber("18401130");
		LoginOutDTO resp = invokeLoginWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), resp.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de logueo cuando el parámetro tipoIdentificacionAportante está
	 * vacío
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 19/01/2017
	 *
	 */
	@Test
	public void testContributorIdentificationTypeEmpty() {
		LoginInDTO inDTO = new LoginInDTO();
		inDTO.setContributorIdType("");
		inDTO.setAccountIdType("1");
		inDTO.setAccountPassword("manager2009");
		inDTO.setAccountIdNumber("18401130");
		inDTO.setContributorIdNumber("18401130");
		LoginOutDTO resp = invokeLoginWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), resp.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de logueo cuando el parámetro tipoIdentificacionCuenta está
	 * vacío
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 19/01/2017
	 *
	 */
	@Test
	public void testAccountIdentificationTypeEmpty() {
		LoginInDTO inDTO = new LoginInDTO();
		inDTO.setContributorIdType("2");
		inDTO.setAccountIdType("");
		inDTO.setAccountPassword("manager2009");
		inDTO.setAccountIdNumber("18401130");
		inDTO.setContributorIdNumber("18401130");
		LoginOutDTO resp = invokeLoginWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), resp.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de logueo cuando el parámetro numeroIdentificacionAportante
	 * está vacío
	 * 
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 19/01/2017
	 *
	 */
	@Test
	public void testIdContributorNumberEmpty() {
		LoginInDTO inDTO = new LoginInDTO();
		inDTO.setContributorIdType("2");
		inDTO.setAccountIdType("1");
		inDTO.setAccountPassword("manager2009");
		inDTO.setAccountIdNumber("18401130");
		inDTO.setContributorIdNumber("");
		LoginOutDTO resp = invokeLoginWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), resp.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de logueo cuando el parámetro numeroIdentificacionCuenta está
	 * vacío
	 * 
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 19/01/2017
	 *
	 */
	@Test
	public void testIdAccountNumberEmpty() {
		LoginInDTO inDTO = new LoginInDTO();
		inDTO.setContributorIdType("2");
		inDTO.setAccountIdType("1");
		inDTO.setAccountPassword("manager2009");
		inDTO.setAccountIdNumber("");
		inDTO.setContributorIdNumber("18401130");
		LoginOutDTO resp = invokeLoginWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), resp.getCode());
	}

	/**
	 * 
	 * Test que comprueba el funcionamiento del servicio de logueo cuando el parámetro contrasenaCuenta está vacío
	 * 
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 19/01/2017
	 *
	 */
	@Test
	public void testAccountPasswordEmpty() {
		LoginInDTO inDTO = new LoginInDTO();
		inDTO.setContributorIdType("2");
		inDTO.setAccountIdType("1");
		inDTO.setAccountPassword("");
		inDTO.setAccountIdNumber("18401130");
		inDTO.setContributorIdNumber("18401130");
		LoginOutDTO resp = invokeLoginWS(inDTO);
		assertEquals(CodeErrorEnum.ERRORREQUIREDFIELD.getCode(), resp.getCode());
	}

}

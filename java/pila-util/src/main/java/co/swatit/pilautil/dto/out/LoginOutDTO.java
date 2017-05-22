package co.swatit.pilautil.dto.out;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.ach.seg.biz.transfer.UsuarioAutenticadoDTO;

import co.swatit.pilautil.dto.ResponseDTO;

/**
 * 
 * Objeto de transporte que contiene los parámetros de salida del servicio WEB login
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 12/01/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loginOutDTO", propOrder = { "token", "userPermissions", "userName", "companyName", "authenticatedUserDTO" })
public class LoginOutDTO extends ResponseDTO {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * token generado
	 */
	private String token;

	/**
	 * Lista de permisos del usuario
	 */
	private List<String> userPermissions;

	/**
	 * Nombre del usuario logueado
	 */
	private String userName;

	/**
	 * Nombre de la empresa
	 */
	private String companyName;

	/**
	 * IdSoiAportante
	 */
	private String soiContributorIdNumber;

	/**
	 * IdSegUsuario
	 */
	private String soiAccountIdNumber;

	/**
	 * Información obtenida del objeto {@link UsuarioAutenticadoDTO}
	 */
	private AuthenticatedUserDTO authenticatedUserDTO;

	/**
	 * Método getter del atributo permisosUsuario de la clase LoginOutDTO
	 *
	 * @return the permisosUsuario
	 */
	public List<String> getUserPermissions() {
		if (userPermissions == null) {
			userPermissions = new ArrayList<String>();
		}
		return userPermissions;
	}

	/**
	 * Método getter del atributo token de la clase LoginOutDTO
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Método setter del atributo token de la clase LoginOutDTO
	 *
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Método getter del atributo userName de la clase LoginOutDTO
	 *
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Método setter del atributo userName de la clase LoginOutDTO
	 *
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Método getter del atributo companyName de la clase LoginOutDTO
	 *
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * Método setter del atributo companyName de la clase LoginOutDTO
	 *
	 * @param companyName
	 *            the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * Método getter del atributo soiContributorIdNumber de la clase LoginOutDTO
	 *
	 * @return the soiContributorIdNumber
	 */
	public String getSoiContributorIdNumber() {
		return soiContributorIdNumber;
	}

	/**
	 * Método setter del atributo soiContributorIdNumber de la clase LoginOutDTO
	 *
	 * @param soiContributorIdNumber
	 *            the soiContributorIdNumber to set
	 */
	public void setSoiContributorIdNumber(String soiContributorIdNumber) {
		this.soiContributorIdNumber = soiContributorIdNumber;
	}

	/**
	 * Método getter del atributo soiAccountIdNumber de la clase LoginOutDTO
	 *
	 * @return the soiAccountIdNumber
	 */
	public String getSoiAccountIdNumber() {
		return soiAccountIdNumber;
	}

	/**
	 * Método setter del atributo soiAccountIdNumber de la clase LoginOutDTO
	 *
	 * @param soiAccountIdNumber
	 *            the soiAccountIdNumber to set
	 */
	public void setSoiAccountIdNumber(String soiAccountIdNumber) {
		this.soiAccountIdNumber = soiAccountIdNumber;
	}

	/**
	 * Método getter del atributo authenticatedUserDTO de la clase LoginOutDTO
	 *
	 * @return the authenticatedUserDTO
	 */
	public AuthenticatedUserDTO getAuthenticatedUserDTO() {
		return authenticatedUserDTO;
	}

	/**
	 * Método setter del atributo authenticatedUserDTO de la clase LoginOutDTO
	 *
	 * @param authenticatedUserDTO
	 *            the authenticatedUserDTO to set
	 */
	public void setAuthenticatedUserDTO(AuthenticatedUserDTO authenticatedUserDTO) {
		this.authenticatedUserDTO = authenticatedUserDTO;
	}

}

package co.swatit.pilautil.dto.in;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Objeto de transporte que contiene los parámetros de entrada del servicio WEB login
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 12/01/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoginInDTO")
@XmlRootElement
public class LoginInDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * tipo identificacion del aportante
	 */
	private String contributorIdType;
	/**
	 * numero identificacion del aportante
	 */
	private String contributorIdNumber;
	/**
	 * tipo identificacion de la cuenta
	 */
	private String accountIdType;
	/**
	 * numero identificacion de la cuenta
	 */
	private String accountIdNumber;
	/**
	 * contrasena de la cuenta
	 */
	private String accountPassword;

	/**
	 * Método getter del atributo contributorIdType de la clase LoginInDTO
	 *
	 * @return the contributorIdType
	 */
	public String getContributorIdType() {
		return contributorIdType;
	}

	/**
	 * Método setter del atributo contributorIdType de la clase LoginInDTO
	 *
	 * @param contributorIdType
	 *            the contributorIdType to set
	 */
	public void setContributorIdType(String contributorIdType) {
		this.contributorIdType = contributorIdType;
	}

	/**
	 * Método getter del atributo contributorIdNumber de la clase LoginInDTO
	 *
	 * @return the contributorIdNumber
	 */
	public String getContributorIdNumber() {
		return contributorIdNumber;
	}

	/**
	 * Método setter del atributo contributorIdNumber de la clase LoginInDTO
	 *
	 * @param contributorIdNumber
	 *            the contributorIdNumber to set
	 */
	public void setContributorIdNumber(String contributorIdNumber) {
		this.contributorIdNumber = contributorIdNumber;
	}

	/**
	 * Método getter del atributo accountIdType de la clase LoginInDTO
	 *
	 * @return the accountIdType
	 */
	public String getAccountIdType() {
		return accountIdType;
	}

	/**
	 * Método setter del atributo accountIdType de la clase LoginInDTO
	 *
	 * @param accountIdType
	 *            the accountIdType to set
	 */
	public void setAccountIdType(String accountIdType) {
		this.accountIdType = accountIdType;
	}

	/**
	 * Método getter del atributo accountIdNumber de la clase LoginInDTO
	 *
	 * @return the accountIdNumber
	 */
	public String getAccountIdNumber() {
		return accountIdNumber;
	}

	/**
	 * Método setter del atributo accountIdNumber de la clase LoginInDTO
	 *
	 * @param accountIdNumber
	 *            the accountIdNumber to set
	 */
	public void setAccountIdNumber(String accountIdNumber) {
		this.accountIdNumber = accountIdNumber;
	}

	/**
	 * Método getter del atributo accountPassword de la clase LoginInDTO
	 *
	 * @return the accountPassword
	 */
	public String getAccountPassword() {
		return accountPassword;
	}

	/**
	 * Método setter del atributo accountPassword de la clase LoginInDTO
	 *
	 * @param accountPassword
	 *            the accountPassword to set
	 */
	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginInDTO [contributorIdType=" + contributorIdType + ", contributorIdNumber=" + contributorIdNumber
				+ ", accountIdType=" + accountIdType + ", accountIdNumber=" + accountIdNumber + ", accountPassword="
				+ accountPassword + "]";
	}

}

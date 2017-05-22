package co.swatit.pilautil.dto.in;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * Objeto de transporte que contiene los parámetros del servicio web getApplicationConfiguration
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 15/02/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetApplicationConfigurationInDTO")
@XmlRootElement
public class GetValidationFileConfigInDTO implements Serializable {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Primera linea del archivo convertido
	 */
	private String regTp01;
	/**
	 * Id del Aportante
	 */
	private String idSoiAportante;
	/**
	 * Id de la cuenta de Usuario
	 */
	private String idSegUsuario;

	/**
	 * Token del usuario autenticado
	 */
	private String token;

	/**
	 * Método getter del atributo regTp01 de la clase GetApplicationConfigurationInDTO
	 *
	 * @return the regTp01
	 */
	public String getRegTp01() {
		return regTp01;
	}

	/**
	 * Método setter del atributo regTp01 de la clase GetApplicationConfigurationInDTO
	 *
	 * @param regTp01
	 *            the regTp01 to set
	 */
	public void setRegTp01(String regTp01) {
		this.regTp01 = regTp01;
	}

	/**
	 * Método getter del atributo idSoiAportante de la clase GetApplicationConfigurationInDTO
	 *
	 * @return the idSoiAportante
	 */
	public String getIdSoiAportante() {
		return idSoiAportante;
	}

	/**
	 * Método setter del atributo idSoiAportante de la clase GetApplicationConfigurationInDTO
	 *
	 * @param idSoiAportante
	 *            the idSoiAportante to set
	 */
	public void setIdSoiAportante(String idSoiAportante) {
		this.idSoiAportante = idSoiAportante;
	}

	/**
	 * Método getter del atributo idSegUsuario de la clase GetApplicationConfigurationInDTO
	 *
	 * @return the idSegUsuario
	 */
	public String getIdSegUsuario() {
		return idSegUsuario;
	}

	/**
	 * Método setter del atributo idSegUsuario de la clase GetApplicationConfigurationInDTO
	 *
	 * @param idSegUsuario
	 *            the idSegUsuario to set
	 */
	public void setIdSegUsuario(String idSegUsuario) {
		this.idSegUsuario = idSegUsuario;
	}

	/**
	 * Método getter del atributo token de la clase GetApplicationConfigurationInDTO
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Método setter del atributo token de la clase GetApplicationConfigurationInDTO
	 *
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GetApplicationConfigurationInDTO [regTp01=" + regTp01 + ", idSoiAportante=" + idSoiAportante
				+ ", idSegUsuario=" + idSegUsuario + ", token=" + token + "]";
	}

}

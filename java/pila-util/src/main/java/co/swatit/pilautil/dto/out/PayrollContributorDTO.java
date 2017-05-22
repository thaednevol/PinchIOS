package co.swatit.pilautil.dto.out;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Objeto de transporte que contiene la información de un aportante
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 4/04/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "payrollContributorDTO", propOrder = { "idCotizante", "idCotizante", "tipoIdentificacion",
		"numeroIdentificacion", "nombreCompleto", "correoElectronico" })
public class PayrollContributorDTO implements Serializable {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id del cotizante ante SOI
	 */
	private String idCotizante;
	/**
	 * id del tipo de identificación del cotizante
	 */
	private String idTipoIdentificacion;
	/**
	 * tipo de Identificación del aportante
	 */
	private String tipoIdentificacion;

	/**
	 * Número de identificación del cotizante
	 */
	private String numeroIdentificacion;
	/**
	 * Nombre del cotizante
	 */
	private String nombreCompleto;
	/**
	 * Email del cotizante
	 */
	private String correoElectronico;

	/**
	 * Método getter del atributo idCotizante de la clase PayrollContributorDTO
	 *
	 * @return the idCotizante
	 */
	public String getIdCotizante() {
		return idCotizante;
	}

	/**
	 * Método setter del atributo idCotizante de la clase PayrollContributorDTO
	 *
	 * @param idCotizante
	 *            the idCotizante to set
	 */
	public void setIdCotizante(String idCotizante) {
		this.idCotizante = idCotizante;
	}

	/**
	 * Método getter del atributo idTipoIdentificacion de la clase PayrollContributorDTO
	 *
	 * @return the idTipoIdentificacion
	 */
	public String getIdTipoIdentificacion() {
		return idTipoIdentificacion;
	}

	/**
	 * Método setter del atributo idTipoIdentificacion de la clase PayrollContributorDTO
	 *
	 * @param idTipoIdentificacion
	 *            the idTipoIdentificacion to set
	 */
	public void setIdTipoIdentificacion(String idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}

	/**
	 * Método getter del atributo tipoIdentificacion de la clase PayrollContributorDTO
	 *
	 * @return the tipoIdentificacion
	 */
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	/**
	 * Método setter del atributo tipoIdentificacion de la clase PayrollContributorDTO
	 *
	 * @param tipoIdentificacion
	 *            the tipoIdentificacion to set
	 */
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	/**
	 * Método getter del atributo numeroIdentificacion de la clase PayrollContributorDTO
	 *
	 * @return the numeroIdentificacion
	 */
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	/**
	 * Método setter del atributo numeroIdentificacion de la clase PayrollContributorDTO
	 *
	 * @param numeroIdentificacion
	 *            the numeroIdentificacion to set
	 */
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	/**
	 * Método getter del atributo nombreCompleto de la clase PayrollContributorDTO
	 *
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * Método setter del atributo nombreCompleto de la clase PayrollContributorDTO
	 *
	 * @param nombreCompleto
	 *            the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	/**
	 * Método getter del atributo correoElectronico de la clase PayrollContributorDTO
	 *
	 * @return the correoElectronico
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	/**
	 * Método setter del atributo correoElectronico de la clase PayrollContributorDTO
	 *
	 * @param correoElectronico
	 *            the correoElectronico to set
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

}

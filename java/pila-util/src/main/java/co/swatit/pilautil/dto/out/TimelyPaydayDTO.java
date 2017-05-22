/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;

import com.ach.pla.biz.transfer.DiaPagoOportunoDTO;

/**
 * 
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link DiaPagoOportunoDTO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 31/03/2017
 * @version 1.0
 */
public class TimelyPaydayDTO implements Serializable {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * identificador de la clase del aportante
	 */
	private Integer idClaseAportante;
	/**
	 * Digitos de verificación
	 */
	private String digitosVerificacion;
	/**
	 * Entero con el dia del pago oportuno
	 */
	private Integer diaPagoOportuno;
	/**
	 * Identificador ante SOI del dia del pago oportuno
	 */
	private Integer idSoiDiaPagoOportuno;
	/**
	 * Identificador ante SOI de la forma de presentación
	 */
	private Integer idSoiFormaPresentacion;

	/**
	 * Método getter del atributo idClaseAportante de la clase TimelyPaydayDTO
	 *
	 * @return the idClaseAportante
	 */
	public Integer getIdClaseAportante() {
		return idClaseAportante;
	}

	/**
	 * Método setter del atributo idClaseAportante de la clase TimelyPaydayDTO
	 *
	 * @param idClaseAportante
	 *            the idClaseAportante to set
	 */
	public void setIdClaseAportante(Integer idClaseAportante) {
		this.idClaseAportante = idClaseAportante;
	}

	/**
	 * Método getter del atributo digitosVerificacion de la clase TimelyPaydayDTO
	 *
	 * @return the digitosVerificacion
	 */
	public String getDigitosVerificacion() {
		return digitosVerificacion;
	}

	/**
	 * Método setter del atributo digitosVerificacion de la clase TimelyPaydayDTO
	 *
	 * @param digitosVerificacion
	 *            the digitosVerificacion to set
	 */
	public void setDigitosVerificacion(String digitosVerificacion) {
		this.digitosVerificacion = digitosVerificacion;
	}

	/**
	 * Método getter del atributo diaPagoOportuno de la clase TimelyPaydayDTO
	 *
	 * @return the diaPagoOportuno
	 */
	public Integer getDiaPagoOportuno() {
		return diaPagoOportuno;
	}

	/**
	 * Método setter del atributo diaPagoOportuno de la clase TimelyPaydayDTO
	 *
	 * @param diaPagoOportuno
	 *            the diaPagoOportuno to set
	 */
	public void setDiaPagoOportuno(Integer diaPagoOportuno) {
		this.diaPagoOportuno = diaPagoOportuno;
	}

	/**
	 * Método getter del atributo idSoiDiaPagoOportuno de la clase TimelyPaydayDTO
	 *
	 * @return the idSoiDiaPagoOportuno
	 */
	public Integer getIdSoiDiaPagoOportuno() {
		return idSoiDiaPagoOportuno;
	}

	/**
	 * Método setter del atributo idSoiDiaPagoOportuno de la clase TimelyPaydayDTO
	 *
	 * @param idSoiDiaPagoOportuno
	 *            the idSoiDiaPagoOportuno to set
	 */
	public void setIdSoiDiaPagoOportuno(Integer idSoiDiaPagoOportuno) {
		this.idSoiDiaPagoOportuno = idSoiDiaPagoOportuno;
	}

	/**
	 * Método getter del atributo idSoiFormaPresentacion de la clase TimelyPaydayDTO
	 *
	 * @return the idSoiFormaPresentacion
	 */
	public Integer getIdSoiFormaPresentacion() {
		return idSoiFormaPresentacion;
	}

	/**
	 * Método setter del atributo idSoiFormaPresentacion de la clase TimelyPaydayDTO
	 *
	 * @param idSoiFormaPresentacion
	 *            the idSoiFormaPresentacion to set
	 */
	public void setIdSoiFormaPresentacion(Integer idSoiFormaPresentacion) {
		this.idSoiFormaPresentacion = idSoiFormaPresentacion;
	}

}

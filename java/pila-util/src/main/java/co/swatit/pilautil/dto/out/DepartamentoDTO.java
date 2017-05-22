package co.swatit.pilautil.dto.out;

import java.io.Serializable;

import com.ach.cfg.biz.model.DepartamentoVO;

/**
 * 
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link DepartamentoVO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class DepartamentoDTO implements Serializable {
	/**
	 * Constante de Serialización
	 */
	private static final long serialVersionUID = 1L;
	private String causaFinVigencia;
	private Integer vigente;
	private String nombreMostrar;
	private String nombre;
	private String codigo;
	private Integer idSoiDepartamento;

	/**
	 * Método getter del atributo causaFinVigencia de la clase DepartamentoDTO
	 *
	 * @return the causaFinVigencia
	 */
	public String getCausaFinVigencia() {
		return causaFinVigencia;
	}

	/**
	 * Método setter del atributo causaFinVigencia de la clase DepartamentoDTO
	 *
	 * @param causaFinVigencia
	 *            the causaFinVigencia to set
	 */
	public void setCausaFinVigencia(String causaFinVigencia) {
		this.causaFinVigencia = causaFinVigencia;
	}

	/**
	 * Método getter del atributo vigente de la clase DepartamentoDTO
	 *
	 * @return the vigente
	 */
	public Integer getVigente() {
		return vigente;
	}

	/**
	 * Método setter del atributo vigente de la clase DepartamentoDTO
	 *
	 * @param vigente
	 *            the vigente to set
	 */
	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}

	/**
	 * Método getter del atributo nombreMostrar de la clase DepartamentoDTO
	 *
	 * @return the nombreMostrar
	 */
	public String getNombreMostrar() {
		return nombreMostrar;
	}

	/**
	 * Método setter del atributo nombreMostrar de la clase DepartamentoDTO
	 *
	 * @param nombreMostrar
	 *            the nombreMostrar to set
	 */
	public void setNombreMostrar(String nombreMostrar) {
		this.nombreMostrar = nombreMostrar;
	}

	/**
	 * Método getter del atributo nombre de la clase DepartamentoDTO
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre de la clase DepartamentoDTO
	 *
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter del atributo codigo de la clase DepartamentoDTO
	 *
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Método setter del atributo codigo de la clase DepartamentoDTO
	 *
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Método getter del atributo idSoiDepartamento de la clase DepartamentoDTO
	 *
	 * @return the idSoiDepartamento
	 */
	public Integer getIdSoiDepartamento() {
		return idSoiDepartamento;
	}

	/**
	 * Método setter del atributo idSoiDepartamento de la clase DepartamentoDTO
	 *
	 * @param idSoiDepartamento
	 *            the idSoiDepartamento to set
	 */
	public void setIdSoiDepartamento(Integer idSoiDepartamento) {
		this.idSoiDepartamento = idSoiDepartamento;
	}

}

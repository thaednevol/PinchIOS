package co.swatit.pilautil.dto.out;

import java.io.Serializable;

import com.ach.cfg.biz.model.MunicipioVO;

/**
 * 
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link MunicipioVO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class MunicipioDTO implements Serializable {
	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	private String causaFinVigencia;
	private Integer vigente;
	private String nombreMostrar;
	private String nombre;
	private String codigo;
	private Integer idSoiDepartamento;
	private Long idSoiMunicipio;
	private Integer vigenteDepartamento;
	private String nombreMostrarDepto;

	/**
	 * Método getter del atributo causaFinVigencia de la clase CiudadDTO
	 *
	 * @return the causaFinVigencia
	 */
	public String getCausaFinVigencia() {
		return causaFinVigencia;
	}

	/**
	 * Método setter del atributo causaFinVigencia de la clase CiudadDTO
	 *
	 * @param causaFinVigencia
	 *            the causaFinVigencia to set
	 */
	public void setCausaFinVigencia(String causaFinVigencia) {
		this.causaFinVigencia = causaFinVigencia;
	}

	/**
	 * Método getter del atributo vigente de la clase CiudadDTO
	 *
	 * @return the vigente
	 */
	public Integer getVigente() {
		return vigente;
	}

	/**
	 * Método setter del atributo vigente de la clase CiudadDTO
	 *
	 * @param vigente
	 *            the vigente to set
	 */
	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}

	/**
	 * Método getter del atributo nombreMostrar de la clase CiudadDTO
	 *
	 * @return the nombreMostrar
	 */
	public String getNombreMostrar() {
		return nombreMostrar;
	}

	/**
	 * Método setter del atributo nombreMostrar de la clase CiudadDTO
	 *
	 * @param nombreMostrar
	 *            the nombreMostrar to set
	 */
	public void setNombreMostrar(String nombreMostrar) {
		this.nombreMostrar = nombreMostrar;
	}

	/**
	 * Método getter del atributo nombre de la clase CiudadDTO
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre de la clase CiudadDTO
	 *
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter del atributo codigo de la clase CiudadDTO
	 *
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Método setter del atributo codigo de la clase CiudadDTO
	 *
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Método getter del atributo idSoiDepartamento de la clase CiudadDTO
	 *
	 * @return the idSoiDepartamento
	 */
	public Integer getIdSoiDepartamento() {
		return idSoiDepartamento;
	}

	/**
	 * Método setter del atributo idSoiDepartamento de la clase CiudadDTO
	 *
	 * @param idSoiDepartamento
	 *            the idSoiDepartamento to set
	 */
	public void setIdSoiDepartamento(Integer idSoiDepartamento) {
		this.idSoiDepartamento = idSoiDepartamento;
	}

	/**
	 * Método getter del atributo idSoiMunicipio de la clase CiudadDTO
	 *
	 * @return the idSoiMunicipio
	 */
	public Long getIdSoiMunicipio() {
		return idSoiMunicipio;
	}

	/**
	 * Método setter del atributo idSoiMunicipio de la clase CiudadDTO
	 *
	 * @param idSoiMunicipio
	 *            the idSoiMunicipio to set
	 */
	public void setIdSoiMunicipio(Long idSoiMunicipio) {
		this.idSoiMunicipio = idSoiMunicipio;
	}

	/**
	 * Método getter del atributo vigenteDepartamento de la clase CiudadDTO
	 *
	 * @return the vigenteDepartamento
	 */
	public Integer getVigenteDepartamento() {
		return vigenteDepartamento;
	}

	/**
	 * Método setter del atributo vigenteDepartamento de la clase CiudadDTO
	 *
	 * @param vigenteDepartamento
	 *            the vigenteDepartamento to set
	 */
	public void setVigenteDepartamento(Integer vigenteDepartamento) {
		this.vigenteDepartamento = vigenteDepartamento;
	}

	/**
	 * Método getter del atributo nombreMostrarDepto de la clase CiudadDTO
	 *
	 * @return the nombreMostrarDepto
	 */
	public String getNombreMostrarDepto() {
		return nombreMostrarDepto;
	}

	/**
	 * Método setter del atributo nombreMostrarDepto de la clase CiudadDTO
	 *
	 * @param nombreMostrarDepto
	 *            the nombreMostrarDepto to set
	 */
	public void setNombreMostrarDepto(String nombreMostrarDepto) {
		this.nombreMostrarDepto = nombreMostrarDepto;
	}

}

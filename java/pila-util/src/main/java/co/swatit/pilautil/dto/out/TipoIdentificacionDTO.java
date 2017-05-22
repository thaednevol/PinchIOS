/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;

import com.ach.cfg.biz.model.TipoIdentificacionVO;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link TipoIdentificacionVO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class TipoIdentificacionDTO implements Serializable {
	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	private String codTpIdenAllus;
	private Integer aplicaCzteResExterior;
	private Integer aplicaCotizante;
	private Integer aplicaRl;
	private String causaFinVigencia;
	private String fechaFinVigencia;
	private String fechaInicioVigencia;
	private Integer aplicaUsuarioBco;
	private Integer aplicaUsuarioApte;
	private Integer aplicaIndependiente;
	private Integer aplicaEmpresa;
	private Integer vigente;
	private String nombreMostrar;
	private String nombre;
	private String codigo;
	private Integer idSoiTpIdentificacion;

	/**
	 * Método getter del atributo codTpIdenAllus de la clase TipoIdentificacionDTO
	 *
	 * @return the codTpIdenAllus
	 */
	public String getCodTpIdenAllus() {
		return codTpIdenAllus;
	}

	/**
	 * Método setter del atributo codTpIdenAllus de la clase TipoIdentificacionDTO
	 *
	 * @param codTpIdenAllus
	 *            the codTpIdenAllus to set
	 */
	public void setCodTpIdenAllus(String codTpIdenAllus) {
		this.codTpIdenAllus = codTpIdenAllus;
	}

	/**
	 * Método getter del atributo aplicaCzteResExterior de la clase TipoIdentificacionDTO
	 *
	 * @return the aplicaCzteResExterior
	 */
	public Integer getAplicaCzteResExterior() {
		return aplicaCzteResExterior;
	}

	/**
	 * Método setter del atributo aplicaCzteResExterior de la clase TipoIdentificacionDTO
	 *
	 * @param aplicaCzteResExterior
	 *            the aplicaCzteResExterior to set
	 */
	public void setAplicaCzteResExterior(Integer aplicaCzteResExterior) {
		this.aplicaCzteResExterior = aplicaCzteResExterior;
	}

	/**
	 * Método getter del atributo aplicaCotizante de la clase TipoIdentificacionDTO
	 *
	 * @return the aplicaCotizante
	 */
	public Integer getAplicaCotizante() {
		return aplicaCotizante;
	}

	/**
	 * Método setter del atributo aplicaCotizante de la clase TipoIdentificacionDTO
	 *
	 * @param aplicaCotizante
	 *            the aplicaCotizante to set
	 */
	public void setAplicaCotizante(Integer aplicaCotizante) {
		this.aplicaCotizante = aplicaCotizante;
	}

	/**
	 * Método getter del atributo aplicaRl de la clase TipoIdentificacionDTO
	 *
	 * @return the aplicaRl
	 */
	public Integer getAplicaRl() {
		return aplicaRl;
	}

	/**
	 * Método setter del atributo aplicaRl de la clase TipoIdentificacionDTO
	 *
	 * @param aplicaRl
	 *            the aplicaRl to set
	 */
	public void setAplicaRl(Integer aplicaRl) {
		this.aplicaRl = aplicaRl;
	}

	/**
	 * Método getter del atributo causaFinVigencia de la clase TipoIdentificacionDTO
	 *
	 * @return the causaFinVigencia
	 */
	public String getCausaFinVigencia() {
		return causaFinVigencia;
	}

	/**
	 * Método setter del atributo causaFinVigencia de la clase TipoIdentificacionDTO
	 *
	 * @param causaFinVigencia
	 *            the causaFinVigencia to set
	 */
	public void setCausaFinVigencia(String causaFinVigencia) {
		this.causaFinVigencia = causaFinVigencia;
	}

	/**
	 * Método getter del atributo fechaFinVigencia de la clase TipoIdentificacionDTO
	 *
	 * @return the fechaFinVigencia
	 */
	public String getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	/**
	 * Método setter del atributo fechaFinVigencia de la clase TipoIdentificacionDTO
	 *
	 * @param fechaFinVigencia
	 *            the fechaFinVigencia to set
	 */
	public void setFechaFinVigencia(String fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	/**
	 * Método getter del atributo fechaInicioVigencia de la clase TipoIdentificacionDTO
	 *
	 * @return the fechaInicioVigencia
	 */
	public String getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	/**
	 * Método setter del atributo fechaInicioVigencia de la clase TipoIdentificacionDTO
	 *
	 * @param fechaInicioVigencia
	 *            the fechaInicioVigencia to set
	 */
	public void setFechaInicioVigencia(String fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	/**
	 * Método getter del atributo aplicaUsuarioBco de la clase TipoIdentificacionDTO
	 *
	 * @return the aplicaUsuarioBco
	 */
	public Integer getAplicaUsuarioBco() {
		return aplicaUsuarioBco;
	}

	/**
	 * Método setter del atributo aplicaUsuarioBco de la clase TipoIdentificacionDTO
	 *
	 * @param aplicaUsuarioBco
	 *            the aplicaUsuarioBco to set
	 */
	public void setAplicaUsuarioBco(Integer aplicaUsuarioBco) {
		this.aplicaUsuarioBco = aplicaUsuarioBco;
	}

	/**
	 * Método getter del atributo aplicaUsuarioApte de la clase TipoIdentificacionDTO
	 *
	 * @return the aplicaUsuarioApte
	 */
	public Integer getAplicaUsuarioApte() {
		return aplicaUsuarioApte;
	}

	/**
	 * Método setter del atributo aplicaUsuarioApte de la clase TipoIdentificacionDTO
	 *
	 * @param aplicaUsuarioApte
	 *            the aplicaUsuarioApte to set
	 */
	public void setAplicaUsuarioApte(Integer aplicaUsuarioApte) {
		this.aplicaUsuarioApte = aplicaUsuarioApte;
	}

	/**
	 * Método getter del atributo aplicaIndependiente de la clase TipoIdentificacionDTO
	 *
	 * @return the aplicaIndependiente
	 */
	public Integer getAplicaIndependiente() {
		return aplicaIndependiente;
	}

	/**
	 * Método setter del atributo aplicaIndependiente de la clase TipoIdentificacionDTO
	 *
	 * @param aplicaIndependiente
	 *            the aplicaIndependiente to set
	 */
	public void setAplicaIndependiente(Integer aplicaIndependiente) {
		this.aplicaIndependiente = aplicaIndependiente;
	}

	/**
	 * Método getter del atributo aplicaEmpresa de la clase TipoIdentificacionDTO
	 *
	 * @return the aplicaEmpresa
	 */
	public Integer getAplicaEmpresa() {
		return aplicaEmpresa;
	}

	/**
	 * Método setter del atributo aplicaEmpresa de la clase TipoIdentificacionDTO
	 *
	 * @param aplicaEmpresa
	 *            the aplicaEmpresa to set
	 */
	public void setAplicaEmpresa(Integer aplicaEmpresa) {
		this.aplicaEmpresa = aplicaEmpresa;
	}

	/**
	 * Método getter del atributo vigente de la clase TipoIdentificacionDTO
	 *
	 * @return the vigente
	 */
	public Integer getVigente() {
		return vigente;
	}

	/**
	 * Método setter del atributo vigente de la clase TipoIdentificacionDTO
	 *
	 * @param vigente
	 *            the vigente to set
	 */
	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}

	/**
	 * Método getter del atributo nombreMostrar de la clase TipoIdentificacionDTO
	 *
	 * @return the nombreMostrar
	 */
	public String getNombreMostrar() {
		return nombreMostrar;
	}

	/**
	 * Método setter del atributo nombreMostrar de la clase TipoIdentificacionDTO
	 *
	 * @param nombreMostrar
	 *            the nombreMostrar to set
	 */
	public void setNombreMostrar(String nombreMostrar) {
		this.nombreMostrar = nombreMostrar;
	}

	/**
	 * Método getter del atributo nombre de la clase TipoIdentificacionDTO
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre de la clase TipoIdentificacionDTO
	 *
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter del atributo codigo de la clase TipoIdentificacionDTO
	 *
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Método setter del atributo codigo de la clase TipoIdentificacionDTO
	 *
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Método getter del atributo idSoiTpIdentificacion de la clase TipoIdentificacionDTO
	 *
	 * @return the idSoiTpIdentificacion
	 */
	public Integer getIdSoiTpIdentificacion() {
		return idSoiTpIdentificacion;
	}

	/**
	 * Método setter del atributo idSoiTpIdentificacion de la clase TipoIdentificacionDTO
	 *
	 * @param idSoiTpIdentificacion
	 *            the idSoiTpIdentificacion to set
	 */
	public void setIdSoiTpIdentificacion(Integer idSoiTpIdentificacion) {
		this.idSoiTpIdentificacion = idSoiTpIdentificacion;
	}
}

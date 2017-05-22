/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.ach.seg.biz.model.UsuarioVO;

/**
 * Objeto de transporte que contiene la información obtenida de un objeto de tipo {@link UsuarioVO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 8/03/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserDTO")
public class UserDTO implements Serializable {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;

	private Integer cambioContrasena;
	private String causaFinVigencia;
	private String fechaFinVigencia;
	private Integer vigente;
	private String fechaInicioVigencia;
	private Integer idSegTpUsuario;
	private String fcaActContrasena;
	private String sal;
	private String contrasenaAnt;
	private String contrasena;
	private String cuenta;
	private Integer estado;
	private String nmrIdentificacion;
	private Integer idTpIdentificacion;
	private String email;
	private String apellido2;
	private String apellido1;
	private String nombre2;
	private String nombre1;
	private Long idSegUsuario;
	private Integer aplicaCotizante;
	private Integer aplicaRl;
	private String causaFinVigencia1;
	private String fechaFinVigencia1;
	private String fechaInicioVigencia1;
	private Integer aplicaUsuarioBco;
	private Integer aplicaUsuarioApte;
	private Integer aplicaIndependiente;
	private Integer aplicaEmpresa;
	private Integer vigente1;
	private String nombreMostrar;
	private String nombre;
	private String codigo;
	private Integer idSoiTpIdentificacion;

	/**
	 * Método getter del atributo cambioContrasena de la clase UserDTO
	 *
	 * @return the cambioContrasena
	 */
	public Integer getCambioContrasena() {
		return cambioContrasena;
	}

	/**
	 * Método setter del atributo cambioContrasena de la clase UserDTO
	 *
	 * @param cambioContrasena
	 *            the cambioContrasena to set
	 */
	public void setCambioContrasena(Integer cambioContrasena) {
		this.cambioContrasena = cambioContrasena;
	}

	/**
	 * Método getter del atributo causaFinVigencia de la clase UserDTO
	 *
	 * @return the causaFinVigencia
	 */
	public String getCausaFinVigencia() {
		return causaFinVigencia;
	}

	/**
	 * Método setter del atributo causaFinVigencia de la clase UserDTO
	 *
	 * @param causaFinVigencia
	 *            the causaFinVigencia to set
	 */
	public void setCausaFinVigencia(String causaFinVigencia) {
		this.causaFinVigencia = causaFinVigencia;
	}

	/**
	 * Método getter del atributo fechaFinVigencia de la clase UserDTO
	 *
	 * @return the fechaFinVigencia
	 */
	public String getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	/**
	 * Método setter del atributo fechaFinVigencia de la clase UserDTO
	 *
	 * @param fechaFinVigencia
	 *            the fechaFinVigencia to set
	 */
	public void setFechaFinVigencia(String fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	/**
	 * Método getter del atributo vigente de la clase UserDTO
	 *
	 * @return the vigente
	 */
	public Integer getVigente() {
		return vigente;
	}

	/**
	 * Método setter del atributo vigente de la clase UserDTO
	 *
	 * @param vigente
	 *            the vigente to set
	 */
	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}

	/**
	 * Método getter del atributo fechaInicioVigencia de la clase UserDTO
	 *
	 * @return the fechaInicioVigencia
	 */
	public String getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	/**
	 * Método setter del atributo fechaInicioVigencia de la clase UserDTO
	 *
	 * @param fechaInicioVigencia
	 *            the fechaInicioVigencia to set
	 */
	public void setFechaInicioVigencia(String fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	/**
	 * Método getter del atributo idSegTpUsuario de la clase UserDTO
	 *
	 * @return the idSegTpUsuario
	 */
	public Integer getIdSegTpUsuario() {
		return idSegTpUsuario;
	}

	/**
	 * Método setter del atributo idSegTpUsuario de la clase UserDTO
	 *
	 * @param idSegTpUsuario
	 *            the idSegTpUsuario to set
	 */
	public void setIdSegTpUsuario(Integer idSegTpUsuario) {
		this.idSegTpUsuario = idSegTpUsuario;
	}

	/**
	 * Método getter del atributo fcaActContrasena de la clase UserDTO
	 *
	 * @return the fcaActContrasena
	 */
	public String getFcaActContrasena() {
		return fcaActContrasena;
	}

	/**
	 * Método setter del atributo fcaActContrasena de la clase UserDTO
	 *
	 * @param fcaActContrasena
	 *            the fcaActContrasena to set
	 */
	public void setFcaActContrasena(String fcaActContrasena) {
		this.fcaActContrasena = fcaActContrasena;
	}

	/**
	 * Método getter del atributo sal de la clase UserDTO
	 *
	 * @return the sal
	 */
	public String getSal() {
		return sal;
	}

	/**
	 * Método setter del atributo sal de la clase UserDTO
	 *
	 * @param sal
	 *            the sal to set
	 */
	public void setSal(String sal) {
		this.sal = sal;
	}

	/**
	 * Método getter del atributo contrasenaAnt de la clase UserDTO
	 *
	 * @return the contrasenaAnt
	 */
	public String getContrasenaAnt() {
		return contrasenaAnt;
	}

	/**
	 * Método setter del atributo contrasenaAnt de la clase UserDTO
	 *
	 * @param contrasenaAnt
	 *            the contrasenaAnt to set
	 */
	public void setContrasenaAnt(String contrasenaAnt) {
		this.contrasenaAnt = contrasenaAnt;
	}

	/**
	 * Método getter del atributo contrasena de la clase UserDTO
	 *
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * Método setter del atributo contrasena de la clase UserDTO
	 *
	 * @param contrasena
	 *            the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * Método getter del atributo cuenta de la clase UserDTO
	 *
	 * @return the cuenta
	 */
	public String getCuenta() {
		return cuenta;
	}

	/**
	 * Método setter del atributo cuenta de la clase UserDTO
	 *
	 * @param cuenta
	 *            the cuenta to set
	 */
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	/**
	 * Método getter del atributo estado de la clase UserDTO
	 *
	 * @return the estado
	 */
	public Integer getEstado() {
		return estado;
	}

	/**
	 * Método setter del atributo estado de la clase UserDTO
	 *
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	/**
	 * Método getter del atributo nmrIdentificacion de la clase UserDTO
	 *
	 * @return the nmrIdentificacion
	 */
	public String getNmrIdentificacion() {
		return nmrIdentificacion;
	}

	/**
	 * Método setter del atributo nmrIdentificacion de la clase UserDTO
	 *
	 * @param nmrIdentificacion
	 *            the nmrIdentificacion to set
	 */
	public void setNmrIdentificacion(String nmrIdentificacion) {
		this.nmrIdentificacion = nmrIdentificacion;
	}

	/**
	 * Método getter del atributo idTpIdentificacion de la clase UserDTO
	 *
	 * @return the idTpIdentificacion
	 */
	public Integer getIdTpIdentificacion() {
		return idTpIdentificacion;
	}

	/**
	 * Método setter del atributo idTpIdentificacion de la clase UserDTO
	 *
	 * @param idTpIdentificacion
	 *            the idTpIdentificacion to set
	 */
	public void setIdTpIdentificacion(Integer idTpIdentificacion) {
		this.idTpIdentificacion = idTpIdentificacion;
	}

	/**
	 * Método getter del atributo email de la clase UserDTO
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Método setter del atributo email de la clase UserDTO
	 *
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Método getter del atributo apellido2 de la clase UserDTO
	 *
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * Método setter del atributo apellido2 de la clase UserDTO
	 *
	 * @param apellido2
	 *            the apellido2 to set
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * Método getter del atributo apellido1 de la clase UserDTO
	 *
	 * @return the apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * Método setter del atributo apellido1 de la clase UserDTO
	 *
	 * @param apellido1
	 *            the apellido1 to set
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * Método getter del atributo nombre2 de la clase UserDTO
	 *
	 * @return the nombre2
	 */
	public String getNombre2() {
		return nombre2;
	}

	/**
	 * Método setter del atributo nombre2 de la clase UserDTO
	 *
	 * @param nombre2
	 *            the nombre2 to set
	 */
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	/**
	 * Método getter del atributo nombre1 de la clase UserDTO
	 *
	 * @return the nombre1
	 */
	public String getNombre1() {
		return nombre1;
	}

	/**
	 * Método setter del atributo nombre1 de la clase UserDTO
	 *
	 * @param nombre1
	 *            the nombre1 to set
	 */
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	/**
	 * Método getter del atributo idSegUsuario de la clase UserDTO
	 *
	 * @return the idSegUsuario
	 */
	public Long getIdSegUsuario() {
		return idSegUsuario;
	}

	/**
	 * Método setter del atributo idSegUsuario de la clase UserDTO
	 *
	 * @param idSegUsuario
	 *            the idSegUsuario to set
	 */
	public void setIdSegUsuario(Long idSegUsuario) {
		this.idSegUsuario = idSegUsuario;
	}

	/**
	 * Método getter del atributo aplicaCotizante de la clase UserDTO
	 *
	 * @return the aplicaCotizante
	 */
	public Integer getAplicaCotizante() {
		return aplicaCotizante;
	}

	/**
	 * Método setter del atributo aplicaCotizante de la clase UserDTO
	 *
	 * @param aplicaCotizante
	 *            the aplicaCotizante to set
	 */
	public void setAplicaCotizante(Integer aplicaCotizante) {
		this.aplicaCotizante = aplicaCotizante;
	}

	/**
	 * Método getter del atributo aplicaRl de la clase UserDTO
	 *
	 * @return the aplicaRl
	 */
	public Integer getAplicaRl() {
		return aplicaRl;
	}

	/**
	 * Método setter del atributo aplicaRl de la clase UserDTO
	 *
	 * @param aplicaRl
	 *            the aplicaRl to set
	 */
	public void setAplicaRl(Integer aplicaRl) {
		this.aplicaRl = aplicaRl;
	}

	/**
	 * Método getter del atributo causaFinVigencia1 de la clase UserDTO
	 *
	 * @return the causaFinVigencia1
	 */
	public String getCausaFinVigencia1() {
		return causaFinVigencia1;
	}

	/**
	 * Método setter del atributo causaFinVigencia1 de la clase UserDTO
	 *
	 * @param causaFinVigencia1
	 *            the causaFinVigencia1 to set
	 */
	public void setCausaFinVigencia1(String causaFinVigencia1) {
		this.causaFinVigencia1 = causaFinVigencia1;
	}

	/**
	 * Método getter del atributo fechaFinVigencia1 de la clase UserDTO
	 *
	 * @return the fechaFinVigencia1
	 */
	public String getFechaFinVigencia1() {
		return fechaFinVigencia1;
	}

	/**
	 * Método setter del atributo fechaFinVigencia1 de la clase UserDTO
	 *
	 * @param fechaFinVigencia1
	 *            the fechaFinVigencia1 to set
	 */
	public void setFechaFinVigencia1(String fechaFinVigencia1) {
		this.fechaFinVigencia1 = fechaFinVigencia1;
	}

	/**
	 * Método getter del atributo fechaInicioVigencia1 de la clase UserDTO
	 *
	 * @return the fechaInicioVigencia1
	 */
	public String getFechaInicioVigencia1() {
		return fechaInicioVigencia1;
	}

	/**
	 * Método setter del atributo fechaInicioVigencia1 de la clase UserDTO
	 *
	 * @param fechaInicioVigencia1
	 *            the fechaInicioVigencia1 to set
	 */
	public void setFechaInicioVigencia1(String fechaInicioVigencia1) {
		this.fechaInicioVigencia1 = fechaInicioVigencia1;
	}

	/**
	 * Método getter del atributo aplicaUsuarioBco de la clase UserDTO
	 *
	 * @return the aplicaUsuarioBco
	 */
	public Integer getAplicaUsuarioBco() {
		return aplicaUsuarioBco;
	}

	/**
	 * Método setter del atributo aplicaUsuarioBco de la clase UserDTO
	 *
	 * @param aplicaUsuarioBco
	 *            the aplicaUsuarioBco to set
	 */
	public void setAplicaUsuarioBco(Integer aplicaUsuarioBco) {
		this.aplicaUsuarioBco = aplicaUsuarioBco;
	}

	/**
	 * Método getter del atributo aplicaUsuarioApte de la clase UserDTO
	 *
	 * @return the aplicaUsuarioApte
	 */
	public Integer getAplicaUsuarioApte() {
		return aplicaUsuarioApte;
	}

	/**
	 * Método setter del atributo aplicaUsuarioApte de la clase UserDTO
	 *
	 * @param aplicaUsuarioApte
	 *            the aplicaUsuarioApte to set
	 */
	public void setAplicaUsuarioApte(Integer aplicaUsuarioApte) {
		this.aplicaUsuarioApte = aplicaUsuarioApte;
	}

	/**
	 * Método getter del atributo aplicaIndependiente de la clase UserDTO
	 *
	 * @return the aplicaIndependiente
	 */
	public Integer getAplicaIndependiente() {
		return aplicaIndependiente;
	}

	/**
	 * Método setter del atributo aplicaIndependiente de la clase UserDTO
	 *
	 * @param aplicaIndependiente
	 *            the aplicaIndependiente to set
	 */
	public void setAplicaIndependiente(Integer aplicaIndependiente) {
		this.aplicaIndependiente = aplicaIndependiente;
	}

	/**
	 * Método getter del atributo aplicaEmpresa de la clase UserDTO
	 *
	 * @return the aplicaEmpresa
	 */
	public Integer getAplicaEmpresa() {
		return aplicaEmpresa;
	}

	/**
	 * Método setter del atributo aplicaEmpresa de la clase UserDTO
	 *
	 * @param aplicaEmpresa
	 *            the aplicaEmpresa to set
	 */
	public void setAplicaEmpresa(Integer aplicaEmpresa) {
		this.aplicaEmpresa = aplicaEmpresa;
	}

	/**
	 * Método getter del atributo vigente1 de la clase UserDTO
	 *
	 * @return the vigente1
	 */
	public Integer getVigente1() {
		return vigente1;
	}

	/**
	 * Método setter del atributo vigente1 de la clase UserDTO
	 *
	 * @param vigente1
	 *            the vigente1 to set
	 */
	public void setVigente1(Integer vigente1) {
		this.vigente1 = vigente1;
	}

	/**
	 * Método getter del atributo nombreMostrar de la clase UserDTO
	 *
	 * @return the nombreMostrar
	 */
	public String getNombreMostrar() {
		return nombreMostrar;
	}

	/**
	 * Método setter del atributo nombreMostrar de la clase UserDTO
	 *
	 * @param nombreMostrar
	 *            the nombreMostrar to set
	 */
	public void setNombreMostrar(String nombreMostrar) {
		this.nombreMostrar = nombreMostrar;
	}

	/**
	 * Método getter del atributo nombre de la clase UserDTO
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre de la clase UserDTO
	 *
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter del atributo codigo de la clase UserDTO
	 *
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Método setter del atributo codigo de la clase UserDTO
	 *
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Método getter del atributo idSoiTpIdentificacion de la clase UserDTO
	 *
	 * @return the idSoiTpIdentificacion
	 */
	public Integer getIdSoiTpIdentificacion() {
		return idSoiTpIdentificacion;
	}

	/**
	 * Método setter del atributo idSoiTpIdentificacion de la clase UserDTO
	 *
	 * @param idSoiTpIdentificacion
	 *            the idSoiTpIdentificacion to set
	 */
	public void setIdSoiTpIdentificacion(Integer idSoiTpIdentificacion) {
		this.idSoiTpIdentificacion = idSoiTpIdentificacion;
	}

}

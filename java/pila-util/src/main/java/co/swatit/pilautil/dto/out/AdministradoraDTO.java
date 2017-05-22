/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;

import com.ach.cfg.biz.model.AdministradoraVO;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link AdministradoraVO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class AdministradoraDTO implements Serializable {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	private Integer adminPcss;
	private Integer aplicaPnllaCorrecciones;
	private Integer idSoiPenSubsistema;
	private String nombreSoporte;
	private Long periodoFin;
	private Long periodoInicio;
	private String ipModificacion;
	private String usuarioModificacion;
	private String ipCreacion;
	private String usuarioCreacion;
	private String correoContacto;
	private Integer idNuevaAdministradora;
	private String fechaFusion;
	private Integer fusionada;
	private Integer fsp;
	private Integer multipleArp;
	private String naturaleza;
	private String causaFinVigencia;
	private Integer vigente;
	private Integer idSoiSubsistema;
	private String numeroIdentificacion;
	private Integer idTpIdentificacion;
	private String nombreMostrar;
	private String nombre;
	private String codAdministradora;
	private Integer idSoiAdministradora;
	private Integer vigenteSubsistema;
	private Integer idSoiTpCotizante;
	private Integer idSoiSubtpCotizante;
	private Long idSoiAdmCobertura;
	private Integer idSoiMunicipioCobertura;
	private Integer vigenteAdmCobertura;
	private String fechaInicioVigenciaCobertura;
	private String fechaFinVigenciaCobertura;
	private AdministradoraDTO administradoraFusion;

	/**
	 * Método getter del atributo adminPcss de la clase AdministradoraDTO
	 *
	 * @return the adminPcss
	 */
	public Integer getAdminPcss() {
		return adminPcss;
	}

	/**
	 * Método setter del atributo adminPcss de la clase AdministradoraDTO
	 *
	 * @param adminPcss
	 *            the adminPcss to set
	 */
	public void setAdminPcss(Integer adminPcss) {
		this.adminPcss = adminPcss;
	}

	/**
	 * Método getter del atributo aplicaPnllaCorrecciones de la clase AdministradoraDTO
	 *
	 * @return the aplicaPnllaCorrecciones
	 */
	public Integer getAplicaPnllaCorrecciones() {
		return aplicaPnllaCorrecciones;
	}

	/**
	 * Método setter del atributo aplicaPnllaCorrecciones de la clase AdministradoraDTO
	 *
	 * @param aplicaPnllaCorrecciones
	 *            the aplicaPnllaCorrecciones to set
	 */
	public void setAplicaPnllaCorrecciones(Integer aplicaPnllaCorrecciones) {
		this.aplicaPnllaCorrecciones = aplicaPnllaCorrecciones;
	}

	/**
	 * Método getter del atributo idSoiPenSubsistema de la clase AdministradoraDTO
	 *
	 * @return the idSoiPenSubsistema
	 */
	public Integer getIdSoiPenSubsistema() {
		return idSoiPenSubsistema;
	}

	/**
	 * Método setter del atributo idSoiPenSubsistema de la clase AdministradoraDTO
	 *
	 * @param idSoiPenSubsistema
	 *            the idSoiPenSubsistema to set
	 */
	public void setIdSoiPenSubsistema(Integer idSoiPenSubsistema) {
		this.idSoiPenSubsistema = idSoiPenSubsistema;
	}

	/**
	 * Método getter del atributo nombreSoporte de la clase AdministradoraDTO
	 *
	 * @return the nombreSoporte
	 */
	public String getNombreSoporte() {
		return nombreSoporte;
	}

	/**
	 * Método setter del atributo nombreSoporte de la clase AdministradoraDTO
	 *
	 * @param nombreSoporte
	 *            the nombreSoporte to set
	 */
	public void setNombreSoporte(String nombreSoporte) {
		this.nombreSoporte = nombreSoporte;
	}

	/**
	 * Método getter del atributo periodoFin de la clase AdministradoraDTO
	 *
	 * @return the periodoFin
	 */
	public Long getPeriodoFin() {
		return periodoFin;
	}

	/**
	 * Método setter del atributo periodoFin de la clase AdministradoraDTO
	 *
	 * @param periodoFin
	 *            the periodoFin to set
	 */
	public void setPeriodoFin(Long periodoFin) {
		this.periodoFin = periodoFin;
	}

	/**
	 * Método getter del atributo periodoInicio de la clase AdministradoraDTO
	 *
	 * @return the periodoInicio
	 */
	public Long getPeriodoInicio() {
		return periodoInicio;
	}

	/**
	 * Método setter del atributo periodoInicio de la clase AdministradoraDTO
	 *
	 * @param periodoInicio
	 *            the periodoInicio to set
	 */
	public void setPeriodoInicio(Long periodoInicio) {
		this.periodoInicio = periodoInicio;
	}

	/**
	 * Método getter del atributo ipModificacion de la clase AdministradoraDTO
	 *
	 * @return the ipModificacion
	 */
	public String getIpModificacion() {
		return ipModificacion;
	}

	/**
	 * Método setter del atributo ipModificacion de la clase AdministradoraDTO
	 *
	 * @param ipModificacion
	 *            the ipModificacion to set
	 */
	public void setIpModificacion(String ipModificacion) {
		this.ipModificacion = ipModificacion;
	}

	/**
	 * Método getter del atributo usuarioModificacion de la clase AdministradoraDTO
	 *
	 * @return the usuarioModificacion
	 */
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	/**
	 * Método setter del atributo usuarioModificacion de la clase AdministradoraDTO
	 *
	 * @param usuarioModificacion
	 *            the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	/**
	 * Método getter del atributo ipCreacion de la clase AdministradoraDTO
	 *
	 * @return the ipCreacion
	 */
	public String getIpCreacion() {
		return ipCreacion;
	}

	/**
	 * Método setter del atributo ipCreacion de la clase AdministradoraDTO
	 *
	 * @param ipCreacion
	 *            the ipCreacion to set
	 */
	public void setIpCreacion(String ipCreacion) {
		this.ipCreacion = ipCreacion;
	}

	/**
	 * Método getter del atributo usuarioCreacion de la clase AdministradoraDTO
	 *
	 * @return the usuarioCreacion
	 */
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	/**
	 * Método setter del atributo usuarioCreacion de la clase AdministradoraDTO
	 *
	 * @param usuarioCreacion
	 *            the usuarioCreacion to set
	 */
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	/**
	 * Método getter del atributo correoContacto de la clase AdministradoraDTO
	 *
	 * @return the correoContacto
	 */
	public String getCorreoContacto() {
		return correoContacto;
	}

	/**
	 * Método setter del atributo correoContacto de la clase AdministradoraDTO
	 *
	 * @param correoContacto
	 *            the correoContacto to set
	 */
	public void setCorreoContacto(String correoContacto) {
		this.correoContacto = correoContacto;
	}

	/**
	 * Método getter del atributo idNuevaAdministradora de la clase AdministradoraDTO
	 *
	 * @return the idNuevaAdministradora
	 */
	public Integer getIdNuevaAdministradora() {
		return idNuevaAdministradora;
	}

	/**
	 * Método setter del atributo idNuevaAdministradora de la clase AdministradoraDTO
	 *
	 * @param idNuevaAdministradora
	 *            the idNuevaAdministradora to set
	 */
	public void setIdNuevaAdministradora(Integer idNuevaAdministradora) {
		this.idNuevaAdministradora = idNuevaAdministradora;
	}

	/**
	 * Método getter del atributo fechaFusion de la clase AdministradoraDTO
	 *
	 * @return the fechaFusion
	 */
	public String getFechaFusion() {
		return fechaFusion;
	}

	/**
	 * Método setter del atributo fechaFusion de la clase AdministradoraDTO
	 *
	 * @param fechaFusion
	 *            the fechaFusion to set
	 */
	public void setFechaFusion(String fechaFusion) {
		this.fechaFusion = fechaFusion;
	}

	/**
	 * Método getter del atributo fusionada de la clase AdministradoraDTO
	 *
	 * @return the fusionada
	 */
	public Integer getFusionada() {
		return fusionada;
	}

	/**
	 * Método setter del atributo fusionada de la clase AdministradoraDTO
	 *
	 * @param fusionada
	 *            the fusionada to set
	 */
	public void setFusionada(Integer fusionada) {
		this.fusionada = fusionada;
	}

	/**
	 * Método getter del atributo fsp de la clase AdministradoraDTO
	 *
	 * @return the fsp
	 */
	public Integer getFsp() {
		return fsp;
	}

	/**
	 * Método setter del atributo fsp de la clase AdministradoraDTO
	 *
	 * @param fsp
	 *            the fsp to set
	 */
	public void setFsp(Integer fsp) {
		this.fsp = fsp;
	}

	/**
	 * Método getter del atributo multipleArp de la clase AdministradoraDTO
	 *
	 * @return the multipleArp
	 */
	public Integer getMultipleArp() {
		return multipleArp;
	}

	/**
	 * Método setter del atributo multipleArp de la clase AdministradoraDTO
	 *
	 * @param multipleArp
	 *            the multipleArp to set
	 */
	public void setMultipleArp(Integer multipleArp) {
		this.multipleArp = multipleArp;
	}

	/**
	 * Método getter del atributo naturaleza de la clase AdministradoraDTO
	 *
	 * @return the naturaleza
	 */
	public String getNaturaleza() {
		return naturaleza;
	}

	/**
	 * Método setter del atributo naturaleza de la clase AdministradoraDTO
	 *
	 * @param naturaleza
	 *            the naturaleza to set
	 */
	public void setNaturaleza(String naturaleza) {
		this.naturaleza = naturaleza;
	}

	/**
	 * Método getter del atributo causaFinVigencia de la clase AdministradoraDTO
	 *
	 * @return the causaFinVigencia
	 */
	public String getCausaFinVigencia() {
		return causaFinVigencia;
	}

	/**
	 * Método setter del atributo causaFinVigencia de la clase AdministradoraDTO
	 *
	 * @param causaFinVigencia
	 *            the causaFinVigencia to set
	 */
	public void setCausaFinVigencia(String causaFinVigencia) {
		this.causaFinVigencia = causaFinVigencia;
	}

	/**
	 * Método getter del atributo vigente de la clase AdministradoraDTO
	 *
	 * @return the vigente
	 */
	public Integer getVigente() {
		return vigente;
	}

	/**
	 * Método setter del atributo vigente de la clase AdministradoraDTO
	 *
	 * @param vigente
	 *            the vigente to set
	 */
	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}

	/**
	 * Método getter del atributo idSoiSubsistema de la clase AdministradoraDTO
	 *
	 * @return the idSoiSubsistema
	 */
	public Integer getIdSoiSubsistema() {
		return idSoiSubsistema;
	}

	/**
	 * Método setter del atributo idSoiSubsistema de la clase AdministradoraDTO
	 *
	 * @param idSoiSubsistema
	 *            the idSoiSubsistema to set
	 */
	public void setIdSoiSubsistema(Integer idSoiSubsistema) {
		this.idSoiSubsistema = idSoiSubsistema;
	}

	/**
	 * Método getter del atributo numeroIdentificacion de la clase AdministradoraDTO
	 *
	 * @return the numeroIdentificacion
	 */
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	/**
	 * Método setter del atributo numeroIdentificacion de la clase AdministradoraDTO
	 *
	 * @param numeroIdentificacion
	 *            the numeroIdentificacion to set
	 */
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	/**
	 * Método getter del atributo idTpIdentificacion de la clase AdministradoraDTO
	 *
	 * @return the idTpIdentificacion
	 */
	public Integer getIdTpIdentificacion() {
		return idTpIdentificacion;
	}

	/**
	 * Método setter del atributo idTpIdentificacion de la clase AdministradoraDTO
	 *
	 * @param idTpIdentificacion
	 *            the idTpIdentificacion to set
	 */
	public void setIdTpIdentificacion(Integer idTpIdentificacion) {
		this.idTpIdentificacion = idTpIdentificacion;
	}

	/**
	 * Método getter del atributo nombreMostrar de la clase AdministradoraDTO
	 *
	 * @return the nombreMostrar
	 */
	public String getNombreMostrar() {
		return nombreMostrar;
	}

	/**
	 * Método setter del atributo nombreMostrar de la clase AdministradoraDTO
	 *
	 * @param nombreMostrar
	 *            the nombreMostrar to set
	 */
	public void setNombreMostrar(String nombreMostrar) {
		this.nombreMostrar = nombreMostrar;
	}

	/**
	 * Método getter del atributo nombre de la clase AdministradoraDTO
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre de la clase AdministradoraDTO
	 *
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter del atributo codAdministradora de la clase AdministradoraDTO
	 *
	 * @return the codAdministradora
	 */
	public String getCodAdministradora() {
		return codAdministradora;
	}

	/**
	 * Método setter del atributo codAdministradora de la clase AdministradoraDTO
	 *
	 * @param codAdministradora
	 *            the codAdministradora to set
	 */
	public void setCodAdministradora(String codAdministradora) {
		this.codAdministradora = codAdministradora;
	}

	/**
	 * Método getter del atributo idSoiAdministradora de la clase AdministradoraDTO
	 *
	 * @return the idSoiAdministradora
	 */
	public Integer getIdSoiAdministradora() {
		return idSoiAdministradora;
	}

	/**
	 * Método setter del atributo idSoiAdministradora de la clase AdministradoraDTO
	 *
	 * @param idSoiAdministradora
	 *            the idSoiAdministradora to set
	 */
	public void setIdSoiAdministradora(Integer idSoiAdministradora) {
		this.idSoiAdministradora = idSoiAdministradora;
	}

	/**
	 * Método getter del atributo vigenteSubsistema de la clase AdministradoraDTO
	 *
	 * @return the vigenteSubsistema
	 */
	public Integer getVigenteSubsistema() {
		return vigenteSubsistema;
	}

	/**
	 * Método setter del atributo vigenteSubsistema de la clase AdministradoraDTO
	 *
	 * @param vigenteSubsistema
	 *            the vigenteSubsistema to set
	 */
	public void setVigenteSubsistema(Integer vigenteSubsistema) {
		this.vigenteSubsistema = vigenteSubsistema;
	}

	/**
	 * Método getter del atributo idSoiTpCotizante de la clase AdministradoraDTO
	 *
	 * @return the idSoiTpCotizante
	 */
	public Integer getIdSoiTpCotizante() {
		return idSoiTpCotizante;
	}

	/**
	 * Método setter del atributo idSoiTpCotizante de la clase AdministradoraDTO
	 *
	 * @param idSoiTpCotizante
	 *            the idSoiTpCotizante to set
	 */
	public void setIdSoiTpCotizante(Integer idSoiTpCotizante) {
		this.idSoiTpCotizante = idSoiTpCotizante;
	}

	/**
	 * Método getter del atributo idSoiSubtpCotizante de la clase AdministradoraDTO
	 *
	 * @return the idSoiSubtpCotizante
	 */
	public Integer getIdSoiSubtpCotizante() {
		return idSoiSubtpCotizante;
	}

	/**
	 * Método setter del atributo idSoiSubtpCotizante de la clase AdministradoraDTO
	 *
	 * @param idSoiSubtpCotizante
	 *            the idSoiSubtpCotizante to set
	 */
	public void setIdSoiSubtpCotizante(Integer idSoiSubtpCotizante) {
		this.idSoiSubtpCotizante = idSoiSubtpCotizante;
	}

	/**
	 * Método getter del atributo idSoiAdmCobertura de la clase AdministradoraDTO
	 *
	 * @return the idSoiAdmCobertura
	 */
	public Long getIdSoiAdmCobertura() {
		return idSoiAdmCobertura;
	}

	/**
	 * Método setter del atributo idSoiAdmCobertura de la clase AdministradoraDTO
	 *
	 * @param idSoiAdmCobertura
	 *            the idSoiAdmCobertura to set
	 */
	public void setIdSoiAdmCobertura(Long idSoiAdmCobertura) {
		this.idSoiAdmCobertura = idSoiAdmCobertura;
	}

	/**
	 * Método getter del atributo idSoiMunicipioCobertura de la clase AdministradoraDTO
	 *
	 * @return the idSoiMunicipioCobertura
	 */
	public Integer getIdSoiMunicipioCobertura() {
		return idSoiMunicipioCobertura;
	}

	/**
	 * Método setter del atributo idSoiMunicipioCobertura de la clase AdministradoraDTO
	 *
	 * @param idSoiMunicipioCobertura
	 *            the idSoiMunicipioCobertura to set
	 */
	public void setIdSoiMunicipioCobertura(Integer idSoiMunicipioCobertura) {
		this.idSoiMunicipioCobertura = idSoiMunicipioCobertura;
	}

	/**
	 * Método getter del atributo vigenteAdmCobertura de la clase AdministradoraDTO
	 *
	 * @return the vigenteAdmCobertura
	 */
	public Integer getVigenteAdmCobertura() {
		return vigenteAdmCobertura;
	}

	/**
	 * Método setter del atributo vigenteAdmCobertura de la clase AdministradoraDTO
	 *
	 * @param vigenteAdmCobertura
	 *            the vigenteAdmCobertura to set
	 */
	public void setVigenteAdmCobertura(Integer vigenteAdmCobertura) {
		this.vigenteAdmCobertura = vigenteAdmCobertura;
	}

	/**
	 * Método getter del atributo fechaInicioVigenciaCobertura de la clase AdministradoraDTO
	 *
	 * @return the fechaInicioVigenciaCobertura
	 */
	public String getFechaInicioVigenciaCobertura() {
		return fechaInicioVigenciaCobertura;
	}

	/**
	 * Método setter del atributo fechaInicioVigenciaCobertura de la clase AdministradoraDTO
	 *
	 * @param fechaInicioVigenciaCobertura
	 *            the fechaInicioVigenciaCobertura to set
	 */
	public void setFechaInicioVigenciaCobertura(String fechaInicioVigenciaCobertura) {
		this.fechaInicioVigenciaCobertura = fechaInicioVigenciaCobertura;
	}

	/**
	 * Método getter del atributo fechaFinVigenciaCobertura de la clase AdministradoraDTO
	 *
	 * @return the fechaFinVigenciaCobertura
	 */
	public String getFechaFinVigenciaCobertura() {
		return fechaFinVigenciaCobertura;
	}

	/**
	 * Método setter del atributo fechaFinVigenciaCobertura de la clase AdministradoraDTO
	 *
	 * @param fechaFinVigenciaCobertura
	 *            the fechaFinVigenciaCobertura to set
	 */
	public void setFechaFinVigenciaCobertura(String fechaFinVigenciaCobertura) {
		this.fechaFinVigenciaCobertura = fechaFinVigenciaCobertura;
	}

	/**
	 * Método getter del atributo administradoraFusion de la clase AdministradoraDTO
	 *
	 * @return the administradoraFusion
	 */
	public AdministradoraDTO getAdministradoraFusion() {
		return administradoraFusion;
	}

	/**
	 * Método setter del atributo administradoraFusion de la clase AdministradoraDTO
	 *
	 * @param administradoraFusion
	 *            the administradoraFusion to set
	 */
	public void setAdministradoraFusion(AdministradoraDTO administradoraFusion) {
		this.administradoraFusion = administradoraFusion;
	}

}

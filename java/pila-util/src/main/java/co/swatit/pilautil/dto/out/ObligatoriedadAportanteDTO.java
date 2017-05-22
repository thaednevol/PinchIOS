package co.swatit.pilautil.dto.out;

import java.io.Serializable;

import com.ach.apt.biz.model.ObligatoriedadAportanteVO;

/**
 * 
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link ObligatoriedadAportanteVO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class ObligatoriedadAportanteDTO implements Serializable {

	/**
	 * Constante de Serialización
	 */
	private static final long serialVersionUID = 1L;
	private String ipModificacion;
	private String fechaModificacion;
	private String usuarioModificacion;
	private String ipCreacion;
	private String fechaCreacion;
	private String usuarioCreacion;
	private String causaFinVigencia;
	private String fechaFinVigencia;
	private String fechaInicioVigencia;
	private Integer vigente;
	private String tpObligatoriedad;
	private Integer idSoiSubsistema;
	private Long idSoiAportante;
	private Long idSoiOblgAportante;
	private String ipModificacion1;
	private String fechaModificacion1;
	private String usuarioModificacion1;
	private String ipCreacion1;
	private String fechaCreacion1;
	private String usuarioCreacion1;
	private String causaFinVigencia1;
	private String fechaFinVigencia1;
	private String fechaInicioVigencia1;
	private Integer vigente1;
	private String nombreMostrar;
	private String nombre;
	private String codigo;
	private Integer idSoiSubsistema1;
	private Integer ctaEntidadFinanciera;
	private String celular;
	private String correo;
	private Integer infoViaCelular;
	private Integer infoViaCorreo;
	private String ipModificacion2;
	private String fechaModificacion2;
	private String usuarioModificacion2;
	private String ipCreacion2;
	private String fechaCreacion2;
	private String usuarioCreacion2;
	private String apellido;
	private String causaFinVigencia2;
	private String fechaFinVigencia2;
	private Integer vigente2;
	private String fechaInicioVigencia2;
	private Integer idArp;
	private Integer idCcf;
	private Integer aporteEsapMinedu;
	private String codTpPersonaFinanciera;
	private Integer idSoiTpPagadorPension;
	private String fechaFinAccion;
	private String fechaInicioAccion;
	private Integer idSoiTpAccion;
	private String rlSegundoApellido;
	private String rlPrimerApellido;
	private String rlSegundoNombre;
	private String rlPrimerNombre;
	private String rlNumeroIdentificacion;
	private Integer rlIdTpIdentificacion;
	private String fax;
	private String extension;
	private String telefono;
	private Integer idSoiActividadEcon;
	private Long idSoiMunicipio;
	private String direccion;
	private Integer idSoiFormaPresentacion;
	private String codTpPersona;
	private Integer idSoiTpEmpresa;
	private Integer idSoiTpAportante;
	private Integer idSoiClaseAportante;
	private String digitoVerificacion;
	private String numeroIdentificacion;
	private Integer idSoiTpIdentificacion;
	private String nombre1;
	private Long idSoiAportante1;

	/**
	 * Método getter del atributo ipModificacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the ipModificacion
	 */
	public String getIpModificacion() {
		return ipModificacion;
	}

	/**
	 * Método setter del atributo ipModificacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @param ipModificacion
	 *            the ipModificacion to set
	 */
	public void setIpModificacion(String ipModificacion) {
		this.ipModificacion = ipModificacion;
	}

	/**
	 * Método getter del atributo fechaModificacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the fechaModificacion
	 */
	public String getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * Método setter del atributo fechaModificacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @param fechaModificacion
	 *            the fechaModificacion to set
	 */
	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * Método getter del atributo usuarioModificacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the usuarioModificacion
	 */
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	/**
	 * Método setter del atributo usuarioModificacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @param usuarioModificacion
	 *            the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	/**
	 * Método getter del atributo ipCreacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the ipCreacion
	 */
	public String getIpCreacion() {
		return ipCreacion;
	}

	/**
	 * Método setter del atributo ipCreacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @param ipCreacion
	 *            the ipCreacion to set
	 */
	public void setIpCreacion(String ipCreacion) {
		this.ipCreacion = ipCreacion;
	}

	/**
	 * Método getter del atributo fechaCreacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the fechaCreacion
	 */
	public String getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Método setter del atributo fechaCreacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @param fechaCreacion
	 *            the fechaCreacion to set
	 */
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Método getter del atributo usuarioCreacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the usuarioCreacion
	 */
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	/**
	 * Método setter del atributo usuarioCreacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @param usuarioCreacion
	 *            the usuarioCreacion to set
	 */
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	/**
	 * Método getter del atributo causaFinVigencia de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the causaFinVigencia
	 */
	public String getCausaFinVigencia() {
		return causaFinVigencia;
	}

	/**
	 * Método setter del atributo causaFinVigencia de la clase ObligatoriedadAportanteDTO
	 *
	 * @param causaFinVigencia
	 *            the causaFinVigencia to set
	 */
	public void setCausaFinVigencia(String causaFinVigencia) {
		this.causaFinVigencia = causaFinVigencia;
	}

	/**
	 * Método getter del atributo fechaFinVigencia de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the fechaFinVigencia
	 */
	public String getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	/**
	 * Método setter del atributo fechaFinVigencia de la clase ObligatoriedadAportanteDTO
	 *
	 * @param fechaFinVigencia
	 *            the fechaFinVigencia to set
	 */
	public void setFechaFinVigencia(String fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	/**
	 * Método getter del atributo fechaInicioVigencia de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the fechaInicioVigencia
	 */
	public String getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	/**
	 * Método setter del atributo fechaInicioVigencia de la clase ObligatoriedadAportanteDTO
	 *
	 * @param fechaInicioVigencia
	 *            the fechaInicioVigencia to set
	 */
	public void setFechaInicioVigencia(String fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	/**
	 * Método getter del atributo vigente de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the vigente
	 */
	public Integer getVigente() {
		return vigente;
	}

	/**
	 * Método setter del atributo vigente de la clase ObligatoriedadAportanteDTO
	 *
	 * @param vigente
	 *            the vigente to set
	 */
	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}

	/**
	 * Método getter del atributo tpObligatoriedad de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the tpObligatoriedad
	 */
	public String getTpObligatoriedad() {
		return tpObligatoriedad;
	}

	/**
	 * Método setter del atributo tpObligatoriedad de la clase ObligatoriedadAportanteDTO
	 *
	 * @param tpObligatoriedad
	 *            the tpObligatoriedad to set
	 */
	public void setTpObligatoriedad(String tpObligatoriedad) {
		this.tpObligatoriedad = tpObligatoriedad;
	}

	/**
	 * Método getter del atributo idSoiSubsistema de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the idSoiSubsistema
	 */
	public Integer getIdSoiSubsistema() {
		return idSoiSubsistema;
	}

	/**
	 * Método setter del atributo idSoiSubsistema de la clase ObligatoriedadAportanteDTO
	 *
	 * @param idSoiSubsistema
	 *            the idSoiSubsistema to set
	 */
	public void setIdSoiSubsistema(Integer idSoiSubsistema) {
		this.idSoiSubsistema = idSoiSubsistema;
	}

	/**
	 * Método getter del atributo idSoiAportante de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the idSoiAportante
	 */
	public Long getIdSoiAportante() {
		return idSoiAportante;
	}

	/**
	 * Método setter del atributo idSoiAportante de la clase ObligatoriedadAportanteDTO
	 *
	 * @param idSoiAportante
	 *            the idSoiAportante to set
	 */
	public void setIdSoiAportante(Long idSoiAportante) {
		this.idSoiAportante = idSoiAportante;
	}

	/**
	 * Método getter del atributo idSoiOblgAportante de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the idSoiOblgAportante
	 */
	public Long getIdSoiOblgAportante() {
		return idSoiOblgAportante;
	}

	/**
	 * Método setter del atributo idSoiOblgAportante de la clase ObligatoriedadAportanteDTO
	 *
	 * @param idSoiOblgAportante
	 *            the idSoiOblgAportante to set
	 */
	public void setIdSoiOblgAportante(Long idSoiOblgAportante) {
		this.idSoiOblgAportante = idSoiOblgAportante;
	}

	/**
	 * Método getter del atributo ipModificacion1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the ipModificacion1
	 */
	public String getIpModificacion1() {
		return ipModificacion1;
	}

	/**
	 * Método setter del atributo ipModificacion1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param ipModificacion1
	 *            the ipModificacion1 to set
	 */
	public void setIpModificacion1(String ipModificacion1) {
		this.ipModificacion1 = ipModificacion1;
	}

	/**
	 * Método getter del atributo fechaModificacion1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the fechaModificacion1
	 */
	public String getFechaModificacion1() {
		return fechaModificacion1;
	}

	/**
	 * Método setter del atributo fechaModificacion1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param fechaModificacion1
	 *            the fechaModificacion1 to set
	 */
	public void setFechaModificacion1(String fechaModificacion1) {
		this.fechaModificacion1 = fechaModificacion1;
	}

	/**
	 * Método getter del atributo usuarioModificacion1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the usuarioModificacion1
	 */
	public String getUsuarioModificacion1() {
		return usuarioModificacion1;
	}

	/**
	 * Método setter del atributo usuarioModificacion1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param usuarioModificacion1
	 *            the usuarioModificacion1 to set
	 */
	public void setUsuarioModificacion1(String usuarioModificacion1) {
		this.usuarioModificacion1 = usuarioModificacion1;
	}

	/**
	 * Método getter del atributo ipCreacion1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the ipCreacion1
	 */
	public String getIpCreacion1() {
		return ipCreacion1;
	}

	/**
	 * Método setter del atributo ipCreacion1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param ipCreacion1
	 *            the ipCreacion1 to set
	 */
	public void setIpCreacion1(String ipCreacion1) {
		this.ipCreacion1 = ipCreacion1;
	}

	/**
	 * Método getter del atributo fechaCreacion1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the fechaCreacion1
	 */
	public String getFechaCreacion1() {
		return fechaCreacion1;
	}

	/**
	 * Método setter del atributo fechaCreacion1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param fechaCreacion1
	 *            the fechaCreacion1 to set
	 */
	public void setFechaCreacion1(String fechaCreacion1) {
		this.fechaCreacion1 = fechaCreacion1;
	}

	/**
	 * Método getter del atributo usuarioCreacion1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the usuarioCreacion1
	 */
	public String getUsuarioCreacion1() {
		return usuarioCreacion1;
	}

	/**
	 * Método setter del atributo usuarioCreacion1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param usuarioCreacion1
	 *            the usuarioCreacion1 to set
	 */
	public void setUsuarioCreacion1(String usuarioCreacion1) {
		this.usuarioCreacion1 = usuarioCreacion1;
	}

	/**
	 * Método getter del atributo causaFinVigencia1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the causaFinVigencia1
	 */
	public String getCausaFinVigencia1() {
		return causaFinVigencia1;
	}

	/**
	 * Método setter del atributo causaFinVigencia1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param causaFinVigencia1
	 *            the causaFinVigencia1 to set
	 */
	public void setCausaFinVigencia1(String causaFinVigencia1) {
		this.causaFinVigencia1 = causaFinVigencia1;
	}

	/**
	 * Método getter del atributo fechaFinVigencia1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the fechaFinVigencia1
	 */
	public String getFechaFinVigencia1() {
		return fechaFinVigencia1;
	}

	/**
	 * Método setter del atributo fechaFinVigencia1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param fechaFinVigencia1
	 *            the fechaFinVigencia1 to set
	 */
	public void setFechaFinVigencia1(String fechaFinVigencia1) {
		this.fechaFinVigencia1 = fechaFinVigencia1;
	}

	/**
	 * Método getter del atributo fechaInicioVigencia1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the fechaInicioVigencia1
	 */
	public String getFechaInicioVigencia1() {
		return fechaInicioVigencia1;
	}

	/**
	 * Método setter del atributo fechaInicioVigencia1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param fechaInicioVigencia1
	 *            the fechaInicioVigencia1 to set
	 */
	public void setFechaInicioVigencia1(String fechaInicioVigencia1) {
		this.fechaInicioVigencia1 = fechaInicioVigencia1;
	}

	/**
	 * Método getter del atributo vigente1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the vigente1
	 */
	public Integer getVigente1() {
		return vigente1;
	}

	/**
	 * Método setter del atributo vigente1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param vigente1
	 *            the vigente1 to set
	 */
	public void setVigente1(Integer vigente1) {
		this.vigente1 = vigente1;
	}

	/**
	 * Método getter del atributo nombreMostrar de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the nombreMostrar
	 */
	public String getNombreMostrar() {
		return nombreMostrar;
	}

	/**
	 * Método setter del atributo nombreMostrar de la clase ObligatoriedadAportanteDTO
	 *
	 * @param nombreMostrar
	 *            the nombreMostrar to set
	 */
	public void setNombreMostrar(String nombreMostrar) {
		this.nombreMostrar = nombreMostrar;
	}

	/**
	 * Método getter del atributo nombre de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre de la clase ObligatoriedadAportanteDTO
	 *
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter del atributo codigo de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Método setter del atributo codigo de la clase ObligatoriedadAportanteDTO
	 *
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Método getter del atributo idSoiSubsistema1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the idSoiSubsistema1
	 */
	public Integer getIdSoiSubsistema1() {
		return idSoiSubsistema1;
	}

	/**
	 * Método setter del atributo idSoiSubsistema1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param idSoiSubsistema1
	 *            the idSoiSubsistema1 to set
	 */
	public void setIdSoiSubsistema1(Integer idSoiSubsistema1) {
		this.idSoiSubsistema1 = idSoiSubsistema1;
	}

	/**
	 * Método getter del atributo ctaEntidadFinanciera de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the ctaEntidadFinanciera
	 */
	public Integer getCtaEntidadFinanciera() {
		return ctaEntidadFinanciera;
	}

	/**
	 * Método setter del atributo ctaEntidadFinanciera de la clase ObligatoriedadAportanteDTO
	 *
	 * @param ctaEntidadFinanciera
	 *            the ctaEntidadFinanciera to set
	 */
	public void setCtaEntidadFinanciera(Integer ctaEntidadFinanciera) {
		this.ctaEntidadFinanciera = ctaEntidadFinanciera;
	}

	/**
	 * Método getter del atributo celular de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * Método setter del atributo celular de la clase ObligatoriedadAportanteDTO
	 *
	 * @param celular
	 *            the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * Método getter del atributo correo de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Método setter del atributo correo de la clase ObligatoriedadAportanteDTO
	 *
	 * @param correo
	 *            the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Método getter del atributo infoViaCelular de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the infoViaCelular
	 */
	public Integer getInfoViaCelular() {
		return infoViaCelular;
	}

	/**
	 * Método setter del atributo infoViaCelular de la clase ObligatoriedadAportanteDTO
	 *
	 * @param infoViaCelular
	 *            the infoViaCelular to set
	 */
	public void setInfoViaCelular(Integer infoViaCelular) {
		this.infoViaCelular = infoViaCelular;
	}

	/**
	 * Método getter del atributo infoViaCorreo de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the infoViaCorreo
	 */
	public Integer getInfoViaCorreo() {
		return infoViaCorreo;
	}

	/**
	 * Método setter del atributo infoViaCorreo de la clase ObligatoriedadAportanteDTO
	 *
	 * @param infoViaCorreo
	 *            the infoViaCorreo to set
	 */
	public void setInfoViaCorreo(Integer infoViaCorreo) {
		this.infoViaCorreo = infoViaCorreo;
	}

	/**
	 * Método getter del atributo ipModificacion2 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the ipModificacion2
	 */
	public String getIpModificacion2() {
		return ipModificacion2;
	}

	/**
	 * Método setter del atributo ipModificacion2 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param ipModificacion2
	 *            the ipModificacion2 to set
	 */
	public void setIpModificacion2(String ipModificacion2) {
		this.ipModificacion2 = ipModificacion2;
	}

	/**
	 * Método getter del atributo fechaModificacion2 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the fechaModificacion2
	 */
	public String getFechaModificacion2() {
		return fechaModificacion2;
	}

	/**
	 * Método setter del atributo fechaModificacion2 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param fechaModificacion2
	 *            the fechaModificacion2 to set
	 */
	public void setFechaModificacion2(String fechaModificacion2) {
		this.fechaModificacion2 = fechaModificacion2;
	}

	/**
	 * Método getter del atributo usuarioModificacion2 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the usuarioModificacion2
	 */
	public String getUsuarioModificacion2() {
		return usuarioModificacion2;
	}

	/**
	 * Método setter del atributo usuarioModificacion2 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param usuarioModificacion2
	 *            the usuarioModificacion2 to set
	 */
	public void setUsuarioModificacion2(String usuarioModificacion2) {
		this.usuarioModificacion2 = usuarioModificacion2;
	}

	/**
	 * Método getter del atributo ipCreacion2 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the ipCreacion2
	 */
	public String getIpCreacion2() {
		return ipCreacion2;
	}

	/**
	 * Método setter del atributo ipCreacion2 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param ipCreacion2
	 *            the ipCreacion2 to set
	 */
	public void setIpCreacion2(String ipCreacion2) {
		this.ipCreacion2 = ipCreacion2;
	}

	/**
	 * Método getter del atributo fechaCreacion2 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the fechaCreacion2
	 */
	public String getFechaCreacion2() {
		return fechaCreacion2;
	}

	/**
	 * Método setter del atributo fechaCreacion2 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param fechaCreacion2
	 *            the fechaCreacion2 to set
	 */
	public void setFechaCreacion2(String fechaCreacion2) {
		this.fechaCreacion2 = fechaCreacion2;
	}

	/**
	 * Método getter del atributo usuarioCreacion2 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the usuarioCreacion2
	 */
	public String getUsuarioCreacion2() {
		return usuarioCreacion2;
	}

	/**
	 * Método setter del atributo usuarioCreacion2 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param usuarioCreacion2
	 *            the usuarioCreacion2 to set
	 */
	public void setUsuarioCreacion2(String usuarioCreacion2) {
		this.usuarioCreacion2 = usuarioCreacion2;
	}

	/**
	 * Método getter del atributo apellido de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Método setter del atributo apellido de la clase ObligatoriedadAportanteDTO
	 *
	 * @param apellido
	 *            the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Método getter del atributo causaFinVigencia2 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the causaFinVigencia2
	 */
	public String getCausaFinVigencia2() {
		return causaFinVigencia2;
	}

	/**
	 * Método setter del atributo causaFinVigencia2 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param causaFinVigencia2
	 *            the causaFinVigencia2 to set
	 */
	public void setCausaFinVigencia2(String causaFinVigencia2) {
		this.causaFinVigencia2 = causaFinVigencia2;
	}

	/**
	 * Método getter del atributo fechaFinVigencia2 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the fechaFinVigencia2
	 */
	public String getFechaFinVigencia2() {
		return fechaFinVigencia2;
	}

	/**
	 * Método setter del atributo fechaFinVigencia2 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param fechaFinVigencia2
	 *            the fechaFinVigencia2 to set
	 */
	public void setFechaFinVigencia2(String fechaFinVigencia2) {
		this.fechaFinVigencia2 = fechaFinVigencia2;
	}

	/**
	 * Método getter del atributo vigente2 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the vigente2
	 */
	public Integer getVigente2() {
		return vigente2;
	}

	/**
	 * Método setter del atributo vigente2 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param vigente2
	 *            the vigente2 to set
	 */
	public void setVigente2(Integer vigente2) {
		this.vigente2 = vigente2;
	}

	/**
	 * Método getter del atributo fechaInicioVigencia2 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the fechaInicioVigencia2
	 */
	public String getFechaInicioVigencia2() {
		return fechaInicioVigencia2;
	}

	/**
	 * Método setter del atributo fechaInicioVigencia2 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param fechaInicioVigencia2
	 *            the fechaInicioVigencia2 to set
	 */
	public void setFechaInicioVigencia2(String fechaInicioVigencia2) {
		this.fechaInicioVigencia2 = fechaInicioVigencia2;
	}

	/**
	 * Método getter del atributo idArp de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the idArp
	 */
	public Integer getIdArp() {
		return idArp;
	}

	/**
	 * Método setter del atributo idArp de la clase ObligatoriedadAportanteDTO
	 *
	 * @param idArp
	 *            the idArp to set
	 */
	public void setIdArp(Integer idArp) {
		this.idArp = idArp;
	}

	/**
	 * Método getter del atributo idCcf de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the idCcf
	 */
	public Integer getIdCcf() {
		return idCcf;
	}

	/**
	 * Método setter del atributo idCcf de la clase ObligatoriedadAportanteDTO
	 *
	 * @param idCcf
	 *            the idCcf to set
	 */
	public void setIdCcf(Integer idCcf) {
		this.idCcf = idCcf;
	}

	/**
	 * Método getter del atributo aporteEsapMinedu de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the aporteEsapMinedu
	 */
	public Integer getAporteEsapMinedu() {
		return aporteEsapMinedu;
	}

	/**
	 * Método setter del atributo aporteEsapMinedu de la clase ObligatoriedadAportanteDTO
	 *
	 * @param aporteEsapMinedu
	 *            the aporteEsapMinedu to set
	 */
	public void setAporteEsapMinedu(Integer aporteEsapMinedu) {
		this.aporteEsapMinedu = aporteEsapMinedu;
	}

	/**
	 * Método getter del atributo codTpPersonaFinanciera de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the codTpPersonaFinanciera
	 */
	public String getCodTpPersonaFinanciera() {
		return codTpPersonaFinanciera;
	}

	/**
	 * Método setter del atributo codTpPersonaFinanciera de la clase ObligatoriedadAportanteDTO
	 *
	 * @param codTpPersonaFinanciera
	 *            the codTpPersonaFinanciera to set
	 */
	public void setCodTpPersonaFinanciera(String codTpPersonaFinanciera) {
		this.codTpPersonaFinanciera = codTpPersonaFinanciera;
	}

	/**
	 * Método getter del atributo idSoiTpPagadorPension de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the idSoiTpPagadorPension
	 */
	public Integer getIdSoiTpPagadorPension() {
		return idSoiTpPagadorPension;
	}

	/**
	 * Método setter del atributo idSoiTpPagadorPension de la clase ObligatoriedadAportanteDTO
	 *
	 * @param idSoiTpPagadorPension
	 *            the idSoiTpPagadorPension to set
	 */
	public void setIdSoiTpPagadorPension(Integer idSoiTpPagadorPension) {
		this.idSoiTpPagadorPension = idSoiTpPagadorPension;
	}

	/**
	 * Método getter del atributo fechaFinAccion de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the fechaFinAccion
	 */
	public String getFechaFinAccion() {
		return fechaFinAccion;
	}

	/**
	 * Método setter del atributo fechaFinAccion de la clase ObligatoriedadAportanteDTO
	 *
	 * @param fechaFinAccion
	 *            the fechaFinAccion to set
	 */
	public void setFechaFinAccion(String fechaFinAccion) {
		this.fechaFinAccion = fechaFinAccion;
	}

	/**
	 * Método getter del atributo fechaInicioAccion de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the fechaInicioAccion
	 */
	public String getFechaInicioAccion() {
		return fechaInicioAccion;
	}

	/**
	 * Método setter del atributo fechaInicioAccion de la clase ObligatoriedadAportanteDTO
	 *
	 * @param fechaInicioAccion
	 *            the fechaInicioAccion to set
	 */
	public void setFechaInicioAccion(String fechaInicioAccion) {
		this.fechaInicioAccion = fechaInicioAccion;
	}

	/**
	 * Método getter del atributo idSoiTpAccion de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the idSoiTpAccion
	 */
	public Integer getIdSoiTpAccion() {
		return idSoiTpAccion;
	}

	/**
	 * Método setter del atributo idSoiTpAccion de la clase ObligatoriedadAportanteDTO
	 *
	 * @param idSoiTpAccion
	 *            the idSoiTpAccion to set
	 */
	public void setIdSoiTpAccion(Integer idSoiTpAccion) {
		this.idSoiTpAccion = idSoiTpAccion;
	}

	/**
	 * Método getter del atributo rlSegundoApellido de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the rlSegundoApellido
	 */
	public String getRlSegundoApellido() {
		return rlSegundoApellido;
	}

	/**
	 * Método setter del atributo rlSegundoApellido de la clase ObligatoriedadAportanteDTO
	 *
	 * @param rlSegundoApellido
	 *            the rlSegundoApellido to set
	 */
	public void setRlSegundoApellido(String rlSegundoApellido) {
		this.rlSegundoApellido = rlSegundoApellido;
	}

	/**
	 * Método getter del atributo rlPrimerApellido de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the rlPrimerApellido
	 */
	public String getRlPrimerApellido() {
		return rlPrimerApellido;
	}

	/**
	 * Método setter del atributo rlPrimerApellido de la clase ObligatoriedadAportanteDTO
	 *
	 * @param rlPrimerApellido
	 *            the rlPrimerApellido to set
	 */
	public void setRlPrimerApellido(String rlPrimerApellido) {
		this.rlPrimerApellido = rlPrimerApellido;
	}

	/**
	 * Método getter del atributo rlSegundoNombre de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the rlSegundoNombre
	 */
	public String getRlSegundoNombre() {
		return rlSegundoNombre;
	}

	/**
	 * Método setter del atributo rlSegundoNombre de la clase ObligatoriedadAportanteDTO
	 *
	 * @param rlSegundoNombre
	 *            the rlSegundoNombre to set
	 */
	public void setRlSegundoNombre(String rlSegundoNombre) {
		this.rlSegundoNombre = rlSegundoNombre;
	}

	/**
	 * Método getter del atributo rlPrimerNombre de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the rlPrimerNombre
	 */
	public String getRlPrimerNombre() {
		return rlPrimerNombre;
	}

	/**
	 * Método setter del atributo rlPrimerNombre de la clase ObligatoriedadAportanteDTO
	 *
	 * @param rlPrimerNombre
	 *            the rlPrimerNombre to set
	 */
	public void setRlPrimerNombre(String rlPrimerNombre) {
		this.rlPrimerNombre = rlPrimerNombre;
	}

	/**
	 * Método getter del atributo rlNumeroIdentificacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the rlNumeroIdentificacion
	 */
	public String getRlNumeroIdentificacion() {
		return rlNumeroIdentificacion;
	}

	/**
	 * Método setter del atributo rlNumeroIdentificacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @param rlNumeroIdentificacion
	 *            the rlNumeroIdentificacion to set
	 */
	public void setRlNumeroIdentificacion(String rlNumeroIdentificacion) {
		this.rlNumeroIdentificacion = rlNumeroIdentificacion;
	}

	/**
	 * Método getter del atributo rlIdTpIdentificacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the rlIdTpIdentificacion
	 */
	public Integer getRlIdTpIdentificacion() {
		return rlIdTpIdentificacion;
	}

	/**
	 * Método setter del atributo rlIdTpIdentificacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @param rlIdTpIdentificacion
	 *            the rlIdTpIdentificacion to set
	 */
	public void setRlIdTpIdentificacion(Integer rlIdTpIdentificacion) {
		this.rlIdTpIdentificacion = rlIdTpIdentificacion;
	}

	/**
	 * Método getter del atributo fax de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * Método setter del atributo fax de la clase ObligatoriedadAportanteDTO
	 *
	 * @param fax
	 *            the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * Método getter del atributo extension de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * Método setter del atributo extension de la clase ObligatoriedadAportanteDTO
	 *
	 * @param extension
	 *            the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * Método getter del atributo telefono de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Método setter del atributo telefono de la clase ObligatoriedadAportanteDTO
	 *
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Método getter del atributo idSoiActividadEcon de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the idSoiActividadEcon
	 */
	public Integer getIdSoiActividadEcon() {
		return idSoiActividadEcon;
	}

	/**
	 * Método setter del atributo idSoiActividadEcon de la clase ObligatoriedadAportanteDTO
	 *
	 * @param idSoiActividadEcon
	 *            the idSoiActividadEcon to set
	 */
	public void setIdSoiActividadEcon(Integer idSoiActividadEcon) {
		this.idSoiActividadEcon = idSoiActividadEcon;
	}

	/**
	 * Método getter del atributo idSoiMunicipio de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the idSoiMunicipio
	 */
	public Long getIdSoiMunicipio() {
		return idSoiMunicipio;
	}

	/**
	 * Método setter del atributo idSoiMunicipio de la clase ObligatoriedadAportanteDTO
	 *
	 * @param idSoiMunicipio
	 *            the idSoiMunicipio to set
	 */
	public void setIdSoiMunicipio(Long idSoiMunicipio) {
		this.idSoiMunicipio = idSoiMunicipio;
	}

	/**
	 * Método getter del atributo direccion de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Método setter del atributo direccion de la clase ObligatoriedadAportanteDTO
	 *
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Método getter del atributo idSoiFormaPresentacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the idSoiFormaPresentacion
	 */
	public Integer getIdSoiFormaPresentacion() {
		return idSoiFormaPresentacion;
	}

	/**
	 * Método setter del atributo idSoiFormaPresentacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @param idSoiFormaPresentacion
	 *            the idSoiFormaPresentacion to set
	 */
	public void setIdSoiFormaPresentacion(Integer idSoiFormaPresentacion) {
		this.idSoiFormaPresentacion = idSoiFormaPresentacion;
	}

	/**
	 * Método getter del atributo codTpPersona de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the codTpPersona
	 */
	public String getCodTpPersona() {
		return codTpPersona;
	}

	/**
	 * Método setter del atributo codTpPersona de la clase ObligatoriedadAportanteDTO
	 *
	 * @param codTpPersona
	 *            the codTpPersona to set
	 */
	public void setCodTpPersona(String codTpPersona) {
		this.codTpPersona = codTpPersona;
	}

	/**
	 * Método getter del atributo idSoiTpEmpresa de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the idSoiTpEmpresa
	 */
	public Integer getIdSoiTpEmpresa() {
		return idSoiTpEmpresa;
	}

	/**
	 * Método setter del atributo idSoiTpEmpresa de la clase ObligatoriedadAportanteDTO
	 *
	 * @param idSoiTpEmpresa
	 *            the idSoiTpEmpresa to set
	 */
	public void setIdSoiTpEmpresa(Integer idSoiTpEmpresa) {
		this.idSoiTpEmpresa = idSoiTpEmpresa;
	}

	/**
	 * Método getter del atributo idSoiTpAportante de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the idSoiTpAportante
	 */
	public Integer getIdSoiTpAportante() {
		return idSoiTpAportante;
	}

	/**
	 * Método setter del atributo idSoiTpAportante de la clase ObligatoriedadAportanteDTO
	 *
	 * @param idSoiTpAportante
	 *            the idSoiTpAportante to set
	 */
	public void setIdSoiTpAportante(Integer idSoiTpAportante) {
		this.idSoiTpAportante = idSoiTpAportante;
	}

	/**
	 * Método getter del atributo idSoiClaseAportante de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the idSoiClaseAportante
	 */
	public Integer getIdSoiClaseAportante() {
		return idSoiClaseAportante;
	}

	/**
	 * Método setter del atributo idSoiClaseAportante de la clase ObligatoriedadAportanteDTO
	 *
	 * @param idSoiClaseAportante
	 *            the idSoiClaseAportante to set
	 */
	public void setIdSoiClaseAportante(Integer idSoiClaseAportante) {
		this.idSoiClaseAportante = idSoiClaseAportante;
	}

	/**
	 * Método getter del atributo digitoVerificacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the digitoVerificacion
	 */
	public String getDigitoVerificacion() {
		return digitoVerificacion;
	}

	/**
	 * Método setter del atributo digitoVerificacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @param digitoVerificacion
	 *            the digitoVerificacion to set
	 */
	public void setDigitoVerificacion(String digitoVerificacion) {
		this.digitoVerificacion = digitoVerificacion;
	}

	/**
	 * Método getter del atributo numeroIdentificacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the numeroIdentificacion
	 */
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	/**
	 * Método setter del atributo numeroIdentificacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @param numeroIdentificacion
	 *            the numeroIdentificacion to set
	 */
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	/**
	 * Método getter del atributo idSoiTpIdentificacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the idSoiTpIdentificacion
	 */
	public Integer getIdSoiTpIdentificacion() {
		return idSoiTpIdentificacion;
	}

	/**
	 * Método setter del atributo idSoiTpIdentificacion de la clase ObligatoriedadAportanteDTO
	 *
	 * @param idSoiTpIdentificacion
	 *            the idSoiTpIdentificacion to set
	 */
	public void setIdSoiTpIdentificacion(Integer idSoiTpIdentificacion) {
		this.idSoiTpIdentificacion = idSoiTpIdentificacion;
	}

	/**
	 * Método getter del atributo nombre1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the nombre1
	 */
	public String getNombre1() {
		return nombre1;
	}

	/**
	 * Método setter del atributo nombre1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param nombre1
	 *            the nombre1 to set
	 */
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	/**
	 * Método getter del atributo idSoiAportante1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @return the idSoiAportante1
	 */
	public Long getIdSoiAportante1() {
		return idSoiAportante1;
	}

	/**
	 * Método setter del atributo idSoiAportante1 de la clase ObligatoriedadAportanteDTO
	 *
	 * @param idSoiAportante1
	 *            the idSoiAportante1 to set
	 */
	public void setIdSoiAportante1(Long idSoiAportante1) {
		this.idSoiAportante1 = idSoiAportante1;
	}

}

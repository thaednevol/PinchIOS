/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;

/**
 * 
 * Objeto de transporte resultado de la conversión de objetos de tipo
 * {@link com.ach.seg.biz.transfer.InformacionAportantePlanillaDTO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class InformacionAportantePlanillaDTO implements Serializable {

	/**
	 * Constante de Serialización
	 */
	private static final long serialVersionUID = 1L;
	private Long idSoiAportante;
	private Integer vigente;
	private Integer idSoiTpIdentificacion;
	private String numeroIdentificacion;
	private String digitoVerificacion;
	private String nombre;
	private String codSoiTpIdentificacion;
	private String nombreTpIdentificacion;
	private Integer idSoiTpAportante;
	private String codigoTpAportante;
	private String nombreTpAportante;
	private Integer idSoiTpEmpresa;
	private String codigoTpEmpresa;
	private String nombreTpEmpresa;
	private Integer idSoiClaseAportante;
	private String codigoClaseAportante;
	private String nombreClaseAportante;
	private Integer idSoiFormaPresentacion;
	private String codigoFormaPresentacion;
	private String nombreFormaPresentacion;
	private Integer idSoiAdministradoraARP;
	private String nombreARP;
	private String codAdministradoraARP;
	private Integer idSoiAdministradoraCCF;
	private String nombreCCF;
	private String codAdministradoraCCF;
	private Integer minimoCotizanteClaseAportante;
	private Integer maximoCotizanteClaseAportante;
	private String correoAportante;
	private String codigoOperador;
	private Integer idSoiOperador;
	private String tipoPersonaEntidadFinanciera;
	private Integer idSoiTpPagadorPension;
	private String nombreTipoPagadoPension;
	private String nombreUsuarioAdministrador;
	private String apellidoUsuarioAdministrador;
	private String nombreCompletoUsuarioAdmin;
	private String codDepartamentoAportante;
	private String codMunicipioAportante;
	private String direccionAportante;
	private String telefonoAportante;
	private String faxAportante;
	private Integer aportanteMigrado;
	private Integer apteMigradoActDatos;
	private String fechaRegistroMercantil;

	/**
	 * Método getter del atributo idSoiAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the idSoiAportante
	 */
	public Long getIdSoiAportante() {
		return idSoiAportante;
	}

	/**
	 * Método setter del atributo idSoiAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @param idSoiAportante
	 *            the idSoiAportante to set
	 */
	public void setIdSoiAportante(Long idSoiAportante) {
		this.idSoiAportante = idSoiAportante;
	}

	/**
	 * Método getter del atributo vigente de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the vigente
	 */
	public Integer getVigente() {
		return vigente;
	}

	/**
	 * Método setter del atributo vigente de la clase InformacionAportantePlanillaDTO
	 *
	 * @param vigente
	 *            the vigente to set
	 */
	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}

	/**
	 * Método getter del atributo idSoiTpIdentificacion de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the idSoiTpIdentificacion
	 */
	public Integer getIdSoiTpIdentificacion() {
		return idSoiTpIdentificacion;
	}

	/**
	 * Método setter del atributo idSoiTpIdentificacion de la clase InformacionAportantePlanillaDTO
	 *
	 * @param idSoiTpIdentificacion
	 *            the idSoiTpIdentificacion to set
	 */
	public void setIdSoiTpIdentificacion(Integer idSoiTpIdentificacion) {
		this.idSoiTpIdentificacion = idSoiTpIdentificacion;
	}

	/**
	 * Método getter del atributo numeroIdentificacion de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the numeroIdentificacion
	 */
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	/**
	 * Método setter del atributo numeroIdentificacion de la clase InformacionAportantePlanillaDTO
	 *
	 * @param numeroIdentificacion
	 *            the numeroIdentificacion to set
	 */
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	/**
	 * Método getter del atributo digitoVerificacion de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the digitoVerificacion
	 */
	public String getDigitoVerificacion() {
		return digitoVerificacion;
	}

	/**
	 * Método setter del atributo digitoVerificacion de la clase InformacionAportantePlanillaDTO
	 *
	 * @param digitoVerificacion
	 *            the digitoVerificacion to set
	 */
	public void setDigitoVerificacion(String digitoVerificacion) {
		this.digitoVerificacion = digitoVerificacion;
	}

	/**
	 * Método getter del atributo nombre de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre de la clase InformacionAportantePlanillaDTO
	 *
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter del atributo codSoiTpIdentificacion de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the codSoiTpIdentificacion
	 */
	public String getCodSoiTpIdentificacion() {
		return codSoiTpIdentificacion;
	}

	/**
	 * Método setter del atributo codSoiTpIdentificacion de la clase InformacionAportantePlanillaDTO
	 *
	 * @param codSoiTpIdentificacion
	 *            the codSoiTpIdentificacion to set
	 */
	public void setCodSoiTpIdentificacion(String codSoiTpIdentificacion) {
		this.codSoiTpIdentificacion = codSoiTpIdentificacion;
	}

	/**
	 * Método getter del atributo nombreTpIdentificacion de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the nombreTpIdentificacion
	 */
	public String getNombreTpIdentificacion() {
		return nombreTpIdentificacion;
	}

	/**
	 * Método setter del atributo nombreTpIdentificacion de la clase InformacionAportantePlanillaDTO
	 *
	 * @param nombreTpIdentificacion
	 *            the nombreTpIdentificacion to set
	 */
	public void setNombreTpIdentificacion(String nombreTpIdentificacion) {
		this.nombreTpIdentificacion = nombreTpIdentificacion;
	}

	/**
	 * Método getter del atributo idSoiTpAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the idSoiTpAportante
	 */
	public Integer getIdSoiTpAportante() {
		return idSoiTpAportante;
	}

	/**
	 * Método setter del atributo idSoiTpAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @param idSoiTpAportante
	 *            the idSoiTpAportante to set
	 */
	public void setIdSoiTpAportante(Integer idSoiTpAportante) {
		this.idSoiTpAportante = idSoiTpAportante;
	}

	/**
	 * Método getter del atributo codigoTpAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the codigoTpAportante
	 */
	public String getCodigoTpAportante() {
		return codigoTpAportante;
	}

	/**
	 * Método setter del atributo codigoTpAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @param codigoTpAportante
	 *            the codigoTpAportante to set
	 */
	public void setCodigoTpAportante(String codigoTpAportante) {
		this.codigoTpAportante = codigoTpAportante;
	}

	/**
	 * Método getter del atributo nombreTpAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the nombreTpAportante
	 */
	public String getNombreTpAportante() {
		return nombreTpAportante;
	}

	/**
	 * Método setter del atributo nombreTpAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @param nombreTpAportante
	 *            the nombreTpAportante to set
	 */
	public void setNombreTpAportante(String nombreTpAportante) {
		this.nombreTpAportante = nombreTpAportante;
	}

	/**
	 * Método getter del atributo idSoiTpEmpresa de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the idSoiTpEmpresa
	 */
	public Integer getIdSoiTpEmpresa() {
		return idSoiTpEmpresa;
	}

	/**
	 * Método setter del atributo idSoiTpEmpresa de la clase InformacionAportantePlanillaDTO
	 *
	 * @param idSoiTpEmpresa
	 *            the idSoiTpEmpresa to set
	 */
	public void setIdSoiTpEmpresa(Integer idSoiTpEmpresa) {
		this.idSoiTpEmpresa = idSoiTpEmpresa;
	}

	/**
	 * Método getter del atributo codigoTpEmpresa de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the codigoTpEmpresa
	 */
	public String getCodigoTpEmpresa() {
		return codigoTpEmpresa;
	}

	/**
	 * Método setter del atributo codigoTpEmpresa de la clase InformacionAportantePlanillaDTO
	 *
	 * @param codigoTpEmpresa
	 *            the codigoTpEmpresa to set
	 */
	public void setCodigoTpEmpresa(String codigoTpEmpresa) {
		this.codigoTpEmpresa = codigoTpEmpresa;
	}

	/**
	 * Método getter del atributo nombreTpEmpresa de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the nombreTpEmpresa
	 */
	public String getNombreTpEmpresa() {
		return nombreTpEmpresa;
	}

	/**
	 * Método setter del atributo nombreTpEmpresa de la clase InformacionAportantePlanillaDTO
	 *
	 * @param nombreTpEmpresa
	 *            the nombreTpEmpresa to set
	 */
	public void setNombreTpEmpresa(String nombreTpEmpresa) {
		this.nombreTpEmpresa = nombreTpEmpresa;
	}

	/**
	 * Método getter del atributo idSoiClaseAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the idSoiClaseAportante
	 */
	public Integer getIdSoiClaseAportante() {
		return idSoiClaseAportante;
	}

	/**
	 * Método setter del atributo idSoiClaseAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @param idSoiClaseAportante
	 *            the idSoiClaseAportante to set
	 */
	public void setIdSoiClaseAportante(Integer idSoiClaseAportante) {
		this.idSoiClaseAportante = idSoiClaseAportante;
	}

	/**
	 * Método getter del atributo codigoClaseAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the codigoClaseAportante
	 */
	public String getCodigoClaseAportante() {
		return codigoClaseAportante;
	}

	/**
	 * Método setter del atributo codigoClaseAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @param codigoClaseAportante
	 *            the codigoClaseAportante to set
	 */
	public void setCodigoClaseAportante(String codigoClaseAportante) {
		this.codigoClaseAportante = codigoClaseAportante;
	}

	/**
	 * Método getter del atributo nombreClaseAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the nombreClaseAportante
	 */
	public String getNombreClaseAportante() {
		return nombreClaseAportante;
	}

	/**
	 * Método setter del atributo nombreClaseAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @param nombreClaseAportante
	 *            the nombreClaseAportante to set
	 */
	public void setNombreClaseAportante(String nombreClaseAportante) {
		this.nombreClaseAportante = nombreClaseAportante;
	}

	/**
	 * Método getter del atributo idSoiFormaPresentacion de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the idSoiFormaPresentacion
	 */
	public Integer getIdSoiFormaPresentacion() {
		return idSoiFormaPresentacion;
	}

	/**
	 * Método setter del atributo idSoiFormaPresentacion de la clase InformacionAportantePlanillaDTO
	 *
	 * @param idSoiFormaPresentacion
	 *            the idSoiFormaPresentacion to set
	 */
	public void setIdSoiFormaPresentacion(Integer idSoiFormaPresentacion) {
		this.idSoiFormaPresentacion = idSoiFormaPresentacion;
	}

	/**
	 * Método getter del atributo codigoFormaPresentacion de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the codigoFormaPresentacion
	 */
	public String getCodigoFormaPresentacion() {
		return codigoFormaPresentacion;
	}

	/**
	 * Método setter del atributo codigoFormaPresentacion de la clase InformacionAportantePlanillaDTO
	 *
	 * @param codigoFormaPresentacion
	 *            the codigoFormaPresentacion to set
	 */
	public void setCodigoFormaPresentacion(String codigoFormaPresentacion) {
		this.codigoFormaPresentacion = codigoFormaPresentacion;
	}

	/**
	 * Método getter del atributo nombreFormaPresentacion de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the nombreFormaPresentacion
	 */
	public String getNombreFormaPresentacion() {
		return nombreFormaPresentacion;
	}

	/**
	 * Método setter del atributo nombreFormaPresentacion de la clase InformacionAportantePlanillaDTO
	 *
	 * @param nombreFormaPresentacion
	 *            the nombreFormaPresentacion to set
	 */
	public void setNombreFormaPresentacion(String nombreFormaPresentacion) {
		this.nombreFormaPresentacion = nombreFormaPresentacion;
	}

	/**
	 * Método getter del atributo idSoiAdministradoraARP de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the idSoiAdministradoraARP
	 */
	public Integer getIdSoiAdministradoraARP() {
		return idSoiAdministradoraARP;
	}

	/**
	 * Método setter del atributo idSoiAdministradoraARP de la clase InformacionAportantePlanillaDTO
	 *
	 * @param idSoiAdministradoraARP
	 *            the idSoiAdministradoraARP to set
	 */
	public void setIdSoiAdministradoraARP(Integer idSoiAdministradoraARP) {
		this.idSoiAdministradoraARP = idSoiAdministradoraARP;
	}

	/**
	 * Método getter del atributo nombreARP de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the nombreARP
	 */
	public String getNombreARP() {
		return nombreARP;
	}

	/**
	 * Método setter del atributo nombreARP de la clase InformacionAportantePlanillaDTO
	 *
	 * @param nombreARP
	 *            the nombreARP to set
	 */
	public void setNombreARP(String nombreARP) {
		this.nombreARP = nombreARP;
	}

	/**
	 * Método getter del atributo codAdministradoraARP de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the codAdministradoraARP
	 */
	public String getCodAdministradoraARP() {
		return codAdministradoraARP;
	}

	/**
	 * Método setter del atributo codAdministradoraARP de la clase InformacionAportantePlanillaDTO
	 *
	 * @param codAdministradoraARP
	 *            the codAdministradoraARP to set
	 */
	public void setCodAdministradoraARP(String codAdministradoraARP) {
		this.codAdministradoraARP = codAdministradoraARP;
	}

	/**
	 * Método getter del atributo idSoiAdministradoraCCF de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the idSoiAdministradoraCCF
	 */
	public Integer getIdSoiAdministradoraCCF() {
		return idSoiAdministradoraCCF;
	}

	/**
	 * Método setter del atributo idSoiAdministradoraCCF de la clase InformacionAportantePlanillaDTO
	 *
	 * @param idSoiAdministradoraCCF
	 *            the idSoiAdministradoraCCF to set
	 */
	public void setIdSoiAdministradoraCCF(Integer idSoiAdministradoraCCF) {
		this.idSoiAdministradoraCCF = idSoiAdministradoraCCF;
	}

	/**
	 * Método getter del atributo nombreCCF de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the nombreCCF
	 */
	public String getNombreCCF() {
		return nombreCCF;
	}

	/**
	 * Método setter del atributo nombreCCF de la clase InformacionAportantePlanillaDTO
	 *
	 * @param nombreCCF
	 *            the nombreCCF to set
	 */
	public void setNombreCCF(String nombreCCF) {
		this.nombreCCF = nombreCCF;
	}

	/**
	 * Método getter del atributo codAdministradoraCCF de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the codAdministradoraCCF
	 */
	public String getCodAdministradoraCCF() {
		return codAdministradoraCCF;
	}

	/**
	 * Método setter del atributo codAdministradoraCCF de la clase InformacionAportantePlanillaDTO
	 *
	 * @param codAdministradoraCCF
	 *            the codAdministradoraCCF to set
	 */
	public void setCodAdministradoraCCF(String codAdministradoraCCF) {
		this.codAdministradoraCCF = codAdministradoraCCF;
	}

	/**
	 * Método getter del atributo minimoCotizanteClaseAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the minimoCotizanteClaseAportante
	 */
	public Integer getMinimoCotizanteClaseAportante() {
		return minimoCotizanteClaseAportante;
	}

	/**
	 * Método setter del atributo minimoCotizanteClaseAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @param minimoCotizanteClaseAportante
	 *            the minimoCotizanteClaseAportante to set
	 */
	public void setMinimoCotizanteClaseAportante(Integer minimoCotizanteClaseAportante) {
		this.minimoCotizanteClaseAportante = minimoCotizanteClaseAportante;
	}

	/**
	 * Método getter del atributo maximoCotizanteClaseAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the maximoCotizanteClaseAportante
	 */
	public Integer getMaximoCotizanteClaseAportante() {
		return maximoCotizanteClaseAportante;
	}

	/**
	 * Método setter del atributo maximoCotizanteClaseAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @param maximoCotizanteClaseAportante
	 *            the maximoCotizanteClaseAportante to set
	 */
	public void setMaximoCotizanteClaseAportante(Integer maximoCotizanteClaseAportante) {
		this.maximoCotizanteClaseAportante = maximoCotizanteClaseAportante;
	}

	/**
	 * Método getter del atributo correoAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the correoAportante
	 */
	public String getCorreoAportante() {
		return correoAportante;
	}

	/**
	 * Método setter del atributo correoAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @param correoAportante
	 *            the correoAportante to set
	 */
	public void setCorreoAportante(String correoAportante) {
		this.correoAportante = correoAportante;
	}

	/**
	 * Método getter del atributo codigoOperador de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the codigoOperador
	 */
	public String getCodigoOperador() {
		return codigoOperador;
	}

	/**
	 * Método setter del atributo codigoOperador de la clase InformacionAportantePlanillaDTO
	 *
	 * @param codigoOperador
	 *            the codigoOperador to set
	 */
	public void setCodigoOperador(String codigoOperador) {
		this.codigoOperador = codigoOperador;
	}

	/**
	 * Método getter del atributo idSoiOperador de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the idSoiOperador
	 */
	public Integer getIdSoiOperador() {
		return idSoiOperador;
	}

	/**
	 * Método setter del atributo idSoiOperador de la clase InformacionAportantePlanillaDTO
	 *
	 * @param idSoiOperador
	 *            the idSoiOperador to set
	 */
	public void setIdSoiOperador(Integer idSoiOperador) {
		this.idSoiOperador = idSoiOperador;
	}

	/**
	 * Método getter del atributo tipoPersonaEntidadFinanciera de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the tipoPersonaEntidadFinanciera
	 */
	public String getTipoPersonaEntidadFinanciera() {
		return tipoPersonaEntidadFinanciera;
	}

	/**
	 * Método setter del atributo tipoPersonaEntidadFinanciera de la clase InformacionAportantePlanillaDTO
	 *
	 * @param tipoPersonaEntidadFinanciera
	 *            the tipoPersonaEntidadFinanciera to set
	 */
	public void setTipoPersonaEntidadFinanciera(String tipoPersonaEntidadFinanciera) {
		this.tipoPersonaEntidadFinanciera = tipoPersonaEntidadFinanciera;
	}

	/**
	 * Método getter del atributo idSoiTpPagadorPension de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the idSoiTpPagadorPension
	 */
	public Integer getIdSoiTpPagadorPension() {
		return idSoiTpPagadorPension;
	}

	/**
	 * Método setter del atributo idSoiTpPagadorPension de la clase InformacionAportantePlanillaDTO
	 *
	 * @param idSoiTpPagadorPension
	 *            the idSoiTpPagadorPension to set
	 */
	public void setIdSoiTpPagadorPension(Integer idSoiTpPagadorPension) {
		this.idSoiTpPagadorPension = idSoiTpPagadorPension;
	}

	/**
	 * Método getter del atributo nombreTipoPagadoPension de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the nombreTipoPagadoPension
	 */
	public String getNombreTipoPagadoPension() {
		return nombreTipoPagadoPension;
	}

	/**
	 * Método setter del atributo nombreTipoPagadoPension de la clase InformacionAportantePlanillaDTO
	 *
	 * @param nombreTipoPagadoPension
	 *            the nombreTipoPagadoPension to set
	 */
	public void setNombreTipoPagadoPension(String nombreTipoPagadoPension) {
		this.nombreTipoPagadoPension = nombreTipoPagadoPension;
	}

	/**
	 * Método getter del atributo nombreUsuarioAdministrador de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the nombreUsuarioAdministrador
	 */
	public String getNombreUsuarioAdministrador() {
		return nombreUsuarioAdministrador;
	}

	/**
	 * Método setter del atributo nombreUsuarioAdministrador de la clase InformacionAportantePlanillaDTO
	 *
	 * @param nombreUsuarioAdministrador
	 *            the nombreUsuarioAdministrador to set
	 */
	public void setNombreUsuarioAdministrador(String nombreUsuarioAdministrador) {
		this.nombreUsuarioAdministrador = nombreUsuarioAdministrador;
	}

	/**
	 * Método getter del atributo apellidoUsuarioAdministrador de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the apellidoUsuarioAdministrador
	 */
	public String getApellidoUsuarioAdministrador() {
		return apellidoUsuarioAdministrador;
	}

	/**
	 * Método setter del atributo apellidoUsuarioAdministrador de la clase InformacionAportantePlanillaDTO
	 *
	 * @param apellidoUsuarioAdministrador
	 *            the apellidoUsuarioAdministrador to set
	 */
	public void setApellidoUsuarioAdministrador(String apellidoUsuarioAdministrador) {
		this.apellidoUsuarioAdministrador = apellidoUsuarioAdministrador;
	}

	/**
	 * Método getter del atributo nombreCompletoUsuarioAdmin de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the nombreCompletoUsuarioAdmin
	 */
	public String getNombreCompletoUsuarioAdmin() {
		return nombreCompletoUsuarioAdmin;
	}

	/**
	 * Método setter del atributo nombreCompletoUsuarioAdmin de la clase InformacionAportantePlanillaDTO
	 *
	 * @param nombreCompletoUsuarioAdmin
	 *            the nombreCompletoUsuarioAdmin to set
	 */
	public void setNombreCompletoUsuarioAdmin(String nombreCompletoUsuarioAdmin) {
		this.nombreCompletoUsuarioAdmin = nombreCompletoUsuarioAdmin;
	}

	/**
	 * Método getter del atributo codDepartamentoAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the codDepartamentoAportante
	 */
	public String getCodDepartamentoAportante() {
		return codDepartamentoAportante;
	}

	/**
	 * Método setter del atributo codDepartamentoAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @param codDepartamentoAportante
	 *            the codDepartamentoAportante to set
	 */
	public void setCodDepartamentoAportante(String codDepartamentoAportante) {
		this.codDepartamentoAportante = codDepartamentoAportante;
	}

	/**
	 * Método getter del atributo codMunicipioAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the codMunicipioAportante
	 */
	public String getCodMunicipioAportante() {
		return codMunicipioAportante;
	}

	/**
	 * Método setter del atributo codMunicipioAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @param codMunicipioAportante
	 *            the codMunicipioAportante to set
	 */
	public void setCodMunicipioAportante(String codMunicipioAportante) {
		this.codMunicipioAportante = codMunicipioAportante;
	}

	/**
	 * Método getter del atributo direccionAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the direccionAportante
	 */
	public String getDireccionAportante() {
		return direccionAportante;
	}

	/**
	 * Método setter del atributo direccionAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @param direccionAportante
	 *            the direccionAportante to set
	 */
	public void setDireccionAportante(String direccionAportante) {
		this.direccionAportante = direccionAportante;
	}

	/**
	 * Método getter del atributo telefonoAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the telefonoAportante
	 */
	public String getTelefonoAportante() {
		return telefonoAportante;
	}

	/**
	 * Método setter del atributo telefonoAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @param telefonoAportante
	 *            the telefonoAportante to set
	 */
	public void setTelefonoAportante(String telefonoAportante) {
		this.telefonoAportante = telefonoAportante;
	}

	/**
	 * Método getter del atributo faxAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the faxAportante
	 */
	public String getFaxAportante() {
		return faxAportante;
	}

	/**
	 * Método setter del atributo faxAportante de la clase InformacionAportantePlanillaDTO
	 *
	 * @param faxAportante
	 *            the faxAportante to set
	 */
	public void setFaxAportante(String faxAportante) {
		this.faxAportante = faxAportante;
	}

	/**
	 * Método getter del atributo aportanteMigrado de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the aportanteMigrado
	 */
	public Integer getAportanteMigrado() {
		return aportanteMigrado;
	}

	/**
	 * Método setter del atributo aportanteMigrado de la clase InformacionAportantePlanillaDTO
	 *
	 * @param aportanteMigrado
	 *            the aportanteMigrado to set
	 */
	public void setAportanteMigrado(Integer aportanteMigrado) {
		this.aportanteMigrado = aportanteMigrado;
	}

	/**
	 * Método getter del atributo apteMigradoActDatos de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the apteMigradoActDatos
	 */
	public Integer getApteMigradoActDatos() {
		return apteMigradoActDatos;
	}

	/**
	 * Método setter del atributo apteMigradoActDatos de la clase InformacionAportantePlanillaDTO
	 *
	 * @param apteMigradoActDatos
	 *            the apteMigradoActDatos to set
	 */
	public void setApteMigradoActDatos(Integer apteMigradoActDatos) {
		this.apteMigradoActDatos = apteMigradoActDatos;
	}

	/**
	 * Método getter del atributo fechaRegistroMercantil de la clase InformacionAportantePlanillaDTO
	 *
	 * @return the fechaRegistroMercantil
	 */
	public String getFechaRegistroMercantil() {
		return fechaRegistroMercantil;
	}

	/**
	 * Método setter del atributo fechaRegistroMercantil de la clase InformacionAportantePlanillaDTO
	 *
	 * @param fechaRegistroMercantil
	 *            the fechaRegistroMercantil to set
	 */
	public void setFechaRegistroMercantil(String fechaRegistroMercantil) {
		this.fechaRegistroMercantil = fechaRegistroMercantil;
	}

}

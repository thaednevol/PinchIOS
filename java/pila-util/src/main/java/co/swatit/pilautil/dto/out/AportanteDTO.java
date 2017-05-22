/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;

import com.ach.apt.biz.model.AportanteVO;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link AportanteVO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class AportanteDTO implements Serializable {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	private Integer pagoElectronicoOc;
	private Integer permiteGeneracionCsv;
	private Long cantidadMaximaErrores;
	private String fechaActInformacion;
	private Integer actualizoInformacion;
	private Integer aporteCajaCompensacion;
	private String fechaCreacionEmpresa;
	private Integer apteMigradoActDatos;
	private Integer aportanteMigrado;
	private Integer ctaEntidadFinanciera;
	private String celular;
	private String correo;
	private Integer infoViaCelular;
	private Integer infoViaCorreo;
	private String ipModificacion;
	private String fechaModificacion;
	private String usuarioModificacion;
	private String ipCreacion;
	private String fechaCreacion;
	private String usuarioCreacion;
	private String apellido;
	private String causaFinVigencia;
	private String fechaFinVigencia;
	private Integer vigente;
	private String fechaInicioVigencia;
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
	private String nombre;
	private Long idSoiAportante;

	/**
	 * Método getter del atributo pagoElectronicoOc de la clase AportanteDTO
	 *
	 * @return the pagoElectronicoOc
	 */
	public Integer getPagoElectronicoOc() {
		return pagoElectronicoOc;
	}

	/**
	 * Método setter del atributo pagoElectronicoOc de la clase AportanteDTO
	 *
	 * @param pagoElectronicoOc
	 *            the pagoElectronicoOc to set
	 */
	public void setPagoElectronicoOc(Integer pagoElectronicoOc) {
		this.pagoElectronicoOc = pagoElectronicoOc;
	}

	/**
	 * Método getter del atributo permiteGeneracionCsv de la clase AportanteDTO
	 *
	 * @return the permiteGeneracionCsv
	 */
	public Integer getPermiteGeneracionCsv() {
		return permiteGeneracionCsv;
	}

	/**
	 * Método setter del atributo permiteGeneracionCsv de la clase AportanteDTO
	 *
	 * @param permiteGeneracionCsv
	 *            the permiteGeneracionCsv to set
	 */
	public void setPermiteGeneracionCsv(Integer permiteGeneracionCsv) {
		this.permiteGeneracionCsv = permiteGeneracionCsv;
	}

	/**
	 * Método getter del atributo cantidadMaximaErrores de la clase AportanteDTO
	 *
	 * @return the cantidadMaximaErrores
	 */
	public Long getCantidadMaximaErrores() {
		return cantidadMaximaErrores;
	}

	/**
	 * Método setter del atributo cantidadMaximaErrores de la clase AportanteDTO
	 *
	 * @param cantidadMaximaErrores
	 *            the cantidadMaximaErrores to set
	 */
	public void setCantidadMaximaErrores(Long cantidadMaximaErrores) {
		this.cantidadMaximaErrores = cantidadMaximaErrores;
	}

	/**
	 * Método getter del atributo fechaActInformacion de la clase AportanteDTO
	 *
	 * @return the fechaActInformacion
	 */
	public String getFechaActInformacion() {
		return fechaActInformacion;
	}

	/**
	 * Método setter del atributo fechaActInformacion de la clase AportanteDTO
	 *
	 * @param fechaActInformacion
	 *            the fechaActInformacion to set
	 */
	public void setFechaActInformacion(String fechaActInformacion) {
		this.fechaActInformacion = fechaActInformacion;
	}

	/**
	 * Método getter del atributo actualizoInformacion de la clase AportanteDTO
	 *
	 * @return the actualizoInformacion
	 */
	public Integer getActualizoInformacion() {
		return actualizoInformacion;
	}

	/**
	 * Método setter del atributo actualizoInformacion de la clase AportanteDTO
	 *
	 * @param actualizoInformacion
	 *            the actualizoInformacion to set
	 */
	public void setActualizoInformacion(Integer actualizoInformacion) {
		this.actualizoInformacion = actualizoInformacion;
	}

	/**
	 * Método getter del atributo aporteCajaCompensacion de la clase AportanteDTO
	 *
	 * @return the aporteCajaCompensacion
	 */
	public Integer getAporteCajaCompensacion() {
		return aporteCajaCompensacion;
	}

	/**
	 * Método setter del atributo aporteCajaCompensacion de la clase AportanteDTO
	 *
	 * @param aporteCajaCompensacion
	 *            the aporteCajaCompensacion to set
	 */
	public void setAporteCajaCompensacion(Integer aporteCajaCompensacion) {
		this.aporteCajaCompensacion = aporteCajaCompensacion;
	}

	/**
	 * Método getter del atributo fechaCreacionEmpresa de la clase AportanteDTO
	 *
	 * @return the fechaCreacionEmpresa
	 */
	public String getFechaCreacionEmpresa() {
		return fechaCreacionEmpresa;
	}

	/**
	 * Método setter del atributo fechaCreacionEmpresa de la clase AportanteDTO
	 *
	 * @param fechaCreacionEmpresa
	 *            the fechaCreacionEmpresa to set
	 */
	public void setFechaCreacionEmpresa(String fechaCreacionEmpresa) {
		this.fechaCreacionEmpresa = fechaCreacionEmpresa;
	}

	/**
	 * Método getter del atributo apteMigradoActDatos de la clase AportanteDTO
	 *
	 * @return the apteMigradoActDatos
	 */
	public Integer getApteMigradoActDatos() {
		return apteMigradoActDatos;
	}

	/**
	 * Método setter del atributo apteMigradoActDatos de la clase AportanteDTO
	 *
	 * @param apteMigradoActDatos
	 *            the apteMigradoActDatos to set
	 */
	public void setApteMigradoActDatos(Integer apteMigradoActDatos) {
		this.apteMigradoActDatos = apteMigradoActDatos;
	}

	/**
	 * Método getter del atributo aportanteMigrado de la clase AportanteDTO
	 *
	 * @return the aportanteMigrado
	 */
	public Integer getAportanteMigrado() {
		return aportanteMigrado;
	}

	/**
	 * Método setter del atributo aportanteMigrado de la clase AportanteDTO
	 *
	 * @param aportanteMigrado
	 *            the aportanteMigrado to set
	 */
	public void setAportanteMigrado(Integer aportanteMigrado) {
		this.aportanteMigrado = aportanteMigrado;
	}

	/**
	 * Método getter del atributo ctaEntidadFinanciera de la clase AportanteDTO
	 *
	 * @return the ctaEntidadFinanciera
	 */
	public Integer getCtaEntidadFinanciera() {
		return ctaEntidadFinanciera;
	}

	/**
	 * Método setter del atributo ctaEntidadFinanciera de la clase AportanteDTO
	 *
	 * @param ctaEntidadFinanciera
	 *            the ctaEntidadFinanciera to set
	 */
	public void setCtaEntidadFinanciera(Integer ctaEntidadFinanciera) {
		this.ctaEntidadFinanciera = ctaEntidadFinanciera;
	}

	/**
	 * Método getter del atributo celular de la clase AportanteDTO
	 *
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * Método setter del atributo celular de la clase AportanteDTO
	 *
	 * @param celular
	 *            the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * Método getter del atributo correo de la clase AportanteDTO
	 *
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Método setter del atributo correo de la clase AportanteDTO
	 *
	 * @param correo
	 *            the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Método getter del atributo infoViaCelular de la clase AportanteDTO
	 *
	 * @return the infoViaCelular
	 */
	public Integer getInfoViaCelular() {
		return infoViaCelular;
	}

	/**
	 * Método setter del atributo infoViaCelular de la clase AportanteDTO
	 *
	 * @param infoViaCelular
	 *            the infoViaCelular to set
	 */
	public void setInfoViaCelular(Integer infoViaCelular) {
		this.infoViaCelular = infoViaCelular;
	}

	/**
	 * Método getter del atributo infoViaCorreo de la clase AportanteDTO
	 *
	 * @return the infoViaCorreo
	 */
	public Integer getInfoViaCorreo() {
		return infoViaCorreo;
	}

	/**
	 * Método setter del atributo infoViaCorreo de la clase AportanteDTO
	 *
	 * @param infoViaCorreo
	 *            the infoViaCorreo to set
	 */
	public void setInfoViaCorreo(Integer infoViaCorreo) {
		this.infoViaCorreo = infoViaCorreo;
	}

	/**
	 * Método getter del atributo ipModificacion de la clase AportanteDTO
	 *
	 * @return the ipModificacion
	 */
	public String getIpModificacion() {
		return ipModificacion;
	}

	/**
	 * Método setter del atributo ipModificacion de la clase AportanteDTO
	 *
	 * @param ipModificacion
	 *            the ipModificacion to set
	 */
	public void setIpModificacion(String ipModificacion) {
		this.ipModificacion = ipModificacion;
	}

	/**
	 * Método getter del atributo fechaModificacion de la clase AportanteDTO
	 *
	 * @return the fechaModificacion
	 */
	public String getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * Método setter del atributo fechaModificacion de la clase AportanteDTO
	 *
	 * @param fechaModificacion
	 *            the fechaModificacion to set
	 */
	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * Método getter del atributo usuarioModificacion de la clase AportanteDTO
	 *
	 * @return the usuarioModificacion
	 */
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	/**
	 * Método setter del atributo usuarioModificacion de la clase AportanteDTO
	 *
	 * @param usuarioModificacion
	 *            the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	/**
	 * Método getter del atributo ipCreacion de la clase AportanteDTO
	 *
	 * @return the ipCreacion
	 */
	public String getIpCreacion() {
		return ipCreacion;
	}

	/**
	 * Método setter del atributo ipCreacion de la clase AportanteDTO
	 *
	 * @param ipCreacion
	 *            the ipCreacion to set
	 */
	public void setIpCreacion(String ipCreacion) {
		this.ipCreacion = ipCreacion;
	}

	/**
	 * Método getter del atributo fechaCreacion de la clase AportanteDTO
	 *
	 * @return the fechaCreacion
	 */
	public String getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Método setter del atributo fechaCreacion de la clase AportanteDTO
	 *
	 * @param fechaCreacion
	 *            the fechaCreacion to set
	 */
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Método getter del atributo usuarioCreacion de la clase AportanteDTO
	 *
	 * @return the usuarioCreacion
	 */
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	/**
	 * Método setter del atributo usuarioCreacion de la clase AportanteDTO
	 *
	 * @param usuarioCreacion
	 *            the usuarioCreacion to set
	 */
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	/**
	 * Método getter del atributo apellido de la clase AportanteDTO
	 *
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Método setter del atributo apellido de la clase AportanteDTO
	 *
	 * @param apellido
	 *            the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Método getter del atributo causaFinVigencia de la clase AportanteDTO
	 *
	 * @return the causaFinVigencia
	 */
	public String getCausaFinVigencia() {
		return causaFinVigencia;
	}

	/**
	 * Método setter del atributo causaFinVigencia de la clase AportanteDTO
	 *
	 * @param causaFinVigencia
	 *            the causaFinVigencia to set
	 */
	public void setCausaFinVigencia(String causaFinVigencia) {
		this.causaFinVigencia = causaFinVigencia;
	}

	/**
	 * Método getter del atributo fechaFinVigencia de la clase AportanteDTO
	 *
	 * @return the fechaFinVigencia
	 */
	public String getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	/**
	 * Método setter del atributo fechaFinVigencia de la clase AportanteDTO
	 *
	 * @param fechaFinVigencia
	 *            the fechaFinVigencia to set
	 */
	public void setFechaFinVigencia(String fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	/**
	 * Método getter del atributo vigente de la clase AportanteDTO
	 *
	 * @return the vigente
	 */
	public Integer getVigente() {
		return vigente;
	}

	/**
	 * Método setter del atributo vigente de la clase AportanteDTO
	 *
	 * @param vigente
	 *            the vigente to set
	 */
	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}

	/**
	 * Método getter del atributo fechaInicioVigencia de la clase AportanteDTO
	 *
	 * @return the fechaInicioVigencia
	 */
	public String getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	/**
	 * Método setter del atributo fechaInicioVigencia de la clase AportanteDTO
	 *
	 * @param fechaInicioVigencia
	 *            the fechaInicioVigencia to set
	 */
	public void setFechaInicioVigencia(String fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	/**
	 * Método getter del atributo idArp de la clase AportanteDTO
	 *
	 * @return the idArp
	 */
	public Integer getIdArp() {
		return idArp;
	}

	/**
	 * Método setter del atributo idArp de la clase AportanteDTO
	 *
	 * @param idArp
	 *            the idArp to set
	 */
	public void setIdArp(Integer idArp) {
		this.idArp = idArp;
	}

	/**
	 * Método getter del atributo idCcf de la clase AportanteDTO
	 *
	 * @return the idCcf
	 */
	public Integer getIdCcf() {
		return idCcf;
	}

	/**
	 * Método setter del atributo idCcf de la clase AportanteDTO
	 *
	 * @param idCcf
	 *            the idCcf to set
	 */
	public void setIdCcf(Integer idCcf) {
		this.idCcf = idCcf;
	}

	/**
	 * Método getter del atributo aporteEsapMinedu de la clase AportanteDTO
	 *
	 * @return the aporteEsapMinedu
	 */
	public Integer getAporteEsapMinedu() {
		return aporteEsapMinedu;
	}

	/**
	 * Método setter del atributo aporteEsapMinedu de la clase AportanteDTO
	 *
	 * @param aporteEsapMinedu
	 *            the aporteEsapMinedu to set
	 */
	public void setAporteEsapMinedu(Integer aporteEsapMinedu) {
		this.aporteEsapMinedu = aporteEsapMinedu;
	}

	/**
	 * Método getter del atributo codTpPersonaFinanciera de la clase AportanteDTO
	 *
	 * @return the codTpPersonaFinanciera
	 */
	public String getCodTpPersonaFinanciera() {
		return codTpPersonaFinanciera;
	}

	/**
	 * Método setter del atributo codTpPersonaFinanciera de la clase AportanteDTO
	 *
	 * @param codTpPersonaFinanciera
	 *            the codTpPersonaFinanciera to set
	 */
	public void setCodTpPersonaFinanciera(String codTpPersonaFinanciera) {
		this.codTpPersonaFinanciera = codTpPersonaFinanciera;
	}

	/**
	 * Método getter del atributo idSoiTpPagadorPension de la clase AportanteDTO
	 *
	 * @return the idSoiTpPagadorPension
	 */
	public Integer getIdSoiTpPagadorPension() {
		return idSoiTpPagadorPension;
	}

	/**
	 * Método setter del atributo idSoiTpPagadorPension de la clase AportanteDTO
	 *
	 * @param idSoiTpPagadorPension
	 *            the idSoiTpPagadorPension to set
	 */
	public void setIdSoiTpPagadorPension(Integer idSoiTpPagadorPension) {
		this.idSoiTpPagadorPension = idSoiTpPagadorPension;
	}

	/**
	 * Método getter del atributo fechaFinAccion de la clase AportanteDTO
	 *
	 * @return the fechaFinAccion
	 */
	public String getFechaFinAccion() {
		return fechaFinAccion;
	}

	/**
	 * Método setter del atributo fechaFinAccion de la clase AportanteDTO
	 *
	 * @param fechaFinAccion
	 *            the fechaFinAccion to set
	 */
	public void setFechaFinAccion(String fechaFinAccion) {
		this.fechaFinAccion = fechaFinAccion;
	}

	/**
	 * Método getter del atributo fechaInicioAccion de la clase AportanteDTO
	 *
	 * @return the fechaInicioAccion
	 */
	public String getFechaInicioAccion() {
		return fechaInicioAccion;
	}

	/**
	 * Método setter del atributo fechaInicioAccion de la clase AportanteDTO
	 *
	 * @param fechaInicioAccion
	 *            the fechaInicioAccion to set
	 */
	public void setFechaInicioAccion(String fechaInicioAccion) {
		this.fechaInicioAccion = fechaInicioAccion;
	}

	/**
	 * Método getter del atributo idSoiTpAccion de la clase AportanteDTO
	 *
	 * @return the idSoiTpAccion
	 */
	public Integer getIdSoiTpAccion() {
		return idSoiTpAccion;
	}

	/**
	 * Método setter del atributo idSoiTpAccion de la clase AportanteDTO
	 *
	 * @param idSoiTpAccion
	 *            the idSoiTpAccion to set
	 */
	public void setIdSoiTpAccion(Integer idSoiTpAccion) {
		this.idSoiTpAccion = idSoiTpAccion;
	}

	/**
	 * Método getter del atributo rlSegundoApellido de la clase AportanteDTO
	 *
	 * @return the rlSegundoApellido
	 */
	public String getRlSegundoApellido() {
		return rlSegundoApellido;
	}

	/**
	 * Método setter del atributo rlSegundoApellido de la clase AportanteDTO
	 *
	 * @param rlSegundoApellido
	 *            the rlSegundoApellido to set
	 */
	public void setRlSegundoApellido(String rlSegundoApellido) {
		this.rlSegundoApellido = rlSegundoApellido;
	}

	/**
	 * Método getter del atributo rlPrimerApellido de la clase AportanteDTO
	 *
	 * @return the rlPrimerApellido
	 */
	public String getRlPrimerApellido() {
		return rlPrimerApellido;
	}

	/**
	 * Método setter del atributo rlPrimerApellido de la clase AportanteDTO
	 *
	 * @param rlPrimerApellido
	 *            the rlPrimerApellido to set
	 */
	public void setRlPrimerApellido(String rlPrimerApellido) {
		this.rlPrimerApellido = rlPrimerApellido;
	}

	/**
	 * Método getter del atributo rlSegundoNombre de la clase AportanteDTO
	 *
	 * @return the rlSegundoNombre
	 */
	public String getRlSegundoNombre() {
		return rlSegundoNombre;
	}

	/**
	 * Método setter del atributo rlSegundoNombre de la clase AportanteDTO
	 *
	 * @param rlSegundoNombre
	 *            the rlSegundoNombre to set
	 */
	public void setRlSegundoNombre(String rlSegundoNombre) {
		this.rlSegundoNombre = rlSegundoNombre;
	}

	/**
	 * Método getter del atributo rlPrimerNombre de la clase AportanteDTO
	 *
	 * @return the rlPrimerNombre
	 */
	public String getRlPrimerNombre() {
		return rlPrimerNombre;
	}

	/**
	 * Método setter del atributo rlPrimerNombre de la clase AportanteDTO
	 *
	 * @param rlPrimerNombre
	 *            the rlPrimerNombre to set
	 */
	public void setRlPrimerNombre(String rlPrimerNombre) {
		this.rlPrimerNombre = rlPrimerNombre;
	}

	/**
	 * Método getter del atributo rlNumeroIdentificacion de la clase AportanteDTO
	 *
	 * @return the rlNumeroIdentificacion
	 */
	public String getRlNumeroIdentificacion() {
		return rlNumeroIdentificacion;
	}

	/**
	 * Método setter del atributo rlNumeroIdentificacion de la clase AportanteDTO
	 *
	 * @param rlNumeroIdentificacion
	 *            the rlNumeroIdentificacion to set
	 */
	public void setRlNumeroIdentificacion(String rlNumeroIdentificacion) {
		this.rlNumeroIdentificacion = rlNumeroIdentificacion;
	}

	/**
	 * Método getter del atributo rlIdTpIdentificacion de la clase AportanteDTO
	 *
	 * @return the rlIdTpIdentificacion
	 */
	public Integer getRlIdTpIdentificacion() {
		return rlIdTpIdentificacion;
	}

	/**
	 * Método setter del atributo rlIdTpIdentificacion de la clase AportanteDTO
	 *
	 * @param rlIdTpIdentificacion
	 *            the rlIdTpIdentificacion to set
	 */
	public void setRlIdTpIdentificacion(Integer rlIdTpIdentificacion) {
		this.rlIdTpIdentificacion = rlIdTpIdentificacion;
	}

	/**
	 * Método getter del atributo fax de la clase AportanteDTO
	 *
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * Método setter del atributo fax de la clase AportanteDTO
	 *
	 * @param fax
	 *            the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * Método getter del atributo extension de la clase AportanteDTO
	 *
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * Método setter del atributo extension de la clase AportanteDTO
	 *
	 * @param extension
	 *            the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * Método getter del atributo telefono de la clase AportanteDTO
	 *
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Método setter del atributo telefono de la clase AportanteDTO
	 *
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Método getter del atributo idSoiActividadEcon de la clase AportanteDTO
	 *
	 * @return the idSoiActividadEcon
	 */
	public Integer getIdSoiActividadEcon() {
		return idSoiActividadEcon;
	}

	/**
	 * Método setter del atributo idSoiActividadEcon de la clase AportanteDTO
	 *
	 * @param idSoiActividadEcon
	 *            the idSoiActividadEcon to set
	 */
	public void setIdSoiActividadEcon(Integer idSoiActividadEcon) {
		this.idSoiActividadEcon = idSoiActividadEcon;
	}

	/**
	 * Método getter del atributo idSoiMunicipio de la clase AportanteDTO
	 *
	 * @return the idSoiMunicipio
	 */
	public Long getIdSoiMunicipio() {
		return idSoiMunicipio;
	}

	/**
	 * Método setter del atributo idSoiMunicipio de la clase AportanteDTO
	 *
	 * @param idSoiMunicipio
	 *            the idSoiMunicipio to set
	 */
	public void setIdSoiMunicipio(Long idSoiMunicipio) {
		this.idSoiMunicipio = idSoiMunicipio;
	}

	/**
	 * Método getter del atributo direccion de la clase AportanteDTO
	 *
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Método setter del atributo direccion de la clase AportanteDTO
	 *
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Método getter del atributo idSoiFormaPresentacion de la clase AportanteDTO
	 *
	 * @return the idSoiFormaPresentacion
	 */
	public Integer getIdSoiFormaPresentacion() {
		return idSoiFormaPresentacion;
	}

	/**
	 * Método setter del atributo idSoiFormaPresentacion de la clase AportanteDTO
	 *
	 * @param idSoiFormaPresentacion
	 *            the idSoiFormaPresentacion to set
	 */
	public void setIdSoiFormaPresentacion(Integer idSoiFormaPresentacion) {
		this.idSoiFormaPresentacion = idSoiFormaPresentacion;
	}

	/**
	 * Método getter del atributo codTpPersona de la clase AportanteDTO
	 *
	 * @return the codTpPersona
	 */
	public String getCodTpPersona() {
		return codTpPersona;
	}

	/**
	 * Método setter del atributo codTpPersona de la clase AportanteDTO
	 *
	 * @param codTpPersona
	 *            the codTpPersona to set
	 */
	public void setCodTpPersona(String codTpPersona) {
		this.codTpPersona = codTpPersona;
	}

	/**
	 * Método getter del atributo idSoiTpEmpresa de la clase AportanteDTO
	 *
	 * @return the idSoiTpEmpresa
	 */
	public Integer getIdSoiTpEmpresa() {
		return idSoiTpEmpresa;
	}

	/**
	 * Método setter del atributo idSoiTpEmpresa de la clase AportanteDTO
	 *
	 * @param idSoiTpEmpresa
	 *            the idSoiTpEmpresa to set
	 */
	public void setIdSoiTpEmpresa(Integer idSoiTpEmpresa) {
		this.idSoiTpEmpresa = idSoiTpEmpresa;
	}

	/**
	 * Método getter del atributo idSoiTpAportante de la clase AportanteDTO
	 *
	 * @return the idSoiTpAportante
	 */
	public Integer getIdSoiTpAportante() {
		return idSoiTpAportante;
	}

	/**
	 * Método setter del atributo idSoiTpAportante de la clase AportanteDTO
	 *
	 * @param idSoiTpAportante
	 *            the idSoiTpAportante to set
	 */
	public void setIdSoiTpAportante(Integer idSoiTpAportante) {
		this.idSoiTpAportante = idSoiTpAportante;
	}

	/**
	 * Método getter del atributo idSoiClaseAportante de la clase AportanteDTO
	 *
	 * @return the idSoiClaseAportante
	 */
	public Integer getIdSoiClaseAportante() {
		return idSoiClaseAportante;
	}

	/**
	 * Método setter del atributo idSoiClaseAportante de la clase AportanteDTO
	 *
	 * @param idSoiClaseAportante
	 *            the idSoiClaseAportante to set
	 */
	public void setIdSoiClaseAportante(Integer idSoiClaseAportante) {
		this.idSoiClaseAportante = idSoiClaseAportante;
	}

	/**
	 * Método getter del atributo digitoVerificacion de la clase AportanteDTO
	 *
	 * @return the digitoVerificacion
	 */
	public String getDigitoVerificacion() {
		return digitoVerificacion;
	}

	/**
	 * Método setter del atributo digitoVerificacion de la clase AportanteDTO
	 *
	 * @param digitoVerificacion
	 *            the digitoVerificacion to set
	 */
	public void setDigitoVerificacion(String digitoVerificacion) {
		this.digitoVerificacion = digitoVerificacion;
	}

	/**
	 * Método getter del atributo numeroIdentificacion de la clase AportanteDTO
	 *
	 * @return the numeroIdentificacion
	 */
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	/**
	 * Método setter del atributo numeroIdentificacion de la clase AportanteDTO
	 *
	 * @param numeroIdentificacion
	 *            the numeroIdentificacion to set
	 */
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	/**
	 * Método getter del atributo idSoiTpIdentificacion de la clase AportanteDTO
	 *
	 * @return the idSoiTpIdentificacion
	 */
	public Integer getIdSoiTpIdentificacion() {
		return idSoiTpIdentificacion;
	}

	/**
	 * Método setter del atributo idSoiTpIdentificacion de la clase AportanteDTO
	 *
	 * @param idSoiTpIdentificacion
	 *            the idSoiTpIdentificacion to set
	 */
	public void setIdSoiTpIdentificacion(Integer idSoiTpIdentificacion) {
		this.idSoiTpIdentificacion = idSoiTpIdentificacion;
	}

	/**
	 * Método getter del atributo nombre de la clase AportanteDTO
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre de la clase AportanteDTO
	 *
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter del atributo idSoiAportante de la clase AportanteDTO
	 *
	 * @return the idSoiAportante
	 */
	public Long getIdSoiAportante() {
		return idSoiAportante;
	}

	/**
	 * Método setter del atributo idSoiAportante de la clase AportanteDTO
	 *
	 * @param idSoiAportante
	 *            the idSoiAportante to set
	 */
	public void setIdSoiAportante(Long idSoiAportante) {
		this.idSoiAportante = idSoiAportante;
	}

}

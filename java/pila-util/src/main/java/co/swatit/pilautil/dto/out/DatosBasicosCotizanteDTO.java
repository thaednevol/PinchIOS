/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;
import java.math.BigDecimal;

import com.ach.pla.biz.model.DatosBasicosCotizanteVO;

/**
 * Objeto de transporte resultado de la conversión de objetos {@link DatosBasicosCotizanteVO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 7/04/2017
 * @version 1.0
 */
public class DatosBasicosCotizanteDTO implements Serializable {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;

	private Integer idTipoIdentificacion;
	private String codTipoIdentificacion;
	private String nombreTipoIdentificacion;
	private String nroIdentificacion;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private Integer idTipoCotizante;
	private String codTipoCotizante;
	private String dscTipoCotizante;
	private Integer idSubtipoCotizante;
	private String codSubtipoCotizante;
	private String dscSubTipoCotizante;
	private Integer idSCExtranjeria;
	private String codSCExtranjeria;
	private String fechaColResidenteExterior;
	private String emailCotizanteParaEnvioSoportes;
	private Integer idDepartamento;
	private String codDepartamento;
	private String nombreDepartamento;
	private Integer idMunicipio;
	private String codMunicipio;
	private String nombreMunicipio;
	private BigDecimal salario;
	private Boolean salarioIntegral;
	private BigDecimal salarioEfectivo;
	private BigDecimal smmlv;
	private Integer idParametroSMMLV;
	private Integer idTipoIdentificacionPrinc;
	private String codTipoIdentificacionPrinc;
	private String nombreTipoIdentificacionPrinc;
	private String nroIdentificacionPrinc;
	private Boolean cargadoPlanillaPreviaPagada;

	/**
	 * Método getter del atributo idTipoIdentificacion de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the idTipoIdentificacion
	 */
	public Integer getIdTipoIdentificacion() {
		return idTipoIdentificacion;
	}

	/**
	 * Método setter del atributo idTipoIdentificacion de la clase DatosBasicosCotizanteDTO
	 *
	 * @param idTipoIdentificacion
	 *            the idTipoIdentificacion to set
	 */
	public void setIdTipoIdentificacion(Integer idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}

	/**
	 * Método getter del atributo codTipoIdentificacion de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the codTipoIdentificacion
	 */
	public String getCodTipoIdentificacion() {
		return codTipoIdentificacion;
	}

	/**
	 * Método setter del atributo codTipoIdentificacion de la clase DatosBasicosCotizanteDTO
	 *
	 * @param codTipoIdentificacion
	 *            the codTipoIdentificacion to set
	 */
	public void setCodTipoIdentificacion(String codTipoIdentificacion) {
		this.codTipoIdentificacion = codTipoIdentificacion;
	}

	/**
	 * Método getter del atributo nombreTipoIdentificacion de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the nombreTipoIdentificacion
	 */
	public String getNombreTipoIdentificacion() {
		return nombreTipoIdentificacion;
	}

	/**
	 * Método setter del atributo nombreTipoIdentificacion de la clase DatosBasicosCotizanteDTO
	 *
	 * @param nombreTipoIdentificacion
	 *            the nombreTipoIdentificacion to set
	 */
	public void setNombreTipoIdentificacion(String nombreTipoIdentificacion) {
		this.nombreTipoIdentificacion = nombreTipoIdentificacion;
	}

	/**
	 * Método getter del atributo nroIdentificacion de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the nroIdentificacion
	 */
	public String getNroIdentificacion() {
		return nroIdentificacion;
	}

	/**
	 * Método setter del atributo nroIdentificacion de la clase DatosBasicosCotizanteDTO
	 *
	 * @param nroIdentificacion
	 *            the nroIdentificacion to set
	 */
	public void setNroIdentificacion(String nroIdentificacion) {
		this.nroIdentificacion = nroIdentificacion;
	}

	/**
	 * Método getter del atributo primerNombre de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the primerNombre
	 */
	public String getPrimerNombre() {
		return primerNombre;
	}

	/**
	 * Método setter del atributo primerNombre de la clase DatosBasicosCotizanteDTO
	 *
	 * @param primerNombre
	 *            the primerNombre to set
	 */
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	/**
	 * Método getter del atributo segundoNombre de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the segundoNombre
	 */
	public String getSegundoNombre() {
		return segundoNombre;
	}

	/**
	 * Método setter del atributo segundoNombre de la clase DatosBasicosCotizanteDTO
	 *
	 * @param segundoNombre
	 *            the segundoNombre to set
	 */
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	/**
	 * Método getter del atributo primerApellido de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the primerApellido
	 */
	public String getPrimerApellido() {
		return primerApellido;
	}

	/**
	 * Método setter del atributo primerApellido de la clase DatosBasicosCotizanteDTO
	 *
	 * @param primerApellido
	 *            the primerApellido to set
	 */
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	/**
	 * Método getter del atributo segundoApellido de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the segundoApellido
	 */
	public String getSegundoApellido() {
		return segundoApellido;
	}

	/**
	 * Método setter del atributo segundoApellido de la clase DatosBasicosCotizanteDTO
	 *
	 * @param segundoApellido
	 *            the segundoApellido to set
	 */
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	/**
	 * Método getter del atributo idTipoCotizante de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the idTipoCotizante
	 */
	public Integer getIdTipoCotizante() {
		return idTipoCotizante;
	}

	/**
	 * Método setter del atributo idTipoCotizante de la clase DatosBasicosCotizanteDTO
	 *
	 * @param idTipoCotizante
	 *            the idTipoCotizante to set
	 */
	public void setIdTipoCotizante(Integer idTipoCotizante) {
		this.idTipoCotizante = idTipoCotizante;
	}

	/**
	 * Método getter del atributo codTipoCotizante de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the codTipoCotizante
	 */
	public String getCodTipoCotizante() {
		return codTipoCotizante;
	}

	/**
	 * Método setter del atributo codTipoCotizante de la clase DatosBasicosCotizanteDTO
	 *
	 * @param codTipoCotizante
	 *            the codTipoCotizante to set
	 */
	public void setCodTipoCotizante(String codTipoCotizante) {
		this.codTipoCotizante = codTipoCotizante;
	}

	/**
	 * Método getter del atributo dscTipoCotizante de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the dscTipoCotizante
	 */
	public String getDscTipoCotizante() {
		return dscTipoCotizante;
	}

	/**
	 * Método setter del atributo dscTipoCotizante de la clase DatosBasicosCotizanteDTO
	 *
	 * @param dscTipoCotizante
	 *            the dscTipoCotizante to set
	 */
	public void setDscTipoCotizante(String dscTipoCotizante) {
		this.dscTipoCotizante = dscTipoCotizante;
	}

	/**
	 * Método getter del atributo idSubtipoCotizante de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the idSubtipoCotizante
	 */
	public Integer getIdSubtipoCotizante() {
		return idSubtipoCotizante;
	}

	/**
	 * Método setter del atributo idSubtipoCotizante de la clase DatosBasicosCotizanteDTO
	 *
	 * @param idSubtipoCotizante
	 *            the idSubtipoCotizante to set
	 */
	public void setIdSubtipoCotizante(Integer idSubtipoCotizante) {
		this.idSubtipoCotizante = idSubtipoCotizante;
	}

	/**
	 * Método getter del atributo codSubtipoCotizante de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the codSubtipoCotizante
	 */
	public String getCodSubtipoCotizante() {
		return codSubtipoCotizante;
	}

	/**
	 * Método setter del atributo codSubtipoCotizante de la clase DatosBasicosCotizanteDTO
	 *
	 * @param codSubtipoCotizante
	 *            the codSubtipoCotizante to set
	 */
	public void setCodSubtipoCotizante(String codSubtipoCotizante) {
		this.codSubtipoCotizante = codSubtipoCotizante;
	}

	/**
	 * Método getter del atributo dscSubTipoCotizante de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the dscSubTipoCotizante
	 */
	public String getDscSubTipoCotizante() {
		return dscSubTipoCotizante;
	}

	/**
	 * Método setter del atributo dscSubTipoCotizante de la clase DatosBasicosCotizanteDTO
	 *
	 * @param dscSubTipoCotizante
	 *            the dscSubTipoCotizante to set
	 */
	public void setDscSubTipoCotizante(String dscSubTipoCotizante) {
		this.dscSubTipoCotizante = dscSubTipoCotizante;
	}

	/**
	 * Método getter del atributo idSCExtranjeria de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the idSCExtranjeria
	 */
	public Integer getIdSCExtranjeria() {
		return idSCExtranjeria;
	}

	/**
	 * Método setter del atributo idSCExtranjeria de la clase DatosBasicosCotizanteDTO
	 *
	 * @param idSCExtranjeria
	 *            the idSCExtranjeria to set
	 */
	public void setIdSCExtranjeria(Integer idSCExtranjeria) {
		this.idSCExtranjeria = idSCExtranjeria;
	}

	/**
	 * Método getter del atributo codSCExtranjeria de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the codSCExtranjeria
	 */
	public String getCodSCExtranjeria() {
		return codSCExtranjeria;
	}

	/**
	 * Método setter del atributo codSCExtranjeria de la clase DatosBasicosCotizanteDTO
	 *
	 * @param codSCExtranjeria
	 *            the codSCExtranjeria to set
	 */
	public void setCodSCExtranjeria(String codSCExtranjeria) {
		this.codSCExtranjeria = codSCExtranjeria;
	}

	/**
	 * Método getter del atributo fechaColResidenteExterior de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the fechaColResidenteExterior
	 */
	public String getFechaColResidenteExterior() {
		return fechaColResidenteExterior;
	}

	/**
	 * Método setter del atributo fechaColResidenteExterior de la clase DatosBasicosCotizanteDTO
	 *
	 * @param fechaColResidenteExterior
	 *            the fechaColResidenteExterior to set
	 */
	public void setFechaColResidenteExterior(String fechaColResidenteExterior) {
		this.fechaColResidenteExterior = fechaColResidenteExterior;
	}

	/**
	 * Método getter del atributo emailCotizanteParaEnvioSoportes de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the emailCotizanteParaEnvioSoportes
	 */
	public String getEmailCotizanteParaEnvioSoportes() {
		return emailCotizanteParaEnvioSoportes;
	}

	/**
	 * Método setter del atributo emailCotizanteParaEnvioSoportes de la clase DatosBasicosCotizanteDTO
	 *
	 * @param emailCotizanteParaEnvioSoportes
	 *            the emailCotizanteParaEnvioSoportes to set
	 */
	public void setEmailCotizanteParaEnvioSoportes(String emailCotizanteParaEnvioSoportes) {
		this.emailCotizanteParaEnvioSoportes = emailCotizanteParaEnvioSoportes;
	}

	/**
	 * Método getter del atributo idDepartamento de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the idDepartamento
	 */
	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	/**
	 * Método setter del atributo idDepartamento de la clase DatosBasicosCotizanteDTO
	 *
	 * @param idDepartamento
	 *            the idDepartamento to set
	 */
	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	/**
	 * Método getter del atributo codDepartamento de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the codDepartamento
	 */
	public String getCodDepartamento() {
		return codDepartamento;
	}

	/**
	 * Método setter del atributo codDepartamento de la clase DatosBasicosCotizanteDTO
	 *
	 * @param codDepartamento
	 *            the codDepartamento to set
	 */
	public void setCodDepartamento(String codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	/**
	 * Método getter del atributo nombreDepartamento de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the nombreDepartamento
	 */
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	/**
	 * Método setter del atributo nombreDepartamento de la clase DatosBasicosCotizanteDTO
	 *
	 * @param nombreDepartamento
	 *            the nombreDepartamento to set
	 */
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	/**
	 * Método getter del atributo idMunicipio de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the idMunicipio
	 */
	public Integer getIdMunicipio() {
		return idMunicipio;
	}

	/**
	 * Método setter del atributo idMunicipio de la clase DatosBasicosCotizanteDTO
	 *
	 * @param idMunicipio
	 *            the idMunicipio to set
	 */
	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	/**
	 * Método getter del atributo codMunicipio de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the codMunicipio
	 */
	public String getCodMunicipio() {
		return codMunicipio;
	}

	/**
	 * Método setter del atributo codMunicipio de la clase DatosBasicosCotizanteDTO
	 *
	 * @param codMunicipio
	 *            the codMunicipio to set
	 */
	public void setCodMunicipio(String codMunicipio) {
		this.codMunicipio = codMunicipio;
	}

	/**
	 * Método getter del atributo nombreMunicipio de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the nombreMunicipio
	 */
	public String getNombreMunicipio() {
		return nombreMunicipio;
	}

	/**
	 * Método setter del atributo nombreMunicipio de la clase DatosBasicosCotizanteDTO
	 *
	 * @param nombreMunicipio
	 *            the nombreMunicipio to set
	 */
	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}

	/**
	 * Método getter del atributo salario de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the salario
	 */
	public BigDecimal getSalario() {
		return salario;
	}

	/**
	 * Método setter del atributo salario de la clase DatosBasicosCotizanteDTO
	 *
	 * @param salario
	 *            the salario to set
	 */
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	/**
	 * Método getter del atributo salarioIntegral de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the salarioIntegral
	 */
	public Boolean getSalarioIntegral() {
		return salarioIntegral;
	}

	/**
	 * Método setter del atributo salarioIntegral de la clase DatosBasicosCotizanteDTO
	 *
	 * @param salarioIntegral
	 *            the salarioIntegral to set
	 */
	public void setSalarioIntegral(Boolean salarioIntegral) {
		this.salarioIntegral = salarioIntegral;
	}

	/**
	 * Método getter del atributo salarioEfectivo de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the salarioEfectivo
	 */
	public BigDecimal getSalarioEfectivo() {
		return salarioEfectivo;
	}

	/**
	 * Método setter del atributo salarioEfectivo de la clase DatosBasicosCotizanteDTO
	 *
	 * @param salarioEfectivo
	 *            the salarioEfectivo to set
	 */
	public void setSalarioEfectivo(BigDecimal salarioEfectivo) {
		this.salarioEfectivo = salarioEfectivo;
	}

	/**
	 * Método getter del atributo idParametroSMMLV de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the idParametroSMMLV
	 */
	public Integer getIdParametroSMMLV() {
		return idParametroSMMLV;
	}

	/**
	 * Método setter del atributo idParametroSMMLV de la clase DatosBasicosCotizanteDTO
	 *
	 * @param idParametroSMMLV
	 *            the idParametroSMMLV to set
	 */
	public void setIdParametroSMMLV(Integer idParametroSMMLV) {
		this.idParametroSMMLV = idParametroSMMLV;
	}

	/**
	 * Método getter del atributo idTipoIdentificacionPrinc de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the idTipoIdentificacionPrinc
	 */
	public Integer getIdTipoIdentificacionPrinc() {
		return idTipoIdentificacionPrinc;
	}

	/**
	 * Método setter del atributo idTipoIdentificacionPrinc de la clase DatosBasicosCotizanteDTO
	 *
	 * @param idTipoIdentificacionPrinc
	 *            the idTipoIdentificacionPrinc to set
	 */
	public void setIdTipoIdentificacionPrinc(Integer idTipoIdentificacionPrinc) {
		this.idTipoIdentificacionPrinc = idTipoIdentificacionPrinc;
	}

	/**
	 * Método getter del atributo codTipoIdentificacionPrinc de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the codTipoIdentificacionPrinc
	 */
	public String getCodTipoIdentificacionPrinc() {
		return codTipoIdentificacionPrinc;
	}

	/**
	 * Método setter del atributo codTipoIdentificacionPrinc de la clase DatosBasicosCotizanteDTO
	 *
	 * @param codTipoIdentificacionPrinc
	 *            the codTipoIdentificacionPrinc to set
	 */
	public void setCodTipoIdentificacionPrinc(String codTipoIdentificacionPrinc) {
		this.codTipoIdentificacionPrinc = codTipoIdentificacionPrinc;
	}

	/**
	 * Método getter del atributo nombreTipoIdentificacionPrinc de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the nombreTipoIdentificacionPrinc
	 */
	public String getNombreTipoIdentificacionPrinc() {
		return nombreTipoIdentificacionPrinc;
	}

	/**
	 * Método setter del atributo nombreTipoIdentificacionPrinc de la clase DatosBasicosCotizanteDTO
	 *
	 * @param nombreTipoIdentificacionPrinc
	 *            the nombreTipoIdentificacionPrinc to set
	 */
	public void setNombreTipoIdentificacionPrinc(String nombreTipoIdentificacionPrinc) {
		this.nombreTipoIdentificacionPrinc = nombreTipoIdentificacionPrinc;
	}

	/**
	 * Método getter del atributo nroIdentificacionPrinc de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the nroIdentificacionPrinc
	 */
	public String getNroIdentificacionPrinc() {
		return nroIdentificacionPrinc;
	}

	/**
	 * Método setter del atributo nroIdentificacionPrinc de la clase DatosBasicosCotizanteDTO
	 *
	 * @param nroIdentificacionPrinc
	 *            the nroIdentificacionPrinc to set
	 */
	public void setNroIdentificacionPrinc(String nroIdentificacionPrinc) {
		this.nroIdentificacionPrinc = nroIdentificacionPrinc;
	}

	/**
	 * Método getter del atributo cargadoPlanillaPreviaPagada de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the cargadoPlanillaPreviaPagada
	 */
	public Boolean getCargadoPlanillaPreviaPagada() {
		return cargadoPlanillaPreviaPagada;
	}

	/**
	 * Método setter del atributo cargadoPlanillaPreviaPagada de la clase DatosBasicosCotizanteDTO
	 *
	 * @param cargadoPlanillaPreviaPagada
	 *            the cargadoPlanillaPreviaPagada to set
	 */
	public void setCargadoPlanillaPreviaPagada(Boolean cargadoPlanillaPreviaPagada) {
		this.cargadoPlanillaPreviaPagada = cargadoPlanillaPreviaPagada;
	}

	/**
	 * Método getter del atributo smmlv de la clase DatosBasicosCotizanteDTO
	 *
	 * @return the smmlv
	 */
	public BigDecimal getSmmlv() {
		return smmlv;
	}

	/**
	 * Método setter del atributo smmlv de la clase DatosBasicosCotizanteDTO
	 *
	 * @param smmlv
	 *            the smmlv to set
	 */
	public void setSmmlv(BigDecimal smmlv) {
		this.smmlv = smmlv;
	}

}

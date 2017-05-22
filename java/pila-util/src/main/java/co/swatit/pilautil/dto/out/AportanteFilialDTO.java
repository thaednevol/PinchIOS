/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo
 * {@link com.ach.apt.biz.transfer.AportanteFilialDTO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class AportanteFilialDTO implements Serializable {
	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	private Long idSoiFilial;
	private Long idSoiFilialUsuario;
	private Long idSoiAportante;
	private Long idSoiMunicipio;
	private String tipo;
	private Integer vigenteFilial;
	private Integer vigenteFilialUsuario;
	private Integer vigenteDepartamento;
	private Integer vigenteMunicipio;
	private String codigo;
	private String nombre;
	private String codigoMunicipio;
	private String nombreMunicipio;
	private Integer idSoiDepartamento;
	private String codigoDepartamento;
	private String nombreDepartamento;
	private Long idSoiSegUsuario;
	private Boolean esAdministrador;
	private Integer cantPlanillaFilial;
	private String eventoSucursal;

	/**
	 * Método getter del atributo idSoiFilial de la clase AportanteFilial
	 *
	 * @return the idSoiFilial
	 */
	public Long getIdSoiFilial() {
		return idSoiFilial;
	}

	/**
	 * Método setter del atributo idSoiFilial de la clase AportanteFilial
	 *
	 * @param idSoiFilial
	 *            the idSoiFilial to set
	 */
	public void setIdSoiFilial(Long idSoiFilial) {
		this.idSoiFilial = idSoiFilial;
	}

	/**
	 * Método getter del atributo idSoiFilialUsuario de la clase AportanteFilial
	 *
	 * @return the idSoiFilialUsuario
	 */
	public Long getIdSoiFilialUsuario() {
		return idSoiFilialUsuario;
	}

	/**
	 * Método setter del atributo idSoiFilialUsuario de la clase AportanteFilial
	 *
	 * @param idSoiFilialUsuario
	 *            the idSoiFilialUsuario to set
	 */
	public void setIdSoiFilialUsuario(Long idSoiFilialUsuario) {
		this.idSoiFilialUsuario = idSoiFilialUsuario;
	}

	/**
	 * Método getter del atributo idSoiAportante de la clase AportanteFilial
	 *
	 * @return the idSoiAportante
	 */
	public Long getIdSoiAportante() {
		return idSoiAportante;
	}

	/**
	 * Método setter del atributo idSoiAportante de la clase AportanteFilial
	 *
	 * @param idSoiAportante
	 *            the idSoiAportante to set
	 */
	public void setIdSoiAportante(Long idSoiAportante) {
		this.idSoiAportante = idSoiAportante;
	}

	/**
	 * Método getter del atributo idSoiMunicipio de la clase AportanteFilial
	 *
	 * @return the idSoiMunicipio
	 */
	public Long getIdSoiMunicipio() {
		return idSoiMunicipio;
	}

	/**
	 * Método setter del atributo idSoiMunicipio de la clase AportanteFilial
	 *
	 * @param idSoiMunicipio
	 *            the idSoiMunicipio to set
	 */
	public void setIdSoiMunicipio(Long idSoiMunicipio) {
		this.idSoiMunicipio = idSoiMunicipio;
	}

	/**
	 * Método getter del atributo tipo de la clase AportanteFilial
	 *
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Método setter del atributo tipo de la clase AportanteFilial
	 *
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Método getter del atributo vigenteFilial de la clase AportanteFilial
	 *
	 * @return the vigenteFilial
	 */
	public Integer getVigenteFilial() {
		return vigenteFilial;
	}

	/**
	 * Método setter del atributo vigenteFilial de la clase AportanteFilial
	 *
	 * @param vigenteFilial
	 *            the vigenteFilial to set
	 */
	public void setVigenteFilial(Integer vigenteFilial) {
		this.vigenteFilial = vigenteFilial;
	}

	/**
	 * Método getter del atributo vigenteFilialUsuario de la clase AportanteFilial
	 *
	 * @return the vigenteFilialUsuario
	 */
	public Integer getVigenteFilialUsuario() {
		return vigenteFilialUsuario;
	}

	/**
	 * Método setter del atributo vigenteFilialUsuario de la clase AportanteFilial
	 *
	 * @param vigenteFilialUsuario
	 *            the vigenteFilialUsuario to set
	 */
	public void setVigenteFilialUsuario(Integer vigenteFilialUsuario) {
		this.vigenteFilialUsuario = vigenteFilialUsuario;
	}

	/**
	 * Método getter del atributo vigenteDepartamento de la clase AportanteFilial
	 *
	 * @return the vigenteDepartamento
	 */
	public Integer getVigenteDepartamento() {
		return vigenteDepartamento;
	}

	/**
	 * Método setter del atributo vigenteDepartamento de la clase AportanteFilial
	 *
	 * @param vigenteDepartamento
	 *            the vigenteDepartamento to set
	 */
	public void setVigenteDepartamento(Integer vigenteDepartamento) {
		this.vigenteDepartamento = vigenteDepartamento;
	}

	/**
	 * Método getter del atributo vigenteMunicipio de la clase AportanteFilial
	 *
	 * @return the vigenteMunicipio
	 */
	public Integer getVigenteMunicipio() {
		return vigenteMunicipio;
	}

	/**
	 * Método setter del atributo vigenteMunicipio de la clase AportanteFilial
	 *
	 * @param vigenteMunicipio
	 *            the vigenteMunicipio to set
	 */
	public void setVigenteMunicipio(Integer vigenteMunicipio) {
		this.vigenteMunicipio = vigenteMunicipio;
	}

	/**
	 * Método getter del atributo codigo de la clase AportanteFilial
	 *
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Método setter del atributo codigo de la clase AportanteFilial
	 *
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Método getter del atributo nombre de la clase AportanteFilial
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre de la clase AportanteFilial
	 *
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter del atributo codigoMunicipio de la clase AportanteFilial
	 *
	 * @return the codigoMunicipio
	 */
	public String getCodigoMunicipio() {
		return codigoMunicipio;
	}

	/**
	 * Método setter del atributo codigoMunicipio de la clase AportanteFilial
	 *
	 * @param codigoMunicipio
	 *            the codigoMunicipio to set
	 */
	public void setCodigoMunicipio(String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	/**
	 * Método getter del atributo nombreMunicipio de la clase AportanteFilial
	 *
	 * @return the nombreMunicipio
	 */
	public String getNombreMunicipio() {
		return nombreMunicipio;
	}

	/**
	 * Método setter del atributo nombreMunicipio de la clase AportanteFilial
	 *
	 * @param nombreMunicipio
	 *            the nombreMunicipio to set
	 */
	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}

	/**
	 * Método getter del atributo idSoiDepartamento de la clase AportanteFilial
	 *
	 * @return the idSoiDepartamento
	 */
	public Integer getIdSoiDepartamento() {
		return idSoiDepartamento;
	}

	/**
	 * Método setter del atributo idSoiDepartamento de la clase AportanteFilial
	 *
	 * @param idSoiDepartamento
	 *            the idSoiDepartamento to set
	 */
	public void setIdSoiDepartamento(Integer idSoiDepartamento) {
		this.idSoiDepartamento = idSoiDepartamento;
	}

	/**
	 * Método getter del atributo codigoDepartamento de la clase AportanteFilial
	 *
	 * @return the codigoDepartamento
	 */
	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}

	/**
	 * Método setter del atributo codigoDepartamento de la clase AportanteFilial
	 *
	 * @param codigoDepartamento
	 *            the codigoDepartamento to set
	 */
	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	/**
	 * Método getter del atributo nombreDepartamento de la clase AportanteFilial
	 *
	 * @return the nombreDepartamento
	 */
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	/**
	 * Método setter del atributo nombreDepartamento de la clase AportanteFilial
	 *
	 * @param nombreDepartamento
	 *            the nombreDepartamento to set
	 */
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	/**
	 * Método getter del atributo idSoiSegUsuario de la clase AportanteFilial
	 *
	 * @return the idSoiSegUsuario
	 */
	public Long getIdSoiSegUsuario() {
		return idSoiSegUsuario;
	}

	/**
	 * Método setter del atributo idSoiSegUsuario de la clase AportanteFilial
	 *
	 * @param idSoiSegUsuario
	 *            the idSoiSegUsuario to set
	 */
	public void setIdSoiSegUsuario(Long idSoiSegUsuario) {
		this.idSoiSegUsuario = idSoiSegUsuario;
	}

	/**
	 * Método getter del atributo esAdministrador de la clase AportanteFilial
	 *
	 * @return the esAdministrador
	 */
	public Boolean getEsAdministrador() {
		return esAdministrador;
	}

	/**
	 * Método setter del atributo esAdministrador de la clase AportanteFilial
	 *
	 * @param esAdministrador
	 *            the esAdministrador to set
	 */
	public void setEsAdministrador(Boolean esAdministrador) {
		this.esAdministrador = esAdministrador;
	}

	/**
	 * Método getter del atributo cantPlanillaFilial de la clase AportanteFilial
	 *
	 * @return the cantPlanillaFilial
	 */
	public Integer getCantPlanillaFilial() {
		return cantPlanillaFilial;
	}

	/**
	 * Método setter del atributo cantPlanillaFilial de la clase AportanteFilial
	 *
	 * @param cantPlanillaFilial
	 *            the cantPlanillaFilial to set
	 */
	public void setCantPlanillaFilial(Integer cantPlanillaFilial) {
		this.cantPlanillaFilial = cantPlanillaFilial;
	}

	/**
	 * Método getter del atributo eventoSucursal de la clase AportanteFilial
	 *
	 * @return the eventoSucursal
	 */
	public String getEventoSucursal() {
		return eventoSucursal;
	}

	/**
	 * Método setter del atributo eventoSucursal de la clase AportanteFilial
	 *
	 * @param eventoSucursal
	 *            the eventoSucursal to set
	 */
	public void setEventoSucursal(String eventoSucursal) {
		this.eventoSucursal = eventoSucursal;
	}

}

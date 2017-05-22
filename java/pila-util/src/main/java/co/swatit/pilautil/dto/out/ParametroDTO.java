/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link com.ach.cfg.biz.transfer.ParametroDTO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class ParametroDTO implements Serializable {
	/**
	 * Constante de Serialización
	 */
	private static final long serialVersionUID = 1L;
	private Integer idSoiParametro;
	private String causaFinVigencia;
	private String nombre;
	private String valorCadena;
	private BigDecimal valorNumerico;
	private String valorFecha;
	private String valorMostrar;
	private Integer vigente;
	private Integer vigenteValorParametro;
	private Integer aplicaMultiple;
	private Integer claseParametro;
	private String claseParametroMostrar;
	private String fechaInicioVigencia1;
	private String fechaInicioVigencia2;
	private String fechaInicioVigencia;
	private String fechaFinVigencia;
	private String fechaInicioVigenciaValor;
	private String fechaFinVigenciaValor;
	private String descripcion;
	private Integer idSoiValorParametro;
	private String tipoDato;
	private String tipoDatoMostrar;
	private String vigenteValorMostrar;
	private DetalleParametroDTO detalleParametroDTO;
	private ValorParametroDTO valorParametroDTO;
	private Long idSegUsuario;
	private Boolean permiteEdicion;
	private Integer esEditable;
	private Boolean busquedaParCrear;

	/**
	 * Método getter del atributo idSoiParametro de la clase ParametroDTO
	 *
	 * @return the idSoiParametro
	 */
	public Integer getIdSoiParametro() {
		return idSoiParametro;
	}

	/**
	 * Método setter del atributo idSoiParametro de la clase ParametroDTO
	 *
	 * @param idSoiParametro
	 *            the idSoiParametro to set
	 */
	public void setIdSoiParametro(Integer idSoiParametro) {
		this.idSoiParametro = idSoiParametro;
	}

	/**
	 * Método getter del atributo causaFinVigencia de la clase ParametroDTO
	 *
	 * @return the causaFinVigencia
	 */
	public String getCausaFinVigencia() {
		return causaFinVigencia;
	}

	/**
	 * Método setter del atributo causaFinVigencia de la clase ParametroDTO
	 *
	 * @param causaFinVigencia
	 *            the causaFinVigencia to set
	 */
	public void setCausaFinVigencia(String causaFinVigencia) {
		this.causaFinVigencia = causaFinVigencia;
	}

	/**
	 * Método getter del atributo nombre de la clase ParametroDTO
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre de la clase ParametroDTO
	 *
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter del atributo valorCadena de la clase ParametroDTO
	 *
	 * @return the valorCadena
	 */
	public String getValorCadena() {
		return valorCadena;
	}

	/**
	 * Método setter del atributo valorCadena de la clase ParametroDTO
	 *
	 * @param valorCadena
	 *            the valorCadena to set
	 */
	public void setValorCadena(String valorCadena) {
		this.valorCadena = valorCadena;
	}

	/**
	 * Método getter del atributo valorNumerico de la clase ParametroDTO
	 *
	 * @return the valorNumerico
	 */
	public BigDecimal getValorNumerico() {
		return valorNumerico;
	}

	/**
	 * Método setter del atributo valorNumerico de la clase ParametroDTO
	 *
	 * @param valorNumerico
	 *            the valorNumerico to set
	 */
	public void setValorNumerico(BigDecimal valorNumerico) {
		this.valorNumerico = valorNumerico;
	}

	/**
	 * Método getter del atributo valorFecha de la clase ParametroDTO
	 *
	 * @return the valorFecha
	 */
	public String getValorFecha() {
		return valorFecha;
	}

	/**
	 * Método setter del atributo valorFecha de la clase ParametroDTO
	 *
	 * @param valorFecha
	 *            the valorFecha to set
	 */
	public void setValorFecha(String valorFecha) {
		this.valorFecha = valorFecha;
	}

	/**
	 * Método getter del atributo valorMostrar de la clase ParametroDTO
	 *
	 * @return the valorMostrar
	 */
	public String getValorMostrar() {
		return valorMostrar;
	}

	/**
	 * Método setter del atributo valorMostrar de la clase ParametroDTO
	 *
	 * @param valorMostrar
	 *            the valorMostrar to set
	 */
	public void setValorMostrar(String valorMostrar) {
		this.valorMostrar = valorMostrar;
	}

	/**
	 * Método getter del atributo vigente de la clase ParametroDTO
	 *
	 * @return the vigente
	 */
	public Integer getVigente() {
		return vigente;
	}

	/**
	 * Método setter del atributo vigente de la clase ParametroDTO
	 *
	 * @param vigente
	 *            the vigente to set
	 */
	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}

	/**
	 * Método getter del atributo vigenteValorParametro de la clase ParametroDTO
	 *
	 * @return the vigenteValorParametro
	 */
	public Integer getVigenteValorParametro() {
		return vigenteValorParametro;
	}

	/**
	 * Método setter del atributo vigenteValorParametro de la clase ParametroDTO
	 *
	 * @param vigenteValorParametro
	 *            the vigenteValorParametro to set
	 */
	public void setVigenteValorParametro(Integer vigenteValorParametro) {
		this.vigenteValorParametro = vigenteValorParametro;
	}

	/**
	 * Método getter del atributo aplicaMultiple de la clase ParametroDTO
	 *
	 * @return the aplicaMultiple
	 */
	public Integer getAplicaMultiple() {
		return aplicaMultiple;
	}

	/**
	 * Método setter del atributo aplicaMultiple de la clase ParametroDTO
	 *
	 * @param aplicaMultiple
	 *            the aplicaMultiple to set
	 */
	public void setAplicaMultiple(Integer aplicaMultiple) {
		this.aplicaMultiple = aplicaMultiple;
	}

	/**
	 * Método getter del atributo claseParametro de la clase ParametroDTO
	 *
	 * @return the claseParametro
	 */
	public Integer getClaseParametro() {
		return claseParametro;
	}

	/**
	 * Método setter del atributo claseParametro de la clase ParametroDTO
	 *
	 * @param claseParametro
	 *            the claseParametro to set
	 */
	public void setClaseParametro(Integer claseParametro) {
		this.claseParametro = claseParametro;
	}

	/**
	 * Método getter del atributo claseParametroMostrar de la clase ParametroDTO
	 *
	 * @return the claseParametroMostrar
	 */
	public String getClaseParametroMostrar() {
		return claseParametroMostrar;
	}

	/**
	 * Método setter del atributo claseParametroMostrar de la clase ParametroDTO
	 *
	 * @param claseParametroMostrar
	 *            the claseParametroMostrar to set
	 */
	public void setClaseParametroMostrar(String claseParametroMostrar) {
		this.claseParametroMostrar = claseParametroMostrar;
	}

	/**
	 * Método getter del atributo fechaInicioVigencia1 de la clase ParametroDTO
	 *
	 * @return the fechaInicioVigencia1
	 */
	public String getFechaInicioVigencia1() {
		return fechaInicioVigencia1;
	}

	/**
	 * Método setter del atributo fechaInicioVigencia1 de la clase ParametroDTO
	 *
	 * @param fechaInicioVigencia1
	 *            the fechaInicioVigencia1 to set
	 */
	public void setFechaInicioVigencia1(String fechaInicioVigencia1) {
		this.fechaInicioVigencia1 = fechaInicioVigencia1;
	}

	/**
	 * Método getter del atributo fechaInicioVigencia2 de la clase ParametroDTO
	 *
	 * @return the fechaInicioVigencia2
	 */
	public String getFechaInicioVigencia2() {
		return fechaInicioVigencia2;
	}

	/**
	 * Método setter del atributo fechaInicioVigencia2 de la clase ParametroDTO
	 *
	 * @param fechaInicioVigencia2
	 *            the fechaInicioVigencia2 to set
	 */
	public void setFechaInicioVigencia2(String fechaInicioVigencia2) {
		this.fechaInicioVigencia2 = fechaInicioVigencia2;
	}

	/**
	 * Método getter del atributo fechaInicioVigencia de la clase ParametroDTO
	 *
	 * @return the fechaInicioVigencia
	 */
	public String getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	/**
	 * Método setter del atributo fechaInicioVigencia de la clase ParametroDTO
	 *
	 * @param fechaInicioVigencia
	 *            the fechaInicioVigencia to set
	 */
	public void setFechaInicioVigencia(String fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	/**
	 * Método getter del atributo fechaFinVigencia de la clase ParametroDTO
	 *
	 * @return the fechaFinVigencia
	 */
	public String getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	/**
	 * Método setter del atributo fechaFinVigencia de la clase ParametroDTO
	 *
	 * @param fechaFinVigencia
	 *            the fechaFinVigencia to set
	 */
	public void setFechaFinVigencia(String fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	/**
	 * Método getter del atributo fechaInicioVigenciaValor de la clase ParametroDTO
	 *
	 * @return the fechaInicioVigenciaValor
	 */
	public String getFechaInicioVigenciaValor() {
		return fechaInicioVigenciaValor;
	}

	/**
	 * Método setter del atributo fechaInicioVigenciaValor de la clase ParametroDTO
	 *
	 * @param fechaInicioVigenciaValor
	 *            the fechaInicioVigenciaValor to set
	 */
	public void setFechaInicioVigenciaValor(String fechaInicioVigenciaValor) {
		this.fechaInicioVigenciaValor = fechaInicioVigenciaValor;
	}

	/**
	 * Método getter del atributo fechaFinVigenciaValor de la clase ParametroDTO
	 *
	 * @return the fechaFinVigenciaValor
	 */
	public String getFechaFinVigenciaValor() {
		return fechaFinVigenciaValor;
	}

	/**
	 * Método setter del atributo fechaFinVigenciaValor de la clase ParametroDTO
	 *
	 * @param fechaFinVigenciaValor
	 *            the fechaFinVigenciaValor to set
	 */
	public void setFechaFinVigenciaValor(String fechaFinVigenciaValor) {
		this.fechaFinVigenciaValor = fechaFinVigenciaValor;
	}

	/**
	 * Método getter del atributo descripcion de la clase ParametroDTO
	 *
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Método setter del atributo descripcion de la clase ParametroDTO
	 *
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Método getter del atributo idSoiValorParametro de la clase ParametroDTO
	 *
	 * @return the idSoiValorParametro
	 */
	public Integer getIdSoiValorParametro() {
		return idSoiValorParametro;
	}

	/**
	 * Método setter del atributo idSoiValorParametro de la clase ParametroDTO
	 *
	 * @param idSoiValorParametro
	 *            the idSoiValorParametro to set
	 */
	public void setIdSoiValorParametro(Integer idSoiValorParametro) {
		this.idSoiValorParametro = idSoiValorParametro;
	}

	/**
	 * Método getter del atributo tipoDato de la clase ParametroDTO
	 *
	 * @return the tipoDato
	 */
	public String getTipoDato() {
		return tipoDato;
	}

	/**
	 * Método setter del atributo tipoDato de la clase ParametroDTO
	 *
	 * @param tipoDato
	 *            the tipoDato to set
	 */
	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}

	/**
	 * Método getter del atributo tipoDatoMostrar de la clase ParametroDTO
	 *
	 * @return the tipoDatoMostrar
	 */
	public String getTipoDatoMostrar() {
		return tipoDatoMostrar;
	}

	/**
	 * Método setter del atributo tipoDatoMostrar de la clase ParametroDTO
	 *
	 * @param tipoDatoMostrar
	 *            the tipoDatoMostrar to set
	 */
	public void setTipoDatoMostrar(String tipoDatoMostrar) {
		this.tipoDatoMostrar = tipoDatoMostrar;
	}

	/**
	 * Método getter del atributo vigenteValorMostrar de la clase ParametroDTO
	 *
	 * @return the vigenteValorMostrar
	 */
	public String getVigenteValorMostrar() {
		return vigenteValorMostrar;
	}

	/**
	 * Método setter del atributo vigenteValorMostrar de la clase ParametroDTO
	 *
	 * @param vigenteValorMostrar
	 *            the vigenteValorMostrar to set
	 */
	public void setVigenteValorMostrar(String vigenteValorMostrar) {
		this.vigenteValorMostrar = vigenteValorMostrar;
	}

	/**
	 * Método getter del atributo detalleParametroDTO de la clase ParametroDTO
	 *
	 * @return the detalleParametroDTO
	 */
	public DetalleParametroDTO getDetalleParametroDTO() {
		return detalleParametroDTO;
	}

	/**
	 * Método setter del atributo detalleParametroDTO de la clase ParametroDTO
	 *
	 * @param detalleParametroDTO
	 *            the detalleParametroDTO to set
	 */
	public void setDetalleParametroDTO(DetalleParametroDTO detalleParametroDTO) {
		this.detalleParametroDTO = detalleParametroDTO;
	}

	/**
	 * Método getter del atributo valorParametroDTO de la clase ParametroDTO
	 *
	 * @return the valorParametroDTO
	 */
	public ValorParametroDTO getValorParametroDTO() {
		return valorParametroDTO;
	}

	/**
	 * Método setter del atributo valorParametroDTO de la clase ParametroDTO
	 *
	 * @param valorParametroDTO
	 *            the valorParametroDTO to set
	 */
	public void setValorParametroDTO(ValorParametroDTO valorParametroDTO) {
		this.valorParametroDTO = valorParametroDTO;
	}

	/**
	 * Método getter del atributo idSegUsuario de la clase ParametroDTO
	 *
	 * @return the idSegUsuario
	 */
	public Long getIdSegUsuario() {
		return idSegUsuario;
	}

	/**
	 * Método setter del atributo idSegUsuario de la clase ParametroDTO
	 *
	 * @param idSegUsuario
	 *            the idSegUsuario to set
	 */
	public void setIdSegUsuario(Long idSegUsuario) {
		this.idSegUsuario = idSegUsuario;
	}

	/**
	 * Método getter del atributo permiteEdicion de la clase ParametroDTO
	 *
	 * @return the permiteEdicion
	 */
	public Boolean isPermiteEdicion() {
		return permiteEdicion;
	}

	/**
	 * Método setter del atributo permiteEdicion de la clase ParametroDTO
	 *
	 * @param permiteEdicion
	 *            the permiteEdicion to set
	 */
	public void setPermiteEdicion(Boolean permiteEdicion) {
		this.permiteEdicion = permiteEdicion;
	}

	/**
	 * Método getter del atributo esEditable de la clase ParametroDTO
	 *
	 * @return the esEditable
	 */
	public Integer getEsEditable() {
		return esEditable;
	}

	/**
	 * Método setter del atributo esEditable de la clase ParametroDTO
	 *
	 * @param esEditable
	 *            the esEditable to set
	 */
	public void setEsEditable(Integer esEditable) {
		this.esEditable = esEditable;
	}

	/**
	 * Método getter del atributo busquedaParCrear de la clase ParametroDTO
	 *
	 * @return the busquedaParCrear
	 */
	public Boolean isBusquedaParCrear() {
		return busquedaParCrear;
	}

	/**
	 * Método setter del atributo busquedaParCrear de la clase ParametroDTO
	 *
	 * @param busquedaParCrear
	 *            the busquedaParCrear to set
	 */
	public void setBusquedaParCrear(Boolean busquedaParCrear) {
		this.busquedaParCrear = busquedaParCrear;
	}

}

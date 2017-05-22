/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo
 * {@link com.ach.pla.biz.transfer.ResultadoValidacionBduaDTO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 7/04/2017
 * @version 1.0
 */
public class ResultadoValidacionBduaDTO implements Serializable {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;

	private Long valorUpc;
	private String tipoAfiliado;
	private String fechaAfiliacionEps;
	private String segundoNombre;
	private String primerNombre;
	private String segundoApellido;
	private String primerApellido;
	private String codigoEps;
	private String serial;
	private String numeroIdentificacion;
	private String codTpIdentificacion;
	private String codigoAfp;
	private String fechaAfiliacionAfp;
	private Long idSoiBduaNsoi;
	private Boolean presentaDiferenciaNombres;
	private Boolean presentaDiferenciaCodEps;
	private Boolean presentaDiferenciaCodAfp;
	private Boolean presentaDiferenciaPrimerNombre;
	private Boolean presentaDiferenciaSegundoNombre;
	private Boolean presentaDiferenciaPrimerApellido;
	private Boolean presentaDiferenciaSegundoApellido;
	private Boolean presentaDiferenciaValorUpc;
	private Boolean presentaValorUpcInvalido;
	private Boolean presentaFechaAfiliacionMayor;
	private Boolean noExisteConfigRuaf;
	private Boolean presentaDiferenciaCodAfpVigente;
	private String nombreEpsBdua;
	private String nombreAfpBdua;
	private String codigoAfpReportada;
	private Long coincidencia;
	private Boolean presentaPeriodoSaludActual;
	private Boolean presentaPeriodoMayorAFP;

	/**
	 * Método getter del atributo valorUpc de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the valorUpc
	 */
	public Long getValorUpc() {
		return valorUpc;
	}

	/**
	 * Método setter del atributo valorUpc de la clase ResultadoValidacionBduaDTO
	 *
	 * @param valorUpc
	 *            the valorUpc to set
	 */
	public void setValorUpc(Long valorUpc) {
		this.valorUpc = valorUpc;
	}

	/**
	 * Método getter del atributo tipoAfiliado de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the tipoAfiliado
	 */
	public String getTipoAfiliado() {
		return tipoAfiliado;
	}

	/**
	 * Método setter del atributo tipoAfiliado de la clase ResultadoValidacionBduaDTO
	 *
	 * @param tipoAfiliado
	 *            the tipoAfiliado to set
	 */
	public void setTipoAfiliado(String tipoAfiliado) {
		this.tipoAfiliado = tipoAfiliado;
	}

	/**
	 * Método getter del atributo fechaAfiliacionEps de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the fechaAfiliacionEps
	 */
	public String getFechaAfiliacionEps() {
		return fechaAfiliacionEps;
	}

	/**
	 * Método setter del atributo fechaAfiliacionEps de la clase ResultadoValidacionBduaDTO
	 *
	 * @param fechaAfiliacionEps
	 *            the fechaAfiliacionEps to set
	 */
	public void setFechaAfiliacionEps(String fechaAfiliacionEps) {
		this.fechaAfiliacionEps = fechaAfiliacionEps;
	}

	/**
	 * Método getter del atributo segundoNombre de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the segundoNombre
	 */
	public String getSegundoNombre() {
		return segundoNombre;
	}

	/**
	 * Método setter del atributo segundoNombre de la clase ResultadoValidacionBduaDTO
	 *
	 * @param segundoNombre
	 *            the segundoNombre to set
	 */
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	/**
	 * Método getter del atributo primerNombre de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the primerNombre
	 */
	public String getPrimerNombre() {
		return primerNombre;
	}

	/**
	 * Método setter del atributo primerNombre de la clase ResultadoValidacionBduaDTO
	 *
	 * @param primerNombre
	 *            the primerNombre to set
	 */
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	/**
	 * Método getter del atributo segundoApellido de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the segundoApellido
	 */
	public String getSegundoApellido() {
		return segundoApellido;
	}

	/**
	 * Método setter del atributo segundoApellido de la clase ResultadoValidacionBduaDTO
	 *
	 * @param segundoApellido
	 *            the segundoApellido to set
	 */
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	/**
	 * Método getter del atributo primerApellido de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the primerApellido
	 */
	public String getPrimerApellido() {
		return primerApellido;
	}

	/**
	 * Método setter del atributo primerApellido de la clase ResultadoValidacionBduaDTO
	 *
	 * @param primerApellido
	 *            the primerApellido to set
	 */
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	/**
	 * Método getter del atributo codigoEps de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the codigoEps
	 */
	public String getCodigoEps() {
		return codigoEps;
	}

	/**
	 * Método setter del atributo codigoEps de la clase ResultadoValidacionBduaDTO
	 *
	 * @param codigoEps
	 *            the codigoEps to set
	 */
	public void setCodigoEps(String codigoEps) {
		this.codigoEps = codigoEps;
	}

	/**
	 * Método getter del atributo serial de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the serial
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * Método setter del atributo serial de la clase ResultadoValidacionBduaDTO
	 *
	 * @param serial
	 *            the serial to set
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	/**
	 * Método getter del atributo numeroIdentificacion de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the numeroIdentificacion
	 */
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	/**
	 * Método setter del atributo numeroIdentificacion de la clase ResultadoValidacionBduaDTO
	 *
	 * @param numeroIdentificacion
	 *            the numeroIdentificacion to set
	 */
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	/**
	 * Método getter del atributo codTpIdentificacion de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the codTpIdentificacion
	 */
	public String getCodTpIdentificacion() {
		return codTpIdentificacion;
	}

	/**
	 * Método setter del atributo codTpIdentificacion de la clase ResultadoValidacionBduaDTO
	 *
	 * @param codTpIdentificacion
	 *            the codTpIdentificacion to set
	 */
	public void setCodTpIdentificacion(String codTpIdentificacion) {
		this.codTpIdentificacion = codTpIdentificacion;
	}

	/**
	 * Método getter del atributo codigoAfp de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the codigoAfp
	 */
	public String getCodigoAfp() {
		return codigoAfp;
	}

	/**
	 * Método setter del atributo codigoAfp de la clase ResultadoValidacionBduaDTO
	 *
	 * @param codigoAfp
	 *            the codigoAfp to set
	 */
	public void setCodigoAfp(String codigoAfp) {
		this.codigoAfp = codigoAfp;
	}

	/**
	 * Método getter del atributo fechaAfiliacionAfp de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the fechaAfiliacionAfp
	 */
	public String getFechaAfiliacionAfp() {
		return fechaAfiliacionAfp;
	}

	/**
	 * Método setter del atributo fechaAfiliacionAfp de la clase ResultadoValidacionBduaDTO
	 *
	 * @param fechaAfiliacionAfp
	 *            the fechaAfiliacionAfp to set
	 */
	public void setFechaAfiliacionAfp(String fechaAfiliacionAfp) {
		this.fechaAfiliacionAfp = fechaAfiliacionAfp;
	}

	/**
	 * Método getter del atributo idSoiBduaNsoi de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the idSoiBduaNsoi
	 */
	public Long getIdSoiBduaNsoi() {
		return idSoiBduaNsoi;
	}

	/**
	 * Método setter del atributo idSoiBduaNsoi de la clase ResultadoValidacionBduaDTO
	 *
	 * @param idSoiBduaNsoi
	 *            the idSoiBduaNsoi to set
	 */
	public void setIdSoiBduaNsoi(Long idSoiBduaNsoi) {
		this.idSoiBduaNsoi = idSoiBduaNsoi;
	}

	/**
	 * Método getter del atributo presentaDiferenciaNombres de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the presentaDiferenciaNombres
	 */
	public Boolean getPresentaDiferenciaNombres() {
		return presentaDiferenciaNombres;
	}

	/**
	 * Método setter del atributo presentaDiferenciaNombres de la clase ResultadoValidacionBduaDTO
	 *
	 * @param presentaDiferenciaNombres
	 *            the presentaDiferenciaNombres to set
	 */
	public void setPresentaDiferenciaNombres(Boolean presentaDiferenciaNombres) {
		this.presentaDiferenciaNombres = presentaDiferenciaNombres;
	}

	/**
	 * Método getter del atributo presentaDiferenciaCodEps de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the presentaDiferenciaCodEps
	 */
	public Boolean getPresentaDiferenciaCodEps() {
		return presentaDiferenciaCodEps;
	}

	/**
	 * Método setter del atributo presentaDiferenciaCodEps de la clase ResultadoValidacionBduaDTO
	 *
	 * @param presentaDiferenciaCodEps
	 *            the presentaDiferenciaCodEps to set
	 */
	public void setPresentaDiferenciaCodEps(Boolean presentaDiferenciaCodEps) {
		this.presentaDiferenciaCodEps = presentaDiferenciaCodEps;
	}

	/**
	 * Método getter del atributo presentaDiferenciaCodAfp de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the presentaDiferenciaCodAfp
	 */
	public Boolean getPresentaDiferenciaCodAfp() {
		return presentaDiferenciaCodAfp;
	}

	/**
	 * Método setter del atributo presentaDiferenciaCodAfp de la clase ResultadoValidacionBduaDTO
	 *
	 * @param presentaDiferenciaCodAfp
	 *            the presentaDiferenciaCodAfp to set
	 */
	public void setPresentaDiferenciaCodAfp(Boolean presentaDiferenciaCodAfp) {
		this.presentaDiferenciaCodAfp = presentaDiferenciaCodAfp;
	}

	/**
	 * Método getter del atributo presentaDiferenciaPrimerNombre de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the presentaDiferenciaPrimerNombre
	 */
	public Boolean getPresentaDiferenciaPrimerNombre() {
		return presentaDiferenciaPrimerNombre;
	}

	/**
	 * Método setter del atributo presentaDiferenciaPrimerNombre de la clase ResultadoValidacionBduaDTO
	 *
	 * @param presentaDiferenciaPrimerNombre
	 *            the presentaDiferenciaPrimerNombre to set
	 */
	public void setPresentaDiferenciaPrimerNombre(Boolean presentaDiferenciaPrimerNombre) {
		this.presentaDiferenciaPrimerNombre = presentaDiferenciaPrimerNombre;
	}

	/**
	 * Método getter del atributo presentaDiferenciaSegundoNombre de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the presentaDiferenciaSegundoNombre
	 */
	public Boolean getPresentaDiferenciaSegundoNombre() {
		return presentaDiferenciaSegundoNombre;
	}

	/**
	 * Método setter del atributo presentaDiferenciaSegundoNombre de la clase ResultadoValidacionBduaDTO
	 *
	 * @param presentaDiferenciaSegundoNombre
	 *            the presentaDiferenciaSegundoNombre to set
	 */
	public void setPresentaDiferenciaSegundoNombre(Boolean presentaDiferenciaSegundoNombre) {
		this.presentaDiferenciaSegundoNombre = presentaDiferenciaSegundoNombre;
	}

	/**
	 * Método getter del atributo presentaDiferenciaPrimerApellido de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the presentaDiferenciaPrimerApellido
	 */
	public Boolean getPresentaDiferenciaPrimerApellido() {
		return presentaDiferenciaPrimerApellido;
	}

	/**
	 * Método setter del atributo presentaDiferenciaPrimerApellido de la clase ResultadoValidacionBduaDTO
	 *
	 * @param presentaDiferenciaPrimerApellido
	 *            the presentaDiferenciaPrimerApellido to set
	 */
	public void setPresentaDiferenciaPrimerApellido(Boolean presentaDiferenciaPrimerApellido) {
		this.presentaDiferenciaPrimerApellido = presentaDiferenciaPrimerApellido;
	}

	/**
	 * Método getter del atributo presentaDiferenciaSegundoApellido de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the presentaDiferenciaSegundoApellido
	 */
	public Boolean getPresentaDiferenciaSegundoApellido() {
		return presentaDiferenciaSegundoApellido;
	}

	/**
	 * Método setter del atributo presentaDiferenciaSegundoApellido de la clase ResultadoValidacionBduaDTO
	 *
	 * @param presentaDiferenciaSegundoApellido
	 *            the presentaDiferenciaSegundoApellido to set
	 */
	public void setPresentaDiferenciaSegundoApellido(Boolean presentaDiferenciaSegundoApellido) {
		this.presentaDiferenciaSegundoApellido = presentaDiferenciaSegundoApellido;
	}

	/**
	 * Método getter del atributo presentaDiferenciaValorUpc de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the presentaDiferenciaValorUpc
	 */
	public Boolean getPresentaDiferenciaValorUpc() {
		return presentaDiferenciaValorUpc;
	}

	/**
	 * Método setter del atributo presentaDiferenciaValorUpc de la clase ResultadoValidacionBduaDTO
	 *
	 * @param presentaDiferenciaValorUpc
	 *            the presentaDiferenciaValorUpc to set
	 */
	public void setPresentaDiferenciaValorUpc(Boolean presentaDiferenciaValorUpc) {
		this.presentaDiferenciaValorUpc = presentaDiferenciaValorUpc;
	}

	/**
	 * Método getter del atributo presentaValorUpcInvalido de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the presentaValorUpcInvalido
	 */
	public Boolean getPresentaValorUpcInvalido() {
		return presentaValorUpcInvalido;
	}

	/**
	 * Método setter del atributo presentaValorUpcInvalido de la clase ResultadoValidacionBduaDTO
	 *
	 * @param presentaValorUpcInvalido
	 *            the presentaValorUpcInvalido to set
	 */
	public void setPresentaValorUpcInvalido(Boolean presentaValorUpcInvalido) {
		this.presentaValorUpcInvalido = presentaValorUpcInvalido;
	}

	/**
	 * Método getter del atributo presentaFechaAfiliacionMayor de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the presentaFechaAfiliacionMayor
	 */
	public Boolean getPresentaFechaAfiliacionMayor() {
		return presentaFechaAfiliacionMayor;
	}

	/**
	 * Método setter del atributo presentaFechaAfiliacionMayor de la clase ResultadoValidacionBduaDTO
	 *
	 * @param presentaFechaAfiliacionMayor
	 *            the presentaFechaAfiliacionMayor to set
	 */
	public void setPresentaFechaAfiliacionMayor(Boolean presentaFechaAfiliacionMayor) {
		this.presentaFechaAfiliacionMayor = presentaFechaAfiliacionMayor;
	}

	/**
	 * Método getter del atributo noExisteConfigRuaf de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the noExisteConfigRuaf
	 */
	public Boolean getNoExisteConfigRuaf() {
		return noExisteConfigRuaf;
	}

	/**
	 * Método setter del atributo noExisteConfigRuaf de la clase ResultadoValidacionBduaDTO
	 *
	 * @param noExisteConfigRuaf
	 *            the noExisteConfigRuaf to set
	 */
	public void setNoExisteConfigRuaf(Boolean noExisteConfigRuaf) {
		this.noExisteConfigRuaf = noExisteConfigRuaf;
	}

	/**
	 * Método getter del atributo presentaDiferenciaCodAfpVigente de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the presentaDiferenciaCodAfpVigente
	 */
	public Boolean getPresentaDiferenciaCodAfpVigente() {
		return presentaDiferenciaCodAfpVigente;
	}

	/**
	 * Método setter del atributo presentaDiferenciaCodAfpVigente de la clase ResultadoValidacionBduaDTO
	 *
	 * @param presentaDiferenciaCodAfpVigente
	 *            the presentaDiferenciaCodAfpVigente to set
	 */
	public void setPresentaDiferenciaCodAfpVigente(Boolean presentaDiferenciaCodAfpVigente) {
		this.presentaDiferenciaCodAfpVigente = presentaDiferenciaCodAfpVigente;
	}

	/**
	 * Método getter del atributo nombreEpsBdua de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the nombreEpsBdua
	 */
	public String getNombreEpsBdua() {
		return nombreEpsBdua;
	}

	/**
	 * Método setter del atributo nombreEpsBdua de la clase ResultadoValidacionBduaDTO
	 *
	 * @param nombreEpsBdua
	 *            the nombreEpsBdua to set
	 */
	public void setNombreEpsBdua(String nombreEpsBdua) {
		this.nombreEpsBdua = nombreEpsBdua;
	}

	/**
	 * Método getter del atributo nombreAfpBdua de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the nombreAfpBdua
	 */
	public String getNombreAfpBdua() {
		return nombreAfpBdua;
	}

	/**
	 * Método setter del atributo nombreAfpBdua de la clase ResultadoValidacionBduaDTO
	 *
	 * @param nombreAfpBdua
	 *            the nombreAfpBdua to set
	 */
	public void setNombreAfpBdua(String nombreAfpBdua) {
		this.nombreAfpBdua = nombreAfpBdua;
	}

	/**
	 * Método getter del atributo codigoAfpReportada de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the codigoAfpReportada
	 */
	public String getCodigoAfpReportada() {
		return codigoAfpReportada;
	}

	/**
	 * Método setter del atributo codigoAfpReportada de la clase ResultadoValidacionBduaDTO
	 *
	 * @param codigoAfpReportada
	 *            the codigoAfpReportada to set
	 */
	public void setCodigoAfpReportada(String codigoAfpReportada) {
		this.codigoAfpReportada = codigoAfpReportada;
	}

	/**
	 * Método getter del atributo coincidencia de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the coincidencia
	 */
	public Long getCoincidencia() {
		return coincidencia;
	}

	/**
	 * Método setter del atributo coincidencia de la clase ResultadoValidacionBduaDTO
	 *
	 * @param coincidencia
	 *            the coincidencia to set
	 */
	public void setCoincidencia(Long coincidencia) {
		this.coincidencia = coincidencia;
	}

	/**
	 * Método getter del atributo presentaPeriodoSaludActual de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the presentaPeriodoSaludActual
	 */
	public Boolean getPresentaPeriodoSaludActual() {
		return presentaPeriodoSaludActual;
	}

	/**
	 * Método setter del atributo presentaPeriodoSaludActual de la clase ResultadoValidacionBduaDTO
	 *
	 * @param presentaPeriodoSaludActual
	 *            the presentaPeriodoSaludActual to set
	 */
	public void setPresentaPeriodoSaludActual(Boolean presentaPeriodoSaludActual) {
		this.presentaPeriodoSaludActual = presentaPeriodoSaludActual;
	}

	/**
	 * Método getter del atributo presentaPeriodoMayorAFP de la clase ResultadoValidacionBduaDTO
	 *
	 * @return the presentaPeriodoMayorAFP
	 */
	public Boolean getPresentaPeriodoMayorAFP() {
		return presentaPeriodoMayorAFP;
	}

	/**
	 * Método setter del atributo presentaPeriodoMayorAFP de la clase ResultadoValidacionBduaDTO
	 *
	 * @param presentaPeriodoMayorAFP
	 *            the presentaPeriodoMayorAFP to set
	 */
	public void setPresentaPeriodoMayorAFP(Boolean presentaPeriodoMayorAFP) {
		this.presentaPeriodoMayorAFP = presentaPeriodoMayorAFP;
	}

}

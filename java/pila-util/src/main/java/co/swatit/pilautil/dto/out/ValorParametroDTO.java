/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;
import java.math.BigDecimal;

import com.ach.cfg.biz.model.ValorParametroVO;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link ValorParametroVO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class ValorParametroDTO implements Serializable {
	/**
	 * Constante de serialización
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
	private Integer vigente;
	private String fechaInicioVigencia;
	private String valorCadena;
	private String valorFecha;
	private BigDecimal valorNumerico;
	private Integer idSoiParametro;
	private Integer idSoiValorParametro;

	/**
	 * Método getter del atributo ipModificacion de la clase ValorParametroDTO
	 *
	 * @return the ipModificacion
	 */
	public String getIpModificacion() {
		return ipModificacion;
	}

	/**
	 * Método setter del atributo ipModificacion de la clase ValorParametroDTO
	 *
	 * @param ipModificacion
	 *            the ipModificacion to set
	 */
	public void setIpModificacion(String ipModificacion) {
		this.ipModificacion = ipModificacion;
	}

	/**
	 * Método getter del atributo fechaModificacion de la clase ValorParametroDTO
	 *
	 * @return the fechaModificacion
	 */
	public String getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * Método setter del atributo fechaModificacion de la clase ValorParametroDTO
	 *
	 * @param fechaModificacion
	 *            the fechaModificacion to set
	 */
	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * Método getter del atributo usuarioModificacion de la clase ValorParametroDTO
	 *
	 * @return the usuarioModificacion
	 */
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	/**
	 * Método setter del atributo usuarioModificacion de la clase ValorParametroDTO
	 *
	 * @param usuarioModificacion
	 *            the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	/**
	 * Método getter del atributo ipCreacion de la clase ValorParametroDTO
	 *
	 * @return the ipCreacion
	 */
	public String getIpCreacion() {
		return ipCreacion;
	}

	/**
	 * Método setter del atributo ipCreacion de la clase ValorParametroDTO
	 *
	 * @param ipCreacion
	 *            the ipCreacion to set
	 */
	public void setIpCreacion(String ipCreacion) {
		this.ipCreacion = ipCreacion;
	}

	/**
	 * Método getter del atributo fechaCreacion de la clase ValorParametroDTO
	 *
	 * @return the fechaCreacion
	 */
	public String getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Método setter del atributo fechaCreacion de la clase ValorParametroDTO
	 *
	 * @param fechaCreacion
	 *            the fechaCreacion to set
	 */
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Método getter del atributo usuarioCreacion de la clase ValorParametroDTO
	 *
	 * @return the usuarioCreacion
	 */
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	/**
	 * Método setter del atributo usuarioCreacion de la clase ValorParametroDTO
	 *
	 * @param usuarioCreacion
	 *            the usuarioCreacion to set
	 */
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	/**
	 * Método getter del atributo causaFinVigencia de la clase ValorParametroDTO
	 *
	 * @return the causaFinVigencia
	 */
	public String getCausaFinVigencia() {
		return causaFinVigencia;
	}

	/**
	 * Método setter del atributo causaFinVigencia de la clase ValorParametroDTO
	 *
	 * @param causaFinVigencia
	 *            the causaFinVigencia to set
	 */
	public void setCausaFinVigencia(String causaFinVigencia) {
		this.causaFinVigencia = causaFinVigencia;
	}

	/**
	 * Método getter del atributo fechaFinVigencia de la clase ValorParametroDTO
	 *
	 * @return the fechaFinVigencia
	 */
	public String getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	/**
	 * Método setter del atributo fechaFinVigencia de la clase ValorParametroDTO
	 *
	 * @param fechaFinVigencia
	 *            the fechaFinVigencia to set
	 */
	public void setFechaFinVigencia(String fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	/**
	 * Método getter del atributo vigente de la clase ValorParametroDTO
	 *
	 * @return the vigente
	 */
	public Integer getVigente() {
		return vigente;
	}

	/**
	 * Método setter del atributo vigente de la clase ValorParametroDTO
	 *
	 * @param vigente
	 *            the vigente to set
	 */
	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}

	/**
	 * Método getter del atributo fechaInicioVigencia de la clase ValorParametroDTO
	 *
	 * @return the fechaInicioVigencia
	 */
	public String getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	/**
	 * Método setter del atributo fechaInicioVigencia de la clase ValorParametroDTO
	 *
	 * @param fechaInicioVigencia
	 *            the fechaInicioVigencia to set
	 */
	public void setFechaInicioVigencia(String fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	/**
	 * Método getter del atributo valorCadena de la clase ValorParametroDTO
	 *
	 * @return the valorCadena
	 */
	public String getValorCadena() {
		return valorCadena;
	}

	/**
	 * Método setter del atributo valorCadena de la clase ValorParametroDTO
	 *
	 * @param valorCadena
	 *            the valorCadena to set
	 */
	public void setValorCadena(String valorCadena) {
		this.valorCadena = valorCadena;
	}

	/**
	 * Método getter del atributo valorFecha de la clase ValorParametroDTO
	 *
	 * @return the valorFecha
	 */
	public String getValorFecha() {
		return valorFecha;
	}

	/**
	 * Método setter del atributo valorFecha de la clase ValorParametroDTO
	 *
	 * @param valorFecha
	 *            the valorFecha to set
	 */
	public void setValorFecha(String valorFecha) {
		this.valorFecha = valorFecha;
	}

	/**
	 * Método getter del atributo valorNumerico de la clase ValorParametroDTO
	 *
	 * @return the valorNumerico
	 */
	public BigDecimal getValorNumerico() {
		return valorNumerico;
	}

	/**
	 * Método setter del atributo valorNumerico de la clase ValorParametroDTO
	 *
	 * @param valorNumerico
	 *            the valorNumerico to set
	 */
	public void setValorNumerico(BigDecimal valorNumerico) {
		this.valorNumerico = valorNumerico;
	}

	/**
	 * Método getter del atributo idSoiParametro de la clase ValorParametroDTO
	 *
	 * @return the idSoiParametro
	 */
	public Integer getIdSoiParametro() {
		return idSoiParametro;
	}

	/**
	 * Método setter del atributo idSoiParametro de la clase ValorParametroDTO
	 *
	 * @param idSoiParametro
	 *            the idSoiParametro to set
	 */
	public void setIdSoiParametro(Integer idSoiParametro) {
		this.idSoiParametro = idSoiParametro;
	}

	/**
	 * Método getter del atributo idSoiValorParametro de la clase ValorParametroDTO
	 *
	 * @return the idSoiValorParametro
	 */
	public Integer getIdSoiValorParametro() {
		return idSoiValorParametro;
	}

	/**
	 * Método setter del atributo idSoiValorParametro de la clase ValorParametroDTO
	 *
	 * @param idSoiValorParametro
	 *            the idSoiValorParametro to set
	 */
	public void setIdSoiValorParametro(Integer idSoiValorParametro) {
		this.idSoiValorParametro = idSoiValorParametro;
	}

}

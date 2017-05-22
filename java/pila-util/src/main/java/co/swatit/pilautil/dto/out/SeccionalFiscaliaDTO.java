/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;

import com.ach.pla.biz.model.SeccionalFiscaliaVO;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo {@link SeccionalFiscaliaVO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class SeccionalFiscaliaDTO implements Serializable {
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
	private Integer vigente;
	private String fechaInicioVigencia;
	private String digitoVerificacion;
	private String numeroIdentificacion;
	private Integer idSoiTpIdentificacion;
	private String nombre;
	private Long idSoiSeccionalFiscalia;

	/**
	 * Método getter del atributo ipModificacion de la clase SeccionalFiscaliaDTO
	 *
	 * @return the ipModificacion
	 */
	public String getIpModificacion() {
		return ipModificacion;
	}

	/**
	 * Método setter del atributo ipModificacion de la clase SeccionalFiscaliaDTO
	 *
	 * @param ipModificacion
	 *            the ipModificacion to set
	 */
	public void setIpModificacion(String ipModificacion) {
		this.ipModificacion = ipModificacion;
	}

	/**
	 * Método getter del atributo fechaModificacion de la clase SeccionalFiscaliaDTO
	 *
	 * @return the fechaModificacion
	 */
	public String getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * Método setter del atributo fechaModificacion de la clase SeccionalFiscaliaDTO
	 *
	 * @param fechaModificacion
	 *            the fechaModificacion to set
	 */
	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * Método getter del atributo usuarioModificacion de la clase SeccionalFiscaliaDTO
	 *
	 * @return the usuarioModificacion
	 */
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	/**
	 * Método setter del atributo usuarioModificacion de la clase SeccionalFiscaliaDTO
	 *
	 * @param usuarioModificacion
	 *            the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	/**
	 * Método getter del atributo ipCreacion de la clase SeccionalFiscaliaDTO
	 *
	 * @return the ipCreacion
	 */
	public String getIpCreacion() {
		return ipCreacion;
	}

	/**
	 * Método setter del atributo ipCreacion de la clase SeccionalFiscaliaDTO
	 *
	 * @param ipCreacion
	 *            the ipCreacion to set
	 */
	public void setIpCreacion(String ipCreacion) {
		this.ipCreacion = ipCreacion;
	}

	/**
	 * Método getter del atributo fechaCreacion de la clase SeccionalFiscaliaDTO
	 *
	 * @return the fechaCreacion
	 */
	public String getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Método setter del atributo fechaCreacion de la clase SeccionalFiscaliaDTO
	 *
	 * @param fechaCreacion
	 *            the fechaCreacion to set
	 */
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Método getter del atributo usuarioCreacion de la clase SeccionalFiscaliaDTO
	 *
	 * @return the usuarioCreacion
	 */
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	/**
	 * Método setter del atributo usuarioCreacion de la clase SeccionalFiscaliaDTO
	 *
	 * @param usuarioCreacion
	 *            the usuarioCreacion to set
	 */
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	/**
	 * Método getter del atributo causaFinVigencia de la clase SeccionalFiscaliaDTO
	 *
	 * @return the causaFinVigencia
	 */
	public String getCausaFinVigencia() {
		return causaFinVigencia;
	}

	/**
	 * Método setter del atributo causaFinVigencia de la clase SeccionalFiscaliaDTO
	 *
	 * @param causaFinVigencia
	 *            the causaFinVigencia to set
	 */
	public void setCausaFinVigencia(String causaFinVigencia) {
		this.causaFinVigencia = causaFinVigencia;
	}

	/**
	 * Método getter del atributo fechaFinVigencia de la clase SeccionalFiscaliaDTO
	 *
	 * @return the fechaFinVigencia
	 */
	public String getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	/**
	 * Método setter del atributo fechaFinVigencia de la clase SeccionalFiscaliaDTO
	 *
	 * @param fechaFinVigencia
	 *            the fechaFinVigencia to set
	 */
	public void setFechaFinVigencia(String fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	/**
	 * Método getter del atributo vigente de la clase SeccionalFiscaliaDTO
	 *
	 * @return the vigente
	 */
	public Integer getVigente() {
		return vigente;
	}

	/**
	 * Método setter del atributo vigente de la clase SeccionalFiscaliaDTO
	 *
	 * @param vigente
	 *            the vigente to set
	 */
	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}

	/**
	 * Método getter del atributo fechaInicioVigencia de la clase SeccionalFiscaliaDTO
	 *
	 * @return the fechaInicioVigencia
	 */
	public String getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	/**
	 * Método setter del atributo fechaInicioVigencia de la clase SeccionalFiscaliaDTO
	 *
	 * @param fechaInicioVigencia
	 *            the fechaInicioVigencia to set
	 */
	public void setFechaInicioVigencia(String fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	/**
	 * Método getter del atributo digitoVerificacion de la clase SeccionalFiscaliaDTO
	 *
	 * @return the digitoVerificacion
	 */
	public String getDigitoVerificacion() {
		return digitoVerificacion;
	}

	/**
	 * Método setter del atributo digitoVerificacion de la clase SeccionalFiscaliaDTO
	 *
	 * @param digitoVerificacion
	 *            the digitoVerificacion to set
	 */
	public void setDigitoVerificacion(String digitoVerificacion) {
		this.digitoVerificacion = digitoVerificacion;
	}

	/**
	 * Método getter del atributo numeroIdentificacion de la clase SeccionalFiscaliaDTO
	 *
	 * @return the numeroIdentificacion
	 */
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	/**
	 * Método setter del atributo numeroIdentificacion de la clase SeccionalFiscaliaDTO
	 *
	 * @param numeroIdentificacion
	 *            the numeroIdentificacion to set
	 */
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	/**
	 * Método getter del atributo idSoiTpIdentificacion de la clase SeccionalFiscaliaDTO
	 *
	 * @return the idSoiTpIdentificacion
	 */
	public Integer getIdSoiTpIdentificacion() {
		return idSoiTpIdentificacion;
	}

	/**
	 * Método setter del atributo idSoiTpIdentificacion de la clase SeccionalFiscaliaDTO
	 *
	 * @param idSoiTpIdentificacion
	 *            the idSoiTpIdentificacion to set
	 */
	public void setIdSoiTpIdentificacion(Integer idSoiTpIdentificacion) {
		this.idSoiTpIdentificacion = idSoiTpIdentificacion;
	}

	/**
	 * Método getter del atributo nombre de la clase SeccionalFiscaliaDTO
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del atributo nombre de la clase SeccionalFiscaliaDTO
	 *
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter del atributo idSoiSeccionalFiscalia de la clase SeccionalFiscaliaDTO
	 *
	 * @return the idSoiSeccionalFiscalia
	 */
	public Long getIdSoiSeccionalFiscalia() {
		return idSoiSeccionalFiscalia;
	}

	/**
	 * Método setter del atributo idSoiSeccionalFiscalia de la clase SeccionalFiscaliaDTO
	 *
	 * @param idSoiSeccionalFiscalia
	 *            the idSoiSeccionalFiscalia to set
	 */
	public void setIdSoiSeccionalFiscalia(Long idSoiSeccionalFiscalia) {
		this.idSoiSeccionalFiscalia = idSoiSeccionalFiscalia;
	}

}

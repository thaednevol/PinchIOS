/**
 * 
 */
package co.swatit.pilautil.dto.in;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import co.swatit.pilautil.dto.RequestDTO;

/**
 * Objeto de transporte que contiene los parámetros del servicio getFilteredPayrolls
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 9/03/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFilteredPayrollsInDTO", propOrder = { "idSoiAportante", "idSegUsuario", "numPagina", "numRegistros" })
public class GetFilteredPayrollsInDTO extends RequestDTO {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id del aportante
	 */
	private String idSoiAportante;
	/**
	 * Id del usuario que realiza la operación
	 */
	private String idSegUsuario;
	/**
	 * Número de la página a obtener de los resultados
	 */
	private String numPagina;
	/**
	 * Cantidad de registros a obtener de la página
	 */
	private String numRegistros;

	/**
	 * Método getter del atributo idSoiAportante de la clase GetFilteredPayrollsInDTO
	 *
	 * @return the idSoiAportante
	 */
	public String getIdSoiAportante() {
		return idSoiAportante;
	}

	/**
	 * Método setter del atributo idSoiAportante de la clase GetFilteredPayrollsInDTO
	 *
	 * @param idSoiAportante
	 *            the idSoiAportante to set
	 */
	public void setIdSoiAportante(String idSoiAportante) {
		this.idSoiAportante = idSoiAportante;
	}

	/**
	 * Método getter del atributo idSegUsuario de la clase GetFilteredPayrollsInDTO
	 *
	 * @return the idSegUsuario
	 */
	public String getIdSegUsuario() {
		return idSegUsuario;
	}

	/**
	 * Método setter del atributo idSegUsuario de la clase GetFilteredPayrollsInDTO
	 *
	 * @param idSegUsuario
	 *            the idSegUsuario to set
	 */
	public void setIdSegUsuario(String idSegUsuario) {
		this.idSegUsuario = idSegUsuario;
	}

	/**
	 * Método getter del atributo numPagina de la clase GetFilteredPayrollsInDTO
	 *
	 * @return the numPagina
	 */
	public String getNumPagina() {
		return numPagina;
	}

	/**
	 * Método setter del atributo numPagina de la clase GetFilteredPayrollsInDTO
	 *
	 * @param numPagina
	 *            the numPagina to set
	 */
	public void setNumPagina(String numPagina) {
		this.numPagina = numPagina;
	}

	/**
	 * Método getter del atributo numRegistros de la clase GetFilteredPayrollsInDTO
	 *
	 * @return the numRegistros
	 */
	public String getNumRegistros() {
		return numRegistros;
	}

	/**
	 * Método setter del atributo numRegistros de la clase GetFilteredPayrollsInDTO
	 *
	 * @param numRegistros
	 *            the numRegistros to set
	 */
	public void setNumRegistros(String numRegistros) {
		this.numRegistros = numRegistros;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetFilteredPayrollsInDTO [idSoiAportante=");
		builder.append(idSoiAportante);
		builder.append(", idSegUsuario=");
		builder.append(idSegUsuario);
		builder.append(", numPagina=");
		builder.append(numPagina);
		builder.append(", numRegistros=");
		builder.append(numRegistros);
		builder.append("]");
		return builder.toString();
	}

	
}

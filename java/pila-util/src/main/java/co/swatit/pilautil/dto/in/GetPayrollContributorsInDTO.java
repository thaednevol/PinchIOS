/**
 * 
 */
package co.swatit.pilautil.dto.in;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import co.swatit.pilautil.dto.RequestDTO;

/**
 * Objeto de transporte que contiene los parámetros del servicio getPayrollHeader
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 3/04/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPayrollContributorsInDTO", propOrder = { "numeroPlanilla" })
public class GetPayrollContributorsInDTO extends RequestDTO {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Número de la planilla de la que se desea obtener sus aportantes
	 */
	private String numeroPlanilla;

	/**
	 * Método getter del atributo numeroPlanilla de la clase GetPayrollContributorsInDTO
	 *
	 * @return the numeroPlanilla
	 */
	public String getNumeroPlanilla() {
		return numeroPlanilla;
	}

	/**
	 * Método setter del atributo numeroPlanilla de la clase GetPayrollContributorsInDTO
	 *
	 * @param numeroPlanilla
	 *            the numeroPlanilla to set
	 */
	public void setNumeroPlanilla(String numeroPlanilla) {
		this.numeroPlanilla = numeroPlanilla;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetPayrollContributorsInDTO [numeroPlanilla=");
		builder.append(numeroPlanilla);
		builder.append("]");
		return builder.toString();
	}

}

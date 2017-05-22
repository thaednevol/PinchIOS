/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import co.swatit.pilautil.dto.ResponseDTO;

/**
 * Objeto de transporte que contiene la respuesta del servicio getPayrollContributors
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 4/04/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPayrollContributorsOutDTO", propOrder = { "payrollContributors" })
public class GetPayrollContributorsOutDTO extends ResponseDTO {
	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Lista de aportantes
	 */
	private List<PayrollContributorDTO> payrollContributors;

	/**
	 * Método getter del atributo payrollContributors de la clase GetPayrollContributorsOutDTO
	 *
	 * @return the payrollContributors
	 */
	public List<PayrollContributorDTO> getPayrollContributors() {
		if (payrollContributors == null) {
			payrollContributors = new ArrayList<PayrollContributorDTO>();
		}
		return payrollContributors;
	}

}

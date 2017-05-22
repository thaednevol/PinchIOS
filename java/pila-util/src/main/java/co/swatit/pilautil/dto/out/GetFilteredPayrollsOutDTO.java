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
 * 
 * Objeto de transporte que contiene la respuesta del servicio getFilteredPayrolls
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 9/03/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFilteredPayrollsOutDTO ", propOrder = { "listFilteredPayrollsDetails" })
public class GetFilteredPayrollsOutDTO extends ResponseDTO {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Lista que contiene todos las planillas encontradas
	 */
	private List<PayrollDetailDTO> listFilteredPayrollsDetails;

	/**
	 * Método getter del atributo listFilteredPayrollsDetails de la clase GetFilteredPayrollsOutDTO
	 *
	 * @return the listFilteredPayrollsDetails
	 */
	public List<PayrollDetailDTO> getListFilteredPayrollsDetails() {
		if (listFilteredPayrollsDetails == null) {
			listFilteredPayrollsDetails = new ArrayList<PayrollDetailDTO>();
		}
		return listFilteredPayrollsDetails;
	}

}

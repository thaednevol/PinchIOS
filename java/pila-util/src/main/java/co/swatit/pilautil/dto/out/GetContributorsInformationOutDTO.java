package co.swatit.pilautil.dto.out;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import co.swatit.pilautil.dto.ResponseDTO;

/**
 * Objeto de transporte que contiene los parámetros de entrada del servicio web getContributorsInformation
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 7/04/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getContributorsInformationOutDTO", propOrder = { "contributorPayrolls", "contributorsNotFound" })
public class GetContributorsInformationOutDTO extends ResponseDTO {
	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Lista que contiene la información de los aportantes encontrados
	 */
	private List<PlanillaCotizanteDTO> contributorPayrolls;
	/**
	 * Ids de los aportantes que NO fueron encontrados
	 */
	private List<Long> contributorsNotFound;

	/**
	 * Método getter del atributo contributorPayrolls de la clase GetContributorsInformationOutDTO
	 *
	 * @return the contributorPayrolls
	 */
	public List<PlanillaCotizanteDTO> getContributorPayrolls() {
		if (contributorPayrolls == null) {
			contributorPayrolls = new ArrayList<PlanillaCotizanteDTO>();
		}
		return contributorPayrolls;
	}

	/**
	 * Método getter del atributo contributorsNotFound de la clase GetContributorsInformationOutDTO
	 *
	 * @return the contributorsNotFound
	 */
	public List<Long> getContributorsNotFound() {
		if (contributorsNotFound == null) {
			contributorsNotFound = new ArrayList<Long>();
		}
		return contributorsNotFound;
	}

}

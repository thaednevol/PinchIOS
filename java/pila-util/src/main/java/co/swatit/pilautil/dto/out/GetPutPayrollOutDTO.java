package co.swatit.pilautil.dto.out;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import co.swatit.pilautil.dto.ResponseDTO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPutPayrollOutDTO", propOrder = { "idSoiPlanilla", "idNumeroDePlanilla"})
public class GetPutPayrollOutDTO extends ResponseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idSoiPlanilla;
	
	private String idNumeroDePlanilla;

	public Long getIdSoiPlanilla() {
		return idSoiPlanilla;
	}

	public void setIdSoiPlanilla(Long idSoiPlanilla) {
		this.idSoiPlanilla = idSoiPlanilla;
	}

	public String getIdNumeroDePlanilla() {
		return idNumeroDePlanilla;
	}

	public void setIdNumeroDePlanilla(String idNumeroDePlanilla) {
		this.idNumeroDePlanilla = idNumeroDePlanilla;
	}
}

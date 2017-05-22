package co.swatit.pilautil.dto.in;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import co.swatit.pilautil.dto.RequestDTO;
import co.swatit.pilautil.dto.out.GetConsultPayrollOutDTO;
import co.swatit.pilautil.dto.out.GetValidateFileOutDTO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPutPayrollInDTO", propOrder = { "getValidateFileOutDTO",
		"getUsuarioAutenticadoInDTO", "idPlanilla", "getConsultPayrollOutDTO"})
public class GetPutPayrollInDTO extends RequestDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GetValidateFileOutDTO getValidateFileOutDTO;
	
	private GetUsuarioAutenticadoInDTO getUsuarioAutenticadoInDTO;
	
	private Long idPlanilla;
	
	private GetConsultPayrollOutDTO getConsultPayrollOutDTO;



	public GetUsuarioAutenticadoInDTO getGetUsuarioAutenticadoInDTO() {
		return getUsuarioAutenticadoInDTO;
	}

	public void setGetUsuarioAutenticadoInDTO(
			GetUsuarioAutenticadoInDTO getUsuarioAutenticadoInDTO) {
		this.getUsuarioAutenticadoInDTO = getUsuarioAutenticadoInDTO;
	}

	public Long getIdPlanilla() {
		return idPlanilla;
	}

	public void setIdPlanilla(Long idPlanilla) {
		this.idPlanilla = idPlanilla;
	}

	public GetConsultPayrollOutDTO getGetConsultPayrollOutDTO() {
		return getConsultPayrollOutDTO;
	}

	public void setGetConsultPayrollOutDTO(
			GetConsultPayrollOutDTO getConsultPayrollOutDTO) {
		this.getConsultPayrollOutDTO = getConsultPayrollOutDTO;
	}

	public GetValidateFileOutDTO getGetValidateFileOutDTO() {
		return getValidateFileOutDTO;
	}

	public void setGetValidateFileOutDTO(GetValidateFileOutDTO getValidateFileOutDTO) {
		this.getValidateFileOutDTO = getValidateFileOutDTO;
	}

}

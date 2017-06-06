package co.swatit.pilautil.dto.in;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import co.swatit.pilautil.dto.RequestDTO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getConsultFileInDTO", propOrder = { "idFile" })
public class GetConsultFileInDTO extends RequestDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idFile;

	public Long getIdFile() {
		return idFile;
	}

	public void setIdFile(Long idFile) {
		this.idFile = idFile;
	}

}

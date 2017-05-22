package co.swatit.pilautil.dto.out;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import co.swatit.pilautil.dto.ResponseDTO;

/**
 * 
 * Objeto de transporte que contiene la respuesta del servicio generador de tokens además del código de error resultado
 * de consumirlo
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 18/01/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "generateTokenOutDTO", propOrder = { "data" })
public class GenerateTokenOutDTO extends ResponseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Objeto de transporte que contiene el resultado de la invocación del servicio
	 */
	private DataDTO data;

	/**
	 * Método getter del atributo data de la clase GenerateTokenOutDTO
	 *
	 * @return the data
	 */
	public DataDTO getData() {
		return data;
	}

	/**
	 * Método setter del atributo data de la clase GenerateTokenOutDTO
	 *
	 * @param data
	 *            the data to set
	 */
	public void setData(DataDTO data) {
		this.data = data;
	}

}

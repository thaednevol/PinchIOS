package co.swatit.pilautil.dto.out;

import co.swatit.pilautil.dto.ResponseDTO;

/**
 * Objeto de transporte que contiene la respuesta del servicio getApplicationConfiguration
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 15/02/2017
 * @version 1.0
 */
public class GetValidationFileConfigOutDTO extends ResponseDTO {
	/**
	 * Constante de Serialización
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Objeto que contiene la configuración del archivo procesado
	 */
	private ValidacionArchivoDataSourceDTO validacionArchivoDataSourceDTO;
	/**
	 * Objeto que contiene los datos del archivo procesado
	 */
	private ArchivoEnProcesoDTO archivoEnProcesoDTO;

	/**
	 * Método getter del atributo validacionArchivoDataSourceDTO de la clase GetApplicationConfigurationOutDTO
	 *
	 * @return the validacionArchivoDataSourceDTO
	 */
	public ValidacionArchivoDataSourceDTO getValidacionArchivoDataSourceDTO() {
		return validacionArchivoDataSourceDTO;
	}

	/**
	 * Método setter del atributo validacionArchivoDataSourceDTO de la clase GetApplicationConfigurationOutDTO
	 *
	 * @param validacionArchivoDataSourceDTO
	 *            the validacionArchivoDataSourceDTO to set
	 */
	public void setValidacionArchivoDataSourceDTO(ValidacionArchivoDataSourceDTO validacionArchivoDataSourceDTO) {
		this.validacionArchivoDataSourceDTO = validacionArchivoDataSourceDTO;
	}

	/**
	 * Método getter del atributo archivoEnProcesoDTO de la clase GetApplicationConfigurationOutDTO
	 *
	 * @return the archivoEnProcesoDTO
	 */
	public ArchivoEnProcesoDTO getArchivoEnProcesoDTO() {
		return archivoEnProcesoDTO;
	}

	/**
	 * Método setter del atributo archivoEnProcesoDTO de la clase GetApplicationConfigurationOutDTO
	 *
	 * @param archivoEnProcesoDTO
	 *            the archivoEnProcesoDTO to set
	 */
	public void setArchivoEnProcesoDTO(ArchivoEnProcesoDTO archivoEnProcesoDTO) {
		this.archivoEnProcesoDTO = archivoEnProcesoDTO;
	}

}

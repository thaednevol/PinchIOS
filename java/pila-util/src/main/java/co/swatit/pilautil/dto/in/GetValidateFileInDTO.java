package co.swatit.pilautil.dto.in;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import co.swatit.pilautil.dto.RequestDTO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getValidateFileInDTO", propOrder = { "aportanteLey1429", "fileName", "idSegUsuario", "numeroTotalDeEmpleadosPorPantalla", "idAportante", "aportanteLey1607", "idSoiTpPlanilla", "fileZip", "fileNameZip", "rutaLocalArchivo" })
public class GetValidateFileInDTO extends RequestDTO {

	/**
	 * Constante de serialización.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Aporta ley 1429.
	 */
	private boolean aportanteLey1429;
	/**
	 * Nombre del archivo.
	 */
	private String fileName;
	/**
	 * Id del usuario autenticado.
	 */
	private Long idSegUsuario;
	/**
	 * Numero total de empleados por pantalla.
	 */
	private Integer numeroTotalDeEmpleadosPorPantalla;
	/**
	 * Id del aportante.
	 */
	private Long idAportante;
	/**
	 * Aportante ley 1429.
	 */
	private boolean aportanteLey1607;
	/**
	 * IdSoi tipo de planilla.
	 */
	private Integer idSoiTpPlanilla;
	/**
	 * Arreglo de bytes con el contenido de la planilla en formato zip.
	 */
	private byte[] fileZip;
	/**
	 * Nombre del archivo Zip y ruta donde se debe generar.
	 */
	private String fileNameZip;
	
	private String rutaLocalArchivo;
	
	private String periodoSalud;
	
	private String periodoNoSalud;
	
	/**
	 * Método getter del atributo aportanteLey1429.
	 * 
	 * @return the aportanteLey1429
	 */
	public boolean isAportanteLey1429() {
		return aportanteLey1429;
	}
	/**
	 * Método setter del atributo aportanteLey1429.
	 * 
	 * @param aportanteLey1429 the aportanteLey1429 to set
	 */
	public void setAportanteLey1429(boolean aportanteLey1429) {
		this.aportanteLey1429 = aportanteLey1429;
	}
	/**
	 * Método getter del atributo fileName
	 * 
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * Método setter del atributo fileName.
	 * 
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * Método getter del atributo idSegUsuario
	 *  
	 * @return the idSegUsuario
	 */
	public Long getIdSegUsuario() {
		return idSegUsuario;
	}
	/**
	 * Método setter del atributo idSegUsuario.
	 * 
	 * @param idSegUsuario the idSegUsuario to set
	 */
	public void setIdSegUsuario(Long idSegUsuario) {
		this.idSegUsuario = idSegUsuario;
	}
	/**
	 * Método getter del atributo numeroTotalDeEmpleadosPorPantalla.
	 *  
	 * @return the numeroTotalDeEmpleadosPorPantalla
	 */
	public Integer getNumeroTotalDeEmpleadosPorPantalla() {
		return numeroTotalDeEmpleadosPorPantalla;
	}
	/**
	 * Método setter del atributo numeroTotalDeEmpleadosPorPantalla.
	 * 
	 * @param numeroTotalDeEmpleadosPorPantalla the numeroTotalDeEmpleadosPorPantalla to set
	 */
	public void setNumeroTotalDeEmpleadosPorPantalla(
			Integer numeroTotalDeEmpleadosPorPantalla) {
		this.numeroTotalDeEmpleadosPorPantalla = numeroTotalDeEmpleadosPorPantalla;
	}
	/**
	 * Método getter del atributo idAportante.
	 * 
	 * @return the idAportante
	 */
	public Long getIdAportante() {
		return idAportante;
	}
	/**
	 * Método setter del atributo idAportante.
	 * 
	 * @param idAportante the idAportante to set
	 */
	public void setIdAportante(Long idAportante) {
		this.idAportante = idAportante;
	}
	/**
	 * Método getter del atributo aportanteLey1607.
	 * 
	 * @return the aportanteLey1607
	 */
	public boolean isAportanteLey1607() {
		return aportanteLey1607;
	}
	/**
	 * Método setter del atributo aportanteLey1607.
	 * 
	 * @param aportanteLey1607 the aportanteLey1607 to set
	 */
	public void setAportanteLey1607(boolean aportanteLey1607) {
		this.aportanteLey1607 = aportanteLey1607;
	}
	/**
	 * Método getter del atributo idSoiTpPlanilla.
	 * 
	 * @return the idSoiTpPlanilla
	 */
	public Integer getIdSoiTpPlanilla() {
		return idSoiTpPlanilla;
	}
	/**
	 * Método setter del atributo idSoiTpPlanilla.
	 * 
	 * @param idSoiTpPlanilla the idSoiTpPlanilla to set
	 */
	public void setIdSoiTpPlanilla(Integer idSoiTpPlanilla) {
		this.idSoiTpPlanilla = idSoiTpPlanilla;
	}
	/**
	 * Método getter del atributo fileZip.
	 * 
	 * @return the fileZip
	 */
	public byte[] getFileZip() {
		return fileZip;
	}
	/**
	 * Método setter del atributo fileZip.
	 * 
	 * @param fileZip the fileZip to set
	 */
	public void setArchivoZip(byte[] fileZip) {
		this.fileZip = fileZip;
	}
	/**
	 * Método getter del atributo fileNameZip.
	 * 
	 * @return the fileNameZip
	 */
	public String getFileNameZip() {
		return fileNameZip;
	}
	/**
	 * Método setter del atributo fileNameZip.
	 * 
	 * @param fileNameZip the fileNameZip to set
	 */
	public void setFileNameZip(String fileNameZip) {
		this.fileNameZip = fileNameZip;
	}
	public String getRutaLocalArchivo() {
		return rutaLocalArchivo;
	}
	public void setRutaLocalArchivo(String rutaLocalArchivo) {
		this.rutaLocalArchivo = rutaLocalArchivo;
	}
	public String getPeriodoSalud() {
		return periodoSalud;
	}
	public void setPeriodoSalud(String periodoSalud) {
		this.periodoSalud = periodoSalud;
	}
	public String getPeriodoNoSalud() {
		return periodoNoSalud;
	}
	public void setPeriodoNoSalud(String periodoNoSalud) {
		this.periodoNoSalud = periodoNoSalud;
	}
}

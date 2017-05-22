package co.swatit.pilautil.dto.out;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.ach.pla.biz.type.NotificacionDeArchivoEnProcesoType;

import co.swatit.pilautil.dto.ResponseDTO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getValidateFileOutDTO", propOrder = { "idArchivoEnProceso", "errores", "idSegUsuario", "idSoiPlanilla",
		"notificacionDeArchivoEnProcesoType", "numeroTotalDeEmpleadosPorPantalla", "nombreArchivo", "idAportante", 
		"idSoiPlanillaGuardada", "codTipoPlanilla", "idSoiTpPlanilla" })
public class GetValidateFileOutDTO extends ResponseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idArchivoEnProceso = null;
	private Collection<String> errores = new ArrayList<String>();
	private Long idSegUsuario;
	private Long idSoiPlanilla = null;
	private NotificacionDeArchivoEnProcesoType notificacionDeArchivoEnProcesoType = NotificacionDeArchivoEnProcesoType.NUEVA_NOTIFICACION;
	private Integer numeroTotalDeEmpleadosPorPantalla = 0;
	private String nombreArchivo;
	private Long idAportante = null;
	private Long idSoiPlanillaGuardada = null;
	private String codTipoPlanilla;
	private Integer idSoiTpPlanilla = null;
	
	/**
	 * @return the idArchivoEnProceso
	 */
	public Long getIdArchivoEnProceso() {
		return idArchivoEnProceso;
	}
	/**
	 * @param idArchivoEnProceso the idArchivoEnProceso to set
	 */
	public void setIdArchivoEnProceso(Long idArchivoEnProceso) {
		this.idArchivoEnProceso = idArchivoEnProceso;
	}
	/**
	 * @return the errores
	 */
	public Collection<String> getErrores() {
		return errores;
	}
	/**
	 * @param errores the errores to set
	 */
	public void setErrores(Collection<String> errores) {
		this.errores = errores;
	}
	/**
	 * @return the idSegUsuario
	 */
	public Long getIdSegUsuario() {
		return idSegUsuario;
	}
	/**
	 * @param idSegUsuario the idSegUsuario to set
	 */
	public void setIdSegUsuario(Long idSegUsuario) {
		this.idSegUsuario = idSegUsuario;
	}
	/**
	 * @return the idSoiPlanilla
	 */
	public Long getIdSoiPlanilla() {
		return idSoiPlanilla;
	}
	/**
	 * @param idSoiPlanilla the idSoiPlanilla to set
	 */
	public void setIdSoiPlanilla(Long idSoiPlanilla) {
		this.idSoiPlanilla = idSoiPlanilla;
	}
	/**
	 * @return the numeroTotalDeEmpleadosPorPantalla
	 */
	public Integer getNumeroTotalDeEmpleadosPorPantalla() {
		return numeroTotalDeEmpleadosPorPantalla;
	}
	/**
	 * @param numeroTotalDeEmpleadosPorPantalla the numeroTotalDeEmpleadosPorPantalla to set
	 */
	public void setNumeroTotalDeEmpleadosPorPantalla(
			Integer numeroTotalDeEmpleadosPorPantalla) {
		this.numeroTotalDeEmpleadosPorPantalla = numeroTotalDeEmpleadosPorPantalla;
	}
	/**
	 * @return the nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	/**
	 * @param nombreArchivo the nombreArchivo to set
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	/**
	 * @return the idAportante
	 */
	public Long getIdAportante() {
		return idAportante;
	}
	/**
	 * @param idAportante the idAportante to set
	 */
	public void setIdAportante(Long idAportante) {
		this.idAportante = idAportante;
	}
	/**
	 * @return the idSoiPlanillaGuardada
	 */
	public Long getIdSoiPlanillaGuardada() {
		return idSoiPlanillaGuardada;
	}
	/**
	 * @param idSoiPlanillaGuardada the idSoiPlanillaGuardada to set
	 */
	public void setIdSoiPlanillaGuardada(Long idSoiPlanillaGuardada) {
		this.idSoiPlanillaGuardada = idSoiPlanillaGuardada;
	}
	/**
	 * @return the codTipoPlanilla
	 */
	public String getCodTipoPlanilla() {
		return codTipoPlanilla;
	}
	/**
	 * @param codTipoPlanilla the codTipoPlanilla to set
	 */
	public void setCodTipoPlanilla(String codTipoPlanilla) {
		this.codTipoPlanilla = codTipoPlanilla;
	}
	/**
	 * @return the idSoiTpPlanilla
	 */
	public Integer getIdSoiTpPlanilla() {
		return idSoiTpPlanilla;
	}
	/**
	 * @param idSoiTpPlanilla the idSoiTpPlanilla to set
	 */
	public void setIdSoiTpPlanilla(Integer idSoiTpPlanilla) {
		this.idSoiTpPlanilla = idSoiTpPlanilla;
	}
	public NotificacionDeArchivoEnProcesoType getNotificacionDeArchivoEnProcesoType() {
		return notificacionDeArchivoEnProcesoType;
	}
	public void setNotificacionDeArchivoEnProcesoType(
			NotificacionDeArchivoEnProcesoType notificacionDeArchivoEnProcesoType) {
		this.notificacionDeArchivoEnProcesoType = notificacionDeArchivoEnProcesoType;
	}
}

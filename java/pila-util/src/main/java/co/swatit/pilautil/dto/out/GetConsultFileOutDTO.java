package co.swatit.pilautil.dto.out;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import co.swatit.pilautil.dto.ResponseDTO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getConsultFileOutDTO", propOrder = { "supera5smmlv", "rutaArchivoValidacion", "rutaArchivoErroresAf", "ipModificacion",
		"fechaModificacion", "usuarioModificacion", "ipCreacion", "fechaCreacion", 
		"usuarioCreacion", "trazaErrorGuardar", "codigoErrorGuardar",
		"trazaErrorValidacion", "codigoErrorValidacion", "rutaArchivoErrores", 
		"porcentajeAvanceGuardado", "rutaArchivoPlanilla", "cotizantesIngresados",
		"porcentajeAvanceValidacion", "estado", "idPlanilla", "idTmpValidacionArchivo"})
public class GetConsultFileOutDTO extends ResponseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer supera5smmlv;

	private String rutaArchivoValidacion;

	private String rutaArchivoErroresAf;

	private String ipModificacion;

	private Calendar fechaModificacion;

	private String usuarioModificacion;

	private String ipCreacion;

	private Calendar fechaCreacion;

	private String usuarioCreacion;

	private String trazaErrorGuardar;

	private Long codigoErrorGuardar;

	private String trazaErrorValidacion;

	private Long codigoErrorValidacion;

	private String rutaArchivoErrores;

	private Integer porcentajeAvanceGuardado;

	private String rutaArchivoPlanilla;

	private Long cotizantesIngresados;

	private Integer porcentajeAvanceValidacion;

	private Integer estado;

	private Long idPlanilla;

	private Long idTmpValidacionArchivo;

	public Integer getSupera5smmlv() {
		return supera5smmlv;
	}

	public void setSupera5smmlv(Integer supera5smmlv) {
		this.supera5smmlv = supera5smmlv;
	}

	public String getRutaArchivoValidacion() {
		return rutaArchivoValidacion;
	}

	public void setRutaArchivoValidacion(String rutaArchivoValidacion) {
		this.rutaArchivoValidacion = rutaArchivoValidacion;
	}

	public String getRutaArchivoErroresAf() {
		return rutaArchivoErroresAf;
	}

	public void setRutaArchivoErroresAf(String rutaArchivoErroresAf) {
		this.rutaArchivoErroresAf = rutaArchivoErroresAf;
	}

	public String getIpModificacion() {
		return ipModificacion;
	}

	public void setIpModificacion(String ipModificacion) {
		this.ipModificacion = ipModificacion;
	}

	public Calendar getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Calendar fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public String getIpCreacion() {
		return ipCreacion;
	}

	public void setIpCreacion(String ipCreacion) {
		this.ipCreacion = ipCreacion;
	}

	public Calendar getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Calendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getTrazaErrorGuardar() {
		return trazaErrorGuardar;
	}

	public void setTrazaErrorGuardar(String trazaErrorGuardar) {
		this.trazaErrorGuardar = trazaErrorGuardar;
	}

	public Long getCodigoErrorGuardar() {
		return codigoErrorGuardar;
	}

	public void setCodigoErrorGuardar(Long codigoErrorGuardar) {
		this.codigoErrorGuardar = codigoErrorGuardar;
	}

	public String getTrazaErrorValidacion() {
		return trazaErrorValidacion;
	}

	public void setTrazaErrorValidacion(String trazaErrorValidacion) {
		this.trazaErrorValidacion = trazaErrorValidacion;
	}

	public Long getCodigoErrorValidacion() {
		return codigoErrorValidacion;
	}

	public void setCodigoErrorValidacion(Long codigoErrorValidacion) {
		this.codigoErrorValidacion = codigoErrorValidacion;
	}

	public String getRutaArchivoErrores() {
		return rutaArchivoErrores;
	}

	public void setRutaArchivoErrores(String rutaArchivoErrores) {
		this.rutaArchivoErrores = rutaArchivoErrores;
	}

	public Integer getPorcentajeAvanceGuardado() {
		return porcentajeAvanceGuardado;
	}

	public void setPorcentajeAvanceGuardado(Integer porcentajeAvanceGuardado) {
		this.porcentajeAvanceGuardado = porcentajeAvanceGuardado;
	}

	public String getRutaArchivoPlanilla() {
		return rutaArchivoPlanilla;
	}

	public void setRutaArchivoPlanilla(String rutaArchivoPlanilla) {
		this.rutaArchivoPlanilla = rutaArchivoPlanilla;
	}

	public Long getCotizantesIngresados() {
		return cotizantesIngresados;
	}

	public void setCotizantesIngresados(Long cotizantesIngresados) {
		this.cotizantesIngresados = cotizantesIngresados;
	}

	public Integer getPorcentajeAvanceValidacion() {
		return porcentajeAvanceValidacion;
	}

	public void setPorcentajeAvanceValidacion(Integer porcentajeAvanceValidacion) {
		this.porcentajeAvanceValidacion = porcentajeAvanceValidacion;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Long getIdPlanilla() {
		return idPlanilla;
	}

	public void setIdPlanilla(Long idPlanilla) {
		this.idPlanilla = idPlanilla;
	}

	public Long getIdTmpValidacionArchivo() {
		return idTmpValidacionArchivo;
	}

	public void setIdTmpValidacionArchivo(Long idTmpValidacionArchivo) {
		this.idTmpValidacionArchivo = idTmpValidacionArchivo;
	}

}

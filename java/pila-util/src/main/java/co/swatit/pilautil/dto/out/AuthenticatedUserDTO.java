package co.swatit.pilautil.dto.out;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.ach.seg.biz.transfer.UsuarioAutenticadoDTO;

/**
 * Objeto de transporte que contiene la información obtenida de un objeto de tipo {@link UsuarioAutenticadoDTO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 8/03/2017
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthenticatedUserDTO")
public class AuthenticatedUserDTO implements Serializable {

	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	private InformacionAportantePlanillaDTO informacionAportantePlanillaDTO;
	private Long idSoiAportanteUsuario;
	private String correoAportanteUsuario;
	private Boolean permitirActualizarDatosApteMigrado;
	private UserDTO userDTO;
	private List<ResourceDetailDTO> recursosAutorizacion;
	private ResourceDTO resourceDTO;
	private Boolean obligarCambioContrasena;
	private String fechaUltimoIngreso;

	/**
	 * Método getter del atributo idSoiAportanteUsuario de la clase AuthenticatedUserDTO
	 *
	 * @return the idSoiAportanteUsuario
	 */
	public Long getIdSoiAportanteUsuario() {
		return idSoiAportanteUsuario;
	}

	/**
	 * Método setter del atributo idSoiAportanteUsuario de la clase AuthenticatedUserDTO
	 *
	 * @param idSoiAportanteUsuario
	 *            the idSoiAportanteUsuario to set
	 */
	public void setIdSoiAportanteUsuario(Long idSoiAportanteUsuario) {
		this.idSoiAportanteUsuario = idSoiAportanteUsuario;
	}

	/**
	 * Método getter del atributo correoAportanteUsuario de la clase AuthenticatedUserDTO
	 *
	 * @return the correoAportanteUsuario
	 */
	public String getCorreoAportanteUsuario() {
		return correoAportanteUsuario;
	}

	/**
	 * Método setter del atributo correoAportanteUsuario de la clase AuthenticatedUserDTO
	 *
	 * @param correoAportanteUsuario
	 *            the correoAportanteUsuario to set
	 */
	public void setCorreoAportanteUsuario(String correoAportanteUsuario) {
		this.correoAportanteUsuario = correoAportanteUsuario;
	}

	/**
	 * Método getter del atributo permitirActualizarDatosApteMigrado de la clase AuthenticatedUserDTO
	 *
	 * @return the permitirActualizarDatosApteMigrado
	 */
	public Boolean getPermitirActualizarDatosApteMigrado() {
		return permitirActualizarDatosApteMigrado;
	}

	/**
	 * Método setter del atributo permitirActualizarDatosApteMigrado de la clase AuthenticatedUserDTO
	 *
	 * @param permitirActualizarDatosApteMigrado
	 *            the permitirActualizarDatosApteMigrado to set
	 */
	public void setPermitirActualizarDatosApteMigrado(Boolean permitirActualizarDatosApteMigrado) {
		this.permitirActualizarDatosApteMigrado = permitirActualizarDatosApteMigrado;
	}

	/**
	 * Método getter del atributo userDTO de la clase AuthenticatedUserDTO
	 *
	 * @return the userDTO
	 */
	public UserDTO getUserDTO() {
		return userDTO;
	}

	/**
	 * Método setter del atributo userDTO de la clase AuthenticatedUserDTO
	 *
	 * @param userDTO
	 *            the userDTO to set
	 */
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	/**
	 * Método getter del atributo recursosAutorizacion de la clase AuthenticatedUserDTO
	 *
	 * @return the recursosAutorizacion
	 */
	public List<ResourceDetailDTO> getRecursosAutorizacion() {
		if (recursosAutorizacion == null) {
			recursosAutorizacion = new ArrayList<ResourceDetailDTO>();
		}
		return recursosAutorizacion;
	}

	/**
	 * Método getter del atributo resourceDTO de la clase AuthenticatedUserDTO
	 *
	 * @return the resourceDTO
	 */
	public ResourceDTO getResourceDTO() {
		return resourceDTO;
	}

	/**
	 * Método setter del atributo resourceDTO de la clase AuthenticatedUserDTO
	 *
	 * @param resourceDTO
	 *            the resourceDTO to set
	 */
	public void setResourceDTO(ResourceDTO resourceDTO) {
		this.resourceDTO = resourceDTO;
	}

	/**
	 * Método getter del atributo obligarCambioContrasena de la clase AuthenticatedUserDTO
	 *
	 * @return the obligarCambioContrasena
	 */
	public Boolean getObligarCambioContrasena() {
		return obligarCambioContrasena;
	}

	/**
	 * Método setter del atributo obligarCambioContrasena de la clase AuthenticatedUserDTO
	 *
	 * @param obligarCambioContrasena
	 *            the obligarCambioContrasena to set
	 */
	public void setObligarCambioContrasena(Boolean obligarCambioContrasena) {
		this.obligarCambioContrasena = obligarCambioContrasena;
	}

	/**
	 * Método getter del atributo fechaUltimoIngreso de la clase AuthenticatedUserDTO
	 *
	 * @return the fechaUltimoIngreso
	 */
	public String getFechaUltimoIngreso() {
		return fechaUltimoIngreso;
	}

	/**
	 * Método setter del atributo fechaUltimoIngreso de la clase AuthenticatedUserDTO
	 *
	 * @param fechaUltimoIngreso
	 *            the fechaUltimoIngreso to set
	 */
	public void setFechaUltimoIngreso(String fechaUltimoIngreso) {
		this.fechaUltimoIngreso = fechaUltimoIngreso;
	}

	/**
	 * Método getter del atributo informacionAportantePlanillaDTO de la clase AuthenticatedUserDTO
	 *
	 * @return the informacionAportantePlanillaDTO
	 */
	public InformacionAportantePlanillaDTO getInformacionAportantePlanillaDTO() {
		return informacionAportantePlanillaDTO;
	}

	/**
	 * Método setter del atributo informacionAportantePlanillaDTO de la clase AuthenticatedUserDTO
	 *
	 * @param informacionAportantePlanillaDTO
	 *            the informacionAportantePlanillaDTO to set
	 */
	public void setInformacionAportantePlanillaDTO(InformacionAportantePlanillaDTO informacionAportantePlanillaDTO) {
		this.informacionAportantePlanillaDTO = informacionAportantePlanillaDTO;
	}

}

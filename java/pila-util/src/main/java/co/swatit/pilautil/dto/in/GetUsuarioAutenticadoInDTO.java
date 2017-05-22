package co.swatit.pilautil.dto.in;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import co.swatit.pilautil.dto.RequestDTO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUsuarioAutenticadoInDTO", propOrder = { "idSoiAportanteUsuario",
		"correoAportanteUsuario", "permitirActualizarDatosApteMigrado", "apteUgpp",
		"idRecursoLiquidacionPlanillaU", "usuarioCreacion", "ipUsuarioOrigen"})
public class GetUsuarioAutenticadoInDTO extends RequestDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idSoiAportanteUsuario;
	
	private String correoAportanteUsuario;
	
	private boolean permitirActualizarDatosApteMigrado;
	
	private boolean apteUgpp = false;
	
	private Long idRecursoLiquidacionPlanillaU = null;
	
	private String usuarioCreacion;
	
	private String ipUsuarioOrigen;

	public Long getIdSoiAportanteUsuario() {
		return idSoiAportanteUsuario;
	}

	public void setIdSoiAportanteUsuario(Long idSoiAportanteUsuario) {
		this.idSoiAportanteUsuario = idSoiAportanteUsuario;
	}

	public String getCorreoAportanteUsuario() {
		return correoAportanteUsuario;
	}

	public void setCorreoAportanteUsuario(String correoAportanteUsuario) {
		this.correoAportanteUsuario = correoAportanteUsuario;
	}

	public boolean isPermitirActualizarDatosApteMigrado() {
		return permitirActualizarDatosApteMigrado;
	}

	public void setPermitirActualizarDatosApteMigrado(
			boolean permitirActualizarDatosApteMigrado) {
		this.permitirActualizarDatosApteMigrado = permitirActualizarDatosApteMigrado;
	}

	public boolean isApteUgpp() {
		return apteUgpp;
	}

	public void setApteUgpp(boolean apteUgpp) {
		this.apteUgpp = apteUgpp;
	}

	public Long getIdRecursoLiquidacionPlanillaU() {
		return idRecursoLiquidacionPlanillaU;
	}

	public void setIdRecursoLiquidacionPlanillaU(Long idRecursoLiquidacionPlanillaU) {
		this.idRecursoLiquidacionPlanillaU = idRecursoLiquidacionPlanillaU;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getIpUsuarioOrigen() {
		return ipUsuarioOrigen;
	}

	public void setIpUsuarioOrigen(String ipUsuarioOrigen) {
		this.ipUsuarioOrigen = ipUsuarioOrigen;
	}

}

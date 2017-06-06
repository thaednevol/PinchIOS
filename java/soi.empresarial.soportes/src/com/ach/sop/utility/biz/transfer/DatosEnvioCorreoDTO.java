package com.ach.sop.utility.biz.transfer;

/**
 * 
 * @author Gustavo Castro <gcastro@lucasian.com>
 *
 */
public class DatosEnvioCorreoDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String servidorCorreo;
	private String puertoServidorCorreo;
	private boolean servidorRequiereAutenticacion;
	private boolean servidorRequiereTls;
	private boolean servidorRequiereSsl;
	private String nombreUsuarioAutenticacion;
	private String contrasenaUsuarioAutenticacion;
	private String cuentaCorreoElectronicoOrigen;
	private String cuentaCorreoElectronicoDestino;
	
	
	public String getCuentaCorreoElectronicoDestino() {
		return cuentaCorreoElectronicoDestino;
	}
	public void setCuentaCorreoElectronicoDestino(
			String cuentaCorreoElectronicoDestino) {
		this.cuentaCorreoElectronicoDestino = cuentaCorreoElectronicoDestino;
	}
	public String getCuentaCorreoElectronicoOrigen() {
		return cuentaCorreoElectronicoOrigen;
	}
	public void setCuentaCorreoElectronicoOrigen(
			String cuentaCorreoElectronicoOrigen) {
		this.cuentaCorreoElectronicoOrigen = cuentaCorreoElectronicoOrigen;
	}
	public String getServidorCorreo() {
		return servidorCorreo;
	}
	public void setServidorCorreo(String servidorCorreo) {
		this.servidorCorreo = servidorCorreo;
	}
	public String getPuertoServidorCorreo() {
		return puertoServidorCorreo;
	}
	public void setPuertoServidorCorreo(String puertoServidorCorreo) {
		this.puertoServidorCorreo = puertoServidorCorreo;
	}
	public boolean isServidorRequiereAutenticacion() {
		return servidorRequiereAutenticacion;
	}
	public void setServidorRequiereAutenticacion(
			boolean servidorRequiereAutenticacion) {
		this.servidorRequiereAutenticacion = servidorRequiereAutenticacion;
	}
	public boolean isServidorRequiereTls() {
		return servidorRequiereTls;
	}
	public void setServidorRequiereTls(boolean servidorRequiereTls) {
		this.servidorRequiereTls = servidorRequiereTls;
	}
	public boolean isServidorRequiereSsl() {
		return servidorRequiereSsl;
	}
	public void setServidorRequiereSsl(boolean servidorRequiereSsl) {
		this.servidorRequiereSsl = servidorRequiereSsl;
	}
	public String getNombreUsuarioAutenticacion() {
		return nombreUsuarioAutenticacion;
	}
	public void setNombreUsuarioAutenticacion(String nombreUsuarioAutenticacion) {
		this.nombreUsuarioAutenticacion = nombreUsuarioAutenticacion;
	}
	public String getContrasenaUsuarioAutenticacion() {
		return contrasenaUsuarioAutenticacion;
	}
	public void setContrasenaUsuarioAutenticacion(
			String contrasenaUsuarioAutenticacion) {
		this.contrasenaUsuarioAutenticacion = contrasenaUsuarioAutenticacion;
	}
	
	
	
}

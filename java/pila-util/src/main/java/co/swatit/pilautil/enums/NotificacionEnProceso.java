package co.swatit.pilautil.enums;

public enum NotificacionEnProceso {

	NUEVA_NOTIFICACION ("NUEVA_NOTIFICACION"), 
	SOBREESCRIBIR_NOTIFICACION("SOBREESCRIBIR_NOTIFICACION");
	
	private String descripcion;
	
	private NotificacionEnProceso(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}

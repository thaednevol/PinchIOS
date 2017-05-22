package com.ach.soi.empresarial.converters.enums;

public enum TipoArchivo {

	
	ACTIVOS ("1747","Activos"),
	PENSIONADOS ("2145","Pensionados");
	
	private String codigoTipo;
	private String nombreTipo;
	
	TipoArchivo ( String codigo, String nombre ){
		this.codigoTipo = codigo;
		this.nombreTipo = nombre;
	}

	public String getCodigoTipo() {
		return codigoTipo;
	}

	public void setCodigoTipo(String codigoTipo) {
		this.codigoTipo = codigoTipo;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	
	
	public static TipoArchivo getTipoArchivoPorCod ( String cod ) throws Exception{
		for ( TipoArchivo tp:TipoArchivo.values() ){
			if ( tp.codigoTipo.equals(cod) ){
				return tp;
			}
		}
		throw new Exception("Tipo de archivo no soportado: "+cod);
	}
	
	
}

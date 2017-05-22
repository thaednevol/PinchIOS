package com.ach.soi.empresarial.liquidacion.model;

import java.io.Serializable;

import co.swatit.pilautil.dto.out.ArchivoEnProcesoDTO;
import co.swatit.pilautil.dto.out.ValidacionArchivoDataSourceDTO;


public class ConfiguracionLiquidacionTO implements Serializable, Cloneable {

	
	private ValidacionArchivoDataSourceDTO validacionArchivoDataSourceDTO;
	private ArchivoEnProcesoDTO archivoEnProcesoDTO;
	
	public ValidacionArchivoDataSourceDTO getValidacionArchivoDataSourceDTO() {
		return validacionArchivoDataSourceDTO;
	}
	public void setValidacionArchivoDataSourceDTO(
			ValidacionArchivoDataSourceDTO validacionArchivoDataSourceDTO) {
		this.validacionArchivoDataSourceDTO = validacionArchivoDataSourceDTO;
	}
	public ArchivoEnProcesoDTO getArchivoEnProcesoDTO() {
		return archivoEnProcesoDTO;
	}
	public void setArchivoEnProcesoDTO(ArchivoEnProcesoDTO archivoEnProcesoDTO) {
		this.archivoEnProcesoDTO = archivoEnProcesoDTO;
	}
	
	
	
	
}


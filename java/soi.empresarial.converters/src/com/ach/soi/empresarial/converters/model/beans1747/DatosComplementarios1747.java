package com.ach.soi.empresarial.converters.model.beans1747;

public class DatosComplementarios1747 {

	private String tipoDocumento;
	private String nroDocumento;
	private String novedad;
	private String codigoArl;
	private String claseRiesgo;
	private String indTarifaEspecialPens;
	private String fechaDesde;
	private String fechaHasta;
	private String horasLaboradas;
	private String ibcNovedad;
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public String getNovedad() {
		return novedad;
	}
	public void setNovedad(String novedad) {
		this.novedad = novedad;
	}
	public String getCodigoArl() {
		return codigoArl;
	}
	public void setCodigoArl(String codigoArl) {
		this.codigoArl = codigoArl;
	}
	public String getClaseRiesgo() {
		return claseRiesgo;
	}
	public void setClaseRiesgo(String claseRiesgo) {
		this.claseRiesgo = claseRiesgo;
	}
	public String getIndTarifaEspecialPens() {
		return indTarifaEspecialPens;
	}
	public void setIndTarifaEspecialPens(String indTarifaEspecialPens) {
		this.indTarifaEspecialPens = indTarifaEspecialPens;
	}
	public String getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(String fechaDesde) {
		if ( fechaDesde!=null && fechaDesde.equals("NULL") ){
			fechaDesde = "";
		}
		this.fechaDesde = fechaDesde;
	}
	public String getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(String fechaHasta) {
		if ( fechaHasta!=null && fechaHasta.equals("NULL") ){
			fechaHasta = "";
		}
		this.fechaHasta = fechaHasta;
	}
	public String getHorasLaboradas() {
		return horasLaboradas;
	}
	public void setHorasLaboradas(String horasLaboradas) {
		this.horasLaboradas = horasLaboradas;
	}
	public String getIbcNovedad() {
		return ibcNovedad;
	}
	public void setIbcNovedad(String ibcNovedad) {
		this.ibcNovedad = ibcNovedad;
	}
	
	public String getKey ( ){
		String novedad = this.getNovedad();
		if ( novedad!=null ){
			return this.getTipoDocumento()+":"+this.getNroDocumento()+":"+this.getNovedad();
		}
		return this.getTipoDocumento()+":"+this.getNroDocumento();
		
	}
	
	@Override
	public String toString() {
		return "DatosComplementarios1747Tp02 [tipoDocumento=" + tipoDocumento
				+ ", nroDocumento=" + nroDocumento + ", novedad=" + novedad
				+ ", codigoArl=" + codigoArl + ", claseRiesgo=" + claseRiesgo
				+ ", indTarifaEspecialPens=" + indTarifaEspecialPens
				+ ", fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta
				+ ", horasLaboradas=" + horasLaboradas + ", ibcNovedad="
				+ ibcNovedad + "]";
	}
	
	
	
}

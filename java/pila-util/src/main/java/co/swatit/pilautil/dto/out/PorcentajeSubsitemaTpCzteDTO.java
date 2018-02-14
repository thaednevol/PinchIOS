package co.swatit.pilautil.dto.out;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import co.swatit.pilautil.exception.BusinessException;
import co.swatit.pilautil.generics.Utilities;

public class PorcentajeSubsitemaTpCzteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idSoiPorcSubsTpCot;
	private Integer idSoiTpCotizante;
	private Integer idSoiSubsistema;
	private Integer diasCotizados;
	private BigDecimal porcentaje;
	private String fechaInicioVigencia;
	private Integer vigente;
	private String fechaFinVigencia;

	
	public Long getIdSoiPorcSubsTpCot() {
		return idSoiPorcSubsTpCot;
	}

	public void setIdSoiPorcSubsTpCot(Long idSoiPorcSubsTpCot) {
		this.idSoiPorcSubsTpCot = idSoiPorcSubsTpCot;
	}

	public Integer getIdSoiTpCotizante() {
		return idSoiTpCotizante;
	}

	public void setIdSoiTpCotizante(Integer idSoiTpCotizante) {
		this.idSoiTpCotizante = idSoiTpCotizante;
	}

	public Integer getIdSoiSubsistema() {
		return idSoiSubsistema;
	}

	public void setIdSoiSubsistema(Integer idSoiSubsistema) {
		this.idSoiSubsistema = idSoiSubsistema;
	}

	public Integer getDiasCotizados() {
		return diasCotizados;
	}

	public void setDiasCotizados(Integer diasCotizados) {
		this.diasCotizados = diasCotizados;
	}

	public BigDecimal getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	public void setFechaInicioVigencia(String fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	public Integer getVigente() {
		return vigente;
	}

	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}

	public String getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	public void setFechaFinVigencia(String fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	/**
	 * retorna la fecha final de vigencia si esta es diferente de 
	 * nulo (hay valor en la base de datos) o la fecha actual
	 * si esta en nulo la fecha de fin de vigencia del registro.
	 * @return
	 * @throws BusinessException 
	 */
	public String getFechaFinVigenciaNullEsActual() throws BusinessException {
		String resultado = fechaFinVigencia;
		if (resultado == null) {
			Calendar fecha =  Calendar.getInstance();
			// Agregar un a�o para asegurar que se tome como vigente
			fecha.add(Calendar.YEAR, 1);
			resultado = Utilities.convertCalendarToString(fecha);
		}
		
		return resultado;
	}
}

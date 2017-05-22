/**
 * 
 */
package co.swatit.pilautil.dto.out;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de transporte resultado de la conversión de objetos de tipo
 * {@link com.ach.arc.biz.transfer.ArchivoEnProcesoDTO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class ArchivoEnProcesoDTO implements Serializable {
	/**
	 * Constante de serialización
	 */
	private static final long serialVersionUID = 1L;
	private Long idArchivoEnProceso;
	private String pathArchivo;
	private Long idAportante;
	private String estadoProcesosArchivoPlanoType;
	private Long idSegUsuario;
	private String nombreArchivo;
	private Long idSoiPlanilla;
	private String idNumeroDePlanilla;
	private String notificacionDeArchivoEnProcesoType;
	private Integer numeroTotalDeEmpleadosEnPlanilla;
	private String nombreAportante;
	private String codTpDocAportante;
	private String nroDocAportante;
	private String periodoSalud;
	private String periodoNoSalud;
	private String codTipoPlanilla;
	private Integer idSoiTpPlanillaAsociada;
	private Boolean usuarioAceptaPlanillaMNPagadaPorEsteOperador;
	private Boolean usuarioAceptaRetroactivoPlanillaPublica;
	private Boolean usuarioCertificaCalculoInteresesMora;
	private Boolean enProcesoDeReValidacion;
	private InformacionPlanillaMNCorregidaDTO informacionPlanillaMNCorregidaDTO;
	private String numeroPlanillaAsociada;
	private String fechaPlanillaAsociada;
	private String tipoFormaPresentacionType;
	private String codigoSucursal;
	private Boolean modificarPlanillaReferida;
	private Boolean aceptaRenunciaLey1233;
	private Boolean usuarioAceptaDescuentoPymes;
	private Boolean planillaCorrector;
	private Long idTmpCorrector;
	private Long idEstadoProcesoCorrector;
	private String urlArchivosCorrecciones;
	private Boolean aceptoAutocorreccion;
	private Boolean generarErroresNoCorregibles;
	private Boolean convertidor;
	private Boolean aportanteLey1607;
	private Boolean aportanteLey1429;
	private Boolean validarSoloRegistrosT02;
	private Boolean pnllaArchivoEdicion;
	private Boolean contieneArchivoTipo1Consolidado;
	private Boolean esPlanillaTipoU;
	private Boolean existeApteNsoiPlanillaU;
	private Integer idClaseAptePlanillaU;
	private List<String> epsModificadaBDUA;
	private Boolean incluirNombres;
	private Boolean incluirAdministradoras;
	private Boolean administradoraArchivo;
	private Boolean aplicaValidacionPlanillaPrevia;
	private Boolean edicionRegTp2Corrector;
	private Integer idSoiTpEmpresa;

	/**
	 * Método getter del atributo idArchivoEnProceso de la clase ArchivoEnProcesoDTO
	 *
	 * @return the idArchivoEnProceso
	 */
	public Long getIdArchivoEnProceso() {
		return idArchivoEnProceso;
	}

	/**
	 * Método setter del atributo idArchivoEnProceso de la clase ArchivoEnProcesoDTO
	 *
	 * @param idArchivoEnProceso
	 *            the idArchivoEnProceso to set
	 */
	public void setIdArchivoEnProceso(Long idArchivoEnProceso) {
		this.idArchivoEnProceso = idArchivoEnProceso;
	}

	/**
	 * Método getter del atributo pathArchivo de la clase ArchivoEnProcesoDTO
	 *
	 * @return the pathArchivo
	 */
	public String getPathArchivo() {
		return pathArchivo;
	}

	/**
	 * Método setter del atributo pathArchivo de la clase ArchivoEnProcesoDTO
	 *
	 * @param pathArchivo
	 *            the pathArchivo to set
	 */
	public void setPathArchivo(String pathArchivo) {
		this.pathArchivo = pathArchivo;
	}

	/**
	 * Método getter del atributo idAportante de la clase ArchivoEnProcesoDTO
	 *
	 * @return the idAportante
	 */
	public Long getIdAportante() {
		return idAportante;
	}

	/**
	 * Método setter del atributo idAportante de la clase ArchivoEnProcesoDTO
	 *
	 * @param idAportante
	 *            the idAportante to set
	 */
	public void setIdAportante(Long idAportante) {
		this.idAportante = idAportante;
	}

	/**
	 * Método getter del atributo estadoProcesosArchivoPlanoType de la clase ArchivoEnProcesoDTO
	 *
	 * @return the estadoProcesosArchivoPlanoType
	 */
	public String getEstadoProcesosArchivoPlanoType() {
		return estadoProcesosArchivoPlanoType;
	}

	/**
	 * Método setter del atributo estadoProcesosArchivoPlanoType de la clase ArchivoEnProcesoDTO
	 *
	 * @param estadoProcesosArchivoPlanoType
	 *            the estadoProcesosArchivoPlanoType to set
	 */
	public void setEstadoProcesosArchivoPlanoType(String estadoProcesosArchivoPlanoType) {
		this.estadoProcesosArchivoPlanoType = estadoProcesosArchivoPlanoType;
	}

	/**
	 * Método getter del atributo idSegUsuario de la clase ArchivoEnProcesoDTO
	 *
	 * @return the idSegUsuario
	 */
	public Long getIdSegUsuario() {
		return idSegUsuario;
	}

	/**
	 * Método setter del atributo idSegUsuario de la clase ArchivoEnProcesoDTO
	 *
	 * @param idSegUsuario
	 *            the idSegUsuario to set
	 */
	public void setIdSegUsuario(Long idSegUsuario) {
		this.idSegUsuario = idSegUsuario;
	}

	/**
	 * Método getter del atributo nombreArchivo de la clase ArchivoEnProcesoDTO
	 *
	 * @return the nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	/**
	 * Método setter del atributo nombreArchivo de la clase ArchivoEnProcesoDTO
	 *
	 * @param nombreArchivo
	 *            the nombreArchivo to set
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	/**
	 * Método getter del atributo idSoiPlanilla de la clase ArchivoEnProcesoDTO
	 *
	 * @return the idSoiPlanilla
	 */
	public Long getIdSoiPlanilla() {
		return idSoiPlanilla;
	}

	/**
	 * Método setter del atributo idSoiPlanilla de la clase ArchivoEnProcesoDTO
	 *
	 * @param idSoiPlanilla
	 *            the idSoiPlanilla to set
	 */
	public void setIdSoiPlanilla(Long idSoiPlanilla) {
		this.idSoiPlanilla = idSoiPlanilla;
	}

	/**
	 * Método getter del atributo idNumeroDePlanilla de la clase ArchivoEnProcesoDTO
	 *
	 * @return the idNumeroDePlanilla
	 */
	public String getIdNumeroDePlanilla() {
		return idNumeroDePlanilla;
	}

	/**
	 * Método setter del atributo idNumeroDePlanilla de la clase ArchivoEnProcesoDTO
	 *
	 * @param idNumeroDePlanilla
	 *            the idNumeroDePlanilla to set
	 */
	public void setIdNumeroDePlanilla(String idNumeroDePlanilla) {
		this.idNumeroDePlanilla = idNumeroDePlanilla;
	}

	/**
	 * Método getter del atributo notificacionDeArchivoEnProcesoType de la clase ArchivoEnProcesoDTO
	 *
	 * @return the notificacionDeArchivoEnProcesoType
	 */
	public String getNotificacionDeArchivoEnProcesoType() {
		return notificacionDeArchivoEnProcesoType;
	}

	/**
	 * Método setter del atributo notificacionDeArchivoEnProcesoType de la clase ArchivoEnProcesoDTO
	 *
	 * @param notificacionDeArchivoEnProcesoType
	 *            the notificacionDeArchivoEnProcesoType to set
	 */
	public void setNotificacionDeArchivoEnProcesoType(String notificacionDeArchivoEnProcesoType) {
		this.notificacionDeArchivoEnProcesoType = notificacionDeArchivoEnProcesoType;
	}

	/**
	 * Método getter del atributo numeroTotalDeEmpleadosEnPlanilla de la clase ArchivoEnProcesoDTO
	 *
	 * @return the numeroTotalDeEmpleadosEnPlanilla
	 */
	public Integer getNumeroTotalDeEmpleadosEnPlanilla() {
		return numeroTotalDeEmpleadosEnPlanilla;
	}

	/**
	 * Método setter del atributo numeroTotalDeEmpleadosEnPlanilla de la clase ArchivoEnProcesoDTO
	 *
	 * @param numeroTotalDeEmpleadosEnPlanilla
	 *            the numeroTotalDeEmpleadosEnPlanilla to set
	 */
	public void setNumeroTotalDeEmpleadosEnPlanilla(Integer numeroTotalDeEmpleadosEnPlanilla) {
		this.numeroTotalDeEmpleadosEnPlanilla = numeroTotalDeEmpleadosEnPlanilla;
	}

	/**
	 * Método getter del atributo nombreAportante de la clase ArchivoEnProcesoDTO
	 *
	 * @return the nombreAportante
	 */
	public String getNombreAportante() {
		return nombreAportante;
	}

	/**
	 * Método setter del atributo nombreAportante de la clase ArchivoEnProcesoDTO
	 *
	 * @param nombreAportante
	 *            the nombreAportante to set
	 */
	public void setNombreAportante(String nombreAportante) {
		this.nombreAportante = nombreAportante;
	}

	/**
	 * Método getter del atributo codTpDocAportante de la clase ArchivoEnProcesoDTO
	 *
	 * @return the codTpDocAportante
	 */
	public String getCodTpDocAportante() {
		return codTpDocAportante;
	}

	/**
	 * Método setter del atributo codTpDocAportante de la clase ArchivoEnProcesoDTO
	 *
	 * @param codTpDocAportante
	 *            the codTpDocAportante to set
	 */
	public void setCodTpDocAportante(String codTpDocAportante) {
		this.codTpDocAportante = codTpDocAportante;
	}

	/**
	 * Método getter del atributo nroDocAportante de la clase ArchivoEnProcesoDTO
	 *
	 * @return the nroDocAportante
	 */
	public String getNroDocAportante() {
		return nroDocAportante;
	}

	/**
	 * Método setter del atributo nroDocAportante de la clase ArchivoEnProcesoDTO
	 *
	 * @param nroDocAportante
	 *            the nroDocAportante to set
	 */
	public void setNroDocAportante(String nroDocAportante) {
		this.nroDocAportante = nroDocAportante;
	}

	/**
	 * Método getter del atributo periodoSalud de la clase ArchivoEnProcesoDTO
	 *
	 * @return the periodoSalud
	 */
	public String getPeriodoSalud() {
		return periodoSalud;
	}

	/**
	 * Método setter del atributo periodoSalud de la clase ArchivoEnProcesoDTO
	 *
	 * @param periodoSalud
	 *            the periodoSalud to set
	 */
	public void setPeriodoSalud(String periodoSalud) {
		this.periodoSalud = periodoSalud;
	}

	/**
	 * Método getter del atributo periodoNoSalud de la clase ArchivoEnProcesoDTO
	 *
	 * @return the periodoNoSalud
	 */
	public String getPeriodoNoSalud() {
		return periodoNoSalud;
	}

	/**
	 * Método setter del atributo periodoNoSalud de la clase ArchivoEnProcesoDTO
	 *
	 * @param periodoNoSalud
	 *            the periodoNoSalud to set
	 */
	public void setPeriodoNoSalud(String periodoNoSalud) {
		this.periodoNoSalud = periodoNoSalud;
	}

	/**
	 * Método getter del atributo codTipoPlanilla de la clase ArchivoEnProcesoDTO
	 *
	 * @return the codTipoPlanilla
	 */
	public String getCodTipoPlanilla() {
		return codTipoPlanilla;
	}

	/**
	 * Método setter del atributo codTipoPlanilla de la clase ArchivoEnProcesoDTO
	 *
	 * @param codTipoPlanilla
	 *            the codTipoPlanilla to set
	 */
	public void setCodTipoPlanilla(String codTipoPlanilla) {
		this.codTipoPlanilla = codTipoPlanilla;
	}

	/**
	 * Método getter del atributo idSoiTpPlanillaAsociada de la clase ArchivoEnProcesoDTO
	 *
	 * @return the idSoiTpPlanillaAsociada
	 */
	public Integer getIdSoiTpPlanillaAsociada() {
		return idSoiTpPlanillaAsociada;
	}

	/**
	 * Método setter del atributo idSoiTpPlanillaAsociada de la clase ArchivoEnProcesoDTO
	 *
	 * @param idSoiTpPlanillaAsociada
	 *            the idSoiTpPlanillaAsociada to set
	 */
	public void setIdSoiTpPlanillaAsociada(Integer idSoiTpPlanillaAsociada) {
		this.idSoiTpPlanillaAsociada = idSoiTpPlanillaAsociada;
	}

	/**
	 * Método getter del atributo usuarioAceptaPlanillaMNPagadaPorEsteOperador de la clase ArchivoEnProcesoDTO
	 *
	 * @return the usuarioAceptaPlanillaMNPagadaPorEsteOperador
	 */
	public Boolean getUsuarioAceptaPlanillaMNPagadaPorEsteOperador() {
		return usuarioAceptaPlanillaMNPagadaPorEsteOperador;
	}

	/**
	 * Método setter del atributo usuarioAceptaPlanillaMNPagadaPorEsteOperador de la clase ArchivoEnProcesoDTO
	 *
	 * @param usuarioAceptaPlanillaMNPagadaPorEsteOperador
	 *            the usuarioAceptaPlanillaMNPagadaPorEsteOperador to set
	 */
	public void setUsuarioAceptaPlanillaMNPagadaPorEsteOperador(Boolean usuarioAceptaPlanillaMNPagadaPorEsteOperador) {
		this.usuarioAceptaPlanillaMNPagadaPorEsteOperador = usuarioAceptaPlanillaMNPagadaPorEsteOperador;
	}

	/**
	 * Método getter del atributo usuarioAceptaRetroactivoPlanillaPublica de la clase ArchivoEnProcesoDTO
	 *
	 * @return the usuarioAceptaRetroactivoPlanillaPublica
	 */
	public Boolean getUsuarioAceptaRetroactivoPlanillaPublica() {
		return usuarioAceptaRetroactivoPlanillaPublica;
	}

	/**
	 * Método setter del atributo usuarioAceptaRetroactivoPlanillaPublica de la clase ArchivoEnProcesoDTO
	 *
	 * @param usuarioAceptaRetroactivoPlanillaPublica
	 *            the usuarioAceptaRetroactivoPlanillaPublica to set
	 */
	public void setUsuarioAceptaRetroactivoPlanillaPublica(Boolean usuarioAceptaRetroactivoPlanillaPublica) {
		this.usuarioAceptaRetroactivoPlanillaPublica = usuarioAceptaRetroactivoPlanillaPublica;
	}

	/**
	 * Método getter del atributo usuarioCertificaCalculoInteresesMora de la clase ArchivoEnProcesoDTO
	 *
	 * @return the usuarioCertificaCalculoInteresesMora
	 */
	public Boolean getUsuarioCertificaCalculoInteresesMora() {
		return usuarioCertificaCalculoInteresesMora;
	}

	/**
	 * Método setter del atributo usuarioCertificaCalculoInteresesMora de la clase ArchivoEnProcesoDTO
	 *
	 * @param usuarioCertificaCalculoInteresesMora
	 *            the usuarioCertificaCalculoInteresesMora to set
	 */
	public void setUsuarioCertificaCalculoInteresesMora(Boolean usuarioCertificaCalculoInteresesMora) {
		this.usuarioCertificaCalculoInteresesMora = usuarioCertificaCalculoInteresesMora;
	}

	/**
	 * Método getter del atributo enProcesoDeReValidacion de la clase ArchivoEnProcesoDTO
	 *
	 * @return the enProcesoDeReValidacion
	 */
	public Boolean getEnProcesoDeReValidacion() {
		return enProcesoDeReValidacion;
	}

	/**
	 * Método setter del atributo enProcesoDeReValidacion de la clase ArchivoEnProcesoDTO
	 *
	 * @param enProcesoDeReValidacion
	 *            the enProcesoDeReValidacion to set
	 */
	public void setEnProcesoDeReValidacion(Boolean enProcesoDeReValidacion) {
		this.enProcesoDeReValidacion = enProcesoDeReValidacion;
	}

	/**
	 * Método getter del atributo informacionPlanillaMNCorregidaDTO de la clase ArchivoEnProcesoDTO
	 *
	 * @return the informacionPlanillaMNCorregidaDTO
	 */
	public InformacionPlanillaMNCorregidaDTO getInformacionPlanillaMNCorregidaDTO() {
		return informacionPlanillaMNCorregidaDTO;
	}

	/**
	 * Método setter del atributo informacionPlanillaMNCorregidaDTO de la clase ArchivoEnProcesoDTO
	 *
	 * @param informacionPlanillaMNCorregidaDTO
	 *            the informacionPlanillaMNCorregidaDTO to set
	 */
	public void setInformacionPlanillaMNCorregidaDTO(InformacionPlanillaMNCorregidaDTO informacionPlanillaMNCorregidaDTO) {
		this.informacionPlanillaMNCorregidaDTO = informacionPlanillaMNCorregidaDTO;
	}

	/**
	 * Método getter del atributo numeroPlanillaAsociada de la clase ArchivoEnProcesoDTO
	 *
	 * @return the numeroPlanillaAsociada
	 */
	public String getNumeroPlanillaAsociada() {
		return numeroPlanillaAsociada;
	}

	/**
	 * Método setter del atributo numeroPlanillaAsociada de la clase ArchivoEnProcesoDTO
	 *
	 * @param numeroPlanillaAsociada
	 *            the numeroPlanillaAsociada to set
	 */
	public void setNumeroPlanillaAsociada(String numeroPlanillaAsociada) {
		this.numeroPlanillaAsociada = numeroPlanillaAsociada;
	}

	/**
	 * Método getter del atributo fechaPlanillaAsociada de la clase ArchivoEnProcesoDTO
	 *
	 * @return the fechaPlanillaAsociada
	 */
	public String getFechaPlanillaAsociada() {
		return fechaPlanillaAsociada;
	}

	/**
	 * Método setter del atributo fechaPlanillaAsociada de la clase ArchivoEnProcesoDTO
	 *
	 * @param fechaPlanillaAsociada
	 *            the fechaPlanillaAsociada to set
	 */
	public void setFechaPlanillaAsociada(String fechaPlanillaAsociada) {
		this.fechaPlanillaAsociada = fechaPlanillaAsociada;
	}

	/**
	 * Método getter del atributo tipoFormaPresentacionType de la clase ArchivoEnProcesoDTO
	 *
	 * @return the tipoFormaPresentacionType
	 */
	public String getTipoFormaPresentacionType() {
		return tipoFormaPresentacionType;
	}

	/**
	 * Método setter del atributo tipoFormaPresentacionType de la clase ArchivoEnProcesoDTO
	 *
	 * @param tipoFormaPresentacionType
	 *            the tipoFormaPresentacionType to set
	 */
	public void setTipoFormaPresentacionType(String tipoFormaPresentacionType) {
		this.tipoFormaPresentacionType = tipoFormaPresentacionType;
	}

	/**
	 * Método getter del atributo codigoSucursal de la clase ArchivoEnProcesoDTO
	 *
	 * @return the codigoSucursal
	 */
	public String getCodigoSucursal() {
		return codigoSucursal;
	}

	/**
	 * Método setter del atributo codigoSucursal de la clase ArchivoEnProcesoDTO
	 *
	 * @param codigoSucursal
	 *            the codigoSucursal to set
	 */
	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}

	/**
	 * Método getter del atributo modificarPlanillaReferida de la clase ArchivoEnProcesoDTO
	 *
	 * @return the modificarPlanillaReferida
	 */
	public Boolean getModificarPlanillaReferida() {
		return modificarPlanillaReferida;
	}

	/**
	 * Método setter del atributo modificarPlanillaReferida de la clase ArchivoEnProcesoDTO
	 *
	 * @param modificarPlanillaReferida
	 *            the modificarPlanillaReferida to set
	 */
	public void setModificarPlanillaReferida(Boolean modificarPlanillaReferida) {
		this.modificarPlanillaReferida = modificarPlanillaReferida;
	}

	/**
	 * Método getter del atributo aceptaRenunciaLey1233 de la clase ArchivoEnProcesoDTO
	 *
	 * @return the aceptaRenunciaLey1233
	 */
	public Boolean getAceptaRenunciaLey1233() {
		return aceptaRenunciaLey1233;
	}

	/**
	 * Método setter del atributo aceptaRenunciaLey1233 de la clase ArchivoEnProcesoDTO
	 *
	 * @param aceptaRenunciaLey1233
	 *            the aceptaRenunciaLey1233 to set
	 */
	public void setAceptaRenunciaLey1233(Boolean aceptaRenunciaLey1233) {
		this.aceptaRenunciaLey1233 = aceptaRenunciaLey1233;
	}

	/**
	 * Método getter del atributo usuarioAceptaDescuentoPymes de la clase ArchivoEnProcesoDTO
	 *
	 * @return the usuarioAceptaDescuentoPymes
	 */
	public Boolean getUsuarioAceptaDescuentoPymes() {
		return usuarioAceptaDescuentoPymes;
	}

	/**
	 * Método setter del atributo usuarioAceptaDescuentoPymes de la clase ArchivoEnProcesoDTO
	 *
	 * @param usuarioAceptaDescuentoPymes
	 *            the usuarioAceptaDescuentoPymes to set
	 */
	public void setUsuarioAceptaDescuentoPymes(Boolean usuarioAceptaDescuentoPymes) {
		this.usuarioAceptaDescuentoPymes = usuarioAceptaDescuentoPymes;
	}

	/**
	 * Método getter del atributo planillaCorrector de la clase ArchivoEnProcesoDTO
	 *
	 * @return the planillaCorrector
	 */
	public Boolean getPlanillaCorrector() {
		return planillaCorrector;
	}

	/**
	 * Método setter del atributo planillaCorrector de la clase ArchivoEnProcesoDTO
	 *
	 * @param planillaCorrector
	 *            the planillaCorrector to set
	 */
	public void setPlanillaCorrector(Boolean planillaCorrector) {
		this.planillaCorrector = planillaCorrector;
	}

	/**
	 * Método getter del atributo idTmpCorrector de la clase ArchivoEnProcesoDTO
	 *
	 * @return the idTmpCorrector
	 */
	public Long getIdTmpCorrector() {
		return idTmpCorrector;
	}

	/**
	 * Método setter del atributo idTmpCorrector de la clase ArchivoEnProcesoDTO
	 *
	 * @param idTmpCorrector
	 *            the idTmpCorrector to set
	 */
	public void setIdTmpCorrector(Long idTmpCorrector) {
		this.idTmpCorrector = idTmpCorrector;
	}

	/**
	 * Método getter del atributo idEstadoProcesoCorrector de la clase ArchivoEnProcesoDTO
	 *
	 * @return the idEstadoProcesoCorrector
	 */
	public Long getIdEstadoProcesoCorrector() {
		return idEstadoProcesoCorrector;
	}

	/**
	 * Método setter del atributo idEstadoProcesoCorrector de la clase ArchivoEnProcesoDTO
	 *
	 * @param idEstadoProcesoCorrector
	 *            the idEstadoProcesoCorrector to set
	 */
	public void setIdEstadoProcesoCorrector(Long idEstadoProcesoCorrector) {
		this.idEstadoProcesoCorrector = idEstadoProcesoCorrector;
	}

	/**
	 * Método getter del atributo urlArchivosCorrecciones de la clase ArchivoEnProcesoDTO
	 *
	 * @return the urlArchivosCorrecciones
	 */
	public String getUrlArchivosCorrecciones() {
		return urlArchivosCorrecciones;
	}

	/**
	 * Método setter del atributo urlArchivosCorrecciones de la clase ArchivoEnProcesoDTO
	 *
	 * @param urlArchivosCorrecciones
	 *            the urlArchivosCorrecciones to set
	 */
	public void setUrlArchivosCorrecciones(String urlArchivosCorrecciones) {
		this.urlArchivosCorrecciones = urlArchivosCorrecciones;
	}

	/**
	 * Método getter del atributo aceptoAutocorreccion de la clase ArchivoEnProcesoDTO
	 *
	 * @return the aceptoAutocorreccion
	 */
	public Boolean getAceptoAutocorreccion() {
		return aceptoAutocorreccion;
	}

	/**
	 * Método setter del atributo aceptoAutocorreccion de la clase ArchivoEnProcesoDTO
	 *
	 * @param aceptoAutocorreccion
	 *            the aceptoAutocorreccion to set
	 */
	public void setAceptoAutocorreccion(Boolean aceptoAutocorreccion) {
		this.aceptoAutocorreccion = aceptoAutocorreccion;
	}

	/**
	 * Método getter del atributo generarErroresNoCorregibles de la clase ArchivoEnProcesoDTO
	 *
	 * @return the generarErroresNoCorregibles
	 */
	public Boolean getGenerarErroresNoCorregibles() {
		return generarErroresNoCorregibles;
	}

	/**
	 * Método setter del atributo generarErroresNoCorregibles de la clase ArchivoEnProcesoDTO
	 *
	 * @param generarErroresNoCorregibles
	 *            the generarErroresNoCorregibles to set
	 */
	public void setGenerarErroresNoCorregibles(Boolean generarErroresNoCorregibles) {
		this.generarErroresNoCorregibles = generarErroresNoCorregibles;
	}

	/**
	 * Método getter del atributo convertidor de la clase ArchivoEnProcesoDTO
	 *
	 * @return the convertidor
	 */
	public Boolean getConvertidor() {
		return convertidor;
	}

	/**
	 * Método setter del atributo convertidor de la clase ArchivoEnProcesoDTO
	 *
	 * @param convertidor
	 *            the convertidor to set
	 */
	public void setConvertidor(Boolean convertidor) {
		this.convertidor = convertidor;
	}

	/**
	 * Método getter del atributo aportanteLey1607 de la clase ArchivoEnProcesoDTO
	 *
	 * @return the aportanteLey1607
	 */
	public Boolean getAportanteLey1607() {
		return aportanteLey1607;
	}

	/**
	 * Método setter del atributo aportanteLey1607 de la clase ArchivoEnProcesoDTO
	 *
	 * @param aportanteLey1607
	 *            the aportanteLey1607 to set
	 */
	public void setAportanteLey1607(Boolean aportanteLey1607) {
		this.aportanteLey1607 = aportanteLey1607;
	}

	/**
	 * Método getter del atributo aportanteLey1429 de la clase ArchivoEnProcesoDTO
	 *
	 * @return the aportanteLey1429
	 */
	public Boolean getAportanteLey1429() {
		return aportanteLey1429;
	}

	/**
	 * Método setter del atributo aportanteLey1429 de la clase ArchivoEnProcesoDTO
	 *
	 * @param aportanteLey1429
	 *            the aportanteLey1429 to set
	 */
	public void setAportanteLey1429(Boolean aportanteLey1429) {
		this.aportanteLey1429 = aportanteLey1429;
	}

	/**
	 * Método getter del atributo validarSoloRegistrosT02 de la clase ArchivoEnProcesoDTO
	 *
	 * @return the validarSoloRegistrosT02
	 */
	public Boolean getValidarSoloRegistrosT02() {
		return validarSoloRegistrosT02;
	}

	/**
	 * Método setter del atributo validarSoloRegistrosT02 de la clase ArchivoEnProcesoDTO
	 *
	 * @param validarSoloRegistrosT02
	 *            the validarSoloRegistrosT02 to set
	 */
	public void setValidarSoloRegistrosT02(Boolean validarSoloRegistrosT02) {
		this.validarSoloRegistrosT02 = validarSoloRegistrosT02;
	}

	/**
	 * Método getter del atributo pnllaArchivoEdicion de la clase ArchivoEnProcesoDTO
	 *
	 * @return the pnllaArchivoEdicion
	 */
	public Boolean getPnllaArchivoEdicion() {
		return pnllaArchivoEdicion;
	}

	/**
	 * Método setter del atributo pnllaArchivoEdicion de la clase ArchivoEnProcesoDTO
	 *
	 * @param pnllaArchivoEdicion
	 *            the pnllaArchivoEdicion to set
	 */
	public void setPnllaArchivoEdicion(Boolean pnllaArchivoEdicion) {
		this.pnllaArchivoEdicion = pnllaArchivoEdicion;
	}

	/**
	 * Método getter del atributo contieneArchivoTipo1Consolidado de la clase ArchivoEnProcesoDTO
	 *
	 * @return the contieneArchivoTipo1Consolidado
	 */
	public Boolean getContieneArchivoTipo1Consolidado() {
		return contieneArchivoTipo1Consolidado;
	}

	/**
	 * Método setter del atributo contieneArchivoTipo1Consolidado de la clase ArchivoEnProcesoDTO
	 *
	 * @param contieneArchivoTipo1Consolidado
	 *            the contieneArchivoTipo1Consolidado to set
	 */
	public void setContieneArchivoTipo1Consolidado(Boolean contieneArchivoTipo1Consolidado) {
		this.contieneArchivoTipo1Consolidado = contieneArchivoTipo1Consolidado;
	}

	/**
	 * Método getter del atributo esPlanillaTipoU de la clase ArchivoEnProcesoDTO
	 *
	 * @return the esPlanillaTipoU
	 */
	public Boolean getEsPlanillaTipoU() {
		return esPlanillaTipoU;
	}

	/**
	 * Método setter del atributo esPlanillaTipoU de la clase ArchivoEnProcesoDTO
	 *
	 * @param esPlanillaTipoU
	 *            the esPlanillaTipoU to set
	 */
	public void setEsPlanillaTipoU(Boolean esPlanillaTipoU) {
		this.esPlanillaTipoU = esPlanillaTipoU;
	}

	/**
	 * Método getter del atributo existeApteNsoiPlanillaU de la clase ArchivoEnProcesoDTO
	 *
	 * @return the existeApteNsoiPlanillaU
	 */
	public Boolean getExisteApteNsoiPlanillaU() {
		return existeApteNsoiPlanillaU;
	}

	/**
	 * Método setter del atributo existeApteNsoiPlanillaU de la clase ArchivoEnProcesoDTO
	 *
	 * @param existeApteNsoiPlanillaU
	 *            the existeApteNsoiPlanillaU to set
	 */
	public void setExisteApteNsoiPlanillaU(Boolean existeApteNsoiPlanillaU) {
		this.existeApteNsoiPlanillaU = existeApteNsoiPlanillaU;
	}

	/**
	 * Método getter del atributo idClaseAptePlanillaU de la clase ArchivoEnProcesoDTO
	 *
	 * @return the idClaseAptePlanillaU
	 */
	public Integer getIdClaseAptePlanillaU() {
		return idClaseAptePlanillaU;
	}

	/**
	 * Método setter del atributo idClaseAptePlanillaU de la clase ArchivoEnProcesoDTO
	 *
	 * @param idClaseAptePlanillaU
	 *            the idClaseAptePlanillaU to set
	 */
	public void setIdClaseAptePlanillaU(Integer idClaseAptePlanillaU) {
		this.idClaseAptePlanillaU = idClaseAptePlanillaU;
	}

	/**
	 * Método getter del atributo incluirNombres de la clase ArchivoEnProcesoDTO
	 *
	 * @return the incluirNombres
	 */
	public Boolean getIncluirNombres() {
		return incluirNombres;
	}

	/**
	 * Método setter del atributo incluirNombres de la clase ArchivoEnProcesoDTO
	 *
	 * @param incluirNombres
	 *            the incluirNombres to set
	 */
	public void setIncluirNombres(Boolean incluirNombres) {
		this.incluirNombres = incluirNombres;
	}

	/**
	 * Método getter del atributo incluirAdministradoras de la clase ArchivoEnProcesoDTO
	 *
	 * @return the incluirAdministradoras
	 */
	public Boolean getIncluirAdministradoras() {
		return incluirAdministradoras;
	}

	/**
	 * Método setter del atributo incluirAdministradoras de la clase ArchivoEnProcesoDTO
	 *
	 * @param incluirAdministradoras
	 *            the incluirAdministradoras to set
	 */
	public void setIncluirAdministradoras(Boolean incluirAdministradoras) {
		this.incluirAdministradoras = incluirAdministradoras;
	}

	/**
	 * Método getter del atributo administradoraArchivo de la clase ArchivoEnProcesoDTO
	 *
	 * @return the administradoraArchivo
	 */
	public Boolean getAdministradoraArchivo() {
		return administradoraArchivo;
	}

	/**
	 * Método setter del atributo administradoraArchivo de la clase ArchivoEnProcesoDTO
	 *
	 * @param administradoraArchivo
	 *            the administradoraArchivo to set
	 */
	public void setAdministradoraArchivo(Boolean administradoraArchivo) {
		this.administradoraArchivo = administradoraArchivo;
	}

	/**
	 * Método getter del atributo aplicaValidacionPlanillaPrevia de la clase ArchivoEnProcesoDTO
	 *
	 * @return the aplicaValidacionPlanillaPrevia
	 */
	public Boolean getAplicaValidacionPlanillaPrevia() {
		return aplicaValidacionPlanillaPrevia;
	}

	/**
	 * Método setter del atributo aplicaValidacionPlanillaPrevia de la clase ArchivoEnProcesoDTO
	 *
	 * @param aplicaValidacionPlanillaPrevia
	 *            the aplicaValidacionPlanillaPrevia to set
	 */
	public void setAplicaValidacionPlanillaPrevia(Boolean aplicaValidacionPlanillaPrevia) {
		this.aplicaValidacionPlanillaPrevia = aplicaValidacionPlanillaPrevia;
	}

	/**
	 * Método getter del atributo edicionRegTp2Corrector de la clase ArchivoEnProcesoDTO
	 *
	 * @return the edicionRegTp2Corrector
	 */
	public Boolean getEdicionRegTp2Corrector() {
		return edicionRegTp2Corrector;
	}

	/**
	 * Método setter del atributo edicionRegTp2Corrector de la clase ArchivoEnProcesoDTO
	 *
	 * @param edicionRegTp2Corrector
	 *            the edicionRegTp2Corrector to set
	 */
	public void setEdicionRegTp2Corrector(Boolean edicionRegTp2Corrector) {
		this.edicionRegTp2Corrector = edicionRegTp2Corrector;
	}

	/**
	 * Método getter del atributo idSoiTpEmpresa de la clase ArchivoEnProcesoDTO
	 *
	 * @return the idSoiTpEmpresa
	 */
	public Integer getIdSoiTpEmpresa() {
		return idSoiTpEmpresa;
	}

	/**
	 * Método setter del atributo idSoiTpEmpresa de la clase ArchivoEnProcesoDTO
	 *
	 * @param idSoiTpEmpresa
	 *            the idSoiTpEmpresa to set
	 */
	public void setIdSoiTpEmpresa(Integer idSoiTpEmpresa) {
		this.idSoiTpEmpresa = idSoiTpEmpresa;
	}

	/**
	 * Método getter del atributo epsModificadaBDUA de la clase ArchivoEnProcesoDTO
	 *
	 * @return the epsModificadaBDUA
	 */
	public List<String> getEpsModificadaBDUA() {
		if (epsModificadaBDUA == null) {
			epsModificadaBDUA = new ArrayList<String>();
		}
		return epsModificadaBDUA;
	}

}

package co.swatit.pilautil.dto.out;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Objeto de transporte resultado de la conversión de objetos de tipo
 * {@link com.ach.pla.biz.transfer.PlanillaAportanteDTO}
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 13/02/2017
 * @version 1.0
 */
public class PlanillaAportanteDTO implements Serializable {
	/**
	 * Constante de Serialización
	 */
	private static final long serialVersionUID = 1L;
	private InformacionAportantePlanillaDTO informacionAportantePlanillaDTO;
	private String numeroPlanillaActual;
	private String numeroPlanillaAsistida;
	private String numeroPlanillaElectronica;
	private Integer idSoiTpPlanilla;
	private String codigoSoiTpPlanilla;
	private String nombreSoiTpPlanilla;
	private Long numeroTotalEmpleados;
	private Long numeroTotalCotizantes;
	private Long idSucursal;
	private String codigoSucursal;
	private String nombreSucursal;
	private Boolean convertidor;
	private String periodoLiquidacionSalud;
	private String periodoLiquidacionNoSalud;
	private String numeroPlanillaAsocida;
	private String fechaPagoPlanillaAsociada;
	private String fechaPagoPlanillaAsociadaCadena;
	private Integer idSoiTpPlanillaAsociada;
	private String codigoSoiTpPlanillaAsociada;
	private String nombreSoiTpPlanillaAsociada;
	private Integer idSoiAdministradoraARPPlanillaAsociada;
	private String nombreARPPlanillaAsociada;
	private String codAdministradoraARPPlanillaAsociada;
	private String estadoPlanilla;
	private Integer idSoiAdministradoraARP;
	private String codAdministradoraARPPlanilla;
	private Integer idSoiFormaPresentacion;
	private String codSoiFormaPresentacion;
	private String nombreSoiFormaPresentacion;
	private Integer idOperadorPila;
	private Integer formaElaboracionPlanilla;
	private Integer modalidadPlanilla;
	private Long idSoiPlanilla;
	private String nombreArchivoPlano;
	private Boolean tipoPlanillaBloquedada;
	private Boolean claseAportanteBoI;
	private BigDecimal valorPagado;
	private String fechaDePagoEfectiva;
	private Boolean usuarioModificaInformacionAportante;
	private Boolean planilaAsociadaMNExiste;
	private Boolean planilaAsociadaTExiste;
	private Boolean usuarioAceptaPlanillaMNPagadaPorEsteOperador;
	private Boolean planillaPublicaPreguntarSiEsRetroactivo;
	private Boolean usuarioAceptaRetroactivoPlanillaPublica;
	private Boolean certificaCalculoInteresesMora;
	private Integer numeroDiasExistenciaEmpresa;
	private Integer numeroAnosExistenciaEmpresa;
	private Boolean usuarioAceptaDescuentoPymes;
	private InformacionPlanillaMNCorregidaDTO informacionPlanillaMNCorregidaDTO;
	private Boolean recalcularMora;
	private Boolean aportanteLey1607;
	private Boolean aportanteLey1429;
	private Boolean tipoPlanillaAplicaLey1607;
	private Boolean aplicaPeriodoMayorIgualAbr1994;
	private Boolean aplicaPeriodoMenorIgualDic2002;
	private Long idSoiAportante;
	private String codigoTpPlanillaExistente;
	private Boolean existenPlanillasBase;
	private Integer cantidadMaximaErrores;
	private Boolean permiteGeneracionCsv;
	private Long idSoiSoporteUsuario;
	private Boolean existeApteNsoiPlanillaU;
	private Boolean existeApteUgpp;
	private Integer numeroDiasMoraPnllaJ;
	private Boolean edicionPlanillaArchivo;
	private Boolean esPreliquidacion;
	private Boolean aplicaValidacionPlanillaPrevia;
	private Integer idSoiTpEmpresa;
	private Boolean planillaJReferida;
	private Boolean creacionPlanilla;
	private String ipCreacion;
	private Map<String, List<AdministradoraDTO>> administradorasAportante;
	private Map<Integer, List<BigDecimal>> tarifasAportante;
	private String codMunicipioAportante;
	private BigDecimal ivaComision;
	private BigDecimal comision;
	private String codDepartamentoAportante;
	private String direccionAportante;
	private String telefonoAportante;
	private String fax;
	private Long idPlanillaE;
	private Integer numeroCotizantesPermitidos;
	private Integer idSoiEntidadFinanciera;
	private Boolean apteSeccionalFiscalia;
	private Boolean exitePlanillaPreviaResolucion1233;
	private Boolean usuarioSolicitaCambioNormatividad;
	private Map<String, Boolean> normatividad;

	/**
	 * Método getter del atributo informacionAportantePlanillaDTO de la clase PlanillaAportanteDTO
	 *
	 * @return the informacionAportantePlanillaDTO
	 */
	public InformacionAportantePlanillaDTO getInformacionAportantePlanillaDTO() {
		return informacionAportantePlanillaDTO;
	}

	/**
	 * Método setter del atributo informacionAportantePlanillaDTO de la clase PlanillaAportanteDTO
	 *
	 * @param informacionAportantePlanillaDTO
	 *            the informacionAportantePlanillaDTO to set
	 */
	public void setInformacionAportantePlanillaDTO(InformacionAportantePlanillaDTO informacionAportantePlanillaDTO) {
		this.informacionAportantePlanillaDTO = informacionAportantePlanillaDTO;
	}

	/**
	 * Método getter del atributo numeroPlanillaActual de la clase PlanillaAportanteDTO
	 *
	 * @return the numeroPlanillaActual
	 */
	public String getNumeroPlanillaActual() {
		return numeroPlanillaActual;
	}

	/**
	 * Método setter del atributo numeroPlanillaActual de la clase PlanillaAportanteDTO
	 *
	 * @param numeroPlanillaActual
	 *            the numeroPlanillaActual to set
	 */
	public void setNumeroPlanillaActual(String numeroPlanillaActual) {
		this.numeroPlanillaActual = numeroPlanillaActual;
	}

	/**
	 * Método getter del atributo numeroPlanillaAsistida de la clase PlanillaAportanteDTO
	 *
	 * @return the numeroPlanillaAsistida
	 */
	public String getNumeroPlanillaAsistida() {
		return numeroPlanillaAsistida;
	}

	/**
	 * Método setter del atributo numeroPlanillaAsistida de la clase PlanillaAportanteDTO
	 *
	 * @param numeroPlanillaAsistida
	 *            the numeroPlanillaAsistida to set
	 */
	public void setNumeroPlanillaAsistida(String numeroPlanillaAsistida) {
		this.numeroPlanillaAsistida = numeroPlanillaAsistida;
	}

	/**
	 * Método getter del atributo numeroPlanillaElectronica de la clase PlanillaAportanteDTO
	 *
	 * @return the numeroPlanillaElectronica
	 */
	public String getNumeroPlanillaElectronica() {
		return numeroPlanillaElectronica;
	}

	/**
	 * Método setter del atributo numeroPlanillaElectronica de la clase PlanillaAportanteDTO
	 *
	 * @param numeroPlanillaElectronica
	 *            the numeroPlanillaElectronica to set
	 */
	public void setNumeroPlanillaElectronica(String numeroPlanillaElectronica) {
		this.numeroPlanillaElectronica = numeroPlanillaElectronica;
	}

	/**
	 * Método getter del atributo idSoiTpPlanilla de la clase PlanillaAportanteDTO
	 *
	 * @return the idSoiTpPlanilla
	 */
	public Integer getIdSoiTpPlanilla() {
		return idSoiTpPlanilla;
	}

	/**
	 * Método setter del atributo idSoiTpPlanilla de la clase PlanillaAportanteDTO
	 *
	 * @param idSoiTpPlanilla
	 *            the idSoiTpPlanilla to set
	 */
	public void setIdSoiTpPlanilla(Integer idSoiTpPlanilla) {
		this.idSoiTpPlanilla = idSoiTpPlanilla;
	}

	/**
	 * Método getter del atributo codigoSoiTpPlanilla de la clase PlanillaAportanteDTO
	 *
	 * @return the codigoSoiTpPlanilla
	 */
	public String getCodigoSoiTpPlanilla() {
		return codigoSoiTpPlanilla;
	}

	/**
	 * Método setter del atributo codigoSoiTpPlanilla de la clase PlanillaAportanteDTO
	 *
	 * @param codigoSoiTpPlanilla
	 *            the codigoSoiTpPlanilla to set
	 */
	public void setCodigoSoiTpPlanilla(String codigoSoiTpPlanilla) {
		this.codigoSoiTpPlanilla = codigoSoiTpPlanilla;
	}

	/**
	 * Método getter del atributo nombreSoiTpPlanilla de la clase PlanillaAportanteDTO
	 *
	 * @return the nombreSoiTpPlanilla
	 */
	public String getNombreSoiTpPlanilla() {
		return nombreSoiTpPlanilla;
	}

	/**
	 * Método setter del atributo nombreSoiTpPlanilla de la clase PlanillaAportanteDTO
	 *
	 * @param nombreSoiTpPlanilla
	 *            the nombreSoiTpPlanilla to set
	 */
	public void setNombreSoiTpPlanilla(String nombreSoiTpPlanilla) {
		this.nombreSoiTpPlanilla = nombreSoiTpPlanilla;
	}

	/**
	 * Método getter del atributo numeroTotalEmpleados de la clase PlanillaAportanteDTO
	 *
	 * @return the numeroTotalEmpleados
	 */
	public Long getNumeroTotalEmpleados() {
		return numeroTotalEmpleados;
	}

	/**
	 * Método setter del atributo numeroTotalEmpleados de la clase PlanillaAportanteDTO
	 *
	 * @param numeroTotalEmpleados
	 *            the numeroTotalEmpleados to set
	 */
	public void setNumeroTotalEmpleados(Long numeroTotalEmpleados) {
		this.numeroTotalEmpleados = numeroTotalEmpleados;
	}

	/**
	 * Método getter del atributo numeroTotalCotizantes de la clase PlanillaAportanteDTO
	 *
	 * @return the numeroTotalCotizantes
	 */
	public Long getNumeroTotalCotizantes() {
		return numeroTotalCotizantes;
	}

	/**
	 * Método setter del atributo numeroTotalCotizantes de la clase PlanillaAportanteDTO
	 *
	 * @param numeroTotalCotizantes
	 *            the numeroTotalCotizantes to set
	 */
	public void setNumeroTotalCotizantes(Long numeroTotalCotizantes) {
		this.numeroTotalCotizantes = numeroTotalCotizantes;
	}

	/**
	 * Método getter del atributo idSucursal de la clase PlanillaAportanteDTO
	 *
	 * @return the idSucursal
	 */
	public Long getIdSucursal() {
		return idSucursal;
	}

	/**
	 * Método setter del atributo idSucursal de la clase PlanillaAportanteDTO
	 *
	 * @param idSucursal
	 *            the idSucursal to set
	 */
	public void setIdSucursal(Long idSucursal) {
		this.idSucursal = idSucursal;
	}

	/**
	 * Método getter del atributo codigoSucursal de la clase PlanillaAportanteDTO
	 *
	 * @return the codigoSucursal
	 */
	public String getCodigoSucursal() {
		return codigoSucursal;
	}

	/**
	 * Método setter del atributo codigoSucursal de la clase PlanillaAportanteDTO
	 *
	 * @param codigoSucursal
	 *            the codigoSucursal to set
	 */
	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}

	/**
	 * Método getter del atributo nombreSucursal de la clase PlanillaAportanteDTO
	 *
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * Método setter del atributo nombreSucursal de la clase PlanillaAportanteDTO
	 *
	 * @param nombreSucursal
	 *            the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	/**
	 * Método getter del atributo convertidor de la clase PlanillaAportanteDTO
	 *
	 * @return the convertidor
	 */
	public Boolean getConvertidor() {
		return convertidor;
	}

	/**
	 * Método setter del atributo convertidor de la clase PlanillaAportanteDTO
	 *
	 * @param convertidor
	 *            the convertidor to set
	 */
	public void setConvertidor(Boolean convertidor) {
		this.convertidor = convertidor;
	}

	/**
	 * Método getter del atributo periodoLiquidacionSalud de la clase PlanillaAportanteDTO
	 *
	 * @return the periodoLiquidacionSalud
	 */
	public String getPeriodoLiquidacionSalud() {
		return periodoLiquidacionSalud;
	}

	/**
	 * Método setter del atributo periodoLiquidacionSalud de la clase PlanillaAportanteDTO
	 *
	 * @param periodoLiquidacionSalud
	 *            the periodoLiquidacionSalud to set
	 */
	public void setPeriodoLiquidacionSalud(String periodoLiquidacionSalud) {
		this.periodoLiquidacionSalud = periodoLiquidacionSalud;
	}

	/**
	 * Método getter del atributo periodoLiquidacionNoSalud de la clase PlanillaAportanteDTO
	 *
	 * @return the periodoLiquidacionNoSalud
	 */
	public String getPeriodoLiquidacionNoSalud() {
		return periodoLiquidacionNoSalud;
	}

	/**
	 * Método setter del atributo periodoLiquidacionNoSalud de la clase PlanillaAportanteDTO
	 *
	 * @param periodoLiquidacionNoSalud
	 *            the periodoLiquidacionNoSalud to set
	 */
	public void setPeriodoLiquidacionNoSalud(String periodoLiquidacionNoSalud) {
		this.periodoLiquidacionNoSalud = periodoLiquidacionNoSalud;
	}

	/**
	 * Método getter del atributo numeroPlanillaAsocida de la clase PlanillaAportanteDTO
	 *
	 * @return the numeroPlanillaAsocida
	 */
	public String getNumeroPlanillaAsocida() {
		return numeroPlanillaAsocida;
	}

	/**
	 * Método setter del atributo numeroPlanillaAsocida de la clase PlanillaAportanteDTO
	 *
	 * @param numeroPlanillaAsocida
	 *            the numeroPlanillaAsocida to set
	 */
	public void setNumeroPlanillaAsocida(String numeroPlanillaAsocida) {
		this.numeroPlanillaAsocida = numeroPlanillaAsocida;
	}

	/**
	 * Método getter del atributo fechaPagoPlanillaAsociada de la clase PlanillaAportanteDTO
	 *
	 * @return the fechaPagoPlanillaAsociada
	 */
	public String getFechaPagoPlanillaAsociada() {
		return fechaPagoPlanillaAsociada;
	}

	/**
	 * Método setter del atributo fechaPagoPlanillaAsociada de la clase PlanillaAportanteDTO
	 *
	 * @param fechaPagoPlanillaAsociada
	 *            the fechaPagoPlanillaAsociada to set
	 */
	public void setFechaPagoPlanillaAsociada(String fechaPagoPlanillaAsociada) {
		this.fechaPagoPlanillaAsociada = fechaPagoPlanillaAsociada;
	}

	/**
	 * Método getter del atributo fechaPagoPlanillaAsociadaCadena de la clase PlanillaAportanteDTO
	 *
	 * @return the fechaPagoPlanillaAsociadaCadena
	 */
	public String getFechaPagoPlanillaAsociadaCadena() {
		return fechaPagoPlanillaAsociadaCadena;
	}

	/**
	 * Método setter del atributo fechaPagoPlanillaAsociadaCadena de la clase PlanillaAportanteDTO
	 *
	 * @param fechaPagoPlanillaAsociadaCadena
	 *            the fechaPagoPlanillaAsociadaCadena to set
	 */
	public void setFechaPagoPlanillaAsociadaCadena(String fechaPagoPlanillaAsociadaCadena) {
		this.fechaPagoPlanillaAsociadaCadena = fechaPagoPlanillaAsociadaCadena;
	}

	/**
	 * Método getter del atributo idSoiTpPlanillaAsociada de la clase PlanillaAportanteDTO
	 *
	 * @return the idSoiTpPlanillaAsociada
	 */
	public Integer getIdSoiTpPlanillaAsociada() {
		return idSoiTpPlanillaAsociada;
	}

	/**
	 * Método setter del atributo idSoiTpPlanillaAsociada de la clase PlanillaAportanteDTO
	 *
	 * @param idSoiTpPlanillaAsociada
	 *            the idSoiTpPlanillaAsociada to set
	 */
	public void setIdSoiTpPlanillaAsociada(Integer idSoiTpPlanillaAsociada) {
		this.idSoiTpPlanillaAsociada = idSoiTpPlanillaAsociada;
	}

	/**
	 * Método getter del atributo codigoSoiTpPlanillaAsociada de la clase PlanillaAportanteDTO
	 *
	 * @return the codigoSoiTpPlanillaAsociada
	 */
	public String getCodigoSoiTpPlanillaAsociada() {
		return codigoSoiTpPlanillaAsociada;
	}

	/**
	 * Método setter del atributo codigoSoiTpPlanillaAsociada de la clase PlanillaAportanteDTO
	 *
	 * @param codigoSoiTpPlanillaAsociada
	 *            the codigoSoiTpPlanillaAsociada to set
	 */
	public void setCodigoSoiTpPlanillaAsociada(String codigoSoiTpPlanillaAsociada) {
		this.codigoSoiTpPlanillaAsociada = codigoSoiTpPlanillaAsociada;
	}

	/**
	 * Método getter del atributo nombreSoiTpPlanillaAsociada de la clase PlanillaAportanteDTO
	 *
	 * @return the nombreSoiTpPlanillaAsociada
	 */
	public String getNombreSoiTpPlanillaAsociada() {
		return nombreSoiTpPlanillaAsociada;
	}

	/**
	 * Método setter del atributo nombreSoiTpPlanillaAsociada de la clase PlanillaAportanteDTO
	 *
	 * @param nombreSoiTpPlanillaAsociada
	 *            the nombreSoiTpPlanillaAsociada to set
	 */
	public void setNombreSoiTpPlanillaAsociada(String nombreSoiTpPlanillaAsociada) {
		this.nombreSoiTpPlanillaAsociada = nombreSoiTpPlanillaAsociada;
	}

	/**
	 * Método getter del atributo idSoiAdministradoraARPPlanillaAsociada de la clase PlanillaAportanteDTO
	 *
	 * @return the idSoiAdministradoraARPPlanillaAsociada
	 */
	public Integer getIdSoiAdministradoraARPPlanillaAsociada() {
		return idSoiAdministradoraARPPlanillaAsociada;
	}

	/**
	 * Método setter del atributo idSoiAdministradoraARPPlanillaAsociada de la clase PlanillaAportanteDTO
	 *
	 * @param idSoiAdministradoraARPPlanillaAsociada
	 *            the idSoiAdministradoraARPPlanillaAsociada to set
	 */
	public void setIdSoiAdministradoraARPPlanillaAsociada(Integer idSoiAdministradoraARPPlanillaAsociada) {
		this.idSoiAdministradoraARPPlanillaAsociada = idSoiAdministradoraARPPlanillaAsociada;
	}

	/**
	 * Método getter del atributo nombreARPPlanillaAsociada de la clase PlanillaAportanteDTO
	 *
	 * @return the nombreARPPlanillaAsociada
	 */
	public String getNombreARPPlanillaAsociada() {
		return nombreARPPlanillaAsociada;
	}

	/**
	 * Método setter del atributo nombreARPPlanillaAsociada de la clase PlanillaAportanteDTO
	 *
	 * @param nombreARPPlanillaAsociada
	 *            the nombreARPPlanillaAsociada to set
	 */
	public void setNombreARPPlanillaAsociada(String nombreARPPlanillaAsociada) {
		this.nombreARPPlanillaAsociada = nombreARPPlanillaAsociada;
	}

	/**
	 * Método getter del atributo codAdministradoraARPPlanillaAsociada de la clase PlanillaAportanteDTO
	 *
	 * @return the codAdministradoraARPPlanillaAsociada
	 */
	public String getCodAdministradoraARPPlanillaAsociada() {
		return codAdministradoraARPPlanillaAsociada;
	}

	/**
	 * Método setter del atributo codAdministradoraARPPlanillaAsociada de la clase PlanillaAportanteDTO
	 *
	 * @param codAdministradoraARPPlanillaAsociada
	 *            the codAdministradoraARPPlanillaAsociada to set
	 */
	public void setCodAdministradoraARPPlanillaAsociada(String codAdministradoraARPPlanillaAsociada) {
		this.codAdministradoraARPPlanillaAsociada = codAdministradoraARPPlanillaAsociada;
	}

	/**
	 * Método getter del atributo estadoPlanilla de la clase PlanillaAportanteDTO
	 *
	 * @return the estadoPlanilla
	 */
	public String getEstadoPlanilla() {
		return estadoPlanilla;
	}

	/**
	 * Método setter del atributo estadoPlanilla de la clase PlanillaAportanteDTO
	 *
	 * @param estadoPlanilla
	 *            the estadoPlanilla to set
	 */
	public void setEstadoPlanilla(String estadoPlanilla) {
		this.estadoPlanilla = estadoPlanilla;
	}

	/**
	 * Método getter del atributo idSoiAdministradoraARP de la clase PlanillaAportanteDTO
	 *
	 * @return the idSoiAdministradoraARP
	 */
	public Integer getIdSoiAdministradoraARP() {
		return idSoiAdministradoraARP;
	}

	/**
	 * Método setter del atributo idSoiAdministradoraARP de la clase PlanillaAportanteDTO
	 *
	 * @param idSoiAdministradoraARP
	 *            the idSoiAdministradoraARP to set
	 */
	public void setIdSoiAdministradoraARP(Integer idSoiAdministradoraARP) {
		this.idSoiAdministradoraARP = idSoiAdministradoraARP;
	}

	/**
	 * Método getter del atributo codAdministradoraARPPlanilla de la clase PlanillaAportanteDTO
	 *
	 * @return the codAdministradoraARPPlanilla
	 */
	public String getCodAdministradoraARPPlanilla() {
		return codAdministradoraARPPlanilla;
	}

	/**
	 * Método setter del atributo codAdministradoraARPPlanilla de la clase PlanillaAportanteDTO
	 *
	 * @param codAdministradoraARPPlanilla
	 *            the codAdministradoraARPPlanilla to set
	 */
	public void setCodAdministradoraARPPlanilla(String codAdministradoraARPPlanilla) {
		this.codAdministradoraARPPlanilla = codAdministradoraARPPlanilla;
	}

	/**
	 * Método getter del atributo idSoiFormaPresentacion de la clase PlanillaAportanteDTO
	 *
	 * @return the idSoiFormaPresentacion
	 */
	public Integer getIdSoiFormaPresentacion() {
		return idSoiFormaPresentacion;
	}

	/**
	 * Método setter del atributo idSoiFormaPresentacion de la clase PlanillaAportanteDTO
	 *
	 * @param idSoiFormaPresentacion
	 *            the idSoiFormaPresentacion to set
	 */
	public void setIdSoiFormaPresentacion(Integer idSoiFormaPresentacion) {
		this.idSoiFormaPresentacion = idSoiFormaPresentacion;
	}

	/**
	 * Método getter del atributo codSoiFormaPresentacion de la clase PlanillaAportanteDTO
	 *
	 * @return the codSoiFormaPresentacion
	 */
	public String getCodSoiFormaPresentacion() {
		return codSoiFormaPresentacion;
	}

	/**
	 * Método setter del atributo codSoiFormaPresentacion de la clase PlanillaAportanteDTO
	 *
	 * @param codSoiFormaPresentacion
	 *            the codSoiFormaPresentacion to set
	 */
	public void setCodSoiFormaPresentacion(String codSoiFormaPresentacion) {
		this.codSoiFormaPresentacion = codSoiFormaPresentacion;
	}

	/**
	 * Método getter del atributo nombreSoiFormaPresentacion de la clase PlanillaAportanteDTO
	 *
	 * @return the nombreSoiFormaPresentacion
	 */
	public String getNombreSoiFormaPresentacion() {
		return nombreSoiFormaPresentacion;
	}

	/**
	 * Método setter del atributo nombreSoiFormaPresentacion de la clase PlanillaAportanteDTO
	 *
	 * @param nombreSoiFormaPresentacion
	 *            the nombreSoiFormaPresentacion to set
	 */
	public void setNombreSoiFormaPresentacion(String nombreSoiFormaPresentacion) {
		this.nombreSoiFormaPresentacion = nombreSoiFormaPresentacion;
	}

	/**
	 * Método getter del atributo idOperadorPila de la clase PlanillaAportanteDTO
	 *
	 * @return the idOperadorPila
	 */
	public Integer getIdOperadorPila() {
		return idOperadorPila;
	}

	/**
	 * Método setter del atributo idOperadorPila de la clase PlanillaAportanteDTO
	 *
	 * @param idOperadorPila
	 *            the idOperadorPila to set
	 */
	public void setIdOperadorPila(Integer idOperadorPila) {
		this.idOperadorPila = idOperadorPila;
	}

	/**
	 * Método getter del atributo formaElaboracionPlanilla de la clase PlanillaAportanteDTO
	 *
	 * @return the formaElaboracionPlanilla
	 */
	public Integer getFormaElaboracionPlanilla() {
		return formaElaboracionPlanilla;
	}

	/**
	 * Método setter del atributo formaElaboracionPlanilla de la clase PlanillaAportanteDTO
	 *
	 * @param formaElaboracionPlanilla
	 *            the formaElaboracionPlanilla to set
	 */
	public void setFormaElaboracionPlanilla(Integer formaElaboracionPlanilla) {
		this.formaElaboracionPlanilla = formaElaboracionPlanilla;
	}

	/**
	 * Método getter del atributo modalidadPlanilla de la clase PlanillaAportanteDTO
	 *
	 * @return the modalidadPlanilla
	 */
	public Integer getModalidadPlanilla() {
		return modalidadPlanilla;
	}

	/**
	 * Método setter del atributo modalidadPlanilla de la clase PlanillaAportanteDTO
	 *
	 * @param modalidadPlanilla
	 *            the modalidadPlanilla to set
	 */
	public void setModalidadPlanilla(Integer modalidadPlanilla) {
		this.modalidadPlanilla = modalidadPlanilla;
	}

	/**
	 * Método getter del atributo idSoiPlanilla de la clase PlanillaAportanteDTO
	 *
	 * @return the idSoiPlanilla
	 */
	public Long getIdSoiPlanilla() {
		return idSoiPlanilla;
	}

	/**
	 * Método setter del atributo idSoiPlanilla de la clase PlanillaAportanteDTO
	 *
	 * @param idSoiPlanilla
	 *            the idSoiPlanilla to set
	 */
	public void setIdSoiPlanilla(Long idSoiPlanilla) {
		this.idSoiPlanilla = idSoiPlanilla;
	}

	/**
	 * Método getter del atributo nombreArchivoPlano de la clase PlanillaAportanteDTO
	 *
	 * @return the nombreArchivoPlano
	 */
	public String getNombreArchivoPlano() {
		return nombreArchivoPlano;
	}

	/**
	 * Método setter del atributo nombreArchivoPlano de la clase PlanillaAportanteDTO
	 *
	 * @param nombreArchivoPlano
	 *            the nombreArchivoPlano to set
	 */
	public void setNombreArchivoPlano(String nombreArchivoPlano) {
		this.nombreArchivoPlano = nombreArchivoPlano;
	}

	/**
	 * Método getter del atributo tipoPlanillaBloquedada de la clase PlanillaAportanteDTO
	 *
	 * @return the tipoPlanillaBloquedada
	 */
	public Boolean getTipoPlanillaBloquedada() {
		return tipoPlanillaBloquedada;
	}

	/**
	 * Método setter del atributo tipoPlanillaBloquedada de la clase PlanillaAportanteDTO
	 *
	 * @param tipoPlanillaBloquedada
	 *            the tipoPlanillaBloquedada to set
	 */
	public void setTipoPlanillaBloquedada(Boolean tipoPlanillaBloquedada) {
		this.tipoPlanillaBloquedada = tipoPlanillaBloquedada;
	}

	/**
	 * Método getter del atributo claseAportanteBoI de la clase PlanillaAportanteDTO
	 *
	 * @return the claseAportanteBoI
	 */
	public Boolean getClaseAportanteBoI() {
		return claseAportanteBoI;
	}

	/**
	 * Método setter del atributo claseAportanteBoI de la clase PlanillaAportanteDTO
	 *
	 * @param claseAportanteBoI
	 *            the claseAportanteBoI to set
	 */
	public void setClaseAportanteBoI(Boolean claseAportanteBoI) {
		this.claseAportanteBoI = claseAportanteBoI;
	}

	/**
	 * Método getter del atributo valorPagado de la clase PlanillaAportanteDTO
	 *
	 * @return the valorPagado
	 */
	public BigDecimal getValorPagado() {
		return valorPagado;
	}

	/**
	 * Método setter del atributo valorPagado de la clase PlanillaAportanteDTO
	 *
	 * @param valorPagado
	 *            the valorPagado to set
	 */
	public void setValorPagado(BigDecimal valorPagado) {
		this.valorPagado = valorPagado;
	}

	/**
	 * Método getter del atributo fechaDePagoEfectiva de la clase PlanillaAportanteDTO
	 *
	 * @return the fechaDePagoEfectiva
	 */
	public String getFechaDePagoEfectiva() {
		return fechaDePagoEfectiva;
	}

	/**
	 * Método setter del atributo fechaDePagoEfectiva de la clase PlanillaAportanteDTO
	 *
	 * @param fechaDePagoEfectiva
	 *            the fechaDePagoEfectiva to set
	 */
	public void setFechaDePagoEfectiva(String fechaDePagoEfectiva) {
		this.fechaDePagoEfectiva = fechaDePagoEfectiva;
	}

	/**
	 * Método getter del atributo usuarioModificaInformacionAportante de la clase PlanillaAportanteDTO
	 *
	 * @return the usuarioModificaInformacionAportante
	 */
	public Boolean getUsuarioModificaInformacionAportante() {
		return usuarioModificaInformacionAportante;
	}

	/**
	 * Método setter del atributo usuarioModificaInformacionAportante de la clase PlanillaAportanteDTO
	 *
	 * @param usuarioModificaInformacionAportante
	 *            the usuarioModificaInformacionAportante to set
	 */
	public void setUsuarioModificaInformacionAportante(Boolean usuarioModificaInformacionAportante) {
		this.usuarioModificaInformacionAportante = usuarioModificaInformacionAportante;
	}

	/**
	 * Método getter del atributo planilaAsociadaMNExiste de la clase PlanillaAportanteDTO
	 *
	 * @return the planilaAsociadaMNExiste
	 */
	public Boolean getPlanilaAsociadaMNExiste() {
		return planilaAsociadaMNExiste;
	}

	/**
	 * Método setter del atributo planilaAsociadaMNExiste de la clase PlanillaAportanteDTO
	 *
	 * @param planilaAsociadaMNExiste
	 *            the planilaAsociadaMNExiste to set
	 */
	public void setPlanilaAsociadaMNExiste(Boolean planilaAsociadaMNExiste) {
		this.planilaAsociadaMNExiste = planilaAsociadaMNExiste;
	}

	/**
	 * Método getter del atributo planilaAsociadaTExiste de la clase PlanillaAportanteDTO
	 *
	 * @return the planilaAsociadaTExiste
	 */
	public Boolean getPlanilaAsociadaTExiste() {
		return planilaAsociadaTExiste;
	}

	/**
	 * Método setter del atributo planilaAsociadaTExiste de la clase PlanillaAportanteDTO
	 *
	 * @param planilaAsociadaTExiste
	 *            the planilaAsociadaTExiste to set
	 */
	public void setPlanilaAsociadaTExiste(Boolean planilaAsociadaTExiste) {
		this.planilaAsociadaTExiste = planilaAsociadaTExiste;
	}

	/**
	 * Método getter del atributo usuarioAceptaPlanillaMNPagadaPorEsteOperador de la clase PlanillaAportanteDTO
	 *
	 * @return the usuarioAceptaPlanillaMNPagadaPorEsteOperador
	 */
	public Boolean getUsuarioAceptaPlanillaMNPagadaPorEsteOperador() {
		return usuarioAceptaPlanillaMNPagadaPorEsteOperador;
	}

	/**
	 * Método setter del atributo usuarioAceptaPlanillaMNPagadaPorEsteOperador de la clase PlanillaAportanteDTO
	 *
	 * @param usuarioAceptaPlanillaMNPagadaPorEsteOperador
	 *            the usuarioAceptaPlanillaMNPagadaPorEsteOperador to set
	 */
	public void setUsuarioAceptaPlanillaMNPagadaPorEsteOperador(Boolean usuarioAceptaPlanillaMNPagadaPorEsteOperador) {
		this.usuarioAceptaPlanillaMNPagadaPorEsteOperador = usuarioAceptaPlanillaMNPagadaPorEsteOperador;
	}

	/**
	 * Método getter del atributo planillaPublicaPreguntarSiEsRetroactivo de la clase PlanillaAportanteDTO
	 *
	 * @return the planillaPublicaPreguntarSiEsRetroactivo
	 */
	public Boolean getPlanillaPublicaPreguntarSiEsRetroactivo() {
		return planillaPublicaPreguntarSiEsRetroactivo;
	}

	/**
	 * Método setter del atributo planillaPublicaPreguntarSiEsRetroactivo de la clase PlanillaAportanteDTO
	 *
	 * @param planillaPublicaPreguntarSiEsRetroactivo
	 *            the planillaPublicaPreguntarSiEsRetroactivo to set
	 */
	public void setPlanillaPublicaPreguntarSiEsRetroactivo(Boolean planillaPublicaPreguntarSiEsRetroactivo) {
		this.planillaPublicaPreguntarSiEsRetroactivo = planillaPublicaPreguntarSiEsRetroactivo;
	}

	/**
	 * Método getter del atributo usuarioAceptaRetroactivoPlanillaPublica de la clase PlanillaAportanteDTO
	 *
	 * @return the usuarioAceptaRetroactivoPlanillaPublica
	 */
	public Boolean getUsuarioAceptaRetroactivoPlanillaPublica() {
		return usuarioAceptaRetroactivoPlanillaPublica;
	}

	/**
	 * Método setter del atributo usuarioAceptaRetroactivoPlanillaPublica de la clase PlanillaAportanteDTO
	 *
	 * @param usuarioAceptaRetroactivoPlanillaPublica
	 *            the usuarioAceptaRetroactivoPlanillaPublica to set
	 */
	public void setUsuarioAceptaRetroactivoPlanillaPublica(Boolean usuarioAceptaRetroactivoPlanillaPublica) {
		this.usuarioAceptaRetroactivoPlanillaPublica = usuarioAceptaRetroactivoPlanillaPublica;
	}

	/**
	 * Método getter del atributo certificaCalculoInteresesMora de la clase PlanillaAportanteDTO
	 *
	 * @return the certificaCalculoInteresesMora
	 */
	public Boolean getCertificaCalculoInteresesMora() {
		return certificaCalculoInteresesMora;
	}

	/**
	 * Método setter del atributo certificaCalculoInteresesMora de la clase PlanillaAportanteDTO
	 *
	 * @param certificaCalculoInteresesMora
	 *            the certificaCalculoInteresesMora to set
	 */
	public void setCertificaCalculoInteresesMora(Boolean certificaCalculoInteresesMora) {
		this.certificaCalculoInteresesMora = certificaCalculoInteresesMora;
	}

	/**
	 * Método getter del atributo numeroDiasExistenciaEmpresa de la clase PlanillaAportanteDTO
	 *
	 * @return the numeroDiasExistenciaEmpresa
	 */
	public Integer getNumeroDiasExistenciaEmpresa() {
		return numeroDiasExistenciaEmpresa;
	}

	/**
	 * Método setter del atributo numeroDiasExistenciaEmpresa de la clase PlanillaAportanteDTO
	 *
	 * @param numeroDiasExistenciaEmpresa
	 *            the numeroDiasExistenciaEmpresa to set
	 */
	public void setNumeroDiasExistenciaEmpresa(Integer numeroDiasExistenciaEmpresa) {
		this.numeroDiasExistenciaEmpresa = numeroDiasExistenciaEmpresa;
	}

	/**
	 * Método getter del atributo numeroAnosExistenciaEmpresa de la clase PlanillaAportanteDTO
	 *
	 * @return the numeroAnosExistenciaEmpresa
	 */
	public Integer getNumeroAnosExistenciaEmpresa() {
		return numeroAnosExistenciaEmpresa;
	}

	/**
	 * Método setter del atributo numeroAnosExistenciaEmpresa de la clase PlanillaAportanteDTO
	 *
	 * @param numeroAnosExistenciaEmpresa
	 *            the numeroAnosExistenciaEmpresa to set
	 */
	public void setNumeroAnosExistenciaEmpresa(Integer numeroAnosExistenciaEmpresa) {
		this.numeroAnosExistenciaEmpresa = numeroAnosExistenciaEmpresa;
	}

	/**
	 * Método getter del atributo usuarioAceptaDescuentoPymes de la clase PlanillaAportanteDTO
	 *
	 * @return the usuarioAceptaDescuentoPymes
	 */
	public Boolean getUsuarioAceptaDescuentoPymes() {
		return usuarioAceptaDescuentoPymes;
	}

	/**
	 * Método setter del atributo usuarioAceptaDescuentoPymes de la clase PlanillaAportanteDTO
	 *
	 * @param usuarioAceptaDescuentoPymes
	 *            the usuarioAceptaDescuentoPymes to set
	 */
	public void setUsuarioAceptaDescuentoPymes(Boolean usuarioAceptaDescuentoPymes) {
		this.usuarioAceptaDescuentoPymes = usuarioAceptaDescuentoPymes;
	}

	/**
	 * Método getter del atributo informacionPlanillaMNCorregidaDTO de la clase PlanillaAportanteDTO
	 *
	 * @return the informacionPlanillaMNCorregidaDTO
	 */
	public InformacionPlanillaMNCorregidaDTO getInformacionPlanillaMNCorregidaDTO() {
		return informacionPlanillaMNCorregidaDTO;
	}

	/**
	 * Método setter del atributo informacionPlanillaMNCorregidaDTO de la clase PlanillaAportanteDTO
	 *
	 * @param informacionPlanillaMNCorregidaDTO
	 *            the informacionPlanillaMNCorregidaDTO to set
	 */
	public void setInformacionPlanillaMNCorregidaDTO(InformacionPlanillaMNCorregidaDTO informacionPlanillaMNCorregidaDTO) {
		this.informacionPlanillaMNCorregidaDTO = informacionPlanillaMNCorregidaDTO;
	}

	/**
	 * Método getter del atributo recalcularMora de la clase PlanillaAportanteDTO
	 *
	 * @return the recalcularMora
	 */
	public Boolean getRecalcularMora() {
		return recalcularMora;
	}

	/**
	 * Método setter del atributo recalcularMora de la clase PlanillaAportanteDTO
	 *
	 * @param recalcularMora
	 *            the recalcularMora to set
	 */
	public void setRecalcularMora(Boolean recalcularMora) {
		this.recalcularMora = recalcularMora;
	}

	/**
	 * Método getter del atributo aportanteLey1607 de la clase PlanillaAportanteDTO
	 *
	 * @return the aportanteLey1607
	 */
	public Boolean getAportanteLey1607() {
		return aportanteLey1607;
	}

	/**
	 * Método setter del atributo aportanteLey1607 de la clase PlanillaAportanteDTO
	 *
	 * @param aportanteLey1607
	 *            the aportanteLey1607 to set
	 */
	public void setAportanteLey1607(Boolean aportanteLey1607) {
		this.aportanteLey1607 = aportanteLey1607;
	}

	/**
	 * Método getter del atributo aportanteLey1429 de la clase PlanillaAportanteDTO
	 *
	 * @return the aportanteLey1429
	 */
	public Boolean getAportanteLey1429() {
		return aportanteLey1429;
	}

	/**
	 * Método setter del atributo aportanteLey1429 de la clase PlanillaAportanteDTO
	 *
	 * @param aportanteLey1429
	 *            the aportanteLey1429 to set
	 */
	public void setAportanteLey1429(Boolean aportanteLey1429) {
		this.aportanteLey1429 = aportanteLey1429;
	}

	/**
	 * Método getter del atributo tipoPlanillaAplicaLey1607 de la clase PlanillaAportanteDTO
	 *
	 * @return the tipoPlanillaAplicaLey1607
	 */
	public Boolean getTipoPlanillaAplicaLey1607() {
		return tipoPlanillaAplicaLey1607;
	}

	/**
	 * Método setter del atributo tipoPlanillaAplicaLey1607 de la clase PlanillaAportanteDTO
	 *
	 * @param tipoPlanillaAplicaLey1607
	 *            the tipoPlanillaAplicaLey1607 to set
	 */
	public void setTipoPlanillaAplicaLey1607(Boolean tipoPlanillaAplicaLey1607) {
		this.tipoPlanillaAplicaLey1607 = tipoPlanillaAplicaLey1607;
	}

	/**
	 * Método getter del atributo aplicaPeriodoMayorIgualAbr1994 de la clase PlanillaAportanteDTO
	 *
	 * @return the aplicaPeriodoMayorIgualAbr1994
	 */
	public Boolean getAplicaPeriodoMayorIgualAbr1994() {
		return aplicaPeriodoMayorIgualAbr1994;
	}

	/**
	 * Método setter del atributo aplicaPeriodoMayorIgualAbr1994 de la clase PlanillaAportanteDTO
	 *
	 * @param aplicaPeriodoMayorIgualAbr1994
	 *            the aplicaPeriodoMayorIgualAbr1994 to set
	 */
	public void setAplicaPeriodoMayorIgualAbr1994(Boolean aplicaPeriodoMayorIgualAbr1994) {
		this.aplicaPeriodoMayorIgualAbr1994 = aplicaPeriodoMayorIgualAbr1994;
	}

	/**
	 * Método getter del atributo aplicaPeriodoMenorIgualDic2002 de la clase PlanillaAportanteDTO
	 *
	 * @return the aplicaPeriodoMenorIgualDic2002
	 */
	public Boolean getAplicaPeriodoMenorIgualDic2002() {
		return aplicaPeriodoMenorIgualDic2002;
	}

	/**
	 * Método setter del atributo aplicaPeriodoMenorIgualDic2002 de la clase PlanillaAportanteDTO
	 *
	 * @param aplicaPeriodoMenorIgualDic2002
	 *            the aplicaPeriodoMenorIgualDic2002 to set
	 */
	public void setAplicaPeriodoMenorIgualDic2002(Boolean aplicaPeriodoMenorIgualDic2002) {
		this.aplicaPeriodoMenorIgualDic2002 = aplicaPeriodoMenorIgualDic2002;
	}

	/**
	 * Método getter del atributo idSoiAportante de la clase PlanillaAportanteDTO
	 *
	 * @return the idSoiAportante
	 */
	public Long getIdSoiAportante() {
		return idSoiAportante;
	}

	/**
	 * Método setter del atributo idSoiAportante de la clase PlanillaAportanteDTO
	 *
	 * @param idSoiAportante
	 *            the idSoiAportante to set
	 */
	public void setIdSoiAportante(Long idSoiAportante) {
		this.idSoiAportante = idSoiAportante;
	}

	/**
	 * Método getter del atributo codigoTpPlanillaExistente de la clase PlanillaAportanteDTO
	 *
	 * @return the codigoTpPlanillaExistente
	 */
	public String getCodigoTpPlanillaExistente() {
		return codigoTpPlanillaExistente;
	}

	/**
	 * Método setter del atributo codigoTpPlanillaExistente de la clase PlanillaAportanteDTO
	 *
	 * @param codigoTpPlanillaExistente
	 *            the codigoTpPlanillaExistente to set
	 */
	public void setCodigoTpPlanillaExistente(String codigoTpPlanillaExistente) {
		this.codigoTpPlanillaExistente = codigoTpPlanillaExistente;
	}

	/**
	 * Método getter del atributo existenPlanillasBase de la clase PlanillaAportanteDTO
	 *
	 * @return the existenPlanillasBase
	 */
	public Boolean getExistenPlanillasBase() {
		return existenPlanillasBase;
	}

	/**
	 * Método setter del atributo existenPlanillasBase de la clase PlanillaAportanteDTO
	 *
	 * @param existenPlanillasBase
	 *            the existenPlanillasBase to set
	 */
	public void setExistenPlanillasBase(Boolean existenPlanillasBase) {
		this.existenPlanillasBase = existenPlanillasBase;
	}

	/**
	 * Método getter del atributo cantidadMaximaErrores de la clase PlanillaAportanteDTO
	 *
	 * @return the cantidadMaximaErrores
	 */
	public Integer getCantidadMaximaErrores() {
		return cantidadMaximaErrores;
	}

	/**
	 * Método setter del atributo cantidadMaximaErrores de la clase PlanillaAportanteDTO
	 *
	 * @param cantidadMaximaErrores
	 *            the cantidadMaximaErrores to set
	 */
	public void setCantidadMaximaErrores(Integer cantidadMaximaErrores) {
		this.cantidadMaximaErrores = cantidadMaximaErrores;
	}

	/**
	 * Método getter del atributo permiteGeneracionCsv de la clase PlanillaAportanteDTO
	 *
	 * @return the permiteGeneracionCsv
	 */
	public Boolean getPermiteGeneracionCsv() {
		return permiteGeneracionCsv;
	}

	/**
	 * Método setter del atributo permiteGeneracionCsv de la clase PlanillaAportanteDTO
	 *
	 * @param permiteGeneracionCsv
	 *            the permiteGeneracionCsv to set
	 */
	public void setPermiteGeneracionCsv(Boolean permiteGeneracionCsv) {
		this.permiteGeneracionCsv = permiteGeneracionCsv;
	}

	/**
	 * Método getter del atributo idSoiSoporteUsuario de la clase PlanillaAportanteDTO
	 *
	 * @return the idSoiSoporteUsuario
	 */
	public Long getIdSoiSoporteUsuario() {
		return idSoiSoporteUsuario;
	}

	/**
	 * Método setter del atributo idSoiSoporteUsuario de la clase PlanillaAportanteDTO
	 *
	 * @param idSoiSoporteUsuario
	 *            the idSoiSoporteUsuario to set
	 */
	public void setIdSoiSoporteUsuario(Long idSoiSoporteUsuario) {
		this.idSoiSoporteUsuario = idSoiSoporteUsuario;
	}

	/**
	 * Método getter del atributo existeApteNsoiPlanillaU de la clase PlanillaAportanteDTO
	 *
	 * @return the existeApteNsoiPlanillaU
	 */
	public Boolean getExisteApteNsoiPlanillaU() {
		return existeApteNsoiPlanillaU;
	}

	/**
	 * Método setter del atributo existeApteNsoiPlanillaU de la clase PlanillaAportanteDTO
	 *
	 * @param existeApteNsoiPlanillaU
	 *            the existeApteNsoiPlanillaU to set
	 */
	public void setExisteApteNsoiPlanillaU(Boolean existeApteNsoiPlanillaU) {
		this.existeApteNsoiPlanillaU = existeApteNsoiPlanillaU;
	}

	/**
	 * Método getter del atributo existeApteUgpp de la clase PlanillaAportanteDTO
	 *
	 * @return the existeApteUgpp
	 */
	public Boolean getExisteApteUgpp() {
		return existeApteUgpp;
	}

	/**
	 * Método setter del atributo existeApteUgpp de la clase PlanillaAportanteDTO
	 *
	 * @param existeApteUgpp
	 *            the existeApteUgpp to set
	 */
	public void setExisteApteUgpp(Boolean existeApteUgpp) {
		this.existeApteUgpp = existeApteUgpp;
	}

	/**
	 * Método getter del atributo numeroDiasMoraPnllaJ de la clase PlanillaAportanteDTO
	 *
	 * @return the numeroDiasMoraPnllaJ
	 */
	public Integer getNumeroDiasMoraPnllaJ() {
		return numeroDiasMoraPnllaJ;
	}

	/**
	 * Método setter del atributo numeroDiasMoraPnllaJ de la clase PlanillaAportanteDTO
	 *
	 * @param numeroDiasMoraPnllaJ
	 *            the numeroDiasMoraPnllaJ to set
	 */
	public void setNumeroDiasMoraPnllaJ(Integer numeroDiasMoraPnllaJ) {
		this.numeroDiasMoraPnllaJ = numeroDiasMoraPnllaJ;
	}

	/**
	 * Método getter del atributo edicionPlanillaArchivo de la clase PlanillaAportanteDTO
	 *
	 * @return the edicionPlanillaArchivo
	 */
	public Boolean getEdicionPlanillaArchivo() {
		return edicionPlanillaArchivo;
	}

	/**
	 * Método setter del atributo edicionPlanillaArchivo de la clase PlanillaAportanteDTO
	 *
	 * @param edicionPlanillaArchivo
	 *            the edicionPlanillaArchivo to set
	 */
	public void setEdicionPlanillaArchivo(Boolean edicionPlanillaArchivo) {
		this.edicionPlanillaArchivo = edicionPlanillaArchivo;
	}

	/**
	 * Método getter del atributo esPreliquidacion de la clase PlanillaAportanteDTO
	 *
	 * @return the esPreliquidacion
	 */
	public Boolean getEsPreliquidacion() {
		return esPreliquidacion;
	}

	/**
	 * Método setter del atributo esPreliquidacion de la clase PlanillaAportanteDTO
	 *
	 * @param esPreliquidacion
	 *            the esPreliquidacion to set
	 */
	public void setEsPreliquidacion(Boolean esPreliquidacion) {
		this.esPreliquidacion = esPreliquidacion;
	}

	/**
	 * Método getter del atributo aplicaValidacionPlanillaPrevia de la clase PlanillaAportanteDTO
	 *
	 * @return the aplicaValidacionPlanillaPrevia
	 */
	public Boolean getAplicaValidacionPlanillaPrevia() {
		return aplicaValidacionPlanillaPrevia;
	}

	/**
	 * Método setter del atributo aplicaValidacionPlanillaPrevia de la clase PlanillaAportanteDTO
	 *
	 * @param aplicaValidacionPlanillaPrevia
	 *            the aplicaValidacionPlanillaPrevia to set
	 */
	public void setAplicaValidacionPlanillaPrevia(Boolean aplicaValidacionPlanillaPrevia) {
		this.aplicaValidacionPlanillaPrevia = aplicaValidacionPlanillaPrevia;
	}

	/**
	 * Método getter del atributo idSoiTpEmpresa de la clase PlanillaAportanteDTO
	 *
	 * @return the idSoiTpEmpresa
	 */
	public Integer getIdSoiTpEmpresa() {
		return idSoiTpEmpresa;
	}

	/**
	 * Método setter del atributo idSoiTpEmpresa de la clase PlanillaAportanteDTO
	 *
	 * @param idSoiTpEmpresa
	 *            the idSoiTpEmpresa to set
	 */
	public void setIdSoiTpEmpresa(Integer idSoiTpEmpresa) {
		this.idSoiTpEmpresa = idSoiTpEmpresa;
	}

	/**
	 * Método getter del atributo planillaJReferida de la clase PlanillaAportanteDTO
	 *
	 * @return the planillaJReferida
	 */
	public Boolean getPlanillaJReferida() {
		return planillaJReferida;
	}

	/**
	 * Método setter del atributo planillaJReferida de la clase PlanillaAportanteDTO
	 *
	 * @param planillaJReferida
	 *            the planillaJReferida to set
	 */
	public void setPlanillaJReferida(Boolean planillaJReferida) {
		this.planillaJReferida = planillaJReferida;
	}

	/**
	 * Método getter del atributo creacionPlanilla de la clase PlanillaAportanteDTO
	 *
	 * @return the creacionPlanilla
	 */
	public Boolean getCreacionPlanilla() {
		return creacionPlanilla;
	}

	/**
	 * Método setter del atributo creacionPlanilla de la clase PlanillaAportanteDTO
	 *
	 * @param creacionPlanilla
	 *            the creacionPlanilla to set
	 */
	public void setCreacionPlanilla(Boolean creacionPlanilla) {
		this.creacionPlanilla = creacionPlanilla;
	}

	/**
	 * Método getter del atributo ipCreacion de la clase PlanillaAportanteDTO
	 *
	 * @return the ipCreacion
	 */
	public String getIpCreacion() {
		return ipCreacion;
	}

	/**
	 * Método setter del atributo ipCreacion de la clase PlanillaAportanteDTO
	 *
	 * @param ipCreacion
	 *            the ipCreacion to set
	 */
	public void setIpCreacion(String ipCreacion) {
		this.ipCreacion = ipCreacion;
	}

	/**
	 * Método getter del atributo administradorasAportante de la clase PlanillaAportanteDTO
	 *
	 * @return the administradorasAportante
	 */
	public Map<String, List<AdministradoraDTO>> getAdministradorasAportante() {
		if (administradorasAportante == null) {
			administradorasAportante = new HashMap<String, List<AdministradoraDTO>>();
		}
		return administradorasAportante;
	}

	/**
	 * Método setter del atributo administradorasAportante de la clase PlanillaAportanteDTO
	 *
	 * @param administradorasAportante
	 *            the administradorasAportante to set
	 */
	public void setAdministradorasAportante(Map<String, List<AdministradoraDTO>> administradorasAportante) {
		this.administradorasAportante = administradorasAportante;
	}

	/**
	 * Método getter del atributo tarifasAportante de la clase PlanillaAportanteDTO
	 *
	 * @return the tarifasAportante
	 */
	public Map<Integer, List<BigDecimal>> getTarifasAportante() {
		return tarifasAportante;
	}

	/**
	 * Método setter del atributo tarifasAportante de la clase PlanillaAportanteDTO
	 *
	 * @param tarifasAportante
	 *            the tarifasAportante to set
	 */
	public void setTarifasAportante(Map<Integer, List<BigDecimal>> tarifasAportante) {
		this.tarifasAportante = tarifasAportante;
	}

	/**
	 * Método getter del atributo codMunicipioAportante de la clase PlanillaAportanteDTO
	 *
	 * @return the codMunicipioAportante
	 */
	public String getCodMunicipioAportante() {
		return codMunicipioAportante;
	}

	/**
	 * Método setter del atributo codMunicipioAportante de la clase PlanillaAportanteDTO
	 *
	 * @param codMunicipioAportante
	 *            the codMunicipioAportante to set
	 */
	public void setCodMunicipioAportante(String codMunicipioAportante) {
		this.codMunicipioAportante = codMunicipioAportante;
	}

	/**
	 * Método getter del atributo ivaComision de la clase PlanillaAportanteDTO
	 *
	 * @return the ivaComision
	 */
	public BigDecimal getIvaComision() {
		return ivaComision;
	}

	/**
	 * Método setter del atributo ivaComision de la clase PlanillaAportanteDTO
	 *
	 * @param ivaComision
	 *            the ivaComision to set
	 */
	public void setIvaComision(BigDecimal ivaComision) {
		this.ivaComision = ivaComision;
	}

	/**
	 * Método getter del atributo comision de la clase PlanillaAportanteDTO
	 *
	 * @return the comision
	 */
	public BigDecimal getComision() {
		return comision;
	}

	/**
	 * Método setter del atributo comision de la clase PlanillaAportanteDTO
	 *
	 * @param comision
	 *            the comision to set
	 */
	public void setComision(BigDecimal comision) {
		this.comision = comision;
	}

	/**
	 * Método getter del atributo codDepartamentoAportante de la clase PlanillaAportanteDTO
	 *
	 * @return the codDepartamentoAportante
	 */
	public String getCodDepartamentoAportante() {
		return codDepartamentoAportante;
	}

	/**
	 * Método setter del atributo codDepartamentoAportante de la clase PlanillaAportanteDTO
	 *
	 * @param codDepartamentoAportante
	 *            the codDepartamentoAportante to set
	 */
	public void setCodDepartamentoAportante(String codDepartamentoAportante) {
		this.codDepartamentoAportante = codDepartamentoAportante;
	}

	/**
	 * Método getter del atributo direccionAportante de la clase PlanillaAportanteDTO
	 *
	 * @return the direccionAportante
	 */
	public String getDireccionAportante() {
		return direccionAportante;
	}

	/**
	 * Método setter del atributo direccionAportante de la clase PlanillaAportanteDTO
	 *
	 * @param direccionAportante
	 *            the direccionAportante to set
	 */
	public void setDireccionAportante(String direccionAportante) {
		this.direccionAportante = direccionAportante;
	}

	/**
	 * Método getter del atributo telefonoAportante de la clase PlanillaAportanteDTO
	 *
	 * @return the telefonoAportante
	 */
	public String getTelefonoAportante() {
		return telefonoAportante;
	}

	/**
	 * Método setter del atributo telefonoAportante de la clase PlanillaAportanteDTO
	 *
	 * @param telefonoAportante
	 *            the telefonoAportante to set
	 */
	public void setTelefonoAportante(String telefonoAportante) {
		this.telefonoAportante = telefonoAportante;
	}

	/**
	 * Método getter del atributo fax de la clase PlanillaAportanteDTO
	 *
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * Método setter del atributo fax de la clase PlanillaAportanteDTO
	 *
	 * @param fax
	 *            the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * Método getter del atributo idPlanillaE de la clase PlanillaAportanteDTO
	 *
	 * @return the idPlanillaE
	 */
	public Long getIdPlanillaE() {
		return idPlanillaE;
	}

	/**
	 * Método setter del atributo idPlanillaE de la clase PlanillaAportanteDTO
	 *
	 * @param idPlanillaE
	 *            the idPlanillaE to set
	 */
	public void setIdPlanillaE(Long idPlanillaE) {
		this.idPlanillaE = idPlanillaE;
	}

	/**
	 * Método getter del atributo numeroCotizantesPermitidos de la clase PlanillaAportanteDTO
	 *
	 * @return the numeroCotizantesPermitidos
	 */
	public Integer getNumeroCotizantesPermitidos() {
		return numeroCotizantesPermitidos;
	}

	/**
	 * Método setter del atributo numeroCotizantesPermitidos de la clase PlanillaAportanteDTO
	 *
	 * @param numeroCotizantesPermitidos
	 *            the numeroCotizantesPermitidos to set
	 */
	public void setNumeroCotizantesPermitidos(Integer numeroCotizantesPermitidos) {
		this.numeroCotizantesPermitidos = numeroCotizantesPermitidos;
	}

	/**
	 * Método getter del atributo idSoiEntidadFinanciera de la clase PlanillaAportanteDTO
	 *
	 * @return the idSoiEntidadFinanciera
	 */
	public Integer getIdSoiEntidadFinanciera() {
		return idSoiEntidadFinanciera;
	}

	/**
	 * Método setter del atributo idSoiEntidadFinanciera de la clase PlanillaAportanteDTO
	 *
	 * @param idSoiEntidadFinanciera
	 *            the idSoiEntidadFinanciera to set
	 */
	public void setIdSoiEntidadFinanciera(Integer idSoiEntidadFinanciera) {
		this.idSoiEntidadFinanciera = idSoiEntidadFinanciera;
	}

	/**
	 * Método getter del atributo apteSeccionalFiscalia de la clase PlanillaAportanteDTO
	 *
	 * @return the apteSeccionalFiscalia
	 */
	public Boolean getApteSeccionalFiscalia() {
		return apteSeccionalFiscalia;
	}

	/**
	 * Método setter del atributo apteSeccionalFiscalia de la clase PlanillaAportanteDTO
	 *
	 * @param apteSeccionalFiscalia
	 *            the apteSeccionalFiscalia to set
	 */
	public void setApteSeccionalFiscalia(Boolean apteSeccionalFiscalia) {
		this.apteSeccionalFiscalia = apteSeccionalFiscalia;
	}

	/**
	 * Método getter del atributo exitePlanillaPreviaResolucion1233 de la clase PlanillaAportanteDTO
	 *
	 * @return the exitePlanillaPreviaResolucion1233
	 */
	public Boolean getExitePlanillaPreviaResolucion1233() {
		return exitePlanillaPreviaResolucion1233;
	}

	/**
	 * Método setter del atributo exitePlanillaPreviaResolucion1233 de la clase PlanillaAportanteDTO
	 *
	 * @param exitePlanillaPreviaResolucion1233
	 *            the exitePlanillaPreviaResolucion1233 to set
	 */
	public void setExitePlanillaPreviaResolucion1233(Boolean exitePlanillaPreviaResolucion1233) {
		this.exitePlanillaPreviaResolucion1233 = exitePlanillaPreviaResolucion1233;
	}

	/**
	 * Método getter del atributo usuarioSolicitaCambioNormatividad de la clase PlanillaAportanteDTO
	 *
	 * @return the usuarioSolicitaCambioNormatividad
	 */
	public Boolean getUsuarioSolicitaCambioNormatividad() {
		return usuarioSolicitaCambioNormatividad;
	}

	/**
	 * Método setter del atributo usuarioSolicitaCambioNormatividad de la clase PlanillaAportanteDTO
	 *
	 * @param usuarioSolicitaCambioNormatividad
	 *            the usuarioSolicitaCambioNormatividad to set
	 */
	public void setUsuarioSolicitaCambioNormatividad(Boolean usuarioSolicitaCambioNormatividad) {
		this.usuarioSolicitaCambioNormatividad = usuarioSolicitaCambioNormatividad;
	}

	/**
	 * Método getter del atributo normatividad de la clase PlanillaAportanteDTO
	 *
	 * @return the normatividad
	 */
	public Map<String, Boolean> getNormatividad() {
		return normatividad;
	}

	/**
	 * Método setter del atributo normatividad de la clase PlanillaAportanteDTO
	 *
	 * @param normatividad
	 *            the normatividad to set
	 */
	public void setNormatividad(Map<String, Boolean> normatividad) {
		this.normatividad = normatividad;
	}

}

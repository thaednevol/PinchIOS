package co.swatit.pilautil.dto.out;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.ach.cfg.biz.type.EstadoPlanillaType;

import co.swatit.pilautil.dto.ResponseDTO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getConsultPayrollOutDTO", propOrder = { "idSoiTpIdentApte", "nombreTpIndentApte", "numeroIdentApte", "idSoiTpIdentificacionApte",
		"nombreAportante", "idSoiTpAportante", "nombreTpAportante", "idSoiClaseAportante", 
		"nombreClaseAportante", "idSoiTpEmpresa", "nombreTpEmpresa",
		"numeroEmpleados", "cantidadCotizante", "idSoiFormaPresentacion", 
		"nombreFormaPresentacion", "idSoiAdmraArp", "nombreAdmraArp",
		"idSoiAdmraCcf", "nombreAdmraCcf", "idSoiTpPlanilla", "nombreTpPlanilla",
		"numeroAsistida", "numeroElectronica", "modalidadPlanilla", "idSoiFilial",
		"idSoiFilial", "nombreFilial", "diasMora", "tasaMora",
		"valorMora", "periodoSalud", "periodoNoSalud", "idFormaElaboracion",
		"fechaPagoCalendario", "fechaPagoefectiva", "numeroPlanillaReferida", "fechaPagoPlanillaReferida",
		"idSoiTpPlanillaReferida", "codigoTpPlanillaReferida", "nombreTpPlanillaReferida", "estadoPlanilla",
		"confirmacionRetroactivo", "idSoiAportante", "fechaRegistroMercantil", "codDepartamentoAportante",
		"codMunicipioAportante", "guardadaCompletamente", "calcularMora", "valorTotalPago", 
		"exoneradoParafiscales", "idResponsableLiqAportante"})
public class GetConsultPayrollOutDTO extends ResponseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idSoiTpIdentApte;
	private String nombreTpIndentApte;
	private String numeroIdentApte;
	private Integer idSoiTpIdentificacionApte;

	private String nombreAportante;
	private Integer idSoiTpAportante;
	private String nombreTpAportante;
	private Integer idSoiClaseAportante;
	private String nombreClaseAportante;
	private Integer idSoiTpEmpresa;
	private String nombreTpEmpresa;
	
	// numero_empleados el total de empleados que tiene la planilla
	// cantidad_cotizante el total de cotizantes que finalmente vienen en el archivo ( group by numero y tipo de identificacion)
	private Long numeroEmpleados;
	private Long cantidadCotizante;
	private Integer idSoiFormaPresentacion;
	private String nombreFormaPresentacion;
	private Integer idSoiAdmraArp;
	private String nombreAdmraArp;
	private Integer idSoiAdmraCcf;
	private String nombreAdmraCcf;
	private Integer idSoiTpPlanilla;
	private String nombreTpPlanilla;
	private String numeroAsistida;
	private String numeroElectronica;
	private Integer modalidadPlanilla;
	private Long idSoiFilial;
	private String nombreFilial;
	private Integer diasMora;
	private BigDecimal tasaMora;
	private BigDecimal valorMora;
	private String periodoSalud;
	private String periodoNoSalud;
	private Integer idFormaElaboracion;
	private Calendar fechaPagoCalendario;
	private Calendar fechaPagoefectiva;
	private String numeroPlanillaReferida;
	private Calendar fechaPagoPlanillaReferida;
	private Integer idSoiTpPlanillaReferida;
	private String codigoTpPlanillaReferida;
	private String nombreTpPlanillaReferida;
	private EstadoPlanillaType estadoPlanilla;
	private boolean confirmacionRetroactivo;
	private Long idSoiAportante;
	private Calendar fechaRegistroMercantil;
	private String codDepartamentoAportante;
	private String codMunicipioAportante;
	private Integer guardadaCompletamente;
	private boolean calcularMora = true;
	private Long valorTotalPago;
	private String exoneradoParafiscales;
	private Integer idResponsableLiqAportante;
	
	public Integer getIdSoiTpIdentApte() {
		return idSoiTpIdentApte;
	}
	public void setIdSoiTpIdentApte(Integer idSoiTpIdentApte) {
		this.idSoiTpIdentApte = idSoiTpIdentApte;
	}
	public String getNombreTpIndentApte() {
		return nombreTpIndentApte;
	}
	public void setNombreTpIndentApte(String nombreTpIndentApte) {
		this.nombreTpIndentApte = nombreTpIndentApte;
	}
	public String getNumeroIdentApte() {
		return numeroIdentApte;
	}
	public void setNumeroIdentApte(String numeroIdentApte) {
		this.numeroIdentApte = numeroIdentApte;
	}
	public Integer getIdSoiTpIdentificacionApte() {
		return idSoiTpIdentificacionApte;
	}
	public void setIdSoiTpIdentificacionApte(Integer idSoiTpIdentificacionApte) {
		this.idSoiTpIdentificacionApte = idSoiTpIdentificacionApte;
	}
	public String getNombreAportante() {
		return nombreAportante;
	}
	public void setNombreAportante(String nombreAportante) {
		this.nombreAportante = nombreAportante;
	}
	public Integer getIdSoiTpAportante() {
		return idSoiTpAportante;
	}
	public void setIdSoiTpAportante(Integer idSoiTpAportante) {
		this.idSoiTpAportante = idSoiTpAportante;
	}
	public String getNombreTpAportante() {
		return nombreTpAportante;
	}
	public void setNombreTpAportante(String nombreTpAportante) {
		this.nombreTpAportante = nombreTpAportante;
	}
	public Integer getIdSoiClaseAportante() {
		return idSoiClaseAportante;
	}
	public void setIdSoiClaseAportante(Integer idSoiClaseAportante) {
		this.idSoiClaseAportante = idSoiClaseAportante;
	}
	public String getNombreClaseAportante() {
		return nombreClaseAportante;
	}
	public void setNombreClaseAportante(String nombreClaseAportante) {
		this.nombreClaseAportante = nombreClaseAportante;
	}
	public Integer getIdSoiTpEmpresa() {
		return idSoiTpEmpresa;
	}
	public void setIdSoiTpEmpresa(Integer idSoiTpEmpresa) {
		this.idSoiTpEmpresa = idSoiTpEmpresa;
	}
	public String getNombreTpEmpresa() {
		return nombreTpEmpresa;
	}
	public void setNombreTpEmpresa(String nombreTpEmpresa) {
		this.nombreTpEmpresa = nombreTpEmpresa;
	}
	public Long getNumeroEmpleados() {
		return numeroEmpleados;
	}
	public void setNumeroEmpleados(Long numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}
	public Long getCantidadCotizante() {
		return cantidadCotizante;
	}
	public void setCantidadCotizante(Long cantidadCotizante) {
		this.cantidadCotizante = cantidadCotizante;
	}
	public Integer getIdSoiFormaPresentacion() {
		return idSoiFormaPresentacion;
	}
	public void setIdSoiFormaPresentacion(Integer idSoiFormaPresentacion) {
		this.idSoiFormaPresentacion = idSoiFormaPresentacion;
	}
	public String getNombreFormaPresentacion() {
		return nombreFormaPresentacion;
	}
	public void setNombreFormaPresentacion(String nombreFormaPresentacion) {
		this.nombreFormaPresentacion = nombreFormaPresentacion;
	}
	public Integer getIdSoiAdmraArp() {
		return idSoiAdmraArp;
	}
	public void setIdSoiAdmraArp(Integer idSoiAdmraArp) {
		this.idSoiAdmraArp = idSoiAdmraArp;
	}
	public String getNombreAdmraArp() {
		return nombreAdmraArp;
	}
	public void setNombreAdmraArp(String nombreAdmraArp) {
		this.nombreAdmraArp = nombreAdmraArp;
	}
	public Integer getIdSoiAdmraCcf() {
		return idSoiAdmraCcf;
	}
	public void setIdSoiAdmraCcf(Integer idSoiAdmraCcf) {
		this.idSoiAdmraCcf = idSoiAdmraCcf;
	}
	public String getNombreAdmraCcf() {
		return nombreAdmraCcf;
	}
	public void setNombreAdmraCcf(String nombreAdmraCcf) {
		this.nombreAdmraCcf = nombreAdmraCcf;
	}
	public Integer getIdSoiTpPlanilla() {
		return idSoiTpPlanilla;
	}
	public void setIdSoiTpPlanilla(Integer idSoiTpPlanilla) {
		this.idSoiTpPlanilla = idSoiTpPlanilla;
	}
	public String getNombreTpPlanilla() {
		return nombreTpPlanilla;
	}
	public void setNombreTpPlanilla(String nombreTpPlanilla) {
		this.nombreTpPlanilla = nombreTpPlanilla;
	}
	public String getNumeroAsistida() {
		return numeroAsistida;
	}
	public void setNumeroAsistida(String numeroAsistida) {
		this.numeroAsistida = numeroAsistida;
	}
	public String getNumeroElectronica() {
		return numeroElectronica;
	}
	public void setNumeroElectronica(String numeroElectronica) {
		this.numeroElectronica = numeroElectronica;
	}
	public Integer getModalidadPlanilla() {
		return modalidadPlanilla;
	}
	public void setModalidadPlanilla(Integer modalidadPlanilla) {
		this.modalidadPlanilla = modalidadPlanilla;
	}
	public Long getIdSoiFilial() {
		return idSoiFilial;
	}
	public void setIdSoiFilial(Long idSoiFilial) {
		this.idSoiFilial = idSoiFilial;
	}
	public String getNombreFilial() {
		return nombreFilial;
	}
	public void setNombreFilial(String nombreFilial) {
		this.nombreFilial = nombreFilial;
	}
	public Integer getDiasMora() {
		return diasMora;
	}
	public void setDiasMora(Integer diasMora) {
		this.diasMora = diasMora;
	}
	public BigDecimal getTasaMora() {
		return tasaMora;
	}
	public void setTasaMora(BigDecimal tasaMora) {
		this.tasaMora = tasaMora;
	}
	public BigDecimal getValorMora() {
		return valorMora;
	}
	public void setValorMora(BigDecimal valorMora) {
		this.valorMora = valorMora;
	}
	public String getPeriodoSalud() {
		return periodoSalud;
	}
	public void setPeriodoSalud(String periodoSalud) {
		this.periodoSalud = periodoSalud;
	}
	public String getPeriodoNoSalud() {
		return periodoNoSalud;
	}
	public void setPeriodoNoSalud(String periodoNoSalud) {
		this.periodoNoSalud = periodoNoSalud;
	}
	public Integer getIdFormaElaboracion() {
		return idFormaElaboracion;
	}
	public void setIdFormaElaboracion(Integer idFormaElaboracion) {
		this.idFormaElaboracion = idFormaElaboracion;
	}
	public Calendar getFechaPagoCalendario() {
		return fechaPagoCalendario;
	}
	public void setFechaPagoCalendario(Calendar fechaPagoCalendario) {
		this.fechaPagoCalendario = fechaPagoCalendario;
	}
	public Calendar getFechaPagoefectiva() {
		return fechaPagoefectiva;
	}
	public void setFechaPagoefectiva(Calendar fechaPagoefectiva) {
		this.fechaPagoefectiva = fechaPagoefectiva;
	}
	public String getNumeroPlanillaReferida() {
		return numeroPlanillaReferida;
	}
	public void setNumeroPlanillaReferida(String numeroPlanillaReferida) {
		this.numeroPlanillaReferida = numeroPlanillaReferida;
	}
	public Calendar getFechaPagoPlanillaReferida() {
		return fechaPagoPlanillaReferida;
	}
	public void setFechaPagoPlanillaReferida(Calendar fechaPagoPlanillaReferida) {
		this.fechaPagoPlanillaReferida = fechaPagoPlanillaReferida;
	}
	public Integer getIdSoiTpPlanillaReferida() {
		return idSoiTpPlanillaReferida;
	}
	public void setIdSoiTpPlanillaReferida(Integer idSoiTpPlanillaReferida) {
		this.idSoiTpPlanillaReferida = idSoiTpPlanillaReferida;
	}
	public String getCodigoTpPlanillaReferida() {
		return codigoTpPlanillaReferida;
	}
	public void setCodigoTpPlanillaReferida(String codigoTpPlanillaReferida) {
		this.codigoTpPlanillaReferida = codigoTpPlanillaReferida;
	}
	public String getNombreTpPlanillaReferida() {
		return nombreTpPlanillaReferida;
	}
	public void setNombreTpPlanillaReferida(String nombreTpPlanillaReferida) {
		this.nombreTpPlanillaReferida = nombreTpPlanillaReferida;
	}
	public EstadoPlanillaType getEstadoPlanilla() {
		return estadoPlanilla;
	}
	public void setEstadoPlanilla(EstadoPlanillaType estadoPlanilla) {
		this.estadoPlanilla = estadoPlanilla;
	}
	public boolean isConfirmacionRetroactivo() {
		return confirmacionRetroactivo;
	}
	public void setConfirmacionRetroactivo(boolean confirmacionRetroactivo) {
		this.confirmacionRetroactivo = confirmacionRetroactivo;
	}
	public Long getIdSoiAportante() {
		return idSoiAportante;
	}
	public void setIdSoiAportante(Long idSoiAportante) {
		this.idSoiAportante = idSoiAportante;
	}
	public Calendar getFechaRegistroMercantil() {
		return fechaRegistroMercantil;
	}
	public void setFechaRegistroMercantil(Calendar fechaRegistroMercantil) {
		this.fechaRegistroMercantil = fechaRegistroMercantil;
	}
	public String getCodDepartamentoAportante() {
		return codDepartamentoAportante;
	}
	public void setCodDepartamentoAportante(String codDepartamentoAportante) {
		this.codDepartamentoAportante = codDepartamentoAportante;
	}
	public String getCodMunicipioAportante() {
		return codMunicipioAportante;
	}
	public void setCodMunicipioAportante(String codMunicipioAportante) {
		this.codMunicipioAportante = codMunicipioAportante;
	}
	public Integer getGuardadaCompletamente() {
		return guardadaCompletamente;
	}
	public void setGuardadaCompletamente(Integer guardadaCompletamente) {
		this.guardadaCompletamente = guardadaCompletamente;
	}
	public boolean isCalcularMora() {
		return calcularMora;
	}
	public void setCalcularMora(boolean calcularMora) {
		this.calcularMora = calcularMora;
	}
	public Long getValorTotalPago() {
		return valorTotalPago;
	}
	public void setValorTotalPago(Long valorTotalPago) {
		this.valorTotalPago = valorTotalPago;
	}
	public String getExoneradoParafiscales() {
		return exoneradoParafiscales;
	}
	public void setExoneradoParafiscales(String exoneradoParafiscales) {
		this.exoneradoParafiscales = exoneradoParafiscales;
	}
	public Integer getIdResponsableLiqAportante() {
		return idResponsableLiqAportante;
	}
	public void setIdResponsableLiqAportante(Integer idResponsableLiqAportante) {
		this.idResponsableLiqAportante = idResponsableLiqAportante;
	}

}

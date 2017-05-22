package co.swatit.pilawebservices.soi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import co.swatit.pilautil.dto.out.ArchivoEnProcesoDTO;
import co.swatit.pilautil.dto.out.PlanillaAportanteDTO;
import co.swatit.pilautil.exception.BusinessException;
import co.swatit.pilautil.exception.codeenum.CodeErrorEnum;
import co.swatit.pilautil.generics.Constants;
import co.swatit.pilautil.generics.Utilities;

import com.ach.arc.biz.r1747.model.bean.PlanillaRegT01;
import com.ach.arc.biz.r1747.type.TipoInputImplType;
import com.ach.arc.biz.r1747.util.ArchivoEntradaParser;
import com.ach.cfg.biz.type.TipoFormasPresentacionType;
import com.ach.pla.biz.type.EstadoProcesosArchivoPlanoType;
import com.blackbear.flatworm.ConfigurationReader;
import com.blackbear.flatworm.FileFormat;
import com.blackbear.flatworm.errors.FlatwormConfigurationValueException;
import com.lucasian.exception.ApplicationException;

/**
 * Clase que realiza el proceso de obtener la configuración de la aplicación SOI Empresarial
 *
 * @author SWAT-IT <br>
 *         Daniel Moncada Tabares <br>
 *         Email: dmoncada@swat-it.co
 * 
 * @date 15/02/2017
 * @version 1.0
 */
public final class ApplicationConfiguration {

	private ApplicationConfiguration() {

	}

	/**
	 * 
	 * Método que construye la PlanillaRegT01 que contiene los datos de la primera linea del Archivo
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 15/02/2017
	 *
	 * @param regT01
	 * @return
	 * @throws Exception
	 */
	public static PlanillaRegT01 buildPlanillaRegT01(String regT01) throws BusinessException {
		FileFormat fileFormat = null;
		ArchivoEntradaParser archivoEntrada = null;
		PlanillaRegT01 planillaRegT01 = null;
		try {
			fileFormat = new ConfigurationReader()
					.loadConfigurationFile(new FileInputStream(Constants.ARCHIVO_2388_XML));
			archivoEntrada = new ArchivoEntradaParser(TipoInputImplType.IO_BUFFERED_READER, fileFormat);
			archivoEntrada.inicializarMio(regT01);
			planillaRegT01 = (PlanillaRegT01) archivoEntrada.getNextRecord();
			return planillaRegT01;
		} catch (ApplicationException e) {
			throw new BusinessException(CodeErrorEnum.getEnum(String.valueOf(e.getCodigo())), e);
		} catch (FlatwormConfigurationValueException e) {
			throw new BusinessException(CodeErrorEnum.ERRORUNEXPECTED, e);
		} catch (FileNotFoundException e) {
			throw new BusinessException(CodeErrorEnum.ERRORUNEXPECTED, e);
		} catch (ParserConfigurationException e) {
			throw new BusinessException(CodeErrorEnum.ERRORUNEXPECTED, e);
		} catch (IOException e) {
			throw new BusinessException(CodeErrorEnum.ERRORUNEXPECTED, e);
		} catch (SAXException e) {
			throw new BusinessException(CodeErrorEnum.ERRORUNEXPECTED, e);
		}
	}

	/**
	 * 
	 * Método que construye un objeto ArchivoEnProcesoDTO para realizar la respuesta del servicio
	 *
	 * @author SWAT-IT <br>
	 *         Daniel Moncada Tabares <br>
	 *         Email: dmoncada@swat-it.co
	 * 
	 * @date 16/02/2017
	 *
	 * @param planillaAportanteDTO
	 *            , planilla del aportante
	 * @param planillaRegT01
	 *            , primera linea de la planilla
	 * @return {@link ArchivoEnProcesoDTO} con la información construida para realizar la respuesta del servicio
	 * @throws BusinessException
	 *             , cuando algún campo tipo {@link Calendar} no tiene un formato correcto para ser convertido
	 */
	public static ArchivoEnProcesoDTO buildArchivoEnProceso(PlanillaAportanteDTO planillaAportanteDTO,
			PlanillaRegT01 planillaRegT01) throws BusinessException {
		ArchivoEnProcesoDTO retorno = new ArchivoEnProcesoDTO();
		retorno.setAceptaRenunciaLey1233(Boolean.FALSE);
		retorno.setAportanteLey1607(Boolean.FALSE);
		retorno.setCodigoSucursal(planillaAportanteDTO.getCodigoSucursal());
		retorno.setCodTipoPlanilla(planillaAportanteDTO.getCodigoSoiTpPlanilla());
		retorno.setCodTpDocAportante(planillaAportanteDTO.getInformacionAportantePlanillaDTO()
				.getCodSoiTpIdentificacion());
		retorno.setEstadoProcesosArchivoPlanoType(EstadoProcesosArchivoPlanoType.EN_PROCESO.name());
		retorno.setFechaPlanillaAsociada(Utilities.convertCalendarToString(planillaRegT01
				.getFcaPagoPlanillaAsociadaType()));
		retorno.setIdAportante(planillaAportanteDTO.getIdSoiAportante());
		retorno.setNombreAportante(planillaAportanteDTO.getInformacionAportantePlanillaDTO().getNombre());
		retorno.setNroDocAportante(planillaAportanteDTO.getInformacionAportantePlanillaDTO().getNumeroIdentificacion());
		retorno.setNumeroPlanillaAsociada(planillaAportanteDTO.getNumeroPlanillaAsocida());
		retorno.setNumeroTotalDeEmpleadosEnPlanilla(planillaAportanteDTO.getNumeroTotalEmpleados().intValue());
		retorno.setPeriodoNoSalud(planillaAportanteDTO.getPeriodoLiquidacionNoSalud());
		retorno.setPeriodoSalud(planillaAportanteDTO.getPeriodoLiquidacionSalud());
		retorno.setPlanillaCorrector(Boolean.TRUE);
		retorno.setTipoFormaPresentacionType(TipoFormasPresentacionType.getTipoFormasPresentacionXId(
				planillaAportanteDTO.getIdSoiFormaPresentacion()).name());
		return retorno;
	}

}

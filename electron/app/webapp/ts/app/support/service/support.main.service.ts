/// <reference path="../../../dt/angular.d.ts"/>

namespace app.support {

  /**
   * @class SupportService
   * @author Luis Felipe Zapata Castaño <lzapata@swat-it.co>
   * @description
   * Servicio para realizar el proceso de envio de emails por medio de los JAR
   * que ejecutan el servidor de springboot, crea la estructura de JSON que
   * son entregados como parametros a los servicios POST.
   */
  class SupportService {

    /**
    * @type {Object} OPTIONS - Equivale al archivo de opciones del sistema.
    * @see app/webapp/json/data/options.json
    */
    private OPTIONS: any;

    /**
    * @type {String} routeServer - Indica cual es la ruta del servidor que
    * ejecuta el springboot
    */
    private routeserver: string;

    /**
    * @type {Object} servicesName - La lista contiene el nombre de los metodos
    * de los servicios REST que se consumen.
    */
    private servicesName: any;

    private $resource: any;
    static $inject = ["$resource", "OPTIONS"];

    constructor($resource, OPTIONS) {
      this.$resource = $resource;
      this.OPTIONS = OPTIONS;
      this.routeserver = `${this.OPTIONS.SERVER_SPRING.SERVER}:${this.OPTIONS.SERVER_SPRING.PORT}/`;
      this.servicesName = this.OPTIONS.SERVER_SPRING.SERVICES;
    }

    /**
    * @description
    * Hace el envio de los comprobantes del soporte de pago a los contribuidores
    * por medio de email.
    */
    public send(): void {
      let server: string = `${this.routeserver}${this.servicesName.SUPPORTS}`;
      return this.$resource(server);
    }

    /**
    * @description
    * Retorna la estructura JSON del la cebecera del archivo que es solicitada
    * para realizar la construcción del archivo de envio de emails, el contenido
    * es asignado como parametro al metodo "datosEncabezado".
    *
    * TODO
    * Advertencia.
    * Se agrega el parametro fileConfig, este extrae la información del archivo
    * de configuración descargado de la función de liquidar planilla, presenta
    * errores que se estan corrigiendo por parte del cliente de SOI para evitar
    * hacer uso del archivo, cuando se solucione este parametro se debe eliminar.
    * Los campos comentados a final indican que se deben convertir a millisegundos
    * de momento el valor siempre es entregado con 0, por lo que nos e puede
    * validar la conversión.
    *
    * @param {Object} fileConfig - Archivo de configuración con las opciones de
    * departamentos y municipios.
    * @param {Object} infoContributor - Contiene la información del archivo de
    * configuración
    * @param {number} idUserSupport - Identificador del usuario que genera el
    * soporte de pago.
    * @return {Object} JSON con información del encabezado del archivo.
    */
    public infoHeadFile(fileConfig, infoContributor: any, idUserSupport): any {
      let nameCity: string = "";
      let nameDepartament: string = "";
      if (fileConfig.municipiosMap[infoContributor.informacionAportantePlanillaDTO.codMunicipioAportante]) {
        nameCity = fileConfig.municipiosMap[infoContributor.informacionAportantePlanillaDTO.codMunicipioAportante].nombre;
      }
      if (fileConfig.departamentosMap[infoContributor.informacionAportantePlanillaDTO.codDepartamentoAportante]) {
        nameDepartament = fileConfig.departamentosMap[infoContributor.informacionAportantePlanillaDTO.codDepartamentoAportante].nombre;
      }
      let headFile = {
        nombreTipoIdentificacion: infoContributor.informacionAportantePlanillaDTO.nombreTpIdentificacion,
        nombreAportante: infoContributor.informacionAportantePlanillaDTO.nombre,
        nombreMunicipioAportante: nameCity,
        direccionAportante: infoContributor.informacionAportantePlanillaDTO.direccionAportante,
        nombreTipoAportante: infoContributor.informacionAportantePlanillaDTO.nombreTpAportante,
        nombreTipoEmpresaAportante: infoContributor.informacionAportantePlanillaDTO.nombreTpEmpresa,
        nombreFrmPresentacionAportante: infoContributor.informacionAportantePlanillaDTO.nombreFormaPresentacion,
        numeroIdentificacionAportante: infoContributor.informacionAportantePlanillaDTO.numeroIdentificacion,
        nombreDepartamentoAportante: nameDepartament,
        telefonoAportante: infoContributor.informacionAportantePlanillaDTO.telefonoAportante,
        claseAportante: infoContributor.informacionAportantePlanillaDTO.nombreClaseAportante,
        actividadEconAportante: null,
        nombreFilialAportante: infoContributor.nombreSucursal,
        codigoFilialAportante: infoContributor.codigoSucursal,
        numeroAsistidaPlanilla: infoContributor.numeroPlanillaAsistida,
        numeroElectronicaPlanilla: infoContributor.numeroPlanillaElectronica,
        nombreTipoPlanilla: infoContributor.nombreSoiTpPlanilla,
        diasMoraPlanilla: infoContributor.numeroDiasMoraPnllaJ || 0,
        numeroAutorizacionPagoPlanilla: null,
        valorTotalAPagar: infoContributor.valorPagado || 0,
        comision: infoContributor.comision || 0,
        ivaComision: infoContributor.ivaComision || 0,
        CodigoOperador: infoContributor.informacionAportantePlanillaDTO.codigoOperador,
        tituloDelRpt: "Soporte Cotizante",
        exoneradoParafiscales: null,
        nombreUsuarioQueGeneraElReporte: idUserSupport,
        cotizantesImprimirEsapMinedu: null,
        cotizantesPlanillaN: null,
        noMostrarDiasMora: null,
        modalidad: fileConfig.planillaApteDto.modalidadPlanilla,
        usuarioAceptaRetroactivoPlanillaPublica: null,
        nombreLogo: null,
        periodoCotOtrosPlanillaString: infoContributor.periodoLiquidacionNoSalud,
        periodoCotSaludPlanillaString: infoContributor.periodoLiquidacionSalud,
        fechaPagoCalendarioPlanillaInMillis: infoContributor.fechaPagoPlanillaAsociada || 0, // convertir a milisegundos",
        fechaPagoEfectivaPlanillaInMillis: infoContributor.fechaDePagoEfectiva || 0, // convertir a milisegundos,
        fechaPlanillaReferidaPlanillaInMillis: infoContributor.fechaPagoPlanillaAsociada || 0
      };
      return headFile;
    }

    /**
    * @description
    * Crea el objeto que se adjunta al array que almacena la información de los
    * contribuyentes asociados a la planilla de pagos.
    *
    * @param {Object} dataContributor - Información del contribuyente para
    * generar el objeto de envio de paramatro.
    * @param {Object} dataSettlement - Información relacionada con la planilla
    * de pago.
    * @param {String} emailContributor - Correo electronico del contribuidor al
    * que sera enviado el documento de soporte generado.
    * @return {Object} Objeto para envio como parametro del servicio REST de
    * envio de emails.
    */
    public infoContributor(dataContributor: any, dataSettlement: any, emailContributor: string): any {
      let valueValidateX = "";
      if (dataContributor.novedades.length > 0) {
        valueValidateX = dataContributor.novedades[0].tipoNovedad.substr(0, 3)
      }
      let contributor = {
        ING: this.validateFieldNull("ING", valueValidateX),
        RET: this.validateFieldNull("RET", valueValidateX),
        TDE: this.validateFieldNull("TDE", valueValidateX),
        TAE: this.validateFieldNull("TAE", valueValidateX),
        TDP: this.validateFieldNull("TDP", valueValidateX),
        TAP: this.validateFieldNull("TAP", valueValidateX),
        COR: this.validateFieldNull("COR", valueValidateX),
        VSP: this.validateFieldNull("VSP", valueValidateX),
        VST: this.validateFieldNull("VST", valueValidateX),
        SLN: this.validateFieldNull("SLN", valueValidateX),
        IGE: this.validateFieldNull("IGE", valueValidateX),
        LMA: this.validateFieldNull("LMA", valueValidateX),
        VAC: this.validateFieldNull("VAC", valueValidateX),
        AVP: this.validateFieldNull("AVP", valueValidateX),
        VCT: this.validateFieldNull("VCT", valueValidateX),
        IRP: this.validateFieldNull("IRP", valueValidateX),
        COM: this.validateFieldNull("COM", valueValidateX),
        nombreAdministradoraTDE: null,
        nombreAdministradoraTAE: null,
        nombreAdministradoraTDP: null,
        nombreAdministradoraTAP: null,
        diasTotalIRP: null,
        numeroPlanilla: dataSettlement.numeroPlanillaActual,
        esTipoPlanillaN: false,
        generaSoportePorCorreoDeCadaCotizante: false,
        exoneradoParafiscalesAportante: dataSettlement.aportanteLey1607 ? "SI" : "NO",
        exoneradoParafiscalesCotizante: dataContributor.exoneradoParafiscales,
        consecutivo: 0,
        modificado: dataContributor.modificado,
        seleccionado: dataContributor.seleccionado,
        exoneradoParafiscales: dataContributor.exoneradoParafiscales,
        tiempoEjb0: dataContributor.tiempoEjb0,
        tiempoEjb1: dataContributor.tiempoEjb1,
        mostrarDiasLaborados: dataContributor.mostrarDiasLaborados,
        idWebCotizante: dataContributor.idWebCotizante,
        idWebSlnComCotizante: dataContributor.idWebSlnComCotizante,
        datosBasicosCotizanteVO: {
          codTipoIdentificacion: dataContributor.datosBasicosCotizanteDTO.codTipoIdentificacion,
          nroIdentificacion: dataContributor.datosBasicosCotizanteDTO.nroIdentificacion,
          primerNombre: dataContributor.datosBasicosCotizanteDTO.primerNombre,
          primerApellido: dataContributor.datosBasicosCotizanteDTO.primerApellido,
          dscTipoCotizante: dataContributor.datosBasicosCotizanteDTO.dscTipoCotizante,
          nombreDepartamento: dataContributor.datosBasicosCotizanteDTO.nombreDepartamento,
          nombreMunicipio: dataContributor.datosBasicosCotizanteDTO.nombreMunicipio,
          salario: dataContributor.datosBasicosCotizanteDTO.salario,
          salarioIntegral: dataContributor.datosBasicosCotizanteDTO.salarioIntegral,
          cargadoPlanillaPreviaPagada: dataContributor.datosBasicosCotizanteDTO.cargadoPlanillaPreviaPagada
        },
        jsonAportesSubsistemasString: dataContributor.jsonAportesSubsistemasString,
        aplicaFSP: dataContributor.aplicaFSP,
        cargadoPlanillaAnteriorPagada: dataContributor.cargadoPlanillaAnteriorPagada,
        esCotizanteSln: dataContributor.esCotizanteSln,
        esCotizanteCom: dataContributor.esCotizanteCom,
        cotizanteLey1607: dataContributor.cotizanteLey1607,
        validarArpEntPub: dataContributor.validarArpEntPub,
        existeConfiguracionTpCzte4: dataContributor.existeConfiguracionTpCzte4,
        concuerdaTarifaSalud: dataContributor.concuerdaTarifaSalud,
        concuerdaTarifaArp: dataContributor.concuerdaTarifaArp,
        origenPlanillaPagada: dataContributor.origenPlanillaPagada,
        esCotizante23: dataContributor.esCotizante23,
        adminEditable: dataContributor.adminEditable,
        UPCEditable: dataContributor.upcEditable,
        valorUpcModificado: dataContributor.valorUpcModificado,
        esPlanillaNReferidaT: dataContributor.esPlanillaNReferidaT,
        administradoraEpsRegC: dataContributor.administradoraEpsRegC,
        calculosDiasIBC: dataContributor.calculosDiasIBC,
        liquidacionSoloFsp: dataContributor.liquidacionSoloFsp,
        planillaJReferida: dataContributor.planillaJReferida,
        correoSoporteCotizante: emailContributor
      };
      return contributor;
    }

    /**
    * @private
    * @description
    * Por regla del negocio se debe validar que el campo coincida con el valor
    * si es el mismo se asignara el valor de X de lo contrario sera vacio.
    *
    * @param {String} field - Nombre del campo del JSON que se compara.
    * @param {String} value - Valor actual de la planilla para comparar con el
    * campo.
    * @return {String} String vacio o con el valor X si coincide la información
    * del campo con el valor.
    */
    private validateFieldNull(field: string, value: string): string {
      if (field === value) {
        return "X";
      }
      return "";
    }

  }

  // Carga del servicio al modulo principal
  let app: any = angular.module("PILA");
  app.service("support.service", SupportService);
}

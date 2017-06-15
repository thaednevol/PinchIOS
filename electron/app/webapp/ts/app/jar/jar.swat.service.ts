/// <reference path="../../dt/angular.d.ts"/>

namespace app.jar {

  /**
   * @class SwatService
   * @author Luis Felipe Zapata Castaño <lzapata@swat-it.co>
   * @description
   * Realiza la ejecución de los metodos almacenados en el JAR desarrollador por
   * SWAT para integrar con la aplicación.
   */
  class SwatService {

    /**
    * @type {NaviteJarService} jar - Servicio nativo de NodeJS para consumo de JAR.
    * @see app.native.JarNodeService
    */
    private jar: any;

    /**
    * @type {Object} OPTIONS - Equivale al archivo de opciones del sistema.
    * @see app/webapp/json/data/options.json
    */
    private OPTIONS: any;

    /**
    * @type {NativeNotificationService} nativeNotification - Clase que se encarga
    * de mostrar notificaciones por medio de alerts nativos.
    * @see app.native.NativeNotificationService
    */
    private nativeNotification: any;

    /**
    * @type {Object} jarSwat - Hace referencia al contenido asignado en el
    * archivo de opciones para el JAR que desarrollo Swat.
    */
    private jarSwat: any;

    /**
    * @type {NativeFileService} file - Manipula los archivos que se encuentran
    * almacenados en la carpeta del programa.
    * @see app.native.NativeFileService
    */
    private file: any;

    /**
    * @type {String} timerConsultFile - Identificador del timer que se utiliza
    * para realizar el llamado al metodo JAR de consulta de información.
    */
    private timerConsultFile: any = null;

    /**
    * @type {NativeDialogService} dialog - Administra las ventanas nativas
    * del sistema operativo.
    */
    private dialog: any;



    private $localStorage: any;
    private $filter: any;
    private $rootScope: any;
    static $inject = ["native.dialog.service", "native.jar.service", "OPTIONS", "native.file.service", "native.notification.service", "$localStorage", "$filter", "$rootScope"];

    constructor(dialog, jar, OPTIONS, file, nativeNotification, $localStorage, $filter, $rootScope) {
      this.dialog = dialog;
      this.jar = jar;
      this.jarSwat = OPTIONS.JAR.FILES.SWAT;
      this.OPTIONS = OPTIONS;
      this.file = file;
      this.nativeNotification = nativeNotification;
      this.$localStorage = $localStorage;
      this.$filter = $filter;
      this.$rootScope = $rootScope;
    }

    /**
    * @description
    * Ejecuta el llamado al metodo encargado de realizar el login en la aplicación.
    *
    * @param {Object} dataForm - Lista de modelos del formulario para extraer
    * la información de los parametros del metodo JAR.
    * @return {Promise} La promesa solo retorna un resolve, en caso de error
    * el campo error del object es true.
    */
    public login(dataForm): any {
      let dataLogin: any = {
        contributorIdType: dataForm.typeCompany,
        contributorIdNumber: dataForm.company,
        accountIdType: dataForm.typeUser,
        accountIdNumber: dataForm.user,
        accountPassword: dataForm.password
      };
      return this.jar.execJson(this.jarSwat.NAME, this.jarSwat.METHOD.LOGIN, dataLogin);
    }

    /**
    * @description
    * Realiza la consulta al metodo programado en el jar que realiza la
    * consulta de el token asociado al usuario. Si la respuesta del token es
    * que este no es valido se realiza la petición de un nuevo token.
    */
    public validateToken(): any {
      let data: any = {
        token: this.$localStorage.token
      };
      return this.jar.execJson(this.jarSwat.NAME, this.jarSwat.METHOD.VALIDATE_TOKEN, data);
    }

    /**
    * @description
    * El servicio consulta la información por medio de la cedula de un contribuidor
    * vinculado en el soporte de pago, como resultado retorna una lista de
    * contribuidores con la información que es utilizada para el servicio de
    * envio de soportes por medio de email.
    *
    * @param {Array<Srting>} listContributors - Listado de numeros de
    * identificación de los aportantes que se van a consultar.
    * @return {Promise} La promesa solo retorna un resolve, en caso de error
    * el campo error del object es true.
    */
    public contributorsInformation(listContributors: string[]): any {
      let data = {
        token: this.$localStorage.token,
        contributorsIds: listContributors
      };
      return this.jar.execJson(this.jarSwat.NAME, this.jarSwat.METHOD.CONTRIBUTORS_INFORMATION, data);
    }


    /**
    * @description
    * Realiza la consulta de las planillas que estan en estado liquidadas
    * asociadas a la cuenta del usuario logeado.
    *
    * @return {Promise} La promesa solo retorna un resolve, en caso de error
    * el campo error del object es true.
    */
    public listFilesSettlement(): any {
      let data: any = {
        idSoiAportante: this.$localStorage.soiContributorIdNumber,
        idSegUsuario: this.$localStorage.soiAccountIdNumber,
        token: this.$localStorage.token
      };
      // Se consulta la información del servicio REST para retornar la lista de planillas
      return this.jar.execJson(this.jarSwat.NAME, this.jarSwat.METHOD.FILES_SETTLEMENT, data);
    }

    /**
    * @description
    * Consulta en el servidor si existen notificaciones para mostrar en la
    * aplicación y actualizar el archivo local de notificaciones.
    *
    * @return {Promise} La promesa solo retorna un resolve, en caso de error
    * el campo error del object es true.
    */
    public notificationsServer(): any {
      let params: any = {
        token: this.$localStorage.token,
        version: this.OPTIONS.VERSION
      };
      return new Promise((resolve) => {
        let result = this.jar.execJson(this.jarSwat.NAME, this.jarSwat.METHOD.GET_NOTIFICATIONS, params);
        result.then((data) => {
          if (data.code !== "00") {
            this.nativeNotification.show(this.$filter("translate")("MESSAGES.TITLES.ERROR"), this.$filter("translate")("MESSAGES.ERROR_NOTIFICATION_SERVER"));
          }
          resolve(data);
        });
      });
    }

    /**
    * @description
    * Realiza el llamado al metodo que consulta la informacion de las planillas
    * para mostrar en el panel izquierdo o formar la cabecera de la planilla
    * para el envio de emails.
    *
    * @param {String} numberSettlement - Numero de la planilla a consultar.
    * @return {Promise} La promesa solo retorna un resolve, en caso de error
    * se retorna un null como parametro del resolve.
    */
    public infoHeadSettlement(numberSettlement: string): any {
      let params: any = {
        token: this.$localStorage.token,
        numeroPlanilla: numberSettlement,
        idAportante: this.$localStorage.soiContributorIdNumber,
        idSegUsuario: this.$localStorage.soiAccountIdNumber
      };
      return new Promise((resolve) => {
        let result = this.jar.execJson(this.jarSwat.NAME, this.jarSwat.METHOD.INFO_HEAD_SETTLEMENT, params);
        result.then((data) => {
          let infoHead = null;
          if (data.code === "00") {
            infoHead = {};
            // Información para envio de emails
            infoHead.planillaAportanteDTO = data.planillaAportanteDTO;
            // Información para mostrar en el panel de la planilla.
            infoHead.numberTemplate = numberSettlement;
            infoHead.typeTemplate = data.tipoPlanilla;
            infoHead.periodPension = data.periodoLiquidacionPensiones;
            infoHead.periodHealth = data.periodoLiquidacionSalud;
            infoHead.totalContributor = data.cantidadEmpleados;
            infoHead.paymentDate = data.fechaPago;
            infoHead.branchOffice = data.sucursal;
          } else {
            this.nativeNotification.show(this.$filter("translate")("MESSAGES.TITLES.ERROR"), data.message);
          }
          resolve(infoHead);
        });
      });
    }

    /**
    * @description
    * Realiza el llamado al metodo que consulta el listado de empleados
    * vinculados a una planilla de liquidación.
    *
    * @param {String} numberSettlement - Numero de la planilla a consultar.
    * @return {Promise} La promesa solo retorna un resolve, en caso de error
    * el campo error del object es true.
    */
    public listContributorsSettlement(numberSettlement: string): any {
      let params: any = {
        token: this.$localStorage.token,
        numeroPlanilla: numberSettlement,
        idSoiAportante: this.$localStorage.soiContributorIdNumber,
        idSegUsuario: this.$localStorage.soiAccountIdNumber
      };
      return this.jar.execJson(this.jarSwat.NAME, this.jarSwat.METHOD.LIST_CONTRIBUTORS, params);
    }

    /**
    * @description
    * Realiza el proceso de validación de un archivo de liquidación para poder
    * realizar el proces de generar la planilla con el formato 2388.
    *
    * @param {String} pathFile - Nombre del archivo generado de la planilla 2388
    * para comprimir.
    * @param {Object} data - Información de parametros para el envio de la
    * petición.
    * @return {Promise} La promesa solo retorna un resolve, en caso de error
    * el campo error del object es true.
    */
    public validateFileSettlement(pathFile: string, data: any): any {
      let folderTemp = this.file.getPathTemp();
      let routeFileZip = this.file.createFileZip(folderTemp, pathFile);
      let params: any = {
        token: this.$localStorage.token,
        numeroTotalDeEmpleadosPorPantalla: data.totalContributor,
        aportanteLey1429: data.aportanteLey1429,
        fileName: this.file.getNameFilePath(pathFile),
        idAportante: this.$localStorage.soiContributorIdNumber,
        idSegUsuario: this.$localStorage.soiAccountIdNumber,
        aportanteLey1607: data.aportanteLey1607,
        idSoiTpPlanilla: data.idSoiTpPlanilla,
        // fileZip: new Buffer(routeFileZip, "utf-8").toJSON().data,
        fileZip: [],
        fileNameZip: this.file.getNameFilePath(routeFileZip),
        rutaLocalArchivo: this.file.getFilePathOnly(pathFile),
        periodoSalud: data.periodHealth,
        periodoNoSalud: data.periodPension
      };
      return this.jar.execJson(this.jarSwat.NAME, this.jarSwat.METHOD.VALIDATE_FILE, params);
    }


    /**
    * @description
    * Realiza el proceso de consultar información de un archivo despues de
    * generar el archivo ZIP y enviarlo al servicio de SOI para completar el
    * proceso de liquidación, se ejecuta un cierto tiempo hasta que el servicio
    * retorne una respuesta.
    */
    public consultFileSettlement(): void {
      if (this.timerConsultFile) {
        clearTimeout(this.timerConsultFile);
        this.timerConsultFile = null;
      }
      if (!this.$localStorage.validateFile) return;
      let params: any = {
        token: this.$localStorage.token,
        idFile: this.$localStorage.validateFile.idArchivoEnProceso
      };
      let result = this.jar.execJson(this.jarSwat.NAME, this.jarSwat.METHOD.CONSULT_FILE, params);
      result.then((response) => {
        this.$localStorage.validateFile = Object.assign(this.$localStorage.validateFile, response);
        if (response.estado === this.OPTIONS.SETTLEMENT.VALIDATE_FILE_ENUM.EN_PROCESO || response.estado === this.OPTIONS.SETTLEMENT.VALIDATE_FILE_ENUM.INICIO_VALIDACION_BDUA) {
          this.timerConsultFile = setTimeout(this.consultFileSettlement.bind(this), this.jarSwat.TIMER_WAIT);
        } else {
          if (response.estado === this.OPTIONS.SETTLEMENT.VALIDATE_FILE_ENUM.TERMINADO_SIN_ERRORES) {
            this.putPayroll(response.idPlanilla);
            this.$rootScope.$broadcast("hide-loading");
            return;
          }
          if (response.estado === this.OPTIONS.SETTLEMENT.VALIDATE_FILE_ENUM.ADVERTENCIAS_VALIDACION_BDUA) {
            this.putPayroll(response.idPlanilla);
            this.$rootScope.$broadcast("hide-loading");
            return;
          }
          let showError = false;
          let listErrores = this.OPTIONS.SETTLEMENT.VALIDATE_FILE_ENUM.TERMINADO_CON_ERRORES;
          for (let key of Object.keys(listErrores)) {
            if (response.estado === listErrores[key]) {
              showError = true;
              break;
            }
          }
          if (showError) {
            this.dialog.showDialogError(this.$filter("translate")("MESSAGES.TITLES.ERROR"), this.$filter("translate")("SETTLEMENT.ERRORS.VALIDATE_FILE") + response.estado);
            this.$rootScope.$broadcast("hide-loading");
          }
        }
      });
    }

    /**
    * @private
    * @description
    * Servicio que se ejecuta despues de realizar el proceso de envio del archivo
    * zip al servicio de SOI y entonctar en el ciclo de consultFileSettlement un
    * retorno de que termino sin errores.
    */
    private putPayroll(idPlanillaTmp: number): void {
      let params: any = {
        token: this.$localStorage.token,
        "idPlanilla": idPlanillaTmp,
        getValidateFileOutDTO: {
          idSegUsuario: this.$localStorage.validateFile.idSegUsuario,
          idAportante: this.$localStorage.validateFile.idAportante,
          idArchivoEnProceso: this.$localStorage.validateFile.idArchivoEnProceso,
          idSoiPlanilla: this.$localStorage.validateFile.idSoiPlanilla,
          notificacionDeArchivoEnProcesoType: this.$localStorage.validateFile.notificacionDeArchivoEnProcesoType,
          numeroTotalDeEmpleadosPorPantalla: this.$localStorage.validateFile.numeroTotalDeEmpleadosPorPantalla,
          nombreArchivo: this.$localStorage.validateFile.nombreArchivo,
          codTipoPlanilla: this.$localStorage.validateFile.codTipoPlanilla,
          idSoiTpPlanilla: this.$localStorage.validateFile.idSoiTpPlanilla
        },
        "getUsuarioAutenticadoInDTO": null,
        getConsultPayrollOutDTO: {
          periodoSalud: this.$localStorage.validateFile.periodHealth,
          periodoNoSalud: this.$localStorage.validateFile.periodPension
        }
      };
      let result = this.jar.execJson(this.jarSwat.NAME, this.jarSwat.METHOD.PUT_PAYROLL, params);
      result.then((response) => {
        if (response.idNumeroDePlanilla) {
          let title = this.$filter("translate")("SETTLEMENT.CONFIRMATION.SETTLEMENT_CREATED_TITLE");
          let message = this.$filter("translate")("SETTLEMENT.CONFIRMATION.SETTLEMENT_CREATED") + response.idNumeroDePlanilla;
          this.dialog.showDialogError(title, message);
          this.$rootScope.$broadcast("hide-loading");
        }
      });
    }

  }

  let app: any = angular.module("PILA");
  app.service("jar.swat.service", SwatService);
}

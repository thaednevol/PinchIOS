namespace app.settlement {

  /**
  * @class SettlementController
  * @author Luis Felipe Zapata <lzapta@swat-it.co>
  * @description
  */
  class SettlementController {

    /**
    * @type {Array<String>} listErrorsValidateFile - Listado de mensajes de error
    * que se mostraran en una tabla emergente si el proceso de validar el archivo
    * de liquidación en la función "validateFileSettlement" tiene errores.
    */
    public listErrorsValidateFile: any = [];

    /**
    * @type {Boolean} showErrorValidateFile - Da la orden de cuando mostrar la
    * ventana con el listado de mensajes de error del servicio.
    */
    public showErrorValidateFile: boolean = false;

    /**
    * @type {Boolean} showLoading - Indica si debe mostrar la imagen de loading
    * y bloquear la pantalla hasta que espere el usuario que termine la carga
    * del login.
    */
    public showLoading: Boolean = false;

    /**
    * @type {Boolean} showPanel - Indica si se oculta el panel o se muestra.
    */
    public showPanel: boolean = true;

    /**
    * @type {String} pathFile - Ruta del archivo de liquidación almacenado
    * para cargar desde la lista de dashboard.
    */
    private pathFile: String = null;

    /**
    * @type {Boolean} fileLocalIsLoad - Indica si se paso el path de un archivo
    * almacenado desde el liquidador y cargado por el dashboard.
    */
    private fileLocalIsLoad: Boolean = false;

    /**
    * @type {NativeNotificationService} nativeNotification - Clase que se encarga
    * de mostrar notificaciones por medio de alerts nativos.
    * @see app.native.NativeNotificationService
    */
    private nativeNotification: any;

    private tipoPlanillaInvalido: Boolean = false;
    private formaPresentacionInvalida: Boolean = false;
    private sucursalInvalida: Boolean = false;

    public totalRealErrores = 0;
    public totalRealCorrecciones = 0;
    public totalCorrRealizadas = 0;

    /**
    * @type {Object<name,path,data,origin>} file - Contiene la información del archivo
    * que se carga.
    * @see SettOptionsControler.file
    * @see SettTotalsControler.file
    * @see SettContributorsController.file
    */
    public file: any = {
      name: "SETTLEMENT.LOAD.MESSAGES.NO_FILE",
      path: "",
      data: null,
      origin: null
    };

    /**
    * @type {Object<object>} listErrorsContributors - Un array con la estructura
    * de los errores que entrega el validador para los registros tipo 2.
    */
    public listErrorsContributors: any = null;

    /**
    * @type {Object<object>} listErrorsCorrected - Almacena una copia de la lista
    * de errores con la información de las correcciones que se realizaron.
    */
    public listErrorsCorrected: any = null;

    /**
    * @type {Object<periodPension,periodHealth,totalContributor,totalPay,totalError>}
    * info - información resumida del archivo.
    * @see SettInfoControler.info
    */
    public info: any = {
      periodPension: "No definido",
      periodHealth: "No definido",
      reforma: "true",
      totalContributor: 0,
      totalPay: 0,
      totalError: 0,
      totalErrorContributor: 0,
      totalFilterRegister: 0
    };


    /**
    * @type {Object<periodPension,periodHealth,totalContributor,totalPay,totalError>}
    * validationResult - Resultados de la validacion de planilla en SOI
    * @see SettInfoControler.info
    */
    public validationResult: any = {
      error: false,
      errorMessage: "",
      ruafOrBdua: false,
      ruafXlsContent: "",
      bduaXlsContent: "",
      errorXlsContent: "",
      resultMessage: "",
      idTmpPlanilla: 0
    };

    /**
    * @type {String} currentTab - Indica la posición actual del menu de tab.
    */
    public currentTab: string = "contributors";

    /**
    * @type {Class} soiService - Servicio para consultar los archivos JAR que se
    * utilizan con soi para validar y cargar la información de las planillas.
    */
    private soiService: any;

    /**
    * @type {Class} serviceSettlement - Servicio que contiene los consumos a REST
    * para realizar las validaciones de registros.
    */
    private serviceSettlement: any;

    /**
    * @type {Class} serviceJar - Servicio que consulta los archivos JAR.
    */
    private serviceJar: any;

    /**
    * @type {Class} serviceFile - Servicio que ejecuta el llamado a metodos
    * nativos de Nodejs para la manipulación de archivos.
    */
    private serviceFile: any;

    private $filter: any;
    private $localStorage: any;
    private $rootScope: any;
    private $scope: any;

    /**
    * @type {SwatService} swat - Consulta los servicios que utiliza los JAR de
    * Swat para la aplicación.
    * @see app.jar.SwatService
    */
    private swat: any

    static $inject = ["jar.swat.service", "native.notification.service", "$rootScope", "$scope", "jar.soi.service", "native.file.service", "native.jar.service", "settlement.service", "$filter", "$localStorage"];

    constructor(swat, nativeNotification, $rootScope, $scope, soiService, serviceFile, serviceJar, serviceSettlement, $filter, $localStorage) {
      this.swat = swat;
      this.nativeNotification = nativeNotification;
      this.$rootScope = $rootScope;
      this.$scope = $scope;
      this.soiService = soiService;
      this.serviceJar = serviceJar;
      this.serviceFile = serviceFile;
      this.serviceSettlement = serviceSettlement;
      this.$filter = $filter;
      this.$localStorage = $localStorage;
      this.$scope.$on("clear-container", () => {
        this.listErrorsContributors = null;
        this.listErrorsCorrected = null;
        this.file.totals = null;
        this.file.data = null;
        let reformaTmp = this.info.reforma;
        this.info = {};
        this.validationResult = {};
        this.info.reforma = reformaTmp;
        this.showLoading = true;
      });
      this.$scope.$on("load-file-config-soi", () => {
        this.currentTab = "contributors";
        this.getFileConfig();
      });
      this.$scope.$on("update-totals", () => {
        this.updateTotals();
      });
      this.$scope.$on("validate-register-table", (event, numberRegister) => {
        this.validateRegister(numberRegister);
      });
      this.$scope.$on("validate-register-tp01", (event, numberRegister) => {
        this.validateRegisterTp01();
      });
      this.$scope.$on("update-info-panel", () => {
        this.updateInfoPanel();
      });
      this.$scope.$on("save-planilla", (event, idTmpPlanilla) => {
        this.savePlanilla(idTmpPlanilla);
      });
      this.$scope.$on("apply-corrections", (event, linea, col) => {
        this.applyIndividualCorrections(linea,col);
      });
      this.$scope.$on("new-apply-corrections", (event, linea, col) => {
        this.newApplyIndividualCorrections(linea,col);
      });
      this.$scope.$on("hide-loading", () => {
        this.showLoading = false;
        setTimeout(() => {
          this.$scope.$apply();
        });
      });
    }

    $doCheck() {
      if (this.pathFile && !this.fileLocalIsLoad) {
        this.fileLocalIsLoad = true;
        setTimeout(() => {
          this.$rootScope.$broadcast("load-file-settlement", this.pathFile);
        });
      }
    }

    /**
    * @description
    * Ejecuta el llamado al metodo para validar los totales de la planilla.
    */
    private updateTotals() {
      this.serviceSettlement.getTotals().get().$promise.then((response) => {
        let data = response.data;
        if (data.error) {
          let title = this.$filter("translate")("MESSAGES.TITLES.ERROR");
          this.nativeNotification.show(title, data.message);
          this.showLoading = false;
          this.file.data = null;
          return;
        }
        this.file.totals = data;
        setTimeout(() => {
          this.$scope.$apply();
        });
        this.updateInfoPanel();
      }, (error) => {
        console.info(error);
        this.updateInfoPanel();
      });
    }

    /**
    * @description
    * Realiza el switch entre las pestañas de la vista.
    * @param {string} tabForChange - identificador que se le da a las pestañas
    * para realizar la carga.
    */
    public actionChangeTab(tabForChange: string) {
      this.currentTab = tabForChange;
      setTimeout(() => {
        if (tabForChange === "contributors") {
          this.$rootScope.$broadcast("clear-inputs-table-edit");
          this.$rootScope.$broadcast("refresh-table");
          this.$rootScope.$broadcast("rebuild-table");
          this.$rootScope.$broadcast("action-change-page");
        }

        if (tabForChange === "errors") {
          this.$rootScope.$broadcast("rebuild-table-errors");
          this.$rootScope.$broadcast("refresh-table-errores");
        }

        if (tabForChange === "totals") {
          this.$rootScope.$broadcast("rebuild-table-totales");
          this.$rootScope.$broadcast("refresh-table-totales");
        }

        if (tabForChange === "corrected") {
          this.$rootScope.$broadcast("rebuild-table-corrected");
          this.$rootScope.$broadcast("refresh-table-correcciones");
        }

      });
    }

    private prevalidateRegisterTp1 ( ){
      let tipoPlanilla = this.file.data.regTp01.registers[0]["regs7"];
      let formaPresentacion = this.file.data.regTp01.registers[0]["regs10"];
      let codSucursal = this.file.data.regTp01.registers[0]["regs11"];
      let nombreSucursal = this.file.data.regTp01.registers[0]["regs12"];
      let tiposPlanillaValidos: string[] = ['E','Y','A','I'];
      //let formasPresentacionValidas: string[] = ['U','C','S','D'];
      let sucursales = this.$localStorage.sucursalesApte;
      let fmaPresentacionAportante = this.$localStorage.authenticatedUserDTO.informacionAportantePlanillaDTO.codigoFormaPresentacion;

      if ( tiposPlanillaValidos.indexOf(tipoPlanilla)<0 ){
        this.tipoPlanillaInvalido = true;
        this.file.data.regTp01.registers[0]["regs7"] = 'E';
        this.file.data.regTp1Txt = this.file.data.regTp1Txt.substring(0,226)+'E'
                                    +this.file.data.regTp1Txt.substring(227,this.file.data.regTp1Txt.length);
      }
      if ( fmaPresentacionAportante!=formaPresentacion ){
        this.formaPresentacionInvalida = true;
        this.file.data.regTp01.registers[0]["regs10"] = fmaPresentacionAportante;
        this.file.data.regTp1Txt = this.file.data.regTp1Txt.substring(0,247)+fmaPresentacionAportante
                                    +this.file.data.regTp1Txt.substring(248,this.file.data.regTp1Txt.length);
      }
      let sucursalOk = false;
      for ( let i=0;i<sucursales.length;i++ ) {
        let currSucursal = sucursales[i].split(";");
        if ( currSucursal[1]===codSucursal &&currSucursal[2]===nombreSucursal  ){
          sucursalOk = true;
          break;
        }
      }


      if ( (fmaPresentacionAportante==='S' || fmaPresentacionAportante==='D') && !sucursalOk && sucursales.length>0 ){
        let currSucursal = sucursales[0].split(";");
        this.file.data.regTp01.registers[0]["regs11"] = currSucursal[1];
        this.file.data.regTp01.registers[0]["regs12"] = currSucursal[2];
        let codSucursalRelleno = currSucursal[1].padEnd(10," ");
        let nomSucursalRelleno = currSucursal[2].padEnd(40," ");
        let nomSucursalLength = nomSucursalRelleno.length;
        let codSucursalLength = codSucursalRelleno.length;
        this.file.data.regTp1Txt = this.file.data.regTp1Txt.substring(0,248)+codSucursalRelleno
                                  +this.file.data.regTp1Txt.substring(248+codSucursalLength,this.file.data.regTp1Txt.length);
        this.file.data.regTp1Txt = this.file.data.regTp1Txt.substring(0,258)+nomSucursalRelleno
                                                            +this.file.data.regTp1Txt.substring(258+nomSucursalLength,this.file.data.regTp1Txt.length);
        this.sucursalInvalida = true;
      }
      else if ( (fmaPresentacionAportante!='S' && fmaPresentacionAportante!='D') ){
        this.file.data.regTp01.registers[0]["regs11"] = "";
        this.file.data.regTp01.registers[0]["regs12"] = "";
        this.file.data.regTp1Txt = this.file.data.regTp1Txt.substring(0,248)+""
                                  +this.file.data.regTp1Txt.substring(248,this.file.data.regTp1Txt.length);
                                  this.file.data.regTp1Txt = this.file.data.regTp1Txt.substring(0,258)+""
                                                            +this.file.data.regTp1Txt.substring(258,this.file.data.regTp1Txt.length);
      }

    }
    /**
    * @private
    * @description
    * Consulta si existe el archivo de configuración en la aplicación, de no
    * existir realiza el proceso de descarga. Este archivo es utilizado por los
    * metodos del JAR que realiza las validaciones de los campos.
    */
    private getFileConfig() {
      // Se comenta para obligar a realizar el proceso de descarga siempre.
      // let fileConfig = this.serviceFile.getPathOptions("archivoEnProcesoDTO.json");
      // if (fileConfig) {
      //   this.initializeSettlement();
      //   return;
      // }
      this.prevalidateRegisterTp1();

      let params: any = {
        regTp01: this.file.data.regTp1Txt,
        idSoiAportante: this.$localStorage.soiContributorIdNumber,
        idSegUsuario: this.$localStorage.soiAccountIdNumber,
        token: this.$localStorage.token,
        reforma: this.info.reforma
      };
      let result = this.serviceJar.execJsonProxy("pila-business", "getValidationFileConfig", params);
      result.then((data) => {
        if (data.code === "00") {
          let fileProcess = this.serviceFile.createFileOptions("archivoEnProcesoDTO.json", data.archivoEnProcesoDTO);
          fileProcess.then(() => {
            let fileData = this.serviceFile.createFileOptions("validacionArchivoDataSourceDTO.json", data.validacionArchivoDataSourceDTO);
            fileData.then(() => {
                this.initializeSettlement();
            });
          });
        } else {
          let title = this.$filter("translate")("MESSAGES.TITLES.ERROR");
          if (data.message) {
            this.nativeNotification.show(title, data.message);
          } else {
            this.nativeNotification.show(title, "Problemas con conexión al servidor, no se puede descargar archivos de configuración.");
          }
          this.file.data = null;
          this.showLoading = false;
        }
      });
    }

    /**
    * @private
    * @description
    * Realiza las validaciones iniciales del documento entregando todos los
    * posibles errores que presenta el archivo.
    */
    private initializeSettlement() {

      // Parametros solicidatos por el servicio JAR para validar los archivos.
      let params = {
        archivoProcesoJson: this.serviceFile.getPathOptions("archivoEnProcesoDTO.json"),
        archivoDatasourceJson: this.serviceFile.getPathOptions("validacionArchivoDataSourceDTO.json"),
        regTp01: this.file.data.regTp1Txt,
        pathArchivo2388: this.file.path,
        pathRespuestaJson: this.serviceFile.getPathTemp(),
        reformaTributaria: this.info.reforma
      };
      // Se ejecuta el llamado al servicio que valida los errores del archivo
      this.serviceSettlement.initialize(params).get().$promise.then((response) => {
        let data = response.data;
        if (data.estado !== "OK") {
          let title = this.$filter("translate")("MESSAGES.TITLES.ERROR");
          this.nativeNotification.show(title, data.error);
          this.showLoading = false;
          this.file.data = null;
          return;
        }
        let result = this.serviceFile.getContentFileJson(response.data.pathResultadoJson);
        result.then((contentFile) => {

          if ( this.sucursalInvalida || this.formaPresentacionInvalida || this.tipoPlanillaInvalido ){
            let message = this.$filter("translate")("SETTLEMENT.CONFIRMATION.SETTLEMENT_TP_PLANILLA_MODIFICADA");
            let title = this.$filter("translate")("MESSAGES.TITLES.INFO");
            this.nativeNotification.show(title, message);
          }

          let data = contentFile;
          // Si es correcto el proceso de descarga de los archivos de configuración
          let newListError = {};
          // Se convierte el resultado de los errores de los archivos en Objectos para
          // Integrarlos con las tablas.

          return this.processResponseError(data, newListError, 0);

          /*
          for (let i = 0; i < this.file.data.regsTp02.registers.length; i++) {
            let currentSequence: number = this.file.data.regsTp02.registers[i].regs1;
            // let newObject = this.$filter("filter")(data, { linea: Number(currentSequence) + 1 }, true);
            // if (newObject.length > 0) {
            //   newObject = this.arrayErrorsToObject(newObject);
            //   newListError[currentSequence] = newObject;
            // }
          }
          return;
          // Se ejecuta el llamado para actualizar los datos y la información de los paneles.
          this.file.data.regsTp02.errors = newListError;
          this.file.data.regsTp02.corrected = [];
          angular.copy(newListError, this.file.data.regsTp02.corrected);
          //Pestaña de errores
          this.applyCorrections(0,this.file.data.regsTp02.errors);
          //Pestaña de correcciones
          this.applyCorrections(0,this.file.data.regsTp02.corrected);
          */
        });
      }, (response) => {
          let title = this.$filter("translate")("MESSAGES.TITLES.ERROR");
          this.nativeNotification.show(title, "Error inesperado al conectarse al liquidador");
          this.showLoading = false;
          this.file.data = null;
          return;
      });
    }

    private processResponseError(data: any, newListError: any, numberRegister: number): void {
      if (numberRegister === 1) {
        this.file.data.regTp01.errors = newListError;
      }
      if (numberRegister >= this.file.data.regsTp02.registers.length+1) {
        this.file.data.regsTp02.errors = newListError;
        this.file.data.regsTp02.corrected = [];
        angular.copy(newListError, this.file.data.regsTp02.corrected);
        /*this.fillCurrentValues();
        setTimeout(() => {
          this.$scope.$apply();
        });
        this.updateTotals();*/
        //Pestaña de errores
        this.applyCorrections(0,this.file.data.regsTp02.errors);
        //Pestaña de correcciones
        this.applyCorrections(0,this.file.data.regsTp02.corrected);
        this.$rootScope.$broadcast("rebuild-table");
        return;
      }
      setTimeout(() => {
        //let currentSequence: number = this.file.data.regsTp02.registers[numberRegister].regs1;
        let currentSequence: number = numberRegister;
        if ( data.length>0 ){
          let newObject = this.$filter("filter")(data, { linea: Number(currentSequence) + 1 }, true);

          if (newObject.length > 0) {
            newObject = this.arrayErrorsToObject(newObject);
            newListError[currentSequence] = newObject;
          }
        }
        this.processResponseError(data, newListError, numberRegister + 1);
      });

    }

    /**
    * @description
    * Convierte el array que entrega los servicios de validación con los errores
    * en un objeto para ser utilizao en las tablas de edición.
    */
    private arrayErrorsToObject(registersErrors: any) {
      let objectErrors: any = {};
      for (let i = 0; i < registersErrors.length; i++) {
        let field: number = registersErrors[i].campo;
        objectErrors[field] = registersErrors[i];
      }
      return objectErrors;
    }


    private saveSettlementFileTmp() {

      this.file.data.regTp01[18] = this.file.data.regsTp02.registers.length;
      let dataForSave: any = this.soiService.registerType2ToArray(this.file.data);
      return this.serviceFile.createFileTemp(`${this.file.name}.json`, dataForSave, false);
    }

    /**
    * @description
    * Ejecuta la validación de un registro tipo 1 usando servicios rest
    * del JAR.
    */
    public validateRegisterTp01() {
      let reg01ForValidate = this.soiService.lineRegisterType1ToSeparatedString(this.file.data);
      let params = {
        regt01: reg01ForValidate
      };
      this.serviceSettlement.validateRegisterT01(params).get().$promise.then((response) => {

        if (response.data.estadoSolicitud === "OK") {
            this.$rootScope.$broadcast("response_error_server",response);
            let errors = response.data.erroresRegistros;

            if ( this.file.data.regsTp02.corrected[0]===undefined ){
              this.file.data.regsTp02.corrected[0] = [];
            }
            let corrects = this.file.data.regsTp02.corrected[0];
            let oldErrors = [];
            if ( this.file.data.regsTp02.errors[0] ){
              oldErrors = this.file.data.regsTp02.errors[0];
            }

            if (errors.length > 0) {
              this.file.data.regTp01.errors["0"] = [];
              this.file.data.regTp01.errors["0"] = this.arrayErrorsToObject(errors);
              this.file.data.regsTp02.errors["0"] = this.arrayErrorsToObject(errors);
              //this.file.data.regsTp02.corrected["0"] = this.arrayErrorsToObject(errors);
            }
            else{
              this.file.data.regTp01.errors["0"] = [];
              this.file.data.regsTp02.errors["0"] = [];
            }

            //Manda a revalidar todos los registros del archivo cuando no tiene errores
            //en los campos tipo planilla, tipo aportante y codigo arl
            if (  this.file.data.regTp01.errors["0"][7]=== undefined &&
                  this.file.data.regTp01.errors["0"][13]=== undefined &&
                  this.file.data.regTp01.errors["0"][20]=== undefined){
                this.validateRegister(-1);
            }
            let cols: any = Object.keys(errors);
            // Recorre cada columna de la fila para realizar la corrección.
            for (let positionCol = 0; positionCol < cols.length; positionCol++) {
              let currentCol = cols[positionCol];
              let currentError = errors[currentCol];
              currentError.currentValue = this.file.data.regTp01.registers[0][`regs${currentError.campo}`];
            }

            //marca corregidos manualmente los errores que desaparecen al realizar el cambio
            for ( let i=0;i<Object.keys(oldErrors).length;i++ ){
              let currReg = oldErrors[Object.keys(oldErrors)[i]];
              let existeError = errors.find(function(element){
                return element.campo === currReg.campo && !element.corregido;
              });
              if ( !existeError ){
                currReg.corregido = true;
                currReg.autocorregible = true;
                currReg.correccion = this.$filter("translate")("ERROR.CONTRIBUTORS.TYPE_MANU");
                corrects[Object.keys(oldErrors)[i]]=currReg;
              }
            }

            //Agrega los nuevos errores al arreglo de correcciones
            for ( let i=0;i<Object.keys(errors).length;i++ ){
              let currReg = errors[Object.keys(errors)[i]];
              //si existe un error en el arreglo de correcciones que no se haya corregido
              //let existeError = corrects[currReg.campo];
              //if ( !existeError && existeError.corregido ){
                corrects[currReg.campo]=currReg;
              //}
            }

            //this.updateTotals();
            //this.updateInfoPanel();


        }
      });
    }


    private validateRegisters(params: any, numberRegister) {

      this.serviceSettlement.validateRegister(params).get().$promise.then((response) => {

        if (response.data.estadoSolicitud === "OK") {
            let numberSequence = numberRegister;
            for (let idx = 0; idx < params.regTp02.length; idx++) {
              numberSequence = numberSequence + 1;
              // Si la respuesta es correcta se procesa la carga de los errores de los campos
              //obtiene los errores del registro actualiza
              let corrects = this.file.data.regsTp02.corrected[numberSequence];
              let oldErrors = this.file.data.regsTp02.errors[numberSequence];
              let errors = this.$filter("filter")(response.data.erroresRegistros, { linea: numberSequence + 1 }, true);
              if (errors.length > 0) {
                // Se valida si existe el campo para almacenar los errores del registros
                if (!this.file.data.regsTp02.errors.hasOwnProperty(numberSequence)) {
                  this.file.data.regsTp02.errors[numberSequence] = [];
                }
                // Si esisten errores se indican en los registros de las tablas convirtiendo
                // La estructura de array en objetos para que se pueda utilizar en la tabla
                this.file.data.regsTp02.errors[numberSequence] = this.arrayErrorsToObject(errors);
                //Solo cuando se modifico el registro 1 y se mando a revalidar el archivo
                if ( numberRegister===0 ){
                  this.file.data.regsTp02.corrected[numberSequence] = this.arrayErrorsToObject(errors);
                }
                //this.file.data.regsTp02.corrected[numberSequence] = this.arrayErrorsToObject(errors);

                //Bug 2417
                //Se mueve a java conservar la secuencia de errores para evitar duplicados
                /*let anteriorError = this.file.data.regsTp02.errors[numberSequence -1];
                let nuevaSecuenciaError = 0;
                if (anteriorError !== undefined) {
                  let colsAnterior: any = Object.keys(this.file.data.regsTp02.errors[numberSequence -1]);
                  nuevaSecuenciaError = this.file.data.regsTp02.errors[numberSequence-1][colsAnterior[0]].secuenciaError + 1;
                }*/


                //Aplica las correcciones
                let currentRow = this.file.data.regsTp02[numberSequence];
                let cols: any = Object.keys(this.file.data.regsTp02.errors[numberSequence]);
                // Recorre cada columna de la fila para realizar la corrección.
                for (let positionCol = 0; positionCol < cols.length; positionCol++) {
                  let currentCol = cols[positionCol];
                  let currentError = this.file.data.regsTp02.errors[numberSequence][currentCol];
                  // Se valida si existen sugerencias y si cuenta con la opción de autocorreción activa.
                  /*if (currentError.autocorregible && currentError.sugerencias.length > 0) {
                    this.file.data.regsTp02.corrected[numberSequence][currentCol].currentValue = this.file.data.regsTp02.registers[numberSequence - 1][`regs${currentCol - 1}`];
                    this.file.data.regsTp02.registers[numberSequence - 1][`regs${currentCol - 1}`] = currentError.sugerencias[0];
                    // Se elimina la información de la columna del error para evitar que se resalte la celda en la tabla.
                    delete this.file.data.regsTp02.errors[numberSequence][currentCol];
                  } else {*/
                  currentError.currentValue = this.file.data.regsTp02.registers[numberSequence - 1][`regs${currentCol - 1}`];
                  //}
                }
                if (Object.keys(this.file.data.regsTp02.errors[numberSequence]).length === 0) {
                  delete this.file.data.regsTp02.errors[numberSequence];
                }

                //marca corregidos manualmente los errores que desaparecen al realizar el cambio
                if ( oldErrors!== undefined ){
                  for ( let i=0;i<Object.keys(oldErrors).length;i++ ){
                    let currReg = oldErrors[Object.keys(oldErrors)[i]];
                    let existeError = errors.find(function(element){
                      return element.campo === currReg.campo;
                    });
                    if ( !existeError ){
                      currReg.corregido = true;
                      currReg.autocorregible = true;
                      currReg.correccion = this.$filter("translate")("ERROR.CONTRIBUTORS.TYPE_MANU");
                      corrects[Object.keys(oldErrors)[i]]=currReg;
                    }
                  }
                }
                //Bug 2417
                //this.file.data.regsTp02.corrected = this.file.data.regsTp02.errors;
                let arrayCorrected = [];
                for (let key in this.file.data.regsTp02.errors) {
                  let object: any = Object;
                  if (this.file.data.regsTp02.corrected[key] !== undefined) {
                    if (Object.keys(this.file.data.regsTp02.corrected[key]).length === 0) {
                      this.file.data.regsTp02.corrected[key] = this.file.data.regsTp02.errors[key];
                    } else {
                      let array: any = object.values(this.file.data.regsTp02.errors[key]);
                      for (let positionCol = 0; positionCol < array.length; positionCol++) {
                        let currentCol = array[positionCol];
                        currentCol.linea = parseInt(key) + 1;
                        //currentCol.secuenciaError = parseInt(key);
                        this.file.data.regsTp02.corrected[key][currentCol.campo] = currentCol;
                        this.file.data.regsTp02.errors[key][currentCol.campo] = currentCol;
                      }
                    }
                  }
                }
                this.showLoading = false;
                this.updateTotals();
                //this.updateInfoPanel();
              } else {
                //marca corregidos manualmente los errores que desaparecen al realizar el cambio
                if ( oldErrors!== undefined ){
                  for ( let i=0;i<Object.keys(oldErrors).length;i++ ){
                    let currReg = oldErrors[Object.keys(oldErrors)[i]];
                    currReg.corregido = true;
                    currReg.autocorregible = true;
                    currReg.correccion = this.$filter("translate")("ERROR.CONTRIBUTORS.TYPE_MANU");
                    if ( corrects!== undefined ){
                      corrects[Object.keys(oldErrors)[i]]=currReg;
                    }
                  }
                }

                delete this.file.data.regsTp02.errors[numberSequence];
                // Se actualiza la información del panel en el campo de errores.
                this.updateTotals();
                //this.updateInfoPanel();
              }

          }

        }
      });
      setTimeout(() => {
        this.$rootScope.$broadcast("action-change-page");
      });

    }

    /**
    * @description
    * Ejecuta la validación de un registro comparandolo con el servicio REST
    * del JAR.
    */
    public validateRegister(numberRegister) {

      let selectedRegs = [];
      let nroLinea0 = 0;
      let regsForValidate = [];
      if ( numberRegister>=0 ){
        numberRegister = Number(numberRegister);
        let identificationSelected = this.file.data.regsTp02.registers[numberRegister]["regs3"];
        let tpIdentificationSelected = this.file.data.regsTp02.registers[numberRegister]["regs2"];
        selectedRegs = this.$filter("filter")(this.file.data.regsTp02.registers, { regs3: identificationSelected }, true);
        nroLinea0 = Number(selectedRegs[0]["regs1"])+1;
        //Para enviar a validar los multiples registros de un solo cotizante
        for (let i = 0; i < selectedRegs.length; i++) {
          regsForValidate[i] = this.soiService.lineRegisterType2ToSeparatedString(this.file.data, selectedRegs[i]["regs1"]-1);
        }
        // Se agregan los parametros solicitados por el servicio de valdiación de registros
        let params = {
          regTp02: regsForValidate,
          //regTp02: this.soiService.lineRegisterType2ToArray(this.file.data, numberRegister),
          nroLinea: nroLinea0
        };
        this.validateRegisters(params,numberRegister);
      }
      else{
        //se mandan a revalidar todos los registros de cotizante del archivo, por ejemplo si cambia el registro tipo 1
        this.showLoading = true;
        //selectedRegs = this.file.data.regsTp02.registers;
        //Para enviar a validar los multiples registros de un solo cotizante
        nroLinea0 = 0;
        numberRegister = 0;
        for (let i = 0; i < this.file.data.regsTp02.registers.length; i++) {
          regsForValidate[i] = this.soiService.lineRegisterType2ToSeparatedString(this.file.data, this.file.data.regsTp02.registers[i]["regs1"]-1);
          if ( i>0 && i%10===0 ){
            let params = {
              regTp02: regsForValidate,
              //regTp02: this.soiService.lineRegisterType2ToArray(this.file.data, numberRegister),
              nroLinea: nroLinea0
            };
            this.validateRegisters(params,numberRegister);
            regsForValidate = [];
          }
        }
        let params = {
          regTp02: regsForValidate,
          //regTp02: this.soiService.lineRegisterType2ToArray(this.file.data, numberRegister),
          nroLinea: nroLinea0
        };
        this.validateRegisters(params,numberRegister);
      }

    }

    /**
    * @description
    * El metodo permite actualizar las variables de información para mostrar
    * en el panel izquierdo.
    */
    private updateInfoPanel() {
      this.info.totalContributor = this.file.data.regsTp02.registers.length;
      let arrayErrors = [];
      let arrayCorrected = [];
      this.info.totalErrorContributor = 0;
      this.totalRealErrores = 0;
      this.totalRealCorrecciones = 0;
      this.totalCorrRealizadas = 0;
      // Prepara datos con errores para msotrar en la tabla de errores
      let i = 0;
      for (let key in this.file.data.regsTp02.errors) {
        let object: any = Object;
        let arrayObject: any = object.values(this.file.data.regsTp02.errors[key]);
        arrayErrors = arrayErrors.concat(arrayObject);
      }
      // Prepara datos para mostrar en la tabla de correcciones
      let j = 0;
      for (let key in this.file.data.regsTp02.corrected) {
        let object: any = Object;
        let arrayObject: any = object.values(this.file.data.regsTp02.corrected[key]);
        arrayCorrected = arrayCorrected.concat(arrayObject);
      }

      for (let i = 0; i < arrayCorrected.length; i++) {
        if (arrayCorrected[i].autocorregible === true && arrayCorrected[i].corregido === false) {
          this.totalRealCorrecciones++;
        }
        if (arrayCorrected[i].autocorregible === false) {
          this.totalRealErrores++;
        }
        if (arrayCorrected[i].autocorregible === true && arrayCorrected[i].corregido === true) {
          this.totalCorrRealizadas++;
        }
      }

      for (let i = 0; i < this.file.data.regsTp02.registers.length; i++) {
        let filterError = {
          linea: i + 1
        };
        if (this.$filter("filter")(arrayErrors, filterError, true).length > 0) {
          this.info.totalErrorContributor += 1;
        }
      }
      this.info.totalError = arrayErrors.length;
      // Lista de errores para ver en el menu de la tabla y en la tabla de errores
      this.listErrorsContributors = {
        data: arrayErrors
      };
      // Lista de correcciones que se han realizado en la tabla.
      this.listErrorsCorrected = {
        data: arrayCorrected
      };
      if (this.file.totals) {
        this.info.totalPay = this.file.totals.totalAPagar;
        this.info.periodHealth = this.file.totals.periodoSalud;
        this.info.periodPension = this.file.totals.periodoNoSalud;
      }
      this.showLoading = false;
      this.$rootScope.$broadcast("setnumRegisters",this.info.totalFilterRegister);
      //this.$rootScope.$broadcast("rebuild-table");
    }

    private newApplyIndividualCorrections(lineaArr, positionColArr): void {
      let corrects = this.file.data.regsTp02.corrected;
      let errors = this.file.data.regsTp02.errors;
      let rows: any = Object.keys(corrects);

      for (let i = 0; i < lineaArr.length; i++) {
        let linea = lineaArr[i];
        let positionCol = positionColArr[i];
        let currentRow = this.file.data.regsTp02.corrected[linea-1];
        let currentError = currentRow[positionCol];
        if ( linea===1 ){
          this.file.data.regTp01.registers[linea - 1][`regs${positionCol}`] = currentError.sugerencias[0];
        }
        else{
          this.file.data.regsTp02.registers[linea - 2][`regs${positionCol-1}`] = currentError.sugerencias[0];
        }
        // Se elimina la información de la columna del error para evitar que se resalte la celda en la tabla.
        delete errors[linea-1][positionCol];
        if (Object.keys(errors[linea-1]).length === 0) {
            delete errors[linea-1];
        }
        /*
        if ( linea===1 ){
          this.$rootScope.$broadcast("show-loading");
        }
        */
      }
      //this.updateTotals();
      /*this.updateInfoPanel();*/
    }

    private applyIndividualCorrections(linea,positionCol): void {
      let corrects = this.file.data.regsTp02.corrected;
      let errors = this.file.data.regsTp02.errors;
      let rows: any = Object.keys(corrects);
      let currentRow = this.file.data.regsTp02.corrected[linea-1];
      let currentError = currentRow[positionCol];
      if ( linea===1 ){
        this.file.data.regTp01.registers[linea - 1][`regs${positionCol}`] = currentError.sugerencias[0];
      }
      else{
        this.file.data.regsTp02.registers[linea - 2][`regs${positionCol-1}`] = currentError.sugerencias[0];
      }
      // Se elimina la información de la columna del error para evitar que se resalte la celda en la tabla.
      delete errors[linea-1][positionCol];
      if (Object.keys(errors[linea-1]).length === 0) {
          delete errors[linea-1];
      }
      if ( linea===1 ){
        this.$rootScope.$broadcast("show-loading");
      }
      this.updateTotals();
      //this.updateInfoPanel();
      //this.$rootScope.$broadcast("refresh-table");
      //}
      //}

    }



    /**
    * @private
    * @description
    * Aplica las correcciones automaticas de los registros.
    */
    private applyCorrections(positionRow: number = 0, errors): void {
      let rows: any = Object.keys(errors);
      if (positionRow >= rows.length) {
        setTimeout(() => {
          this.$scope.$apply();
        });
        this.updateTotals();
        return;
      }
      setTimeout(() => {
        // Recorre las filas de los registros de la tabla con error.
        let currentRow = rows[positionRow];
        if ( currentRow==="0" ){
          let cols: any = Object.keys(errors[currentRow]);
          // Recorre cada columna de la fila para realizar la corrección.
          for (let positionCol = 0; positionCol < cols.length; positionCol++) {
            let currentCol = cols[positionCol];
            let currentError = errors[0][currentCol];
            currentError.currentValue = this.file.data.regTp01.registers[0][`regs${currentCol}`];
          }
        }else if ( currentRow>0 ){
          let cols: any = Object.keys(errors[currentRow]);
          // Recorre cada columna de la fila para realizar la corrección.
          for (let positionCol = 0; positionCol < cols.length; positionCol++) {
            let currentCol = cols[positionCol];
            let currentError = errors[currentRow][currentCol];
            currentError.currentValue = this.file.data.regsTp02.registers[currentRow - 1][`regs${currentCol - 1}`];
          }
          if (Object.keys(errors[currentRow]).length === 0) {
              delete errors[currentRow];
              positionRow = positionRow - 1;
          }
        }
        this.applyCorrections(positionRow + 1, errors);
      });

    }

    public savePlanilla ( idTmpPlanilla ){
      let result = this.swat.putPayroll(idTmpPlanilla);

      result.then((response) => {
        if (response.idNumeroDePlanilla) {
          let messageResult = this.$filter("translate")("SETTLEMENT.CONFIRMATION.SETTLEMENT_CREATED") + response.idNumeroDePlanilla;
          this.validationResult.resultMessage = messageResult;
          this.validationResult.ruafOrBdua = false;
          this.validationResult.error = false;
          this.$rootScope.$broadcast("hide-loading");
        }
      });
    }

  }

  // Agrega el componente al modulo principal.
  let app: any = angular.module("PILA");
  app.component("settlement", {
    bindings: {
      pathFile: "<" // Ruta del archivo de liquidar que se carga automaticamente.
    },
    controller: SettlementController,
    templateUrl: "./components/settlement/settlement.main.html"
  });
}

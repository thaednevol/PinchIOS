/// <reference path="../../dt/angular.d.ts"/>

namespace app.settlement {

  /**
  * @class SettOptionsController
  * @author Luis Felipe Zapata <lzapta@swat-it.co>
  * @description
  * Controla la parte del menu secundario del modulo, controla la interacción del
  * cliente con las opciones de guardar, cargar, generar y abrir una planilla.
  */
  class SettOptionsController {

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
    * @type {Object<name,path,data,origin>} file - Contiene la información del archivo
    * que se carga.
    * @see SettlementController.file
    */
    public file: any = {
      name: "",
      path: "",
      data: null,
      reforma: null,
      origin: null
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
    * @type {Object} info - Información del panel de la planilla.
    */
    public info: any = {};

    /**
    * @type {Class} soiService - Servicio con funciones de llamado de SOI.
    * @see app.soi.SoiService
    */
    private soiService: any;

    /**
    * @type {Class} serviceFile - Servicio nativo de NodeJS para manupular archivos.
    * @see app.native.FileNodeService
    */
    private serviceFile: any;

    /**
    * @type {Class} serviceJar - Servicio nativo de NodeJS para consumo de JAR.
    * @see app.native.JarNodeService
    */
    private serviceJar: any;

    /**
    * @type {Boolean} dialogIsOpen - Indica si la ventana de carga de un archivo
    * se encuentra abierta para evitar abrir una de nuevo, cuando se cierra
    * la ventana el valor de la variable cambia para poder abrir una de nuevo.
    */
    private dialogIsOpen: boolean = false;

    /**
    * @type {Class} serviceDialog - Servicio nativo de Electron para mostrar ventanas dialog.
    * @see app.native.DialogNodeService
    */
    private serviceDialog: any;

    /**
    * @type {SwatService} swat - Consulta los servicios que utiliza los JAR de
    * Swat para la aplicación.
    * @see app.jar.SwatService
    */
    private swat: any

    /**
    * @type {Object} OPTIONS - Equivale al archivo de opciones del sistema.
    * @see app/webapp/json/data/options.json
    */
    private OPTIONS: any;

    private $scope: any;
    private $rootScope: any;
    private $filter: any;
    private $localStorage: any;
    static $inject = ["jar.swat.service", "jar.soi.service", "native.file.service", "native.jar.service", "native.dialog.service", "OPTIONS", "$scope", "$rootScope", "$filter", "$localStorage"];

    constructor(swat, soiService, serviceFile, serviceJar, serviceDialog, OPTIONS, $scope, $rootScope, $filter, $localStorage) {
      this.swat = swat;
      this.soiService = soiService;
      this.serviceFile = serviceFile;
      this.serviceJar = serviceJar;
      this.serviceDialog = serviceDialog;
      this.OPTIONS = OPTIONS;
      this.$scope = $scope;
      this.$rootScope = $rootScope;
      this.$filter = $filter;
      this.$localStorage = $localStorage;
      this.loadListenerDrag();
      this.$scope.$on("load-file-settlement", (event, data) => {
        this.file.path = data;
        this.file.name = this.serviceFile.getNameFilePath(data);
        this.validateFile();
      });
      this.$scope.$on("update-validation-result", (event, idTmpPlanilla, xlsRuaf, xlsBdua, xlsError, okResultMessage) => {
        this.validationResult.resultMessage = null;
        this.validationResult.idTmpPlanilla = idTmpPlanilla;
        this.validationResult.ruafXlsContent = xlsRuaf;
        this.validationResult.bduaXlsContent = xlsBdua;
        this.validationResult.errorXlsContent = xlsError;
        if ( xlsRuaf != null || xlsBdua!=null ){
          this.validationResult.ruafOrBdua = true;
        }
        if ( xlsError!=null ){
          this.validationResult.error = true;
        }
        if ( okResultMessage!=null ){
          this.validationResult.resultMessage = okResultMessage;
        }
      });
      /*this.$scope.$on("save-planilla-opt", (event, idTmpPlanilla) => {
        this.$rootScope.$broadcast("save-planilla",idTmpPlanilla);
      });
      /*this.$scope.$on("generate-payroll", (event, idTmpPlanilla) => {

      })*/;
    }

    /**
    * @description
    * Carga la ventana de dialogo para buscar los archivos con formato de planilla
    * 2388.
    */
    public actionDialogOpen() {
      if (this.dialogIsOpen) return;
      this.dialogIsOpen = true;
      let result = this.serviceDialog.openFile();
      result.then((pathFile) => {
        if (!pathFile) {
          this.dialogIsOpen = false;
          return;
        }
        this.file.path = pathFile[0];
        this.file.name = this.serviceFile.getNameFilePath(pathFile[0]);
        this.validateFile();
        this.dialogIsOpen = false;
      });
    }

    /**
    * @private
    * @description
    * Comprueba que el archivo que se carga cuente con una extension valida, si
    * no se cumple se notificara al usuario del error, de lo contrario inicia
    * la carga del archivo de planilla.
    */
    private validateFile() {
      if (this.soiService.formatFileValid(this.file.name)) {
        this.$rootScope.$broadcast("clear-container");
        this.file.name = this.file.name.substr(0, this.file.name.lastIndexOf("."));
        this.$rootScope.$broadcast("show-loading");
        this.$scope.$apply();
        this.loadDataFile();
      } else {
        this.$rootScope.$broadcast("show-message-top", {
          message: "MESSAGES.FORMAT_INVALID",
          translate: true
        });
        this.file.name = "SETTLEMENT.LOAD.MESSAGES.FORMAT_INVALID";
      }
    }

    /**
    * @private
    * @description
    * inicia el proceso de carga de la información del archivo que entregara los
    * datos de las tablas que se mostraran.
    *
    * @see validateFile()
    */
    private loadDataFile() {
      let result = this.serviceJar.execString("soi-empresarial-converters-1.0", "leerArchivo2388", this.file.path);
      result.then((data) => {
        data = this.soiService.registerType2ToObject(data);
        this.file.data = data;
        // TODO Se debe guardar una copia del original para detectar si hay cambios en el archivo
        angular.copy(data, this.file.origin);
        this.$scope.$apply();
        setTimeout(() => {
          this.$rootScope.$broadcast("load-file-config-soi");
          this.$rootScope.$broadcast("clear-inputs-table-edit");
        });
      });
    }

    /**
    * @description
    * Carga el evento que abre la ventana de dialog con la opción de guardado
    * del archivo. El evento se activa desde la vista el presionar el boton
    * de generar planilla.
    */
    public actionGenerate2388() {
      if (this.isFileWithErrors()) return;
      this.showLoading = true;
      let result = this.serviceFile.createFileTemp(`${this.file.name}temp2388.txt`, {}, false);
      result.then((path) => {
        if (!path) {
          this.showLoading = false;
          return;
        }
        this.generate2388(path);
      });
    }

    /**
    * @private
    * @description
    * Valida si el archivo cuenta aun con errore que requieran ser corregidos,
    * de ser asi muestra una advertencia de error y evita que se continue con
    * el proceso.
    */
    private isFileWithErrors(): boolean {
      let error = false;
      if (this.info.totalError > 0) {
        error = true;
        let title = this.$filter("translate")("MESSAGES.TITLES.ERROR");
        let message = this.$filter("translate")("SETTLEMENT.FILE_WITH_ERROR");
        this.serviceDialog.showDialogError(title, message);
      }
      return error;
    }

    /**
    * @private
    * @description
    * Realiza el almacenamiento de la plantilla actual en el formato 2388, ejecutando
    * el servicio JAR encargado de la creación.
    *
    * @param {String} pathFile - Ruta donde se almacenara la planilla.
    * @see actionGenerate2388()
    */
    private generate2388(pathFile) {
      let dialogSave = this.saveJSONTemp();
      dialogSave.then((pathJsonFile) => {
        let options = {
          pathArchivo: pathFile,
          tipoArchivo: "1747",
          pathArchivoData: pathJsonFile,
          aplicarCorrecionesConversiones: "N"
        };
        let result = this.serviceJar.execJson(this.OPTIONS.JAR.FILES.CONVERT.NAME, this.OPTIONS.JAR.FILES.CONVERT.METHOD.WRITE_2388, options);
        result.then((data2388) => {
          let pathConfig = this.serviceFile.getPathOptions(this.OPTIONS.FILES.CONFIG_SOI.VALIDATION_DATA_SOURCE);
          let resultContentFile = this.serviceFile.getContentFileJson(pathConfig);
          resultContentFile.then((fileConfig) => {
            let params = {
              totalContributor: this.info.totalContributor,
              aportanteLey1429: fileConfig.planillaApteDto.aportanteLey1429,
              aportanteLey1607: fileConfig.planillaApteDto.aportanteLey1607,
              idSoiTpPlanilla: fileConfig.planillaApteDto.idSoiTpPlanilla,
              periodHealth: this.info.periodHealth,
              periodPension: this.info.periodPension
            };
            let resultValidation = this.swat.validateFileSettlement(pathFile, params);
            resultValidation.then((data) => {
              if (data.errores.length > 0) {
                this.listErrorsValidateFile = data.errores;
                this.showErrorValidateFile = true;
                this.showLoading = false;
                setTimeout(() => {
                  this.$scope.$apply();
                });
              } else {
                let newInfoForService = Object.assign(params, data);
                this.$localStorage.validateFile = newInfoForService;
                this.swat.consultFileSettlement();
              }
            });
          });
        });
      });
    }



    /**
    * private
    * @description
    * Almacena el JSON de la plantilla en la carpeta temporal
    */
    private saveJSONTemp() {
      this.$rootScope.$broadcast("clear-inputs-table-edit");
      this.file.data.regTp01[18] = this.file.data.regsTp02.registers.length;
      let dataForSave: any = this.soiService.registerType2ToArray(this.file.data);
      return this.serviceFile.createFileTemp(`${this.file.name}.json`, dataForSave, false);
    }

    /**
    * @description
    * Crea un archivo con la información de la planilla de liquidación.
    */
    public actionSaveFile() {
      this.$rootScope.$broadcast("clear-inputs-table-edit");
      let dataForSave: any = this.soiService.registerType2ToArray(this.file.data);
      return this.serviceFile.createFileSettlement(`${this.file.name}.txt`, dataForSave);
    }


    // TODO refactorizar exponiendo el metodo de Drag en un servicio para reutilizar.
    private loadListenerDrag() {
      // Se inicia el drag
      document.ondragover = () => {
        return false;
      };
      // El usuario cancela el drag
      document.ondragleave = document.ondragend = () => {
        return false;
      };
      // Se solto el archivo dentro de la aplicación
      document.body.ondrop = (event) => {
        event.preventDefault();
        this.file.path = event.dataTransfer.files[0]["path"];
        this.file.name = event.dataTransfer.files[0]["name"];
        this.validateFile();
        return false;
      };
    }

    /**
    * @description
    * Almacena el archivo de la planilla en un JSON para su edición futura
    */
    public actionSaveTemplate() {
      if (this.file.data) {
        let result = this.actionSaveFile();
        result.then((routeJson) => {
          let options = {
            pathArchivo: this.serviceFile.getPathSettlement(this.file.name),
            tipoArchivo: "1747",
            pathArchivoData: routeJson
          };
          this.serviceJar.execJson("soi-empresarial-converters-1.0", "escribirArchivo2388", options);
        });
      }
    }

  }

  // Agrega el componente al modulo principal.
  let app: any = angular.module("PILA");
  app.component("settOptions", {
    bindings: {
      file: "=", // Información del archivo que se edita
      info: "=", // Información del panel de la planilla
      showErrorValidateFile: "=", // Indica si mostrar la ventana de erorres de validación de archivos
      listErrorsValidateFile: "=", // Listado de errores de validación de archivos
      validationResult: "=",
      showLoading: "="
    },
    controller: SettOptionsController,
    templateUrl: "./components/settlement/settlement.options.html"
  });
}

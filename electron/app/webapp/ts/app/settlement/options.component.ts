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
    * @type {Object<name,path,data,origin>} file - Contiene la información del archivo
    * que se carga.
    * @see SettlementController.file
    */
    public file: any = {
      name: "",
      path: "",
      data: null,
      origin: null
    };

    /**
    * @type {Object<object>} errors - Lista de errores que tiene el registro
    * documento de la planilla.
    */
    public errors: any = {};

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
    * @type {Class} serviceDialog - Servicio nativo de Electron para mostrar ventanas dialog.
    * @see app.native.DialogNodeService
    */
    private serviceDialog: any;

    private $scope: any;
    private $rootScope: any;

    static $inject = ["jar.soi.service", "native.file.service", "native.jar.service", "native.dialog.service", "$scope", "$rootScope"];

    constructor(soiService, serviceFile, serviceJar, serviceDialog, $scope, $rootScope) {
      this.soiService = soiService;
      this.serviceFile = serviceFile;
      this.serviceJar = serviceJar;
      this.serviceDialog = serviceDialog;
      this.$scope = $scope;
      this.$rootScope = $rootScope;
      this.loadListenerDrag();
      this.$scope.$on("load-file-settlement", (event, data) => {
        this.file.path = data;
        this.file.name = this.serviceFile.getNameFilePath(data);
        this.validateFile();
      });
    }

    /**
    * @description
    * Carga la ventana de dialogo para buscar los archivos con formato de planilla
    * 2388.
    */
    public actionDialogOpen() {
      let result = this.serviceDialog.openFile();
      result.then((pathFile) => {
        if (!pathFile) return;
        this.file.path = pathFile[0];
        this.file.name = this.serviceFile.getNameFilePath(pathFile[0]);
        this.validateFile();
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
        this.$rootScope.$broadcast("hide-loading");
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
    public actionDialogSave() {
      let result = this.serviceDialog.saveFile();
      result.then((pathFile) => {
        this.generate2388(pathFile);
      });
    }

    /**
    * @private
    * @description
    * Realiza el almacenamiento de la plantilla actual en el formato 2388, ejecutando
    * el servicio JAR encargado de la creación.
    *
    * @param {String} pathFile - Ruta donde se almacenara la planilla.
    * @see actionDialogSave()
    */
    private generate2388(pathFile) {
      let dialogSave = this.saveJSONTemp();
      dialogSave.then((pathJsonFile) => {
        let options = {
          pathArchivo: pathFile,
          tipoArchivo: "1747",
          pathArchivoData: pathJsonFile
        };
        this.serviceJar.execJson("soi-empresarial-converters-1.0", "escribirArchivo2388", options);
      });
    }

    /**
    * private
    * @description
    * Almacena el JSON de la plantilla en la carpeta temporal
    */
    private saveJSONTemp() {
      this.$rootScope.$broadcast("clear-inputs-table-edit");
      let dataForSave: any = this.soiService.registerType2ToArray(this.file.data);
      return this.serviceFile.createFileTemp(`${this.file.name}.json`, dataForSave);
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
      errors: "=" // Lista de errores del documento.
    },
    controller: SettOptionsController,
    templateUrl: "./components/settlement/settlement.options.html"
  });
}

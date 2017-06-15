/// <reference path="../../dt/angular.d.ts"/>
/// <reference path="../../dt/node.d.ts"/>

namespace app.load {

  /**
  * @class ConvertController
  * @author Luis Felipe Zapata <lzapata@swat-it.co>
  * @description
  * Componente encargado de la carga del archivo en la aplicación, valida el historial
  * de los archivos cargados y hace el puente entre el componente de valicación
  * que muestra los errores y notifica al usuario para que realice los cambios.
  */
  class ConvertController {

    /**
    * @type {Boolean} showLoading - Indica si debe mostrar la imagen de loading
    * y bloquear la pantalla hasta que el proceso ejecutado finalice
    */
    public showLoading: Boolean = false;

    /**
    * @type {Object<name, path, type>} form - Contiene la informacion del path del archivo
    * que se va a convertir, el tipo (Activo o Pensionado) y el nombre.
    */
    public form: any = { name: "", path: "", type: "1747" };

    /**
    * @type {NativeNotificationService} notificationService - Servicio para
    * mostrar mensajes de notificaciones del sistema nativas.
    * @see app.native.NativeNotificationService
    */
    private notificationService: any;

    /**
    * @type {SoiService} soi - Servicio con funciones de llamado de SOI.
    * @see app.native.SoiService
    */
    private soi: any;

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

    /**
    * @type {Class} historyService - Servicio de consumo de historial de archivos.
    * @see app.history.HistoryService
    */
    private historyService: any;

    /**
    * @type {Boolean} showValidate - Indica que hay errores y debe mostrar el
    * componente de validación de errores.
    */
    public showValidate: boolean = false;

    /**
    * @type {Object[]} dataValidate - Datos entregados con errores de validación del archivo.
    */
    public dataValidate: any;

    /**
    * @type {Object<name, pathArchivo, tipoArchivo>} file - Información del archivo actualmente cargado.
    */
    public file: any;

    /**
    * @type {Boolean} dialogIsOpen - Indica si la ventana de carga de un archivo
    * se encuentra abierta para evitar abrir una de nuevo, cuando se cierra
    * la ventana el valor de la variable cambia para poder abrir una de nuevo.
    */
    private dialogIsOpen: boolean = false;

    private $scope: any;
    private $state: any;
    private $filter: any;
    private $rootScope: any;
    static $inject = ["native.notification.service", "jar.soi.service", "native.file.service", "native.jar.service", "native.dialog.service", "history.service", "$scope", "$state", "$filter", "$rootScope"];

    constructor(notificationService, soi, serviceFile, serviceJar, serviceDialog, historyService, $scope, $state, $filter, $rootScope) {
      this.notificationService = notificationService;
      this.soi = soi;
      this.serviceFile = serviceFile;
      this.serviceJar = serviceJar;
      this.serviceDialog = serviceDialog;
      this.historyService = historyService;
      this.$scope = $scope;
      this.$state = $state;
      this.$filter = $filter;
      this.$rootScope = $rootScope;
      this.loadListenerDrag();
    }

    /**
    * @private
    * @description
    * Carga el evento para arrastrar archivos desde windows y mac en la aplicación
    */
    private loadListenerDrag() {
      // Se inicia el drag
      document.ondragover = () => {
        this.$scope.$apply();
        return false;
      };
      // El usuario cancela el drag
      document.ondragleave = document.ondragend = () => {
        this.$scope.$apply();
        return false;
      };
      // Se solto el archivo dentro de la aplicación
      document.body.ondrop = (event) => {
        event.preventDefault();
        this.form.path = event.dataTransfer.files[0]["path"];
        this.form.name = event.dataTransfer.files[0]["name"];
        this.$scope.$apply();
        return false;
      };
    }

    /**
    * @description
    * Se activa al presionar el boton para cargar o reemplazar un archivo, este
    * abre una ventana del explorador para buscar el archivo
    *
    * @see app.native.FileNodeService.openFile
    */
    public actionOpenDialogFile() {
      if (this.dialogIsOpen) return;
      this.dialogIsOpen = true;
      let result = this.serviceDialog.openFile();
      result.then((pathFile) => {
        if (!pathFile) {
          this.dialogIsOpen = false;
          return;
        }
        this.form.path = pathFile[0];
        this.form.name = this.serviceFile.getNameFilePath(this.form.path);
        this.$scope.$apply();
        this.dialogIsOpen = false;
      });
    }

    /**
    * @description
    * Valida si el archivo existe antes de iniciar el consumo del servicio JAR.
    */
    public actionValidateFile() {
      if (this.form.path === "") return;
      if (this.dialogIsOpen) return;
      this.dialogIsOpen = true;
      this.showLoading = true;
      // Si no cumple con el formato del archivo este no se sube y muestra el mensaje de error
      if (!this.soi.formatFileValid(this.form.name)) {
        this.notificationService.show(this.$filter("translate")("MESSAGES.TITLES.ERROR"), this.$filter("translate")("MESSAGES.FORMAT_INVALID"));
        this.dialogIsOpen = false;
        this.showLoading = false;
        return;
      }
      // this.$rootScope.$broadcast("show-loading");
      this.file = {
        pathArchivo: this.form.path,
        tipoArchivo: this.form.type
      };
      let result = this.serviceJar.execJson("soi-empresarial-converters-1.0", "validarArchivoPila", this.file);
      result.then((data) => {
        this.dataValidate = data;
        this.showLoading = false;
        this.dialogIsOpen = false;
        if (this.dataValidate.length > 0) {
          this.file.name = this.form.name.substr(0, this.form.name.lastIndexOf("."));
          this.showValidate = true;
          this.$scope.$apply();
          let title = this.$filter("translate")("MESSAGES.VALIDATE_ERROR.TITLE");
          let message = this.$filter("translate")("MESSAGES.VALIDATE_ERROR.MESSAGE");
          this.serviceDialog.showDialogError(title, message);
        } else {
          // Se ejecuta el codigo que abre de inmediato la ventana de la tabla.
          let result = this.soi.convertFile(this.file);
          this.file.name = this.form.name.substr(0, this.form.name.lastIndexOf("."));
          result.then((data) => {
            if (!data) return;
            this.$state.go("listTable", {
              data: JSON.stringify(data),
              file: JSON.stringify(this.file)
            });
          });
        }

      }, (data) => {
        // Se crea la función vacia para evitar error por no encontrar el metodo reject
      });
    }

  }

  // Vincula el componente al modulo principal
  let app: any = angular.module("PILA");
  app.component("convert", {
    controller: ConvertController,
    templateUrl: "./components/convert/convert.main.html"
  });
}

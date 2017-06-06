/// <reference path="../../dt/angular.d.ts"/>

namespace app.table {

  /**
  * @class ListTableController
  * @author Luis Felipe Zapata <lzapata@swat-it.co>
  * @description
  * Componente que carga la lista de todas las tablas de los registros del archivo
  * para su edición, permite guardar los cambios del archivo para luego cambiarlo.
  */
  class ListTableController {

    /**
    * @type {Object[]} data - Contiene los datos que se deben mostrar en la tablas.
    */
    public data: any;

    /**
    * @type {Object<name, pathArchivo, tipoArchivo>} file - Información del archivo actualmente cargado.
    */
    public file: any;

    /**
    * @type {Class} soiService - Servicio con funciones de llamado de SOI.
    * @see app.native.SoiService
    */
    private soiService: any;

    /**
    * @type {Class} serviceJar - Servicio nativo de NodeJS para consumo de JAR.
    * @see app.nodejs.JarNodeService
    */
    private serviceJar: any;

    /**
    * @type {Class} serviceFile - Servicio nativo de NodeJS para manupular archivos.
    * @see app.nodejs.FileNodeService
    */
    private serviceFile: any;

    /**
    * @type {Class} historyService - Servicio para consulta de archivos
    * del historial.
    */
    private historyService: any;

    /**
    * @type {NativeDialogService} dialog - Administra las ventanas nativas
    * del sistema operativo.
    */
    private dialog: any;

    private $scope: any;
    private $rootScope: any;

    static $inject = ["native.dialog.service", "jar.soi.service", "native.jar.service", "native.file.service", "history.service", "$scope", "$rootScope"];

    constructor(dialog, soiService, serviceJar, serviceFile, historyService, $scope, $rootScope) {
      this.dialog = dialog;
      this.soiService = soiService;
      this.serviceJar = serviceJar;
      this.serviceFile = serviceFile;
      this.historyService = historyService;
      this.$scope = $scope;
      this.$rootScope = $rootScope;
    }

    /**
    * @description
    * Toma el JSON actual y lo almacena en un archivo JSON dentro de la carpeta
    * de la aplicación para su carga en el historial.
    * El broadcast se encuentra en el componente TableEdit para limpiar los
    * inputs dentro de las tablas
    *
    *@return {Promise} la promesa en el parametro tiene la ruta completa del nuevo JSON.
    */
    public actionSaveFile() {
      this.$rootScope.$broadcast("clear-inputs-table-edit");
      let promiseHistory = this.historyService.fileFormatHistory();
      promiseHistory.then((jsonFormatHistory) => {
        jsonFormatHistory[this.file.name] = this.file.tipoArchivo;
        this.historyService.saveFileFormatHistory(jsonFormatHistory);
      });
      let dataForSave: any = this.soiService.registerType2ToArray(this.data);
      return this.serviceFile.createFileConvert(this.file.name + ".json", dataForSave);
    }

    /**
    * @description
    * ALmacena el archivo en formato JSON para la edición futura, el evento retorna
    * una promesa con la ruta del archivo JSON almacenado, se carga la opción de
    * la ventana de tipo dialog para almacenar el archivo, despues de que el usuario
    * seleccione la ubicación y nombre del archivo, se pasa los datos al metodo JAR
    * que creara la planilla con el formato 2388.
    */
    public actionGenerate() {
      let jsonFile = this.dialog.saveFile();
     if (!jsonFile) return null;
      jsonFile.then((pathFile) => {
        if (!pathFile) return;
        let dialogSave = this.actionSaveFile();
        dialogSave.then((pathJsonFile) => {
          let options = {
            pathArchivo: pathFile,
            tipoArchivo: this.file.tipoArchivo,
            pathArchivoData: pathJsonFile
          };
          this.serviceJar.execJson("soi-empresarial-converters-1.0", "escribirArchivo2388", options);
        });
      });
    }

  }

  // Se agrega el componente al modulo principal.
  let app: any = angular.module("PILA");
  app.component("listTable", {
    bindings: {
      data: "=", // Datos de las tablas para mostrar, son entregados por el JAR.
      file: "<" // Datos del archivo, se usa para sacar el nombre.
    },
    controller: ListTableController,
    templateUrl: "./components/table/list.html"
  });
}

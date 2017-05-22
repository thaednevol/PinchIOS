/// <reference path="../../dt/angular.d.ts"/>

namespace app.dashboard {

  /**
  * @class DashboardTableController
  * @author Luis Felipe Zapata <lzapata@swat-it.co>
  * @description
  */
  class DashboardTableController {

    /**
    * @type {Array<Object>} listTable - Lista de datos que se imprimen en la
    * tabla.
    */
    public listTable: any = null;

    /**
    * @type {Object} labelsTable - El objeto almacena los keys de los campos
    * que debe mostrar la tabla y el nombre del label de la cabecera.
    */
    public labelsTable: any = null;

    /**
    * @type {String} search - Modelo utilizado para indicar los valores que
    * se utilizan para el filtro de todos los campso de la tabla.
    */
    public search: string = "";

    /**
    * @type {SoiService} soi - Consulta los servicios que utiliza los JAR de
    * SOI para la aplicación.
    * @see app.jar.SoiService
    */
    private soi: any;

    /**
    * @type {NativeFileService} file - Manipula los archivos que se encuentran
    * almacenados en la carpeta del programa.
    * @see app.native.NativeFileService
    */
    private file: any;

    /**
    * @type {Class} historyService - Realzia la petición de carga de información
    * del archivo de la planilla.
    */
    private historyService: any;

    /**
    * @type {String} typeTable - Indica si la tabla es de settlement o local para
    * realizar el switch entre los titulos de la tabla.
    */
    public typeTable: string;

    /**
    * @type {NativeDialogService} dialog - Servicio encargado de manipular las
    * ventanas nativas del sistema operativo, puede abrir ventanas de dialogo
    * para guardar o abrir archivos.
    * @see app.native.NativeDialogService
    */
    private dialog: any;

    private $state: any;
    static $inject = ["history.service", "jar.soi.service", "native.file.service", "native.dialog.service", "$state"];

    constructor(historyService, soi, file, dialog, $state) {
      this.historyService = historyService;
      this.soi = soi;
      this.file = file;
      this.dialog = dialog;
      this.$state = $state;
    }

    /**
    * @description
    * Cuando se presiona una fila de alguno de los registros de las tablas se
    * valida que tipo de archivo es y ejecuta la función de carga de la planilla.
    *
    * @param {Number} indexRegister - Posición en el array de la tabla.
    */
    public actionOpenFile(indexRegister: number): void {
      let currentFile = this.listTable[indexRegister];
      if (currentFile.hasOwnProperty("convert")) {
        // Archivos locales
        if (currentFile.convert) {
          this.openFileConvert(currentFile.name);
        } else {
          this.openFileSettlement(currentFile.name);
        }
      } else {
        // Archivos del servidor
        this.$state.go("support", {
          numberDashboard: currentFile.numeroPlanillaElectronica
        });
      }
    }

    /**
    * @description
    * Carga el archivo editado en formato JSON, realiza el llamado del
    * componente de la tabla de edición.
    * Si no se encuentra el formato en el archivo de opciones se carga por
    * defecto el valor de tipo de archivo de activos 1747.
    *
    * @param {String} nameFile - Nombre del archivo JSON del convertidor.
    */
    private openFileConvert(nameFile: string): void {
      let promiseHistory = this.historyService.fileFormatHistory();
      // Consulta el tipo de archivo del convertidor para cargarlo.
      // Identifica que tipo de archivo es si Activo o pensionado.
      promiseHistory.then((jsonFormatHistory) => {
        let pathFile = this.file.getPathConvert(nameFile);
        let fileConvert: any = {
          name: nameFile,
          pathArchivo: pathFile,
          tipoArchivo: jsonFormatHistory[nameFile] || "1747"
        };
        // Consulta la información del archivo con la ruta para cargarla.
        let result = this.historyService.fileHistory(pathFile);
        result.then((data) => {
          // Realiza la conversión del array de registro tipo2 a un objecto.
          data = this.soi.registerType2ToObject(data);
          // Realiza el llamado al componente convert con los datos del archivo.
          this.$state.go("listTable", {
            data: JSON.stringify(data),
            file: JSON.stringify(fileConvert)
          });
        });
      });
    }

    /**
    * @description
    * Carga el archivo en la ventana de liquidador.
    *
    * @param {string} nameFile - Nombre del archivo JSON del liquidador.
    */
    private openFileSettlement(nameFile: string): void {
      this.$state.go("settlement", {
        pathFile: this.file.getPathSettlement(nameFile)
      });
    }

  }

  // Vincula el componente al modulo principal
  let app: any = angular.module("PILA");
  app.component("dashboardTable", {
    controller: DashboardTableController,
    bindings: {
      listTable: "=",  // Lista de datos para mostrar en la tabla.
      labelsTable: "<", // Lista de texto que tiene la cabecera de la tabla.
      typeTable: "<" // Indica que tipo de tabla es la que se carga para ajustar el titulo.
    },
    templateUrl: "./components/dashboard/dashboard.table.html"
  });
}


namespace app.history {

  /**
   * @class HistoryService
   * @author Luis Felipe Zapata <lzapata@swat-it.co>
   * @description
   * Clase encargada de realizar el consumo del servicio que carga los datos
   * de los archivos modificados antes.
   */
  class HistoryService {


    /**
    * @type {Class} serviceFile - Servicio nativo de NodeJS para manupular
    * archivos.
    * @see app.native.FileNodeService
    */
    private serviceFile: any;

    /**
    * @type {Object} OPTIONS - Equivale al archivo de opciones del sistema.
    * @see app/webapp/json/data/options.json
    */
    private OPTIONS: any;

    private $resource: any;
    static $inject = ["$resource", "native.file.service", "OPTIONS"];

    constructor($resource, serviceFile, OPTIONS) {
      this.$resource = $resource;
      this.serviceFile = serviceFile;
      this.OPTIONS = OPTIONS;
    }

    /**
    * @description
    * Carga el archivo json que se pasa como una ruta completa, con la
    * información del archivo almacenado en el historial.
    *
    * @param {String} routeJson - Ruta donde se almacena el archivo con los
    * datos de la planilla antes guardados.
    * @return {Promise} Promesa con el información del archivo en JSON.
    */
    public fileHistory(routeJson) {
      return this.$resource(routeJson).get().$promise;
    }

    /**
    * @description
    * Carga el archivo que almacena el formato para los archivos del historial.
    *
    * @return {Promise} Promesa con la información del archivo en JSON.
    */
    public fileFormatHistory() {
      let formatHistory = this.serviceFile.getPathOptions(this.OPTIONS.FILES.FORMAT_HISTORY);
      if (formatHistory) {
        return this.$resource(formatHistory).get().$promise;
      }
      return new Promise((resolve) => { resolve({}); });
    }

    /**
    * @description
    * Agrega información al archivo de formatos del historial almacenado en la
    * carpeta de opciones.
    *
    * @param {JSON} jsonFormatHistory - Datos para reemplazar el contenido
    * del archivo de tipo de formatos del historial.
    */
    public saveFileFormatHistory(jsonFormatHistory) {
      this.serviceFile.createFileOptions(this.OPTIONS.FILES.FORMAT_HISTORY, jsonFormatHistory);
    }

  }

  // Vincula el servicio al modulo principal de la aplicación
  let app: any = angular.module("PILA");
  app.service("history.service", HistoryService);
}

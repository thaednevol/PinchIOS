
namespace app.native {

  /**
   * @class DebugService
   * @author David Montoya <dmontoya@lucasian.com>
   * @description
   * Almacena la información de tipo log en un archivo creado en la carpeta de
   * los logs de la aplicación.
   *
   */
  class DebugService {

    /**
    * @type {Object} logger - Libreria nodeJS encargada de almacenar archivos
    * logs en el equipo
    */
    private logger = require("electron-logger");

    private fs: any = require("fs");

    /**
    * @type {Object} OPTIONS - Equivale al archivo de opciones del sistema.
    * @see app/webapp/json/data/options.json
    */
    private OPTIONS: any;

    static $inject = ["OPTIONS"];

    /**
    * @constructor DebugService
    * @description
    * Configura el plugin de electron-logger indicando que ruta debe ser utilizada para
    * almacenar los logs, tamaño maximo de archivos y formato, valida el
    * sistema operativo para indicar la ruta con el SO.
    */
    constructor(OPTIONS) {
      this.OPTIONS = OPTIONS;
      this.logger.setLevel("info");
      this.logger.getLevel();
      this.logger.open();
      let logPath = process.env.LOG_PILA_ELECTRON;
      // Uso para Windows
      if (/^win/.test(process.platform)) {
        logPath = logPath.substr(0, logPath.lastIndexOf("\\") + 1);
      }else{
        logPath = logPath.substr(0, logPath.lastIndexOf("/") + 1);
      }
      if ( !this.fs.existsSync(logPath) ){
          this.fs.mkdir(logPath);
      }
      var logName = 'electron.log';
      this.logger.setOutput({file:logPath+logName});

    }

    /**
    * @description
    * Almacena un texto con el tag de debug en el archivo de log de electron.
    *
    * @param {String} message - Texto del log que se almacenara.
    */
    public debug(message: string): void {
      this.logger.debug(message);
    }

    /**
    * @description
    * Almacena un texto con el tag de info en el archivo de log de electron.
    *
    * @param {String} message - Texto del log que se almacenara.
    */
    public info(message: string): void {
      this.logger.info(message);
    }

    /**
    * @description
    * Almacena un texto con el tag de error en el archivo de log de electron.
    *
    * @param {String} message - Texto del log que se almacenara.
    */
    public error(message: string): void {
      this.logger.error(message);
    }

  }

  // Vincula el servicio al componente principal de angular
  let app: any = angular.module("PILA");
  app.service('logger',DebugService);
}

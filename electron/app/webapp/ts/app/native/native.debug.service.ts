/// <reference path="../../dt/angular.d.ts"/>

namespace app.native {

  /**
   * @class DebugService
   * @author Luis Felipe Zapata Castaño <lzapata@swat-it.co>
   * @description
   * Almacena la información de tipo log en un archivo creado en la carpeta de
   * los logs de la aplicación.
   *
   * @see {@link https://www.npmjs.com/package/winston|winston}
   * @see {@link https://nodejs.org/api/process.html#process_process_env|process}
   */
  class DebugService {

    /**
    * @type {Object} winston - Libreria nodeJS encargada de almacenar archivos
    * logs en el equipo
    */
    private winston = require("winston");

    /**
    * @type {Object} OPTIONS - Equivale al archivo de opciones del sistema.
    * @see app/webapp/json/data/options.json
    */
    private OPTIONS: any;

    static $inject = ["OPTIONS"];

    /**
    * @constructor DebugService
    * @description
    * Configura el plugin de winston indicando que ruta debe ser utilizada para
    * almacenar los logs, tamaño maximo de archivos y formato, valida el
    * sistema operativo para indicar la ruta con el SO.
    */
    constructor(OPTIONS) {
      this.OPTIONS = OPTIONS;
      let routeLog = process.env.LOG_PILA;
      routeLog = routeLog.substr(0, routeLog.lastIndexOf("/") + 1);
      // Uso para Windows
      if (/^win/.test(process.platform)) {
        routeLog = routeLog.substr(0, routeLog.lastIndexOf("\\") + 1);
      }
      this.winston.add(this.winston.transports.File, {
        filename: `${routeLog}${this.OPTIONS.LOGS.NAME}`,
        json: false, // Se da la orden de que el formato sea texto plano.
        maxsize: this.OPTIONS.LOGS.SIZE // Tamaño de 1 mega maximo por archivo de log.
      });
      // Se indica que se elimnen los mensajes de la consola web.
      this.winston.remove(this.winston.transports.Console);
    }

    /**
    * @description
    * Almacena un texto con el tag de info en el archivo de log de electron.
    *
    * @param {String} message - Texto del log que se almacenara.
    */
    public info(message: string): void {
      this.winston.info(message);
    }

    /**
    * @description
    * Almacena un texto con el tag de error en el archivo de log de electron.
    *
    * @param {String} message - Texto del log que se almacenara.
    */
    public error(message: string): void {
      this.winston.log("error", message);
    }

  }

  // Vincula el servicio al componente principal de angular
  let app: any = angular.module("PILA");
  app.service("native.debug.service", DebugService);
}

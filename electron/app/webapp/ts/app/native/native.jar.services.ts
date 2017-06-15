/// <reference path="../../dt/Promise.d.ts"/>

namespace app.native {

  /**
   * @class NaviteJarService
   * @author Luis Felipe Zapata Castaño <lzapata@swat-it.co>
   * @description
   * Ejecuta los archivos JAR por consola, extrae la información de los archivos
   * que entrega impreso con un System.println.
   *
   * @see {@link https://nodejs.org/api/path.html#path_path_join_paths|path}
   * @see {@link https://nodejs.org/api/child_process.html#child_process_child_process_exec_command_options_callback|exec}
   */
  class NaviteJarService {

    /**
    * @type {Boolean} waitResponse - Si el valor asignado es true, se eliminara
    * del comando de ejecución de comandos la opción timeout para permitir
    * que el child_process continue ejecutando hasta que el comando retorne
    * una respuesta.
    */
    public waitResponse: boolean = false;

    /**
    * @type {debug} debug - Servicio que se encarga de almacenar
    * los registros de las acciones realizadas en un archivo de log.
    * @see app.native.debug()
    */
    private debug: any;

    /**
    * @type {Object} OPTIONS - Equivale al archivo de opciones del sistema.
    * @see app/webapp/json/data/options.json
    */
    private OPTIONS: any;


    private $filter: any;
    private exec: any = require("child_process").exec;
    private path: any = require("path");
    static $inject = ["native.debug.service", "OPTIONS", "$filter"];

    constructor(debug, OPTIONS, $filter) {
      this.debug = debug;
      this.OPTIONS = OPTIONS;
      this.$filter = $filter;
    }

    /**
    * @description
    * Ejecuta un archivo JAR pasando como parametro el nombre del evento, y como
    * argumento principal un objeto JSON que es convertido a cadena String.
    *
    * @param {string} nameJar - Nombre del archivo JAR que se ejecutara.
    * @param {string} event - Nombre del metodo que tiene el JAR.
    * @param {Object} dataJson - Datos que recibe el parametro para pasar como JSON.
    * @return {Promise} Resultado entregado por la función this.execCommand().
    */
    public execJson(nameJar: string, event: string = null, dataJson: any = null): any {
      return this.execString(nameJar, event, JSON.stringify(dataJson).replace(/\"/g, "\\\""));
    }

    /**
    * @description
    * Ejecuta un archivo JAR, pasando como parametros el nombre del evento y
    * una cadena de string como argumento principal.
    *
    * @param {string} nameJar - Nombre del archivo JAR que se ejecutara.
    * @param {string} event - Nombre del metodo que tiene el JAR.
    * @param {String} dataString - Datos que recibe el parametro en formato String.
    * @return {Promise} Resultado entregado por la función this.execCommand().
    */
    public execString(nameJar: string, event: string = null, dataString: string = null): any {
      let routeJar = this.getRouteJar(nameJar);
      let command: any = `${this.OPTIONS.JAR.COMMAND} ${routeJar} ${event} "${dataString}"`;
      return this.execCommand(command);
    }

    /**
    * @description
    * Ejecuta un archivo JAR sin parametros.
    *
    * @param {string} nameJar - Nombre del archivo JAR que se ejecutara.
    * @return {Promise} Resultado entregado por la función this.execCommand().
    */
    public execJar(nameJar: string): any {
      let execServer: any = require("child_process").exec;
      let routeJar = this.getRouteJar(nameJar);
      let command: string = `${this.OPTIONS.JAR.COMMAND} ${routeJar}`;
      execServer(command, { killSignal: "KILL_EXEC_SERVER" });
    }


    /**
    * @description
    * Ejecuta el jar del WebServer de liquidacion con parametros personalizados de memoria.
    *
    * @param {string} nameJar - Nombre del archivo JAR que se ejecutara.
    * @return {Promise} Resultado entregado por la función this.execCommand().
    */
    public execJarLiquidacionSvr(nameJar: string): any {
      let routeJar = this.getRouteJar(nameJar);
      let command: string = `${this.OPTIONS.JAR.COMMAND_LIQ_SVR} ${routeJar}`;
      return this.execCommand(command);
    }

    /**
    * @private
    * @description
    * Realiza la ejecución de un cadena de comandos desde la consola, captura
    * la información impresa en la salida de la consola y la convierte a JSON
    * para retornarla en una promesa.
    *
    * @param {String} command - Comando que se ejecuta en la consola del
    * sistema operativo.
    * @return {null|Promise} Si la variable command es nula o vacia se retorna
    * null, en caso contrario una promesa que ejecuta resolve y reject.
    */
    private execCommand(command: string): any {
      if (!command || command === "") return;
      this.debug.info(`command: ${command}`);
      return new Promise((resolve, reject) => {
        let optionsCommand = {
          maxBuffer: this.OPTIONS.JAR.BUFFER_EXEC,
          timeout: this.OPTIONS.JAR.TIMEOUT_EXEC
        };
        // Se elimina el tiempo si se requiere que el comando se ejecute hasta
        // tener una respuesta.
        if (this.waitResponse) {
          delete optionsCommand.timeout;
        }
        this.exec(command, optionsCommand, (error, outData, messageError) => {
          // Si no entrega un mensaje de error, se asigna uno por defecto.
          if (messageError === "") {
            messageError = this.$filter("translate")("MESSAGES.ERROR_JAR");
          }
          let dataError: any = {
            error: true,
            message: messageError
          };
          if (error || outData === " " || outData === "") {
            this.debug.error(`JAR command: ${command}\n${error} ${messageError}`);
            reject(dataError);
            return;
          }
          outData = this.outDataToJson(outData);
          resolve(outData);
        });
      });
    }

    /**
    * @private
    * @description
    * Convierte el mensaje entregado en consola en un JSON, valida si la
    * estructura entregada es la correcta, de lo contrario retorna un JSON vacio.
    *
    * @param {String} outData - mensaje que retorna la consola despues de
    * ejecutar el comando JAR.
    * @return {Object} Objecto JSON.
    */
    private outDataToJson(outData): any {
      let json = {};
      try {
        json = JSON.parse(outData);
      } catch (error) {
        this.debug.error(`El mensaje de consola del JAR no tiene la estructura adecuada de un JSON.\n${error.message}\n${outData}`);
      }
      return json;
    }

    /**
    * @private
    * @description
    * Retorna la ruta del archivo JAR en el sistema operativo para ejecutar el
    * llamado. Al generar el empaquetado de la aplicación los archivos JAR se
    * ubican en una carpeta que esta a 2 niveles fuera de la que ejecuta los
    * script, por lo cual se hace uso de los dos puntos (..).
    *
    * @param {string} nameJar - Nombre del archivo JAR que se ejecutara.
    * @return {String} ruta completa del archivo JAR.
    */
    private getRouteJar(nameJar: string = ""): string {
      let fileJar = this.path.join(this.OPTIONS.FOLDERS.JAR, `${nameJar}.jar`);
      let routeJar = this.path.join(__dirname, "..", "..", fileJar);
      return routeJar;
    }

  }

  // Se agerga el servicio al modulo principal de la aplicación.
  let app: any = angular.module("PILA");
  app.service("native.jar.service", NaviteJarService);
}

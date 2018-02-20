/// <reference path="../../dt/node.d.ts"/>

namespace app.native {

  /**
   * @class NativeFileService
   * @author Luis Felipe Zapata Castaño <lzapata@swat-it.co>
   * @description
   * Clase encargada del manejo de archivos con el modulo nativo de nodejs,
   * valida si existen las carpetas que son utilizadas en la aplicación
   * y las crea.
   *
   * @see {@link https://nodejs.org/api/path.html#path_path_join_paths|path}
   * @see {@link https://nodejs.org/api/process.html#process_process_platform|platform}
   * @see {@link https://nodejs.org/api/fs.html#fs_fs_readfile_file_options_callback|readFile}
   * @see {@link https://nodejs.org/api/fs.html#fs_fs_stat_path_callback|stat}
   * @see {@link https://nodejs.org/api/process.html#process_process_env|env}
   * @see {@link https://www.npmjs.com/package/json2csv|json2csv}
   */
  class NativeFileService {

    /**
    * @type {NativeNotificationService} notificationService - Servicio que
    * permite mostrar notificaciones de forma nativa en el SO.
    * @see app.native.NativeNotificationService
    */
    private notificationService: any;

    /**
    * @type {Object} OPTIONS - Equivale al archivo de opciones del sistema.
    * @see app/webapp/json/data/options.json
    */
    private OPTIONS: any;

    /**
    * @type {Object} folders - Almacena las rutas de las carpetas que se
    * utilizan en la aplicación, la carpeta principal, log, archivos de
    * planillas, temporal y de opciones.
    */
    private folders: any = {};

    /**
    * @type {Object} listTailCreateFile - Cola de almacenamiento de archivos.
    * Se utiliza para evitar que se este escribiendo el contenido de un archivo
    * al mismo tiempo, lo que genera un error en el documento.
    */
    private listTailCreateFile = {};

    /**
    * @type {Array<Object>} listFiles - La lista contiene la información de los
    * archivos de plantillas almacenadas en la aplicación para mostrar en el
    * historial del dashboard.
    */
    public listFiles: any[];

    private archiver: any = require("archiver");
    private json2csv: any = require("json2csv");
    private fs: any = require("fs");
    private path: any = require("path");
    private ipcRender: any = require("electron").ipcRenderer;
    private exec: any = require("child_process").exec;
    private $rootScope: any;
    private $filter: any;
    private $localStorage: any;
    static $inject = ["native.notification.service", "$rootScope", "$filter","$localStorage", "OPTIONS"];

    constructor(notificationService, $rootScope, $filter, $localStorage, OPTIONS) {
      this.notificationService = notificationService;
      this.$rootScope = $rootScope;
      this.$filter = $filter;
      this.$localStorage = $localStorage;
      this.OPTIONS = OPTIONS;
      if ( this.$localStorage!=null && this.$localStorage.authenticatedUserDTO!=null ){
        this.validateFolderApp(this.$localStorage.authenticatedUserDTO.informacionAportantePlanillaDTO.codSoiTpIdentificacion+"-"+this.$localStorage.authenticatedUserDTO.informacionAportantePlanillaDTO.numeroIdentificacion);
      }
      else{
        this.validateFolderApp("");
      }
    }

    /**
    * @private
    * @description
    * Valida si la carpeta de la aplicación existe, almacena la ruta completa de
    * la carpeta, si esta no existe es creada por el sistema.
    */
    public validateFolderApp(nroIdentificacionAportante): void {
      // Valida la carpeta de la aplicación
      let homeFolder: string = process.env.USERPROFILE || process.env.HOME;
      this.folders.app = this.path.join(homeFolder, this.OPTIONS.FOLDERS.ROOT);
      this.createFolder(this.folders.app);
      // Si el sistema es windows aplica el atributo de oculto a la carpeta.
      if (/^win/.test(process.platform)) {
        this.exec("attrib +h -r " + this.folders.app);
      }
      // Valida carpeta de logs
      this.folders.log = this.path.join(this.folders.app, this.OPTIONS.FOLDERS.LOGS);
      this.createFolder(this.folders.log);
      this.createEnvLogs();
      this.createEnvCommand();
      this.createEnvJar();
      // Carpeta para almacenar archivos.
      this.folders.files = this.path.join(this.folders.app, this.OPTIONS.FOLDERS.TEMPLATES.MAIN);
      this.createFolder(this.folders.files);
      // Archivos del historial del convertidor
      this.folders.convert = this.path.join(this.folders.files, this.OPTIONS.FOLDERS.TEMPLATES.CONVERT,nroIdentificacionAportante);
      this.createFolder(this.folders.convert);
      // Archivos del historial de liquidar
      this.folders.settlement = this.path.join(this.folders.files, this.OPTIONS.FOLDERS.TEMPLATES.SETTLEMENT,nroIdentificacionAportante);
      this.createFolder(this.folders.settlement);
      // Carpeta con archivos temporales
      this.folders.temp = this.path.join(this.folders.files, this.OPTIONS.FOLDERS.TEMPLATES.TEMP);
      this.createFolder(this.folders.temp);
      // Carpeta con archivos de opciones para metodos JAR y NodeJS
      this.folders.options = this.path.join(this.folders.app, this.OPTIONS.FOLDERS.OPTIONS);
      this.createFolder(this.folders.options);
    }

    /**
    * @private
    * @description
    * Valida si la carpeta existe, si no existe y la crea.
    *
    * @param {String} folder - Ruta absoluta de la carpeta para validar o crear.
    */
    private createFolder(folder: string): void {
      if (!this.fs.existsSync(folder)) {
        this.fs.mkdirSync(folder);
      }
    }

    /**
    * @private
    * @description
    * Crea la ruta donde se almacena el archivo de log, este es almacenado en
    * una variable de entorno para ser llamada desde el JAR de SWAT para
    * registrar los eventos.
    */
    private createEnvLogs(): void {
      let pathFileLog = this.path.join(this.folders.log, this.OPTIONS.FILES.LOGS);
      process.env.LOG_PILA = pathFileLog;
    }

    /**
    * @private
    * @description
    * Crea la ruta donde se almacena el archivo de log, este es almacenado en
    * una variable de entorno para ser llamada desde el JAR de SWAT para
    * registrar los eventos de comandos.
    */
    private createEnvCommand(): void {
      let pathFileLog = this.path.join(this.folders.log, this.OPTIONS.LOGS.NAME);
      process.env.LOG_PILA_ELECTRON = pathFileLog;
    }

    /**
    * @private
    * @description
    * Crea la ruta donde se almacenas los JAR en una variable de entorno para
    * se consultada por el servidor REST de liquidación.
    */
    private createEnvJar(): void {
      let jarFolder = this.path.join(__dirname, "..", "..", this.OPTIONS.FOLDERS.JAR);
      let supportFolder = this.path.join(jarFolder, this.OPTIONS.FOLDERS.SUPPORTS);
      let resourceFolder = this.path.join(jarFolder, this.OPTIONS.FOLDERS.RESOURCES);
      process.env.RECURSOS_SOPORTES = resourceFolder;
      process.env.GENERACION_SOPORTES = supportFolder;
    }

    /**
    * @description
    * Carga un array con los nombres de los archivos que este almacenados en la
    * carpeta del liquidador.
    *
    * @return {Promise} Retorna una promesa, como parametro entrega un array.
    * @see this.loadFilesOfFolder();
    */
    public loadSettlementFiles(): any {
      return this.loadFilesOfFolder(this.folders.settlement);
    }

    /**
    * @description
    * Carga un array con los nombres de los archivos que este almacenados en la
    * carpeta del convertidor.
    *
    * @return {Promise} Retorna una promesa, como parametro entrega un array.
    * @see this.loadFilesOfFolder();
    */
    public loadConvertFiles(identificacionAportante): any {
      return this.loadFilesOfFolder(this.folders.convert);
    }

    /**
    * @private
    * @description
    * Busca los archivos de una carpeta y los procesa entregando el listado con
    * nombres ordenados por fecha de modificación de la mas reciente a la mas
    * antigua.
    *
    * @param {String} folder - Ruta absoluta de carpeta donde se almacenan los archivos.
    * @return {Promise} La promesa solo cuenta con el metodo resolve.
    */
    private loadFilesOfFolder(folder): any {
      this.listFiles = this.listFiles || [];
      return new Promise((resolve) => {
        this.fs.readdir(folder, (error, files) => {
          if (!error && files) {
            this.processFile(folder, files, 0, resolve);
          } else {
            resolve(this.listFiles);
          }
        });
      });
    }

    /**
    * @private
    * @description
    * Recorre el array de los archivos que se encuentran en una carpeta, realiza
    * un ordenamiento segun las fechas de modificación conservando la mas
    * reciente de primero.
    *
    * @param {String} folder - Ruta absoluta de carpeta donde se almacenan los archivos.
    * @param {Array} files - Lista de archivos que esta en la carpeta.
    * @param {Number} position - Posición actual en el array.
    * @param {Promise} resolve - Metodo resolve de la promesa principal que ejecuta
    * esta función.
    * @see this.loadFilesOfFolder();
    * @see this.getTimeFile();
    */
    private processFile(folder, files, position, resolve) {
      if (position >= files.length) {
        // Ordenan teniendo en cuenta la fecha mas reciente de modificación.
        this.listFiles.sort((fileA, fileB) => {
          return fileB.time - fileA.time;
        });
        // Da la orden de ejecución de la promesa principal.
        resolve(this.listFiles);
      } else {
        let result = this.getTimeFile(folder, files[position]);
        result.then(() => {
          this.processFile(folder, files, position + 1, resolve);
        });
      }
    }

    /**
    * @private
    * @description
    * Hace uso de la funcion stat de nodejs para capturar la información del
    * archivo, captura la ultima fecha de modificación y agrega la información
    * del tiempo en milisegundos, tiempo con formato y nombre del archivo en
    * el array que almacena los archivos de la carpeta actual.
    *
    * @param {string} folder - Ruta absoluta de carpeta donde se almacenan los archivos.
    * @param {string} file - Nombre del archivo a procesar.
    * @return {Promise} Solo cuenta con el metodo resolve.
    * @see this.processFile();
    */
    private getTimeFile(folder, file) {
      return new Promise((resolve) => {
        // Se valida que los archivos sean JSON o texto plano.
        if (file.indexOf(".json") === -1 && file.indexOf(".txt") === -1) {
          resolve();
          return;
        }
        this.fs.stat(this.path.join(folder, file), (error, stats) => {
          let date: any = new Date(stats.mtime);
          // El formato es propuesto por SOI, por lo que no se puede cambiar.
          let dateFormatted: string = `${date.getDate()}/${date.getMonth() + 1}/${date.getFullYear()} ${date.getHours()}:${date.getMinutes()}`;
          // Se agrega la información del archivo en el array de archivos.
          this.listFiles.push({
            time: date.getTime(),
            formatted: dateFormatted,
            name: file.replace(".json", "").replace(".txt", ""),
            convert: folder.indexOf(this.OPTIONS.FOLDERS.TEMPLATES.CONVERT) !== -1
          });
          resolve();
        });
      });
    }

    /**
    * @description
    * Crea un archivo en formato JSON con los datos actuales de las tablas de
    * edición y almacena la información del archivo en la carpeta de las
    * planillas del convertidor de la aplicación.
    *
    * @param {Sring} nameFile - Nombre del archivo que se almacenara en la
    * carpeta de planillas de convertidor de la aplicación.
    * @param {JSON} [dataJson={}] - Datos JSON que se almacenaran en el archivo.
    * @return {Promise} El metodo resolve contiene la ruta del archivo que se
    * crea, en caso de error retorna null en el resolve.
    */
    public createFileConvert(name: string, dataJson: any = {}): any {
      let fileName = this.path.join(this.folders.convert, name);
      return this.createFile(fileName, JSON.stringify(dataJson));
    }

    /**
    * @description
    * Alamacena una planilla de liquidación en la carpeta de la
    * aplicación.
    *
    * @param {Sring} nameFile - Nombre del archivo que se almacenara en la
    * carpeta de planillas de liquidación de la aplicación.
    * @param {JSON} [dataJson={}] - Datos JSON que se almacenaran en el archivo.
    * @return {Promise} El metodo resolve contiene la ruta del archivo que se
    * crea, en caso de error retorna null en el resolve.
    */
    public createFileSettlement(name: string, dataJson: any = {}): any {
      let fileName = this.path.join(this.folders.settlement, name);
      return this.createFile(fileName, JSON.stringify(dataJson),true,false);
    }

    /**
    * @description
    * Crea un archivo en la carpeta temporal
    *
    * @param {Sring} nameFile - Nombre del archivo que se almacenara en la
    * carpeta de planillas de liquidación de la aplicación.
    * @param {JSON} [data={}] - Datos JSON que se almacenaran en el archivo.
    * @return {Promise} El metodo resolve contiene la ruta del archivo que se
    * crea, en caso de error retorna null en el resolve.
    */
    public createFileTemp(name: string, data: any = {}, showNotification: boolean = true): any {
      let fileName = this.path.join(this.folders.temp, name);
      return this.createFile(fileName, JSON.stringify(data), showNotification);
    }

    /**
    * @description
    * Crea un archivo en la carpeta de opciones de la aplicación, si el archivo
    * fue creado antes, se sobre escribe.
    *
    * @param {Sring} nameFile - Nombre del archivo que se almacenara en la
    * carpeta de opciones de la aplicación.
    * @param {JSON} [dataJson={}] - Datos JSON que se almacenaran en el archivo.
    * @return {Promise} El metodo resolve contiene la ruta del archivo que se
    * crea, en caso de error retorna null en el resolve.
    */
    private createFileOptions(nameFile: string, dataJson: any = {}): any {
      let fileName = this.path.join(this.folders.options, nameFile);
      return this.createFile(fileName, JSON.stringify(dataJson), false);
    }


    /**
    * @description
    * Crea un archivo excel con el contenido enviado
    *
    * @param {String} name - Nombre del archivo que se crea con la ruta absoluta.
    * @param {String} dataFile - Contenido el archivo excel
    * @return {Promise} El metodo resolve contiene la ruta del archivo que se
    * crea, en caso de error retorna null en el resolve.
    */
    public createXlsFile(name: string, dataFile: any): any {
      return new Promise((resolve) => {
        var buf = new Buffer(dataFile, 'base64');
        this.fs.writeFile(name, buf, (error, data) => {
          if (error) {
            delete this.listTailCreateFile[name];
            resolve(null);
            return;
          }
          resolve(name);
          return;
        });
      });
    }


    /**
    * @description
    * Crea un archivo en la ruta especifica, agregando en el la información
    * que se le pasa como parametro.
    *
    * @param {String} name - Nombre del archivo que se crea con la ruta absoluta.
    * @param {String} contentFile - Información que contendra el archivo.
    * @param {boolean} [showNotification=true] - Cuando se almacena el archivo se
    * muestra una notificación indicando que se guardo de forma correcta.
    * @return {Promise} El metodo resolve contiene la ruta del archivo que se
    * crea, en caso de error retorna null en el resolve.
    */
    public createFile(name: string, contentFile: string, showNotification: boolean = true, defaultEncoding: boolean = true): any {
      return new Promise((resolve) => {
        // Se valida si existe una operación de escritura sobre el archivo para
        // ejecutar un timer de 1 segundo esperando que termine para escribir
        // de nuevo el archivo.
        if (this.listTailCreateFile.hasOwnProperty(name)) {
          setTimeout(() => {
            return this.createFile(name, contentFile, showNotification);
          }, 1000 * 1);
        } else {
          // Se le indica que se escribe sobre el archivo.
          this.listTailCreateFile[name] = contentFile;
        }
        if ( defaultEncoding===true ){
          this.fs.writeFile(name, contentFile,(error, data) => {
            if (error) {
              delete this.listTailCreateFile[name];
              resolve(null);
              return;
            }
            // Algunos archivos que se guardan como los de opciones de la aplicación
            // no deben notificar al usuario que se crearon.
            if (showNotification) {
              this.notificationService.show(this.$filter("translate")("MESSAGES.TITLES.INFO"), this.$filter("translate")("MESSAGES.SAVED_FILE"));
            }
            delete this.listTailCreateFile[name];
            resolve(name);
            return;
          });
        }
        else{
          this.fs.writeFile(name, contentFile,'latin1',(error, data) => {
            if (error) {
              delete this.listTailCreateFile[name];
              resolve(null);
              return;
            }
            // Algunos archivos que se guardan como los de opciones de la aplicación
            // no deben notificar al usuario que se crearon.
            if (showNotification) {
              this.notificationService.show(this.$filter("translate")("MESSAGES.TITLES.INFO"), this.$filter("translate")("MESSAGES.SAVED_FILE"));
            }
            delete this.listTailCreateFile[name];
            resolve(name);
            return;
          });
        }
      });
    }

    /**
    * @description
    * Entrega la ruta del archivo de planilla del convertidor guardado.
    * Utiliza el path de NodeJS para entregar la ruta absoluta donde se encuentra
    * almacenado el archivo, esto se realiza para evitar errores por barras
    * en las rutas de los archivos en diferentes OS.
    *
    * @param {String} nameFile - Nombre del archivo JSON del convertidor.
    * @return {String|null} Ruta completa donde se encuentra el archivo, en caso de
    * error retorna null.
    */
    public getPathConvert(nameFile: string): string {
      let path = this.path.join(this.folders.convert, `${nameFile}.json`);
      return this.validatePath(path);
    }

    /**
    * @description
    * Entrega la ruta del archivo de liquidación que se guardo en la aplciación.
    * Utiliza el path de NodeJS para entregar la ruta absoluta donde se encuentra
    * almacenado el archivo, esto se realiza para evitar errores por barras
    * en las rutas de los archivos en diferentes OS.
    *
    * @param {String} nameFile - Nombre del archivo TXT del liquidación.
    * @return {String|null} Ruta completa donde se encuentra el archivo, en caso de
    * error retorna null.
    */
    public getPathSettlement(nameFile: string): string {
      let path = this.path.join(this.folders.settlement, `${nameFile}.txt`);
      return this.validatePath(path);
    }

    /**
    * @description
    * Entrega la ruta del archivo de opciones que se le indique.
    * Utiliza el path de NodeJS para entregar la ruta absoluta donde se encuentra
    * almacenado el archivo, esto se realiza para evitar errores por barras
    * en las rutas de los archivos en diferentes OS.
    *
    * @param {String} nameFile - Nombre del archivo de opciones a cargar.
    * @return {String|null} Ruta completa donde se encuentra el archivo, en caso de
    * error retorna null.
    */
    public getPathOptions(nameFile: string): string {
      let path = this.path.join(this.folders.options, nameFile);
      return this.validatePath(path);
    }

    /**
    * @description
    * Utiliza el path de NodeJS para entregar la ruta absoluta donde se encuentra
    * almcenado el archivo JSON, esto se realiza para evitar errores por barras
    * en las rutas de los archivos en diferentes OS.
    *
    * @param {string} nameJson - Nombre del archivo JSON sin la extension.
    * @return {String|null} Ruta completa donde se encuentra el archivo, en caso de
    * error retorna null.
    */
    public getPathJson(nameJson: string): any {
      let path = this.path.join(__dirname, "..", "json", "data", `${nameJson}.json`);
      return this.validatePath(path);
    }

    /**
    * @description
    * Utiliza el path de NodeJS para entregar la ruta absoluta donde se encuentra
    * almcenado el archivo temp o entregar la carpeta temp para almacenar
    * algun archivo que se requiera.
    *
    * @param {string} [name=null] - Nombre del archivo
    * @return {String|null} Ruta completa donde se encuentra el archivo, en caso de
    * error retorna null.
    */
    public getPathTemp(name: string = null): any {
      let path = this.path.join(this.folders.temp);
      if (name) {
        path = this.path.join(this.folders.temp, `${name}`);
      }
      return this.validatePath(path);
    }


    /**
    * @private
    * @description
    * valida si el archivo existe en la ruta completa, si existe lo retorna, en
    * caso de que el archivo no existe retorna null.
    *
    * @return {String|null} Ruta completa donde se encuentra el archivo, en caso de
    * error retorna null.
    */
    private validatePath(path: string): string {
      if (this.fs.existsSync(path)) {
        return path;
      }
      return null;
    }

    /**
    * @description
    * Entrega el nombre del archivo analizando la cadena string, segun el sistema
    * operativo que se usa el path de un archivo usa \ o /.
    *
    * @param {String} pathFile - Ruta completa del archivo.
    * @return {String} Nombre del archivo que se carga desde un path.
    */
    public getNameFilePath(pathFile: string): any {
      // Uso para Unix
      let nameFile: string = pathFile.substr(pathFile.lastIndexOf("/") + 1);
      // Uso para Windows
      if (/^win/.test(process.platform)) {
        nameFile = pathFile.substr(pathFile.lastIndexOf("\\") + 1);
      }
      return nameFile;
    }

    /**
    * @description
    * Entrega el nombre del archivo analizando la cadena string, segun el sistema
    * operativo que se usa el path de un archivo usa \ o /.
    *
    * @param {String} pathFile - Ruta completa del archivo.
    * @return {String} Nombre del archivo que se carga desde un path.
    */
    public getFilePathOnly(pathFile: string): any {
      // Uso para Unix
      let nameFile: string = pathFile.substr(0, pathFile.lastIndexOf("/") + 1);
      // Uso para Windows
      if (/^win/.test(process.platform)) {
        nameFile = pathFile.substr(0, pathFile.lastIndexOf("\\") + 1) + "\\";
      }
      return nameFile;
    }

    /**
    * @description
    * Entrega la información de un archivo JSON. Si el archivo que se trata de
    * leer no tiene la extensión .json se retorna null en el resolve.
    *
    * @param {String} routeFile - Ruta absoluta del archivo que se quiere leer.
    * @return {Promise} La promesa solo cuenta con la función resolve.
    */
    public getContentFileJson(routeFile: string): any {
      return new Promise((resolve) => {
        if (routeFile.indexOf(".json") === -1) {
          resolve(null);
          return;
        }
        this.fs.readFile(routeFile, (error, data) => {
          if (error) {
            resolve(null);
            return;
          }
          let contentFile = this.contentFileToJson(routeFile, data);
          resolve(contentFile);
        });
      });
    }

    /**
    * @private
    * @description
    * Realiza el parseo del contenido string del archivo
    *
    * @param {String} routeFile - Ruta absoluta donde se almacena el archivo.
    * @param {String} data - Información del archivo en cadena de texto.
    * @return {Object} Contenido del archivo o objeto vacio en caso de error.
    */
    private contentFileToJson(routeFile: string, data: string): any {
      let json = {};
      try {
        if (data.length === 0 || data.indexOf("{") === -1) {
          data = "{}";
        }
        json = JSON.parse(data);
      } catch (error) {
        console.info(`El contenido del archivo ${routeFile} no tiene la estructura adecuada de un JSON.\n${error.message}`);
      }
      return json;
    }

    /**
    * @description
    * Lee un archivo CSV y extrae la información del archivo y la convierte un
    * Array con objetos, las columnas se especifican como fieldN, donde N
    * equivale al numero del campo iniciando desde el numero 1,
    * las opciones de lectura se configuran en el archivo JSON de opciones.
    *
    * @param {String} routeFile - Ruta absoluta donde se almacena el archivo CSV
    * que se va a convertir en un JSON.
    * @return {Promise} La promesa retorna un resolve, el parametro null indica
    * que ocurrio un error de lo contrario retornara un Array.
    * @see app/webapp/json/data/options.json
    */
    public csvToJson(routeFile: string): any {
      let options: any = {
        noheader: this.OPTIONS.CSV.NO_HEADER,
        trim: this.OPTIONS.CSV.TRIM,
        delimiter: this.OPTIONS.CSV.DELIMITER
      };
      const csv = require("csvtojson");
      return new Promise((resolve) => {
        let fileCSV = csv(options);
        let contentCSV = [];
        fileCSV.fromFile(routeFile).on("json", (contentRowJson) => {
          contentCSV.push(contentRowJson);
        });
        fileCSV.on("done", (error) => {
          if (error) {
            this.notificationService.show(this.$filter("translate")("MESSAGES.TITLES.ERROR"), this.$filter("translate")("MESSAGES.ERROR_FILE_CSV"));
            resolve(null);
            return;
          }
          resolve(contentCSV);
        });
      });
    }

    /**
    * @description
    * Convierte una estructura JSON a CSV, crea el archivo en la ruta que se le
    * indica con el contenido.
    *
    * @param {String} routeFile - Ruta donde se almacenara el archivo.
    * @param {Object} dataJson - Objeto JSON con la información que se agregara.
    * @param {Array<String>} fields - Nombre de los campos que se va a crear.
    * @return {Promise} Promesa del proces de almacenado del archivo.
    */
    public jsonToCsv(routeFile: string, dataJson: any, fields: any): any {
      let csvContent: any = this.json2csv({
        withBOM:true,
        excelStrings:true,
        data: dataJson,
        fields: fields,
        hasCSVColumnTitle: false,
        del: this.OPTIONS.CSV.DELIMITER
      });
      return this.createFile(routeFile, csvContent, true);
    }

    /**
    * @description
    * Realiza el proceso de creación de archivos ZIP, asigna el contenido de un
    * arhivo y lo almacena en la ruta indicada en el path.
    */
    public createFileZip(path: string, file: any): string {
      let nameFileInZip = this.getNameFilePath(file);
      let routeFileZip = this.path.join(path, `${nameFileInZip}.zip`);
      let fileZip = this.fs.createWriteStream(routeFileZip);
      let archive = this.archiver("zip", {
        store: true
      });
      archive.pipe(fileZip);
      archive.file(file, {
        name: nameFileInZip
      });
      archive.finalize();
      return routeFileZip;
    }
  }

  let app: any = angular.module("PILA");
  app.service("native.file.service", NativeFileService);
}

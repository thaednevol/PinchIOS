namespace app.jar {

  /**
   * @class SoiService
   * @author Luis Felipe Zapata Castaño <lzapata@swat-it.co>
   * @description
   * Realiza la ejecución de los metodos almacenados en el JAR entregado para
   * las peticiones de planillas SOI.
   */
  class SoiService {

    /**
    * @type {NaviteJarService} jar - Servicio nativo de NodeJS para consumo de JAR.
    * @see app.native.JarNodeService
    */
    private jar: any;

    /**
    * @type {NativeNotificationService} nativeNotification - Clase que se encarga
    * de mostrar notificaciones por medio de alerts nativos.
    * @see app.native.NativeNotificationService
    */
    private nativeNotification: any;

    /**
    * @type {NativeDialogService} dialog - Administra las ventanas nativas
    * del sistema operativo.
    */
    private dialog: any;

    /**
    * @type {Object} OPTIONS - Equivale al archivo de opciones del sistema.
    * @see app/webapp/json/data/options.json
    */
    private OPTIONS: any;

    private $state: any;
    private $filter: any;
    static $inject = ["native.jar.service", "native.notification.service", "native.dialog.service", "OPTIONS", "$state", "$filter"];


    constructor(jar, nativeNotification, dialog, OPTIONS, $state, $filter) {
      this.jar = jar;
      this.nativeNotification = nativeNotification;
      this.dialog = dialog;
      this.OPTIONS = OPTIONS;
      this.$state = $state;
      this.$filter = $filter;
    }

    /**
    * @description
    * Ejecuta el servidor de springBoot que se usa para realizar el consumo
    * de servicios REST de la aplicación para el componente de liquidar, este
    * metodo se ejecuta despues de hacer login en la aplicación.
    */
    public runServer() {
      setTimeout(() => {
        this.jar.execJar(this.OPTIONS.JAR.FILES.SETTLEMENT.NAME);
      });
    }

    /**
    * @description
    * Realiza la ejecución del metodo que se encarga de convertir la planilla
    * en el formato 2388 de la nueva ley, retorna el registro de tipo 2 con una
    * estructura de Object para poder se utilizado con los filtros.
    *
    * @param {Object} paramsJar - Parametros JSON que se deben enviar al metodo
    * JAR para su ejecuciòn.
    * @return {Promise} Contiene los datos null en caso de error o el Object JSON.
    */
    public convertFile(paramsJar) {
      return new Promise((resolve) => {
        let result = this.jar.execJson(this.OPTIONS.JAR.FILES.CONVERT.NAME, this.OPTIONS.JAR.FILES.CONVERT.METHOD.CONVERT_TO_2388, paramsJar);
        result.then((data) => {
          data = this.registerType2ToObject(data);
          resolve(data);
        }, () => {
          resolve(null);
        });
      });
    }

    /**
    * @private
    * @param {Object} data - Datos retornados por el metodo JAR.
    * @description
    * Recorre cada registro del array de tipo 2 y los convierte en objectos.
    */
    public registerType2ToObject(data) {
      if (!data) return data;
      for (let i = 0; i < data.regsTp02.length; i++) {
        let objectRegister = {};
        for (let j = 0; j < data.regsTp02[i].length; j++) {
          objectRegister[`regs${j}`] = data.regsTp02[i][j];
        }
        objectRegister['selected'] = false;
        objectRegister['line'] = Number(objectRegister["regs1"]) + 1;
        data.regsTp02[i] = objectRegister;
      }
      let objectRegister1 = {};
      for (let j = 0; j < data.regTp01.length; j++) {
        objectRegister1[`regs${j}`] = data.regTp01[j];
      }
      objectRegister1['selected'] = false;
      data.regTp01 = [];
      data.regTp01[0] = objectRegister1;
      data.regsTp02 = {
        registers: data.regsTp02,
        errors: {}
      }
      data.regTp01 = {
        registers: data.regTp01,
        errors: {}
      };
      return data;
    }

    /**
    * @description
    * Ejecuta el llamado al metodo del JAR que carga el archivo en el convertidor
    * valida si existen errores, si el archivo cuenta con una extructura adecuada
    * se procese a realizar la carga de la ventana del convertidor, en caso de
    * errores se retorna el valor de la promesa con la información del error.
    *
    * @return {Promise} Si hay errores la promesa entrega el array de errores
    * en el metodo resolve de la promesa.
    */
    public validateFile(dataFile: any, nameFile: string): any {
      // return new Promise((resolve) => {
      //   let result = this.jar.execJson(this.OPTIONS.JAR.FILES.CONVERT.NAME, this.OPTIONS.JAR.FILES.CONVERT.METHOD.VALIDATE_FILE, dataFile);
      //   result.then((dataError) => {
      //     if (this.errorInResponseJar(dataError)) return;
      //     if (dataError.length > 0) {
      //       resolve(dataError);
      //       this.file.name = this.form.name.substr(0, this.form.name.lastIndexOf("."));
      //       this.showValidate = true;
      //       this.$scope.$apply();
      //       let title = this.$filter("translate")("MESSAGES.VALIDATE_ERROR.TITLE");
      //       let message = this.$filter("translate")("MESSAGES.VALIDATE_ERROR.MESSAGE");
      //       this.dialog.showDialogError(title, message);
      //     } else {
      //       // Se ejecuta el codigo que abre de inmediato la ventana de la tabla.
      //       let result = this.convertFile(dataFile);
      //       dataFile.name = nameFile;
      //       result.then((response) => {
      //         if (this.errorInResponseJar(response)) return;
      //         this.$state.go("listTable", {
      //           data: JSON.stringify(response),
      //           file: JSON.stringify(dataFile)
      //         });
      //       });
      //     }
      //   });
      // });
    }

    /**
    * @description
    * Revierte el proceso de asignar a objetos los arrays de datos del registro
    * tipo 2 para filtros, esto se hace para que al almacenar conserven la
    * estructura original usada por los metodo JAR.
    *
    * @param {Object} data - Estructura del archivo antigua con datos.
    * @return {Object} Estructura original de la tabla con los datos.
    * @see this.registerType2ToObject();
    */
    public registerType2ToArray(data) {
      if (!data) return data;
      let dataInArray: any = {};
      angular.copy(data, dataInArray);
      dataInArray.regsTp02 = [];
      for (let i = 0; i < data.regsTp02.registers.length; i++) {
        dataInArray.regsTp02[i] = this.lineRegisterType2ToArray(data, i);
      }
      dataInArray.regTp01 = this.lineRegisterType1ToArray(data);
      return dataInArray;
    }


    /**
    * @description
    * Convierte una linea del registro de formato Object a Array.
    *
    * @param {Object} data - Datos que actuales para el cambio.
    * @param {Number} position - Numero del linea o registro para cambiar de
    * objeto a array.
    * @return {Array} Linea del registro convertida en Array.
    */
    public lineRegisterType2ToArray(data, position) {
      if (!data) return data;
      position = position || 0;
      let newArray = [];
      for (let i = 0; i < Object.keys(data.regsTp02.registers[position]).length; i++) {
        newArray[i] = data.regsTp02.registers[position][`regs${i}`];
      }
      return newArray;
    }

    public lineRegisterType1ToArray(data) {
      if (!data) return data;
      let newArray = [];
      for (let i = 0; i < Object.keys(data.regTp01.registers[0]).length; i++) {
        newArray[i] = data.regTp01.registers[0][`regs${i}`];
      }
      return newArray;
    }


    /**
    * @description
    * Convierte una linea del registro de formato Object a una cadena separada por pipe.
    *
    * @param {Object} data - Datos que actuales para el cambio.
    * @param {Number} position - Numero del linea o registro para cambiar de
    * objeto a array.
    * @return {String} Cadena separada por pipe.
    */
    public lineRegisterType2ToSeparatedString(data, position) {
      if (!data) return data;
      position = position || 0;
      let newLine = '';
      for (let i = 0; i <= Object.keys(data.regsTp02.registers[position]).length; i++) {
        newLine = newLine+data.regsTp02.registers[position][`regs${i}`]+'|';
      }
      return newLine;
    }

    /**
    * @description
    * Convierte los datos del registro tipo 1 a cadena
    *
    * @param {Object} data - Datos que actuales para el cambio.
    * objeto a array.
    * @return {String} Cadena separada por pipe.
    */
    public lineRegisterType1ToSeparatedString(data) {
      if (!data) return data;
      let newLine = '';
      for (let i = 0; i < Object.keys(data.regTp01.registers[0]).length-1; i++) {
        newLine = newLine+data.regTp01.registers[0][`regs${i}`]+'|';
      }
      return newLine;
    }

    /**
    * @description
    * Recorre la información de los registros y cambia el valor del numero de
    * secuencia, indicando el registro del cual se tomara referencia para el
    * consecutivo.
    *
    * @param {Object} data - Datos que actuales para el cambio.
    * @param {Number} positionReference - Numero del registro en el array que
    * se usara como referencia.
    * @return {Object} Datos con el valor de la secuencia modificado.
    */
    public changeSequenceRegisterType2(data, positionReference) {
      if (!data) return data;
      positionReference = positionReference || 0;
      for (let i = positionReference; i < data.regsTp02.registers.length; i++) {
        data.regsTp02.registers[i].regs1 = i + 1;
        data.regsTp02.registers[i].line = data.regsTp02.registers[i].regs1 + 1;
      }
      return data;
    }

    /**
    * @description
    * Valida si el tipo de archivo que se trata de convertir es un formato valido
    * de las planillas. En este caso solo se permite archivos con extensión .txt
    *
    * @param {String} nameFile - Nombre o ruta del archivo para validar el formato.
    * @return {Boolean} Indica con true que el archivo es valido.
    */
    public formatFileValid(nameFile) {
      let type = nameFile.substr(nameFile.lastIndexOf(".") + 1).toLowerCase();
      return type === "txt";
    }

    /**
    * @description
    * Valida si el archivo tiene la extención CSV.
    *
    * @param {String} nameFile - Nombre o ruta del archivo para validar el formato.
    * @return {Boolean} Indica con true que el archivo es valido.
    */
    public formatFileValidCSV(nameFile) {
      let type = nameFile.substr(nameFile.lastIndexOf(".") + 1).toLowerCase();
      return type === "csv";
    }

    /**
    * @private
    * @description
    * El metodo valida que tipo de respuesta tiene el metodo JAR que se ejecuta,
    * si existe una respuesta de error por tiempo de ejecución del JAR o
    * por un mensaje retornaro, se mustra una notificación o mensaje dialog con
    * el error y se retorna true para evitar que el proceso continue.
    *
    * @param {Object|String} response - Contenido que retorna el llamado al
    * metodo JAR.
    * @return {Boolean} true en caso de existir un error.
    */
    private errorInResponseJar(response: any): boolean {
      if (response.error) {
        this.nativeNotification.show(this.$filter("translate")("MESSAGES.VALIDATE_ERROR.TITLE"), response.message);
        return true;
      }
      return false;
    }

  }

  let app: any = angular.module("PILA");
  app.service("jar.soi.service", SoiService);
}

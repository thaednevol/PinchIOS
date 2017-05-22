/// <reference path="../../dt/angular.d.ts"/>

namespace app.error {

  /**
  * @class ErrorConvertController
  * @author Luis Felipe Zapata <lzapata@swat-it.co>
  * @description
  * Componente encargado de cargar la lista de errores despues de ejecutar
  * el validador de codigo, cuando se presiona la opción de ir a edición
  * se convierte el archivo y carga la lista con las tablas.
  */
  class ErrorConvertController {

    /**
    * @type {Object[]} data - Contiene los datos que se deben mostrar en la
    * tabla de errores.
    */
    public data: any = [];

    /**
    * @type {Object<name, pathArchivo, tipoArchivo>} file - Información del
    * archivo actualmente cargado.
    */
    public file: any;

    /**
    * @type {SoiService} soi - Servicio con funciones de llamado de SOI.
    * @see app.soi.SoiService()
    */
    private soi: any;

    private $state: any;
    static $inject = ["jar.soi.service", "$state"];

    constructor(soi, $state) {
      this.soi = soi;
      this.$state = $state;
    }

    /**
    * @description
    * Ejecuta el archivo JAR encargado de realizar el convertidor del archivo,
    * al finalizar realiza el llamado al componete de lista de tablas de edición.
    */
    public actionConvertFile() {
      let result = this.soi.convertFile(this.file);
      result.then((data) => {
        if (!data) return;
        this.$state.go("listTable", {
          data: JSON.stringify(data),
          file: JSON.stringify(this.file)
        });
      });
    }

  }

  // Se agrega el componente al modulo principal
  let app: any = angular.module("PILA");
  app.component("errorConvert", {
    bindings: {
      data: "=", // Datos utilizados para mostrar las tabla con errores.
      file: "<" // información del archivo que se carga.
    },
    controller: ErrorConvertController,
    templateUrl: "./components/error/error.convert.html"
  });
}

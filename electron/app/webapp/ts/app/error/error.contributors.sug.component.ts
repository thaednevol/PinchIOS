/// <reference path="../../dt/angular.d.ts"/>

namespace app.error {

  /**
  * @class ErrorContributorsAutController
  * @author Luis Felipe Zapata <lzapata@swat-it.co>
  * @description
  * Lista una tabla con los errores que tiene el el documento de liquidación
  * con los registros de tipo 2.
  * El componente solo permite visualizar datos, no se editan, solo se aplica
  * un filtro para indicar que información se debe mostrar.
  */
  class ErrorContributorsAutController {

    /**
    * @type {Object} selectedItemAut - Almacena la información de la celdas que
    * se selecciona en el momento.
    */
    public selectedItemAut: any = {};

    /**
    * @type {Object[]} data - Contiene los datos que se deben mostrar en la
    * tabla de errores.
    */
    public data: any = [];

    /**
    * @type {Object} objectFilter - Indica el filtro para aplicar a la tabla,
    * esto se realiza para la tabla en la cual los errores son solo para un
    * tipo de registro y no para todos.
    */
    public objectFilter: any = null;

    public errorsFilter: any = null;

    /**
    * @type {Boolean} styleError - Se utiliza para indicar un estilo css con
    * iconos de que los registros presentan error.
    */
    public styleError: boolean = true;

    /**
    * @type {Number} limitRegister - limita la cantidad de registros que se
    * renderizan por bloque que se carga de una tabla, cada cierto
    * tiempo se va aumentando hasta completar el total de elementos.
    */
    public limitRegister = 50;

    /**
    * @type {Number} startLimit - Indica el numero maximo de registros a cargar.
    */
    public startLimit = 0;

    /**
    * @type {Number} currentNumberRegisterLoad - Indica la cantidad de registros
    * que estan cargados en el momento.
    */
    public currentNumberRegisterLoad = 0;

    /**
    * @type {Object} OPTIONS - Equivale al archivo de opciones del sistema.
    * @see app/webapp/json/data/options.json
    */
    private OPTIONS: any;

    static $inject = ["OPTIONS", "$scope"];

    private $scope: any;

    constructor(OPTIONS, $scope) {
      this.OPTIONS = OPTIONS;
      this.$scope = $scope;
      this.limitRegister = this.OPTIONS.TABLES.ROW_LOAD_BY_PAGE;
    }

    public changeLimitRegister() {
      this.setCurrentRegisterLoaded();
      if (this.limitRegister < this.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE_ERROR) {
        setTimeout(() => {
          this.limitRegister += this.OPTIONS.TABLES.ROW_LOAD_BY_PAGE;
          this.$scope.$digest();
        });
      }
    }

    /**
    * @description
    * Actualiza la información de la cantidad de paginas cargadas.
    */
    private setCurrentRegisterLoaded() {
      this.currentNumberRegisterLoad = this.startLimit + this.limitRegister;
      if (this.currentNumberRegisterLoad > this.data.data.length) {
        this.currentNumberRegisterLoad = this.data.data.length;
      }
    }

    /**
    * @description
    * Realiza el cambio de la pagina de la tabla.
    */
    public actionChangePage(orientation) {
      if (orientation === "next" && this.startLimit + this.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE_ERROR < this.data.data.length) {
        this.startLimit += this.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE_ERROR;
      }
      if (orientation === "prev" && this.startLimit > 1) {
        this.startLimit -= this.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE_ERROR;
      }
      setTimeout(() => {
        this.setCurrentRegisterLoaded();
        this.$scope.$digest();
      });
    }

  }

  // Se agrega el componente al modulo principal
  let app: any = angular.module("PILA");
  app.component("errorContributorsSug", {
    bindings: {
      selectedItemAut: "=",
      data: "=", // Datos utilizados para mostrar las tabla con errores.
      objectFilter: "=",  // Datos del filtro para mostrar solo los errores de un registro.
      errorsFilter: "=",  // Filtro para incluir solo los errores corregibles que aun no se han aplicado
      styleError: "=" // Indica si se aplica un estilo css para resaltar los campos como error
    },
    controller: ErrorContributorsAutController,
    templateUrl: "./components/error/error.contributors.sug.html"
  });
}

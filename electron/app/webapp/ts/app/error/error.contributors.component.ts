/// <reference path="../../dt/angular.d.ts"/>

namespace app.error {

  /**
  * @class ErrorContributorsController
  * @author Luis Felipe Zapata <lzapata@swat-it.co>
  * @description
  * Lista una tabla con los errores que tiene el el documento de liquidación
  * con los registros de tipo 2.
  * El componente solo permite visualizar datos, no se editan, solo se aplica
  * un filtro para indicar que información se debe mostrar.
  */
  class ErrorContributorsController {

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
    public objectFilter: any = {};

    constructor() {
    }

  }

  // Se agrega el componente al modulo principal
  let app: any = angular.module("PILA");
  app.component("errorContributors", {
    bindings: {
      data: "=", // Datos utilizados para mostrar las tabla con errores.
      objectFilter: "="  // Datos del filtro para mostrar solo los errores de un registro.
    },
    controller: ErrorContributorsController,
    templateUrl: "./components/error/error.contributors.html"
  });
}

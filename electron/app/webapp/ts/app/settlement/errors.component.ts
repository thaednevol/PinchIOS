/// <reference path="../../dt/angular.d.ts"/>

namespace app.settlement {

  /**
  * @class SettErrorsController
  * @author Luis Felipe Zapata <lzapta@swat-it.co>
  * @description
  */
  class SettErrorsController {

    /**
    * @type {Array} listErrorsContributors - Lista con datos a mostrar en la
    * tabla de errores.
    */
    public listErrorsContributors: any;

    constructor() {
    }

  }

  // Agrega el componente al modulo principal.
  let app: any = angular.module("PILA");
  app.component("settErrors", {
    bindings: {
      listErrorsContributors: "="
    },
    controller: SettErrorsController,
    templateUrl: "./components/settlement/errors.html"
  });
}

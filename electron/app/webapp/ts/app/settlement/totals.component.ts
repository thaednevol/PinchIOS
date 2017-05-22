/// <reference path="../../dt/angular.d.ts"/>

namespace app.settlement {

  /**
  * @class SettTotalsController
  * @author Luis Felipe Zapata <lzapta@swat-it.co>
  * @description
  */
  class SettTotalsController {

    /**
    * @type {Object<name,path,data,origin>} file - Contiene la información del archivo
    * que se carga.
    * @see SettlementController.file
    */
    public file: any = {
      name: "",
      path: "",
      data: [],
      origin: []
    };

    constructor() {
    }

  }

  // Agrega el componente al modulo principal.
  let app: any = angular.module("PILA");
  app.component("settTotals", {
    bindings: {
      file: "=" // Información del archivo que se edita
    },
    controller: SettTotalsController,
    templateUrl: "./components/settlement/totals.html"
  });
}

/// <reference path="../../dt/angular.d.ts"/>

namespace app.settlement {

  /**
  * @class SettInfoController
  * @author Luis Felipe Zapata <lzapta@swat-it.co>
  * @description
  */
  class SettInfoController {

    /**
    * @type {Object<periodPension,periodHealth,totalContributor,totalPay,totalError>}
    * info - información resumida del archivo.
    * @see SettlementController.info
    */
    public info: any = {
      periodPension: "No definido",
      periodHealth: "No definido",
      totalContributor: 0,
      totalPay: 0,
      totalError: 0,
      totalErrorContributor: 0 
    };

    constructor() {
    }
  }

  // Agrega el componente al modulo principal.
  let app: any = angular.module("PILA");
  app.component("settInfo", {
    bindings: {
      info: "=" // Información del documento
    },
    controller: SettInfoController,
    templateUrl: "./components/settlement/settlement.info.html"
  });
}

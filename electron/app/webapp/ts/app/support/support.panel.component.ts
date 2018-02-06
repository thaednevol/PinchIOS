
namespace app.support {

  /**
  * @class SupportPanelController
  * @author Cristian Camilo Zapata <czapata@swat-it.co>
  * @description
  * Controla la carga del las plantillas de liquidación, muestra
  * la información en el panel izquierdo retornada por el consumo del servicio.
  */
  class SupportPanelController {

    /**
    * @type {Object} infoPanel - Variable que almacena en un formato JSON
    * los campos de información de la planilla.
    */
    public infoPanel: any = {};

    /**
    * @type {String} numberSettlement - Modelo que se pasa como binding desde
    * el componente principal, el modelo es asociado al input de la vista que
    * realiza la busqueda.
    */
    public numberSettlement: string = "";

    private $rootScope: any;
    private $scope: any;
    private $filter: any;
    static $inject = ["$rootScope", "$scope", "$filter"];

    public constructor($rootScope, $scope, $filter) {
      this.$rootScope = $rootScope;
      this.$scope = $scope;
      this.$filter = $filter;
      this.clearInfoPanel();
    }

    /**
    * @private
    * @description
    * El metodo restaura el valor por defecto para la variable infoPanel.
    */
    private clearInfoPanel(): void {
      this.infoPanel = {};
    }

    /**
    * @description
    * Realiza la invocación por broadcast a al método getFileSettlement del
    * controlador SupportController para buscar la información de un numero de
    * planilla y extraer la información del soporte de pagos.
    */
    public actionSearch(): void {
      if (this.numberSettlement.length > 0) {
        this.clearInfoPanel();
        this.$rootScope.$broadcast("get-file-settlement");
      }
    }


    /**
    * @description
    * El evento detecta cuando se presiona la tecla enter en la ventana ubicada
    * en un formulario para dar la orden de validación de los datos del login.
    *
    * @param {Object} event - Evento del DOM HTML.
    */
    public actionKeyPress(event: any): void {
      if (event.keyCode === 13) {
        this.actionSearch();
      }
    }

  }

  // Declaración del componente.
  let app: any = angular.module("PILA");
  app.component("supportPanel", {
    controller: SupportPanelController,
    bindings: {
      numberSettlement: "=",
      infoPanel: "="
    },
    templateUrl: "./components/support/support.panel.html"
  });
}

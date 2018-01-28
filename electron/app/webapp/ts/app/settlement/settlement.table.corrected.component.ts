/// <reference path="../../dt/angular.d.ts"/>

namespace app.settlement {

  /**
  * @class SettTableCorrectedController
  * @author Luis Felipe Zapata <lzapta@swat-it.co>
  * @description
  * Carga la información de la tabla de correcciones realizadas
  */
  class SettTableCorrectedController {

    /**
    * @type {NativeNotificationService} notificationService - Servicio que
    * permite mostrar notificaciones de forma nativa en el SO.
    * @see app.native.NativeNotificationService
    */

    /**
    * @type {Array} listErrorsContributors - Lista con datos a mostrar en la
    * tabla de errores.
    */
    public listErrorsContributors: any;

    /**
    * @type {Object} selectedItem - Almacena la información de la celdas que
    * se selecciona en el momento.
    */
    public selectedItem: any = {};

    /**
    * @type {Class} serviceFile - Servicio que ejecuta el llamado a metodos
    * nativos de Nodejs para la manipulación de archivos.
    */
    private serviceFile: any;

    /**
    * @type {Class} serviceDialog - Servicio nativo de Electron para mostrar ventanas dialog.
    * @see app.native.DialogNodeService
    */
    private serviceDialog: any;

    public filterCorregidos: any = null;
    public filterSugeridos: any = null;

    private $filter: any;
    private $scope: any;
    private $rootScope: any;

    static $inject = ["native.notification.service","native.file.service", "native.dialog.service","$scope","$rootScope", "$filter"];
    constructor(notificationService,serviceFile, serviceDialog, $scope,$rootScope,$filter) {
      this.notificationService = notificationService;
      this.serviceFile = serviceFile;
      this.serviceDialog = serviceDialog;
      this.$scope = $scope;
      this.$rootScope = $rootScope;
      this.$filter = $filter;
      this.filterCorregidos = function ( item ){
        return item.corregido;
      };

      this.filterSugeridos = function ( item ){
        return item.autocorregible && !item.corregido;
      };


    }

    /**
    * @description
    * Realiza el llamado a la ventana para indicar donde se almacena el archivo
    * generado en CSV.
    */
    public actionExportToCsvSug(): void {
      let result = this.serviceDialog.saveFile("csv");
      let fields: string[] = [
        "linea",
        "tipoIdentificacion",
        "nroIdentificacion",
        "error",
        "sugerencias",
        "currentValue"
      ];
      if (!result) return;
      result.then((pathFile) => {
        if (!pathFile) return;
        let dataExport = this.$filter("filter")(this.listErrorsContributors.data, this.filterSugeridos);
        this.serviceFile.jsonToCsv(pathFile, dataExport, fields);
      });
    }

    public actionExportToCsvCorr(): void {
      let result = this.serviceDialog.saveFile("csv");
      let fields: string[] = [
        "linea",
        "tipoIdentificacion",
        "nroIdentificacion",
        "error",
        "sugerencias",
        "currentValue",
        "correccion"
      ];
      if (!result) return;
      result.then((pathFile) => {
        if (!pathFile) return;
        let dataExport = this.$filter("filter")(this.listErrorsContributors.data, this.filterCorregidos);
        this.serviceFile.jsonToCsv(pathFile, dataExport, fields);
      });
    }

    public validateSelected(): void {
      let message = `Se eliminará ${Object.keys(this.selectedItem).length} registro.`;
      if (Object.keys(this.selectedItem).length === 0) {
        this.serviceDialog.showDialogError(this.$filter("translate")("ERROR.CONTRIBUTORS.MESSAGE_CORRECTED_WARN_TIT"), this.$filter("translate")("ERROR.CONTRIBUTORS.MESSAGE_CORRECTED_WARN"));
      } else {;
        this.serviceDialog.showDialogConfirm(
          this.$filter("translate")("ERROR.CONTRIBUTORS.MESSAGE_CORRECTED_CONF_TIT"),
          this.$filter("translate")("ERROR.CONTRIBUTORS.MESSAGE_CORRECTED_CONF"),
          (option) => {
            this.dialogIsOpen = false;
            this.correctError(option);
          }
        );
      }

    }

    private correctError(option) {
      let message = `Opcion seleccionada> ${option}`;
      //si acepta la correccion automatica
      if (option === 1){
        for (var i = 0; i < Object.keys(this.selectedItem).length; i++) {
            let register = this.$filter("filter")(this.listErrorsContributors.data, { secuenciaError: Number(Object.keys(this.selectedItem)[i]) },true);
            register[0].correccion = this.$filter("translate")("ERROR.CONTRIBUTORS.TYPE_AUTOM");
            register[0].corregido = true;
            this.$rootScope.$broadcast("apply-corrections",register[0].linea,register[0].campo);
            //this.$filter("filter")(this.listErrorsContributors.data, { secuenciaError: this.selectedItem)[i] }).correccion = this.$filter("translate")("ERROR.CONTRIBUTORS.TYPE_AUTOM");
            //this.listErrorsContributors.data.filter(secuenciaError:Object.keys(this.selectedItem)[i]).corregido = true;
            //this.listErrorsContributors.data.filter(this.filterSugeridos)[Object.keys(this.selectedItem)[i]].correccion = this.$filter("translate")("ERROR.CONTRIBUTORS.TYPE_AUTOM");
          }
          this.filterCorregidos = function ( item ){
            return item.autocorregible && item.corregido;
          };

          this.filterSugeridos = function ( item ){
            return item.autocorregible && !item.corregido;
          };

          this.selectedItem = [];
          this.$scope.$apply();
      }
    }



  }

  // Agrega el componente al modulo principal.
  let app: any = angular.module("PILA");
  app.component("settTableCorrected", {
    bindings: {
      listErrorsContributors: "="
    },
    controller: SettTableCorrectedController,
    templateUrl: "./components/settlement/settlement.table.corrected.html"
  });
}

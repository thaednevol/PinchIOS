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

        private $filter: any;
        static $inject = ["native.file.service", "native.dialog.service", "$filter"];

        constructor(serviceFile, serviceDialog, $filter) {
          this.serviceFile = serviceFile;
          this.serviceDialog = serviceDialog;
          this.$filter = $filter;
        }

        /**
        * @description
        * Realiza el llamado a la ventana para indicar donde se almacena el archivo
        * generado en CSV.
        */
        public actionExportToCsv(): void {
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
            let dataExport = this.$filter("filter")(this.listErrorsContributors.data, { autocorregible: false });
            this.serviceFile.jsonToCsv(pathFile, dataExport, fields);
          });
        }
  }

  // Agrega el componente al modulo principal.
  let app: any = angular.module("PILA");
  app.component("settTableErrors", {
    bindings: {
      listErrorsContributors: "="
    },
    controller: SettErrorsController,
    templateUrl: "./components/settlement/settlement.table.errors.html"
  });
}

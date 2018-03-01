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
    private notificationService:any;

    /**
    * @type {Array} listErrorsContributors - Lista con datos a mostrar en la
    * tabla de errores.
    */
    public listErrorsContributors: any;

    /**
    * @type {Array} listErrors - Lista con datos a mostrar en la
    * tabla de errores.
    */
    public totalCorrecciones: any;

    public totalCorrRealizadas: any;

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

    /**
    * @type {Boolean} showLoading - Indica si debe mostrar la imagen de loading
    * y bloquear la pantalla hasta que espere el usuario que termine la carga
    * del login.
    */
    public showLoading: Boolean = false;

    private idTable:any;

    static $inject = ["native.notification.service","native.file.service", "native.dialog.service","$scope","$rootScope", "$filter"];
    constructor(notificationService,serviceFile, serviceDialog, $scope,$rootScope,$filter) {
      this.notificationService = notificationService;
      this.serviceFile = serviceFile;
      this.$scope = $scope;
      this.$rootScope = $rootScope;
      this.serviceDialog = serviceDialog;
      this.$filter = $filter;
      this.filterCorregidos = function ( item ){
        return item.corregido;
      };

      this.filterSugeridos = function ( item ){
        return item.autocorregible && !item.corregido;
      };

      this.$scope.$on("correct-error", (  ) => {
        this.correctError();
      });

      this.$scope.$on("new-correct-error", (  ) => {
        this.newCorrectError();
      });
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

    public newValidateSelected(): void {
      for (let reg of this.listErrorsContributors.data) {
        if (reg["seleccionado"]) {
          this.selectedItem[reg["secuenciaError"]] = true;
          reg["seleccionado"] = false;
        }
      }
      if (Object.keys(this.selectedItem).length === 0) {
        this.serviceDialog.showDialogError(this.$filter("translate")("ERROR.CONTRIBUTORS.MESSAGE_CORRECTED_WARN_TIT"), this.$filter("translate")("ERROR.CONTRIBUTORS.MESSAGE_CORRECTED_WARN"));
      } else {
        this.serviceDialog.showDialogConfirm(
          this.$filter("translate")("ERROR.CONTRIBUTORS.MESSAGE_CORRECTED_CONF_TIT"),
          this.$filter("translate")("ERROR.CONTRIBUTORS.MESSAGE_CORRECTED_CONF"),
          (option) => {
            if ( option==1 ){
                //this.$scope.$broadcast("new-correct-error");
                this.newCorrectError();
                this.$rootScope.$broadcast("update-totals");
                this.$rootScope.$broadcast("correct-error");
            }
          }
        );
      }
    }

    private newCorrectError() {
      //this.showLoading = true;
      //this.$scope.$apply();
      //si acepta la correccion automatica
      let validarTipo1 = false;
      let lineas = [];
      let campos = [];
      for (var i = 0; i < Object.keys(this.selectedItem).length; i++) {
        let register = this.$filter("filter")(this.listErrorsContributors.data, { secuenciaError: Number(Object.keys(this.selectedItem)[i]) },true);
        register[0].correccion = this.$filter("translate")("ERROR.CONTRIBUTORS.TYPE_AUTOM");
        register[0].corregido = true;
        lineas.push(register[0].linea);
        campos.push(register[0].campo);
        //this.$rootScope.$broadcast("apply-corrections",register[0].linea,register[0].campo);
        validarTipo1 = register[0].linea === 1;
      }
      //aca el broadcast
      this.$rootScope.$broadcast("new-apply-corrections",lineas, campos);
      if ( validarTipo1 ){
        this.$rootScope.$broadcast("validate-register-tp01");
      }
      this.filterCorregidos = function ( item ){
        return item.autocorregible && item.corregido;
      };

      this.filterSugeridos = function ( item ){
        return item.autocorregible && !item.corregido;
      };

      this.selectedItem = [];
      setTimeout(() => {
        this.$rootScope.$broadcast("refresh-contributors");
        //this.$rootScope.$broadcast("refresh-contributors-aut");
      });
      //this.$rootScope.$broadcast("refresh-contributors");
      //this.$rootScope.$broadcast("refresh-contributors-aut");
      this.notificationService.show(this.$filter("translate")("MESSAGES.TITLES.INFO"), this.$filter("translate")("ERROR.CONTRIBUTORS.MESSAGE_CORRECTED_CONF_1"));
      this.$rootScope.$broadcast("refresh-table-corrected");
      //this.showLoading = false;
      //this.$scope.$apply();
  }

    public validateSelected(): void {
      for (let reg of this.listErrorsContributors.data) {
        if (reg["seleccionado"]) {
          this.selectedItem[reg["secuenciaError"]] = true;
          reg["seleccionado"] = false;
        }
      }
      if (Object.keys(this.selectedItem).length === 0) {
        this.serviceDialog.showDialogError(this.$filter("translate")("ERROR.CONTRIBUTORS.MESSAGE_CORRECTED_WARN_TIT"), this.$filter("translate")("ERROR.CONTRIBUTORS.MESSAGE_CORRECTED_WARN"));
      } else {;
        this.serviceDialog.showDialogConfirm(
          this.$filter("translate")("ERROR.CONTRIBUTORS.MESSAGE_CORRECTED_CONF_TIT"),
          this.$filter("translate")("ERROR.CONTRIBUTORS.MESSAGE_CORRECTED_CONF"),
          (option) => {
            if ( option==1 ){
                this.$scope.$broadcast("correct-error");
            }
          }
        );
      }

    }

    private correctError() {
      this.showLoading = true;
      this.$scope.$apply();
      //if (option === 1){
      //si acepta la correccion automatica
      let validarTipo1 = false;
      for (var i = 0; i < Object.keys(this.selectedItem).length; i++) {
        let register = this.$filter("filter")(this.listErrorsContributors.data, { secuenciaError: Number(Object.keys(this.selectedItem)[i]) },true);
        register[0].correccion = this.$filter("translate")("ERROR.CONTRIBUTORS.TYPE_AUTOM");
        register[0].corregido = true;
        this.$rootScope.$broadcast("apply-corrections",register[0].linea,register[0].campo);
        validarTipo1 = register[0].linea === 1;
        //this.$filter("filter")(this.listErrorsContributors.data, { secuenciaError: this.selectedItem)[i] }).correccion = this.$filter("translate")("ERROR.CONTRIBUTORS.TYPE_AUTOM");
        //this.listErrorsContributors.data.filter(secuenciaError:Object.keys(this.selectedItem)[i]).corregido = true;
        //this.listErrorsContributors.data.filter(this.filterSugeridos)[Object.keys(this.selectedItem)[i]].correccion = this.$filter("translate")("ERROR.CONTRIBUTORS.TYPE_AUTOM");
      }
      if ( validarTipo1 ){
        this.$rootScope.$broadcast("validate-register-tp01");
      }
      this.filterCorregidos = function ( item ){
        return item.autocorregible && item.corregido;
      };

      this.filterSugeridos = function ( item ){
        return item.autocorregible && !item.corregido;
      };

      this.selectedItem = [];
      this.$rootScope.$broadcast("refresh-contributors");
      this.$rootScope.$broadcast("refresh-contributors-aut");
      this.notificationService.show(this.$filter("translate")("MESSAGES.TITLES.INFO"), this.$filter("translate")("ERROR.CONTRIBUTORS.MESSAGE_CORRECTED_CONF_1"));
      this.$rootScope.$broadcast("refresh-table-corrected");
      this.showLoading = false;
      this.$scope.$apply();
      //}
  }

  }

  // Agrega el componente al modulo principal.
  let app: any = angular.module("PILA");
  app.component("settTableCorrected", {
    bindings: {
      listErrorsContributors: "=",
      totalCorrecciones: "=",
      totalCorrRealizadas: "=",
      showLoading: "="
    },
    controller: SettTableCorrectedController,
    templateUrl: "./components/settlement/settlement.table.corrected.html"
  });
}

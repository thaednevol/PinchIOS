
namespace app.settlement {

  /**
  * @class SettTableCorrectedController
  * @author Luis Felipe Zapata <lzapta@swat-it.co>
  * @description
  * Carga la información de la tabla de correcciones realizadas
  */
  class SettTableCorrectedController {


    /**
    * @type {Boolean} showLoading - Indica si debe mostrar la imagen de loading
    * y bloquear la pantalla hasta que espere el usuario que termine la carga
    * del login.
    */
    public showLoading: Boolean = false;

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
        return item.autocorregible && item.corregido;
      };

      this.filterSugeridos = function ( item ){
        return item.autocorregible && !item.corregido;
      };

      let ctrl = this;
      let errorContributorsAut="error-contributors-aut";
      $(errorContributorsAut).ready(function() {
        ctrl.copyAndMove(errorContributorsAut);
      });

      let errorContributorsSug="error-contributors-sug";

      $(errorContributorsSug).ready(function() {
        ctrl.copyAndMove(errorContributorsSug);
      });
    }

    private copyAndMove(strTable){
      var currCell = $(strTable+" td").first();
      var ctrlDown = false, ctrlKey = 17, cmdKey = 91, vKey = 86, cKey = 67;

      //$(strTable+" td").css("background-color", "yellow");

      $(strTable+" td").each(function (){
        $(this).attr("tabindex", "1");
      });

      $(strTable+" td").click(function(){
        $(this).focus();
      });

      $(strTable+" td").focusin(function(){
        $(strTable+" td").css("font-weight", "");
        //$(this).css("border", "3px solid");
        //$(this).css("border-color","#5292F7");
        //$(this).css("color","#5292F7 !important");

        //$(this).attr("style","border-color: #5292F7 !important");
        //$(this).attr("style","border: 3px");

        $(this).css("font-weight", "bold");

        currCell = $(this);
      });

      $(strTable+" td").keydown(function(e) {
          if (e.keyCode == ctrlKey || e.keyCode == cmdKey) ctrlDown = true;
            }).keyup(function(e) {
              if (e.keyCode == ctrlKey || e.keyCode == cmdKey) ctrlDown = false;
            });

    $(strTable+" td").keyup(function(e) {
      var c = currCell;
      //$(".error__table-container").css("overflow", "hidden");
        if (e.which == 39) {
            // Right Arrow
            c = currCell.next();
        } else if (e.which == 37) {
            // Left Arrow
            c = currCell.prev();
        } else if (e.which == 38) {
            // Up Arrow
            c = currCell.closest('tr').prev().find('td:eq(' +
              currCell.index() + ')');
        } else if (e.which == 40) {
            // Down Arrow
            c = currCell.closest('tr').next().find('td:eq(' +
              currCell.index() + ')');
        }

        if (c.length > 0) {
          currCell = c;
          currCell.focus();
        }



        if (ctrlDown && (e.keyCode == vKey || e.keyCode == cKey)){
          var textarea = document.createElement("textarea");
          textarea.textContent = $(this).html();
          textarea.style.position = "fixed";  // Prevent scrolling to bottom of page in MS Edge.
          document.body.appendChild(textarea);
          textarea.select();
          try {
              return document.execCommand("copy");  // Security exception may be thrown by some browsers.
          } catch (ex) {
              console.warn("Copy to clipboard failed.", ex);
              return false;
          } finally {
              document.body.removeChild(textarea);
          }
        }
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

    public validateSelected(): void {
      for (let reg of this.listErrorsContributors.data) {
        if (reg["seleccionado"]) {
          this.selectedItem[reg["secuenciaError"]] = true;
          reg["seleccionado"] = false;
        }
      }

      let message = `Se eliminará ${Object.keys(this.selectedItem).length} registro.`;
      if (Object.keys(this.selectedItem).length === 0) {
        this.serviceDialog.showDialogError(this.$filter("translate")("ERROR.CONTRIBUTORS.MESSAGE_CORRECTED_WARN_TIT"), this.$filter("translate")("ERROR.CONTRIBUTORS.MESSAGE_CORRECTED_WARN"));
      } else {
        this.showLoading = true;
        this.serviceDialog.showDialogConfirm(
          this.$filter("translate")("ERROR.CONTRIBUTORS.MESSAGE_CORRECTED_CONF_TIT"),
          this.$filter("translate")("ERROR.CONTRIBUTORS.MESSAGE_CORRECTED_CONF"),
          (option) => {
            if (option === 1) {
              //this.dialogIsOpen = false;
              this.correctError(option);
              this.notificationService.show(this.$filter("translate")("MESSAGES.TITLES.INFO"), this.$filter("translate")("ERROR.CONTRIBUTORS.MESSAGE_CORRECTED_CONF_1"));
              this.$rootScope.$broadcast("refresh-table-corrected");
            }
          }
        );
      }

    }

    private correctError(option) {
      let message = `Opcion seleccionada> ${option}`;
      //si acepta la correccion automatica
      if (option === 1){
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

          this.notificationService.show(this.$filter("translate")("MESSAGES.TITLES.INFO"), this.$filter("translate")("ERROR.CONTRIBUTORS.MESSAGE_CORRECTED_CONF_1"));
          this.selectedItem = [];
          this.$scope.$apply();
          this.$rootScope.$broadcast("refresh-contributors");
          this.$rootScope.$broadcast("refresh-contributors-aut");
      }
      this.showLoading = false;
      this.selectedItem = [];
      this.$scope.$apply();
    }

  }

  // Agrega el componente al modulo principal.
  let app: any = angular.module("PILA");
  app.component("settTableCorrected", {
    bindings: {
      listErrorsContributors: "=",
      totalCorrecciones: "=",
      totalCorrRealizadas: "="
    },
    controller: SettTableCorrectedController,
    templateUrl: "./components/settlement/settlement.table.corrected.html"
  });
}

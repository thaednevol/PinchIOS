
namespace app.settlement {

  /**
  * @class SettContributorsController
  * @author Luis Felipe Zapata <lzapta@swat-it.co>
  * @description
  */
  class SettContributorsController {

    /**
    * @type {Object<name,path,data,origin>} file - Contiene la información del archivo
    * que se carga.
    * @see SettlementController.file
    */
    public file: any = {
      name: "",
      path: "",
      reforma: null,
      data: [],
      origin: []
    };

    /**
    * @type {Object} OPTIONS - Equivale al archivo de opciones del sistema.
    * @see app/webapp/json/data/options.json
    */
    private OPTIONS: any;

    /**
    * @type {Object} selectedItem - Almacena la información de la celdas que
    * se selecciona en el momento.
    */
    public selectedItem: any = {};

    /**
    * @type {Arra} cellNoEditType1 - Son valores fijos que indican que celdas no
    * se les permite la edición.
    */
    public cellNoEditType1: any = [0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 16, 17, 18, 19, 20, 21];
    public cellNoEditType2: any = [0, 1];

    /**
    * @type {Object} filterError - Información de que registros se deben
    * filtrar en la tabla, la función se aplica solo cuando se selecciona
    * registros de las celdas.
    */
    public filterError: any = { linea: 0 };

    /**
    * @type {Array} listErrorsContributors - Datos que se muestran en la tabla.
    */
    public listErrorsContributors: any;

    /**
    * @type {Number} startLimit - Limite de carga de registros en la tabla.
    */
    private startLimit: number = 0;

    private onlyErrors: string = "N";

    /**
    * @type {Class} soiService - Ejecuta el llamado a los metodos JAR de SOI.
    */
    private soiService: any;

    /**
    * @type {Class} serviceSettlement - Servicio de la planilla de liqudiación
    * ejecuta los llamados a los servicios REST.
    */
    private serviceSettlement: any;

    /**
    * @type {Boolean} dialogIsOpen - Indica si la ventana de dialog cualquiera
    * se encuentra abierta para evitar abrir una de nuevo, cuando se cierra
    * la ventana el valor de la variable cambia para poder abrir una de nuevo.
    */
    private dialogIsOpen: boolean = false;

    /**
    * @type {Object} objectFilter - Lista de opciones o palabras para filtrar
    */
    public objectFilter: any = {};

    public onlyErrorsFilter: any = {};

    /**
    * @type {Object<periodPension,periodHealth,totalContributor,totalPay,totalError>}
    * info - información resumida del archivo.
    * @see SettlementController.info
    */
    public info: any = {};

    /**
    * @type {SwatService} swat - Consulta los servicios que utiliza los JAR de
    * Swat para la aplicación.
    * @see app.jar.SwatService
    */
    private swat: any


    /**
    * @type {Object<periodPension,periodHealth,totalContributor,totalPay,totalError>}
    * validationResult - Resultados de la validacion de planilla en SOI
    * @see SettInfoControler.info
    */
    public validationResult: any = {
      error: false,
      errorMessage: "",
      ruafOrBdua: false,
      ruafXlsContent: "",
      bduaXlsContent: "",
      errorXlsContent: "",
      resultMessage: "",
      idTmpPlanilla: 0
    };

    /**
    * @type {Class} dialogService - Ejecuta el llamado a los Dialogs nativos.
    */
    private dialogService;

    /**
    * @type {Class} fileService - Ejecuta el llamado a los Dialogs nativos.
    */
    private fileService;

    private $scope: any;
    private $rootScope: any;
    private $filter: any;

    static $inject = ["jar.swat.service", "jar.soi.service", "settlement.service", "$rootScope", "$scope", "$filter", "OPTIONS", "native.dialog.service", "native.file.service"];

    constructor(swat, soiService, serviceSettlement, $rootScope, $scope, $filter, OPTIONS, dialogService, fileService) {
      this.swat = swat;
      this.fileService = fileService;
      this.soiService = soiService;
      this.serviceSettlement = serviceSettlement;
      this.$scope = $scope;
      this.$rootScope = $rootScope;
      this.$filter = $filter;
      this.OPTIONS = OPTIONS;
      this.dialogService = dialogService;
      this.$scope.$on("line-table-edit-select", (event, line) => {
        line = Number(line) + 2;
        this.filterError = {
          linea: line
        };
      });
    }

    $doCheck() {
      if (this.file.data.regsTp02 && this.objectFilter ) {
        let total: any = this.$filter("filter")(this.file.data.regsTp02.registers, this.objectFilter);
        this.info.totalFilterRegister = total.length;
      }
    }


    /**
    * @description
    * Metodo que permite filtrar unicamente registros con error
    */
    public actionOnlyErrors() {
      if ( this.onlyErrors==="N" ){
        this.onlyErrors = "S";
        this.onlyErrorsFilter = (item,index) => {
                let linea = Number(item["regs1"]);
                return this.file.data.regsTp02.errors.hasOwnProperty(linea);
        };
        /*this.file.data.regsTp02.registers =
          this.$filter("filter")(this.file.data.regsTp02.registers, (item,index) => {
                            let linea = Number(item["regs1"])+2;
                            return this.file.data.regsTp02.errors.hasOwnProperty(linea);
        });*/
      }
      else{
        this.onlyErrorsFilter = function(item){
          return item.regs1!='0'
        };
        this.onlyErrors = "N";
      }

    }

    /*public showOnlyErrors = function(myArray) {
                              return function(item) {
                                if ( this.onlyErrors==="N" ){
                                    return true;
                                }
                                let linea = Number(item["regs1"])+2;
                                return this.file.data.regsTp02.errors.hasOwnProperty(linea);
                              }};*/


    /**
    * @description
    * Metodo que agrega un registro nuevo en la tabla, el registro es agregado
    * al final de la tabla.
    */
    public actionAddRegister() {
      let newRegister: any = {};
      // Se valida la cantidad de registros existentes de usuarios.
      for (let i = 0; i < this.file.data.labelsTp02.length; i++) {
        newRegister[`regs${i}`] = "";
      }
      // Se le asignan los valores por defecto del consecutivo y tipo de registro.
      newRegister["regs0"] = 2;
      newRegister["regs1"] = this.file.data.regsTp02.registers.length + 1;
      this.file.data.regsTp02.registers.push(newRegister);
      let currentPosition = this.file.data.regsTp02.registers.length - 1;
      let params = {
        regTp02: this.soiService.lineRegisterType2ToArray(this.file.data, currentPosition),
        nroLinea: Number(this.file.data.regsTp02.registers[currentPosition]["regs1"]) + 1
      };
      // Se realiza el llamado a un metodo REST definido por SOI para agregar un registro.
      this.serviceSettlement.addRegister(params).get().$promise.then((data) => {
        this.$rootScope.$broadcast("update-totals");
      });
      // Timer para ejecutar el llamado a la función de actualización de cantidad
      // de archivos cargados.
      setTimeout(() => {
        let numberPage = Math.floor((this.file.data.regsTp02.registers.length - 1) / this.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE);
        this.$rootScope.$broadcast("change-page-table", "regsTp02", numberPage, true);
        this.$rootScope.$broadcast("update-info-panel");
      }, 100);
    }

    /**
    * @description
    * Acción de la vista que da la orden de eliminar los registros seleccionados
    * se extrae las keys del modelo de los checkbox y se reinicia la variable.
    * Se le resta 1 para que el registro coincida con la posición en el array.
    */
    public actionDeleteRegister() {
      if (this.dialogIsOpen) return;
      this.dialogIsOpen = true;
      if (Object.keys(this.selectedItem).length === 0) {
        return;
      }
      // Se agerga el mensaje para la ventana de confirmación de eliminar.
      let message = `Se eliminará ${Object.keys(this.selectedItem).length} registro.`;
      if (Object.keys(this.selectedItem).length > 1) {
        message = `Se eliminarán ${Object.keys(this.selectedItem).length} registros.`;
      }
      // Se muestra la ventana de dialog de confirmación de eliminar registros.
      this.dialogService.showDialogConfirm(
        "Eliminar registros",
        message,
        (option) => {
          this.dialogIsOpen = false;
          this.confirmDeleteRegister(option);
        }
      );
    }

    /**
    * @description
    * Valida si la respuesta de la ventana que indica que se debe eliminar los
    * registros es correcta, si lo es procede a eliminar los registros de la
    * tabla y ejecutar de nuevo el calculo de las lineas.
    */
    private confirmDeleteRegister(option) {
      if (option === 1) {
        let positionDelete = [];
        // Se recorre el array de los registros que estan seleccionados para
        // su eliminación.
        for (let i = 0; i < Object.keys(this.selectedItem).length; i++) {
          let key = Object.keys(this.selectedItem)[i];
          if (this.selectedItem[key]) {
            positionDelete.push(parseInt(key) - 1);
          }
        }
        this.selectedItem = {};
        this.deleteItemsArray(positionDelete);
      }
    }

    /**
    * @description
    * Elimina los items con un splice segun la posición del array que se captura
    * con el numero de la secuencia del registro, al terminar cambia los
    * numeros de secuencia de los registros.
    *
    * @param {Array<Number>} positionDelete - Lista de numero de secuencia
    * de registros para eliminar.
    */
    private deleteItemsArray(positionDelete) {
      let arrayDelete = this.file.data.regsTp02.registers;
      // Se recorre el array con la información de los registros a eliminar
      for (let i = 0; i < positionDelete.length; i++) {
        let currentPosition = positionDelete[i] - i;
        let params = {
          regTp02: this.soiService.lineRegisterType2ToArray(this.file.data, currentPosition),
          nroLinea: Number(this.file.data.regsTp02.registers[currentPosition]["regs1"]) + 1
        };
        arrayDelete.splice(currentPosition, 1);
        this.serviceSettlement.removeRegister(params).get();
      }
      // Se asigna un timer para realizar el llamado a los metodos de actualización
      // de datos y numero consecutivo.
      setTimeout(() => {
        this.file.data = this.soiService.changeSequenceRegisterType2(this.file.data, positionDelete[0]);
        this.$scope.$digest();
        this.$rootScope.$broadcast("update-info-panel");
        this.$rootScope.$broadcast("update-totals");
      });
    }

    /**
    * @description
    * Muestra un tooltip con información de la acción que ejecuta el boton.
    */
    public actionShowTooltip(event) {
      let target = event.target.children[0];
      if (target) {
        target.style.display = "block";
      }
    }

    /**
    * @description
    * Oculta el tooltip del boton.
    */
    public actionHideTooltip(event) {
      let target = event.target.children[0];
      if (target) {
        target.style.display = "none";
      }
    }


    public actionSavePlanilla(): void {
      this.$rootScope.$broadcast("save-planilla",this.validationResult.idTmpPlanilla);
      /*let result = this.swat.putPayroll(this.validationResult.idTmpPlanilla);

      result.then((response) => {
        if (response.idNumeroDePlanilla) {
          let messageResult = this.$filter("translate")("SETTLEMENT.CONFIRMATION.SETTLEMENT_CREATED") + response.idNumeroDePlanilla;
          this.validationResult.resultMessage = messageResult;
          this.validationResult.ruafOrBdua = false;
          this.validationResult.error = false;
          this.$rootScope.$broadcast("hide-loading");
        }
      });*/
    }

    /**
    * @description
    * Metodo para descargar un archivo excel generado por la aplicacion y
    * descargado del servidor SOI
    */
    public actionGenerateXls(xlsSelected): void {
      let result = this.dialogService.saveFile("xls");
      if (!result) return;
      result.then((pathFile) => {
        if (!pathFile) return;
        if ( xlsSelected==="BDUA" ){
          this.fileService.createXlsFile(pathFile,this.validationResult.bduaXlsContent);
        }
        else if( xlsSelected=="RUAF" ){
          this.fileService.createXlsFile(pathFile,this.validationResult.ruafXlsContent);
        }
        else if( xlsSelected=="ERROR" ){
          this.fileService.createXlsFile(pathFile,this.validationResult.errorXlsContent);
        }
      });
    }
  }

  // Agrega el componente al modulo principal.
  let app: any = angular.module("PILA");
  app.component("settContributors", {
    bindings: {
      file: "=", // Información del archivo que se edita
      listErrorsContributors: "=",
      validationResult: "=",
      info: "="
    },
    controller: SettContributorsController,
    templateUrl: "./components/settlement/settlement.table.contributors.html"
  });
}

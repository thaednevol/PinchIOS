
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
    * @type {Boolean} selectAll - Indica si esta activo el check de seleccionar todos.
    */
    public selectAll: boolean = false;

    /**
    * @type {Object} selectedItem - Almacena la información de la celdas que
    * se selecciona en el momento.
    */

    public selectedItem: any = {};

    /**
    * Primer elemento del arreglo despues de filtros y ordenamiento
    */
    public firstElement: any;

    /**
    /**
    * @type {Arra} cellNoEditType1 - Son valores fijos que indican que celdas no
    * se les permite la edición.
    */
    public cellNoEditType1: any = [0, 2];
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

    /**
    * @type {boolean} showTable - Permite controlar si se muestra o se oculta la tabla
    */
    public showTable: boolean = false;

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

    public actionShowTable(){
      this.showTable=!this.showTable;
    }

    public validate(){
      this.$rootScope.$broadcast("validate-regstp02");
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
      //Llama a todos los que escuchen este evento para el filtrado
      this.$rootScope.$broadcast("only-errors");
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
    * Metodo que duplica los registros seleccionados en la tabla,
    * los registros duplicados quedan seguidos del "original".
    */
    public actionDuplicateRegister() {
      /** Arreglo de posiciones de registros a duplicar */
      let positionToDuplicate = [];
      /** Secuencia que se va duplicar */
      let position: any = 0
      /** Arreglo de registros a duplicar */
      let newRegister: any = {};
      let key: any;
      for (let reg of this.file.data.regsTp02.registers) {
        if (reg["selected"]) {
          this.selectedItem[reg["regs1"]] = true;
        }
      }
      // Se recorren los registros seleccionados y se agregan a la matriz total
      for (let i = 0; i < Object.keys(this.selectedItem).length; i++) {
        key = Object.keys(this.selectedItem)[i];
        if (this.selectedItem[key]) {
          position = parseInt(key);
          positionToDuplicate.push(position);
          // Vector que se va a duplicar
          this.file.data.regsTp02.registers[position - 1 + i]['selected'] = false;
          angular.copy(this.file.data.regsTp02.registers[position - 1 + i], newRegister);
          this.file.data.regsTp02.registers.splice(position + i, 0, newRegister);
          newRegister = {};
        }
      }
      // Se desmarcan los registros seleccionados
      this.selectedItem = {};
      if (this.selectAll) {
        this.selectAll = false;
      }
      // Se realiza el cambio en las secuencia de los registros
      this.file.data = this.soiService.changeSequenceRegisterType2(this.file.data, positionToDuplicate[0]-1);
      // Se realiza validacion de errores para los registros nuevos duplicados
      for (let j = positionToDuplicate[0]-1; j < this.file.data.regsTp02.registers.length; j++) {
          this.$rootScope.$broadcast("validate-register-table", j);
      }
      // Se asigna un timer para realizar el llamado para actualización de cantidad de archivos cargados.
      setTimeout(() => {
        let numberPage = Math.floor((this.file.data.regsTp02.registers.length - 1) / this.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE);
        this.$rootScope.$broadcast("change-page-table", "regsTp02", numberPage, true);
        this.$rootScope.$broadcast("update-info-panel");
        this.$rootScope.$broadcast("update-totals");
        this.$rootScope.$broadcast("refresh-table-duplicate");
        //this.$scope.$digest();
      });
    }


    /**
    * @description
    * Acción de la vista que da la orden de eliminar los registros seleccionados
    * se extrae las keys del modelo de los checkbox y se reinicia la variable.
    * Se le resta 1 para que el registro coincida con la posición en el array.
    */
    public actionDeleteRegister() {
      for (let reg of this.file.data.regsTp02.registers) {
        if (reg["selected"]) {
          this.selectedItem[reg["regs1"]] = true;
        }
      }
      if (this.dialogIsOpen) return;
      this.dialogIsOpen = true;
      if (Object.keys(this.selectedItem).length === 0) {
        this.dialogIsOpen = false;
        return;
      }
      // Se agerga el mensaje para la ventana de confirmación de eliminar.
      let message = `Se eliminar\u00E1 ${Object.keys(this.selectedItem).length} registro.`;
      if (Object.keys(this.selectedItem).length > 1) {
        message = `Se eliminar\u00E1n ${Object.keys(this.selectedItem).length} registros.`;
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

        /*
         * La aplicación debe validar que al realizar la eliminación de información,
         * se conserve la información de al menos un (1) registro tipo 2.
         * El total de registros del archivo se debe corregir de acuerdo a la
         * eliminación de líneas.
         */

        this.$rootScope.$broadcast("refresh-first-element");

        if (this.firstElement === undefined || this.firstElement === null) {
          this.firstElement = this.file.data.regsTp02.registers[0];
        } else {
          for (let j = 0; j < this.file.data.regsTp02.registers.length; j++) {
            let current = this.file.data.regsTp02.registers[j]["regs1"];
            if (parseInt(current) === parseInt(this.firstElement["3"])) {
              this.firstElement =this.file.data.regsTp02.registers[j];
            }
          }
        }

        let clearFilter = false;
        if (this.file.data.regsTp02.registers.length === Object.keys(this.selectedItem).length) {
          let sec = this.firstElement["regs1"];
          let position = this.file.data.regsTp02.registers.indexOf(this.firstElement);
          if (position !== -1) {
            delete this.selectedItem[this.firstElement["regs1"]];
            this.file.data.regsTp02.registers[position]["selected"] = false;
          } else {
            delete this.selectedItem[1];
            this.file.data.regsTp02.registers[0]["selected"] = false;
          }
          clearFilter = true;
        } else {
          clearFilter = false;
        }

        let arraySeleccionado = [];
        let indexSeleccionado = 0;
        // Se recorre el array de los registros que estan seleccionados para
        // su eliminación.
        for (let i = 0; i < Object.keys(this.selectedItem).length; i++) {
          let key = Object.keys(this.selectedItem)[i];
          if (this.selectedItem[key]) {
            positionDelete.push(parseInt(key) - 1);
           for (let j = 0; j < this.file.data.regsTp02.registers.length; j++) {
              let current = this.file.data.regsTp02.registers[j]["regs1"];
              if (parseInt(current) === parseInt(key)) {
                arraySeleccionado[indexSeleccionado] = this.file.data.regsTp02.registers[j];
                indexSeleccionado++;
              }
            }
          }
        }
        this.selectedItem = {};

         // Prepara datos para mostrar en la tabla de correcciones
        let rowsCorrected: any = Object.keys(this.file.data.regsTp02.corrected);
        let correctedDelete = 0;
        let correccionesEliminadas = [];
        for (let positionRow = 0; positionRow < rowsCorrected.length; positionRow++) {
          let currentRow = rowsCorrected[positionRow];
          let cols: any = Object.keys(this.file.data.regsTp02.corrected[currentRow]);
          for (let positionCol = 0; positionCol < cols.length; positionCol++) {
            let currentCol = cols[positionCol];
            let currentError = this.file.data.regsTp02.corrected[currentRow][currentCol];
            for (let i = 0; i < arraySeleccionado.length; i++) {
              let currentArraySeleccionado = arraySeleccionado[i];
              let linea = parseInt(currentArraySeleccionado.regs1) + 1;
              if ( currentError.nroIdentificacion === currentArraySeleccionado.regs3 && currentError.tipoIdentificacion === currentArraySeleccionado.regs2 ) {
                delete this.file.data.regsTp02.corrected[currentRow][currentCol];
              }
            }
          }
          if (Object.keys(this.file.data.regsTp02.corrected[currentRow]).length === 0) {
            delete this.file.data.regsTp02.corrected[currentRow];
            correccionesEliminadas[correctedDelete] = currentRow;
            correctedDelete++;
          }
        }


        let erroresDelete = 0;
        let erroresEliminadas = [];
        let rows: any = Object.keys(this.file.data.regsTp02.errors);
        for (let positionRow = 0; positionRow < rows.length; positionRow++) {
          let currentRow = rows[positionRow];860507669
          let cols: any = Object.keys(this.file.data.regsTp02.errors[currentRow]);
          for (let positionCol = 0; positionCol < cols.length; positionCol++) {
            let currentCol = cols[positionCol];
            let currentError = this.file.data.regsTp02.errors[currentRow][currentCol];
            for (let i = 0; i < arraySeleccionado.length; i++) {
              let currentArraySeleccionado = arraySeleccionado[i];
              let linea = parseInt(currentArraySeleccionado.regs1) + 1;
              if ( currentError.nroIdentificacion === currentArraySeleccionado.regs3 && currentError.tipoIdentificacion === currentArraySeleccionado.regs2 ) {
                delete this.file.data.regsTp02.errors[currentRow][currentCol];
              }
            }
          }
          if (Object.keys(this.file.data.regsTp02.errors[currentRow]).length === 0) {
            delete this.file.data.regsTp02.errors[currentRow];
            erroresEliminadas[erroresDelete] = currentRow;
            erroresDelete++;
          }
        }
        this.deleteItemsArray(positionDelete);

        //Restablece  los check de selección
        this.selectedItem = {};
        if (this.selectAll) {
          this.selectAll = false;
        }

        //Restablece los filtros
        if (clearFilter) {
          this.$rootScope.$broadcast("clear-filter");
        }

        this.$rootScope.$broadcast("clear-filter-multiple");

        setTimeout(() => {
          if (correccionesEliminadas.length > 0) {

            let filasCorrected: any = Object.keys(this.file.data.regsTp02.corrected);
            let newCorrected = [];
            for (let positionRow = 0; positionRow < filasCorrected.length; positionRow++) {
              let currentCorrected;
              let currentRow = filasCorrected[positionRow];
              if (currentRow !== undefined) {
                let cols: any = Object.keys(this.file.data.regsTp02.corrected[currentRow]);
                for (let positionCol = 0; positionCol < cols.length; positionCol++) {
                  let currentCol = cols[positionCol];
                  let currentError = this.file.data.regsTp02.corrected[currentRow][currentCol];
                  for (let h = 0; h < this.file.data.regsTp02.registers.length; h++) {
                    let current = this.file.data.regsTp02.registers[h];
                    let linea = parseInt(current.regs1) + 1;
                    if (currentError.nroIdentificacion === current.regs3 && currentError.tipoIdentificacion === current.regs2 ) {
                      currentError.linea = linea;
                      currentCorrected = parseInt(current.regs1);
                      let existe = newCorrected[currentCorrected];
                      if ( existe === undefined) {
                        break;
                      }
                    }
                  }
                }
              }
              newCorrected[parseInt(currentCorrected)] = this.file.data.regsTp02.corrected[currentRow];
            }

            this.file.data.regsTp02.corrected = newCorrected;
          }


          let filasErrores: any = Object.keys(this.file.data.regsTp02.errors);
          let newErrores = [];
          for (let positionRow = 0; positionRow < filasErrores.length; positionRow++) {
            let currentCorrected;
            let currentRow = filasErrores[positionRow];
            if (currentRow !== undefined) {
              let cols: any = Object.keys(this.file.data.regsTp02.errors[currentRow]);
              for (let positionCol = 0; positionCol < cols.length; positionCol++) {
                let currentCol = cols[positionCol];
                let currentError = this.file.data.regsTp02.errors[currentRow][currentCol];
                for (let h = 0; h < this.file.data.regsTp02.registers.length; h++) {
                  let current = this.file.data.regsTp02.registers[h];
                  let linea = parseInt(current.regs1) + 1;
                  if (currentError.nroIdentificacion === current.regs3 && currentError.tipoIdentificacion === current.regs2 ) {
                    currentError.linea = parseInt(current.regs1) + 1;
                    currentCorrected = parseInt(current.regs1);
                    let existe = newErrores[currentCorrected];
                    if ( existe === undefined) {
                      break;
                    }
                  }
                }
              }
            }
            newErrores[parseInt(currentCorrected)] = this.file.data.regsTp02.errors[currentRow];
          }

          if (erroresEliminadas.length > 0) {
            this.file.data.regsTp02.errors = newErrores;
          }

        });
        // Se realiza el cambio en las secuencia de los registros
        //this.file.data = this.soiService.changeSequenceRegisterType2(this.file.data, 0);

        // Se asigna un timer para realizar el llamado para actualización de cantidad de archivos cargados.
        setTimeout(() => {

          let numberPage = Math.floor((this.file.data.regsTp02.registers.length - 1) / this.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE);
          this.$rootScope.$broadcast("change-page-table", "regsTp02", numberPage, true);
          this.$rootScope.$broadcast("update-info-panel");
          this.$rootScope.$broadcast("update-totals");
          this.$rootScope.$broadcast("refresh-table-delete");
          this.$rootScope.$broadcast("action-change-page");
          //this.$scope.$digest();


        });
        //this.$rootScope.$broadcast("refresh-table");
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
      let i = 0;
      for (let pos of positionDelete) {
        let currentPosition = pos - i;

        // Si el archivo carga sin correccion se debe buscar la posicion real
        let regs1 = pos + 1;
        let filter = {'regs1': regs1};
        let filterRegs = this.$filter('filter')(arrayDelete, filter);
        let arrayPosition = arrayDelete.indexOf(filterRegs[0]);
        currentPosition = arrayPosition;

        try {
          if (!arrayDelete[arrayPosition]['selected'] || currentPosition >= 0 || !arrayDelete[arrayPosition]) {
            let positionAux = pos + 1;
            for (let j = 0; j < arrayDelete.length; j++) {
              if (arrayDelete[j]['regs1'] === positionAux + "") {
                currentPosition = j;
                break;
              }
            }
          }
        } catch (error) {

        }
        let params = {
          regTp02: this.soiService.lineRegisterType2ToArray(this.file.data, currentPosition),
          nroLinea: Number(this.file.data.regsTp02.registers[currentPosition]["regs1"]) + 1
        };
        arrayDelete.splice(currentPosition, 1);
        this.serviceSettlement.removeRegister(params).get();
        i++;
      }
      // Se asigna un timer para realizar el llamado a los metodos de actualización
      // de datos y numero consecutivo.
      setTimeout(() => {
        this.file.data = this.soiService.changeSequenceRegisterType2(this.file.data, positionDelete[0]);
        this.$scope.$digest();
        this.$rootScope.$broadcast("update-info-panel");
        this.$rootScope.$broadcast("update-totals");
      });
      let result = this.$filter("filter")(this.file.data.regsTp02.registers, this.objectFilter);
      if (result === undefined || result.length === 0) {
        this.objectFilter = {};
      }
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

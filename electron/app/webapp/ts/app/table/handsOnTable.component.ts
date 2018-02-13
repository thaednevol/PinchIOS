namespace app.table {

  /**
  * @class HandsOnTableController
  * @author Edwin Hurtado <ehurtado@lucasian.com>
  * @description
  * Clase encargada de cargar una tabla con las opciones de edición
  * paginado y filtro de contenido de las tablas basado en handsontable.
  */
  class HandsOnTableController {
    /**
    * @type {String[]} labels - Nombre de las columnas
    */
    public labels: any;

    /**
    * @type {String[]} data - Datos que se muestran en la tabla
    */
    public data: any = [{}];

    /**
    * @type {string} idTable - Nombre con el que se identifica la tabla de las otras.
    */
    public idTable: any;

    /**
    * @type {Boolean} activeFilter - Indica si habilita la tabla con filtro de celdas
    */
    public activeFilter: boolean = false;

    /**
    * @type {Boolean} editTable - Indica si la tabla esta activa para editar el contenido.
    */
    public editTable: boolean = true;

    /**
    * @type {Boolean} fixedColumns - Indica si se deben fijar las dos columnas iniciales,
    * el numero de linea y la casilla para seleccionar.
    */
    public fixedColumns: boolean = false;

    /**
    * @type {Object<Number, Boolean>} selectedItem - Almacena el numero de
    * secuencia del input y si se selecciono.
    */
    public selectedItem: any = {};

    /**
    * @type {Boolean} selectAll - Indica si esta activo el check de seleccionar todos.
    */
    public selectAll: boolean = false;

    /**
    * @type {Array} cellNoEdit - Lista de celdas que nos e editan.
    */
    public cellNoEdit: any = [];

    /**
    * @type {Boolean} activeSubMenu - Indica si esta activo el submenu.
    */
    public activeSubMenu: boolean = false;

    /**
    * @type {number} page - Guarda la página actual
    */
    private page:number = 1;


   /**
    * @type {Object} objectFilter - Lista de opciones o palabras para filtrar
    */
    public objectFilter: any = {};
    public onlyErrorsFilter: any = {};

    public firstElement: any =  null;

    /**
    * @type {Boolean} replaceActive - Indica si se debe hacer visible la opción
    * de reemplazar el contenido de todas las celdas.
    */
    public replaceActive: boolean = false;

      /**
      * @type {Object} hotElement - Elemento del DOM que tiene la tabla
      */
      public hotElement:any;

      /**
      * @type {Object} hotTable - Objeto de la tabla
      */
      public hotTable:any;

      /**
      * @type {Boolean} renderedTable - Indica si la tabla ya se renderizó en
      * el DOM
      */
      private renderedTable:boolean = false;

      /**
      * @type {Object} hotData - Guarda los datos de la tabla
      */
      private hotData:any;

      /**
      * @type {number} startLimit - Limite inferior de registros mostrados
      */
      private startLimit:number = 0;

      /**
      * @type {number} numRegisters - Número de registros actuales
      */
      private numRegisters:number = 0;

      /**
      * @type {number} currentNumberRegisterLoad - Número de registros mostrados
      */
      private currentNumberRegisterLoad:number = 0;

      /**
    * @type {NativeNotificationService} notificationService - Servicio que
    * permite mostrar notificaciones de forma nativa en el SO.
    * @see app.native.NativeNotificationService
    */

    private notificationService:any;

      /**
      * @type {Object} OPTIONS - Guarda las opciones de la aplicación
      */
      private OPTIONS:any;

      private $scope: any;
      private $rootScope: any;
      private $filter: any;
      static $inject = ["$scope", "$rootScope", "$filter", "OPTIONS", "native.notification.service"];

      private hc:HotConfigs;

      constructor($scope, $rootScope, $filter, OPTIONS, notificationService) {
        this.$scope = $scope;
        this.$rootScope = $rootScope;
        this.$filter = $filter;
        this.OPTIONS = OPTIONS;
        this.notificationService=notificationService;

        this.$scope.$on("rebuild-table", () => {
          this.hc=new HotConfigs(this);
          this.rebuildTable();
        });

        this.$scope.$on("refresh-table", () => {
          if (this.hotTable !== undefined) {
            this.hotTable.render();
          }
        } );

        this.$scope.$on("refresh-table-duplicate", () => {
          if (this.hotTable) {
            this.hotTable.render();
          }
          try {
            this.hotTable.updateSettings({
              data: this.hc.getData()
            });
          } catch (error) {
          }
        });

        this.$scope.$on("refresh-table-delete", () => {
          //Se comenta por error Invalid attempt to destructure non-iterable instance[object Object] handsontable
          try {
            this.hotTable.updateSettings({
              data: this.hc.getData()
            });
          } catch(err) {

          if (this.hotTable) {
            this.hotTable.render();
          }

          if (this.idTable === "regsTp02" ) {
            var filter = this.hotTable.getPlugin('filters');
            filter.filter();
            var dataQue = this.hotTable.getData();
            var longitud = this.hotTable.getData().length;
            if (longitud === 0) {
              filter.clearConditions();
              filter.filter();
            }

          }

        }


        });

        this.$scope.$on("refresh-table-corrected", () => {
          //Se comenta por error Invalid attempt to destructure non-iterable instance[object Object] handsontable

          if(this.idTable === "errorConAut"  ){
            this.page=1;

            try {
            this.hotTable.updateSettings({

              data: this.hc.getData()
            });
          } catch(err) {
            if (this.hotTable) {
              this.hotTable.render();
            }
          }

          var valo= this.hotTable.getData().length;
          if(valo === 0){
             this.currentNumberRegisterLoad=0;
             this.numRegisters=0;
             this.startLimit=0;
            }
          }

        });

        this.$scope.$on("refresh-first-element", () => {
          if(this.idTable === "regsTp02"  ){
            this.firstElement=null;
            this.firstElement=this.hc.getFirstElement();
            if (this.hotTable) {
              this.hotTable.render();
            }

            try {
              this.hotTable.updateSettings({
                firstElement: this.hc.getFirstElement()
              });
            } catch (error) {
            }
          }
        });

    }

  $onInit() {

  }

  /**
  * @description
  * Realiza el cambio de la pagina de la tabla.
  */
  private actionChangePage(orientation) {
      let pagination=this.hc.getPagination();
      let ctrl=this;
      if (ctrl){
        if (pagination.enablePag){
          if (pagination.numReg) {
            let maxPage=Math.ceil(pagination.numReg/pagination.limitShown);
            if ((ctrl.page>0) && (ctrl.page<=maxPage)){
              if (orientation === "next"  && ctrl.page<maxPage){
                  ctrl.page++;
              }
              if (orientation === "prev"  && ctrl.page>1){
                  ctrl.page--;
              }

              if (orientation!==""){
                if (ctrl.hotTable && ctrl.hc){
                  let clicked=ctrl.page;
                  let ht=ctrl.hotTable;
                  this.hotTable.updateSettings({
                    hiddenRows: ctrl.hc.getHiddenRows(clicked)
                  });
                  ctrl.hotTable.render();
                }
              }
              ctrl.currentNumberRegisterLoad = ctrl.page * pagination.limitShown;
              ctrl.startLimit = (ctrl.page-1)*pagination.limitShown;
              ctrl.numRegisters = pagination.numReg;
            }
          }
        }
      }

      let phase = this.$rootScope.$$phase;
      if(phase != '$apply' && phase != '$digest') {
          this.$scope.$apply();
      }

      this.$rootScope.$broadcast("action-change-page",orientation);
    }

    private fillTable(){
      var ctrl = this;
      var myData = this.data;
      var myRootScope = this.$rootScope;

      this.hc.registerRenderers();
      this.hc.registerValidators();
      //this.hc.registerHooks();
      //this.hc.registerEvents();
      let hotSettings:any= this.hc.getHotSettings();

        this.hotTable = new Handsontable(this.hotElement, hotSettings);
        this.hotTable.validateCells(function(valid) {});
        $("#hot-display-license-info").hide();
        if(hotSettings.tableId === "errorConAut" || hotSettings.tableId ===  "errorContributors") {
          //this.fillTableCorrected();
        }
    }

    private fillTableCorrected(){
      var ctrl = this;
      var myData = this.data;
      var myRootScope = this.$rootScope;

      var varFixedColumns:any=this.hc.getVarFixedColumns();
      let columnDef:any=this.hc.getColumnDef();
      let labelsDef:any=this.hc.getLabelsDef();

      var hotSettings = {
              tableId:this.idTable,
              data: this.hc.getData(),
              language:"es-CO",
              stretchH: 'all',
              autoWrapRow: true,
              fixedColumnsLeft: varFixedColumns,
              rowHeaders: false,
              colHeaders: labelsDef,
              fillHandle: {
                autoInsertRow: false
              },
              afterGetColHeader: function (col, TH) {
              },
              columns: columnDef,
              manualRowResize: true,
              manualColumnResize: true,
              manualRowMove: true,
              manualColumnMove: true,
              renderAllRows: true,
              contextMenu: true,
              filters: this.activeFilter,
              scrollToSelection: true,
              licenseKey: '05ea7-d0139-2af62-34f15-ce322'
        };

      this.hotTable = new Handsontable(this.hotElement, hotSettings);

      this.hc.registerHooks();
      this.hc.registerRenderers();
      this.hc.registerEvents();

      this.updateSettings(ctrl);

    }

      private updateSettings(ctrl){
        this.hotTable.updateSettings({
            columnSorting: this.hc.getColumnSorting(),
            sortIndicator: this.hc.getSortIndicator(),
            height: this.hc.getHeight(),
            dropdownMenu:this.hc.getDropDownMenu(),
            contextMenu:this.hc.getContextMenu(),
            hiddenRows: this.hc.getHiddenRows(1),
            afterFilter:this.hc.afterFilter(),
            afterColumnSort: this.hc.afterColumnSort(),
            beforeChange:function(changes, source) {
                if (source === 'Autofill.fill' && (typeof changes[0][2]  === "boolean")) {
                    if ( !(typeof changes[0][3]  === "boolean") ){
                        return false;
                    }
                }
                // Para que no se puedan copiar y pegar valores en la columna
                // Selección, que contiene valores Booleanos.
                if (source === 'CopyPaste.paste' && (typeof changes[0][2] === "boolean")) {
                  if (!(typeof changes[0][3] === "boolean")) {
                    return false;
                  }
                }
                // Valida que cuando se copia y pega al final de la tabla
                // no se creen registros nuevos.
                if (source === 'CopyPaste.paste') {
                  if (changes[changes.length - 1][2] === null) {
                    return false;
                  }
                }
            },
            afterChange: this.hc.afterChange(),
            afterOnCellMouseDown: this.hc.afterOnCellMouseDown(),
            cells: this.hc.getCells()
        });

        this.hc.updateSettings();

        ctrl.hotTable.render();
      }

    public rebuildTable() {
      let hotId='#hot-'+this.idTable;
      this.hotElement=document.querySelector(hotId);
      if (this.hotElement){
        if (!this.renderedTable){
          this.renderedTable=true;
          this.fillTable();
        }
      }
    }

    /**
    * @description
    * Actualiza la data segun el modelo
    */
    public refreshTable() {
      this.hotTable.render();
    }

    private replaceAll(str, find, replace) {
        return str.replace(new RegExp(find, 'g'), replace);
    }
  }

      let app: any = angular.module("PILA");
      app.component("handsOnTable", {
          bindings: {
              labels: "<", // Nombre de las columnas
              data: "=", // Registros que debe tener la tabla.
              idTable: "<", // El id con el que se identifica la tabla como unica.
              activeFilter: "<", // indica si se usa el filtro por columnas en la tabla.
              editTable: "<", // Indica si la tabla se le permite editar la información.
              fixedColumns: "<", // Indica si se insertan dos columnas fijas, de seleccion y linea.
              selectedItem: "=", // Lista para indicar que inputs se seleccionan
              selectAll: "=", // Para indicar que si se seleccionaron todos los registros
              firstElement: "=?", // Para indicar el primer elemento del arreglo
              cellNoEdit: "<", // Indica que celdas de la tabla no se pueden editar.
              activeSubMenu: "<", // Indica si se debe activar la opción del submenu en la tabla
              objectFilter: "=", // Almacena la información de los registros visualizados en el filtro.
              onlyErrorsFilter: "=", // Almacena la información de los registros visualizados en el filtro.
              replaceActive: "<" // Indica si se debe reemplzar el contenido con el filtro
            },
    controller: HandsOnTableController,
    templateUrl: "./components/table/handsOnTable.html"
  });
}

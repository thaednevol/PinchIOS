
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
      * @type {number} startLimit - Limite inferior de registros mostrados
      */
      private startLimit:number = 0;

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
          this.rebuildTable();
        });

        this.$scope.$on("refresh-table", () => {
          if (this.hotTable !== undefined) {
            this.hotTable.render();
          }
        } );

        this.$scope.$on("refresh-table-duplicate", () => {
          console.log("refresh-table-duplicate");
          this.hotTable.render();
          this.hotTable.updateSettings({
            data: this.hc.getData()
          });
        });

        this.$scope.$on("refresh-table-delete", () => {
          console.log("refresh-table-delete");
          this.hotTable.render();
          /*
          Se comenta por error Invalid attempt to destructure non-iterable instance[object Object] handsontable
          this.hotTable.updateSettings({
            data: this.getData()
          });
          */
        });

        this.$scope.$on("hide-loading", () => {
          console.log("HIDE-LOADING");
          this.rebuildTable();
        });

        console.log("JQUERY");
        console.log($('#'+this.idTable));
        console.log(this.idTable);
      }

  /**
  * @description
  * Realiza el cambio de la pagina de la tabla.
  */
  // private actionChangePage(orientation) {
  //   console.log("actionChangePage");
  //   var ctrl=this;

  //   var maxPage=Math.ceil(this.data.registers.length/this.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE);
  //   if ((this.page>0) && (this.page<=maxPage)){
  //     if (orientation === "next"  && this.page<maxPage){
  //         this.page++;
  //     }
  //     if (orientation === "prev"  && this.page>1){
  //         this.page--;
  //     }

  //     var clicked=ctrl.page;
  //     this.hotTable.updateSettings({
  //       hiddenRows: this.hc.getHiddenRows(clicked)
  //     });
  //     this.$rootScope.$broadcast("action-change-page");
  //   }
  // }



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
                  if (pagination.pageByPage !== undefined && pagination.pageByPage) {
                    console.log("paginacion por pagina habilitada");
                    let borrame = pagination.dataTmp;
                    if (this.hotTable) {
                      this.hotTable.updateSettings({
                        data: pagination.dataTmp
                      });
                    }
                  }
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


      }




    public rebuildTable() {
      var hotId='#hot-'+this.idTable;
      this.hotElement=document.querySelector(hotId);
      if (this.hotElement){
        if (!this.hc){
          this.hc=new HotConfigs(this);
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

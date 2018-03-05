namespace app.table {

  /**
  * @class HandsOnTableController
  * @author Edwin Hurtado <ehurtado@lucasian.com>
  * @description
  * Clase encargada de cargar una tabla con las opciones de edición
  * paginado y filtro de contenido de las tablas basado en handsontable.
  */
  export class HotRegsTp2 extends HotDefault{
    /**
    * @type {string} onlyErrors: Permite identificar si está filtrado por errores
    */
    private onlyErrors: string = "N";

    public firstElement: any =  null;

    /**
    * @type {array} errors: Guarda los errores
    */
    private errors:any=new Array();

    /**
    * @type {number} numeroErrores - Guarda el número de errores encontrados
    */
    public numeroErrores = 0;

    public columGeneral = 0;

    /**
    * @type {number} trSelected - Guarda la fila seleccionada
    */
    public trSelected = -1;

    /**
    * @type {Array} rowsValidated - Guarda las filas validadas
    */
    private rowsValidated= new Array();

    /**
    * @type {boolean} validarAlIniciar - Valida los registros al iniciar
    */
    private validarAlIniciar:boolean;

    /**
    * @type {boolean} validarAlVisualizar - Valida los registros cuando se
    * visualizan (true) o todos al cargar (false)
    */
    private validarAlVisualizar;

    public tmpRegs: any;

    private showItemBar:boolean=false;

    /**
    * @type {Object} barError - Objecto que permite guardar la barra de error
    */
    private barError:any;

    constructor(hotComponent) {
      super(hotComponent);
      this.hotComponent=hotComponent;
      let ctrl=this;

      // Escucha el evento only-errors del controlador principal
      this.hotComponent.$scope.$on("only-errors", () => {
        // Compara si todos los registros están validados
        if (ctrl.rowsValidated.length===ctrl.getData().length){
          ctrl.actionOnlyErrors();
        }
        // Si no están validados, los manda a validar
        else{
          ctrl.validateAll();
          let listRegVal=this.hotComponent.$scope.$on("all-registers-validated", () => {
            ctrl.actionOnlyErrors();
            listRegVal();
          });
        }
      });

      this.hotComponent.$scope.$on("action-change-page", () => {
        ctrl.validate();
      });


      this.hotComponent.$scope.$on("validate-regstp02", () => {
        ctrl.validate();
      });

      this.hotComponent.$scope.$on("correct-error",()=>{
        // Al reiniciar los dos arreglos, vuelve a validar cuando cargue
        ctrl.rowsValidated=new Array();
        ctrl.errors=new Array();
        $('#barra-errores').empty();
      });

      if (localStorage.getItem('validar_al_iniciar') === null) {
        ctrl.validarAlIniciar = JSON.parse("true");
      } else {
        ctrl.validarAlIniciar = (localStorage.getItem('validar_al_iniciar')=='true');
      }

      if (localStorage.getItem('validar_al_visualizar') === null) {
        ctrl.validarAlVisualizar = JSON.parse("false");
      } else {
        ctrl.validarAlVisualizar = (localStorage.getItem('validar_al_visualizar')=='true');
      }
    }

    public getHotSettings(){
      let ctrl=this;
      let hotsettings = super.getHotSettings();
      hotsettings['afterChange'] = this.afterChange();
      hotsettings['afterRender'] = this.afterRender();
      hotsettings['colWidths']=this.colWidths();
      hotsettings['afterBeginEditing']=this.afterBeginEditing();
      hotsettings['beforeChange']=this.beforeChange();
      hotsettings['beforeValidate']=this.beforeValidate();
      hotsettings['afterColumnSort']=this.afterColumnSort();
      hotsettings['afterFilter']=this.afterFilter();
      return hotsettings;
    }

    private beforeChange(){
      return function(changes, source) {
        try {
          for (let change of changes) {
            if ((change[1] === "selected") && (typeof change[2]  === "boolean") && (typeof change[3]  !== "boolean")) {
              if (change[3] === "") {
                // Supr
                change[3] = false;
              } else {
                change[3] = change [2];
              }
            }
          }
        } catch (error) {
          console.log("Error en beforeChange() de HotRegsTp2 por columna \"selected\"");
        }
      };
    }


    private beforeValidate(){
      let ctrl=this;
      let all=false;
      let myFunc=function(value,row,prop,source){
        // Valida si la celda ya existe en el arreglo de celdas validadas
        if (ctrl.rowsValidated.length!==ctrl.getData().length){
          ctrl.rowsValidated.indexOf(Number(row)) === -1 ? ctrl.rowsValidated.push(Number(row)) : null;
        }
        else {
          ctrl.hotComponent.$rootScope.$broadcast("all-registers-validated");
        }
      }
      return myFunc;
    }

    public getData(){
      return this.hotComponent.data.registers;
    }

    public getColumnSorting(){
        return true;
    }

    public getSortIndicator(){
        return true;
    }

    public getHeight(){
      return 275;
    }

    public getColumnDef(){
      var columnDef=[];
      columnDef = [
        {data: "line", type:"numeric", readOnly: true,validator:'registerValidator', invalidCellClassName:'fa fa-times-circle-o line-error'},
        {data: "selected", type: 'checkbox', className: "htCenter", sortFunction:this.sortFunction()}
      ];

      if (this.hotComponent.data.registers[0]) {
        for(let i of Object.keys(this.hotComponent.data.registers[0])) {
          if (i.startsWith("regs")) {
            // Columnas Tipo Registro (regs0) y Secuencia (regs1), deben ser de solo lectura
            if (i === "regs0" || i === "regs1") {
              columnDef.push({data: i, type: 'numeric',validator:'registerValidator', invalidCellClassName:'table__data-field--error', readOnly: true});
            } else {
              columnDef.push({data: i, type: 'text',validator:'registerValidator', invalidCellClassName:'table__data-field--error'});
            }
          }
        }
      }
      return columnDef;
    }

    public getVarFixedColumns(){
      if (this.hotComponent.fixedColumns)
        return 2;

      return 0;
    }

    public sortFunction(){
      return function(sortOrder) {
        return function(a, b) {
          let newA = a[1];
          let newB = b[1];
          // POR ALGUNA RARA RAZON, SE PUEDE COMPARAR DOS BOOLEANOS Y UNO ES MAS
          // GRANDE QUE EL OTRO
          if (newA < newB) {
            return sortOrder ? -1 : 1;
          }
          if (newA > newB) {
            return sortOrder ? 1 : -1;
          }
          return 0;
        }
      }
    }

    public getLabelsDef(){
      let fixArray = [this.hotComponent.$filter("translate")("SETTLEMENT.TABLES.LABELS.LINE"), this.hotComponent.$filter("translate")("SETTLEMENT.TABLES.LABELS.SELECTION")];
      return fixArray.concat(this.hotComponent.labels);
    }

    public getDropDownMenu(){
      var ctrl=this;
      return {
        callback: function (key, options) {
          if (key === 'toggle_all') {
            setTimeout(function () {
              ctrl.hotComponent.selectAll=!ctrl.hotComponent.selectAll;
              ctrl.toogleAll();
            }, 100);
          }
          if (key==='replace'){
            var opt={"col":ctrl.hotComponent.hotTable.getSelected()[1]};
            this.columGeneral = opt["col"];
            if (this.columGeneral > 3) {
              ctrl.createDialog(opt,ctrl.hotComponent);
            }
          }
          if (key==='filter_by_error'){
            ctrl.actionOnlyErrors();
          }
          ctrl.hotComponent.$rootScope.$broadcast("cargado_menu");
        },
        items: {
          'filter_action_bar':{},
          "filter_by_condition":{},
          "filter_by_value":{},
          "filter_by_error":{name:"Mostrar errores"},
          '---------':{},
          "replace":{name:"Reemplazar"},
          "toggle_all":{name:"Sel/Des todos",disabled: function () {
            //let datosSeleccionados = ctrl.hotComponent.hotTable.getData();
            return ctrl.hotComponent.hotTable.getSelected()[1] !== 1;
            //return ctrl.hotComponent.hotTable.getData()[1] !== 1;
            }
          }
        }
      };
    }

    public getContextMenu(){
      var ctrl=this;
      return {
          callback: function (key, options) {
            if (key === 'borrar') {
              setTimeout(function () {
                var selection = ctrl.hotComponent.hotTable.getSelected();
                for (var fil = selection[0];fil <= selection[2]; fil++) {
                  for (var col =selection[1]; col <= selection[3]; col++) {
                    if (col > 3) {
                      ctrl.hotComponent.hotTable.setDataAtCell(fil, col, "");
                    }
                    if (col === 1) {
                      ctrl.hotComponent.hotTable.setDataAtCell(fil, col, false);
                    }
                  }
                }
              }, 100);
            }
          },
          items: {
            "borrar": {name: 'Borrar contenido'}
          }
        };
    }

    private createDialog(options,ctrl) {
      $("#diag-replace-"+ctrl.idTable).dialog({modal: true,width:'auto',
      close: function(event, ui) {
        $("#ta-replace-"+ctrl.idTable).val("");
        $("#in-replace-"+ctrl.idTable).val("");
        $("#vacios-"+ctrl.idTable).prop("checked", false);
        }});

        $("#ta-replace-"+ctrl.idTable).focusin(function(){
          $("#diag-replace-message-"+ctrl.idTable).hide();
        });
        $("#in-replace-"+ctrl.idTable).focusin(function(){
          $("#diag-replace-message-"+ctrl.idTable).hide();
        });

        //var fil=options.fil;
        //var col=options.col;
        var col = ctrl.hotTable.columGeneral;

        $("#btn-replace-"+ctrl.idTable).click(function() {
          var orig=$("#ta-replace-"+ctrl.idTable).val();
          var dest=$("#in-replace-"+ctrl.idTable).val();
          var vacios = $("#vacios-"+ctrl.idTable).is(":checked");
          var reemplazoValido = true;
          if(!vacios && dest === "") {
            reemplazoValido = false;
          }

          if (orig !== "" && reemplazoValido) {
            var arrOrig=ctrl.replaceAll(orig,' ',"#-#").split("\n");
            var datosTabla = ctrl.data.registers;
            var datosTablaTmp = ctrl.hotTable.getData();
            for (var k = 0; k < arrOrig.length; k++){
              var value=arrOrig[k];
              //for (var i = 0; i < ctrl.hotTable.getData().length; i++){
              for (var i = 0; i < datosTablaTmp.length; i++){
                var currenFil = ctrl.hotTable.columGeneral;
                  //var str = datosTabla[i][currenFil];
                  //var str = datosTablaTmp[i][ctrl.hotTable.columGeneral];
                  var currentIndice = Number(datosTablaTmp[i][0]) - 2;
                  var str = datosTabla[currentIndice][`regs${ctrl.hotTable.columGeneral-2}`];
                  //var currentRegister = datosTabla[currentIndice];
                  var newstr="";
                  if (value==="#-#"){
                    if (str.trim().length === 0) {
                        //ctrl.hotTable.setDataAtCell(i,ctrl.hotTable.columGeneral,dest);
                        datosTabla[currentIndice][`regs${ctrl.hotTable.columGeneral-2}`] = dest;
                        //currentRegister[`regs${ctrl.hotTable.columGeneral-2}`] = dest;
                        //datosTablaTmp[i][ctrl.hotTable.columGeneral] = dest;
                        //ctrl.hotTable.setDataAtCell(i,ctrl.hotTable.columGeneral,dest);
                    }
                  }
                  else {
                      if (str !== null) {
                        newstr = str.replace(new RegExp(value.trim(), 'g'), dest);
                        datosTabla[currentIndice][`regs${ctrl.hotTable.columGeneral-2}`] = newstr;
                        //currentRegister[`regs${ctrl.hotTable.columGeneral-2}`] = newstr;
                        //datosTablaTmp[i][ctrl.hotTable.columGeneral] = newstr;
                        //ctrl.hotTable.setDataAtCell(i,ctrl.hotTable.columGeneral,newstr);
                      }
                    }
                  }
                }
                ctrl.hotTable.render();
                $("#diag-replace-"+ctrl.idTable).dialog('close');
                $("#diag-replace-"+ctrl.idTable).dialog('destroy');
            } else {
              //alert("Debe ingresar el valor a buscar y el valor a reemplazar para poder ejecutar la accion.");
              $("#diag-replace-message-"+ctrl.idTable).show();
            }
      });
    }

    public getArray(clicked){
      var arr = [];
      var rowsOnSinglePage=this.hotComponent.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE;
      var newDataSet = this.getData();
        if (clicked === 1) {
          for (var i = (clicked * rowsOnSinglePage); i < newDataSet.length; i++) {
            arr.push(i);
          }
        }
        else {
          for (var j = 0; j < (clicked * rowsOnSinglePage) - rowsOnSinglePage; j++) {
            arr.push(j);
          }
          for (var i = (clicked * rowsOnSinglePage); i < newDataSet.length; i++) {
            arr.push(i);
          }
        }
        return arr;
    }

    public getHiddenRows(clicked){
      return {
        rows:this.getArray(clicked),
        indicators:false
      }
    }

//getCells() no estaba siendo usado. Se reemplaza por registerValidator

    public afterFilter(){
      let ctrl=this;
      if (this.hotComponent && this.hotComponent.hotTable){
        this.checkEmpty();
        this.refreshPaging();
        ctrl.updateItemErrorBar();
      }
    }

//afterOnCellMouseDown() no estaba siendo usado (se reemplaza por
//afterBeginEditing con doble click)

    public afterBeginEditing(){
      let ctrl=this;
      return function(row,col){
        let cs=ctrl.hotComponent.hotTable.getCellMeta(row, col);
        let linePosition=cs.row;
        ctrl.hotComponent.$rootScope.$broadcast("refresh-contributors-table", linePosition + 2);
      }
    }

    public afterChange(){
      let ctrl=this;
      return function (changes, source) {
        if (changes != null) {
          for (var fil = 0; fil < changes.length; fil++) {
            if (changes[fil][1] !== "selected") {
              if (changes[fil][2] !== changes[fil][3]) {
                let row=changes[fil][0];
                let col=changes[fil][1];
                let cs=this.getCellMeta(row,col);
                let realRow=cs.row;
                ctrl.hotComponent.$rootScope.$broadcast("validate-register-table",realRow);
                  let deregisterListener=ctrl.hotComponent.$scope.$on("setnumRegisters", () => {
                  let rowsToValidate = new Array();
                  rowsToValidate.push(Number(row));
                  ctrl.hotComponent.hotTable.validateRows(rowsToValidate, function(valid) {});
                  deregisterListener();
                });
              }
            }
          }
        }
      }
    }

    private checkEmpty(){
      if (this.hotComponent.hotTable.countRenderedRows()===0){
        this.hotComponent.notificationService.show(this.hotComponent.$filter("translate")("MESSAGES.TITLES.INFO"),
          this.hotComponent.$filter("translate")("MESSAGES.WARNINGS.NO_RESULTS"));
      }
    }

    private refreshPaging() {
      this.hotComponent.hotTable.updateSettings({
        hiddenRows: this.getArray(1),
      });
    }

    /**
    * @description
    * Inicia el proceso de carga de la barra de error de la tabla de liquidación.
    */
    private updateItemErrorBar(){
      let barErrorItems: any = document.getElementsByClassName("table__scroll-error-item");
      let itemsError=new Array();
        for (let i = 0; i < barErrorItems.length; i++) {
            itemsError.push(barErrorItems[i].getAttribute("line"));
        }
        $('#barra-errores').empty();
        for (let i=0; i<itemsError.length;i++){
            this.createItemError(itemsError[i]);
        }
    }

    private deleteItemError(row){
      $('div[line="'+row+'"]').remove();
    }

  private createItemError(row){
    let ctrl=this;
    if (!this.barError){
      this.barError=this.getBarError();
    }
    let visualRow=ctrl.hotComponent.hotTable.toVisualRow(Number(row));
      let rows=ctrl.hotComponent.hotTable.countRows();
      let delta=$(this.barError).height()/rows;
      let item = this.buildItem();
      item.setAttribute("line", String(row));
      let columnSettings=ctrl.hotComponent.hotTable.getCellMeta(Number(row),0);
      let pos=visualRow*delta;
      item.style.top = `${pos}px`;
    item.addEventListener("click", (event) => {
        let target: any = event.target;
        let line = target.getAttribute("line");
        setTimeout(() => {
          let arrCS=ctrl.hotComponent.hotTable.getCellMetaAtRow(Number(line));
          let newRow=0;
          let newCol=0;
          for (let i=1; i<arrCS.length; i++){
            if (!arrCS[i].valid){
              newRow=arrCS[i].visualRow;
              newCol=arrCS[i].visualCol;
              break;
            }
          }
          ctrl.hotComponent.hotTable.scrollViewportTo(newRow,newCol);
          ctrl.hotComponent.hotTable.selectCell(newRow,newCol, newRow,newCol, false);

            $(".currentRow").effect("highlight", {color:"red"}, 3000);
        }, 100);
      });
      this.barError.appendChild(item);
  }

    /**
    * @description
    * Metodo que permite filtrar unicamente registros con error
    */
    public actionOnlyErrors() {
      let ctrl=this;
      const filtersPlugin = ctrl.hotComponent.hotTable.getPlugin('filters');
      const arrayEach = Handsontable.helper.arrayEach;
      filtersPlugin.removeConditions(0);

      if ( this.onlyErrors === "N" ) {
        this.onlyErrors = "S";
        let conditions=new Array();
        filtersPlugin.addCondition(0, 'by_value', [ctrl.errors]);
        $("#onlyErrorsIcon").css("color", "rgb(117, 129, 140)");
      } else {
        $("#onlyErrorsIcon").css("color", "rgb(255, 66, 66)");
        this.onlyErrors = "N";
      }
      filtersPlugin.filter();
      ctrl.updateItemErrorBar();
    }

    private validateAll(){
      let ctrl=this;
      ctrl.hotComponent.hotTable.validateCells(function(valid) {});
    }

    private validate(){
      // METODO PARA VALIDAR
      let ctrl=this;
      function validar(rowsToValidate):Promise<any> {
        return new Promise<any>(resolve => {
          ctrl.hotComponent.hotTable.validateRows(rowsToValidate, function(valid) {});
          resolve();
        });
      }

      async function validarLote(): Promise<void> {
        let plugin=ctrl.hotComponent.hotTable.getPlugin('autoRowSize');
        let inf=plugin.getFirstVisibleRow();
        let sup=plugin.getLastVisibleRow();
        if (inf!=-1 && sup!=-1){
          let rowsToValidate=new Array();
          for(let i=inf; i<=sup;i++){
            if(ctrl.rowsValidated.indexOf(Number(i)) === -1){
              rowsToValidate.push(Number(i))
            }
          }
          if (rowsToValidate.length>0){
            await validar(rowsToValidate);
          }
        }
      }
      // SI SE VALIDA AL VISUALIZAR, cada vez que se hace scroll, valida
      if (this.validarAlVisualizar){
        validarLote();
      }
      // SI NO, valida todo
      else {
        ctrl.validateAll();
      }
    }

    public afterRender(){
      let ctrl=this;
      // La variable all es un para que 'deje' de renderizar
      let all=false;
      let listRegVal=this.hotComponent.$scope.$on("all-registers-validated", () => {
          all=true;
          listRegVal();
        });
      return function(forced){
        if (this.countVisibleRows()!= -1){
          if (ctrl.validarAlIniciar){
            if (!all){
              ctrl.validate();
            }
          }

          //ctrl.hotComponent.actionChangePage("");
          ctrl.hotComponent.newActionChangePage("");
        }
      }
    }

        /**
        * @description
        * Selecciona todos los registros activando todos  los checks de la columna
        * "Seleccion"
        */
        private toogleAll() {
          let regs: any = {};
          regs = this.hotComponent.$filter("filter")(this.hotComponent.data.registers, this.hotComponent.objectFilter);
          //regs = this.$filter("filter")(regs, this.filterMultiples);
          //regs = this.$filter("filter")(regs, this.filterEmptyy);
          regs = this.hotComponent.$filter("filter")(regs, this.hotComponent.onlyErrorsFilter);
          let datosSeleccionados = this.hotComponent.hotTable.getData();
          this.hotComponent.selectedItem = {};
          if (this.hotComponent.selectAll) {
            for (let reg of datosSeleccionados) {
              var currentIndice = Number(reg[0]) - 2;
              var currenRegister = regs[currentIndice];
              this.hotComponent.selectedItem[currenRegister['regs1']] = true;
              //this.hotComponent.selectedItem[reg[3]] = true;
              currenRegister['selected'] = !currenRegister['selected'];
              //reg[1] = !reg[1];
            }
          } else {
            for (let reg of datosSeleccionados) {
              var currentIndice = Number(reg[0]) - 2;
              var currenRegister = regs[currentIndice];
              currenRegister[1] = false;
            }
          }
          this.hotComponent.hotTable.render();
        }

        /**
        * @description
        * Cuando se presiona un item de la barra de error, se le da la orden que
        * realice el scroll hasta la posición en la que se encuentra el registro del
        * error.
        */
        private scrollTableTo(valueScroll: number = 0, posicionLinea) {
          let wtHolder: any = document.getElementsByClassName('wtHolder')[0];
          let division = Math.ceil(valueScroll / 8);
          if (division > 0) {
            division = division - 1;
          }
          let top = division * 235;

          wtHolder.scrollTop = top;
        }



        private getArrayErrors(regs) {
          var array = [];
          var newArray = [];

          for (var i = 0; i < regs.length; i++) {
              array.push(Number(regs[i].regs1 - 1));
          }

          let count = 0;
          let indiceInicial = 0;
          //let registros = this.data.registers;
          let registros = this.tmpRegs;
          for (var i = 0; i < registros.length; i++) {
            let existe = false;
            for (var j = 0; j < array.length; j++) {
              if (Number(registros[i].regs1 - 1) === array[j]) {
                existe = true;
              }
            }
            if (!existe) {
              count++;
              newArray.push(registros[i]);
            }
          }

          return newArray;
        }


        $doCheck() {
          /*setTimeout(() => {
                  this.addItemBarError();
                }, this.hotComponent.OPTIONS.TABLES.TIMER.WAIT);*/

            }

        public getPagination(){
          let enablePag=true;
          let numReg=this.hotComponent.data.registers.length;
          let limitShown=this.hotComponent.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE;
          return {"enablePag":enablePag,"numReg":numReg,"limitShown":limitShown,"ctrl":this.hotComponent};
        }

        public registerRenderers(){
          let ctrl=this;
          function lineRenderer(instance, td, row, col, prop, value, cellProperties) {
            if (ctrl.hotComponent.data.errors != undefined) {
              let currentRegister = ctrl.hotComponent.data.registers[row];
              if (currentRegister !== undefined) {
                if (currentRegister != undefined && currentRegister != null) {
                  let key = Object.keys(currentRegister)[1];
                  let seleccionado = currentRegister[key];
                  let errorSeleccionado = ctrl.hotComponent.data.errors[seleccionado];
                  let value ='';
                  if (errorSeleccionado != undefined) {
                    value = '<i class="fa fa-times-circle-o" ></i>';
                  }
                  else {
                    value = '';
                  }
                  Handsontable.dom.fastInnerHTML(td, value);
                }
              }
            }
          }
          Handsontable.renderers.registerRenderer('lineRenderer', lineRenderer);
        }

        public registerValidators(){
          let ctrl=this;
          let registerValidatorAsync = function (value, callback, regVal) {
            var colDef=regVal;
            setTimeout(function(){
              let r=colDef.row+1;

              if (ctrl.hotComponent.data.errors.hasOwnProperty(r)){
                let filaErrorSeleccionado=ctrl.hotComponent.data.errors[r];
                let c=colDef.col-1;

                if (colDef.col==0){
                  // SE AGREGA AL ARREGLO DE ERRORES SI ES UN ERROR, PERO VALIDA
                  // QUE NO ESTÉ
                  ctrl.errors.indexOf(Number(value)) === -1 ? ctrl.errors.push(Number(value)) : null;
                  ctrl.createItemError(Number(colDef.row));
                  callback(false);
                }
                else{
                  if (filaErrorSeleccionado.hasOwnProperty(c)){
                    let errorSeleccionado=filaErrorSeleccionado[c];
                    callback(false);
                  }
                  else {
                    callback(true);
                  }
                }
              }
              else {
                if (colDef.col==0){
                  // SI NO ES UN ERROR, PERO YA HA SIDO AGREGADO ANTERIORMENTE
                  // SE QUITA
                  let index=ctrl.errors.indexOf(Number(value));
                  if (index > -1) {
                    ctrl.errors.splice(index,1);
                    ctrl.deleteItemError(Number(colDef.row));
                  }
                }
                callback(true);
              }
            }, 250);

              };
              async function registerValidator(value, callback){
                let regVal=this;
                await registerValidatorAsync(value, callback, regVal);
              }

              Handsontable.validators.registerValidator('registerValidator', registerValidator);
        }

        public afterColumnSort(){
          let ctrl=this;
          return function(row,col){
              ctrl.firstElement = null;
              if(ctrl.hotComponent.hotTable.sortIndex !== undefined){
                ctrl.firstElement= ctrl.hotComponent.hotTable.getData()[0];
              }
              ctrl.updateItemErrorBar();
              // ctrl.refreshPaging();
          }
        }

        // public afterColumnSort(){
        //
        //   var ctrl=this;
        //
        //   this.firstElement=null;
        //   try {
        //     if(ctrl.hotComponent.hotTable.sortIndex !== undefined){
        //       this.firstElement= this.hotComponent.hotTable.getData()[0];
        //     }
        //     return function(r,c,r2,c2) {
        //       ctrl.updateItemErrorBar();
        //       ctrl.refreshPaging();
        //     }
        //   } catch (error) {
        //   }
        // }

         /**
         * @author Brian Caldas <bcaldas@lucasian.com>
         * @description
         * Método updateSettings, para modificar el comportamiento del filtro y el ordenamiento
         * ya que el componente handsotable tiene un bug en esta parte y no permite filtrar
         * y ordernar al mismo tiempo de manera correcta.
         * La solución que encontre, fue que al momento de ordenar, borrar todos los datos
         * y ordenar solo los datos que elegí según el filtro, ya si necesito ver todo de nuevo
         * cargo todos los datos almacenados en localstorage y renderizo de nuevo la tabla
         */
        public updateSettings(){

          var ctrl = this;

          this.hotComponent.hotTable.updateSettings({

            sortIndicator : true,

            //Evento se ejecuta despues de marcar las casillas en el filtro
            afterFilter: function(e){

            //La variable e trae las condiciones del filtro
            //Sí e es mayor a cero, trae condiciones, de lo contrario es un array vacio
            if(e.length<=0){

              //Si no hay condiciones, obtengo todos los datos almacenados en localstorage del arrayoriginal o los primeros datos de la tabla
              let datos_temporales = JSON.parse(localStorage.getItem('array_original'));
              if(datos_temporales!=undefined){
                //cargo los datos originales
                ctrl.hotComponent.hotTable.loadData(datos_temporales);

                //Cargo los datos y los muestros todos con el plugin trimrows del handsotable
                var plugin = ctrl.hotComponent.hotTable.getPlugin('trimRows');
                plugin.untrimAll();
                ctrl.hotComponent.hotTable.render();

                //Elimino del local storage los datos temporales y originales
                localStorage.removeItem('array_tmp');
                localStorage.removeItem('array_original');
              }
            }

            //Si e[0] es diferente de undefined, es que estan marcadas las condiciones de filtro
            if(e[0]!=undefined){

              //Obtengo los datos originales y las condiciones de filtro
              let registros = ctrl.hotComponent.data.registers;
              let conditions = e[0].conditions[0].args[0];

              //Saco el key de la columna en la que voy a hacer el ordenamiento
              let keys = Object.keys(registros[0]);
              let index = e[0].column-2;
              let indice = keys[index];

              //Creo un array temporal con los datos según las condiciones
              let arraytmp = [];

                for (let i = 0; i < registros.length; i++) {
                   if( conditions.indexOf(registros[i][""+indice+""]) >= 0){
                    arraytmp.push(registros[i]);
                   }
                }
                //Verifico si hay datos temporales y si su cantidad es menos que las condiciones
                let datos_temporales_filter = JSON.parse(localStorage.getItem('array_tmp'));
                if(datos_temporales_filter!=undefined){
                  console.log('temporales '+datos_temporales_filter.length)
                  console.log('condiciones '+e[0].conditions[0].args[0].length)
                  if(datos_temporales_filter.length < e[0].conditions[0].args[0].length){
                      ctrl.hotComponent.hotTable.loadData(arraytmp);
                      var plugin = ctrl.hotComponent.hotTable.getPlugin('trimRows');
                      plugin.untrimAll();
                      ctrl.hotComponent.hotTable.render();
                  }
               }

               //Guardo los datos temporales y originales
                localStorage.setItem('array_tmp', JSON.stringify(arraytmp));
                localStorage.setItem('array_original', JSON.stringify(registros));
                ctrl.hotComponent.hotTable.loadData(arraytmp);
                var plugin = ctrl.hotComponent.hotTable.getPlugin('trimRows');
                plugin.untrimAll();
                ctrl.hotComponent.hotTable.render();
              }
            },
            //Función que se ejecuta antes de hacer el ordenamiento
            beforeColumnSort: function (){
              //Si hay datos temporales, los cargo y hago el ordamiento
              let datos_temporales = JSON.parse(localStorage.getItem('array_tmp'));
              if(datos_temporales!=undefined){
                ctrl.hotComponent.hotTable.loadData(datos_temporales);
                var plugin = ctrl.hotComponent.hotTable.getPlugin('trimRows');
                plugin.untrimAll();
                ctrl.hotComponent.hotTable.render();
              }
            }

          });
        }

      public getFirstElement(){
       return this.firstElement;
      }
      // Metodo para construir la barra de error
      private getBarError(){
        let barError: any = document.getElementById("barra-errores");
        let tableContent=$("#hot-regsTp02").find('tbody')[0];
        let positionTop=$(tableContent).offset()['top'];
        let positionLeft=$(barError).offset()['left'];
        $(barError).offset({ top: positionTop , left: positionLeft});
        let wtHolder=$("#hot-regsTp02").find('.wtHolder')[0];
        let heightBarError=$(wtHolder).height()-($(tableContent).offset()['top'] - $(wtHolder).offset()['top']);
        $(barError).height(heightBarError);
        return barError;
      }

      // Método para construir un item
      private buildItem(){
        let item = document.createElement("div");
        item.className = "table__scroll-error-item";
        return item;
      }

        public colWidths(){
          // LAS COSAS QUE UNO HACE POR LA OPTIMIZACION
          return [
            79,	// Línea
            102,	// Selección
            122,	// Tipo registro
            106,	// Secuencia
            144,	// Tipo documento
            142,	// Nro Documento
            131,	// Tipo cotizante
            151,	// Subtipo cotizante
            109,	// Extranjero
            202,	// Colombiano en el exterior
            177,	// Código departamento
            150,	// Código municipio
            138,	// Primer apellido
            149,	// Segundo apellido
            138,	// Primer nombre
            148,	// Segundo nombre
            120,	// ING: Ingreso
            111,	// RET: Retiro
            189,	// TDE: Traslado desde EPS
            161,	// TAE: Traslado a EPS
            192,	// TDP: Traslado desde AFP
            163,	// TAP: Traslado a AFP
            270,	// VSP: Variación permanente de salario
            124,	// Correcciones
            264,	// VST: Variación transitoria del salario
            199,	// SLN: Suspensón temporal
            203,	// IGE: Incapacidad temporal
            219,	// LMA: Licencia de Maternidad
            143,	// VAC: Vacaciones
            183,	// AVP: Aporte voluntario
            245,	// VCT: Variación centros de trabajo
            266,	// IRL: Incapacidad enfermedad laboral
            112,	// Código AFP
            167,	// Código AFP Traslado
            111,	// Código EPS
            166,	// Código EPS Traslado
            112,	// Código CCF
            98,	// Días AFP
            96,	// Días EPS
            98,	// Días ARL
            97,	// Días CCF
            129,	// Salario básico
            138,	// Salario integral
            92,	// IBC AFP
            102,	// IBC salud
            92,	// IBC ARL
            91,	// IBC CCF
            107,	// Tarifa AFP
            134,	// Cotización AFP
            249,	// Aporte voluntario del afiliado AFP
            264,	// Aporte voluntario del aportante AFP
            172,	// Cotización Pensiones
            184,	// Aporte AFP-solidaridad
            191,	// Aporte AFP-subsistencia
            198,	// Valor No Ret. Voluntarios
            106,	// Tarifa EPS
            133,	// Cotización EPS
            128,	// UPC adicional
            170,	// Nro autorización IGE
            100,	// Valor IGE
            177,	// Nro autorización LMA
            107,	// Valor LMA
            108,	// Tarifa ARL
            152,	// Centro de trabajo
            135,	// Cotización ARL
            107,	// Tarifa CCF
            112,	// Aporte CCF
            116,	// Tarifa SENA
            112,	// Valor SENA
            111,	// Tarifa ICBF
            107,	// Valor ICBF
            114,	// Tarifa ESAP
            110,	// Valor ESAP
            113,	// Tarifa MEN
            109,	// Valor MEN
            176,	// Tp Doc Cotizante Ppal
            184,	// Nro Doc Cotizante Ppal
            165,	// Exonerado Ley 1607
            113,	// Código ARL
            118,	// Clase riesgo
            197,	// Tarifa especial pensiones
            147,	// Fecha de ingreso
            137,	// Fecha de retiro
            142,	// Fecha Inicio VSP
            144,	// Fecha Inicio SLN
            127,	// Fecha fin SLN
            139,	// Fecha inicio IGE
            123,	// Fecha fin IGE
            146,	// Fecha inicio LMA
            130,	// Fecha fin LMA
            144,	// Fecha inicio VAC
            128,	// Fecha fin VAC
            142,	// Fecha inicio VCT
            126,	// Fecha fin VCT
            139,	// Fecha inicio IRL
            122,	// Fecha fin IRL
            118,	// IBC otros PF
            144,	// Horas laboradas
            143	// Fec Rad Exterior
          ];
        }
  }
}

namespace app.table {

  /**
  * @class HandsOnTableController
  * @author Edwin Hurtado <ehurtado@lucasian.com>
  * @description
  * Clase encargada de cargar una tabla con las opciones de edición
  * paginado y filtro de contenido de las tablas basado en handsontable.
  */
  export class HotRegsTp2 extends HotDefault{

    private onlyErrors: string = "N";


    /**
    * @type {number} numeroErrores - Guarda el número de errores encontrados
    */
    public numeroErrores = 0;

    /**
    * @type {number} trSelected - Guarda la fila seleccionada
    */
    public trSelected = -1;

    public tmpRegs: any;

    constructor(hotComponent) {
      super(hotComponent);

      this.hotComponent=hotComponent;

      this.hotComponent.$scope.$on("only-errors", () => {
        this.actionOnlyErrors();
      });

      this.hotComponent.$scope.$on("action-change-page", () => {
        this.addItemBarError();
      });
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

    public colWidths(){

      return [50, 150, 50];
    }

    public getColumnDef(){
      var columnDef=[];
      columnDef = [
        {data: "line", type:"numeric", readOnly: true,renderer:'lineRenderer'},
        {data: "selected", type: 'checkbox', className: "htCenter"}
      ];

      if (this.hotComponent.data.registers[0]) {
        for(let i of Object.keys(this.hotComponent.data.registers[0])) {
          if (i.startsWith("regs")) {
            columnDef.push({data: i, type: 'text',validator:'registerValidator', invalidCellClassName:'table__data-field--error'});
            //TODO: Cambiar las columnas  con datos especial por su tipo correcto
          }
          // if (i.startsWith("selected")) {
          //   columnDef.push({data: i, type: 'checkbox'});
          //   //TODO: Cambiar las columnas  con datos especial por su tipo correcto
          // }
      }

      }
      // console.log('columndef')
      return columnDef;
    }
    public getVarFixedColumns(){
      if (this.hotComponent.fixedColumns)
        return 2;

      return 0;
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
            ctrl.createDialog(opt,ctrl.hotComponent);
          }
          ctrl.hotComponent.$rootScope.$broadcast("cargado_menu");
        },
        items: {
          'filter_action_bar':{},
          "filter_by_condition":{},
          "filter_by_value":{},
          '---------':{},
          "replace":{name:"Reemplazar"},
          "toggle_all":{name:"Sel/Des todos",disabled: function () {
            return ctrl.hotComponent.hotTable.getSelected()[1] !== 1;
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
      $("#diag-replace-"+ctrl.idTable).dialog({modal: true,width:'auto'});

      var fil=options.fil;
      var col=options.col;
      $("#btn-replace-"+ctrl.idTable).click(function() {
        var orig=$("#ta-replace-"+ctrl.idTable).val();
        var dest=$("#in-replace-"+ctrl.idTable).val();
        if (orig !== "" && dest !== "") {
          var arrOrig=ctrl.replaceAll(orig,' ',"#-#").split("\n");
          for (var k=0; k<arrOrig.length;k++){
            var value=arrOrig[k];
            for (var i=0;i<ctrl.hotTable.countRows();i++){
                  var str=ctrl.hotTable.getDataAtCell(i, col);
                  var newstr="";
                  if (value==="#-#"){
                    if (str.trim().length === 0){
                        ctrl.hotTable.setDataAtCell(i,col,dest);
                    }
                  }
                  else {
                    newstr=ctrl.replaceAll(str,value.trim(),dest);
                    ctrl.hotTable.setDataAtCell(i,col,newstr);
                  }
            }
          }
          ctrl.hotTable.render();
          $("#diag-replace-"+ctrl.idTable).dialog('close');
        } else {
          alert("Debe ingresar el valor a buscar y el valor a reemplazar para poder ejecutar la accion.");
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

    public getCells(){
      var ctrl=this;
      return function (row, col, prop) {
              var cellProperties = {};
              //console.log(row+" "+col+" "+prop);
              if (row!=null){

              if (row != undefined){

                var myCell=ctrl.hotComponent.hotTable.getCell(row,col);

                if (prop.startsWith('line')){
                  cellProperties['editor'] = false;
                  cellProperties['readOnly'] = true;
                } else if (col === 2 || col === 3) {
                  cellProperties['editor'] = false;
                  cellProperties['readOnly'] = true;
                } else if ($(myCell).find('input')){
                  if ($(myCell).find('input').attr('type')){
                    if ($(myCell).find('input').attr('type')==='checkbox'){
                      cellProperties['disableVisualSelection']=true;
                    }
                  }
                }

                //Revisa si el arreglo de errores está definido
                if (ctrl.hotComponent.data.errors != undefined) {
                  var currentRegister = ctrl.hotComponent.data.registers[row];
                  if (currentRegister !== undefined) {
                          //Revisa si el registro error
                      if (ctrl.hotComponent.data.errors.hasOwnProperty(currentRegister.regs1)) {
                        if (col===0){
                          cellProperties['renderer'] = "errorLineaRenderer"; // uses lookup map
                        } else {
                          cellProperties['renderer'] = "errorValueRenderer"; // uses lookup map
                        }
                      }
                      //Si no es la primera columna, se buscan los registros con error
                      else {
                        if (col===0){
                          cellProperties['renderer'] = "successLineaRenderer"; // uses lookup map
                        } else {
                          cellProperties['renderer'] = "successValueRenderer";
                        }
                      }
                  }
                }
              }
            }


            return cellProperties;
        }
    }

    public afterFilter(){
      if (this.hotComponent && this.hotComponent.hotTable){
        this.checkEmpty();
        this.refreshPaging();
        this.addItemBarError();
      }
    }

    public afterOnCellMouseDown(){
      var ctrl=this;
      return function (event,pos,cell) {
        let linePosition=ctrl.hotComponent.hotTable.getDataAtCell(pos.row,0);
        if (linePosition){
            let cellPosition=pos.col;
            if (cellPosition){
              ctrl.hotComponent.$rootScope.$broadcast("line-table-edit-select", linePosition-2);
              ctrl.hotComponent.$rootScope.$broadcast("validate-register-table", linePosition - 2);
            }
          }
        };
    }

    public afterChange(){
      var ctrl=this;
      return function (changes, source) {
        if (changes != null) {
          for (var fil = 0; fil < changes.length; fil++) {
            var rowThatHasBeenChanged = changes[fil][0],
            columnThatHasBeenChanged = changes[fil][1],
            previousValue = changes[fil][2],
            newValue = changes[fil][3];

            var sourceRow = ctrl.hotComponent.hotTable.getSourceDataAtRow(rowThatHasBeenChanged),
            visualRow = ctrl.hotComponent.hotTable.getDataAtRow(rowThatHasBeenChanged);

            var visualObjectRow = function(row) {
                var obj = {},key, name;
                for (var i = 0; i < ctrl.hotComponent.hotTable.countCols(); i++) {
                    obj[ctrl.hotComponent.hotTable.colToProp(i)] = ctrl.hotComponent.hotTable.getDataAtCell(row, i);
                  }
                  return obj
                }



                // console.log('* the getSourceDataAtRow:');
                // console.log(sourceRow);
                // console.log('* the getDataAtRow:');
                // console.log(visualRow);
                // console.log('* the visualObjectRow function:');
                // console.log(visualObjectRow(rowThatHasBeenChanged));
          }
        }

        if (changes != null) {
          for (var fil = 0; fil < changes.length; fil++) {
            if (changes[fil][1] !== "selected") {
              if (changes[fil][2] !== changes[fil][3]) {
                ctrl.hotComponent.$rootScope.$broadcast("validate-register-table", changes[fil][0]);
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
    public addItemBarError() {
      if (this.hotComponent.hotTable !== undefined) {
        var registersTmp = this.hotComponent.hotTable.getData();

        let delta = 27;
        let table: any = document.getElementById("hot-regsTp02");
        let barError: any = document.getElementById("barra-errores");
        if (!barError) return;

        barError.innerText = "";

        if (this.hotComponent.data.errors != undefined) {
          //var limite = this.data.registers.length;
          var limite = registersTmp.length;
          let init = 0;
          //let fin = this.data.registers.length;
          let fin = registersTmp.length;

          //if (this.data.registers.length > this.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE){
          if (registersTmp.length > this.hotComponent.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE){
            limite = this.hotComponent.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE;
            init = (this.hotComponent.page - 1) * this.hotComponent.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE;
            fin = init + this.hotComponent.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE;
            //if (fin > this.data.registers.length) {
            if (fin > registersTmp.length) {
              //fin = this.data.registers.length;
              fin = registersTmp.length;
            }
          }

          let positionInBar = ((this.getHeight() - 30) / limite);
          if (this.numeroErrores === 1) {
            positionInBar = delta;
          }
          var posicionLinea = 0;
          var i = 0;

          for (var row = init; row < fin; row++ ) {
            //var currentRegister = this.data.registers[row];
            //var comparar = this.data.registers[row];
            var currentRegister = registersTmp[row];
            //if (this.data.errors.hasOwnProperty(currentRegister.regs1)) {
            if (this.hotComponent.data.errors.hasOwnProperty(currentRegister[3])) {
              if ((fin - init) < 10 ) {
                posicionLinea = (i * 25) + delta;
              } else {
                posicionLinea = (i * positionInBar) + delta;
              }

              let item = document.createElement("div");
              item.className = "table__scroll-error-item";
              item.setAttribute("line", String(row));
              item.style.top = `${posicionLinea}px`;

              item.addEventListener("click", (event) => {
                let target: any = event.target;
                let line = target.getAttribute("line");
                this.trSelected = Number(line) + 1;
                this.scrollTableTo(Number(line));

              });

              barError.appendChild(item);
            }
            i++;
          }
        }
      }
    }

    /**
    * @description
    * Metodo que permite filtrar unicamente registros con error
    */
    public actionOnlyErrors() {
      console.log("actionOnlyErrors");

      let regs = this.hotComponent.data.registers;
      let regsData = this.hotComponent.hotTable.getData();
      var newRegs = [];
      for (let i = 0; i < regsData.length; i++) {
        for (let j = 0; j < regs.length; j++) {
          if (regsData[i][3] === regs[j].regs1) {
            newRegs.push(regs[j]);
            break;
          }
        }
      }

      regs = newRegs;

      //buscar solo los regs que esten en regsData

      let array = [];
      if ( this.onlyErrors === "N" ) {
        this.tmpRegs = this.hotComponent.data.registers;
        this.onlyErrors = "S";
        this.hotComponent.onlyErrorsFilter = (item,index) => {
            let linea = Number(item["regs1"]);
            let respuesta = this.hotComponent.data.errors.hasOwnProperty(linea);
            return respuesta;
        };
      } else {
        this.hotComponent.data.registers = this.tmpRegs;
        regs = this.tmpRegs;

        this.hotComponent.onlyErrorsFilter = function(item) {
          return true;
        };
        this.onlyErrors = "N";
      }

      regs = this.hotComponent.$filter("filter")(regs, this.hotComponent.onlyErrorsFilter);

      this.hotComponent.data.registers = regs;
      /*
      this.hotComponent.hotTable.updateSettings({
          data: regs
      });
      */

      regs = this.getArrayErrors(regs);

      let tempArray = [];
      for (var i = 0; i < regs.length; i++) {
        tempArray.push(i);
      }

        var clicked=this.hotComponent.page;

        this.hotComponent.hotTable.updateSettings({
          hiddenRows: this.hotComponent.hc.getArray(clicked)
        });

      this.addItemBarError();
      if (this.onlyErrors === "S") {
        $("#onlyErrorsIcon").css("color", "rgb(255, 66, 66)");
      } else {
        $("#onlyErrorsIcon").css("color", "rgb(117, 129, 140)");
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
          this.hotComponent.selectedItem = {};
          if (this.hotComponent.selectAll) {
            for (let reg of regs) {
              this.hotComponent.selectedItem[reg['regs1']] = true;
              reg['selected'] = !reg['selected'];
            }
          } else {
            for (let reg of regs) {
              reg['selected'] = false;
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
        private scrollTableTo(valueScroll: number = 0) {
          let wtHolder: any = document.getElementsByClassName('wtHolder')[0];
          let tamanoSroll = 280;
          let heightScroll = wtHolder.scrollHeight - tamanoSroll;
          let porcionesScroll = heightScroll / this.numeroErrores;
          wtHolder.scrollTop = porcionesScroll * valueScroll;
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
          setTimeout(() => {
                  this.addItemBarError();
                }, this.hotComponent.OPTIONS.TABLES.TIMER.WAIT);

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
          let registerValidator = function (value, callback, something) {
            var colDef=this;
            setTimeout(function(){
                let r=colDef.row+1;
                  if (ctrl.hotComponent.data.errors.hasOwnProperty(r)){
                    let filaErrorSeleccionado=ctrl.hotComponent.data.errors[r];
                    let c=colDef.col-1;

                    if (filaErrorSeleccionado.hasOwnProperty(c)){
                      let errorSeleccionado=filaErrorSeleccionado[c];
                      callback(false);
                    }
                  }
                }, 250);
              };

              Handsontable.validators.registerValidator('registerValidator', registerValidator);
        }

        public afterColumnSort(){

          var ctrl=this;
          return function() {
          console.log('afterColumnSort');
           ctrl.refreshPaging();
           ctrl.addItemBarError();
         }
        }

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
  }
}

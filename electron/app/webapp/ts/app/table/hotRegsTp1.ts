
namespace app.table {

  /**
  * @class HandsOnTableController
  * @author Edwin Hurtado <ehurtado@lucasian.com>
  * @description
  * Clase encargada de cargar una tabla con las opciones de edición
  * paginado y filtro de contenido de las tablas basado en handsontable.
  */
  export class HotRegsTp1 extends HotDefault {

    constructor(hotComponent) {
      super(hotComponent);
      this.hotComponent = hotComponent;
    }

    public getData(){
      return this.hotComponent.data.registers[0];
    }

    public getColumnSorting(){
        return false;
    }

    public getSortIndicator(){
        return false;
    }


    public getColumnDef(){
      var columnas=[];
      if (this.hotComponent.data.registers[0]) {
        for(let i of Object.keys(this.hotComponent.data.registers[0])) {
            //columnas.push({data: i, readOnly:true, type: 'text'});
          if (i.includes("regs")) {
            if (i === "regs0" || i === "regs2") {
              columnas.push({data: i, readOnly:true, type: 'text', renderer: 'cellRenderer'});
            } else {
              columnas.push({data: i, readOnly:false, type: 'text', renderer: 'cellRenderer'});
            }
          }
        }
      }
      return columnas;
    }

    public getVarFixedColumns(){
      return 0;
      }

      public getLabelsDef(){
        return this.hotComponent.labels;
      }

      public getDropDownMenu(){
        return false;
      }

      public getContextMenu(){
        return  true;
      }

      public getArray(clicked){

      }

      public getHiddenRows(clicked){

      }

      public afterFilter(){

      }

      public getHeight(){
        return 75;
      }

      public getCells(){
        var ctrl=this;
        return function (row, col, prop) {
            var cellProperties = {};
            if (row!=null){

              if (row != undefined && row === 0){
                var myCell=ctrl.hotComponent.hotTable.getCell(row,col);
                if (ctrl.hotComponent.data.errors != undefined) {
                  var currentRegister = ctrl.hotComponent.data.registers[row];
                  if (currentRegister !== undefined) {
                          //Revisa si el registro error
                      if (ctrl.hotComponent.data.errors.hasOwnProperty(currentRegister.regs1)) {
                          cellProperties['renderer'] = "errorRenderer"; // uses lookup map
                      } else {
                          cellProperties['renderer'] = "successRenderer";
                      }
                  }
                }
              }
          }


          return cellProperties;
        }
      }

      public afterColumnSort(){

      }

      public afterBeginEditing(){
        let ctrl=this;
        return function(row,col){
          let cs=ctrl.hotComponent.hotTable.getCellMeta(row, col);
          let linePosition=cs.visualRow;
          ctrl.hotComponent.$rootScope.$broadcast("refresh-contributors-table", 1);
        }
      }

      public getHotSettings(){
      let hotSettings= super.getHotSettings();
      //
      //hotSettings['hiddenRows'] = this.getHiddenRows(1);
      //hotSettings['afterFilter'] = this.afterFilter();
      //hotSettings['afterColumnSort'] = this.afterColumnSort();
      //hotSettings['afterOnCellMouseDown'] = this.afterOnCellMouseDown();
      hotSettings['afterChange'] = this.afterChange();
      hotSettings['afterBeginEditing'] = this.afterBeginEditing();
      return hotSettings;
    }




      public registerHooks(){

      }

      public registerRenderers(){
        var ctrl=this;

        Handsontable.renderers.registerRenderer('cellRenderer', cellRenderer);
        //Handsontable.renderers.registerRenderer('successRenderer', successRenderer);

        function cellRenderer(instance, td, row, col, prop, value, cellProperties) {
          // solo aplicar a celds tipo texto
          if (row === 0) {
            Handsontable.renderers.TextRenderer.apply(this, arguments);
            if (ctrl.hotComponent.data.errors != undefined) {
              var currentRegister = ctrl.hotComponent.data.registers[row];
              if (currentRegister !== undefined) {
                if (currentRegister != undefined && currentRegister != null) {
                  var key = Object.keys(currentRegister)[1];
                  var seleccionado = currentRegister[key];
                  var errorSeleccionado = ctrl.hotComponent.data.errors[seleccionado];
                  if (errorSeleccionado != undefined) {
                    var respuesta = errorSeleccionado.hasOwnProperty(col);
                    if (respuesta === true) {
                      td.className = 'table__data-field--error';
                    } else {
                      td.className = "";
                    }
                  }
                }
              }
            } else {
              td.innerHTML = value;
            }
          }

        }

        /*function successRenderer(instance, td, row, col, prop, value, cellProperties) {
          td.innerHTML = value;
        }*/
      }

      public afterChange(){
        var ctrl=this;
        return function (changes, source) {



          // if (changes != null) {
          //   // for (var fil = 0; fil < changes.length; fil++) {
          //   //   if (changes[fil][1] !== "selected") {
          //   //     /*
          //   //     Algunos registros vienen con espacios, entonces, si no se hace la comparacion, cambia los totales
          //   //     */
          //   //     let c1=changes[fil][2].trim();
          //   //     let c2=changes[fil][3].trim();
          //   //     if (c1 !== c2) {
          //   //       ctrl.hotComponent.$rootScope.$broadcast("validate-register-tp01", changes[fil][0]);
          //   //     }
          //   //   }
          //   // }

           if (changes != null) {

            if((source == 'edit') || (source='UndoRedo.undo')){

                ctrl.hotComponent.$rootScope.$broadcast("validate-register-tp01", changes[0][0]);

                let removelistener =  ctrl.hotComponent.$rootScope.$on("response_error_server", (event,res) => {
                 // var plugin = ctrl.hotComponent.hotTable.getPlugin('autoColumnSize');
                  let datos = ctrl.hotComponent.hotTable.getDataAtRow(changes[0][0]);
                  // let firstColumn = plugin.getFirstVisibleColumn();
                  // let lastColumn = plugin.getLastVisibleColumn();
                  // console.log(firstColumn)
                  // console.log(lastColumn)
                  for (let e = 0; e < datos.length; e++) {
                    let  cell = ctrl.hotComponent.hotTable.getCell(0, e);
                    if(cell != undefined){
                      cell.className  = '';
                    }


                  }

                  if(res.data.erroresRegistros.length > 0){

                      var errores = res.data.erroresRegistros;

                        for (let i = 0; i < errores.length; i++) {
                          if(errores[i]['error'] != 'Error no identificado'){
                             // ctrl.hotComponent.hotTable.setCellMeta(0, errores[i]['campo']+1, 'className', 'brian');
                             let  cell = ctrl.hotComponent.hotTable.getCell(0, errores[i]['campo']);
                             if(cell != undefined){
                              cell.className  = 'table__data-field--error';
                             }

                          }

                        }
                    }

                    // ctrl.hotComponent.hotTable.render();

                    });


                    setTimeout(() => {
                      removelistener();
                    }, 1000);




                }

          }

        }


      }


      public registerEvents(){

      }

      public updateSettings(){
        this.hotComponent.hotTable.updateSettings({
          fillHandle: false
        });
      }

      public colWidths(){
        return [100, 100, 100, 150, 150, 150, 150, 100, 180, 180, 150, 150, 150, 100, 180, 180, 150, 150, 150, 100, 100, 150];
      }

      public getPagination(){

      }

  }
}


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
      return this.hotComponent.data.registers;
    }

    public getColumnSorting(){
        return false;
    }

    public getSortIndicator(){
        return false;
    }

    public getColumnDef(){
      var columnas=[
        { data: "regs0", readOnly: true, type: 'text' },
        { data: "regs1", readOnly: true, type:'checkbox' },
        { data: "regs2", readOnly: true, type: 'numeric' }
      ];
      if (this.hotComponent.data.registers[0]) {

        for(let i of Object.keys(this.hotComponent.data.registers[0])) {
          /*
          Según la HU, en la NEC005-002 en los escenarios del 1 al 11, no se
          contempla que los campos Tipo Registro, Modalidad y Secuencia puedan ser
          editables, pero como se aprecia en el video de la evidencia, al pegar
          datos en estos campos la aplicación lo permite.
          */
          if (i !== "regs0" &&  i !== "regs1" && i !== "regs2" && i !== "selected") {
            columnas.push({data: i, readOnly:false, type: 'text'});
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

      public afterOnCellMouseDown(){
        var ctrl=this;
        return function (event,pos,cell) {
          let linePosition=ctrl.hotComponent.hotTable.getDataAtCell(pos.row,0);
          if (linePosition){
              let cellPosition=pos.col;
              if (cellPosition){
                //ctrl.hotComponent.$rootScope.$broadcast("line-table-edit-select", -1);
                  //ctrl.hotComponent.$rootScope.$broadcast("validate-register-table", -1);
              }
            }
          };
      }

      public afterChange(){
        var ctrl=this;
        return function (changes, source) {

          if (changes != null) {
            for (var fil = 0; fil < changes.length; fil++) {
              if (changes[fil][1] !== "selected") {
                /*
                Algunos registros vienen con espacios, entonces, si no se hace la comparacion, cambia los totales
                */
                let c1=changes[fil][2].trim();
                let c2=changes[fil][3].trim();
                if (c1 !== c2) {
                  ctrl.hotComponent.$rootScope.$broadcast("validate-register-tp01", changes[fil][0]);
                }
              }
            }
          }
        }
      }

      public registerHooks(){

      }

      public registerRenderers(){
        var ctrl=this;

        Handsontable.renderers.registerRenderer('errorRenderer', errorRenderer);
        Handsontable.renderers.registerRenderer('successRenderer', successRenderer);

        function errorRenderer(instance, td, row, col, prop, value, cellProperties) {
          //solo aplicar a celds tipo texto
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
            }
          }
        }

        function successRenderer(instance, td, row, col, prop, value, cellProperties) {
          td.innerHTML = value;
        }
      }

      public registerEvents(){

      }

      public updateSettings(){
        this.hotComponent.hotTable.updateSettings({
          fillHandle: false
        });
      }

      public getPagination(){

      }

  }
}

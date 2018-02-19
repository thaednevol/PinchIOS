
namespace app.table {

  /**
  * @class HandsOnTableController
  * @author Edwin Hurtado <ehurtado@lucasian.com>
  * @description
  * Clase encargada de cargar una tabla con las opciones de edición
  * paginado y filtro de contenido de las tablas basado en handsontable.
  */
  export class HotDefault implements IHotComponents{

    public hotComponent : any;

    constructor(hotComponent) {
      this.hotComponent=hotComponent;
    }

    public getData(){
      return this.hotComponent.data;
    }

    public getColumnSorting(){

    }

    public getHotSettings() {
      var hotSettings = {
              tableId:this.hotComponent.idTable,
              data: this.getData(),
              language:"es-CO",
              stretchH: 'all',
              autoWrapRow: true,
              columnSorting: this.getColumnSorting(),
              sortIndicator: this.getSortIndicator(),
              fixedColumnsLeft: this.getVarFixedColumns(),
              dropdownMenu:this.getDropDownMenu(),
              contextMenu:this.getContextMenu(),
              rowHeaders: false,
              colHeaders: this.getLabelsDef(),
              fillHandle: {autoInsertRow: false},
              columns: this.getColumnDef(),
              manualRowResize: true,
              manualColumnResize: true,
              manualRowMove: true,
              manualColumnMove: true,
              autoRowSize: {syncLimit: 200},
              renderAllRows: false,
              filters: this.hotComponent.activeFilter,
              scrollToSelection: true,
              height: this.getHeight(),
              licenseKey: '05ea7-d0139-2af62-34f15-ce322'
        };
        return hotSettings;
    }

    public getPagination(){

    }

    public getSortIndicator(){

    }

    public getColumnDef(){
      var columnDef=[];
      if (this.hotComponent.data.registers[0]) {
        for(let i of Object.keys(this.hotComponent.data.registers[0])) {
          if (i.startsWith("regs")) {
            columnDef.push({data: i, type: 'text'});
            }
          }
        }
      return columnDef;
    }

    public colWidths(){

    }

    public getVarFixedColumns(){
      return 0;
      }

      public getLabelsDef(){
        if (this.hotComponent.labels){
          return this.hotComponent.labels;
        }
        else
          return true;
      }

      public getDropDownMenu(){
        let option: any =true;
        return option;
      }

      public getContextMenu(){
        let option: any =true;
        return option;
      }

      public getArray(clicked){

      }

      public getHiddenRows(clicked){

      }

      public afterFilter(){

      }

      public getHeight(){

        return (2*30)+this.hotComponent.hotTable.countRows()*24;
      }

      public getCells(){

      }

      public afterColumnSort(){

      }

      public afterOnCellMouseDown(){

      }

      public afterChange(){

      }

      public registerHooks(){

      }

      public registerRenderers(){

      }

      public registerEvents(){

      }

      public updateSettings(){

      }

      public registerValidators(){

      }

      public getFirstElement(){

      }

    }
  }

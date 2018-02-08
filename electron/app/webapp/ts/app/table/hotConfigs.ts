
namespace app.table {

  /**
  * @class HandsOnTableController
  * @author Edwin Hurtado <ehurtado@lucasian.com>
  * @description
  * Clase encargada de cargar una tabla con las opciones de edición
  * paginado y filtro de contenido de las tablas basado en handsontable.
  */
  export class HotConfigs implements IHotComponents{

    private hotComponent:any;
    private iHotcomponent:any;

    constructor (hotComponent: any) {
      this.hotComponent=hotComponent;

       if (this.hotComponent.idTable==="regsTp01"){
         this.iHotcomponent=new HotRegsTp1(hotComponent);
       }

      //if (this.hotComponent.idTable==="regsTp02"){
        //this.iHotcomponent=new HotRegsTp2(hotComponent);
      //}
      //
      // if (this.hotComponent.idTable==="salud"
      //     || this.hotComponent.idTable==="fps"
      //       || this.hotComponent.idTable==="pension"
      //         || this.hotComponent.idTable==="riesgo"
      //           || this.hotComponent.idTable==="parafiscales"
      //             || this.hotComponent.idTable==="gran"){
      //   this.iHotcomponent=new HotTotals(hotComponent);
      // }
      //
      if (this.hotComponent.idTable==="regsTp02"){
        this.iHotcomponent=new HotRegsTp2(hotComponent);
      }


      if (this.hotComponent.idTable==="salud"
          || this.hotComponent.idTable==="fps"
            || this.hotComponent.idTable==="pension"
              || this.hotComponent.idTable==="riesgo"
                || this.hotComponent.idTable==="parafiscales"
                  || this.hotComponent.idTable==="gran"){
        this.iHotcomponent=new HotTotals(hotComponent);
      }

      // if (this.hotComponent.idTable==="error"){
      //   this.iHotcomponent=new HotErrors(hotComponent);
      // }
    }

    public getData(){
      return this.iHotcomponent.getData();
    }

    public getColumnSorting(){
      return this.iHotcomponent.getColumnSorting();
    }

    public getSortIndicator(){
        return this.iHotcomponent.getSortIndicator();
    }

    public getColumnDef(){
      return this.iHotcomponent.getColumnDef();
    }

    public colWidths(){
      return this.iHotcomponent.colWidths();
    }

    public getVarFixedColumns(){
      return this.iHotcomponent.getVarFixedColumns();
    }

    public getLabelsDef(){
      return this.iHotcomponent.getLabelsDef();
    }

    public getDropDownMenu(){
      return this.iHotcomponent.getDropDownMenu();
      // var hotDefault= new HotDefault();
      // return hotDefault.getDropDownMenu(hot);

    }
    public getPagination(){
      return this.iHotcomponent.getPagination();
    }

    public getContextMenu(){
      return this.iHotcomponent.getContextMenu();
    }

    public getArray(clicked){
      return this.iHotcomponent.getArray(clicked);
    }

    public getHiddenRows(clicked){
      return this.iHotcomponent.getHiddenRows(clicked);
    }

    public afterFilter(){
      return this.iHotcomponent.afterFilter();
    }

    public getHeight(){
      return this.iHotcomponent.getHeight();
    }

    public getCells(){
      return this.iHotcomponent.getCells();
    }

    public afterColumnSort(){
      return this.iHotcomponent.afterColumnSort();
    }

    public afterOnCellMouseDown(){
        return this.iHotcomponent.afterOnCellMouseDown();
    }

    public afterChange(){
      return this.iHotcomponent.afterChange();
    }

    public registerHooks(){
      return this.iHotcomponent.registerHooks();
    }

    public registerRenderers(){
      return this.iHotcomponent.registerRenderers();
    }

    public registerEvents(){
        return this.iHotcomponent.registerEvents();
    }

    public updateSettings(){
      return this.iHotcomponent.updateSettings();
    }

    public registerValidators(){
      return this.iHotcomponent.registerValidators();
    }

  }
}

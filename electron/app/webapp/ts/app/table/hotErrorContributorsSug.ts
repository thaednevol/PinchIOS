namespace app.table {
	/**
  * @class HandsOnTableController
  * @author Edwin Hurtado <ehurtado@lucasian.com>
  * @description
  * Clase encargada de cargar una tabla con las opciones de edición
  * paginado y filtro de contenido de las tablas basado en handsontable.
  */
  export class HotErrorContributorsSug extends HotDefault implements IHotComponents {
    constructor(hotComponent) {
      super(hotComponent);
      /*Handsontable.hooks.add('afterLoadData', () => {
         this.hotComponent.actionChangePage("");
      });*/
      this.hotComponent.$scope.$on("refresh-contributors", () => {
        this.refreshContributors();
      });
    }

    public refreshContributors() {
      this.hotComponent.hotTable.updateSettings({
          data: this.getData()
      });
    }

    public getData() {
      let newData = [];
      let regs = this.hotComponent.data;
      for (let i = 0; i < regs.length; i++) {
        if (regs[i].autocorregible === true && regs[i].corregido === true) {
          newData.push(regs[i]);
        }
      }
      return newData;
    }

    public getColumnDef() {
      let columnDef=[];
      columnDef = [
        {data: "tipoRegistro", readOnly: true},
        {data: "linea", type:"numeric", readOnly: true, className: "htLeft"},
        {data: "tipoIdentificacion", readOnly: true},
        {data: "nroIdentificacion", readOnly: true},
        {data: "error", readOnly: true},
        {data: "sugerencias", readOnly: true},
        {data: "currentValue", readOnly: true},
        {data: "correccion", readOnly: true}
      ];
      console.log("getColumnDef");
      console.log(columnDef);
      return columnDef;
    }

    public colWidths(){
      return [5, 5, 5, 10, 15, 10, 10, 5];
    }

    public getLabelsDef() {
      let columnLab=[];
			columnLab = ["Registro", "L\u00EDnea", "Tipo Documento", "Identificaci\u00F3n Cotizante", "Error", "Esperado", "Encontrado", "Correcci\u00F3n"];
      return columnLab;
    }

    public getColumnSorting() {
      return true;
    }

    public getSortIndicator() {
      return true;
    }

    public getContextMenu() {
      return false;
    }

    // public getArray(clicked) {
    //   var arr = [];
    //   var rowsOnSinglePage=this.hotComponent.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE;
    //   var newDataSet = this.getData();
    //   if (clicked === 1) {
    //     for (var i = (clicked * rowsOnSinglePage); i < newDataSet.length; i++) {
    //       arr.push(i);
    //     }
    //   } else {
    //     for (var j = 0; j < (clicked * rowsOnSinglePage) - rowsOnSinglePage; j++) {
    //       arr.push(j);
    //     }
    //     for (var i = (clicked * rowsOnSinglePage); i < newDataSet.length; i++) {
    //       arr.push(i);
    //     }
    //   }
    //   return arr;
    // }
    //
    // public getHiddenRows(clicked) {
    //   return {
    //     rows:this.getArray(clicked),
    //     indicators:false
    //   }
    // }

    public getHeight() {
      return 275;
    }

    public updateSettings() {
      let ctrl=this;
      this.hotComponent.hotTable.updateSettings({
        filters:[2,3,4,5,6,7],
        afterGetColHeader: function(col, TH) {
          var BUTTON_CLASS_NAME = 'changeType';
          var existingButton = TH.querySelector('.' + BUTTON_CLASS_NAME);
          if (!this.enabled) {
            if (existingButton) {
              if (Object.prototype.toString.call( this.getSettings().filters ) === '[object Array]' && this.getSettings().filters.indexOf(col) === -1) {
                existingButton.parentNode.removeChild(existingButton);
              }
            }
            return;
          }
        }/*,
        afterRender:function(event,a,b,c) {
          ctrl.hotComponent.actionChangePage("");
        }*/
      });
    }

    public getDropDownMenu() {
      var ctrl=this;
      return {
        items: {
          "filter_action_bar": {
            disabled: function () {
              return ctrl.hotComponent.hotTable.getSelected()[1] <= 1;
            }
          },
          "filter_by_condition": {
            name: "Filtrar por condicion",
            disabled: function () {
              return ctrl.hotComponent.hotTable.getSelected()[1] <= 1;
            }
          },
          "filter_by_value": {
            name:"Filtrar por valor",disabled: function () {
              return ctrl.hotComponent.hotTable.getSelected()[1] <= 1;
            }
          }
        }
      };
    }

    public afterRender(){
          let ctrl=this;
          // return function(forced){
          //   if (this.countVisibleRows()!= -1){
          //     ctrl.validate();
          //     // ctrl.hotComponent.actionChangePage("");
          //   }
          // }
        }

        private rowsValidated= new Array();

        private validate(){
          let ctrl=this;
          if (ctrl.rowsValidated.length==0){
            function validar(inf,sup):Promise<any> {
                return new Promise<any>(resolve => {
                    for(let i=inf; i<sup;i++){
                      ctrl.rowsValidated.indexOf(Number(i)) === -1 ? ctrl.rowsValidated.push(Number(i)) : null;
                    }
                    ctrl.hotComponent.hotTable.validateRows(ctrl.rowsValidated, function(valid) {});

                  resolve();
                })
              }
              async function validarLote(): Promise<void> {
                let plugin=ctrl.hotComponent.hotTable.getPlugin('autoRowSize');
                let inf=plugin.getFirstVisibleRow();
                let sup=plugin.getLastVisibleRow();
                if (inf!=-1 && sup!=-1){
                  await validar(inf,sup);
                  inf=plugin.getLastVisibleRow();
                  sup=ctrl.hotComponent.hotTable.countRows();
                  await validar(inf,sup);
                }
              }
              validarLote();
          }
        }

    public getPagination() {
      let enablePag=true;
      let numReg=this.getData().length;
      let limitShown=this.hotComponent.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE;
      return {"enablePag":enablePag,"numReg":numReg,"limitShown":limitShown,"ctrl":this.hotComponent};
    }

    public getHotSettings(){
      let hotSettings= super.getHotSettings();
      //
      hotSettings['afterRender'] = this.afterRender();
      //hotSettings['hiddenRows'] = this.getHiddenRows(1);
      //hotSettings['afterFilter'] = this.afterFilter();
      //hotSettings['afterColumnSort'] = this.afterColumnSort();
      //hotSettings['afterOnCellMouseDown'] = this.afterOnCellMouseDown();
      //hotSettings['afterChange'] = this.afterChange();
      hotSettings['getData'] = this.getData();
      //
      return hotSettings;
    }


  }
}

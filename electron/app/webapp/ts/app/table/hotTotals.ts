

namespace app.table {
	/**
  * @class HandsOnTableController
  * @author Edwin Hurtado <ehurtado@lucasian.com>
  * @description
  * Clase encargada de cargar una tabla con las opciones de edición
  * paginado y filtro de contenido de las tablas basado en handsontable.
  */
  export class HotTotals extends HotDefault {
      constructor(hotComponent) {
		  super(hotComponent);
    }



    public getData(){

      return this.hotComponent.data;
      
    }

    public getColumnDef(){
 
        let columnDef=[];
        if (this.hotComponent.data[0]) {
            for(let i of Object.keys(this.hotComponent.data[0])) {
                columnDef.push({data: i, type: 'text',readOnly:!this.hotComponent.editTable});
            }
        }
        return columnDef;
    }

    public getDropDownMenu(){
      return false;
    }

    public getContextMenu(){
      return false;
    }

    public getSortIndicator(){
      return true;
    }

    public getColumnSorting(){
      return true;
    }

    public getHeight(){

      return (2*30)+this.hotComponent.data.length*24;
    }
    public colWidths(){

      return [80,80, 250,80,80,80,80,80,80,80];
    }

    public registerRenderers(){
      function boldValueRenderer(instance, td, row, col, prop, value, cellProperties) {
        Handsontable.renderers.TextRenderer.apply(this, arguments);
        td.style.fontWeight = 'bold';
      }

      Handsontable.renderers.registerRenderer('boldValueRenderer', boldValueRenderer);

    }

    public getCells(){
      let data=this.hotComponent.data;

      return function (row, col, prop) {
        let total=data.length-1;
        var cellProperties = {};

        if (row === total){
          // cellProperties.renderer = "boldValueRenderer";
        }
        return cellProperties;
      }
    }

    public updateSettings(){
      let hot=this.hotComponent.hotTable;
      let data=this.hotComponent.data;

      this.hotComponent.hotTable.updateSettings({
        sortFunction: function(sortOrder, columnMeta) {
    	     return function(a, b) {
             var plugin = hot.getPlugin('columnSorting');
             let total=data.length-1;
             var sortFunction;

             if (b[0] === total) {
        	      return -1;
              }

              switch (columnMeta.type) {
                case 'date':
                  sortFunction = plugin.dateSort;
                break;
                case 'numeric':
                  sortFunction = plugin.numericSort;
                break;
                default:
                  sortFunction = plugin.defaultSort;
                }

                return sortFunction(sortOrder, columnMeta)(a, b);
              };
            }
          });
        }
      }
    }

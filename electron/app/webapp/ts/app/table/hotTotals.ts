

namespace app.table {
	/**
  * @class HandsOnTableController
  * @author Edwin Hurtado <ehurtado@lucasian.com>
  * @description
  * Clase encargada de cargar una tabla con las opciones de edición
  * paginado y filtro de contenido de las tablas basado en handsontable.
  */



  export class HotTotals extends HotDefault {

    public hotComponent: any;

      constructor(hotComponent) {

		  super(hotComponent);

      this.hotComponent = hotComponent;
    }



    public getData(){

      return this.hotComponent.data;
      
    }



    public getColumnDef(){

        let columnDef=[];

        if (this.hotComponent.data[0]) {
          // for(let i of Object.keys(this.hotComponent.data[0])) {
          //   columnDef.push({data: i, type: 'text',readOnly:!this.hotComponent.editTable});
          // }
          for(let i=0; i<Object.keys(this.hotComponent.data[0]).length; i++){
            if(this.hotComponent.idTable==="pension" && i > 1){
                columnDef.push({data: i, type: 'numeric',readOnly:!this.hotComponent.editTable});
               }else if (this.hotComponent.idTable==="salud" && i>1){
                  columnDef.push({data: i, type: 'numeric',readOnly:!this.hotComponent.editTable});
               }else if (this.hotComponent.idTable==="riesgo" && i>1){
                  columnDef.push({data: i, type: 'numeric',readOnly:!this.hotComponent.editTable});
               }else if (this.hotComponent.idTable==="parafiscales" && i>2){
                  columnDef.push({data: i, type: 'numeric',readOnly:!this.hotComponent.editTable});
               }else if (this.hotComponent.idTable==="gran"){
                  columnDef.push({data: i, type: 'numeric',readOnly:!this.hotComponent.editTable});
               }else{
                columnDef.push({data: i, type: 'text',readOnly:!this.hotComponent.editTable});
               }
          }
            // for(int i of Object.keys(this.hotComponent.data[0])) {

            //    if(this.hotComponent.idTable==="pension" && i > 2){
            //     columnDef.push({data: i, type: 'numeric',readOnly:!this.hotComponent.editTable});
            //    }else if (this.hotComponent.idTable==="salud" && i>2){
            //       columnDef.push({data: i, type: 'numeric',readOnly:!this.hotComponent.editTable});
            //    }else if (this.hotComponent.idTable==="riesgo" && i>2){
            //       columnDef.push({data: i, type: 'numeric',readOnly:!this.hotComponent.editTable});
            //    }else if (this.hotComponent.idTable==="parafiscales" && i>3){
            //       columnDef.push({data: i, type: 'numeric',readOnly:!this.hotComponent.editTable});
            //    }else if (this.hotComponent.idTable==="gran"){
            //       columnDef.push({data: i, type: 'numeric',readOnly:!this.hotComponent.editTable});
            //    }else{
            //     columnDef.push({data: i, type: 'text',readOnly:!this.hotComponent.editTable});
            //    }
                
            // }
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

    public getHotSettings(){
      let ctrl=this;
      let hotsettings = super.getHotSettings();
      hotsettings['sortFunction']=this.sortFunction();
      return hotsettings;
    }

    public sortFunction(){
      var hot = this.hotComponent.hotTable;
      var data=this.hotComponent.data;
      var ctrl = this;
      return function(sortOrder,columnMeta){

              return function(a, b) {
                var plugin = ctrl.hotComponent.hotTable.getPlugin('columnSorting');
                var total=data.length-1;
                var sortFunction;
                
                if (b[0] === total) {
                 return -1;
                }

                switch (columnMeta.type) {
                  case 'date':
                    sortFunction = plugin.dateSort;
                    break;
                    case 'numeric':

                    //Quito el signo $ de los numeros
                    let valorB = b[1].replace('$','');
                    let valorA = a[1].replace('$','');

                    //Quito los puntos
                    let valorBB = valorB.split('.').join("");
                    let valorAA = valorA.split('.').join("");

                    //Quito las comas
                    let newB = valorBB.split(',').join("");
                    let newA = valorAA.split(',').join("");

                    //Convierto los números a enteros para calcula el mayor al menor
                    let bvalor = parseInt(newB)
                    let avalor = parseInt(newA)



                    if (bvalor < avalor) {
                      return sortOrder ? -1 : 1;
                    }
                    if (bvalor > avalor) {
                      return sortOrder ? 1 : -1;
                    }

                    sortFunction = plugin.numericSort;
                    break;
                  default:
                    sortFunction = plugin.defaultSort;
                }
                
                return sortFunction(sortOrder, columnMeta)(a, b);
              };
      }

    }
        
      }
    }

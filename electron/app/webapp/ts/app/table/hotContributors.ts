
namespace app.table {
	/**
  * @class HandsOnTableController
  * @author Edwin Hurtado <ehurtado@lucasian.com>
  * @description
  * Clase encargada de cargar una tabla con las opciones de edición
  * paginado y filtro de contenido de las tablas basado en handsontable.
  */
  export class HotContributors extends HotDefault implements IHotComponents {

    /**
    * @type {number} numberRegister - Numero de registro (id)
    */
    public numberRegister: number;

    constructor(hotComponent) {
		  super(hotComponent);
      this.hotComponent.$scope.$on("refresh-contributors-table", (event, numberRegister) => {
        this.refreshContributorsTable(numberRegister);
      });
    }

    public refreshContributorsTable(numberRegister) {
      let ctrl = this;
      this.numberRegister = numberRegister;
      this.hotComponent.hotTable.updateSettings({
          data: this.getDataContributors(numberRegister)
      });
    }

    public getDataContributors(numberRegister) {
      let newData = [];

      let regs = this.hotComponent.data;
      if (regs !== undefined) {
        for (let i = 0; i < regs.length; i++) {
          let linea = regs[i].linea;
          if (linea === parseInt(numberRegister)) {
            newData.push(regs[i]);
          }
        }
      }

      return newData;
    }

    public getHeight(){
      return 275;
    }

    public getColumnDef(){
        let columnDef=[];
        columnDef = [
          {data: "tipoRegistro", readOnly: true},
          {data: "linea", type:"numeric", readOnly: true, className: "htLeft"},
          {data: "tipoIdentificacion", readOnly: true},
          {data: "nroIdentificacion", readOnly: true},
          {data: "error", readOnly: true},
          {data: "sugerencias", readOnly: true},
          {data: "currentValue", readOnly: true}

        ];
        console.log("getColumnDef");
        console.log(columnDef);
        return columnDef;
    }


    public getLabelsDef(){
        let columnLab=[];
				columnLab = ["Registro", "L\u00EDnea", "Tipo Documento", "Identificaci\u00F3n Cotizante", "Error", "Esperado", "Encontrado"];
        return columnLab;
    }

    public getColumnSorting(){
      return true;
    }

    public getSortIndicator(){
      return true;
    }

    public getContextMenu(){
      return false;
    }

    public getArray(clicked){

    }

    public getHiddenRows(clicked){
      return {
        rows:this.getArray(clicked),
        indicators:false
      }
    }

    public getDropDownMenu(){
      return false;
    }

    public getPagination(){

    }

    public getFirstElement(){
      
    }

    public colWidths(){
      return [70, 50, 120, 180, 1300, 150, 150];
    }

    }


  }

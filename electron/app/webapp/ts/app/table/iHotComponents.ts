
namespace app.table {

  /**
  * @class HandsOnTableController
  * @author Edwin Hurtado <ehurtado@lucasian.com>
  * @description
  * Clase encargada de cargar una tabla con las opciones de edición
  * paginado y filtro de contenido de las tablas basado en handsontable.
  */
  export interface IHotComponents {
    getData();

    getColumnSorting();
    getSortIndicator();
    getColumnDef();
    colWidths();
    getVarFixedColumns();
    getLabelsDef();
    getDropDownMenu();
    getContextMenu();
    getArray(clicked);
    getHiddenRows(clicked);
    getHeight();
    getCells();
    getPagination();
    afterFilter();
    afterColumnSort();
    afterOnCellMouseDown();
    afterChange();
    getHotSettings();


    registerHooks();
    registerRenderers();
    registerEvents();
    registerValidators();
    getFirstElement();

    updateSettings();
  }
}

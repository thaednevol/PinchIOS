
namespace app.table {

  /**
  * @class TableEditController
  * @author Luis Felipe Zapata <lzapata@swat-it.co>
  * @description
  * Clase encargada de cargar una tabla con las opciones de edición
  * paginado y filtro de contenido de las tablas.
  */
  class TableEditController {

    /**
    * @type {Boolean} replaceActive - Indica si se debe hacer visible la opción
    * de reemplazar el contenido de todas las celdas.
    */
    public replaceActive: boolean = false;

    /**
    * @type {String} inputFilterReplace - Model o del input que se encarga de
    * realizar el reemplazo del contenido.
    */
    public inputFilterReplace: string = "";

    /**
    * @type {Object} contextMenu - Menu Contextual utilizado en los campos de
    * input que muestran las sugerencias de corrección de errores.
    */
    private contextMenu: any = require("electron-contextmenu-middleware");

    /**
    * @type {String[]} data - Datos que se muestran en la tabla
    */
    public data: any = [{}];

    /**
    * @type {Object<Number, Boolean>} selectedItem - Almacena el numero de
    * secuencia del input y si se selecciono.
    */
    public selectedItem: any = {};

    /**
    * @type {String[]} labels - Nombre de las columnas
    */
    public labels: any;

    /**
    * @type {string} idTable - Nombre con el que se identifica la tabla de las otras.
    */
    public idTable: any;

    /**
    * @type {Boolean} editTable - Indica si la tabla esta activa para editar el contenido.
    */
    public editTable: boolean = true;

    /**
    * @type {Boolean} activeFilter - Indica si habilita la tabla con filtro de celdas
    */
    public activeFilter: boolean = false;

    /**
    * @type {Object} objectFilter - Lista de opciones o palabras para filtrar
    */
    public objectFilter: any = {};

    public onlyErrorsFilter: any = {};

    /**
    * @type {Number} positionFilter - Identifica las cordenadas
    * de carga del input de filtro.
    */
    public positionFilter: number = 0;

    /**
    * @type {Object} keyFilter - Objeto que almacena los nombres de las columnas
    * segun la posición, se utiliza por que los nombres de las columnas no son
    * siempre de una misma secuencia.
    */
    public keyFilter: any = {};

    /**
    * @type {Boolean} showFilter - Indica si esta activo la ventana de filtro.
    */
    public showFilter: boolean = false;

    /**
    * @type {Array} listSuggestions - Almacena una lista de sugerencias para
    * realizar las correcciones si el campo cuenta con opciones.
    */
    public listSuggestions: any = null;

    /**
    * @type {Number} limitRegister - limita la cantidad de registros que se
    * renderizan por bloque que se carga de una tabla, cada cierto
    * tiempo se va aumentando hasta completar el total de elementos.
    */
    public limitRegister = 50;

    /**
    * @type {Number} startLimit - Indica el numero maximo de registros a cargar.
    */
    public startLimit = 0;

    /**
    * @type {Number} currentNumberRegisterLoad - Indica la cantidad de registros
    * que estan cargados en el momento.
    */
    public currentNumberRegisterLoad = 0;

    /**
    * @type {Boolean} activeSubMenu - Indica si esta activo el submenu.
    */
    public activeSubMenu: boolean = false;

    /**
    * @type {Boolean} fixedColumns - Indica si se deben fijar las dos columnas iniciales,
    * el numero de linea y la casilla para seleccionar.
    */
    public fixedColumns: boolean = false;

    /**
    * @type {Array} cellNoEdit - Lista de celdas que nos e editan.
    */
    public cellNoEdit: any = [];

    /**
    * @type {Object} inputEditField - Representa el input de edición en la tabla.
    */
    private inputEditField: any;

    /**
    * @type {Object} OPTIONS - Equivale al archivo de opciones del sistema.
    * @see app/webapp/json/data/options.json
    */
    private OPTIONS: any;

    /**
    * @type {Object} timerSubMenuVisible - Timer que indica cuando ocultar el
    * submenu.
    */
    private timerSubMenuVisible: any;

    private $scope: any;
    private $rootScope: any;
    private $filter: any;
    static $inject = ["$scope", "$rootScope", "$filter", "OPTIONS"];

    constructor($scope, $rootScope, $filter, OPTIONS) {
      this.$scope = $scope;
      this.$rootScope = $rootScope;
      this.$filter = $filter;
      this.OPTIONS = OPTIONS;
      this.limitRegister = this.OPTIONS.TABLES.ROW_LOAD_BY_PAGE;
      this.$scope.$on("clear-inputs-table-edit", () => {
        this.clearInputs();
      });
      this.$scope.$on("change-page-table", (event, idTable, numberPage, scrollBottom) => {
        if (this.idTable === idTable) {
          this.changePageTo(numberPage, scrollBottom);
        }
      });
    }

    /**
    * @description
    * Ejecuta el flujo de un compoenten angular cuando detecta que hay un cambio
    * en un scope, se hace una validación para permitir que cargue el listener
    * del scroll y se ajuste el tamaño de las columnas.
    */
    $doCheck() {
      let scrollContainer = document.getElementById("scroll-" + this.idTable);
      if (scrollContainer) {
        window.addEventListener("resize", () => {
          this.setWidthHead();
        });
        scrollContainer.addEventListener("scroll", (event) => {
          if (this.showFilter) {
            this.showFilter = false;
            this.$scope.$digest();
          }
          this.actionScroll(event);
        });
        this.setWidthHead();
      }
      setTimeout(() => {
        this.addItemBarError();
      }, this.OPTIONS.TABLES.TIMER.WAIT);
    }

    /**
    * @private
    * @description
    * Lee el valor de los inputs que tienen insertado dentro de cada celda,
    * captura el valor y lo almacena dentro de la celda y el modelo de la tabla,
    * luego elimina los inputs cargados.
    * El metodo se ejecuta por un broadcast clear-inputs-table-edit.
    */
    private clearInputs() {
      let inputs: any = document.getElementById(this.idTable);
      if (!inputs) {
        return;
      }
      this.$rootScope.$broadcast("line-table-edit-select", -2);
      inputs = inputs.getElementsByTagName("input");
      let positionInArray: number;
      for (let i = 0; i < inputs.length; i++) {
        let input: any = inputs[i];
        let value = input.value.trim();
        if (input.getAttribute("keydata") !== null) {
          positionInArray = input.getAttribute("position");
          let currentKey = input.getAttribute("keydata");
          if (this.idTable === "regsTp02") {
            currentKey = Object.keys(this.data.registers[0])[currentKey];
            //Solo se revalida cuando realmente cambia el valor
            if ( this.data.registers[positionInArray][currentKey] != value ){
              this.data.registers[positionInArray][currentKey] = value;
              this.$rootScope.$broadcast("validate-register-table", input.getAttribute("position"));
            }
          }else if (this.idTable === "regTp01") {
            currentKey = Object.keys(this.data.registers[0])[currentKey];
            if (currentKey !== undefined) {
              //Solo se revalida cuando realmente cambia el valor
              if ( this.data.registers[positionInArray][currentKey] != value ){
                this.data.registers[positionInArray][currentKey] = value;
                this.$rootScope.$broadcast("validate-register-tp01");
              }
            }
          }else if (this.data.registers) {
            currentKey = Object.keys(this.data.registers[0])[currentKey];
            this.data.registers[positionInArray][currentKey] = value;
          } else {
            this.data[positionInArray][currentKey] = value;
          }
          // Se elimina la clase de efecto de selección de las filas.
          input.parentNode.parentNode.className = input.parentNode.parentNode.className.replace(" table__row--selected", "");
          input.parentNode["innerText"] = value || " ";
        }
      }
      this.removeSubMenu();
      this.setWidthHead();
      this.$rootScope.$broadcast("action-clear-inputs-table", positionInArray);
    }

    /**
    * @description
    * Elimina el submenu de las celdas.
    */
    private removeSubMenu() {
      if (this.timerSubMenuVisible) {
        clearTimeout(this.timerSubMenuVisible);
      }
      this.timerSubMenuVisible = setTimeout(() => {
        this.listSuggestions = null;
        this.$scope.$digest();
      }, this.OPTIONS.TABLES.TIMER.WAIT);
    }

    /**
    * @description
    * Captura la información de la celda en la que se da clic, ejecuta el llamado
    * para limpiar los inputs que esten cargados antes y agrega un nuevo input
    * con los datos que tenia la celda actualmetne y le hace un foco para
    * permitir que el usuario realice la edición de la información de la celda
    *
    * @param {Object} model - Representa la clase TableEdit en la vista.
    * @param {Object} event - Contiene los datos del evento de click
    */
    public actionSelectCell(model, event) {
      // Como se da clic se indica que limpie el foco y inputs de otras tablas.
      if (!event.target.childNodes[0] || this.editTable === false || this.lockCell(model)) {
        return;
      }
      let target = event.target;
      target.parentNode.className = target.parentNode.className.replace(" table__row--error", "");
      // Se agrega la clase para aplicar efecto de selección en la fila.
      target.parentNode.className += " table__row--selected";
      let linePosition = model.$parent.$index;
      let cellPosition = model.$index;
      this.inputEditField = document.createElement("input");
      this.inputEditField.setAttribute("keydata", cellPosition);
      if (!(model.$parent.register instanceof Array)) {
        if (model.$parent.register.regs1) {
          linePosition = String(parseInt(model.$parent.register.regs1) - 1);
        }
      }
      this.inputEditField.setAttribute("position", linePosition);
      this.inputEditField.value = target.innerText;
      target.innerText = "";
      target.appendChild(this.inputEditField);
      this.inputEditField.focus();
      this.inputEditField.addEventListener("focusout", () => {
        this.$rootScope.$broadcast("clear-inputs-table-edit");
      });
      if (this.idTable === "regsTp02") {
        this.$rootScope.$broadcast("line-table-edit-select", linePosition);
        this.setSuggestions(Number(linePosition) + 1, Number(cellPosition) + 1);
      }else{
        this.$rootScope.$broadcast("line-table-edit-select", -1);
      }
    }

    /**
    * @description
    * Cuando se presiona el clic secundario sobre una celda, captura la
    * información de la posición de la celda y consulta si existen
    * sugerencias de corrección de errores para la celda.
    */
    public actionContextMenuCell(model, event) {
      let linePosition = "";
      let cellPosition = model.$index;
      if (model.$parent.register instanceof Array) {
        linePosition = model.$parent.$index;
      } else {
        linePosition = String(parseInt(model.$parent.register.regs1) - 1);
      }
      this.setSuggestions(Number(linePosition) + 1, Number(cellPosition) + 1);
    }

    /**
    * @description
    * Realiza la carga de la sugerencia para la celda, si esta no tiene no se
    * asigna.
    * @param {Number} line - Linea en la que se activa la opcion.
    * @param {Number} cell - Numero de celda a la que se aplica la sugerencia.
    */
    private setSuggestions(line, cell) {
      this.contextMenu.reset();
      // Se agregan validaciones para evitar que se consulte las sugerencias si
      // no existe error, la condición se cumple cuando son tablas de edición
      // que no son tipo regstro 2 o tablas sin filtro.
      if (!this.data.errors) return;
      if (!this.data.errors[line]) return;
      if (!this.data.errors[line][cell]) return;
      this.contextMenu.use((ctx, next) => {
        for (let i = 0; i < this.data.errors[line][cell].sugerencias.length; i++) {
          let suggestion = this.data.errors[line][cell].sugerencias[i];
          ctx.menu.push({
            label: suggestion,
            click: () => {
              let inputs: any = document.getElementById(this.idTable);
              inputs = inputs.getElementsByTagName("input");
              if (inputs.length > 0) {
                inputs[0].value = suggestion
              } else {
                this.actionApplySuggestion(suggestion, Number(line) - 1, Number(cell) - 1);
              }
            }
          });
        }
        next();
      });
      this.contextMenu.activate();
    }

    /**
    * @description
    * Activa la opción de cargar la sugerencia desde el menu cuando se presiona
    * el boton
    */
    public actionApplySuggestion(suggestion, position, keyData) {
      let currentKey = `regs${keyData}`;
      this.data.registers[position][currentKey] = suggestion;
      this.$rootScope.$broadcast("validate-register-table", position);
    }

    /**
    * @description
    * Bloquea la celda para evitar que se permita su edición.
    */
    private lockCell(model) {
      if (!this.cellNoEdit) return false;
      return this.cellNoEdit.indexOf(model.$index) !== -1;
    }

    /**
    * @description
    * Inicia el proceso de carga de la barra de error de la tabla de liquidación.
    */
    private addItemBarError() {
      let table: any = document.getElementById("scroll-regsTp02");
      if (!table) return;
      let scrollHeightTable: number = Number(table.scrollHeight);
      let listRow: any = table.getElementsByClassName("table__data--error");
      if (listRow.length === 0) return;
      let barError: any = document.getElementsByClassName("table__scroll-error")[0];
      barError.innerText = "";
      for (let i = 0; i < listRow.length; i++) {
        let numberLine: number = Number(listRow[i].getAttribute("id").replace("row-", ""));
        if (numberLine < this.startLimit && numberLine > this.currentNumberRegisterLoad) {
          break;
        }
        let positionInTable: number = listRow[i].clientHeight * numberLine;
        let positionInBar: number = (positionInTable * 100) / scrollHeightTable;
        let item = document.createElement("div");
        item.className = "table__scroll-error-item";
        item.setAttribute("line", String(numberLine));
        item.style.top = `${positionInBar}%`;
        item.addEventListener("click", (event) => {
          this.restoreRowClassError();
          let target: any = event.target;
          let line = target.getAttribute("line");
          let destination = document.getElementById(`row-${line}`);
          destination.className += " table__row--error";
          this.scrollTableTo(positionInTable);
        });
        barError.appendChild(item);
      }
    }

    /**
    * @description
    * Elimina los estilos CSS de las clases que indican el error en las celdas.
    */
    private restoreRowClassError() {
      let rows = document.getElementsByClassName("table__row--error");
      for (let i = 0; i < rows.length; i++) {
        rows[i].className = rows[i].className.replace(" table__row--error", "");
      }
    }

    /**
    * @description
    * Cuando se presiona un item de la barra de error, se le da la orden que
    * realice el scroll hasta la posición en la que se encuentra el registro del
    * error.
    */
    private scrollTableTo(valueScroll: number = 0) {
      let table: any = document.getElementById("scroll-regsTp02");
      table.scrollTop = valueScroll;
    }

    /**
    * @description
    * Realiza el scroll de la tabla fixed que tiene la información
    * de la cabecera y las columnas fijas si cuenta con ellas.
    */
    public actionScroll(event) {
      let positionLeft: number = -1 * event.path[0].scrollLeft;
      let positionTop: number = -1 * event.path[0].scrollTop;
      let tableFixRow = event.target.getElementsByClassName("table__fixed")[0];
      let tableFixColumn = event.target.parentNode.parentNode.getElementsByClassName("table__fixed-columns--data")[0];
      tableFixRow.style.left = positionLeft + "px";
      if (tableFixColumn) {
        tableFixColumn.style.top = positionTop + "px";
      }
    }

    /**
    * @private
    * @description
    * Ajusta el tamaño de las columnas de las tablas, lee el tamaño que tienen
    * las columnas de las tablas de scroll y le asigna el valor a la columna fixed.
    */
    private setWidthHead() {
      let scroll: any = document.getElementById(this.idTable);
      if (!scroll) return;
      let fixed: any = document.getElementById(`fix-${this.idTable}`);
      let thScroll: any = scroll.getElementsByTagName("th");
      let thFixed: any = fixed.getElementsByTagName("th");
      for (let i = 0; i < thScroll.length; i++) {
        thFixed[i].style.minWidth = `${thScroll[i].clientWidth}px`;
      }
      fixed.style.width = `${scroll.clientWidth}px`;
    }

    /**
    * @description
    * Cuando se presiona el boton de filtro de una cabecera de la tabla se
    * carga el input para filtrar valores en la celda.
    */
    public actionOpenFilter(event, position) {
      this.positionFilter = position;
      this.keyFilter[position] = Object.keys(this.data.registers[0])[position];
      this.showFilter = true;
      let positionLeft = event.pageX - 10;
      if (this.fixedColumns) {
        positionLeft = event.pageX - 300;
      }
      // Se valida si esta al borde derecho de la tabla para moverlo un poco
      // a la izquieda y permitir que se vea la ventana del filtro.
      if (window.innerWidth - event.pageX < 150) {
        positionLeft -= window.innerWidth - event.pageX;
      }
      let panelHide: any = document.getElementsByClassName("sett__right-content--without-panel");
      if (panelHide.length > 0) {
        positionLeft += 130;
      }
      let table: any = document.getElementById(`${this.idTable}`);
      let target: any = table.parentNode.parentNode.parentNode.parentNode.getElementsByClassName("table__filter")[0];
      target.style.left = positionLeft + "px";
      setTimeout(() => { this.listenerInputFilter(); });
    }

    /**
    * @private
    * @description
    * Carga el listener para detectar cuando se pierde el foco en el campo y
    * cerrar el contenedor emergente del input.
    */
    private listenerInputFilter() {
      let input = document.getElementById("table-filter");
      let inputReplace = document.getElementById("table-filter-replace");
      input.focus();
    }

    /**
    * @description
    * Cuando se ejecuta la orden de limpiar un campo de filtro, presionando
    * el boton de eliminar presente en el campo de filtro.
    */
    public actionDeleteFilter() {
      this.showFilter = false;
      delete this.objectFilter[this.keyFilter[this.positionFilter]];
      delete this.keyFilter[this.positionFilter];
      this.removeUndefinedKeys();
      setTimeout(() => {
        this.$scope.$digest();
      });
    }

    /**
    * @private
    * @description
    * Valida que el objeto de filtro no contenta elementos no definidos, si los
    * encuentra los elimina para evitar que la tabla de resultados quede vacia.
    */
    private removeUndefinedKeys(): void {
      for (let key of Object.keys(this.objectFilter)) {
        if (key === "undefined") {
          delete this.objectFilter[key];
        }
      }
    }

    /**
    * @description
    * Toma los registros que tiene el filtro y los reemplaza por el contenido
    * especificado en la celda.
    */
    public actionReplaceContent(): void {
      this.showFilter = true;
      let modelFilter = this.objectFilter[this.keyFilter[this.positionFilter]];
      let content = this.$filter("filter")(this.data.registers, this.objectFilter);
      content = this.$filter("filter")(content, this.onlyErrorsFilter);
      if (!this.inputFilterReplace || this.inputFilterReplace === "" || !modelFilter || modelFilter === "") return;
      let reg = new RegExp(modelFilter, "g");
      for (let register of content) {
        register[`regs${this.positionFilter}`] = register[`regs${this.positionFilter}`].replace(reg, this.inputFilterReplace);
        this.$rootScope.$broadcast("validate-register-table",register[`regs1`]-1);
      }
      if (this.inputFilterReplace !== "" && this.inputFilterReplace) {
        this.objectFilter[this.keyFilter[this.positionFilter]] = this.inputFilterReplace;
      }
      this.inputFilterReplace = null;
      this.showFilter = false;
      setTimeout(() => {
        this.$scope.$apply();
      });
    }

    // TODO extraer la función de paginado de la tabla
    public changeLimitRegister() {
      this.setCurrentRegisterLoaded();
      if (this.limitRegister < this.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE) {
        setTimeout(() => {
          this.limitRegister += this.OPTIONS.TABLES.ROW_LOAD_BY_PAGE;
          this.$scope.$digest();
        });
      }
    }

    /**
    * @description
    * Realiza el cambio de la pagina de la tabla.
    */
    public actionChangePage(orientation) {
      if (orientation === "next" && this.startLimit + this.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE < this.data.registers.length) {
        this.startLimit += this.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE;
      }
      if (orientation === "prev" && this.startLimit > 1) {
        this.startLimit -= this.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE;
      }
      setTimeout(() => {
        this.setCurrentRegisterLoaded();
        this.$scope.$digest();
      });
    }

    /**
    * @description
    * Actualiza la información de la cantidad de paginas cargadas.
    */
    private setCurrentRegisterLoaded() {
      this.currentNumberRegisterLoad = this.startLimit + this.limitRegister;
      if (this.currentNumberRegisterLoad > this.data.registers.length) {
        this.currentNumberRegisterLoad = this.data.registers.length;
      }
    }

    /**
    * @description
    * Pagina la tabla al inicio, esta función se utiliza cuando el filtro
    * se aplica para que quede al inicio de la tabla y no genere errores.
    */
    public actionPageToStart() {
      if (this.startLimit !== 0) {
        this.startLimit = 0;
      }
      this.removeUndefinedKeys();
      setTimeout(() => {
        if (this.keyFilter[this.positionFilter]) {
          if (this.objectFilter[this.keyFilter[this.positionFilter]].length === 0) {
            this.actionDeleteFilter();
          }
        }
      });
    }

    /**
    * @private
    * @description
    * Se activa por medio de un broadcast, realiza el cambio de pagina de la
    * tabla.
    *
    * @param {Number} numberPage - Numero de la pagina por la cual se cargan
    * los registros.
    * @param {Boolean} scrollBottom - Si es true se realiza un scroll automatico
    * al final de la tabla para mostrar el ultimo registros, de lo contrario
    * se conserva en la posición actual de la pagina.
    */
    private changePageTo(numberPage: number = 0, scrollBottom: boolean = false) {
      this.startLimit = this.OPTIONS.TABLES.ROW_LIMIT_BY_PAGE * numberPage;
      setTimeout(() => {
        this.setCurrentRegisterLoaded();
        this.$scope.$digest();
        if (scrollBottom) {
          this.scrollBottomTable();
        }
      });
    }

    /**
    * @private
    * @description
    * Toma el id actual de la tabla y captura la información del limite del
    * scroll vertical, luego con la información da la orde a la tabla para
    * realizar el scroll al final de la tabla.
    *
    * @see changePageTo()
    */
    private scrollBottomTable() {
      let idScroll = `scroll-${this.idTable}`;
      let sizeScroll = document.getElementById(idScroll).scrollHeight;
      document.getElementById(idScroll).scrollTop = sizeScroll;
    }

    /**
    * @description
    * Recorre el numero de secuencia del registro tipo 2 actual, le suma
    * un 1 para indicar la linea del archivo ya que el registro de tipo 1 esta
    * en la primera linea del documento.
    *
    * @param {Object} register - Registro actual de la tabla.
    * @return {Number} Numero de la linea del registro en el archivo.
    */
    public actionSetLine(register) {
      let line: number = parseInt(register.regs1) + 1;
      if (!register.regs1) {
        for (let i = 0; i < this.data.registers.length; i++) {
          if (angular.equals(this.data.registers[i], register)) {
            line = i + 1;
            break;
          }
        }
      }
      return line;
    }

    /**
    * @description
    * Consulta el valor de la llave primaria que identifica la fila
    */
    public valueRowId(item) {
      let key = Object.keys(item)[1];
      return item[key];
    }

  }

  // Se agrega el componente al modulo principal.
  let app: any = angular.module("PILA");
  app.component("tableEdit", {
    bindings: {
      labels: "<", // Nombre de las columnas
      data: "=", // Registros que debe tener la tabla.
      idTable: "<", // El id con el que se identifica la tabla como unica.
      activeFilter: "<", // indica si se usa el filtro por columnas en la tabla.
      editTable: "<", // Indica si la tabla se le permite editar la información.
      fixedColumns: "<", // Indica si se insertan dos columnas fijas, de seleccion y linea.
      selectedItem: "=", // Lista para indicar que inputs se seleccionan
      cellNoEdit: "<", // Indica que celdas de la tabla no se pueden editar.
      activeSubMenu: "<", // Indica si se debe activar la opción del submenu en la tabla
      objectFilter: "=", // Almacena la información de los registros visualizados en el filtro.
      onlyErrorsFilter: "=", // Almacena la información de los registros visualizados en el filtro.
      replaceActive: "<" // Indica si se debe reemplzar el contenido con el filtro
    },
    controller: TableEditController,
    templateUrl: "./components/table/table.html"
  });
}

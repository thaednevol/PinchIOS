
namespace app.support {

  /**
  * @class SupportTableController
  * @author Cristian Camilo Zapata <czapata@swat-it.co>
  * @description
  * La clase se encarga de controlar las acciones de la tabla, realiza la carga
  * del componente de tabla-edit.
  */
  class SupportTableController {

    /**
    * @type {Array<Number>} cellNoEdit - Indica las celdas que no se editaran
    * en la tabla que se carga.
    */
    public cellNoEdit: number[] = [0, 1, 2];

    /**
    * @type {Boolean} showLoading - Indica si debe mostrar la imagen de loading
    * y bloquear la pantalla hasta que el proceso ejecutado finalice
    */
    public showLoading: Boolean = false;

    /**
    * @type {Object} selectedItem - Almacena la información de la celdas que
    * se selecciona en el momento.
    */
    public selectedItem: any = {};

    /**
    * @type {Object} labelsTable - El objeto almacena los keys de los campos
    * que debe mostrar la tabla y el nombre del label de la cabecera.
    */
    public labelsTable: any = null;

    /**
    * @type {Array<Object>} listContributors - Variable que almacena la lista de
    * empleados asociados a la planilla de pago para cargarlos en la tabla de
    * edición de correos.
    */
    public listContributors: any = [];

    /**
    * @type {Object} listEmailsContributors - Almacena el contenido del archivo
    * que contiene la lista de contribuidores y los emails asociados.
    */
    public listEmailsContributors: any = {};

    /**
    * @type {NativeWindowService} dialog - Servicio encargado de manipular las
    * ventanas nativas del sistema operativo, puede abrir ventanas de dialogo
    * para guardar o abrir archivos.
    */
    private dialog: any;

    /**
    * @type {NativeFileService} file - Manipula los archivos que se encuentran
    * almacenados en la carpeta del programa.
    */
    private file: any;

    /**
    * @type {NativeNotificationService} notificationService - Servicio para
    * mostrar mensajes de notificaciones del sistema nativas.
    * @see app.native.NativeNotificationService
    */
    private notificationService: any;

    /**
    * @type {SoiService} soi - Servicio con funciones de llamado de SOI.
    * @see app.native.SoiService
    */
    private soi: any;

    /**
    * @type {Object} OPTIONS - Equivale al archivo de opciones del sistema.
    * @see app/webapp/json/data/options.json
    */
    private OPTIONS: any;

    /**
    * @type {Boolean} dialogIsOpen - Indica si la ventana de dialog cualquiera
    * se encuentra abierta para evitar abrir una de nuevo, cuando se cierra
    * la ventana el valor de la variable cambia para poder abrir una de nuevo.
    */
    private dialogIsOpen: boolean = false;

    /**
    * @type {Boolean} isLoadedListContributors - Indica si se realizo la carga
    * de una planilla con la lista de los contribuidores en la tabla, se utiliza
    * para validar el evento del doCheck de angular y evitar que se repita.
    */
    private isLoadedListContributors: boolean = false;

    private $scope: any;
    private $filter: any;

    /**
    * @type {Object} objectFilter - Lista de opciones o palabras para filtrar
    */
    public objectFilter: any = {};

    static $inject = ["OPTIONS", "native.notification.service", "jar.soi.service", "native.dialog.service", "native.file.service", "$scope", "$filter"];

    constructor(OPTIONS, notificationService, soi, dialog, file, $scope, $filter) {
      this.OPTIONS = OPTIONS;
      this.notificationService = notificationService;
      this.soi = soi;
      this.dialog = dialog;
      this.file = file;
      this.$scope = $scope;
      this.$filter = $filter;
      this.$scope.$on("action-clear-inputs-table", (event: any, position: number) => {
        this.editContentTable(position);
      });
    }

    $doCheck() {
      if (this.listContributors.registers && !this.isLoadedListContributors) {
        this.isLoadedListContributors = true;
        this.assingEmails();
      }
    }

    /**
    * @private
    * @description
    * Se ejecuta despues de finalizar la edición de una celda de la tabla,
    * se realiza la validación del campo si la información del email es correcta.
    */
    private editContentTable(position: number): void {
      let contributor: any = this.listContributors.registers[position];
      if (this.isEmailCorrect(contributor.email)) {
        delete this.listContributors.errors[contributor.number];
        let key: string = `${contributor.type}${contributor.number}`;
        this.listEmailsContributors[key] = contributor.email;
        this.saveFileEmailsContributors();
      } else {
        this.listContributors.errors[contributor.number] = { 4: true };
      }
    }

    /**
    * @private
    * @description
    * Aplica una validación re expresión regular para identificar si el
    * valor es un email valido.
    *
    * @param {String} email - Email para validar
    * @return {Boolean} true indica que es un valor valido para un email.
    */
    private isEmailCorrect(email: string): boolean {
      return /^\w+([\.\+\-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/.test(email);
    }

    /**
    * @description
    * Lee un archivo CSV para carga los emails de los contribuidores.
    */
    public actionAddEmail(): void {
      if (this.dialogIsOpen) return;
      this.dialogIsOpen = true;
      let result = this.dialog.openFile();
      if (!result) return;
      result.then((path) => {
        if (!path) return;
        this.showLoading = true;
        // Si no cumple con el formato del archivo este no se sube y muestra el mensaje de error
        if (!this.soi.formatFileValidCSV(path[0])) {
          this.notificationService.show(this.$filter("translate")("MESSAGES.TITLES.ERROR"), this.$filter("translate")("MESSAGES.FORMAT_INVALID_CSV"));
          this.dialogIsOpen = false;
          this.showLoading = false;
          return;
        }
        let resultCSV = this.file.csvToJson(path[0]);
        resultCSV.then((data) => {
          if (data) {
            this.converCSVToObject(data);
          } else {
            this.dialogIsOpen = false;
            this.showLoading = false;
          }
        });
      });
    }

    /**
    * @private
    * @description
    * Modifica la estructura del Object CSV uniendo field1 y field2 como una
    * key que almacena el field3, el resultado es concatenado al objeto existente
    * que contiene la información del archivo de emails.
    *
    * @param {Array<Object>} csv - Contenido del archivo CSV en formato JSON.
    */
    private converCSVToObject(csv: any[]): void {
      this.showLoading = true;
      for (let register of csv) {
        let key: string = `${register.field1}${register.field2}`;
        this.listEmailsContributors[key] = register.field3;
      }
      this.saveFileEmailsContributors();
      this.assingEmails();
      this.dialogIsOpen = false;
      this.showLoading = false;
    }

    /**
    * @private
    * @description
    * Alamcena la información de los emails de los contribuidores que son
    * agregados por un archivo CSV o ingresados manualmente en el archivo de
    * opciones.
    */
    private saveFileEmailsContributors(): void {
      this.file.createFileOptions(this.OPTIONS.FILES.EMAILS_CONTRIBUTORS, this.listEmailsContributors);
    }

    /**
    * @private
    * @description
    * Asigna los emails a los registros de los usuarios que coinciden con los
    * almacenados en el documento de la lista de emails de la variable
    * listEmailsContributors.
    */
    private assingEmails(): void {
      this.showLoading = true;
      for (let register of this.listContributors.registers) {
        let key = `${register.type}${register.number}`;
        if (this.listEmailsContributors.hasOwnProperty(key)) {
          register.email = this.listEmailsContributors[key];
          delete this.listContributors.errors[register.number];
        }
      }
      this.showLoading = false;
      setTimeout(() => {
        this.$scope.$digest();
      });
    }

    /**
    * @description
    * Acción de la vista que da la orden de eliminar los registros seleccionados
    * se extrae las keys del modelo de los checkbox y se reinicia la variable.
    */
    public actionDeleteContributor(): void {
      if (Object.keys(this.selectedItem).length === 0) {
        return;
      }
      if (this.dialogIsOpen) return;
      this.dialogIsOpen = true;
      // Se agerga el mensaje para la ventana de confirmación de eliminar.
      let message = `Se eliminar\u00E1 ${Object.keys(this.selectedItem).length} registro.`;
      if (Object.keys(this.selectedItem).length > 1) {
        message = `Se eliminar\u00E1n ${Object.keys(this.selectedItem).length} registros.`;
      }
      // Se muestra la ventana de dialog de confirmación de eliminar registros.
      this.dialog.showDialogConfirm(
        "Eliminar registros",
        message,
        (option) => {
          this.dialogIsOpen = false;
          this.confirmDeleteRegister(option);
        }
      );
    }

    /**
    * @private
    * @description
    * Valida si la respuesta de la ventana que indica que se debe eliminar los
    * registros es correcta, si lo es procede a eliminar los registros de la
    * tabla ajustando en un array los identificadores seleccionados, por estar
    * integrado en un modelo se debe de hacer la validación con un if del valor
    * boolean del modelo del checkbox.
    *
    * @param {Number} option - Resultado de presionar el boton de las opciones
    * de la ventana de dialog.
    */
    private confirmDeleteRegister(option: number): void {
      if (option === 1) {
        let positionDelete = [];
        // Se recorre el array de los registros que estan seleccionados para
        // su eliminación.
        for (let i = 0; i < Object.keys(this.selectedItem).length; i++) {
          let key = Object.keys(this.selectedItem)[i];
          if (this.selectedItem[key]) {
            positionDelete.push(parseInt(key));
          }
        }
        this.selectedItem = {};
        this.deleteItemsArray(positionDelete);
      }
    }

    /**
    * @private
    * @description
    * Recorre el arreglo con las posiciones para eliminar los registros de
    * contribuidores.
    *
    * @param {Array<Number>} positionDelete - Lista de numero de secuencia
    * de registros para eliminar.
    */
    private deleteItemsArray(positionDelete: any[]): void {
      for (let i = 0; i < positionDelete.length; i++) {
        let currentPosition = positionDelete[i] - i;
        this.listContributors.registers.splice(currentPosition, 1);
      }
      setTimeout(() => {
        this.$scope.$digest();
      });
    }

    /**
    * @description
    * Muestra un tooltip con información de la acción que ejecuta el boton.
    */
    public actionShowTooltip(event) {
      let target = event.target.children[0];
      if (target) {
        target.style.display = "block";
      }
    }

    /**
    * @description
    * Oculta el tooltip del boton.
    */
    public actionHideTooltip(event) {
      let target = event.target.children[0];
      if (target) {
        target.style.display = "none";
      }
    }

  }

  // Declaración del componente.
  let app: any = angular.module("PILA");
  app.component("supportTable", {
    controller: SupportTableController,
    bindings: {
      labelsTable: "=", //lista de texto de la cabecera de la tabla.
      listContributors: "=", //lista de los contribuidores de la plantilla.
      listEmailsContributors: "=", // Lista de contribuidores con su email vinculado.
      showLoading: "=" // Muestra la ventana de precarga cuando se realzia un proceso como validar emails.
    },
    templateUrl: "./components/support/support.table.html"
  });
}

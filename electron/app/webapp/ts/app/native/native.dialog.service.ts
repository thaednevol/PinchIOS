/// <reference path="../../dt/angular.d.ts"/>
/// <reference path="../../dt/Promise.d.ts"/>
/// <reference path="../../dt/node.d.ts"/>

namespace app.native {

  /**
   * @class NativeDialogService
   * @author Luis Felipe Zapata Castaño <lzapata@swat-it.co>
   * @description
   * Clase encargada de gestionar la carga de ventanas nativas que se requieran
   * para cargar o guardar archivos, mensajes de alerta o información.
   */
  class NativeDialogService {

    /**
    * @type {Boolean} dialogEnabled - Si una ventana de dialog esta activa,
    * bloquea la carga de otra, los metodos que hagan el llamado recibiran
    * null en caso de que se trate de abrir un dialog nuevo si ya hay uno
    * en la pantalla.
    */
    private dialogEnabled: boolean = false;

    private ipcRender: any = require("electron").ipcRenderer;
    private ipcMain: any = require("electron").remote.ipcMain;
    private dialog: any = require("electron").remote.dialog;
    private $filter: any;
    static $inject = ["$filter"];

    constructor($filter) {
      this.$filter = $filter;
    }

    /**
    * @description
    * Abre la ventana de dialogo que permite buscar y agregar un archivo, retorna
    * una promesa en la cual va incluido el path del archivo en el sistema.
    *
    * @return {Promise|null} Solo retorna el metodo resolve con el path del archivo
    * o null en caso de un error.
    */
    public openFile(): any {
      if (this.dialogEnabled) return null;
      this.dialogEnabled = true;
      this.createMainOpenFile();
      this.ipcRender.send("dialog-open-file");
      return new Promise((resolve) => {
        // Acción cuando se presiona el boton de aceptar de la ventana.
        this.ipcRender.once("dialog-open-file-selected-file", (event, path) => {
          resolve(path);
        });
        // Cuando se presiona el boton de cancelar de la ventana.
        this.ipcRender.once("dialog-open-file-no-selected-file", (event, path) => {
          resolve(null);
        });
      });
    }

    /**
    * @private
    * @description
    * Crea la función que permite asignar la ventana de dialog en el proceso
    * principal de electron para abrir un archivo.
    */
    private createMainOpenFile() {
      this.ipcMain.on("dialog-open-file", (event) => {
        this.dialog.showOpenDialog({
          properties: ["openFile"]
        }, (file) => {
          // Asignan opciones si se cancel la orden por cerrar la ventana.
          if (file) {
            event.sender.send("dialog-open-file-selected-file", file);
          } else {
            event.sender.send("dialog-open-file-no-selected-file", file);
          }
        });
        this.dialogEnabled = false;
        this.ipcMain.removeAllListeners("dialog-open-file");
      });
    }

    /**
    * @description
    * Abre la ventana de dialog para indicar donde se debe almacenar un archivo.
    *
    * @param {String} format - Extensión que tiene el archivo que se graba.
    * @return {Promise|null} Solo retorna el metodo resolve con el path del archivo
    * o null en caso de un error.
    */
    public saveFile(format: string = "txt"): any {
      if (this.dialogEnabled) return null;
      this.dialogEnabled = true;
      this.createMainSaveFile();
      // Se realiza el llamado al componente creado de la vista de dialog.
      this.ipcRender.send("dialog-save-file");
      return new Promise((resolve, reject) => {
        // Acción cuando se presiona el boton de aceptar de la ventana.
        this.ipcRender.once("dialog-save-file-selected-file", function(event, path) {
          resolve(`${path}.${format}`);
        });
        // Acción si se cancela la odren de grabar
        this.ipcRender.once("dialog-save-file-no-selected-file", function(event, path) {
          resolve(null);
        });
      });
    }

    /**
    * @private
    * @description
    * Crea la función que permite asignar la ventana de dialog en el proceso
    * principal de electron para guardar un archivo.
    */
    private createMainSaveFile(): void {
      this.ipcMain.on("dialog-save-file", (event) => {
        this.dialog.showSaveDialog({}, (files) => {
          // Asignan opciones si se cancel la orden por cerrar la ventana.
          if (files) {
            event.sender.send("dialog-save-file-selected-file", files);
          } else {
            event.sender.send("dialog-save-file-no-selected-file", files);
          }
          this.dialogEnabled = false;
          this.ipcMain.removeAllListeners("dialog-save-file");
        });
      });
    }

    /**
    * @description
    * Muestra un mensaje de error con el diseño del sistema operativo.
    * Despues de abrir la ventana se eliminan los listener asignados al
    * proceso principal.
    *
    * @param {String} title - Texto de la cabecera que se muestra en la ventana
    * de confirmación.
    * @param {String} message - Texto del mensaje de la ventana.
    */
    public showDialogError(title: string, message: string): void {
      this.ipcMain.on("open-error-dialog", (event) => {
        this.dialog.showErrorBox(title, message);
      });
      this.ipcRender.send("open-error-dialog");
      this.ipcMain.removeAllListeners("open-error-dialog");
    }

  
    /**
    * @description
    * Entrega una ventana donde se solicita una confirmación de una acción,
    * presenta dos opciones, si y no. Despues de abrir la ventana se eliminan
    * los listener asignados al proceso principal.
    *
    * @param {String} title - Texto de la cabecera que se muestra en la ventana
    * de confirmación.
    * @param {String} message - Texto del mensaje de la ventana.
    * @param {Function} callback - Función a ejecutar despues de que se cierra
    * la ventana de confirmación.
    */
    public showDialogConfirm(title: string, message: string, callback: any): void {
      this.ipcMain.on("open-confirm-dialog", (event) => {
        this.dialog.showMessageBox({
          buttons: [
            this.$filter("translate")("MESSAGES.DIALOGS.ACTION_MESSAGE_BOX.NO"),
            this.$filter("translate")("MESSAGES.DIALOGS.ACTION_MESSAGE_BOX.YES")
          ],
          title: title,
          message: message
        }, callback);
      });
      this.ipcRender.send("open-confirm-dialog");
      this.ipcMain.removeAllListeners("open-confirm-dialog");
    }

  }

  // Se agerga el servicio al componente principal
  let app: any = angular.module("PILA");
  app.service("native.dialog.service", NativeDialogService);
}

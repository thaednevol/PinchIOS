
namespace app.native {

  /**
   * @class NativeNotificationService
   * @author Luis Felipe Zapata Castaño <lzapata@swat-it.co>
   * @description
   * Clase enargada de manejar las notificaciones que se utilizan en la
   * aplicación para informar al usuario de eventos, las notificaciones son
   * tipo toast, en el caso de windows 7 y 8 son notificaciones usando el globo
   * de la barra de tareas.
   *
   * @see {@link https://nodejs.org/api/path.html#path_path_join_paths|path}
   * @see {@link https://nodejs.org/api/os.html#os_os_release|os}
   * @see {@link https://nodejs.org/api/process.html#process_process_platform|platform}
   * @see {@link https://www.npmjs.com/package/node-notifier|node-notifier}
   */
  class NativeNotificationService {

    /**
    * @type {Array<String>} titles - Lista de los textos que se muestran en el
    * titulo de la notificación.
    */
    private titles: string[] = [];

    /**
    * @type {Array<String>} messages - Lista de los mensajes que se muestran
    * en las notificaciones.
    */
    private messages: string[] = [];

    /**
    * @type {String} urlLogo - Ruta donde se almacena el archivo del logo de
    * la aplicación para utilizar en el tema de notificaciones.
    * @see this.getFileOptions();
    */
    private urlLogo: string = null;

    /**
    * @type {Array} versionOs - Indica el numero de versión del sistema
    * operativo, se utiliza para identificar principalmente la versión de
    * windows.
    */
    private version: number[] = [];

    /**
    * @type {Object} OPTIONS - Almacena las constantes del archivo de opciones
    * de la aplicación.
    * @see app/webapp/json/data/options.json
    */
    private OPTIONS: any;

    /**
    * @type {Boolean} notificationActive - Indica si la notificación esta
    * activa para evitar que se se carguen otras notificaciones encima.
    */
    private notificationActive: boolean = false;

    /**
    * @type {Object} notifier - Plugin o modulo de nodejs que permite realizar
    * la ejecución de notificaciones nativas.
    */
    private notifier: any = require("node-notifier");

    private path = require("path");
    private os = require("os");
    static $inject = ["OPTIONS"];

    /**
    * @constructor NativeNotificationService
    * @description
    * Captura la información de la versión del sistema operativo almacenando
    * el valor numerico en un array para poder comparar los dos primeros
    * digitos de la versión.
    */
    constructor(OPTIONS) {
      this.OPTIONS = OPTIONS;
      this.version = this.os.release().split(".");
      this.urlLogo = this.path.join(__dirname, "..", this.OPTIONS.NOTIFICATIONS.LOGO);
    }

    /**
    * @description
    * Muestra una notificación nativa, agrega el texto del mensaje y el titulo
    * dentro de un array para ir cargando cada mensaje en la forma que se van
    * agregando a la cola, si se pasan todos al mismo tiempo serian sobre
    * escritos y solo seria visible el ultimo.
    *
    * @param {String} title - Titulo de la notificación.
    * @param {String} message - Texto que se muestra en la notificación.
    */
    public show(title: string, message: string): void {
      this.titles.push(title);
      this.messages.push(message);
      // Si no hay notificaciones activas, se da la orden de cargar la primera.
      if (!this.notificationActive) {
        this.notificationActive = true;
        if (/^win/.test(process.platform)) {
          // Se agrega la validación de versión unicamente en windows.
          // en el momento la versión de windows 8 es 6.3, por problemas en las
          // notificaciones HTML5 para windows 8 y no agregar plugins extra se
          // dejan las notificaciones balloon
          if (this.version[0] <= 6 && this.version[1] <= 3) {
            let WindowsBalloon: any = require('node-notifier').WindowsBalloon;
            this.notifier = new WindowsBalloon();
          }
        }
        this.showNotificationHTML();
      }
    }

    /**
    * @private
    * @description
    * Muestra una notificación personalizada en el sistema, agrega el icono,
    * titulo y mensaje, para windows se agrea el identificador de la aplicación.
    */
    private showNotificationHTML(): void {
      let options = {
        message: this.messages.shift(),
        title: this.titles.shift(),
        icon: this.urlLogo,
        appID: this.OPTIONS.APP_ID
      };
      this.notifier.notify(options);
      // Se le asigna el tiempo que permanece visible antes de cargar la siguiente.
      setTimeout(() => {
        this.notificationsInWait();
      }, this.OPTIONS.NOTIFICATIONS.TIME_ACTIVE);
    }

    /**
    * @private
    * @description
    * Valida si existen notificaciones en cola para mostrar, si existen
    * ejecuta el llamado al metodo showNotificationHTML.
    */
    private notificationsInWait(): void {
      if (this.messages.length > 0) {
        this.showNotificationHTML();
      } else {
        this.notificationActive = false;
      }
    }

  }

  // Se vincula el servicio al modulo principal de la aplicación.
  let app: any = angular.module("PILA");
  app.service("native.notification.service", NativeNotificationService);
}

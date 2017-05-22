/// <reference path="../../dt/angular.d.ts"/>

namespace app.dashboard {

  /**
  * @class DashboardNotificationController
  * @author Luis Felipe Zapata <lzapata@swat-it.co>
  * @description
  * Muestra las notificaciones en el panel principal, por regla de negocio solo
  * se deben mostrar 10, exectuando las que tengan prioridad de visibilidad.
  * Las fechas de las notificaciones esta definida por DD/MM/YYYY
  */
  class DashboardNotificationController {

    /**
    * @type {Array<Object>} listNotifications - Almacena las notificaciones que se
    * deben mostrar en la interfaz.
    * Los objectos del array tienen la siguiente estructura:
    * {
    *  notificationMessage: "Message",
    *  severity: "ERROR|WARNING|INFO",
    *  type: "HIGH-PRIORITY|LOW-PRIORITY",
    *  maxDate: "12/12/2017",
    *  actions: "update",
    *  url: "www.paginaweb.com"
    * }
    * La fecha de notificaciones esta definida por DD/MM/YYYY
    */
    public listNotifications: any = [];

    /**
    * @type {LoginTokenService} token - Valida el estado del token, de estar
    * vencido realiza una solicitud de un token.
    * @see app.login.LoginTokenService
    */
    private token: any;

    /**
    * @type {SwatService} swat - Consulta los servicios que utiliza los JAR de
    * Swat para la aplicación.
    * @see app.jar.SwatService
    */
    private swat: any

    /**
    * @type {NativeFileService} file - Manipula los archivos que se encuentran
    * almacenados en la carpeta del programa.
    * @see app.native.NativeFileService
    */
    private file: any;

    /**
    * @type {NativeNotificationService} nativeNotification - Clase que se encarga
    * de mostrar notificaciones por medio de alerts nativos.
    * @see app.native.NativeNotificationService
    */
    private nativeNotification: any;

    /**
    * @type {Object} OPTIONS - Equivale al archivo de opciones del sistema.
    * @see app/webapp/json/data/options.json
    */
    private OPTIONS: any;

    private $localStorage: any;
    private $scope: any;
    private $filter: any;
    static $inject = ["jar.swat.service", "login.token.service", "native.file.service", "native.notification.service", "OPTIONS", "$localStorage", "$scope", "$filter"];

    constructor(swat, token, file, nativeNotification, OPTIONS, $localStorage, $scope, $filter) {
      this.swat = swat;
      this.token = token;
      this.file = file;
      this.nativeNotification = nativeNotification;
      this.OPTIONS = OPTIONS;
      this.$localStorage = $localStorage;
      this.$scope = $scope;
      this.$filter = $filter;
      // Se valida el token antes de realizar la petición al servidor.
      this.token.validate(() => { this.getNotificationServer(); }, () => { this.getFileNotification(); });
      this.getFileNotification();
    }

    /**
    * @private
    * @description
    * Realiza el llamado a un metodo JAR que consulta en el servidor si existen
    * notificaciones para descargar.
    */
    private getNotificationServer() {
      let result = this.swat.notificationsServer();
      result.then((data) => {
        if (data.code === "00") {
          this.validateTimeNotifications(data.notificationDetails);
          this.saveFileNotification(data.notificationDetails);
        }
      });
    }

    /**
    * @private
    * @description
    * Almacena una notificación en el archivo de notificaciones.
    *
    * @param {Object} dataNotification - Información de las notificaciones
    * del servidor.
    */
    private saveFileNotification(dataNotification) {
      this.file.createFileOptions(this.OPTIONS.FILES.NOTIFICATIONS, dataNotification);
    }

    /**
    * @private
    * @description
    * Consulta el archivo con la lista de notificaciones almacenadas en el
    * equipo, son notificaciones locales.
    */
    private getFileNotification() {
      let pathFile = this.file.getPathOptions(this.OPTIONS.FILES.NOTIFICATIONS);
      if (pathFile) {
        let result = this.file.getContentFileJson(pathFile);
        result.then((data) => {
          this.validateTimeNotifications(data);
        });
      } else {
        this.validateNotificationsLocal();
      }
    }

    /**
    * @private
    * @description
    * Compara el tiempo del equipo con el tiempo maximo programado para mostrar
    * las notificaciones, en caso de que lo supere es eliminada del array, si
    * cumple con el tiempo se agrega al array, siempre que este no supere el
    * limite permitido de 10 notificaciones visibles.
    */
    private validateTimeNotifications(notification: any) {
      let arrayNotification: any = [];
      let dateApp: any = new Date();
      for (let currentNotification of notification) {
        let arrayDate = currentNotification.maxDate.split("-");
        let dateNotification = new Date(`${arrayDate[1]}/${arrayDate[0]}/${arrayDate[2]}`);
        // Si la notificación es de alta prioridad se agrega asi la fecha no sea correcta.
        if (dateApp.getTime() < dateNotification.getTime() || currentNotification.type === "HIGH-PRIORITY") {
          arrayNotification.push(currentNotification);
        }
      }
      this.listNotifications = arrayNotification;
      this.validateNotificationsLocal();
      this.$scope.$digest();
    }

    /**
    * @private
    * @description
    * consulta las opciones y configuración de la aplicación para ver que
    * opciones deben ser notificadas al usuario.
    */
    private validateNotificationsLocal() {
      // Valdia si exite conexión a internet, si no hay notifica.
      if (!navigator.onLine) {
        this.addLocalNotification(this.$filter("translate")("MESSAGES.NO_INTERNET"));
      }
    }

    /**
    * @private
    * @description
    * Agrega una notificación local al inicio de las demas notificaciones.
    */
    private addLocalNotification(message: string, type: string = "WARNING") {
      let noInternet = {
        notificationMessage: message,
        severity: type,
        type: "HIGH-PRIORITY",
        url: ""
      };
      this.listNotifications.unshift(noInternet);
    }

    /**
    * @description
    * Abre la ventana del navegador con el enlace de la notificación.
    *
    * @param {String} link - Enlace para abrir en el navegador.
    */
    public actionOpenLink(link: string) {
      let open: any = require("open");
      open(link);
    }

  }

  // Vincula el componente al modulo principal
  let app: any = angular.module("PILA");
  app.component("dashboardNotification", {
    controller: DashboardNotificationController,
    templateUrl: "./components/dashboard/dashboard.notification.html"
  });
}

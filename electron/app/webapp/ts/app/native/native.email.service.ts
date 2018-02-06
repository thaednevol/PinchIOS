
namespace app.native {

  /**
   * @class NativeEmailService
   * @author Luis Felipe Zapata Castaño <lzapata@swat-it.co>
   * @description
   * La clase manipula las funciones de envio de emails haciendo uso del plugin
   * de nodeMailer, la clase solo realizara un test de conexión de una
   * configuración de email como función principal.
   *
   * @see {@link https://nodemailer.com|nodemailer}
   */
  class NativeEmailService {

    /**
    * @type {Object} nodemailer - Plugin encargado de controlar los servicios
    * de email con el protocolo SMTP.
    */
    private nodemailer: any = require("nodemailer");

    /**
    * @type {NativeNotificationService} notification - Clase que se encarga
    * de mostrar notificaciones por medio de alerts nativos.
    * @see app.native.NativeNotificationService
    */
    private notification: any;

    private $filter: any;
    static $inject = ["native.notification.service", "$filter"];

    constructor(notification, $filter) {
      this.notification = notification;
      this.$filter = $filter;
    }

    /**
    * @description
    * Realiza una prueba de conexión al servicio de email con el protocolo
    * SMTP.
    *
    * @param {Object} [options={}] - Almacena las opciones de configuración que
    * recibe el servicio de nodemailer para realizar el test de conexión.
    * @return {Promise} La promesa solo tiene el metodo resolve, retornará un
    * true en caso de éxito y undefined en caso de error.
    * @example
    * Estructura requerida para la variable de opciones.
    * <pre>
    *   let options = {
    *     host: "smtp.gmail.com",
    *     port: 587,
    *     secure: false,
    *     auth: {
    *        user: "email@gmail.com",
    *        pass: "clave"
    *     }
    *   };
    * </pre>
    */
    public testSMTP(options: any = {}): any {
      return new Promise((resolve) => {
        let transport = this.nodemailer.createTransport(options);
        transport.verify((error, success) => {
          this.detailError(error);
          resolve(success);
        });
      });
    }

    /**
    * @private
    * @description
    * Entrega un mensaje de notificación indicando el estado de la operación,
    * si presenta un error se realiza un indexOf para identificar que contiene
    * el mensaje de error, con esto se le notifica al usuario si es un error
    * por configuración del servidor o usuario y contraseña malos.
    *
    * @param {Object} error - Es el evento retornado por el evento verify del
    * plugin de nodemailer.
    * @return {Object} Información sobre el error retornado.
    */
    private detailError(error: any): any {
      let title = this.$filter("translate")("MESSAGES.TITLES.INFO");
      let message = this.$filter("translate")("MESSAGES.EMAIL_GOOD");
      if (error) {
        title = this.$filter("translate")("MESSAGES.TITLES.ERROR");
        message = this.$filter("translate")("MESSAGES.EMAIL_SERVER_BAD");
        if (error.toString().indexOf("Invalid login") !== -1) {
          message = this.$filter("translate")("MESSAGES.EMAIL_USER_PASSWORD_BAD");
        }
        if (error.toString().indexOf("ECONNREFUSED") !== -1) {
          message = this.$filter("translate")("MESSAGES.EMAIL_SERVER_NO_CONNECT");
        }
      }
      this.notification.show(title, message);
    }

  }

  // Se agerga el servicio al modulo principal de la aplicación.
  let app: any = angular.module("PILA");
  app.service("native.email.service", NativeEmailService);
}


namespace app.login {

  /**
   * @class LoginTokenService
   * @author Luis Felipe Zapata Castaño <lzapata@swat-it.co>
   * @description
   * Realiza las validaciones del token del usuario, de ser el caso realiza
   * nuevamente el registro en la aplicación.
   */
  class LoginTokenService {

    /**
    * @type {NativeNotificationService} nativeNotification - Clase que se encarga
    * de mostrar notificaciones por medio de alerts nativos.
    * @see app.native.NativeNotificationService
    */
    private nativeNotification: any;

    /**
    * @type {SwatService} swat - Consulta los servicios que utiliza los JAR de
    * Swat para la aplicación.
    * @see app.jar.SwatService
    */
    private swat: any;

    private $resource: any;
    private $localStorage: any;
    private $filter: any;
    static $inject = ["jar.swat.service", "$resource", "$localStorage", "$filter", "native.notification.service"];

    constructor(swat, $resource, $localStorage, $filter, nativeNotification) {
      this.swat = swat;
      this.$resource = $resource;
      this.$localStorage = $localStorage;
      this.$filter = $filter;
      this.nativeNotification = nativeNotification;
    }

    /**
    * @description
    * Realiza el llamado a una función del servicio JAR que valida el estado
    * del token del usuario, si el token es invalido se realiza el login
    * de nuevo y se continua con el proceso de carga.
    *
    * @param {Function} callbackSuccess - Función de retorno cuando el proceso
    * que se realiza es correcto.
    * @param {Function} callbackError - Función de retorno cuando hay un error
    * en la respuesta del servidor.
    */
    public validate(callbackSuccess: any, callbackError: any = null) {
      let result = this.swat.validateToken();
      result.then((data) => {
        if (data.code !== "00") {
          this.getNew(callbackSuccess, callbackError);
        } else {
          callbackSuccess();
        }
      }, (error) => {
        if (callbackError) callbackError();
      });
    }

    /**
    * @private
    * @description
    * Extrae la información de la cuenta del usuario almacenada en el localStorage
    * para realizar de nuevo la petición de login.
    *
    * @param {Function} callbackSuccess - Función de retorno cuando el proceso
    * que se realiza es correcto.
    * @param {Function} callbackError - Función de retorno cuando hay un error
    * en la respuesta del servidor.
    */
    private getNew(callbackSuccess: any, callbackError: any = null) {
      let result = this.swat.login(this.$localStorage.login);
      result.then((data) => {
        if (data.code === "00") {
          this.$localStorage.token = data.token;
          callbackSuccess();
        } else {
          if (callbackError) callbackError();
          let titleError = this.$filter("translate")("MESSAGES.TITLES.ERROR");
          this.nativeNotification.show(titleError, data.message);
        }
      });
    }

  }

  // Carga del servicio al modulo principal
  let app: any = angular.module("PILA");
  app.service("login.token.service", LoginTokenService);
}

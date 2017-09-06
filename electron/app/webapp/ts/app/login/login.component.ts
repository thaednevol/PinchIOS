/// <reference path="../../dt/angular.d.ts"/>

namespace app.login {

  /**
  * @class LoginController
  * @author Luie Felipe Zapata <lzapata@swat-it.co>
  * @description
  * Componente que se encarga de gestionar el formulario y validaciones para
  * permitir el login con del usuario, registrando los datos de la cuenta en
  * la variable local en caso de que sean correctos para ser utilizados en
  * la sesión actual.
  */
  class LoginController {

    /**
    * @type {Boolean} showLoading - Indica si debe mostrar la imagen de loading
    * y bloquear la pantalla hasta que espere el usuario que termine la carga
    * del login.
    */
    public showLoading: Boolean = false;

    /**
    * @type {String} messageError - Mensaje de cuando el proceso de login
    * presenta errores, el mensaje es mostrado debajo de los campos del formulario.
    */
    public messageError: String = null;

    /**
    * @type {NativeNotificationService} nativeNotification - Clase que se encarga
    * de mostrar notificaciones por medio de alerts nativos.
    * @see app.native.NativeNotificationService
    */
    private nativeNotification: any;

    /**
    * @type {SwatService} swat - Clase de consulta de metodos JAR desarrollados
    * por Swat.
    * @see app.jar.SwatService
    */
    private swat: any;

    /**
    * @type {Array<Objet>} listCompany - Almacena la lista para utilizar en el
    * select de tipo de empresa.
    */
    private listCompany: any[];

    /**
    * @type {Array<Objet>} listUser - Almacena la lista para utilizar en el
    * select de tipo de información de la persona.
    */
    private listUser: any[];

    /**
    * @type {Object<Object>} form - Datos utilizados en el formulario de login
    * como modelos.
    */
    private form: any;

    /**
    * @type {Object} errorForm - Indica que campos presentan error para realizar
    * la carga del estilo.
    */
    private errorForm: any = null;

    /**
    * @type {Object} FORMS -  Equivale al archivo de formularios del sistema.
    * @see app/webapp/json/data/forms.json
    */
    private FORMS: any;

    /**
    * @type {Boolean} showConfigProxy - Indica si se debe hacer visible el
    * formulario de configuracion de proxy.
    */
    public showConfigProxy: Boolean = false;

    private $localStorage: any;
    private $state: any;
    private $rootScope: any;
    private $scope: any;
    private $filter: any;
    static $inject = ["jar.swat.service", "native.notification.service", "FORMS", "$localStorage", "$state", "$rootScope", "$scope", "$filter"];

    constructor(swat, nativeNotification, FORMS, $localStorage, $state, $rootScope, $scope, $filter) {
      this.swat = swat;
      this.nativeNotification = nativeNotification;
      this.FORMS = FORMS;
      this.$localStorage = $localStorage;
      this.$state = $state;
      this.$rootScope = $rootScope;
      this.$scope = $scope;
      this.$filter = $filter;
      this.$rootScope.userLogin = true;
      this.defaultValueForm();
      this.loadListForm();
      // Se valdia si existe conexión a internet para notificarle al usuario.
      if (!navigator.onLine) {
        this.nativeNotification.show(this.$filter("translate")("MESSAGES.TITLES.INFO"), this.$filter("translate")("MESSAGES.NO_INTERNET"));
      }
    }

    /**
    * @private
    * @description
    * Carga los valores por defecto para el formulario de login.
    */
    private defaultValueForm(): void {
      this.form = {
        typeCompany: 2,
        typeUser: 1,
        user: "",
        company: "",
        password: ""
      };
    }

    /**
    * @private
    * @description
    * Carga los valores de los select de los formularios.
    */
    private loadListForm(): void {
      this.listCompany = this.FORMS.SELECTS_LOGIN.TYPE_COMPANY;
      this.listUser = this.FORMS.SELECTS_LOGIN.TYPE_USER;
    }


    /**
    * @description
    * Valida que el contenido del formulario se encuentre en el formato adecuado
    * que los esten completos antes de hacer la encriptación y el envio.
    */
    public actionValidateLogin(): void {
      this.form.user = this.form.user.trim();
      this.form.company = this.form.company.trim();
      this.form.password = this.form.password.trim();
      // La expresión regular valida que no se ingresen espacios
      // y solo los simbolos permitidos.
      let exp = new RegExp("^[0-9a-zA-Z\.\,\!@#$%&\(\)-_¿?]+$");
      this.errorForm = {};
      this.errorForm.typeCompany = this.form.typeCompany === 0;
      this.errorForm.typeUser = this.form.typeUser === 0;
      this.errorForm.password = !exp.test(this.form.password);
      this.errorForm.user = !exp.test(this.form.user);
      this.errorForm.company = !exp.test(this.form.company);
      if (this.oneValueIsTrue()) {
        return;
      }
      this.login();
    }

    /**
    * @private
    * @description
    * Valida si existe un error registrado en el array de errores de formulario
    *
    * @return {Boolean} true si existen errores en el formulario.
    */
    private oneValueIsTrue(): boolean {
      for (let key in this.errorForm) {
        if (this.errorForm[key]) {
          return true;
        }
      }
      return false;
    }

    /**
    * @private
    * @description
    * Se encarga de realizar el consumo del servicio REST para autenticar al
    * usuario.
    */
    private login(): void {
      this.messageError = null;
      this.showLoading = true;
      let result = this.swat.login(this.form);
      result.then((data) => {
        this.loginSuccess(data);
      }, (dataError) => {
        this.loginError(dataError);
      });
    }

    /**
    * @private
    * @description
    * Se ejecuta si el llamado al servicio del JAR es correcto, si el servicio
    * retorna algun mensaje de error este es mostrado en pantalla.
    *
    * @param {Object} data - Información que retorna el servicio de login.
    */
    private loginSuccess(data): void {
      this.showLoading = false;
      if (data.code === "00") {
        this.saveDataFromLogin(data);
        this.$rootScope.userLogin = false;
        this.$state.go("dashboard");
      } else {
        this.messageError = data.message;
        this.$scope.$digest();
      }
    }

    /**
    * @private
    * @description
    * Se ejecuta si en el proceso de login hay un error al ejecutar el JAR o
    * si el tiempo de espera de la respuesta se agoto.
    *
    * @param {Object} dataError - Información del tipo de error que ocurrio.
    */
    private loginError(dataError): void {
      this.showLoading = false;
      this.messageError = dataError.message;
      // Si no hay conexión a internet se cambia el mensaje de error.
      if (!navigator.onLine) {
        this.messageError = this.$filter("translate")("MESSAGES.NO_INTERNET");
      }
      this.$scope.$digest();
    }

    /**
    * @private
    * @description
    * Almacena la inforamción que se retorna en el login de la aplicación.
    * La información almacenada en el localStorage es consultada en la aplicación
    * para las funciones de los archivos JAR.
    *
    * @param {Object} resultLogin - Objecto con la información que retorna
    * el servicio de login.
    */
    private saveDataFromLogin(resultLogin): void {
      this.$localStorage.token = resultLogin.token;
      this.$localStorage.permissions = resultLogin.userPermissions;
      this.$localStorage.nameUser = resultLogin.userName;
      this.$localStorage.nameCompany = resultLogin.companyName;
      this.$localStorage.soiContributorIdNumber = resultLogin.soiContributorIdNumber;
      this.$localStorage.authenticatedUserDTO = resultLogin.authenticatedUserDTO;
      this.$localStorage.soiAccountIdNumber = resultLogin.soiAccountIdNumber;
      // Valida si activo la opción para almacenar la información de la sesión
      if (this.form.saveSession) {
        this.$localStorage.login = this.form;
      }
    }


    /**
    * @description
    * El evento detecta cuando se presiona la tecla enter en la ventana ubicado
    * en un formulario para dar la orden de validación de los datos del login.
    *
    * @param {Object} event - Evento del DOM HTML.
    */
    public actionKeyPress(event): void {
      if (event.keyCode === 13) {
        this.actionValidateLogin();
      }
    }

  }

  // Declaración del componente.
  let app: any = angular.module("PILA");
  app.component("login", {
    controller: LoginController,
    templateUrl: "./components/login/login.main.html"
  });
}

namespace app.login {

  /**
  * @class LoginConfigProxyController
  * @author David Montoya <dmontoya@lucasian.com>
  * @description
  * Administra el componente del formulario de configuración de proxy.
  */
  class LoginConfigProxyController {

    /**
    * @type {Boolean} showConfigProxy - Indica si se debe hacer visible el
    * formulario de registro de opciones de proxy.
    */
    public showConfigProxy: Boolean = false;

    /**
    * @type {Boolean} showLoading - Indica si debe mostrar la imagen de loading
    * y bloquear la pantalla hasta que el proceso ejecutado finalice
    */
    public showLoading: Boolean = false;

    /**
    * @type {Object} form - Formulario de la vista.
    */
    public form: any = {};

    /**
    * @type {Object} errorForm - Indica que campos presentan error para realizar
    * la carga del estilo.
    */
    public errorForm: any = null;

    /**
    * @type {NativeFileService} file - Manipula los archivos que se encuentran
    * almacenados en la carpeta del programa.
    * @see app.native.NativeFileService()
    */
    private file: any;

    /**
    * @type {NativeEmailService} email - Escribe el email
    * @see app.native.NativeEmailService()
    */
    private email: any;

    /**
    * @type {NativeNotificationService} nativeNotification - Clase que se encarga
    * de mostrar notificaciones por medio de alerts nativos.
    * @see app.native.NativeNotificationService()
    */
    private nativeNotification: any;

    /**
    * @type {NativeEmailService} email - Clase con funciones de validación
    * de configuración de email.
    * @see app.native.NativeEmailService()
    */
    private email: any;

    /**
    * @type {Object} OPTIONS - Equivale al archivo de opciones del sistema.
    * @see app/webapp/json/data/options.json
    */
    private OPTIONS: any;

    private $scope: any;
    private $filter: any;
    private $rootScope: any;
    static $inject = ["native.notification.service", "native.email.service", "native.file.service", "OPTIONS", "$scope", "$filter", "$rootScope"];

    public constructor(nativeNotification, email, file, OPTIONS, $scope, $filter, $rootScope) {
      this.nativeNotification = nativeNotification;
      this.email = email;
      this.file = file;
      this.OPTIONS = OPTIONS;
      this.$scope = $scope;
      this.$filter = $filter;
      this.$rootScope = $rootScope;
      this.getProxyConfig();
    }

    /**
    * @private
    * @description
    * Carga los valores por defecto para el formulario de login.
    */
    private defaultValueForm(): void {
      this.form = {
        useProxy: false,
        server: "",
        port: "",
        user: "",
        pass: ""
      };
    }

    /**
    * @private
    * @description
    * Valida que el contenido del formulario se encuentre en el formato adecuado
    *
    * @return {Boolean} Indica si hay un error en el formulario con true.
    */
    private validateFormProxy(): boolean {
      if(this.form.useProxy){
        this.errorForm = {};
        this.errorForm.server = this.form.server.trim().length === 0;
        this.errorForm.port = this.form.port.trim().length === 0;
        return this.oneValueIsTrue();
      }else{
        return false;
      }
    }

    /**
    * @private
    * @description
    * Recorre el array de errores del formulario, si detecta que existe un
    * campo con el valor true retorna este para indicar que hay un error.
    *
    * @return {Boolean} True para indicar que existe un error.
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
    * Consulta el archivo con la configuración del proxy y formulario para el proceso de edición.
    */
    private getProxyConfig(): void {
      let pathFile = this.file.getPathOptions(this.OPTIONS.FILES.PROXY_CONFIG);
      if (pathFile) {
        let result = this.file.getContentFileJson(pathFile);
        result.then((data) => {
          this.form = data;
          this.$scope.$digest();
        });
      }
    }

    /**
    * @public
    * @description - Método el cual realiza el registra la configuracion del proxy
    */
    public actionSaveConfig() {
      if (this.validateFormProxy()) {
        return;
      }else{
        this.file.createFileOptions(this.OPTIONS.FILES.PROXY_CONFIG, this.form);
        this.showConfigProxy = false;
      }
    }

    /**
    * @description
    * Cierra la ventana de configuración de proxy.
    */
    public actionCloseProxyConfig(): void {
      this.showConfigProxy = false;
    }

  }

  // Declaración del componente.
  let app: any = angular.module("PILA");
  app.component("loginConfigProxy", {
    controller: LoginConfigProxyController,
    bindings: {
      showLoading: "=", // Se utiliza para realizar uso del componente de carga
      showConfigProxy: "=" // Oculta la ventana de proxy
    },
    templateUrl: "./components/login/login.config.proxy.html"
  });
}

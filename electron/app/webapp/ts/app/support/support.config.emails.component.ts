
namespace app.support {

  /**
  * @class SupportConfigEmailsController
  * @author Cristian Camilo Zapata <czapata@swat-it.co>
  * @description
  * Administra el componente del formulario de configuración de cuentas de email.
  */
  class SupportConfigEmailsController {

    /**
    * @type {Boolean} showConfigEmail - Indica si se debe hacer visible el
    * formulario de registro de opciones de email.
    */
    public showConfigEmail: Boolean = false;

    /**
    * @type {Boolean} showLoading - Indica si debe mostrar la imagen de loading
    * y bloquear la pantalla hasta que el proceso ejecutado finalice
    */
    public showLoading: Boolean = false;

    /**
    * @type {Array<Object>} listConfigEmails - Almacena la lista de objetos
    * JSON que tiene las opciones de configuración de envio de emails.
    */
    public listConfigEmails: any[] = [];

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
    * @type {number} positionEmail - Variable que almacena la posición de la
    * cuenta en la cual se estan realizando acciones. No se utiliza directamente
    * el objeto por la logica de la función de eliminar registros la cual se
    * hace con la posición del objeto en el array.
    */
    private positionEmail: number = null;

    /**
    * @type {NativeFileService} file - Manipula los archivos que se encuentran
    * almacenados en la carpeta del programa.
    * @see app.native.NativeFileService()
    */
    private file: any;

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
    * @type {Boolean} emailTestSuccess - Indica si fue correcto el proceso de
    * validación de email
    */
    private emailTestSuccess: boolean = false;

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
      this.defaultValueForm();
      this.getListEmails();
    }

    /**
    * @private
    * @description
    * Carga los valores por defecto para el formulario de login.
    */
    private defaultValueForm(): void {
      this.form = {
        name: "",
        email: "",
        server: "",
        port: "",
        user: "",
        password: "",
        tls: false,
        ssl: false
      };
    }

    /**
    * @private
    * @description
    * Valida que el contenido del formulario se encuentre en el formato adecuado
    *
    * @return {Boolean} Indica si hay un error en el formulario con true.
    */
    private validateFormCount(): boolean {
      this.errorForm = {};
      this.errorForm.name = this.form.name.trim().length === 0;
      this.errorForm.email = this.form.email.trim().length === 0;
      this.errorForm.server = this.form.server.trim().length === 0;
      this.errorForm.port = this.form.port.trim().length === 0;
      this.errorForm.user = this.form.user.trim().length === 0;
      this.errorForm.password = this.form.password.trim().length === 0;
      return this.oneValueIsTrue();
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
    * Consulta el archivo con la configuraciones de emails y la asigna al
    * listado para el proceso de edición.
    */
    private getListEmails(): void {
      let pathFile = this.file.getPathOptions(this.OPTIONS.FILES.EMAILS_SYSTEM);
      if (pathFile) {
        let result = this.file.getContentFileJson(pathFile);
        result.then((data) => {
          this.listConfigEmails = data;
          this.$scope.$digest();
        });
      }
    }

    /**
    * @public
    * @description - Método para eliminar una cuenta seleccionada
    */
    public actionDeleteEmail() {
      if (this.positionEmail === null) {
        this.nativeNotification.show(this.$filter("translate")("MESSAGES.TITLES.INFO"), this.$filter("translate")("MESSAGES.DELETE_COUNT_MAIL_LACK_ID"));
        return;
      }
      this.listConfigEmails.splice(this.positionEmail, 1);
      this.file.createFileOptions(this.OPTIONS.FILES.EMAILS_SYSTEM, this.listConfigEmails);
      this.nativeNotification.show(this.$filter("translate")("MESSAGES.TITLES.INFO"), this.$filter("translate")("MESSAGES.DELETE_COUNT_MAIL"));
      this.positionEmail = null;
      this.defaultValueForm();
    }

    /**
    * @public
    * @description - Método el cual realiza el registro de un nuevo dato o la
    * actualización de un dato seleccionado de la lista.
    */
    public actionSaveEmail() {
      this.showLoading = true;
      if (this.validateFormCount()) {
        this.showLoading = false;
        return;
      }
      if (!this.emailTestSuccess) {
        this.nativeNotification.show(this.$filter("translate")("MESSAGES.TITLES.INFO"), this.$filter("translate")("MESSAGES.EMAIL_NOT_VALIDATE"));
        this.showLoading = false;
        return;
      }
      if (this.listConfigEmails) {
        if (this.positionEmail !== null) {
          angular.copy(this.form, this.listConfigEmails[this.positionEmail]);
        } else {
          this.listConfigEmails.push(this.form);
        }
        this.file.createFileOptions(this.OPTIONS.FILES.EMAILS_SYSTEM, this.listConfigEmails);
        this.defaultValueForm();
        let message = this.$filter("translate")("MESSAGES.SAVED_COUNT_MAIL");
        if (this.positionEmail) {
          message = this.$filter("translate")("MESSAGES.EDIT_COUNT_MAIL");
        }
        this.positionEmail = null;
        this.nativeNotification.show(this.$filter("translate")("MESSAGES.TITLES.INFO"), message);
        this.showLoading = false;
        this.emailTestSuccess = false;
      }
    }

    /**
    * @description
    * Limpia el contenido del formulario y le asigna el valor por defecto.
    */
    public actionAddEmail(): void {
      this.positionEmail = null;
      this.emailTestSuccess = false;
      this.errorForm = {};
      this.defaultValueForm();
    }

    /**
    * @description
    * Método para realizar un test de la cuenta de correos, el resultado es
    * mostrado en una notificación del sistema operativo, al finalizar se
    * hace oculta al ventana modal de loading.
    * Si el formulario no tiene los campos diligenciados de forma correcta no se
    * inicia el proceso de test.
    */
    public actionTestConfigEmail(): void {
      if (this.validateFormCount()) {
        return;
      }
      this.emailTestSuccess = false;
      let options = {
        host: this.form.server,
        port: this.form.port,
        secure: this.form.ssl,
        auth: {
          user: this.form.user,
          pass: this.form.password
        },
        tls: {
          rejectUnauthorized: this.form.tls
        }
      };
      this.showLoading = true;
      let result = this.email.testSMTP(options);
      result.then((success) => {
        console.info(success);
        this.emailTestSuccess = success;
        this.showLoading = false;
        this.$scope.$apply();
      });
    }

    /**
    * @description
    * Método para obtener una cuenta de la lista y realizar la carga en el
    * formulario.
    *
    * @param {Number} index - Posición del elemento en el array.
    */
    public actionSelectEmail(index: number): void {
      this.positionEmail = index;
      this.form = {};
      angular.copy(this.listConfigEmails[index], this.form);
    }

    /**
    * @description
    * Cierra la ventana de configuración de email y solicita actualizar la
    * lista de configuración de emails de la vista principal.
    */
    public actionCloseEmailConfig(): void {
      this.showConfigEmail = false;
      this.$rootScope.$broadcast("support-update-config-emails");
    }

  }

  // Declaración del componente.
  let app: any = angular.module("PILA");
  app.component("supportConfigEmails", {
    controller: SupportConfigEmailsController,
    bindings: {
      showLoading: "=", // Se utiliza para realizar uso del componente de carga
      showConfigEmail: "=" // Oculta la ventana de email
    },
    templateUrl: "./components/support/support.config.emails.html"
  });
}

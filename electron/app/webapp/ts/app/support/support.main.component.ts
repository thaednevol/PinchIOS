/// <reference path="../../dt/angular.d.ts"/>

namespace app.support {

  /**
  * @class SupportController
  * @author Cristian Camilo Zapata <czapata@swat-it.co>
  * @description
  * Componente principal del modulo de soporte de pagos, se encarga de realizar
  * el consumo de los servicios para extraer la  información de las planillas.
  * Realiza la consulta de los archivos de opciones y emails almacenados en la
  * aplicación.
  */
  class SupportController {

    /**
    * @type {SupportService} supportService - Servico principal de la clase de
    * soporte de pagos, su función es el consumo de los servicios REST que
    * realizan el envio de emails.
    */
    private supportService: any;

    /**
    * @type {Boolean} isSendEmail - Indica si se estan enviando un email para
    * mostrar la barra de progreso.
    */
    private isSendEmail: boolean = false;

    /**
    * @type {Object} progress - Almacena la información requerida para indicar
    * el estado del progreso para envio de emails.
    */
    public progress: any = {
      percentage: "0%",
      totalEmails: 0,
      countEmailsSend: 0
    };

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
    * @type {Boolean} flagOperationSupport - Indica si debe ejecutar el proceso cuando se hace
		* el llamado de la vista desde otra.
    */
    private flagOperationSupport = false;

    /**
    * @type {Boolean} showPanel - Indica si se oculta el panel o se muestra.
    */
    public showPanel: boolean = true;

    /**
    * @type {Boolean} showPanel - Indica si se ocultan las tablas
    */
    public showTable: boolean = false;

    /**
    * @type {NaviteJarService} jar - Servicio nativo de NodeJS para consumo de JAR.
    * @see app.native.JarNodeService
    */
    private jar: any;

    /**
    * @type {NativeFileService} file - Manipula los archivos que se encuentran
    * almacenados en la carpeta del programa.
    */
    private file: any;

    /**
    * @type {NativeNotificationService} nativeNotification - Clase que se encarga
    * de mostrar notificaciones por medio de alerts nativos.
    * @see app.native.NativeNotificationService
    */
    private nativeNotification: any;

    /**
    * @type {NativeDialogService} nativeDialog - Clase que se encarga
    * de mostrar las ventanas de dialog nativas.
    * @see app.native.NativeDialogService
    */
    private nativeDialog: any;

    /**
    * @type {String} numberSettlement - variable que se utiliza para referenciar
    * el numero de la planilla que se va a cargar, se asigna el valor por el
    * ng-model del input de la vista del panel que herada del binding o por el
    * llamado con el statePArams que se envia como parametro "numberSettlement"
    */
    public numberSettlement: string = "";

    /**
    * @type {String} numberDashboard - variable que se utiliza para referenciar
    * el numero de la planilla que se va a cargar, se asigna el valor desde la vista que
    * llame a esta.
    */
    public numberDashboard: string = null;

    /**
    * @type {Array<Object>} listContributors - Variable que almacena la lista de
    * empleados asociados a la planilla de pago para cargarlos en la tabla de
    * edición de correos.
    */
    public listContributors: any = [];

    /**
    * @type {Array<Object>} listContributorsOrigin - Almacena los datos que
    * son entregados del servicio de consulta de contribuyentes asociados en la
    * planilla, se conserva como copia original.
    */
    public listContributorsOrigin: any = [];

    /**
    * @type {Object} dataEmailsSent - Almacena la información del
    * consecutivo de los correos enviados.
    */
    public dataEmailsSent: any = {};

    /**
    * @type {Array<Object>} labelsTable - Lista los labels que se usan
    * en la tabla, tambien sirve para que indique que campos se muestran.
    */
    public labelsTable: any = [];

    /**
    * @type {Array<Object>} listConfigEmails - Almacena la liste de objetos
    * JSON que tiene las opciones de los envios de las configuración de los emails.
    */
    public listConfigEmails: any[] = [];

    /**
    * @type {Object} currentEmailConfig - Cuenta seleccionada en el select de la vista
    */
    public currentEmailConfig: any = null;

    /**
    * @type {Object} OPTIONS - Equivale al archivo de opciones del sistema.
    * @see app/webapp/json/data/options.json
    */
    private OPTIONS: any;

    /**
    * @type {Object} infoSupport - Contiene la información de la planilla de
    * soporte de pagos, la información es presentada en el panel de información,
    * tambien almacena la información requerida para construir la cabecera
    * de la planilla de soporte.
    */
    public infoSupport: any = {
      numberTemplate: "SUPPORT.PANEL.UNDEFINED",
      typeTemplate: "SUPPORT.PANEL.UNDEFINED",
      periodPension: "SUPPORT.PANEL.UNDEFINED",
      periodHealth: "SUPPORT.PANEL.UNDEFINED",
      totalContributor: 0,
      paymentDate: "SUPPORT.PANEL.UNDEFINED",
      branchOffice: "SUPPORT.PANEL.UNDEFINED"
    };

    /**
    * @type {Object} listEmailsContributors - Almacena el contenido del archivo
    * que contiene la lista de contribuidores y los emails asociados.
    */
    private listEmailsContributors: any = {};

    /**
    * @type {SwatService} swat - Clase de consulta de metodos JAR desarrollados
    * por Swat.
    * @see app.jar.SwatService
    */
    private swat: any;

    /**
    * @type {Number} currentPositionEmailSent - Indica la posición actual de la
    * tanda o bloque de correos enviados.
    */
    private currentPositionEmailSent: number = 0;

    /**
    * @type {Object} listAuthorizedContributors - Almacena unicamente los
    * contribuidores que cumplen con los requerimientos para realizar el envio
    * de los soportes de pago con las cuentas de email.
    */
    private listAuthorizedContributors: any = {};

    private $filter: any;
    private $localStorage: any;
    private $rootScope: any;
    private $scope: any;
    static $inject = ["support.service", "OPTIONS", "native.dialog.service", "native.notification.service", "native.file.service", "native.jar.service", "jar.swat.service", "$filter", "$localStorage", "$rootScope", "$scope"];

    constructor(supportService, OPTIONS, nativeDialog, nativeNotification, file, jar, swat, $filter, $localStorage, $rootScope, $scope) {
      this.supportService = supportService;
      this.OPTIONS = OPTIONS;
      this.nativeDialog = nativeDialog;
      this.nativeNotification = nativeNotification;
      this.file = file;
      this.jar = jar;
      this.swat = swat;
      this.$filter = $filter;
      this.$localStorage = $localStorage;
      this.$rootScope = $rootScope;
      this.$scope = $scope;
      this.setListEmailsContributors();
      this.setLabelsTable();
      this.setListEmails();
      // Consulta el numero de la planilla liquidada
      this.$scope.$on("get-file-settlement", () => {
        this.getFileSettlement();
      });
      // broadcast para actualizar la lista de opciones de configuración de email
      this.$scope.$on("support-update-config-emails", () => {
        this.setListEmails();
      });
      // Finaliza el proceso de envio de email
      this.$scope.$on("support-stop-emails-send", () => {
        this.stopEmailSend();
        this.currentPositionEmailSent = this.listAuthorizedContributors.ids.length;
      });
    }

    $doCheck() {
      // Se realiza una validación para identificar si el numero de planilla
      // es pasado como parametro del state, esto se realiza si se presiona
      // el boton de planilla liquidada del dashboard, se inicia la carga de la
      // información asociada a la planilla.
      if (this.numberDashboard && !this.flagOperationSupport) {
        this.flagOperationSupport = true;
        this.numberSettlement = this.numberDashboard;
        this.getFileSettlement();
      }
    }

    /**
    * @private
    * @description
    * Consulta el archivo de configuración con la lista de empelados y correos
    * asociados a ellos, la llave principal del archivo JSON esta constituida
    * por la convinación de tipo de identificación y numero de identificación.
    */
    private setListEmailsContributors(): void {
      let pathFile = this.file.getPathOptions(this.OPTIONS.FILES.EMAILS_CONTRIBUTORS);
      if (pathFile) {
        let result = this.file.getContentFileJson(pathFile);
        result.then((data) => {
          this.listEmailsContributors = data;
        });
      }
    }

    /**
    * @private
    * @description
    * Consulta la información de una plantilla por medio de su identificador,
    * luego de tener una respuesta correcta se hace el llamado a
    * getPositionSendEmail para actualizar la información de las plantillas y
    * en caso de errores se notifica por medio show de la clase
    * NativeNotificacionService.
    */
    private getFileSettlement(): void {
      this.numberSettlement = this.numberSettlement.trim();
      if (this.numberSettlement.length > 0) {
        this.showLoading = true;
        this.clearView();
        let result = this.swat.infoHeadSettlement(this.numberSettlement);
        result.then((data) => {
          if (data) {
            this.infoSupport = data;
            //Consultamos la lista de los contribuidores
            this.getListContributors();
          } else {
            this.showLoading = false;
            this.$scope.$digest();
          }
        });
      }
    }

    /**
    * @private
    * @description
    * Realiza el llamado al metodo JAR que consulta la lista de empleados
    * asociados a la planilla de soporte de pago.
    * La respuesta del servicio swat se procesa en este punto po no tener
    * que realizar la transformación de los datos que retorna como en el
    * metodo infoHeadSettlement.
    */
    private getListContributors(): void {
      let result = this.swat.listContributorsSettlement(this.numberSettlement);
      result.then((data) => {
        if (data.code === "00") {
          angular.copy(data.payrollContributors, this.listContributorsOrigin);
          this.listContributors = {
            registers: data.payrollContributors,
            errors: {}
          };
          this.validateRegisterContributors();
          this.associeateEmailContributors();
          this.getPositionSendEmail();
          this.showTable = true;
          setTimeout(() => {
            this.showLoading = false;
          }, 1000 * 1);
          this.$scope.$digest();
        } else {
          this.showLoading = false;
          this.clearView();
          this.nativeNotification.show(this.$filter("translate")("MESSAGES.TITLES.ERROR"), data.message);
        }
      });
    }

    /**
    * @private
    * @description
    * Realiza la validación inicial de los emails asociados a un contribuidor
    * junto con la conversión del array de contribuidores a objeto.
    */
    private validateRegisterContributors(): void {
      for (let i = 0; i < this.listContributors.registers.length; i++) {
        let currentContributor = this.listContributors.registers[i];
        let contributor = {
          type: currentContributor.idTipoIdentificacion,
          number: currentContributor.numeroIdentificacion,
          name: currentContributor.nombreCompleto,
          email: currentContributor.correoElectronico
        }
        this.listContributors.registers[i] = contributor;
        this.listContributors.errors[contributor.number] = { 4: true };
      }
    }

    /**
    * @private
    * @description
    * Método para asociar email almacenados en el sistema con los contribuidores
    * de la plantilla.
    */
    private associeateEmailContributors(): void {
      for (let i = 0; i < this.listContributors.registers.length; i++) {
        let contributor = this.listContributors.registers[i];
        let key = `${contributor.type}${contributor.number}`;
        if (this.listEmailsContributors.hasOwnProperty(key)) {
          contributor.email = this.listEmailsContributors[key];
          delete this.listContributors.errors[contributor.number];
        }
      }
    }

    /**
    * @public
    * @author Cristian Camilo Zapata <czapata@swat-it.co>
    * @description
    * Realiza la consulta del JSON de opciones con la información de los datos
    * de envio, en el JSON que se entrega como resultado se identifica si
    * existen registros asociados al numero de planilla, si existen se
    * almacena la información en la variable "dataEmailsSent"
    */
    public getPositionSendEmail() {
      let pathFile = this.file.getPathOptions(this.OPTIONS.FILES.PROGRESS_EMAILS);
      if (pathFile) {
        let result = this.file.getContentFileJson(pathFile);
        result.then((data) => {
          this.dataEmailsSent = data;
        });
      }
    }


    /**
    * @description
    * Valida si existe un progreso almacenado y inicia el envio de emails.
    */
    public actionSendEmails(): void {
      if (!this.currentEmailConfig) {
        return;
      }
      this.currentPositionEmailSent = 0;
      this.showLoading = true;
      if (this.dataEmailsSent[this.numberSettlement]) {
        this.nativeDialog.showDialogConfirm(
          this.$filter("translate")("MESSAGES.TITLES.INFO"),
          this.$filter("translate")("SUPPORT.CONTINUE_EMAIL_SENT"),
          (option) => {
            if (option === 1) {
              this.currentPositionEmailSent = this.dataEmailsSent[this.numberSettlement];
            }
            this.initializeSendEmails();
          }
        );
      } else {
        this.initializeSendEmails();
      }
    }

    /**
    * @private
    * @description
    * Inicia las validaciones antes de iniciar el proceso de envio de emails,
    * identifica que contribuidores cumplen con los requerimientos minimos,
    * se agregan los datos de idCotizante de SOI y el email en dos arrays
    * conservando la misma posición ambos datos dejando vinculados la posición
    * al registro del contribuidor, luego se almacenan en el objeto que realiza
    * el envio  a la función que contruye los bloques de datos que se envian.
    */
    private initializeSendEmails(): void {
      this.isSendEmail = true;
      this.$rootScope.$broadcast("support-start-time-elapsed");
      this.listAuthorizedContributors = {
        ids: [],
        emails: []
      };
      for (let contributor of this.listContributors.registers) {
        if (!this.listContributors.errors.hasOwnProperty(contributor.number) && contributor.email && contributor.email !== "") {
          // Se realiza un filtro para extraer el idCotizante del usuario con el
          // dato unico de numero de identificación y tipo, siempre retornara
          // un array con un solo campo.
          let registerOrigin = this.$filter("filter")(this.listContributorsOrigin, {
            idTipoIdentificacion: contributor.type,
            numeroIdentificacion: contributor.number
          }, true)[0];
          this.listAuthorizedContributors.ids.push(registerOrigin.idCotizante);
          this.listAuthorizedContributors.emails.push(contributor.email);
        }
      }
      if (this.listAuthorizedContributors.emails.length === 0) {
        this.nativeNotification.show(this.$filter("translate")("MESSAGES.TITLES.ERROR"), this.$filter("translate")("MESSAGES.EMAIL_NO_CONTRIBUTORS"));
        this.stopEmailSend();
        return;
      }
      this.updateProgressEmail();
      this.createBlockEmails();
    }

    /**
    * @private
    * @description
    * Actualiza la información de emails enviados para visualizar los cambios
    * en la vista.
    */
    private updateProgressEmail(): void {
      let totalEmails = this.listAuthorizedContributors.ids.length;
      let currentEmails = this.currentPositionEmailSent;
      let percentage = Math.round((currentEmails * 100) / totalEmails);
      this.progress.countEmailsSend = currentEmails;
      this.progress.totalEmails = totalEmails;
      this.progress.percentage = `${percentage}%`;
      if (this.currentPositionEmailSent > 0) {
        this.dataEmailsSent[this.numberSettlement] = this.currentPositionEmailSent;
      }
      this.saveProgressEmailSent();
    }

    /**
    * @private
    * @description
    * Almacena el progreso del envio de emails de la planilla.
    */
    private saveProgressEmailSent(): void {
      this.file.createFileOptions(this.OPTIONS.FILES.PROGRESS_EMAILS, this.dataEmailsSent);
    }

    /**
    * @private
    * @description
    * Crea un bloque de emails para enviar al servicio que consulta la
    * información de los empleados asociados a la planilla de soporte, esta
    * información es enviada al servicio que construye la planilla y envia el
    * email. El tamaño de los bloques varia segun el archivo JSON de propiedades
    * que lo expecifica. Se realiza el envio por bloques para evitar que la
    * aplicación se bloquee al atratar de enviar una enorme cantidad de archivos.
    */
    private createBlockEmails(): void {
      let maxPositionBlockEmail: number = this.currentPositionEmailSent + this.OPTIONS.EMAILS.NUMBER_BLOCK;
      let blockContributors: any = {};
      if (this.listAuthorizedContributors.ids.length < maxPositionBlockEmail) {
        maxPositionBlockEmail = this.listAuthorizedContributors.ids.length;
      }
      // Con la opción de slice se extraen los ids que se enviaran en el bloque
      blockContributors.ids = this.listAuthorizedContributors.ids.slice(this.currentPositionEmailSent, maxPositionBlockEmail);
      blockContributors.emails = this.listAuthorizedContributors.emails.slice(this.currentPositionEmailSent, maxPositionBlockEmail);
      this.currentPositionEmailSent = maxPositionBlockEmail;
      let result = this.swat.contributorsInformation(blockContributors.ids, this.infoSupport.planillaAportanteDTO);
      result.then((data) => {
        if (data.code === "00") {
          if (data.contributorPayrolls) {
            this.sendEmails(data.contributorPayrolls, blockContributors);
          }
        } else {
          this.nativeNotification.show(this.$filter("translate")("MESSAGES.TITLES.ERROR"), data.message);
          this.stopEmailSend();
        }
      });
    }

    /**
    * @private
    * @description
    * Se activa cuando se detiene el proceso de envio de emails por un error o
    * por finalizar el proceso exitoso.
    */
    private stopEmailSend(): void {
      this.showLoading = false;
      this.isSendEmail = false;
      this.$rootScope.$broadcast("support-stop-time-elapsed");
    }

    /**
    * @private
    * @description
    * Realiza el envio de los bloques de emails.
    */
    private sendEmails(infoContributors: any, blockContributors: any): void {
      // TODO
      // El fragmento en el que se consulta el archivo de opciones se debe
      // eliminar cuando el JAR de SOI corriga el error de la extracción de los
      // mapas de departamentos y ciudades.
      let pathFile = this.file.getPathOptions(this.OPTIONS.FILES.CONFIG_SOI.VALIDATION_DATA_SOURCE);
      if (pathFile) {
        let result = this.file.getContentFileJson(pathFile);
        result.then((fileConfig) => {
          let paramsEmail = this.setParamsForSendEmail(fileConfig, infoContributors, blockContributors);
          // Se realiza el llamado al servicio REST de SOI que envia los emails.
          this.supportService.send().save(paramsEmail).$promise.then((response) => {
            if (response.resultadoGeneracion !== "OK") {
              this.nativeNotification.show(this.$filter("translate")("MESSAGES.TITLES.ERROR"), this.$filter("translate")("MESSAGES.ERROR_JAR"));
              this.stopEmailSend();
              return;
            }
            this.updateProgressEmail();
            // Se valida si llego a la tanda final o aun contiene elementos para
            // crear otro bloque de envio de emails.
            if (this.listAuthorizedContributors.ids.length > this.currentPositionEmailSent) {
              this.createBlockEmails();
            } else {
              this.stopEmailSend();
              delete this.dataEmailsSent[this.numberSettlement];
              this.saveProgressEmailSent();
            }
          }, () => {
            this.nativeNotification.show(this.$filter("translate")("MESSAGES.TITLES.ERROR"), this.$filter("translate")("MESSAGES.ERROR_JAR"));
            this.stopEmailSend();
          });
        });
      } else {
        this.stopEmailSend();
      }
    }

    /**
    * @private
    * @description
    * Construye el objeto que se envia con los parametros al servicio REST de
    * envio de emails.
    */
    private setParamsForSendEmail(fileConfig: any, infoContributors: any, blockContributors: any): any {
      let headSettlement = this.supportService.infoHeadFile(fileConfig, this.infoSupport.planillaAportanteDTO, this.$localStorage.soiContributorIdNumber);
      let contributosRest = this.setInfoContributorForSupport(infoContributors, blockContributors);
      let paramsEmail = {
        datosEnvioCorreoJson: JSON.stringify(this.getInfoEmail()),
        datosDetalleCotizanteJson: JSON.stringify(contributosRest),
        datosEncabezadoJson: JSON.stringify(headSettlement),
        rutaRecursos: process.env.RECURSOS_SOPORTES,
        rutaGeneracion: process.env.GENERACION_SOPORTES
      };
      return paramsEmail;
    }

    /**
    * @private
    * @description
    * Realiza el llamado al servicio que construye la información requerida de
    * los contribuyentes para crear las planillas de soporte de pagos, recorre
    * los bloques con la información de los empleados y almacena los resultados
    * en un array.
    *
    * @param {Object} infoContributors - Información proveiniente del servicio
    * de swat para consultar la información del empleado.
    * @param {Object} blockContributors - Contiene los ids SOI de los empleados
    * junto con una lista de emails para el bloque actual que se enviara.
    * @return {Array<Object>} Parametros requeridos para la creación de la
    * planilla.
    */
    private setInfoContributorForSupport(infoContributors: any, blockContributors: any): any {
      let contributosRest = [];
      for (let i = 0; i < infoContributors.length; i++) {
        contributosRest.push(this.supportService.infoContributor(infoContributors[i], this.infoSupport.planillaAportanteDTO, blockContributors.emails[i]));
      }
      return contributosRest;
    }

    /**
    * @private
    * @description
    * Crea el objeto JSON que es entregado como parametro al servicio REST que
    * envia el email con el documento de soporte a una cuenta destino.
    *
    * @return {Object|null} Información para agregar al parametro de envio de
    * email, en caso de error el parametro retornado sera null.
    */
    private getInfoEmail(): any {
      if (!this.currentEmailConfig) {
        this.nativeNotification.show(this.$filter("translate")("MESSAGES.TITLES.ERROR"), this.$filter("translate")("MESSAGES.EMAIL_CONFIG_BAD"));
        return null;
      }
      let infoEmail: any = {
        servidorCorreo: this.currentEmailConfig.server,
        puertoServidorCorreo: this.currentEmailConfig.port,
        servidorRequiereAutenticacion: true,
        servidorRequiereTls: this.currentEmailConfig.tls,
        servidorRequiereSsl: this.currentEmailConfig.ssl,
        nombreUsuarioAutenticacion: this.currentEmailConfig.user,
        contrasenaUsuarioAutenticacion: this.currentEmailConfig.password,
        cuentaCorreoElectronicoOrigen: this.currentEmailConfig.email
      };
      return infoEmail;
    }

    /**
    * @private
    * @description
    * Construye un json que contiene la cabecera de la tabla de los empleados
    * asociados a la planilla de pago. Se valida para que solo se asigne
    * una vez el contenido de labels de la tabla.
    */
    private setLabelsTable(): void {
      if (this.labelsTable.length === 0) {
        this.labelsTable = [
          this.$filter("translate")("SUPPORT.TABLE.IDENTIFICATION_TYPE"),
          this.$filter("translate")("SUPPORT.TABLE.IDENTIFICATION_NUMBER"),
          this.$filter("translate")("SUPPORT.TABLE.FULL_NAME_EMPLOYEE"),
          this.$filter("translate")("SUPPORT.TABLE.MAIL")
        ];
      }
    }

    /**
    * @private
    * @description
    * Consulta el archivo JSON con la lista de configuraciones de emails.
    */
    private setListEmails(): void {
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
    * @private
    * @description
    * Método para inicializar la vista en cero datos.
    */
    private clearView(): void {
      this.showTable = false;
      this.listContributors = [];
      setTimeout(() => {
        this.$scope.$digest();
      });
    }

  }

  // Declaración del componente.
  let app: any = angular.module("PILA");
  app.component("support", {
    bindings: {
      numberDashboard: "="
    },
    controller: SupportController,
    templateUrl: "./components/support/support.main.html"
  });
}

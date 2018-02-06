
namespace app.dashboard {

  /**
  * @class DashboardController
  * @author Luis Felipe Zapata <lzapata@swat-it.co>
  * @description
  * Controlador del componente del panel de control inicial despues de login.
  */
  class DashboardController {

    /**
    * @type {Object} account - Almacena los datos de la cuenta del usuario se
    * muestran en la ventana de aportante.
    */
    public account: any = null;

    /**
    * @type {Array<Object>} listTableServer - Información de planillas pagadas
    * enviadas desde el servidor.
    */
    public listTableServer: any = null;

    /**
    * @type {Array<Object>} listLabelTableSever - Lista los labels que se usan
    * en la tabla, tambien sirve para que indique que campos se muestran.
    */
    public listLabelTableSever: any = null;

    /**
    * @type {Array<Object>} listTableLocal - Información de las planillas
    * que se editan en el convertidor o liquidador de la aplicación.
    */
    public listTableLocal: any = null;

    /**
    * @type {Array<Object>} listLabelTableLocal - Lista los labels que se usan
    * en la tabla, tambien sirve para que indique que campos se muestran.
    */
    public listLabelTableLocal: any = null;

    /**
    * @type {NativeNotificationService} nativeNotification - Clase que se encarga
    * de mostrar notificaciones por medio de alerts nativos.
    * @see app.native.NativeNotificationService
    */
    private nativeNotification: any;

    /**
    * @type {SoiService} soi - Consulta los servicios que utiliza los JAR de
    * SOI para la aplicación.
    * @see app.jar.SoiService
    */
    private soi: any;

    /**
    * @type {SwatService} swat - Consulta los servicios que utiliza los JAR de
    * Swat para la aplicación.
    * @see app.jar.SwatService
    */
    private swat: any;

    /**
    * @type {NaviteJarService} jar - Servicio nativo de NodeJS para consumo de JAR.
    * @see app.native.NaviteJarService
    */
    private jar: any;

    /**
    * @type {NativeFileService} file - Manipula los archivos que se encuentran
    * almacenados en la carpeta del programa.
    * @see app.native.NativeFileService
    */
    private file: any;

    /**
    * @type {LoginTokenService} token - Valida el estado del token, de estar
    * vencido realiza una solicitud de un token.
    * @see app.login.LoginTokenService
    */
    private token: any;

    /**
    * @type {Object} OPTIONS - Equivale al archivo de opciones del sistema.
    * @see app/webapp/json/data/options.json
    */
    private OPTIONS: any;

    /**
    * @type {Array<Object>} listFilesSettlement - Almacena el listado de archivos
    * que existen en la carpeta de liquidación para comparar con los archivos
    * de la carpepeta de conversión.
    * @see this.validateFilesLocal();
    */
    private listFilesSettlement: any[];

    private $filter: any;
    private $localStorage: any;
    private $rootScope: any;
    private $scope: any;
    static $inject = ["native.notification.service", "jar.swat.service", "jar.soi.service", "native.jar.service", "native.file.service", "login.token.service", "OPTIONS", "$filter", "$localStorage", "$rootScope", "$scope"];

    constructor(nativeNotification, swat, soi, jar, file, token, OPTIONS, $filter, $localStorage, $rootScope, $scope) {
      this.nativeNotification = nativeNotification;
      this.swat = swat;
      this.soi = soi;
      this.jar = jar;
      this.file = file;
      this.token = token;
      this.OPTIONS = OPTIONS;
      this.$filter = $filter;
      this.$localStorage = $localStorage;
      this.$rootScope = $rootScope;
      this.$scope = $scope;
      this.initializeDashboard();
    }

    /**
    * @private
    * @description
    * Realiza la carga inicial del dashboard y todos los demas componentes
    * realizando las validaciones de dependencias.
    */
    private initializeDashboard(): void {
      this.file.listFiles = [];
      // Cambio para itentifcar que se eliminar el estilo del login (fondo azul).
      this.$rootScope.userLogin = false;
      // Se ejecuta el llamado del servidor en un hilo a parte para evitar
      // bloqueos al inicio de la app.
      setTimeout(() => {
        this.initializeServer();
      });
      this.getDataTableServerFromFile();
      this.listTableServer = [];
      this.listTableLocal = [];

      this.getDataAcount();
      this.getDataTableLocal();
      // Validación para detectar conexión a internet.
      if (navigator.onLine) {
        this.token.validate(() => { this.getDataTableServer(); });
      } else {
        this.nativeNotification.show(this.$filter("translate")("MESSAGES.TITLES.INFO"), this.$filter("translate")("MESSAGES.NO_INTERNET"));
      }
    }

    /**
    * @private
    * @description
    * Realiza el llamado al metodo para iniciar el servidor springBoot
    */
    private initializeServer(): void {
      this.soi.runServer();
    }

    /**
    * @private
    * @description
    * Consulta el servidor para cargas la lista de archivos de liquidación
    * asociados a una cuenta.
    */
    private getDataTableServer(): void {
      let result = this.swat.listFilesSettlement();
      result.then((data) => {
        // Se almacena la información de las planillas entregadas por la promesa de la petición.
        this.listTableServer = data.listFilteredPayrollsDetails;
        this.$scope.$digest();
        //this.saveDataTableServer();
      });
    }

    /**
    * @private
    * @description
    * Almacena la información que entrega el servicio de planillas pagadas, si
    * el archivo no retorna nada, no se almacena.
    */
    private saveDataTableServer(): void {
      if (this.listTableServer) {
        if (this.listTableServer.length > 0) {
          this.file.createFileOptions(this.OPTIONS.FILES.TEMPLATES.SERVER, this.listTableServer);
        }
      }
    }

    /**
    * @private
    * @description
    * Consulta el archivo con la información de las tablas de liquidación
    * almacenado en el equipo.
    */
    private getDataTableServerFromFile(): void {
      // Se cargan los labels con variables de idiomas, los keys del objeto son
      // definidos en la estructura de los JAR de SOI.
      this.listLabelTableSever = {
        numeroPlanillaElectronica: this.$filter("translate")("DASHBOARD.TABLE.LABELS.NUMBER"),
        fechaUltimaModificacion: this.$filter("translate")("DASHBOARD.TABLE.LABELS.DATE_PAYMENT"),
        periodoSistemaSalud: this.$filter("translate")("DASHBOARD.TABLE.LABELS.PERIOD_PAYMENT"),
        tipoPlanilla: this.$filter("translate")("DASHBOARD.TABLE.LABELS.TYPE"),
        valorPagado: this.$filter("translate")("DASHBOARD.TABLE.LABELS.AMOUNT_PAID"),
      };
      // Carga la respueste de la promesa que retorna la ruta de los archivos de planillas liquidadas
      /*let pathFile = this.file.getPathOptions(this.OPTIONS.FILES.TEMPLATES.SERVER);
      if (pathFile) {
        // Se extrae la información del archivo de planillas liquidadas.
        let result = this.file.getContentFileJson(pathFile);
        result.then((data) => {
          this.listTableServer = data;
          this.$scope.$digest();
        });
      }*/
    }

    /**
    * @private
    * @description
    * Realiza las peticiones de los archivos de planillas locales.
    */
    private getDataTableLocal(): void {
      let resultConvert = this.file.loadConvertFiles();
      resultConvert.then(() => {
        let resultSettlement = this.file.loadSettlementFiles();
        resultSettlement.then((listFiles) => {
          this.listTableLocal = listFiles;
          this.validateFilesLocal();
          this.$scope.$digest();
        });
      });
    }

    /**
    * @private
    * @description
    * Realiza la validación de que si el archivo de la planilla de conversor esta
    * tambien en el liquidar para eliminarla y mostrar siempre la planilla del
    * estado mas actualizada (liquidación).
    */
    private validateFilesLocal(): void {
      this.listLabelTableLocal = {
        formatted: this.$filter("translate")("DASHBOARD.TABLE.LABELS.DATE"),
        name: this.$filter("translate")("DASHBOARD.TABLE.LABELS.FILE")
      };
      this.listFilesSettlement = this.$filter("filter")(this.listTableLocal, {
        convert: false
      });
      this.listTableLocal = this.$filter("filter")(this.listTableLocal, (data) => {
        return this.removeFilesDuplicate(data);
      });
    }

    /**
    * @private
    * @description
    * Valida los registros de los archivos que tiene el array, elimina todos los
    * que esten duplicados que pertenescan al convertidor, conservando los
    * archivos del liquidador como prioridad.
    *
    * @param {Object} data - Contiene información del registro actual.
    * @return {Boolean} true para indicar que se debe conservar y false para eliminar.
    */
    private removeFilesDuplicate(data): boolean {
      let result = this.$filter("filter")(this.listFilesSettlement, { name: data.name }, true);
      return result.length === 0 || !data.convert;
    }

    /**
    * @private
    * @description
    * Consulta la información almacenada del login con los datos del usuario
    * para extraer la información del usuario que se requiere en la cabecera
    * de la vista.
    */
    private getDataAcount(): void {
      let code = this.$localStorage.authenticatedUserDTO.informacionAportantePlanillaDTO.codSoiTpIdentificacion;
      let numberId = this.$localStorage.authenticatedUserDTO.informacionAportantePlanillaDTO.numeroIdentificacion;
      let name = this.$localStorage.authenticatedUserDTO.informacionAportantePlanillaDTO.nombre;
      let typeCompany = this.$localStorage.authenticatedUserDTO.informacionAportantePlanillaDTO.nombreTpEmpresa;
      let classCompany = this.$localStorage.authenticatedUserDTO.informacionAportantePlanillaDTO.nombreClaseAportante;
      let contributor = `${code}${numberId} - ${name}`;
      this.account = {
        contributor: contributor,
        typeCompany: typeCompany,
        classCompany: classCompany
      };

      this.file.validateFolderApp(code+"_"+numberId);
    }

  }

  // Vincula el componente al modulo principal
  let app: any = angular.module("PILA");
  app.component("dashboard", {
    controller: DashboardController,
    templateUrl: "./components/dashboard/dashboard.main.html"
  });
}

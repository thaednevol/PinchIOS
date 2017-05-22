/// <reference path="../../dt/angular.d.ts"/>

namespace app.jar {

  /**
   * @class SwatService
   * @author Luis Felipe Zapata Castaño <lzapata@swat-it.co>
   * @description
   * Realiza la ejecución de los metodos almacenados en el JAR desarrollador por
   * SWAT para integrar con la aplicación.
   */
  class SwatService {

    /**
    * @type {NaviteJarService} jar - Servicio nativo de NodeJS para consumo de JAR.
    * @see app.native.JarNodeService
    */
    private jar: any;

    /**
    * @type {Object} OPTIONS - Equivale al archivo de opciones del sistema.
    * @see app/webapp/json/data/options.json
    */
    private OPTIONS: any;

    /**
    * @type {NativeNotificationService} nativeNotification - Clase que se encarga
    * de mostrar notificaciones por medio de alerts nativos.
    * @see app.native.NativeNotificationService
    */
    private nativeNotification: any;

    /**
    * @type {Object} jarSwat - Hace referencia al contenido asignado en el
    * archivo de opciones para el JAR que desarrollo Swat.
    */
    private jarSwat: any;

    private $localStorage: any;
    private $filter: any;
    static $inject = ["native.jar.service", "OPTIONS", "native.notification.service", "$localStorage", "$filter"];

    constructor(jar, OPTIONS, nativeNotification, $localStorage, $filter) {
      this.jar = jar;
      this.jarSwat = OPTIONS.JAR.FILES.SWAT;
      this.OPTIONS = OPTIONS;
      this.nativeNotification = nativeNotification;
      this.$localStorage = $localStorage;
      this.$filter = $filter;
    }

    /**
    * @description
    * Ejecuta el llamado al metodo encargado de realizar el login en la aplicación.
    *
    * @param {Object} dataForm - Lista de modelos del formulario para extraer
    * la información de los parametros del metodo JAR.
    * @return {Promise} La promesa solo retorna un resolve, en caso de error
    * el campo error del object es true.
    */
    public login(dataForm): any {
      let dataLogin: any = {
        contributorIdType: dataForm.typeCompany,
        contributorIdNumber: dataForm.company,
        accountIdType: dataForm.typeUser,
        accountIdNumber: dataForm.user,
        accountPassword: dataForm.password
      };
      return this.jar.execJson(this.jarSwat.NAME, this.jarSwat.METHOD.LOGIN, dataLogin);
    }

    /**
    * @description
    * Realiza la consulta al metodo programado en el jar que realiza la
    * consulta de el token asociado al usuario. Si la respuesta del token es
    * que este no es valido se realiza la petición de un nuevo token.
    */
    public validateToken(): any {
      let data: any = {
        token: this.$localStorage.token
      };
      return this.jar.execJson(this.jarSwat.NAME, this.jarSwat.METHOD.VALIDATE_TOKEN, data);
    }

    /**
    * @description
    * El servicio consulta la información por medio de la cedula de un contribuidor
    * vinculado en el soporte de pago, como resultado retorna una lista de
    * contribuidores con la información que es utilizada para el servicio de
    * envio de soportes por medio de email.
    *
    * @param {Array<Srting>} listContributors - Listado de numeros de
    * identificación de los aportantes que se van a consultar.
    * @return {Promise} La promesa solo retorna un resolve, en caso de error
    * el campo error del object es true.
    */
    public contributorsInformation(listContributors: string[]): any {
      let data = {
        token: this.$localStorage.token,
        contributorsIds: listContributors
      };
      return this.jar.execJson(this.jarSwat.NAME, this.jarSwat.METHOD.CONTRIBUTORS_INFORMATION, data);
    }


    /**
    * @description
    * Realiza la consulta de las planillas que estan en estado liquidadas
    * asociadas a la cuenta del usuario logeado.
    *
    * @return {Promise} La promesa solo retorna un resolve, en caso de error
    * el campo error del object es true.
    */
    public listFilesSettlement(): any {
      let data: any = {
        idSoiAportante: this.$localStorage.soiContributorIdNumber,
        idSegUsuario: this.$localStorage.soiAccountIdNumber,
        token: this.$localStorage.token
      };
      // Se consulta la información del servicio REST para retornar la lista de planillas
      return this.jar.execJson(this.jarSwat.NAME, this.jarSwat.METHOD.FILES_SETTLEMENT, data);
    }

    /**
    * @description
    * Consulta en el servidor si existen notificaciones para mostrar en la
    * aplicación y actualizar el archivo local de notificaciones.
    *
    * @return {Promise} La promesa solo retorna un resolve, en caso de error
    * el campo error del object es true.
    */
    public notificationsServer(): any {
      let params: any = {
        token: this.$localStorage.token,
        version: this.OPTIONS.VERSION
      };
      return new Promise((resolve) => {
        let result = this.jar.execJson(this.jarSwat.NAME, this.jarSwat.METHOD.GET_NOTIFICATIONS, params);
        result.then((data) => {
          if (data.code !== "00") {
            this.nativeNotification.show(this.$filter("translate")("MESSAGES.TITLES.ERROR"), this.$filter("translate")("MESSAGES.ERROR_NOTIFICATION_SERVER"));
          }
          resolve(data);
        });
      });
    }

    /**
    * @description
    * Realiza el llamado al metodo que consulta la informacion de las planillas
    * para mostrar en el panel izquierdo o formar la cabecera de la planilla
    * para el envio de emails.
    *
    * @param {String} numberSettlement - Numero de la planilla a consultar.
    * @return {Promise} La promesa solo retorna un resolve, en caso de error
    * se retorna un null como parametro del resolve.
    */
    public infoHeadSettlement(numberSettlement: string): any {
      let params: any = {
        token: this.$localStorage.token,
        numeroPlanilla: numberSettlement
      };
      return new Promise((resolve) => {
        let result = this.jar.execJson(this.jarSwat.NAME, this.jarSwat.METHOD.INFO_HEAD_SETTLEMENT, params);
        result.then((data) => {
          let infoHead = null;
          if (data.code === "00") {
            infoHead = {};
            // Información para envio de emails
            infoHead.planillaAportanteDTO = data.planillaAportanteDTO;
            // Información para mostrar en el panel de la planilla.
            infoHead.numberTemplate = numberSettlement;
            infoHead.typeTemplate = data.tipoPlanilla;
            infoHead.periodPension = data.periodoLiquidacionPensiones;
            infoHead.periodHealth = data.periodoLiquidacionSalud;
            infoHead.totalContributor = data.cantidadEmpleados;
            infoHead.paymentDate = data.fechaPago;
            infoHead.branchOffice = data.sucursal;
          } else {
            this.nativeNotification.show(this.$filter("translate")("MESSAGES.TITLES.ERROR"), data.message);
          }
          resolve(infoHead);
        });
      });
    }

    /**
    * @description
    * Realiza el llamado al metodo que consulta el listado de empleados
    * vinculados a una planilla de liquidación.
    *
    * @param {String} numberSettlement - Numero de la planilla a consultar.
    * @return {Promise} La promesa solo retorna un resolve, en caso de error
    * el campo error del object es true.
    */
    public listContributorsSettlement(numberSettlement: string): any {
      let params: any = {
        token: this.$localStorage.token,
        numeroPlanilla: numberSettlement
      };
      return this.jar.execJson(this.jarSwat.NAME, this.jarSwat.METHOD.LIST_CONTRIBUTORS, params);
    }

  }

  let app: any = angular.module("PILA");
  app.service("jar.swat.service", SwatService);
}

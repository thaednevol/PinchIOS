
namespace app.support {

  /**
  * @class SupportLoadController
  * @author Cristian Camilo Zapata <czapata@swat-it.co>
  * @description
  * Actualiza la vista para visualizar los datos de envio de email, incluye el
  * metodo encargado de cancelar y almacenar el progreso de envio.
  */
  class SupportLoadController {

    /**
    * @type {Object} progress - Almacena los atributos de los valores que son
    * impresos en las vistas para indicar el progreso actual.
    * Cuenta con la siguiente estructura:
    * {
    *   percentage: "0%",
    *   totalEmails: 0,
    *   countEmailsSend: 0
    * }
    */
    public progress: string = "0%";

    /**
    * @type {String} timeElapsed - Tiempo con formato String para visualizar en
    * la vista del tiempo que lleva ejecutando el proceso de envio de emails.
    */
    public timeElapsed: string = "0";


    /**
    * @type {String} startDate - Tiempo en el que se inicio el proceso de
    * envio de emails.
    */
    public startDate: string = "0";

    /**
    * @type {Object} interval - identificador del interval utilizado para
    * actualizar el tiempo de ejecución en la vista.
    */
    private interval: any = null;

    private $scope: any;
    private $rootScope: any;
    private $filter: any;
    static $inject = ["$scope", "$rootScope", "$filter"];

    public constructor($scope, $rootScope, $filter) {
      this.$scope = $scope;
      this.$rootScope = $rootScope;
      this.$filter = $filter;
      // broadcast para inciar el intervalo de tiempo que muestra el reloj
      // y cargar la fecha de inicio del envio de email
      this.$scope.$on("support-start-time-elapsed", () => {
        this.updateTimeElapsed();
        this.setTimeStart();
      });
      // broadcast para detener el intervalo de tiempo que muestra el reloj
      this.$scope.$on("support-stop-time-elapsed", () => {
        this.stopTimeElapsed();
      });
    }

    /**
    * @description
    * Realiza el llamado por broadcast al metodo que detiene la ejecución
    * del envio de emails. El bloque actual que se esta enviando no se detiene,
    * el proceso continuara por debajo hasta finalizar ya que no hay forma de
    * detener el consumo del servicio REST y el servidor de SOI, pero el
    * progreso se almacenara hasta donnde se encuentra en el momento de cancelar.
    */
    public actionCancel(): void {
      this.stopTimeElapsed();
      this.$rootScope.$broadcast("support-stop-emails-send");
    }

    /**
    * @private
    * @description
    * Ejecuta un intervalo de tiempo que refrescara en la pantalla indicando el
    * tiempo que lleva activo el proceso de envio de emails.
    */
    private updateTimeElapsed(): void {
      let seconds: number = 0;
      let minutes: number = 0;
      let hours: number = 0;
      this.interval = setInterval(() => {
        seconds += 1;
        if (seconds > 59) {
          minutes += 1;
          seconds = 0;
        }
        if (minutes > 59) {
          hours += 1;
          minutes = 0;
        }
        this.timeElapsed = `${this.completeZero(hours)}:${this.completeZero(minutes)}:${this.completeZero(seconds)}`;
        this.$scope.$digest();
      }, 1000 * 1);
    }

    /**
    * @private
    * @description
    * Realiza la comprobación de si un numero es menor de 10 para asignarle
    * el valor cero al inicio, esto se realiza para conservar un formato de
    * reloj digital.
    *
    * @param {Number} value - Numero que se desea validar para asignarle el
    * valor de cero.
    * @return {String} Cadena de texto de dos o mas caracteres.
    */
    private completeZero(value: number): string {
      let result = `${value}`;
      if (value < 10) {
        result = `0${value}`;
      }
      return result;
    }

    /**
    * @private
    * @description
    * Asigna la fecha y la hora en la que se inicia el proceso de envio de email
    * para agregar la información en la vista.
    */
    private setTimeStart(): void {
      let time = new Date();
      this.startDate = `${time.getFullYear()}-${this.completeZero(time.getMonth() + 1)}-${this.completeZero(time.getDay())} ${this.completeZero(time.getHours())}:${this.completeZero(time.getMinutes())}`;
      setTimeout(() => {
        this.$scope.$digest();
      });
    }

    /**
    * @private
    * @description
    * Detiene el intervalo de tiempo que indica cuanto lleva ejecutando el
    * proceso de envio de email.
    */
    private stopTimeElapsed(): void {
      if (this.interval) {
        clearInterval(this.interval);
        this.interval = null;
      }
    }

  }

  // Declaración del componente.
  let app: any = angular.module("PILA");
  app.component("supportLoad", {
    bindings: {
      progress: "=" // Contiene información de los progresos que se actualizan
    },
    controller: SupportLoadController,
    templateUrl: "./components/support/support.load.html"
  });
}

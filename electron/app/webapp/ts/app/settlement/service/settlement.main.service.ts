/// <reference path="../../../dt/angular.d.ts"/>

namespace app.settlement {

  /**
   * @class SettlementService
   * @author Luis Felipe Zapata Castaño <lzapata@swat-it.co>
   * @description
   */
  class SettlementService {

    /**
    * @type {Object} OPTIONS - Equivale al archivo de opciones del sistema.
    * @see app/webapp/json/data/options.json
    */
    private OPTIONS: any;

    /**
    * @type {String} routeServer - Indica cual es la ruta del servidor que
    * ejecuta el springboot
    */
    private routeserver: string;

    private $resource: any;
    private $filter:any;
    static $inject = ["$resource", "OPTIONS", "$filter"];

    constructor($resource, OPTIONS, $filter) {
      this.$resource = $resource;
      this.OPTIONS = OPTIONS;
      this.$filter = $filter;
      this.routeserver = `${this.OPTIONS.SERVER_SPRING.SERVER}:${this.OPTIONS.SERVER_SPRING.PORT}/`;
    }

    /**
    * @description
    * Realiza la petición inicial que carga todos los errores del archivo.
    */
    public initialize(params) {
      let service: string = "incializarliquidacion";
      let server: string = `${this.routeserver}${service}`;
      return this.$resource(server, params, {
        get: {
          method: "GET",
          transformResponse: (data) => {
            if (data.indexOf("Apache Tomcat") !== -1) {
              data = {
                error: true,
                message: this.$filter("translate")("MESSAGES.ERROR_500")
              };
              data = JSON.stringify(data);
            }
            if (data === "") {
              data = {
                error: true,
                message: this.$filter("translate")("MESSAGES.ERROR_SETTLEMENT_INITIALIZE")
              };
              data = JSON.stringify(data);
            }
            return {
              data: JSON.parse(data)
            };
          }
        }
      });
    }

    /**
    * @description
    * Servicio REST para validar una fila de la tabla.
    */
    public validateRegister(params) {
      let service: string = "validarcotizante";
      let server: string = `${this.routeserver}${service}`;
      return this.$resource(server, params, {
        get: {
          method: "POST",
          transformResponse: (data) => {
            return {
              data: JSON.parse(data)
            };
          }
        }
      });
    }

    /**
    * @description
    * Servicio REST para consultar el total de la planilla de liquidación.
    */
    public getTotals() {
      let service: string = "gettotales";
      let server: string = `${this.routeserver}${service}`;
      return this.$resource(server, {}, {
        get: {
          method: "GET",
          transformResponse: (data) => {
            if (data === "") {
              data = {
                error: true,
                message: this.$filter("translate")("MESSAGES.ERROR_SETTLEMENT_TOTALES")
              };
              data = JSON.stringify(data);
            }
            return {
              data: JSON.parse(data)
            };
          }
        }
      });
    }

    /**
    * @description
    * Servicio REST que se ejecuta despues de agergar un nuevo registro en la
    * tabla.
    */
    public addRegister(params) {
      let service: string = "agregarcotizante";
      let server: string = `${this.routeserver}${service}`;
      return this.$resource(server, params, {
        get: {
          method: "GET",
          transformResponse: (data) => {
            return {
              data: JSON.parse(data)
            };
          }
        }
      });
    }

    /**
    * @description
    * Servicio REST que se ejecuta despues de haber eliminado un registro de la
    * tabla.
    */
    public removeRegister(params) {
      let service: string = "eliminarcotizante";
      let server: string = `${this.routeserver}${service}`;
      return this.$resource(server, params);
    }

  }

  // Carga del servicio al modulo principal
  let app: any = angular.module("PILA");
  app.service("settlement.service", SettlementService);
}

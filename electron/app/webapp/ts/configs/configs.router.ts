/// <reference path="../dt/angular.d.ts"/>

/**
* @class ConfigsRouteApplication
* @author Luis Felipe Zapata <lzapata@swat-it.co>
* @description
* Clase encargada de la carga de las rutas de archivos de idiomas y rutas de
* componentes.
*/
class ConfigsRouteApplication {

  /**
  * @type {Object} app - Representa un modulo principal de angular utilizado
  * en la aplicación.
  */
  private app: any;

  constructor() {
    this.app = angular.module("PILA");
    this.appRouter();
  }

  /**
  * @private
  * @description
  * Ejecuta el metodo config del modulo principal de angular para la carga de las
  * rutas y provedores de componentes, se realizan la carga de las rutas en
  * archivos JSON, solo las rutas que hagan uso del metodo resolve seran
  * agregadas en la función.
  */
  private appRouter() {
    this.app.config(["$translateProvider", "$stateProvider", "$urlRouterProvider", "$qProvider",
      ($translateProvider, $stateProvider, $urlRouterProvider, $qProvider) => {
        // Valdiación para errores 500 en servidor JAVA.
        $qProvider.errorOnUnhandledRejections(false);
        // Ajuste de la ruta de archivos de idiomas
        $translateProvider.useStaticFilesLoader({
          prefix: "../json/language/",
          suffix: ".json"
        });
        // Por defecto el idioma cargado es español.
        $translateProvider.preferredLanguage("es");
        $translateProvider.useSanitizeValueStrategy("escape");

        // Componentes que se cargan con resolve para variables de url

        let listTable = {
          name: "listTable",
          url: "/list-table/{data}/{file}",
          views: {
            menus: {
              component: "menus"
            },
            "": {
              component: "listTable"
            }
          },
          resolve: {
            data: ["$transition$", ($transition$) => {
              return JSON.parse($transition$.params().data);
            }],
            file: ["$transition$", ($transition$) => {
              return JSON.parse($transition$.params().file);
            }]
          }
        };

        let settlement = {
          name: "settlement",
          url: "/settlement/{pathFile}",
          views: {
            menus: {
              component: "menus"
            },
            "": {
              component: "settlement"
            }
          },
          resolve: {
            pathFile: ["$transition$", ($transition$) => {
              return $transition$.params().pathFile;
            }]
          }
        };

        let support = {
          name: "support",
          url: "/support/?{numberDashboard}",
          views: {
            menus: {
              component: "menus"
            },
            "": {
              component: "support"
            }
          },
          resolve: {
            numberDashboard: ["$transition$", ($transition$) => {
              return $transition$.params().numberDashboard;
            }]
          }
        };

        $stateProvider.state(listTable);
        $stateProvider.state(settlement);
        $stateProvider.state(support);

        // Carga de rutas de componentes desde archivo externo de rutas.
        for (let key in globalRoutes) {
          $stateProvider.state(globalRoutes[key]);
        }
        $urlRouterProvider.otherwise("/");

      }]);
  }
}

new ConfigsRouteApplication();

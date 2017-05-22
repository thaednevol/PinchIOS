/// <reference path="../dt/angular.d.ts"/>

/**
* @class ConfigsRunApplication
* @author Luis Felipe Zapata <lzapata@swat-it.co>
* @description
* Clase encargada de ejecutar el run de la aplicación angular para validar el
* estado de carga del inicio de la aplicación y aplicar redirecciones.
*/
class ConfigsRunApplication {

  /**
  * @type {Object} app - Representa un modulo principal de angular utilizado
  * en la aplicación.
  */
  private app: any;

  constructor() {
    this.app = angular.module("PILA");
    this.appRun();
  }

  /**
  * @private
  * @description
  * Ejecuta el metodo run del modulo angular principal para detectar si esta o
  * no los datos de sesion almacenados para hacer login o redireccionar al
  * dashboard. El elemento $localStorage.login almacena un JSON con los datos
  * de acceso.
  * Se hace un llamado al servicio de archivo para que cree la estructura de
  * carpetas antes de hacer uso de la aplicación.
  */
  private appRun() {
    this.app.run(["$rootScope", "$localStorage", "$state", "OPTIONS","native.file.service",
      ($rootScope, $localStorage, $state, OPTIONS, file) => {

        /**
        * @description
        * Realiza la carga del stage segun la posición indicada si esta logeado
        * o no basado en la información del localStorage.
        */
        function loadStage(){
          $rootScope.version = OPTIONS.VERSION;
          if ($localStorage.login) {
            $rootScope.userLogin = false;
            $state.go("dashboard");
          } else {
            $rootScope.userLogin = true;
            $state.go("login");
          }
        }

        loadStage();
      }]);
  }
}

new ConfigsRunApplication();


/**
* @class Application
* @author Luis Felipe Zapata <lzapata@swat-it.co>
* @description
* Componente principal o modulo de inicio de la app.
*/
class Application {

  private app: any;

  constructor() {
    // this.validateLoad();
    this.initializeApp();
  }

  /**
  * @private
  * @description
  * Valida si la precarga se completo, cuando finaliza se realiza la asignación
  * de las constantes, si no se completa se ejecuta un timer para que se realice
  * el llamado de nuevo al metodo hasta que se termine la carga.
  */
  private validateLoad() {
    if (globalOptions) {
      this.initializeApp();
    } else {
      setTimeout(() => {
        this.validateLoad();
        // El tiempo no se puede asignar en una constante por ser el timer
        // asignado para la carga del archivo de opciones
      }, 100);
    }
  }

  /**
  * @private
  * @description
  * Crea el modulo principal de la aplicación con las inyección de dependencias.
  */
  private initializeApp() {
    this.app = angular.module("PILA", [
      "PILA.Options", // Modulo de opciones de configuración de la app configs.angular
      "pascalprecht.translate", // Libreria de traducción
      "ngResource", // Libreria para consumo de recursos REST
      "ui.router", // Libreria de enrutamiento
      "ngStorage" // Libreria para almacenar datos en localstorage de HTML5
    ]);
  }
}

new Application();

/// <reference path="../../dt/angular.d.ts"/>

namespace app.modal {

  /**
  * @class LoadingController
  * @author Luis Felipe Zapata <lzapata@swat-it.co>
  * @description
  * La clase se encarga de cargar una ventana de componente cuando se requiera
  * visualizar un loading, se hace visible unicamente cuando se asigna el
  * parametro showLoading true, el contenedor se ajusta al tamaño del padre que
  * carga el componente.
  */
  class LoadingController {

    /**
    * @type {Boolean} showLoading - Indica si se debe mostrar el loading o se
    * oculta para desbloquear el contenido.
    */
    public showLoading: Boolean = false;

    constructor() { }

  }

  let app: any = angular.module("PILA");
  app.component("loading", {
    controller: LoadingController,
    bindings: {
      showLoading: "="  // Indica si se debe mostrar la barra de progreso.
    },
    templateUrl: "./components/loading/loading.main.html"
  });
}

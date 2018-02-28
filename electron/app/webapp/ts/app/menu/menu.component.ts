
namespace app.menu {

  /**
  * @class MenuControler
  * @author Luis Felipe Zapata <lzapta@swat-it.co>
  * @description
  * Clase encargada de la gestión del menu y navegación en la aplicación,
  * tambien realiza el logout.
  */
  class MenuControler {

    /**
    * @type {Object<uiSref, title>[]} menu - Contiene los objetos del menu
    * permitidos.
    */
    public menu: any;

    /**
    * @type {String} user - Nombre del usuario que se logea.
    */
    public user: string;

    /**
    * @type {Boolean} showConfiguration - Indica si se muestra el icono de
    * configuracion del menu desplegable basado en los permisos del usuario.
    */
    public showConfiguration: boolean = false;

    /**
    * @type {Boolean} showSubMenu - Indica si se muestra el submenu del usuario.
    */
    public showSubMenu: boolean = false;

    /**
    * @type {Object} MENUS - Equivale al archivo de menus del sistema.
    * @see json/data/menus.json
    */
    private MENUS: any;

    private $localStorage: any;
    private $state: any;
    private $rootScope: any;
    static $inject = ["$localStorage", "$state", "$rootScope", "MENUS"];

    constructor($localStorage, $state, $rootScope, MENUS) {
      this.$localStorage = $localStorage;
      this.$state = $state;
      this.$rootScope = $rootScope;
      this.MENUS = MENUS;
      this.validatePermissions();
      this.loadUserName();
    }

    /**
    * @private
    * @description
    * Almacena el nombre del usuario que realizo el login.
    */
    private loadUserName(): void {
      if (this.$localStorage.nameUser) {
        this.user = this.$localStorage.nameUser;
      }
    }

    /**
    * @private
    * @description
    * Consulta desde el localStorage los permisos asignados al usuario para ver
    * las opciones del menu, almacena los String en un array que luego es
    * comparado contra el archivo del menu.json, el boton de configuración es
    * el unico que no carga en la cinta de opciones por ser un icono.
    */
    private validatePermissions(): void {
      if (this.$localStorage.permissions) {
        let menuPermitted: any[] = [];
        this.$localStorage.permissions.forEach((value) => {
          // Si tiene permisos de configuración se indica que se puede mostrar el boton
          if (value === "Configuracion") {
            this.showConfiguration = true;
          } else {
            if (this.MENUS[value]) {
              menuPermitted.push(this.MENUS[value]);
            }
          }
        });
        this.menu = menuPermitted;
        this.menu.unshift(this.MENUS["dashboard"]);
      }
    }

    public showConfigDialog():void{
            let str="<div>"+
              "<input id='sm' type='checkbox'/>"+
                "<label for='check' class='ui-widget'>Cargar al iniciar</label>"+
                "</div>"+
                "<div>"+
                "<input id='md' type='checkbox'/>"+
                "<label for='check' class='ui-widget'>Validar al iniciar</label>"+
                "</div>"+
                "<div>"+
                "<input id='lg' type='checkbox'/>"+
                "<label for='check' class='ui-widget'>Validar al visualizar</label>"+
                "</div>";
            $("<div class='dialog' >"+str+"</div>").dialog({
                title: 'Configuraciones',
                modal: true,
                close: function(event, ui) {
                  $(this).dialog('destroy');
                }
              }
            ).show();

          //let cargar_al_iniciar = localStorage.getItem('cargar_al_iniciar');
          let cargar_al_iniciar = "true"
          if (cargar_al_iniciar === null) {
            cargar_al_iniciar = JSON.parse("true");
          } else {
            cargar_al_iniciar = JSON.parse(cargar_al_iniciar);
          }
          $('#sm').prop('checked', cargar_al_iniciar);
          $("#sm").change(function() {
            let myVar=JSON.parse(this['checked']);
            localStorage.setItem('cargar_al_iniciar',myVar);
          });

          //let validar_al_iniciar = localStorage.getItem('validar_al_iniciar');
          let validar_al_iniciar = "true";
          if (validar_al_iniciar === null) {
            validar_al_iniciar = JSON.parse("true");
          } else {
            validar_al_iniciar = JSON.parse(validar_al_iniciar);
          }
          $('#md').prop('checked', validar_al_iniciar);
          $("#md").change(function() {
            let myVar=JSON.parse(this['checked']);
            localStorage.setItem('validar_al_iniciar',myVar);
          });

          //let validar_al_visualizar = localStorage.getItem('validar_al_visualizar');
          let validar_al_visualizar = "false";
          if (validar_al_visualizar === null) {
            validar_al_visualizar = JSON.parse("false");
          } else {
            validar_al_visualizar = JSON.parse(validar_al_visualizar);
          }
          $('#lg').prop('checked', validar_al_visualizar);
          $("#lg").change(function() {
            let myVar=JSON.parse(this['checked']);
            localStorage.setItem('validar_al_visualizar',myVar);
          });
        }

    /**
    * @description
    * Elimina los datos de la sesion actual y redirecciona al login de la
    * aplicación.
    */
    public actionLogout(): void {
      this.$localStorage.$reset();
      this.$state.go("login");
    }

  }

  // Agrega el componente al modulo principal.
  let app: any = angular.module("PILA");
  app.component("menus", {
    controller: MenuControler,
    templateUrl: "./menus/menus.main.html"
  });
}

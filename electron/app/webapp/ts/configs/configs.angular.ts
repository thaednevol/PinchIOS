/// <reference path="../dt/angular.d.ts"/>
/// <reference path="../dt/Soi.d.ts"/>

/**
* @class ConfigOptions
* @author Luis Felipe Zapata <lzapata@swat-it.co>
* @description
* Modulo encargado de cargar los archivos de opciones de la aplicación.
*/
class ConfigOptions {

  /**
  * @type {Object} moduleOptions - Es el modulo de angular que carga las
  * constantes de opciones de la aplicación.
  */
  private moduleOptions: any;

  constructor() {
    this.moduleOptions = angular.module("PILA.Options", []);
    this.saveConstants();
  }

  /**
  * @private
  * @description
  * Almacena en constantes que se requieren al inicio de la aplicación, estas
  * son almacenadas en variables globales creatas antes de realiza la carga de
  * la ventana principal de la aplicación en el archivo preload.js de electron.
  */
  private saveConstants() {
    // La constante almacena la información del Archivo JSON de opciones
    this.moduleOptions.constant("OPTIONS", globalOptions);
    // La cosntante almacena la información de Archivo JSON que almacena la
    // información de los formularios de la aplicación.
    this.moduleOptions.constant("FORMS", globalForms);
    // Constante que almacena la información para construir los menus.
    this.moduleOptions.constant("MENUS", globalMenus);
  }
}

new ConfigOptions();

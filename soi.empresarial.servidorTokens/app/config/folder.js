/**
 * @description
 * Almacena las rutas absolutas de las carpetas de la aplicación, estas seran
 * usadas para realizar correctamente el proceso de importación de archivos.
 *
 * @author Luis Felipe Zapata - lzapata@swat-it.co
 */
(function() {

  "use strict";
  var path = require('path');

  var folder = {
    root: path.normalize(__dirname + "/../.."),
    controllers: path.normalize(__dirname + "/../../app/controllers"),
    route: path.normalize(__dirname + "/../../app/routes"),
    config: path.normalize(__dirname + "/../../app/config")
  };

  module.exports = folder;

})();

/**
 * @description
 * Inicia la instancia del servidor, llama a las librerias de configuración.
 *
 * Variables
 *    config: contiene la configuración del servidor y llaves de encriptación.
 *    folder: contiene todas las rutas absolutas para ser usadas dentro de require().
 *
 * @author Luis Felipe Zapata - lzapata@swat-it.co
 */
(function() {

  var app = require('express')();
  var server = require('http').Server(app);

  global.folder = require('./app/config/folder');
  global.config = require('./app/config/options');

  require('./app/config/express')(app);

  server.listen(config.port, function() {
    console.info("Servidor generador de tokens iniciado");
    console.info("Puerto: " + config.port);
  });

})();

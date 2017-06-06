/**
 * @description
 * Configuración del servidor de Express, agrega rutas, configura sesiones y carga
 * los modelos de base de datos global.
 *
 * @author Luis Felipe Zapata - lzapata@swat-it.co
 */
(function() {

  "use strict";
  var express = require('express');
  var path = require('path');
  var bodyParser = require('body-parser');
  var session = require('express-session');
  var rateLimit = require('express-rate-limit');

  module.exports = function(app) {

    //Para el envio de formularios post
    app.use(bodyParser.json());
    app.use(bodyParser.urlencoded({
      extended: true
    }));

    //Se agrega el limite para peticiones HTTP a las API
    var apiLimiter = new rateLimit({
      windowMs: 5 * 60 * 1000,
      max: 100,
      delayMs: 0 // disabled
    });

    //Se indica que el limite se aplica unicamente en la url principal
    app.use('/', apiLimiter);

    //agregar configuración de URLS
    require(path.join(folder.config, 'routes'))(app);

  }

})();

/**
 * @description
 * Carga las rutas utilizadas para las API's
 *
 * @author Luis Felipe Zapata - lzapata@swat-it.co
 */
(function() {

  "use strict";
  var path = require('path');
  var Api = require(path.join(folder.controllers, 'Api'));

  module.exports = function(app) {

    // Activa CORS
    app.use(function(req, res, next) {
      res.header("Access-Control-Allow-Origin", "*");
      res.header("Access-Control-Allow-Headers", config.http.CORS.toString());
      next();
    });

    // Carga rutas utilizadas en el API
    var routeToken = require(path.join(folder.route, config.api.folder + 'token'));
    app.use(config.api.routeUrl + '/token', routeToken);


    //Si se accede a una URL que no corresponda se muestra este mensaje
    app.use('/', function(req, res) {
      var response = "The URL path is not valid.";
      Api.response(res, response, Api.CODE.ERRORTOKENNOTAUTHORIZED);
    });
  }

})();

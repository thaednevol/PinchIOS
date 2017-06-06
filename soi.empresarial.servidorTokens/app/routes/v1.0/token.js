/**
 * @description
 * Asocia los metodos que debe ejecutar del controlador segun la ruta y el tipo de metodo.
 *
 * @author Luis Felipe Zapata - lzapata@swat-it.co
 */
(function () {

  var express = require('express');
  var path = require('path');
  var router = express.Router();
  var TokenController = require(path.join(
    folder.controllers,
    config.api.folder + 'TokenController'
  ));

  router.post('/', TokenController.create);
  router.post('/validate', TokenController.validate);

  module.exports = router;

})();

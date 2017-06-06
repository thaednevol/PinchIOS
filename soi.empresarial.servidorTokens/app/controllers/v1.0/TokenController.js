/**
 * @description
 * Controlador de los servicios REST encargado de crear y validar los token de
 * los usuarios.
 *
 * @author Luis Felipe Zapata - lzapata@swat-it.co
 */
(function () {

    "use strict";
    var jwt = require('jsonwebtoken');
    var path = require('path');
    var Api = require(path.join(folder.controllers, 'Api'));

    /**
     * @description
     * Crea el token de conexión para el usuario con la información del registro,
     * retorna la información del usuario pero limpia el campo del id antes de
     * enviarlo.
     *
     * @param {string} user - Nombre de usuario para agregar al metodo GET.
     * @author Luis Felipe Zapata - lzapata@swat-it.co
     */
    exports.create = function (req, res) {
        var code = Api.STATUS.BAD_REQUEST;
        var data = null;
        if (req.body.user) {
            var token = Api.createToken(req.body.user, req.body.expirationTime);
            var data = {
                token: token
            };
            code = Api.CODE.SUCCESSFULL;
        }else{
        	code = Api.CODE.ERROR;
        }
        Api.response(res, data , code);
    }

    /**
     * @description
     * Valida si existe el token y esta activo.
     */
    exports.validate = function (req, res) {
        Api.isCorrectToken(req, res)
            .then(function (token) {
                Api.noDataResponse(res, Api.CODE.SUCCESSFULL);
            });
    }

})();

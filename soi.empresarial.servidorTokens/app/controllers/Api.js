/**
 * @description Controla las funciones basicas del API, codigos de los mensajes,
 *              creación y validación de tokens de seguridad, respuestas de
 *              error y correctas del api
 * 
 * @author Luis Felipe Zapata - lzapata@swat-it.co
 */
(function() {

	"use strict";
	var jwt = require('jsonwebtoken');

	// Los status que se pueden responden en los web services
	var STATUS = {
		DONE : 200,
		CREATE : 201,
		NO_CONTENT : 202,
		DUPLICATE : 207,
		BAD_REQUEST : 400,
		UNAUTHORIZED : 401,
		BAD_PARAMS : 402,
		METHOD_NOT_ALLOWED : 405,
		NO_IMPLEMENT : 501
	}
	// Contiene los códigos de error que pueden ser respondidos por los
	// servicios
	var CODE = {
		SUCCESSFULL : '00',
		ERRORTOKENSERVICERESPONSE : '33',
		ERRORTOKENNOTAUTHORIZED : '35'
	}
	exports.CODE = CODE;
	exports.STATUS = STATUS;

	/**
	 * @description
	 * 
	 */
	exports.createToken = function(data, timeExpires) {
		return jwt.sign({
			data : data
		}, config.secretKey, {
			expiresIn : timeExpires
		});
	}

	/**
	 * @description Valida si el token tiene el contenido adecuado y lo retorna
	 * 
	 * @param {Request-Express}
	 *            Contenido de la petición de express
	 * @return {Promise} Promesa para indicar si se proceso correcto o con
	 *         errores
	 */
	exports.isCorrectToken = function(req, res) {
		var token = req.body.token;
		return new Promise(function(resolve, reject) {
			jwt.verify(token, config.secretKey, function(error, decode) {
				if (decode) {
					resolve(decode);
				} else {
					noDataResponse(res, STATUS.DONE,
							CODE.ERRORTOKENNOTAUTHORIZED);
				}
			})
		});
	}

	exports.response = function(res, data, code) {
		sendResponse(res, data, STATUS.DONE, code);
	}

	exports.noDataResponse = function(res, code) {
		noDataResponse(res, STATUS.DONE, code);
	}

	/**
	 * @description Envia la respuesta json con los keys "code" y "data" que
	 *              contiene la información de la base de datos.
	 */
	function sendResponse(res, data, status, code) {
		status = status || STATUS.DONE
		if (dataEmpty(data)) {
			status = STATUS.NO_CONTENT;
			code = ERRORTOKENSERVICERESPONSE;
		}
		res = setHeaders(res);
		res.status(status).jsonp({
			data : data,
			code : code
		});
	}

	/**
	 * @description Envia la respuesta de un servicio el cual solo requiere el
	 *              código de error
	 */
	function noDataResponse(res, status, code) {
		status = status || STATUS.DONE
		res = setHeaders(res);
		res.status(status).jsonp({
			code : code
		});
	}

	/**
	 * @description Valida si el tipo de dato es un objeto o array y si no esta
	 *              vacio para entregar el codigo que indica que fue correcto el
	 *              proceso pero sin resultados.
	 */
	function dataEmpty(data) {
		if (typeof data === 'object' && data !== null) {
			return data.length === 0
		}
		return false;
	}

	/**
	 * @description Personaliza la cabecera de las respuestas
	 */
	function setHeaders(res) {
		res.header('Content-Type', 'application/json');
		res.header('X-Powered-By', 'Swat-it');
		return res;
	}

})();

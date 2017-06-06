/**
 * @description Opciones de configuración basicas de la aplicación, se define
 *              como la Variable config de forma global para acceder a las
 *              propiedades.
 * 
 * @author Luis Felipe Zapata - lzapata@swat-it.co
 * @see app.js
 */
(function() {

	"use strict";
	var optionApp = {
		/**
		 * Puerto del servidor de administración de tokens
		 */
		port : 5002,
		/**
		 * Llave usada para generar los tokens
		 */
		secretKey : 'Adf34Fgb10Sfg32FG',
		/**
		 * Ruta a los servicios
		 */
		api : {
			routeUrl : '/v1.0',
			folder : 'v1.0/'
		},
		/**
		 * Contenido del header esperado, contenido necesario.
		 */
		http : {
			header : {
				token : 'access-token'
			},
			CORS : [ 'access-token', 'Origin', 'X-Requested-With',
					'Content-Type', 'Accept' ]
		}
	};

	module.exports = optionApp;

})();

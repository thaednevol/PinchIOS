(function webpackUniversalModuleDefinition(root, factory) {
	if(typeof exports === 'object' && typeof module === 'object')
		module.exports = factory(require("../../handsontable-pro"));
	else if(typeof define === 'function' && define.amd)
		define(["../../handsontable-pro"], factory);
	else {
		var a = typeof exports === 'object' ? factory(require("../../handsontable-pro")) : factory(root["Handsontable"]);
		for(var i in a) (typeof exports === 'object' ? exports : root)[i] = a[i];
	}
})(typeof self !== 'undefined' ? self : this, function(__WEBPACK_EXTERNAL_MODULE_0__) {
return /******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 1);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ (function(module, exports) {

module.exports = __WEBPACK_EXTERNAL_MODULE_0__;

/***/ }),
/* 1 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


exports.__esModule = true;

var _dictionary;

var _handsontablePro = __webpack_require__(0);

var _handsontablePro2 = _interopRequireDefault(_handsontablePro);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function
_defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; } /**
                                                                                                                                                                                                                   * @preserve
                                                                                                                                                                                                                   * Authors: Handsoncode
                                                                                                                                                                                                                   * Last updated: Nov 15, 2017
                                                                                                                                                                                                                   *
                                                                                                                                                                                                                   * Description: Definition file for English - United States language-country.
                                                                                                                                                                                                                   */


var C = _handsontablePro2.default.languages.dictionaryKeys;

var dictionary = (_dictionary = {
  languageCode: 'es-CO'
},
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_ROW_ABOVE, 'Insertar fila arriba'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_ROW_BELOW, 'Insertar fila abajo'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_INSERT_LEFT, 'Insertar columna a la izquierda'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_INSERT_RIGHT, 'Insertar columna a la derecha'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_REMOVE_ROW, ['Borrar fila', 'Borrar filas']),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_REMOVE_COLUMN, ['Borrar columna', 'Borrar columnas']),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_UNDO, 'Deshacer'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_REDO, 'Rehacer'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_READ_ONLY, 'Solo lectura'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_CLEAR_COLUMN, 'Borrar columna'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_ALIGNMENT, 'Alineaci\u00F3n'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_ALIGNMENT_LEFT, 'Izquierda'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_ALIGNMENT_CENTER, 'Centro'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_ALIGNMENT_RIGHT, 'Derecha'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_ALIGNMENT_JUSTIFY, 'Justificar'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_ALIGNMENT_TOP, 'Arriba'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_ALIGNMENT_MIDDLE, 'Medio'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_ALIGNMENT_BOTTOM, 'Abajo'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_FREEZE_COLUMN, 'Fijar columna'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_UNFREEZE_COLUMN, 'Liberar columna'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_BORDERS, 'Bordes'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_BORDERS_TOP, 'Arriba'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_BORDERS_RIGHT, 'Derecha'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_BORDERS_BOTTOM, 'Abajo'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_BORDERS_LEFT, 'Izquierda'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_REMOVE_BORDERS, 'Quitar bordes'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_ADD_COMMENT, 'Agregar comentarios'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_EDIT_COMMENT, 'Editar comentarios'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_REMOVE_COMMENT, 'Borrar comentarios'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_READ_ONLY_COMMENT, 'Comentario de solo lectura'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_MERGE_CELLS, 'Unir celdas'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_UNMERGE_CELLS, 'Desunir celdas'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_COPY, 'Copiar'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_CUT, 'Cortar'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_NESTED_ROWS_INSERT_CHILD, 'Insertar fila hija'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_NESTED_ROWS_DETACH_CHILD, 'Desvincular del padre'),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_HIDE_COLUMN, ['Esconder columna', 'Esconder columnas']),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_SHOW_COLUMN, ['Mostrar columna', 'Mostrar columas']),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_HIDE_ROW, ['Esconder fila', 'Esconder filas']),
_defineProperty(_dictionary, C.CONTEXTMENU_ITEMS_SHOW_ROW, ['Mostrar fila', 'Mostrar filas']),
_defineProperty(_dictionary, C.FILTERS_CONDITIONS_NONE, 'Ninguna'),
_defineProperty(_dictionary, C.FILTERS_CONDITIONS_EMPTY, 'Esta vac\u00EDo'),
_defineProperty(_dictionary, C.FILTERS_CONDITIONS_NOT_EMPTY, 'No esta vac\u00EDo'),
_defineProperty(_dictionary, C.FILTERS_CONDITIONS_EQUAL, 'Es igual a'),
_defineProperty(_dictionary, C.FILTERS_CONDITIONS_NOT_EQUAL, 'Es diferente a'),
_defineProperty(_dictionary, C.FILTERS_CONDITIONS_BEGINS_WITH, 'Comienza con'),
_defineProperty(_dictionary, C.FILTERS_CONDITIONS_ENDS_WITH, 'Termina con'),
_defineProperty(_dictionary, C.FILTERS_CONDITIONS_CONTAINS, 'Contiene'),
_defineProperty(_dictionary, C.FILTERS_CONDITIONS_NOT_CONTAIN, 'No contiene'),
_defineProperty(_dictionary, C.FILTERS_CONDITIONS_GREATER_THAN, 'Mayor que'),
_defineProperty(_dictionary, C.FILTERS_CONDITIONS_GREATER_THAN_OR_EQUAL, 'Mayor o igual a'),
_defineProperty(_dictionary, C.FILTERS_CONDITIONS_LESS_THAN, 'Menor que'),
_defineProperty(_dictionary, C.FILTERS_CONDITIONS_LESS_THAN_OR_EQUAL, 'Menor o igual a'),
_defineProperty(_dictionary, C.FILTERS_CONDITIONS_BETWEEN, 'Est\u00E1  entre'),
_defineProperty(_dictionary, C.FILTERS_CONDITIONS_NOT_BETWEEN, 'No est\u00E1 entre'),
_defineProperty(_dictionary, C.FILTERS_CONDITIONS_AFTER, 'Despu\u00E9s'),
_defineProperty(_dictionary, C.FILTERS_CONDITIONS_BEFORE, 'Antes'),
_defineProperty(_dictionary, C.FILTERS_CONDITIONS_TODAY, 'Hoy'),
_defineProperty(_dictionary, C.FILTERS_CONDITIONS_TOMORROW, 'Ma\u00F1ana'),
_defineProperty(_dictionary, C.FILTERS_CONDITIONS_YESTERDAY, 'Ayer'),
_defineProperty(_dictionary, C.FILTERS_VALUES_BLANK_CELLS, 'Celdas vac\u00EDas'),
_defineProperty(_dictionary, C.FILTERS_DIVS_FILTER_BY_CONDITION, 'Filtrar por condici\u00F3n'),
_defineProperty(_dictionary, C.FILTERS_DIVS_FILTER_BY_VALUE, 'Filtrar por valor'),
_defineProperty(_dictionary, C.FILTERS_LABELS_CONJUNCTION, 'Y'),
_defineProperty(_dictionary, C.FILTERS_LABELS_DISJUNCTION, 'O'),
_defineProperty(_dictionary, C.FILTERS_BUTTONS_SELECT_ALL, 'Seleccionar todo'),
_defineProperty(_dictionary, C.FILTERS_BUTTONS_CLEAR, 'Limpiar'),
_defineProperty(_dictionary, C.FILTERS_BUTTONS_OK, 'OK'),
_defineProperty(_dictionary, C.FILTERS_BUTTONS_CANCEL, 'Cancelar'),
_defineProperty(_dictionary, C.FILTERS_BUTTONS_PLACEHOLDER_SEARCH, 'Buscar'),
_defineProperty(_dictionary, C.FILTERS_BUTTONS_PLACEHOLDER_VALUE, 'Valor'),
_defineProperty(_dictionary, C.FILTERS_BUTTONS_PLACEHOLDER_SECOND_VALUE, 'Segundo valor'), _dictionary);

_handsontablePro2.default.languages.registerLanguageDictionary(dictionary);

exports.default = dictionary;

/***/ })
/******/ ])["___"];
});

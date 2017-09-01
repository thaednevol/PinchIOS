/**
 * @author Luis Felipe Zapata <lzapata@swat-it.co>
 * @description
 * Se encarga de cargar los archivos de configuración que seran utilizados en
 * la aplicación.
 * Todas las funciones tienen un return para permitir que la carga del contenido
 * termine antes de realizar la siguiente carga. Se carga el archivo de
 * opciones de ultimo para la validación de precarga completa del angularJs.
 */


var fs = require("fs");
var path = require("path");

// Ruta donde se almacena los archivos de opciones en el equipo
var dirData = path.join(__dirname, "public", "json", "data");
// Indica el numero de archivos que se han cargado de las opciones
var filesLoaded = 0;

/**
 * @description
 * El archivo de opciones contiene la información de rutas, carpetas, archivos
 * y demas opciones como API y estructura de tablas.
 */
function loadJsonOptions() {
  var routeFile = path.join(dirData, "options.json");
  var data = fs.readFileSync(routeFile, "utf8");
  const ipcRenderer = require("electron").ipcRenderer;
  global.globalOptions = JSON.parse(data);
  loadComplete();
  return;
  /*return fs.readFile(routeFile, "utf8", function(error, data) {
    const ipcRenderer = require("electron").ipcRenderer;
    if (error || data === "") {
      return loadJsonOptions();
    }
    global.globalOptions = JSON.parse(data);
    loadComplete();
    return;
  });*/
}

/**
 * @description
 * El archivo routes almacena las rutas de los componentes que no requeiran de
 * un resolve para el paso de información de variables.
 */
function loadJsonRoutes() {
  var routeFile = path.join(dirData, "routes.json");
  var data = fs.readFileSync(routeFile, "utf8");
  global.globalRoutes = JSON.parse(data);
  loadComplete();
  return;
  /*return fs.readFile(routeFile, "utf8", function(error, data) {
    if (error || data === "") {
      return loadJsonRoutes();
    }
    global.globalRoutes = JSON.parse(data);
    loadComplete();
    return;
  });*/
}

/**
 * @description
 * El archivo con los valores por defecto para los campos de los formularios
 * que se utilizan en la aplicación. Este archivo contiene los valores de los
 * selects agregando la variable de idioma para su impresión.
 */
function loadJsonForms() {
  var routeFile = path.join(dirData, "forms.json");
  var data = fs.readFileSync(routeFile, "utf8");
  global.globalForms = JSON.parse(data);
  loadComplete();
  return;
  /*return fs.readFile(routeFile, "utf8", function(error, data) {
    if (error || data === "") {
      return loadJsonForms();
    }
    global.globalForms = JSON.parse(data);
    loadComplete();
    return;
  });*/
}

/**
 * @description
 * El archivo con los valores de los menus que se utilizan en la aplicación.
 * Carga los permisos, iconos y enlaces que abre.
 */
function loadJsonMenus() {
  var routeFile = path.join(dirData, "menus.json");
  var data = fs.readFileSync(routeFile, "utf8");
  global.globalMenus= JSON.parse(data);
  loadComplete();
  return;
  /*return fs.readFile(routeFile, "utf8", function(error, data) {
    if (error || data === "") {
      return loadJsonForms();
    }
    global.globalMenus= JSON.parse(data);
    loadComplete();
    return;
  });*/
}

/**
* @description
* Valida si se cargaron los script completos, luego ejecuta el llamado a la
* función que se encarga de ocultar la precarga y cargar la ventana de la app.
*/
function loadComplete() {
  filesLoaded += 1;
  if (filesLoaded >= 4) {
    const {
      ipcRenderer
    } = require("electron");
    ipcRenderer.send("load-complete");
  }
}
// Se realiza el llamado a las funciones de carga de los archivos JSON.
loadJsonRoutes();
loadJsonForms();
loadJsonMenus();
loadJsonOptions();

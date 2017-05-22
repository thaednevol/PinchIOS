/**
 * @author Luis Felipe Zapata <lzapata@swat-it.co>
 * @description
 * Componente principal encargado de iniciar el proyecto Electron, contiene las
 * configuraciones requeridas para la pantalla de la aplicación.
 */

const {
  app,
  BrowserWindow,
  ipcMain
} = require("electron");
var path = require("path");

// Ventana de la aplicación
var mainWindow = null;
// Ventana de precarga de la aplicación
var loadWindow = null;

app.on("ready", () => {

  // Carga el codigo de la ventana
  mainWindow = new BrowserWindow({
    width: 1280,
    height: 850,
    minWidth: 970,
    minHeight: 720,
    center: true,
    show: false,
    webPreferences: {
      preload: path.join(__dirname, "preload.js")
    }
  });
  mainWindow.loadURL(`file://${__dirname}/public/views/index.html`);

  // Ventana de precarga
  loadWindow = new BrowserWindow({
    width: 300,
    height: 600,
    movable: false,
    resizable: false,
    center: true,
    closable: false,
    maximizable: false,
    minimizable: false,
    alwaysOnTop: true,
    frame: false,
    titleBarStyle: "hidden"
  });
  loadWindow.loadURL(`file://${__dirname}/public/views/loading.html`);
  // Si se cierra la ventana se eliminan todas las subventanas.
  mainWindow.on("closed", () => {
    mainWindow = null;
    loadWindow = null;
    app.quit();
  });
});

// Se asigna un evento para ejecutar cuando la carga de todos los archivo JSON
// se complete. Se da 1 segundo de tiempo para que se rendericen el DOM inicial.
ipcMain.once("load-complete", (event, args) => {
  setTimeout(() => {
    if (mainWindow) {
      mainWindow.show();
      if (loadWindow) {
        loadWindow.hide();
        loadWindow.setClosable(true);
        loadWindow.close();
      }
      loadWindow = null;
    }
  }, 1000 * 1.5);
});

app.on("window-all-closed", () => {
  app.quit();
});

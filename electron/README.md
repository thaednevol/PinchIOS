# Liquidación Planillas PILA

La aplicación hace uso del framework AngularJs en la versión 1.6, el empaquetado del cliente de escritorio es Electron, el editor de codigo utilizado es Atom con la siguiente lista de plugins:

* [atom-beautify](https://atom.io/packages/atom-beautify)
* [atom-live-server](https://atom.io/packages/atom-live-server)
* [atom-typescript](https://atom.io/packages/atom-typescript)
* [language-pug](https://atom.io/packages/language-pug)
* [language-stylus](https://atom.io/packages/language-stylus)
* [linter](https://atom.io/packages/linter)
* [linter-tslint](https://atom.io/packages/linter-tslint)
* [editorconfig](https://atom.io/packages/editorconfig)

## Configuración de entornos

Antes de hacer cambios en el proyecto se requiete que el equipo de desarrollo tenga instalado las siguientes aplicaciones.

* [GIT](https://git-scm.com/)
* [NodeJS](https://nodejs.org/es/)
* [Bower](https://bower.io/): Para instalar se ejecuta el comando ` npm install -g bower `

Las versiones utilizadas de NodeJS y NPM son las siguientes:

* NodeJs: **6.9.1**
* NPM: **4.0.5**

Desde una terminal de comandos se abre la carpeta del proyecto y se ejecutan los siguientes comandos para realizar la instalación de las dependencias del proyecto:

```sh
bower install
npm install
```


### Variables de plantillas
El archivo ubicado en la carpeta **app/views/layouts/main.pug** cuenta con un un bloque de variables donde se asigna en nombre de la pagina HTML y una variable que realiza el switch entre las versiones de producción y desarrollo, segun la versión que se compile se debe hacer el switch, este es utilizado para realizar la carga del codigo minificado y ofuscado de los codigos CSS y JS en ambientes de producción.

### Producción
Para ejecutar la aplicación final se debe de ejecutar el comando ` npm run build `, consulta las dependencias necesarias y crea el instalador para Windows y MacOSX registrandolo en la carpeta llamada **dist** dentro del proyecto.

### Desarrollo

En una terminal de comandos se abre la carpeta del proyecto y se ejecuta el comando ` gulp development ` este inicia la compilación y copia los archivos necesarios para que se ejecute la aplicación en modo de desarrollo para su depuración.

Para ejecutar el entorno directamente desde la aplicación de Electron se debe ejecutar el comando ` npm start ` desde la terminal, se puede dejar esta ventana abierta y cada vez que se realice un cambio en el codigo se recarga la aplicación con la combinación de tecla ` cmd+r ` (MacOSX) o ` ctrl+r ` (Windows/Linux).

Se recomienda el uso de dos terminales, en una se hace la ejecución del comando ` gulp development ` y en otra el comando ` npm start `


## Estructura de carpetas.

El proyecto se conforma por la siguiente estructura de carpetas:
```sh
.
├── app
|   ├── views
|   │   ├── components: Vista de componentes
|   │   ├── layouts: Capas o plantillas principales
|   │   └── menus: Menus de la aplicacion
|   └── webapp
|       ├── css
|       |   ├── fonts: Fuentes de hojas de estilo
|       |   ├── lib: Librerias de terceros en formato CSS
|       |   └── stylus: Codigo CSS
|       ├── js
|       |   └── lib: Dependendicas de Angular o liberias JavaScript
|       ├── json
|       |   ├── data: Almacena archivos de configuración y formularios
|       |   └── language: Almacena archivos de idiomas
|       └── ts
|           ├── app: Controladores y servicios de componentes
|           ├── configs: Configuración y rutas del proyecto
|           └── dt: Archivos DefinitelyTyped
├── jar: Almacena los archivos JAR que se ejecutaran por consola
└── public
    └── img: Imagenes de la aplicación

```

La carpeta public almacena el codigo final que es visible al usuario,

La carpeta **app** almacena el codigo fuente de la aplicación, dividido en 2 carpetas principales:
* **views:** Almacena las vistas en formato de plantillas **Pug**, dentro de esta carpeta se encuentra un archivo index.pug, la carpeta **layouts** almacena las plantillas principales de las vistas mientras que en la carpeta **components**, se almacena las vistas de los componentes utilizados en la aplicación organizados en subcarpetas con el nombre al que corresponden.
* **webapp:** Almacena el codigo TypeScript y CSS que se utiliza en la aplicación, carga los controladores de los componentes y configuración en la carpeta **ts**, la carpeta **js** almacena unicamente librerias de JavaScript utilizadas en la aplicación (Librerias de Angular), la carpeta **json** cuenta con dos carpetas data y language que almacena datos y idiomas.

Las demas carpetas generadas al cargar los entornos de desarrollo o producción no son versionadas, en el documento .gitignore se encuentra el listado de carpetas y archivos que no se hace uso.

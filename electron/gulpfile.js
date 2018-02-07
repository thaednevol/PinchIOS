/**
 * @description
 *
 *
 * @author Luis Felipe Zapata - lzapata@swat-it.co
 */

var gulp = require("gulp");
var pug = require("gulp-pug");
var gulpTypeScript = require("gulp-typescript");
var gulpTsmetrics = require('./node_modules/gulp-tsmetrics/index');
// var gulpTsmetrics = require("gulp-tsmetrics");
var gulpComplexity = require("gulp-complexity");
var clean = require("gulp-clean");
var rename = require("gulp-rename");
var concat = require("gulp-concat");
var uglifyJs = require("gulp-uglifyjs");
var stylus = require("gulp-stylus");
var json = require("gulp-json-minify");
var server = require("gulp-webserver");
var tsProject = gulpTypeScript.createProject("tsconfig.json");
var nib = require("nib");


gulp.task("default", () => {
  console.info("\n\n\n\n\n\n\n\n\n\n");
  console.error("Debe elegir entre estas tareas:");
  console.error("gulp development");
  console.error("gulp production");
  console.error("gulp server");
  console.info("\n\n\n\n\n\n\n\n\n\n");
});


/**
 * Limpia el contenido antiguo de la carpeta public
 */
gulp.task("removeOldFile", () => {
  return gulp.src([
      "./public/css/",
      "./public/json/",
      "./public/views/**/*.*",
      "./public/js/"
    ])
    .pipe(clean());
});

/**
 * Convierte los archivos pug en versiones HTML para la interpretación.
 */
gulp.task("pug", ["removeOldFile"], () => {
  return gulp.src("./app/views/**/*.pug")
    .pipe(pug())
    .pipe(gulp.dest("./public/views"));
});

/******************************************************************************
 **                                                                          **
 **                         ENTORNO DE DESARROLLO                            **
 **                                                                          **
 ******************************************************************************/

/**
 * Ejecuta el entorno de desarrollo activando la escucha de cambios para ejecutar
 * de nuevo los comandos.
 */
gulp.task("development", [
  "combine",
  "watch"
]);


/**
 * Copia los archivos .js, .css, fuentes y .map para el funcionamiento y depuración
 * de la aplicación.
 */
gulp.task("copy", ["typeScript"], () => {
  gulp.src("./app/webapp/css/fonts/**")
    .pipe(gulp.dest("./public/css/fonts"));
  gulp.src("./app/webapp/css/lib/**/*.css")
    .pipe(gulp.dest("./public/css/lib"));
  gulp.src("./app/webapp/js/lib/**/*.js")
    .pipe(gulp.dest("./public/js/lib"));
  gulp.src("./app/webapp/js/es-CO.js").pipe(gulp.dest("./public/js/lib/handsontable-pro/languages/"));
  gulp.src("./app/webapp/js/lib/jquery-ui/themes/cupertino/*.css").pipe(gulp.dest("./public/css/lib"));
  gulp.src("./app/webapp/js/lib/jquery-ui/themes/cupertino/images/**/*").pipe(gulp.dest("./public/css/lib/images/"));
  gulp.src("./app/webapp/js/lib/handsontable-pro/dist/*.css").pipe(gulp.dest("./public/css/lib"));
});

/*
 * Realiza la conversión del codigo typeScript a Js
 */
gulp.task("typeScript", ["json"], () => {
  return tsProject.src()
    .pipe(tsProject())
    .js.pipe(gulp.dest("./"));
});

/**
 * Mueve el contenido de la carpeta JSON a la carpeta public
 */
gulp.task("json", ["css"], () => {
  return gulp.src("./app/webapp/json/**/*.json")
    .pipe(json())
    .pipe(gulp.dest("./public/json/"));
});

/**
 * Compila el codigo del preprocesador stylus a css
 */
gulp.task("css", ["pug"], () => {
  return gulp.src("./app/webapp/css/stylus/main.styl")
    .pipe(stylus({
      use: nib(),
      compress: false,
      "include css": true
    }))
    .pipe(gulp.dest("./public/css"));
});

/**
 * Escucha cambios en los archivos para ejecutar de nuevo las tareas programadas.
 */
gulp.task("watch", () => {

  gulp.watch([
    "./app/webapp/json/language/*.json",
    "./app/webapp/css/**/*.styl",
    "./app/webapp/ts/**/*.ts",
    "./app/views/**/*.pug"
  ], ["combine"]);

});



gulp.task("combine", ["copy"], function() {
  // return gulp.src([
  //     "./app/webapp/js/lib/angular/angular.min.js",
  //     "./app/webapp/js/lib/angular-resource/angular-resource.min.js",
  //     "./app/webapp/js/lib/angular-ui-router/release/angular-ui-router.min.js",
  //     "./app/webapp/js/lib/ngstorage/ngStorage.min.js",
  //     "./app/webapp/js/lib/angular-translate/angular-translate.min.js",
  //     "./app/webapp/js/lib/angular-translate-loader-static-files/angular-translate-loader-static-files.min.js",
  //     "./public/js/main.js"
  //   ])
  //   .pipe(concat("main.min.js"))
  //   .pipe(gulp.dest("./public/js"));


  // .pipe(uglifyJs("main.js", {
  //   compress: true,
  //   mangle: false
  // }))
  // .pipe(rename({
  //   suffix: '.min'
  // }))
  // .pipe(gulp.dest("./public/js"));
});

namespace errror {
  'use strict';

  export interface IExceptionHandlerConfig {
    appErrorPrefix: string
  }
  export class ExceptionHandlerProvider {
    static $inject: Array<string> = [];
    constructor() { }
    config: IExceptionHandlerConfig = {
      appErrorPrefix: undefined
    }

    configure(appErrorPrefix: any) {
      this.config.appErrorPrefix = appErrorPrefix;
    }
    $get: () => { config: IExceptionHandlerConfig } = () => { return { config: this.config }; }
  }

  config.$inject = ['$provide'];
  function config($provide: ng.auto.IProvideService) {
    $provide.decorator('$exceptionHandler', extendExceptionHandler);
  }

  extendExceptionHandler.$inject = ['$delegate', 'exceptionHandler'];
  /**
   * Extend the $exceptionHandler service to also display a toast.
   * @param  {Object} $delegate
   * @param  {Object} exceptionHandler
   * @return {Function} the decorated $exceptionHandler service
   */
  function extendExceptionHandler($delegate: ng.IExceptionHandlerService,
    exceptionHandler: any) {
    return function(exception: any, cause: any) {
      //            var appErrorPrefix = '[Error] ';
      var appErrorPrefix = exceptionHandler.config.appErrorPrefix || '';
      var errorData = { exception: exception, cause: cause };
      exception.message = appErrorPrefix + exception.message;
      $delegate(exception, cause);
      /**
       * Could add the error to a service's collection,
       * add errors to $rootScope, log errors to remote web server,
       * or log locally. Or throw hard. It is entirely up to you.
       * throw exception;
       *
       * @example
       *     throw { message: 'error message we added' };
       */
      alert(exception.message+errorData);
    };
  }

  angular
    .module('PILA').provider('exceptionHandler', ExceptionHandlerProvider).config(config);
}

class Exception extends Error {

  constructor(public message: string) {
    super(message);
    this.name = 'Exception';
    this.message = message;
    this.stack = (new Error()).stack;
  }
  toString() {
    return this.name + ': ' + this.message;
  }
}

class ACHException extends Exception {}

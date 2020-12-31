const uuid = require('uuid').v4;

exports.Session = class {

  constructor(sessionName) {
    this.name = sessionName;
    this.id = uuid();
  }

}

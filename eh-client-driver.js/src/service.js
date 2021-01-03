const express = require('express');
const bodyParser = require('body-parser');
const Session = require('./session').Session;

exports.Service = class {

  constructor() {
    this.routes = express();
    this.sessions = [];

    this.routes.use(bodyParser.json());

    // get status
    this.routes.get('/status', (request, response) => {
      return response.json({status: 'ok'});
    });

    // create session
    this.routes.post('/session', (request, response) => {
      var session = new Session(request.body.name, this.sessions.length);
      this.sessions.push(session);
      return response.json({status: 'ok', session: session});
    });

    // get list pf active sessions
    this.routes.get('/sessions', (request, response) => {
      return response.json({status: 'ok', sessions: this.sessions});
    });

    // delete session
    this.routes.delete('/session/:sessionId', (request, response) => {
      delete this.sessions[request.params.sessionId];
      return response.json({status: "ok"});
    });

  }
}

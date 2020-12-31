const express = require('express');
const Session = require('./session').Session;

exports.Service = class {

  constructor() {
      this.routes = express();
      this.sessions = [];

      this.routes.get('/status', (request, response) => {
        console.log('hello');
        return response.json({status: 'ok'});
      });

      this.routes.post('/session', (request, response) => {
        console.log(request);
        var session = new Session(request.body.name);
        this.sessions.push(session);
        return response.json({status: 'ok', session: session});
      });

      this.routes.get('/sessions', (request, response) => {
        return response.json({status: 'ok', sessions: this.sessions});
      });

    }
}

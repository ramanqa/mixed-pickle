const WebSocket = require('ws');
const shell = require('shelljs');

const cukeWS = new WebSocket('ws://localhost:4001/js');

  cukeWS.on('message', message => {
    console.log("here");
    console.log(message);
    shell.exec('echo ' + message + ' >> message.log');
  });


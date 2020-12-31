const Service = require('./src/service').Service;
const server = require('http').createServer();

var service = new Service();
var port = 4001;
server.on('request', service.routes);

server.listen(port, () => {
  console.log('eh-client-driver.js server started at ' + port);
});

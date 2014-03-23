var vertx = require('vertx');

var server = vertx.createHttpServer();

server.requestHandler(function(req) {
    var file = req.path() === "/" ? 'index.html' : req.path();
    req.response.sendFile("./" + file);
})

vertx.createSockJSServer(server).bridge({prefix: "/eventbus"}, [{}], [{}]);

server.listen(8080);

var express = require('express')
var app = express()
var bodyParser = require('body-parser');
var port = process.env.port || 3000

app.use( bodyParser.urlencoded({ extended: true }) );
app.use( bodyParser.json() );

var routes = require('./route');
routes( app );

app.listen( port )
console.log( ' Calorie Management has been started on port: ' + port )

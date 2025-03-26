
var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

var R = parseFloat(lines.shift());

var pi = 3.14159;
var _valordoVolume = 4.0/3.0;

var volume = _valordoVolume*pi*(R * R *R);

console.log("VOLUME = " + volume.toFixed(3));
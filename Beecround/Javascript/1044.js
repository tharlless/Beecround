var input = require('fs').readFileSync('stdin', 'utf8');
var lines = input.trim().split('\n');

var  [A, B] =  input.split(' ').map(Number);

if (A % B === 0 || B % A === 0) {
    console.log('Sao Multiplos');
}   else {
   console.log('Nao sao Multiplos');
}

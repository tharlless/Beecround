var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

// Separando e convertendo os valores para número
var valores1 = lines[0].split(' ').map(Number);
var valores2 = lines[1].split(' ').map(Number);

var x1 = valores1[0];
var y1 = valores1[1];
var x2 = valores2[0];
var y2 = valores2[1];

// Calculando a distância corretamente
var distancia = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

// Exibindo a distância com 4 casas decimais
console.log(distancia.toFixed(4));

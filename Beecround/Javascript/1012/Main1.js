// Lê a entrada de valores em uma única linha
var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split(' '); // Divide os valores por espaços

// Converte os valores de entrada para números
var A = parseFloat(lines[0]);
var B = parseFloat(lines[1]);
var C = parseFloat(lines[2]);
var pi = 3.14159;

// Calcula as áreas
var ques_a = (A * C) / 2;
var ques_b = pi * (C * C);
var quest_c = ((B + A) * C) / 2;
var quest_d = (B * B);
var quest_e = (A * B);

// Exibe os resultados com 3 casas decimais
console.log("TRIANGULO: " + ques_a.toFixed(3));
console.log("CIRCULO: " + ques_b.toFixed(3));
console.log("TRAPEZIO: " + quest_c.toFixed(3));
console.log("QUADRADO: " + quest_d.toFixed(3));
console.log("RETANGULO: " + quest_e.toFixed(3));

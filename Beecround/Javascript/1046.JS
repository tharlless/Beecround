var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

var [inicio, fim] = input.split(' ').map(Number);

var duracao;

if (inicio < fim) {
duracao = fim - inicio;
} else if (inicio > fim){
duracao = (24 - inicio) + fim;
}
else {
duracao = 24;    
}

console.log (`O JOGO DUROU ${duracao} HORA(S)`);

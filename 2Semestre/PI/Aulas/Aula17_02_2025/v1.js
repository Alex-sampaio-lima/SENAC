import prompt from "prompt-sync";

const read = prompt();

const notas = [];
let qtdNotas = 0;
let soma = 0;
let media = 0;
let maiorNota = 0;
let menorNota = Number.MAX_VALUE;

console.log('Informe quantas notas serão apuradas: ');
qtdNotas = Number(read());

for (let i = 0; i < qtdNotas; i++) {
    console.log("Informe as notas:")
    notas[i] = Number(read());
    if (notas[i] > 5) {
        console.log(`Notas azuis: ${notas[i]}`);
    }
    soma += notas[i];

    if (notas[i] > maiorNota) {
        maiorNota = notas[i];
    } else if (notas[i] < menorNota) {
        menorNota = notas[i];
    }

}

media = soma / qtdNotas;

console.log(`A média das notas foi de: ${media}`);
console.log(`Maior nota foi de ${maiorNota} e menor foi de ${menorNota}`);
import prompt from "prompt-sync";

const read = prompt();


let soma = 0;
let maiorNota = 0;
let menorNota = Number.MAX_VALUE;
let media = 0;
let qtdNotas = 0;

console.log("Informe quantas notas serão apuradas: ");
qtdNotas = Number(read());

const nota = Array.from({ length: qtdNotas });

nota.forEach((item, i) => {
    console.log("Informe as notas: ");
    nota[i] = Number(read());

    if (nota[i] > 0 && nota[i] > maiorNota) {
        maiorNota = nota[i];
    }

    if (nota[i] < menorNota) {
        menorNota = nota[i];
    }

    soma += nota[i];
})


nota.forEach(item => item > 5 ? console.log(`Notas azuis: ${item}`) : 0)

media = soma / nota.length;

console.log(`A maior nota foi ${maiorNota}\nA menor nota foi ${menorNota}`);



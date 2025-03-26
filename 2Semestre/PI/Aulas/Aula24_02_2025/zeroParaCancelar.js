import prompt from 'prompt-sync';

const read = prompt();

let qtdNumeros = 0;
let achaIndice = 0;
let soma = 0;
// console.log("Digite a quantidade de números a ser digitados: ");
// qtdNumeros = Number(read());

// const numeros = Array.from({ length: qtdNumeros });

// const numeros = [3, 0, 4, 0];
// const numeros = [5, 4, 0, 0];
const numeros = [1, 3, 5, 4, 0, 0, 7, 0, 0, 6];
// const numeros = [1, 0, 5, 4, 0, 0, 4];
let resultado = [];
let i = 0;
let count = 0;

for (i; i < numeros.length; i++) {
    // console.log("Informe os números: ");
    // numeros[i] = Number(read());
    if (numeros[i] == 0) {
        count++;
        if (numeros[i + 1] != 0) {
            while (count != 0) {
                numeros.splice(i - count, 2);
                i -= count;
                count--;
            }
        }
    }

    if (numeros[i] != 0) {
        achaIndice = 0;
    }
}

for (const element of numeros) {
    soma += element;
}

console.log(soma);
// for (let j = 0; j < numeros.length; j++) {


// }
// for (let i = 0; i < numeros.length; i++) {
//     if (numeros[i] === 0) {
//         // Remove o último número adicionado ao resultado
//         resultado.pop();
//     } else {
//         // Adiciona o número ao resultado
//         resultado.push(numeros[i]);
//     }
// }



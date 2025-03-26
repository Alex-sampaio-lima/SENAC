let time1 = 0;
let time2 = 0;
let vetor = [1, 2, 3, 4];
let total = 0;
let primeiroMenor = Number.MAX_VALUE;
let primeiroMaior = 0;
let segundoMaior = 0;
let segundoMenor = 0;

for (let i = 0; i < vetor.length; i++) {
    if (vetor[i] <= primeiroMenor) {
        primeiroMenor = vetor[i];
    }
    if (vetor[i] >= primeiroMaior) {
        primeiroMaior = vetor[i];
    }
}

time1 = primeiroMaior + primeiroMenor;

for (let i = 0; i < vetor.length; i++) {
    if (vetor[i] == primeiroMaior) {
        vetor[i] = 0;
    }
    if (vetor[i] == primeiroMenor) {
        vetor[i] = 0;
    }
}

for (const element of vetor) {
    time2 += element;
}

total = time1 - time2;
console.log(total);
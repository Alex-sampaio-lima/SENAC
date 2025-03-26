import { escrever, ler } from "./funcoes.js";

let comecoCorrida = [];
let finalCorrida = [];
let qtdJogadores = 0;
let posJogadores = 0;
let avancoJogadores = 0;
let retrocessoJogador = 0;

escrever("Quantas pessoas irão jogar ?");
qtdJogadores = Number(ler());
console.log("");


debugger;

for (let i = 0; i < qtdJogadores; i++) {
    escrever(`Informe a posição inicial do jogador ${i + 1}`)
    comecoCorrida[i] = Number(ler());
}

console.log();

for (let j = 0; j < qtdJogadores; j++) {
    escrever(`Agora, informe a posição de chegada do jogador ${j + 1}`)
    finalCorrida[j] = Number(ler());
}

console.log("");
// debugger;
for (let i = 0; i < qtdJogadores; i++) {
    if (comecoCorrida[i] > finalCorrida[i]) {
        avancoJogadores = comecoCorrida[i] - finalCorrida[i];
        console.log(`O Jogador ${i + 1} chegou na posição ${finalCorrida[i]} e avançou ${avancoJogadores} posições`)
    } else if (comecoCorrida[i] == finalCorrida[i]) {
        console.log(`O jogador ${i + 1} manteve sua posição em ${finalCorrida[i]}`)
    } else {
        retrocessoJogador = finalCorrida[i] - comecoCorrida[i];
        console.log(`O Jogador ${i + 1} chegou na posição ${finalCorrida[i]} e perdeu ${retrocessoJogador} posições`)
    }
}
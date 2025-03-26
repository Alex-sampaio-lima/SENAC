import prompt from "prompt-sync";
import { escrever } from "./funcoes.js";

const read = prompt();

let comecoCorrida = [];
let finalCorrida = [];
let quantidade = 3;
let posJogadores = 0;
let nome;

escrever("Quantas pessoas irão jogar ?");
quantidade = Number(read());

console.log("");


for (let i = 0; i < quantidade; i++) {
    escrever(`Informe a posição inicial do jogador ${i + 1}`)
    comecoCorrida[i] = Number(read());
}



for (let j = 0; j < quantidade; j2++) {
    escrever(`Agora, informe a posição de chegada do jogador ${j + 1}`)
    finalCorrida[j] = Number(read());
}

console.log("");

for (let i = 0; i < quantidade; i++) {
    posJogadores = comecoCorrida[i] - finalCorrida[i];
    console.log("Posição Final", posJogadores)
}
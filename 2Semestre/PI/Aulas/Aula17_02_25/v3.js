import prompt from 'prompt-sync';
import { escrever, media } from './funcoes.js';

const read = prompt();
let qtdNotas = 0;

escrever("Informe quantas notas serão apuradas:");
qtdNotas = Number(read());

const notas = Array.from({ length: qtdNotas });

media(notas);
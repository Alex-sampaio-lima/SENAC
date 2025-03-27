// @ts-ignore
import prompt from "prompt-sync";
import { arrayDobro, avaliarSituacao, calculaNaturais, calcularDobro, calcularEntrada, calcularMedia, calcularNumero, calcularPrecoAcai, corResultante, desenharQuadrado, diaSemana, numerosOrdenados, vestibular, vetorRegressivo } from "./service";

const ler = prompt();

// Simples

// Ex1
// console.log('-- PROGRAMA DO DOBRO --');
// let n = Number(ler('Informe um número: '));;

// let dobro = calcularDobro(n);

// console.log(`O dobro de ${n} é ${dobro}`);

// // Ex2

// let n1: number = Number(ler('Informe o primeiro o número: '));
// let n2: number = Number(ler('Informe o segundo número: '));

// let soma = calcularNumero(n1, n2);

// console.log(`A soma de ${n1} + ${n2} é ${soma}`);


// // Ex3

// let nota1: number = Number(ler('Informe a primeiro nota: '));
// let nota2: number = Number(ler('Informe a segunda nota: '));
// let nota3: number = Number(ler('Informe a terceira nota: '));

// let media: number = calcularMedia(nota1, nota2, nota3);

// console.log(`A média é ${media.toFixed(1)}`);

// // Ex4 

// let qtdPequeno: number = Number(ler('Informe a quantidade de açais pequenos: '));
// let qtdMedio: number = Number(ler('Informe a quantidade de açais Médios: '));
// let qtdGrande: number = Number(ler('Informe a quantidade de açais Grandes: '));

// let total: number = calcularPrecoAcai(qtdPequeno, qtdMedio, qtdGrande,);

// console.log(`Total à pagar é ${total.toFixed(1)}`);


// Condição

// Ex1
// let dia = Number(ler('Informe o número do dia: '));
// console.log(diaSemana(dia));

// Ex2
// let entrada: string = ler('Informe o tipo de entrada (Meia ou Inteira) :').toLowerCase();

// let qtdEntrda: number = Number(ler('Informe a quantidade de ingressos: '));

// console.log(`O total a pagar é R$ ${(calcularEntrada(entrada, qtdEntrda)).toFixed(2)}`);

// Ex3
// let nota1 = Number(ler('Informe a primeira nota: '));
// let nota2 = Number(ler('Informe a segunda nota: '));
// let nota3 = Number(ler('Informe a terceira nota: '));

// let resultado = avaliarSituacao(nota1, nota2, nota3);

// console.log(`A média do aluno é ${resultado.media.toFixed(1)}\nSituação: ${resultado.situacao}`);


// Ex4

// let cor1: string = ler('Informe a primeira cor: ').toLowerCase();
// let cor2: string = ler('Informe a segunda cor: ').toLowerCase();

// console.log(`A combinação das cores é: ${corResultante(cor1, cor2)}`);

// Ex5

// let notaCandidato: number = Number(ler('Informe a nota do candidato: '));
// let notaDeCorte: number = Number(ler('Informe a nota de corte: '));
// let notaMin: number = Number(ler('Informe a nota Mínima: '));

// console.log(vestibular(notaCandidato, notaDeCorte, notaMin));


// Repetição

// Ex1 
// let numeroInicio: number = Number(ler('Informe o número de inicio: '));
// let numeroFim: number = Number(ler('Informe o número de fim: '));

// vetorRegressivo(numeroInicio, numeroFim);

// Ex2

// let numeroTab = ler('Informe o número que deseja saber a tabuada: ');
// let calculo: number = 0;

// for (let i = 1; i <= 10; i++) {
//     calculo = numeroTab * i;
//     console.log(`${numeroTab} x ${i} = ${calculo}`);
// }

// Ex4 

// let numeroNatural: number = Number(ler('Informe um número natural: '));

// let soma: number = calculaNaturais(numeroNatural);

// console.log(`A soma dos números de 1 á ${numeroNatural} é de ${soma}`);

// Ex5

// let numeroDoQuadrado: number = ler('Informe um número para formar um quadrado: ');

// desenharQuadrado(numeroDoQuadrado);

// Vetor

// Ex1

// let tamanhoDoArray: number = Number(ler('Informe a quantidade de números a serem armazendos: '));
// let vetor: number[] = new Array(tamanhoDoArray);

// for (let i = 0; i < vetor.length; i++) {
//     vetor[i] = Number(ler());
// }

// arrayDobro(vetor);

// Ex2

const tamanhoDoArray: number = Number(ler('Informe o tamanho do array: '));
const vetor: number[] = new Array(tamanhoDoArray);

console.log('\nOrganização dos elementos: ');
numerosOrdenados(vetor);






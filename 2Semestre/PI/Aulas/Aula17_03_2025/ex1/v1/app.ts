// @ts-ignore

import prompt from 'prompt-sync';

const ler = prompt();
// let dobro: number = 0;

// // Ex1
// let n = Number(ler('Informe um número: '));

// dobro = n * 2;

// console.log(`O dobro de ${n} é ${dobro}`);

// // Ex2

// let n1 = ler('Informe o primeiro o número: ');
// let n2 = ler('Informe o segundo número: ');

// let soma = n1 + n2;

// console.log(`A soma de ${n1} + ${n2} é ${soma}`);

// // Ex3

// let nota1: number = Number(ler('Informe a primeiro nota: '));
// let nota2: number = Number(ler('Informe a segunda nota: '));
// let nota3: number = Number(ler('Informe a terceira nota: '));

// let media: number = (nota1 + nota2 + nota3) / 3;

// console.log(`A média é ${media.toFixed(1)}`);

// // Ex4

// let qtdPequeno: number = Number(ler('Informe a quantidade de açais pequenos: '));
// let qtdMedio: number = Number(ler('Informe a quantidade de açais Médios: '));
// let qtdGrande: number = Number(ler('Informe a quantidade de açais Grandes: '));

// let precoP = 13.50;
// let precoM = 15.00;
// let precoG = 17.50;

// let total: number = (qtdPequeno * precoP + qtdMedio * precoM + qtdGrande * precoG);

// console.log(`Total à pagar é ${total.toFixed(1)}`);



// npx tsx ex1/v1/app.ts


// Condição

// Ex1

// let dia = Number(ler('Informe o número do dia: '));

// switch (dia) {
//     case 0:
//         console.log('Domingo');
//         break;
//     case 1:
//         console.log('Segunda-Feira');
//         break;
//     case 2:
//         console.log('Terça-Feira');
//         break;
//     case 3:
//         console.log('Quarta-Feira');
//         break;
//     case 4:
//         console.log('Quinta-Feira');
//         break;
//     case 5:
//         console.log('Sexta-Feira');
//         break;
//     case 6:
//         console.log('Sábado');
//         break;
//     default:
//         console.log('Dia da semana inválido');
//         break;
// }


// Ex2

// let precoEntrada: number = 28.50;

// let entrada: string = ler('Informe o tipo de entrada (Meia ou Inteira) : ');
// let qtdEntrda: number = Number(ler('Informe a quantidade de ingressos: '));
// let total: number = 0;

// if (entrada == 'meia' || 'Meia') {
//     total = (precoEntrada / 2) * qtdEntrda;
// }
// if (entrada == 'inteira' || 'Inteira') {
//     total = precoEntrada * qtdEntrda;
// }

// console.log(`O total a pagar é R$ ${total.toFixed(2)}`);


// Ex3

// let nota1 = Number(ler('Informe a primeira nota:'));
// let nota2 = Number(ler('Informe a segunda nota:'));
// let nota3 = Number(ler('Informe a terceira nota:'));
// let situacao: string = '';
// let media: number = (nota1 + nota2 + nota3) / 3;

// if (media >= 8) {
//     situacao = 'Aprovado com sucesso !';
// } else if (media >= 6 && media <= 8) {
//     situacao = 'Aprovado';
// } else if (media >= 3 && media <= 6) {
//     situacao = 'Recuperação';
// } else if (media < 3) {
//     situacao = 'Reprovado';
// } else {
//     situacao = 'Desistente';
// }

// console.log(`A média do aluno é ${media.toFixed(1)}\nSituação: ${situacao}`);



// Ex4

// let cor1: string = ler('Informe a primeira cor: ').toLowerCase();
// let cor2: string = ler('Informe a segunda cor: ').toLowerCase();
// let resultado: string = '';

// if ((cor1 == 'vermelho' && cor2 == 'azul') || (cor1 == 'azul' && cor2 == 'vermelho')) {
//     resultado = 'Roxo';
// } else if ((cor1 == 'amarelo' && cor2 == 'azul') || (cor2 == 'azul' && cor1 == 'amarelo')) {
//     resultado = 'Verde';
// } else if ((cor1 == 'amarelo' && cor2 == 'verde') || (cor2 == 'verde' && cor1 == 'amarelo')) {
//     resultado = 'azul'
// } else if (cor1 == cor2) {
//     resultado = cor1;
// } else {
//     resultado = 'Apenas cores primárias são aceitas';
// }


// console.log(`A combinação das cores é: ${resultado}`);

// Ex5

// let notaCandidato: number = Number(ler('Informe a nota do candidato: '));
// let notaDeCorte: number = Number(ler('Informe a nota de corte: '));
// let notaMin: number = Number(ler('Informe a nota Mínima: '));

// let situacao: string = '';

// if (notaCandidato >= notaMin && notaCandidato <= notaDeCorte) {
//     situacao = 'Candidato está na lista de espera...';
// } else if (notaCandidato >= notaMin) {
//     situacao = 'Candidato Aprovado!';
// } else {
//     situacao = 'Candidato não passou!';
// }

// console.log(situacao);


// Repetição

// Ex1 

// let numeroInicio: number = Number(ler('Informe o número de inicio: '));
// let numeroFim: number = Number(ler('Informe o número de fim: '));


// for (let i = numeroInicio; i >= numeroFim; i--) {
//     console.log(i);
// }


// Ex2


// let numeroTab = ler('Informe o número que deseja saber a tabuada: ');
// let calculo: number = 0;

// for (let i = 1; i <= 10; i++) {
//     calculo = numeroTab * i;
//     console.log(`${numeroTab} x ${i} = ${calculo}`);
// }


// Ex4

// let numeroNatural: number = Number(ler('Informe um número natural: '));
// let soma: number = 0;

// for (let i = 1; i <= numeroNatural; i++) {
//     soma += i;
// }

// console.log(`A soma dos números de 1 á ${numeroNatural} é de ${soma}`);


// Ex5

// let numeroDoQuadrado: number = ler('Informe um número para formar um quadrado: ');

// for (let i = 0; i < numeroDoQuadrado; i++) {

//     for (let j = 0; j < numeroDoQuadrado; j++) {
//         process.stdout.write("* ");
//     }
//     console.log();
// }

// Vetor

// Ex1


// let tamanhoDoArray: number = Number(ler('Informe a quantidade de números a serem armazendos: '));
// let vetor: number[] = new Array(tamanhoDoArray);

// for (let i = 0; i < vetor.length; i++) {
//     vetor[i] = Number(ler());
// }

// console.log("Array Inicial: ");
// vetor.forEach(item => {
//     process.stdout.write(`${item}` + " ");
// });
// console.log('\n');

// console.log("Array com Dobros: ")
// vetor.forEach(item => {
//     process.stdout.write(`${item * 2}` + " ");
// });


// Ex2



let tamanhoDoArray: number = Number(ler('Informe o tamanho do array: '));
let vetor: number[] = new Array(tamanhoDoArray);

console.log();

let verificaCrescente: boolean = true;
let verificaDecrescente: boolean = true;

for (let i = 0; i < vetor.length; i++) {
    vetor[i] = Number(ler('Informe os valores do array: '));
}

for (let i = 0; i < vetor.length - 1; i++) {
    let proximoIndice = vetor[i + 1];
    let valorMaisUm = vetor[i] + 1;
    let valorMenosUm = vetor[i] - 1;

    if (valorMaisUm != proximoIndice) {
        verificaCrescente = false;
    }

    if (valorMenosUm != proximoIndice) {
        verificaDecrescente = false;
    }
}

console.log('\nOrganização dos elementos: ');
if (verificaCrescente) {
    console.log('Ordem Crescente!\n')
} else if (verificaDecrescente) {
    console.log('Ordem Descrescente!\n')
} else {
    console.log('Desordenados!\n');
}






import readlineSync from "readline-sync";
import promptSync from 'prompt-sync';
import { Prompt } from "prompt-sync";

const read = promptSync();

type Disciplina = {
    nome: string,
    nota1: number,
    nota2: number,
    nota3: number
}


type NotasAluno = {
    nome: string,
    disciplinas: Disciplina[]
}


type Boletim = {
    disciplina: string,
    media: string,
    situacao: string
}

// Coleta nome do aluno
let notasAluno: NotasAluno = {
    nome: read('\nNome do Aluno: '),
    disciplinas: []
}


// Coleta disciplinas
let opcao = '';
while (opcao != 'n') {
    let disciplina: Disciplina = {
        nome: read('\n Nova Disciplina: '),
        nota1: Number(read('\nNota 1: ')),
        nota2: Number(read('\nNota 2: ')),
        nota3: Number(read('\nNota 3: '))
    }
    notasAluno.disciplinas.push(disciplina);
    console.log(disciplina);

    opcao = read('\nQuer informar outra disciplina ? (y/n)');
}

// calcula boletim para cada disciplina

let boletins = calcularBoletim(notasAluno);

// Apresenta Boletim

console.log("\n***BOLETIM***\n");

boletins.forEach(b => {
    console.log(``);
})



function calcularMedia(disciplina: Disciplina): number {
    return (disciplina.nota1 + disciplina.nota2 + disciplina.nota3) / 3;
}

function verificarSituacao(media: number): string {
    return media >= 6 ? 'Aprovado' : 'DP';
}


function calcularBoletim(notas: NotasAluno): Boletim[] {
    return notas.disciplinas.map(d => {
        let media = calcularMedia(d);
        
        let situacao = verificarSituacao(media);
        return {
            disciplina: d.nome,
            media: media,
            situacao: situacao
        }
    })
}







type soma = {
    nome1: string,
    nome2: string,
    idade1: number,
    idade2: number
}



function verificarIdade(sum: soma) {

    sum.idade1
}
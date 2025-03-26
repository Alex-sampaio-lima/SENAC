import { transform } from 'typescript';
import { Tarefa } from './models';

export class GerenciadorTarefas {

    tarefas: Tarefa[];

    constructor() {
        this.tarefas = [];
    };

    novaTarefa(codigo: string, descricao: string) {
        let novaTarefa: Tarefa = {
            codigo,
            descricao,
            concluida: false
        };
        this.tarefas.push(novaTarefa);
    };

    listarTarefas() {
        this.tarefas.forEach((tarefa, index) =>
            console.log(`${index + 1}. (${tarefa.concluida ? 'x' : ' '}) ${tarefa.codigo} - ${tarefa.descricao}`));
    };

    removerTarefas(codigo: string) {
        let verificaCodigo = false;
        this.tarefas.forEach((tarefa, index) => {
            if (tarefa.codigo === codigo) {
                this.tarefas.splice(index, 1);
                verificaCodigo = true;
            };
        });
        console.log(`${verificaCodigo ? 'Tarefa removida com sucesso!' : 'O código da sua tarefa não foi localizada, tente novamente!'}`);
    };

    alterarTarefa(codigo: string, descricao: string): void {
        this.tarefas.forEach((tarefa) => {
            if (tarefa.codigo === codigo) {
                tarefa.descricao = descricao;
            };
        });
    };


    concluirTarefa(posicao: number): void {
        this.tarefas.forEach((tarefa, index) => {
            let novoIndice = index + 1;
            if (posicao == novoIndice) {
                tarefa.concluida = true;
            }
        });
    };

};
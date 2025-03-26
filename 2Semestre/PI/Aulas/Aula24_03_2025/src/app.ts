import { GerenciadorTarefas } from './processos';
import { apresentarMenu, encerraPrograma, pedirNumero, pedirTexto } from './tela';

let gerenciador = new GerenciadorTarefas();

let opcao = apresentarMenu();
while (opcao != 0) {
    switch (opcao) {
        // nova tarefa
        case 1:
            let codigo = pedirTexto('Informe o código:').toLowerCase();
            let descricao = pedirTexto('Informe a tarefa:');
            gerenciador.novaTarefa(codigo, descricao);
            break;
        // listar
        case 2:
            gerenciador.listarTarefas();
            break;
        case 3:
            let codigoRemovedor = pedirTexto('Informe o código para remover a tarefa: ');
            gerenciador.removerTarefas(codigoRemovedor);
            // código para remover
            break;
        case 4:
            let codigoAlteracao = pedirTexto('Informe o código para realizar a alteração na descrição da tarefa: ');
            let novaDescricao = pedirTexto('Informe a nova descrição: ');
            gerenciador.alterarTarefa(codigoAlteracao, novaDescricao);
            // código para alterar
            break;
        case 5:
            let posicaoConcluir = pedirNumero('Informe o número da tarefa que você deseja marcar como concluída: ');
            gerenciador.concluirTarefa(posicaoConcluir);
            // código para marcar conluído
            break;
        case 0:
            encerraPrograma(opcao);
            // código para sair
            break;
        default:
            console.log("Opção inválida, tente novamente!");
            // código inválido
            break;
    };

    opcao = apresentarMenu();
};
encerraPrograma(opcao);
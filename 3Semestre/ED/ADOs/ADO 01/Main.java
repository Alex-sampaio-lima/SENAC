import java.util.Scanner;

public class Main {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int tamanhoVetorMaquina = 0;
        int opcao = 0;

        System.out.println("Informe quantas máquinas você irá adicionar antes de iniciar o programa !");
        tamanhoVetorMaquina = read.nextInt();
        VetorObjeto vetorMaquina = new VetorObjeto(tamanhoVetorMaquina);

        do {
            menuOpcoes();
            opcao = read.nextInt();
            read.nextLine();

            switch (opcao) {
                case 0:
                    System.out.println("Programa finalizado com sucesso !");
                    break;
                case 1:
                    System.out.println("Quantas máquinas deseja adicionar?");
                    int qtdMaquina = read.nextInt();
                    read.nextLine();

                    for (int i = 0; i < qtdMaquina; i++) {
                        System.out.printf("\nCadastro da Máquina %d\n", i + 1);

                        System.out.print("Número de Serial: ");
                        String numeroSerial = read.nextLine();

                        System.out.print("Patrimônio: ");
                        int patrimonio = read.nextInt();
                        read.nextLine();

                        System.out.print("Modelo: ");
                        String modelo = read.nextLine();

                        System.out.print("Ano: ");
                        int ano = read.nextInt();
                        read.nextLine();

                        System.out.print("Marca: ");
                        String marca = read.nextLine();

                        System.out.print("Data que a máquina entrou no estoque: ");
                        String entrada = read.nextLine();

                        System.out.print("Data que a máquina saiu do estoque: ");
                        String saida = read.nextLine();

                        Maquina maquinaCriada = new Maquina(numeroSerial, patrimonio, modelo, ano, marca, entrada,
                                saida);
                        vetorMaquina.adiciona(maquinaCriada);
                    }
                    break;
                case 2:
                    String exibeVetor = vetorMaquina.toString();
                    System.out.println(exibeVetor);
                    break;
                case 3:
                    System.out.println(vetorMaquina.toString());
                    System.out.println("Informe a posição da máquina que deseja remover (começa em 0): ");
                    int numeroRemove = read.nextInt();
                    read.nextLine();

                    vetorMaquina.remove(numeroRemove);
                    System.out.println("Máquina removida!");
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
            }
        } while ((opcao != 0));

        read.close();
    }

    public static void menuOpcoes() {
        System.out.println("\nEscolha a opção que deseja realizar: ");
        System.out.println("0 - Sair");
        System.out.println("1 - Adicionar Máquina(s)");
        System.out.println("2 - Visualizar Máquina(s)");
        System.out.println("3 - Remover Máquina");
    }
}

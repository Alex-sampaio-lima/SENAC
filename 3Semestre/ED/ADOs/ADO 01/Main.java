import java.util.Scanner;

public class Main {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int opcao = 0;
        int patrimonio = 0;
        String numeroSerial = "";
        String modelo = "";
        int ano = 0;
        String marca = "";
        String entrada = "";
        String saida = "";
        int capacidadeInicial = 100;

        VetorObjeto vetorMaquina = new VetorObjeto(capacidadeInicial);

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
                        numeroSerial = verificaString(numeroSerial);

                        System.out.print("Patrimônio: ");
                        patrimonio = verificaNumero(patrimonio);

                        System.out.print("Modelo: ");
                        modelo = verificaString(modelo);

                        System.out.print("Ano: ");
                        ano = verificaNumero(ano);

                        System.out.print("Marca: ");
                        marca = verificaString(marca);

                        System.out.print("Data que a máquina entrou no estoque: ");
                        entrada = verificaString(entrada);

                        System.out.print("Data que a máquina saiu do estoque: ");
                        saida = verificaString(saida);

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
    };

    public static void menuOpcoes() {
        System.out.println("\nEscolha a opção que deseja realizar: ");
        System.out.println("0 - Sair");
        System.out.println("1 - Adicionar Máquina(s)");
        System.out.println("2 - Visualizar Máquina(s)");
        System.out.println("3 - Remover Máquina");
    };

    public static int verificaNumero(int numero) {
        while (!read.hasNextInt()) {
            System.out.println("Número inválido ! Digite um número inteiro: ");
            read.next();
        }
        numero = read.nextInt();
        read.nextLine();
        return numero;
    };

    public static String verificaString(String entrada) {
        entrada = read.nextLine();

        while (entrada.trim().isEmpty()) {
            System.out.println("Entrada inválida! Digite novamente:");
            entrada = read.nextLine();
        }
        return entrada;
    };

};
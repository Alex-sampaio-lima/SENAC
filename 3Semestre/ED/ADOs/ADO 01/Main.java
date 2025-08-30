import java.util.Scanner;

public class Main {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        VetorObjeto vetorMaquina = new VetorObjeto(0);
        int opcao = 0;
        String numeroSerial = "";
        int patrimonio = 0;
        String modelo = "";
        int ano = 0;
        String marca = "";
        String entrada = "";
        String saida = "";

        int qtdMaquina = 0;

        // Maquina m1 = new Maquina(
        // "FSD5N22",
        // 150034,
        // "Latitude 3410",
        // 2015,
        // "DELL",
        // "20/10/25",
        // "31/12/25");

        do {
            exibeMenu();
            opcao = read.nextInt();
            read.nextLine();

            if (opcao == 0) {
                System.exit(0);
            } else if (opcao == 2) {
                System.out.println(vetorMaquina.toString());
                while (opcao != 0 && opcao != 1) {
                    exibeMenu();
                    opcao = read.nextInt();
                    read.nextLine();
                    System.out.println(vetorMaquina.toString());
                }
            }

            System.out.println("Escolha quantas máquinas você deseja adicionar: ");
            qtdMaquina = read.nextInt();
            read.nextLine();

            vetorMaquina = new VetorObjeto(qtdMaquina);

            for (int i = 0; i < qtdMaquina; i++) {
                System.out.printf("\n\nCadastro da Máquina %d\n\n", i + 1);

                System.out.print("Insira o número de Serial da máquina: ");
                numeroSerial = read.nextLine();
                System.out.print("Insira o patrimônio da máquina: ");
                patrimonio = read.nextInt();
                read.nextLine();
                System.out.print("Insira o modelo da máquina: ");
                modelo = read.nextLine();
                System.out.print("Insira o ano da máquina: ");
                ano = read.nextInt();
                read.nextLine();
                System.out.print("Insira a marca da máquina: ");
                marca = read.nextLine();
                System.out.print("Insira o data em que a máquina entrou no estoque: ");
                entrada = read.nextLine();
                System.out.print("Insira o data em que a máquina saiu do estoque: ");
                saida = read.nextLine();

                Maquina maquinaCriada = new Maquina(numeroSerial, patrimonio, modelo, ano,
                        marca, entrada, saida);

                vetorMaquina.adiciona(maquinaCriada);
            }

            if (opcao == 2) {
                vetorMaquina.toString();
            }

            System.out.println(vetorMaquina.tamanho());

        } while (opcao != 0);

        read.close();
    }

    public static void exibeMenu() {
        System.out.println("Escolha a opção que deseja realizar: ");
        System.out.println("0 - Sair");
        System.out.println("1 - Adicionar máquina(s)");
        System.out.println("2 - Visualizar máquinas");
    }
};
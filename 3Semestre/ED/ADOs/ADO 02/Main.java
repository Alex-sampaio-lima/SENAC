import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        Fila<Paciente> fila = new Fila<>(100);
        int opcao;

        do {
            System.out.println("\n--- Sistema de Atendimento ---");
            System.out.println("1. Solicitar senha Normal");
            System.out.println("2. Solicitar senha Prioridade");
            System.out.println("3. Listar todas as senhas");
            System.out.println("4. Espiar próximo");
            System.out.println("5. Chamar próximo");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = read.nextInt();
            read.nextLine();


            switch (opcao) {
                case 1:
                    System.out.println("Nome do Paciente: ");
                    String nomePNormal = read.nextLine();
                    System.out.println("Idade do Paciente: ");
                    int idadePNormal = read.nextInt();
                    read.nextLine();
                    fila.enfileira(new Paciente(nomePNormal, idadePNormal, false));
                    break;
                case 2:
                    System.out.println("Nome do Paciente: ");
                    String nomePPrioridade = read.nextLine();
                    System.out.println("Idade do Paciente");
                    int idadePPrioridade = read.nextInt();
                    read.nextLine();
                    fila.enfileira(new Paciente(nomePPrioridade, idadePPrioridade, true));
                    break;
                case 3:
                    System.out.println(fila.listar());
                    break;
                case 4:
                    Paciente espia = fila.espiar();
                    if (espia != null) {
                        System.out.println("Próximo " + espia);
                    } else {
                        System.out.println("Fila vazia !");
                    }
                case 5:
                    Paciente chamado = fila.chamarElemento();
                    if (chamado != null) {
                        System.out.println("Chamado " + chamado);
                    } else {
                        System.out.println("Fila vazia !");
                    }
                    break;
            }
        } while (opcao != 0);

        read.close();
    }
}
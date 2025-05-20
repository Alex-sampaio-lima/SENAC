
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        double m[][] = new double[12][12];
        String operacao = "";
        double soma = 0;
        int numeroLinha = 0;
        numeroLinha = read.nextInt();
        read.nextLine();
        operacao = read.nextLine();
        boolean verificaNumeroLinha = false;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = j;
//                m[i][j] = read.nextDouble();
            }
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (numeroLinha == i) {
                    soma += m[numeroLinha][j];
                    verificaNumeroLinha = true;
                }
            }
            if (verificaNumeroLinha) {
                break;
            }
        }

        if (operacao.equals("S")) {
            System.out.printf("%.1f\n", soma);
        } else if (operacao.equals("M")) {
            System.out.printf("%.1f\n", soma / m.length);
        }

    }
}
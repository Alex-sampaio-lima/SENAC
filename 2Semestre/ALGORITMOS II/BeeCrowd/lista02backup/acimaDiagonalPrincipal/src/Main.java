import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        double[][] m = new double[12][12];
        double soma = 0;
        int count = 0;
        String operacao = "";
        operacao = read.nextLine();

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = j;
//                m[i][j] = read.nextDouble();
            }
        }

        for (int linha = 0; linha < m.length; linha++) {
            for (int coluna = 0; coluna < m[linha].length; coluna++) {
                if (coluna > linha) {
                    System.out.print(coluna + " ");
                    soma += m[linha][coluna];
                    count++;
                }
            }
        }

        if (operacao.equals("S")) {
            System.out.printf("%.1f", soma);
        } else if (operacao.equals("M")) {
            System.out.printf("%.1f", soma / count);
        }

    }
}

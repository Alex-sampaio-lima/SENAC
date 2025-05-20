import java.util.Random;
import java.util.Scanner;

public class areaDireita {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Random rand = new Random();
        double[][] m = new double[12][12];
        double soma = 0;
        String operacao = "";
        double countMedia = 0;
        int numeroCondicao = 0;

        operacao = read.nextLine();

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                // m[i][j] = read.nextDouble();
                m[i][j] = j;
            }
        }

        for (int linha = 0; linha < m.length; linha++) {
            for (int coluna = 0; coluna < m[linha].length; coluna++) {
                numeroCondicao = m.length - 1 - linha;
                if (coluna > linha && coluna > numeroCondicao) {
                    System.out.print(m[linha][numeroCondicao]);
                    soma += m[linha][coluna];
                    countMedia++;
                }

            }
            System.out.println();
        }

        if (operacao.equals("S")) {
            System.out.printf("%.1f\n", soma);
        } else {
            System.out.printf("%.1f\\n", soma / countMedia);
        }

        read.close();
    }
}

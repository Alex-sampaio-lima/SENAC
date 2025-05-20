import java.util.Random;
import java.util.Scanner;

public class area {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Random rand = new Random();
        double[][] m = new double[12][12];
        int somador = 0;
        double soma = 0;

        for (int i = 0; i < m.length; i++) { // linha
            for (int j = 0; j < m[i].length; j++) { // coluna
                // m[i][j] = read.nextDouble();
                m[i][j] = 1;
                System.out.print(" " + m[i][j]);
            }
//            System.out.println();
        }
        read.close();

        int numero = 0;

        for (int linha = 0; linha < m.length; linha++) {
            for (int coluna = 0; coluna < m[linha].length - 1; coluna++) {
                if (coluna - linha >= coluna) {
                    System.out.print(m[linha][coluna]);
                }
            }
            System.out.println();
        }
    }
}

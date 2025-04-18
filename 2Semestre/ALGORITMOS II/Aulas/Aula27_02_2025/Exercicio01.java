import java.util.Random;
import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Quantidade de Linhas: ");
        int linhas = teclado.nextInt();
        System.out.print("Quantidade de Colunas: ");
        int colunas = teclado.nextInt();
        int[][] matriz = gerarMatriz(linhas, colunas);
        imprimirMatriz(matriz);
        teclado.close();
    }

    public static int[][] gerarMatriz(int linhas, int colunas) {
        Random r = new Random();
        int[][] m = new int[linhas][colunas];
        // percorre as linhas
        for (int linha = 0; linha < m.length; linha++) {
            // precorre as colunas
            for (int coluna = 0; coluna < m[linha].length; coluna++) {
                m[linha][coluna] = r.nextInt(101);
            }
        }
        return m;
    }

    public static void imprimirMatriz(int[][] m) {
        for (int linha = 0; linha < m.length; linha++) {
            for (int coluna = 0; coluna < m[linha].length; coluna++) {
                System.out.printf("%3d ", m[linha][coluna]);
            }
            System.out.println();
        }
    }
}

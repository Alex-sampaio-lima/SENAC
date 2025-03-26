import java.util.Random;
import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        System.out.print("Quantidade de linhas: ");
        int linha = read.nextInt();
        System.out.print("Quantidade de colunas: ");
        int coluna = read.nextInt();
        int[][] matriz = gerarMatriz(linha, coluna);
        System.out.println("Maior Valor: " + maiorValor(matriz));

        read.close();
    }

    public static int[][] gerarMatriz(int linhas, int colunas) {
        Random rand = new Random();
        int[][] matriz = new int[linhas][colunas];

        // Percorre as linhas
        for (int linha = 0; linha < matriz.length; linha++) {
            // Percorre as colunas
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                matriz[linha][coluna] = rand.nextInt(100);
            }
        }

        return matriz;
    }

    public static int maiorValor(int[][] matriz) {
        int maiorValor = matriz[0][0];
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                if (matriz[linha][coluna] >= maiorValor) {
                    maiorValor = matriz[linha][coluna];
                }
            }
        }

        return maiorValor;
    }
}
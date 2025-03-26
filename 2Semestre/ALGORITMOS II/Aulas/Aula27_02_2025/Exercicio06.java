public class Exercicio06 {
    public static void main(String[] args) {
        int[][] a = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 0, 4, 3 },
        };
        int[][] b = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 0, 4, 3 },
        };
        int[][] c = soma(a, b);
        imprimirMatriz(c);
    }

    public static int[][] soma(int[][] a, int[][] b) {
        int[][] c = new int[a.length][a[0].length];

        for (int linha = 0; linha < c.length; linha++) {
            for (int coluna = 0; coluna < c.length; coluna++) {
                c[linha][coluna] = a[linha][coluna] + b[linha][coluna];
            }
        }
        return c;
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
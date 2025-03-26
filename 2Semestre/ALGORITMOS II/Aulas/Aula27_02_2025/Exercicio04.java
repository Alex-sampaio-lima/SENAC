public class Exercicio04 {
    public static void main(String[] args) {
        int[][] m = {
                { 67, 34, 22, 28 },
                { 78, 7, 69, 36 },
                { 47, 77, 94, 3 },
                { 1, 9, 10, 16 },
        };

        int traco = calcularTraco(m);
        System.out.println(traco);

    }

    public static int calcularTraco(int[][] m) {
        int soma = 0;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (i == j) {
                    soma = soma + m[i][j];
                }
            }
        }

        return soma;
    }

    public static int calcularTraco1(int[][] m) {
        int soma = 0;

        for (int i = 0; i < m.length; i++) {
            soma = soma + m[i][i];
        }

        return soma;
    }
}
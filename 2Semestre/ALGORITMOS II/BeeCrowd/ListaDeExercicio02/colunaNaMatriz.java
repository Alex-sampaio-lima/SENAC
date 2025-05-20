import java.util.Scanner;

public class coluna {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        double[][] m = new double[12][12];
        double soma = 0;
        int numeroColuna = read.nextInt();
        read.nextLine();
        String operacao = read.nextLine();
        boolean verificaNumeroColuna = false;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
//                m[i][j] = read.nextDouble();
                m[i][j] = j;
            }
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (numeroColuna == j) {
                    soma += m[i][numeroColuna];
                }
            }

        }

        if (operacao.equals("S")) {
            System.out.printf("%.1f\n", soma);
        } else if (operacao.equals("M")) {
            System.out.printf("%.1f\n", soma / m.length);
        }


    }
}

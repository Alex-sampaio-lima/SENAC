import java.util.Scanner;

public class MenorEPosicao {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        int n = 0;
        int menorValor = Integer.MAX_VALUE;
        int posicao = 0;

        n = read.nextInt();

        int x[] = new int[n];

        for (int i = 0; i < x.length; i++) {
            x[i] = read.nextInt();
        }

        for (int i = 0; i < x.length; i++) {
            if (x[i] < menorValor) {
                menorValor = x[i];
                posicao = i;
            }
        }

        System.out.printf("Menor valor: %d\nPosicao: %d\n", menorValor, posicao);
        read.close();
    }
}
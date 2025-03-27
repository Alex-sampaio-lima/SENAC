import java.util.Arrays;
import java.util.Random;

public class ExemploBubbleSort {

    public static void main(String[] args) {
        int[] v = gerarVetor(20);
        bubbleSort(v);
        System.out.println(Arrays.toString(v));
    }

    public static boolean ehPar(int n) {
        return n % 2 == 0;
    }

    public static void bubbleSort(int[] v) {
        int aux;
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = 0; j < v.length - 1 - i; j++) {
                if (!ehPar(v[j]) && ehPar(v[j+1])) {
                    troca(v, j, j+1);
                }
            }
        }
    }

    public static void troca(int[] v, int a, int b) {
        int aux = v[a];
        v[a] = v[b];
        v[b] = aux;
    }

    public static int[] gerarVetor(int n) {
        Random r = new Random();
        int[] vetor = new int[n];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = r.nextInt(1000);
        }
        return vetor;
    }
}



import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int v[] = { 5, 6, 2, 7, 9, 1, 8, 3, 7 };
        // pegaMaior(v);
        int posicao = particaoVetor(v);
        System.out.println(Arrays.toString(v));
    }

    public static int particaoVetor(int[] v) {
        int pivo = v[0];
        int i = 1;
        int j = v.length - 1;
        int aux = 0;

        while (i <= j) {
            if (v[i] <= pivo)
                i++;
            else if (v[j] > pivo)
                j--;
            else {
                aux = v[i];
                v[i] = v[j];
                v[j] = aux;
                i++;
                j--;
            }
        }
        v[0] = v[j];
        v[j] = pivo;
        return j;
    }

    public static void pegaMaior(int v[]) {
        int aux = 0;
        int i = 1;
        int primeiroElemento = v[0];
        System.out.println(primeiroElemento);

        while (primeiroElemento <= v[i]) {
            aux = primeiroElemento;
            v[i] = primeiroElemento;

            i++;
        }

    };
};
import java.util.Arrays;

public class buscaBinaria {
    public static void main(String[] args) {
        int[] numeros = { 4, 27, 53, 64, 23 };

        Arrays.sort(numeros);
        buscaBinariaFn(numeros, 64);

    }

    public static int buscaBinariaFn(int[] vetor, int valorASerAchado) {
        int ini = 0;
        int fim = vetor.length - 1;
        int meio;
        while (ini <= fim) {
            meio = (ini + fim) / 2;
            if (vetor[meio] == valorASerAchado) {
                return meio;
            }
            if (valorASerAchado < vetor[meio]) {
                fim = meio - 1;
            } else {
                ini = meio + 1;
            }
        }
        return -1;
    };
};

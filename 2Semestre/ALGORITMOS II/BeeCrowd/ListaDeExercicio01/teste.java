import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int[] a = new int[5]; // Vetor para números pares
        int[] b = new int[5]; // Vetor para números ímpares
        int[] teste = new int[15]; // Vetor de entrada

        int countPar = 0;
        int countImpar = 0;
        int countTeste = 0;

        // Preencher o vetor 'teste' com entrada do usuário
        for (int i = 0; i < teste.length; i++) {
            teste[i] = read.nextInt();
        }

        // Loop principal percorrendo todos os números do vetor 'teste'
        while (countTeste < teste.length) {

            if (teste[countTeste] % 2 == 0) {
                a[countPar] = teste[countTeste];
                countPar++;
            } else {
                b[countImpar] = teste[countTeste];
                countImpar++;
            }

            countTeste++;

            // Se o vetor de pares estiver cheio, imprime e reseta
            if (countPar == 5) {
                for (int k = 0; k < 5; k++) {
                    System.out.printf("par[%d] = %d\n", k, a[k]);
                }
                countPar = 0;
            }

            // Se o vetor de ímpares estiver cheio, imprime e reseta
            if (countImpar == 5) {
                for (int j = 0; j < 5; j++) {
                    System.out.printf("ímpar[%d] = %d\n", j, b[j]);
                }
                countImpar = 0;
            }
        }

        // Imprime os elementos restantes que não foram impressos anteriormente
        for (int i = 0; i < countImpar; i++) {
            System.out.printf("ímpar[%d] = %d\n", i, b[i]);
        }

        for (int i = 0; i < countPar; i++) {
            System.out.printf("par[%d] = %d\n", i, a[i]);
        }

        read.close();
    }
}

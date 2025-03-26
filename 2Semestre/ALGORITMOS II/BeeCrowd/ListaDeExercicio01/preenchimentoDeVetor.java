import java.util.Scanner;

public class preenchimentoDeVetor {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int[] a = new int[5];
        int[] b = new int[5];
        int countPar = 0;
        int countImpar = 0;
        int countVetor = 0;
        int[] vetor = new int[15];

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Informe os números do vetor:");
            vetor[i] = read.nextInt();  
        }  

        while (countVetor < vetor.length) {

            if (vetor[countVetor] % 2 == 0) {
                a[countPar] = vetor[countVetor];
                countPar++;
            } else {
                b[countImpar] = vetor[countVetor];
                countImpar++;
            }
            countVetor++;

            if (countPar == 5) {
                countPar = 0;
                for (int k = 0; k < a.length; k++) {
                    System.out.printf("par[%d] = %d\n", k, a[k]);
                    a[k] = 0;
                }
            }

            if (countImpar == 5) {
                countImpar = 0;
                for (int j = 0; j < b.length; j++) {
                    System.out.printf("impar[%d] = %d\n", j, b[j]);
                    b[j] = 0;
                }
            }
        }

        for (int i = 0; i < b.length; i++) {
            if (b[i] != 0) {
                System.out.printf("impar[%d] = %d\n", i, b[i]);
            }
        }

        for (int j = 0; j < a.length; j++) {
            if (a[j] != 0) {
                System.out.printf("par[%d] = %d\n", j, a[j]);
            }
        }

        read.close();
    }

}
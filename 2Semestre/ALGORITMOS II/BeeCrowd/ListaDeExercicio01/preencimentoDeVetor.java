import java.util.Scanner;

public class preencimentoDeVetor {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        int numeros[] = new int[10];
        int resultado = 0;

        numeros[0] = read.nextInt();

        for (int i = 0; i < numeros.length - 1; i++) {
            resultado = numeros[i] * 2;
            numeros[i + 1] = resultado;
        }

        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("N[%d] = %d\n", i, numeros[i]);
        }

        read.close();

    }

}
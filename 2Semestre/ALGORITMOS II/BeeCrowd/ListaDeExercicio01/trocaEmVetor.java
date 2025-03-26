import java.util.Scanner;

public class trocaEmVetor {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        int n[] = new int[20];
        int aux = 0;

        for (int i = 0; i < n.length; i++) {
            n[i] = read.nextInt();
        }

        for (int j = 0; j < n.length / 2; j++) {
            aux = n[j];
            n[j] = n[n.length - j - 1];
            n[n.length - j - 1] = aux;
        }

        for (int k = 0; k < n.length; k++) {
            System.out.printf("N[%d] = %d\n", k, n[k]);
        }

        read.close();
    }
}

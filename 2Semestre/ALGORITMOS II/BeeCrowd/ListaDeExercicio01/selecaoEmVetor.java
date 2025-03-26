import java.util.Scanner;

public class selecaoEmVetor {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        double[] a = new double[4];

        for (int i = 0; i < a.length; i++) {
            a[i] = read.nextDouble();
        }

        int j = 0;
        for (double item : a) {
            if (item <= 10) {
                System.out.printf("A[%d] = %.1f\n", j, a[j]);
            }
            j++;
        }
        read.close();
    }
}

import java.util.Scanner;

public class substituicaoEmVetor {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int[] x = new int[10];

        for (int i = 0; i < x.length; i++) {
            x[i] = read.nextInt();
            if (x[i] <= 0) {
                x[i] = 1;
            }
        }

        for (int i = 0; i < x.length; i++) {
            System.out.printf("X[%d] = %d\n", i, x[i]);
        }
        read.close();
    }

}

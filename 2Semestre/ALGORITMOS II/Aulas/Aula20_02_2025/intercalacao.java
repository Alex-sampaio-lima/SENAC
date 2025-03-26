import java.util.*;

public class intercalacao {
    public static void main(String[] args) {
        int a[] = { 1, 3, 9, 6, 12, 13, 7 };
        int b[] = { 2, 11, 4, 5, 8, 10, 20 };
        int c[] = new int[a.length + b.length];

        int referencia = 1;
        int count = 0;

        while (c[c.length - 1] == 0) {

            System.out.println(c.length - 1);

            for (int item : a) {
                if (item == referencia) {
                    c[count] = item;
                    count++;
                    referencia++;
                    break;
                }
            }

            for (int item : b) {
                if (item == referencia) {
                    c[count] = item;
                    count++;
                    referencia++;
                    break;
                }
            }

        }

        // for (int i = 0; i < a.length; i++) {
        // for (int j = 0; j < b.length; j++) {
        // if (a[i] == referencia) {
        // c[i] = referencia;
        // referencia++;
        // count++;
        // break;
        // } else if (b[j] == referencia) {
        // c[i] = referencia;
        // referencia++;
        // count++;
        // break;
        // }
        // }
        // }

        System.out.println(Arrays.toString(c));
    }
}
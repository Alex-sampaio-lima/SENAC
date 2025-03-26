import java.util.Arrays;

public class middleWay {

    public static void main(String[] args) {
        // int[] a = { 1, 2, 3 };
        // int[] b = { 4, 5, 6 };
        int[] a = { 7, 7, 7 };
        int[] b = { 3, 8, 0 };

        int[] resultado = new int[2];
        int countResultado = 0;
        for (int i = 0; i < a.length; i++) {
            // if (a[i] > a[0] && a[i] < a[a.length - 1]) {
            // resultado[countResultado] = a[i];
            // countResultado++;
            // }

            // if (i == 1) {
            // resultado[countResultado] = a[i];
            // countResultado++;
            // }

            if (i > 0 && i < 2) {
                resultado[countResultado] = a[i];
                countResultado++;
            }

        }

        for (int j = 0; j < b.length; j++) {
            // if (b[i] > b[0] && b[i] < b[b.length - 1]) {
            // resultado[countResultado] = b[i];
            // countResultado++;
            // }
            // if (j == 1) {
            // resultado[countResultado] = b[j];
            // countResultado++;
            // }
            if (j > 0 && j < 2) {
                resultado[countResultado] = b[j];
                countResultado++;
            }
        }

        // return resultado;
        System.out.println(Arrays.toString(resultado));

    }
}

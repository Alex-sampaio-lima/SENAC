
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] v = { 3, 5, 9, 11, 15, 17, 19, 6 };

        ordenarUltimoElemento(v);
        System.out.println(Arrays.toString(v));
    }

    // public static void selectionSort(int[] v) {
    // int min;
    // int aux;
    // for (int i = 0; i < v.length; i++) {
    // min = i;
    // for (int j = 0; j < v.length; j++) {
    // if (v[j] < v[min]) {
    // min = j;
    // }
    // }
    // if (i != min) {
    // aux = v[i];
    // v[i] = v[min];
    // v[min] = aux;
    // }
    // }
    // }

    public static void ordenarUltimoElemento(int[] v) {
        System.out.println(Arrays.toString(v));

        int x = v[v.length - 1];
        int j = v.length - 1;
        while (j > 0 && x < v[j - 1]) {
            v[j] = v[j - 1];
            j--;
        }
        v[j] = x;

        // for (int i = 0; i < v.length - 1; i++) {
        // System.out.println(v[i]);
        // System.out.println(v[i + 1]);
        // if (v[i] < v[v.length - 1] && v[i + 1] > v[v.length - 1]) {
        // aux = v[i];
        // v[i] = v[v.length - 1];
        // v[v.length - 1] = aux;
        // }
        // }
    }
}
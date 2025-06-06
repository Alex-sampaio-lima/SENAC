import java.util.*;

public class selectionSort {
    public static void main(String[] args) {
        int[] vetor = { 10, 12, 5, 2, 20 };
        selectoinSortFunction(vetor);

    };

    public static void selectoinSortFunction(int[] v) {
        int min;
        int aux;
        for (int i = 0; i < v.length; i++) {
            min = i;
            for (int j = min + 1; j < v.length; j++) {
                if (v[j] < v[min]) {
                    min = j;
                }
            }
            if (i != min) {
                aux = v[i];
                v[i] = v[min];
                v[min] = aux;
            }
        }
    };

    public static int indiceMenorElemento(int[] v) {
        int min = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] < v[min]) {
                min = i;
            }
        }
        return min;
    };

    
};
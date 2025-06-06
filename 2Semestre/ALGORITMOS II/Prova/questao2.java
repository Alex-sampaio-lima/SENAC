
import java.util.Arrays;

public class questao2 {
    public static void main(String[] args) {
        int[] vetor = { 78, 12, 35, 1, 17, 4, 43, 11, 17, 1 };
        insertionSort(vetor);
    }

    public static void insertionSort(int[] v) {

        for (int i = 1; i < v.length; i++) {
            int j = i;
            int x = v[j];
            while (j > 0 && x < v[j - 1]) {
                v[j] = v[j - 1];
                j--;
            }
            v[j] = x;
            apresentaVetor(v);
        }
    };

    public static void apresentaVetor(int[] vetor) {
        System.out.println(Arrays.toString(vetor));
    }
};

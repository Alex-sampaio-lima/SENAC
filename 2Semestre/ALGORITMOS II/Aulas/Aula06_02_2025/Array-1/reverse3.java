import java.util.Arrays;

public class reverse3 {
    public static void main(String[] args) {
        // int[] a = { 1, 2, 3 };
        int[] a = { 5, 11, 9 };
        // int[] a = { 7, 0, 0 };

        int troca = a[0];

        a[0] = a[a.length - 1];
        a[a.length - 1] = troca;

        // return a;

        System.out.println(Arrays.toString(a));
    }
}
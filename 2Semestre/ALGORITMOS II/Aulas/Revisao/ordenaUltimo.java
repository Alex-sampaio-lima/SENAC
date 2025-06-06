public class ordenaUltimo {
    public static void main(String[] args) {
        int[] v = { 3, 5, 9, 11, 15, 17, 19, 2 };
        ordenaUltimo(v);

    }

    public static void ordenaUltimo(int[] v) {
        int x = v[v.length - 1];
        int j = v.length - 1;
        while (j > 0 && x < v[j - 1]) {
            v[j] = v[j - 1];
            j--;
        }
        v[j] = x;
    };
};

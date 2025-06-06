public class fibonacci {
    public static void main(String[] args) {
        int n = 30;
        for (int i = 0; i <= n; i++) {
            long f = fibonacciFn(i);
        }
    }

    public static long fibonacciFn(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacciFn(n - 1) + fibonacciFn(n - 2);
    }
}

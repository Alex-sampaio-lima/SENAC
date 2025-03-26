public class commonEnd {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        int[] b = { 7, 3 };

        boolean verifca = false;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[0] == b[0] || a[a.length - 1] == b[b.length - 1]) {
                    verifca = true;
                }
            }
        }

        // return verifca;
        System.out.print(verifca);

    }
}
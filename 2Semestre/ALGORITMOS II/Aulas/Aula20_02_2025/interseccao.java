public class interseccao  {
    public static void main(String[] args) {
        int[] a = { 7, 2, 5, 8, 4 };
        int[] b = { 4, 2, 9, 5 };
        String resposta = intersceccao(a, b);
        System.out.println(resposta);
    }

    public static String intersceccao(int[] a, int[] b) {
        String c = "";
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    c = c + a[i] + " ";
                    break;
                }
            }
        }

        return c;
    }
}

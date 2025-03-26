public class diferenca {
    public static void main(String[] args) {
        int[] a = { 7, 2, 5, 8, 4 };
        int[] b = { 4, 2, 9, 5 };
        String resultado = "";
        resultado = diferencaMetodo(a, b);
        System.out.println(resultado);

    }

    public static String diferencaMetodo(int[] a, int[] b) {
        String c = "";
        for (int i = 0; i < a.length; i++) {
            Boolean verifica = false;
            for (int j = 0; j < b.length; j++) {

                if (a[i] == b[j]) {
                    verifica = true;
                    break;
                }
        
            }
            if (!verifica) {
                c = c + a[i] + " ";
            }

        }
        return c;
    }
}

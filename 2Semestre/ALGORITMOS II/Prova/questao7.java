public class questao7 {
    public static void main(String[] args) {
        // int[] a = { 7, 2, 5, 8, 4 };
        // int[] b = { 4, 2, 9, 5 };

        int[] a = { 3, 9, 11 };
        int[] b = { 2, 6, 1 };
        
        String resultado = "";

        for (int item : a) {
            resultado += item + " ";
        }

        for (int i = 0; i < b.length; i++) {
            boolean verifica = false;
            for (int j = 0; j < a.length; j++) {
                if (b[i] == a[j]) {
                    verifica = true;
                    break;
                }
            }
            if (!verifica) {
                resultado = resultado + b[i] + " ";
            }
        }

        System.out.println(resultado);
    };
};
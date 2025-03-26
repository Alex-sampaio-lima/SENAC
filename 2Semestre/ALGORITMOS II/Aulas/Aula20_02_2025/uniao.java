public class uniao {
    public static void main(String[] args) {

        int[] a = { 7, 2, 5, 8, 4 };
        int[] b = { 4, 2, 9, 5, 66, 445, 34 };
        String resultado = "";
        // Eu só posso unir eles quando os elementos de B não estiverem no A

        // Concatenar os valores do array a em uma String
        for (int item : a) {
            resultado += item + " ";
        }

        for (int i = 0; i < b.length; i++) {
            Boolean verifica = false;
            for (int j = 0; j < a.length; j++) {
                // Verificar se o número que está em B não existe em A
                if (b[i] == a[j]) {
                    verifica = true;
                }
            }

            if (!verifica) {
                resultado = resultado + b[i] + " ";
            }
            // Após isso adicionar ele a String resultado
        }

        System.out.println(resultado);
    }
}
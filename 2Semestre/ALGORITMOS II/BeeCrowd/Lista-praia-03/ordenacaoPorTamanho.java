import java.util.*;

public class ordenacaoPorTamanho {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int casoTeste = 0;
        casoTeste = read.nextInt();
        String[] palavras = new String[casoTeste];
        read.nextLine();
        String linha = "";

        for (int i = 0; i < casoTeste; i++) {
            linha = read.nextLine();
            palavras = linha.split(" ");
            ordernar(palavras);
            imprimir(palavras);
        }
        read.close();
    };

    public static void ordernar(String[] palavras) {
        String palavraAtual = "";
        for (int i = 0; i < palavras.length; i++) {
            int j = i - 1;
            palavraAtual = palavras[i];

            while (j >= 0 && palavras[j].length() < palavraAtual.length()) {
                palavras[j + 1] = palavras[j];
                j--;
            }
            palavras[j + 1] = palavraAtual;
        }

    }

    public static void imprimir(String[] palavras) {
        for (int i = 0; i < palavras.length; i++) {
            System.out.print(palavras[i]);
            if (i < palavras.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
};
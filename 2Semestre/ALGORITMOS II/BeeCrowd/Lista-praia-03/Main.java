import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < casos; i++) {
            String linha = sc.nextLine();
            String[] palavras = dividirPalavras(linha);
            ordenarPorTamanho(palavras);
            imprimir(palavras);
        }
    }

    // Função para dividir a linha em palavras (sem usar split)
    public static String[] dividirPalavras(String linha) {
        // Conta quantas palavras há
        int count = 1;
        for (int i = 0; i < linha.length(); i++) {
            if (linha.charAt(i) == ' ') {
                count++;
            }
        }

        String[] palavras = new String[count];
        int idx = 0;
        StringBuilder palavra = new StringBuilder();

        for (int i = 0; i < linha.length(); i++) {
            char c = linha.charAt(i);
            if (c != ' ') {
                palavra.append(c);
            } else {
                palavras[idx++] = palavra.toString();
                palavra = new StringBuilder();
            }
        }
        palavras[idx] = palavra.toString(); // última palavra
        return palavras;
    }

    // Ordenação estável por tamanho (Insertion Sort)
    public static void ordenarPorTamanho(String[] palavras) {
        for (int i = 1; i < palavras.length; i++) {
            String atual = palavras[i];
            int j = i - 1;

            // Compara o tamanho
            while (j >= 0 && palavras[j].length() < atual.length()) {
                palavras[j + 1] = palavras[j]; // move pra frente
                j--;
            }

            palavras[j + 1] = atual;
        }
    }

    // Imprimir palavras com espaço entre elas
    public static void imprimir(String[] palavras) {
        for (int i = 0; i < palavras.length; i++) {
            System.out.print(palavras[i]);
            if (i < palavras.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}

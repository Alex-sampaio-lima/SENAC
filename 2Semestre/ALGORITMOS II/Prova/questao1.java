public class questao1 {
    public static void main(String[] args) {
        int[] numeros = { 1, 2, 3, 4, 5 };
        calcularProduto(numeros, numeros.length);
    };

    public static int calcularProduto(int vetor[], int tamanho) {

        if (tamanho == 0) {
            return 1;
        }

        return vetor[tamanho - 1] + calcularProduto(vetor, tamanho - 1);

    }
};

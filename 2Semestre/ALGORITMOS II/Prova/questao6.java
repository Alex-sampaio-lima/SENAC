public class questao6 {
    public static void main(String[] args) {
        int[] vetor = { 4, 3, 2, 1, };
        bubbleSort(vetor);
    }

    public static void bubbleSort(int[] vetor) {
        int aux = 0;

        for (int i = 0; i < vetor.length - 1; i++) {
            boolean verifica = false;
            for (int j = 0; j < vetor.length - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                    verifica = true;
                }
            }
            if (!verifica) {
                break;
            }
        }
    }

}

import java.util.Arrays;

public class Vetor {

    private String[] vetor;
    private int tamanho;

    public Vetor(int capacidade) {
        vetor = new String[capacidade];
        this.tamanho = 0;
    }

    public void adiciona(String elemento) throws Exception {
        this.aumentaCapacidade();
        this.vetor[this.tamanho] = elemento;
        this.tamanho++;
    }

    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("[");

        for (int i = 0; i < this.tamanho - 1; i++) {
            s.append(this.vetor[i]);
            s.append(", ");
        }

        if (this.tamanho > 0) {
            s.append(this.vetor[this.tamanho - 1]);
        }

        s.append("]");

        return s.toString();
    }

    public String busca(int posicao) throws Exception {
        if (posicao >= 0 && posicao < this.tamanho) {
            return this.vetor[posicao];
        } else {
            throw new Exception("Posição Inválida !");
        }
    }

    public int buscaIndice(String elemento) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equalsIgnoreCase(elemento)) {
                return i;
            }
        }
        return -1;
        // return "ads";
    };

    public boolean adicionaInicio(int posicao, String elemento) throws Exception {
        this.aumentaCapacidade();
        if (posicao >= 0 && posicao < this.tamanho) {
            for (int i = this.tamanho - 1; i >= posicao; i--) {
                this.vetor[i + 1] = this.vetor[i];
            }
            this.vetor[posicao] = elemento;
            this.tamanho++;
        }
        return true;
    };

    public void aumentaCapacidade() {
        if (this.tamanho == this.vetor.length) {
            String[] vetorNovo = new String[this.vetor.length * 2];
            for (int i = 0; i < this.vetor.length; i++) {
                vetorNovo[i] = this.vetor[i];
            }
            this.vetor = vetorNovo;
        }
    }

    public void remove(int posicao) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            for (int i = posicao; i < this.tamanho - 1; i++) {
                this.vetor[i] = this.vetor[i + 1];
            }
            this.vetor[tamanho] = null;
            this.tamanho--;
        } else {
            throw new Exception("Posição inválada !");
        }

    };
};

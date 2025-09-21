public class VetorObjeto {
    public Object[] maquinas;
    public int tamanho;

    public VetorObjeto(int capacidade) {
        this.maquinas = new Object[capacidade];
        this.tamanho = 0;
    }

    public void adiciona(Object elemento) throws Exception {
        this.aumentaCapacidade();
        this.maquinas[this.tamanho] = elemento;
        this.tamanho++;
    };

    public int tamanho() {
        return this.tamanho;
    };

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < this.tamanho; i++) {
            if (this.maquinas[i] != null) { // só imprime se não for null
                sb.append(this.maquinas[i].toString()).append("\n");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public Object busca(int posicao) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            return this.maquinas[posicao];
        } else {
            throw new Exception("Posição inválida ! Tente inserir outra posição");
        }
    };

    private void aumentaCapacidade() {
        if (this.tamanho == this.maquinas.length) {
            Object[] maquinaNovas = new Object[this.maquinas.length * 2];
            for (int i = 0; i < this.maquinas.length; i++) {
                maquinaNovas[i] = this.maquinas[i];
            }
            this.maquinas = maquinaNovas;
        }
    };

    public void remove(int posicao) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            for (int i = posicao; i < this.tamanho - 1; i++) {
                this.maquinas[i] = this.maquinas[i + 1];
            }
            this.maquinas[tamanho] = null;
            this.tamanho--;
        } else {
            throw new Exception("Posição Inválida !");
        }
    };
};

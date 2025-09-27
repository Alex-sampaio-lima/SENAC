public class ListaEncadeadaDupla<Tipo> {

    private No inicio;
    private No fim;
    private No anterior;
    private int tamanho;

    // Método Construtor
    public ListaEncadeadaDupla() {
        this.tamanho = 0;
    }

    // Método de Acesso
    public No getInicio() {
        return inicio;
    }

    // procedimento preciso passar a informação
    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public No getFim() {
        return fim;
    }

    public void setFim(No fim) {
        this.fim = fim;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "ListaEncadeada{" + "Inicio=" + inicio + '}';
    }

    public void adiciona(Tipo elemento) {

        No<Tipo> celula = new No<Tipo>(elemento);
        if (this.inicio == null && this.fim == null) {
            this.inicio = celula;
            this.fim = celula;
        } else {
            celula.setAnterior(this.fim);
            this.fim.setProximo(celula);
            this.fim = celula;
        }
        this.tamanho++;

    };

    public No<String> get(int posicao) {
        No atual = this.inicio;

        if (posicao > this.tamanho) {
            No<String> erro = new No<String>("ERRO - não localizado");
            return erro;
        }

        for (int i = 0; i < posicao; i++) {
            if (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
        }
        return atual;
    }

    // remover um elemento no MEIO
    public void removerMeio(Tipo elemento) {
        No anterior = null;
        No atual = this.inicio;

        for (int i = 0; i < this.getTamanho(); i++) {
            if (atual.getElemento().equals(elemento)) {
                anterior.setProximo(atual.getProximo());
                atual = null;
                this.tamanho--;
                break;
            }

            anterior = atual;
            atual = atual.getProximo();

        }

    }

    // Remover elementos em todas as posições

    public void remover(Tipo elemento) {
        No anterior = null;
        No atual = this.inicio;

        for (int i = 0; i < getTamanho(); i++) {

            if (atual.getElemento().equals(elemento)) {
                if (this.tamanho == 1) {
                    this.inicio = null;
                    this.fim = null;
                } else if (atual == inicio) {
                    atual.getProximo().setAnterior(null);
                    this.inicio = atual.getProximo();
                    atual.setProximo(null);
                } else if (atual == fim) {
                    this.fim = anterior;
                    anterior.setProximo(null);
                } else {
                    anterior.setProximo(atual.getProximo());
                    atual.getProximo().setAnterior(anterior);
                }
                atual = null;
                this.tamanho--;
                break;
            }

            anterior = atual;
            atual = atual.getProximo();
        }

    }

    public int buscar(Tipo elemento) {
        No atual = this.inicio;
        for (int i = 0; i < this.getTamanho(); i++) {
            if (atual.getElemento().equals(elemento)) {
                return i;
            }
            atual = atual.getProximo();
        }
        return -1;
    }

}
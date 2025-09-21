public class EstruturaEstatica<T> {
    public T[] elementos;
    public int tamanho;

    // Método construtor com parâmetros
    public EstruturaEstatica(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    // Método construtor sem parâmetros
    public EstruturaEstatica() {
        this(10);
    }

    // Método para adicionar elementos na estrutura
    public boolean adiciona(T elemento) {
        this.aumentaCapacidade();
        this.elementos[this.tamanho] = elemento;
        this.tamanho++;
        return true;

    }

    // Método para adicionar elementos na estrutura em uma posição especifica
    public boolean adiciona(int posicao, T elemento) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        this.aumentaCapacidade();
        for (int i = this.tamanho - 1; i >= posicao; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.tamanho++;
        return true;
    }

    public void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    // Método para verificar a quantidade de dados dentro da Estrutura
    public int tamanho() {
        return this.tamanho;
    }


    // Método para exibir dados da Estrutura
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("[");
        for (int i = 0; i < this.tamanho - 1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }
        if (this.tamanho > 0) {
            s.append(this.elementos[this.tamanho - 1]);
        }

        s.append("]");

        return s.toString();
    }

    // Método para verificar se existe elementos na estrutura
    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    // Método para remover elementos da estrutura
    public void remove(int posicao) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        for (int i = 0; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        tamanho--;
    }
};
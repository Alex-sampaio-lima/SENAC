public class Fila<T> extends EstruturaEstatica<T> {

    private int contadorPrioridade;

    public Fila(int capacidade) {
        super(capacidade);
        this.contadorPrioridade = 0;
    }

    public void enfileira(T elemento) {
        this.adiciona(elemento);
    }

    public Paciente espiar() {
        if (this.estaVazia()) return null;
        return (Paciente) this.elementos[0];
    }

    public Paciente chamarElemento() {
        if (this.estaVazia()) return null;

        int indice = -1;

        if (contadorPrioridade < 3) {
            for (int i = 0; i < tamanho; i++) {
                Paciente p = (Paciente) elementos[i];
                if (p.isPrioridade()) {
                    indice = i;
                    contadorPrioridade++;
                    break;
                }
            }
        }

        if (indice == -1) {
            for (int i = 0; i < tamanho; i++) {
                Paciente p = (Paciente) elementos[i];
                if (!p.isPrioridade()) {
                    indice = i;
                    contadorPrioridade = 0;
                    break;
                }
            }
        }

        Paciente paciente = (Paciente) elementos[indice];

        for (int i = indice; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }

        elementos[--tamanho] = null;

        return paciente;
    }

    public String listar() {
        if (estaVazia()) return "Fila vazia!";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            sb.append((i + 1) + " - " + elementos[i] + "\n");
        }
        return sb.toString();
    }
}

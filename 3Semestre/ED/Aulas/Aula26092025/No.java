public class No<Tipo> {
    private Tipo elemento;
    private No proximo;
    private No anterior;

    // Um só com a informacao mas sem ponteiro
    public No(Tipo elemento) {
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }

    // E o outro com a informacao e o ponteiro
    public No(Tipo elemento, No proximo) {
        this.anterior = null;
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public Tipo getElemento() {
        return elemento;
    }

    public void setElemento(Tipo elemento) {
        this.elemento = elemento;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "No [Anterior " + anterior + "[elemento=" + elemento + ", proximo=" + proximo + "]";
    }

}
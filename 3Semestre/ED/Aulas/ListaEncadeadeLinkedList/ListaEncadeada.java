package ListaEncadeadeLinkedList;

import java.util.LinkedList;

public class ListaEncadeada<Tipo> {

    private LinkedList<Tipo> lista = new LinkedList<Tipo>();

    @Override
    public String toString() {
        return "ListaEncadeada [inicio=" + lista.getFirst() + ", fim=" + lista.getLast() + ", tamanho=" + lista.size()
                + "" + lista.toString() + "]";
    };

    public void adiciona(Tipo elemento) {
        lista.add(elemento);
    }

    public void remover(Tipo elemento) {
        lista.remove(elemento);
    }

    public Tipo get(int posicao) {
        if (posicao < 0 || posicao > lista.size()) {
            throw new IndexOutOfBoundsException("Erro - não localizado");
        }
        return lista.get(posicao);
    }

    public int buscar(Tipo elemento) {
        return lista.indexOf(elemento);
    }

};

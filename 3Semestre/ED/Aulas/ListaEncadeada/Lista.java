public class Lista {
    public static void main(String[] args) {
        ListaEncadeada<String> lista = new ListaEncadeada<>();
        // System.out.println("Tamanho da Lista = " + lista.getTamanho());

        // lista.adiciona("Claudio");

        // System.out.println(lista);
        // System.out.println("Tamanho da Lista = " + lista.getTamanho());
        // System.out.println("Inicio da lista = " + lista.getInicio().getElemento());
        // System.out.println("Fim da Lista = " + lista.getFim().getElemento());

        // lista.adiciona("Camila");

        // System.out.println(lista);
        // System.out.println("Tamanho da Lista = " + lista.getTamanho());
        // System.out.println("Inicio da lista = " + lista.getInicio().getElemento());
        // System.out.println("Fim da Lista = " + lista.getFim().getElemento());

        lista.adiciona("Claudio");
        lista.adiciona("Camila");
        lista.adiciona("Miguel");
        lista.adiciona("Elis");

        System.out.println("Tamanho da Lista = " + lista.getTamanho());
        System.out.println("Inicio da lista = " + lista.getInicio().getElemento());
        System.out.println("Fim da Lista = " + lista.getFim().getElemento());
        
        // System.out.println(lista);
        lista.remover("Claudio");

        System.out.println("Tamanho da Lista = " + lista.getTamanho());
        System.out.println("Inicio da lista = " + lista.getInicio().getElemento());
        System.out.println("Fim da Lista = " + lista.getFim().getElemento());

        // System.out.println("Elemento na posição 2 = " + lista.get(8).getElemento());

    };
};

public class Lista {
    public static void main(String[] args) {
        System.out.println("TESTE");
        ListaEncadeadaDupla<String> lista = new ListaEncadeadaDupla<>();

        lista.adiciona("Claudio");
        lista.adiciona("Camila");
        lista.adiciona("Elis");

        System.out.println("Tamanho da Lista = " + lista.getTamanho());
        lista.remover("Claudio");

    };
};

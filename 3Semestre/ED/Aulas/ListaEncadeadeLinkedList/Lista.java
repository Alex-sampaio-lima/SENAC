public class Lista {
    public static void main(String[] args) {
        ListaEncadeada<String> minhaListaDeNomes = new ListaEncadeada<>();
        minhaListaDeNomes.adiciona("Carlos");
        minhaListaDeNomes.adiciona("Pedro");

        minhaListaDeNomes.get(1);

        System.out.println("Lista de Nomes: " + minhaListaDeNomes.toString());

        minhaListaDeNomes.remover("Pedro");
        
        System.out.println("Lista de Nomes: " + minhaListaDeNomes.toString());

        minhaListaDeNomes.get(1);
        System.out.println(minhaListaDeNomes.toString());
    };
};

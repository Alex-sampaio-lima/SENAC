public class Main {
    public static void main(String[] args) throws Exception {
        Vetor vetor = new Vetor(5);

        vetor.adiciona("Alex");
        vetor.adiciona("Ana");
        vetor.adiciona("Beatriz");
        vetor.adiciona("Julia");
        vetor.adiciona("Carol");
        vetor.adiciona("Jose"); // Erro proposital

        System.out.println("Quantidade de informações no vetor: " + vetor.tamanho());

        System.out.println("Contéudo do vetor: " + vetor.toString());

        System.out.println("Informação Armazenada no vetor na posicão informada: " + vetor.busca(4));

        // System.out.println("Valor do indice: " + vetor.buscaIndice("Carol"));

        vetor.remove(2);
        System.out.println(vetor.busca(2));

        System.out.println(vetor.buscaIndice("Julia"));
        System.out.println(vetor.toString());
        
    };
};

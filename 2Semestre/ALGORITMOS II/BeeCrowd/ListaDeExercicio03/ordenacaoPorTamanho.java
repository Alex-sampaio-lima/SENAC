class ordenacaoPorTamanho {
    public static void main(String[] args) {
        Homem h = new Homem();
        h.idade = 30;
        h.tipo = "Gorila";
    }

    String tipo = "";
}

class Homem extends ordenacaoPorTamanho {
    int idade = 0;

}
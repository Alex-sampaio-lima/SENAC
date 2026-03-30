public class Pessoa {
    String nome;

    @Override
    public String toString() {
        return "Pessoa [nome = " + nome + "]";
    };

    public Pessoa(String nome) {
        this.nome = nome;
    };

    public Pessoa() {
        this.nome = "Sem registro";
    };

    public void setNome(String nome) {
        this.nome = nome;
    };

    public String getNome() {
        return this.nome;
    };

};

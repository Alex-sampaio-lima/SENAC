
public class Pessoa {
    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    };

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", idade=" + idade + "]";
    };

    public String getNome() {
        return nome;
    };

    public int getIdade() {
        return idade;
    };

    @Override
    public boolean equals(Object outraPessoa) {

        Pessoa op = (Pessoa) outraPessoa;
        // Ele força com que o outraPessoa seja do tipo Pessoa

        if (this.nome.equals(op.getNome()) && this.idade == op.getIdade()) {
            return true;
        } else {
            return false;
        }

    };

    @Override
    public int hashCode() {
        // int hash = 7;
        // hash = 29 * hash + Objects.hashCode(this.nome);
        // hash = 29 * hash + this.idade;
        // return hash;

        return this.nome.hashCode() + 61 * this.idade;
    };

};

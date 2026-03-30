public class PessoaFisica extends Pessoa {
    long cpf;

    @Override
    public String toString() {
        return "PessoaFisica [nome=" + nome + ", cpf=" + cpf + "]";
    };

    public PessoaFisica(String nome, long cpf) {
        super(nome);
        this.cpf = cpf;
    };

    public PessoaFisica() {
        this.cpf = 0;
    };

    public void setCpf(long cpf) {
        this.cpf = cpf;
    };

    public long getCpf() {
        return cpf;
    };

};

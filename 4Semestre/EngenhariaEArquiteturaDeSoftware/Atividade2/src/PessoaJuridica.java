public class PessoaJuridica extends Pessoa {
    private long cnpj;

    @Override
    public String toString() {
        return "PessoaJuridica [nome=" + getNome() + ", cnpj=" + cnpj + "]";
    };

    public PessoaJuridica(String nome, long cnpj) {
        super(nome);
        this.cnpj = cnpj;
    };

    public PessoaJuridica() {
        this.cnpj = 0;
    };

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    };

    public long getCnpj() {
        return this.cnpj;
    };

};

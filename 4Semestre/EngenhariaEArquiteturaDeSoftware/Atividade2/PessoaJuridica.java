public class PessoaJuridica extends Pessoa {
    long cnpj;

    @Override
    public String toString() {
        return "PessoaJuridica [nome=" + nome + ", cnpj=" + cnpj + "]";
    };

    public PessoaJuridica(long cnpj) {
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

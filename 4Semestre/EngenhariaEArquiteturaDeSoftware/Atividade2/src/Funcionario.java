public class Funcionario extends PessoaFisica {
    private int matricula;

    @Override
    public String toString() {
        return "Funcionario [nome=" + getNome() + ", cpf=" + getCpf() + ", matricula=" + matricula + "]";
    };

    public Funcionario(String nome, long cpf, int matricula) {
        super(nome, cpf);
        this.matricula = matricula;
    };

    public Funcionario() {
        this.matricula = 0;
    };

    public int getMatricula() {
        return matricula;
    };

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    };

};

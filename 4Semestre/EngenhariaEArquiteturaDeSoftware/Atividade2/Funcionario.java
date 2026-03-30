public class Funcionario extends PessoaFisica {
    int matricula;

    @Override
    public String toString() {
        return "Funcionario [nome=" + nome + ", cpf=" + cpf + ", matricula=" + matricula + "]";
    };

    public Funcionario(int matricula) {
        this.matricula = matricula;
    };

    public Funcionario() {
    };

    public int getMatricula() {
        return matricula;
    };

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    };

};

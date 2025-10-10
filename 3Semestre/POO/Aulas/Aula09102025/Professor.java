public class Professor extends Pessoa implements ProfessorFinanceiro {
    private int salario;

    public Professor(int id, String nome, int salario) {
        super(id, nome);
        this.salario = salario;
    }

    @Override
    public void receberSalario() {
        System.out.println(getNome() + " recebe salario " + this.salario);
    }

}

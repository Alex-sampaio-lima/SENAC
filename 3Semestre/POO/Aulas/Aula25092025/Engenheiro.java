
public final class Engenheiro extends Profissional {

    private Engenheiros especialidade;
    private int salario;

    Engenheiro(Engenheiros especialidade) {
        this.especialidade = especialidade;
        switch (especialidade) {
            case Civil:
                this.salario = 2500;
                break;
            case Mecanico:
                this.salario = 3000;
                break;
            case Eletricista:
                this.salario = 3500;
                break;
            case Dados:
                this.salario = 4000;
                break;
            default:
                this.salario = 2000;
                break;
        }
    }

    @Override
    public int getSalario() {
        return this.salario;
    }

    @Override
    public void TipoDeContrato() {
        System.out.println("CLT");
    }

    @Override
    public void fazServico() {
        switch (especialidade) {
            case Mecanico:
                System.out.println("Fazendo Projeto Mecanico.");
                break;
            case Eletricista:
                System.out.println("Fazendo projeto elétrico.");
                break;
            case Dados:
                System.out.println("Fazendo projeto de dados.");
                break;
            case Civil:
                System.out.println("Fazendo projeto de Casa.");
                break;
            default:
                System.out.println("Fazendo projeto.");
        }
    }

    public Engenheiros getEspecialidade() {
        return this.especialidade;
    }

    public void mostraEspecialiadade() {
        System.out.println("Especialidade: " + especialidade);
    }

}


public final class Engenheiro extends Profissional {

    private Engenheiros especialidade;
    private int salario;

    Engenheiro(Engenheiros especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public int getSalario() {
        return 0;
    }

    @Override
    public void TipoDeContrato() {

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

    public void mostraEspecialiadade() {
        System.out.println("Especialidade: " + especialidade);
    }

}

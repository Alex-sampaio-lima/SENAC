
public class BackEnd extends Programador {

    // Não pode sobreescrever porque ser final
    // @Override
    // public int getSalario() {
    //     return super.getSalario() + 800
    // }

    @Override
    public void TipoDeContrato() {
        System.out.println("CLT");
    }

    @Override
    public void fazServico() {
        System.out.println("Fazendo o BackEnd do Sistema.");
    }

}

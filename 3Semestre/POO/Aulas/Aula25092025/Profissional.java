
public abstract class Profissional {

    public abstract int getSalario();

    public abstract void TipoDeContrato();

    public abstract void fazServico();

    public static Profissional CriaProfissional(ListaDeProfissionais tipo) {

        switch (tipo) {
            case EngenheiroCivil:
                return new Engenheiro(Engenheiros.Civil);
            case EngenheiroMecanico:
                return new Engenheiro(Engenheiros.Mecanico);
            case EngenheiroDeDados:
                return new Engenheiro(Engenheiros.Dados);
            case EngenheiroEletricista:
                return new Engenheiro(Engenheiros.Eletricista);
            case ProgramadorFrontEnd:
                return new FrontEnd();
            case ProgramadorBackEnd:
                return new BackEnd();
            default:
                throw new AssertionError();
        }
    }

}

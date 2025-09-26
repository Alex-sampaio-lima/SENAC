
public class Main {

    public static void main(String args[]) {
        double raizDe2 = Math.sqrt(2.0);
        System.out.println(raizDe2);

        double tresAoQuadrado = Math.pow(3.0, 2.0);
        System.out.println(tresAoQuadrado);

        double pi = Math.PI;
        System.out.println(pi);

        pi = Matematica.PI;

        System.out.println(Matematica.pow(3.0, 2));
        // -- PARTE 2
        Engenheiro engMecanico = new Engenheiro(Engenheiros.Mecanico);
        Engenheiro engEletricista = new Engenheiro(Engenheiros.Eletricista);
        Engenheiro engDados = new Engenheiro(Engenheiros.Dados);
        Engenheiro engCivil = new Engenheiro(Engenheiros.Civil);

        engMecanico.mostraEspecialiadade();
        engEletricista.mostraEspecialiadade();
        engDados.mostraEspecialiadade();
        engCivil.mostraEspecialiadade();

        Programador progBackEnd = new BackEnd();
        Programador progFrontEnd = new FrontEnd();

        Profissional p1 = Profissional.CriaProfissional(ListaDeProfissionais.ProgramadorFrontEnd);

        Profissional p2 = Profissional.CriaProfissional(ListaDeProfissionais.EngenheiroCivil);

        p1.fazServico();
        p1.getSalario();
        p1.TipoDeContrato();

        

    }
}

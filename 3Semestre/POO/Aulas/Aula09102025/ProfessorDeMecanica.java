public class ProfessorDeMecanica extends Professor implements Mecanica {
    public ProfessorDeMecanica(int id, String nome, int salario) {
        super(id, nome, salario);
    };

    @Override
    public int getIDPessoa() {
        return getId();
    }

    @Override
    public void liberaAcessoOficina() {
        System.out.println("Professor " + getNome() + " entra na oficina.");

    }

    @Override
    public boolean temAcessoPesado() {
        return true;
    }
};

public class AlunoMecanica extends Aluno implements Mecanica {
    public AlunoMecanica(int id, String nome) {
        super(id, nome);
    }

    @Override
    public void liberaAcessoOficina() {
        System.out.println(getNome() + " está liberado !");
    }

    @Override
    public boolean temAcessoPesado() {
        return true;
    }

    @Override
    public int getIDPessoa() {
        return getId();
    }

}

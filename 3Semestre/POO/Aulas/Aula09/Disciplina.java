public class Disciplina {
    private String nome;
    private int cargaHoraria;

    Disciplina(String nome, int cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return this.nome;
    }

    public int getCargarHoraria() {
        return this.cargaHoraria;
    }

    @Override
    public String toString() {
        return "Disciplina [nome=" + nome + ", cargaHoraria=" + cargaHoraria + "]";
    }

}
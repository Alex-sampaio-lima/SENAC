import java.util.List;
import java.util.ArrayList;

public class Professor {
    private String nome;

    private final int valorDaHora = 1400;
    private List<Disciplina> disciplinas = new ArrayList();

    Professor(String nome) {
        this.nome = nome;
    }

    Professor(String nome, List<Disciplina> _disciplinas) {
        this.nome = nome;
        this.disciplinas.addAll(_disciplinas);
    }

    Professor(String nome, Disciplina[] _disciplinas) {
        this.nome = nome;
        for (Disciplina disciplina : _disciplinas) {
            this.disciplinas.add(disciplina);
        }
    }

    public void atribuiDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public int getCargarHoraria() {
        int total = 0;
        for (Disciplina disciplina : disciplinas) {
            total += disciplina.getCargarHoraria();
        }
        return total;
    }

    public int getSalario() {
        return getCargarHoraria() * valorDaHora * 4;
    }

    @Override
    public String toString() {
        return "Professor [nome=" + nome + ", valorDaHora=" + valorDaHora + ", disciplinas=" + disciplinas
                + ", getCargarHoraria()=" + getCargarHoraria() + ", getSalario()=" + getSalario() + "]";
    }

}

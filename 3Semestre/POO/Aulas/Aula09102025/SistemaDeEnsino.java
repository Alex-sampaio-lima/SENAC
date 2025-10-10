
import java.util.HashMap;
import java.util.Map;

public class SistemaDeEnsino {
    Map<Integer, Aluno> alunos = new HashMap<>();

    public void adicionaAluno(Aluno a) {
        alunos.put(a.getId(), a);
    };

    public void fazAvaliacao(int id, double nota) {
        alunos.get(id).fazAvaliacao(nota);
    };

};

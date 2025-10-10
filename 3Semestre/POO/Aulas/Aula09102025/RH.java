
import java.util.ArrayList;
import java.util.List;

public class RH {
    List<ProfessorFinanceiro> professores = new ArrayList();

    public void adicionaProfessor(ProfessorFinanceiro p) {
        professores.add(p);
        // p.liberaAcesso();
    };

    public void folhaDePagamento() {
        for (ProfessorFinanceiro p : professores) {
            p.receberSalario();
        }
    };
}

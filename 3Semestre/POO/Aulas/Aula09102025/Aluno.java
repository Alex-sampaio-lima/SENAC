public class Aluno extends Pessoa {

    private double nota = -1;

    public Aluno(int id, String nome) {
        super(id, nome);
    }

    public void fazAvaliacao(double nota) {
        if (nota < 0.0 || nota > 10.0) {
            System.out.println("Nota inválida");
        } else {
            System.out.println(getNome() + " recebe nota de " + nota);
            this.nota = nota;
        }
    }

    public boolean estaAprovado() {
        String nome = getNome();
        if (nota < 0.0) {
            System.out.println(nome + " não avaliado");
            return false;
        } else {
            if (nota < 6.0) {
                System.out.println(nome + " está reprovado.");
                return false;
            } else {
                System.out.println(nome + " está aprovado.");
                return true;
            }
        }
    }

}

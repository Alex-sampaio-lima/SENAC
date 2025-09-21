public class Paciente {
    private String nome;
    private int idade;
    private boolean prioridade;

    public Paciente(String nome, int idade, boolean prioridade) {
        this.nome = nome;
        this.idade = idade;
        this.prioridade = prioridade;
    }

    public Paciente() {
        this.nome = "";
        this.idade = 0;
        this.prioridade = false;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("{ Paciente } nome = " + nome + ", idade = " + idade + ", prioridade = " + prioridade + "}\n");

        return s.toString();
    }

    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isPrioridade() {
        return prioridade;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }
};

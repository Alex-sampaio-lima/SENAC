public abstract class Pessoa {
    // Normalmento id usa-se long
    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void liberaAcesso() {
        System.out.println(this.nome + " está liberado.");
    }

};

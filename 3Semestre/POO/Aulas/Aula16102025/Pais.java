public class Pais {
    private String nome;
    private int ouro = 0;
    private int prata = 0;
    private int bronze = 0;

    public Pais(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pais [nome=" + nome + ", ouro=" + ouro + ", prata=" + prata + ", bronze=" + bronze + "]";
    }

    public String getNome() {
        return nome;
    }

    public int getOuro() {
        return ouro;
    }

    public int getPrata() {
        return prata;
    }

    public int getBronze() {
        return bronze;
    }

    public void adicionaOuro() {
        this.ouro++;
    }

    public void adicionaPrata() {
        this.prata++;
    }

    public void adicionaBronze() {
        this.bronze++;
    }
}

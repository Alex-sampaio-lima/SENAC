public class Clube {

    private final String nome;
    private int titulos;
    private int viceTitulos;
    private int terceiros;
    private int golsMarcados;

    public Clube(String nome) {
        this.nome = nome;
        this.titulos = 0;
        this.viceTitulos = 0;
        this.terceiros = 0;
        this.golsMarcados = 0;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getTitulos() {
        return titulos;
    }

    public int getViceTitulos() {
        return viceTitulos;
    }

    public int getTerceiros() {
        return terceiros;
    }

    public int getGolsMarcados() {
        return golsMarcados;
    }

    // Métodos para adicionar
    public void addTitulo() {
        this.titulos++;
    }

    public void addViceTitulo() {
        this.viceTitulos++;
    }

    public void addTerceiro() {
        this.terceiros++;
    }

    public void addGols(int gols) {
        this.golsMarcados += gols;
    }

    @Override
    public String toString() {
        return String.format("%-25s | Títulos: %-2d | Vices: %-2d | 3ºs: %-2d | Gols: %d",
                nome, titulos, viceTitulos, terceiros, golsMarcados);
    }
}
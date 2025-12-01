import java.util.ArrayList;
import java.util.List;

public class Estado {
    private String nome;
    private List<Clube> clubes;

    public Estado(String nome) {
        this.nome = nome;
        this.clubes = new ArrayList<>();
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public List<Clube> getClubes() {
        return clubes;
    }

    // Adicionar clube ao estado
    public void addClube(Clube clube) {
        this.clubes.add(clube);
    }

    // Métodos para calcular totais
    public int getTotalTitulos() {
        return clubes.stream().mapToInt(Clube::getTitulos).sum();
    }

    public int getTotalViceTitulos() {
        return clubes.stream().mapToInt(Clube::getViceTitulos).sum();
    }

    public int getTotalTerceiros() {
        return clubes.stream().mapToInt(Clube::getTerceiros).sum();
    }

    public int getTotalGols() {
        return clubes.stream().mapToInt(Clube::getGolsMarcados).sum();
    }

    public int getQuantidadeClubes() {
        return clubes.size();
    }

    @Override
    public String toString() {
        return String.format("%-15s | Clubes: %-2d | Títulos: %-2d | Vices: %-2d | 3ºs: %-2d | Gols: %d",
                nome, getQuantidadeClubes(), getTotalTitulos(),
                getTotalViceTitulos(), getTotalTerceiros(), getTotalGols());
    }
}
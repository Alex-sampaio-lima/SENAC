import java.util.Comparator;

public class ComparadorTitulosClube implements Comparator<Clube> {

    @Override
    public int compare(Clube clube1, Clube clube2) {
        // Compara por títulos (1º lugar) - ordem decrescente
        int comparacaoTitulos = Integer.compare(clube2.getTitulos(), clube1.getTitulos());
        if (comparacaoTitulos != 0) {
            return comparacaoTitulos;
        }

        // Empate em títulos: compara vice-títulos (2º lugar) - ordem decrescente
        int comparacaoVices = Integer.compare(clube2.getViceTitulos(), clube1.getViceTitulos());
        if (comparacaoVices != 0) {
            return comparacaoVices;
        }

        // Empate em títulos e vices: compara 3ª colocações - ordem decrescente
        return Integer.compare(clube2.getTerceiros(), clube1.getTerceiros());
    };
};
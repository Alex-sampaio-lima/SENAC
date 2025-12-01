import java.util.Comparator;

public class PontuacaoComparator<T> implements Comparator<T> {
    private int pontosTitulo;
    private int pontosVice;
    private int pontosTerceiro;

    public PontuacaoComparator(int pontosTitulo, int pontosVice, int pontosTerceiro) {
        this.pontosTitulo = pontosTitulo;
        this.pontosVice = pontosVice;
        this.pontosTerceiro = pontosTerceiro;
    }

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(calcularPontuacao(o2), calcularPontuacao(o1));
    }

    private int calcularPontuacao(Object obj) {
        int titulos = 0, vices = 0, terceiros = 0;

        if (obj instanceof Clube) {
            titulos = ((Clube) obj).getTitulos();
            vices = ((Clube) obj).getViceTitulos();
            terceiros = ((Clube) obj).getTerceiros();
        } else if (obj instanceof Estado) {
            titulos = ((Estado) obj).getTotalTitulos();
            vices = ((Estado) obj).getTotalViceTitulos();
            terceiros = ((Estado) obj).getTotalTerceiros();
        }

        return titulos * pontosTitulo + vices * pontosVice + terceiros * pontosTerceiro;
    }
}
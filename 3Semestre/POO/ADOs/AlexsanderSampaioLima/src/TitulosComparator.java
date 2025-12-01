import java.util.Comparator;

public class TitulosComparator<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        int titulos1 = getTitulos(o1);
        int titulos2 = getTitulos(o2);
        int vice1 = getViceTitulos(o1);
        int vice2 = getViceTitulos(o2);
        int terceiros1 = getTerceiros(o1);
        int terceiros2 = getTerceiros(o2);

        int cmp = Integer.compare(titulos2, titulos1);
        if (cmp != 0) {
            return cmp;
        }

        cmp = Integer.compare(vice2, vice1);
        if (cmp != 0) {
            return cmp;
        }

        return Integer.compare(terceiros2, terceiros1);
    }

    private int getTitulos(Object obj) {
        if (obj instanceof Clube) {
            return ((Clube) obj).getTitulos();
        }
        if (obj instanceof Estado) {
            return ((Estado) obj).getTotalTitulos();
        }
        return 0;
    }

    private int getViceTitulos(Object obj) {
        if (obj instanceof Clube) {
            return ((Clube) obj).getViceTitulos();
        }
        if (obj instanceof Estado) {
            return ((Estado) obj).getTotalViceTitulos();
        }
        return 0;
    }

    private int getTerceiros(Object obj) {
        if (obj instanceof Clube) {
            return ((Clube) obj).getTerceiros();
        }
        if (obj instanceof Estado) {
            return ((Estado) obj).getTotalTerceiros();
        }
        return 0;
    };
};
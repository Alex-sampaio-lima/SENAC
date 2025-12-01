import java.util.Comparator;

public class GolsComparator<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        int gols1 = getGols(o1);
        int gols2 = getGols(o2);
        return Integer.compare(gols2, gols1);
    }

    private int getGols(Object obj) {
        if (obj instanceof Clube) {
            return ((Clube) obj).getGolsMarcados();
        }
        if (obj instanceof Estado) {
            return ((Estado) obj).getTotalGols();
        }
        return 0;
    }
}
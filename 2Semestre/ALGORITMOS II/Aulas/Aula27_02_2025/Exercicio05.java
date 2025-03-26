public class Exercicio05 {
    public static void main(String[] args) {
        char[][] m = {
                { 'a', 'b', 'c' },
                { 'b', 'd', 'e' },
                { 'c', 'e', 'f' },
        };
        boolean simetrica = ehSimetrica(m);
        if (simetrica) {
            System.out.println("A matriz é simétrica");
        } else {
            System.out.println("A matriz não é simétrica");
        }

    }

    public static boolean ehSimetrica(char[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] != m[j][i]) {
                    return false;
                }
            }
        }

        return true;
    }
}
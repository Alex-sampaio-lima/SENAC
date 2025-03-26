import java.util.Random;

public class teste {
    public static void main(String[] args) {
        Random rand = new Random();
        int a[][] = new int[2][3];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = rand.nextInt(190);
                System.out.printf("%03d ", a[i][j]);
            }
            System.out.println();
        }
    }
}

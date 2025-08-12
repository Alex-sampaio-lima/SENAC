package beecrowd;
import java.util.Scanner;

public class bee1013 {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        int a = 0;
        int b = 0;
        int c = 0;
        int maiorAB = 0;
        int maiorABC = 0;

        a = read.nextInt();
        b = read.nextInt();
        c = read.nextInt();

        maiorAB = (a + b + Math.abs(a - b)) / 2;
        maiorABC = (maiorAB + c + Math.abs(maiorAB - c)) / 2;

        System.out.printf("%d eh o maior", maiorABC);
    }
};

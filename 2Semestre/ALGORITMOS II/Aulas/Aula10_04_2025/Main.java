public class Main {
    public static void main(String[] args) {

        int f = fatorial(5);
        System.out.println(f);
        potencia(3, 4);

        binario(18);
    }

    public static int fatorial(int n) {
        // Base de recursão (condição de parada)
        if (n == 0) {
            return 1;
        } else {
            int f = fatorial(n - 1);
            int r = n * f;
            return r;
            // return n * fatorial(n - 1);
        }
    }

    // 3. Implemente uma funçaõ recursiva para calcular a potência A elevado a N,
    // supondo
    // que tanto a quanto N sejam números inteiros positivos.

    public static int potencia(int a, int n) {
        if (n == 0) // base da recursão
            return 1;
        // Passo da recursão
        return a * potencia(a, n - 1);
        // Redução de instância = Quanto eu chego mais perto da recursão
    }

    // 4. Implemente uma função recursiva que receba como
    // parâmetro um número natural e apresente o seu correspondente binário.

    public static void binario(int n) {
        if (n < 2) {
            System.out.print(n);
        } else {
            binario(n / 2);
            System.out.println(n % 2);
        }
    }

    // 5. Dado um vetor de números inteiros positivos, implemente funções recursivas
    // para:
    // a) Fazer a busca linear

}

public class Matematica {

    public static double PI = 3.14159265;

    public static double pow(double base, int expoente) {
        double resultado = 1;
        for (int i = 0; i < expoente; i++) {
            resultado *= base;
        }

        return resultado;
    }

    public static double pow(double base, double expoente) {
        return pow(base, (int) expoente);
    }
};

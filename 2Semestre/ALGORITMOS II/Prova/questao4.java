public class questao4 {
    public static void main(String[] args) {
        f_rec(5, 3);
    };

    public static int f_rec(int x, int y) {
        if (x == 0) {
            return y;
        }
        return f_rec(x - 1, y + 1);
    };
};

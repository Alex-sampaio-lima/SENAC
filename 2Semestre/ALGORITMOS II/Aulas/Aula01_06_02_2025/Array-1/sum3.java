public class sum3 {
    public static void main(String[] args) {
        int[] nums = { 53, 23, 123, 43, 532, 234, 123, 34 };
        int soma = 0;

        for (int i : nums) {
            soma += i;
        }

        // return soma;
        System.out.println(soma);
    }
}
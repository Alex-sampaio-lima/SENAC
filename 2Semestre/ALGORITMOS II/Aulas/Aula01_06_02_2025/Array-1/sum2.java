public class sum2 {
    public static void main(String[] args) {

        // int[] nums = { 1, 2, 3 };
        // int[] nums = { 1, 2, 3 };
        int[] nums = { 1, 1, 1, 1 };

        int soma = 0;

        for (int i = 0; i < nums.length; i++) {
            System.out.println(i);
            if (i <= 1) {
                soma += nums[i];
            }
        }

        // return soma;
        System.out.print(soma);

    }
}

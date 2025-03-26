public class sameFirstLast {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3 };
        // int[] nums = { 1, 2, 3, 1 };
        // int[] nums = { 1, 2, 1 };

        boolean verifica = false;
    
        for (int i = 0; i < nums.length; i++) {
            if (nums[0] == nums[nums.length - 1]) {
                verifica = true;
            }
        }
        System.out.println(verifica);

        // return verifica;

    }
}

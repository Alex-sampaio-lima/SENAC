public class firstLast6 {

    public static boolean main() {

        // int[] nums = { 1, 2, 6 }; // true
        // int[] nums = { 6, 1, 2, 3 }; // true
        // int[] nums = { 13, 6, 1,2,3 }; //false
        int[] nums = { 3, 6, 1 }; // false

        boolean verifica = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[0] == 6 || nums[nums.length - 1] == 6) {
                verifica = true;
            }
        }

        return verifica;
    }
}
import java.util.Arrays;

public class makeEnds {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        // int[] a = { 1, 2, 3, 4 };
        int[] resultado = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                resultado[i] = nums[i];
            } else if (i == nums.length - 1) {
                resultado[1] = nums[nums.length - 1];
            }
        }

        System.out.println(Arrays.toString(nums));
        // return nums;
    }
}
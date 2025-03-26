import java.util.Arrays;

public class maxEnd3 {
    public static void main(String[] args) {
        int[] nums = { 2, 11, 3 };

        int maiorNumero = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[0] >= nums[nums.length - 1]) {
                maiorNumero = nums[0];
            } else {
                maiorNumero = nums[nums.length - 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = maiorNumero;
        }

        // return nums;
        System.out.print(Arrays.toString(nums));
    }
}

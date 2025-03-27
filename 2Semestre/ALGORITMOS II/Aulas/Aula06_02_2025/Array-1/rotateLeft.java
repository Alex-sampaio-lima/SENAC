import java.util.Arrays;

public class rotateLeft {
    public static void main(String[] args) {
        int[] nums = { 5, 11, 9 };

        int troca = nums[nums.length - 1];

        nums[nums.length - 1] = nums[0];
        nums[0] = nums[1];
        nums[1] = troca;

        // return troca;
        System.out.print(Arrays.toString(nums));
    }
}

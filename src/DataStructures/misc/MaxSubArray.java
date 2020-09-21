package DataStructures.misc;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4, -2, 1, -3, 4, -1, 2, 1, -5, 4, -2, 1, -3, 4, -1, 2, 1, -5, 4, -2,
                1, -3, 4, -1, 2, 1, -5, 4, -2, 1, -3, 4, -1, 2, 1, -5, 4, -2, 1, -3, 4, -1, 2, 1, -5, 4, -2, 1, -3, 4,
                -1, 2, 1, -5, 4, -2, 1, -3, 4, -1, 2, 1, -5, 4, -2, 1, -3, 4, -1, 2, 1, -5, 4, -2, 1, -3, 4, -1, 2, 1,
                -5, 4, -2, 1, -3, 4, -1, 2, 1, -5, 4, -2, 1, -3, 4, -1, 2, 1, -5, 4, -2, 1, -3, 4, -1, 2, 1, -5, 4, -2,
                1, -3, 4, -1, 2, 1, -5, 4, -2, 1, -3, 4, -1, 2, 1, -5, 4, -2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    //keep on moving and if your max sub goes below 0
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        else if (nums.length == 1) return nums[0];

        int maxSum = nums[0];
        int sumTillNow = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumTillNow += nums[i];
            maxSum = Math.max(sumTillNow, maxSum);
            if (maxSum < 0) {
                sumTillNow = 0;
            }
        }
        return maxSum;
    }
}

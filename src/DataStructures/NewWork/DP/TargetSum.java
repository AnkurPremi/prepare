package DataStructures.NewWork.DP;

public class TargetSum {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        System.out.println(new TargetSum().findTargetSumWays(arr, 3));
    }

    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length + 1][1001];
        return helper(nums, 0, S, 0, dp);
    }

    private int helper(int[] nums, int sum, int target, int idx, int[][] dp) {
        if (target == sum) {
            if (idx == nums.length) return 1;
            return 0;
        }

        if (idx == nums.length) return 0;

        if (dp[idx][target] != 0) {
            System.out.println("hrerererere");
            return dp[idx][target];
        }

        //try positive
        int val = helper(nums, sum + nums[idx], target, idx + 1, dp);

        //try negative
        val += helper(nums, sum - nums[idx], target, idx + 1, dp);

        dp[idx][target] = val;
        return dp[idx][target];
    }
}

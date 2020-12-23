package DataStructures.NewWork.DP;

public class PartitionEqualSubSetsSum {
    public static void main(String[] args) {
        int[] arr = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};
        System.out.println(new PartitionEqualSubSetsSum().canPartition(arr));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if(sum % 2 != 0) return false;

        int target = sum / 2;
        Boolean[][] dp = new Boolean[nums.length + 1][target+1];
        return dfs(nums, target, 0, 0, dp);
    }

    private boolean dfs(int[] A, int target, int idx, int sum, Boolean[][] dp){
        if(sum > target) return false;

        if(sum == target)
            return true;

        if(idx ==  A.length)
            return false;

        if(dp[idx][sum] != null)
            return dp[idx][sum];

        boolean isPossible = dfs(A, target, idx + 1, sum, dp)
                || dfs(A, target, idx + 1, sum + A[idx], dp);

        dp[idx][sum] = isPossible;
        return dp[idx][sum];
    }
}

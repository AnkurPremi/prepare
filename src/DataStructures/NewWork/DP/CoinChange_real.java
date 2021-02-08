package DataStructures.NewWork.DP;

import java.util.Arrays;

public class CoinChange_real {
    public static void main(String[] args) {

    }

    //coinChange-2

    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount + 1];
        return dfs(coins, 0, amount, dp);
    }
    int dfs(int[] coins, int i, int amount, Integer[][] dp) {
        if (amount == 0) return 1;
        if (amount < 0 || i == coins.length) return 0;
        if (dp[i][amount] != null) return dp[i][amount];
        int ans = 0;
        ans += dfs(coins, i + 1, amount, dp); // skip ith coin
        ans += dfs(coins, i, amount - coins[i], dp); // use ith coin
        return dp[i][amount] = ans;
    }


    //coin change 1
    //Time O(n*amount) //space is less
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int coin : coins){
            for(int j = coin ; j <= amount ; j++){
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        int ans = dp[amount];
        return ans == amount + 1 ? -1 : ans;
    }

    //O(N*amount)
    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int ans = helper(coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int helper(int[] coins, int amount, int[] dp) {
        if (amount == 0) return 0;
        if (dp[amount] != 0) return dp[amount];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) continue;

            int val = helper(coins, amount - coins[i], dp);
            if (val != Integer.MAX_VALUE) {
                min = Math.min(min, val + 1);
            }
        }

        return dp[amount] = min;
    }
}

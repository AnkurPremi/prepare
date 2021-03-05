package DataStructures.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CoinChange {
    public static void main(String[] args) {
        int[] arr = {186, 419, 83, 408};
        int val = 6249;
        System.out.println(new CoinChange().coinChange12(arr, val));
    }

    public int coinChange(int[] coins, int amount) {
        return helper(0, coins, amount);
    }


    public int helper(int idx, int[] coins, int amount) {
        if (amount == 0) return 0;

        if (idx < coins.length && amount > 0) {
            int maxCoins = amount / coins[idx];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i <= maxCoins; i++) {
                if (amount >= i * coins[idx]) {
                    int result = helper(idx + 1, coins, amount - i * coins[idx]);
                    if (result != -1) {
                        min = Math.min(min, result + i);
                    }
                }
            }
            return min == Integer.MAX_VALUE ? -1 : min;
        }
        return -1;
    }

    public int coinChangeDP(int[] coins, int amount) {
        Map<Integer, Integer> map = new HashMap<>();
        return coinChangeDPHelper(coins, amount, map);
    }

    public int coinChangeDPHelper(int[] coins, int amount, Map<Integer, Integer> map) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (map.containsKey(amount-1)) return map.get(amount-1);
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChangeDPHelper(coins, amount - coin, map);
            if (res != -1) {
                min = Math.min(min, res + 1);
            }
            int val = min == Integer.MAX_VALUE ? -1 : min;
            map.put(amount-1, val);
            return val;
        }
        return -1;
    }

    public int coinChange12(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int j = 0; j < coins.length; j++){
            for(int i = coins[j]; i <= amount; i++){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

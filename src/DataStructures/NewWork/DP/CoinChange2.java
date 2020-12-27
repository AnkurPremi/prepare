package DataStructures.NewWork.DP;

import java.util.Arrays;

public class CoinChange2 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(new CoinChange2().change(5, coins));
    }

    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length + 1][amount + 1];

        for(int i=1 ; i<= coins.length ; i++){
            dp[i][0] = 1 ; // 0 amount but have coins
            for(int j=1 ; j<=amount ; j++){
                //if coins value greater than amount..then take whatever was best by not using this coin
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                } else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

//    public int change(int amount, int[] coins) {
//        Integer memo[][] = new Integer [coins.length+1][amount+1];
//        //no coins to make amount
//        for (int j=0; j<amount+1; j++){
//            memo[0][j] = 0;
//        }
//
//        //0 amount..but have coins
//        for (int i=0; i<coins.length+1; i++){
//            memo[i][0] = 1;
//        }
//
//        return recurse(amount, coins, coins.length, memo);
//    }
//
//    private int recurse(int amount, int[] coins, int numberOfCoins, Integer memo[][]){
//        if(amount==0) return 1;
//        if(numberOfCoins==0) return 0;
//        if(memo[numberOfCoins][amount] != null) return memo[numberOfCoins][amount];
//
//        //coins value is greater than the left amount
//        if(coins[numberOfCoins-1] > amount){
//            memo[numberOfCoins][amount] = recurse(amount, coins, numberOfCoins-1, memo);
//        } else{
//            memo[numberOfCoins][amount] = recurse(amount, coins, numberOfCoins-1, memo) + recurse(amount-coins[numberOfCoins-1], coins, numberOfCoins, memo);
//        }
//
//        return memo[numberOfCoins][amount];
//    }


//    public int change(int amount, int[] coins) {
//        Integer[][] cache = new Integer[coins.length + 1][amount + 1];
////        for(int[] arr : cache) Arrays.fill(arr, -1);
//        for (int j=0; j<amount+1; j++){
//            cache[0][j] = 0;
//        }
//
//        for (int i=0; i<coins.length+1; i++){
//            cache[i][0] = 1;
//        }
//        return helper(coins, amount, 0, cache);
//    }
//
//    private int helper(int[] coins, int amount, int idx, Integer[][] cache) {
//        if (amount == 0) return 1;
//        if (amount < 0 || idx == coins.length) return 0;
//        if(cache[idx][amount] != null) return cache[idx][amount];
//
//        //if we have coin that is bigger than the left amount
//        if(coins[idx] > amount){
//            cache[idx][amount] = helper(coins, amount, idx+1, cache);
//        } else {
//            //not using coin vs using same coin again
//            cache[idx][amount] = helper(coins, amount, idx + 1, cache) + helper(coins, amount - coins[idx], idx, cache);
//        }
//        return cache[idx][amount];
//    }

//    public int change(int amount, int[] coins) {
//        return helper(coins, amount, 0);
//    }
//
//    private int helper(int[] coins, int amount, int idx) {
//        if (amount == 0) return 1;
//        if (amount < 0 || idx == coins.length) return 0;
//        //not using coin vs using same coin again
//        return helper(coins, amount, idx + 1) + helper(coins, amount - coins[idx], idx);
//    }


}

package DataStructures.NewWork.DP;

public class CointChange {
    public static void main(String[] args) {

    }
    public int coinChange(int[] coins, int amount) {
        int[] min = {Integer.MAX_VALUE};
        helper(coins, amount, 0, 0, min);
        return min[0];
    }

    private void helper(int[] coins, long amount, long sum, long count, int[] min){
        if(count > min[0]) return;

        if(sum == amount){
            min[0] = Math.min(min[0], (int)count);
            return;
        }

        for(int i=0 ; i<coins.length ; i++){
            if(coins[i] + sum > amount) continue;
            helper(coins, amount, sum + coins[i], count + 1, min);
        }
    }
}

package DataStructures.NewWork.DP;

public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(3));
    }

    public int integerBreak(int n) {
//        int[] dp = new int[n+1];
        int[] max = {0};
        helper(n, max, 1);;
        return max[0];
    }

    public void helper(int n, int[] max, int product){
        if(n < 0) return;

        if(n == 0){
            max[0] = Math.max(max[0], product);
            return;
        }

        // if(dp[n] != 0) return dp[n];

        for(int i=1 ; i<=n ; i++){
            helper(n-i, max, product * i);
        }
    }
}

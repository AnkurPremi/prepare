package misc;

public class DistinctWaysClimbStairs {
    public static void main(String[] args) {

        System.out.println(getDistinctWays(2, new long[3]));
        System.out.println(getDistinctWays(200, new long[201]));
    }


    public static long getDistinctWays(int steps, long[] dp){
        if(steps == 0 || steps == 1) {
            dp[steps] = 1;
        }
        else if(dp[steps] == 0){
            dp[steps] = getDistinctWays(steps - 1, dp) + getDistinctWays(steps-2, dp);
        }
        return dp[steps];
    }

}

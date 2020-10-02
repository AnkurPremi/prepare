package DataStructures.DP;

public class DiceRollSum {
    public static void main(String[] args) {
        System.out.println(new DiceRollSum().numRollsToTarget1(30, 30, 500));
    }

    int ans = 0;
    //slow solution
    public int numRollsToTarget(int d, int f, int target) {
        if(d == 0 && target == 0) return 1;
        if(d ==0 || target == 0) return 0;

        //use each face of the dice to reach to the target
        for(int i=1 ; i<=f ; i++){

            //we can avoid checking some of the values..with which we can never reach
            if(d-1 !=0 && target - i > (d-1 * f)) break;

            //check if we can reach the target sum - i.. with one less dice
            ans = (ans + numRollsToTarget(d-1, f, target - i)) % 100000007;
        }

        return ans;

    }


    public int numRollsToTarget1(int d, int f, int target) {
        int[][] dp = new int[31][1001];
        return helper(d, f, target, dp);
    }

    public int helper(int d, int f, int target, int[][] dp){
        if(d == 0 && target == 0) return 1;
        if(d ==0 || target == 0) return 0;
        if(dp[d][target] != 0) return dp[d][target];
        int ans = 0;
        //use each face of the dice to reach to the target
        for(int i=1 ; i<=f ; i++){
            if(d!=0 && target-i > (d-1) * f) continue;
            //check if we can reach the target using i (target - i) .. with one less dice(d - i)
            ans = (ans + numRollsToTarget(d-1, f, target - i)) % 1000000007;
        }
        dp[d][target] = ans;

        return dp[d][target];
    }
}

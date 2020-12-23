package DataStructures.NewWork.DP;

import java.util.Arrays;

public class MinCostToCutStick {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5};
        System.out.println(new MinCostToCutStick().minCost(7, arr));
    }

    static int MAX = Integer.MAX_VALUE;
    int n = 0;
    public int minCost(int n, int[] cuts) {
        this.n = n;
        Arrays.sort(cuts);
        int len = cuts.length;
        int[][] dp = new int[len+1][len+1];
        return helper(cuts, 0, cuts.length, dp);
    }

    private int helper(int[] cuts, int start, int end, int[][] dp){
        if(start >= end) return 0;
        if(dp[start][end] != 0) return dp[start][end];
        int min = MAX;
        int actualEnd = (end == cuts.length ? n : cuts[end]);
        int actualStart = (start == 0 ? 0 : cuts[start-1]);
        int costHere = actualEnd - actualStart;
        for(int i=start ; i<end ; i++){
            min = Math.min(min, costHere
                    + helper(cuts, start, i, dp)
                    + helper(cuts, i+1, end, dp));
        }
        return dp[start][end] = min;
    }
}

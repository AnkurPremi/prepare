package DataStructures.DP;

import java.util.Arrays;

public class MaximumLengthofPairChain {
    public static void main(String[] args) {
        int[][] pairs = {
                {0,0},
                {11,12},
                {1,4},
                {2,5},
                {7,9}
        };
        System.out.println(new MaximumLengthofPairChain().findLongestChain(pairs));
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        int n = pairs.length;
        int[] dp = new int[n];
        int max = 1;
        dp[0] = 1;
        for(int i=1 ; i<n ; i++){
            int currMax = 0;
            for(int j=i-1 ; j>=0 && pairs[i][0] >= pairs[j][0] ; j--){
                if(pairs[i][0] > pairs[j][1]){
                    currMax = Math.max(currMax, dp[j]+1);
                }
            }
            dp[i] += currMax == 0? 1 : currMax;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

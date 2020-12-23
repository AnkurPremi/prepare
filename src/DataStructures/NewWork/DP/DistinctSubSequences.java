package DataStructures.NewWork.DP;

import java.util.Arrays;

public class DistinctSubSequences {
    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        System.out.println(new DistinctSubSequences().numDistinct(s, t));
    }

    public int numDistinct(String s, String t) {
        if(t.length() > s.length()) return 0;
        if(t.equals(s)) return 1;

        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        return helper(s, t, 0, 0, dp);
    }

    private int helper(String s, String t, int sIdx, int tIdx, int[][] dp) {
        if (t.length() == tIdx) return 1;
        if (s.length() == sIdx) return 0;

        if(dp[sIdx][tIdx] != -1) return dp[sIdx][tIdx];

        int ans = 0;
        if (s.charAt(sIdx) == t.charAt(tIdx)) {
            ans = helper(s, t, sIdx + 1, tIdx + 1, dp); // use the same character
            ans += helper(s, t, sIdx + 1, tIdx, dp); // don't use the same character
        } else {
            ans = helper(s, t, sIdx + 1, tIdx, dp); // no match
        }

        return dp[sIdx][tIdx] = ans;
    }
}

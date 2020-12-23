package DataStructures.NewWork.DP;

import java.util.ArrayList;
import java.util.List;

public class FreedomTrail {
    public static void main(String[] args) {
        String ring = "godding", key = "gd";
        System.out.println(new FreedomTrail().findRotateSteps(ring, key));
    }


    static int MAX = Integer.MAX_VALUE;
    public int findRotateSteps(String ring, String key) {
        List<Integer>[] map = new List[26];
        for (int i = 0; i < ring.length(); i++) {
            char c = ring.charAt(i);
            if (map[c - 'a'] == null)
                map[c - 'a'] = new ArrayList();
            map[c - 'a'].add(i);
        }
        int[][] dp = new int[ring.length() + 1][key.length() + 1];
        return helper(ring, key, 0, 0, map, dp);
    }

    private int helper(String ring, String key, int rIdx, int kIdx, List<Integer>[] map, int[][] dp) {
        if (key.length() == kIdx) return 0;
        if (dp[rIdx][kIdx] > 0) return dp[rIdx][kIdx];
        int min = MAX;
        int m = ring.length();
        for (int i : map[key.charAt(kIdx) - 'a']) {
            int val = Math.abs(rIdx - i);
            val = Math.min(val, m - val); //clockwise vs anticlockwise
            min = Math.min(min, val + helper(ring, key, i, kIdx + 1, map, dp));
        }
        return dp[rIdx][kIdx] = min + 1;
    }
}

package DataStructures.NewWork.DP;

import java.util.Arrays;

public class MinInsertionsTomakeStringPalindrome {
    public static void main(String[] args) {
        String s = "no";
        System.out.println(new MinInsertionsTomakeStringPalindrome().minInsertions(s));
    }

    public int minInsertions(String s) {
        int n = s.length();
        if(n < 2) return 0;
        int[][] cache = new int[n+1][n+1];
        for(int[] arr : cache) Arrays.fill(arr, -2);
        return helper(s, 0, n-1, cache);
    }

    private int helper(String s, int left, int right, int[][] cache){
        if(left > right) return -1;
        if(left == right) return 0;
        if(cache[left][right] != -2) return  cache[left][right];
        int min = 0;
        if(s.charAt(left) == s.charAt(right)){
            min = helper(s, left + 1, right - 1, cache);
        } else{
            int v1 = helper(s, left+1, right, cache);
            int v2 = helper(s, left, right - 1, cache);
            if(v1 == -1)
                min = 1 + v2;
            else if(v2 == -1)
                min = 1 + v1;
            else
                min = 1 + Math.min(v1, v2);
        }
        return cache[left][right] = min;
    }
}

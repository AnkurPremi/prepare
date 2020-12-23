package DataStructures.NewWork.DP;

import java.util.Arrays;

public class RussianDollEnvelope {
    public static void main(String[] args) {
        int[][] arr = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(new RussianDollEnvelope().maxEnvelopes(arr));
    }
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if(n < 2) return n;
        Arrays.sort(envelopes, (a, b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        int[] dp = new int[n];
        int len = 0;
        for(int[] env : envelopes){
            int idx = Arrays.binarySearch(dp, 0, len, env[1]);

            if(idx < 0){  //negative index means there is no element greater than this
                idx = -(idx + 1);
            }
            dp[idx] = env[1];
            if(len == idx){
                len++;
            }
        }
        return len;
    }
    public int maxEnvelopes1(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        int n = envelopes.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        int max = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<i ; j++){
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

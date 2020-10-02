package DataStructures.DP;

public class MaxSumAfterPartition {
    public static void main(String[] args) {
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        System.out.println(new MaxSumAfterPartition().maxSumAfterPartitioning(arr, 3));
    }

    public int maxSumAfterPartitioning(int[] A, int K) {
        int[] dp = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int currMax = 0;
            for (int j = 1; j <= K && j - K + 1 >= 0; j++) {
                currMax = Math.max(currMax, A[j - K + 1]);
                dp[i] = Math.max(dp[i], (i >= j ? dp[i - j] : 0) + currMax * j);
            }
        }
        return dp[A.length - 1];
    }
}


//    int N = A.length, dp[] = new int[N];
//        for (int i = 0; i < N; ++i) {
//        int curMax = 0;
//        for (int k = 1; k <= K && i - k + 1 >= 0; ++k) {
//        curMax = Math.max(curMax, A[i - k + 1]);
//        dp[i] = Math.max(dp[i], (i >= k ? dp[i - k] : 0) + curMax * k);
//        }
//        }
//        return dp[N - 1];
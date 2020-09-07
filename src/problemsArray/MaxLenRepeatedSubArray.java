package problemsArray;

import strings.EditDistance;

public class MaxLenRepeatedSubArray {
    public static void main(String[] args) {
        int[] A = {0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        int[] B = {0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
        System.out.println(new MaxLenRepeatedSubArray().findLength(A, B));
    }

    //this is like finding longest common substring
    //we can solve it using dp
    public int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) return 0;

        int max = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 1; j < B.length + 1; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    EditDistance.printMatrix(dp);
                    System.out.println("\n------------------------");
                    if (max < dp[i][j]) {
                        max = dp[i][j];
                    }
                }
            }
        }
        return max;
    }
}

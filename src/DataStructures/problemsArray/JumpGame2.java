package DataStructures.problemsArray;

import java.util.Arrays;

public class JumpGame2 {
    public static void main(String[] args) {
        int[] arr = {4,1,1,3,1,1,1};
        Arrays.binarySearch(arr, 0, 2, 3);
        System.out.println(new JumpGame2().jump(arr));
    }

    public int jump(int[] A) {
        int n = A.length;
        int[] dp = new int[n];

        for(int i=n-2 ; i>=0 ; i--){
            dp[i] = 1 + Math.min(dp[i+1], dp[Math.min(i+A[i], n-1)]);
        }
        return dp[0];
    }
}

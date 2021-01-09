package DataStructures.NewWork.DP;

import java.util.Arrays;

public class LongestLengthOfIncreasingSubSequence {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(new LongestLengthOfIncreasingSubSequence().lengthOfLIS(arr));
    }

    public int lengthOfLIS1(int[] nums) {
        int n = nums.length, max = 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<i ; j++){
                if(nums[j] < nums[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    //patience sorting
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}

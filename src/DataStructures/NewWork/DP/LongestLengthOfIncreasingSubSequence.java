package DataStructures.NewWork.DP;

import java.util.Arrays;

public class LongestLengthOfIncreasingSubSequence {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(new LongestLengthOfIncreasingSubSequence().lengthOfLIS(arr));
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

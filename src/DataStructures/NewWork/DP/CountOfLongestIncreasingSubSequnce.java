package DataStructures.NewWork.DP;

import java.util.Arrays;

//673
public class CountOfLongestIncreasingSubSequnce {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 7};
        System.out.println(new CountOfLongestIncreasingSubSequnce().findNumberOfLIS(arr));
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int[] count = new int[n + 1];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { //nums[i] is making LIS with nums[j]

                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        //New long LIS formed with elements at i and j..
                        //previously formed here is now current
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        //new LIS formed..that means ..including this element there are multiple LIS
                        //{1,3,5,4,7} -- at 7 ... we have two LIS  1,3,5,7  and  1,3,4,7
                        //when 7 received same length dp[j]+1 ..from another element
                        //that means there is another LIS of same length but has diff elements
                        //so..add the LIS counts ending at 7
                        count[i] += count[j];
                    }
                }
            }
            if (maxLen < dp[i]) {
                maxLen = dp[i];
            }
        }
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            if (maxLen == i) {
                ans += count[i];
            }
        }

        return ans;
    }
}

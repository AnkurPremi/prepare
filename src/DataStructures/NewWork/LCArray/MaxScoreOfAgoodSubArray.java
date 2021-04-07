package DataStructures.NewWork.LCArray;

import java.util.PriorityQueue;

public class MaxScoreOfAgoodSubArray {
    public static void main(String[] args) {
        int[] nums = {1,4,3,7,4,5};
        int k = 3;
        System.out.println(new MaxScoreOfAgoodSubArray().maximumScore(nums, k));
    }

    public int maximumScore(int[] nums, int k) {
        int n = nums.length, start = k, end = k, min = nums[k];
        int ans = nums[k];

        while(start > 0 || end < n - 1){
            if(start == 0){
                end++;
            } else if(end == n - 1){
                start--;
            } else if(nums[start - 1] < nums[end + 1]){
                end++;
            } else {
                start--;
            }

            min = Math.min(min, Math.min(nums[start], nums[end]));
            ans = Math.max(ans, (end - start + 1) * min);
        }

        return ans;
    }

    public int maximumScore1(int[] A, int k) {
        int res = A[k], mini = A[k], i = k, j = k, n = A.length;
        while (i > 0 || j < n - 1) {
            if (i == 0)
                ++j;
            else if (j == n - 1)
                --i;
            else if (A[i - 1] < A[j + 1])
                ++j;
            else
                --i;
            mini = Math.min(mini, Math.min(A[i], A[j]));
            res = Math.max(res, mini * (j - i + 1));
        }
        return res;
    }

}

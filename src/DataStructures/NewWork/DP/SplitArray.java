package DataStructures.NewWork.DP;

public class SplitArray {
    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        System.out.println(new SplitArray().splitArray(arr, 2));
    }

//    int max = 0;
//    int min = Integer.MAX_VALUE;
//    public int splitArray(int[] nums, int m) {
//         helper(nums, m, 1, 0);
//        System.out.println("min-"+min);
//         return min;
//    }
//
//    private int helper(int[] nums, int m, int mCount, int idx) {
//        if (idx == nums.length) {
//            if(m != mCount) return Integer.MIN_VALUE;
//            return 0;
//        }
//        if (mCount >= m) return Integer.MIN_VALUE;
//        int v1 = nums[idx] + helper(nums, m, mCount, idx + 1);
//        int v2 = helper(nums, m, mCount + 1, idx + 1);
//        int v3 = Math.max(v1, v2);
//        min = Math.min(v3, min);
//        return v3;
//    }

    int max = 0;
    int min = Integer.MAX_VALUE;
    public int splitArray(int[] nums, int m) {
        helper(nums, m, 1, 0, 0, 0);
        return min;
    }

    private void helper(int[] nums, int m, int mCount, int idx, int prevSum, int curSum) {
        if (idx == nums.length) {
            if (mCount != m) return;
            max = Math.max(curSum, prevSum);
            min = Math.min(min, max);
            return;
        }
        if (mCount > m) return;
        //part of previous
        helper(nums, m, mCount, idx + 1, prevSum, curSum + nums[idx]);

        //
        helper(nums, m, mCount + 1, idx + 1, Math.max(prevSum, curSum), nums[idx]);

    }
    }

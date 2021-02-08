package DataStructures.NewWork.LCArray;

public class LongestHarmonicSubSequence {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(new LongestHarmonicSubSequence().findLHS(arr));
    }

    public int findLHS(int[] nums) {
        return helper(nums, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
    }

    private int helper(int[] nums, int idx, int min, int max, int len) {
        if (idx == nums.length) return 0;

        int maxHere = 0;
        //pick this index - deleting old selection
        if (nums[idx] < min || nums[idx] > max) {
            int val = helper(nums, idx + 1, Math.min(min, nums[idx]), Math.max(max, nums[idx]), 1);
            maxHere = Math.max(maxHere, 1 + val);
            maxHere = Math.max(maxHere, 1 + len + helper(nums, idx + 1, min, max, len + 1));
        } else {
            maxHere = Math.max(maxHere, 1 + len + helper(nums, idx + 1, min, max, len + 1));
        }


        maxHere = Math.max(maxHere, len);


        //don't pick this index

        return maxHere;
    }
}

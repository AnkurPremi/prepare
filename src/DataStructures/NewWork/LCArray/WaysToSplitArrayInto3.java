package DataStructures.NewWork.LCArray;

public class WaysToSplitArrayInto3 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        System.out.println(new WaysToSplitArrayInto3().waysToSplit(arr));
    }

    public int waysToSplit(int[] nums) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        return helper(nums, 0, 0, totalSum, 1, -1);
    }

    private int helper(int[] nums, int idx, int sum, long totalSum, int split, int prevSum) {
        if (idx == nums.length && split == 3 && sum >= prevSum) return 1;
        if (idx == nums.length || split > 3) return 0;

        int ans = 0;
        //part of prev
        if (prevSum == -1 || nums[idx] + sum <= prevSum)
            ans += helper(nums, idx + 1, sum + nums[idx], totalSum, split, prevSum == -1 ? nums[idx] : prevSum);


        //part of other
        ans += helper(nums, idx + 1, nums[idx], totalSum, split + 1, sum);

        return ans;
    }
}

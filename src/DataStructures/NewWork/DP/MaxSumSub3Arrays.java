package DataStructures.NewWork.DP;

import java.util.ArrayList;
import java.util.List;

public class MaxSumSub3Arrays {
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,6,7,5,1};
        System.out.println(new MaxSumSub3Arrays().maxSumOfThreeSubarrays(arr, 2));
    }

    List<Integer> result = null;
    int max = 0;

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        result = new ArrayList();
        helper(nums, k, 0, 0, 0, new ArrayList());
        return new int[]{0};
    }

    private void helper(int[] nums, int k, int kCount, int idx, int sum, List<Integer> list) {
        if (list.size() == 3) {
            if (max < sum) {
                result = new ArrayList(list);
                max = sum;
            }
            return;
        }
        if (idx == nums.length) return;

        for (int i = idx; i < nums.length; i++) {
            if (kCount == 0)
                list.add(idx);

            helper(nums, k, kCount == k ? 0 : kCount + 1, i + 1, nums[i] + sum, list);

            if (kCount == 0)
                list.remove(list.size() - 1);

            helper(nums, k, kCount, i + 1, sum, list);
        }

    }
}

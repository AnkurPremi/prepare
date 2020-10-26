package DataStructures.problemsArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/
public class CombinationSumII {
    public static void main(String[] args) {
        int[] nums = {10,1,2,10,6,1,5};
        int target = 13;
        System.out.println(new CombinationSumII().combinationSum2(nums, target));
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(0, target, nums, result, new ArrayList<>());
        return result;
    }

    private void helper(int start, int target, int[] nums, List<List<Integer>> result, List<Integer> tempList) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            tempList.add(nums[i]);
            helper(i + 1, target - nums[i], nums, result, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}

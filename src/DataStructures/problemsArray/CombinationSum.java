package DataStructures.problemsArray;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/combination-sum/submissions/
public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 7;
        System.out.println(new CombinationSum().combinationSum(nums, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int target, int start, List<List<Integer>> result, List<Integer> tempList) {
        if (target < 0) return;
        if (target == 0) result.add(new ArrayList<>(tempList));
        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            helper(candidates, target - candidates[i], i, result, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}


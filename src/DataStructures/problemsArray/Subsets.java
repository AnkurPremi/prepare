package DataStructures.problemsArray;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Subsets().subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result, new ArrayList<>());
        return result;
    }

    private void helper(int start, int[] nums, List<List<Integer>> result, List<Integer> tempList) {
        if (start <= nums.length && !tempList.isEmpty()) {
            result.add(new ArrayList<>(tempList));
        }
        for (int i=start; i<nums.length ; i++){
            tempList.add(nums[i]);
            helper(i+1, nums, result, tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}

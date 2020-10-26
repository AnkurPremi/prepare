package DataStructures.problemsArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/4sum/
public class FourSum {
    public static void main(String[] args) {
        int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        System.out.println(new FourSum().fourSum(nums, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
            return res;
        if (k == 2)
            return twoSum(nums, target, start);
        for (int i = start; i < nums.length; ++i)
            if (i == start || nums[i - 1] != nums[i])
                for (var set : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(set);
                }
        return res;
    }
    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target || (lo > start && nums[lo] == nums[lo - 1]))
                ++lo;
            else if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1]))
                --hi;
            else
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
        }
        return res;
    }

    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if(j>1 && nums[j] == nums[j-1]) continue;
                int newtarget = target - nums[i] - nums[j];
                int low = j + 1, high = nums.length - 1;
                while (low > j+1 && nums[low] == nums[low - 1]) low++;
                while (high < nums.length-1 && nums[high] == nums[high + 1]) high--;
                while (low < high) {
                    if (newtarget == nums[low] + nums[high]) {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[low], nums[high])));
                        low++;
                        high--;
                    } else if (newtarget > nums[low] + nums[high]) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return result;
    }
}

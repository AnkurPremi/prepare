package DataStructures.problemsArray;

import java.util.*;

//https://leetcode.com/problems/3sum/
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        new ThreeSum().threeSum1(arr);
    }
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int low = 1, high = nums.length-1, target = -nums[0];
        while(low < high){
            int val = nums[low] + nums[high];
            if(val == target){
                List<Integer> list = new ArrayList<>();
                list.add(nums[low]);list.add(-target);list.add(nums[high]);
                result.add(list);
                low++;
                high--;
            }else if(val <target){
                low++;
            }else{
                high++;
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            target = -nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for(int j=i+1; j<nums.length ; j++){
                if(map.containsKey(nums[j])){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[j]);list.add(nums[i]);list.add(target - nums[j]);
                    result.add(list);
                } else{
                    map.put(target - nums[j], j);
                }
            }
        }
        return result;
    }
}

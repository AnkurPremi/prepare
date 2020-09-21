package DataStructures.problemsArray;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] result = new TwoSum().twoSum(arr, target);
        System.out.println("check");
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums.length != 0){
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<nums.length ; i++){
                if(map.containsKey(nums[i])){
                    result[0] = map.get(nums[i]);
                    result[1] = i;
                    return result;
                } else{
                    map.put(target - nums[i], i);
                }
            }
        }
        return result;
    }
}

package problemsArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum0 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,1,-1,1,-2,2};
        System.out.println(new ThreeSum0().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) return result;
        Arrays.sort(nums);
        int target = 0;
        for(int i=0; i<nums.length ;i++){
            //if the previous number is same as the current one..means we cannot use the current number
            // because this will add duplicates
            if(i !=0 && (nums[i] == nums[i-1])) continue;

            //if we have reached at a position after which all the numbers are positive
            //then from this position onwards we cannot make our sum 0 by adding numbers
            //so break
            if(nums[i] >=0) break;

            int start = i+1, end = nums.length-1;
            while(start < end){
                int sum = nums[start] + nums[end] + nums[i];
                if(sum == target){
                    //this is to handle the case of duplicate numbers
                    while(start < end && nums[start] == nums[start+1]) start++;
                    //this is to handle the case of duplicate numbers
                    while(start < end && nums[end] == nums[end-1]) end--;
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                } else if(sum < target){
                    start++;
                } else{
                    end--;
                }
            }
        }
        return result;
    }
}

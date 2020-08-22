package Arrays;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/4sum/
public class FourSum {
    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        System.out.println(new FourSum().fourSum(nums, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i< nums.length-3 ;i++){
            for(int j = i+1 ; j < nums.length-2;j++){
                int newtarget = target - nums[i] - nums[j];
                int low = j+1, high = nums.length-1;
                 while(low<high){
                    if(newtarget == nums[low] + nums[high]){
                        List<Integer> list= new ArrayList<>();
                        list.add(nums[i]);list.add(nums[j]);list.add(nums[low]);list.add(nums[high]);
                         result.add(list);
                        low++;
                        high--;
                    }else if(newtarget > nums[low] + nums[high]){
                        low++;
                    }else {
                        high--;
                    }
                }
            }
        }
        return result;
    }
}

package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbers_Disappeared_Array {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        new FindAllNumbers_Disappeared_Array().findDisappearedNumbers(nums);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i=0;
        while(i<nums.length){
            if(nums[i] != i+1 && nums[i] != nums[nums[i]-1]){
                swap(nums, i, nums[i]-1);
            }else{
                i++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int j=0;j<nums.length;j++){
            if(nums[j] != j+1){
                result.add(j+1);
            }
        }
        return result;
    }

    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

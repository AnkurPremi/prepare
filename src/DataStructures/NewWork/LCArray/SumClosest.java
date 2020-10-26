package DataStructures.NewWork.LCArray;

import java.util.Arrays;

public class SumClosest {
    public static void main(String[] args) {
        int[] arr = {-1,2,1,-4};
        System.out.println(new SumClosest().threeSumClosest(arr, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Integer ans = null;
        for(int i=0 ; i<nums.length-2 ; i++){
            int j = i+1, k = nums.length-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < target){
                    j++;
                }else if(sum > target){
                    k--;
                }else{
                    return sum;
                }
                if(ans == null){
                    ans = sum;
                }else if(Math.abs(sum - target) < Math.abs(ans - target)){
                    ans = sum;
                }
            }
        }
        return ans;
    }
}

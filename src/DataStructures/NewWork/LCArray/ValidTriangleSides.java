package DataStructures.NewWork.LCArray;

import java.util.Arrays;

public class ValidTriangleSides {
    public static void main(String[] args) {
        int[] arr = {2,2,3,4,7,9,14};
        System.out.println(new ValidTriangleSides().triangleNumber1(arr));
    }

    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int i=0 ; i<nums.length-2 ; i++){
            int k = i+2;
            for(int j=i+1 ; j<nums.length-1 && nums[j] != 0; j++){
                while(k < nums.length && nums[i] + nums[j] > nums[k]){
                    k++;
                }
                count += k-j-1; //k-j-1 = (k-1) - (j+1) + 1   --- all the elements b/w k-1 and j+1 will make valid triangle
            }
        }
        return count;
    }

    public int triangleNumber1(int[] nums) {
        int count = 0;
        Arrays.sort(nums);

        int n = nums.length;
        for(int i=n-1 ; i>=2 ; i--){
            int l = 0, r = i-1;
            while(l<r){
                if(nums[l] + nums[r] > nums[i]){
                    //since the array is sorted..if nums[l] + nums[r] > nums[i]
                    //then all the elements at index j where l<j && nums[l]<=nums[j] .. will satisfy the condition nums[l] + nums[r] > nums[i]
                    //so count all of them and move r to r-1 and try the same
                    count += r-l;
                    r--;
                }
                l++;
            }
        }

        return count;
    }
}

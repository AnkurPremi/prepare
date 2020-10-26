package DataStructures.NewWork.LCArray;

public class MinInSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(new MinInSortedArray().findMin(arr));
    }

    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        while(l < r){
            int m = (l+r) >> 1;
            if(nums[m] < nums[l]){
                if(nums[l] < nums[r])
                    l = m + 1;
                else
                    r = m - 1;
            } else{
                if(nums[l] < nums[r])
                    r = m - 1;
                else
                    l = m + 1;
            }
        }
        return nums[l];
    }
}

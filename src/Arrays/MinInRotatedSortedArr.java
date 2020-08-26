package Arrays;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class MinInRotatedSortedArr {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,1};
        new MinInRotatedSortedArr().findMin(nums);
    }

    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        //array is sorted with no rotation - return 1st number in array
        if(nums[0] < nums[nums.length-1]) return nums[0];
        return binarySearchHelper(nums, 0, nums.length-1);
    }

    private int binarySearchHelper(int[] nums, int start, int end){

        while(start < end){
            int mid = (start+end)>>1;

            if(mid - 1 >=0 && mid+1 < nums.length){
                if(nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1])
                    return nums[mid];
                else if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
                    return nums[mid+1];
            }


            if(mid == start){
                if(nums[mid] < nums[end]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
            //if left is sorted
            else if(nums[start] < nums[mid]){
                //if right is unsorted, look right
                if(nums[mid] > nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
            //if right is sorted
            else if(nums[mid] < nums[end]){
                //if left is unsorted
                if(nums[start] > nums[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }

            //if both are sorted..look left
//            else{
//                end = mid -1;
//            }
        }
        return nums[start];
    }

}

package problemsArray;

public class SearchinRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {3,1};
        int target = 1;
        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int start = 0, end = nums.length-1;
        while (start<=end){
            int mid = (start+end)>>1;
            if(nums[mid] == target) return true;
            //if right half is sorted
            else if(nums[mid] < nums[end] || nums[mid] < nums[start]){
                //check if target lies in the right half
                if(target > nums[mid] && target<=nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
            //if left half is sorted
            else if(nums[mid] > nums[start] || nums[end] < nums[mid]){
                //check if target lies in the left half
                if(target < nums[mid] && target >= nums[start]){
                    end = mid-1;
                }else {
                    start = mid+1;
                }
            }
            else {
                while(end-1 >=start && nums[mid-1] == nums[mid]){
                    end--;
                }
            }
        }
        return false;
    }
}

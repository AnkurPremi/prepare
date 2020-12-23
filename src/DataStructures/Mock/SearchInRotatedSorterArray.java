package DataStructures.Mock;

public class SearchInRotatedSorterArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(new SearchInRotatedSorterArray().search(arr, 3));
    }
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;

        while(start <= end){
            int mid = (start + end) >> 1;
            if(nums[mid] == target) return mid;

            if(nums[start] < nums[mid]){
                if(target >= nums[start] && target < nums[mid]){
                    end = mid - 1;
                } else{
                    start = mid + 1;
                }
            }
            else if(nums[end] > nums[mid]){
                if(target <= nums[end] && target > nums[mid]){
                    start = mid + 1;
                } else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}

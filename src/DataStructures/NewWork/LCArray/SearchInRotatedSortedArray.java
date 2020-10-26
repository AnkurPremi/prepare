package DataStructures.NewWork.LCArray;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {3,1};
        System.out.println(new SearchInRotatedSortedArray().search(arr, 1));
    }

    public int search(int[] nums, int target) {
        int n = nums.length;

        int l = 0, r = n - 1;
        while(l <= r){
            int m = (l + r) >> 1;
            if(nums[m] == target) return m;

            //check if left half is sorted
            if(nums[l] <= nums[m]){

                if(nums[l] <= target && target < nums[m])
                    r = m - 1;
                else
                    l = m + 1;

            }

            else{

                if(nums[m] < target && target <= nums[r])
                    l = m + 1;
                else
                    r = m - 1;

            }
        }
        return -1;
    }
}

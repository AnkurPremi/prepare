package problemsArray;

public class FirstandLastPositionofElementInSorted {
    public static void main(String[] args) {
        int[] nums = {1,4};
        int target = 4;
        new FirstandLastPositionofElementInSorted().searchRange(nums, target);
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[0];
        if (nums.length == 1 && nums[0] == target) {
            return new int[]{0, 0};
        }
        if(nums[0] == nums[nums.length-1] && nums[0] == target){
            return new int[]{0, nums.length-1};
        }
        int left = binarySearch(nums, 0, nums.length-1,target, true);
        int right = binarySearch(nums, 0, nums.length-1,target, false);
        return new int[]{left, right};
    }

    public int binarySearch(int[] nums, int start, int end, int target, boolean lookLeft) {
        int result = -1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (nums[mid] == target) {
                result = mid;
                if(start == end) break;
                if (lookLeft) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }else if(nums[mid] < target){
                start++;
            }else {
                end -- ;
            }
        }
        return result;
    }
}

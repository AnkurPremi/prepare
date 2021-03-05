package DataStructures.problemsArray;

public class FirstandLastPositionofElementInSorted {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        new FirstandLastPositionofElementInSorted().searchRange(nums, target);
    }

    public int[] searchRange1(int[] nums, int target) {
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


    public int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums, target);
        if(left == -1) return new int[]{-1, -1};
        int right = searchRight(nums, target);
        return new int[]{left, right};
    }

    private int searchLeft(int[] nums, int target){
        int ans = -1;
        int start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == nums[mid]) ans = mid;

            if(target <= nums[mid]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    private int searchRight(int[] nums, int target){
        int ans = -1;
        int start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = start + (end- start) / 2;
            if(target == nums[mid]) ans = mid;

            if(target >= nums[mid]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
}

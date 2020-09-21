package DataStructures.problemsArray;

public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3, 5, 1};
        int target = 1;
        System.out.println(new SearchinRotatedSortedArray().search(nums, target));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 1 || nums[0] == nums[1]) return nums[0] == target ? 0 : -1;
        if (nums.length == 2) {
            return nums[0] == target ? 0 : nums[1] == target ? 1 : -1;
        }
        if (nums[0] < nums[nums.length - 1]) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                if (target <= nums[nums.length - 1]) {
                    return binarySearch(nums, mid + 1, end, target);
                } else {
                    return binarySearch(nums, start, mid - 1, target);
                }
            } else if (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                if (target <= nums[nums.length - 1]) {
                    return binarySearch(nums, mid, end, target);
                } else {
                    return binarySearch(nums, start, mid - 1, target);
                }
            } else {
                if (target < nums[mid]) {
                    if (nums[0] > target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}

package Arrays;

public class FindPeakElement {
    public static void main(String[] args) {

    }

    //check the elements left and right of the mid
    //while doing binary search
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) return -1;
        else if (nums.length == 1) return 0;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;

            if (mid - 1 >= 0) {
                if (mid + 1 < nums.length) {
                    if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                        return mid;
                    } else if (nums[mid - 1] > nums[mid + 1]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if (nums[mid] > nums[mid - 1]) {
                        return mid;
                    } else {
                        end = mid - 1;
                    }
                }
            } else if (mid + 1 < nums.length) {
                if (nums[mid] > nums[mid + 1]) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            }

        }
        return -1;
    }
}

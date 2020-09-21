package DataStructures.problemsArray;

public class KthLargestInArray {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k = 2;
        new KthLargestInArray().findKthLargest(arr, k);
    }

    public int findKthLargest(int[] nums, int k) {
        quickselect(nums, k, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public void quickselect(int[] nums, int k, int start, int end) {
        if (start > end) return;
        int pIndex = partition(nums, start, end);
        if (pIndex == k) {
            return;
        }
        if (k < pIndex) {
            quickselect(nums, k, start, pIndex - 1);
        } else {
            quickselect(nums, k, pIndex + 1, end);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (nums[i] >= pivot) {
                int temp = nums[pIndex];
                nums[pIndex] = nums[i];
                nums[i] = temp;
                pIndex++;
            }
        }
        int temp = nums[pIndex];
        nums[pIndex] = pivot;
        nums[end] = temp;
        return pIndex;
    }
}

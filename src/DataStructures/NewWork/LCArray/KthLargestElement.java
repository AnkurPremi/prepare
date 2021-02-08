package DataStructures.NewWork.LCArray;

import java.util.Arrays;
import java.util.Random;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        System.out.println(new KthLargestElement().findKthLargest(arr, 2));
    }

//    public int findKthLargest(int[] nums, int k) {
//        return quickSelect(nums, 0, nums.length - 1, k);
//    }
//
//    public int quickSelect(int[] nums, int start, int end, int k) {
//        if (start >= end) {
//            return nums[start];
//        }
//
//        int left = start;
//        int right = end;
//
//        int pivot = nums[(left + right) / 2];
//        while (left <= right) {
//            while (left <= right && nums[left] > pivot) {
//                left ++;
//            }
//            while (left <= right && nums[right] < pivot) {
//                right --;
//            }
//            if (left <= right) {
//                int temp = nums[left];
//                nums[left] = nums[right];
//                nums[right] = temp;
//                left ++;
//                right --;
//            }
//        }
//        if (start + k - 1 <= right) {
//            return quickSelect(nums, start, right, k);
//        }
//        if (start + k - 1 >= left) {
//            return quickSelect(nums, left, end, k - (left - start));
//        }
//        return nums[right + 1];
//    }

    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        qSort(nums, k - 1);
        System.out.println(Arrays.toString(nums));
        return nums[k - 1];
    }


    private void qSort(int[] nums, int k){
        int start = 0, end = nums.length-1;
        while(start < end){
            int pivot = partition(nums, start, end);
            if(pivot == k) return;
            else if(pivot > k) end = pivot - 1;
            else start = pivot + 1;
        }
    }

    private int partition(int[] nums, int start, int end){
        int pivot = nums[end];
        int pIndex = start;
        System.out.println(Arrays.toString(nums));
        for(int i=start ; i<end ; i++){
            if(pivot <= nums[i]){
                swap(nums, pIndex, i);
                pIndex++;
                System.out.println(Arrays.toString(nums));
            }
        }
        swap(nums, end, pIndex);
        System.out.println(Arrays.toString(nums));
        return pIndex;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void shuffle(int a[]) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }
}

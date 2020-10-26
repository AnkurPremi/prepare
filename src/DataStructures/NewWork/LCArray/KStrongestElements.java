package DataStructures.NewWork.LCArray;

import java.util.Arrays;

public class KStrongestElements {
    public static void main(String[] args) {
        int[] arr = {6,7,11,7,6,8};
        new KStrongestElements().getStrongest(arr, 3);
    }

    public int[] getStrongest(int[] arr, int k) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        int[] count = new int[max - min + 1];
        for (int num : arr) {
            count[num - min]++;
        }
        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[idx++] = i + min;
                count[i]--;
            }
        }

//        Arrays.sort(arr);
        int[] result = new int[k];
        int n = arr.length, l = 0, r = n - 1, m = (n - 1) / 2, writer = 0;
        while (l <= r) {
            if (Math.abs(arr[l] - arr[m]) > Math.abs(arr[r] - arr[m])) {
                result[writer++] = arr[l++];
            } else {
                result[writer++] = arr[r--];
            }
            k--;
            if (k == 0) break;
        }
        return result;
    }

    public int[] getStrongest1(int[] arr , int k){
        int[] result = new int[k];
        int n = arr.length;
        int mIdx = (n-1)/2;
        findMedian(arr, 0, n-1, mIdx);
        int mIdxVal = arr[mIdx];

        return result;
    }

    public void findMedian(int[] arr, int start, int end, int mIdx){
        if(start > end) return;
        int pIdx = qSelect(arr, start, end);
        if(pIdx == mIdx) return;
        else if(pIdx > mIdx)
            findMedian(arr, start, pIdx-1, mIdx);
        else
            findMedian(arr, pIdx+1, end, mIdx);
    }

    public int qSelect(int[] nums, int start, int end){
        int pIdx = start;
        int pivot = nums[end];

        for(int i=start ; i<end ; i++){
            if(nums[i] < pivot){
                int temp = nums[pIdx];
                nums[pIdx] = nums[i];
                nums[i] = temp;
                pIdx++;
            }
        }

        nums[end] = nums[pIdx];
        nums[pIdx] = pivot;
        return pIdx;
    }


}

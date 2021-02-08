package DataStructures.NewWork.LCArray;

import java.util.Arrays;

public class MinimumRemoveToMakeMoutainArray {
    public static void main(String[] args) {
        int[] arr = {100,92,89,77,74,66,64,66,64};
        System.out.println(new MinimumRemoveToMakeMoutainArray().minimumMountainRemovals(arr));
    }

    public int minimumMountainRemovals(int[] nums) {

        int n = nums.length;
        int[] front = new int[n], back = new int[n];

        int[] helper = new int[n];
//        helper[0] = nums[0];
        int size = 0;

        for(int i = 0; i < n; i++) {
            int idx = Arrays.binarySearch(helper, 0, size, nums[i]);
            if(idx < 0) idx = -(idx + 1);
            helper[idx] = nums[i];
            front[i] = idx + 1;
            if(idx == size) size++;
        }

        Arrays.fill(helper, 0);
//        helper[0] = nums[n - 1];
        size = 0;
        for(int i = n - 1; i >= 0; i--) {
            int idx = Arrays.binarySearch(helper, 0, size, nums[i]);
            if(idx < 0) idx = -(idx + 1);
            helper[idx] = nums[i];
            back[i] = idx + 1;
            if(idx == size) size++;
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            res = Math.max(res, front[i] + back[i] - 1);
        }

        return n - res;
    }
}

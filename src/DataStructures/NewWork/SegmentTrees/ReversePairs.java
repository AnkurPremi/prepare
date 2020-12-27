package DataStructures.NewWork.SegmentTrees;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ReversePairs {
    public static void main(String[] args) {
        System.out.println(new ReversePairs().reversePairs(new int[]{2,4,3,5,1}));
    }


    //we can use merge sort
    //and during merging phase we can calculate the count of Reverse Pairs
    public int reversePairs(int[] nums) {
        return mergesort(nums, 0, nums.length - 1);
    }

    private int mergesort(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left)/2;
        int count = mergesort(nums, left, mid) + mergesort(nums, mid + 1, right);

        int[] arr = new int[right - left + 1];
        int k = mid + 1;
        int writer = 0;
        for (int i = left, j = mid + 1; i <= mid; i++)  {
            while (j <= right && nums[i] > (long)2 * nums[j]) j++;
            while (k <= right && nums[k] < nums[i]) arr[writer++] = nums[k++];
            arr[writer++] = nums[i];
            count += j - (mid + 1);
            // j = mid+1;
        }

        while (k <= right) {
            arr[writer++] = nums[k++];
        }
        System.arraycopy(arr, 0, nums, left, right - left + 1);
        return count;
    }

//    public int reversePairs(int[] nums) {
//        if (nums == null) return 0;
//
//        return mergedSort(nums,0, nums.length - 1);
//    }
//
//    private int  mergedSort(int[] nums, int start, int end) {
//        if (start >= end) return 0;
//
//        int mid = start + ((end - start)>>1);
//        //int count = 0;
//        int count = mergedSort(nums, start, mid) + mergedSort(nums, mid + 1, end);
//        int[] cache = new int[end - start + 1];
//        int k = mid + 1, c = 0;
//        for (int i = start, j = mid + 1; i <= mid; i++, c++) {
//            while (j <= end && nums[i] > 2 * (long)nums[j])
//                j++;
//            while (k <= end && nums[k] < nums[i]) cache[c++] = nums[k++];
//            cache[c] = nums[i];
//            count += j - (mid + 1);
//        }
//
//        while (k <= end)
//            cache[c++] = nums[k++];
//        System.arraycopy(cache, 0, nums, start, end - start + 1);
//        // Arrays.sort(nums,start,end+1);
//        return count;
//    }

//    public int reversePairs(int[] nums) {
//
//        int n = nums.length;
//        if (n == 0) return 0;
//        // Mapping -ve integers to positive range - start
//
//        TreeSet<Long> set = new TreeSet<>();
//        for (int num : nums) {
//            long ln = (long) num;
//            set.add(ln);
//            set.add(ln * 2);
//        }
//
//        Map<Long, Integer> map = new HashMap<>();
//        int j = 1;
//        for (Long num : set) {
//            map.put(num, j++);
//        }
//
//        // Mapping -ver integers to positive range - end
//
//        int ans = 0;
//        int[] tree = new int[map.size() + 1];
//        for (int i = nums.length - 1; i >= 0; i--) {
//            long v = (long) nums[i];
//            ans += get(map.get(v) - 1, tree);
//            update(map.get(v * 2), tree);
//        }
//
//        return ans;
//    }
//
//    private int get(int val, int[] tree) {
//        int ans = 0;
//        while (val > 0) {
//            ans += tree[val];
//            val -= val & (-val);
//        }
//        return ans;
//    }
//
//    private void update(int val, int[] tree) {
//        while (val < tree.length) {
//            tree[val]++;
//            val += val & (-val);
//        }
//    }
}

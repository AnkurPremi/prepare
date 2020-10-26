package DataStructures.BinarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionOf2Arrays {
    public static void main(String[] args) {
        int[] arr = {4,9,5};
        int[] arr1 = {9,4,9,8,4};
        arr = new IntersectionOf2Arrays().intersection(arr, arr1);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return intersection(nums2, nums1);
        }
        Arrays.sort(nums1);
        Set<Integer> set = new HashSet<>();
        for (int i : nums2) {
            int val = binarySearch(nums1, i);
            if (val != -1) set.add(val);
        }
        int[] result = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        int j = 0;
        while (it.hasNext()) {
            result[j++] = it.next();
        }
        return result;
    }

    private int binarySearch(int[] arr, int val) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (arr[m] == val)
                return m;
            else if (arr[m] < val)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }
}

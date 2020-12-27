package DataStructures.NewWork.Misc;

import java.util.*;

public class DistributeRepeatingIntegers {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 4, 5, 6, 3, 3, 2, 3};
        int[] quant = {2, 2};
        System.out.println(new DistributeRepeatingIntegers().canDistribute(arr, quant));
    }

    public boolean canDistribute(int[] nums, int[] quantity) {
        // compress the states first
        int[] counts = new int[1001];
        int n = 0;
        for (int i : nums) {
            counts[i]++;
            if (counts[i] == 1) {
                n++;
            }
        }

        nums = new int[n];
        int j = 0;
        for (int i : counts) {
            if (i > 0) {
                nums[j++] = i;
            }
        }

        return distribute(nums, quantity, 0);
    }

    boolean distribute(int[] nums, int[] quantity, int i) {
        int m = quantity.length;
        if (i == m) return true;

        int n = nums.length;
        int q = quantity[i];
        Set<Integer> used = new HashSet<>();
        for (int j = 0; j < n; j++) {
            int k = nums[j];
            if (k < q || used.contains(k)) continue;
            nums[j] -= q;
            used.add(k); // Avoid duplicates. TLE without it.

            if (distribute(nums, quantity, i + 1))
                return true;

            nums[j] += q;
        }

        return false;
    }

}

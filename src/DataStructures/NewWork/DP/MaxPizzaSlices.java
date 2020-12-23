package DataStructures.NewWork.DP;

import java.util.HashSet;
import java.util.Set;

public class MaxPizzaSlices {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(new MaxPizzaSlices().maxSizeSlices(arr));
    }

    int max = 0;
    int n = 0;

    public int maxSizeSlices(int[] slices) {
        Set<Integer> set = new HashSet<>();
        n = slices.length;
        helper(slices, set, 0);
        return max;
    }

    private int helper(int[] slices, Set<Integer> set, int idx) {
        if (idx == n){
            if(set.size() == n) return 0;
            return Integer.MIN_VALUE;
        }

        int sum = 0;
        for (int k = idx; k < n; k++) {
            if (!set.contains(k % n)) {
                set.add(k % n);
                set.add((n - 1 - k) % n);
                set.add((k + 1) % n);
                sum = Math.max(sum, slices[k] + helper(slices, set, k + 1));
                set.remove(k % n);
                set.remove((n - 1 - k) % n);
                set.remove((k + 1) % n);
                sum = Math.max(sum, helper(slices, set, k + 1));
            } else {
                sum = helper(slices, set, k + 1);
            }
            max = Math.max(max, sum);
        }
        return sum;
    }
}

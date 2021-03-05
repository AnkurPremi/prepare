package DataStructures.NewWork.BinarySearch;

import java.util.Random;

public class RandompickByWeight {
    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{2, 3, 5, 1, 8});
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());


    }


}
class Solution {
    private int[] prefixSums;
    private int totalSum;
    Random random;

    public Solution(int[] w) {
        this.prefixSums = new int[w.length];

        int prefixSum = 0;
        for (int i = 0; i < w.length; ++i) {
            prefixSum += w[i];
            this.prefixSums[i] = prefixSum;
        }
        this.totalSum = prefixSum;
        random = new Random();
    }

    public int pickIndex() {
//        double target = this.totalSum * Math.random();
        double target = this.totalSum * random.nextDouble();

        // run a binary search to find the target zone
        int low = 0, high = this.prefixSums.length;
        while (low < high) {
            // better to avoid the overflow
            int mid = low + (high - low) / 2;
            if (target > this.prefixSums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
package DataStructures.NewWork.LCArray;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SumOfSortedSubArraySums {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(new SumOfSortedSubArraySums().rangeSum(arr, 4, 1, 5));
    }

    static class Pair {
        long sum;
        int index;

        Pair(long sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(n, (p1, p2) -> Long.compare(p1.sum, p2.sum));
        for (int i = 0; i < n; i++) {
            minHeap.offer(new Pair(nums[i], i + 1));
        }
        int res = 0, mod = (int) 1e9 + 7;
        for (int i = 1; i <= right; i++) {
            Pair p = minHeap.poll();
            if (i >= left) {
                res = (int) ((res + p.sum) % mod);
            }
            if (p.index < n) {
                p.sum += nums[p.index++];
                minHeap.offer(p);
            }
        }
        return res;
    }
}

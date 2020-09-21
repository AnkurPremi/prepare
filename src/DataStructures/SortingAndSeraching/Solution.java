package DataStructures.SortingAndSeraching;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        rangeSum(arr, arr.length, 1, 5);
    }

    /**
     * We will create a priority Q which will store the object of 'Pair'
     * 'Pair' will contain running sum and the index at which it got this sum
     *
     * @param nums
     * @param n
     * @param left
     * @param right
     * @return
     */
    public static int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>((a, b) -> Long.compare(a.sum, b.sum));

        //initially insert all the elements and their index
        for (int i = 0; i < n; i++) {
            minHeap.offer(new Pair(nums[i], i));
        }
        int result = 0, mod = (int) 1e9 + 7;
        //Start popping the elements from pQ
        for (int i = 0; i < right + 1; i++) {
            Pair p = minHeap.poll();
            //add the sum to the result
            if (i >= left) {
                result = (int) ((result + p.sum) % mod);
            }

            if (p.index < n) {
                p.sum = p.sum + nums[p.index++];
                minHeap.offer(p);
            }
        }
        return result;
    }

    static class Pair {
        long sum;
        int index;

        Pair(long sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
}
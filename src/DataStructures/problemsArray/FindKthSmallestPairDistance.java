package DataStructures.problemsArray;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthSmallestPairDistance {
    public static void main(String[] args) {
        int[] nums = {9,10,7,10,6,1,5,4,9,8};
        int k = 18;
        System.out.println(new FindKthSmallestPairDistance().smallestDistancePair(nums, k));
    }

    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        if (n - 1 < k) k = n-1;
        Arrays.sort(nums);
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(Math.abs(b[0] - b[1]), Math.abs(a[0] - a[1]))
        );

        int i = 0, j = 1;
        while (pq.size() != k) {
            pq.offer(new int[]{nums[i], nums[j]});
            i++;
            j++;
        }
        for (; i < n - 1 && j < n; i++, j++) {
            if (Math.abs(nums[i] - nums[j]) < Math.abs(pq.peek()[0] - pq.peek()[1])) {
                pq.offer(new int[]{nums[i], nums[j]});
                pq.poll();
            }
        }
        int[] result = pq.poll();
        return Math.abs(result[0] - result[1]);
    }
}

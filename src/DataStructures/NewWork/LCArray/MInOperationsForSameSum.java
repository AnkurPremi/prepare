package DataStructures.NewWork.LCArray;

import java.util.PriorityQueue;

public class MInOperationsForSameSum {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6}, nums2 = {1, 1, 2, 2, 2, 2};
        System.out.println(new MInOperationsForSameSum().minOperations(nums1, nums2));
    }

    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length * 6 || nums2.length > nums1.length * 6)
            return -1;
        int sum1 = 0, sum2 = 0, operations = 0;
        for (int i : nums2) sum2 += i;
        for (int i : nums1) sum1 += i;

        if(sum1 == sum2) return 0;

        if (sum1 > sum2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            int tempSum = sum1;
            sum1 = sum2;
            sum2 = tempSum;
        }
        int diff = sum2 - sum1;
        int[] gains_in_large_array = new int[nums2.length];
        int[] gains_in_smaller_array = new int[nums1.length];
        for(int i = 0 ; i < nums2.length ; i++){
            gains_in_large_array[i] = nums2[i] - 1;
        }

        for(int i = 0 ; i < nums1.length ; i++){
            gains_in_smaller_array[i] = 6 - nums1[i];
        }
//
//        int[] finalArray = new int[nums1.length + nums2.length];
//        for(int i = 0 ; i < )

        return 0;
    }
    public int minOperations1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length * 6 || nums2.length > nums1.length * 6)
            return -1;
        int sum1 = 0, sum2 = 0, operations = 0;
        for (int i : nums2) sum2 += i;
        for (int i : nums1) sum1 += i;
        if (sum1 > sum2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            int tempSum = sum1;
            sum1 = sum2;
            sum2 = tempSum;
        }
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(), pq2 = new PriorityQueue<>((x, y) -> y - x);
        for (int i : nums1) pq1.offer(i);
        for (int i : nums2) pq2.offer(i);

        for (; sum1 < sum2; operations++)
            if (pq2.isEmpty() || pq2.peek() - 1 < 6 - pq1.peek())
                sum1 += 6 - pq1.poll();
            else
                sum2 -= pq2.poll() - 1;
        return operations;
    }
}

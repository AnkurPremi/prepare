package DataStructures.NewWork.LCArray;

public class CircularSubArraySum {
    public static void main(String[] args) {
        int[] arr = {5, -7, -2, 10, 5, -2};
        System.out.println(new CircularSubArraySum().maxSubarraySumCircular(arr));
    }

    public int maxSubarraySumCircular(int[] A) {

        int curMax = 0, maxSum = A[0];
        int curMin = 0, minSum = A[0];
        int total = 0;
        //move from left to right
        for (int i = 0; i < A.length; i++) {
            curMax = A[i] + Math.max(curMax, 0);
            maxSum = Math.max(maxSum, curMax);
            curMin = A[i] + Math.min(curMin, 0);
            minSum = Math.min(minSum, curMin);
            total += A[i];
        }

        return maxSum < 0 ? maxSum : Math.max(maxSum, total - minSum);
    }
}

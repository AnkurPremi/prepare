package DataStructures.NewWork.Misc;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q862_ShortestSubArraySumWithNegatives {
    public static void main(String[] args) {
        int[] arr = {2,3,4,-5,6,1,-2,2,-4,7};
        System.out.println(new Q862_ShortestSubArraySumWithNegatives().shortestSubarray(arr, 3));
    }

    public int shortestSubarray(int[] A, int K) {
        int N = A.length, res = N + 1;
        int[] B = new int[N + 1];
        for (int i = 0; i < N; i++) B[i + 1] = B[i] + A[i];
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N + 1; i++) {
            while (d.size() > 0 && B[i] - B[d.getFirst()] >= K)
                res = Math.min(res, i - d.pollFirst());
            while (d.size() > 0 && B[i] <= B[d.getLast()])
                d.pollLast();
            d.addLast(i);
        }
        return res <= N ? res : -1;
    }
}

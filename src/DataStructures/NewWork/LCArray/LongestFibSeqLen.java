package DataStructures.NewWork.LCArray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestFibSeqLen {
    public static void main(String[] args) {
        int[] arr = {2,4,7,8,9,10,14,15,18,23,32,50};
        System.out.println(new LongestFibSeqLen().lenLongestFibSubseq(arr));
    }

    public int lenLongestFibSubseq(int[] A) {
        int N = A.length;
        Set<Integer> S = new HashSet();
        for (int x: A) S.add(x);

        int ans = 0;
        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j) {
                /* With the starting pair (A[i], A[j]),
                 * y represents the future expected value in
                 * the fibonacci subsequence, and x represents
                 * the most current value found. */
                int x = A[j], y = A[i] + A[j];
                int length = 2;
                while (S.contains(y)) {
                    // x, y -> y, x+y
                    int tmp = y;
                    y += x;
                    x = tmp;
                    ans = Math.max(ans, ++length);
                }
            }

        return ans >= 3 ? ans : 0;
    }

    public int lenLongestFibSubseq1(int[] A) {
        int maxL = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }

        for (int i = 0; i < A.length - 2; i++) {
            int len = 2;
            int j = i, k = i + 1;
            while (k < A.length) {
                int sum = A[j] + A[k];
                if(sum > A[A.length-1]) break;
                if (map.containsKey(sum)) {
                    len++;
                    maxL = Math.max(len, maxL);
                    j = k;
                    k = map.get(sum);
                } else {
                    k++;
                    len = 2;
                }
            }
        }
        return maxL;
    }
}

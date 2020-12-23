package DataStructures.NewWork.DP;

import java.util.HashMap;
import java.util.Map;

public class SplitArraySameAverage {
    public static void main(String[] args) {
        int[] arr = {33,86,88,78,21,76,19,20,88,76,10,25,37,97,58,89,65,59,98,57,50,30,58,5,61,72,23,6};
        new Solution().splitArraySameAverage(arr);
    }
}


class Solution {
    public boolean splitArraySameAverage(int[] A) {
        return helper(A, 0, new int[2], new int[2]);
    }

    private boolean helper(int[] A, int i, int[] B, int[] C) {
        if (i == A.length) {
            if (B[1] == 0 || C[1] == 0) return false;
            double avg1 = (B[0] / 1.0) / (B[1] / 1.0);
            double avg2 = (C[0] / 1.0) / (C[1] / 1.0);
            System.out.println("avg1: "+avg1 +"   avg2: "+avg2);
            return avg1 == avg2;
        }

        B[0] += A[i];
        B[1]++;
        boolean canMake = helper(A, i + 1, B, C);
        if (canMake) return true;
        B[0] -= A[i];
        B[1]--;
        C[0] += A[i];
        C[1]++;
        canMake = helper(A, i + 1, B, C);
        C[0] -= A[i];
        C[1]--;
        return canMake;
    }
}
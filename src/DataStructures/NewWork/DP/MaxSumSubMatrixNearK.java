package DataStructures.NewWork.DP;

import java.util.Arrays;
import java.util.TreeSet;

public class MaxSumSubMatrixNearK {
    public static void main(String[] args) {
        int[][] arr = {{2,2,-1}};
        System.out.println(new MaxSumSubMatrixNearK().maxSumSubmatrix(arr, -1));
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        int[] arr = new int[m];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr, 0);

            for (int j = i; j < n; j++) {
                for (int q = 0; q < m; q++) {
                    arr[q] += matrix[q][j];
                }
                ans = justMinSumK(set, arr, k, ans);
                set.clear();
                set.add(0);
            }
        }
        return ans;
    }

    private int justMinSumK(TreeSet<Integer> set, int[] arr, int k, int min) {
        int sum = 0;
        for (int num : arr) {
            sum += num;

            Integer val = set.ceiling(sum - k);
            if (val != null) {
                min = Math.max(min, sum - val);
            }
            set.add(sum);
        }
        return min;
    }
}

package DataStructures.NewWork.LCArray;

import DataStructures.strings.EditDistance;

public class MaxSideLengthOfSquare {
    public static void main(String[] args) {
        int[][] grid = {
                {1,1,3,2,4},
                {1,1,3,2,4},
                {1,1,3,2,4}
        };
        new MaxSideLengthOfSquare().maxSideLength(grid, 4);
    }


    int m, n;

    public int maxSideLength(int[][] mat, int threshold) {
        m = mat.length;
        n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
//                EditDistance.printMatrix(sum);
//                System.out.println("\n------------------");
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
                EditDistance.printMatrix(sum);
                System.out.println("\n------------------");
            }
        }

        int lo = 0, hi = Math.min(m, n);

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isSquareExist(sum, threshold, mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi;
    }


    private boolean isSquareExist(int[][] sum, int threshold, int len) {
        for (int i = len; i <= m; i++) {
            for (int j = len; j <= n; j++) {
                if (sum[i][j] - sum[i - len][j] - sum[i][j - len] + sum[i - len][j - len] <= threshold) return true;
            }
        }
        return false;
    }
}

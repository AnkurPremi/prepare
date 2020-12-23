package DataStructures.NewWork.DP;

public class Largest1BorderedSquare {
    public static void main(String[] args) {
        int[][] grid = {
                {0,1,0,1,1},
                {1,1,1,1,1},
                {1,1,0,1,1},
                {1,1,1,1,0},
                {0,1,1,1,1},
                {1,1,1,0,1},
                {0,1,1,1,1},
                {1,1,1,0,1}
        };
        System.out.println(new Largest1BorderedSquare().largest1BorderedSquare(grid));
    }

    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][2];
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    dp[i][j][0] = j - 1 >= 0 ? dp[i][j - 1][0] + 1 : 1;
                    dp[i][j][1] = i - 1 >= 0 ? dp[i - 1][j][1] + 1 : 1;
                }

                int len = Math.min(dp[i][j][0], dp[i][j][1]);

                for (int k = len; k > max; --k) {
                    int rowVal = j - k + 1 >= 0 ? dp[i][j - k + 1][1] : 1;
                    int colVal = i - k + 1 >= 0 ? dp[i - k + 1][j][0] : 1;

                    if (rowVal >= len && colVal >= len) {
                        max = Math.max(max, len);
                    }

                }
            }
        }

        return max * max;
    }
}

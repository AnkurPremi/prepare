package DataStructures.DP;

public class Largest1BorderedSquare {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
        };
        System.out.println(new Largest1BorderedSquare().largest1BorderedSquare(grid));
    }

    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][2];
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    if (grid[i][j] == 0) {
                        dp[i][j] = new int[]{0, 0};
                    } else {
                        if (i == 0 && j == 0) {
                            dp[i][j] = new int[]{1, 1};
                        } else if (i == 0) {
                            //left,top
                            dp[0][j] = new int[]{dp[0][j - 1][0] + 1, 1};
                        } else if (j == 0) {
                            dp[i][0] = new int[]{1, dp[i - 1][0][1] + 1};
                        }
                    }
                } else {
                    if (grid[i][j] == 0) {
                        dp[i][j] = new int[]{0, 0};
                    } else if (grid[i - 1][j] == 0 || grid[i][j - 1] == 0) {
                        dp[i][j] = new int[]{dp[i][j - 1][0] + 1, dp[i - 1][j][1] + 1};
                    } else {
                        boolean t = false;
                        boolean l = false;
                        int top = dp[i - 1][j][1];
                        int left = dp[i][j - 1][0];
                        if (top >= i && left >= j) {
                            if (dp[i - top][j][0] <= left + 1) {
                                t = true;
                            }
                            if (dp[i][j - left][1] <= top + 1) {
                                l = true;
                            }
                        }
                        if (t && l) {
                            dp[i][j] = new int[]{left + 1, top + 1};
                            max = Math.max(max, (top + 1) * (left + 1));
                            System.out.println("Max: " + max);
                        } else {
                            dp[i][j] = new int[]{dp[i][j - 1][0] + 1, dp[i - 1][j][1] + 1};
                        }
                    }
                }
            }
        }
        return max;
    }
}

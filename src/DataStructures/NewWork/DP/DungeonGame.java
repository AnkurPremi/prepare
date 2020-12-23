package DataStructures.NewWork.DP;

public class DungeonGame {
    public static void main(String[] args) {
        int[][] grid = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5},
        };
        System.out.println(new DungeonGame().calculateMinimumHP(grid));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;

        int[][] dp = new int[m+1][n+1];
        int min = Integer.MAX_VALUE;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (i == 0) {
                    dp[i][j] = -1 * dungeon[i][j] + dp[i][j + 1];
                } else if (j == 0) {
                    dp[i][j] = -1 * dungeon[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = -1 * dungeon[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][0] + 1;
    }
}

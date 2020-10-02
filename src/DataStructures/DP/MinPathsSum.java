package DataStructures.DP;

public class MinPathsSum {
    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(new MinPathsSum().minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n ; j++){
                dp[i][j] = -1;
            }
        }
        int[] min = {Integer.MAX_VALUE};
        minPathSum(grid, 0, 0, min, 0, dp);
        return min[0];
    }

    public int minPathSum(int[][] grid, int i, int j, int[] min, int sum, int[][] dp) {
        if(i == grid.length-1 && j == grid[0].length-1){
            min[0] = Math.min(min[0], sum + grid[i][j]);
            return sum + grid[i][j];
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int down = i<grid.length-1 ? minPathSum(grid, i+1, j, min, sum + grid[i][j], dp) : 0;
        int right = j < grid[0].length-1 ? minPathSum(grid, i, j+1, min, sum + grid[i][j], dp) : 0;

        dp[i][j] = Math.min(down, right);
        return dp[i][j];
    }
}

package Arrays;

//https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new MinimumPathSum().minPathSum(matrix));
    }

    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //if i=0 and j!=0 .. means we can only come from left
                if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                }
                //if j=0 and i!=0 .. means we can only come from top
                else if (j == 0 && i != 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else if (i == 0 && j == 0) {
                    continue;
                }
                //else check the minimum of two - coming to this point from top or coming to this point from left
                else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}

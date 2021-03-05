package DataStructures.NewWork.LCArray;

public class LongestIncreasingPathInmatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {9,9,4},
                {6,6,8},
                {2,1,1}};
        System.out.println(new LongestIncreasingPathInmatrix().longestIncreasingPath(matrix));
    }

    int[][] cache;
    public int longestIncreasingPath(int[][] grid) {
        int max = 0;
        cache = new int[grid.length + 1][grid[0].length + 1];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                max = Math.max(max, findMaxPath(grid, i, j));
            }
        }
        return max;
    }

    private int findMaxPath(int[][] grid, int i, int j){
        if(grid[i][j] == -1) return 0;
        if(cache[i][j] > 0) return cache[i][j];
        int maxHere = 1;
        int valHere = grid[i][j];
        grid[i][j] = -1;

        if(i > 0 && grid[i - 1][j] > valHere){
            maxHere = 1 + findMaxPath(grid, i - 1, j);
        }

        if(j > 0 && grid[i][j - 1] > valHere){
            maxHere = Math.max(maxHere, 1 + findMaxPath(grid, i, j - 1));
        }

        if(i < grid.length - 1 && grid[i + 1][j] > valHere){
            maxHere = Math.max(maxHere, 1 + findMaxPath(grid, i + 1, j));
        }

        if(j < grid[0].length - 1 && grid[i][j + 1] > valHere){
            maxHere = Math.max(maxHere, 1 + findMaxPath(grid, i, j + 1));
        }

        grid[i][j] = valHere;

        return cache[i][j] = maxHere;
    }
}

package DataStructures.problemsArray;

public class UniquePaths3 {
    public static void main(String[] args) {
        int[][] grid = {
                {1,0,0,0},
                {0,0,0,0},
                {0,0,2,-1}
        };
        System.out.println(new UniquePaths3().uniquePathsIII(grid));
    }

    public int uniquePathsIII(int[][] grid) {
        int count = 1, startX = 0, startY = 0;
        for(int i=0; i< grid.length ; i++){
            for(int j=0; j < grid[0].length ; j++){
                if(grid[i][j] == 0) count++;
                else if(grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }

        int[] sum = {0};

        helper(grid, sum, startX, startY, count);
        return sum[0];
    }


    public void helper(int[][] grid, int[] sum, int x, int y, int zCnt) {
        if(grid[x][y] == -1 || grid[x][y] == 3) return;
        if(grid[x][y] == 2) {
            if(zCnt == 0) sum[0]++;
            return;
        }

        grid[x][y] = 3;

        if(x > 0) helper(grid, sum, x-1, y, zCnt - 1);
        if(y > 0) helper(grid, sum, x, y-1, zCnt - 1);
        if(x < grid.length-1) helper(grid, sum, x+1, y, zCnt - 1);
        if(y < grid[0].length-1) helper(grid, sum, x, y+1, zCnt - 1);

        grid[x][y] = 0;
    }
}

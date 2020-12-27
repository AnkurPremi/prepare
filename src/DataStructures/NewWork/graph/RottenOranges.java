package DataStructures.NewWork.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(new RottenOranges().orangesRotting(grid));
    }

    //DFS bad idea...because in BFS at every depth ... we add a minute
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Queue<int[]> queue = new LinkedList();
        int freshCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;

        int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        int mins = 0;
        while (!queue.isEmpty()) {
            mins++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                for (int[] d : dir) {
                    int r = arr[0] + d[0];
                    int c = arr[1] + d[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && !(grid[r][c] == 0 || grid[r][c] == 2)) {
                        grid[r][c] = 2;
                        freshCount--;
                        queue.offer(new int[]{r, c});
                    }
                }
            }
        }

        return freshCount == 0 ? mins - 1 : -1; // -1 from mins because initially we are adding mins for cell value = 2 in the queue
    }
//    public int orangesRotting(int[][] grid) {
//        int x = -1, y = -1;
//        int freshCount = 0;
//        for(int i=0 ; i<grid.length ; i++){
//            for(int j=0 ; j<grid[0].length ; j++){
//                if(grid[i][j] == 2){
//                    x = i;
//                    y = j;
//                } else if(grid[i][j] == 1){
//                    freshCount++;
//                }
//            }
//        }
//
//        if(freshCount == 0) return 0;
//
//        int[] count = {freshCount};
//        int[] max = {Integer.MAX_VALUE};
//        dfs(grid, x, y, count, 0, max, 0);
//        if(count[0] == freshCount){
//            return max[0];
//        }
//        return -1;
//    }
//
//    private void dfs(int[][] grid, int r, int c, int[] val, int time, int[] maxTime, int count){
//        if(grid[r][c] == 0 || grid[r][c] == 4) return;
//
//        if(val[0] == count){
//            maxTime[0] = Math.min(time, maxTime[0]);
//            return;
//        }
//        int u = grid[r][c];
//        grid[r][c] = 4;
//
//        if(r > 0 && grid[r-1][c] == 1){
//            dfs(grid, r-1, c, val, time + 1, maxTime, count + 1);
//        }
//
//        if(c > 0 && grid[r][c-1] == 1){
//            dfs(grid, r, c-1, val, time + 1, maxTime, count + 1);
//        }
//
//        if(r < grid.length-1 && grid[r+1][c] == 1){
//            dfs(grid, r+1, c, val, time + 1, maxTime, count + 1);
//        }
//
//
//        if(c < grid[0].length-1 && grid[r][c+1] == 1){
//            dfs(grid, r, c+1, val, time + 1, maxTime, count + 1);
//        }
//
//        grid[r][c] = u;
//
//    }
}

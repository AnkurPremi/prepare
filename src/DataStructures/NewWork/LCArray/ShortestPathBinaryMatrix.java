package DataStructures.NewWork.LCArray;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}};
        System.out.println(new ShortestPathBinaryMatrix().shortestPathBinaryMatrix(grid));
    }


    int[] dirX = {-1, 0, 1};
    int[] dirY = {-1, 0, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;

        int shortestPath = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                size--;
                int[] location = queue.poll();
                for (int dx : dirX) {
                    for (int dy : dirY) {
                        if (dx == 0 && dy == 0) continue;

                        int x = dx + location[0];
                        int y = dy + location[1];

                        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 0) continue;

                        if (x == m - 1 && y == n - 1) return shortestPath + 1;
                        grid[x][y] = 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            shortestPath++;
        }
        return -1;
    }
}

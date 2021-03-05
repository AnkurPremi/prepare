package DataStructures.NewWork.BFS;

import java.util.PriorityQueue;

public class SwimWater {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}};
        System.out.println(new SwimWater().swimInWater(grid));
    }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//    int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[n][n];

        pq.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int i = cur[0], j = cur[1], max = cur[2];

            for (int[] dir : directions) {
                int x = dir[0] + i;
                int y = dir[1] + j;

                if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y]) continue;
                max = Math.max(max, grid[x][y]);

                if (x == n - 1 && y == n - 1) return max;

                visited[x][y] = true;
                pq.offer(new int[]{x, y, max});
            }
        }

        return -1;
    }
}

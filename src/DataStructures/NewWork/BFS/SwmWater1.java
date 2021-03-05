package DataStructures.NewWork.BFS;

import java.util.PriorityQueue;

public class SwmWater1 {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}};
        System.out.println(new SwmWater1().swimInWater(grid));
    }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//    int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });

        pq.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int i = cur[0], j = cur[1], max = cur[2];

            for (int[] dir : directions) {
                int x = dir[0] + i;
                int y = dir[1] + j;

                if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y]) continue;
                visited[x][y] = true;
                int newMax = Math.max(max, grid[x][y]);

                if (x == n - 1 && y == n - 1) return max;

                pq.offer(new int[]{x, y, newMax});
            }
        }

        return -1;
    }
}

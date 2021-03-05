package DataStructures.NewWork.LCArray;

import java.util.LinkedList;
import java.util.Queue;

public class HighestPeak {
    public static void main(String[] args) {
        int[][] ewater = {{0, 1},
                {0, 0}};
        System.out.println(new HighestPeak().highestPeak(ewater));
    }

    public int[][] highestPeak(int[][] water) {
        int m = water.length, n = water[0].length;

        Queue<int[]> queue = new LinkedList();

        int[][] distance = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (water[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    distance[i][j] = -1;
                    doBFS(queue, new boolean[m][n], distance);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (distance[i][j] == -1) {
                    distance[i][j] = 0;
                }
            }
        }
        return distance;

    }

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private void doBFS(Queue<int[]> queue, boolean[][] visited, int[][] distance) {
        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                size--;

                int[] point = queue.poll();

                int i = point[0], j = point[1];
                for (int[] dir : directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x < 0 || y < 0 || x >= distance.length || y >= distance[0].length || distance[x][y] == -1 || visited[x][y])
                        continue;

                    visited[x][y] = true;
                    if (distance[x][y] != 0 && Math.abs(distance[x][y] - dist) > 1) {
                        distance[x][y] = Math.min(distance[x][y], dist);
                    } else {
                        distance[x][y] = dist;
                    }
                    queue.offer(new int[]{x, y});
                }
            }
            dist++;
        }
    }
}

package DataStructures.NewWork.graph;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze2 {
    public static void main(String[] args) {
        int[][] maz = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0, 4}, end = {4, 4};
        System.out.println(new TheMaze2().shortestDistance(maz, start, end));
    }

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        Queue<Vertex> q = new LinkedList();
        boolean[][] visited = new boolean[m][n];
        int s1 = start[0], s2 = start[1];
        visited[s1][s2] = true;

        for (int[] dir : directions) {
            int x = dir[0] + s1;
            int y = dir[1] + s2;

            if (x < 0 || y < 0 || x >= m || y >= n) continue;
            visited[x][y] = true;
            q.offer(new Vertex(x, y, dir, 1));
        }

        while (!q.isEmpty()) {
            int size = q.size();

            while (size > 0) {
                size--;

                Vertex curr = q.poll();
                if (curr.row == destination[0] && destination[1] == curr.col) return curr.dist;

                int i = curr.row + curr.dir[0], j = curr.col + curr.dir[1];
                if (i < 0 || j < 0 || i >= m || j >= n || (!visited[i][j] && maze[i][j] == 1)) {
                    for (int[] dir : directions) {
                        int x = curr.row + dir[0];
                        int y = curr.col + dir[1];

                        if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || maze[x][y] == 1) continue;

                        visited[x][y] = true;
                        q.offer(new Vertex(x, y, dir, curr.dist + 1));
                    }
                } else if (!visited[i][j]) {
                    visited[i][j] = true;
                    q.offer(new Vertex(i, j, curr.dir, curr.dist + 1));
                }
            }
        }
        return -1;

    }

    class Vertex {
        int row, col, dist;
        int[] dir;

        Vertex(int r, int c, int[] d, int dis) {
            row = r;
            col = c;
            dir = d;
            dist = dis;
        }
    }

}

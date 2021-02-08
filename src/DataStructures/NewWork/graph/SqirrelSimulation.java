package DataStructures.NewWork.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SqirrelSimulation {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        SQ sq = new SQ();
        int h = 5;
        int w = 5;
                int[] tree = {3,2};
        int[] squ = {0,1};
        int[][] nuts = {{2,0},
                {4,1},
                {0,4},
                {1,3},
                {1,0},
                {3,4},
                {3,0},
                {2,3},
                {0,2},
                {0,0},
                {2,2},
                {4,2},
                {3,3},
                {4,4},
                {4,0},
                {4,3},
                {3,1},
                {2,1},
                {1,4},
                {2,4}};
        sq.minDistance(h, w, tree, squ, nuts);
    }
}


class SQ {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int[][] grid = new int[height][width];

        int count = nuts.length;

        for (int[] nut : nuts) {
            grid[nut[0]][nut[1]] = -1;
        }
        grid[tree[0]][tree[1]] = -3;

        Queue<int[]> queue = new LinkedList();
        queue.offer(tree);
        Map<Integer, Integer> nutsDist = doBFS(queue, count, grid, true, -1, -3);

        queue = new LinkedList();
        queue.offer(squirrel);
        grid[squirrel[0]][squirrel[1]] = -1;
        grid[tree[0]][tree[1]] = 0;

        Map<Integer, Integer> sqDist = doBFS(queue, 0, grid, false, -3, -1);

        int ans = 0;
        boolean added = false;
        for (int[] nut : nuts) {
            int val = 10000 * nut[0] + nut[1];
            if (!added && sqDist.containsKey(val)) {
                ans += sqDist.get(val);
                ans += nutsDist.get(val);
                added = true;
            } else {
                ans += nutsDist.get(val) * 2;
            }
        }

        return ans;
    }

    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private Map<Integer, Integer> doBFS(Queue<int[]> queue, int count, int[][] grid, boolean treePath, int find, int replace) {
        int distance = 0;
        Map<Integer, Integer> map = new HashMap();

        while (!queue.isEmpty()) {
            int size = queue.size();
            distance += 1;
            while (size > 0) {
                size--;
                int[] point = queue.poll();

                for (int[] dir : directions) {
                    int r = dir[0] + point[0];
                    int c = dir[1] + point[1];

                    if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == replace) {
                        continue;
                    }


                    if (grid[r][c] == find) {
                        count--;
                        map.put(10000 * r + c, distance);
                        if (!treePath) return map;
                        grid[r][c] = replace;
                        if (count == 0) return map;
                    }

                    queue.offer(new int[]{r, c});

                }
            }
        }
        return map;
    }


}
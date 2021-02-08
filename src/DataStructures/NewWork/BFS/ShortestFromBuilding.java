package DataStructures.NewWork.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestFromBuilding {
    public static void main(String[] args) {
        int[][] grid = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        System.out.println(new ShortestFromBuilding().shortestDistance(grid));
    }

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestDistance(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        Queue<int[]> queue = new LinkedList();
        int[][] distance = new int[m][n];
        int[][] buildingsCount = new int[m][n];
        int count = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){

                if(grid[i][j] == 1){
                    count++;
                    queue.offer(new int[]{i, j});
                    grid[i][j] = -1;
                    distance[i][j] = -1;
                    doBFS(queue, grid, distance, buildingsCount);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] != -1 && distance[i][j] != 0 && buildingsCount[i][j] == count){
                    min = Math.min(min, distance[i][j]);
                }
            }
        }

        return min;
    }

    private void doBFS(Queue<int[]> queue, int[][] grid, int[][] distances, int[][] buildingsCount){

        int m = grid.length, n = grid[0].length;
        int distance = 0;

        boolean[][] visited = new boolean[m][n];

        while(!queue.isEmpty()){
            int size = queue.size();
            distance += 1;

            while(size > 0){
                size--;
                int[] point = queue.poll();

                int row = point[0], col = point[1];

                for(int[] dir : directions){
                    int r = dir[0] + row;
                    int c = dir[1] + col;

                    if(isNotValid(grid, r, c) || visited[r][c]) continue;

                    visited[r][c] = true;
                    distances[r][c] += distance;
                    buildingsCount[r][c]++;
                    queue.offer(new int[]{r, c});
                }
            }
        }
    }

    private boolean isNotValid(int[][] grid, int r, int c){
        return r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 0;
    }

//    private final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//
//    public int shortestDistance(int[][] grid) {
//        int m = grid.length, n = grid[0].length;
//        List<int[]> buildings = new ArrayList();
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == 1)
//                    buildings.add(new int[]{i, j});
//            }
//        }
//
//        int[][] paths = new int[m][n];
//        int[][] canBeReached = new int[m][n];
//        int buildingCount = 0;
//
//        for (int[] building : buildings) {
//            int distance = 0;
//            buildingCount++;
//            Queue<int[]> queue = new LinkedList();
//            queue.offer(building);
//            boolean[][] visited = new boolean[m][n];
//            while (!queue.isEmpty()) {
//                distance++;
//                int size = queue.size();
//                for(int i = 0 ; i < size ; i++) {
//                    int[] point = queue.poll();
//                    int row = point[0], col = point[1];
//
//                    for (int[] dir : directions) {
//                        int r = row + dir[0];
//                        int c = col + dir[1];
//                        if (r < 0 || c < 0 || r > m - 1 || c > n - 1 || grid[r][c] != 0 || visited[r][c]) {
//                            continue;
//                        }
//                        visited[r][c] = true;
//                        canBeReached[r][c] = buildingCount;
//                        queue.offer(new int[]{r, c});
//                        paths[r][c] += distance;
//                    }
//                }
//            }
//        }
//
//        int ans = Integer.MAX_VALUE;
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (paths[i][j] != 0 && canBeReached[i][j] == buildings.size()) {
//                    ans = Math.min(ans, paths[i][j]);
//                }
//            }
//        }
//
//        return ans;
//    }

}



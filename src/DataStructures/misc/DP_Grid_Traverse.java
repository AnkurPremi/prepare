package DataStructures.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DP_Grid_Traverse {
    static boolean foundPath = false;

    public static void main(String[] args) {
        Integer[][] grid = {
                {0, null, 0, 0, 0},
                {0, 0, null, 0, 0},
                {0, null, 0, 0, 0},
                {0, 0, null, 0, 0},
                {null, 0, 0, 0, 0},
                {0, 0, null, 0, 0}
        };
        int[][] paths = new int[grid.length][grid[0].length];
        int count = traverse(grid, 0, 0);
        System.out.println(count);
        count = traverse(grid, 0, 0, paths);
        System.out.println(count);

        List<Point> pathsList = new ArrayList<>();
        Set<Point> failedPoints = new HashSet<>();
        if (findPath(grid, grid.length - 1, grid[0].length - 1, pathsList)) {
            System.out.println(pathsList.size());
            System.out.println("sdasd");
        }
        if (findPath(grid, grid.length - 1, grid[0].length - 1, pathsList, failedPoints)) {
            System.out.println(pathsList.size());
            System.out.println("rwerwe");
        }
    }

    static int traverse(Integer[][] grid, int row, int col) {
        if (isValid(grid, row, col)) {
            if (row == grid.length - 1 && col == grid[row].length - 1) return 1;
            else return traverse(grid, row + 1, col) + traverse(grid, row, col + 1);
        }
        return 0;
    }

    static int traverse(Integer[][] grid, int row, int col, int[][] paths) {
        if (isValid(grid, row, col)) {
            if (row == grid.length - 1 && col == grid[row].length - 1) return 1;
            else if (paths[row][col] == 0) {
                paths[row][col] = traverse(grid, row + 1, col) + traverse(grid, row, col + 1);
            }
        }
        return paths[row][col];
    }

    static boolean findPath(Integer[][] grid, int row, int col, List<Point> paths) {
        if (!isValid(grid, row, col)) return false;
        boolean isAtOrigin = (row == 0) && (col == 0);
        if (isAtOrigin || findPath(grid, row - 1, col, paths) || findPath(grid, row, col - 1, paths)) {
            paths.add(new Point(row, col));
            return true;
        }
        return false;
    }

    static boolean findPath(Integer[][] grid, int row, int col, List<Point> paths, Set<Point> failedPoints) {
        if (!isValid(grid, row, col)) return false;
        Point p = new Point(row, col);
        if (failedPoints.contains(p)) return false;
        boolean isAtOrigin = (row == 0) && (col == 0);
        if (isAtOrigin || findPath(grid, row - 1, col, paths, failedPoints) || findPath(grid, row, col - 1, paths, failedPoints)) {
            paths.add(p);
            return true;
        }
        failedPoints.add(p);
        return false;
    }


    static boolean isValid(Integer[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] != null;
    }
}

class Point {
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
package DataStructures.BinarySearch;

public class FindNegativesInGrid {
    public static void main(String[] args) {
        int[][] grid = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        System.out.println(new FindNegativesInGrid().countNegatives(grid));
    }

    public int countNegatives(int[][] grid) {
        int x = 0;
        int y = grid[0].length - 1;
        int w = y;
        int count = 0;
        while (x < grid.length) {
            while (y >= 0) {
                if (grid[x][y] > 0)
                    break;
                y--;
            }
            count += (w - y);
            x++;
        }
        return count;
    }
}

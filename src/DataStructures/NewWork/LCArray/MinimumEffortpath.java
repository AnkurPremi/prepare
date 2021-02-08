package DataStructures.NewWork.LCArray;

public class MinimumEffortpath {
    public static void main(String[] args) {
        int[][] heights = {
                        {1,2,1,1,1},
                        {1,2,1,2,1},
                        {1,2,1,2,1},
                        {1,2,1,2,1},
                        {1,1,1,2,1}
        };
        System.out.println(new MinimumEffortpath().minimumEffortPath(heights));
    }

    Integer[][] cache;
    public int minimumEffortPath(int[][] heights) {
        int[] ans = {Integer.MAX_VALUE};
        int m = heights.length, n = heights[0].length;
        cache = new Integer[m + 1][n + 1];
        findMinEffortPath(heights, m - 1, n - 1, ans, 0);
        return ans[0];
    }

    private int findMinEffortPath(int[][] heights, int i, int j, int[] min, int effort) {

        if (i == 0 && j == 0) {
//            min[0] = Math.min(effort, min[0]);
            return 0;
        }
        if(cache[i][j] != null) return cache[i][j];

        int temp = heights[i][j];
        heights[i][j] = 0;

        if (i > 0) {
            int minEffort = Math.max(effort, Math.abs(temp - heights[i - 1][j]));
            if ((min[0] == 0 && heights[i - 1][j] != 0 ) || (min[0] >= minEffort && heights[i - 1][j] != 0)) {
                min[0]  = Math.min(minEffort, findMinEffortPath(heights, i - 1, j, min, minEffort));
            }
        }

        if (j > 0) {
            int minEffort = Math.max(effort, Math.abs(temp - heights[i][j - 1]));
            if ((min[0] == 0 && heights[i][j - 1] != 0 ) ||  (min[0] >= minEffort && heights[i][j - 1] != 0)) {
                min[0]  = Math.min(minEffort, findMinEffortPath(heights, i, j - 1, min, minEffort));
            }
        }

        if (i < heights.length - 1) {
            int minEffort = Math.max(effort, Math.abs(temp - heights[i + 1][j]));
            if ((min[0] == 0 && heights[i + 1][j] != 0 ) ||  (min[0] >= minEffort && heights[i + 1][j] != 0)) {
                min[0]  = Math.min(minEffort, findMinEffortPath(heights, i + 1, j, min, minEffort));
            }
        }

        if (j < heights[0].length - 1) {
            int minEffort = Math.max(effort, Math.abs(temp - heights[i][j + 1]));
            if ((min[0] == 0 && heights[i][j + 1] != 0 ) ||  (min[0] >= minEffort && heights[i][j + 1] != 0)) {
                min[0]  = Math.min(minEffort, findMinEffortPath(heights, i, j + 1, min, minEffort));
            }
        }

        heights[i][j] = temp;

        cache[i][j] = effort;

        return effort;
    }
}

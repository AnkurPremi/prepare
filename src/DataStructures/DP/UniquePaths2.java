package DataStructures.DP;

public class UniquePaths2 {
    public static void main(String[] args) {
        int[][] obstacle = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int totalPaths = uniquePathsWithObstacles(obstacle);
        System.out.println(totalPaths);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        Integer[][] lookup = new Integer[m + 1][n + 1];
        return helper(obstacleGrid, 0, 0, lookup);
    }

    public static int helper(int[][] obstacleGrid, int m, int n, Integer[][] lookup) {
        if (!isValid(obstacleGrid, m, n)) return 0;
        if (isAtEnd(obstacleGrid, m, n)) return 1;
        if (lookup[m][n] != null) {
            return lookup[m][n];
        } else {
            lookup[m][n] = helper(obstacleGrid, m + 1, n, lookup) + helper(obstacleGrid, m, n + 1, lookup);
            return lookup[m][n];
        }
    }

    static boolean isValid(int[][] obstacleGrid, int m, int n) {
        return m >= 0 && n >= 0 && m < obstacleGrid.length && n < obstacleGrid[0].length && obstacleGrid[m][n] != 1;
    }

    static boolean isAtEnd(int[][] arr, int m, int n) {
        return (m == arr.length-1) && (n == arr[0].length-1);
    }
}

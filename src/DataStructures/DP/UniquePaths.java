package DataStructures.DP;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 7, n = 3;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        int[][] path = new int[m + 1][n + 1];
        Integer[][] lookup = new Integer[m + 1][n + 1];
        return helper(path, m, n, lookup);
    }

    static int helper(int[][] arr, int row, int col, Integer[][] lookup) {
        if (!isBound(arr, row, col)) return 0;
        if (row == 1 || col == 1) return 1;
        if (lookup[row][col] != null) {
            return lookup[row][col];
        } else {
            lookup[row][col] = helper(arr, row - 1, col, lookup) + helper(arr, row, col - 1, lookup);
        }
        return lookup[row][col];
    }

    static boolean isBound(int[][] arr, int m, int n) {
        return m >= 0 && m < arr.length && n >= 0 && n < arr[m].length;
    }

    static boolean isAtEnd(int[][] arr, int m, int n) {
        return (m == arr.length) && (n == arr[m].length);
    }
}

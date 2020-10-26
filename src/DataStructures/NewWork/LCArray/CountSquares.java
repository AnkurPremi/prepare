package DataStructures.NewWork.LCArray;

import DataStructures.DP.CountBits;

public class CountSquares {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 1}
        };
        System.out.println(new CountSquares().countSquares(grid));
    }

    public int countSquares(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    if (matrix[i][j] == 1) count++;
                } else if (matrix[i][j] == 1) {
                    int min = Math.min(matrix[i - 1][j], Math.min(matrix[i][j - 1], matrix[i - 1][j - 1]));
                    count += min + 1;
                    matrix[i][j] = min + 1;
                }
//                else {
//                    matrix[i][j] = matrix[i - 1][j - 1];
//                }
            }
        }
        return count;
    }
}

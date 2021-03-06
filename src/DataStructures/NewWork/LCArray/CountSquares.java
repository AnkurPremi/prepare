package DataStructures.NewWork.LCArray;

import DataStructures.DP.CountBits;

import java.util.Collections;

public class CountSquares {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 1}
        };
        char[][] grid1 = {
                {'0', '1', '1', '1'},
                {'1', '1', '0', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}
        };
//        System.out.println(new CountSquares().countSquares(grid));
        System.out.println(new CountSquares().maximalSquare(grid1));
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

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int max = 0;
        int[][] matrix2 = new int[m][n];
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ;j++){
                matrix2[i][j] = matrix[i][j] - '0';
                if(i == 0 || j == 0){
                    max = Math.max(max, matrix2[i][j]);
                } else if(matrix2[i][j] == 1){
                    int val = Math.min(matrix2[i-1][j], Math.min(matrix2[i][j-1], matrix2[i-1][j-1]));
                    matrix2[i][j] = val + 1;
                    max = Math.max(val+1, max);
                }
            }
        }
        return max * max;
    }
}

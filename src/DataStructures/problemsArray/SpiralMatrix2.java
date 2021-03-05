package DataStructures.problemsArray;

import DataStructures.strings.EditDistance;

//https://leetcode.com/problems/spiral-matrix-ii/
public class SpiralMatrix2 {
    public static void main(String[] args) {
        int num = 4;
        System.out.println(Integer.MAX_VALUE);
        EditDistance.printMatrix(new SpiralMatrix2().generateMatrix(num));
    }

    public int[][] generateMatrix(int n) {
        if(n == 0) return new int[0][0];
        if(n == 1) {
         int[][] result=new int[1][1];
         result[1][1] = 1;
         return result;
        }
        int[][] matrix = new int[n][n];
        int rowStart = 0, colStart = 0;
        int rowEnd = matrix.length - 1, colEnd = matrix[rowStart].length - 1;
        int startVal = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            //Move right
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = startVal++;
            }
            rowStart++;

            //Move down
            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = startVal++;
            }
            colEnd--;

            //Move left
            if(rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    matrix[rowEnd][i]= startVal++;
                }
                rowEnd--;
            }

            //Move up
            if(colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    matrix[i][colStart]= startVal++;
                }
                colStart++;
            }
        }

        return matrix;
    }
}

package DataStructures.problemsArray;

import DataStructures.strings.EditDistance;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/set-matrix-zeroes/
//https://leetcode.com/problems/set-matrix-zeroes/discuss/26014/Any-shorter-O(1)-space-solution
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {3,9,4,6,2,4,0,1,7},
                {1,9,7,3,7,0,2,0,7},
                {1,8,9,9,4,6,1,1,8},
                {6,2,4,4,5,3,0,4,7},
                {4,6,9,3,7,8,1,3,7},
                {3,5,7,0,8,7,0,7,1},
                {6,0,2,4,8,7,0,2,2}}
                ;
        new SetMatrixZeroes().setZeroes(matrix);
        EditDistance.printMatrix(matrix);
    }

    public void setZeroes(int[][] matrix) {
        List<Integer> avoidRows = new ArrayList<>();
        List<Integer> avoidCols = new ArrayList<>();
        for(int i=0 ; i< matrix.length ;i++){
            for(int j=0 ; j< matrix[i].length ;j++){
                if(matrix[i][j] == 0){
                    if(avoidRows.contains(i) || avoidCols.contains(j)) continue;
                    markZero(matrix, i, j, avoidRows, avoidCols);
                }
            }
        }
    }

    public void markZero(int[][] grid, int row, int col, List<Integer> avoidRows, List<Integer> avoidCols){

        EditDistance.printMatrix(grid);
        if(!avoidCols.contains(col)) {
            avoidCols.add(col);
            //go up.. you will not find zero
            int newRow = row - 1;
            while (newRow >= 0) {
                if (grid[newRow][col] == 0) {
                    markZero(grid, newRow, col, avoidRows, avoidCols);
                } else {
                    grid[newRow][col] = 0;
                }
                newRow--;
            }

            EditDistance.printMatrix(grid);
            //go down - we can find new zeroes.. do recursion and call the same function
            newRow = row + 1;
            while (newRow < grid.length) {
                if (grid[newRow][col] == 0) {
                    markZero(grid, newRow, col, avoidRows, avoidCols);
                } else {
                    grid[newRow][col] = 0;
                }
                newRow++;
            }
        }

        EditDistance.printMatrix(grid);
        if(!avoidRows.contains(row)) {
            avoidRows.add(row);
            //go left
            int newCol = col - 1;
            while (newCol >= 0) {
                if (grid[row][newCol] == 0) {
                    markZero(grid, row, newCol, avoidRows, avoidCols);
                } else {
                    grid[row][newCol] = 0;
                }
                newCol--;
            }

            EditDistance.printMatrix(grid);
            //go right - we can find new zeroes - recursion here
            newCol = col + 1;
            while (newCol < grid[0].length) {
                if (grid[row][newCol] == 0) {
                    markZero(grid, row, newCol, avoidRows, avoidCols);
                } else {
                    grid[row][newCol] = 0;
                }
                newCol++;
            }
        }

        EditDistance.printMatrix(grid);
    }
}

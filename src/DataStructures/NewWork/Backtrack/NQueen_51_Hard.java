package DataStructures.NewWork.Backtrack;

import java.util.*;

public class NQueen_51_Hard {
    public static void main(String[] args) {
        System.out.println(new NQueen_51_Hard().solveNQueens(4));
    }

    //a queen can move in row, col and diagonal
    //backtracking

    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList();
        char[][] matrix = new char[n][n];
        for (char[] arr : matrix) Arrays.fill(arr, '.');
        backtrack(n, 0, new int[n], new int[2 * n], new int[2 * n], matrix);
        return result;
    }

    private void backtrack(int n, int k, int[] col, int[] diag45, int[] diag135, char[][] matrix) {
        if (k == n) {
            result.add(prepareAns(matrix));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (col[i] != 0 || diag45[n - 1 + k - i] != 0 || diag135[k + i] != 0) continue;

            col[i] = 1;
            diag45[n - 1 + k - i] = 1;
            diag135[k + i] = 1;
            matrix[k][i] = 'Q';

            backtrack(n, k + 1, col, diag45, diag135, matrix);

            col[i] = 0;
            diag45[n - 1 + k - i] = 0;
            diag135[k + i] = 0;
            matrix[k][i] = '.';
        }
    }

    private List<String> prepareAns(char[][] matrix) {
        List<String> ans = new ArrayList();
        for (char[] pos : matrix) {
            ans.add(String.valueOf(pos));
        }
        return ans;
    }
}

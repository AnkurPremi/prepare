package DataStructures.NewWork.Backtrack;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class NQueens2_52 {
    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue(3);
        System.out.println(new NQueens2_52().totalNQueens(4));
    }

    public int totalNQueens(int n) {
        int[] ans = {0};
        helper(n, 0, new int[1], new int[1], new int[1], ans);
        return ans[0];
    }

    private void helper(int n, int k, int[] col, int[] diag1, int[] diag2, int[] ans) {
        if (k == n) {
            ans[0] += 1;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (cannotPlace(n, k, i, col, diag1, diag2)) continue;
            place(n, k, i, col, diag1, diag2);
            helper(n, k + 1, col, diag1, diag2, ans);
            remove(n, k, i, col, diag1, diag2);
        }
    }

    private boolean cannotPlace(int n, int k, int i, int[] col, int[] diag1, int[] diag2) {
        int d1 = n - 1 + k - i;
        int d2 = k + i;
        if ((col[0] & (1 << i)) > 0 || (diag1[0] & (1 << d1)) > 0 || (diag2[0] & (1 << d2)) > 0) {
            return true;
        }
        return false;
    }

    private void place(int n, int k, int i, int[] col, int[] diag1, int[] diag2) {
        int d1 = n - 1 + k - i;
        int d2 = k + i;

        col[0] |= (1 << i);
        diag1[0] |= (1 << d1);
        diag2[0] |= (1 << d2);
    }

    private void remove(int n, int k, int i, int[] col, int[] diag1, int[] diag2) {
        int d1 = n - 1 + k - i;
        int d2 = k + i;

        col[0] &= ~(1 << i);
        diag1[0] &= ~(1 << d1);
        diag2[0] &= ~(1 << d2);
    }
}

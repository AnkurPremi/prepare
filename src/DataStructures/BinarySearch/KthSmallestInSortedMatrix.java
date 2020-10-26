package DataStructures.BinarySearch;

public class KthSmallestInSortedMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        System.out.println(new KthSmallestInSortedMatrix().kthSmallest(grid, 2));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if (k == 1) return matrix[0][0];
        if (k == n * n) return matrix[n - 1][n - 1];

        int x1 = 0, y1 = 0;
        int x2 = n, y2 = n;
        int l = 1, r = n * n;
        while (x1 <= x2 && y1 <= y2) {
            int mx = (x1 + x2) / 2;
            int my = (y1 + y2) % 2;
            int curr = (l + r) / 2;
            if (curr == k)
                return matrix[mx][my];
            else if (curr < k) {
                x1 = mx;
                y1 = my;
                l = curr;
            } else {
                x2 = mx;
                y2 = my;
                r = curr;
            }
        }
        return -1;
    }
}

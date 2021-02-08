package DataStructures.NewWork.LCArray;

import DataStructures.BinarySearch.KthSmallestInSortedMatrix;

public class KthSmallestInMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        System.out.println(new KthSmallestInMatrix().kthSmallest(grid, 8));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        if(m == 0) return 0;
        if(m == 1) return matrix[0][k];
        int n = matrix[0].length;

        int x1 = 0, y1 = 0;
        int x2 = 1, y2 = 0;
        int count = 0;
        while(x1 < m && x2 < m && y1 < n && y2 < n){
            if(matrix[x1][y1] < matrix[x2][y2]){
                if(++count == k) return matrix[x1][y1];
                if(++y1 == n){
                    y1 = 0;
                    x1 += 1;
                }
            } else if(matrix[x1][y1] > matrix[x2][y2]){
                if(++count == k) return matrix[x2][y2];
                if(++y2 == n){
                    y2 = 0;
                    x2 += 1;
                }
            } else{
                count++;
                if(y1 < n) y1++;
                else y2++;
            }

            if(count == k) return 0;
        }
        return 0;
    }
}

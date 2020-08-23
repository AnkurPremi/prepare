package Arrays;

//https://leetcode.com/problems/search-a-2d-matrix/

/**
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */
public class Search2Dmatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {7, 9, 12},
                {15, 20, 22}
        };
        System.out.println(new Search2Dmatrix().searchMatrix(matrix, 20));
    }

    //option-1 do binary search on the complete matrix as one list
    //O(log(n)
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0, end = row * col - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            int midVal = matrix[mid / col][mid % col];
            if (midVal == target) return true;
            else if (midVal > target) end = mid-1;
            else start = mid+1;
        }
        return false;
    }

    //option-2 do binary search on each row individually
    //O(mlog(n))
    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            int[] temp = matrix[i];
            if (target >= temp[0] && target <= temp[col - 1]) {
                return doBinarySearch(temp, target) != -1;
            }
        }
        return false;
    }

    private int doBinarySearch(int[] temp, int target) {
        int start = 0;
        int end = temp.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (temp[mid] == target) return mid;
            else if (temp[mid] > target) end--;
            else start++;
        }
        return -1;
    }
}

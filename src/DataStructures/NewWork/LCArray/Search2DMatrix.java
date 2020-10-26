package DataStructures.NewWork.LCArray;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1}};
        System.out.println(new Search2DMatrix().searchMatrix(matrix, 80));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;

        int n = matrix.length;
        //first find the row by doing binary search in 1st column
        int top = 0, bottom = n - 1;
        while (top <= bottom) {
            int mid = (top + bottom) >> 1;
            if (matrix[mid][0] == target)
                return true;
            else if (matrix[mid][0] < target)
                top = mid + 1;
            else
                bottom = mid - 1;
        }
        if(bottom < 0) return false;

        //now search in that row
        return doBinarySearchInRow(matrix[bottom], 0, matrix[0].length - 1 , target);
    }

    public boolean doBinarySearchInRow(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
}

package DataStructures.NewWork.LCArray;

import java.util.Arrays;

public class MaximalRectangle {
    public static void main(String[] args) {
//        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix = {{'0', '1'}};
        System.out.println(new MaximalRectangle().maximalRectangle(matrix));
    }

    /**
     For each index (i,j) we can calculate the left boundary, right boundary and height
     left boundary for index (i,j) is the point on the left in the same row where same height (present height) exist
     right boundary for index (i,j) is the point on the right in the same row where same height (present height) exist

     rectangle area will be :  (right - left) * height

     if matrix[i][j] == '0' : height will be 0
     if matrix[i][j] == '1' : height will be height[j] += 1   (1 + height at the same column in the previous row)

     **/
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int maxArea = 0,  n = matrix[0].length;
        int[] left = new int[n], right = new int[n], height = new int[n];
        Arrays.fill(right, n - 1);
        for(int i=0 ; i<m ; i++){
            //calculate right boundary for each point in this row
            int curr_right = n - 1;

            for(int j=n-1 ; j>=0 ; j--){
                if(matrix[i][j] == '1'){
                    right[j] = Math.min(right[j], curr_right);
                } else{
                    right[j] = n - 1;
                    curr_right = j - 1;
                }
            }


            int curr_left = 0;
            for(int j=0 ; j<n ; j++){
                if(matrix[i][j] == '1'){
                    left[j] = Math.max(left[j], curr_left);
                    height[j]++;
                    maxArea = Math.max(maxArea, height[j] * ( right[j] - left[j]  + 1));
                } else{
                    height[j] = 0;
                    left[j] = 0;
                    curr_left = j + 1;
                }
            }
        }

        return maxArea;
    }

//    public int maximalRectangle(char[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
//        int m = matrix.length, n = matrix[0].length, maxArea = 0;
//        int[] left = new int[n];
//        int[] right = new int[n];
//        int[] height = new int[n];
//        Arrays.fill(right, n - 1);
//        for (int i = 0; i < m; i++) {
//            int rB = n - 1;
//            for (int j = n - 1; j >= 0; j--) {
//                if (matrix[i][j] == '1') {
//                    right[j] = Math.min(right[j], rB);
//                } else {
//                    right[j] = n - 1;
//                    rB = j - 1;
//                }
//            }
//            int lB = 0;
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == '1') {
//                    left[j] = Math.max(left[j], lB);
//                    height[j]++;
//                    maxArea = Math.max(maxArea, height[j] * (right[j] - left[j] + 1));
//                } else {
//                    height[j] = 0;
//                    left[j] = 0;
//                    lB = j + 1;
//                }
//            }
//        }
//        return maxArea;
//    }
}

package DataStructures.NewWork.LCArray;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
//        new RotateMatrix().rotateMatrix(matrix);
        new RotateMatrix().rotateMatrixAnti(matrix);
    }

    public void rotateMatrix(int[][] matrix) {

        int t = 0, b = matrix.length-1;
        while (t < b) {
            int[] temp = matrix[b];
            matrix[b] = matrix[t];
            matrix[t] = temp;
            b--;
            t++;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void rotateMatrixAnti(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length;

        for(int i= 0 ;i<m ; i++){
            int[] temp = matrix[i];
            int l = 0, r = n-1;
            while(l < r){
                int val = temp[l];
                temp[l] = temp[r];
                temp[r] = val;
                l++;
                r--;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i= 0 ;i<m ; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}

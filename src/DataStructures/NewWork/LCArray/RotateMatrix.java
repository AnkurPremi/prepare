package DataStructures.NewWork.LCArray;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        new RotateMatrix().rotateMatrix(matrix);
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
}

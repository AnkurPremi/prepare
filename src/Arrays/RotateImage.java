package Arrays;

//https://leetcode.com/problems/rotate-image/
//https://leetcode.com/problems/rotate-image/discuss/18872/A-common-method-to-rotate-the-image
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        new RotateImage().rotateClockWise(matrix);

        int[][] matrix1 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

    }

    public void rotateClockWise(int[][] matrix) {

        //this is reversing the rows from bottom to top
        int start = 0, end = matrix.length-1;
        while (start < end){
            int[] temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;
            start++;
            end--;
        }
        //exchange the elements
        for(int i=0; i< matrix.length;i++){
            for(int j=i+1; j< matrix[i].length ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println("checkout");
    }

    public void rotateCounterClockWise(int[][]matrix){
        int start = 0, end = matrix.length-1;
        while(start < end){

        }
    }
}

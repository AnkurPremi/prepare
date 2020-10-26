package DataStructures.NewWork.LCArray;

public class GenerateMatrix {
    public static void main(String[] args) {
        int[][] grid = new GenerateMatrix().generateMatrix(2);
    }

    public int[][] generateMatrix(int n) {
        int rowUpper = 0;
        int colLeft = 0;
        int colRight = n-1;
        int rowBottom = n-1;
        int start = 1;
        int[][] grid = new int[n][n];
        int i = 0, j = 0;
        while(colLeft < colRight && rowUpper < rowBottom){
            //move right
            while(j<=colRight){
                grid[i][j] = start++;
                j++;
            }
            rowUpper++;
            j--;i++;

            //move down
            while(i<=rowBottom){
                grid[i][j] = start++;
                i++;
            }
            colRight--;
            i--;j--;

            //move left
            while(j>=colLeft){
                grid[i][j] = start++;
                j--;
            }
            rowBottom--;
            j++;i--;

            //move up
            while(i>=rowUpper){
                grid[i][j] = start++;
                i--;
            }
            colLeft++;
            i++;j++;
        }
        return grid;
    }

    public void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) System.out.println("\n");
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}

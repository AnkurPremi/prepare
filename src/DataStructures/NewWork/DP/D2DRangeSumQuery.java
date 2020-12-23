package DataStructures.NewWork.DP;

public class D2DRangeSumQuery {
    public static void main(String[] args) {

    }

    class NumMatrix {

        int[][] pSumMatrix;
        public NumMatrix(int[][] matrix) {
            calculatePrefixSum(matrix);
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return pSumMatrix[row2+1][col2+1] - pSumMatrix[row1][col2+1] - pSumMatrix[row2+1][col1] + pSumMatrix[row1][col1];
        }

        private void calculatePrefixSum(int[][] matrix){
            int m = matrix.length, n = matrix[0].length;
            this.pSumMatrix = new int[m+1][n+1];

            for(int i=1 ; i<=m ; i++){
                for(int j=1 ; j<=n ; j++){
                    pSumMatrix[i][j] = matrix[i-1][j-1] + pSumMatrix[i-1][j] + pSumMatrix[i][j-1] - pSumMatrix[i-1][j-1];
                }
            }
        }
    }
}

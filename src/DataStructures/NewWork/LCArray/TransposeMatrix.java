package DataStructures.NewWork.LCArray;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},
                {4,5,6}};
        new TransposeMatrix().transpose(grid);
    }

    public int[][] transpose(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int n1 = 0, m1 = 0;
        int[][] result = new int[m][n];
        for(int j=0; j<m ; j++){
            for(int i=0; i<n ; i++){
                if(m1 == n){
                    m1=0;
                    n1++;
                }
                result[n1][m1] = A[i][j];
                m1++;
            }
        }
        return result;
    }
}

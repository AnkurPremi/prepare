package DataStructures.NewWork.LCArray;

public class DiagnolSort {
    public static void main(String[] args) {
        int[][] grid = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        new DiagnolSort().diagonalSort(grid);
    }

    public int[][] diagonalSort(int[][] mat) {

        int n = mat.length, m = mat[0].length;
        for(int i = 0; i < n - 1; i++) {
            countingSort(mat, i, 0, n, m);
        }
        for(int j = 1; j < m - 1; j++) {
            countingSort(mat, 0, j, n, m);
        }
        return mat;
    }

    private void countingSort(int[][] mat, int i, int j, int n, int m) {

        int[] arr = new int[101];
        int k = i, l = j, val = 0;
        while(k < n && l < m) {
            arr[mat[k][l]]++;
            k++; l++;
        }

        k = i; l = j;
        for(int p = 0; p < 101; p++) {
            if(k > n || l > m) break;
            if(arr[p] > 0) {
                val = arr[p];
                while(val > 0){
                    mat[k][l] = p;
                    k++; l++; val--;
                }
            }
        }
    }
}

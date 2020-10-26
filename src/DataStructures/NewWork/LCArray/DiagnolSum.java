package DataStructures.NewWork.LCArray;

public class DiagnolSum {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(new DiagnolSum().diagonalSum(mat));
    }

    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;
        for (int x1 = 0,  y1 = 0,  x2 = 0,  y2 = n - 1  ;   x1 < n && y1 < n   &&   x2 < n   &&   y2 >= 0  ;   x1++,  y1++,  x2++,  y2--) {
            if (x1 == x2 && y1 == y2)
                sum += mat[x1][y1];
            else
                sum += mat[x1][y1] + mat[x2][y2];
        }
        return sum;
    }

}

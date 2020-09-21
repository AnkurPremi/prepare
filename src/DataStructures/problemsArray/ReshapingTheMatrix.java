package DataStructures.problemsArray;

public class ReshapingTheMatrix {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2},
                {3, 4}
        };
        new ReshapingTheMatrix().matrixReshape(nums, 4, 1);
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        if (row == 0) return nums;
        int col = nums[0].length;
        if (r * c != row * col) return nums;
        int[][] arr = new int[r][c];
        int count = 0, p = c;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (count == c) {
                    r--;
                    p = c;
                    count = 0;
                }
                arr[r - 1][p - 1] = nums[i][j];
                count++;
                p--;
            }
        }
        return arr;
    }
}

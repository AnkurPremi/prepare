package DataStructures.problemsArray;

//https://leetcode.com/problems/squares-of-a-sorted-array/
public class SQuaresOFSortedArray {
    public static void main(String[] args) {
        int[] nums = {-7, -3, -3,2, 2, 3, 11};
        new SQuaresOFSortedArray().sortedSquares(nums);
    }

    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int l = 0;
        int r = n - 1;
        int j = n - 1;
        while (l <= r) {
            if (A[l] * A[l] > A[r] * A[r]) {
                result[j--] = A[l] * A[l];
                l++;
            } else {
                result[j--] = A[r] * A[r];
                r--;
            }
        }
        return result;
    }
}

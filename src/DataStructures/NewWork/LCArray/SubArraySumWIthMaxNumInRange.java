package DataStructures.NewWork.LCArray;

public class SubArraySumWIthMaxNumInRange {
    public static void main(String[] args) {
        int[] arr = {1,1,2,1,3,4,3};
    }

    public int getCount(int[] A, int L, int R){
        int i0 = 0, res = 0, count = 0;
        for (int i = 0; i < A.length; i++) {
            //if we found a number greater than R..break the current count
            //and move the left pointer to right
            if (A[i] > R) {
                count = 0; i0 = i + 1;
            }
            //if we found a number in range...
            // all the previously seen smaller numbers will contribute in making the subArrays
            else if (A[i] >= L) count = i-i0+1;

            //if we found a smaller number
            res += count;
        }
        return res;
    }
}

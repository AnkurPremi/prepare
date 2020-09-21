package DataStructures.problemsArray;

public class NumberofSubarrayswithBoundedMaximum {
    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3, 1, 5, 3, 2};
        int l = 2;
        int r = 3;
        new NumberofSubarrayswithBoundedMaximum().numSubarrayBoundedMax(nums, l, r);
    }

    public int numSubarrayBoundedMax1(int[] A, int L, int R) {
        int result = 0, start = -1, end = -1;
        for (int i = 0; i < A.length; i++) {
            //found a block..cannot move forward
            if (A[i] > R) {
                start = end = i;
                continue;
            }
            //every time a new number come in the range of L and R
            //we can have subArrays around that number using only that number
            if (A[i] >= L) {
                end = i;
            }
            result += end - start;
        }
        return result;
    }

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int max = -1;
        int count = 0;
        boolean subArrRunning = false;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            //either max lie in area.. or num should be less than max and subArrRunning = true
            if (A[i] < L && subArrRunning) {
                count++;
            } else if (L <= max && max <= R) {
                count++;
                if (subArrRunning) {
                    count++;
                }
                subArrRunning = true;
            } else {
                max = -1;
                subArrRunning = false;
            }
        }
        return count;
    }

    boolean isBound(int k, int l, int r) {
        return l <= k && k <= r;
    }
}

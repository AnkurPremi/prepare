package DataStructures.NewWork.DP;

public class MinSwapsTOMakeIncreasing {
    public static void main(String[] args) {
        int[] A = {1,3,5,4};
        int[] B = {1,2,3,7};
        System.out.println(new MinSwapsTOMakeIncreasing().minSwap(A, B));
    }

    int min = 1002;
    public int minSwap(int[] A, int[] B) {
        helper(A, B, 1, 0);
        return min;
    }

    private void helper(int[] A, int[] B, int idx, int swaps){
        if(idx == A.length){
            min = Math.min(swaps, min);
            return;
        }

        //need a swap
        if(A[idx] < A[idx-1] || B[idx] < B[idx-1]){
            if(B[idx] > A[idx-1] && B[idx-1] < A[idx]){
                int temp = A[idx];
                A[idx] = B[idx];
                B[idx] = temp;

                helper(A, B, idx+1, swaps+1);

                temp = A[idx];
                A[idx] = B[idx];
                B[idx] = temp;
            }

            if(idx-2 >= 0 && A[idx-1] > B[idx-2] && B[idx-1] > A[idx-2]) {
                int temp = A[idx - 1];
                A[idx - 1] = B[idx - 1];
                B[idx - 1] = temp;
                helper(A, B, idx, swaps + 1);
            }
        } else{
            helper(A, B, idx+1, swaps);
        }
    }
}

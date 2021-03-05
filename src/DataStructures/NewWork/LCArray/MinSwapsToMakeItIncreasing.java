package DataStructures.NewWork.LCArray;

import java.util.Arrays;

public class MinSwapsToMakeItIncreasing {
    public static void main(String[] args) {
        int[] A = {0,4,4,5,9};
        int[] B = {0,1,6,8,10};
        System.out.println(new MinSwapsToMakeItIncreasing().minSwap(A, B));
    }

    int[] cache;
    public int minSwap(int[] A, int[] B) {
        cache = new int[A.length + 1];
        Arrays.fill(cache, -1);

        return helper(A, B, 0);
    }

    private int helper(int[] A, int[] B, int i){
        if(i == A.length) return 0;
        if(cache[i] != -1) return cache[i];

        int min = Integer.MAX_VALUE;

        if(i == 0 || (A[i - 1] < A[i] && B[i - 1] < B[i])){
            min = helper(A, B, i + 1);
        } else if(A[i - 1] >= A[i] || B[i - 1] >= B[i]){

            //swap curr val
            swap(i, A, B);
            int v1 = helper(A, B, i);
            swap(i, A, B);

            //swap prev value
            swap(i - 1, A, B);
            int v2 = helper(A, B, i - 1);
            swap(i - 1, A, B);

            if(v1 == Integer.MAX_VALUE) min = v2 + 1;
            else if(v2 == Integer.MAX_VALUE) min = v1 + 1;
            else min = 1 + Math.min(v1, v2);

        }

        return cache[i] = min;
    }

    private void swap(int i, int[] A, int[] B){
        int temp = A[i];
        A[i] = B[i];
        B[i] = temp;
    }
}

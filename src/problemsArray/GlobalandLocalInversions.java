package problemsArray;

public class GlobalandLocalInversions {
    public static void main(String[] args) {
        int[] nums = {1,2,0};
        new GlobalandLocalInversions().isIdealPermutation(nums);
    }

    public boolean isIdealPermutation(int[] A) {
        int n = A.length;
        int[] maxFromLeft = new int[n];
        maxFromLeft[0] = A[0];
        int global = 0;
        for (int i = 1; i < n; i++) {
            if (maxFromLeft[i - 1] > A[i]) global++;
            maxFromLeft[i] = Math.max(maxFromLeft[i - 1], A[i]);
        }

        int local = 0;
        int[] minFromRight = new int[n];
        minFromRight[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) local++;
//            if(minFromRight[])
        }

        return local == global;
    }

}

package DataStructures.NewWork.LCArray;

public class SubArrayWithKDifferentIntegers_HaRd {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        System.out.println(new SubArrayWithKDifferentIntegers_HaRd().subarraysWithKDistinct(arr, 2));
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        int[] counts = new int[A.length + 1];
        int ans = 0;
        int prefix = 0;
        int l = 0, unique = 0;
        for (int r = 0; r < A.length; r++) {
            if (counts[A[r]]++ == 0) unique++;
            if (unique > K) {
                counts[A[l]]--;
                unique--;
                l++;
                prefix = 0;
            }
            while (counts[A[l]] > 1) {
                counts[A[l]]--;
                prefix++;
                l++;
            }

            if (unique == K) {
                ans += 1 + prefix; //1: for itself... prefix: for previous elements which could have made subarray
            }

        }
        return ans;
    }
}

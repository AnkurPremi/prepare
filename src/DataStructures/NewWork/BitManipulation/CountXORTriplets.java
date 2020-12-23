package DataStructures.NewWork.BitManipulation;

public class CountXORTriplets {
    public static void main(String[] args) {
        int[] arr = {2,3,1,6,7};
        System.out.println(new CountXORTriplets().countTriplets(arr));
    }

    public int countTriplets(int[] arr) {
        int i = 0, j = 1, k = 1;
        int ans = 0;
        int lx = arr[i], rx = arr[j];
        while (j < arr.length) {
            if (lx == rx) {
                ans++;
            }

            if (i < j - 1) {
                lx ^= arr[i++];
                lx ^= arr[i];
            } else if (j < k) {
                lx ^= arr[j];
                rx ^= arr[j++];
                if (j < arr.length)
                    rx ^= arr[j];
            } else if (k < arr.length) {
                k++;
                rx ^= arr[k];
            }

        }
        return ans;
    }
}

package DataStructures.NewWork.DP;

public class DuplicateZeroes {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        new DuplicateZeroes().duplicateZeroes(arr);
    }

    private void duplicateZeroes(int[] arr) {
        int count = 0, n = arr.length;
        for (int i : arr) if (i == 0) count++;
        int r = n - 1;
        int writer = n + count - 1; //imaginary arr length
        if(count == 0) return;
        while (r >= 0 && writer >= 0) {
            if (arr[r] != 0) {
                if (writer < n)  arr[writer] = arr[r];
            } else {
                if (writer < n) arr[writer] = 0;
                writer--;
                if (writer < n) arr[writer] = 0;
            }
            writer--;
            r--;
        }
    }
}

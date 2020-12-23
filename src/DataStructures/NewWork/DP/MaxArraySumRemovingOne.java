package DataStructures.NewWork.DP;

public class MaxArraySumRemovingOne {
    public static void main(String[] args) {
        int[] arr = {2,1,-2,-5,-2};
        System.out.println(new MaxArraySumRemovingOne().maximumSum(arr));
    }

    public int maximumSum(int[] arr) {
        int n = arr.length;
        int oneDelete = 0, noDelete = arr[0], max = arr[0];
        for (int i = 1; i < n; i++) {
            oneDelete = Math.max(oneDelete + arr[i], noDelete);
            noDelete = Math.max(noDelete + arr[i], arr[i]);
            max = Math.max(max, Math.max(oneDelete, noDelete));
        }
        return max;
    }
}

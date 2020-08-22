package misc;

public class NthSmallestUnsortedArray {
    public static void main(String[] args) {
        int[] arr = {10, 2, 9, 1, 3, 5,7,11,22};
        System.out.println(getNthSmallest(arr, 0, arr.length-1, 3));
    }

    static int getNthSmallest(int[] arr, int start, int end,int m) {

        int pivot = reArrangeNumbers(arr, start, end);
        if(pivot == m)return arr[m];
        else if(pivot <= start)
            return getNthSmallest(arr, pivot+1, end, m);

        return getNthSmallest(arr, start, pivot-1, m);
    }

    static int reArrangeNumbers(int[] arr, int start, int end) {
        int temp = arr[end];
        int idx = start;
        for (int i = start; i <= end; i++) {
            if (temp > arr[i]) {
                int k = arr[i];
                arr[i] = arr[idx];
                arr[idx] = k;
                idx++;
            }
        }
        int k = arr[end];
        arr[end] = arr[idx];
        arr[idx] = k;
        return idx;
    }
}

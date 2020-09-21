package DataStructures.SortingAndSeraching;

public class QuickSortArray {
    public static void main(String[] args) {
        int[] arr = {10, 12, 3, 13, 14, 9, 4, 7, 5, 8, 6, 2};
        qSort(arr, 0, arr.length - 1);
        System.out.println("fef");
    }

    static void qSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivot = partition(arr, start, end);
        qSort(arr, start, pivot - 1);
        qSort(arr, pivot + 1, end);
    }

    static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }
        int temp = arr[pIndex];
        arr[pIndex] = pivot;
        arr[end] = temp;
        return pIndex;
    }
}

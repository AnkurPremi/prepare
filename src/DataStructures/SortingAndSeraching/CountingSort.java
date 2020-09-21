package DataStructures.SortingAndSeraching;

/**
 * Mainly used when we know the range of elements
 * Total count is quite more than the max element
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 2, 9, 3, 1, 1}; //here the range is from 1 ... 10
        sort(arr);
    }

    static void sort(int[] arr) {
        //create an array to store the count of each element
        int[] arrNew = new int[256];
        for (int i = 0; i < arr.length; i++) {
            arrNew[arr[i]]++;
        }
        //adjust the count
        for (int i = 1; i < 256; i++) {
            arrNew[i] = arrNew[i] + arrNew[i - 1];
        }

        int[] result = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {
            result[arrNew[arr[i]]-1] = arr[i];
            --arrNew[arr[i]];
        }
        System.out.println(result);
    }


}

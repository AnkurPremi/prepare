package misc;

//Magic Index: A magic index in an array A[ 1 .•. n-1] is defined to be an index such that A[ i]
//i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
//array A.
//FOLLOW UP
//What if the values are not distinct?
public class MagicIndex {
    public static void main(String[] args) {
        int[] arrWithDistinct = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12};
        int[] arrWithDuplicates = {-10, -5, 2, 2, 2, 3, 4, 5, 7, 9, 12, 13};
        System.out.println(findMagicIndexWithDistinct(arrWithDistinct));
        System.out.println(findMagicIndexWithDuplicates(arrWithDuplicates, 0, arrWithDuplicates.length - 1));
        System.out.println(findMagicIndexWithDuplicates(arrWithDistinct, 0, arrWithDistinct.length - 1));
    }

    static int findMagicIndexWithDistinct(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        //do binary search on index and compare the element value at that index
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (arr[mid] == mid) {
                return mid;
            } else if (arr[mid] < mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    static int findMagicIndexWithDuplicates(int[] arr, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) >> 1;
        if (arr[mid] == mid)
            return mid;

        //search left
        int leftIndex = Math.min(arr[mid], mid - 1);
        int left = findMagicIndexWithDuplicates(arr, start, leftIndex);
        if (left >= 0)
            return left;

        //search right
        int rightIndex = Math.max(mid + 1, arr[mid]);
        int right = findMagicIndexWithDuplicates(arr, rightIndex, end);
        return right;
    }


}

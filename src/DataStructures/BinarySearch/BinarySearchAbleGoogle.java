package DataStructures.BinarySearch;

public class BinarySearchAbleGoogle {
    public static void main(String[] args) {
        BinarySearchable obj = new BinarySearchable();
        System.out.println(obj.getSearchableCount(new int[]{2, 1, 3, 4, 6, 5}));
        System.out.println(obj.getSearchableCount(new int[]{1, 3, 2}));
        System.out.println(obj.getSearchableCount(new int[]{1, 2, 2, 3}));
    }

    static class BinarySearchable {
        public int getSearchableCount(int[] arr) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            return getSearchableCount(arr, 0, arr.length - 1, Integer.MAX_VALUE, true);
        }

        private int getSearchableCount(int[] arr, int start, int end, int num, boolean isLeft) {
            if (start > end) {
                return 0;
            }
            int mid = (start + end) / 2;
            int count = 0;
            if (isLeft && arr[mid] <= num) count++;
            if (!isLeft && arr[mid] >= num) count++;
            return count + getSearchableCount(arr, start, mid - 1, arr[mid], true) +
                    getSearchableCount(arr, mid + 1, end, arr[mid], false);
        }


    }
}

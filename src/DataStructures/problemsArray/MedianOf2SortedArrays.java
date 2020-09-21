package DataStructures.problemsArray;

//O(log(min(m,n))
public class MedianOf2SortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 3};
        int[] arr2 = {2};
        System.out.println(new MedianOf2SortedArrays().getMedian(arr1, arr2));
    }

    public double getMedian(int[] arr1, int[] arr2) {
        int[] shortArr = null;
        int[] longArr = null;
        int n = arr1.length;
        int m = arr2.length;
        if (m < n) {
            shortArr = arr2;
            longArr = arr1;
        } else {
            shortArr = arr1;
            longArr = arr2;
        }

        int x = 0, y = shortArr.length;
        while (x <= y) {
            int partX = (x + y) / 2;
            int partY = ((m + n + 1) / 2) - partX;
            int p1 = partX == 0 ? Integer.MIN_VALUE : shortArr[partX - 1];
            int p2 = partX == shortArr.length ? Integer.MAX_VALUE : shortArr[partX];
            int q1 = partY == 0 ? Integer.MIN_VALUE : longArr[partY - 1];
            int q2 = partY == longArr.length ? Integer.MAX_VALUE : longArr[partY];
            if (p1 <= q2 && q1 <= p2) {
                if ((m + n) % 2 == 0) {
                    double d = (double) ((Math.max(p1, q1) + Math.min(p2, q2))) / 2;
                    return d;
                } else {
                    double d = (double) Math.max(p1, q1);
                    return d;
                }
            } else if (p1 > q2) {
                y = partX - 1;
            } else {
                x = partX + 1;
            }
        }
        return -1;
    }
}

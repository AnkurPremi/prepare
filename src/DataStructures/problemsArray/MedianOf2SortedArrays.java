package DataStructures.problemsArray;

//O(log(min(m,n))
public class MedianOf2SortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        System.out.println(new MedianOf2SortedArrays().findMedianSortedArrays(arr1, arr2));
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if(n > m) return findMedianSortedArrays(nums2, nums1);

        int x = 0, y = n;
        while(x <= y){
            int partX = (x + y) >> 1;
            int partY = ((m + n + 1) >> 1) - partX;

            int p1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int p2 = partX == n ? Integer.MAX_VALUE : nums1[partX];

            int q1 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            int q2 = partY == m ? Integer.MAX_VALUE : nums2[partY];

            if(p1 <= q2 && q1 <= p2){
                //odd length
                if((n + m) % 2 == 0){
                    double ans = (Math.max(p1, q1)/1.0 + Math.min(p2, q2)/1.0) /2.0;
                    return ans;
                } else{
                    return Math.max(p1, q1) / 1.0;
                }
            } else if(p1 > q2){
                y = partX - 1;
            } else{
                x = partX + 1;
            }
        }
        return -1d;

    }

    public double getMedian1(int[] arr1, int[] arr2) {
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

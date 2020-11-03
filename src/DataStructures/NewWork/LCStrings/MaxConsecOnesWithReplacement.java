package DataStructures.NewWork.LCStrings;

public class MaxConsecOnesWithReplacement {
    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(new MaxConsecOnesWithReplacement().longestOnes(arr, 2));
    }

    public int longestOnes(int[] A, int K) {
        //sliding window technique
        //every time we see a see 0.. we subtract 1 from K .. untile K>0
        //when K == 0.. we start contracting the window from left until k = 0
        int l = 0, r = 0, n = A.length;
        int max = 0;
        while (r < n) {
            if (A[r] == 0) {
                    K--;
                while (l <= r && K < 0) {
                    max = Math.max(r - l, max);
                    if (A[l++] == 0)
                        K++;
                }
            }
            r++;
        }
        max = Math.max(r - l, max);
        return max;
    }
}

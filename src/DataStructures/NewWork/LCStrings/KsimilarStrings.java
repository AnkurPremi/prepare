package DataStructures.NewWork.LCStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class KsimilarStrings {
    public static void main(String[] args) {
        String A = "aabc";
        String B = "abca";
        System.out.println(new KsimilarStrings().kSimilarity(A, B));
    }

    public int kSimilarity(String A, String B) {

        return backtrack(A.toCharArray(), B.toCharArray(), 0);
    }

    private int backtrack(char[] a, char[] b, int i) {
        if(i == a.length) return 0;

        if(a[i] == b[i]) return backtrack(a, b, i + 1);

        int res = Integer.MAX_VALUE;
        for(int j = i + 1; j < a.length; j++) {
            //if the character at ith index and jth index is not same
            //and if the character a jth index of a and b is same..don't swap it..it's at the correct position
            //swapping that will result in more moves
            if(a[i] != b[j] || a[j] == b[j]) continue;

            swap(b, i, j);
            res = Math.min(res, backtrack(a, b, i + 1));
            swap(b, i, j);
        }
        res++;

        return res;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

package DataStructures.NewWork.LCStrings;

import java.util.ArrayList;
import java.util.List;

public class CanMakePalindromeFromSubStr {
    public static void main(String[] args) {
        int[][] queries = {{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};
        String s = "abcda";
        
        System.out.println(new CanMakePalindromeFromSubStr().canMakePaliQueries(s, queries));
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList();
        for (int[] q : queries) {
            result.add(isPalindrome(s, q[0], q[1], q[2]));
        }
        return result;
    }

    private boolean isPalindrome(String s, int l, int r, int k) {
        if (l >= r) return true;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (k > 0)
                    return isPalindrome(s, l + 1, r - 1, k - 1);
                else
                    return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
// return isPalindrome(s, l + 1, r, k - 1) || isPalindrome(s, l, r - 1, k - 1);
package DataStructures.strings;

import java.util.HashMap;
import java.util.Map;

public class AllPalindromicSubstrings {
    public static void main(String[] args) {
        String s = "aabccbaa";
        int val = new AllPalindromicSubstrings().countSubstrings1(s);
        System.out.println(val);
    }

    public int countSubstrings(String s) {
        int[] result = new int[1];
        helper(s, 0, result);
        return result[0];
    }

    public void helper(String s, int start, int[] result) {
        if (start == s.length()) {
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(0, i);
            System.out.println("---------------\nString here is: "+ str);
            if (!str.isEmpty() && checkIfPalindrome(str)) {
                result[0]++;
                System.out.println("is Palindrome. count now: "+ result[0]);
                helper(s.substring(i), i + 1, result);
            }
        }
    }

    public boolean checkIfPalindrome(String s) {
        if (s.length() == 1) return true;
        else {
            int start = 0, end = s.length() - 1;
            while (start < end) {
                if (s.charAt(start) != s.charAt(end))
                    return false;
                start++;
                end--;
            }
        }
        return true;
    }

    public int countSubstrings1(String s) {
        int count = 0;
        if(s == null) return count;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            count += helpernew(s, i, i, map);
            count += helpernew(s, i, i + 1, map);
        }
        return count;
    }

    public int helpernew(String s, int start, int end, Map<String, Integer> map) {
        int count = 0;
        if (map.containsKey(s)) return map.get(s);
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        map.put(s, count);
        return count;
    }
}

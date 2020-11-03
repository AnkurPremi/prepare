package DataStructures.strings;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * Example:
 * <p>
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 */
public class MinWindowSubstring {
    public static void main(String[] args) {
        String S = "a", T = "a";
        System.out.println(new MinWindowSubstring().minWindow(S, T));
    }

    public String minWindow(String s, String t) {
        int[] map = new int[128];

        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }

        int[] lookup = map.clone();

        int l = 0, r = 0, minL = s.length() + 1;
        int count = 0;
        int start = 0, end = 0;
        while (r < s.length()) {
            if (lookup[s.charAt(r)] > 0) {
                if (map[s.charAt(r)]-- > 0) {
                    count++;
                }
            }

            if (count == t.length()) {
                if (minL > r - l + 1) {
                    minL = r - l + 1;
                    start = l;
                    end = r;
                }
                while (l < s.length() && count == t.length()) {
                    if (lookup[s.charAt(l)] > 0) {
                        if (map[s.charAt(l)]++ == 0) {
                            if (minL > r - l + 1) {
                                minL = r - l + 1;
                                start = l;
                                end = r;
                            }
                            count--;
                        }
                    }
                    l++;
                }
            }
            r++;
        }
        return s.substring(start, end + 1);
    }
    
    public static String minWindow1(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) return "";
        if (t.length() > s.length()) return "";
        if (t.equals(s)) return t;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        boolean charAdded = false;
        String result = "";
        int len = 0, minLength = Integer.MAX_VALUE, max = -1;
        for (int i = 0; i < s.length(); i++) {
            if (t.indexOf(s.charAt(i)) != -1) {
                if (map.containsKey(s.charAt(i))) {
                    map.remove(s.charAt(i));
                } else {
                    len++;
                }
                map.put(s.charAt(i), i);
                charAdded = true;
            }
            if (charAdded && (len == t.length())) {
                charAdded = false;
                Map.Entry<Character, Integer> entry = map.entrySet().iterator().next();
                int val = minLength;
                minLength = Math.min(minLength, i - entry.getValue());
                if (minLength < val) {
                    max = i;
                }
            }
        }
        if (len == t.length()) {
            result = s.substring(map.entrySet().iterator().next().getValue(), max + 1);
        }
        return result;
    }

    private static class Helper {
        public int minVal;
        public int index;

        public Helper(int val, int idx) {
            minVal = val;
            index = idx;
        }
    }
}

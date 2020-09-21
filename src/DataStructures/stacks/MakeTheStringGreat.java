package DataStructures.stacks;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/make-the-string-great/
public class MakeTheStringGreat {
    public static void main(String[] args) {
        String s = "abBAcCdddddD";
        System.out.println(new MakeTheStringGreat().makeGood(s));
    }

    public String makeGood(String s) {
        int n = s.length();
        if (n == 1) return s;
        char[] arr = s.toCharArray();
        int i = 0;
        for (char c : arr) {
            if (i > 0 && (arr[i - 1] - 'a' == c - 'A')) {
                i--;
            } else {
                arr[i] = c;
                i++;
            }
        }
        return new String(arr, 0, i);
    }

    private Map<Character, Character> getCharMap() {
        Map<Character, Character> map = new HashMap<>();
        for (char i = 'a'; i <= 'z'; i++) {
            map.put((char) (i - 32), i);
        }
        return map;
    }
}

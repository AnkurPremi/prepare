package DataStructures.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the length of longest substring from a String with no repeating characters
 */
public class LongestSubStrWithNoRepeatChars {
    public static void main(String[] args) {
        String s = "abcabababc";
        String s2 = "bbbbb";
        String s3 = "tmmzuxt";
        System.out.println(getSubStr(s3));
    }

    static int getSubStr(String s) {
        if (s == null || s.length() == 0) return 0;
        //this hashmap will be used as lookup for character and their index
        //as we iterate, we will start storing the characters with their index
        //we will take 2 pointers, one slow and one fast
        //fast will continue to move and slow will only move when a duplicate char is found
        //at any time, diff b/w right and left is the max sub string length
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        char[] charArr = s.toCharArray();
        for (int left = 0, right = 0 ;right < charArr.length; right++) {
            if (map.containsKey(charArr[right])) {
                left = Math.max(left, map.get(charArr[right])+1);
            }
            map.put(charArr[right], right);
            maxLength = Math.max(right-left+1, maxLength);
        }
        return maxLength;
    }
}

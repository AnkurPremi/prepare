package DataStructures.HashTable;

import Interview.LongestSubStringWithNoRepeatChars;

import java.util.*;

public class LongestWorldInDict {
    /**
     *
     * @param args @code
     */
    public static void main(String[] args) {
//        String words[] = {"w","wo","wor","worl", "world"};
        String[] words = {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        System.out.println(new LongestWorldInDict().longestWord(words));
    }

    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            return a.compareTo(b);
        });
        Set<String> map = new HashSet<>();
        map.add("");
        String ans = "";
        for (String s : words) {
            String sub = s.substring(0, s.length() - 1);
            if (map.contains(sub)) {
                if (ans.length() < s.length()) {
                    ans = s;
                } else if (ans.length() == s.length()) {
                    ans = ans.compareTo(s) < 0 ? ans : s;
                }
                map.add(s);
            }
        }
        return ans;
    }

    public String longestWord1(String[] words) {
        StringBuilder builder = new StringBuilder();

        Arrays.sort(words, (a, b) -> {
            return a.compareTo(b);
        });
        Set<String> map = new HashSet<>();
        map.add("");
        String ans = "";
        for (String s : words) {
            String sub = s.substring(0, s.length() - 1);
            if (map.contains(sub)) {
                if (ans.length() < s.length()) {
                    ans = s;
                } else if (ans.length() == s.length()) {
                    ans = ans.compareTo(s) == -1 ? s : ans;
                }
                map.add(s);
            } else {
                map.add(s);
            }
        }
        return ans;
    }
}

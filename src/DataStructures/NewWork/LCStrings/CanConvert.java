package DataStructures.NewWork.LCStrings;

import java.util.*;

public class CanConvert {
    public static void main(String[] args) {
//        String str1 = "leetcode", str2 = "codeleet";
        String str1 = "abcdefghijklmnopqrstuvwxyz";
        String str2 = "bcadefghijklmnopqrstuvwxzz";
        System.out.println(new CanConvert().canConvert1(str1, str2));
    }

    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) return true;
        if (str1.length() != str2.length()) return false;

        Deque<Integer> dq = new LinkedList();
        int num = 0;
        int[] map = new int[128];

        for (char c : str1.toCharArray()) {
            if (map[c] == 0) {
                map[c] = ++num;
            }
            dq.addLast(map[c]);
        }

        map = new int[128];
        num = 0;

        for (char c : str2.toCharArray()) {
            if (map[c] == 0) {
                map[c] = ++num;
            }
            if (dq.pollFirst() != map[c]) return false;
        }

        return true;
    }

    public boolean canConvert1(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (map.containsKey(c1) && map.get(c1) != c2) {
                return false;
            }
            map.put(c1, c2);
        }
        return new HashSet<Character>(map.values()).size() < 26;
    }
}

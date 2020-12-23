package DataStructures.NewWork.LCStrings;

import java.util.*;

public class LongestDuplicateSubstring {
    public static void main(String[] args) {
        System.out.println(new LongestDuplicateSubstring().longestDupSubstring("bananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaananaanana"));
    }

    public String longestDupSubstring(String S) {
        Map<Character, List<Integer>> map = new HashMap();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }

        int maxLen = 0;
        int start = -1, end = -1;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            List<Integer> list = map.get(c);

            for(int j=1 ; j<list.size() ; j++) {
                int s1 = list.get(j-1), s2 = list.get(j), len = 0;
                while (s2 < S.length() && S.charAt(s1) == S.charAt(s2)) {
                    s1++;
                    s2++;
                    len++;
                }
                if (maxLen < len) {
                    start = i;
                    end = s1;
                    maxLen = len;
                }
            }
        }
        if (start == -1) return "";

        return S.substring(start, end);
    }

    private Integer getCeilingValue(int val, List<Integer> list) {
        int start = 0, end = list.size() - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (val == list.get(mid)) {
                return mid + 1 < list.size() ? list.get(mid + 1) : null;
            } else if (val < list.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return null;
    }
}

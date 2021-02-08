package DataStructures.NewWork.LCStrings;

import java.util.*;

public class LongestDuplicateSubstring {
    public static void main(String[] args) {
        System.out.println(new LongestDuplicateSubstring().longestDupSubstring("qav"));
    }


    public String longestDupSubstring(String s) {
        int n = s.length();
        long mod = (long) Math.pow(2, 32);

        int ansIdx = -1, ansLen = 0;

        int start = 0, end = n;

        while (start != end) {
            int mid = start + ((end - start) >> 1);
            int idx = doBinarySearch(mid, s, mod);
            if (idx == -1) {
                end = mid;
            } else {
                start = mid + 1;
                ansIdx = idx;
                ansLen = mid;
            }
        }


        int searchIdx = doBinarySearch(ansLen, s, mod);
        if(searchIdx != ansIdx){

        }

        return ansIdx == -1 ? "" : s.substring(ansIdx, ansIdx + ansLen);
    }

    private int doBinarySearch(int len, String s, long mod) {

        Set<Long> set = new HashSet();
        long hash = 0, p = 256, n = s.length();

        for (int i = 0; i < len; i++) {
            hash = (p * hash + s.charAt(i) - 'a') % mod;
        }

        long maxHash = 1;
        for(int i = 1 ; i < len ; i++){
            maxHash = (maxHash * p) % mod;
        }

        set.add(hash);

        for (int i = 1; i + len - 1 < n; i++) {
            hash = (hash - (maxHash * (s.charAt(i - 1) - 'a'))) % mod;
            hash = (hash * p + (s.charAt(len + i - 1) - 'a')) % mod;
            if (!set.add(hash)) {
                return i;
            }
        }

        return -1;
    }

    public String longestDupSubstring1(String S) {
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

            for (int j = 1; j < list.size(); j++) {
                int s1 = list.get(j - 1), s2 = list.get(j), len = 0;
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
